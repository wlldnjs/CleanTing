package sopt.client.cleanting.Main.Login;

/**
 * Created by 김지원 on 2017-07-03.
 */

public class LoginResult {
    public String message;
    public String token;
    public LoginData userInfo;

    public class LoginData{
        public String userId;
        public String name;
        public String phone;
        public String address;
//        public String lat;
//        public String lng;
    }

    public class SendLoginData{
        public String userId;
        public String pwd;
    }
}
