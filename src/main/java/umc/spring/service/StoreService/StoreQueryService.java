package umc.spring.service.StoreService;

import org.springframework.data.domain.Page;
import umc.spring.domain.Mission;
import umc.spring.domain.Store;

import java.util.List;
import java.util.Optional;

public interface StoreQueryService {

    Optional<Store> findStore(Long id);
    List<Store> findStoresByNameAndScore(String name, Float score);

//페이징을 위함 (특정 가게의 미션 조회시)
    Page<Mission> getMissionList(Long storeId, int page);
}

