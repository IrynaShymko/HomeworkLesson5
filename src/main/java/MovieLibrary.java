import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class MovieLibrary {
    private List<Film> films;

    public List<Film> getFilms() {
        return films;
    }

    public List<Film> setFilms(List<Film> films) {
        this.films = films;
        return films;
    }

    public void showFilmsFromInterval() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter start release year");
        int startDate = scanner.nextInt();
        System.out.println("Enter end release year");
        int endDate = scanner.nextInt();
        for (Film film :
                films) {
            if (film.getPremieraYear() >= startDate && film.getPremieraYear() <= endDate) {
                System.out.println("Film title: "+film.getNameFilm());
            }
        }
    }

    public void showFilmByActor() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name of actor (for example Morgan)");
        String actorNameFromUser = scanner.nextLine();
        System.out.println("Enter surname of actor (for example Freeman)");
        String actorSurnameFromUser = scanner.nextLine();
        for (Film film :
                films) {
            for (Actor actor : film.getActors()) {
                if (actor.getName().equals(actorNameFromUser) && actor.getSurname().equals(actorSurnameFromUser)) {
                    System.out.println("Film title: "+film.getNameFilm());
                }
            }
        }
    }

    public void showRandomFilmInfo() {
    int indexOfRandomFilm = new Random().nextInt(films.size());
    System.out.println(films.get(indexOfRandomFilm));
    }
}





