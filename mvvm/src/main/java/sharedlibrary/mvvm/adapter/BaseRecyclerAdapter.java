package sharedlibrary.mvvm.adapter;

import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

/**
 * Created by Patrick Hsiao on 2016/8/24.
 */
public abstract class BaseRecyclerAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {
    protected final ArrayList<T> dataList = new ArrayList<>();

    public void insert(int position, T data) {
        dataList.add(position, data);
        notifyItemInserted(position);
    }

    public void add(T data) {
        insert(dataList.size(), data);
    }

    public void remove(int position) {
        dataList.remove(position);
        notifyItemRemoved(position);
    }

    public void clear() {
        int size = dataList.size();
        dataList.clear();
        notifyItemRangeRemoved(0, size);
    }

    public T getItem(int position) {
        return dataList.get(position);
    }
}
