package ma.cinema.cinema.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Categorie {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false , updatable = false)
    private long id;
    private String name;
    @OneToMany(mappedBy = "categorie")
    private Collection<Film> films;
}
