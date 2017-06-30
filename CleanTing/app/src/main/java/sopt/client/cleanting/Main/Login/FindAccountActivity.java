package sopt.client.cleanting.Main.Login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import sopt.client.cleanting.R;

public class FindAccountActivity extends AppCompatActivity {

    EditText edit_phonenumber,edit_citenumber,new_edit_phonenumber,new_edit_citenumber;
    EditText new_password,edit_confirm_password;
    ImageView button_request_citenumber,button_find,new_button_citenumber,new_button_find,button_new_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
