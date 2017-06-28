package sopt.client.cleanting.Main.SignUp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

import sopt.client.cleanting.Main.Login.LoginActivity;
import sopt.client.cleanting.R;

public class SignUpActivity extends AppCompatActivity {


    ImageView before,button_cite,button_confirm,button_address;
    ImageView submit;
    EditText edit_name,edit_phonenumber,edit_citenumber,edit_password,edit_address,edit_id;
    TextView agreement,information,approval,to_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

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

        agreement=(TextView)findViewById(R.id.agreement);
        information=(TextView)findViewById(R.id.information);
        approval=(TextView)findViewById(R.id.approval);
        to_login=(TextView)findViewById(R.id.to_login);

        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

            //진영

                String name,phonenumber,password,address,id;
                String information;
                name=edit_name.getText().toString();
                phonenumber=edit_phonenumber.getText().toString();
                password=edit_password.getText().toString();
                address=edit_address.getText().toString();
                id=edit_id.getText().toString();

                information=name+" "+phonenumber+" "+password+" "+address;

                //유효성검사
                if(edit_name.length()==0){
                    Toast.makeText(getApplicationContext(), "이름 입력해주세요.", Toast.LENGTH_SHORT).show();
                    edit_name.requestFocus();
                    return;
                }
                if(edit_id.length()==0){
                    Toast.makeText(getApplicationContext(),"아이디를 입력해주세요.",Toast.LENGTH_SHORT).show();
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

                else{
                    //여기 이제 인텐트값 넘기는걸로 바꿔야함
                    Toast.makeText(getApplicationContext(),
                            information, Toast.LENGTH_LONG).show();
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


    submit.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent intent=new Intent(getBaseContext(),LoginActivity.class);
            startActivity(intent);
            finish();
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
    }
}
