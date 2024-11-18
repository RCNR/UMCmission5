package umc.spring.web.dto.missionChallengeDTO;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class MissionChallengeRequest {

    @Getter
    public static class MissionChallenge {

        @NotNull
        Long memberId;

        @NotNull
        Long missionId;
    }
}
