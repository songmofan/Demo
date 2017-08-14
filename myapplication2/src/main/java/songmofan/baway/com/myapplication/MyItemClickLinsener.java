package songmofan.baway.com.myapplication;

import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * 类的作用：
 * <p>
 * 作者： 宋莫凡
 * <p>
 * 思路：
 * <p>
 * on 2017/8/14 19
 */

public abstract class MyItemClickLinsener extends RecyclerView.SimpleOnItemTouchListener {

    private RecyclerView mrecyclerView;
    private final GestureDetectorCompat gestureDetectorCompat;

    public MyItemClickLinsener(RecyclerView recyclerView) {
        this.mrecyclerView = recyclerView;
        gestureDetectorCompat = new GestureDetectorCompat(recyclerView.getContext(), new MyGestureListener());
    }


    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        gestureDetectorCompat.onTouchEvent(e);
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        gestureDetectorCompat.onTouchEvent(e);
        return false;
    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        super.onRequestDisallowInterceptTouchEvent(disallowIntercept);
    }

    //定义一个回调方法
    public abstract void setOnItemClick(RecyclerView.ViewHolder viewHolder);
    class MyGestureListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            View childViewUnder = mrecyclerView.findChildViewUnder(e.getX(), e.getY());
            if (childViewUnder != null) {
                RecyclerView.ViewHolder viewHolder = mrecyclerView.getChildViewHolder(childViewUnder);
                setOnItemClick(viewHolder);
            }
            return true;
        }
    }

}
