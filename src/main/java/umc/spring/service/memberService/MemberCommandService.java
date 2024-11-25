package umc.spring.service.memberService;

import umc.spring.domain.Member;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.memberDTO.MemberRequestDTO;
import umc.spring.web.dto.missionDTO.MemberMissionDTO;

public interface MemberCommandService{

    Member joinMember(MemberRequestDTO.JoinDTO request);

    void challengeMission(MemberMissionDTO dto);

    void finishedMission(MemberMission memberMission);
}