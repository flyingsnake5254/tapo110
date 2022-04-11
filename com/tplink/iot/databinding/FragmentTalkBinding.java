package com.tplink.iot.databinding;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.widget.liveViewSettingButton.RippleLayout;
import com.tplink.iot.viewmodel.ipcamera.play.TalkViewModel;

public abstract class FragmentTalkBinding
  extends ViewDataBinding
{
  @NonNull
  public final ImageView c;
  @NonNull
  public final TextView d;
  @NonNull
  public final RippleLayout f;
  @NonNull
  public final ImageButton q;
  @Bindable
  protected TalkViewModel x;
  @Bindable
  protected View.OnClickListener y;
  
  protected FragmentTalkBinding(Object paramObject, View paramView, int paramInt, ImageView paramImageView, TextView paramTextView, RippleLayout paramRippleLayout, ImageButton paramImageButton)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramImageView;
    this.d = paramTextView;
    this.f = paramRippleLayout;
    this.q = paramImageButton;
  }
  
  public abstract void h(@Nullable View.OnClickListener paramOnClickListener);
  
  public abstract void i(@Nullable TalkViewModel paramTalkViewModel);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentTalkBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */