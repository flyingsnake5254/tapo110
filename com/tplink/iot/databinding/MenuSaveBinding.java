package com.tplink.iot.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.MutableLiveData;

public abstract class MenuSaveBinding
  extends ViewDataBinding
{
  @NonNull
  public final TextView c;
  @Bindable
  protected MutableLiveData<Boolean> d;
  
  protected MenuSaveBinding(Object paramObject, View paramView, int paramInt, TextView paramTextView)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramTextView;
  }
  
  public abstract void h(@Nullable MutableLiveData<Boolean> paramMutableLiveData);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\MenuSaveBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */