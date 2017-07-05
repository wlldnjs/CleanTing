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
    String userId, cleanerId, tingId, price, request, warning;


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

        cleanerId = getArguments().getString("cleanerId");
        tingId = getArguments().getString("tingId");
        cleaner.setText(getArguments().getString("name") +" 클리너");
        userId = getArguments().getString("userId");
        price = getArguments().getString("price");
        request = getArguments().getString("request");
        warning = getArguments().getString("warning");
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
                Intent intent = new Intent(context, MyRequestDetailActivity.class);
                intent.putExtra("tingId",tingId);
                intent.putExtra("cleanerId",cleanerId);
                intent.putExtra("userId",userId);
                intent.putExtra("price",price);
                intent.putExtra("request",request);
                intent.putExtra("warning",warning);
                intent.putExtra("date",date.getText().toString());
                intent.putExtra("time",time.getText().toString());
                intent.putExtra("cnt",getArguments().getString("cnt"));

                startActivity(intent);
            }
        });
        return layout;
    }

}
