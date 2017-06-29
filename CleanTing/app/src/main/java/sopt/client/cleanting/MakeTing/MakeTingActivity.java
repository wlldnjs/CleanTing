package sopt.client.cleanting.MakeTing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import sopt.client.cleanting.R;

public class MakeTingActivity extends AppCompatActivity implements View.OnClickListener{
    RelativeLayout selectDate1, selectTime1, selectRequest1, selectWorning1, selectCleaner1;
    LinearLayout selectDate2, selectTime2, selectRequest2, selectWorning2, selectCleaner2;
    ImageView requestBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_ting);
        selectDate1 = (RelativeLayout)findViewById(R.id.select_date_layout1);
        selectTime1 = (RelativeLayout)findViewById(R.id.select_time_layout1);
        selectRequest1 = (RelativeLayout)findViewById(R.id.select_request_layout1);
        selectWorning1 = (RelativeLayout)findViewById(R.id.select_warning_layout1);
        selectCleaner1 = (RelativeLayout)findViewById(R.id.select_cleaner_layout1);

        selectDate2 = (LinearLayout)findViewById(R.id.select_date_layout2);
        selectTime2 = (LinearLayout)findViewById(R.id.select_time_layout2);
        selectRequest2 = (LinearLayout)findViewById(R.id.select_request_layout2);
        selectWorning2 = (LinearLayout)findViewById(R.id.select_warning_layout2);
        selectCleaner2 = (LinearLayout) findViewById(R.id.select_cleaner_layout2);

        selectDate1.setOnClickListener(this);
        selectTime1.setOnClickListener(this);
        selectRequest1.setOnClickListener(this);
        selectWorning1.setOnClickListener(this);
        selectCleaner1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.select_date_layout1:
                if(selectDate2.getVisibility() == View.GONE) {
                    selectDate2.setVisibility(View.VISIBLE);
                } else {
                    selectDate2.setVisibility(View.GONE);
                }
                break;
            case R.id.select_time_layout1:
                if(selectTime2.getVisibility() == View.GONE) {
                    selectTime2.setVisibility(View.VISIBLE);
                } else {
                    selectTime2.setVisibility(View.GONE);
                }
                break;
            case R.id.select_request_layout1:
                if(selectRequest2.getVisibility() == View.GONE) {
                    selectRequest2.setVisibility(View.VISIBLE);
                } else {
                    selectRequest2.setVisibility(View.GONE);
                }
                break;
            case R.id.select_warning_layout1:
                if(selectWorning2.getVisibility() == View.GONE) {
                    selectWorning2.setVisibility(View.VISIBLE);
                } else {
                    selectWorning2.setVisibility(View.GONE);
                }
                break;
            case R.id.select_cleaner_layout1:
                if(selectCleaner2.getVisibility() == View.GONE) {
                    selectCleaner2.setVisibility(View.VISIBLE);
                } else {
                    selectCleaner2.setVisibility(View.GONE);
                }
                break;
        }
    }
}
