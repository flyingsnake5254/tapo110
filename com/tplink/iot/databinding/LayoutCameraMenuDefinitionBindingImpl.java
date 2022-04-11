package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;

public class LayoutCameraMenuDefinitionBindingImpl
  extends LayoutCameraMenuDefinitionBinding
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts q;
  @Nullable
  private static final SparseIntArray x;
  @NonNull
  private final LinearLayout y;
  private long z = -1L;
  
  public LayoutCameraMenuDefinitionBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 3, q, x));
  }
  
  private LayoutCameraMenuDefinitionBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 1, (TextView)paramArrayOfObject[1], (TextView)paramArrayOfObject[2]);
    this.c.setTag(null);
    this.d.setTag(null);
    paramDataBindingComponent = (LinearLayout)paramArrayOfObject[0];
    this.y = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  private boolean i(ObservableBoolean paramObservableBoolean, int paramInt)
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
      long l1 = this.z;
      this.z = 0L;
      Object localObject1 = this.f;
      int i = 0;
      boolean bool1 = false;
      boolean bool2 = (l1 & 0x3) < 0L;
      long l2;
      int j;
      if (bool2)
      {
        if (localObject1 != null) {
          bool1 = ((ObservableBoolean)localObject1).get();
        }
        l2 = l1;
        if (bool2)
        {
          if (bool1)
          {
            l1 |= 0x8;
            l2 = 32L;
          }
          else
          {
            l1 |= 0x4;
            l2 = 16L;
          }
          l2 = l1 | l2;
        }
        localObject1 = this.d;
        if (bool1) {
          j = ViewDataBinding.getColorFromResource((View)localObject1, 2131100206);
        } else {
          j = ViewDataBinding.getColorFromResource((View)localObject1, 2131099706);
        }
        if (bool1) {
          i = ViewDataBinding.getColorFromResource(this.c, 2131099706);
        } else {
          i = ViewDataBinding.getColorFromResource(this.c, 2131100206);
        }
      }
      else
      {
        j = 0;
        l2 = l1;
      }
      if ((l2 & 0x3) != 0L)
      {
        this.c.setTextColor(i);
        this.d.setTextColor(j);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable ObservableBoolean paramObservableBoolean)
  {
    updateRegistration(0, paramObservableBoolean);
    this.f = paramObservableBoolean;
    try
    {
      this.z |= 1L;
      notifyPropertyChanged(40);
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
      this.z = 2L;
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
    return i((ObservableBoolean)paramObject, paramInt2);
  }
  
  public boolean setVariable(int paramInt, @Nullable Object paramObject)
  {
    boolean bool;
    if (40 == paramInt)
    {
      h((ObservableBoolean)paramObject);
      bool = true;
    }
    else
    {
      bool = false;
    }
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\LayoutCameraMenuDefinitionBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */