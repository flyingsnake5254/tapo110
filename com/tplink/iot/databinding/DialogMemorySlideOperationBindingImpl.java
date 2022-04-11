package com.tplink.iot.databinding;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.Observable;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import androidx.databinding.adapters.ImageViewBindingAdapter;
import com.tplink.iot.generated.callback.a;
import com.tplink.iot.generated.callback.a.a;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.ipcamera.memories.MemoriesViewModel;

public class DialogMemorySlideOperationBindingImpl
  extends DialogMemorySlideOperationBinding
  implements a.a
{
  @Nullable
  private static final SparseIntArray p0;
  @Nullable
  private static final ViewDataBinding.IncludedLayouts z;
  @Nullable
  private final View.OnClickListener H3;
  @Nullable
  private final View.OnClickListener I3;
  private long J3 = -1L;
  @NonNull
  private final LinearLayout p1;
  @Nullable
  private final View.OnClickListener p2;
  @Nullable
  private final View.OnClickListener p3;
  
  public DialogMemorySlideOperationBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 5, z, p0));
  }
  
  private DialogMemorySlideOperationBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 1, (ImageView)paramArrayOfObject[4], (ImageView)paramArrayOfObject[3], (ImageView)paramArrayOfObject[2], (ImageView)paramArrayOfObject[1]);
    this.c.setTag(null);
    this.d.setTag(null);
    this.f.setTag(null);
    this.q.setTag(null);
    paramDataBindingComponent = (LinearLayout)paramArrayOfObject[0];
    this.p1 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    setRootTag(paramView);
    this.p2 = new a(this, 2);
    this.p3 = new a(this, 3);
    this.H3 = new a(this, 1);
    this.I3 = new a(this, 4);
    invalidateAll();
  }
  
  private boolean l(ObservableBoolean paramObservableBoolean, int paramInt)
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
            localg = this.x;
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
          localg = this.x;
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
        localg = this.x;
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
      localg = this.x;
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
      MemoriesViewModel localMemoriesViewModel = this.y;
      Object localObject1 = null;
      Object localObject3 = null;
      boolean bool1 = (l1 & 0xB) < 0L;
      long l2 = l1;
      if (bool1)
      {
        localObject1 = localObject3;
        if (localMemoriesViewModel != null) {
          localObject1 = localMemoriesViewModel.h;
        }
        boolean bool2 = false;
        updateRegistration(0, (Observable)localObject1);
        if (localObject1 != null) {
          bool2 = ((ObservableBoolean)localObject1).get();
        }
        l2 = l1;
        if (bool1)
        {
          if (bool2) {
            l2 = 32L;
          } else {
            l2 = 16L;
          }
          l2 = l1 | l2;
        }
        int i;
        if (bool2)
        {
          localObject1 = this.f.getContext();
          i = 2131231334;
        }
        else
        {
          localObject1 = this.f.getContext();
          i = 2131231335;
        }
        localObject1 = AppCompatResources.getDrawable((Context)localObject1, i);
      }
      if ((0x8 & l2) != 0L)
      {
        this.c.setOnClickListener(this.I3);
        this.d.setOnClickListener(this.p3);
        this.f.setOnClickListener(this.p2);
        this.q.setOnClickListener(this.H3);
      }
      if ((l2 & 0xB) != 0L) {
        ImageViewBindingAdapter.setImageDrawable(this.f, (Drawable)localObject1);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable MemoriesViewModel paramMemoriesViewModel)
  {
    this.y = paramMemoriesViewModel;
    try
    {
      this.J3 |= 0x2;
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
    this.x = paramg;
    try
    {
      this.J3 |= 0x4;
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
      this.J3 = 8L;
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
    return l((ObservableBoolean)paramObject, paramInt2);
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\DialogMemorySlideOperationBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */