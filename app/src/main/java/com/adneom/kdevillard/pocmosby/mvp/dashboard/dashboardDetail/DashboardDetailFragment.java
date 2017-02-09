package com.adneom.kdevillard.pocmosby.mvp.dashboard.dashboardDetail;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.adneom.kdevillard.pocmosby.R;
import com.adneom.kdevillard.pocmosby.mvp.login.LoginActivity;
import com.adneom.kdevillard.pocmosby.mvp.model.Article;
import com.adneom.kdevillard.pocmosby.widgets.Widget;
import com.hannesdorfmann.mosby.mvp.viewstate.MvpViewStateFragment;
import com.hannesdorfmann.mosby.mvp.viewstate.ViewState;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by kdevillard on 21-11-16.
 */

public class DashboardDetailFragment extends MvpViewStateFragment<DashboardDetailView, DashboardDetailPresenter> implements DashboardDetailView {
    protected DashboardDetailPresenter presenter;
    private Widget currentWidget;

    @BindView(R.id.descCardDetail) TextView description;
    @BindView(R.id.imgCardDetail) ImageView photo;
    @BindView(R.id.titleCardDetail) TextView title;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_dashboard_detail, container, false);
        Bundle bundle = this.getArguments();
        if(bundle != null){
            //currentArticle = (Article) bundle.getSerializable("currentArt");
            currentWidget = (Widget) bundle.getSerializable("currentWidget");
        }
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(true);

        this.description.setText("ID: " + currentWidget.getId());
        this.title.setText(currentWidget.getName());
        this.photo.setImageResource(currentWidget.getImg());
    }

    @Override
    public DashboardDetailPresenter createPresenter() {
        presenter = new DashboardDetailPresenter();
        return presenter;
    }

    @Override
    public ViewState createViewState() {
        return new DashboardDetailViewState();
    }

    @Override
    public void onNewViewStateInstance() {
        showDetailCard();
    }

    @Override
    public void showDetailCard() {

    }

    @Override
    public void showError() {

    }

    @Override
    public void showLoading() {

    }


}
