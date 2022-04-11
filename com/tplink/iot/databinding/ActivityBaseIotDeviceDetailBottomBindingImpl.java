package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.lifecycle.LiveData;
import com.tplink.iot.Utils.extension.a;
import com.tplink.iot.devicecommon.viewmodel.IoTDetailBaseViewModel;
import com.tplink.libtpcontrols.materialnormalcompat.swicth.TPSwitchCompat;
import com.yinglan.scrolllayout.content.ContentScrollView;

public class ActivityBaseIotDeviceDetailBottomBindingImpl
  extends ActivityBaseIotDeviceDetailBottomBinding
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts J3;
  @Nullable
  private static final SparseIntArray K3;
  private long L3 = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    K3 = localSparseIntArray;
    localSparseIntArray.put(2131362656, 7);
    localSparseIntArray.put(2131361981, 8);
    localSparseIntArray.put(2131361977, 9);
    localSparseIntArray.put(2131364819, 10);
  }
  
  public ActivityBaseIotDeviceDetailBottomBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 11, J3, K3));
  }
  
  private ActivityBaseIotDeviceDetailBottomBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 5, (ImageView)paramArrayOfObject[9], (ImageView)paramArrayOfObject[8], (TPSwitchCompat)paramArrayOfObject[3], (FrameLayout)paramArrayOfObject[7], (RelativeLayout)paramArrayOfObject[4], (RelativeLayout)paramArrayOfObject[6], (ImageView)paramArrayOfObject[1], (RelativeLayout)paramArrayOfObject[2], (ContentScrollView)paramArrayOfObject[0], (TextView)paramArrayOfObject[5], (View)paramArrayOfObject[10]);
    this.f.setTag(null);
    this.x.setTag(null);
    this.y.setTag(null);
    this.z.setTag(null);
    this.p0.setTag(null);
    this.p1.setTag(null);
    this.p2.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  private boolean l(LiveData<Integer> paramLiveData, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.L3 |= 0x10;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean m(LiveData<Boolean> paramLiveData, int paramInt)
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
  
  private boolean n(LiveData<Boolean> paramLiveData, int paramInt)
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
  
  private boolean o(LiveData<Boolean> paramLiveData, int paramInt)
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
  
  private boolean p(LiveData<Boolean> paramLiveData, int paramInt)
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
      IoTDetailBaseViewModel localIoTDetailBaseViewModel = this.I3;
      View.OnClickListener localOnClickListener = this.H3;
      float f1 = 0.0F;
      Object localObject1;
      boolean bool1;
      boolean bool2;
      float f2;
      boolean bool4;
      float f3;
      boolean bool5;
      boolean bool6;
      if ((0xBF & l1) != 0L)
      {
        if ((l1 & 0xA1) != 0L)
        {
          if (localIoTDetailBaseViewModel != null) {
            localObject1 = localIoTDetailBaseViewModel.A();
          } else {
            localObject1 = null;
          }
          updateLiveDataRegistration(0, (LiveData)localObject1);
          if (localObject1 != null) {
            localObject1 = (Boolean)((LiveData)localObject1).getValue();
          } else {
            localObject1 = null;
          }
          bool1 = ViewDataBinding.safeUnbox(Boolean.valueOf(ViewDataBinding.safeUnbox((Boolean)localObject1) ^ true));
        }
        else
        {
          bool1 = false;
        }
        if (((l1 & 0xA0) != 0L) && (localIoTDetailBaseViewModel != null)) {
          bool2 = localIoTDetailBaseViewModel.C();
        } else {
          bool2 = false;
        }
        f2 = 0.5F;
        boolean bool3 = (l1 & 0xA2) < 0L;
        long l2;
        if (bool3)
        {
          if (localIoTDetailBaseViewModel != null) {
            localObject1 = localIoTDetailBaseViewModel.z();
          } else {
            localObject1 = null;
          }
          updateLiveDataRegistration(1, (LiveData)localObject1);
          if (localObject1 != null) {
            localObject1 = (Boolean)((LiveData)localObject1).getValue();
          } else {
            localObject1 = null;
          }
          bool4 = ViewDataBinding.safeUnbox((Boolean)localObject1);
          l2 = l1;
          if (bool3)
          {
            if (bool4) {
              l2 = 512L;
            } else {
              l2 = 256L;
            }
            l2 = l1 | l2;
          }
          if (bool4) {
            f3 = 0.5F;
          } else {
            f3 = 1.0F;
          }
          bool4 = ViewDataBinding.safeUnbox(Boolean.valueOf(bool4 ^ true));
          l1 = l2;
        }
        else
        {
          bool4 = false;
          f3 = 0.0F;
        }
        bool3 = (l1 & 0xA4) < 0L;
        if (bool3)
        {
          if (localIoTDetailBaseViewModel != null) {
            localObject1 = localIoTDetailBaseViewModel.w();
          } else {
            localObject1 = null;
          }
          updateLiveDataRegistration(2, (LiveData)localObject1);
          if (localObject1 != null) {
            localObject1 = (Boolean)((LiveData)localObject1).getValue();
          } else {
            localObject1 = null;
          }
          bool5 = ViewDataBinding.safeUnbox((Boolean)localObject1);
          l2 = l1;
          if (bool3)
          {
            if (bool5) {
              l2 = 2048L;
            } else {
              l2 = 1024L;
            }
            l2 = l1 | l2;
          }
          if (bool5) {
            f2 = 1.0F;
          }
          l1 = l2;
        }
        else
        {
          bool5 = false;
          f2 = f1;
        }
        if ((l1 & 0xA8) != 0L)
        {
          if (localIoTDetailBaseViewModel != null) {
            localObject1 = localIoTDetailBaseViewModel.v();
          } else {
            localObject1 = null;
          }
          updateLiveDataRegistration(3, (LiveData)localObject1);
          if (localObject1 != null) {
            localObject1 = (Boolean)((LiveData)localObject1).getValue();
          } else {
            localObject1 = null;
          }
          bool6 = ViewDataBinding.safeUnbox((Boolean)localObject1);
        }
        else
        {
          bool6 = false;
        }
        if ((l1 & 0xB0) != 0L)
        {
          if (localIoTDetailBaseViewModel != null) {
            localObject1 = localIoTDetailBaseViewModel.l();
          } else {
            localObject1 = null;
          }
          updateLiveDataRegistration(4, (LiveData)localObject1);
          if (localObject1 != null) {
            localObject1 = (Integer)((LiveData)localObject1).getValue();
          } else {
            localObject1 = null;
          }
          localObject1 = String.valueOf(ViewDataBinding.safeUnbox((Integer)localObject1));
          f1 = f2;
          f2 = f3;
          f3 = f1;
        }
        else
        {
          f1 = f3;
          localObject1 = null;
          f3 = f2;
          f2 = f1;
        }
      }
      else
      {
        bool4 = false;
        bool1 = false;
        bool2 = false;
        bool6 = false;
        localObject1 = null;
        bool5 = false;
        f3 = 0.0F;
        f2 = 0.0F;
      }
      if ((l1 & 0xA8) != 0L) {
        CompoundButtonBindingAdapter.setChecked(this.f, bool6);
      }
      if ((l1 & 0xA4) != 0L)
      {
        this.f.setEnabled(bool5);
        if (ViewDataBinding.getBuildSdkInt() >= 11) {
          this.p0.setAlpha(f3);
        }
      }
      if ((0xA2 & l1) != 0L)
      {
        if (ViewDataBinding.getBuildSdkInt() >= 11) {
          this.x.setAlpha(f2);
        }
        this.x.setEnabled(bool4);
      }
      if ((l1 & 0xC0) != 0L)
      {
        this.x.setOnClickListener(localOnClickListener);
        this.y.setOnClickListener(localOnClickListener);
        this.z.setOnClickListener(localOnClickListener);
      }
      if ((l1 & 0xA1) != 0L) {
        a.h(this.x, bool1);
      }
      if ((0xA0 & l1) != 0L) {
        a.h(this.p0, bool2);
      }
      if ((l1 & 0xB0) != 0L) {
        TextViewBindingAdapter.setText(this.p2, (CharSequence)localObject1);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable IoTDetailBaseViewModel paramIoTDetailBaseViewModel)
  {
    this.I3 = paramIoTDetailBaseViewModel;
    try
    {
      this.L3 |= 0x20;
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
      return this.L3 != 0L;
    }
    finally {}
  }
  
  public void i(@Nullable View.OnClickListener paramOnClickListener)
  {
    this.H3 = paramOnClickListener;
    try
    {
      this.L3 |= 0x40;
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
      this.L3 = 128L;
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
          if (paramInt1 != 3)
          {
            if (paramInt1 != 4) {
              return false;
            }
            return l((LiveData)paramObject, paramInt2);
          }
          return m((LiveData)paramObject, paramInt2);
        }
        return n((LiveData)paramObject, paramInt2);
      }
      return o((LiveData)paramObject, paramInt2);
    }
    return p((LiveData)paramObject, paramInt2);
  }
  
  public boolean setVariable(int paramInt, @Nullable Object paramObject)
  {
    if (15 == paramInt)
    {
      h((IoTDetailBaseViewModel)paramObject);
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityBaseIotDeviceDetailBottomBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */