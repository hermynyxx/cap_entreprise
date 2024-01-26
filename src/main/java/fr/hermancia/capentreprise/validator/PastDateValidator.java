package fr.hermancia.capentreprise.validator;

import fr.hermancia.capentreprise.validator.annotation.PastDate;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class PastDateValidator
    implements ConstraintValidator<PastDate, Date> {
    @Override
    public boolean isValid(Date date, ConstraintValidatorContext constraintValidatorContext) {
       return date.before(new Date());
    }
}
