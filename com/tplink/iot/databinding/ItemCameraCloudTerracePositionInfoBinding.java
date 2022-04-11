package com.tplink.iot.databinding;

import android.view.View;
import android.view.View.OnLongClickListener;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LiveData;
import com.tplink.iot.viewmodel.ipcamera.play.e3;

public abstract class ItemCameraCloudTerracePositionInfoBinding
  extends ViewDataBinding
{
  @Bindable
  protected Integer c;
  @Bindable
  protected String d;
  @Bindable
  protected Integer f;
  @Bindable
  protected LiveData<Boolean> p0;
  @Bindable
  protected Object q;
  @Bindable
  protected e3 x;
  @Bindable
  protected e3 y;
  @Bindable
  protected View.OnLongClickListener z;
  
  protected ItemCameraCloudTerracePositionInfoBinding(Object paramObject, View paramView, int paramInt)
  {
    super(paramObject, paramView, paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ItemCameraCloudTerracePositionInfoBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */