package com.woowahan.wiccan.core.entity;

import com.woowahan.wiccan.commons.entity.BaseEntity;
import lombok.Getter;

import javax.persistence.*;

/**
 * Created by justicehoop on 2017. 4. 3..
 */
@Getter
@Entity
public class AdProduct extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @ManyToOne
    private AdPaymentModel adPaymentModel;

    AdProduct() { }

    public static AdProduct of(String name, String description) {
        AdProduct instance = new AdProduct();
        instance.name = name;
        instance.description = description;
        return instance;
    }
}
