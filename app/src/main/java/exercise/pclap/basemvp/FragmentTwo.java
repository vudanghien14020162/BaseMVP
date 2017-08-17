package exercise.pclap.basemvp;

import android.support.annotation.StringRes;

import exercise.pclap.basemvp.ui.fragment.BaseFragment;

/**
 * Created by PC Lap on 8/17/2017.
 */
public class FragmentTwo extends BaseFragment {
    @Override
    public int getLayoutView() {
        return R.layout.layout_fragment_two;
    }

    @Override
    public void findViewByIds() {
    }

    @Override
    public void initComponents() {
    }

    @Override
    public void setEvents() {
    }

    @Override
    public void showMsg(@StringRes int msg) {

    }
}
