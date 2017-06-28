package sopt.client.cleanting.MyRequest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import sopt.client.cleanting.R;

public class MyRequestRecruit extends AppCompatActivity {
    ImageView button_back,person1,person2,person3;//뒤로가기버튼, 모집현황사람
    ImageView cleaner_picture,star1,star2,star3,star4,star5;//클리너사진, 별점5개
    ImageView addrequest1,addrequest2,addrequest3;//추가요청이미지
    ImageView button_participate;//참여하기버튼

    TextView text_people,cleaner_name,star_people;//모집현황 사람 수
    TextView act,review,career,age;//활동,리뷰,경력,나이
    TextView more_view;//더보기
    TextView clean_date,clean_time;//청소날짜,청소시간
    TextView moreview_clean;//기본청소보러가기
    TextView text_addrequest1,text_addrequest2,text_addrequest3;//추가요청텍스트
    TextView totalprice;//총금액

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_request_recruit);
        button_back=(ImageView)findViewById(R.id.button_back);
        person1=(ImageView)findViewById(R.id.person1);
        person2=(ImageView)findViewById(R.id.person2);
        person3=(ImageView)findViewById(R.id.person3);
        cleaner_picture=(ImageView)findViewById(R.id.cleaner_picture);
        star1=(ImageView)findViewById(R.id.star1);
        star2=(ImageView)findViewById(R.id.star2);
        star3=(ImageView)findViewById(R.id.star3);
        star4=(ImageView)findViewById(R.id.star4);
        star5=(ImageView)findViewById(R.id.star5);
        addrequest1=(ImageView)findViewById(R.id.addrequest1);
        addrequest2=(ImageView)findViewById(R.id.addrequest2);
        addrequest3=(ImageView)findViewById(R.id.addrequest3);
        button_participate=(ImageView)findViewById(R.id.button_participate);

        text_people=(TextView)findViewById(R.id.text_people);
        cleaner_name=(TextView)findViewById(R.id.cleaner_name);
        star_people=(TextView)findViewById(R.id.star_people);
        act=(TextView)findViewById(R.id.act);
        review=(TextView)findViewById(R.id.review);
        career=(TextView)findViewById(R.id.career);
        age=(TextView)findViewById(R.id.age);
        more_view=(TextView)findViewById(R.id.more_view);
        moreview_clean=(TextView)findViewById(R.id.moreview_clean);
        text_addrequest1=(TextView)findViewById(R.id.text_addrequest1);
        text_addrequest2=(TextView)findViewById(R.id.text_addrequest2);
        text_addrequest3=(TextView)findViewById(R.id.text_addrequest3);
        totalprice=(TextView)findViewById(R.id.totalprice);
        clean_date=(TextView)findViewById(R.id.clean_date);
        clean_time=(TextView)findViewById(R.id.clean_time);




    }
}
