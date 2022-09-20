package ma.cinema.cinema.cinemaDao;

import ma.cinema.cinema.Model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface FilmRepos extends JpaRepository<Film, Long> {
}
