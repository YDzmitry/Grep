
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        SearchGrep searchGrep = new SearchGrep();

        System.out.println("1 - для поиска по слову");
        System.out.println("2 - для поиска по регулярному выражению");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String str = reader.readLine();
            if (str.isEmpty()) break;

            switch (str) {
                case "1":
                    searchGrep.stringsSearch("1");
                    break;
                case "2":
                    searchGrep.stringsSearch("2");
                    break;
                default:
                    break;
            }
        }
    }
}