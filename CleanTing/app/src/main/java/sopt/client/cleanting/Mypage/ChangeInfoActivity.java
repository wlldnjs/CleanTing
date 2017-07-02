package sopt.client.cleanting.Mypage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import sopt.client.cleanting.R;

public class ChangeInfoActivity extends AppCompatActivity {

    private CustomDialog2 mCustomDialog2;
    ImageView changephone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_info);

        changephone = (ImageView)findViewById(R.id.changeimg);

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
