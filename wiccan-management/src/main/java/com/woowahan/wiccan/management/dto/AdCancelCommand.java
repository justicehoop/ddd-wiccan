package com.woowahan.wiccan.management.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by justicehoop on 2017. 4. 5..
 */
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor(staticName = "of")
public class AdCancelCommand {
    private Boolean instantStop;
    private String reason;

}
