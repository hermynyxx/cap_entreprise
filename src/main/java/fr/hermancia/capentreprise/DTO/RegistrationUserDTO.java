package fr.hermancia.capentreprise.DTO;

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

    private String email;

    private String nickname;

    private String password;

    private LocalDate birthAt;

    private String phoneNumber;




}
