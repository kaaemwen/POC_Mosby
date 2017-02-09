package com.adneom.kdevillard.pocmosby.mvp.dashboard.dashboardDetail;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;

import javax.inject.Inject;

/**
 * Created by kdevillard on 21-11-16.
 */

public class DashboardDetailPresenter extends MvpBasePresenter<DashboardDetailView> {

    @Inject
    public DashboardDetailPresenter(){}

    @Override
    public void detachView(boolean retainInstance) { super.detachView(retainInstance); }

    @Override
    public void attachView(DashboardDetailView view) { super.attachView(view); }
}
