package sopt.client.cleanting.MyRequest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sopt.client.cleanting.Application.ApplicationController;
import sopt.client.cleanting.Cleanner.CleanerData;
import sopt.client.cleanting.Cleanner.SearchCleanerDetailResult;
import sopt.client.cleanting.Network.NetworkService;
import sopt.client.cleanting.R;

import static sopt.client.cleanting.Main.MainActivity.REQUEST_MODIFY_TING;

public class MyRequestDetailActivity extends AppCompatActivity {
    ImageView man1, man2, man3, cleanerImg, star1, star2, star3, star4, star5, callBtn,
            editBtn, cancelBtn;
    TextView manCount, starCount, name,  act, review, career, age, date, time, moreRequest, warning, total;
    String tingId, cleanerId, userId, request, cnt, phone, area, rate, cleanerImgSrc;
    NetworkService service;
    CleanerData cleanerData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_request_detail);
        service = ApplicationController.getInstance().getNetworkService();

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

        cleanerId = getIntent().getStringExtra("cleanerId");
        Call<SearchCleanerDetailResult> searchCleanerDetailResultCall = service.getSearchCleanerDetailResult("bumjin");
        searchCleanerDetailResultCall.enqueue(new Callback<SearchCleanerDetailResult>() {
            @Override
            public void onResponse(Call<SearchCleanerDetailResult> call, Response<SearchCleanerDetailResult> response) {
                if(response.isSuccessful()){
                    Toast.makeText(MyRequestDetailActivity.this, "성공", Toast.LENGTH_SHORT).show();
                    cleanerData = response.body().result.cleaner;
                    age.setText("나이: " +cleanerData.age);
                    name.setText(cleanerData.name +" 클리너");
                    phone = cleanerData.phone;
                    career.setText("경력: " +cleanerData.career +"개월");
                    area = cleanerData.area;
                    rate = cleanerData.rate;
                    if(rate.equals("4")){
                        star5.setImageResource(R.drawable.star_line);
                    } else if(rate.equals("3")){
                        star5.setImageResource(R.drawable.star_line);
                        star4.setImageResource(R.drawable.star_line);
                    } else if(rate.equals("2")){
                        star5.setImageResource(R.drawable.star_line);
                        star4.setImageResource(R.drawable.star_line);
                        star3.setImageResource(R.drawable.star_line);
                    } else if(rate.equals("1")){
                        star5.setImageResource(R.drawable.star_line);
                        star4.setImageResource(R.drawable.star_line);
                        star3.setImageResource(R.drawable.star_line);
                        star2.setImageResource(R.drawable.star_line);
                    } else if(rate.equals("0")){
                        star5.setImageResource(R.drawable.star_line);
                        star4.setImageResource(R.drawable.star_line);
                        star3.setImageResource(R.drawable.star_line);
                        star2.setImageResource(R.drawable.star_line);
                        star1.setImageResource(R.drawable.star_line);
                    }
                    starCount.setText(cleanerData.review_cnt +"명");
                    review.setText("리뷰 " +cleanerData.review_cnt +"회");
                    Glide.with(getApplicationContext()).load(cleanerData.image).into(cleanerImg);
                } else {
                    Toast.makeText(MyRequestDetailActivity.this, "통신 실패", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<SearchCleanerDetailResult> call, Throwable t) {
                Toast.makeText(MyRequestDetailActivity.this, "서버상태 확인", Toast.LENGTH_SHORT).show();
                t.printStackTrace();
            }
        });

        tingId = getIntent().getStringExtra("tingId");
        userId = getIntent().getStringExtra("userId");
        total.setText(getIntent().getStringExtra("price"));
        request = getIntent().getStringExtra("request");
        if(request.equals("0")){
            moreRequest.setText("추가사항 없음");
        } else if(request.equals("1")){
            moreRequest.setText("에어컨 필터 청소");
        } else if(request.equals("2")){
            moreRequest.setText("창틀 청소");
        } else if(request.equals("3")){
            moreRequest.setText("냉장고 정리");
        }
        warning.setText(getIntent().getStringExtra("warning"));
        date.setText(getIntent().getStringExtra("date"));
        time.setText(getIntent().getStringExtra("time"));
        cnt = getIntent().getStringExtra("cnt");
        manCount.setText(cnt+"명/3명");
        if(cnt.equals("2")){
            man1.setImageResource(R.drawable.man_line);
        } else if(cnt.equals("1")){
            man1.setImageResource(R.drawable.man_line);
            man2.setImageResource(R.drawable.man_line);
        }

        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ChangeMyRequestDetail.class);
                intent.putExtra("tingId",tingId);
                intent.putExtra("cleanerId",cleanerId);
                intent.putExtra("userId",userId);
                intent.putExtra("price",getIntent().getStringExtra("price"));
                intent.putExtra("request",request);
                intent.putExtra("date",date.getText().toString());
                intent.putExtra("time",time.getText().toString());
                intent.putExtra("cnt",cnt);
                intent.putExtra("cleanerData",cleanerData);
                startActivityForResult(intent, REQUEST_MODIFY_TING);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            finish();
        }
    }
}
