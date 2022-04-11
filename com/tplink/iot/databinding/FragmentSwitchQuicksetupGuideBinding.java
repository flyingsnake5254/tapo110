package com.tplink.iot.databinding;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.base.g;

public abstract class FragmentSwitchQuicksetupGuideBinding
  extends ViewDataBinding
{
  @NonNull
  public final Button c;
  @NonNull
  public final ImageView d;
  @NonNull
  public final ImageView f;
  @NonNull
  public final TextView q;
  @NonNull
  public final TextView x;
  @Bindable
  protected g y;
  
  protected FragmentSwitchQuicksetupGuideBinding(Object paramObject, View paramView, int paramInt, Button paramButton, ImageView paramImageView1, ImageView paramImageView2, TextView paramTextView1, TextView paramTextView2)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramButton;
    this.d = paramImageView1;
    this.f = paramImageView2;
    this.q = paramTextView1;
    this.x = paramTextView2;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentSwitchQuicksetupGuideBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */