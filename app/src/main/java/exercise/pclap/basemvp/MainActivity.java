package exercise.pclap.basemvp;

import android.support.annotation.StringRes;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;

import exercise.pclap.basemvp.ui.activity.BaseActivity;
import exercise.pclap.basemvp.ui.animation.ScreenAnimation;
import exercise.pclap.basemvp.ui.fragment.BaseFragment;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private Button btnShow;

    @Override
    public int getLayoutView() {
        return R.layout.activity_main;
    }

    @Override
    public void findViewByIds() {
        btnShow = (Button) findViewById(R.id.btn_show);
    }

    @Override
    public void initComponents() {
    }

    @Override
    public void setEvents() {
        btnShow.setOnClickListener(this);
    }

    @Override
    public void showMsg(@StringRes int msg) {

    }

    @Override
    public void onClick(View v) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        BaseFragment.openFragment(manager, transaction, FragmentDemo.class, ScreenAnimation.OPEN_FULL, null, false, false);
    }
}
