package umc.spring.web.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.RegionConverter;
import umc.spring.domain.Region;
import umc.spring.domain.Restaurant;
import umc.spring.service.regionService.RegionCommandService;
import umc.spring.service.storeService.command.RestaurantCommandService;
import umc.spring.web.dto.RegionDTO.RegionRequestDTO;
import umc.spring.web.dto.RegionDTO.RegionResponseDTO;
import umc.spring.web.dto.restaurantDTO.RestaurantRequestDTO;
import umc.spring.web.dto.restaurantDTO.RestaurantResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/regions")
@Slf4j
public class RegionController {

    private final RegionCommandService regionCommandService;
    private final RestaurantCommandService restaurantCommandService;

    @PostMapping("/")
    public ApiResponse<RegionResponseDTO.JoinResultDTO> join(@RequestBody @Valid RegionRequestDTO.CreateRegionDTO requestDTO) {

        Region region = regionCommandService.joinRegion(requestDTO);
        return ApiResponse.onSuccess(RegionConverter.toJoinResultDTO(region));
    }


}
