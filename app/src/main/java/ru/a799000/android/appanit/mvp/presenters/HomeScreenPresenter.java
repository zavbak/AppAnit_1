package ru.a799000.android.appanit.mvp.presenters;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import ru.a799000.android.appanit.mvp.views.HomeView;


@InjectViewState
public class HomeScreenPresenter extends MvpPresenter<HomeView> {

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        showScreenList();
    }


    public void showScreenList(){
        getViewState().showList();
    }

}
