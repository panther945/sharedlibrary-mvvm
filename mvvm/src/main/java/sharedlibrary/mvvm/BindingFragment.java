package sharedlibrary.mvvm;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Patrick Hsiao on 2016/8/18.
 */
public abstract class BindingFragment<V extends ViewDataBinding, T extends ViewModel> extends Fragment
        implements ViewInterface {
    protected V binding;
    protected T viewModel;
    protected abstract T createViewModel();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, getBindingConfig().getLayoutResource(), container, false);
        viewModel = createViewModel();
        if (viewModel != null) {
            viewModel.bindView(this);
            binding.setVariable(getBindingConfig().getVariableName(), viewModel);
            viewModel.onViewAttached();
        }

        return binding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        viewModel.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        viewModel.onPause();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        viewModel.onViewDetached();
    }
}
