package ma.cinema.cinema.controller;


import lombok.Data;
import ma.cinema.cinema.Model.Film;
import ma.cinema.cinema.Model.Ticket;
import ma.cinema.cinema.cinemaDao.FilmRepos;
import ma.cinema.cinema.cinemaDao.TicketRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


@RestController
public class CinemaRestController {
    @Autowired
    private FilmRepos filmRepos;
    @Autowired
    private TicketRepos ticketRepos;
    @GetMapping(path = "/imageFilm/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] image(@PathVariable(name = "id") Long id) throws IOException {
    Film f = filmRepos.findById(id).get();
    String photoName = f.getPhoto();
    File file = new File(System.getProperty("user.home"+"/cinema/images"+photoName+".jpg"));
    Path path= Paths.get(file.toURI());
    return Files.readAllBytes(path);
    }
    @PostMapping("/payerTickets")
    @Transactional
    public List<Ticket> payerTickets(@RequestBody TicketForm ticketForm){
        List<Ticket> listTickets= new ArrayList<>();
        ticketForm.getTickets().forEach(id->{
            //System.out.println(id);
            Ticket  ticket = ticketRepos.findById(id).get();
            ticket.setNomClient(ticketForm.getNomClient());
            ticket.setReservee(true);
            ticket.setCodePayement(ticketForm.getCodePayement());
            ticketRepos.save(ticket);
            listTickets.add(ticket);
        });
        return listTickets;
    }

}
@Data
class TicketForm{
    private  String nomClient;
    private int codePayement;
    private List<Long> tickets = new ArrayList<>();
}
