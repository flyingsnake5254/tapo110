package com.tplink.iot.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.widget.PointTextView;
import com.tplink.iot.widget.viewgroup.ToastTipBarView;
import com.tplink.libtpcontrols.tprefreshablebutton.TPRefreshableButton;

public abstract class ActivityTrvSetProgressCalibrationBinding
  extends ViewDataBinding
{
  @NonNull
  public final TPRefreshableButton c;
  @NonNull
  public final ToastTipBarView d;
  @NonNull
  public final View f;
  @NonNull
  public final PointTextView q;
  @NonNull
  public final PointTextView x;
  
  protected ActivityTrvSetProgressCalibrationBinding(Object paramObject, View paramView1, int paramInt, TPRefreshableButton paramTPRefreshableButton, ToastTipBarView paramToastTipBarView, View paramView2, PointTextView paramPointTextView1, PointTextView paramPointTextView2)
  {
    super(paramObject, paramView1, paramInt);
    this.c = paramTPRefreshableButton;
    this.d = paramToastTipBarView;
    this.f = paramView2;
    this.q = paramPointTextView1;
    this.x = paramPointTextView2;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityTrvSetProgressCalibrationBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */