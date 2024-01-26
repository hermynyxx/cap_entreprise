package fr.hermancia.capentreprise.validator.annotation;

import fr.hermancia.capentreprise.repository.intefaces.EntityNameRepository;
import fr.hermancia.capentreprise.validator.UniqueNameValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = UniqueNameValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface UniqueName {

    Class<? extends EntityNameRepository<?>> repositoryClass();

    String message() default "Ce nom d'utilisateur existe déjà. ";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
