import java.util.List;
import java.util.Random;

public class MovieLibrary {
    private List<Film> films;

    public List<Film> getFilms() {
        return films;
    }

    public List<Film> setFilms(List<Film> films) {
        this.films = films;
        return films;
    }

    public void showFilmsFromInterval(int startDate, int endDate) {
        for (Film film :
                films) {
            if (film.getPremieraYear() >= startDate && film.getPremieraYear() <= endDate) {
                System.out.println("Film title: " + film.getNameFilm());
            }
        }
    }

    public void showFilmByActor(String actorNameFromUser, String actorSurnameFromUser) {
        for (Film film :
                films) {
            for (Actor actor : film.getActors()) {
                if (actor.getName().equals(actorNameFromUser) && actor.getSurname().equals(actorSurnameFromUser)) {
                    System.out.println("Film title: " + film.getNameFilm());
                }
            }
        }
    }

    public void showRandomFilmInfo() {
        int indexOfRandomFilm = new Random().nextInt(films.size());
        System.out.println(films.get(indexOfRandomFilm));
    }
}