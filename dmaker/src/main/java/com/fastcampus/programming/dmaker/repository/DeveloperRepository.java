package com.fastcampus.programming.dmaker.repository;

import com.fastcampus.programming.dmaker.code.StatusCode;
import com.fastcampus.programming.dmaker.entity.Developer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

/**
 * @author oppspark
 */
@Repository
public interface DeveloperRepository
        extends JpaRepository<Developer, Long> {
    Optional<Developer> findByMemberId(String memberId);
    List<Developer> findDeveloperByStatusCodeEquals(StatusCode statusCode);
}
