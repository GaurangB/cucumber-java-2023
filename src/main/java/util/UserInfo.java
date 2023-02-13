package util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

public class UserInfo {
    public String key;
    public String userName;
    public String password;

    public static UserInfo getUserInfo(String userKey) {

        String dir = System.getProperty("user.dir") + "\\src\\test\\resources\\Users.json";
        String jsonStr = JsonUtil.getJsonArrayFileAsString(dir);

        ObjectMapper mapper = new ObjectMapper();
        try {
            List<UserInfo> usersInfo = mapper.readValue(jsonStr, new TypeReference<List<UserInfo>>() {
            });
            for (UserInfo info : usersInfo) {
                if (info.key.equals(userKey))
                    return info;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
