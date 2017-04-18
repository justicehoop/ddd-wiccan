package com.woowahan.wiccan.management.service.impl;

import com.woowahan.wiccan.management.dto.ListingAdDto;
import com.woowahan.wiccan.management.dto.ListingAdRequestCommand;
import com.woowahan.wiccan.management.entity.*;
import com.woowahan.wiccan.management.entity.rule.period.AdPeriod;
import com.woowahan.wiccan.management.entity.rule.period.AdPeriodPolicy;
import com.woowahan.wiccan.management.entity.rule.period.AdPeriodPolicyFactory;
import com.woowahan.wiccan.management.ex.ResourceNotFoundException;
import com.woowahan.wiccan.management.ports.externals.model.Shop;
import com.woowahan.wiccan.management.ports.externals.service.ShopApiService;
import com.woowahan.wiccan.management.repository.*;
import com.woowahan.wiccan.management.service.AdRequestService;
import com.woowahan.wiccan.management.service.PaymentMethodFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Created by justicehoop on 2017. 4. 4..
 */
@Transactional
@Service
public class ListingAdRequestService implements AdRequestService<ListingAdRequestCommand, ListingAdDto> {

    @Autowired
    private ListingAdRepository listingAdRepository;
    @Autowired
    private AdShopRepository adShopRepository;
    @Autowired
    private ShopApiService shopApiService;
    @Autowired
    private AdAccountRepository adAccountRepository;
    @Autowired
    private AdAccountDsmContractRepository adAccountDsmContractRepository;
    @Autowired
    private AdProductRepository adProductRepository;
    @Autowired
    private PaymentMethodRepository paymentMethodRepository;


    @Override
    public ListingAdDto applyFor(ListingAdRequestCommand command) {
        AdShop adShop = createShopIfNotExists(command.getShopId());
        AdAccount adAccount = findValidAdAccount(command.getAdAccountId());
        AdAccountDsmContract contract = findContract(adAccount);
        AdProduct product = findValidAdProduct(command.getAdProductId());
        Dsm dsm = contract.getDsm();

        PaymentMethod paymentMethod = registerPaymentMethod(adAccount, command);
        ListingAd ad = listingAdRepository.save(ListingAd.createOf(product,
                                                                   adShop,
                                                                   adAccount,
                                                                   paymentMethod));

        dsm.addListAd(ad);
        return ListingAdDto.of(ad);
    }

    private PaymentMethod registerPaymentMethod(AdAccount adAccount,ListingAdRequestCommand command) {
        return paymentMethodRepository.save(PaymentMethodFactory.createOf(adAccount, command));

    }

    private AdProduct findValidAdProduct(Long productId) {
        return Optional.ofNullable(adProductRepository.findOne(productId))
                       .orElseThrow(() -> new ResourceNotFoundException(String.format("product[id:%d] does not exist!", productId)));

    }

    private AdAccountDsmContract findContract(AdAccount adAccount) {
        return Optional.ofNullable(adAccountDsmContractRepository.findByAdAccount(adAccount))
                        .orElseThrow(() -> new ResourceNotFoundException("Contract of adAccount does not exist!"));
    }


    private AdShop createShopIfNotExists(String shopId) {
        return Optional.ofNullable(adShopRepository.findOne(shopId))
                                .orElseGet(() -> {
                                    Shop shop = findValidShop(shopId);
                                    return adShopRepository.save(AdShop.createOf(shop.getShopId(),
                                                                                 shop.getName(),
                                                                                 shop.getShopImage()));
                                });

    }

    private AdAccount findValidAdAccount(Long adAccountId) {
        return Optional.ofNullable(adAccountRepository.findOne(adAccountId))
                        .orElseThrow(() -> new ResourceNotFoundException(String.format("adAccount[%d] does not exist!!", adAccountId)));
    }

    private Shop findValidShop(String shopId) {
        return Optional.ofNullable(shopApiService.findById(shopId))
                        .orElseThrow(() -> new ResourceNotFoundException(String.format("shop[id:%s] does not exist!", shopId)));
    }

}
