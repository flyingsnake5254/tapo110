package androidx.databinding;

import android.view.View;
import android.view.ViewStub;
import android.view.ViewStub.OnInflateListener;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ViewStubProxy
{
  private ViewDataBinding mContainingBinding;
  private ViewStub.OnInflateListener mOnInflateListener;
  private ViewStub.OnInflateListener mProxyListener;
  private View mRoot;
  private ViewDataBinding mViewDataBinding;
  private ViewStub mViewStub;
  
  public ViewStubProxy(@NonNull ViewStub paramViewStub)
  {
    ViewStub.OnInflateListener local1 = new ViewStub.OnInflateListener()
    {
      public void onInflate(ViewStub paramAnonymousViewStub, View paramAnonymousView)
      {
        ViewStubProxy.access$002(ViewStubProxy.this, paramAnonymousView);
        ViewStubProxy localViewStubProxy = ViewStubProxy.this;
        ViewStubProxy.access$102(localViewStubProxy, DataBindingUtil.bind(localViewStubProxy.mContainingBinding.mBindingComponent, paramAnonymousView, paramAnonymousViewStub.getLayoutResource()));
        ViewStubProxy.access$302(ViewStubProxy.this, null);
        if (ViewStubProxy.this.mOnInflateListener != null)
        {
          ViewStubProxy.this.mOnInflateListener.onInflate(paramAnonymousViewStub, paramAnonymousView);
          ViewStubProxy.access$402(ViewStubProxy.this, null);
        }
        ViewStubProxy.this.mContainingBinding.invalidateAll();
        ViewStubProxy.this.mContainingBinding.forceExecuteBindings();
      }
    };
    this.mProxyListener = local1;
    this.mViewStub = paramViewStub;
    paramViewStub.setOnInflateListener(local1);
  }
  
  @Nullable
  public ViewDataBinding getBinding()
  {
    return this.mViewDataBinding;
  }
  
  public View getRoot()
  {
    return this.mRoot;
  }
  
  @Nullable
  public ViewStub getViewStub()
  {
    return this.mViewStub;
  }
  
  public boolean isInflated()
  {
    boolean bool;
    if (this.mRoot != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void setContainingBinding(@NonNull ViewDataBinding paramViewDataBinding)
  {
    this.mContainingBinding = paramViewDataBinding;
  }
  
  public void setOnInflateListener(@Nullable ViewStub.OnInflateListener paramOnInflateListener)
  {
    if (this.mViewStub != null) {
      this.mOnInflateListener = paramOnInflateListener;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\databinding\ViewStubProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */