package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.quicksetup.subg.SubGViewModel;
import com.tplink.libtpcontrols.tprefreshablebutton.TPRefreshableButton;

public abstract class FragmentSubGSetupLocationSelectBinding
  extends ViewDataBinding
{
  @NonNull
  public final TPRefreshableButton c;
  @NonNull
  public final RecyclerView d;
  @NonNull
  public final ImageView f;
  @Bindable
  protected SubGViewModel p0;
  @Bindable
  protected g p1;
  @NonNull
  public final LinearLayout q;
  @NonNull
  public final View x;
  @NonNull
  public final TextView y;
  @NonNull
  public final TextView z;
  
  protected FragmentSubGSetupLocationSelectBinding(Object paramObject, View paramView1, int paramInt, TPRefreshableButton paramTPRefreshableButton, RecyclerView paramRecyclerView, ImageView paramImageView, LinearLayout paramLinearLayout, View paramView2, TextView paramTextView1, TextView paramTextView2)
  {
    super(paramObject, paramView1, paramInt);
    this.c = paramTPRefreshableButton;
    this.d = paramRecyclerView;
    this.f = paramImageView;
    this.q = paramLinearLayout;
    this.x = paramView2;
    this.y = paramTextView1;
    this.z = paramTextView2;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentSubGSetupLocationSelectBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */