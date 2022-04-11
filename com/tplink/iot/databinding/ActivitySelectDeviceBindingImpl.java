package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.view.ipcamera.base.b;
import com.tplink.iot.viewmodel.ipcamera.play.SelectDeviceViewModel;

public class ActivitySelectDeviceBindingImpl
  extends ActivitySelectDeviceBinding
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts q;
  @Nullable
  private static final SparseIntArray x;
  @NonNull
  private final ConstraintLayout y;
  private long z = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    x = localSparseIntArray;
    localSparseIntArray.put(2131363820, 2);
  }
  
  public ActivitySelectDeviceBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 3, q, x));
  }
  
  private ActivitySelectDeviceBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 1, (TextView)paramArrayOfObject[1], (RecyclerView)paramArrayOfObject[2]);
    this.c.setTag(null);
    paramDataBindingComponent = (ConstraintLayout)paramArrayOfObject[0];
    this.y = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  private boolean i(MutableLiveData<Integer> paramMutableLiveData, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.z |= 1L;
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
      long l = this.z;
      this.z = 0L;
      SelectDeviceViewModel localSelectDeviceViewModel = this.f;
      boolean bool1 = false;
      boolean bool2 = false;
      boolean bool3 = (l & 0x7) < 0L;
      if (bool3)
      {
        if (localSelectDeviceViewModel != null) {
          localObject1 = localSelectDeviceViewModel.n();
        } else {
          localObject1 = null;
        }
        updateLiveDataRegistration(0, (LiveData)localObject1);
        if (localObject1 != null) {
          localObject1 = (Integer)((LiveData)localObject1).getValue();
        } else {
          localObject1 = null;
        }
        int i = ViewDataBinding.safeUnbox((Integer)localObject1);
        if (i > 32) {
          bool2 = true;
        }
        bool1 = bool2;
        if (localSelectDeviceViewModel != null)
        {
          localObject1 = localSelectDeviceViewModel.j(i);
          break label127;
        }
      }
      Object localObject1 = null;
      bool2 = bool1;
      label127:
      if (bool3)
      {
        TextViewBindingAdapter.setText(this.c, (CharSequence)localObject1);
        b.c(this.c, Boolean.valueOf(bool2), null);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable SelectDeviceViewModel paramSelectDeviceViewModel)
  {
    this.f = paramSelectDeviceViewModel;
    try
    {
      this.z |= 0x2;
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
      return this.z != 0L;
    }
    finally {}
  }
  
  public void invalidateAll()
  {
    try
    {
      this.z = 4L;
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
    if (103 == paramInt)
    {
      h((SelectDeviceViewModel)paramObject);
      bool = true;
    }
    else
    {
      bool = false;
    }
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivitySelectDeviceBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */