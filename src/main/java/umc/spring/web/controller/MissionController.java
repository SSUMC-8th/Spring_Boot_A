package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.service.MissionService.MissionCommandService;
import umc.spring.web.dto.MissionDTO.ChallengeRequestDTO;

@RestController
@RequestMapping("/api/missions")
@Validated   // 클래스 레벨 어노테이션 검증을 위해 필요
@RequiredArgsConstructor
public class MissionController {

    private final MissionCommandService missionService;

    // 1) 미션 도전하기
    @PostMapping("/challenge")
    public ResponseEntity<Void> challenge(
            @RequestBody @Valid ChallengeRequestDTO request
    ) {
        missionService.challengeMission(request);
        return ResponseEntity.status(201).build();
    }

    // 2) 미션 진행 상태 변경하기
    @PatchMapping("/{missionId}/status")
    public ResponseEntity<Void> updateStatus(
            @PathVariable Long missionId,
            @RequestParam Long memberId,
            @RequestParam MissionStatus newStatus  // 지금은 PROGRESS만 쓰지만 확장 가능
    ) {
        missionService.progressMission(memberId, missionId);
        return ResponseEntity.noContent().build();
    }
}