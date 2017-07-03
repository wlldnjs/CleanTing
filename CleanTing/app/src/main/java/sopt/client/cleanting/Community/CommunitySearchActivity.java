package sopt.client.cleanting.Community;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sopt.client.cleanting.Network.NetworkService;
import sopt.client.cleanting.R;

public class CommunitySearchActivity extends AppCompatActivity {

    ImageView searchimg;
    EditText search_edit;
    RecyclerView SearchRecyclerView;
    ImageView imgview;
    NetworkService service;

    private RecyclerView BrecyclerView;
    private ArrayList<Bulletin> bulletinArrayList;
    private BulletinListRecylerAdapter BrecyclerAdapter;
    private LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community_search);

        searchimg = (ImageView)findViewById(R.id.Bulletin_search_img);
        imgview = (ImageView)findViewById(R.id.center_img);
        search_edit = (EditText)findViewById(R.id.editText);

        SearchRecyclerView = (RecyclerView)findViewById(R.id.Search_bulletin_Recyclerview);
        SearchRecyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);             //리니어레이아웃의 형태이면 방향은 수직
        SearchRecyclerView.setLayoutManager(layoutManager);

        searchimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"검색하기",Toast.LENGTH_SHORT).show();
                SearchRecyclerView.setVisibility(View.VISIBLE);
                imgview.setVisibility(View.INVISIBLE);

                String str = search_edit.getText().toString();
                // 서버한테 보내기

                Call<SearchBulletinResult> searchBulletinResultCall = service.getSearchBulletinResult(str);
                searchBulletinResultCall.enqueue(new Callback<SearchBulletinResult>() {
                    @Override
                    public void onResponse(Call<SearchBulletinResult> call, Response<SearchBulletinResult> response) {
                        if(response.isSuccessful())
                        {
                            if(response.body().message.equals("pwd update ok")){
                                Toast.makeText(getApplicationContext(),"비밀번호 변경에 성공했습니다.", Toast.LENGTH_SHORT).show();
                                finish();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<SearchBulletinResult> call, Throwable t) {

                    }
                });

                // 받고

//                BrecyclerAdapter = new BulletinListRecylerAdapter(bulletinArrayList,clickEvent);
//                SearchRecyclerView.setAdapter(BrecyclerAdapter);
            }
        });

    }
    public View.OnClickListener clickEvent = new View.OnClickListener() {
        public void onClick(View v) {
            final int itemPosition = BrecyclerView.getChildPosition(v);           //position 을 지원하지 않는다 따라서 직접 얻어와야함
            Intent intent = new Intent(getApplicationContext(),CommunityBulletinDetailActivity.class);
            startActivity(intent);
        }
    };
}
