package umc.spring.converter;

import umc.spring.domain.Region;
import umc.spring.domain.Store;
import umc.spring.web.dto.StoreRequestDTO;
import umc.spring.web.dto.StoreResponseDTO;
import java.time.LocalDateTime;

public class StoreConverter {

    public static StoreResponseDTO.StoreAddResultDTO toStoreAddResultDTO(Store store){
        return StoreResponseDTO.StoreAddResultDTO.builder()
                .storeId(store.getId())
                .createTime(LocalDateTime.now())
                .build();
    }

    public static Store toStore(StoreRequestDTO.StoreAddDTO request, Region region) {

        return Store.builder()
                .name(request.getName())
                .address(request.getAddress())
                .region(region)
                .build();
    }
}
