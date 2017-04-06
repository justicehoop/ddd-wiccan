package com.woowahan.wiccan.management.service.impl;

import com.woowahan.wiccan.management.dto.ListingAdDto;
import com.woowahan.wiccan.management.dto.ListingAdRequestCommand;
import com.woowahan.wiccan.management.entity.*;
import com.woowahan.wiccan.management.ex.ResourceNotFoundException;
import com.woowahan.wiccan.management.ports.externals.model.Shop;
import com.woowahan.wiccan.management.ports.externals.service.ShopApiService;
import com.woowahan.wiccan.management.repository.AdAccountRepository;
import com.woowahan.wiccan.management.repository.AdProductRepository;
import com.woowahan.wiccan.management.repository.AdShopRepository;
import com.woowahan.wiccan.management.repository.ListingAdRepository;
import com.woowahan.wiccan.management.repository.custom.AdAccountDsmContractRepository;
import com.woowahan.wiccan.management.service.AdRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by justicehoop on 2017. 4. 4..
 */
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


    @Override
    public ListingAdDto applyFor(ListingAdRequestCommand command) {
        AdShop adShop = createShopIfNotExists(command.getShopId());
        AdAccount adAccount = findValidAdAccount(command.getAdAccountId());
        AdAccountDsmContract contract = findContract(adAccount);
        AdProduct product = findValidAdProduct(command.getAdProductId());
        Dsm dsm = contract.getDsm();
        ListingAd ad = listingAdRepository.save(ListingAd.createOf(product, adShop, adAccount, command.getStartDate(), command.getEndDate(), null));
        dsm.addListAd(ad);
        return ListingAdDto.of(ad);
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
                                                                                 shop.getName()));
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
