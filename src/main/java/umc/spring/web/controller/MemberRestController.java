package umc.spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MemberConverter;
import umc.spring.converter.MissionChallengeConverter;
import umc.spring.converter.RestaurantConverter;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.service.memberService.MemberCommandService;
import umc.spring.service.memberService.MemberQueryService;
import umc.spring.service.missionService.MissionQueryService;
import umc.spring.validation.annotation.CheckPage;
import umc.spring.web.dto.memberDTO.MemberRequestDTO;
import umc.spring.web.dto.memberDTO.MemberResponseDTO;
import umc.spring.web.dto.missionDTO.MissionResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {

    private final MemberCommandService memberCommandService;
    private final MemberQueryService memberQueryService;
    private final MissionQueryService missionQueryService;

    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDTO request) {

        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }

    @GetMapping("/mission/{missionId}")
    @Operation(summary = "내가 진행중인 미션 목록 보기 API", description = "내가 진행중인 미션 보기 API이며, 페이징을 포함합니다.")
    public ApiResponse<?> getMyChallengeMission(
            @CheckPage @RequestParam(name = "page") Integer page
    ) {

        Page<Mission> challengeMission = memberQueryService.getChallengeMission(page);
        return ApiResponse.onSuccess(MissionChallengeConverter.missionPreviewListDTO(challengeMission));
    }

    @PutMapping("/mission/{missionId}")
    @Operation(summary = "진행한 미션 갱신")
    public ApiResponse<?> updateMyChallengeMissionFinished(@PathVariable("missionId") Long missionId) {

        MemberMission myMission = missionQueryService.findMyMission(missionId);

        memberCommandService.finishedMission(myMission);

        return ApiResponse.onSuccess(HttpStatus.OK);
    }
}