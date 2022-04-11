package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.view.ipcamera.base.b;
import com.tplink.iot.widget.springview.widget.PullToRefreshContainer;

public class ActivityCameraPreviewBindingImpl
  extends ActivityCameraPreviewBinding
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts p2;
  @Nullable
  private static final SparseIntArray p3;
  @NonNull
  private final ConstraintLayout H3;
  @NonNull
  private final LinearLayout I3;
  private long J3 = -1L;
  
  static
  {
    Object localObject = new ViewDataBinding.IncludedLayouts(8);
    p2 = (ViewDataBinding.IncludedLayouts)localObject;
    ((ViewDataBinding.IncludedLayouts)localObject).setIncludes(3, new String[] { "activity_camera_preview_mode_part", "activity_camera_preview_cloud_video_server" }, new int[] { 4, 5 }, new int[] { 2131558475, 2131558474 });
    localObject = new SparseIntArray();
    p3 = (SparseIntArray)localObject;
    ((SparseIntArray)localObject).put(2131363827, 6);
    ((SparseIntArray)localObject).put(2131363817, 7);
  }
  
  public ActivityCameraPreviewBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 8, p2, p3));
  }
  
  private ActivityCameraPreviewBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 5, (TextView)paramArrayOfObject[2], (ImageView)paramArrayOfObject[1], (ActivityCameraPreviewModePartBinding)paramArrayOfObject[4], (ActivityCameraPreviewCloudVideoServerBinding)paramArrayOfObject[5], (RecyclerView)paramArrayOfObject[7], (PullToRefreshContainer)paramArrayOfObject[6]);
    this.c.setTag(null);
    this.d.setTag(null);
    setContainedBinding(this.f);
    setContainedBinding(this.q);
    paramDataBindingComponent = (ConstraintLayout)paramArrayOfObject[0];
    this.H3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (LinearLayout)paramArrayOfObject[3];
    this.I3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  private boolean m(ActivityCameraPreviewModePartBinding paramActivityCameraPreviewModePartBinding, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.J3 |= 0x2;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean n(MutableLiveData<Boolean> paramMutableLiveData, int paramInt)
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
  
  private boolean o(MutableLiveData<Boolean> paramMutableLiveData, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.J3 |= 0x4;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean p(MutableLiveData<Boolean> paramMutableLiveData, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.J3 |= 0x10;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean q(ActivityCameraPreviewCloudVideoServerBinding paramActivityCameraPreviewCloudVideoServerBinding, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.J3 |= 0x8;
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
      long l = this.J3;
      this.J3 = 0L;
      MutableLiveData localMutableLiveData1 = this.p1;
      boolean bool1 = false;
      Boolean localBoolean1 = null;
      MutableLiveData localMutableLiveData2 = this.z;
      MutableLiveData localMutableLiveData3 = this.p0;
      boolean bool2 = (0x21 & l) < 0L;
      if ((bool2) && (localMutableLiveData1 != null)) {
        Boolean localBoolean2 = (Boolean)localMutableLiveData1.getValue();
      }
      boolean bool3 = (0x24 & l) < 0L;
      if (bool3)
      {
        if (localMutableLiveData2 != null) {
          localBoolean1 = (Boolean)localMutableLiveData2.getValue();
        }
        bool1 = ViewDataBinding.safeUnbox(localBoolean1);
      }
      boolean bool4 = (l & 0x30) < 0L;
      if ((bool4) && (localMutableLiveData3 != null)) {
        localBoolean1 = (Boolean)localMutableLiveData3.getValue();
      }
      if (bool3)
      {
        b.Q(this.c, bool1);
        b.Q(this.d, bool1);
      }
      if (bool4)
      {
        this.f.h(localMutableLiveData3);
        this.q.i(localMutableLiveData3);
      }
      if (bool2) {
        this.q.h(localMutableLiveData1);
      }
      ViewDataBinding.executeBindingsOn(this.f);
      ViewDataBinding.executeBindingsOn(this.q);
      return;
    }
    finally {}
  }
  
  public void h(@Nullable MutableLiveData<Boolean> paramMutableLiveData)
  {
    updateLiveDataRegistration(0, paramMutableLiveData);
    this.p1 = paramMutableLiveData;
    try
    {
      this.J3 |= 1L;
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
      if (this.J3 != 0L) {
        return true;
      }
      if (this.f.hasPendingBindings()) {
        return true;
      }
      return this.q.hasPendingBindings();
    }
    finally {}
  }
  
  public void i(@Nullable MutableLiveData<Boolean> paramMutableLiveData)
  {
    updateLiveDataRegistration(2, paramMutableLiveData);
    this.z = paramMutableLiveData;
    try
    {
      this.J3 |= 0x4;
      notifyPropertyChanged(36);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void invalidateAll()
  {
    try
    {
      this.J3 = 32L;
      this.f.invalidateAll();
      this.q.invalidateAll();
      requestRebind();
      return;
    }
    finally {}
  }
  
  public void l(@Nullable MutableLiveData<Boolean> paramMutableLiveData)
  {
    updateLiveDataRegistration(4, paramMutableLiveData);
    this.p0 = paramMutableLiveData;
    try
    {
      this.J3 |= 0x10;
      notifyPropertyChanged(48);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  protected boolean onFieldChange(int paramInt1, Object paramObject, int paramInt2)
  {
    if (paramInt1 != 0)
    {
      if (paramInt1 != 1)
      {
        if (paramInt1 != 2)
        {
          if (paramInt1 != 3)
          {
            if (paramInt1 != 4) {
              return false;
            }
            return p((MutableLiveData)paramObject, paramInt2);
          }
          return q((ActivityCameraPreviewCloudVideoServerBinding)paramObject, paramInt2);
        }
        return o((MutableLiveData)paramObject, paramInt2);
      }
      return m((ActivityCameraPreviewModePartBinding)paramObject, paramInt2);
    }
    return n((MutableLiveData)paramObject, paramInt2);
  }
  
  public void setLifecycleOwner(@Nullable LifecycleOwner paramLifecycleOwner)
  {
    super.setLifecycleOwner(paramLifecycleOwner);
    this.f.setLifecycleOwner(paramLifecycleOwner);
    this.q.setLifecycleOwner(paramLifecycleOwner);
  }
  
  public boolean setVariable(int paramInt, @Nullable Object paramObject)
  {
    if (34 == paramInt)
    {
      h((MutableLiveData)paramObject);
    }
    else if (36 == paramInt)
    {
      i((MutableLiveData)paramObject);
    }
    else
    {
      if (48 != paramInt) {
        break label53;
      }
      l((MutableLiveData)paramObject);
    }
    boolean bool = true;
    return bool;
    label53:
    bool = false;
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityCameraPreviewBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */