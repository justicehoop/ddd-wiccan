package com.woowahan.wiccan.impression.entity;

import com.woowahan.wiccan.commons.type.AdStatus;
import lombok.*;

/**
 * Created by justicehoop on 2017. 4. 7..
 */
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Getter
@Setter
@ToString
public class ListingAd {
    private Long adId;
    private Long adProductId;
    private String shopImage;
    private String shopName;
    private AdStatus adStatus;
}
