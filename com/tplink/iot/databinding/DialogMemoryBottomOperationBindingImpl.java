package com.tplink.iot.databinding;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.Observable;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.databinding.adapters.ViewBindingAdapter;
import com.tplink.iot.generated.callback.a;
import com.tplink.iot.generated.callback.a.a;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.ipcamera.memories.MemoriesViewModel;

public class DialogMemoryBottomOperationBindingImpl
  extends DialogMemoryBottomOperationBinding
  implements a.a
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts p0;
  @Nullable
  private static final SparseIntArray p1;
  @Nullable
  private final View.OnClickListener H3;
  @Nullable
  private final View.OnClickListener I3;
  private long J3 = -1L;
  @Nullable
  private final View.OnClickListener p2;
  @Nullable
  private final View.OnClickListener p3;
  
  public DialogMemoryBottomOperationBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 5, p0, p1));
  }
  
  private DialogMemoryBottomOperationBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 5, (LinearLayout)paramArrayOfObject[0], (TextView)paramArrayOfObject[4], (TextView)paramArrayOfObject[3], (TextView)paramArrayOfObject[2], (TextView)paramArrayOfObject[1]);
    this.c.setTag(null);
    this.d.setTag(null);
    this.f.setTag(null);
    this.q.setTag(null);
    this.x.setTag(null);
    setRootTag(paramView);
    this.p2 = new a(this, 4);
    this.p3 = new a(this, 2);
    this.H3 = new a(this, 3);
    this.I3 = new a(this, 1);
    invalidateAll();
  }
  
  private boolean l(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.J3 |= 0x4;
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
        this.J3 |= 0x10;
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
        this.J3 |= 1L;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean o(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.J3 |= 0x8;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean p(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.J3 |= 0x2;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  public final void d(int paramInt, View paramView)
  {
    int i = 0;
    int j = 0;
    int k = 0;
    int m = 0;
    g localg;
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt == 4)
          {
            localg = this.y;
            paramInt = m;
            if (localg != null) {
              paramInt = 1;
            }
            if (paramInt != 0) {
              localg.onClick(paramView);
            }
          }
        }
        else
        {
          localg = this.y;
          paramInt = i;
          if (localg != null) {
            paramInt = 1;
          }
          if (paramInt != 0) {
            localg.onClick(paramView);
          }
        }
      }
      else
      {
        localg = this.y;
        paramInt = j;
        if (localg != null) {
          paramInt = 1;
        }
        if (paramInt != 0) {
          localg.onClick(paramView);
        }
      }
    }
    else
    {
      localg = this.y;
      paramInt = k;
      if (localg != null) {
        paramInt = 1;
      }
      if (paramInt != 0) {
        localg.onClick(paramView);
      }
    }
  }
  
  protected void executeBindings()
  {
    try
    {
      long l1 = this.J3;
      this.J3 = 0L;
      MemoriesViewModel localMemoriesViewModel = this.z;
      Object localObject1;
      boolean bool3;
      long l2;
      boolean bool4;
      boolean bool5;
      boolean bool6;
      if ((0xBF & l1) != 0L)
      {
        boolean bool1 = (l1 & 0xA1) < 0L;
        if (bool1)
        {
          if (localMemoriesViewModel != null) {
            localObject1 = localMemoriesViewModel.h;
          } else {
            localObject1 = null;
          }
          updateRegistration(0, (Observable)localObject1);
          if (localObject1 != null) {
            bool3 = ((ObservableBoolean)localObject1).get();
          } else {
            bool3 = false;
          }
          l2 = l1;
          if (bool1)
          {
            if (bool3) {
              l2 = 131072L;
            } else {
              l2 = 65536L;
            }
            l2 = l1 | l2;
          }
          int i;
          if (bool3)
          {
            localObject1 = this.q.getContext();
            i = 2131231333;
          }
          else
          {
            localObject1 = this.q.getContext();
            i = 2131231336;
          }
          localObject1 = AppCompatResources.getDrawable((Context)localObject1, i);
          l1 = l2;
        }
        else
        {
          localObject1 = null;
        }
        boolean bool2 = (l1 & 0xA2) < 0L;
        ObservableBoolean localObservableBoolean;
        if (bool2)
        {
          if (localMemoriesViewModel != null) {
            localObservableBoolean = localMemoriesViewModel.f;
          } else {
            localObservableBoolean = null;
          }
          updateRegistration(1, localObservableBoolean);
          if (localObservableBoolean != null) {
            bool4 = localObservableBoolean.get();
          } else {
            bool4 = false;
          }
          l2 = l1;
          bool3 = bool4;
          if (bool2)
          {
            if (bool4) {
              l2 = 32768L;
            } else {
              l2 = 16384L;
            }
            l2 = l1 | l2;
            bool3 = bool4;
          }
        }
        else
        {
          bool3 = false;
          l2 = l1;
        }
        bool2 = (l2 & 0xA4) < 0L;
        if (bool2)
        {
          if (localMemoriesViewModel != null) {
            localObservableBoolean = localMemoriesViewModel.d;
          } else {
            localObservableBoolean = null;
          }
          updateRegistration(2, localObservableBoolean);
          if (localObservableBoolean != null) {
            bool5 = localObservableBoolean.get();
          } else {
            bool5 = false;
          }
          l1 = l2;
          bool4 = bool5;
          if (bool2)
          {
            if (bool5) {
              l1 = 8192L;
            } else {
              l1 = 4096L;
            }
            l1 = l2 | l1;
            bool4 = bool5;
          }
        }
        else
        {
          bool4 = false;
          l1 = l2;
        }
        bool2 = (l1 & 0xA8) < 0L;
        if (bool2)
        {
          if (localMemoriesViewModel != null) {
            localObservableBoolean = localMemoriesViewModel.g;
          } else {
            localObservableBoolean = null;
          }
          updateRegistration(3, localObservableBoolean);
          if (localObservableBoolean != null) {
            bool6 = localObservableBoolean.get();
          } else {
            bool6 = false;
          }
          l2 = l1;
          bool5 = bool6;
          if (bool2)
          {
            if (bool6) {
              l2 = 2048L;
            } else {
              l2 = 1024L;
            }
            l2 = l1 | l2;
            bool5 = bool6;
          }
        }
        else
        {
          bool5 = false;
          l2 = l1;
        }
        bool2 = (l2 & 0xB0) < 0L;
        if (bool2)
        {
          if (localMemoriesViewModel != null) {
            localObservableBoolean = localMemoriesViewModel.e;
          } else {
            localObservableBoolean = null;
          }
          updateRegistration(4, localObservableBoolean);
          if (localObservableBoolean != null) {
            bool6 = localObservableBoolean.get();
          } else {
            bool6 = false;
          }
          l1 = l2;
          if (bool2)
          {
            if (bool6) {
              l1 = 512L;
            } else {
              l1 = 256L;
            }
            l1 = l2 | l1;
          }
          l2 = l1;
        }
        else
        {
          bool6 = false;
        }
        boolean bool7 = bool3;
        bool3 = bool4;
        bool4 = bool7;
      }
      else
      {
        localObject1 = null;
        bool6 = false;
        bool4 = false;
        bool5 = false;
        bool3 = false;
        l2 = l1;
      }
      if ((l2 & 0xA4) != 0L)
      {
        this.d.setEnabled(bool3);
        ViewBindingAdapter.setOnClick(this.d, this.p2, bool3);
      }
      if ((0xB0 & l2) != 0L)
      {
        this.f.setEnabled(bool6);
        ViewBindingAdapter.setOnClick(this.f, this.H3, bool6);
      }
      if ((l2 & 0xA1) != 0L) {
        TextViewBindingAdapter.setDrawableTop(this.q, (Drawable)localObject1);
      }
      if ((l2 & 0xA8) != 0L)
      {
        this.q.setEnabled(bool5);
        ViewBindingAdapter.setOnClick(this.q, this.p3, bool5);
      }
      if ((l2 & 0xA2) != 0L)
      {
        this.x.setEnabled(bool4);
        ViewBindingAdapter.setOnClick(this.x, this.I3, bool4);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable MemoriesViewModel paramMemoriesViewModel)
  {
    this.z = paramMemoriesViewModel;
    try
    {
      this.J3 |= 0x20;
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
      return this.J3 != 0L;
    }
    finally {}
  }
  
  public void i(@Nullable g paramg)
  {
    this.y = paramg;
    try
    {
      this.J3 |= 0x40;
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
      this.J3 = 128L;
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
            return m((ObservableBoolean)paramObject, paramInt2);
          }
          return o((ObservableBoolean)paramObject, paramInt2);
        }
        return l((ObservableBoolean)paramObject, paramInt2);
      }
      return p((ObservableBoolean)paramObject, paramInt2);
    }
    return n((ObservableBoolean)paramObject, paramInt2);
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\DialogMemoryBottomOperationBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */