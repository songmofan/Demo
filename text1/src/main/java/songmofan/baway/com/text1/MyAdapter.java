package songmofan.baway.com.text1;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * 类的作用：
 * <p>
 * 作者： 宋莫凡
 * <p>
 * 思路：
 * <p>
 * on 2017/8/14 16
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder> {

    private Context contexts;
    private List<String> list = new ArrayList<>();
    private OnItimClickLisenter onItimClickLisenters;

    public MyAdapter(Context context, List<String> data) {
        this.contexts = context;
        this.list = data;
    }

    public interface OnItimClickLisenter {
        void onItimClick(View view, int position);
    }

    public void setOnItimClickLisenter(OnItimClickLisenter onItimClickLisenter) {
        this.onItimClickLisenters = onItimClickLisenter;

    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(contexts, R.layout.layout, null);
        MyHolder holder = new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, final int position) {
        holder.tv.setText(list.get(position));
        if (onItimClickLisenters!=null) {
            holder.item_layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItimClickLisenters.onItimClick(v,position);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        private final TextView tv;
        private final RelativeLayout item_layout;

        public MyHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.tv);
            item_layout = (RelativeLayout) itemView.findViewById(R.id.item_layout);
        }
    }
}
