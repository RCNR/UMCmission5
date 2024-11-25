package umc.spring.service.missionService;

import umc.spring.domain.Mission;
import umc.spring.domain.mapping.MemberMission;

public interface MissionQueryService {

    Mission findByMission(Long missionId);

    MemberMission findMyMission(Long missionId);
}
