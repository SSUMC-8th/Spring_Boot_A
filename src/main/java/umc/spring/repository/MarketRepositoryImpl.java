package umc.spring.repository;


import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.spring.domain.Market;
import umc.spring.domain.QMarket;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MarketRepositoryImpl implements MarketRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;
    private final QMarket market = QMarket.market;

    @Override
    public List<Market> dynamicQueryWithBooleanBuilder(String name, Float score) {
        BooleanBuilder predicate = new BooleanBuilder();

        if(name != null){
            predicate.and(market.name.eq(name));
        }

        if(score != null){
            predicate.and(market.score.goe(score));
        }

        return jpaQueryFactory
                .selectFrom(market)
                .where(predicate)
                .fetch();
    }
}
