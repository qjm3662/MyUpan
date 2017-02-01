package Test;

import org.springframework.stereotype.Component;

/**
 * Created by qjm3662 on 2017/1/23.
 */
@Component
public class Person {
    private String name;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
