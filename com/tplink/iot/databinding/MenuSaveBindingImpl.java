package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
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

public class MenuSaveBindingImpl
  extends MenuSaveBinding
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts f;
  @Nullable
  private static final SparseIntArray q;
  @NonNull
  private final LinearLayout x;
  private long y = -1L;
  
  public MenuSaveBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 2, f, q));
  }
  
  private MenuSaveBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 1, (TextView)paramArrayOfObject[1]);
    paramDataBindingComponent = (LinearLayout)paramArrayOfObject[0];
    this.x = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    this.c.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  private boolean i(MutableLiveData<Boolean> paramMutableLiveData, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.y |= 1L;
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
      long l1 = this.y;
      this.y = 0L;
      Object localObject1 = this.d;
      boolean bool1 = false;
      boolean bool2 = (l1 & 0x3) < 0L;
      long l2;
      Object localObject3;
      boolean bool4;
      if (bool2)
      {
        if (localObject1 != null) {
          localObject1 = (Boolean)((LiveData)localObject1).getValue();
        } else {
          localObject1 = null;
        }
        if (localObject1 == null) {
          bool3 = true;
        } else {
          bool3 = false;
        }
        l2 = l1;
        localObject3 = localObject1;
        bool4 = bool3;
        if (bool2)
        {
          if (bool3) {
            l2 = 8L;
          } else {
            l2 = 4L;
          }
          l2 = l1 | l2;
          localObject3 = localObject1;
          bool4 = bool3;
        }
      }
      else
      {
        localObject3 = null;
        bool4 = false;
        l2 = l1;
      }
      boolean bool3 = (l2 & 0x3) < 0L;
      if (bool3)
      {
        if (bool4) {
          bool1 = true;
        } else {
          bool1 = ((Boolean)localObject3).booleanValue();
        }
        bool1 ^= true;
      }
      if (bool3) {
        b.c(this.c, Boolean.valueOf(bool1), null);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable MutableLiveData<Boolean> paramMutableLiveData)
  {
    updateLiveDataRegistration(0, paramMutableLiveData);
    this.d = paramMutableLiveData;
    try
    {
      this.y |= 1L;
      notifyPropertyChanged(20);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public boolean hasPendingBindings()
  {
    try
    {
      return this.y != 0L;
    }
    finally {}
  }
  
  public void invalidateAll()
  {
    try
    {
      this.y = 2L;
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
    if (20 == paramInt)
    {
      h((MutableLiveData)paramObject);
      bool = true;
    }
    else
    {
      bool = false;
    }
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\MenuSaveBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */