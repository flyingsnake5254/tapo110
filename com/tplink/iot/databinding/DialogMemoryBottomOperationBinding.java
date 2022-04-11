package com.tplink.iot.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.ipcamera.memories.MemoriesViewModel;

public abstract class DialogMemoryBottomOperationBinding
  extends ViewDataBinding
{
  @NonNull
  public final LinearLayout c;
  @NonNull
  public final TextView d;
  @NonNull
  public final TextView f;
  @NonNull
  public final TextView q;
  @NonNull
  public final TextView x;
  @Bindable
  protected g y;
  @Bindable
  protected MemoriesViewModel z;
  
  protected DialogMemoryBottomOperationBinding(Object paramObject, View paramView, int paramInt, LinearLayout paramLinearLayout, TextView paramTextView1, TextView paramTextView2, TextView paramTextView3, TextView paramTextView4)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramLinearLayout;
    this.d = paramTextView1;
    this.f = paramTextView2;
    this.q = paramTextView3;
    this.x = paramTextView4;
  }
  
  public abstract void h(@Nullable MemoriesViewModel paramMemoriesViewModel);
  
  public abstract void i(@Nullable g paramg);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\DialogMemoryBottomOperationBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */