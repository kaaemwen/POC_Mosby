package com.adneom.kdevillard.pocmosby.mvp.dashboard;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.adneom.kdevillard.pocmosby.R;
import com.adneom.kdevillard.pocmosby.mvp.dashboard.dashboardDetail.DashboardDetailFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by kdevillard on 18-11-16.
 */

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        setContentView(R.layout.activity_dashboard);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .addToBackStack("dashboard")
                    .replace(R.id.homeContainer, new DashboardFragment())
                    .commit();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                System.out.println("--------- back : " + getSupportFragmentManager().getFragments().size());
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.homeContainer, new DashboardFragment())
                        .commit();
                //getSupportFragmentManager().popBackStack();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onContentChanged() {
        super.onContentChanged();
    }
}
