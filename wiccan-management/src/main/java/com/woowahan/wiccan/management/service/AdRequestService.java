package com.woowahan.wiccan.management.service;

/**
 * Created by justicehoop on 2017. 4. 4..
 */
public interface AdRequestService<I,O> {

    O applyFor(I command);

}
