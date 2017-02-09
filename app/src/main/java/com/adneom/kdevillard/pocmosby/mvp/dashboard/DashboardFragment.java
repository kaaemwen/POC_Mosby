package com.adneom.kdevillard.pocmosby.mvp.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.adneom.kdevillard.pocmosby.R;
import com.adneom.kdevillard.pocmosby.mvp.dashboard.dashboardDetail.DashboardDetailFragment;
import com.adneom.kdevillard.pocmosby.mvp.model.Article;
import com.adneom.kdevillard.pocmosby.widgets.Widget;
import com.adneom.kdevillard.pocmosby.widgets.WidgetAdapter;
import com.adneom.kdevillard.pocmosby.widgets.WidgetFactory;
import com.hannesdorfmann.mosby.mvp.viewstate.MvpViewStateFragment;
import com.hannesdorfmann.mosby.mvp.viewstate.ViewState;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by kdevillard on 18-11-16.
 */

public class DashboardFragment extends MvpViewStateFragment<DashboardView, DashboardPresenter> implements DashboardView {
    protected DashboardPresenter presenter;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    //private List<Article> articleList;
    private List<Widget> listWidgets;

    @BindView(R.id.dashboardRecyclerView) RecyclerView mRecyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);

        //articleList = new ArrayList<>();
        listWidgets = new ArrayList<>();
        listWidgets.add(WidgetFactory.getWidget("alarm"));
        listWidgets.add(WidgetFactory.getWidget("graph"));
        listWidgets.add(WidgetFactory.getWidget("indicator"));
        listWidgets.add(WidgetFactory.getWidget("equipment"));
        listWidgets.add(WidgetFactory.getWidget("datacenter"));
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.from(getContext()).inflate(R.layout.fragment_dashboard, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(false);
    }

    @Override
    public ViewState createViewState() { return new DashboardViewState(); }

    @Override
    public DashboardPresenter createPresenter() {
        presenter = new DashboardPresenter();
        return presenter;
    }

    @Override
    public void onNewViewStateInstance() { showDashboardCards(); }

    @Override
    public void showDashboardCards() {
        //Set the view state
        DashboardViewState vs = (DashboardViewState) viewState;
        vs.setShowCards();

        /*articleList.add(new Article("What is Lorem Ipsum?",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
                getContext().getResources().getDrawable(R.drawable.fat_princess)));
        articleList.add(new Article("Why do we use it?",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
                getContext().getResources().getDrawable(R.drawable.fat_princess)));
        articleList.add(new Article("Where does it come from?",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
                getContext().getResources().getDrawable(R.drawable.fat_princess)));*/

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        //mAdapter = new ArticleAdapter(articleList, getContext());
        mAdapter = new WidgetAdapter(listWidgets, getContext());
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void showError() {

    }

    @Override
    public void showLoading() {

    }
}
