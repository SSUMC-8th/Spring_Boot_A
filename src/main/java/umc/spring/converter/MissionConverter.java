package umc.spring.converter;

import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.web.dto.MissionRequestDTO;
import umc.spring.web.dto.MissionResponseDTO;

import java.time.LocalDateTime;

public class MissionConverter {

    public static MissionResponseDTO.CreateMissionResultDTO toCreateMissionResultDTO(Mission mission){
        return MissionResponseDTO.CreateMissionResultDTO.builder()
                .missionId(mission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Mission toMission(MissionRequestDTO.createMissionDTO request, Store store) {
        return Mission.builder()
                .store(store)
                .missionCondition(request.getMissionCondition())
                .point(request.getPoint())
                .dueDate(request.getDueDate())
                .build();
    }
}
