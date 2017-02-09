package com.adneom.kdevillard.pocmosby.mvp.dashboard;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.adneom.kdevillard.pocmosby.R;
import com.adneom.kdevillard.pocmosby.mvp.dashboard.dashboardDetail.DashboardDetailFragment;
import com.adneom.kdevillard.pocmosby.mvp.model.Article;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by kdevillard on 18-11-16.
 */

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder> {
    private List<Article> articleList;
    private Context context;

    // Provide a suitable constructor (depends on the kind of dataset)
    public ArticleAdapter(List<Article> articleList, Context context) {
        this.articleList = articleList;
        this.context = context;
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return articleList.size();
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ArticleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.item_card, parent, false);

        return new ArticleViewHolder(itemView, parent.getContext());
    }

    @Override
    public void onBindViewHolder(ArticleViewHolder articleHolder, int position) {
        Article art = articleList.get(position);
        articleHolder.getDescription().setText(art.getDescription());
        articleHolder.getTitle().setText(art.getTitle());
        articleHolder.getPhoto().setImageResource(R.drawable.fat_princess);
        articleHolder.currentItem = art;
    }

    public static class ArticleViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.descCard) TextView description;
        @BindView(R.id.imgCard) ImageView photo;
        @BindView(R.id.titleCard) TextView title;

        public View view;
        public Article currentItem;
        private Context mContext;

        public ArticleViewHolder(View v, final Context mContext) {
            super(v);
            this.view = v;
            this.mContext = mContext;
            ButterKnife.bind(this, v);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("currentArt", currentItem);
                    DashboardDetailFragment fragment = new DashboardDetailFragment();
                    fragment.setArguments(bundle);
                    ((DashboardActivity)mContext).getSupportFragmentManager().beginTransaction()
                            .addToBackStack("details")
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
