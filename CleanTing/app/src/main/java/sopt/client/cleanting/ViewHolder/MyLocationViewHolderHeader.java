package sopt.client.cleanting.ViewHolder;

import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import sopt.client.cleanting.R;

/**
 * Created by 김지원 on 2017-06-28.
 */

public class MyLocationViewHolderHeader extends RecyclerView.ViewHolder{
    public ImageView myLocationBtn;
    public ViewPager viewPager;
    public MyLocationViewHolderHeader(View itemView) {
        super(itemView);
        myLocationBtn = (ImageView)itemView.findViewById(R.id.my_location_sort);
        viewPager = (ViewPager)itemView.findViewById(R.id.my_request_view_pager);
    }
}
