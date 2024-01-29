package fr.hermancia.capentreprise.DTO;

import fr.hermancia.capentreprise.repository.GamerRepository;
import fr.hermancia.capentreprise.repository.UserRepository;
import fr.hermancia.capentreprise.validator.annotation.UniqueEmail;
import fr.hermancia.capentreprise.validator.annotation.UniqueName;
import fr.hermancia.capentreprise.validator.annotation.UniqueNickname;
import fr.hermancia.capentreprise.validator.group.ValidationGroup;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RegistrationUserDTO {

    @Email(message = "Veuillez renseigner votre email.")
    @NotBlank(message = "L'email doit être renseigné.")
    @UniqueEmail
    private String email;

    @NotBlank(
            message = "Veuillez renseigner un nom d'utilisateur valide",
            groups = ValidationGroup.OnPutItem.class
    )
    @UniqueNickname(
            repositoryClass = UserRepository.class,
            groups = ValidationGroup.OnPostItem.class
    )
    @NotBlank(message = "C'est par ce nom  que les autres utilisateurs verront. Veuillez le renseigner.")
    private String username;

    @NotBlank(message = "Veuillez renseigner votre mot de passe")
    @Size(message = "Le mot de passe doit contenir au moins neuf caractères.", min = 9)
    private String password;

    private String image;


    private LocalDate birthAt;






}
