package com.woowahan.wiccan.management.service;

import com.woowahan.wiccan.commons.utils.ValueCreator;
import com.woowahan.wiccan.management.entity.*;
import com.woowahan.wiccan.management.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by justicehoop on 2017. 4. 6..
 */
@Service
public class MockEntityCreateHelper {
    @Autowired
    private AdAccountRepository adAccountRepository;
    @Autowired
    private AdProductRepository adProductRepository;
    @Autowired
    private AdShopRepository adShopRepository;
    @Autowired
    private ListingAdRepository listingAdRepository;
    @Autowired
    private DsmRepository dsmRepository;
    @Autowired
    private PaymentTransactionRepository paymentTransactionRepository;
    @Autowired
    private PaymentMethodRepository paymentMethodRepository;


    public AdAccount mockAccount(String name) {
        AdAccount account = AdAccount.createOf(name, ValueCreator.randomBizNumber(), ValueCreator.randomTelephone());
        return adAccountRepository.save(account);
    }

    public AdProduct mockProduct(AdProduct.CostModel costModel) {
        return adProductRepository.save(AdProduct.of(ValueCreator.randomString(4), ValueCreator.randomString(4), costModel));
    }

    public AdShop mockShop(String name) {
        return adShopRepository.save(AdShop.createOf(ValueCreator.randomCode(4), name));
    }

    public AdShop mockShop() {
        return mockShop(ValueCreator.randomString(5));
    }

    public Dsm mockDsm(Dsm.DsmType type) {
        return dsmRepository.save(Dsm.createOf(ValueCreator.randomString(4),type));
    }

    public PaymentMethod mockPaymentMethod(AdAccount account, CreditCard card) {
        return paymentMethodRepository.save(PaymentMethod.createOf(account, card));
    }

    public PaymentTransaction mockPaymentTransaction(ListingAd ad, PaymentMethod method, Integer price) {
        return paymentTransactionRepository.save(PaymentTransaction.of(ad, method, price));
    }

    public ListingAd mockListingAd(AdProduct product,
                                   AdShop shop,
                                   AdAccount account,
                                   Date startDate,
                                   Date endDate) {
        return listingAdRepository.save(ListingAd.createOf(product, shop, account, startDate, endDate));
    }

    public CreditCard  mockCreditCard() {
        return CreditCard.of(CreditCard.CardType.PERSONAL, ValueCreator.randomString(4), ValueCreator.randomTelephone(), ValueCreator.randomTelephone(), "11", "2020", "11", "1970-01-01", ValueCreator.randomString(4)+"@" + "gmail.com");
    }



}
