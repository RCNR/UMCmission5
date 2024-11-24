package umc.spring.service.memberService;

import umc.spring.domain.Member;
import umc.spring.web.dto.memberDTO.MemberRequestDTO;

public interface MemberCommandService{

    Member joinMember(MemberRequestDTO.JoinDTO request);
}