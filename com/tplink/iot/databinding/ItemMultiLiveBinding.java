package com.tplink.iot.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.MutableLiveData;
import com.tplink.iot.adapter.databinding.e;
import com.tplink.iot.widget.cameralive.VideoSurfaceViewLayout;

public abstract class ItemMultiLiveBinding
  extends ViewDataBinding
{
  @Bindable
  protected com.tplink.iot.adapter.databinding.d H3;
  @Bindable
  protected e I3;
  @Bindable
  protected io.reactivex.m0.d<Integer> J3;
  @Bindable
  protected MutableLiveData<String> K3;
  @NonNull
  public final RelativeLayout c;
  @NonNull
  public final RelativeLayout d;
  @NonNull
  public final FrameLayout f;
  @Bindable
  protected ObservableBoolean p0;
  @Bindable
  protected MutableLiveData<Boolean> p1;
  @Bindable
  protected ObservableBoolean p2;
  @Bindable
  protected ObservableBoolean p3;
  @NonNull
  public final VideoSurfaceViewLayout q;
  @Bindable
  protected String x;
  @Bindable
  protected Integer y;
  @Bindable
  protected MutableLiveData<Integer> z;
  
  protected ItemMultiLiveBinding(Object paramObject, View paramView, int paramInt, RelativeLayout paramRelativeLayout1, RelativeLayout paramRelativeLayout2, FrameLayout paramFrameLayout, VideoSurfaceViewLayout paramVideoSurfaceViewLayout)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramRelativeLayout1;
    this.d = paramRelativeLayout2;
    this.f = paramFrameLayout;
    this.q = paramVideoSurfaceViewLayout;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ItemMultiLiveBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */