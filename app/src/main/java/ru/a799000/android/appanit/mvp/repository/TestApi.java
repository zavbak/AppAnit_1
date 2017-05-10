package ru.a799000.android.appanit.mvp.repository;


import java.util.Date;
import java.util.List;

import ru.a799000.android.appanit.mvp.model.intities.Contractor;
import rx.Observable;


/**
 * Created by user on 10.05.2017.
 */

public class TestApi {

    public static List<Contractor> getList(){


        List<Contractor> list =  Observable.range(0, 50)
                .map(i -> new Contractor("Item " + i + " - "+ new Date(),""+i))
                .toList().toBlocking().single();

        return list;
    }
}
