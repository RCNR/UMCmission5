package umc.spring.service.memberService;

import org.springframework.data.domain.Page;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;

import java.util.Optional;

public interface MemberQueryService {

    Optional<Member> findMember(Long id);

    Page<Mission> getChallengeMission(Integer page);

}
