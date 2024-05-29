package exercise;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.Value;
import com.fasterxml.jackson.databind.ObjectMapper;

// BEGIN
@Value
// END
class Car {
    int id;
    String brand;
    String model;
    String color;
    User owner;

    // BEGIN
    public static String serialize(Car car) {
        ObjectMapper mapper = new ObjectMapper();
        var data = "";
        try {
            data = mapper.writeValueAsString(car);
        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
        }
        return data;
    }

    public static Car unserialize(String json) {
        ObjectMapper mapper = new ObjectMapper();
        Car car = null;
        try {
            car = mapper.readValue(json, Car.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return car;
    }
    // END
}
