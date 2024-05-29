package exercise;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

// BEGIN
public class App {

    public static void save(Path path, Car car) {
        var content = Car.serialize(car);
        try {
            Files.write(path, content.getBytes(), StandardOpenOption.WRITE);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Car extract(Path path) {
        var content = "";
        try {
            content = Files.readString(path);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return Car.unserialize(content);
    }
}
// END
