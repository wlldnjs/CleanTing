package sopt.client.cleanting.Alarm;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;

import sopt.client.cleanting.Application.ApplicationController;
import sopt.client.cleanting.Network.NetworkService;
import sopt.client.cleanting.R;


public class AlarmFragment extends Fragment {
    private static final String[]  LIST_MENU ={"List1","List2","List3"} ;
    NetworkService service;
    Context context;
    ListView listview;
    RelativeLayout groupA;
    public AlarmFragment() {
    }

    public void setContext(Context context){
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        LinearLayout layout = (LinearLayout)inflater.inflate(R.layout.fragment_alarm,container,false);

        int flag_a,flag_b,flag_c=0; //플래그

        super.onCreate(savedInstanceState);
        listview=(ListView)getActivity().findViewById(R.id.listview);
        groupA = (RelativeLayout)layout.findViewById(R.id.groupA);
//        groupA = (RelativeLayout)getActivity().findViewById(R.id.groupA);

        service = ApplicationController.getInstance().getNetworkService();


        ArrayAdapter Adapter = new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_1,LIST_MENU);
        ListView listview = (ListView)layout.findViewById(R.id.listview);
        listview.setAdapter(Adapter);




        return layout;
    }



    }


