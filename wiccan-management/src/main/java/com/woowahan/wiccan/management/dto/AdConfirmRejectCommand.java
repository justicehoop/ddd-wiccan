package com.woowahan.wiccan.management.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by justicehoop on 2017. 4. 5..
 */
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AdConfirmRejectCommand {
    private String rejectReason;
}
