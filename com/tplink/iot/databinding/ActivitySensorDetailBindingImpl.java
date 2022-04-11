package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import androidx.lifecycle.LifecycleOwner;
import com.tplink.iot.viewmodel.iotsensor.SensorDetailViewModel;
import com.yinglan.scrolllayout.ScrollLayout;

public class ActivitySensorDetailBindingImpl
  extends ActivitySensorDetailBinding
{
  @Nullable
  private static final SparseIntArray p0;
  @Nullable
  private static final ViewDataBinding.IncludedLayouts z;
  @NonNull
  private final FrameLayout p1;
  private long p2 = -1L;
  
  static
  {
    Object localObject = new ViewDataBinding.IncludedLayouts(5);
    z = (ViewDataBinding.IncludedLayouts)localObject;
    ((ViewDataBinding.IncludedLayouts)localObject).setIncludes(0, new String[] { "activity_sensor_detail_content" }, new int[] { 2 }, new int[] { 2131558650 });
    ((ViewDataBinding.IncludedLayouts)localObject).setIncludes(1, new String[] { "activity_sensor_detail_bottom" }, new int[] { 3 }, new int[] { 2131558649 });
    localObject = new SparseIntArray();
    p0 = (SparseIntArray)localObject;
    ((SparseIntArray)localObject).put(2131363003, 4);
  }
  
  public ActivitySensorDetailBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 5, z, p0));
  }
  
  private ActivitySensorDetailBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 2, (ImageView)paramArrayOfObject[4], (ScrollLayout)paramArrayOfObject[1], (ActivitySensorDetailBottomBinding)paramArrayOfObject[3], (ActivitySensorDetailContentBinding)paramArrayOfObject[2]);
    paramDataBindingComponent = (FrameLayout)paramArrayOfObject[0];
    this.p1 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    this.d.setTag(null);
    setContainedBinding(this.f);
    setContainedBinding(this.q);
    setRootTag(paramView);
    invalidateAll();
  }
  
  private boolean l(ActivitySensorDetailBottomBinding paramActivitySensorDetailBottomBinding, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.p2 |= 0x2;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean m(ActivitySensorDetailContentBinding paramActivitySensorDetailContentBinding, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.p2 |= 1L;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  protected void executeBindings()
  {
    try
    {
      long l = this.p2;
      this.p2 = 0L;
      SensorDetailViewModel localSensorDetailViewModel = this.y;
      View.OnClickListener localOnClickListener = this.x;
      if ((0x14 & l) != 0L)
      {
        this.f.h(localSensorDetailViewModel);
        this.q.h(localSensorDetailViewModel);
      }
      if ((l & 0x18) != 0L)
      {
        this.f.i(localOnClickListener);
        this.q.i(localOnClickListener);
      }
      ViewDataBinding.executeBindingsOn(this.q);
      ViewDataBinding.executeBindingsOn(this.f);
      return;
    }
    finally {}
  }
  
  public void h(@Nullable SensorDetailViewModel paramSensorDetailViewModel)
  {
    this.y = paramSensorDetailViewModel;
    try
    {
      this.p2 |= 0x4;
      notifyPropertyChanged(15);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public boolean hasPendingBindings()
  {
    try
    {
      if (this.p2 != 0L) {
        return true;
      }
      if (this.q.hasPendingBindings()) {
        return true;
      }
      return this.f.hasPendingBindings();
    }
    finally {}
  }
  
  public void i(@Nullable View.OnClickListener paramOnClickListener)
  {
    this.x = paramOnClickListener;
    try
    {
      this.p2 |= 0x8;
      notifyPropertyChanged(69);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void invalidateAll()
  {
    try
    {
      this.p2 = 16L;
      this.q.invalidateAll();
      this.f.invalidateAll();
      requestRebind();
      return;
    }
    finally {}
  }
  
  protected boolean onFieldChange(int paramInt1, Object paramObject, int paramInt2)
  {
    if (paramInt1 != 0)
    {
      if (paramInt1 != 1) {
        return false;
      }
      return l((ActivitySensorDetailBottomBinding)paramObject, paramInt2);
    }
    return m((ActivitySensorDetailContentBinding)paramObject, paramInt2);
  }
  
  public void setLifecycleOwner(@Nullable LifecycleOwner paramLifecycleOwner)
  {
    super.setLifecycleOwner(paramLifecycleOwner);
    this.q.setLifecycleOwner(paramLifecycleOwner);
    this.f.setLifecycleOwner(paramLifecycleOwner);
  }
  
  public boolean setVariable(int paramInt, @Nullable Object paramObject)
  {
    if (15 == paramInt)
    {
      h((SensorDetailViewModel)paramObject);
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivitySensorDetailBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */