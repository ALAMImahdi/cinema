package ma.cinema.cinema.cinemaDao;

import ma.cinema.cinema.Model.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PlaceRepos extends JpaRepository<Place, Long> {
}
