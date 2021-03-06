import java.util.List;

public class Film {
    private String nameFilm;
    private int premieraYear;
    private Director director;
    private String genre;
    private List<Actor> actors;

    public String getNameFilm() {
        return nameFilm;
    }

    public void setNameFilm(String nameFilm) {
        this.nameFilm = nameFilm;
    }

    public int getPremieraYear() {
        return premieraYear;
    }

    public void setPremieraYear(int premieraYear) {
        this.premieraYear = premieraYear;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public String toStringActors() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Actor actor : actors) {
            stringBuilder.append(actor.toString());
            stringBuilder.append(", ");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 2);
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return "title: " + nameFilm +
                " \ndirector: " + director +
                " \ngenre: " + genre +
                " \ndate: " + premieraYear +
                " \nactors: " + toStringActors();
    }
}
