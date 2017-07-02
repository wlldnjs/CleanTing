package sopt.client.cleanting.Community;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import sopt.client.cleanting.R;

public class CommunityFilterActivity extends AppCompatActivity {

    private RecyclerView CFrecyclerView;
    private ArrayList<Bulletin> bulletinArrayList;
    private BulletinListRecylerAdapter BrecyclerAdapter;
    private LinearLayoutManager layoutManager2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community_filter);

        CFrecyclerView = (RecyclerView)findViewById(R.id.CommunityFilterRecyclerView);
        CFrecyclerView.setHasFixedSize(true);

        layoutManager2 = new LinearLayoutManager(this);
        layoutManager2.setOrientation(LinearLayoutManager.VERTICAL);             //리니어레이아웃의 형태이면 방향은 수직
        CFrecyclerView.setLayoutManager(layoutManager2);

        bulletinArrayList = new ArrayList<Bulletin>();                         //사용자 정의 데이터를 갖는 arraylist
        bulletinArrayList.add(new Bulletin("쌀 사러 갈 사람", "2015.05.10","저기 어디에 진짜로 싸게 판대 가자","12"));
        bulletinArrayList.add(new Bulletin("쌀 사러 갈 사람", "2015.05.10","저기 어디에 진짜로 싸게 판대 가자","12"));
        bulletinArrayList.add(new Bulletin("쌀 사러 갈 사람", "2015.05.10","저기 어디에 진짜로 싸게 판대 가자","12"));
        bulletinArrayList.add(new Bulletin("쌀 사러 갈 사람", "2015.05.10","저기 어디에 진짜로 싸게 판대 가자","12"));
        bulletinArrayList.add(new Bulletin("쌀 사러 갈 사람", "2015.05.10","저기 어디에 진짜로 싸게 판대 가자","12"));
        bulletinArrayList.add(new Bulletin("제목", "날짜","사러가자","12"));
        bulletinArrayList.add(new Bulletin("제목", "날짜","사러가자","12"));
        bulletinArrayList.add(new Bulletin("제목", "날짜","사러가자","12"));

        BrecyclerAdapter = new BulletinListRecylerAdapter(bulletinArrayList,clickEvent2);
        CFrecyclerView.setAdapter(BrecyclerAdapter);
    }
    public View.OnClickListener clickEvent2 = new View.OnClickListener() {
        public void onClick(View v) {
            final int itemPosition = CFrecyclerView.getChildPosition(v);           //position 을 지원하지 않는다 따라서 직접 얻어와야함

            Intent intent = new Intent(getApplicationContext(),CommunityBulletinDetailActivity.class);
            startActivity(intent);
            Toast.makeText(getApplicationContext(),itemPosition + "번 리스트 클릭!!", Toast.LENGTH_SHORT).show();
        }
    };
}
