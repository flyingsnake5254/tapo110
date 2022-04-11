package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.quicksetup.subg.SubGViewModel;
import com.tplink.iot.widget.DrawableEditText;
import com.tplink.iot.widget.FlowTagLayout;
import com.tplink.libtpcontrols.tprefreshablebutton.TPRefreshableButton;

public abstract class FragmentSubGSetupLocationCustomBinding
  extends ViewDataBinding
{
  @NonNull
  public final TPRefreshableButton c;
  @NonNull
  public final DrawableEditText d;
  @NonNull
  public final FlowTagLayout f;
  @NonNull
  public final TextView p0;
  @Bindable
  protected SubGViewModel p1;
  @Bindable
  protected g p2;
  @NonNull
  public final ImageView q;
  @NonNull
  public final LinearLayout x;
  @NonNull
  public final LinearLayout y;
  @NonNull
  public final View z;
  
  protected FragmentSubGSetupLocationCustomBinding(Object paramObject, View paramView1, int paramInt, TPRefreshableButton paramTPRefreshableButton, DrawableEditText paramDrawableEditText, FlowTagLayout paramFlowTagLayout, ImageView paramImageView, LinearLayout paramLinearLayout1, LinearLayout paramLinearLayout2, View paramView2, TextView paramTextView)
  {
    super(paramObject, paramView1, paramInt);
    this.c = paramTPRefreshableButton;
    this.d = paramDrawableEditText;
    this.f = paramFlowTagLayout;
    this.q = paramImageView;
    this.x = paramLinearLayout1;
    this.y = paramLinearLayout2;
    this.z = paramView2;
    this.p0 = paramTextView;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentSubGSetupLocationCustomBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */