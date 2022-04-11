package com.tplink.iot.databinding;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import androidx.databinding.adapters.ImageViewBindingAdapter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tplink.iot.view.ipcamera.base.b;
import com.tplink.iot.view.ipcamera.widget.CameraLoadingView;
import com.tplink.iot.view.ipcamera.widget.CloudTerraceControlPanel;
import com.tplink.iot.viewmodel.ipcamera.play.CloudTerraceControlViewModel;

public class FragmentCloudTerraceControlBindingImpl
  extends FragmentCloudTerraceControlBinding
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts H3;
  @Nullable
  private static final SparseIntArray I3;
  @NonNull
  private final ConstraintLayout J3;
  @NonNull
  private final TextView K3;
  private long L3 = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    I3 = localSparseIntArray;
    localSparseIntArray.put(2131362264, 8);
    localSparseIntArray.put(2131364023, 9);
    localSparseIntArray.put(2131363614, 10);
  }
  
  public FragmentCloudTerraceControlBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 11, H3, I3));
  }
  
  private FragmentCloudTerraceControlBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 4, (ConstraintLayout)paramArrayOfObject[8], (ImageView)paramArrayOfObject[1], (ImageView)paramArrayOfObject[2], (CameraLoadingView)paramArrayOfObject[7], (ImageView)paramArrayOfObject[5], (CloudTerraceControlPanel)paramArrayOfObject[10], (ImageView)paramArrayOfObject[9], (TextView)paramArrayOfObject[3], (TextView)paramArrayOfObject[4]);
    this.d.setTag(null);
    this.f.setTag(null);
    this.q.setTag(null);
    this.x.setTag(null);
    paramDataBindingComponent = (ConstraintLayout)paramArrayOfObject[0];
    this.J3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (TextView)paramArrayOfObject[6];
    this.K3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    this.p0.setTag(null);
    this.p1.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  private boolean l(MutableLiveData<Boolean> paramMutableLiveData, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.L3 |= 0x4;
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
        this.L3 |= 0x8;
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
        this.L3 |= 0x2;
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
        this.L3 |= 1L;
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
      long l1 = this.L3;
      this.L3 = 0L;
      Object localObject1 = this.p2;
      Boolean localBoolean = this.p3;
      boolean bool2;
      if ((0x5F & l1) != 0L)
      {
        if ((l1 & 0x51) != 0L)
        {
          if (localObject1 != null) {
            localObject2 = ((CloudTerraceControlViewModel)localObject1).K3;
          } else {
            localObject2 = null;
          }
          updateLiveDataRegistration(0, (LiveData)localObject2);
          if (localObject2 != null) {
            localObject2 = (Boolean)((LiveData)localObject2).getValue();
          } else {
            localObject2 = null;
          }
          bool1 = ViewDataBinding.safeUnbox((Boolean)localObject2) ^ true;
        }
        else
        {
          bool1 = false;
        }
        if ((l1 & 0x52) != 0L)
        {
          if (localObject1 != null) {
            localObject2 = ((CloudTerraceControlViewModel)localObject1).P3;
          } else {
            localObject2 = null;
          }
          updateLiveDataRegistration(1, (LiveData)localObject2);
          if (localObject2 != null) {
            localObject2 = (Boolean)((LiveData)localObject2).getValue();
          } else {
            localObject2 = null;
          }
          bool2 = ViewDataBinding.safeUnbox((Boolean)localObject2);
        }
        else
        {
          bool2 = false;
        }
        if ((l1 & 0x5C) != 0L)
        {
          if (localObject1 != null)
          {
            localObject4 = ((CloudTerraceControlViewModel)localObject1).O3;
            localObject2 = ((CloudTerraceControlViewModel)localObject1).N3;
          }
          else
          {
            localObject2 = null;
            localObject4 = localObject2;
          }
          updateLiveDataRegistration(2, (LiveData)localObject4);
          updateLiveDataRegistration(3, (LiveData)localObject2);
          if (localObject4 != null) {
            localObject4 = (Boolean)((LiveData)localObject4).getValue();
          } else {
            localObject4 = null;
          }
          if (localObject2 != null) {
            localObject2 = (Boolean)((LiveData)localObject2).getValue();
          } else {
            localObject2 = null;
          }
          bool3 = ViewDataBinding.safeUnbox((Boolean)localObject4);
          bool4 = ViewDataBinding.safeUnbox((Boolean)localObject2);
          long l2 = l1;
          if ((l1 & 0x54) != 0L)
          {
            if (bool3) {
              l2 = 256L;
            } else {
              l2 = 128L;
            }
            l2 = l1 | l2;
          }
          l1 = l2;
          if ((l2 & 0x5C) != 0L)
          {
            if (bool3) {
              l1 = 16384L;
            } else {
              l1 = 8192L;
            }
            l1 = l2 | l1;
          }
          l2 = l1;
          if ((l1 & 0x5C) != 0L)
          {
            if (bool4) {
              l2 = 1024L;
            } else {
              l2 = 512L;
            }
            l2 = l1 | l2;
          }
          l1 = l2;
          if ((l2 & 0x58) != 0L)
          {
            if (bool4) {
              l1 = 4096L;
            } else {
              l1 = 2048L;
            }
            l1 = l2 | l1;
          }
          int i = 2131231024;
          if ((l1 & 0x54) != 0L)
          {
            localObject2 = this.d.getContext();
            if (bool3) {
              localObject2 = AppCompatResources.getDrawable((Context)localObject2, 2131231024);
            } else {
              localObject2 = AppCompatResources.getDrawable((Context)localObject2, 2131231023);
            }
          }
          else
          {
            localObject2 = null;
          }
          if ((l1 & 0x58) != 0L)
          {
            localObject4 = this.f.getContext();
            if (!bool4) {
              i = 2131231025;
            }
            localObject1 = AppCompatResources.getDrawable((Context)localObject4, i);
            bool6 = bool1;
            bool7 = bool2;
            localObject4 = localObject2;
            localObject2 = localObject1;
            bool1 = bool3;
            break label602;
          }
          localObject1 = null;
          bool6 = bool1;
          bool7 = bool2;
          localObject4 = localObject2;
          localObject2 = localObject1;
          bool1 = bool3;
          break label602;
        }
        bool4 = bool1;
      }
      else
      {
        bool4 = false;
        bool2 = false;
      }
      Object localObject2 = null;
      Object localObject4 = null;
      boolean bool3 = false;
      boolean bool1 = false;
      boolean bool7 = bool2;
      boolean bool6 = bool4;
      boolean bool4 = bool3;
      label602:
      boolean bool8 = (l1 & 0x60) < 0L;
      boolean bool9;
      if (bool8) {
        bool9 = ViewDataBinding.safeUnbox(localBoolean);
      } else {
        bool9 = false;
      }
      boolean bool5 = (l1 & 0x5C) < 0L;
      if (bool5)
      {
        if (bool4) {
          bool2 = true;
        } else {
          bool2 = bool1;
        }
        if (bool1) {
          bool3 = true;
        } else {
          bool3 = bool4;
        }
      }
      else
      {
        bool3 = false;
        bool2 = false;
      }
      if ((0x51 & l1) != 0L)
      {
        this.d.setClickable(bool6);
        this.f.setClickable(bool6);
        this.x.setClickable(bool6);
      }
      if ((0x54 & l1) != 0L)
      {
        ImageViewBindingAdapter.setImageDrawable(this.d, (Drawable)localObject4);
        b.c(this.f, Boolean.valueOf(bool1), null);
        b.c(this.p0, Boolean.valueOf(bool1), null);
      }
      if (bool8)
      {
        b.Q(this.d, bool9);
        b.Q(this.f, bool9);
        b.Q(this.x, bool9);
        b.Q(this.K3, bool9);
        b.Q(this.p0, bool9);
        b.Q(this.p1, bool9);
      }
      if ((0x58 & l1) != 0L)
      {
        b.c(this.d, Boolean.valueOf(bool4), null);
        ImageViewBindingAdapter.setImageDrawable(this.f, (Drawable)localObject2);
        b.c(this.p1, Boolean.valueOf(bool4), null);
      }
      if ((l1 & 0x52) != 0L) {
        b.K(this.q, Boolean.valueOf(bool7));
      }
      if (bool5)
      {
        b.c(this.x, Boolean.valueOf(bool3), null);
        b.c(this.K3, Boolean.valueOf(bool2), null);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable CloudTerraceControlViewModel paramCloudTerraceControlViewModel)
  {
    this.p2 = paramCloudTerraceControlViewModel;
    try
    {
      this.L3 |= 0x10;
      notifyPropertyChanged(11);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public boolean hasPendingBindings()
  {
    try
    {
      return this.L3 != 0L;
    }
    finally {}
  }
  
  public void i(@Nullable Boolean paramBoolean)
  {
    this.p3 = paramBoolean;
    try
    {
      this.L3 |= 0x20;
      notifyPropertyChanged(21);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void invalidateAll()
  {
    try
    {
      this.L3 = 64L;
      requestRebind();
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
          if (paramInt1 != 3) {
            return false;
          }
          return m((MutableLiveData)paramObject, paramInt2);
        }
        return l((MutableLiveData)paramObject, paramInt2);
      }
      return n((MutableLiveData)paramObject, paramInt2);
    }
    return o((MutableLiveData)paramObject, paramInt2);
  }
  
  public boolean setVariable(int paramInt, @Nullable Object paramObject)
  {
    if (11 == paramInt)
    {
      h((CloudTerraceControlViewModel)paramObject);
    }
    else
    {
      if (21 != paramInt) {
        break label36;
      }
      i((Boolean)paramObject);
    }
    boolean bool = true;
    return bool;
    label36:
    bool = false;
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentCloudTerraceControlBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */