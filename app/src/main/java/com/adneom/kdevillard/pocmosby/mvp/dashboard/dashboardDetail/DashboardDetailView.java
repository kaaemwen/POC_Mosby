package com.adneom.kdevillard.pocmosby.mvp.dashboard.dashboardDetail;

import com.hannesdorfmann.mosby.mvp.MvpView;

/**
 * Created by kdevillard on 21-11-16.
 */

public interface DashboardDetailView extends MvpView {
    // Shows the detail of one card
    void showDetailCard();

    // Called if error
    void showError();

    // Shows a loading animation while charging card
    void showLoading();
}
