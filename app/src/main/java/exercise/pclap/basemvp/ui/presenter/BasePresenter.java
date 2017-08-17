package exercise.pclap.basemvp.ui.presenter;

import exercise.pclap.basemvp.ui.IBasePresenter;
import exercise.pclap.basemvp.ui.IBaseView;

/**
 * Created by PC Lap on 8/17/2017.
 */
public abstract class BasePresenter<T extends IBaseView> implements IBasePresenter{

    protected T mBaseView;

}
