package sopt.client.cleanting.Community;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import sopt.client.cleanting.R;

public class CommunityWriteActivity extends AppCompatActivity {

    EditText BulletinInputTitle;
    EditText BulletinInputContent;
    ImageView BulletinInputComplete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community_write);

        BulletinInputTitle = (EditText)findViewById(R.id.Bulletin_input_titile);
        BulletinInputContent = (EditText)findViewById(R.id.Bulletin_input_content);
        BulletinInputComplete = (ImageView)findViewById(R.id.Bulletin_input_complete);

        BulletinInputComplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Btitle = BulletinInputTitle.getText().toString();
                String Bcontent = BulletinInputContent.getText().toString();

                //   서버한테 데이터 보내기

                finish();
                Toast.makeText(getApplicationContext(),"게시글이 등록되었습니다.",Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }
}
