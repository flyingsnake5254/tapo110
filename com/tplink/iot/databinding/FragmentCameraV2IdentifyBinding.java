package com.tplink.iot.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;

public abstract class FragmentCameraV2IdentifyBinding
  extends ViewDataBinding
{
  @NonNull
  public final Toolbar c;
  
  protected FragmentCameraV2IdentifyBinding(Object paramObject, View paramView, int paramInt, Toolbar paramToolbar)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramToolbar;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentCameraV2IdentifyBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */