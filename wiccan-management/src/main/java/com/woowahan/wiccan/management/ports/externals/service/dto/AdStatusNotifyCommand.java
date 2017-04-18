package com.woowahan.wiccan.management.ports.externals.service.dto;

import com.woowahan.wiccan.commons.type.AdStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by justicehoop on 2017. 4. 7..
 */
@Data
@AllArgsConstructor(staticName = "of")
public class AdStatusNotifyCommand {
    private Long adId;
    private AdStatus status;

}
