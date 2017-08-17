package exercise.pclap.basemvp.ui.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import exercise.pclap.basemvp.ui.IBaseView;
import exercise.pclap.basemvp.ui.fragment.BaseFragment;

/**
 * Created by PC Lap on 8/17/2017.
 */
public abstract class BaseActivity extends AppCompatActivity implements IBaseView {
    protected boolean mIsDestroy;
    protected ProgressDialog mDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutView());
        mIsDestroy = false;
        mDialog = new ProgressDialog(this);
        findViewByIds();
        initComponents();
        setEvents();
    }

    @Override
    public abstract int getLayoutView();
    @Override
    public abstract void findViewByIds();
    @Override
    public abstract void initComponents();
    @Override
    public abstract void setEvents();
    @Override
    public void showMsg(String msg){
        Toast.makeText(BaseActivity.this, "assad", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgress() {
        if(mIsDestroy == false){
            mDialog.show();
        }
    }

    @Override
    public void hideShowProgress() {
        if(mDialog.isShowing() && mIsDestroy == false){
            mDialog.hide();
        }
    }
    //1
    @Override
    public void onBackPressed() {
        onBackFragment();
    }

    //2
    @Override
    public void onBackFragment() {
        BaseFragment baseFragment = BaseFragment.getFragmentNow(getSupportFragmentManager());
        if(baseFragment == null){
            return;
        }
        //3
        baseFragment.onBackFragment();
    }

    @Override
    protected void onDestroy() {
        mIsDestroy = true;
        super.onDestroy();
    }

    public final void onBackMain() {
        super.onBackPressed();
    }

}
