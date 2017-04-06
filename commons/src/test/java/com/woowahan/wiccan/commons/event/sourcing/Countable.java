package com.woowahan.wiccan.commons.event.sourcing;

/**
 * Created by justicehoop on 2017. 4. 6..
 */
public interface Countable {
    void increment();
    Integer getCallCount();
}
