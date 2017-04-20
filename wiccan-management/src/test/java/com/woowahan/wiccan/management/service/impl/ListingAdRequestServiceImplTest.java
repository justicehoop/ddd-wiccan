package com.woowahan.wiccan.management.service.impl;

import com.woowahan.wiccan.management.service.ManagementTestBase;
import com.woowahan.wiccan.management.service.MockEntityCreateHelper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by justicehoop on 2017. 4. 6..
 */
@Transactional
public class ListingAdRequestServiceImplTest extends ManagementTestBase {
    @Autowired
    private MockEntityCreateHelper mockEntityCreateHelper;
    @Autowired
    private ListingAdRequestServiceImpl listingAdRequestServiceImpl;

    @Test
    public void 광고신청이_정상적으로_되어야_한다() {
//        listingAdRequestService.applyFor()
    }
}