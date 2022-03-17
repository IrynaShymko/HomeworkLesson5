import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Run {
    public static void main(String[] args) throws IOException {
        MovieLibrary movieLibrary = new MovieLibrary();

        File file = new File("src/main/resources/movies.json");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line = null;
        StringBuilder stringBuilder = new StringBuilder();
        String ls = System.getProperty("line.separator");
        while ((line = br.readLine()) != null) {
            stringBuilder.append(line);
            stringBuilder.append(ls);
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        String stringFilms = stringBuilder.toString();

        Film[] f2 = Film.parseJson2(stringFilms);
        List<Film> allFilms = movieLibrary.setFilms(Arrays.asList(f2));
        while (true) {
            System.out.println();
            System.out.println("Wybierz opcje: \n 1. Podaj dwie daty aby wyświetlić nazwy filmów wydanych pomiędzy tymi datami" +
                    "\n 2. Wyświetl wszystkie informacje o losowym filmie \n 3. Podaj imię i nazwisko aktora aby wyświetlić nazwy filmów w jakich zagrał");
            Scanner scanner = new Scanner(System.in);
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    movieLibrary.showFilmsFromInterval();
                    break;
                case 2:
                    movieLibrary.showRandomFilmInfo();
                    break;
                case 3:
                    movieLibrary.showFilmByActor();
                    break;
                default:
                    System.exit(200);
            }
        }
    }
}