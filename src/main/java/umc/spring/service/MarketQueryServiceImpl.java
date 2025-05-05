package umc.spring.service;

import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.domain.Market;
import umc.spring.repository.MarketRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MarketQueryServiceImpl implements MarketQueryService{
    private final MarketRepository marketRepository;

    @Override
    public Optional<Market> findMarket(Long id){
        return marketRepository.findById(id);
    }

    @Override
    public List<Market> findMarketByNameAndScore(String name, Float score){
        List<Market> filteredMarkets = marketRepository.dynamicQueryWithBooleanBuilder(name, score);

        filteredMarkets.forEach(market -> System.out.println("Market: "+ market));
        return filteredMarkets;
    }
}
