package umc.spring.web.controller;

import lombok.RequiredArgsConstructor;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.StoreConverter;
import umc.spring.domain.Store;
import umc.spring.service.StoreService.StoreCommandService;
import umc.spring.web.dto.StoreRequestDTO;
import umc.spring.web.dto.StoreResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreRestController {

    private final StoreCommandService storeCommandService;

    @PostMapping("/register")
    public ApiResponse<StoreResponseDTO.StoreAddResultDTO> createStore(@RequestBody @Valid StoreRequestDTO.StoreAddDTO request) {
        Store store = storeCommandService.createStore(request);
        return ApiResponse.onSuccess(StoreConverter.toStoreAddResultDTO(store));
    }
}