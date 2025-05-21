package umc.spring.repository.StoreRespository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.Store;

public interface StoreRepository extends JpaRepository<Store, Long> {
}
