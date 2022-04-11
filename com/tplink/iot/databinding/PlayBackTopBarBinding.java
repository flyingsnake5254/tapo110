package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.ipcamera.play.PlayBackControlViewModel;

public abstract class PlayBackTopBarBinding
  extends ViewDataBinding
{
  @NonNull
  public final TextView c;
  @NonNull
  public final ImageView d;
  @NonNull
  public final ImageView f;
  @NonNull
  public final ImageView q;
  @NonNull
  public final TextView x;
  @Bindable
  protected g y;
  @Bindable
  protected PlayBackControlViewModel z;
  
  protected PlayBackTopBarBinding(Object paramObject, View paramView, int paramInt, TextView paramTextView1, ImageView paramImageView1, ImageView paramImageView2, ImageView paramImageView3, TextView paramTextView2)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramTextView1;
    this.d = paramImageView1;
    this.f = paramImageView2;
    this.q = paramImageView3;
    this.x = paramTextView2;
  }
  
  public abstract void h(@Nullable g paramg);
  
  public abstract void i(@Nullable PlayBackControlViewModel paramPlayBackControlViewModel);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\PlayBackTopBarBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */