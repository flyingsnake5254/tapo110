package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.MutableLiveData;

public abstract class DialogMultiLiveDragBinding
  extends ViewDataBinding
{
  @NonNull
  public final ConstraintLayout c;
  @NonNull
  public final ImageView d;
  @NonNull
  public final ImageView f;
  @NonNull
  public final View q;
  @Bindable
  protected MutableLiveData<Boolean> x;
  
  protected DialogMultiLiveDragBinding(Object paramObject, View paramView1, int paramInt, ConstraintLayout paramConstraintLayout, ImageView paramImageView1, ImageView paramImageView2, View paramView2)
  {
    super(paramObject, paramView1, paramInt);
    this.c = paramConstraintLayout;
    this.d = paramImageView1;
    this.f = paramImageView2;
    this.q = paramView2;
  }
  
  public abstract void h(@Nullable MutableLiveData<Boolean> paramMutableLiveData);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\DialogMultiLiveDragBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */