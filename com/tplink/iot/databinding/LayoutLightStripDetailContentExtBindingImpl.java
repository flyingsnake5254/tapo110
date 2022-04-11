package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import com.airbnb.lottie.LottieAnimationView;
import com.tplink.iot.devices.lightstrip.viewmodel.LightStripDetailViewModel;
import com.tplink.iot.devices.lightstrip.widget.LightStripControllerLayout;
import com.tplink.iot.devices.lightstrip.widget.LightingEffectPresetLayout;

public class LayoutLightStripDetailContentExtBindingImpl
  extends LayoutLightStripDetailContentExtBinding
{
  @Nullable
  private static final SparseIntArray H3;
  @Nullable
  private static final ViewDataBinding.IncludedLayouts p3;
  @NonNull
  private final FrameLayout I3;
  private long J3 = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    H3 = localSparseIntArray;
    localSparseIntArray.put(2131363555, 1);
    localSparseIntArray.put(2131363236, 2);
    localSparseIntArray.put(2131364510, 3);
    localSparseIntArray.put(2131363232, 4);
    localSparseIntArray.put(2131363860, 5);
    localSparseIntArray.put(2131363388, 6);
    localSparseIntArray.put(2131364555, 7);
    localSparseIntArray.put(2131363513, 8);
  }
  
  public LayoutLightStripDetailContentExtBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 9, p3, H3));
  }
  
  private LayoutLightStripDetailContentExtBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 0, (LightStripControllerLayout)paramArrayOfObject[4], (LightingEffectPresetLayout)paramArrayOfObject[2], (LottieAnimationView)paramArrayOfObject[6], (ImageView)paramArrayOfObject[8], (LinearLayout)paramArrayOfObject[1], (RelativeLayout)paramArrayOfObject[5], (TextView)paramArrayOfObject[3], (TextView)paramArrayOfObject[7]);
    paramDataBindingComponent = (FrameLayout)paramArrayOfObject[0];
    this.I3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  protected void executeBindings()
  {
    try
    {
      this.J3 = 0L;
      return;
    }
    finally {}
  }
  
  public void h(@Nullable LightStripDetailViewModel paramLightStripDetailViewModel)
  {
    this.p2 = paramLightStripDetailViewModel;
  }
  
  public boolean hasPendingBindings()
  {
    try
    {
      return this.J3 != 0L;
    }
    finally {}
  }
  
  public void i(@Nullable View.OnClickListener paramOnClickListener)
  {
    this.p1 = paramOnClickListener;
  }
  
  public void invalidateAll()
  {
    try
    {
      this.J3 = 4L;
      requestRebind();
      return;
    }
    finally {}
  }
  
  protected boolean onFieldChange(int paramInt1, Object paramObject, int paramInt2)
  {
    return false;
  }
  
  public boolean setVariable(int paramInt, @Nullable Object paramObject)
  {
    if (15 == paramInt)
    {
      h((LightStripDetailViewModel)paramObject);
    }
    else
    {
      if (69 != paramInt) {
        break label36;
      }
      i((View.OnClickListener)paramObject);
    }
    boolean bool = true;
    return bool;
    label36:
    bool = false;
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\LayoutLightStripDetailContentExtBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */