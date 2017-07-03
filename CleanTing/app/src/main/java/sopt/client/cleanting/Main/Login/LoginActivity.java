package sopt.client.cleanting.Main.Login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import sopt.client.cleanting.Main.MainActivity;
import sopt.client.cleanting.Main.SignUp.SignUpActivity;
import sopt.client.cleanting.R;

public class LoginActivity extends AppCompatActivity {

    ImageView Signup_img;
    ImageView Findpassword_img;
    ImageView Login_btn;
    EditText edit_id;
    EditText edit_password;
    CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Signup_img = (ImageView)findViewById(R.id.Signup_img);
        Login_btn = (ImageView)findViewById(R.id.Login_btn);
        edit_id = (EditText)findViewById(R.id.edit_id);
        edit_password = (EditText)findViewById(R.id.edit_password);
        Findpassword_img = (ImageView) findViewById(R.id.Findpassword_tv);
        checkBox = (CheckBox)findViewById(R.id.checkbox) ;


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

                if (edit_id.getText().toString().replace(" ", "").equals("") || edit_password.getText().toString().replace(" ", "").equals("") )
                {
                    Toast.makeText(getApplicationContext()," 아이디 혹은 비밀번호를 입력하세요 ",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    String temp_id = edit_id.getText().toString();
                    String temp_password = edit_password.getText().toString();
                    Toast.makeText(getApplicationContext(),"id : "+temp_id + "\n"+ "pass : "+temp_password, Toast.LENGTH_SHORT).show();

                    // 아이디 비번 검사

                    //  keep me log in 체크
                    if(checkBox.isChecked())
                    {
                        // login 유지 코드
                    }
                    edit_id.setText("");
                    edit_password.setText("");
                    Intent intent = new Intent(getApplication(),MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
