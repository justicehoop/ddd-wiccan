package com.woowahan.wiccan.core.repository.custom;

import com.woowahan.wiccan.core.entity.AdAccount;
import com.woowahan.wiccan.core.entity.AdAccountDsmContract;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by justicehoop on 2017. 4. 5..
 */
public interface AdAccountDsmContractRepository extends JpaRepository<AdAccountDsmContract, Long> {

    AdAccountDsmContract findByAdAccount(AdAccount adAccount);
}
