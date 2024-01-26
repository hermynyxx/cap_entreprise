package fr.hermancia.capentreprise.validator.annotation;

import fr.hermancia.capentreprise.repository.intefaces.EntityFindByNicknameRepository;
import fr.hermancia.capentreprise.repository.intefaces.EntityNicknameRepository;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import fr.hermancia.capentreprise.validator.UniqueNicknameValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = UniqueNicknameValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface UniqueNickname {

    Class<? extends EntityFindByNicknameRepository<?>> repositoryClass();

    String message() default "Ce nom d'utilisateur existe déjà. ";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
