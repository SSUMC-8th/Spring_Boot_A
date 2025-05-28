package umc.spring.web.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MemberMissionConverter;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.service.membermissionService.MemberMissionQueryService;
import umc.spring.service.membermissionService.dto.MemberMissionResponseDTO;
import umc.spring.service.missionService.dto.MissionResponseDTO;
import umc.spring.validation.annotation.ValidPage;

@RestController
@RequiredArgsConstructor
@RequestMapping("/membermission")
public class MemberMissionController {

    private final MemberMissionQueryService memberMissionQueryService;

    @GetMapping("/{memberId}")
    @Operation(summary = "내가 도전중인 미션 조회하기 API",
            description = "내가 도전중인 미션을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "memberId", description = "추후에 토큰으로 변경 예정")
    })
    public ApiResponse<MemberMissionResponseDTO.myProgressMissionListDTO>
    getMarketMissionList(@PathVariable(name = "memberId") Long memberId, @ValidPage Integer page){
        Page<MemberMission> missionList = memberMissionQueryService.myProgressMissionList(memberId, page);
        return ApiResponse.onSuccess(MemberMissionConverter.toMyProgressMissionListDTO(missionList));

    }
}
