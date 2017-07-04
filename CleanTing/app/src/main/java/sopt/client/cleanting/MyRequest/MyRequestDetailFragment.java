package sopt.client.cleanting.MyRequest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import sopt.client.cleanting.R;

/**
 * Created by 김지원 on 2017-06-28.
 */

public class MyRequestDetailFragment extends Fragment {
    Context context;
    TextView cleaner, date, time, memberCount;
    ImageView member1, member2, member3;
    LinearLayout layout;

    public MyRequestDetailFragment() {
    }

    public void setContext(Context context){
        this.context = context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layout = (LinearLayout) inflater.inflate(R.layout.viewpager_my_request_detail,container,false);
        cleaner = (TextView)layout.findViewById(R.id.my_request_detail_cleaner);
        date = (TextView)layout.findViewById(R.id.my_request_detail_date1);
        time = (TextView)layout.findViewById(R.id.my_request_detail_time1);
        member1 = (ImageView)layout.findViewById(R.id.my_request_detail_member1);
        member2 = (ImageView)layout.findViewById(R.id.my_request_detail_member2);
        member3 = (ImageView)layout.findViewById(R.id.my_request_detail_member3);
        memberCount = (TextView)layout.findViewById(R.id.my_request_detail_member_count);

        cleaner.setText(getArguments().getString("cleanerId"));
        date.setText(getArguments().getString("date"));
        time.setText(getArguments().getString("startTime") +"~" +getArguments().getString("endTime"));
        memberCount.setText(getArguments().getString("cnt") +"명/3명");
        if(getArguments().getString("cnt").equals("2")){
            member3.setImageResource(R.drawable.man_line);
        } else if(getArguments().getString("cnt").equals("1")){
            member3.setImageResource(R.drawable.man_line);
            member2.setImageResource(R.drawable.man_line);
        }

        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MyRequestRecruit.class);
                startActivity(intent);
            }
        });
        return layout;
    }

    public void setData(String date1, String time1){
        date.setText(date1);
        time.setText(time1);
    }
}
