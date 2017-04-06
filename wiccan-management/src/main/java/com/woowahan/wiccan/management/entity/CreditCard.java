package com.woowahan.wiccan.management.entity;

import lombok.Getter;

import javax.persistence.Embeddable;

/**
 * 카드정보
 * Created by justicehoop on 2017. 4. 4..
 */
@Embeddable
@Getter
public class CreditCard {
    private String cardOwnerName;
    private String cardNumber;
    private String mobileNumber;
    private String expireMonth;
    private String expireYear;
    private String passwordPrefix;
    private String cardBirthday;
    private String email;
    private CardType cardType;

    public enum CardType {
        CORP("법인"),
        PERSONAL("개인");

        private String desc;

        CardType(String desc) {
            this.desc = desc;
        }

        public String getDesc() {
            return desc;
        }
    }

    CreditCard() {}


    public static CreditCard of(CardType cardType,
                                String ownerName,
                                String cardNumber,
                                String mobileNumber,
                                String expireMonth,
                                String expireYear,
                                String passwordPrefix,
                                String birthday,
                                String email) {
        CreditCard card = new CreditCard();
        card.cardOwnerName = ownerName;
        card.cardNumber = cardNumber;
        card.mobileNumber = mobileNumber;
        card.expireMonth = expireMonth;
        card.expireYear = expireYear;
        card.passwordPrefix = passwordPrefix;
        card.cardBirthday = birthday;
        card.email = email;
        return card;
    }


}