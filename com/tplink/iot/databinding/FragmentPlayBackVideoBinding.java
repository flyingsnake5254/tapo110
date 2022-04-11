package com.tplink.iot.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.view.ipcamera.widget.a.a;
import com.tplink.iot.view.ipcamera.widget.calendar.b;
import com.tplink.iot.view.ipcamera.widget.calendar.c;
import com.tplink.iot.view.ipcamera.widget.scollitem.ScrollPlayRatePicker.a;
import com.tplink.iot.view.ipcamera.widget.timeaxis.TimeAxisLayout.b;
import com.tplink.iot.view.ipcamera.widget.touchlayout.TouchListenerRelativeLayout;
import com.tplink.iot.viewmodel.ipcamera.play.PlayBackControlViewModel;
import com.tplink.iot.viewmodel.ipcamera.play.PlaybackMainViewModel;
import com.tplink.iot.viewmodel.ipcamera.play.VodViewModel;

public abstract class FragmentPlayBackVideoBinding
  extends ViewDataBinding
{
  @NonNull
  public final LayoutPalybackFullBottomBinding H3;
  @NonNull
  public final LayoutPlayBackFullscreenCalendarBinding I3;
  @NonNull
  public final LayoutPlayBackFullscreenFilterBinding J3;
  @NonNull
  public final LayoutPlaybackToolbarBottomBinding K3;
  @NonNull
  public final LayoutPlaybackToolbarTopBinding L3;
  @NonNull
  public final LayoutPlaybackToolbarPopupBinding M3;
  @NonNull
  public final TouchListenerRelativeLayout N3;
  @Bindable
  protected g O3;
  @Bindable
  protected PlaybackMainViewModel P3;
  @Bindable
  protected VodViewModel Q3;
  @Bindable
  protected PlayBackControlViewModel R3;
  @Bindable
  protected a S3;
  @Bindable
  protected ScrollPlayRatePicker.a T3;
  @Bindable
  protected b U3;
  @Bindable
  protected TimeAxisLayout.b V3;
  @Bindable
  protected c W3;
  @NonNull
  public final ImageView c;
  @NonNull
  public final RelativeLayout d;
  @NonNull
  public final View f;
  @NonNull
  public final ImageView p0;
  @NonNull
  public final FrameLayout p1;
  @NonNull
  public final ImageView p2;
  @NonNull
  public final TextView p3;
  @NonNull
  public final FrameLayout q;
  @NonNull
  public final ImageView x;
  @NonNull
  public final ConstraintLayout y;
  @NonNull
  public final TextView z;
  
  protected FragmentPlayBackVideoBinding(Object paramObject, View paramView1, int paramInt, ImageView paramImageView1, RelativeLayout paramRelativeLayout, View paramView2, FrameLayout paramFrameLayout1, ImageView paramImageView2, ConstraintLayout paramConstraintLayout, TextView paramTextView1, ImageView paramImageView3, FrameLayout paramFrameLayout2, ImageView paramImageView4, TextView paramTextView2, LayoutPalybackFullBottomBinding paramLayoutPalybackFullBottomBinding, LayoutPlayBackFullscreenCalendarBinding paramLayoutPlayBackFullscreenCalendarBinding, LayoutPlayBackFullscreenFilterBinding paramLayoutPlayBackFullscreenFilterBinding, LayoutPlaybackToolbarBottomBinding paramLayoutPlaybackToolbarBottomBinding, LayoutPlaybackToolbarTopBinding paramLayoutPlaybackToolbarTopBinding, LayoutPlaybackToolbarPopupBinding paramLayoutPlaybackToolbarPopupBinding, TouchListenerRelativeLayout paramTouchListenerRelativeLayout)
  {
    super(paramObject, paramView1, paramInt);
    this.c = paramImageView1;
    this.d = paramRelativeLayout;
    this.f = paramView2;
    this.q = paramFrameLayout1;
    this.x = paramImageView2;
    this.y = paramConstraintLayout;
    this.z = paramTextView1;
    this.p0 = paramImageView3;
    this.p1 = paramFrameLayout2;
    this.p2 = paramImageView4;
    this.p3 = paramTextView2;
    this.H3 = paramLayoutPalybackFullBottomBinding;
    this.I3 = paramLayoutPlayBackFullscreenCalendarBinding;
    this.J3 = paramLayoutPlayBackFullscreenFilterBinding;
    this.K3 = paramLayoutPlaybackToolbarBottomBinding;
    this.L3 = paramLayoutPlaybackToolbarTopBinding;
    this.M3 = paramLayoutPlaybackToolbarPopupBinding;
    this.N3 = paramTouchListenerRelativeLayout;
  }
  
  public abstract void h(@Nullable a parama);
  
  public abstract void i(@Nullable b paramb);
  
  public abstract void l(@Nullable c paramc);
  
  public abstract void m(@Nullable ScrollPlayRatePicker.a parama);
  
  public abstract void n(@Nullable PlayBackControlViewModel paramPlayBackControlViewModel);
  
  public abstract void o(@Nullable g paramg);
  
  public abstract void p(@Nullable TimeAxisLayout.b paramb);
  
  public abstract void q(@Nullable PlaybackMainViewModel paramPlaybackMainViewModel);
  
  public abstract void r(@Nullable VodViewModel paramVodViewModel);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentPlayBackVideoBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */