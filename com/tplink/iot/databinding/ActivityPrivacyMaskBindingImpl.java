package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tplink.iot.view.ipcamera.base.b;
import com.tplink.iot.view.ipcamera.widget.CameraLoadingView;
import com.tplink.iot.viewmodel.ipcamera.setting.privacymask.PrivacyMaskViewModel;

public class ActivityPrivacyMaskBindingImpl
  extends ActivityPrivacyMaskBinding
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts I3;
  @Nullable
  private static final SparseIntArray J3;
  @NonNull
  private final RelativeLayout K3;
  @NonNull
  private final View L3;
  private long M3 = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    J3 = localSparseIntArray;
    localSparseIntArray.put(2131364193, 8);
    localSparseIntArray.put(2131363698, 9);
  }
  
  public ActivityPrivacyMaskBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 10, I3, J3));
  }
  
  private ActivityPrivacyMaskBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 4, (CameraLoadingView)paramArrayOfObject[7], (TextView)paramArrayOfObject[6], (FrameLayout)paramArrayOfObject[4], (ImageView)paramArrayOfObject[5], (CheckBox)paramArrayOfObject[1], (ImageView)paramArrayOfObject[9], (RelativeLayout)paramArrayOfObject[3], (TextView)paramArrayOfObject[8]);
    this.c.setTag(null);
    paramDataBindingComponent = (RelativeLayout)paramArrayOfObject[0];
    this.K3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (View)paramArrayOfObject[2];
    this.L3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    this.d.setTag(null);
    this.f.setTag(null);
    this.q.setTag(null);
    this.x.setTag(null);
    this.z.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  private boolean l(LiveData<Boolean> paramLiveData, int paramInt)
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
  
  private boolean m(MutableLiveData<Boolean> paramMutableLiveData, int paramInt)
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
  
  private boolean n(MutableLiveData<Boolean> paramMutableLiveData, int paramInt)
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
  
  private boolean o(MutableLiveData<Boolean> paramMutableLiveData, int paramInt)
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
      long l = this.M3;
      this.M3 = 0L;
      View.OnClickListener localOnClickListener = this.p3;
      PrivacyMaskViewModel localPrivacyMaskViewModel = this.p1;
      boolean bool1 = false;
      boolean bool5;
      boolean bool6;
      boolean bool7;
      if ((0xCE & l) != 0L)
      {
        Object localObject1;
        boolean bool2;
        boolean bool3;
        if ((l & 0xC2) != 0L)
        {
          if (localPrivacyMaskViewModel != null) {
            localObject1 = localPrivacyMaskViewModel.j();
          } else {
            localObject1 = null;
          }
          updateLiveDataRegistration(1, (LiveData)localObject1);
          if (localObject1 != null) {
            localObject1 = (Boolean)((LiveData)localObject1).getValue();
          } else {
            localObject1 = null;
          }
          bool2 = ViewDataBinding.safeUnbox((Boolean)localObject1);
          bool3 = ViewDataBinding.safeUnbox((Boolean)localObject1);
        }
        else
        {
          bool3 = false;
          bool2 = false;
        }
        boolean bool4;
        if ((l & 0xC4) != 0L)
        {
          if (localPrivacyMaskViewModel != null) {
            localObject1 = localPrivacyMaskViewModel.i();
          } else {
            localObject1 = null;
          }
          updateLiveDataRegistration(2, (LiveData)localObject1);
          if (localObject1 != null) {
            localObject1 = (Boolean)((LiveData)localObject1).getValue();
          } else {
            localObject1 = null;
          }
          bool4 = ViewDataBinding.safeUnbox(Boolean.valueOf(ViewDataBinding.safeUnbox((Boolean)localObject1) ^ true));
        }
        else
        {
          bool4 = false;
        }
        bool5 = bool3;
        bool6 = bool2;
        bool7 = bool4;
        if ((l & 0xC8) != 0L)
        {
          if (localPrivacyMaskViewModel != null) {
            localObject1 = localPrivacyMaskViewModel.n();
          } else {
            localObject1 = null;
          }
          updateLiveDataRegistration(3, (LiveData)localObject1);
          if (localObject1 != null) {
            localObject1 = (Boolean)((LiveData)localObject1).getValue();
          } else {
            localObject1 = null;
          }
          bool1 = ViewDataBinding.safeUnbox((Boolean)localObject1);
          bool5 = bool3;
          bool6 = bool2;
          bool7 = bool4;
        }
      }
      else
      {
        bool5 = false;
        bool6 = false;
        bool7 = false;
      }
      if ((l & 0xC8) != 0L) {
        b.K(this.c, Boolean.valueOf(bool1));
      }
      if ((0xC2 & l) != 0L)
      {
        b.Q(this.L3, bool6);
        b.Q(this.f, bool6);
        CompoundButtonBindingAdapter.setChecked(this.x, bool5);
        b.Q(this.z, bool6);
      }
      if ((l & 0xC4) != 0L) {
        b.Q(this.d, bool7);
      }
      if ((0xA0 & l) != 0L)
      {
        this.q.setOnClickListener(localOnClickListener);
        this.z.setOnClickListener(localOnClickListener);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable View.OnClickListener paramOnClickListener)
  {
    this.p3 = paramOnClickListener;
    try
    {
      this.M3 |= 0x20;
      notifyPropertyChanged(9);
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
  
  public void i(@Nullable PrivacyMaskViewModel paramPrivacyMaskViewModel)
  {
    this.p1 = paramPrivacyMaskViewModel;
    try
    {
      this.M3 |= 0x40;
      notifyPropertyChanged(103);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void invalidateAll()
  {
    try
    {
      this.M3 = 128L;
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
          return n((MutableLiveData)paramObject, paramInt2);
        }
        return m((MutableLiveData)paramObject, paramInt2);
      }
      return o((MutableLiveData)paramObject, paramInt2);
    }
    return l((LiveData)paramObject, paramInt2);
  }
  
  public void p(@Nullable LiveData<Boolean> paramLiveData)
  {
    this.p2 = paramLiveData;
  }
  
  public void q(@Nullable String paramString)
  {
    this.H3 = paramString;
  }
  
  public boolean setVariable(int paramInt, @Nullable Object paramObject)
  {
    if (57 == paramInt)
    {
      p((LiveData)paramObject);
    }
    else if (60 == paramInt)
    {
      q((String)paramObject);
    }
    else if (9 == paramInt)
    {
      h((View.OnClickListener)paramObject);
    }
    else
    {
      if (103 != paramInt) {
        break label70;
      }
      i((PrivacyMaskViewModel)paramObject);
    }
    boolean bool = true;
    return bool;
    label70:
    bool = false;
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityPrivacyMaskBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */