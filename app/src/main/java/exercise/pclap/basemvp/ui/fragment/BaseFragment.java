package exercise.pclap.basemvp.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import exercise.pclap.basemvp.R;
import exercise.pclap.basemvp.ui.IBaseView;
import exercise.pclap.basemvp.ui.activity.BaseActivity;
import exercise.pclap.basemvp.ui.animation.ScreenAnimation;

/**
 * Created by PC Lap on 8/17/2017.
 */
public abstract class BaseFragment extends Fragment implements IBaseView {
    private boolean mIsDestroy;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mIsDestroy = false;

    }

    //return base activity de thuc hien cac buoc anh xa va on click cho view trong giao dien
    public BaseActivity getBaseActivity() {
        BaseActivity baseActivity = (BaseActivity) getActivity();
        return baseActivity;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutView(), container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        findViewByIds();
        initComponents();
        setEvents();
    }

    @Override
    public abstract int getLayoutView();

    @Override
    public abstract void setEvents();

    @Override
    public void showProgress() {
        if (mIsDestroy) {
            return;
        }
        getBaseActivity().showProgress();
    }

    @Override
    public void hideShowProgress() {
        if (mIsDestroy) {
            return;
        }
        getBaseActivity().hideShowProgress();
    }

    @Override
    public void showMsg(String msg) {
//        Toast.makeText(getBaseActivity(), msg, Toast.LENGTH_SHORT).show();
    }

    //open fragment
    public static void openFragment(FragmentManager manager,
                                    FragmentTransaction tran,
                                    Class<? extends BaseFragment> classFragment,
                                    ScreenAnimation animation,
                                    Bundle bundle,
                                    boolean isCommit,
                                    boolean isAddBackStack
    ) {

        String tag = classFragment.getSimpleName().toString();
        //kiem tra xem trong mnager co fragment do chua
        BaseFragment baseFragment = (BaseFragment) manager.findFragmentByTag(tag);

        if (baseFragment == null) {
            try {
                baseFragment = classFragment.newInstance();
                tran.setCustomAnimations(animation.getEnter_left_to_right(), animation.getExit_left_to_right(),
                        animation.getEnter_right_to_left(), animation.getExit_right_to_left());
                baseFragment.setArguments(bundle);
                tran.replace(R.id.fr_content, baseFragment, tag);

            } catch (java.lang.InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        } else {

            if (baseFragment.isVisible()) {
                return;
            }

            tran.setCustomAnimations(
                    animation.getEnter_left_to_right(),
                    animation.getExit_left_to_right(),
                    animation.getEnter_right_to_left(),
                    animation.getExit_right_to_left()
            );
            tran.show(baseFragment);
        }

        if (!isAddBackStack) {
            tran.addToBackStack(tag);
        }
        if (!isCommit) {
            tran.commit();
        }
    }

    public static void closeFragment(FragmentManager manager,
                                     FragmentTransaction tran,
                                     Class<? extends BaseFragment> classFragment,
                                     ScreenAnimation animation,
                                     Bundle bundle,
                                     boolean isCommit,
                                     boolean isAddBackStack) {
        String tag = classFragment.getSimpleName().toString();
        BaseFragment fragment = (BaseFragment) manager.findFragmentByTag(tag);

        if (fragment != null && fragment.isVisible()) {
            tran.setCustomAnimations(
                    animation.getEnter_right_to_left(),
                    animation.getExit_right_to_left(),
                    animation.getEnter_left_to_right(),
                    animation.getExit_left_to_right());
            fragment.setArguments(bundle);

            tran.hide(fragment);
            if (!isAddBackStack) {
                tran.addToBackStack(tag);
            }
            if (!isCommit) {
                tran.commit();
            }
        }
    }


    @Override
    public void onBackFragment() {

        getBaseActivity().onBackMain();

    }

    //lay ra fragmnet hien tai
    public static BaseFragment getFragmentNow(FragmentManager manager) {
        List<Fragment> listFragment = manager.getFragments();
        if(listFragment.size() == 0){
            return null;
        }

        for(int i = listFragment.size() - 1; i >= 0; i--){

            BaseFragment fragmentNow = (BaseFragment) listFragment.get(i);
            if(fragmentNow != null && fragmentNow.isVisible()){
                return fragmentNow;
            }
        }
        return null;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
