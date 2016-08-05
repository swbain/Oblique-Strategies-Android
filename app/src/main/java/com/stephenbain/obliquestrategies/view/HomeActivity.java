package com.stephenbain.obliquestrategies.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import com.stephenbain.obliquestrategies.MyApplication;
import com.stephenbain.obliquestrategies.R;

import javax.inject.Inject;

public class HomeActivity extends AppCompatActivity implements HomePresenter.HomeView {

    @Inject HomePresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MyApplication.getComponent().inject(this);

        setContentView(R.layout.activity_home);

        presenter.attach(this);
        presenter.present();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        presenter.detach();
    }
}