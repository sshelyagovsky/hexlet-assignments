package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


// BEGIN
public class Validator {

    public static List<String> validate(Object object) {

        List<String> list = new ArrayList<>();

        for (Field field : object.getClass().getDeclaredFields()) {
            NotNull notNull = field.getAnnotation(NotNull.class);
            if (notNull != null) {
                try {
                    field.setAccessible(true);
                    if (field.get(object) == null) {
                        list.add(field.getName());
                    }
                } catch (IllegalAccessException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        return list;
    }

    public static Map<String, List<String>> advancedValidate(Object object) {

        Map<String, List<String>> map = new HashMap<>();

        for (Field field : object.getClass().getDeclaredFields()) {

            NotNull notNull = field.getAnnotation(NotNull.class);
            MinLength minLength = field.getAnnotation(MinLength.class);

            try {
                field.setAccessible(true);

                if (notNull != null && field.get(object) == null) {
                    map.put(field.getName(), List.of("can not be null"));
                }

                if (minLength != null && String.valueOf(field.get(object)).length() < 4) {
                    map.put(field.getName(), List.of("length less than 4"));
                }

            } catch (IllegalAccessException e) {
                System.out.println(e.getMessage());
            }
        }

        return map;
    }
}
// END
