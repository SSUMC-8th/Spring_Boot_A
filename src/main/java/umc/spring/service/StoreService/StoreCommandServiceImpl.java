package umc.spring.service.StoreService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.RegionHandler;
import umc.spring.converter.StoreConverter;
import umc.spring.domain.Region;
import umc.spring.domain.Store;
import umc.spring.repository.RegionRepository;
import umc.spring.repository.StoreRepository;
import umc.spring.web.dto.StoreRequestDTO;

@Service
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService {

    private final RegionRepository regionRepository;
    private final StoreRepository storeRepository;

    @Override
    @Transactional
    public Store createStore(StoreRequestDTO.StoreAddDTO request) {
        Region region = regionRepository.findById(request.getRegionId())
                .orElseThrow(() -> new RegionHandler(ErrorStatus.REGION_NOT_FOUND));
        Store store = StoreConverter.toStore(request, region);
        return storeRepository.save(store);
    }
}


//package umc.spring.service.StoreService;
//
//import jakarta.transaction.Transactional;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//import umc.spring.converter.StoreConverter;
//import umc.spring.domain.Region;
//import umc.spring.domain.Store;
//import umc.spring.repository.RegionRepository;
//import umc.spring.repository.StoreRepository;
//import umc.spring.web.dto.StoreRequestDTO;
//import umc.spring.apiPayload.exception.handler.RegionHandler;
//import umc.spring.apiPayload.code.status.ErrorStatus;
//
//@Service
//@RequiredArgsConstructor
//public class StoreCommandServiceImpl implements StoreCommandService {
//
//    private final RegionRepository regionRepository;
//    private final StoreRepository storeRepository;
//
//    @Override
//    @Transactional
//    public Store createStore(StoreRequestDTO.StoreAddDTO request) {
//        Region region = regionRepository.findById(request.getRegionId())
//                .orElseThrow(() -> new RegionHandler(ErrorStatus.REGION_NOT_FOUND));
//        Store store = StoreConverter.toStore(request, region);
//        return storeRepository.save(store);
//    }
//}
