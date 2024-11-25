package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.domain.Mission;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.missionChallengeDTO.MissionChallengeRequest;
import umc.spring.web.dto.missionChallengeDTO.MissionChallengeResponseDTO;
import umc.spring.web.dto.missionDTO.MissionResponseDTO;

import java.util.List;

public class MissionChallengeConverter {

    public static MissionChallengeResponseDTO.CreateMissionChallengeResponseDTO
    toCreateMissionChallengeResponseDTO(MemberMission memberMission) {

        return MissionChallengeResponseDTO.CreateMissionChallengeResponseDTO.builder()
                .member_id(memberMission.getId())
                .mission_id(memberMission.getId())
                .id(memberMission.getId())
                .build();
    }

    public static MissionResponseDTO.MissionPreviewDTO missionPreviewDTO(Mission mission) {

        return MissionResponseDTO.MissionPreviewDTO.builder()
                .description(mission.getDescription())
                .restaurantName(mission.getRestaurant().getName())
                .certificationNumber(mission.getCertificationNumber())
                .build();
    }

    public static MissionResponseDTO.MissionPreviewListDTO missionPreviewListDTO(Page<Mission> missions) {

        List<MissionResponseDTO.MissionPreviewDTO> missionList = missions.getContent().stream()
                .map(MissionChallengeConverter::missionPreviewDTO)
                .toList();

        return MissionResponseDTO.MissionPreviewListDTO.builder()
                .isFirst(missions.isFirst())
                .isLast(missions.isLast())
                .totalElements(missions.getTotalElements())
                .listSize(missionList.size())
                .missionPreviewList(missionList)
                .build();

    }
}
