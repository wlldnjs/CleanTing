package sopt.client.cleanting.MakeTing;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.tsengvn.typekit.TypekitContextWrapper;

import java.util.ArrayList;
import java.util.StringTokenizer;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sopt.client.cleanting.Application.ApplicationController;
import sopt.client.cleanting.Network.NetworkService;
import sopt.client.cleanting.R;

public class MakeTingActivity extends AppCompatActivity implements View.OnClickListener {
    RelativeLayout selectDate1, selectTime1, selectRequest1, selectWorning1, selectCleaner1;
    LinearLayout selectDate2, selectTime2, selectRequest2, selectWorning2, selectCleaner2;
    TextView date, timeStart, timeEnd, request, warning, cleaner, amount;
    EditText warningEdit;
    ImageView requestBtn, condiBtn, windowBtn, refBtn;
    ListView listView1;
    ArrayList<String> timeData;
    ArrayAdapter arrayAdapter;
    CalendarView calendarView;
    ScrollView warningScroll;
    boolean selectCond, selectWindow, selectRef = false;
    String requsetNum = "0";
    ImageView directimg;
    NetworkService service;
    String putdate;

    @Override    //  글씨체 적용
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(TypekitContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_ting);
        service = ApplicationController.getInstance().getNetworkService();

        date = (TextView) findViewById(R.id.date_text);
        timeStart = (TextView) findViewById(R.id.time_start_text);
        timeEnd = (TextView) findViewById(R.id.time_end_text);
        request = (TextView) findViewById(R.id.request_text);
        warning = (TextView) findViewById(R.id.warning_text);
        cleaner = (TextView) findViewById(R.id.cleaner_text);
        amount = (TextView) findViewById(R.id.total_text);

        warningScroll = (ScrollView) findViewById(R.id.warning_scroll);

        calendarView = (CalendarView) findViewById(R.id.calendarview);
        warningEdit = (EditText) findViewById(R.id.warning_edit);
        requestBtn = (ImageView) findViewById(R.id.make_ting_request_btn);

        selectDate1 = (RelativeLayout) findViewById(R.id.select_date_layout1);
        selectTime1 = (RelativeLayout) findViewById(R.id.select_time_layout1);
        selectRequest1 = (RelativeLayout) findViewById(R.id.select_request_layout1);
        selectWorning1 = (RelativeLayout) findViewById(R.id.select_warning_layout1);
        selectCleaner1 = (RelativeLayout) findViewById(R.id.select_cleaner_layout1);

        selectDate2 = (LinearLayout) findViewById(R.id.select_date_layout2);
        selectTime2 = (LinearLayout) findViewById(R.id.select_time_layout2);
        selectRequest2 = (LinearLayout) findViewById(R.id.select_request_layout2);
        selectWorning2 = (LinearLayout) findViewById(R.id.select_warning_layout2);
        selectCleaner2 = (LinearLayout) findViewById(R.id.select_cleaner_layout2);

        listView1 = (ListView) findViewById(R.id.select_time_list1);

        timeData = new ArrayList<String>();
        timeData.add("08:00");
        timeData.add("08:30");
        timeData.add("09:00");
        timeData.add("09:30");
        timeData.add("10:00");
        timeData.add("10:30");
        timeData.add("11:00");
        timeData.add("11:30");
        timeData.add("12:00");
        timeData.add("12:30");
        timeData.add("13:00");
        timeData.add("13:30");

        arrayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, timeData);
        listView1.setAdapter(arrayAdapter);

        selectDate1.setOnClickListener(this);
        selectTime1.setOnClickListener(this);
        selectRequest1.setOnClickListener(this);
        selectWorning1.setOnClickListener(this);
        selectCleaner1.setOnClickListener(this);

        condiBtn = (ImageView) findViewById(R.id.make_ting_condi);
        windowBtn = (ImageView) findViewById(R.id.make_ting_window);
        refBtn = (ImageView) findViewById(R.id.make_ting_ref);

        directimg = (ImageView) findViewById(R.id.direct_img_btn);

        directimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ChooseCleanerActivity.class);
                intent.putExtra("date",putdate);
                startActivity(intent);
            }
        });

        condiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectCond == false) {
                    condiBtn.setImageResource(R.drawable.conditioner_yellow);
                    selectCond = true;
                    if (selectWindow) {
                        windowBtn.setImageResource(R.drawable.window_gray);
                        selectWindow = false;
                    } else if (selectRef) {
                        refBtn.setImageResource(R.drawable.refrigerator_gray);
                        selectRef = false;
                    }
                    request.setText("에어컨 필터청소");
                } else if (selectCond) {
                    condiBtn.setImageResource(R.drawable.conditioner_gray);
                    selectCond = false;
                    request.setText("추가사항 없음");
                }
            }
        });

        windowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectWindow == false) {
                    windowBtn.setImageResource(R.drawable.window_yellow);
                    selectWindow = true;
                    if (selectCond) {
                        condiBtn.setImageResource(R.drawable.conditioner_gray);
                        selectCond = false;
                    } else if (selectRef) {
                        refBtn.setImageResource(R.drawable.refrigerator_gray);
                        selectRef = false;
                    }
                    request.setText("창틀 청소");
                } else if (selectWindow) {
                    windowBtn.setImageResource(R.drawable.window_gray);
                    selectWindow = false;
                    request.setText("추가사항 없음");
                }
            }
        });

        refBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectRef == false) {
                    refBtn.setImageResource(R.drawable.refrigerator_yellow);
                    selectRef = true;
                    if (selectCond) {
                        condiBtn.setImageResource(R.drawable.conditioner_gray);
                        selectCond = false;
                    } else if (selectWindow) {
                        windowBtn.setImageResource(R.drawable.window_gray);
                        selectWindow = false;
                    }
                    request.setText("냉장고 정리");
                } else if (selectRef) {
                    refBtn.setImageResource(R.drawable.refrigerator_gray);
                    selectRef = false;
                    request.setText("추가사항 없음");
                }
            }
        });


        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                timeStart.setText("" + parent.getItemAtPosition(position));
                StringTokenizer st1 = new StringTokenizer(timeStart.getText().toString(),":");
                int startTimeFront = Integer.parseInt(st1.nextToken())+8;
                String startTimeEnd = st1.nextToken();
                timeEnd.setText(""+startTimeFront+":"+startTimeEnd);

            }
        });
        listView1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                listView1.requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                date.setText("" + year + "-" + (month + 1) + "-" + dayOfMonth);
            }
        });

        warningScroll.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                warningScroll.requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });

        requestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MakeTingResultData makeTingResultData = new MakeTingResultData();
                makeTingResultData.userId = "bumma";
                makeTingResultData.date = date.getText().toString();
                putdate = date.getText().toString();
                if(makeTingResultData.date.equals("선택해 주세요")){
                    Toast.makeText(MakeTingActivity.this, "청소날짜를 선택해 주세요.", Toast.LENGTH_SHORT).show();
                    return;
                }
                makeTingResultData.startTime = timeStart.getText().toString();
                if(makeTingResultData.startTime.equals("")){
                    Toast.makeText(MakeTingActivity.this, "청소 시간을 선택해 주세요.", Toast.LENGTH_SHORT).show();
                    return;
                }
                makeTingResultData.endTime = timeEnd.getText().toString();
                String priceText = amount.getText().toString();
                priceText.replace("원","");
                makeTingResultData.price = amount.getText().toString();
                makeTingResultData.cleanerId = "bumjin";
                if (request.getText().toString().equals("에어컨 필터청소")) {
                    requsetNum = "1";
                } else if (request.getText().toString().equals("창틀 청소")) {
                    requsetNum = "2";
                } else if (request.getText().toString().equals("냉장고 정리")) {
                    requsetNum = "3";
                }
                makeTingResultData.request = requsetNum;
                makeTingResultData.warning = warningEdit.getText().toString();

                Log.d("입력 유저 아이디",makeTingResultData.userId);
                Log.d("입력 날짜",makeTingResultData.date);
                Log.d("입력 시작시간",makeTingResultData.startTime);
                Log.d("입력 끝시간",makeTingResultData.endTime);
                Log.d("입력 가격",makeTingResultData.price);
                Log.d("입력 클리너 아이디",makeTingResultData.cleanerId);
                Log.d("입력 추가요청",makeTingResultData.request);
                Log.d("입력 경고",makeTingResultData.warning);

                Call<MakeTingResult> makeTingResultCall = service.getMakeTingResult(makeTingResultData);
                makeTingResultCall.enqueue(new Callback<MakeTingResult>() {
                    @Override
                    public void onResponse(Call<MakeTingResult> call, Response<MakeTingResult> response) {
                        if (response.isSuccessful()) {
                            Toast.makeText(MakeTingActivity.this, "팅 생성 완료", Toast.LENGTH_SHORT).show();

                            finish();
                        } else {
                            Toast.makeText(MakeTingActivity.this, "실패", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<MakeTingResult> call, Throwable t) {
                        Toast.makeText(MakeTingActivity.this, "인터넷 연결 상태를 확인해 주세요.", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.select_date_layout1:
                if (selectDate2.getVisibility() == View.GONE) {
                    selectDate2.setVisibility(View.VISIBLE);
                } else {
                    selectDate2.setVisibility(View.GONE);
                }
                break;
            case R.id.select_time_layout1:
                if (selectTime2.getVisibility() == View.GONE) {
                    selectTime2.setVisibility(View.VISIBLE);
                } else {
                    selectTime2.setVisibility(View.GONE);
                }
                break;
            case R.id.select_request_layout1:
                if (selectRequest2.getVisibility() == View.GONE) {
                    selectRequest2.setVisibility(View.VISIBLE);
                } else {
                    selectRequest2.setVisibility(View.GONE);
                }
                break;
            case R.id.select_warning_layout1:
                if (selectWorning2.getVisibility() == View.GONE) {
                    selectWorning2.setVisibility(View.VISIBLE);
                } else {
                    selectWorning2.setVisibility(View.GONE);
                    warning.setText(warningEdit.getText().toString());
                }
                break;
            case R.id.select_cleaner_layout1:
                if (selectCleaner2.getVisibility() == View.GONE) {
                    selectCleaner2.setVisibility(View.VISIBLE);
                } else {
                    selectCleaner2.setVisibility(View.GONE);
                }
                break;
        }
    }
}
