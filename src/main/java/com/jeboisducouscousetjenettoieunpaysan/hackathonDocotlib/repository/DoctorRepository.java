package com.jeboisducouscousetjenettoieunpaysan.hackathonDocotlib.repository;

import com.jeboisducouscousetjenettoieunpaysan.hackathonDocotlib.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
