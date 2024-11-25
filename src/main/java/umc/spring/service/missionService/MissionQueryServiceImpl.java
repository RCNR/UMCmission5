package umc.spring.service.missionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apiPayload.code.exception.handler.MemberHandler;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.domain.Mission;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.repository.MemberMissionRepository;
import umc.spring.repository.MissionRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionQueryServiceImpl implements MissionQueryService {

    private final MissionRepository missionRepository;
    private final MemberMissionRepository memberMissionRepository;


    @Override
    public Mission findByMission(Long missionId) {

        return missionRepository.findById(missionId).orElseThrow(() -> new MemberHandler(ErrorStatus.MISSION_NOT_FOUND));
    }

    @Override
    public MemberMission findMyMission(Long missionId) {

        return memberMissionRepository.findById(missionId).orElseThrow(() -> new MemberHandler(ErrorStatus.MISSION_NOT_FOUND));
    }
}
