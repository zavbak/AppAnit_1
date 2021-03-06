package ru.a799000.android.appanit.ui.fragments;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.arellomobile.mvp.MvpFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ru.a799000.android.appanit.R;
import ru.a799000.android.appanit.mvp.presenters.ListScreenPresenter;
import ru.a799000.android.appanit.mvp.views.ListScreenView;
import ru.a799000.android.appanit.ui.adapters.RecyclerAdapter;


public class ListFragment extends MvpFragment implements ListScreenView {
    public static final String TAG = "ListFragment";

    @InjectPresenter
    ListScreenPresenter mListPresenter;


    @BindView(R.id.my_recycler_view)
    RecyclerView mRecyclerView;

    @BindView(R.id.srl_container)
    SwipeRefreshLayout mSwipeRefreshLayout;



    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;



    public static ListFragment newInstance() {
        ListFragment fragment = new ListFragment();

        Bundle args = new Bundle();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_list, container, false);

        ButterKnife.bind(this, view);

        initRcycledView();

        return view;
    }


    void initRcycledView(){
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);


        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mListPresenter.onRefresh();

                // указываем, что мы уже сделали все, что нужно было
                // убираем стандартную анимацию
                mSwipeRefreshLayout.setRefreshing(false);
            }
        });

    }




    @Override
    public void onViewCreated(final View view, final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }



    @Override
    public void refresh() {
        mAdapter = new RecyclerAdapter(mListPresenter.getContractors());
        mRecyclerView.setAdapter(mAdapter);
    }
}
