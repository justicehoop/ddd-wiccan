package com.woowahan.wiccan.management.ports.externals.service;

import com.woowahan.wiccan.management.ports.externals.model.AdExportModel;
import com.woowahan.wiccan.management.ports.externals.service.dto.AdSyncCommand;

/**
 * Created by justicehoop on 2017. 4. 7..
 */
public interface AdImpressionSyncService {

    void sync(AdExportModel ad);

    void syncStatus(AdSyncCommand sync);
}
