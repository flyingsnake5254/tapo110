package com.tplink.iot.databinding;

import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.view.ipcamera.widget.CameraLoadingView;
import com.tplink.iot.view.ipcamera.widget.calendar.b;
import com.tplink.iot.view.ipcamera.widget.calendar.c;
import com.tplink.iot.view.ipcamera.widget.timeaxis.TimeAxisLayout.b;
import com.tplink.iot.viewmodel.ipcamera.play.PlayBackControlViewModel;

public abstract class FragmentPlayBackControlBinding
  extends ViewDataBinding
{
  @Bindable
  protected c H3;
  @NonNull
  public final CameraLoadingView c;
  @NonNull
  public final PlayBackDateSelectorBinding d;
  @NonNull
  public final PlayBackRulerLayoutBinding f;
  @Bindable
  protected g p0;
  @Bindable
  protected b p1;
  @Bindable
  protected PlayBackControlViewModel p2;
  @Bindable
  protected TimeAxisLayout.b p3;
  @NonNull
  public final PlayBackTopBarBinding q;
  @NonNull
  public final View x;
  @NonNull
  public final RelativeLayout y;
  @NonNull
  public final View z;
  
  protected FragmentPlayBackControlBinding(Object paramObject, View paramView1, int paramInt, CameraLoadingView paramCameraLoadingView, PlayBackDateSelectorBinding paramPlayBackDateSelectorBinding, PlayBackRulerLayoutBinding paramPlayBackRulerLayoutBinding, PlayBackTopBarBinding paramPlayBackTopBarBinding, View paramView2, RelativeLayout paramRelativeLayout, View paramView3)
  {
    super(paramObject, paramView1, paramInt);
    this.c = paramCameraLoadingView;
    this.d = paramPlayBackDateSelectorBinding;
    this.f = paramPlayBackRulerLayoutBinding;
    this.q = paramPlayBackTopBarBinding;
    this.x = paramView2;
    this.y = paramRelativeLayout;
    this.z = paramView3;
  }
  
  public abstract void h(@Nullable b paramb);
  
  public abstract void i(@Nullable c paramc);
  
  public abstract void l(@Nullable g paramg);
  
  public abstract void m(@Nullable TimeAxisLayout.b paramb);
  
  public abstract void n(@Nullable PlayBackControlViewModel paramPlayBackControlViewModel);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentPlayBackControlBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */