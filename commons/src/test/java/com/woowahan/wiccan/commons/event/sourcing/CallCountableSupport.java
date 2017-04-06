package com.woowahan.wiccan.commons.event.sourcing;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by justicehoop on 2017. 4. 6..
 */
public class CallCountableSupport implements Countable {
    private AtomicInteger count = new AtomicInteger();

    public void increment() {
        count.addAndGet(1);
    }

    public Integer getCallCount() {
        return count.get();
    }
}
