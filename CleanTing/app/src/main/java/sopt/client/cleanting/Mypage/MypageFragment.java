package sopt.client.cleanting.Mypage;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.Toast;

import sopt.client.cleanting.Application.ApplicationController;
import sopt.client.cleanting.Network.NetworkService;
import sopt.client.cleanting.R;

/**
 * Created by 김지원 on 2017-06-25.
 */

public class MypageFragment extends Fragment{
    NetworkService service;
    Context context;
    Button Logout_btn;
    Switch alarm_switch;

    public MypageFragment() {
    }

    public void setContext(Context context){
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        service = ApplicationController.getInstance().getNetworkService();
        LinearLayout layout = (LinearLayout)inflater.inflate(R.layout.fragment_mypage,container,false);

        Logout_btn = (Button)layout.findViewById(R.id.Logout_btn);
        alarm_switch = (Switch)layout.findViewById(R.id.alarm_switch);

        Logout_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ///////////////////
                //////             로그 아웃 코드
                ////////////////////

                Toast.makeText(getContext(),"로그아웃",Toast.LENGTH_SHORT).show();
            }
        });

        alarm_switch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(alarm_switch.isChecked())
                {
                    Toast.makeText(getContext(),"알림이 켜집니다",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getContext(),"알림이 꺼집니다",Toast.LENGTH_SHORT).show();
                }
            }
        });
        //
        //   서버에서 정보 가져와서 알림이 켜져있으면 alarm_switch.setChecked(true);
        //   아니면 alarm_switch.setChecked(false);

        return layout;
    }
}
