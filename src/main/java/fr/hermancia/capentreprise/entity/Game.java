package fr.hermancia.capentreprise.entity;

import com.fasterxml.jackson.annotation.JsonView;
import fr.hermancia.capentreprise.entity.interfaces.NameAndIdInterface;
import fr.hermancia.capentreprise.entity.interfaces.SluggerInterface;
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
public class Game implements
                  SluggerInterface,
                  NameAndIdInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;


    private LocalDate publishedAt;


    private String image;

    private String slug;

    @ManyToOne
    private Publisher publisher;

    @OneToMany(mappedBy = "game")
    private List<Review> reviews = new ArrayList<>();

    @ManyToMany
    private List<Platform> platforms = new ArrayList<>();


    @ManyToOne
    private Genre genre;

    @ManyToOne
    private Moderator moderator;


    @ManyToOne
    private Classification classification;

    @ManyToOne
    private BusinessModel businessModel;

    @Override
    public String getField() {
        return name;
    }

    public void addPlatform(Platform platform) {
        if (!platforms.contains(platform)) {
            platforms.add(platform);
        }
    }
}