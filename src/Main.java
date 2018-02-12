
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        SearchGrep searchGrep = new SearchGrep();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Введите аргументы через пробел: ");
        String str = reader.readLine();
        if (str.trim().isEmpty()) {
            System.out.println("Ничего не введено");
        } else searchGrep.stringsSearch(str.trim());
    }
}