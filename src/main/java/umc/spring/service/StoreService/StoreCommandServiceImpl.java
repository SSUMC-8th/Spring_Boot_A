package umc.spring.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handle.TempHandler;
import umc.spring.converter.StoreConverter;
import umc.spring.domain.Region;
import umc.spring.domain.Store;
import umc.spring.repository.RegionRepository;
import umc.spring.repository.StoreRespository.StoreRepository;
import umc.spring.web.dto.StoreRequestDTO;

@Service
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService{

    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;

    @Override
    @Transactional
    public Store addStore(StoreRequestDTO.StoreAddDTO request) {

        // 1. region 조회
        Region region = regionRepository.findById(request.getRegionId())
                .orElseThrow(() -> new TempHandler(ErrorStatus._BAD_REQUEST));

        Store newStore = StoreConverter.toStore(request, region);

        return storeRepository.save(newStore);
    }
}
