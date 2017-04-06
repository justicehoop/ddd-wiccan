package com.woowahan.wiccan.commons.repository;

import com.woowahan.wiccan.commons.entity.DomainEventHistory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by justicehoop on 2017. 4. 6..
 */
public interface DomainEventHistoryRepository extends JpaRepository<DomainEventHistory, String> {
}
