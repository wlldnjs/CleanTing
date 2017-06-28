package sopt.client.cleanting.MyRequest;

import java.util.ArrayList;

/**
 * Created by 김지원 on 2017-06-28.
 */

public class RequestTingDetailResult {
    public String message;
    public ArrayList<RequestTingDetailResultData> result;

    public class RequestTingDetailResultData{
        public String tingId;
        public String area;
        public String year;
        public String month;
        public String date;
        public String time;
        public String price;
        public String cleanerId;
        public String request;
        public String cnt;
    }
}
