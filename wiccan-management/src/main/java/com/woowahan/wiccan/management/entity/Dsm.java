package com.woowahan.wiccan.management.entity;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    @OneToMany
    private List<ListingAd> listingAds = new ArrayList<>();
    @Enumerated(EnumType.STRING)
    private DsmType dsmType = DsmType.DIRECT;

    public enum DsmType {
        DIRECT("직영"),
        AGENT("대리점");

        private final String desc;

        DsmType(String desc) {
            this.desc = desc;
        }

        public String getDesc() {
            return desc;
        }
    }

    Dsm() {}

    public Dsm addListAd(ListingAd listingAd) {
        listingAds.add(listingAd);
        return this;
    }

    public static Dsm createOf(String name, DsmType dsmType) {
        Dsm instance = new Dsm();
        instance.name = name;
        instance.dsmType = dsmType;
        return instance;
    }
}
