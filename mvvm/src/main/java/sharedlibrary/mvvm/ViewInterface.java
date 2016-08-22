package sharedlibrary.mvvm;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Patrick Hsiao on 2016/8/17.
 */
public interface ViewInterface {
    Context getContext();
    Activity getActivity();
    void startActivity(Intent intent);
    void startActivityForResult(Intent intent, int requestCode);
    BindingConfig getBindingConfig();
}
