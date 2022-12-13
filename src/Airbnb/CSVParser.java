package Airbnb;

import java.util.ArrayList;
import java.util.List;

public class CSVParser {
    public String parseCSV(String s) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean quote = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // case 1: quote
            // case 2: no quote
            if (quote) {
                // check double quote
                if (c == '\"') {
                    if (i < s.length() - 1 && s.charAt(i + 1) == '\"') {
                        sb.append('\"');
                        i++;
                    } else {
                        quote = false;
                    }
                } else {
                    sb.append(c);
                }
            } else {
                // case 1: quote
                // case 2: comma
                // case 3: otherwise
                if (c == '\"') {
                    quote = true;
                } else if (c == ',') {
                    res.add(sb.toString());
                    sb = new StringBuilder();
                } else {
                    sb.append(c);
                }
            }
        }

        // append remaining
        if (sb.length() > 0) {
            res.add(sb.toString());
        }

        // combine
        return String.join("|", res);
    }

    public static void main(String[] args) {
        CSVParser test = new CSVParser();
        System.out.println(test.parseCSV("john,smith,my@gmail.com,los angeles,1"));
        System.out.println(test.parseCSV("\"Alexandra \"\"Alex\"\"\",Menendez,alex.menendez@gmail.com,Miami,1 \"\"\"Alexandra Alex\"\"\""));
    }
}
