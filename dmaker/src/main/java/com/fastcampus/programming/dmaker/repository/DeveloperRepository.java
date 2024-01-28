package com.fastcampus.programming.dmaker.repository;

import com.fastcampus.programming.dmaker.entity.Developer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author oppspark
 */
@Repository
public interface DeveloperRepository
        extends JpaRepository<Developer, Long> {
}
