package umc.spring.service.memberService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.repository.MemberMissionRepository;
import umc.spring.repository.MemberRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberQueryServiceImpl implements MemberQueryService{

    private final MemberRepository memberRepository;
    private final MemberMissionRepository memberMissionRepository;

    @Override
    public Optional<Member> findMember(Long id) {
        return Optional.empty();
    }

    @Override
    public Page<Mission> getChallengeMission(Integer page) {

        Member member = memberRepository.findById(1L).get();
        Page<MemberMission> memberMissions = memberMissionRepository.findAllByMemberAndMissionStatus(
                member, MissionStatus.unfinished, PageRequest.of(page, 10)
        );

        return memberMissions.map(MemberMission::getMission);
    }
}
