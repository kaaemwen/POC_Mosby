package com.adneom.kdevillard.pocmosby.mvp.dashboard;

import com.adneom.kdevillard.pocmosby.mvp.model.Article;
import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;

import javax.inject.Inject;

/**
 * Created by kdevillard on 18-11-16.
 */

public class DashboardPresenter extends MvpBasePresenter<DashboardView> {

    @Inject
    public DashboardPresenter(){}

    @Override
    public void detachView(boolean retainInstance) { super.detachView(retainInstance); }

    @Override
    public void attachView(DashboardView view) { super.attachView(view); }
}