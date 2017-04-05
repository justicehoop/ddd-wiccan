package com.woowahan.wiccan.core.entity;

import com.woowahan.wiccan.commons.entity.BaseEntity;
import lombok.Getter;

import javax.persistence.Id;

/**
 * Created by justicehoop on 2017. 4. 3..
 */
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
