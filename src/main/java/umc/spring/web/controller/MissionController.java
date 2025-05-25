package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.service.missionService.MissionCommandService;
import umc.spring.service.missionService.dto.MissionRequestDTO;
import umc.spring.service.missionService.dto.MissionResponseDTO;
import umc.spring.service.reviewService.ReviewCommandService;
import umc.spring.service.reviewService.dto.ReviewRequestDTO;
import umc.spring.service.reviewService.dto.ReviewResponseDTO;


@RestController
@RequiredArgsConstructor
@RequestMapping("/mission")
public class MissionController {

    private final MissionCommandService missionCommandService;

    @PostMapping("/progress")
    public ApiResponse<MissionResponseDTO.challengeResponse> challengeMission(@RequestBody @Valid MissionRequestDTO.challengeMission dto){
        MissionResponseDTO.challengeResponse response = missionCommandService.challengeMission(dto);

        return ApiResponse.onSuccess(response);
    }
}
