package co.com.gorest.factories;

import co.com.gorest.models.UsersModel;
import lombok.SneakyThrows;
import org.openqa.selenium.NotFoundException;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import static io.restassured.path.json.JsonPath.from;

public class UserFactory {
    public static final String PATH = "json/users.json";

    private UserFactory() {
    }

    public static UsersModel with(String code) {
        return getData().stream()
                .filter(user -> user.getId().equals(code))
                .findFirst()
                .orElseThrow(() -> new NotFoundException(String.format("data %s not found", code)));
    }

    public static List<UsersModel> getData() {
        return Arrays.asList(from(getDataFile()).getObject("data", UsersModel[].class));
    }

    @SneakyThrows
    public static URL getDataFile() {
        String path = PATH;
        URL filePath = UserFactory.class.getClassLoader().getResource(path);
        if (filePath == null) {
            throw new FileNotFoundException("file not found: " + path);
        }
        return filePath;
    }
}
