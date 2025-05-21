package umc.spring.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayLoad.ApiResponse;
import umc.spring.service.MemberMissionService.MemberMissionCommandService;
import umc.spring.validation.annotation.ExistStore;
import umc.spring.validation.annotation.NotDuplicatedChallengeMission;
import umc.spring.web.dto.MemberMissionResponseDTO;

@Validated // Path Variable에 대한 유효성 검사 수행
@RestController
@RequiredArgsConstructor
@RequestMapping("/member-missions")
public class MemberMissionRestController {

    private final MemberMissionCommandService memberMissionService;

    @PostMapping("/{storeId}/missions/{missionId}/challenge")
    public ResponseEntity<ApiResponse<MemberMissionResponseDTO.ChallengeMissionResultDTO>> challengeMission(
            @PathVariable @ExistStore Long storeId,
            @PathVariable @NotDuplicatedChallengeMission Long missionId
    ) {
        Long memberId = 1L; // 테스트용 (실제 구현에서는 인증된 사용자 ID)
        MemberMissionResponseDTO.ChallengeMissionResultDTO response = memberMissionService.challengeMission(storeId, missionId, memberId);
        return ResponseEntity.ok(ApiResponse.onSuccess(response));
    }
}
