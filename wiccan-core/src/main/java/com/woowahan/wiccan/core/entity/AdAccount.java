package com.woowahan.wiccan.core.entity;

import com.woowahan.wiccan.commons.entity.BaseEntity;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 광고주
 * Created by justicehoop on 2017. 4. 3..
 */
@Entity
@Getter
public class AdAccount extends BaseEntity {
    @Id
    private Long accountId;
    private String name;
    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus = AccountStatus.REQ_REGIST;

    public enum AccountStatus {
        REQ_REGIST("승인요청"),
        CONFIRMED("승인"),
        LOCK("계정잠금"),
        WITHDRAW("탈퇴");

        private String desc;

        private AccountStatus(String desc) {
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

    public static AdAccount createOf(Long accountId, String name) {
        AdAccount instance = new AdAccount();
        instance.accountId = accountId;
        instance.name = name;
        return instance;
    }
}


