package umc.spring.service.marektService;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.converter.MarketConverter;
import umc.spring.domain.Market;
import umc.spring.repository.MarketRepository;
import umc.spring.service.marektService.dto.MarketRequestDTO;
import umc.spring.service.marektService.dto.MarketResponseDTO;


@Service
@RequiredArgsConstructor
public class MarketCommandServiceImpl implements MarketCommandService {


    private final MarketRepository marketRepository;
    private final MarketConverter marketConverter;

    @Override
    @Transactional
    public MarketResponseDTO.RegisterMarketResponse registerMarket(MarketRequestDTO.registerDTO dto){
        String code = createUniqueCode();
        Market market = marketConverter.convertToEntity(dto);
        market.setCode(code);

        Market saved = marketRepository.save(market);
        return marketConverter.convertToDTO(saved);
    }

    @Transactional(readOnly = true)
    @Override
    public String createUniqueCode() {
        String code;
        do {
            code = RandomStringUtils.randomAlphanumeric(8); // 예: "aB3xZ91d"
        } while (marketRepository.existsByCode(code));
        return code;
    }

}
