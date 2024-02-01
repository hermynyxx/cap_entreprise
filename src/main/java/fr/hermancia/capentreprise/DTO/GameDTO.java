package fr.hermancia.capentreprise.DTO;

import fr.hermancia.capentreprise.entity.*;
import fr.hermancia.capentreprise.validator.group.ValidationGroup;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GameDTO {

    @NotBlank
    private String description;

    @NotBlank
    private String publishedAt;

    @NotBlank
    private String name;

    @NotEmpty
    private List<Platform> platforms;

    @NotNull
    private Classification classification;

    @NotNull
    private Genre genre;

    @NotNull
    private BusinessModel businessModel;

    @NotNull
    private Publisher publisher;
}
