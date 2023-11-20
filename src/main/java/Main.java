import java.util.*;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    static Map<String, Country> mapOfCountries = new HashMap<>();
    // nie zmieniaj nic w main
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        Main main = new Main();

//        writeFile();
        readFile("countries.csv");
        main.run(scanner);

    }

    void run(Scanner scanner) {
        String codeFromUser = "";
        System.out.println("Podaj kod kraju, o którym chcesz zobaczyć informacje:");
        try {
            codeFromUser = scanner.nextLine();
        } catch (NoSuchElementException ex){
            System.out.println("Brak pliku countries.csv.");
        }

        try {
            mapOfCountries.get(codeFromUser).toString();
        } catch (Exception e) {
            System.out.println("Kod kraju " + codeFromUser + " nie został znaleziony.");
        }
    }

// opcja do samodzielnego nadpisania zawartości pliku
//    static void writeFile() {
//        String fileName = "countries.csv";
//        try (
//                var fileWriter = new FileWriter(fileName);
//                var writer = new BufferedWriter(fileWriter);
//        ) {
//            writer.write("PL;Polska;38000000");
//            writer.newLine();
//            writer.write("DE;Niemcy;84000000");
//            writer.newLine();
//            writer.write("ES;Hiszpania;49331076");
//            writer.newLine();
//            writer.write("FR;Francja;67364357");
//            writer.newLine();
//            writer.write("UA;Ukraina;43528136");
//            writer.newLine();
//            writer.write("CZ;Czechy;10686269");
//            writer.newLine();
//            writer.write("ES;Estonia;1244288");
//            writer.newLine();
//            writer.write("IT;Włochy;62246674");
//        } catch (IOException e) {
//            System.err.println("Nie udało się zapisać pliku " + fileName);
//        }
//    }

    static void readFile(String fileName) throws IOException {
        List<String> listOfLines;

        FileReader fileReader;
        BufferedReader reader;

        fileReader = new FileReader(fileName);
        reader = new BufferedReader(fileReader);
        String nextLine;
        while ((nextLine = reader.readLine()) != null) {
            listOfLines = List.of(nextLine.split(";"));
            mapOfCountries.put(listOfLines.get(0), new Country(listOfLines.get(0), listOfLines.get(1),
                    Double. parseDouble(listOfLines.get(2))));
        }
        reader.close();
    }
}
