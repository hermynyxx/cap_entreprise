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
public class Platform {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@JsonView(JsonViews.PlatformView.class)
    private Long id;

    //@JsonView(JsonViews.PlatformSimpleView.class)
    private String name;

    //@JsonView(JsonViews.PlatformSimpleView.class)
    private String slug;

    @ManyToMany
    @JoinTable(
            name = "platform_game",
            joinColumns = @JoinColumn(name = "platform_id"),
            inverseJoinColumns = @JoinColumn(name = "game_id")
    )
    //@JsonView(JsonViews.GameListShowView.class)
    private List<Game> games = new ArrayList<>();
}
