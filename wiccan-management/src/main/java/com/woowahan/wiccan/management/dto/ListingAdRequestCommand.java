package com.woowahan.wiccan.management.dto;

import com.woowahan.wiccan.management.entity.*;
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
    private PaymentTransaction.DayOfPayment dayOfPayment;
    private PaymentMethod.Type paymentMethodType = PaymentMethod.Type.AUTO_PAYMENT;
    private ListingAd.RequestType requestType;
    private CreditCardCommand creditCard;
    private BankAccountCommand bankAccount;

    @Getter
    @Setter
    @NoArgsConstructor
    public static class CreditCardCommand {
        private String billKey;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    public static class BankAccountCommand {
        private String bankName;
        private String bankOwnerName;
        private String birthday;
        private String accountNumber;
    }

    public boolean isCardPayment() {
        return paymentMethodType == PaymentMethod.Type.CARD;
    }

}