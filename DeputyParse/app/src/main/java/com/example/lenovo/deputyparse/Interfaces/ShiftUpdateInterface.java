package com.example.lenovo.deputyparse.Interfaces;

/**
 * Created by lenovo on 2/23/2018.
 */
        import android.view.View;

        import java.util.ArrayList;

/**
 * Created by LeakSun on 10/31/2017.
 */

public interface ShiftUpdateInterface {

    void addMorningData(ArrayList<String> onshiftNames);

    void addAfternoonData(ArrayList<String> onshiftNames);

    void addEveningData(ArrayList<String> onshiftNames);

    int getMorningDataCount();

    int getAfternoonDataCount();

    int getEveningDataCount();

    View getLayout();
}
