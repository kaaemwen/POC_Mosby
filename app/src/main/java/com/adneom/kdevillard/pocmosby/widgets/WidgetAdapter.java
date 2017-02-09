package com.adneom.kdevillard.pocmosby.widgets;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.adneom.kdevillard.pocmosby.R;
import com.adneom.kdevillard.pocmosby.mvp.dashboard.DashboardActivity;
import com.adneom.kdevillard.pocmosby.mvp.dashboard.dashboardDetail.DashboardDetailFragment;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by kdevillard on 22-11-16.
 */

public class WidgetAdapter extends RecyclerView.Adapter<WidgetAdapter.WidgetViewHolder> {
    private List<Widget> widgetsList;
    private Context context;

    // Provide a suitable constructor (depends on the kind of dataset)
    public WidgetAdapter(List<Widget> widgetsList, Context context) {
        this.widgetsList = widgetsList;
        this.context = context;
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return widgetsList.size();
    }

    // Create new views (invoked by the layout manager)
    @Override
    public WidgetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.item_card, parent, false);

        return new WidgetViewHolder(itemView, parent.getContext());
    }

    @Override
    public void onBindViewHolder(WidgetViewHolder widgetHolder, int position) {
        Widget widget = widgetsList.get(position);
        widgetHolder.getDescription().setText("ID: " + widget.getId());
        widgetHolder.getTitle().setText(widget.getName());
        widgetHolder.getPhoto().setImageResource(widget.getImg());
        widgetHolder.currentItem = widget;
    }

    public static class WidgetViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.descCard) TextView description;
        @BindView(R.id.imgCard) ImageView photo;
        @BindView(R.id.titleCard) TextView title;

        public View view;
        public Widget currentItem;
        private Context mContext;

        public WidgetViewHolder(View v, final Context mContext) {
            super(v);
            this.view = v;
            this.mContext = mContext;
            ButterKnife.bind(this, v);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("currentWidget", currentItem);
                    DashboardDetailFragment fragment = new DashboardDetailFragment();
                    fragment.setArguments(bundle);
                    ((DashboardActivity)mContext).getSupportFragmentManager().beginTransaction()
                            .replace(R.id.homeContainer, fragment)
                            .commit();
                }
            });
        }

        public ImageView getPhoto() {
            return photo;
        }

        public TextView getDescription() {
            return description;
        }

        public TextView getTitle() {
            return title;
        }
    }

}
