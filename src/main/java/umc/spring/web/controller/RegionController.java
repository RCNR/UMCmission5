package umc.spring.web.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.RegionConverter;
import umc.spring.domain.Region;
import umc.spring.service.regionService.RegionCommandService;
import umc.spring.web.dto.RegionDTO.RegionRequestDTO;
import umc.spring.web.dto.RegionDTO.RegionResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/regions")
@Slf4j
public class RegionController {

    private final RegionCommandService regionCommandService;

    @PostMapping("/")
    public ApiResponse<RegionResponseDTO.JoinResultDTO> join(@RequestBody @Valid RegionRequestDTO.JoinDTO requestDTO) {

        log.info(requestDTO.getName());
        Region region = regionCommandService.joinRegion(requestDTO);
        return ApiResponse.onSuccess(RegionConverter.toJoinResultDTO(region));
    }
}
