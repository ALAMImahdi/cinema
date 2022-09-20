package ma.cinema.cinema.cinemaDao;

import ma.cinema.cinema.Model.ProjectionFilm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProjectionRepos extends JpaRepository<ProjectionFilm, Long> {
}
