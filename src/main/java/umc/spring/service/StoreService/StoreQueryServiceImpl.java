package umc.spring.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.GeneralException;
import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.repository.MissionRepository;
import umc.spring.repository.StoreRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StoreQueryServiceImpl implements StoreQueryService {

    private final StoreRepository storeRepository;
    private final MissionRepository missionRepository;

    @Override
    public Optional<Store> findStore(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Store> findStoresByNameAndScore(String name, Float score) {
        return List.of();
    }

    @Override
    public Page<Mission> getMissionList(Long storeId, int page) {
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new GeneralException(ErrorStatus.STORE_NOT_FOUND));

        return missionRepository.findAllByStore(store, PageRequest.of(page, 10));
    }
}

//package umc.spring.service.StoreService;
//
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import umc.spring.domain.Store;
//import umc.spring.repository.StoreRepository;
//
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//@RequiredArgsConstructor
//@Transactional(readOnly = true)
//public class StoreQueryServiceImpl implements StoreQueryService{
//
//    private final StoreRepository storeRepository;
//
//    @Override
//    public Optional<Store> findStore(Long id) {
//        return storeRepository.findById(id);
//    }
//
//    @Override
//    public List<Store> findStoresByNameAndScore(String name, Float score) {
//        List<Store> filteredStores = storeRepository.dynamicQueryWithBooleanBuilder(name, score);
//
//        filteredStores.forEach(store -> System.out.println("Store: " + store));
//
//        return filteredStores;
//    }
//}