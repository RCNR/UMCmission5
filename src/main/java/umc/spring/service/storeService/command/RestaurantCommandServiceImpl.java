package umc.spring.service.storeService.command;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apiPayload.code.exception.handler.RegionHandler;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.converter.RestaurantConverter;
import umc.spring.domain.Region;
import umc.spring.domain.Restaurant;
import umc.spring.repository.RegionRepository;
import umc.spring.repository.restaurantRepository.RestaurantRepository;
import umc.spring.web.dto.restaurantDTO.RestaurantRequestDTO;

@Service
@Transactional
@RequiredArgsConstructor
public class RestaurantCommandServiceImpl implements RestaurantCommandService{

    private final RestaurantRepository restaurantRepository;
    private final RegionRepository regionRepository;

    @Override
    public Restaurant createRestaurant(RestaurantRequestDTO.CreateRestaurantDTO dto) {

        Region region = regionRepository.findById(dto.getRegionId()).orElseThrow(() -> new RegionHandler(ErrorStatus.REGION_NOT_FOUND));

        return restaurantRepository.save(RestaurantConverter.toRestaurant(dto, region));
    }

}
