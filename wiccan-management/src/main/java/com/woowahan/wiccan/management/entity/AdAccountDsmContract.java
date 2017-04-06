package com.woowahan.wiccan.management.entity;

import com.woowahan.wiccan.commons.entity.BaseEntity;
import lombok.Getter;

import javax.persistence.*;
import java.util.Date;

/**
 * 광고 <-> Dsm계약
 * Created by justicehoop on 2017. 4. 3..
 */
@Entity
@Getter
public class AdAccountDsmContract extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private AdAccount adAccount;
    @ManyToOne
    private Dsm dsm;
    private Date startDate;
    private Date endDate;
    private boolean deleted = false;

    AdAccountDsmContract() { }

    public AdAccountDsmContract expire() {
        deleted = true;
        return this;
    }

    public static AdAccountDsmContract of(AdAccount adAccount, Dsm dsm, Date startDate, Date endDate) {
        AdAccountDsmContract instance = new AdAccountDsmContract();
        instance.adAccount = adAccount;
        instance.dsm = dsm;
        instance.startDate = startDate;
        instance.endDate = endDate;
        return instance;
    }

}
