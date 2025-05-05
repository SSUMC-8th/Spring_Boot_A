package umc.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.Market;

public interface MarketRepository extends JpaRepository<Market, Long>, MarketRepositoryCustom {

}
