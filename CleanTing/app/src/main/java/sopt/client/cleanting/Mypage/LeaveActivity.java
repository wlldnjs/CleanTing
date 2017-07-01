package sopt.client.cleanting.Mypage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import sopt.client.cleanting.Main.Login.LoginActivity;
import sopt.client.cleanting.R;

public class LeaveActivity extends AppCompatActivity {

    ImageView leave_btn;
    private CustomDialog mCustomDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leave);

        leave_btn = (ImageView)findViewById(R.id.leave_btn);

    }

    private View.OnClickListener leftListener = new View.OnClickListener() {
        public void onClick(View v) {
            mCustomDialog.dismiss();
        }
    };

    private View.OnClickListener rightListener = new View.OnClickListener() {
        public void onClick(View v) {
            Toast.makeText(getApplicationContext(),"정상적으로 탈퇴 되었습니다.",
                    Toast.LENGTH_SHORT).show();
            mCustomDialog.dismiss();
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);
        }
    };

    public void onclick_leave(View view)
    {
        mCustomDialog = new CustomDialog(this,
                " ", // 제목
                "정말로 탈퇴를 하시겠습니까?", // 내용
                leftListener, // 왼쪽 버튼 이벤트
                rightListener); // 오른쪽 버튼 이벤트
        mCustomDialog.show();
    }
}
