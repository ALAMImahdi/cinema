package ma.cinema.cinema.service;

import ma.cinema.cinema.Model.*;
import ma.cinema.cinema.cinemaDao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

@Service
@Transactional //chaque fois on appel une methode on fait a la fin un commit ou rollback
public class CinemaInitService implements ICinema{
    @Autowired
    private VilleRepos villeRepos;
    @Autowired
    private CinemaRepos cinemaRepos;
    @Autowired
    private SalleRepos salleRepos;
    @Autowired
    private PlaceRepos placeRepos;
    @Autowired
    private SeanceRepos seanceRepos;
    @Autowired
    private FilmRepos filmRepos;
    @Autowired
    private ProjectionRepos projectionRepos;
    @Autowired
    private CategorieRepos categorieRepos;
    @Autowired
    private TicketRepos ticketRepos;
    @Override
    public void initVilles() {
        Stream.of("Casablanca","Rabat","Tanger","Marrakech").forEach(nameVille->{
           Ville ville=new Ville();
           ville.setName(nameVille);
           villeRepos.save(ville);
        });
    }

    @Override
    public void initCinemas() {
    villeRepos.findAll().forEach(v->{
        Stream.of("Megarama","IMAX","Dawliz","FOUNOUN").forEach(nameCinema ->{
            Cinema cinema=new Cinema();
            cinema.setName(nameCinema);
            cinema.setNombreSalles((int) (3+Math.random()*7));
            cinema.setVille(v);
            cinemaRepos.save(cinema);
        });
    });
    }

    @Override
    public void initSalles() {
    cinemaRepos.findAll().forEach(cinema->{
        for(int i=0;i<cinema.getNombreSalles();i++){
            Salle  salle=new Salle();
            salle.setName("Salle"+(i+1));
            salle.setCinema(cinema);
            salle.setNombrePlace((int) (15+(Math.random()*20)));
            salleRepos.save(salle);
        }
    });
    }

    @Override
    public void initPlaces() {
        salleRepos.findAll().forEach(salle->{
            for (int i=0;i<salle.getNombrePlace();i++){
                Place place=new Place();
                place.setNumero(i+1);
                place.setSalle(salle);
                placeRepos.save(place);
            }
        });

    }

    @Override
    public void initSeances() {
        DateFormat dateFormat=new SimpleDateFormat("HH:mm");
        Stream.of("12:00","15:00","17:00","19:00","21:00").forEach(s->{
            Seance seance=new Seance();
            try {
                seance.setHeureDebut(dateFormat.parse(s));
                seanceRepos.save(seance);
            }catch (ParseException e){
                e.printStackTrace();
            }
        });

    }

    @Override
    public void initCategories() {
    Stream.of("Histoire","Action","Fiction","Drama").forEach(cat->{
        Categorie categorie=new Categorie();
        categorie.setName(cat);
        categorieRepos.save(categorie);
    });
    }

    @Override
    public void initFilms() {
        double[] durees=new double[]{1,1.5,2,2.5,3};
        List<Categorie> categories=categorieRepos.findAll();
        Stream.of("Game Of Thrones","Seigneur des anneaux","Spider Man","Iron Man","Cat Women").forEach(f->{
            Film film = new Film();
            film.setTitre(f);
            film.setDuree(durees[new Random().nextInt(durees.length)]);
            film.setPhoto(f.replaceAll(" ","")+".jpg");
            film.setCategorie(categories.get(new Random().nextInt(categories.size())));
            filmRepos.save(film);
        });


    }

    @Override
    public void initProjections() {
        double[] prices=new double[]{30,50,60,70,90,100};
        villeRepos.findAll().forEach(ville->{
            ville.getCinemas().forEach(cinema->{
                cinema.getSalles().forEach(salle -> {
                   filmRepos.findAll().forEach(film -> {
                       seanceRepos.findAll().forEach(seance -> {
                               ProjectionFilm projectionFilm=new ProjectionFilm();
                               projectionFilm.setDateProjection(new Date());
                               projectionFilm.setFilm(film);
                               projectionFilm.setPrix(prices[new Random().nextInt(prices.length)]);
                               projectionFilm.setSalle(salle);
                               projectionFilm.setSeance(seance);
                               projectionRepos.save(projectionFilm);

                       });
                   });
                });
            });
        });


    }

    @Override
    public void initTickets() {
    projectionRepos.findAll().forEach(p->{
        p.getSalle().getPlaces().forEach(place->{
            Ticket ticket = new Ticket();
            ticket.setPlace(place);
            ticket.setPrix(p.getPrix());
            ticket.setProjectionFilm(p);
            ticket.setReservee(false);
            ticketRepos.save(ticket);
        });
    });
    }
}
