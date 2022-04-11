package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import androidx.lifecycle.LifecycleOwner;
import com.google.android.material.appbar.AppBarLayout;
import com.tplink.iot.view.ipcamera.base.b;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.view.ipcamera.widget.CameraLoadingView;
import com.tplink.iot.viewmodel.ipcamera.memories.MemoriesViewModel;

public class ActivityMemoriesVideoBindingImpl
  extends ActivityMemoriesVideoBinding
{
  @Nullable
  private static final SparseIntArray H3;
  @Nullable
  private static final ViewDataBinding.IncludedLayouts p3;
  private long I3 = -1L;
  
  static
  {
    Object localObject = new ViewDataBinding.IncludedLayouts(8);
    p3 = (ViewDataBinding.IncludedLayouts)localObject;
    ((ViewDataBinding.IncludedLayouts)localObject).setIncludes(0, new String[] { "dialog_memory_bottom_operation" }, new int[] { 2 }, new int[] { 2131558806 });
    localObject = new SparseIntArray();
    H3 = (SparseIntArray)localObject;
    ((SparseIntArray)localObject).put(2131364284, 3);
    ((SparseIntArray)localObject).put(2131364275, 4);
    ((SparseIntArray)localObject).put(2131364290, 5);
    ((SparseIntArray)localObject).put(2131364771, 6);
    ((SparseIntArray)localObject).put(2131364772, 7);
  }
  
  public ActivityMemoriesVideoBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 8, p3, H3));
  }
  
  private ActivityMemoriesVideoBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 2, (CameraLoadingView)paramArrayOfObject[1], (RelativeLayout)paramArrayOfObject[0], (Toolbar)paramArrayOfObject[4], (AppBarLayout)paramArrayOfObject[3], (TextView)paramArrayOfObject[5], (FrameLayout)paramArrayOfObject[6], (TextView)paramArrayOfObject[7], (DialogMemoryBottomOperationBinding)paramArrayOfObject[2]);
    this.c.setTag(null);
    this.d.setTag(null);
    setContainedBinding(this.p0);
    setRootTag(paramView);
    invalidateAll();
  }
  
  private boolean h(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.I3 |= 1L;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean i(DialogMemoryBottomOperationBinding paramDialogMemoryBottomOperationBinding, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.I3 |= 0x2;
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
      long l1 = this.I3;
      this.I3 = 0L;
      ObservableBoolean localObservableBoolean = null;
      MemoriesViewModel localMemoriesViewModel = this.p2;
      g localg = this.p1;
      boolean bool1 = false;
      boolean bool2 = false;
      boolean bool3 = (l1 & 0x15) < 0L;
      long l2 = l1;
      if (bool3)
      {
        if (localMemoriesViewModel != null) {
          localObservableBoolean = localMemoriesViewModel.o;
        }
        updateRegistration(0, localObservableBoolean);
        if (localObservableBoolean != null) {
          bool2 = localObservableBoolean.get();
        }
        l2 = l1;
        bool1 = bool2;
        if (bool3)
        {
          if (bool2) {
            l2 = 64L;
          } else {
            l2 = 32L;
          }
          l2 = l1 | l2;
          bool1 = bool2;
        }
      }
      if ((0x15 & l2) != 0L) {
        b.K(this.c, Boolean.valueOf(bool1));
      }
      if ((0x18 & l2) != 0L) {
        this.p0.i(localg);
      }
      if ((l2 & 0x14) != 0L) {
        this.p0.h(localMemoriesViewModel);
      }
      ViewDataBinding.executeBindingsOn(this.p0);
      return;
    }
    finally {}
  }
  
  public boolean hasPendingBindings()
  {
    try
    {
      if (this.I3 != 0L) {
        return true;
      }
      return this.p0.hasPendingBindings();
    }
    finally {}
  }
  
  public void invalidateAll()
  {
    try
    {
      this.I3 = 16L;
      this.p0.invalidateAll();
      requestRebind();
      return;
    }
    finally {}
  }
  
  public void l(@Nullable MemoriesViewModel paramMemoriesViewModel)
  {
    this.p2 = paramMemoriesViewModel;
    try
    {
      this.I3 |= 0x4;
      notifyPropertyChanged(62);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void m(@Nullable g paramg)
  {
    this.p1 = paramg;
    try
    {
      this.I3 |= 0x8;
      notifyPropertyChanged(79);
      super.requestRebind();
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
      return i((DialogMemoryBottomOperationBinding)paramObject, paramInt2);
    }
    return h((ObservableBoolean)paramObject, paramInt2);
  }
  
  public void setLifecycleOwner(@Nullable LifecycleOwner paramLifecycleOwner)
  {
    super.setLifecycleOwner(paramLifecycleOwner);
    this.p0.setLifecycleOwner(paramLifecycleOwner);
  }
  
  public boolean setVariable(int paramInt, @Nullable Object paramObject)
  {
    if (62 == paramInt)
    {
      l((MemoriesViewModel)paramObject);
    }
    else
    {
      if (79 != paramInt) {
        break label36;
      }
      m((g)paramObject);
    }
    boolean bool = true;
    return bool;
    label36:
    bool = false;
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityMemoriesVideoBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */