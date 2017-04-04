package com.woowahan.wiccan.commons.entity;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by justicehoop on 2017. 4. 3..
 */
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    protected Date createdDate = new Date();

//    @CreatedBy
//    @JoinColumn(name = "created_by")
//    @OneToOne(fetch = FetchType.LAZY)
//    private Account createdBy;

    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    protected Date lastModifiedDate = new Date();

//    @LastModifiedBy
//    @JoinColumn(name = "last_modified_by")
//    @OneToOne(fetch = FetchType.LAZY)
//    private Account lastModifiedBy;

    public Date getCreatedDate() {
        return createdDate;
    }

    void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

//    public Account getCreatedBy() {
//        return createdBy;
//    }
//
//    public Account getLastModifiedBy() {
//        return lastModifiedBy;
//    }
//
//    public BaseEntity amendModifier(Account account) {
//        this.lastModifiedBy = account;
//        this.lastModifiedDate = new Date();
//        return this;
//    }



}