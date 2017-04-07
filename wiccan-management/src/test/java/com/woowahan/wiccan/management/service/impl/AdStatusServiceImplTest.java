package com.woowahan.wiccan.management.service.impl;

import com.woowahan.wiccan.commons.utils.DateUtils;
import com.woowahan.wiccan.commons.utils.ValueCreator;
import com.woowahan.wiccan.management.dto.AdCancelCommand;
import com.woowahan.wiccan.management.dto.ListingAdDto;
import com.woowahan.wiccan.management.dto.ListingAdStatusDto;
import com.woowahan.wiccan.management.entity.*;
import com.woowahan.wiccan.management.service.AdStatusService;
import com.woowahan.wiccan.management.service.ManagementTestBase;
import com.woowahan.wiccan.management.service.MockEntityCreateHelper;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

import static org.hamcrest.Matchers.is;

/**
 * Created by justicehoop on 2017. 4. 6..
 */
@Transactional
public class AdStatusServiceImplTest extends ManagementTestBase {
    @Autowired
    private MockEntityCreateHelper mockEntityCreateHelper;
    @Autowired
    private AdStatusService adStatusService;

    private ListingAd makeAd() {
        AdAccount adAccount = mockEntityCreateHelper.mockAccount(ValueCreator.randomString(4));
        AdShop adShop = mockEntityCreateHelper.mockShop(ValueCreator.randomString(4));
        Dsm dsm = mockEntityCreateHelper.mockDsm(Dsm.DsmType.DIRECT);
        AdProduct adProduct = mockEntityCreateHelper.mockProduct(AdProduct.CostModel.CPT);


        ListingAd listingAd = mockEntityCreateHelper.mockListingAd(adProduct, adShop, adAccount, new Date(), DateUtils.plusDaysAsDate(new Date(), 30));
        PaymentMethod paymentMethod = mockEntityCreateHelper.mockPaymentMethod(adAccount, mockEntityCreateHelper.mockCreditCard());
        mockEntityCreateHelper.mockPaymentTransaction(listingAd, paymentMethod, 80000);
        return listingAd;
    }

    @Test
    public void 광고취소가_정상적으로_되어야_한다() {
        //Given
        ListingAd listingAd = makeAd();

        //When
        ListingAdDto canceledAd = adStatusService.cancel(listingAd.getId(), AdCancelCommand.of(true, "테스트"));

        //Then
        Assert.assertNotNull(canceledAd);
        ListingAdStatusDto status = canceledAd.getStatus();
        Assert.assertThat("광고 상태가 'CANCEL'여야 한다", status.getStatus(), is(ListingAdStatus.Status.CANCEL));

    }




}