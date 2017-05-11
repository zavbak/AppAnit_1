package ru.a799000.android.appanit.mvp.presenters;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.Date;
import java.util.List;

import ru.a799000.android.appanit.mvp.model.intities.Contractor;
import ru.a799000.android.appanit.mvp.repository.TestApi;
import ru.a799000.android.appanit.mvp.views.HomeView;
import ru.a799000.android.appanit.mvp.views.ListScreenView;

/**
 * Created by Alex on 10.05.2017.
 */

@InjectViewState
public class ListScreenPresenter extends MvpPresenter<ListScreenView> {

    List<Contractor> mContractors;

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        getViewState().refresh();
    }



    void refreshContractors(){
        mContractors = TestApi.getList();
    }

    public List<Contractor> getContractors(){
        if(mContractors == null){
            refreshContractors();
        }
        return mContractors;
    }




    public void onRefresh() {
        refreshContractors();
        getViewState().refresh();
    }
}
