package umc.spring.web.dto.RegionDTO;

import lombok.Getter;

public class RegionRequestDTO {

    @Getter
    public static class CreateRegionDTO {
        String name;
    }
}
