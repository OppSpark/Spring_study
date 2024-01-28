package com.fastcampus.programming.dmaker.service;

import com.fastcampus.programming.dmaker.dto.CreateDeveloper;
import com.fastcampus.programming.dmaker.entity.Developer;
import com.fastcampus.programming.dmaker.exception.DMakerErrorCode;
import com.fastcampus.programming.dmaker.exception.DMakerException;
import com.fastcampus.programming.dmaker.repository.DeveloperRepository;
import com.fastcampus.programming.dmaker.type.DeveloperLevel;
import com.fastcampus.programming.dmaker.type.DeveloperSkillType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author oppspark
 */
@Service
@RequiredArgsConstructor
public class DMakerService {
    private final DeveloperRepository developerRepository;
    private final EntityManager em;

    @Transactional
    public void createDevelopers(CreateDeveloper.Request request) {
        EntityTransaction transaction = em.getTransaction();
        validateCreateDeveloperRequest(request);

        //비즈니스 로직 시작
        Developer developer = Developer.builder()
                .developerLevel(DeveloperLevel.JUNIOR)
                .developerSkillType(DeveloperSkillType.FRONT_END)
                .experienceYears(2)
                .name("Olaf")
                .age(5)
                .build();

        developerRepository.save(developer);

        transaction.commit();
    }

    private void validateCreateDeveloperRequest(CreateDeveloper.Request request) {
        //  비즈니스 벨리데이션 수행 로직

        // 예외 처리 예시
        /**
         * DeveloperLevel 에서 시니어의 경우 10년차 이상이여한다.
         * 10년차 이하인 경우 예최처리 방법 예시이다.
         *
         * 주니어 개발자의 경우 3년에서 10년 사이
         * 예시
         *
         */
        DeveloperLevel developerLevel = request.getDeveloperLevel();
        Integer experienceYear = request.getExperienceYear();
        if (developerLevel == DeveloperLevel.SENIOR
                && experienceYear < 10) {
            throw new DMakerException(
                    DMakerErrorCode.LEVEL_EXPERIENCE_YEARS_NOT_MATCHED);
        }
        if (developerLevel == DeveloperLevel.JUNGNIOR
                && (experienceYear < 4 || experienceYear > 10)) {
            throw new DMakerException(DMakerErrorCode.LEVEL_EXPERIENCE_YEARS_NOT_MATCHED);
        }
        if (developerLevel == DeveloperLevel.JUNIOR
                && experienceYear > 4) {
            throw new DMakerException(DMakerErrorCode.LEVEL_EXPERIENCE_YEARS_NOT_MATCHED);
        }


        //주석 처리한 문장을 람다 표현식으로 간단하게 처리 가능함
        developerRepository.findByMemberId(request.getMemberId())
                .ifPresent((developer1 -> {
                    throw new DMakerException(DMakerErrorCode.DUPLICATED_MEMBER_ID);
                }));

        /*
        Optional<Developer> developer = developerRepository.findByMemberId(request.getMemberId());
        if(developer.isPresent())
            throw new DMakerException(DMakerErrorCode.DUPLICATED_MEMBER_ID);
        */
    }
}
