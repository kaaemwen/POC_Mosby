package com.adneom.kdevillard.pocmosby.mvp.dashboard;

import com.hannesdorfmann.mosby.mvp.MvpView;

/**
 * Created by kdevillard on 18-11-16.
 */

public interface DashboardView extends MvpView {
    // Shows the list of cards
    void showDashboardCards();

    // Called if error
    void showError();

    // Shows a loading animation while charging cards
    void showLoading();
}
