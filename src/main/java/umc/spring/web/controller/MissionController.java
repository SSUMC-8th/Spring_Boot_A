package umc.spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MissionConverter;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.service.missionService.MissionCommandService;
import umc.spring.service.missionService.MissionQueryService;
import umc.spring.service.missionService.dto.MissionRequestDTO;
import umc.spring.service.missionService.dto.MissionResponseDTO;
import umc.spring.service.reviewService.ReviewCommandService;
import umc.spring.service.reviewService.dto.ReviewRequestDTO;
import umc.spring.service.reviewService.dto.ReviewResponseDTO;
import umc.spring.validation.annotation.ValidPage;


@RestController
@RequiredArgsConstructor
@RequestMapping("/mission")
public class MissionController {
    private final MissionQueryService missionQueryService;
    private final MissionCommandService missionCommandService;

    @PostMapping("/progress")
    public ApiResponse<MissionResponseDTO.challengeResponse> challengeMission(@RequestBody @Valid MissionRequestDTO.challengeMission dto){
        MissionResponseDTO.challengeResponse response = missionCommandService.challengeMission(dto);

        return ApiResponse.onSuccess(response);
    }

    @GetMapping("/{marketId}")
    @Operation(summary = "해당 가게 리뷰 조회하기 API",
            description = "요청한 가게의 미션 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "marketId", description = "마켓 아이디를 넘겨주세요")
    })
    public ApiResponse<MissionResponseDTO.marketMissionListDTO>
    getMarketMissionList(@PathVariable(name = "marketId") Long marketId, @ValidPage Integer page){
        Page<Mission> missionList = missionQueryService.getMarketMissionList(marketId,page);
        return ApiResponse.onSuccess(MissionConverter.toMarketMissionListDTO(missionList));

    }
}
