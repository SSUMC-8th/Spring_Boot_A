package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.service.MissionService.MissionCommandService;
import umc.spring.web.dto.MissionRequestDTO;
import umc.spring.web.dto.MissionResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionRestController {

    private final MissionCommandService missionCommandService;

    @PostMapping("/challenge")
    public ApiResponse<MissionResponseDTO.ChallengeResultDTO> challengeMission(
            @RequestBody @Valid MissionRequestDTO.ChallengeMissionDTO request) {

        MemberMission memberMission = missionCommandService.createChallenge(request);
        return ApiResponse.onSuccess(MissionConverter.toChallengeResultDTO(memberMission));
    }
}