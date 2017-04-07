package com.woowahan.wiccan.impression.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by justicehoop on 2017. 4. 7..
 */
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Data
public class Location {
    private Double lng;
    private Double lat;
}
