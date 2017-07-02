package sopt.client.cleanting.Cleanner;

import java.util.ArrayList;

/**
 * Created by 김지원 on 2017-07-03.
 */

public class SearchCleanerResult {
    public String message;
    public ArrayList<SearchCleanerData> result;

    public class SearchCleanerData{
        public String cleanerId;
        public String name;
        public String phone;
        public String age;
        public String career;
        public String area;
        public String rate;
        public String review_cnt;
        public String image;
    }
}
