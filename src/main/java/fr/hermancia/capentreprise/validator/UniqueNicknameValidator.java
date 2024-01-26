package fr.hermancia.capentreprise.validator;

import fr.hermancia.capentreprise.repository.intefaces.EntityFindByNicknameRepository;
import jakarta.persistence.EntityManager;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.stereotype.Component;
import fr.hermancia.capentreprise.validator.annotation.UniqueNickname;

@Component
public class UniqueNicknameValidator implements ConstraintValidator<UniqueNickname, String> {

    private Class<? extends EntityFindByNicknameRepository<?>> repositoryClass;

    private final EntityManager em;

    @Autowired
    UniqueNicknameValidator(EntityManager em) {
        this.em = em;
    }

    @Override
    public void initialize(UniqueNickname constraintAnnotation) {
        repositoryClass = constraintAnnotation.repositoryClass();

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        JpaRepositoryFactory factory = new JpaRepositoryFactory(em);
        EntityFindByNicknameRepository<?> repository = factory.getRepository(repositoryClass);
        return repository.findByNickname(s).isEmpty();
    }

}

