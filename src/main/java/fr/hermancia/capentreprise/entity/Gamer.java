package fr.hermancia.capentreprise.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@DiscriminatorValue("GAMER")
public class Gamer extends User{

    private LocalDate birthAt;

    @OneToMany(mappedBy = "gamer")
    private List<Review> reviews = new ArrayList<>();

}
