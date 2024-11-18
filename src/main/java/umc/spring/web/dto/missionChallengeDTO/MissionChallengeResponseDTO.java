package umc.spring.web.dto.missionChallengeDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class MissionChallengeResponseDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreateMissionChallengeResponseDTO {
        private Long id;
        private Long member_id;
        private Long mission_id;
    }
}
