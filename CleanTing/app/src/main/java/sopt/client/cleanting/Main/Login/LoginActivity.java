package sopt.client.cleanting.Main.Login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;
import com.tsengvn.typekit.TypekitContextWrapper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sopt.client.cleanting.Application.ApplicationController;
import sopt.client.cleanting.Main.LoginUserDatas;
import sopt.client.cleanting.Main.MainActivity;
import sopt.client.cleanting.Main.SignUp.SignUpActivity;
import sopt.client.cleanting.Network.NetworkService;
import sopt.client.cleanting.R;

public class LoginActivity extends AppCompatActivity {

    ImageView Signup_img;
    ImageView Findpassword_img;
    ImageView Login_btn;
    EditText edit_id;
    EditText edit_password;
    CheckBox checkBox;
    NetworkService service;

    public static LoginUserDatas loginUserDatas = new LoginUserDatas();

    @Override    //  글씨체 적용
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(TypekitContextWrapper.wrap(newBase));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        service = ApplicationController.getInstance().getNetworkService();

        Signup_img = (ImageView) findViewById(R.id.Signup_img);
        Login_btn = (ImageView) findViewById(R.id.Login_btn);
        edit_id = (EditText) findViewById(R.id.edit_id);
        edit_password = (EditText) findViewById(R.id.edit_password);
        Findpassword_img = (ImageView) findViewById(R.id.Findpassword_tv);
        checkBox = (CheckBox) findViewById(R.id.checkbox);

        Findpassword_img.setOnClickListener(new View.OnClickListener() {// 계정찾기 페이지로 넘어 감
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FindAccountActivity.class);
                startActivity(intent);
            }
        });


        Signup_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
                startActivity(intent);
            }
        });

        Login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (edit_id.getText().toString().replace(" ", "").equals("") || edit_password.getText().toString().replace(" ", "").equals("")) {
                    Toast.makeText(getApplicationContext(), " 아이디 혹은 비밀번호를 입력하세요 ", Toast.LENGTH_SHORT).show();
                } else {
                    SendLoginData sendLoginData = new SendLoginData();
                    sendLoginData.userId = edit_id.getText().toString();
                    sendLoginData.pwd = edit_password.getText().toString();
                    String token = FirebaseInstanceId.getInstance().getToken();
                    sendLoginData.deviceToken = token;
                    Log.d("FCM_Token", token);

                    Call<LoginResult> loginResultCall = service.getLoginResult(sendLoginData);
                    loginResultCall.enqueue(new Callback<LoginResult>() {
                        @Override
                        public void onResponse(Call<LoginResult> call, Response<LoginResult> response) {
                            if (response.isSuccessful()) {
                                loginUserDatas.token = response.body().token;
                                loginUserDatas.userId = response.body().userInfo.userId;
                                loginUserDatas.name = response.body().userInfo.name;
                                loginUserDatas.phone = response.body().userInfo.phone;
                                loginUserDatas.address = response.body().userInfo.address;
                                loginUserDatas.lat = response.body().userInfo.lat;
                                loginUserDatas.lng = response.body().userInfo.lng;
                                loginUserDatas.locationNum = response.body().userInfo.locationNum;
                                loginUserDatas.push = response.body().userInfo.push;

                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                startActivity(intent);
                                finish();

                            } else {
                                Toast.makeText(LoginActivity.this, "아이디, 비밀번호를 확인해주세요.", Toast.LENGTH_SHORT).show();
                            }

                        }

                        @Override
                        public void onFailure(Call<LoginResult> call, Throwable t) {
                            Toast.makeText(getApplicationContext(),
                                    "서버상태를 확인해주세요", Toast.LENGTH_LONG).show();
                        }
                    });

                    // 아이디 비번 검사

                    //  keep me log in 체크
                    if (checkBox.isChecked()) {
                        // login 유지 코드
                    }
                    edit_id.setText("");
                    edit_password.setText("");

                }
            }
        });
    }
}
