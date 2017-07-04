package sopt.client.cleanting.MyRequest;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
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
    FragmentManager fm;
    ArrayList<MyRequestData> itemDatas;
    View.OnClickListener clickListener;
    Context context;
    ArrayList<Bundle> bundleList = new ArrayList<Bundle>();

    public MyRequestAdapter(ArrayList<MyRequestData> itemDatas, View.OnClickListener clickListener, Context context, FragmentManager fm, ArrayList<Bundle> bundleList){
        this.itemDatas = itemDatas;
        this.clickListener = clickListener;
        this.context = context;
        this.fm = fm;
        this.bundleList = bundleList;
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
            MyLocationViewHolderHeader.viewPager.setAdapter(new pagerAdapter (fm));
            MyLocationViewHolderHeader.viewPager.setCurrentItem(0);

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

            if(position == bundleList.size()){
                MyRequestDetailFragmentEmpty empty = new MyRequestDetailFragmentEmpty();
                empty.setContext(context);

                return empty;
            }else {
                MyRequestDetailFragment myRequestDetailFragment = new MyRequestDetailFragment();
                myRequestDetailFragment.setContext(context);
                myRequestDetailFragment.setArguments(bundleList.get(position));
                return myRequestDetailFragment;
            }

        }
        @Override
        public int getCount() {
            return bundleList.size()+1;
        }

    }
}