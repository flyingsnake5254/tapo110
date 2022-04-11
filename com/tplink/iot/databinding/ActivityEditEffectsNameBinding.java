package com.tplink.iot.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.widget.DrawableEditText;

public abstract class ActivityEditEffectsNameBinding
  extends ViewDataBinding
{
  @NonNull
  public final DrawableEditText c;
  
  protected ActivityEditEffectsNameBinding(Object paramObject, View paramView, int paramInt, DrawableEditText paramDrawableEditText)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramDrawableEditText;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityEditEffectsNameBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */