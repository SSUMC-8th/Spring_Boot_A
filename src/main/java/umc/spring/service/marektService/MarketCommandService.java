package umc.spring.service.marektService;

import umc.spring.service.marektService.dto.MarketRequestDTO;
import umc.spring.service.marektService.dto.MarketResponseDTO;

public interface MarketCommandService {
    MarketResponseDTO.RegisterMarketResponse registerMarket(MarketRequestDTO.registerDTO dto);

    String createUniqueCode();
}
