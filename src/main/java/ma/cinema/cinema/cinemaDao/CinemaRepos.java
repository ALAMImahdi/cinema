package ma.cinema.cinema.cinemaDao;

import ma.cinema.cinema.Model.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CinemaRepos extends JpaRepository<Cinema, Long> {
}
