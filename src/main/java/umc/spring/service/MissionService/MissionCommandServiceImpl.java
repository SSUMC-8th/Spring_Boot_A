package umc.spring.service.MissionService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.apiPayLoad.code.status.ErrorStatus;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.exception.GeneralException;
import umc.spring.repository.MissionRepository.MissionRepository;
import umc.spring.repository.StoreRepository.StoreRepository;
import umc.spring.web.dto.MissionRequestDTO;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService {

    private final StoreRepository storeRepository;
    private final MissionRepository missionRepository;

    @Override
    @Transactional
    public Mission createMission(Long storeId, MissionRequestDTO.createMissionDTO request) {
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new GeneralException(ErrorStatus.STORE_NOT_FOUND));

        Mission mission = MissionConverter.toMission(request, store);
        return missionRepository.save(mission);
    }
}
