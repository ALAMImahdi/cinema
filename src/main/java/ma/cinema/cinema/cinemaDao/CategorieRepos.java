package ma.cinema.cinema.cinemaDao;

import ma.cinema.cinema.Model.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CategorieRepos extends JpaRepository<Categorie, Long> {
}
