package com.woowahan.wiccan.core.entity;

import lombok.Getter;

import javax.persistence.*;

/**
 * DSM(영업 마케터)
 * Created by justicehoop on 2017. 4. 3..
 */
@Entity
@Getter
public class Dsm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    private DsmGroup dsmGroup;
    @Enumerated(EnumType.STRING)
    private DsmType dsmType = DsmType.DIRECT;

    public enum DsmType {
        DIRECT("직영"),
        AGENCY("대리점");

        private final String desc;

        DsmType(String desc) {
            this.desc = desc;
        }

        public String getDesc() {
            return desc;
        }
    }

    Dsm() {}

    public static Dsm createOf(DsmGroup dsmGroup, String name, DsmType dsmType) {
        Dsm instance = new Dsm();
        instance.dsmGroup = dsmGroup;
        instance.name = name;
        instance.dsmType = dsmType;
        return instance;
    }

}
