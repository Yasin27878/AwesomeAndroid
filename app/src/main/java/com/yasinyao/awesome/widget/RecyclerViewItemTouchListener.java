package com.yasinyao.awesome.widget;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.GestureDetectorCompat;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Description:
 * Author: Yasin Yao
 * Time:2019/7/1
 * @author yasin
 */
public class RecyclerViewItemTouchListener extends RecyclerView.SimpleOnItemTouchListener {
    private OnItemListener mOnItemListener;
    private GestureDetectorCompat mGestureDetector;

    public RecyclerViewItemTouchListener(OnItemListener onItemListener) {
        this.mOnItemListener = onItemListener;
    }

    @Override
    public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
        if (mGestureDetector == null) {
            initGestureDetector(rv);
        }
        // 把事件交给GestureDetector处理
        return mGestureDetector.onTouchEvent(e);
    }

    private void initGestureDetector(final RecyclerView rv) {
        mGestureDetector = new GestureDetectorCompat(rv.getContext(), new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                View childView = rv.findChildViewUnder(e.getX(), e.getY());
                if (childView != null && mOnItemListener != null) {
                    mOnItemListener.onItemClick(rv.getChildAdapterPosition(childView), childView);
                    return true;
                }
                return false;
            }

            /**
             * 长按事件
             */
            @Override
            public void onLongPress(MotionEvent e) {
                View childView = rv.findChildViewUnder(e.getX(), e.getY());
                if (childView != null && mOnItemListener != null) {
                    mOnItemListener.onItemLongClick(rv.getChildAdapterPosition(childView), childView);
                }
            }
        });
    }

    public interface OnItemListener {
        void onItemClick(int position, View view);

        void onItemLongClick(int position, View view);
    }
}
