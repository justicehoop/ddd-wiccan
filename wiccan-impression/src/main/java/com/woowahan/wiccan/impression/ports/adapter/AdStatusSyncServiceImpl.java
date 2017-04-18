package com.woowahan.wiccan.impression.ports.adapter;


import com.woowahan.wiccan.messaging.MessageListener;
import org.springframework.stereotype.Service;

/**
 * Created by justicehoop on 2017. 4. 14..
 */
@Service
public class AdStatusSyncServiceImpl implements MessageListener {

    @Override
    public void onMessage(Object message) {
        /**
         *  광고 노출을 위한 Repository에 저장
         */
    }

}
