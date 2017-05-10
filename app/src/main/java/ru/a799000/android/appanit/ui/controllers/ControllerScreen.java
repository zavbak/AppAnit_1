package ru.a799000.android.appanit.ui.controllers;



import android.app.Fragment;
import android.app.FragmentManager;

import ru.a799000.android.appanit.R;
import ru.a799000.android.appanit.ui.fragments.ListFragment;
import ru.a799000.android.appanit.ui.fragments.ListScreenFragment;



public class ControllerScreen {

    FragmentManager mFragmentManager;

    public ControllerScreen(FragmentManager fragmentManager) {
        mFragmentManager = fragmentManager;
    }

    public void startListScreen(){
        Fragment fragment = ListFragment.newInstance();

        mFragmentManager.beginTransaction()          // получаем экземпляр FragmentTransaction
                .replace(R.id.main_activity_frame_layout, fragment)
                //.addToBackStack("myStack")
                .commit();
    }
}
