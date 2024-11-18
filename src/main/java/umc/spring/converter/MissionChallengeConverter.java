package umc.spring.converter;

import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.missionChallengeDTO.MissionChallengeRequest;
import umc.spring.web.dto.missionChallengeDTO.MissionChallengeResponseDTO;

public class MissionChallengeConverter {

    public static MissionChallengeResponseDTO.CreateMissionChallengeResponseDTO
    toCreateMissionChallengeResponseDTO(MemberMission memberMission) {

        return MissionChallengeResponseDTO.CreateMissionChallengeResponseDTO.builder()
                .member_id(memberMission.getId())
                .mission_id(memberMission.getId())
                .id(memberMission.getId())
                .build();
    }
}
