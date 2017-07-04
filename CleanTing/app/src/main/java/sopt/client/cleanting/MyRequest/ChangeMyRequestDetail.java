package sopt.client.cleanting.MyRequest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import sopt.client.cleanting.R;

public class ChangeMyRequestDetail extends AppCompatActivity {
    ImageView man1, man2, man3, cleanerImg, star1, star2, star3, star4, star5, callBtn,
    cond, window, ref, commitBtn;
    TextView manCount, starCount, name,  act, review, career, age, date, time, total;
    EditText warningEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_my_request_detail);
        man1 = (ImageView)findViewById(R.id.change_my_request_detail_man1);
        man2 = (ImageView)findViewById(R.id.change_my_request_detail_man2);
        man3 = (ImageView)findViewById(R.id.change_my_request_detail_man3);
        cleanerImg = (ImageView)findViewById(R.id.change_my_request_detail_cleaner_img);
        star1 = (ImageView)findViewById(R.id.change_my_request_detail_star1);
        star2 = (ImageView)findViewById(R.id.change_my_request_detail_star2);
        star3 = (ImageView)findViewById(R.id.change_my_request_detail_star3);
        star4 = (ImageView)findViewById(R.id.change_my_request_detail_star4);
        star5 = (ImageView)findViewById(R.id.change_my_request_detail_star5);
        callBtn = (ImageView)findViewById(R.id.change_my_request_detail_call_btn);
        cond = (ImageView)findViewById(R.id.change_my_request_detail_condi);
        window = (ImageView)findViewById(R.id.change_my_request_detail_window);
        ref = (ImageView)findViewById(R.id.change_my_request_detail_ref);
        commitBtn = (ImageView)findViewById(R.id.change_my_request_detail_btn);

        manCount = (TextView)findViewById(R.id.change_my_request_detail_man_count);
        starCount = (TextView)findViewById(R.id.change_my_request_detail_star_count);
        name = (TextView)findViewById(R.id.change_my_request_detail_cleaner_name);
        act = (TextView)findViewById(R.id.change_my_request_detail_activity);
        review = (TextView)findViewById(R.id.change_my_request_detail_review);
        career = (TextView)findViewById(R.id.change_my_request_detail_career);
        age = (TextView)findViewById(R.id.change_my_request_detail_age);
        date = (TextView)findViewById(R.id.change_my_request_detail_date);
        time = (TextView)findViewById(R.id.change_my_request_detail_time);
        total = (TextView)findViewById(R.id.change_my_request_detail_total);

        warningEdit = (EditText)findViewById(R.id.change_my_request_detail_warning);

        commitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                setResult(RESULT_OK);

                finish();
            }
        });
    }
}
