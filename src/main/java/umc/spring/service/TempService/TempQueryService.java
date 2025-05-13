package umc.spring.service.TempService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

public interface TempQueryService {
    void checkFlag(Integer flag);
}