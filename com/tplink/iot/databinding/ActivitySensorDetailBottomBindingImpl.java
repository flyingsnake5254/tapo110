package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
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
import com.tplink.iot.viewmodel.iotsensor.SensorDetailViewModel;
import com.tplink.libtpcontrols.materialnormalcompat.swicth.TPSwitchCompat;
import com.yinglan.scrolllayout.content.ContentScrollView;

public class ActivitySensorDetailBottomBindingImpl
  extends ActivitySensorDetailBottomBinding
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts K3;
  @Nullable
  private static final SparseIntArray L3;
  private long M3 = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    L3 = localSparseIntArray;
    localSparseIntArray.put(2131361983, 8);
    localSparseIntArray.put(2131362478, 9);
    localSparseIntArray.put(2131361981, 10);
    localSparseIntArray.put(2131361977, 11);
  }
  
  public ActivitySensorDetailBottomBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 12, K3, L3));
  }
  
  private ActivitySensorDetailBottomBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 6, (ImageView)paramArrayOfObject[11], (ImageView)paramArrayOfObject[10], (ImageView)paramArrayOfObject[8], (View)paramArrayOfObject[9], (TPSwitchCompat)paramArrayOfObject[4], (RelativeLayout)paramArrayOfObject[5], (RelativeLayout)paramArrayOfObject[7], (RelativeLayout)paramArrayOfObject[2], (ImageView)paramArrayOfObject[1], (RelativeLayout)paramArrayOfObject[3], (ContentScrollView)paramArrayOfObject[0], (TextView)paramArrayOfObject[6]);
    this.x.setTag(null);
    this.y.setTag(null);
    this.z.setTag(null);
    this.p0.setTag(null);
    this.p1.setTag(null);
    this.p2.setTag(null);
    this.p3.setTag(null);
    this.H3.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  private boolean l(LiveData<Integer> paramLiveData, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.M3 |= 0x20;
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
        this.M3 |= 0x10;
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
        this.M3 |= 0x8;
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
        this.M3 |= 0x4;
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
        this.M3 |= 1L;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean q(LiveData<Boolean> paramLiveData, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.M3 |= 0x2;
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
      long l1 = this.M3;
      this.M3 = 0L;
      SensorDetailViewModel localSensorDetailViewModel = this.J3;
      View.OnClickListener localOnClickListener = this.I3;
      float f1 = 0.0F;
      Object localObject1;
      boolean bool1;
      boolean bool2;
      boolean bool4;
      float f3;
      boolean bool5;
      float f4;
      boolean bool6;
      boolean bool7;
      if ((0x17F & l1) != 0L)
      {
        if ((l1 & 0x141) != 0L)
        {
          if (localSensorDetailViewModel != null) {
            localObject1 = localSensorDetailViewModel.L();
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
        if (((l1 & 0x140) != 0L) && (localSensorDetailViewModel != null)) {
          bool2 = localSensorDetailViewModel.N();
        } else {
          bool2 = false;
        }
        float f2 = 1.0F;
        boolean bool3 = (l1 & 0x142) < 0L;
        long l2;
        if (bool3)
        {
          if (localSensorDetailViewModel != null) {
            localObject1 = localSensorDetailViewModel.M();
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
              l2 = 16384L;
            } else {
              l2 = 8192L;
            }
            l2 = l1 | l2;
          }
          if (bool4)
          {
            f3 = 1.0F;
            l1 = l2;
          }
          else
          {
            f3 = 0.5F;
            l1 = l2;
          }
        }
        else
        {
          bool4 = false;
          f3 = 0.0F;
        }
        bool3 = (l1 & 0x144) < 0L;
        if (bool3)
        {
          if (localSensorDetailViewModel != null) {
            localObject1 = localSensorDetailViewModel.K();
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
              l2 = 1024L;
            } else {
              l2 = 512L;
            }
            l2 = l1 | l2;
          }
          if (bool5) {
            f4 = 0.5F;
          } else {
            f4 = 1.0F;
          }
          bool6 = ViewDataBinding.safeUnbox(Boolean.valueOf(true ^ bool5));
          l1 = l2;
        }
        else
        {
          bool6 = false;
          f4 = 0.0F;
        }
        bool3 = (l1 & 0x148) < 0L;
        if (bool3)
        {
          if (localSensorDetailViewModel != null) {
            localObject1 = localSensorDetailViewModel.H();
          } else {
            localObject1 = null;
          }
          updateLiveDataRegistration(3, (LiveData)localObject1);
          if (localObject1 != null) {
            localObject1 = (Boolean)((LiveData)localObject1).getValue();
          } else {
            localObject1 = null;
          }
          bool7 = ViewDataBinding.safeUnbox((Boolean)localObject1);
          l2 = l1;
          if (bool3)
          {
            if (bool7) {
              l2 = 4096L;
            } else {
              l2 = 2048L;
            }
            l2 = l1 | l2;
          }
          if (bool7) {
            f1 = f2;
          } else {
            f1 = 0.5F;
          }
          l1 = l2;
        }
        else
        {
          bool7 = false;
        }
        if ((l1 & 0x150) != 0L)
        {
          if (localSensorDetailViewModel != null) {
            localObject1 = localSensorDetailViewModel.G();
          } else {
            localObject1 = null;
          }
          updateLiveDataRegistration(4, (LiveData)localObject1);
          if (localObject1 != null) {
            localObject1 = (Boolean)((LiveData)localObject1).getValue();
          } else {
            localObject1 = null;
          }
          bool5 = ViewDataBinding.safeUnbox((Boolean)localObject1);
        }
        else
        {
          bool5 = false;
        }
        if ((l1 & 0x160) != 0L)
        {
          if (localSensorDetailViewModel != null) {
            localObject1 = localSensorDetailViewModel.y();
          } else {
            localObject1 = null;
          }
          updateLiveDataRegistration(5, (LiveData)localObject1);
          if (localObject1 != null) {
            localObject1 = (Integer)((LiveData)localObject1).getValue();
          } else {
            localObject1 = null;
          }
          localObject1 = String.valueOf(ViewDataBinding.safeUnbox((Integer)localObject1));
          f2 = f1;
          f1 = f3;
          f3 = f2;
        }
        else
        {
          f2 = f1;
          f1 = f3;
          localObject1 = null;
          f3 = f2;
        }
      }
      else
      {
        bool4 = false;
        bool1 = false;
        bool2 = false;
        bool5 = false;
        bool6 = false;
        bool7 = false;
        localObject1 = null;
        f3 = 0.0F;
        f4 = 0.0F;
        f1 = 0.0F;
      }
      if ((l1 & 0x150) != 0L) {
        CompoundButtonBindingAdapter.setChecked(this.x, bool5);
      }
      if ((l1 & 0x148) != 0L)
      {
        this.x.setEnabled(bool7);
        if (ViewDataBinding.getBuildSdkInt() >= 11) {
          this.p2.setAlpha(f3);
        }
      }
      if ((l1 & 0x141) != 0L) {
        a.h(this.y, bool1);
      }
      if ((0x144 & l1) != 0L)
      {
        this.y.setEnabled(bool6);
        if (ViewDataBinding.getBuildSdkInt() >= 11) {
          this.y.setAlpha(f4);
        }
      }
      if ((l1 & 0x180) != 0L)
      {
        this.y.setOnClickListener(localOnClickListener);
        this.z.setOnClickListener(localOnClickListener);
        this.p0.setOnClickListener(localOnClickListener);
        this.p1.setOnClickListener(localOnClickListener);
      }
      if ((0x142 & l1) != 0L)
      {
        this.p0.setEnabled(bool4);
        if (ViewDataBinding.getBuildSdkInt() >= 11) {
          this.p0.setAlpha(f1);
        }
      }
      if ((l1 & 0x140) != 0L) {
        a.h(this.p2, bool2);
      }
      if ((l1 & 0x160) != 0L) {
        TextViewBindingAdapter.setText(this.H3, (CharSequence)localObject1);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable SensorDetailViewModel paramSensorDetailViewModel)
  {
    this.J3 = paramSensorDetailViewModel;
    try
    {
      this.M3 |= 0x40;
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
      return this.M3 != 0L;
    }
    finally {}
  }
  
  public void i(@Nullable View.OnClickListener paramOnClickListener)
  {
    this.I3 = paramOnClickListener;
    try
    {
      this.M3 |= 0x80;
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
      this.M3 = 256L;
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
            if (paramInt1 != 4)
            {
              if (paramInt1 != 5) {
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
      return q((LiveData)paramObject, paramInt2);
    }
    return p((LiveData)paramObject, paramInt2);
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivitySensorDetailBottomBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */