package ru.a799000.android.appanit.ui.activitys;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


import com.arellomobile.mvp.MvpActivity;
import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import ru.a799000.android.appanit.R;
import ru.a799000.android.appanit.mvp.presenters.HomeScreenPresenter;
import ru.a799000.android.appanit.mvp.views.HomeView;
import ru.a799000.android.appanit.ui.controllers.ControllerScreen;

public class MainActivity extends MvpAppCompatActivity implements HomeView {

    ControllerScreen mControllerScreen;

    @InjectPresenter
    HomeScreenPresenter mHomeScreenPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mControllerScreen = new ControllerScreen(getFragmentManager());
    }

    @Override
    public void showList() {
        mControllerScreen.startListScreen();
    }
}
