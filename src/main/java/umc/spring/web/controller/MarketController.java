package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.service.marektService.MarketCommandService;
import umc.spring.service.marektService.dto.MarketRequestDTO;
import umc.spring.service.marektService.dto.MarketResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/market")
public class MarketController {

    private final MarketCommandService marketCommandService;

    @PostMapping("/register")
    public ApiResponse<MarketResponseDTO.RegisterMarketResponse> registerMarket(@RequestBody @Valid MarketRequestDTO.registerDTO dto){
        MarketResponseDTO.RegisterMarketResponse response = marketCommandService.registerMarket(dto);

        return ApiResponse.onSuccess(response);
    }
}