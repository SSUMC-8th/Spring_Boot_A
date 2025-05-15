package umc.spring.service.marektService;

import umc.spring.domain.Market;

import java.util.List;
import java.util.Optional;

public interface MarketQueryService {
    Optional<Market> findMarket(Long id);
    List<Market> findMarketByNameAndScore(String name, Float score);

}
