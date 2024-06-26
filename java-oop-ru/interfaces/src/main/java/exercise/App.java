package exercise;

import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class App {
    public static List<String> buildApartmentsList(List<Home> apartments, int cnt) {
        return apartments.stream()
                .sorted(Home::compareTo)
                .map(Home::toString)
                .limit(cnt)
                .collect(Collectors.toList());
    }
}
// END
