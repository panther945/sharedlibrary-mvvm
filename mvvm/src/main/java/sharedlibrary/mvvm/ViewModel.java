package sharedlibrary.mvvm;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.CallSuper;
import android.support.annotation.StringRes;
import android.support.v4.app.FragmentActivity;

import rx.Subscription;

/**
 * Created by Patrick Hsiao on 2016/8/17.
 */
public abstract class ViewModel {
    private ViewInterface view;
    private Subscription subscription;

    public void bindView(ViewInterface view) {
        this.view = view;
    }

    public void onResume() {

    }

    public void onPause() {

    }

    @CallSuper
    public void onViewAttached() {

    }

    @CallSuper
    public void onViewDetached() {
        unsubscribe();
        view = null;
    }

    public ViewInterface getView() {
        return view;
    }

    public Context getContext() {
        return view != null ? view.getContext() : null;
    }

    public FragmentActivity getActivity() {
        return view != null ? view.getActivity() : null;
    }

    public String getString(@StringRes int resId) {
        return view != null ? view.getContext().getString(resId) : null;
    }

    public Resources getResources() {
        return view != null ? getContext().getResources() : null;
    }

    protected void subscribe(Subscription subscriber) {
        unsubscribe();
        subscription = subscriber;
    }

    protected void unsubscribe() {
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }
}
