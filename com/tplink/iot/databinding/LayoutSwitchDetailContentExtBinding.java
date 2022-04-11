package com.tplink.iot.databinding;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.devices.switches.viewmodel.SwitchDetailViewModel;
import com.tplink.iot.widget.DiffuseViewV2;

public abstract class LayoutSwitchDetailContentExtBinding
  extends ViewDataBinding
{
  @NonNull
  public final DiffuseViewV2 c;
  @NonNull
  public final ImageView d;
  @NonNull
  public final LinearLayout f;
  @Bindable
  protected View.OnClickListener p0;
  @NonNull
  public final TextView q;
  @NonNull
  public final TextView x;
  @NonNull
  public final TextView y;
  @Bindable
  protected SwitchDetailViewModel z;
  
  protected LayoutSwitchDetailContentExtBinding(Object paramObject, View paramView, int paramInt, DiffuseViewV2 paramDiffuseViewV2, ImageView paramImageView, LinearLayout paramLinearLayout, TextView paramTextView1, TextView paramTextView2, TextView paramTextView3)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramDiffuseViewV2;
    this.d = paramImageView;
    this.f = paramLinearLayout;
    this.q = paramTextView1;
    this.x = paramTextView2;
    this.y = paramTextView3;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\LayoutSwitchDetailContentExtBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */