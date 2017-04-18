package com.woowahan.wiccan.management.service;

import com.woowahan.wiccan.management.dto.ListingAdRequestCommand;
import com.woowahan.wiccan.management.entity.AdAccount;
import com.woowahan.wiccan.management.entity.BankAccount;
import com.woowahan.wiccan.management.entity.CreditCard;
import com.woowahan.wiccan.management.entity.PaymentMethod;

/**
 * Created by justicehoop on 2017. 4. 18..
 */
public abstract class PaymentMethodFactory {

    public static PaymentMethod createOf(AdAccount adAccount, ListingAdRequestCommand command) {
        PaymentMethod.Type paymentMethodType = command.getPaymentMethodType();

        switch (paymentMethodType) {
            case CARD:
                ListingAdRequestCommand.CreditCardCommand creditCard = command.getCreditCard();
                return PaymentMethod.createOf(adAccount,
                        CreditCard.of(creditCard.getBillKey()));
            case AUTO_PAYMENT:
                ListingAdRequestCommand.BankAccountCommand bankAccount = command.getBankAccount();
                return PaymentMethod.createOf(adAccount,
                                       BankAccount.of(bankAccount.getBankName(),
                                                      bankAccount.getBankOwnerName(),
                                                      bankAccount.getBirthday(),
                                                      bankAccount.getAccountNumber()));
            default:
                throw new IllegalArgumentException(String.format("Do Not create PaymentMethod for paymentType[%s]", paymentMethodType));
        }
    }

}
