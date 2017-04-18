package com.woowahan.wiccan.management.ports.externals.service;

import com.woowahan.wiccan.management.ports.externals.model.AdExportModel;
import com.woowahan.wiccan.management.ports.externals.service.dto.AdStatusNotifyCommand;

/**
 * 광고 정보 생성 , 수정시 관련 시스템으로 notify 해주는 기능을 제공
 * Created by justicehoop on 2017. 4. 7..
 */
public interface AdChangedNotifyService {

    void notifyAdCreated(AdExportModel ad);

    void notifyAdStatusChanged(AdStatusNotifyCommand sync);
}
