package ma.cinema.cinema.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import  java.io.Serializable;
import java.util.Collection;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Cinema implements Serializable{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false , updatable = false)
    private Long id;
    private String name;
    private double longitude;
    private double altitude;
    private double latitude;
    private int nombreSalles;
    @OneToMany(mappedBy = "cinema")//bidirectionnelle
    private Collection<Salle> salles;
    @ManyToOne
    private Ville ville;
}
