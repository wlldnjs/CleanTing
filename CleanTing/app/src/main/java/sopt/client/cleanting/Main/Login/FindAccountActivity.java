package sopt.client.cleanting.Main.Login;

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

public class FindAccountActivity extends AppCompatActivity {

    NetworkService service;

    EditText edit_phonenumber,edit_citenumber,new_edit_phonenumber,new_edit_citenumber;
    EditText new_password,edit_confirm_password;
    ImageView button_request_citenumber,button_find,new_button_citenumber,new_button_find,button_new_password;
    ImageView recreate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        service= ApplicationController.getInstance().getNetworkService();

        setContentView(R.layout.activity_find_account);

        edit_phonenumber=(EditText)findViewById(R.id.edit_phonenumber);
        edit_citenumber=(EditText)findViewById(R.id.edit_citenumber);
        new_edit_phonenumber=(EditText)findViewById(R.id.new_edit_phonenumber);
        new_edit_citenumber=(EditText)findViewById(R.id.new_edit_citenumber);
        new_password=(EditText)findViewById(R.id.new_password);
        edit_confirm_password=(EditText)findViewById(R.id.edit_confirm_password);

        button_request_citenumber=(ImageView)findViewById(R.id.button_request_citenumber);
        button_find=(ImageView)findViewById(R.id.button_find);
        new_button_citenumber=(ImageView)findViewById(R.id.new_button_citenumber);
        new_button_find=(ImageView)findViewById(R.id.new_button_find);
        button_new_password=(ImageView)findViewById(R.id.button_new_password);

        recreate=(ImageView)findViewById(R.id.recreate);

        //아이디찾기 인증번호 요청버튼
        button_request_citenumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"인증번호가 요청되었습니다.",Toast.LENGTH_SHORT).show();

            }
        });
        //아이디찾기 찾기버튼
        button_find.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Call<FindIdResult> findIdResultCall=service.getFindIdResult(edit_citenumber.getText().toString());

                findIdResultCall.enqueue(new Callback<FindIdResult>() {
                    @Override
                    public void onResponse(Call<FindIdResult> call, Response<FindIdResult> response) {
                        if(response.isSuccessful()){
                            if(response.body().message.equals("아이디가 존재합니다")){
                                Toast.makeText(getApplicationContext(),"아이디가 존재합니다",Toast.LENGTH_SHORT).show();
                            }
                            else{
                                Toast.makeText(getApplicationContext(),response.body().message,Toast.LENGTH_SHORT).show();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<FindIdResult> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),
                                "서버상태를 확인해주세요", Toast.LENGTH_LONG).show();
                    }
                });

            }
        });
        //새 비밀번호 인증번호 요청버튼(Toast메시지만)
        new_button_citenumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"인증번호가 요청되었습니다.",Toast.LENGTH_SHORT).show();
            }
        });
        // 새 비밀번호 찾기버튼
        new_button_find.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


            }
        });

        recreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        button_new_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
