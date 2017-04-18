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
    private String billKey;

    public static CreditCard of(String billKey) {
        CreditCard card = new CreditCard();
        card.billKey = billKey;
        return card;
    }


}