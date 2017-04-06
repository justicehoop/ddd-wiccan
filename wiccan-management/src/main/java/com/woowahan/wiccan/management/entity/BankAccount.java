package com.woowahan.wiccan.management.entity;

import lombok.Getter;

import javax.persistence.Embeddable;

/**
 * 계좌정보(Value Object)
 * Created by justicehoop on 2017. 4. 4..
 */
@Embeddable
@Getter
public class BankAccount {
    private String bankName;
    private String bankOwnerName;
    private String birthday;
    private String accountNumber;

    public static BankAccount of(String bankName, String ownerName, String birthday, String accountNumber) {
        BankAccount instance = new BankAccount();
        instance.bankName = bankName;
        instance.bankOwnerName = ownerName;
        instance.birthday = birthday;
        instance.accountNumber = accountNumber;
        return instance;
    }
}
