package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MissionChallengeConverter;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.service.missionService.MissionCommandService;
import umc.spring.validation.annotation.ValidMissionChallenge;
import umc.spring.web.dto.missionChallengeDTO.MissionChallengeRequest;
import umc.spring.web.dto.missionChallengeDTO.MissionChallengeResponseDTO;

@RestController
@RequestMapping("/missions")
@RequiredArgsConstructor
public class MissionController {

    private final MissionCommandService missionCommandService;

    @PostMapping("/challenge")
    public ApiResponse<MissionChallengeResponseDTO.CreateMissionChallengeResponseDTO> createMissionChallenge
            (@Valid @ValidMissionChallenge @RequestBody MissionChallengeRequest.MissionChallenge dto) {

        MemberMission memberMission = missionCommandService.challengeMission(dto.getMissionId(), dto.getMemberId());

        return ApiResponse.onSuccess(MissionChallengeConverter.toCreateMissionChallengeResponseDTO(memberMission));
    }
}
