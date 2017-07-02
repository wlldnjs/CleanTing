package sopt.client.cleanting.MakeTing.ListCleaner;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import sopt.client.cleanting.R;

/**
 * Created by glgld on 2017-07-03.
 */

public class ListCleanerViewHolder extends RecyclerView.ViewHolder {

    ImageView ListCleanerimg;
    TextView ListCleanername;
    TextView ListCleanerhistory;
    TextView ListCleanercomment;
    ImageView ListCleanerrate;

    public ListCleanerViewHolder(View itemView) {
        super(itemView);

        ListCleanerimg = (ImageView)itemView.findViewById(R.id.List_cleanerimg);
        ListCleanername = (TextView)itemView.findViewById(R.id.List_cleanername);
        ListCleanerhistory = (TextView)itemView.findViewById(R.id.List_cleanerhistory);
        ListCleanercomment = (TextView)itemView.findViewById(R.id.List_cleanercomment);
        ListCleanerrate = (ImageView)itemView.findViewById(R.id.List_clenaerstar);
    }
}
