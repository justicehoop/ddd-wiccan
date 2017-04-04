package com.woowahan.wiccan.core.entity;

import com.woowahan.wiccan.commons.entity.BaseEntity;
import lombok.Getter;

import javax.persistence.Id;

/**
 * Created by justicehoop on 2017. 4. 3..
 */
@Deprecated
@Getter
public class ShopCategory extends BaseEntity {
    @Id
    private String categoryId;
    private String name;

    ShopCategory() {}

    public static ShopCategory of(String categoryId, String name) {
        ShopCategory category = new ShopCategory();
        category.categoryId = categoryId;
        category.name = name;
        return category;
    }
}
