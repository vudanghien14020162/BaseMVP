package exercise.pclap.basemvp;

import android.support.annotation.StringRes;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import exercise.pclap.basemvp.ui.animation.ScreenAnimation;
import exercise.pclap.basemvp.ui.fragment.BaseFragment;

/**
 * Created by PC Lap on 8/17/2017.
 */
public class FragmentDemo extends BaseFragment implements View.OnClickListener {
    private static final String TAG = FragmentDemo.class.getSimpleName();
    private Button btnShow;

    @Override
    public int getLayoutView() {
        return R.layout.layout_fragment;
    }

    @Override
    public void findViewByIds() {
        btnShow = (Button) getBaseActivity().findViewById(R.id.btn_show);
    }

    @Override
    public void initComponents() {
    }
    @Override
    public void setEvents() {
        btnShow.setOnClickListener(this);
    }
    @Override
    public void showMsg(String msg) {
        super.showMsg("saasdsd");
    }

    @Override
    public void showMsg(@StringRes int msg) {
    }

    @Override
    public void onClick(View v) {
        super.showMsg("asfasd");
        Log.d(TAG, "asdasd");
        MainActivity mainActivity = (MainActivity) getBaseActivity();
        FragmentManager manager = mainActivity.getSupportFragmentManager();
        FragmentTransaction tran = manager.beginTransaction();
        BaseFragment.openFragment(manager, tran, FragmentTwo.class, ScreenAnimation.OPEN_FULL, null, false, false);

    }
}
