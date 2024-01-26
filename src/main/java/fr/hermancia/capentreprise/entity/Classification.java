package fr.hermancia.capentreprise.entity;

import com.fasterxml.jackson.annotation.JsonView;
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
public class Classification implements
                            SluggerInterface,
                            NameAndIdInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@JsonView(JsonViews.PegiShowView.class)
    private Long id;

    //@JsonView(JsonViews.PegiShowView.class)
    private String name;


    //@JsonView(JsonViews.PegiShowView.class)
    private String slug;


    @OneToMany(mappedBy = "classification")
    //@JsonView(JsonViews.GameListShowView.class)
    private List<Game> games = new ArrayList<>();

    @Override
    public String getField() {
        return name;
    }
}
