package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.RestaurantConverter;
import umc.spring.domain.Restaurant;
import umc.spring.service.regionService.RegionCommandService;
import umc.spring.service.storeService.command.RestaurantCommandService;
import umc.spring.web.dto.restaurantDTO.RestaurantRequestDTO;
import umc.spring.web.dto.restaurantDTO.RestaurantResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/restaurants")
public class RestaurantController {

    private final RestaurantCommandService restaurantCommandService;

    @PostMapping("/")
    public ApiResponse<RestaurantResponseDTO.CreateRestaurantResponseDTO> createRestaurant(@RequestBody @Valid RestaurantRequestDTO.CreateRestaurantDTO dto) {

        Restaurant saveRestaurant = restaurantCommandService.createRestaurant(dto);

        return ApiResponse.onSuccess(RestaurantConverter.toCreateRestaurantResponseDTO(saveRestaurant));
    }
}
