package umc.spring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.Mission;
import umc.spring.domain.Store;

public interface MissionRepository extends JpaRepository<Mission, Long> {
    //특정가게에서 미션 목록을 가져오기 위함
    Page<Mission> findAllByStore(Store store, Pageable pageable);
}