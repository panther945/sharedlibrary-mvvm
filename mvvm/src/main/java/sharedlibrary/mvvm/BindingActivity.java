package sharedlibrary.mvvm;

import android.app.Activity;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Patrick Hsiao on 2016/8/17.
 */
public abstract class BindingActivity<V extends ViewDataBinding, T extends ViewModel> extends AppCompatActivity
        implements ViewInterface {
    protected V binding;
    protected T viewModel;
    protected abstract T createViewModel();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, getBindingConfig().getLayoutResource());
        viewModel = createViewModel();

        if (viewModel != null) {
            viewModel.bindView(this);
            binding.setVariable(getBindingConfig().getVariableName(), viewModel);
            viewModel.onViewAttached();
        }
    }

    @Override
    public Context getContext() {
        return getActivity();
    }

    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    protected void onResume() {
        super.onResume();
        viewModel.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        viewModel.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        viewModel.onViewDetached();
    }
}
