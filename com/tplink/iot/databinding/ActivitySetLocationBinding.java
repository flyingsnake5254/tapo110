package com.tplink.iot.databinding;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.viewmodel.ipcamera.setting.LocateSettingViewModel;
import com.tplink.iot.widget.ErrorBar;
import com.tplink.libtpcontrols.tprefreshablebutton.TPRefreshableButton;

public abstract class ActivitySetLocationBinding
  extends ViewDataBinding
{
  @NonNull
  public final ImageView c;
  @NonNull
  public final Toolbar d;
  @NonNull
  public final ErrorBar f;
  @Bindable
  protected LocateSettingViewModel p0;
  @Bindable
  protected View.OnClickListener p1;
  @NonNull
  public final RecyclerView q;
  @NonNull
  public final TextView x;
  @NonNull
  public final TextView y;
  @NonNull
  public final TPRefreshableButton z;
  
  protected ActivitySetLocationBinding(Object paramObject, View paramView, int paramInt, ImageView paramImageView, Toolbar paramToolbar, ErrorBar paramErrorBar, RecyclerView paramRecyclerView, TextView paramTextView1, TextView paramTextView2, TPRefreshableButton paramTPRefreshableButton)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramImageView;
    this.d = paramToolbar;
    this.f = paramErrorBar;
    this.q = paramRecyclerView;
    this.x = paramTextView1;
    this.y = paramTextView2;
    this.z = paramTPRefreshableButton;
  }
  
  public abstract void h(@Nullable View.OnClickListener paramOnClickListener);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivitySetLocationBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */