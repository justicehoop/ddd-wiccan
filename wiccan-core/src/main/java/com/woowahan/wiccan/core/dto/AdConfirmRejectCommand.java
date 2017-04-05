package com.woowahan.wiccan.core.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by justicehoop on 2017. 4. 5..
 */
@NoArgsConstructor
@Getter
@Setter
public class AdConfirmRejectCommand {
    private String rejectReason;
}
