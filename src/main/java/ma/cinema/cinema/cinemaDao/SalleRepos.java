package ma.cinema.cinema.cinemaDao;

import ma.cinema.cinema.Model.Salle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface SalleRepos extends JpaRepository<Salle, Long> {
}
