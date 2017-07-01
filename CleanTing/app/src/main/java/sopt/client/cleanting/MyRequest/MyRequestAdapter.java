package sopt.client.cleanting.MyRequest;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import sopt.client.cleanting.R;
import sopt.client.cleanting.ViewHolder.MyLocationViewHolder;
import sopt.client.cleanting.ViewHolder.MyLocationViewHolderHeader;

/**
 * Created by 김지원 on 2017-06-28.
 */

public class MyRequestAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITME = 1;
    ViewPager viewPager;
    FragmentManager fm;
    ArrayList<MyRequestData> itemDatas;
    View.OnClickListener clickListener;
    Context context;
    float viewPagerMove1, viewPagerMove2;

    public MyRequestAdapter(ArrayList<MyRequestData> itemDatas, View.OnClickListener clickListener, Context context, FragmentManager fm){
        this.itemDatas = itemDatas;
        this.clickListener = clickListener;
        this.context = context;
        this.fm = fm;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == TYPE_HEADER){
            View v = LayoutInflater.from(context).inflate(R.layout.recycler_item_mylocation_header,parent,false);

            v.setOnClickListener(clickListener);
            return new MyLocationViewHolderHeader(v);
        } else if(viewType == TYPE_ITME){
            View v = LayoutInflater.from(context).inflate(R.layout.recycler_item_mylocation,parent,false);
            v.setOnClickListener(clickListener);
            return new MyLocationViewHolder(v);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if(holder instanceof MyLocationViewHolderHeader){
            final MyLocationViewHolderHeader myLocationViewHolderHeader = (MyLocationViewHolderHeader)holder;
            myLocationViewHolderHeader.myLocationBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "정렬방식 선택", Toast.LENGTH_SHORT).show();
                }
            });
            myLocationViewHolderHeader.viewPager.setAdapter(new pagerAdapter (fm));
            myLocationViewHolderHeader.viewPager.setCurrentItem(0);
            myLocationViewHolderHeader.viewPager.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    if(event.getAction() == MotionEvent.ACTION_DOWN){
                        viewPagerMove1 = event.getX();
                        Log.d("다운 x",""+viewPagerMove1);
                    } else if(event.getAction() == MotionEvent.ACTION_UP){
                        viewPagerMove2 = event.getX();
                        Log.d("업 x",""+viewPagerMove2);
                        if(Math.abs(viewPagerMove1) - Math.abs(viewPagerMove2) < 20 && Math.abs(viewPagerMove1) - Math.abs(viewPagerMove2) > -20){
                            myLocationViewHolderHeader.viewPager.requestDisallowInterceptTouchEvent(true);
                            Toast.makeText(context, "아이템클릭", Toast.LENGTH_SHORT).show();
                        }
                    }
                    return false;
                }
            });

        } else if(holder instanceof MyLocationViewHolder){
            MyRequestData currentItem = itemDatas.get(position-1);
            MyLocationViewHolder myLocationViewHolder = (MyLocationViewHolder)holder;
            myLocationViewHolder.myLocationDay.setText(currentItem.day);
            myLocationViewHolder.myLocationTime.setText(currentItem.time);
            if(currentItem.member.equals("1")){
                myLocationViewHolder.myLocationMember3.setImageResource(R.drawable.man_line);
                myLocationViewHolder.myLocationMember2.setImageResource(R.drawable.man_line);
            } else if(currentItem.member.equals("2")){
                myLocationViewHolder.myLocationMember3.setImageResource(R.drawable.man_line);
            }
        }
    }

    @Override
    public int getItemCount() {
        return itemDatas.size()+1;
    }

    @Override
    public int getItemViewType(int position) {
        if(position == 0){
            return TYPE_HEADER;
        }
        return TYPE_ITME;
    }

    private class pagerAdapter extends FragmentStatePagerAdapter {
        public pagerAdapter(FragmentManager fm) {
            super(fm);

        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return new MyRequestDetailFragment();
                case 1:
                    return new MyRequestDetailFragment();
                case 2:
                    MyRequestDetailFragmentEmpty empty = new MyRequestDetailFragmentEmpty();
                    empty.setContext(context);
                    return empty;
            }
            return null;
        }
        @Override
        public int getCount() {
            return 3;
        }

    }

}