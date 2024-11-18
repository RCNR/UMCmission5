package umc.spring.service.missionService;

import umc.spring.domain.mapping.MemberMission;

public interface MissionCommandService {

    MemberMission challengeMission(Long missionId, Long memberId);
}
