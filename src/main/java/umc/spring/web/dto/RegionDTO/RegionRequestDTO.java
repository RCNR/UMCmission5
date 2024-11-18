package umc.spring.web.dto.RegionDTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

public class RegionRequestDTO {

    @Getter
    public static class CreateRegionDTO {
        @NotBlank
        String name;
    }
}
