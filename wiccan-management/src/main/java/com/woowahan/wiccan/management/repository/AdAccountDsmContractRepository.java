package com.woowahan.wiccan.management.repository;

import com.woowahan.wiccan.management.entity.AdAccount;
import com.woowahan.wiccan.management.entity.AdAccountDsmContract;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by justicehoop on 2017. 4. 5..
 */
public interface AdAccountDsmContractRepository extends JpaRepository<AdAccountDsmContract, Long> {

    AdAccountDsmContract findByAdAccount(AdAccount adAccount);
}
