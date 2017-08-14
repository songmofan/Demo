package songmofan.baway.com.text1;

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
 * on 2017/8/14 16
 */

public abstract class MyItemClikLisener extends RecyclerView.SimpleOnItemTouchListener {
    private RecyclerView mrecyclerView;
    private final GestureDetectorCompat mGestureDetectorCompat;

    public MyItemClikLisener(RecyclerView recyclerView) {
        this.mrecyclerView = recyclerView;
        mGestureDetectorCompat = new GestureDetectorCompat(mrecyclerView.getContext(), new MyGestureListener());

    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        mGestureDetectorCompat.onTouchEvent(e);
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        mGestureDetectorCompat.onTouchEvent(e);
        return false;
    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        super.onRequestDisallowInterceptTouchEvent(disallowIntercept);
    }
     public  abstract  void  onItemClick(RecyclerView.ViewHolder viewHolder);

    public class MyGestureListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            View childView = mrecyclerView.findChildViewUnder(e.getX(), e.getY());
            if (childView!=null) {
                RecyclerView.ViewHolder viewHolder = mrecyclerView.getChildViewHolder(childView);

              onItemClick(viewHolder);

            }

            return true;
        }
    }
}
