package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.Observable;
import androidx.databinding.ObservableInt;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import androidx.databinding.adapters.SeekBarBindingAdapter;
import androidx.databinding.adapters.SeekBarBindingAdapter.OnStopTrackingTouch;
import com.tplink.iot.generated.callback.OnStopTrackingTouch;
import com.tplink.iot.generated.callback.OnStopTrackingTouch.a;
import com.tplink.iot.view.iotsensor.a.a;
import com.tplink.iot.viewmodel.iotsensor.SensorSetSensitivityViewModel;

public class ActivitySensorSetSensitivityBindingImpl
  extends ActivitySensorSetSensitivityBinding
  implements OnStopTrackingTouch.a
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts q;
  @Nullable
  private static final SparseIntArray x;
  private long H3 = -1L;
  @NonNull
  private final TextView p0;
  @NonNull
  private final TextView p1;
  @Nullable
  private final SeekBarBindingAdapter.OnStopTrackingTouch p2;
  private InverseBindingListener p3 = new a();
  @NonNull
  private final LinearLayout y;
  @NonNull
  private final TextView z;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    x = localSparseIntArray;
    localSparseIntArray.put(2131364018, 5);
  }
  
  public ActivitySensorSetSensitivityBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 6, q, x));
  }
  
  private ActivitySensorSetSensitivityBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 1, (FrameLayout)paramArrayOfObject[5], (SeekBar)paramArrayOfObject[4]);
    paramDataBindingComponent = (LinearLayout)paramArrayOfObject[0];
    this.y = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (TextView)paramArrayOfObject[1];
    this.z = paramDataBindingComponent;
    paramDataBindingComponent.setTag("0");
    paramDataBindingComponent = (TextView)paramArrayOfObject[2];
    this.p0 = paramDataBindingComponent;
    paramDataBindingComponent.setTag("1");
    paramDataBindingComponent = (TextView)paramArrayOfObject[3];
    this.p1 = paramDataBindingComponent;
    paramDataBindingComponent.setTag("2");
    this.d.setTag(null);
    setRootTag(paramView);
    this.p2 = new OnStopTrackingTouch(this, 1);
    invalidateAll();
  }
  
  private boolean i(ObservableInt paramObservableInt, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.H3 |= 1L;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  public final void a(int paramInt, SeekBar paramSeekBar)
  {
    paramSeekBar = this.f;
    if (paramSeekBar != null) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    if (paramInt != 0) {
      paramSeekBar.m();
    }
  }
  
  protected void executeBindings()
  {
    try
    {
      long l = this.H3;
      this.H3 = 0L;
      Object localObject1 = this.f;
      int i = 0;
      boolean bool = (0x7 & l) < 0L;
      int j = i;
      if (bool)
      {
        if (localObject1 != null) {
          localObject1 = ((SensorSetSensitivityViewModel)localObject1).k();
        } else {
          localObject1 = null;
        }
        updateRegistration(0, (Observable)localObject1);
        j = i;
        if (localObject1 != null) {
          j = ((ObservableInt)localObject1).get();
        }
      }
      if (bool)
      {
        a.b(this.z, Integer.valueOf(j));
        a.b(this.p0, Integer.valueOf(j));
        a.b(this.p1, Integer.valueOf(j));
        SeekBarBindingAdapter.setProgress(this.d, j);
      }
      if ((l & 0x4) != 0L) {
        SeekBarBindingAdapter.setOnSeekBarChangeListener(this.d, null, this.p2, null, this.p3);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable SensorSetSensitivityViewModel paramSensorSetSensitivityViewModel)
  {
    this.f = paramSensorSetSensitivityViewModel;
    try
    {
      this.H3 |= 0x2;
      notifyPropertyChanged(103);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public boolean hasPendingBindings()
  {
    try
    {
      return this.H3 != 0L;
    }
    finally {}
  }
  
  public void invalidateAll()
  {
    try
    {
      this.H3 = 4L;
      requestRebind();
      return;
    }
    finally {}
  }
  
  protected boolean onFieldChange(int paramInt1, Object paramObject, int paramInt2)
  {
    if (paramInt1 != 0) {
      return false;
    }
    return i((ObservableInt)paramObject, paramInt2);
  }
  
  public boolean setVariable(int paramInt, @Nullable Object paramObject)
  {
    boolean bool;
    if (103 == paramInt)
    {
      h((SensorSetSensitivityViewModel)paramObject);
      bool = true;
    }
    else
    {
      bool = false;
    }
    return bool;
  }
  
  class a
    implements InverseBindingListener
  {
    a() {}
    
    public void onChange()
    {
      int i = ActivitySensorSetSensitivityBindingImpl.this.d.getProgress();
      Object localObject = ActivitySensorSetSensitivityBindingImpl.this.f;
      int j = 1;
      int k;
      if (localObject != null) {
        k = 1;
      } else {
        k = 0;
      }
      if (k != 0)
      {
        localObject = ((SensorSetSensitivityViewModel)localObject).k();
        if (localObject != null) {
          k = j;
        } else {
          k = 0;
        }
        if (k != 0) {
          ((ObservableInt)localObject).set(i);
        }
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivitySensorSetSensitivityBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */