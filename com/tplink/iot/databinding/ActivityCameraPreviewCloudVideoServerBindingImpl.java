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

public class ActivityCameraPreviewCloudVideoServerBindingImpl
  extends ActivityCameraPreviewCloudVideoServerBinding
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts p0;
  @Nullable
  private static final SparseIntArray p1;
  private long p2 = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    p1 = localSparseIntArray;
    localSparseIntArray.put(2131364369, 1);
    localSparseIntArray.put(2131364364, 2);
    localSparseIntArray.put(2131364368, 3);
    localSparseIntArray.put(2131363016, 4);
  }
  
  public ActivityCameraPreviewCloudVideoServerBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 5, p0, p1));
  }
  
  private ActivityCameraPreviewCloudVideoServerBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 2, (ImageView)paramArrayOfObject[4], (LinearLayout)paramArrayOfObject[0], (TextView)paramArrayOfObject[2], (TextView)paramArrayOfObject[3], (TextView)paramArrayOfObject[1]);
    this.d.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  private boolean l(MutableLiveData<Boolean> paramMutableLiveData, int paramInt)
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
  
  private boolean m(MutableLiveData<Boolean> paramMutableLiveData, int paramInt)
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
  
  protected void executeBindings()
  {
    try
    {
      long l1 = this.p2;
      this.p2 = 0L;
      MutableLiveData localMutableLiveData = this.y;
      Object localObject1 = this.z;
      Object localObject3 = null;
      boolean bool1 = false;
      boolean bool2 = (l1 & 0x7) < 0L;
      long l2;
      boolean bool4;
      if (bool2)
      {
        if (localObject1 != null) {
          localObject1 = (Boolean)((LiveData)localObject1).getValue();
        } else {
          localObject1 = null;
        }
        bool3 = ViewDataBinding.safeUnbox((Boolean)localObject1) ^ true;
        l2 = l1;
        bool4 = bool3;
        if (bool2) {
          if (bool3)
          {
            l2 = l1 | 0x10;
            bool4 = bool3;
          }
          else
          {
            l2 = l1 | 0x8;
            bool4 = bool3;
          }
        }
      }
      else
      {
        bool4 = false;
        l2 = l1;
      }
      boolean bool5;
      if ((l2 & 0x10) != 0L)
      {
        localObject1 = localObject3;
        if (localMutableLiveData != null) {
          localObject1 = (Boolean)localMutableLiveData.getValue();
        }
        bool5 = ViewDataBinding.safeUnbox((Boolean)localObject1);
      }
      else
      {
        bool5 = false;
      }
      boolean bool3 = (l2 & 0x7) < 0L;
      boolean bool6 = bool1;
      if (bool3)
      {
        bool6 = bool1;
        if (bool4) {
          bool6 = bool5;
        }
      }
      if (bool3) {
        b.Q(this.d, bool6);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable MutableLiveData<Boolean> paramMutableLiveData)
  {
    updateLiveDataRegistration(0, paramMutableLiveData);
    this.y = paramMutableLiveData;
    try
    {
      this.p2 |= 1L;
      notifyPropertyChanged(34);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public boolean hasPendingBindings()
  {
    try
    {
      return this.p2 != 0L;
    }
    finally {}
  }
  
  public void i(@Nullable MutableLiveData<Boolean> paramMutableLiveData)
  {
    updateLiveDataRegistration(1, paramMutableLiveData);
    this.z = paramMutableLiveData;
    try
    {
      this.p2 |= 0x2;
      notifyPropertyChanged(48);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void invalidateAll()
  {
    try
    {
      this.p2 = 4L;
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
      return m((MutableLiveData)paramObject, paramInt2);
    }
    return l((MutableLiveData)paramObject, paramInt2);
  }
  
  public boolean setVariable(int paramInt, @Nullable Object paramObject)
  {
    if (34 == paramInt)
    {
      h((MutableLiveData)paramObject);
    }
    else
    {
      if (48 != paramInt) {
        break label36;
      }
      i((MutableLiveData)paramObject);
    }
    boolean bool = true;
    return bool;
    label36:
    bool = false;
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityCameraPreviewCloudVideoServerBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */