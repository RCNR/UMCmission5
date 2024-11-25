package umc.spring.web.dto.missionDTO;

import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.mapping.MemberMission;

public record MemberMissionDTO(Long memberId, Long missionId) {
    public MemberMission toEntity(Member member, Mission mission) {
        return MemberMission.builder()
                .member(member)
                .mission(mission)
                .build();
    }
}
