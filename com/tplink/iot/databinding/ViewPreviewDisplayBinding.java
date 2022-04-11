package com.tplink.iot.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.MutableLiveData;
import com.tplink.iot.widget.RoundImageView;
import com.tplink.iot.widget.camerapreview.e;

public abstract class ViewPreviewDisplayBinding
  extends ViewDataBinding
{
  @NonNull
  public final ImageView H3;
  @NonNull
  public final TextView I3;
  @Bindable
  protected MutableLiveData<e> J3;
  @Bindable
  protected Boolean K3;
  @Bindable
  protected Boolean L3;
  @Bindable
  protected MutableLiveData<String> M3;
  @Bindable
  protected MutableLiveData<Boolean> N3;
  @NonNull
  public final LinearLayout c;
  @NonNull
  public final RoundImageView d;
  @NonNull
  public final ImageView f;
  @NonNull
  public final FrameLayout p0;
  @NonNull
  public final TextView p1;
  @NonNull
  public final TextView p2;
  @NonNull
  public final View p3;
  @NonNull
  public final TextView q;
  @NonNull
  public final TextView x;
  @NonNull
  public final TextView y;
  @NonNull
  public final RoundImageView z;
  
  protected ViewPreviewDisplayBinding(Object paramObject, View paramView1, int paramInt, LinearLayout paramLinearLayout, RoundImageView paramRoundImageView1, ImageView paramImageView1, TextView paramTextView1, TextView paramTextView2, TextView paramTextView3, RoundImageView paramRoundImageView2, FrameLayout paramFrameLayout, TextView paramTextView4, TextView paramTextView5, View paramView2, ImageView paramImageView2, TextView paramTextView6)
  {
    super(paramObject, paramView1, paramInt);
    this.c = paramLinearLayout;
    this.d = paramRoundImageView1;
    this.f = paramImageView1;
    this.q = paramTextView1;
    this.x = paramTextView2;
    this.y = paramTextView3;
    this.z = paramRoundImageView2;
    this.p0 = paramFrameLayout;
    this.p1 = paramTextView4;
    this.p2 = paramTextView5;
    this.p3 = paramView2;
    this.H3 = paramImageView2;
    this.I3 = paramTextView6;
  }
  
  public abstract void h(@Nullable Boolean paramBoolean);
  
  public abstract void i(@Nullable MutableLiveData<String> paramMutableLiveData);
  
  public abstract void l(@Nullable MutableLiveData<Boolean> paramMutableLiveData);
  
  public abstract void m(@Nullable Boolean paramBoolean);
  
  public abstract void n(@Nullable MutableLiveData<e> paramMutableLiveData);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ViewPreviewDisplayBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */