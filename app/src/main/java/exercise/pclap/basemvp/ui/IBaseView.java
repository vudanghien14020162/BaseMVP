package exercise.pclap.basemvp.ui;

import android.support.annotation.StringRes;

/**
 * Created by PC Lap on 8/17/2017.
 */
public interface IBaseView {

    int getLayoutView();
    void findViewByIds();
    void initComponents();
    void setEvents();
    void showMsg(String msg);
    void showMsg(@StringRes int msg);
    void showProgress();
    void hideShowProgress();
    void onBackFragment();

}
