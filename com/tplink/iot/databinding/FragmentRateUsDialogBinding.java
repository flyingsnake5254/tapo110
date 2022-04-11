package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableInt;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.base.g;

public abstract class FragmentRateUsDialogBinding
  extends ViewDataBinding
{
  @NonNull
  public final ImageButton c;
  @NonNull
  public final ImageButton d;
  @NonNull
  public final ImageButton f;
  @NonNull
  public final TextView p0;
  @Bindable
  protected ObservableInt p1;
  @Bindable
  protected g p2;
  @NonNull
  public final ImageButton q;
  @NonNull
  public final ImageButton x;
  @NonNull
  public final ImageButton y;
  @NonNull
  public final LinearLayout z;
  
  protected FragmentRateUsDialogBinding(Object paramObject, View paramView, int paramInt, ImageButton paramImageButton1, ImageButton paramImageButton2, ImageButton paramImageButton3, ImageButton paramImageButton4, ImageButton paramImageButton5, ImageButton paramImageButton6, LinearLayout paramLinearLayout, TextView paramTextView)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramImageButton1;
    this.d = paramImageButton2;
    this.f = paramImageButton3;
    this.q = paramImageButton4;
    this.x = paramImageButton5;
    this.y = paramImageButton6;
    this.z = paramLinearLayout;
    this.p0 = paramTextView;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentRateUsDialogBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */