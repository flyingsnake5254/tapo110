package com.tplink.iot.databinding;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.devicecommon.widget.VariousImageViewLayout;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.quicksetup.subg.SubGViewModel;

public abstract class FragmentSubgEnablePairingModeBinding
  extends ViewDataBinding
{
  @NonNull
  public final Button c;
  @NonNull
  public final ImageView d;
  @NonNull
  public final VariousImageViewLayout f;
  @NonNull
  public final TextView p0;
  @Bindable
  protected SubGViewModel p1;
  @Bindable
  protected g p2;
  @NonNull
  public final RelativeLayout q;
  @NonNull
  public final LinearLayout x;
  @NonNull
  public final TextView y;
  @NonNull
  public final TextView z;
  
  protected FragmentSubgEnablePairingModeBinding(Object paramObject, View paramView, int paramInt, Button paramButton, ImageView paramImageView, VariousImageViewLayout paramVariousImageViewLayout, RelativeLayout paramRelativeLayout, LinearLayout paramLinearLayout, TextView paramTextView1, TextView paramTextView2, TextView paramTextView3)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramButton;
    this.d = paramImageView;
    this.f = paramVariousImageViewLayout;
    this.q = paramRelativeLayout;
    this.x = paramLinearLayout;
    this.y = paramTextView1;
    this.z = paramTextView2;
    this.p0 = paramTextView3;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentSubgEnablePairingModeBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */