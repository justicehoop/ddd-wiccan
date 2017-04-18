package com.woowahan.wiccan.management.ports.externals.model;

import com.woowahan.wiccan.commons.type.AdStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by justicehoop on 2017. 4. 7..
 */
@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class ListingAdSyncCommand {
    private Long adId;
    private AdStatus adStatus;
    private String shopName;
    private String image;
}
