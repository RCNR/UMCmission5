package umc.spring.web.dto.missionDTO;

import lombok.*;

import java.util.List;

public class MissionResponseDTO {

    @Builder
    @Getter
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class MissionPreviewDTO {

        String restaurantName;
        String description;
        Integer certificationNumber;
    }

    @Builder
    @Getter
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class MissionPreviewListDTO {

        List<MissionPreviewDTO> missionPreviewList;
        Integer listSize;
        Integer totalPage;
        Long totalElements;
        Boolean isFirst;
        Boolean isLast;
    }
}
