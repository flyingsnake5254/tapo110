package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;

public abstract class FragmentSubgSwitchHowToInstallBinding
  extends ViewDataBinding
{
  @NonNull
  public final ImageView c;
  @NonNull
  public final ImageView d;
  
  protected FragmentSubgSwitchHowToInstallBinding(Object paramObject, View paramView, int paramInt, ImageView paramImageView1, ImageView paramImageView2)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramImageView1;
    this.d = paramImageView2;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentSubgSwitchHowToInstallBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */