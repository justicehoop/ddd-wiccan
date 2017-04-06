package com.woowahan.wiccan.management.entity;

import lombok.Getter;

import javax.persistence.*;

/**
 * 결제정보
 * Created by justicehoop on 2017. 4. 5..
 */
@Entity
@Getter
public class PaymentMethod {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ad_account_id")
    private AdAccount adAccount;
    private Type type;
    @Embedded
    private CreditCard creditCard;
    @Embedded
    private BankAccount bankAccount;

    public enum Type {
        AUTO_PAYMENT("자동이체"),
        CARD("신용카드");

        private String desc;

        Type(String desc) {
            this.desc = desc;
        }

        public String getDesc() {
            return this.desc;
        }
    }

    PaymentMethod() { }

    public boolean isAutoPay() {
        return this.type == Type.AUTO_PAYMENT;
    }

    public boolean isCardPay() {
        return this.type == Type.CARD;
    }

    public static PaymentMethod createOf(AdAccount account, CreditCard card) {
        PaymentMethod instance = new PaymentMethod();
        instance.adAccount = account;
        instance.type = Type.CARD;
        instance.creditCard = card;
        return instance;
    }

    public static PaymentMethod createOf(AdAccount account, BankAccount bankAccount) {
        PaymentMethod instance = new PaymentMethod();
        instance.adAccount = account;
        instance.bankAccount = bankAccount;
        instance.type = Type.AUTO_PAYMENT;
        return instance;
    }

}
