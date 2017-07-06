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

import com.bumptech.glide.Glide;
import com.tsengvn.typekit.TypekitContextWrapper;

import java.util.ArrayList;
import java.util.StringTokenizer;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sopt.client.cleanting.Application.ApplicationController;
import sopt.client.cleanting.Cleanner.SearchCleanerDetailResult;
import sopt.client.cleanting.Cleanner.SearchLocationCleanerData;
import sopt.client.cleanting.Cleanner.SearchLocationCleanerResult;
import sopt.client.cleanting.Cleanner.SendSearchLocationCleanerData;
import sopt.client.cleanting.MakeTing.CleanerDetail.DetailCleanerActivity;
import sopt.client.cleanting.Network.NetworkService;
import sopt.client.cleanting.R;

import static sopt.client.cleanting.Main.Login.LoginActivity.loginUserDatas;
import static sopt.client.cleanting.Main.MainActivity.REQUEST_SELECT_CLEANER;

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
    ImageView star1, star2, star3, star4, star5, cleanerImg;
    TextView cleanText, cleanerName, ratingCnt, activity, review, career, age, commentBtn, location;
    String cleanerId;
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
        location = (TextView) findViewById(R.id.make_ting_location);
        location.setText(loginUserDatas.address);

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

        // 클리너 정보
        star1 = (ImageView)findViewById(R.id.make_ting_star1);
        star2 = (ImageView)findViewById(R.id.make_ting_star2);
        star3 = (ImageView)findViewById(R.id.make_ting_star3);
        star4 = (ImageView)findViewById(R.id.make_ting_star4);
        star5 = (ImageView)findViewById(R.id.make_ting_star5);
        cleanerImg = (ImageView)findViewById(R.id.make_ting_cleaner_img);

        cleanText = (TextView)findViewById(R.id.cleaner_text);
        cleanerName = (TextView)findViewById(R.id.make_ting_cleaner_name);
        ratingCnt = (TextView)findViewById(R.id.make_ting_rate_count);
        activity = (TextView)findViewById(R.id.make_ting_actity);
        review = (TextView)findViewById(R.id.make_ting_review);
        career = (TextView)findViewById(R.id.make_ting_career);
        age = (TextView)findViewById(R.id.make_ting_age);
        commentBtn = (TextView)findViewById(R.id.make_ting_cleaner_comment);

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

        arrayAdapter = new ArrayAdapter(getApplicationContext(),R.layout.timelist, timeData);

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
                intent.putExtra("date",date.getText().toString());
                startActivityForResult(intent,REQUEST_SELECT_CLEANER);
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
                SendSearchLocationCleanerData sendSearchLocationCleanerData = new SendSearchLocationCleanerData();
                sendSearchLocationCleanerData.userId = loginUserDatas.userId;
                sendSearchLocationCleanerData.order = "1";
                sendSearchLocationCleanerData.userLat = loginUserDatas.lat;
                sendSearchLocationCleanerData.userLng = loginUserDatas.lng;
                Call<SearchLocationCleanerResult> searchLocationCleanerResultCall = service.getSearchLocationCleanerResult(date.getText().toString(),sendSearchLocationCleanerData);
                searchLocationCleanerResultCall.enqueue(new Callback<SearchLocationCleanerResult>() {
                    @Override
                    public void onResponse(Call<SearchLocationCleanerResult> call, Response<SearchLocationCleanerResult> response) {
                        if(response.isSuccessful()){
                            if(response.body().result == null){
                                Toast.makeText(MakeTingActivity.this, "현 지역 클리너가 없습니다.", Toast.LENGTH_SHORT).show();
                            } else {
                                SearchLocationCleanerData cleanerData = response.body().result.get(0);
                                cleanerId = cleanerData.cleanerId;
                                Toast.makeText(MakeTingActivity.this, cleanerData.cleanerId, Toast.LENGTH_SHORT).show();
                                String rate = cleanerData.rate;
                                String cnt = cleanerData.review_cnt;
                                int rating = Integer.parseInt(rate)/Integer.parseInt(cnt);
                                if(rating <= 0.5){
                                    star2.setImageResource(R.drawable.star_line);
                                    star3.setImageResource(R.drawable.star_line);
                                    star4.setImageResource(R.drawable.star_line);
                                    star5.setImageResource(R.drawable.star_line);
                                } else if(rating <=1.5){
                                    star3.setImageResource(R.drawable.star_line);
                                    star4.setImageResource(R.drawable.star_line);
                                    star5.setImageResource(R.drawable.star_line);
                                } else if (rating <=2.5){
                                    star3.setImageResource(R.drawable.star_line);
                                    star4.setImageResource(R.drawable.star_line);
                                    star5.setImageResource(R.drawable.star_line);
                                } else if (rating <= 3.5){
                                    star4.setImageResource(R.drawable.star_line);
                                    star5.setImageResource(R.drawable.star_line);
                                } else if(rating <= 4.5){
                                    star5.setImageResource(R.drawable.star_line);
                                }
                                Glide.with(getApplicationContext()).load(cleanerData.image).into(cleanerImg);
                                cleanText.setText(cleanerData.name +" 클리너");
                                cleanerName.setText(cleanerData.name +" 클리너");
                                ratingCnt.setText(cleanerData.review_cnt +"명");
                                activity.setText("경력 : " +cleanerData.review_cnt+"건");
                                review.setText("리뷰 : "+cleanerData.review_cnt +"회");
                                career.setText("경력 : "+cleanerData.career +"개월");
                                age.setText("나이 : " +cleanerData.age);
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<SearchLocationCleanerResult> call, Throwable t) {

                    }
                });
            }
        });

        commentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cleanerId != null){
                    Intent intent = new Intent(MakeTingActivity.this, DetailCleanerActivity.class);
                    intent.putExtra("cleanerid", cleanerId);
                    intent.putExtra("review","ok");
                    startActivity(intent);
                }
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
                makeTingResultData.userId = loginUserDatas.userId;
                makeTingResultData.date = date.getText().toString();
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            Toast.makeText(this, getIntent().getStringExtra("cleanerId"), Toast.LENGTH_SHORT).show();
            if(requestCode == REQUEST_SELECT_CLEANER){
                cleanerId = data.getStringExtra("cleanerId");
                refreshCleaner();
            }
        }
    }

    private void refreshCleaner(){
        Call<SearchCleanerDetailResult> searchCleanerDetailResultCall = service.getSearchCleanerDetailResult(cleanerId);
        searchCleanerDetailResultCall.enqueue(new Callback<SearchCleanerDetailResult>() {
            @Override
            public void onResponse(Call<SearchCleanerDetailResult> call, Response<SearchCleanerDetailResult> response) {
                if(response.isSuccessful()){
                    cleanText.setText(response.body().result.cleaner.name);
                    cleanerName.setText(response.body().result.cleaner.name);
                    Glide.with(getApplicationContext()).load(response.body().result.cleaner.image).into(cleanerImg);
                    String rate = response.body().result.cleaner.rate;
                    String cnt = response.body().result.cleaner.review_cnt;
                    int rating = 0;
                    if(!rate.equals("0") && !cnt.equals("0")){
                        rating = Integer.parseInt(rate)/Integer.parseInt(cnt);
                    }

                    if(rating <= 1){
                        star2.setImageResource(R.drawable.star_line);
                        star3.setImageResource(R.drawable.star_line);
                        star4.setImageResource(R.drawable.star_line);
                        star5.setImageResource(R.drawable.star_line);
                    } else if(rating <=1.5){
                        star3.setImageResource(R.drawable.star_line);
                        star4.setImageResource(R.drawable.star_line);
                        star5.setImageResource(R.drawable.star_line);
                    } else if (rating <=2.5){
                        star3.setImageResource(R.drawable.star_line);
                        star4.setImageResource(R.drawable.star_line);
                        star5.setImageResource(R.drawable.star_line);
                    } else if (rating <= 3.5){
                        star4.setImageResource(R.drawable.star_line);
                        star5.setImageResource(R.drawable.star_line);
                    } else if(rating <= 4.5){
                        star5.setImageResource(R.drawable.star_line);
                    }
                    Glide.with(getApplicationContext()).load(response.body().result.cleaner.image).into(cleanerImg);
                    cleanText.setText(response.body().result.cleaner.name +" 클리너");
                    cleanerName.setText(response.body().result.cleaner.name +" 클리너");
                    ratingCnt.setText(response.body().result.cleaner.review_cnt +"명");
                    activity.setText("경력 : " +response.body().result.cleaner.review_cnt+"건");
                    review.setText("리뷰 : "+response.body().result.cleaner.review_cnt +"회");
                    career.setText("경력 : "+response.body().result.cleaner.career +"개월");
                    age.setText("나이 : " +response.body().result.cleaner.age);

                }
            }

            @Override
            public void onFailure(Call<SearchCleanerDetailResult> call, Throwable t) {

            }
        });
    }
}