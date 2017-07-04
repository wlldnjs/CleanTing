package sopt.client.cleanting.MyRequest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import sopt.client.cleanting.R;

public class MyRequestDetailActivity extends AppCompatActivity {
    ImageView man1, man2, man3, cleanerImg, star1, star2, star3, star4, star5, callBtn,
            editBtn, cancelBtn;
    TextView manCount, starCount, name,  act, review, career, age, date, time, moreRequest, warning, total;
    String tingId, cleanerId, userId, request, cnt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_request_detail);

        man1 = (ImageView)findViewById(R.id.my_request_detail_man1);
        man2 = (ImageView)findViewById(R.id.my_request_detail_man2);
        man3 = (ImageView)findViewById(R.id.my_request_detail_man3);
        cleanerImg = (ImageView)findViewById(R.id.my_request_detail_cleaner_img);
        star1 = (ImageView)findViewById(R.id.my_request_detail_star1);
        star2 = (ImageView)findViewById(R.id.my_request_detail_star2);
        star3 = (ImageView)findViewById(R.id.my_request_detail_star3);
        star4 = (ImageView)findViewById(R.id.my_request_detail_star4);
        star5 = (ImageView)findViewById(R.id.my_request_detail_star5);
        callBtn = (ImageView)findViewById(R.id.my_request_detail_call_btn);
        editBtn = (ImageView)findViewById(R.id.my_request_detail_edit_btn);
        cancelBtn = (ImageView)findViewById(R.id.my_request_detail_cancel_btn);

        manCount = (TextView)findViewById(R.id.my_request_detail_man_count);
        starCount = (TextView)findViewById(R.id.my_request_detail_star_count);
        name = (TextView)findViewById(R.id.my_request_detail_cleaner_name);
        act = (TextView)findViewById(R.id.my_request_detail_activity);
        review = (TextView)findViewById(R.id.my_request_detail_review);
        career = (TextView)findViewById(R.id.my_request_detail_career);
        age = (TextView)findViewById(R.id.my_request_detail_age);
        date = (TextView)findViewById(R.id.my_request_detail_date);
        time = (TextView)findViewById(R.id.my_request_detail_time);
        moreRequest = (TextView)findViewById(R.id.my_request_detail_request_message);
        warning = (TextView)findViewById(R.id.my_request_detail_warning_message);
        total = (TextView)findViewById(R.id.my_request_detail_total);

        tingId = getIntent().getStringExtra("tingId");
        cleanerId = getIntent().getStringExtra("cleanerId");
        userId = getIntent().getStringExtra("userId");
        total.setText(getIntent().getStringExtra("price"));
        request = getIntent().getStringExtra("request");
        warning.setText(getIntent().getStringExtra("warning"));
        date.setText(getIntent().getStringExtra("date"));
        time.setText(getIntent().getStringExtra("time"));
        cnt = getIntent().getStringExtra("cnt");
    }
}
