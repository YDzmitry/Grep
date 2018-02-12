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


    public void stringsSearch(String argument) throws IOException {

        String checkingString;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> words = new ArrayList<>();

        System.out.println("Введите строки: ");
        try {
            if (argument.contains(" ")) {
                throw new Exception();
            }
            Pattern pattern = Pattern.compile("(" + argument + ")");
            while (true) {
                checkingString = cleanString(reader.readLine());
                createListFromString(checkingString, tempStrings);
                if (checkingString.isEmpty()) {
                    break;
                }
                for (int j = 0; j < tempStrings.size(); j++) {
                    Matcher matcher = pattern.matcher(tempStrings.get(j));
                    if (matcher.matches()) {
                        words.add(checkingString);
                        tempStrings.clear();
                    }
                }
                tempStrings.clear();
            }
        } catch (Exception ex) {
            createListFromString(argument, arguments);
            while (true) {
                checkingString = reader.readLine();
                createListFromString(checkingString, tempStrings);
                if (checkingString.isEmpty()) {
                    break;
                }
                for (String arg : arguments) {
                    for (int j = 0; j < tempStrings.size(); j++) {
                        if (arg.equals(tempStrings.get(j))) {
                            words.add(checkingString);
                            tempStrings.clear();
                        }
                    }

                }
                tempStrings.clear();
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
                list.add(tempString.substring(j, i + 1).trim());
                j = i + 1;
            }
        }
    }

    private String cleanString(String tempString) {
        tempString = tempString.replaceAll("(\\s+|[;])", " ").trim();
        return tempString;
    }
}