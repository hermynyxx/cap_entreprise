package fr.hermancia.capentreprise.DTO;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReviewDTO {
    @NotBlank
    private String title;

    @NotBlank
    private String content;

    private String description;

    //    @Positive(message = "The user id has to be positive")
    @NotNull(message = "Un identifiant de jeu est requis")
    private Long gameId;


    //    @Positive(message = "The user id has to be positive")
    @NotNull(message = "L'utilisateur est requis")
    private Long userId;


    @DecimalMin(
            value = "0",
            message= "The rating should be at least 0"
    )
    @DecimalMax(
            value = "20",
            message= "The rating should be 20 at max"
    )
    @NotNull
    private Float rating;
}
