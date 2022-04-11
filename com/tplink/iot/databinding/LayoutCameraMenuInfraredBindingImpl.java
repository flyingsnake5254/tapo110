package com.tplink.iot.databinding;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import androidx.databinding.adapters.TextViewBindingAdapter;

public class LayoutCameraMenuInfraredBindingImpl
  extends LayoutCameraMenuInfraredBinding
{
  @Nullable
  private static final SparseIntArray p0;
  @Nullable
  private static final ViewDataBinding.IncludedLayouts z;
  @NonNull
  private final LinearLayout p1;
  private long p2 = -1L;
  
  public LayoutCameraMenuInfraredBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 4, z, p0));
  }
  
  private LayoutCameraMenuInfraredBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 3, (TextView)paramArrayOfObject[1], (TextView)paramArrayOfObject[2], (TextView)paramArrayOfObject[3]);
    this.c.setTag(null);
    this.d.setTag(null);
    this.f.setTag(null);
    paramDataBindingComponent = (LinearLayout)paramArrayOfObject[0];
    this.p1 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  private boolean m(ObservableBoolean paramObservableBoolean, int paramInt)
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
  
  private boolean n(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.p2 |= 0x4;
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
        this.p2 |= 0x2;
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
      Object localObject1 = this.q;
      Object localObject3 = this.x;
      Object localObject4 = this.y;
      int i = 0;
      boolean bool1 = false;
      boolean bool2 = (l1 & 0x9) < 0L;
      boolean bool3;
      long l2;
      int j;
      if (bool2)
      {
        if (localObject1 != null) {
          bool3 = ((ObservableBoolean)localObject1).get();
        } else {
          bool3 = false;
        }
        l2 = l1;
        if (bool2)
        {
          if (bool3)
          {
            l1 |= 0x20;
            l2 = 8192L;
          }
          else
          {
            l1 |= 0x10;
            l2 = 4096L;
          }
          l2 = l1 | l2;
        }
        localObject1 = this.c.getContext();
        if (bool3) {
          j = 2131231346;
        } else {
          j = 2131231345;
        }
        localObject1 = AppCompatResources.getDrawable((Context)localObject1, j);
        if (bool3) {
          j = ViewDataBinding.getColorFromResource(this.c, 2131099706);
        } else {
          j = ViewDataBinding.getColorFromResource(this.c, 2131100206);
        }
      }
      else
      {
        j = 0;
        localObject1 = null;
        l2 = l1;
      }
      boolean bool4 = (l2 & 0xA) < 0L;
      int n;
      if (bool4)
      {
        if (localObject3 != null) {
          bool3 = ((ObservableBoolean)localObject3).get();
        } else {
          bool3 = false;
        }
        l1 = l2;
        if (bool4)
        {
          if (bool3)
          {
            l1 = l2 | 0x800;
            l2 = 32768L;
          }
          else
          {
            l1 = l2 | 0x400;
            l2 = 16384L;
          }
          l1 |= l2;
        }
        localObject3 = this.f;
        int k;
        if (bool3) {
          k = ViewDataBinding.getColorFromResource((View)localObject3, 2131099706);
        } else {
          k = ViewDataBinding.getColorFromResource((View)localObject3, 2131100206);
        }
        if (bool3)
        {
          localObject3 = this.f.getContext();
          n = 2131231352;
        }
        else
        {
          localObject3 = this.f.getContext();
          n = 2131231351;
        }
        localObject3 = AppCompatResources.getDrawable((Context)localObject3, n);
        l2 = l1;
        n = k;
      }
      else
      {
        localObject3 = null;
        n = 0;
      }
      boolean bool5 = (l2 & 0xC) < 0L;
      int m;
      if (bool5)
      {
        bool3 = bool1;
        if (localObject4 != null) {
          bool3 = ((ObservableBoolean)localObject4).get();
        }
        l1 = l2;
        if (bool5)
        {
          if (bool3)
          {
            l2 |= 0x80;
            l1 = 512L;
          }
          else
          {
            l2 |= 0x40;
            l1 = 256L;
          }
          l1 = l2 | l1;
        }
        localObject4 = this.d.getContext();
        if (bool3) {
          m = 2131231350;
        } else {
          m = 2131231349;
        }
        localObject4 = AppCompatResources.getDrawable((Context)localObject4, m);
        TextView localTextView = this.d;
        if (bool3) {
          m = ViewDataBinding.getColorFromResource(localTextView, 2131099706);
        } else {
          m = ViewDataBinding.getColorFromResource(localTextView, 2131100206);
        }
        l2 = l1;
      }
      else
      {
        localObject4 = null;
        m = i;
      }
      if ((l2 & 0x9) != 0L)
      {
        TextViewBindingAdapter.setDrawableStart(this.c, (Drawable)localObject1);
        this.c.setTextColor(j);
      }
      if ((l2 & 0xC) != 0L)
      {
        TextViewBindingAdapter.setDrawableStart(this.d, (Drawable)localObject4);
        this.d.setTextColor(m);
      }
      if ((l2 & 0xA) != 0L)
      {
        TextViewBindingAdapter.setDrawableStart(this.f, (Drawable)localObject3);
        this.f.setTextColor(n);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable ObservableBoolean paramObservableBoolean)
  {
    updateRegistration(0, paramObservableBoolean);
    this.q = paramObservableBoolean;
    try
    {
      this.p2 |= 1L;
      notifyPropertyChanged(32);
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
  
  public void i(@Nullable ObservableBoolean paramObservableBoolean)
  {
    updateRegistration(2, paramObservableBoolean);
    this.y = paramObservableBoolean;
    try
    {
      this.p2 |= 0x4;
      notifyPropertyChanged(35);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void invalidateAll()
  {
    try
    {
      this.p2 = 8L;
      requestRebind();
      return;
    }
    finally {}
  }
  
  public void l(@Nullable ObservableBoolean paramObservableBoolean)
  {
    updateRegistration(1, paramObservableBoolean);
    this.x = paramObservableBoolean;
    try
    {
      this.p2 |= 0x2;
      notifyPropertyChanged(47);
      super.requestRebind();
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
        if (paramInt1 != 2) {
          return false;
        }
        return n((ObservableBoolean)paramObject, paramInt2);
      }
      return o((ObservableBoolean)paramObject, paramInt2);
    }
    return m((ObservableBoolean)paramObject, paramInt2);
  }
  
  public boolean setVariable(int paramInt, @Nullable Object paramObject)
  {
    if (32 == paramInt)
    {
      h((ObservableBoolean)paramObject);
    }
    else if (47 == paramInt)
    {
      l((ObservableBoolean)paramObject);
    }
    else
    {
      if (35 != paramInt) {
        break label53;
      }
      i((ObservableBoolean)paramObject);
    }
    boolean bool = true;
    return bool;
    label53:
    bool = false;
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\LayoutCameraMenuInfraredBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */