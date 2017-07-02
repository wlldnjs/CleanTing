package sopt.client.cleanting.Cleanner;

import java.util.ArrayList;

/**
 * Created by 김지원 on 2017-07-03.
 */

public class SearchLocationCleanerResult {
    public String message;
    public ArrayList<SearchLocationCleanerData> result;

    public class SearchLocationCleanerData{
        public String cleanerId;
        public String name;
        public String phone;
        public String age;
        public String career;
        public String area;
        public String rate;
        public String review_cnt;
        public String image;
        public String distance;
    }

    public class SendSearchLocationCleanerData{
        public String userId;
        public String order;
        public String userLat;
        public String userLng;
    }
}
