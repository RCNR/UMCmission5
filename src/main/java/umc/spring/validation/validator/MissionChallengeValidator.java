package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.repository.MemberMissionRepository;
import umc.spring.validation.annotation.ValidMissionChallenge;
import umc.spring.web.dto.missionChallengeDTO.MissionChallengeRequest;

@Component
@RequiredArgsConstructor
public class MissionChallengeValidator implements ConstraintValidator<
        ValidMissionChallenge, MissionChallengeRequest.MissionChallenge> {

    private final MemberMissionRepository memberMissionRepository;

    @Override
    public void initialize(ValidMissionChallenge constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(MissionChallengeRequest.MissionChallenge value, ConstraintValidatorContext context) {
        Long missionId = value.getMissionId();
        Long memberId = value.getMemberId();

        // MemberMission 존재 여부 체크 -> 존재하면 true 임
        boolean exists = memberMissionRepository.existsByMemberIdAndMissionId(memberId, missionId);

        // 도전 중이라면 유효X
        return !exists;
    }
}
