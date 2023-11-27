package com.yasinyao.awesome.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;

public class FlyInItemAnimator extends SimpleItemAnimator {
    public static final String TAG = "FlyInItemAnimator";
    private static final int ANIMATION_DURATION = 300;
    private static final int ITEM_DELAY = 100;

    @Override
    public boolean animateRemove(RecyclerView.ViewHolder holder) {
        return false;
    }

    @Override
    public boolean animateAdd(RecyclerView.ViewHolder holder) {
        final View view = holder.itemView;
        Log.d(TAG, "animateAdd: ");

        // 设置初始状态，使列表项位于屏幕的一侧
        view.setTranslationX(-view.getWidth());

        // 为每个列表项添加适当的延迟
        long delay = holder.getAdapterPosition() * ITEM_DELAY;

        // 创建动画并设置持续时间和延迟
        ObjectAnimator animator = ObjectAnimator.ofFloat(view, "translationX", 0);
        animator.setDuration(ANIMATION_DURATION);
        animator.setStartDelay(delay);

        // 设置动画结束监听器，以执行适当的清理工作
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                //dispatchAddFinished(holder);
            }
        });

        // 启动动画
        animator.start();

        return true;
    }

    @Override
    public boolean animateMove(RecyclerView.ViewHolder holder, int fromX, int fromY, int toX, int toY) {
        return false;
    }

    @Override
    public boolean animateChange(RecyclerView.ViewHolder oldHolder, RecyclerView.ViewHolder newHolder, int fromLeft, int fromTop, int toLeft, int toTop) {
        return false;
    }

    @Override
    public void runPendingAnimations() {

    }

    @Override
    public void endAnimation(@NonNull RecyclerView.ViewHolder item) {

    }

    @Override
    public void endAnimations() {

    }

    @Override
    public boolean isRunning() {
        return true;
    }


    // 省略其他方法的实现
}