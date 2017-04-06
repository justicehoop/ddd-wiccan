package com.woowahan.wiccan.management.dto;

import com.woowahan.wiccan.management.entity.PaymentTransaction;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * Created by justicehoop on 2017. 4. 4..
 */
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Getter
@Setter
public class ListingAdRequestCommand {
    private Long adAccountId;
    private Long adProductId;
    private String description;
    private String shopId;
    private Date startDate;
    private Date endDate;
    private PaymentTransaction.DayOfPayment dayOfPayment;

}