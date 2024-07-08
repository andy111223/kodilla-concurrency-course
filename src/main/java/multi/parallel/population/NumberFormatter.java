package multi.parallel.population;

import java.text.NumberFormat;
import java.util.Locale;

public class NumberFormatter {

    static String format(long number) {
        NumberFormat formatter = NumberFormat.getInstance(Locale.US);
        return formatter
                .format(number)
                .replace(',','\'');
    }
}
