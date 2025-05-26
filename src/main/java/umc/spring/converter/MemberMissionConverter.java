package umc.spring.converter;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.service.membermissionService.dto.MemberMissionResponseDTO;
import umc.spring.service.missionService.dto.MissionResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class MemberMissionConverter {

    public static MemberMissionResponseDTO.myProgressMissionDTO toMyProgressMission(MemberMission mission){
        return MemberMissionResponseDTO.myProgressMissionDTO.builder()
                .content(mission.getMission().getContent())
                .market(mission.getMission().getMarket().getName())
                .region(mission.getRegion().getName())
                .build();
    }

    public static MemberMissionResponseDTO.myProgressMissionListDTO toMyProgressMissionListDTO(Page<MemberMission> missionList){
        List<MemberMissionResponseDTO.myProgressMissionDTO> myMissionDTOList = missionList.stream()
                .map(MemberMissionConverter::toMyProgressMission).collect(Collectors.toList());

        return MemberMissionResponseDTO.myProgressMissionListDTO.builder()
                .isLast(missionList.isLast())
                .isFirst(missionList.isFirst())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .listSize(myMissionDTOList.size())
                .missionList(myMissionDTOList)
                .build();
    }
}
