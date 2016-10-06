package sharedlibrary.mvvm;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;

/**
 * Created by Patrick Hsiao on 2016/8/17.
 */
public interface ViewInterface {
    Context getContext();
    FragmentActivity getActivity();
    void startActivity(Intent intent);
    void startActivityForResult(Intent intent, int requestCode);
    BindingConfig getBindingConfig();
}
