package umc.spring.service.regionService;

import umc.spring.domain.Region;
import umc.spring.web.dto.RegionDTO.RegionRequestDTO;

public interface RegionCommandService {

    Region joinRegion(RegionRequestDTO.JoinDTO request);

}
