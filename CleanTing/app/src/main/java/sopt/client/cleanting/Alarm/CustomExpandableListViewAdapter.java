package sopt.client.cleanting.Alarm;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

import sopt.client.cleanting.R;

/**
 * Created by 진영 on 2017-06-28.
 */

public class CustomExpandableListViewAdapter extends BaseExpandableListAdapter {
    private AlarmFragment mFragment;
    private ArrayList<String> mParentList;
    private ArrayList<ChildListData> mChildList;
    private ChildListViewHolder mChildListViewHolder;
    private HashMap<String, ArrayList<ChildListData>> mChildHashMap;
    private ImageView resources;
    private Drawable drawable;

    // CustomExpandableListViewAdapter 생성자
    public CustomExpandableListViewAdapter(AlarmFragment context, ArrayList<String> parentList, HashMap<String, ArrayList<ChildListData>> childHashMap){
        this.mFragment = context;
        this.mParentList = parentList;
        this.mChildHashMap = childHashMap;
    }



    @Override
    public String getGroup(int groupPosition) {//TextView에 반영될 String값 반환
        return mParentList.get(groupPosition);
    }

    @Override
    public int getGroupCount() {//ParentList의 갯수 반환
        return mParentList.size();
    }

    @Override
    public long getGroupId(int groupPosition) {//ParentList의 position을 받아서 long값으로 반환
        return groupPosition;
    }



    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {//ParentList의 View



        if(convertView==null){
            LayoutInflater groupInflater =(LayoutInflater)this.mFragment.getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=groupInflater.inflate(R.layout.parent_listview,parent,false);
            if(isExpanded){
                //열려있을때의 이미지 삽입
            }
            else
            {
                //닫혀있을때의 이미지 삽입
            }
        }
        //ParentList의 Layout연결 후, 해당 layout 내 TextView를 연결
        TextView parentText = (TextView)convertView.findViewById(R.id.parenttext);
        parentText.setText(getGroup(groupPosition));
        return convertView;
    }

    /****************************************여기는 ChildListView*****************************************/

    @Override
    public Object getChild(int groupPosition, int childPosition){//groupPosition과 childPosition을 통해 childList원소를 얻어옴

        return this.mChildHashMap.get(this.mParentList.get(groupPosition)).get(childPosition);

    }

    @Override
    public int getChildrenCount(int groupPosition){//ChildList의 크기를 int형으로 반환
        return this.mChildHashMap.get(this.mParentList.get(groupPosition)).size();
    }

    @Override
    public long getChildId(int groupPosition, int childPosition){//ChildList의 ID로 long형 값 반환
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        //ChildList의 뷰, Layout먼저 연결 후, TextView와 ImageView연결

        ChildListData childData = (ChildListData) getChild(groupPosition, childPosition);
        if (convertView == null) {
            LayoutInflater childInflater = (LayoutInflater) this.mFragment.getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = childInflater.inflate(R.layout.child_listview, null);

            mChildListViewHolder = new ChildListViewHolder();
            mChildListViewHolder.mChildListViewIcon = (ImageView) convertView.findViewById(R.id.child_item_icon);
            mChildListViewHolder.mChildListViewText = (TextView) convertView.findViewById(R.id.childtext);
            convertView.setTag(mChildListViewHolder);
        } else {
            mChildListViewHolder = (ChildListViewHolder) convertView.getTag();
        }
/***********************************여기고쳐야댐!!!!!!*********************************/
        mChildListViewHolder.mChildListViewText.setText(getGroup(childPosition));
        mChildListViewHolder.mChildListViewIcon.getResources().getDrawable(R.drawable.tingyellow);
        return convertView;

    }
    @Override
    public boolean hasStableIds() { return true; } // stable ID인지 boolean 값으로 반환

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) { return true; } // 선택여부를 boolean 값으로 반환
}
