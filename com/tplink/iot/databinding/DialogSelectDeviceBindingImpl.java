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

public class DialogSelectDeviceBindingImpl
  extends DialogSelectDeviceBinding
{
  @Nullable
  private static final SparseIntArray p0;
  @Nullable
  private static final ViewDataBinding.IncludedLayouts z;
  @NonNull
  private final ConstraintLayout p1;
  private long p2 = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    p0 = localSparseIntArray;
    localSparseIntArray.put(2131364010, 2);
    localSparseIntArray.put(2131364252, 3);
    localSparseIntArray.put(2131364293, 4);
    localSparseIntArray.put(2131363820, 5);
  }
  
  public DialogSelectDeviceBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 6, z, p0));
  }
  
  private DialogSelectDeviceBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 1, (TextView)paramArrayOfObject[1], (RecyclerView)paramArrayOfObject[5], (TextView)paramArrayOfObject[2], (TextView)paramArrayOfObject[3], (View)paramArrayOfObject[4]);
    this.c.setTag(null);
    paramDataBindingComponent = (ConstraintLayout)paramArrayOfObject[0];
    this.p1 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  private boolean i(MutableLiveData<Integer> paramMutableLiveData, int paramInt)
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
  
  protected void executeBindings()
  {
    try
    {
      long l1 = this.p2;
      this.p2 = 0L;
      SelectDeviceViewModel localSelectDeviceViewModel = this.y;
      float f = 0.0F;
      boolean bool1 = false;
      boolean bool2 = false;
      boolean bool3 = (l1 & 0x7) < 0L;
      Object localObject1;
      long l2;
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
        l2 = l1;
        if (bool3)
        {
          if (bool2) {
            l2 = 16L;
          } else {
            l2 = 8L;
          }
          l2 = l1 | l2;
        }
        if (localSelectDeviceViewModel != null) {
          localObject1 = localSelectDeviceViewModel.j(i);
        } else {
          localObject1 = null;
        }
        if (bool2) {
          f = 0.4F;
        } else {
          f = 1.0F;
        }
      }
      else
      {
        localObject1 = null;
        bool2 = bool1;
        l2 = l1;
      }
      if ((l2 & 0x7) != 0L)
      {
        if (ViewDataBinding.getBuildSdkInt() >= 11) {
          this.c.setAlpha(f);
        }
        TextViewBindingAdapter.setText(this.c, (CharSequence)localObject1);
        b.c(this.c, Boolean.valueOf(bool2), null);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable SelectDeviceViewModel paramSelectDeviceViewModel)
  {
    this.y = paramSelectDeviceViewModel;
    try
    {
      this.p2 |= 0x2;
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
      this.p2 = 4L;
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\DialogSelectDeviceBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */