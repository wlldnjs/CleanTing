package sopt.client.cleanting.MakeTing.CleanerDetail;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sopt.client.cleanting.Application.ApplicationController;
import sopt.client.cleanting.Cleanner.CleanerReviewData;
import sopt.client.cleanting.Cleanner.SearchCleanerDetailResult;
import sopt.client.cleanting.Network.NetworkService;
import sopt.client.cleanting.R;

public class DetailCleanerActivity extends AppCompatActivity {

    private RecyclerView ReviewRrecyclerView;
    private ArrayList<ReviewItem> reviewItems;
    private ReviewRecyclerAdapter ReviewrecyclerAdapter;
    private LinearLayoutManager layoutManager4;

    ImageView imageView;
    NetworkService service;

    TextView Creviewnum;
    TextView Ccareer;
    TextView Cage;
    TextView Cname;
    TextView ratenum;

    ImageView dstar1;
    ImageView dstar2;
    ImageView dstar3;
    ImageView dstar4;
    ImageView dstar5;

    ArrayList<CleanerReviewData> cleanerReviewDatas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_cleaner);

        service = ApplicationController.getInstance().getNetworkService();

        Creviewnum = (TextView)findViewById(R.id.review_tv);
        Ccareer = (TextView)findViewById(R.id.career_tv);
        Cage = (TextView)findViewById(R.id.age_tv);
        Cname = (TextView)findViewById(R.id.cleanername_tv);
        ratenum = (TextView)findViewById(R.id.rateNum);

        dstar1 = (ImageView)findViewById(R.id.D_star1);
        dstar2 = (ImageView)findViewById(R.id.D_star2);
        dstar3 = (ImageView)findViewById(R.id.D_star3);
        dstar4 = (ImageView)findViewById(R.id.D_star4);
        dstar5 = (ImageView)findViewById(R.id.D_star5);

        cleanerReviewDatas = new ArrayList<>();

        String cleanerid = getIntent().getStringExtra("cleanerid");
        Call<SearchCleanerDetailResult> searchCleanerDetailResultCall = service.getSearchCleanerDetailResult("hwang"); //cleanerid
        searchCleanerDetailResultCall.enqueue(new Callback<SearchCleanerDetailResult>() {
            @Override
            public void onResponse(Call<SearchCleanerDetailResult> call, Response<SearchCleanerDetailResult> response) {
                if(response.isSuccessful())
                {
                    Cname.setText(response.body().result.cleaner.name+" 클리너");

                    cleanerReviewDatas = response.body().result.review;

                    Creviewnum.setText("리뷰 : " + response.body().result.cleaner.review_cnt + "건");
                    Cage.setText("나이 : " + response.body().result.cleaner.age + "세");
                    Ccareer.setText("경력 : " + response.body().result.cleaner.career + "개월");
                    ratenum.setText(response.body().result.cleaner.review_cnt + "명");
                    if(response.body().result.cleaner.rate.equals("0"));
                    {
                        dstar1.setImageResource(R.drawable.star_line);
                        dstar2.setImageResource(R.drawable.star_line);
                        dstar3.setImageResource(R.drawable.star_line);
                        dstar4.setImageResource(R.drawable.star_line);
                        dstar5.setImageResource(R.drawable.star_line);
                    }
                    if(response.body().result.cleaner.rate.equals("1"))
                    {
                        dstar2.setImageResource(R.drawable.star_line);
                        dstar3.setImageResource(R.drawable.star_line);
                        dstar4.setImageResource(R.drawable.star_line);
                        dstar5.setImageResource(R.drawable.star_line);
                    }
                    if(response.body().result.cleaner.rate.equals("2"))
                    {
                        dstar3.setImageResource(R.drawable.star_line);
                        dstar4.setImageResource(R.drawable.star_line);
                        dstar5.setImageResource(R.drawable.star_line);
                    }
                    if(response.body().result.cleaner.rate.equals("3"))
                    {
                        dstar4.setImageResource(R.drawable.star_line);
                        dstar5.setImageResource(R.drawable.star_line);
                    }
                    if(response.body().result.cleaner.rate.equals("4"))
                    {
                        dstar5.setImageResource(R.drawable.star_line);
                    }
                }
            }

            @Override
            public void onFailure(Call<SearchCleanerDetailResult> call, Throwable t) {

            }
        });

        imageView = (ImageView)findViewById(R.id.Choose);

        //////////////////////////////////////////////////////  리뷰 부분 ///////////////////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////

        ReviewRrecyclerView = (RecyclerView)findViewById(R.id.Review_recyclerview);
        ReviewRrecyclerView.setHasFixedSize(true);
        layoutManager4 = new LinearLayoutManager(this);
        layoutManager4.setOrientation(LinearLayoutManager.VERTICAL);             //리니어레이아웃의 형태이면 방향은 수직
        ReviewRrecyclerView.setLayoutManager(layoutManager4);                           //리사이클러뷰에 레이아웃매니저를 달아준다

        ReviewrecyclerAdapter = new ReviewRecyclerAdapter(cleanerReviewDatas);
        ReviewRrecyclerView.setAdapter(ReviewrecyclerAdapter);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext()," 팅만들기 가서 클리너 이름 띄우기",Toast.LENGTH_SHORT).show();
            }
        });

    }
}
