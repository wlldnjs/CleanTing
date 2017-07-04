package sopt.client.cleanting.Community;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sopt.client.cleanting.Application.ApplicationController;
import sopt.client.cleanting.Network.NetworkService;
import sopt.client.cleanting.R;

public class CommunityWriteActivity extends AppCompatActivity {

    EditText BulletinInputTitle;
    EditText BulletinInputContent;
    ImageView BulletinInputComplete;

    NetworkService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community_write);

        service = ApplicationController.getInstance().getNetworkService();

        BulletinInputTitle = (EditText)findViewById(R.id.Bulletin_input_titile);
        BulletinInputContent = (EditText)findViewById(R.id.Bulletin_input_content);
        BulletinInputComplete = (ImageView)findViewById(R.id.Bulletin_input_complete);

        BulletinInputComplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Btitle = BulletinInputTitle.getText().toString();
                String Bcontent = BulletinInputContent.getText().toString();
                String Buserid = "bumma";
                //   서버한테 데이터 보내기
                BulletinAddPostData bulletinAddPostData = new BulletinAddPostData();
//                bulletinAddPostData = new BulletinAddPostData();
                bulletinAddPostData.userId = Buserid;
                bulletinAddPostData.title = Btitle;
                bulletinAddPostData.content = Bcontent;
                bulletinAddPostData.locationNum = 1;

                Call<BulletinAddPostResult> bulletinAddPostResultCall  = service.getBulletinAddPostResult(bulletinAddPostData);
                bulletinAddPostResultCall.enqueue(new Callback<BulletinAddPostResult>()
                {
                    @Override
                    public void onResponse(Call<BulletinAddPostResult> call, Response<BulletinAddPostResult> response) {
                        if(response.isSuccessful())
                        {
                            if(response.body().message.equals("Succeed in writing a post"))
                            {
                                Toast.makeText(getApplicationContext(),"게시글 등록 성공",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent();
                                setResult(RESULT_OK);
                                finish();
                            } else {
                                Toast.makeText(CommunityWriteActivity.this, response.body().message, Toast.LENGTH_SHORT).show();
                            }
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(),"dkfjgldkf",Toast.LENGTH_SHORT);
                        }
                    }
                    @Override
                    public void onFailure(Call<BulletinAddPostResult> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),"서버에러",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }
}
