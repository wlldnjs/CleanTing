package sopt.client.cleanting.Mypage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import sopt.client.cleanting.R;

public class RatingActivity extends AppCompatActivity {

    //이름 id값이랑 같게 씀!
    ImageView cleaner_picture;
    TextView Rate_cleanername;
    TextView Rate_cleannumber;
    TextView Rate_reviewnumber;
    TextView Rate_career;
    TextView Rate_age;
    RatingBar rating_bar;
    EditText inputCommentEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);

        cleaner_picture=(ImageView)findViewById(R.id.cleaner_picture);
        Rate_cleanername=(TextView)findViewById(R.id.Rate_cleanername);
        Rate_cleannumber=(TextView)findViewById(R.id.Rate_cleannumber);
        Rate_reviewnumber=(TextView)findViewById(R.id.Rate_reviewnumber);
        Rate_career=(TextView)findViewById(R.id.Rate_career);
        Rate_age=(TextView)findViewById(R.id.Rate_age);

        rating_bar=(RatingBar)findViewById(R.id.rating_bar);

        inputCommentEdit=(EditText)findViewById(R.id.inputCommentEdit);





    }
}
