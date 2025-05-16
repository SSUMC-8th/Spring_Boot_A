package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.repository.FoodCategoryRepository;
import umc.spring.repository.StoreRespository.StoreRepository;
import umc.spring.validation.annotation.ExistCategories;
import umc.spring.validation.annotation.ExistStores;

import java.util.List;

@Component
public class StoresExistValidator
        implements ConstraintValidator<ExistStores, Long> {

    private final StoreRepository storeRepository;

    public StoresExistValidator(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        if (value == null) return true;
        return storeRepository.existsById(value);
    }
}

