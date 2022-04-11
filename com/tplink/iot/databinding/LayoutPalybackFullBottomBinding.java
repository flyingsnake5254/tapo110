package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.view.ipcamera.widget.timeaxis.TimeAxisLayout;
import com.tplink.iot.view.ipcamera.widget.timeaxis.TimeAxisLayout.b;
import com.tplink.iot.viewmodel.ipcamera.play.PlayBackControlViewModel;
import com.tplink.iot.viewmodel.ipcamera.play.PlaybackMainViewModel;
import com.tplink.iot.viewmodel.ipcamera.play.VodViewModel;

public abstract class LayoutPalybackFullBottomBinding
  extends ViewDataBinding
{
  @Bindable
  protected VodViewModel H3;
  @Bindable
  protected PlaybackMainViewModel I3;
  @Bindable
  protected PlayBackControlViewModel J3;
  @Bindable
  protected TimeAxisLayout.b K3;
  @NonNull
  public final ImageView c;
  @NonNull
  public final TextView d;
  @NonNull
  public final ConstraintLayout f;
  @NonNull
  public final TextView p0;
  @NonNull
  public final TextView p1;
  @NonNull
  public final ImageView p2;
  @Bindable
  protected g p3;
  @NonNull
  public final TimeAxisLayout q;
  @NonNull
  public final RelativeLayout x;
  @NonNull
  public final ImageView y;
  @NonNull
  public final ImageView z;
  
  protected LayoutPalybackFullBottomBinding(Object paramObject, View paramView, int paramInt, ImageView paramImageView1, TextView paramTextView1, ConstraintLayout paramConstraintLayout, TimeAxisLayout paramTimeAxisLayout, RelativeLayout paramRelativeLayout, ImageView paramImageView2, ImageView paramImageView3, TextView paramTextView2, TextView paramTextView3, ImageView paramImageView4)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramImageView1;
    this.d = paramTextView1;
    this.f = paramConstraintLayout;
    this.q = paramTimeAxisLayout;
    this.x = paramRelativeLayout;
    this.y = paramImageView2;
    this.z = paramImageView3;
    this.p0 = paramTextView2;
    this.p1 = paramTextView3;
    this.p2 = paramImageView4;
  }
  
  public abstract void h(@Nullable PlayBackControlViewModel paramPlayBackControlViewModel);
  
  public abstract void i(@Nullable g paramg);
  
  public abstract void l(@Nullable TimeAxisLayout.b paramb);
  
  public abstract void m(@Nullable PlaybackMainViewModel paramPlaybackMainViewModel);
  
  public abstract void n(@Nullable VodViewModel paramVodViewModel);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\LayoutPalybackFullBottomBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */