//6주차
//package umc.spring.repository;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import umc.spring.domain.Store;
//
//public interface StoreRepository extends JpaRepository<Store, Long>, StoreRepositoryCustom {
//}

//8주차
// StoreRepository.java
package umc.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.Store;

public interface StoreRepository extends JpaRepository<Store, Long> {
}
