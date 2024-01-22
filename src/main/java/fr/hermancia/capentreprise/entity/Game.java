package fr.hermancia.capentreprise.entity;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@JsonView(JsonViews.GameListShowView.class)
    private Long id;

    //@JsonView(JsonViews.GameSimpleView.class)
    private String name;

    //@JsonView(JsonViews.GameListShowView.class)
    private String description;


    //@JsonView(JsonViews.GameListShowView.class)
    private LocalDate publishedAt;

    //@JsonView(JsonViews.GameSimpleView.class)
    private String thumbnailCover;

    //@JsonView(JsonViews.GameSimpleView.class)
    private String slug;

    @ManyToOne
    //@JsonView(JsonViews.GameListShowView.class)
    private Publisher publisher;

    @OneToMany(mappedBy = "game")
    //@JsonView(JsonViews.GameListShowView.class)
    private List<Review> reviews = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "game_platform",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "platform_id")
    )
    //@JsonView(JsonViews.GameListShowView.class)
    private List<Platform> platforms = new ArrayList<>();


    @ManyToOne
    private Genre genre;

    @ManyToOne
    private Moderator moderator;


    @ManyToOne
    //@JsonView(JsonViews.GameListShowView.class)
    private Classification classification;

    @ManyToOne
    //@JsonView(JsonViews.GameListShowView.class)
    private BusinessModel businessModel;


}
