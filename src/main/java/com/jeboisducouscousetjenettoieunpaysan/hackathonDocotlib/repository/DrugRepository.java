package com.jeboisducouscousetjenettoieunpaysan.hackathonDocotlib.repository;

import com.jeboisducouscousetjenettoieunpaysan.hackathonDocotlib.entity.Drug;
import org.hibernate.cache.spi.entry.StructuredCacheEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DrugRepository extends JpaRepository<Drug, Long> {

    List<Drug> findAll();

    @Query(value = "SELECT drug.name " +
            "FROM drug " +
            "LEFT JOIN composition " +
            "ON drug.id = composition.id_drug " +
            "LEFT JOIN pillbox " +
            "ON pillbox.id = composition.id_pillbox " +
            "LEFT JOIN patient " +
            "ON patient.id = pillbox.id_patient " +
            "WHERE composition.time_of_the_day = 'matin' "+
            "AND patient.id = 1 " +
            "AND composition.day = 'Lundi'",
            nativeQuery = true)
    List<String> findAllMorningDrugsNames();

    @Query(value = "SELECT drug.image " +
            "FROM drug " +
            "LEFT JOIN composition " +
            "ON drug.id = composition.id_drug " +
            "LEFT JOIN pillbox " +
            "ON pillbox.id = composition.id_pillbox " +
            "LEFT JOIN patient " +
            "ON patient.id = pillbox.id_patient " +
            "WHERE composition.time_of_the_day = 'matin' " +
            "AND patient.id = 1 " +
            "AND composition.day = 'Lundi' ",
            nativeQuery = true)
    List<String> findAllMorningDrugsImages();

    @Query(value = "SELECT * " +
            "FROM drug " +
            "LEFT JOIN composition " +
            "ON drug.id = composition.id_drug " +
            "LEFT JOIN pillbox " +
            "ON pillbox.id = composition.id_pillbox " +
            "LEFT JOIN patient " +
            "ON patient.id = pillbox.id_patient " +
            "WHERE composition.time_of_the_day = 'matin' " +
            "AND patient.id = 1 " +
            "AND composition.day = 'Lundi' ",
            nativeQuery = true)
    List<Drug> findAllMorningDrugs();


}
