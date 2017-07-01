package sopt.client.cleanting.Community;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import sopt.client.cleanting.R;

public class CommunityBulletinDetailActivity extends AppCompatActivity {

    ImageView send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community_bulletin_detail);

        send = (ImageView)findViewById(R.id.sendimg);

    }
}
