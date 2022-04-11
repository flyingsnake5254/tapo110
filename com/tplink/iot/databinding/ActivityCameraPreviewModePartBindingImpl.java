package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tplink.iot.view.ipcamera.base.b;

public class ActivityCameraPreviewModePartBindingImpl
  extends ActivityCameraPreviewModePartBinding
{
  @Nullable
  private static final SparseIntArray H3;
  @Nullable
  private static final ViewDataBinding.IncludedLayouts p3;
  @NonNull
  private final LinearLayout I3;
  private long J3 = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    H3 = localSparseIntArray;
    localSparseIntArray.put(2131364404, 1);
    localSparseIntArray.put(2131362923, 2);
    localSparseIntArray.put(2131363065, 3);
    localSparseIntArray.put(2131364485, 4);
    localSparseIntArray.put(2131362890, 5);
    localSparseIntArray.put(2131363001, 6);
    localSparseIntArray.put(2131364349, 7);
    localSparseIntArray.put(2131364405, 8);
    localSparseIntArray.put(2131364512, 9);
  }
  
  public ActivityCameraPreviewModePartBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 10, p3, H3));
  }
  
  private ActivityCameraPreviewModePartBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 1, (LinearLayout)paramArrayOfObject[5], (LinearLayout)paramArrayOfObject[2], (ImageView)paramArrayOfObject[6], (ImageView)paramArrayOfObject[3], (TextView)paramArrayOfObject[7], (TextView)paramArrayOfObject[1], (TextView)paramArrayOfObject[8], (TextView)paramArrayOfObject[4], (TextView)paramArrayOfObject[9]);
    paramDataBindingComponent = (LinearLayout)paramArrayOfObject[0];
    this.I3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  private boolean i(MutableLiveData<Boolean> paramMutableLiveData, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.J3 |= 1L;
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
      long l1 = this.J3;
      this.J3 = 0L;
      Object localObject1 = null;
      Boolean localBoolean = null;
      MutableLiveData localMutableLiveData = this.p2;
      boolean bool1 = false;
      boolean bool2 = (l1 & 0x3) < 0L;
      long l2;
      boolean bool4;
      if (bool2)
      {
        if (localMutableLiveData != null) {
          localBoolean = (Boolean)localMutableLiveData.getValue();
        }
        if (localBoolean == null) {
          bool3 = true;
        } else {
          bool3 = false;
        }
        l2 = l1;
        localObject1 = localBoolean;
        bool4 = bool3;
        if (bool2)
        {
          if (bool3) {
            l2 = 8L;
          } else {
            l2 = 4L;
          }
          l2 = l1 | l2;
          localObject1 = localBoolean;
          bool4 = bool3;
        }
      }
      else
      {
        bool4 = false;
        l2 = l1;
      }
      boolean bool3 = (l2 & 0x3) < 0L;
      if (bool3)
      {
        if (bool4) {
          bool1 = true;
        } else {
          bool1 = ((Boolean)localObject1).booleanValue();
        }
        bool1 ^= true;
      }
      if (bool3) {
        b.Q(this.I3, bool1);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable MutableLiveData<Boolean> paramMutableLiveData)
  {
    updateLiveDataRegistration(0, paramMutableLiveData);
    this.p2 = paramMutableLiveData;
    try
    {
      this.J3 |= 1L;
      notifyPropertyChanged(48);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public boolean hasPendingBindings()
  {
    try
    {
      return this.J3 != 0L;
    }
    finally {}
  }
  
  public void invalidateAll()
  {
    try
    {
      this.J3 = 2L;
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
    return i((MutableLiveData)paramObject, paramInt2);
  }
  
  public boolean setVariable(int paramInt, @Nullable Object paramObject)
  {
    boolean bool;
    if (48 == paramInt)
    {
      h((MutableLiveData)paramObject);
      bool = true;
    }
    else
    {
      bool = false;
    }
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityCameraPreviewModePartBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */