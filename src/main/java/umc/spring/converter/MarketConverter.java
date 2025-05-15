package umc.spring.converter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.apiPayload.exception.NotFoundException;
import umc.spring.domain.FoodCategory;
import umc.spring.domain.Market;
import umc.spring.domain.Region;
import umc.spring.repository.FoodCategoryRepository;
import umc.spring.repository.RegionRepository;
import umc.spring.service.marektService.dto.MarketRequestDTO;
import umc.spring.service.marektService.dto.MarketResponseDTO;

@Component
@RequiredArgsConstructor
public class MarketConverter {

    private final RegionRepository regionRepository;
    private final FoodCategoryRepository foodCategoryRepository;

    public Market convertToEntity(MarketRequestDTO.registerDTO dto){
        Region region = regionRepository.findByName(dto.getAddress())
                .orElseThrow(()-> new NotFoundException("Region not found"));

        FoodCategory category = foodCategoryRepository.findById(dto.getCategory_id())
                .orElseThrow(()-> new NotFoundException("FoodCategory not found"));

        return Market.builder()
                .name(dto.getName())
                .region(region).score(0.0)
                .address(dto.getDetailAddress())
                .category(category)
                .build();
    }

    public MarketResponseDTO.RegisterMarketResponse convertToDTO(Market market){
        return MarketResponseDTO.RegisterMarketResponse.builder()
                .id(market.getId())
                .name(market.getName())
                .code(market.getCode())
                .build();
    }
}
