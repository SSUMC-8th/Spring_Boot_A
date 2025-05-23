package umc.spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.spring.converter.StoreConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.service.StoreService.StoreCommandService;
import umc.spring.service.StoreService.StoreQueryService;
import umc.spring.validation.annotation.ValidPage;
import umc.spring.web.dto.StoreRequestDTO;
import umc.spring.web.dto.StoreResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreRestController {

    private final StoreCommandService storeCommandService;

    @PostMapping("/register")
    public umc.spring.apiPayload.ApiResponse<StoreResponseDTO.StoreAddResultDTO> createStore(@RequestBody @Valid StoreRequestDTO.StoreAddDTO request) {
        Store store = storeCommandService.createStore(request);
        return umc.spring.apiPayload.ApiResponse.onSuccess(StoreConverter.toStoreAddResultDTO(store));
    }


    private final StoreQueryService storeQueryService;

    @GetMapping("/{storeId}/missions")
    @Operation(summary = "가게의 미션 목록 조회 API")
    @ApiResponses({
            @ApiResponse(responseCode = "COMMON200", description = "성공"),
            @ApiResponse(responseCode = "COMMON400", description = "page가 1보다 작음"),
            @ApiResponse(responseCode = "STORE4001", description = "존재하지 않는 가게")
    })
    public umc.spring.apiPayload.ApiResponse<StoreResponseDTO.MissionPreviewListDTO> getMissionList(
            @PathVariable Long storeId,
            @ValidPage @RequestParam Integer page) {

        Page<Mission> missions = storeQueryService.getMissionList(storeId, page - 1);
        return umc.spring.apiPayload.ApiResponse.onSuccess(StoreConverter.toMissionPreviewListDTO(missions));
    }




}