package umc.spring.converter;

import umc.spring.domain.Region;
import umc.spring.web.dto.RegionDTO.RegionRequestDTO;
import umc.spring.web.dto.RegionDTO.RegionResponseDTO;

import java.time.LocalDateTime;

public class RegionConverter {


    public static Region toRegion(RegionRequestDTO.CreateRegionDTO request) {
        return Region.builder()
                .name(request.getName())
                .build();
    }

    public static RegionResponseDTO.JoinResultDTO toJoinResultDTO(Region region) {

        return RegionResponseDTO.JoinResultDTO.builder()
                .regionId(region.getId())
                .name(region.getName())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
