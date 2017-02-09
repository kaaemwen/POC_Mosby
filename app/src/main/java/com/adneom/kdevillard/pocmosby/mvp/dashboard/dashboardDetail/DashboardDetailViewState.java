package com.adneom.kdevillard.pocmosby.mvp.dashboard.dashboardDetail;

import com.hannesdorfmann.mosby.mvp.viewstate.ViewState;

/**
 * Created by kdevillard on 21-11-16.
 */

public class DashboardDetailViewState implements ViewState<DashboardDetailView> {
    final int STATE_SHOW_CARD = 0;
    final int STATE_SHOW_LOADING = 1;
    final int STATE_SHOW_ERROR = 2;

    int state = STATE_SHOW_CARD;

    public void setShowDetailCard() {
        state = STATE_SHOW_CARD;
    }

    public void setShowError() {
        state = STATE_SHOW_ERROR;
    }

    public void setShowLoading() { state = STATE_SHOW_LOADING; }

    /**
     * Is called from Mosby to apply the view state to the view.
     * We do that by calling the methods from the View interface (like the presenter does)
     */
    @Override public void apply(DashboardDetailView view, boolean retained) {
        switch (state) {
            case STATE_SHOW_LOADING:
                view.showLoading();
                break;

            case STATE_SHOW_ERROR:
                view.showError();
                break;

            case STATE_SHOW_CARD:
                view.showDetailCard();
                break;

        }
    }
}
