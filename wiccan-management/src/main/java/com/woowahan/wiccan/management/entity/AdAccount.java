package com.woowahan.wiccan.management.entity;

import com.woowahan.wiccan.commons.entity.BaseEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.annotation.Generated;
import javax.persistence.*;

/**
 * 광고주 Entity
 * Created by justicehoop on 2017. 4. 3..
 */
@EqualsAndHashCode(of = "accountId", callSuper = false)
@Entity
@Getter
public class AdAccount extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;
    private String name;
    private String bizNo;
    private String telNo;
    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus = AccountStatus.REQ_REGIST;
    @OneToOne(fetch = FetchType.LAZY)
    private PaymentMethod paymentMethod;

    public enum AccountStatus {
        REQ_REGIST("승인요청"),
        CONFIRMED("승인"),
        LOCK("계정잠금"),
        WITHDRAW("탈퇴");

        private String desc;

        AccountStatus(String desc) {
            this.desc = desc;
        }

        public String getDesc() {
            return desc;
        }
    }

    private AdAccount changeAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
        return this;
    }

    public AdAccount confirmed() {
        return changeAccountStatus(AccountStatus.CONFIRMED);
    }

    public AdAccount lock() {
        return changeAccountStatus(AccountStatus.LOCK);
    }

    public static AdAccount createOf(String name, String bizNo, String telNo) {
        AdAccount instance = new AdAccount();
        instance.name = name;
        instance.bizNo = bizNo;
        instance.telNo = telNo;
        return instance;
    }
}


