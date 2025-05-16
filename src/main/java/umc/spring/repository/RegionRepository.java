package umc.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.Region;

import java.util.Optional;

//8주차
public interface RegionRepository extends JpaRepository<Region, Long> {
    Optional<Region> findByRegionSector(String regionSector); // 지역 이름으로 조회
}

