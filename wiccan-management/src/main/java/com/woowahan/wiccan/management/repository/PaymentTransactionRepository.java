package com.woowahan.wiccan.management.repository;

import com.woowahan.wiccan.management.entity.PaymentTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by justicehoop on 2017. 4. 7..
 */
public interface PaymentTransactionRepository extends JpaRepository<PaymentTransaction, Long>{
}
