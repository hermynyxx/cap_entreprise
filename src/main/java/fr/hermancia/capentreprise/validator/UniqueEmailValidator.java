package fr.hermancia.capentreprise.validator;

import fr.hermancia.capentreprise.repository.UserRepository;
import fr.hermancia.capentreprise.validator.annotation.UniqueEmail;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UniqueEmailValidator
        implements ConstraintValidator<UniqueEmail, String> {

    private final UserRepository userRepository;

    private String example;

    @Autowired
    UniqueEmailValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public void initialize(UniqueEmail constraintAnnotation) {
        example = constraintAnnotation.example();
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        System.out.println("Valeur d'example : " + example);
        return userRepository.findByEmail (email).isEmpty();
    }
}
