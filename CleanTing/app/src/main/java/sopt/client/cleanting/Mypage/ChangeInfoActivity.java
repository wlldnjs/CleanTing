package sopt.client.cleanting.Mypage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sopt.client.cleanting.Application.ApplicationController;
import sopt.client.cleanting.Network.NetworkService;
import sopt.client.cleanting.R;

import static sopt.client.cleanting.Main.Login.LoginActivity.loginUserDatas;
import static sopt.client.cleanting.R.id.changeimg;

public class ChangeInfoActivity extends AppCompatActivity {

    private CustomDialog2 mCustomDialog2;
    ImageView changephone;
    ImageView button_pw,button_phonenumber,button_address;
    NetworkService service;
    TextView text_phonenumber;
    EditText password1,password2;
    EditText edit_phonenumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_info);
        service = ApplicationController.getInstance().getNetworkService();

        changephone = (ImageView)findViewById(changeimg);

        button_pw = (ImageView) findViewById(R.id.button_pw);
        button_phonenumber=(ImageView)findViewById(R.id.button_phonenumber);
        button_address=(ImageView)findViewById(R.id.button_address);


        password1 = (EditText)findViewById(R.id.password1);
        password2 = (EditText)findViewById(R.id.password2);

        text_phonenumber=(TextView)findViewById(R.id.text_phonenumber);

        button_pw.setOnClickListener(new View.OnClickListener() {       // 수정하기

            @Override
            public void onClick(View v) {
            if(Pattern.matches("^[a-zA-Z0-9]*$",password1.getText().toString())){
                if(password1.getText().toString().length()>=4 && password1.getText().toString().length()<=20){
                    if(password1.getText().toString().equals(password2.getText().toString())){
                    /*@Body로 바꾸고 수정해야함*/
                        Call<ModifyPasswordResult> modifyPasswordResultCall = service.getModifyPasswordResult(loginUserDatas.userId,password1.getText().toString());
                        modifyPasswordResultCall.enqueue(new Callback<ModifyPasswordResult>() {
                            @Override
                            public void onResponse(Call<ModifyPasswordResult> call, Response<ModifyPasswordResult> response) {
                                if (response.isSuccessful()){
                                    if(response.body().message.equals("pwd update ok")){
                                        Toast.makeText(ChangeInfoActivity.this, "비밀번호 변경에 성공했습니다.", Toast.LENGTH_SHORT).show();
                                    }
                                } else {
                                    Toast.makeText(ChangeInfoActivity.this, response.body().message, Toast.LENGTH_SHORT).show();
                                }
                            }

                            @Override
                            public void onFailure(Call<ModifyPasswordResult> call, Throwable t) {
                                Toast.makeText(ChangeInfoActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    else{
                        Toast.makeText(ChangeInfoActivity.this, "비밀번호를 다시 확인해 주세요", Toast.LENGTH_SHORT).show();
                        password2.requestFocus();
                        return;
                    }
                }
                else{
                    Toast.makeText(getApplicationContext(),"패스워드를 4~20자리로 입력해주세요",Toast.LENGTH_SHORT).show();
                    password1.requestFocus();
                    return;
                }
            }
            else{
                Toast.makeText(getApplicationContext(),"비밀번호를 영문과 숫자로만 입력해주세요.",Toast.LENGTH_SHORT).show();
                password1.requestFocus();
                return;
            }
//                if(password1.getText().toString().equals(password2.getText().toString())){
//                    /*@Body로 바꾸고 수정해야함*/
//                    Call<ModifyPasswordResult> modifyPasswordResultCall = service.getModifyPasswordResult(loginUserDatas.userId,password1.getText().toString());
//                    modifyPasswordResultCall.enqueue(new Callback<ModifyPasswordResult>() {
//                        @Override
//                        public void onResponse(Call<ModifyPasswordResult> call, Response<ModifyPasswordResult> response) {
//                            if (response.isSuccessful()){
//                                if(response.body().message.equals("pwd update ok")){
//                                    Toast.makeText(ChangeInfoActivity.this, "비밀번호 변경에 성공했습니다.", Toast.LENGTH_SHORT).show();
//                                }
//                            } else {
//                                Toast.makeText(ChangeInfoActivity.this, response.body().message, Toast.LENGTH_SHORT).show();
//                            }
//                        }
//
//                        @Override
//                        public void onFailure(Call<ModifyPasswordResult> call, Throwable t) {
//                            Toast.makeText(ChangeInfoActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
//                        }
//                    });
//                }
//                else{
//                    Toast.makeText(ChangeInfoActivity.this, "비밀번호를 다시 확인해 주세요", Toast.LENGTH_SHORT).show();
//                    password2.requestFocus();
//                    return;
//                }

            }
        });

        button_phonenumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<ModifyUserPhoneResult> modifyUserPhoneResultCall =service.getModifyUserPhoneResult(loginUserDatas.userId,text_phonenumber.getText().toString());

                modifyUserPhoneResultCall.enqueue(new Callback<ModifyUserPhoneResult>() {
                    @Override
                    public void onResponse(Call<ModifyUserPhoneResult> call, Response<ModifyUserPhoneResult> response) {
                        if(response.isSuccessful()){
                            if(response.body().message.equals("phone update ok")){
                                Toast.makeText(getApplicationContext(),"phone update ok",Toast.LENGTH_SHORT).show();
                            }
                            else{
                                Toast.makeText(getApplicationContext(),response.body().message,Toast.LENGTH_SHORT).show();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<ModifyUserPhoneResult> call, Throwable t) {
                        Toast.makeText(ChangeInfoActivity.this, "서버 연결 상태를 확인해주세요.", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

        button_address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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

            text_phonenumber.setText(mCustomDialog2.getEdit_phonenumber().getText().toString());

//            Call<ModifyUserPhoneResult> modifyUserPhoneResultCall=service.getModifyUserPhoneResult(loginUserDatas.userId,edit_phonenumber.getText().toString());
//            modifyUserPhoneResultCall.enqueue(new Callback<ModifyUserPhoneResult>() {
//                @Override
//                public void onResponse(Call<ModifyUserPhoneResult> call, Response<ModifyUserPhoneResult> response) {
//                    if(response.isSuccessful()){
//                        if(response.body().message.equals("phone update ok")){
//                            Toast.makeText(getApplicationContext(), "phone update ok", Toast.LENGTH_SHORT).show();
//                        }
//                        else{
//                            Toast.makeText(getApplicationContext(),response.body().message,Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                }
//
//                @Override
//                public void onFailure(Call<ModifyUserPhoneResult> call, Throwable t) {
//                    Toast.makeText(getApplicationContext(),"서버 연결 상태를 확인해주세요.",Toast.LENGTH_SHORT).show();
//                }
//            });


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
