package sopt.client.cleanting.MakeTing;

/**
 * Created by 김지원 on 2017-06-28.
 */

public class MakeTingRequestResult {
    public String message;
    public MakeTingRequestResultData result;

    public class MakeTingRequestResultData{
        public String userId;
        public String price;
        public String request;
    }
}
