package sopt.client.cleanting.Community;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import sopt.client.cleanting.R;

public class CommunitySearchActivity extends AppCompatActivity {

    ImageView searchimg;
    EditText search_edit;
    RecyclerView SearchRecyclerView;
    ImageView imgview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community_search);

        SearchRecyclerView = (RecyclerView)findViewById(R.id.Search_bulletin_Recyclerview);
        searchimg = (ImageView)findViewById(R.id.Bulletin_search_img);
        imgview = (ImageView)findViewById(R.id.center_img);

        searchimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"검색하기",Toast.LENGTH_SHORT).show();
                SearchRecyclerView.setVisibility(View.VISIBLE);
                imgview.setVisibility(View.INVISIBLE);
            }
        });

    }
}
