package sharedlibrary.mvvm.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Patrick Hsiao on 2016/8/24.
 */
public class RecyclerBindingAdapter<T> extends BaseRecyclerAdapter<T, RecyclerBindingAdapter.BindingHolder> {
    private OnItemClickListener onItemClickListener;
    private @LayoutRes int holderLayout;
    private int variableId;

    public RecyclerBindingAdapter(int holderLayout, int variableId) {
        this.holderLayout = holderLayout;
        this.variableId = variableId;
    }

    @Override
    public BindingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(holderLayout, parent, false);
        return new BindingHolder(v);
    }

    @Override
    public void onBindViewHolder(BindingHolder holder, int position) {
        final T item = dataList.get(position);
        holder.setOnItemClickListener(onItemClickListener);
        holder.getBinding().setVariable(variableId, item);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public static class BindingHolder extends RecyclerView.ViewHolder {
        private ViewDataBinding binding;
        private OnItemClickListener onItemClickListener;

        public BindingHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
            if (onItemClickListener != null) {
                binding.getRoot().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onItemClickListener.onItemClick(getAdapterPosition());
                    }
                });
            }
        }

        public ViewDataBinding getBinding() {
            return binding;
        }

        public void setOnItemClickListener(OnItemClickListener listener) {
            this.onItemClickListener = listener;
        }
    }
}
