package com.tplink.iot.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.widget.tipsbar.TipsBar;

public abstract class ActivityPlaybackNewIpcBinding
  extends ViewDataBinding
{
  @NonNull
  public final FrameLayout c;
  @NonNull
  public final RelativeLayout d;
  @NonNull
  public final TipsBar f;
  @NonNull
  public final FrameLayout q;
  
  protected ActivityPlaybackNewIpcBinding(Object paramObject, View paramView, int paramInt, FrameLayout paramFrameLayout1, RelativeLayout paramRelativeLayout, TipsBar paramTipsBar, FrameLayout paramFrameLayout2)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramFrameLayout1;
    this.d = paramRelativeLayout;
    this.f = paramTipsBar;
    this.q = paramFrameLayout2;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityPlaybackNewIpcBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */