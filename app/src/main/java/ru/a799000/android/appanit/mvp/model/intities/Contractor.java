package ru.a799000.android.appanit.mvp.model.intities;

/**
 * Created by user on 06.05.2017.
 */

public class Contractor {
    String name;
    String code;

    public Contractor(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
