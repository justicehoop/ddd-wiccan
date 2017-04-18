package com.woowahan.wiccan.management.entity;

import com.woowahan.wiccan.commons.entity.BaseEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 광고용 카테고리
 * Created by justicehoop on 2017. 4. 3..
 */
@EqualsAndHashCode(of = "categoryId", callSuper = false)
@Entity
@Getter
public class AdCategory extends BaseEntity {
    @Id
    private String categoryId;
    private String name;

    AdCategory() {}

    public static AdCategory of(String categoryId, String name) {
        AdCategory category = new AdCategory();
        category.categoryId = categoryId;
        category.name = name;
        return category;
    }
}
