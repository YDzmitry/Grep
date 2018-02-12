import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class SearchGrep {

    private List<String> arguments = new ArrayList<>();
    private List<String> tempStrings = new ArrayList<>();


    public void stringsSearch(String count) throws IOException {


        Pattern pattern = null;
        String argument;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> words = new ArrayList<>();

        if (count.equals("1")) {

            System.out.print("Введите аргументы через пробел: ");
            argument = reader.readLine().toLowerCase().trim();
            createListFromString(argument, arguments);

        } else {
            System.out.print("Введите аргумент(regex): ");
            pattern = Pattern.compile(reader.readLine());
        }

        System.out.println("Введите строки: ");

        while (true) {
            String originalString = reader.readLine();
            createListFromString(originalString, tempStrings);

            if (originalString.isEmpty())
                break;

            if (count.equals("1")) {

                for (String arg : arguments) {
                    for (int j = 0; j < tempStrings.size(); j++) {
                        if (arg.equals(tempStrings.get(j))) {
                            words.add(originalString);
                            tempStrings.clear();
                        }
                    }

                }
                tempStrings.clear();

            }
            if (pattern != null) {

                Matcher matcher = pattern.matcher(originalString);

                if (matcher.matches()) words.add(originalString);
            }

        }

        System.out.println("\nСтроки, содержащие введенный аргумент");
        for (String str : words)
            System.out.println(str);
    }


    private void createListFromString(String tempString, List list) {
        tempString = cleanString(tempString);
        for (int i = 0, j = 0; i < tempString.length(); i++) {
            if ((tempString.charAt(i) == ' ') || tempString.length() == i + 1) {
                list.add(tempString.substring(j, i + 1));
                j = i + 1;
            }
        }
    }

    private String cleanString(String tempString) {
        tempString = tempString.replaceAll("\\W+", " ").replaceAll("\\s+", " ").trim();
        return tempString;
    }
}