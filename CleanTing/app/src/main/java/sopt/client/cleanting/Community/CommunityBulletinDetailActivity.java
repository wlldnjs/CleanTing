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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import sopt.client.cleanting.Community.Reply.ReplyData;
import sopt.client.cleanting.Community.Reply.ReplyRecyclerViewAdapter;
import sopt.client.cleanting.R;

public class CommunityBulletinDetailActivity extends AppCompatActivity {

    ImageView send;

    private RecyclerView recyclerView;
    private ArrayList<ReplyData> itemdata;
    private ReplyRecyclerViewAdapter replyRecyclerViewAdapter;
    private LinearLayoutManager layoutManager;
    BulletinPostData postData;
    ArrayList<BulletinCommentData> commentDatas;
    EditText inputReplyEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community_bulletin_detail);

        Intent intent = getIntent();
        postData = new BulletinPostData();
        postData = (BulletinPostData)intent.getSerializableExtra("post");
        commentDatas = new ArrayList<>();
        commentDatas = (ArrayList<BulletinCommentData>)intent.getSerializableExtra("comment");

        send = (ImageView)findViewById(R.id.sendimg);
        inputReplyEdit = (EditText)findViewById(R.id.inputReplyEdit);

        recyclerView = (RecyclerView)findViewById(R.id.ReplyRecyclerview);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

//        itemdata = new ArrayList<ReplyData>();
//        itemdata.add(new ReplyData("오 나도 살래","2015.05. 01"));
//        itemdata.add(new ReplyData("오 나도 살래","2015.05. 01"));
//        itemdata.add(new ReplyData("오 나도 살래","2015.05. 01"));
//        itemdata.add(new ReplyData("오 나도 살래","2015.05. 01"));
//        itemdata.add(new ReplyData("오 나도 살래","2015.05. 01"));
//        itemdata.add(new ReplyData("오 나도 살래","2015.05. 01"));
//        itemdata.add(new ReplyData("오 나도 살래","2015.05. 01"));
//        itemdata.add(new ReplyData("오 나도 살래","2015.05. 01"));
//        itemdata.add(new ReplyData("오 나도 살래","2015.05. 01"));
//        itemdata.add(new ReplyData("오 나도 살래","2015.05. 01"));

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = inputReplyEdit.getText().toString();
                String time = new SimpleDateFormat("yyyy/MM/dd HH:mm").format(new Date(System.currentTimeMillis()));
                itemdata.add(0,new ReplyData(str,time));
                replyRecyclerViewAdapter.notifyDataSetChanged();
                inputReplyEdit.setText("");
                Toast.makeText(getApplicationContext(),"댓글 등록",Toast.LENGTH_SHORT).show();
            }
        });
        replyRecyclerViewAdapter = new ReplyRecyclerViewAdapter(itemdata,getApplicationContext(),postData,commentDatas);
        recyclerView.setAdapter(replyRecyclerViewAdapter);
        replyRecyclerViewAdapter.notifyDataSetChanged();

    }
}
