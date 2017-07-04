package sopt.client.cleanting.Main.SignUp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sopt.client.cleanting.Application.ApplicationController;
import sopt.client.cleanting.Main.Login.LoginActivity;
import sopt.client.cleanting.Network.NetworkService;
import sopt.client.cleanting.R;

public class SignUpActivity extends AppCompatActivity {


    ImageView before,button_cite,button_confirm,button_address;
    ImageView submit;
    EditText edit_name,edit_phonenumber,edit_citenumber,edit_password,edit_address,edit_id,edit_confirm_password;
    TextView agreement,information,approval;
    TextView to_login;
    CheckBox checkbox;
    NetworkService service;
    ImageView doublecheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        service = ApplicationController.getInstance().getNetworkService();

        before=(ImageView)findViewById(R.id.before);
        button_cite=(ImageView) findViewById(R.id.button_cite);
        button_confirm=(ImageView)findViewById(R.id.button_confirm);
        button_address=(ImageView)findViewById(R.id.button_address);

        submit=(ImageView) findViewById(R.id.submit);

        edit_name=(EditText)findViewById(R.id.edit_name);
        edit_phonenumber=(EditText)findViewById(R.id.edit_phonenumber);
        edit_citenumber=(EditText)findViewById(R.id.edit_citenumber);
        edit_password=(EditText)findViewById(R.id.edit_password);
        edit_address=(EditText)findViewById(R.id.edit_address);
        edit_id=(EditText)findViewById(R.id.edit_id);
        edit_confirm_password=(EditText)findViewById(R.id.edit_confirm_password);

        agreement=(TextView)findViewById(R.id.agreement);
        information=(TextView)findViewById(R.id.information);
        approval=(TextView)findViewById(R.id.approval);
        to_login=(TextView) findViewById(R.id.to_login);

        checkbox=(CheckBox)findViewById(R.id.checkbox);

        doublecheck=(ImageView)findViewById(R.id.doublecheck);

        //중복확인
        doublecheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<IdCheckResult> checkResultCall = service.getIdCheckResult(edit_id.getText().toString());

                checkResultCall.enqueue(new Callback<IdCheckResult>() {
                    @Override
                    public void onResponse(Call<IdCheckResult> call, Response<IdCheckResult> response) {
                        if (response.isSuccessful()){
                            if (response.body().message.equals("사용가능한 아이디 입니다.")){
                                Toast.makeText(getApplicationContext(),
                                        "사용 가능한 아이디입니다.", Toast.LENGTH_LONG).show();
                            }
                            else{
                                Toast.makeText(getApplicationContext(),
                                        response.body().message, Toast.LENGTH_LONG).show();
                            }
                        }

                    }

                    @Override
                    public void onFailure(Call<IdCheckResult> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),
                               t.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });

            }
        });

        button_address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

            //진영

                String name,phonenumber,password,confirm_password,address,id;
                String information;
                name=edit_name.getText().toString();
                phonenumber=edit_phonenumber.getText().toString();
                password=edit_password.getText().toString();
                address=edit_address.getText().toString();
                id=edit_id.getText().toString();
                confirm_password=edit_confirm_password.getText().toString();

                information=name+" "+phonenumber+" "+password+" "+address;

                //유효성검사
                if(edit_name.length()==0){
                    Toast.makeText(getApplicationContext(), "이름 입력해주세요.", Toast.LENGTH_SHORT).show();
                    edit_name.requestFocus();
                    return;
                }
                if(edit_id.length()==0){
                    Toast.makeText(getApplicationContext(),"아이디를 입력해주세요.",Toast.LENGTH_SHORT).show();
                    edit_id.requestFocus();
                    return;
                }

                if(edit_phonenumber.length()==0){
                    Toast.makeText(getApplicationContext(),"핸드폰 번호를 입력해주세요.",Toast.LENGTH_SHORT).show();
                    edit_phonenumber.requestFocus();
                    return;
                }
                if(edit_password.length()<4&&edit_password.length()>20){
                    Toast.makeText(getApplicationContext(),"비밀번호를 4~20자리로 입력해주세요.",Toast.LENGTH_SHORT).show();
                    edit_password.requestFocus();
                    return;
                }
                if(edit_citenumber.length()==0){
                    Toast.makeText(getApplicationContext(), "인증번호를 입력해주세요", Toast.LENGTH_SHORT).show();

                }
                if(edit_address.length()==0){
                    Toast.makeText(getApplicationContext(),"주소를 입력해주세요.",Toast.LENGTH_SHORT).show();
                    edit_address.requestFocus();
                    return;
                }
                if(!Pattern.matches("^[가-힣]*$",name)){
                    Toast.makeText(getApplicationContext(),"이름을 한글로 입력해주세요.",Toast.LENGTH_SHORT).show();
                }

                if(!Pattern.matches("^[a-zA-Z0-9]*$$",id)){
                    Toast.makeText(getApplicationContext(), "아이디를 영문과 숫자로만 입력해주세요.", Toast.LENGTH_SHORT).show();
                    edit_name.requestFocus();
                    return;
                }
                if(!Pattern.matches("^[a-zA-Z0-9]*$",password)){
                    Toast.makeText(getApplicationContext(),"비밀번호를 영문과 숫자로만 입력해주세요.",Toast.LENGTH_SHORT).show();
                    edit_password.requestFocus();
                    return;
                }
                if(  checkbox.isChecked()==false){
                    Toast.makeText(getApplicationContext(),"위 약관에 동의해주세요",Toast.LENGTH_SHORT).show();
                    return;
                }

                if(password!=confirm_password){
                    Toast.makeText(getApplicationContext(),"비밀번호를 다시 확인해주세요",Toast.LENGTH_SHORT).show();
                    return;
                }



                else{
                    SignUpData signUpData = new SignUpData();

                    signUpData.userId = edit_id.getText().toString();
                    signUpData.name = edit_name.getText().toString();
                    signUpData.phone=edit_phonenumber.getText().toString();
                    signUpData.address=edit_address.getText().toString();
                    signUpData.pwd=edit_password.getText().toString();


                    Call<SignUpResult> signUpResultCall = service.getSignUpResult(signUpData);
                    signUpResultCall.enqueue(new Callback<SignUpResult>() {
                        @Override
                        public void onResponse(Call<SignUpResult> call, Response<SignUpResult> response) {
                            if(response.isSuccessful()){
                                if(response.body().message.equals("ok")){
                                    Toast.makeText(getApplicationContext(),
                                            "회원가입에 성공했습니다", Toast.LENGTH_LONG).show();
                                    Intent intent=new Intent(getBaseContext(),LoginActivity.class);
                                    startActivity(intent);
                                    finish();
                                } else {
                                    Toast.makeText(getApplicationContext(),
                                            response.body().message, Toast.LENGTH_LONG).show();
                                }

                            }
                        }

                        @Override
                        public void onFailure(Call<SignUpResult> call, Throwable t) {
                            Toast.makeText(getApplicationContext(),
                                    "서버상태를 확인해주세요", Toast.LENGTH_LONG).show();
                        }
                    });




                }

            }
        });

        before.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getBaseContext(),LoginActivity.class);

                startActivity(intent);
            }
        });



        to_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        agreement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),AgreementActivity.class);
                startActivity(intent);
            }
        });

        information.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),InformationActivity.class);
                startActivity(intent);
            }
        });

    }
}
