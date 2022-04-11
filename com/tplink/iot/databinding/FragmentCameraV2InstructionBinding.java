package com.tplink.iot.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.base.g;

public abstract class FragmentCameraV2InstructionBinding
  extends ViewDataBinding
{
  @NonNull
  public final LinearLayout c;
  @NonNull
  public final Toolbar d;
  @NonNull
  public final TextView f;
  @Bindable
  protected g q;
  
  protected FragmentCameraV2InstructionBinding(Object paramObject, View paramView, int paramInt, LinearLayout paramLinearLayout, Toolbar paramToolbar, TextView paramTextView)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramLinearLayout;
    this.d = paramToolbar;
    this.f = paramTextView;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentCameraV2InstructionBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */