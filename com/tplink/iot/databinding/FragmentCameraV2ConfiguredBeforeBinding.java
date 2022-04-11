package com.tplink.iot.databinding;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.widget.autofixtextview.AutofitTextView;

public abstract class FragmentCameraV2ConfiguredBeforeBinding
  extends ViewDataBinding
{
  @NonNull
  public final RelativeLayout c;
  @NonNull
  public final Toolbar d;
  @NonNull
  public final TextView f;
  @NonNull
  public final TextView p0;
  @NonNull
  public final AutofitTextView q;
  @NonNull
  public final TextView x;
  @NonNull
  public final TextView y;
  @NonNull
  public final TextView z;
  
  protected FragmentCameraV2ConfiguredBeforeBinding(Object paramObject, View paramView, int paramInt, RelativeLayout paramRelativeLayout, Toolbar paramToolbar, TextView paramTextView1, AutofitTextView paramAutofitTextView, TextView paramTextView2, TextView paramTextView3, TextView paramTextView4, TextView paramTextView5)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramRelativeLayout;
    this.d = paramToolbar;
    this.f = paramTextView1;
    this.q = paramAutofitTextView;
    this.x = paramTextView2;
    this.y = paramTextView3;
    this.z = paramTextView4;
    this.p0 = paramTextView5;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentCameraV2ConfiguredBeforeBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */