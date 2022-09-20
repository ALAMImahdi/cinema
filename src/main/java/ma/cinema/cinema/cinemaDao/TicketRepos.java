package ma.cinema.cinema.cinemaDao;

import ma.cinema.cinema.Model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Map;

@RepositoryRestResource
public interface TicketRepos extends JpaRepository<Ticket, Long> {

}
