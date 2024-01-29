package fr.hermancia.capentreprise.DTO;

import fr.hermancia.capentreprise.entity.BusinessModel;
import fr.hermancia.capentreprise.entity.Genre;
import fr.hermancia.capentreprise.entity.Platform;
import fr.hermancia.capentreprise.validator.group.ValidationGroup;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
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

    @NotBlank(
            message = "Veuillez renseigner le nom du jeu",
            groups = ValidationGroup.OnPutItem.class
    )
    private String name;


    private String description;



    @NotBlank(
            message = "Veuillez renseigner une date valide",
            groups = ValidationGroup.OnPutItem.class
    )
    private Date publishedAt;

    private String image;

    @NotBlank(
            message = "Veuillez renseigner le nom d'un éditeur pour ce jeu",
            groups = ValidationGroup.OnPutItem.class
    )
    private Long publisher_id;

    private List<Platform> platforms = new ArrayList<>();

    private List<Genre> genreList = new ArrayList<>();


    private Long classification_id;

    private List<BusinessModel> businessModels = new ArrayList<>();
}
