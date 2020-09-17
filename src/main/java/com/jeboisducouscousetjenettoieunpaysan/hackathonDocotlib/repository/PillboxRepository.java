package com.jeboisducouscousetjenettoieunpaysan.hackathonDocotlib.repository;

import com.jeboisducouscousetjenettoieunpaysan.hackathonDocotlib.entity.Pillbox;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PillboxRepository extends JpaRepository<Pillbox, Long> {
}
