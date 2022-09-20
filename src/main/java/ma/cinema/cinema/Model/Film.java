package ma.cinema.cinema.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Film  {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false , updatable = false)
    private long id;
    private String titre;
    private double duree;
    private String realisateur;
    private String description;
    private String photo;
    private Date dateSortie;
    @OneToMany(mappedBy = "film")
    private Collection<ProjectionFilm> projectionFilms;
    @ManyToOne
    private Categorie categorie;
}
