package exercise.pclap.basemvp.ui.fragment;

import exercise.pclap.basemvp.ui.IBasePresenter;

/**
 * Created by PC Lap on 8/17/2017.
 */
public abstract class BaseFragmentMVP<P extends IBasePresenter> extends BaseFragment {

    protected P mPresenter;

    @Override
    public void onDestroyView() {
        if(mPresenter != null){
            mPresenter.destroyAction();
        }
        super.onDestroyView();
    }
}
