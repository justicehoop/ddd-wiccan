package com.woowahan.wiccan.management.entity;

import com.woowahan.wiccan.commons.entity.BaseEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.*;
import java.util.UUID;

/**
 * 광고 상품 Entity
 * Created by justicehoop on 2017. 4. 3..
 */
@EqualsAndHashCode(of = "code", callSuper = false)
@Getter
@Entity
public class AdProduct extends BaseEntity {
    @Id
    private String code;
    private String name;
    private String description;
    @Enumerated
    private CostModel costModel = CostModel.CPT;

    public enum CostModel {
        CPT("기간제 상품"),
        CPM("노출 횟수 보장"),
        CPC("클릭당 과금");

        private String desc;

        CostModel(String desc) {
            this.desc = desc;
        }
    }

    AdProduct() { }

    public static AdProduct of(String name, String description, CostModel costModel) {
        AdProduct instance = new AdProduct();
        instance.code = UUID.randomUUID().toString();
        instance.name = name;
        instance.description = description;
        instance.costModel = costModel;
        return instance;
    }
}
