package com.woowahan.wiccan.core.entity;

import com.woowahan.wiccan.commons.entity.BaseEntity;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by justicehoop on 2017. 4. 4..
 */
@Getter
@Entity
public class DsmGroup extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @OneToMany
    private List<Dsm> dsms = new ArrayList<>();

    DsmGroup() {}

    public static DsmGroup createOf(String name, String description) {
        DsmGroup instance = new DsmGroup();
        instance.name = name;
        instance.description = description;
        return instance;
    }

}
