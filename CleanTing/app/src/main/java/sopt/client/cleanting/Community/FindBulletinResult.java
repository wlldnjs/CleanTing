package sopt.client.cleanting.Community;

import java.util.ArrayList;

/**
 * Created by 김지원 on 2017-07-03.
 */

public class FindBulletinResult {
    public String message;
    public FindBulletinData result;

    public class FindBulletinData{
        public BulletinPostData post;
        public ArrayList<BulletinCommentData> comment;
    }

}
