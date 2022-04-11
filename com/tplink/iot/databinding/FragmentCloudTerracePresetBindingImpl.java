package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.view.ipcamera.base.b;
import com.tplink.iot.view.ipcamera.widget.CameraLoadingView;
import com.tplink.iot.viewmodel.ipcamera.play.CloudTerracePresetViewModel;

public class FragmentCloudTerracePresetBindingImpl
  extends FragmentCloudTerracePresetBinding
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts y;
  @Nullable
  private static final SparseIntArray z;
  @NonNull
  private final ConstraintLayout p0;
  @NonNull
  private final TextView p1;
  private long p2 = -1L;
  
  public FragmentCloudTerracePresetBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 6, y, z));
  }
  
  private FragmentCloudTerracePresetBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 2, (RecyclerView)paramArrayOfObject[1], (CameraLoadingView)paramArrayOfObject[5], (ImageView)paramArrayOfObject[2], (TextView)paramArrayOfObject[3]);
    this.c.setTag(null);
    this.d.setTag(null);
    this.f.setTag(null);
    paramDataBindingComponent = (ConstraintLayout)paramArrayOfObject[0];
    this.p0 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (TextView)paramArrayOfObject[4];
    this.p1 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    this.q.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  private boolean i(MutableLiveData<Boolean> paramMutableLiveData, int paramInt)
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
  
  private boolean l(MutableLiveData<Boolean> paramMutableLiveData, int paramInt)
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
      long l = this.p2;
      this.p2 = 0L;
      CloudTerracePresetViewModel localCloudTerracePresetViewModel = this.x;
      boolean bool1 = false;
      boolean bool2;
      boolean bool3;
      if ((0xF & l) != 0L)
      {
        Boolean localBoolean = null;
        Object localObject1;
        if ((l & 0xD) != 0L)
        {
          if (localCloudTerracePresetViewModel != null) {
            localObject1 = localCloudTerracePresetViewModel.B();
          } else {
            localObject1 = null;
          }
          updateLiveDataRegistration(0, (LiveData)localObject1);
          if (localObject1 != null) {
            localObject1 = (Boolean)((LiveData)localObject1).getValue();
          } else {
            localObject1 = null;
          }
          bool2 = ViewDataBinding.safeUnbox((Boolean)localObject1);
        }
        else
        {
          bool2 = false;
        }
        if ((l & 0xE) != 0L)
        {
          if (localCloudTerracePresetViewModel != null) {
            localObject1 = localCloudTerracePresetViewModel.I();
          } else {
            localObject1 = null;
          }
          updateLiveDataRegistration(1, (LiveData)localObject1);
          if (localObject1 != null) {
            localBoolean = (Boolean)((LiveData)localObject1).getValue();
          }
          bool3 = ViewDataBinding.safeUnbox(localBoolean);
          bool1 = bool3 ^ true;
        }
        else
        {
          bool3 = false;
        }
      }
      else
      {
        bool3 = false;
        bool2 = false;
      }
      if ((0xE & l) != 0L)
      {
        b.Q(this.c, bool1);
        b.Q(this.f, bool3);
        b.Q(this.p1, bool3);
        b.Q(this.q, bool3);
      }
      if ((l & 0xD) != 0L) {
        b.K(this.d, Boolean.valueOf(bool2));
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable CloudTerracePresetViewModel paramCloudTerracePresetViewModel)
  {
    this.x = paramCloudTerracePresetViewModel;
    try
    {
      this.p2 |= 0x4;
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
      return this.p2 != 0L;
    }
    finally {}
  }
  
  public void invalidateAll()
  {
    try
    {
      this.p2 = 8L;
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
      return l((MutableLiveData)paramObject, paramInt2);
    }
    return i((MutableLiveData)paramObject, paramInt2);
  }
  
  public boolean setVariable(int paramInt, @Nullable Object paramObject)
  {
    boolean bool;
    if (103 == paramInt)
    {
      h((CloudTerracePresetViewModel)paramObject);
      bool = true;
    }
    else
    {
      bool = false;
    }
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentCloudTerracePresetBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */