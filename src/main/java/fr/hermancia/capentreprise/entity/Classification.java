package fr.hermancia.capentreprise.entity;

import com.fasterxml.jackson.annotation.JsonView;
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
public class Classification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@JsonView(JsonViews.PegiShowView.class)
    private Long id;

    //@JsonView(JsonViews.PegiShowView.class)
    private String name;


    @OneToMany(mappedBy = "classification")
    //@JsonView(JsonViews.GameListShowView.class)
    private List<Game> games = new ArrayList<>();


    //@JsonView(JsonViews.PegiShowView.class)
    private String slug;
}
