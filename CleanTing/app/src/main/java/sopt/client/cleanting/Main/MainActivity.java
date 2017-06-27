package sopt.client.cleanting.Main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import sopt.client.cleanting.Alarm.AlarmFragment;
import sopt.client.cleanting.MakeTing.MakeTingFragment;
import sopt.client.cleanting.MyRequest.MyRequestFragment;
import sopt.client.cleanting.Mypage.MypageFragment;
import sopt.client.cleanting.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    ImageView myRequestBtn, makeTingBtn, alarmBtn, mypageBtn;
    MyRequestFragment myRequestFragment;
    MakeTingFragment makeTingFragment;
    AlarmFragment alarmFragment;
    MypageFragment mypageFragment;
    int previousBtn = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myRequestBtn = (ImageView)findViewById(R.id.my_request_btn);
        makeTingBtn = (ImageView)findViewById(R.id.make_ting_btn);
        alarmBtn = (ImageView)findViewById(R.id.alarm_btn);
        mypageBtn = (ImageView)findViewById(R.id.mypage_btn);

        myRequestFragment = new MyRequestFragment();
        makeTingFragment = new MakeTingFragment();
        alarmFragment = new AlarmFragment();
        mypageFragment = new MypageFragment();

        myRequestFragment.setContext(getApplicationContext());
        makeTingFragment.setContext(getApplicationContext());
        alarmFragment.setContext(getApplicationContext());
        mypageFragment.setContext(getApplicationContext());

        myRequestBtn.setOnClickListener(this);
        makeTingBtn.setOnClickListener(this);
        alarmBtn.setOnClickListener(this);
        mypageBtn.setOnClickListener(this);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout, myRequestFragment).commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.my_request_btn:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout, myRequestFragment).commit();
                previousBtnImgSet();
                previousBtn = 1;
                myRequestBtn.setImageResource(R.drawable.group1);
                break;

            case R.id.make_ting_btn:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout, makeTingFragment).commit();
                previousBtnImgSet();
                previousBtn = 2;
                makeTingBtn.setImageResource(R.drawable.group3);
                break;

            case R.id.alarm_btn:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout, alarmFragment).commit();
                previousBtnImgSet();
                previousBtn = 3;
                alarmBtn.setImageResource(R.drawable.group5);
                break;

            case R.id.mypage_btn:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout, mypageFragment).commit();
                previousBtnImgSet();
                previousBtn = 4;
                mypageBtn.setImageResource(R.drawable.group7);
                break;
        }
    }

    public void previousBtnImgSet(){
        switch (previousBtn){
            case 1:
                myRequestBtn.setImageResource(R.drawable.group2);
                break;

            case 2:
                makeTingBtn.setImageResource(R.drawable.group4);
                break;

            case 3:
                alarmBtn.setImageResource(R.drawable.group6);
                break;

            case 4:
                mypageBtn.setImageResource(R.drawable.group8);
                break;
        }
    }
}
