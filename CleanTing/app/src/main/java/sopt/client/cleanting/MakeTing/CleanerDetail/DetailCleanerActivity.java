package sopt.client.cleanting.MakeTing.CleanerDetail;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

import sopt.client.cleanting.R;

public class DetailCleanerActivity extends AppCompatActivity {

    private RecyclerView ReviewRrecyclerView;
    private ArrayList<ReviewItem> reviewItems;
    private ReviewRecyclerAdapter ReviewrecyclerAdapter;
    private LinearLayoutManager layoutManager4;

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_cleaner);

        imageView = (ImageView)findViewById(R.id.Choose);

        ReviewRrecyclerView = (RecyclerView)findViewById(R.id.Review_recyclerview);
        ReviewRrecyclerView.setHasFixedSize(true);

        layoutManager4 = new LinearLayoutManager(this);
        layoutManager4.setOrientation(LinearLayoutManager.VERTICAL);             //리니어레이아웃의 형태이면 방향은 수직
        ReviewRrecyclerView.setLayoutManager(layoutManager4);                           //리사이클러뷰에 레이아웃매니저를 달아준다

        reviewItems = new ArrayList<ReviewItem>();                         //사용자 정의 데이터를 갖는 arraylist
        reviewItems.add(new ReviewItem("이름1","2015-07-15","정말정말 좋아요"));
        reviewItems.add(new ReviewItem("이름2","2015-07-15","정말정말 좋아요"));
        reviewItems.add(new ReviewItem("이름3","2015-07-15","정말정말 좋아요"));
        reviewItems.add(new ReviewItem("이름3","2015-07-15","정말정말 좋아요"));
        reviewItems.add(new ReviewItem("이름3","2015-07-15","정말정말 좋아요"));
        reviewItems.add(new ReviewItem("이름3","2015-07-15","정말정말 좋아요"));
        reviewItems.add(new ReviewItem("이름3","2015-07-15","정말정말 좋아요"));
        reviewItems.add(new ReviewItem("이름3","2015-07-15","정말정말 좋아요"));
        reviewItems.add(new ReviewItem("이름3","2015-07-15","정말정말 좋아요"));
        reviewItems.add(new ReviewItem("이름3","2015-07-15","정말정말 좋아요"));

        ReviewrecyclerAdapter = new ReviewRecyclerAdapter(reviewItems);
        ReviewRrecyclerView.setAdapter(ReviewrecyclerAdapter);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext()," 팅만들기 가서 클리너 이름 띄우기",Toast.LENGTH_SHORT).show();
            }
        });

    }
}
