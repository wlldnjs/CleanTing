package sopt.client.cleanting.Community;

import java.util.ArrayList;

/**
 * Created by 김지원 on 2017-07-03.
 */

public class FindAllBulletinResult {
    public String message;
    public ArrayList<FindAllBulletinData> result;

    public class FindAllBulletinData{
        public String postId;
        public String userId;
        public String title;
        public String content;
        public String view_number;
        public String date;
        public String time;
        public String comment_cnt;
    }
}
