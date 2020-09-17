package com.jeboisducouscousetjenettoieunpaysan.hackathonDocotlib.repository;

import com.jeboisducouscousetjenettoieunpaysan.hackathonDocotlib.entity.Composition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompositionRepository extends JpaRepository<Composition, Long> {
}
