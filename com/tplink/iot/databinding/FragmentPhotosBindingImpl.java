package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.tplink.iot.view.ipcamera.base.b;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.view.ipcamera.widget.CameraLoadingView;
import com.tplink.iot.viewmodel.ipcamera.memories.MemoriesViewModel;

public class FragmentPhotosBindingImpl
  extends FragmentPhotosBinding
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts p2;
  @Nullable
  private static final SparseIntArray p3;
  private long H3 = -1L;
  
  static
  {
    Object localObject = new ViewDataBinding.IncludedLayouts(7);
    p2 = (ViewDataBinding.IncludedLayouts)localObject;
    ((ViewDataBinding.IncludedLayouts)localObject).setIncludes(0, new String[] { "dialog_memory_bottom_operation" }, new int[] { 4 }, new int[] { 2131558806 });
    localObject = new SparseIntArray();
    p3 = (SparseIntArray)localObject;
    ((SparseIntArray)localObject).put(2131363551, 5);
    ((SparseIntArray)localObject).put(2131361964, 6);
  }
  
  public FragmentPhotosBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 7, p2, p3));
  }
  
  private FragmentPhotosBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 4, (View)paramArrayOfObject[6], (RelativeLayout)paramArrayOfObject[2], (CollapsingToolbarLayout)paramArrayOfObject[0], (RecyclerView)paramArrayOfObject[1], (CameraLoadingView)paramArrayOfObject[3], (ImageView)paramArrayOfObject[5], (DialogMemoryBottomOperationBinding)paramArrayOfObject[4]);
    this.d.setTag(null);
    this.f.setTag(null);
    this.q.setTag(null);
    this.x.setTag(null);
    setContainedBinding(this.z);
    setRootTag(paramView);
    invalidateAll();
  }
  
  private boolean l(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.H3 |= 1L;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean m(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.H3 |= 0x2;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean n(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.H3 |= 0x4;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean o(DialogMemoryBottomOperationBinding paramDialogMemoryBottomOperationBinding, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.H3 |= 0x8;
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
      long l1 = this.H3;
      this.H3 = 0L;
      MemoriesViewModel localMemoriesViewModel = this.p1;
      g localg = this.p0;
      long l2;
      boolean bool3;
      int j;
      int i;
      int k;
      if ((0x57 & l1) != 0L)
      {
        boolean bool1 = (l1 & 0x51) < 0L;
        ObservableBoolean localObservableBoolean;
        boolean bool2;
        if (bool1)
        {
          if (localMemoriesViewModel != null) {
            localObservableBoolean = localMemoriesViewModel.o;
          } else {
            localObservableBoolean = null;
          }
          updateRegistration(0, localObservableBoolean);
          if (localObservableBoolean != null) {
            bool2 = localObservableBoolean.get();
          } else {
            bool2 = false;
          }
          l2 = l1;
          bool3 = bool2;
          if (bool1)
          {
            if (bool2) {
              l2 = 256L;
            } else {
              l2 = 128L;
            }
            l2 = l1 | l2;
            bool3 = bool2;
          }
        }
        else
        {
          bool3 = false;
          l2 = l1;
        }
        bool1 = (l2 & 0x52) < 0L;
        if (bool1)
        {
          if (localMemoriesViewModel != null) {
            localObservableBoolean = localMemoriesViewModel.i;
          } else {
            localObservableBoolean = null;
          }
          updateRegistration(1, localObservableBoolean);
          if (localObservableBoolean != null) {
            bool2 = localObservableBoolean.get();
          } else {
            bool2 = false;
          }
          l1 = l2;
          if (bool1)
          {
            if (bool2)
            {
              l1 = l2 | 0x1000;
              l2 = 16384L;
            }
            else
            {
              l1 = l2 | 0x800;
              l2 = 8192L;
            }
            l1 |= l2;
          }
          if (bool2) {
            j = 0;
          } else {
            j = 8;
          }
          if (bool2)
          {
            i = 8;
            l2 = l1;
          }
          else
          {
            i = 0;
            l2 = l1;
          }
        }
        else
        {
          i = 0;
          j = 0;
        }
        boolean bool4 = (l2 & 0x54) < 0L;
        int m;
        if (bool4)
        {
          if (localMemoriesViewModel != null) {
            localObservableBoolean = localMemoriesViewModel.c;
          } else {
            localObservableBoolean = null;
          }
          updateRegistration(2, localObservableBoolean);
          if (localObservableBoolean != null) {
            bool2 = localObservableBoolean.get();
          } else {
            bool2 = false;
          }
          l1 = l2;
          if (bool4)
          {
            if (bool2) {
              l1 = 1024L;
            } else {
              l1 = 512L;
            }
            l1 = l2 | l1;
          }
          if (bool2) {
            bool4 = false;
          } else {
            k = 8;
          }
          m = k;
          l2 = l1;
          k = i;
          i = m;
        }
        else
        {
          m = 0;
          k = i;
          i = m;
        }
      }
      else
      {
        bool3 = false;
        k = 0;
        i = 0;
        j = 0;
        l2 = l1;
      }
      if ((0x52 & l2) != 0L)
      {
        this.d.setVisibility(j);
        this.q.setVisibility(k);
      }
      if ((l2 & 0x51) != 0L) {
        b.K(this.x, Boolean.valueOf(bool3));
      }
      if ((0x54 & l2) != 0L) {
        this.z.getRoot().setVisibility(i);
      }
      if ((l2 & 0x60) != 0L) {
        this.z.i(localg);
      }
      if ((l2 & 0x50) != 0L) {
        this.z.h(localMemoriesViewModel);
      }
      ViewDataBinding.executeBindingsOn(this.z);
      return;
    }
    finally {}
  }
  
  public void h(@Nullable MemoriesViewModel paramMemoriesViewModel)
  {
    this.p1 = paramMemoriesViewModel;
    try
    {
      this.H3 |= 0x10;
      notifyPropertyChanged(62);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public boolean hasPendingBindings()
  {
    try
    {
      if (this.H3 != 0L) {
        return true;
      }
      return this.z.hasPendingBindings();
    }
    finally {}
  }
  
  public void i(@Nullable g paramg)
  {
    this.p0 = paramg;
    try
    {
      this.H3 |= 0x20;
      notifyPropertyChanged(79);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void invalidateAll()
  {
    try
    {
      this.H3 = 64L;
      this.z.invalidateAll();
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
          return o((DialogMemoryBottomOperationBinding)paramObject, paramInt2);
        }
        return n((ObservableBoolean)paramObject, paramInt2);
      }
      return m((ObservableBoolean)paramObject, paramInt2);
    }
    return l((ObservableBoolean)paramObject, paramInt2);
  }
  
  public void setLifecycleOwner(@Nullable LifecycleOwner paramLifecycleOwner)
  {
    super.setLifecycleOwner(paramLifecycleOwner);
    this.z.setLifecycleOwner(paramLifecycleOwner);
  }
  
  public boolean setVariable(int paramInt, @Nullable Object paramObject)
  {
    if (62 == paramInt)
    {
      h((MemoriesViewModel)paramObject);
    }
    else
    {
      if (79 != paramInt) {
        break label36;
      }
      i((g)paramObject);
    }
    boolean bool = true;
    return bool;
    label36:
    bool = false;
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentPhotosBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */