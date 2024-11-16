package umc.spring.service.regionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.converter.RegionConverter;
import umc.spring.domain.Region;
import umc.spring.repository.RegionRepository;
import umc.spring.web.dto.RegionDTO.RegionRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional
public class RegionCommandServiceImpl implements RegionCommandService {

    private final RegionRepository regionRepository;

    @Override
    public Region joinRegion(RegionRequestDTO.JoinDTO request) {

        Region region = RegionConverter.toRegion(request);
        return regionRepository.save(region);
    }
}
