package sharedlibrary.mvvm.adapter;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;

import sharedlibrary.andorid.BR;

/**
 * Created by Patrick Hsiao on 2016/8/25.
 */
public class RecyclerConfiguration extends BaseObservable {
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;

    public RecyclerConfiguration(RecyclerView.LayoutManager layoutManager, RecyclerView.Adapter adapter) {
        this.layoutManager = layoutManager;
        this.adapter = adapter;
    }

    @Bindable
    public RecyclerView.LayoutManager getLayoutManager() {
        return layoutManager;
    }

    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        this.layoutManager = layoutManager;
        notifyPropertyChanged(BR.layoutManager);
    }

    @Bindable
    public RecyclerView.Adapter getAdapter() {
        return adapter;
    }

    public void setAdapter(RecyclerView.Adapter adapter) {
        this.adapter = adapter;
        notifyPropertyChanged(BR.adapter);
    }

    public static class Builder {
        private RecyclerView.LayoutManager layoutManager;
        private RecyclerView.Adapter adapter;

        public Builder setLayoutManager(RecyclerView.LayoutManager layoutManager) {
            this.layoutManager = layoutManager;
            return this;
        }

        public Builder setAdapter(RecyclerView.Adapter adapter) {
            this.adapter = adapter;
            return this;
        }

        public RecyclerConfiguration create() {
            return new RecyclerConfiguration(layoutManager, adapter);
        }
    }

    @BindingAdapter("config")
    public static void configureRecyclerView(RecyclerView recyclerView, RecyclerConfiguration configuration) {
        recyclerView.setLayoutManager(configuration.getLayoutManager());
        recyclerView.setAdapter(configuration.getAdapter());
    }
}
