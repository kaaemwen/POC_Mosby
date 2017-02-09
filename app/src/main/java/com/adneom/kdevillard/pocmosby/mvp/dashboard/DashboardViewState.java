package com.adneom.kdevillard.pocmosby.mvp.dashboard;

import com.hannesdorfmann.mosby.mvp.viewstate.ViewState;

/**
 * Created by kdevillard on 18-11-16.
 */

public class DashboardViewState implements ViewState<DashboardView> {
    final int STATE_SHOW_CARDS = 0;
    final int STATE_SHOW_LOADING = 1;
    final int STATE_SHOW_ERROR = 2;

    int state = STATE_SHOW_CARDS;

    public void setShowCards() {
        state = STATE_SHOW_CARDS;
    }
    public void setShowError() {
        state = STATE_SHOW_ERROR;
    }
    public void setShowLoading() { state = STATE_SHOW_LOADING; }

    /**
     * Is called from Mosby to apply the view state to the view.
     * We do that by calling the methods from the View interface (like the presenter does)
     */
    @Override public void apply(DashboardView view, boolean retained) {
        switch (state) {
            case STATE_SHOW_LOADING:
                view.showLoading();
                break;

            case STATE_SHOW_ERROR:
                view.showError();
                break;

            case STATE_SHOW_CARDS:
                view.showDashboardCards();
                break;
        }
    }
}
