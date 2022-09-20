package ma.cinema.cinema.cinemaDao;

import ma.cinema.cinema.Model.Ville;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface VilleRepos extends JpaRepository<Ville, Long> {
}
