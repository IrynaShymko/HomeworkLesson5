import CsvConvertingToJson.LabFileDTO;

import java.io.IOException;

public class Run {
    public static void main(String[] args) throws IOException {
        LabFileDTO.convertCsvToJson("src/main/resources/labExample.csv");
    }











    public static void oldHomeworkParseJson(){
//        JsonParser jsonParser = new JsonParser();
//        MovieLibrary movieLibrary = new MovieLibrary();
//        Scanner scanner;
//        String path = "src/main/resources/movies.json";
//
//        Film[] f2 = jsonParser.parseJson(path);
//        List<Film> allFilms = movieLibrary.setFilms(Arrays.asList(f2));
//
//        while (true) {
//            Menu.showMenuOptions();
//            scanner = new Scanner(System.in);
//            int option = scanner.nextInt();
//            switch (option) {
//                case 1:
//                    movieLibrary.showFilmsFromInterval(Communications.getDateFromUser(), Communications.getDateFromUser());
//                    break;
//                case 2:
//                    movieLibrary.showRandomFilmInfo();
//                    break;
//                case 3:
//                    movieLibrary.showFilmByActor(Communications.getActorNameFromUser(), Communications.getActorSurnameFromUser());
//                    break;
//                default:
//                    System.exit(0);
//            }
//        }
    }
}