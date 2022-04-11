package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import com.tplink.iot.Utils.extension.a;
import com.tplink.iot.devicecommon.viewmodel.IoTDetailBaseViewModel;
import com.yinglan.scrolllayout.ScrollLayout;

public class ActivityBaseIotDeviceDetailBindingImpl
  extends ActivityBaseIotDeviceDetailBinding
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts Q3;
  @Nullable
  private static final SparseIntArray R3;
  private long S3 = -1L;
  
  static
  {
    Object localObject = new ViewDataBinding.IncludedLayouts(18);
    Q3 = (ViewDataBinding.IncludedLayouts)localObject;
    ((ViewDataBinding.IncludedLayouts)localObject).setIncludes(7, new String[] { "activity_base_iot_device_detail_bottom" }, new int[] { 8 }, new int[] { 2131558453 });
    localObject = new SparseIntArray();
    R3 = (SparseIntArray)localObject;
    ((SparseIntArray)localObject).put(2131363003, 9);
    ((SparseIntArray)localObject).put(2131363353, 10);
    ((SparseIntArray)localObject).put(2131364535, 11);
    ((SparseIntArray)localObject).put(2131363121, 12);
    ((SparseIntArray)localObject).put(2131362677, 13);
    ((SparseIntArray)localObject).put(2131362843, 14);
    ((SparseIntArray)localObject).put(2131362196, 15);
    ((SparseIntArray)localObject).put(2131362328, 16);
    ((SparseIntArray)localObject).put(2131362660, 17);
  }
  
  public ActivityBaseIotDeviceDetailBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 18, Q3, R3));
  }
  
  private ActivityBaseIotDeviceDetailBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 5, (CardView)paramArrayOfObject[6], (CardView)paramArrayOfObject[15], (ScrollView)paramArrayOfObject[16], (ActivityBaseIotDeviceDetailBottomBinding)paramArrayOfObject[8], (FrameLayout)paramArrayOfObject[17], (FrameLayout)paramArrayOfObject[0], (FrameLayout)paramArrayOfObject[3], (FrameLayout)paramArrayOfObject[13], (ImageView)paramArrayOfObject[14], (ImageView)paramArrayOfObject[1], (ImageView)paramArrayOfObject[9], (ImageView)paramArrayOfObject[4], (ImageView)paramArrayOfObject[12], (LinearLayout)paramArrayOfObject[10], (ScrollLayout)paramArrayOfObject[7], (TextView)paramArrayOfObject[5], (TextView)paramArrayOfObject[11], (TextView)paramArrayOfObject[2]);
    this.c.setTag(null);
    setContainedBinding(this.q);
    this.y.setTag(null);
    this.z.setTag(null);
    this.p2.setTag(null);
    this.H3.setTag(null);
    this.K3.setTag(null);
    this.L3.setTag(null);
    this.N3.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  private boolean l(ActivityBaseIotDeviceDetailBottomBinding paramActivityBaseIotDeviceDetailBottomBinding, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.S3 |= 0x4;
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
        this.S3 |= 0x2;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean n(LiveData<String> paramLiveData, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.S3 |= 0x10;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean o(LiveData<String> paramLiveData, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.S3 |= 1L;
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
        this.S3 |= 0x8;
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
      long l = this.S3;
      this.S3 = 0L;
      IoTDetailBaseViewModel localIoTDetailBaseViewModel = this.O3;
      View.OnClickListener localOnClickListener = this.P3;
      Object localObject1;
      label90:
      Object localObject3;
      boolean bool1;
      boolean bool2;
      if ((0xBB & l) != 0L)
      {
        if ((l & 0xA1) != 0L)
        {
          if (localIoTDetailBaseViewModel != null) {
            localObject1 = localIoTDetailBaseViewModel.t();
          } else {
            localObject1 = null;
          }
          updateLiveDataRegistration(0, (LiveData)localObject1);
          if (localObject1 != null)
          {
            localObject1 = (String)((LiveData)localObject1).getValue();
            break label90;
          }
        }
        localObject1 = null;
        if ((l & 0xA2) != 0L)
        {
          if (localIoTDetailBaseViewModel != null) {
            localObject3 = localIoTDetailBaseViewModel.x();
          } else {
            localObject3 = null;
          }
          updateLiveDataRegistration(1, (LiveData)localObject3);
          if (localObject3 != null) {
            localObject3 = (Boolean)((LiveData)localObject3).getValue();
          } else {
            localObject3 = null;
          }
          bool1 = ViewDataBinding.safeUnbox((Boolean)localObject3);
        }
        else
        {
          bool1 = false;
        }
        if ((l & 0xA8) != 0L)
        {
          if (localIoTDetailBaseViewModel != null) {
            localObject3 = localIoTDetailBaseViewModel.u();
          } else {
            localObject3 = null;
          }
          updateLiveDataRegistration(3, (LiveData)localObject3);
          if (localObject3 != null) {
            localObject3 = (Boolean)((LiveData)localObject3).getValue();
          } else {
            localObject3 = null;
          }
          bool2 = ViewDataBinding.safeUnbox((Boolean)localObject3);
        }
        else
        {
          bool2 = false;
        }
        if ((l & 0xB0) != 0L)
        {
          if (localIoTDetailBaseViewModel != null) {
            localObject3 = localIoTDetailBaseViewModel.s();
          } else {
            localObject3 = null;
          }
          updateLiveDataRegistration(4, (LiveData)localObject3);
          if (localObject3 != null)
          {
            String str = (String)((LiveData)localObject3).getValue();
            localObject3 = localObject1;
            localObject1 = str;
            break label308;
          }
        }
        localObject3 = localObject1;
        localObject1 = null;
      }
      else
      {
        localObject1 = null;
        bool1 = false;
        bool2 = false;
        localObject3 = null;
      }
      label308:
      if ((0xC0 & l) != 0L)
      {
        this.c.setOnClickListener(localOnClickListener);
        this.q.i(localOnClickListener);
        this.z.setOnClickListener(localOnClickListener);
        this.p2.setOnClickListener(localOnClickListener);
      }
      if ((0xA0 & l) != 0L) {
        this.q.h(localIoTDetailBaseViewModel);
      }
      if ((0xA8 & l) != 0L) {
        a.h(this.H3, bool2);
      }
      if ((l & 0xA1) != 0L) {
        TextViewBindingAdapter.setText(this.L3, (CharSequence)localObject3);
      }
      if ((0xA2 & l) != 0L) {
        a.h(this.L3, bool1);
      }
      if ((l & 0xB0) != 0L) {
        TextViewBindingAdapter.setText(this.N3, (CharSequence)localObject1);
      }
      ViewDataBinding.executeBindingsOn(this.q);
      return;
    }
    finally {}
  }
  
  public void h(@Nullable IoTDetailBaseViewModel paramIoTDetailBaseViewModel)
  {
    this.O3 = paramIoTDetailBaseViewModel;
    try
    {
      this.S3 |= 0x20;
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
      if (this.S3 != 0L) {
        return true;
      }
      return this.q.hasPendingBindings();
    }
    finally {}
  }
  
  public void i(@Nullable View.OnClickListener paramOnClickListener)
  {
    this.P3 = paramOnClickListener;
    try
    {
      this.S3 |= 0x40;
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
      this.S3 = 128L;
      this.q.invalidateAll();
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
            return n((LiveData)paramObject, paramInt2);
          }
          return p((LiveData)paramObject, paramInt2);
        }
        return l((ActivityBaseIotDeviceDetailBottomBinding)paramObject, paramInt2);
      }
      return m((LiveData)paramObject, paramInt2);
    }
    return o((LiveData)paramObject, paramInt2);
  }
  
  public void setLifecycleOwner(@Nullable LifecycleOwner paramLifecycleOwner)
  {
    super.setLifecycleOwner(paramLifecycleOwner);
    this.q.setLifecycleOwner(paramLifecycleOwner);
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityBaseIotDeviceDetailBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */