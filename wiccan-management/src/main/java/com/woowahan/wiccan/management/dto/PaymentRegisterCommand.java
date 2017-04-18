package com.woowahan.wiccan.management.dto;

import com.woowahan.wiccan.management.entity.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by justicehoop on 2017. 4. 18..
 */
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Getter
@Setter
public class PaymentRegisterCommand {
    private PaymentMethod.Type paymentMethodType = PaymentMethod.Type.AUTO_PAYMENT;
    private CreditCardCommand creditCard;
    private BankAccountCommand bankAccount;
}
