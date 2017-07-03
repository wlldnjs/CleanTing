package sopt.client.cleanting.Mypage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sopt.client.cleanting.Application.ApplicationController;
import sopt.client.cleanting.Network.NetworkService;
import sopt.client.cleanting.R;

import static sopt.client.cleanting.Main.Login.LoginActivity.loginUserDatas;

public class ChangeInfoActivity extends AppCompatActivity {

    private CustomDialog2 mCustomDialog2;
    ImageView changephone;
    Button changeimg;
    NetworkService service;

    EditText password1,password2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_info);
        service = ApplicationController.getInstance().getNetworkService();

        changephone = (ImageView)findViewById(R.id.changeimg);
        changeimg = (Button)findViewById(R.id.change_img);

        password1 = (EditText)findViewById(R.id.password1);
        password2 = (EditText)findViewById(R.id.password2);
        changeimg.setOnClickListener(new View.OnClickListener() {       // 수정하기
            @Override
            public void onClick(View v) {
                if(password1.equals(password2)){
                    Call<ModifyPasswordResult> modifyPasswordResultCall = service.getModifyPasswordResult(loginUserDatas.userId,password1.getText().toString());
                    modifyPasswordResultCall.enqueue(new Callback<ModifyPasswordResult>() {
                        @Override
                        public void onResponse(Call<ModifyPasswordResult> call, Response<ModifyPasswordResult> response) {
                            if (response.isSuccessful()){
                                if(response.body().message.equals("pwd update ok")){
                                    Toast.makeText(ChangeInfoActivity.this, "비밀번호 변경에 성공했습니다.", Toast.LENGTH_SHORT).show();
                                    finish();
                                }
                            } else {
                                Toast.makeText(ChangeInfoActivity.this, response.body().message, Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<ModifyPasswordResult> call, Throwable t) {
                            Toast.makeText(ChangeInfoActivity.this, "서버 연결 상태를 확인해주세요.", Toast.LENGTH_SHORT).show();
                        }
                    });
                }

            }
        });

    }
    private View.OnClickListener leftListener = new View.OnClickListener() {
        public void onClick(View v) {
            mCustomDialog2.dismiss();
        }
    };

    private View.OnClickListener rightListener = new View.OnClickListener() {
        public void onClick(View v) {
            Toast.makeText(getApplicationContext(),"정상적으로 변경.",
                    Toast.LENGTH_SHORT).show();
            mCustomDialog2.dismiss();
        }
    };

    public void changeDialog(View view)
    {
        mCustomDialog2 = new CustomDialog2(this,
                leftListener, // 왼쪽 버튼 이벤트
                rightListener); // 오른쪽 버튼 이벤트
        mCustomDialog2.show();
    }
}
