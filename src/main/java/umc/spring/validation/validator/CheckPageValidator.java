package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.validation.annotation.checkPage;

@Component
@RequiredArgsConstructor
public class CheckPageValidator implements ConstraintValidator<checkPage, Integer> {


    @Override
    public void initialize(checkPage constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext constraintValidatorContext) {
        return value > 0;
    }
}
