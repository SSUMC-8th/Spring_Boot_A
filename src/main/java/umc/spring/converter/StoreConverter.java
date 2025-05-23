// StoreConverter.java
package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.domain.Mission;
import umc.spring.domain.Region;
import umc.spring.domain.Store;
import umc.spring.web.dto.StoreRequestDTO;
import umc.spring.web.dto.StoreResponseDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class StoreConverter {

    public static Store toStore(StoreRequestDTO.StoreAddDTO request, Region region) {
        return Store.builder()
                .region(region)
                .name(request.getName())
                .address(request.getAddress())
                .detailAddress(request.getDetailAddress())
                .rate(request.getRate())
                .build();
    }

    public static StoreResponseDTO.StoreAddResultDTO toStoreAddResultDTO(Store store) {
        return StoreResponseDTO.StoreAddResultDTO.builder()
                .storeId(store.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }


    //특정 지역의 미션목록 조회를 위한 컨버터(엔티티를 dto로)
    public static StoreResponseDTO.MissionPreviewDTO toMissionPreviewDTO(Mission mission) {
        return StoreResponseDTO.MissionPreviewDTO.builder()
                .missionId(mission.getId())
                .missionDetail(mission.getMissionCondition())
                .deadline(mission.getDueDate().toLocalDate())
                .build();
    }

    public static StoreResponseDTO.MissionPreviewListDTO toMissionPreviewListDTO(Page<Mission> missionPage) {
        List<StoreResponseDTO.MissionPreviewDTO> missionList = missionPage.stream()
                .map(StoreConverter::toMissionPreviewDTO)
                .collect(Collectors.toList());

        return StoreResponseDTO.MissionPreviewListDTO.builder()
                .missionList(missionList)
                .listSize(missionList.size())
                .totalPage(missionPage.getTotalPages())
                .totalElements(missionPage.getTotalElements())
                .isFirst(missionPage.isFirst())
                .isLast(missionPage.isLast())
                .build();
    }



}