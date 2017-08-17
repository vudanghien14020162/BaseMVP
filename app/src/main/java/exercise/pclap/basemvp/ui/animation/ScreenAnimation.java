package exercise.pclap.basemvp.ui.animation;

import exercise.pclap.basemvp.R;

/**
 * Created by PC Lap on 8/17/2017.
 */
public enum ScreenAnimation {

    OPEN_FULL(R.anim.enter_left_to_right, R.anim.exit_left_to_right,
            R.anim.enter_right_to_left, R.anim.exit_right_to_left),

    NONE(0,0,0,0);

    private int enter_left_to_right;
    private int exit_left_to_right;
    private int enter_right_to_left;
    private int exit_right_to_left;

    ScreenAnimation(int enter_left_to_right, int exit_left_to_right, int enter_right_to_left, int exit_right_to_left) {
        this.enter_left_to_right = enter_left_to_right;
        this.exit_left_to_right = exit_left_to_right;
        this.enter_right_to_left = enter_right_to_left;
        this.exit_right_to_left = exit_right_to_left;
    }

    public int getEnter_left_to_right() {
        return enter_left_to_right;
    }

    public int getExit_left_to_right() {
        return exit_left_to_right;
    }

    public int getEnter_right_to_left() {
        return enter_right_to_left;
    }

    public int getExit_right_to_left() {
        return exit_right_to_left;
    }
}
