package com.tplink.iot.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.ipcamera.play.PlaybackMainViewModel;
import com.tplink.iot.viewmodel.ipcamera.play.VodViewModel;

public abstract class LayoutPlaybackToolbarTopBinding
  extends ViewDataBinding
{
  @NonNull
  public final TextView c;
  @NonNull
  public final TextView d;
  @Bindable
  protected g f;
  @Bindable
  protected VodViewModel q;
  @Bindable
  protected PlaybackMainViewModel x;
  
  protected LayoutPlaybackToolbarTopBinding(Object paramObject, View paramView, int paramInt, TextView paramTextView1, TextView paramTextView2)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramTextView1;
    this.d = paramTextView2;
  }
  
  public abstract void h(@Nullable g paramg);
  
  public abstract void i(@Nullable PlaybackMainViewModel paramPlaybackMainViewModel);
  
  public abstract void l(@Nullable VodViewModel paramVodViewModel);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\LayoutPlaybackToolbarTopBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */