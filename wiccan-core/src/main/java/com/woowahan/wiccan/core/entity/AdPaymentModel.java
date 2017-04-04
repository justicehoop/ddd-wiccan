package com.woowahan.wiccan.core.entity;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by justicehoop on 2017. 4. 3..
 */
@Getter
@Entity
public class AdPaymentModel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long costPerUnit;
    private String description;

}
