package umc.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.Market;

import java.util.Optional;

public interface MarketRepository extends JpaRepository<Market, Long> {
    boolean existsByCode(String code);

    Optional<Market> findByName(String marketName);

}
