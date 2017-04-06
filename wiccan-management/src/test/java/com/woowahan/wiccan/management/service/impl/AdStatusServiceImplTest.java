package com.woowahan.wiccan.management.service.impl;

import com.woowahan.wiccan.management.repository.*;
import com.woowahan.wiccan.management.service.AdStatusService;
import com.woowahan.wiccan.management.service.ManagementTestBase;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by justicehoop on 2017. 4. 6..
 */
public class AdStatusServiceImplTest extends ManagementTestBase {
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
    private AdStatusService adStatusService;

    @Before
    public void setup() {

    }

    @Test
    public void 광고상태가_정상적으로_변경되어야_한다() {

    }

}