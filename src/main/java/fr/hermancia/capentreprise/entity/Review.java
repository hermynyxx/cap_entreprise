package fr.hermancia.capentreprise.entity;

import com.fasterxml.jackson.annotation.JsonView;
import fr.hermancia.capentreprise.entity.interfaces.SluggerInterface;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @CreationTimestamp
    private LocalDateTime createdAt;

    private Float rating;

    @CreationTimestamp
    private LocalDateTime moderationDate;

    @ManyToOne
    private Gamer gamer;

    @ManyToOne
    private Moderator moderator;

    @ManyToOne
    private Game game;

    private boolean isModerated = false;

    public boolean isModerated() {
        return isModerated;
    }



}
