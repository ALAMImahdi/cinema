package ma.cinema.cinema.cinemaDao;

import ma.cinema.cinema.Model.Seance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface SeanceRepos extends JpaRepository<Seance, Long> {
}
