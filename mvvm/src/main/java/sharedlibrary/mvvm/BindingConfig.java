package sharedlibrary.mvvm;

import android.support.annotation.LayoutRes;

/**
 * Created by Patrick Hsiao on 2016/8/17.
 */
public class BindingConfig {
    @LayoutRes int layoutResource;
    int variableName;

    public BindingConfig(int layoutResource, int variableName) {
        this.layoutResource = layoutResource;
        this.variableName = variableName;
    }

    public int getLayoutResource() {
        return layoutResource;
    }

    public int getVariableName() {
        return variableName;
    }
}
