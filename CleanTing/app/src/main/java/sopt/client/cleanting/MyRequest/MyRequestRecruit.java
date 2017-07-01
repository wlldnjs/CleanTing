package sopt.client.cleanting.MyRequest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import sopt.client.cleanting.R;

public class MyRequestRecruit extends AppCompatActivity {
    ImageView man1, man2, man3, cleanerImg, star1, star2, star3, star4, star5,
            cond, window, ref, commitBtn;
    TextView manCount, starCount, name,  act, review, career, age, date, time, total;
    EditText warningEdit;
    MyRequestData datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_request_recruit);
        datas = (MyRequestData)getIntent().getSerializableExtra("datas");

        man1 = (ImageView)findViewById(R.id.my_request_recruit_man1);
        man2 = (ImageView)findViewById(R.id.my_request_recruit_man2);
        man3 = (ImageView)findViewById(R.id.my_request_recruit_man3);
        cleanerImg = (ImageView)findViewById(R.id.my_request_recruit_cleaner_img);
        star1 = (ImageView)findViewById(R.id.my_request_recruit_star1);
        star2 = (ImageView)findViewById(R.id.my_request_recruit_star2);
        star3 = (ImageView)findViewById(R.id.my_request_recruit_star3);
        star4 = (ImageView)findViewById(R.id.my_request_recruit_star4);
        star5 = (ImageView)findViewById(R.id.my_request_recruit_star5);
        cond = (ImageView)findViewById(R.id.my_request_recruit_condi);
        window = (ImageView)findViewById(R.id.my_request_recruit_window);
        ref = (ImageView)findViewById(R.id.my_request_recruit_ref);
        commitBtn = (ImageView)findViewById(R.id.my_request_recruit_join);

        manCount = (TextView)findViewById(R.id.my_request_recruit_man_count);
        starCount = (TextView)findViewById(R.id.my_request_recruit_star_count);
        name = (TextView)findViewById(R.id.my_request_recruit_cleaner_name);
        act = (TextView)findViewById(R.id.my_request_recruit_activity);
        review = (TextView)findViewById(R.id.my_request_recruit_review);
        career = (TextView)findViewById(R.id.my_request_recruit_career);
        age = (TextView)findViewById(R.id.my_request_recruit_age);
        date = (TextView)findViewById(R.id.my_request_recruit_date);
        time = (TextView)findViewById(R.id.my_request_recruit_time);
        total = (TextView)findViewById(R.id.my_request_recruit_total);

        warningEdit = (EditText)findViewById(R.id.my_request_recruit_warning);

        date.setText(datas.day);
        time.setText(datas.time);
        if(datas.member.equals("2")){
            man3.setImageResource(R.drawable.man_line);
            manCount.setText("2명/3명");
        } else if(datas.member.equals("1")){
            man2.setImageResource(R.drawable.man_line);
            man3.setImageResource(R.drawable.man_line);
            manCount.setText("1명/3명");
        }
    }
}
