package sopt.client.cleanting.MakeTing.RecentCleaner;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import sopt.client.cleanting.R;

/**
 * Created by glgld on 2017-07-03.
 */

public class RecentCleanerViewHolder extends RecyclerView.ViewHolder  {

    ImageView R_CleanerImg;
    TextView R_CleanerName;
    TextView R_date;
    ImageView R_starrate;

    public RecentCleanerViewHolder(View itemView) {
        super(itemView);
        R_CleanerImg = (ImageView)itemView.findViewById(R.id.R_cleanerimg);
        R_CleanerName = (TextView)itemView.findViewById(R.id.R_cleanername);
        R_date = (TextView)itemView.findViewById(R.id.R_date);
    }
}
