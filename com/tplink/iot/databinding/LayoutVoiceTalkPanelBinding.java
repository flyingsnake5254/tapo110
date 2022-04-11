package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.view.ipcamera.widget.liveViewSettingButton.RippleLayout;
import com.tplink.iot.viewmodel.ipcamera.play.TalkViewModel;

public abstract class LayoutVoiceTalkPanelBinding
  extends ViewDataBinding
{
  @NonNull
  public final ImageView c;
  @NonNull
  public final ImageView d;
  @NonNull
  public final RippleLayout f;
  @NonNull
  public final ImageView q;
  @NonNull
  public final ImageButton x;
  @Bindable
  protected TalkViewModel y;
  @Bindable
  protected g z;
  
  protected LayoutVoiceTalkPanelBinding(Object paramObject, View paramView, int paramInt, ImageView paramImageView1, ImageView paramImageView2, RippleLayout paramRippleLayout, ImageView paramImageView3, ImageButton paramImageButton)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramImageView1;
    this.d = paramImageView2;
    this.f = paramRippleLayout;
    this.q = paramImageView3;
    this.x = paramImageButton;
  }
  
  public abstract void h(@Nullable g paramg);
  
  public abstract void i(@Nullable TalkViewModel paramTalkViewModel);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\LayoutVoiceTalkPanelBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */