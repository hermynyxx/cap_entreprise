package fr.hermancia.capentreprise.entity;

import fr.hermancia.capentreprise.entity.interfaces.NameAndIdInterface;
import fr.hermancia.capentreprise.entity.interfaces.SluggerInterface;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Publisher implements
                        SluggerInterface,
                        NameAndIdInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "publisher")
    //@JsonView(JsonViews.GameListShowView.class)
    private List<Game> games = new ArrayList<>();

    private String slug;

    @Override
    public String getField() {
        return name;
    }
}
