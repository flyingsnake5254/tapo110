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
import com.tplink.iot.generated.callback.a;
import com.tplink.iot.generated.callback.a.a;
import com.tplink.iot.view.ipcamera.base.b;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.ipcamera.play.MultiLiveVideoViewModel;
import com.tplink.iot.viewmodel.ipcamera.play.VideoPlayViewModel;

public class LayoutDayNightModeBindingImpl
  extends LayoutDayNightModeBinding
  implements a.a
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts p0;
  @Nullable
  private static final SparseIntArray p1;
  @Nullable
  private final View.OnClickListener H3;
  private long I3 = -1L;
  @Nullable
  private final View.OnClickListener p2;
  @Nullable
  private final View.OnClickListener p3;
  
  public LayoutDayNightModeBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 4, p0, p1));
  }
  
  private LayoutDayNightModeBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 4, (LinearLayout)paramArrayOfObject[0], (TextView)paramArrayOfObject[1], (TextView)paramArrayOfObject[2], (TextView)paramArrayOfObject[3]);
    this.c.setTag(null);
    this.d.setTag(null);
    this.f.setTag(null);
    this.q.setTag(null);
    setRootTag(paramView);
    this.p2 = new a(this, 3);
    this.p3 = new a(this, 1);
    this.H3 = new a(this, 2);
    invalidateAll();
  }
  
  private boolean m(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.I3 |= 0x4;
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
        this.I3 |= 0x2;
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
        this.I3 |= 1L;
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
        this.I3 |= 0x8;
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
    g localg;
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt == 3)
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
  
  protected void executeBindings()
  {
    try
    {
      long l1 = this.I3;
      this.I3 = 0L;
      Object localObject1 = this.z;
      Object localObject2;
      long l2;
      boolean bool3;
      int i;
      Object localObject4;
      int j;
      int m;
      if ((0xCF & l1) != 0L)
      {
        boolean bool1 = (l1 & 0xC1) < 0L;
        boolean bool2;
        if (bool1)
        {
          if (localObject1 != null) {
            localObject2 = ((MultiLiveVideoViewModel)localObject1).Q3;
          } else {
            localObject2 = null;
          }
          updateRegistration(0, (Observable)localObject2);
          if (localObject2 != null) {
            bool2 = ((ObservableBoolean)localObject2).get();
          } else {
            bool2 = false;
          }
          l2 = l1;
          bool3 = bool2;
          if (bool1)
          {
            if (bool2) {
              l2 = 131072L;
            } else {
              l2 = 65536L;
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
        bool1 = (l2 & 0xC2) < 0L;
        if (bool1)
        {
          if (localObject1 != null) {
            localObject2 = ((MultiLiveVideoViewModel)localObject1).P3;
          } else {
            localObject2 = null;
          }
          updateRegistration(1, (Observable)localObject2);
          if (localObject2 != null) {
            bool2 = ((ObservableBoolean)localObject2).get();
          } else {
            bool2 = false;
          }
          l1 = l2;
          if (bool1)
          {
            if (bool2)
            {
              l2 |= 0x2000;
              l1 = 2097152L;
            }
            else
            {
              l2 |= 0x1000;
              l1 = 1048576L;
            }
            l1 = l2 | l1;
          }
          localObject2 = this.f;
          if (bool2) {
            i = ViewDataBinding.getColorFromResource((View)localObject2, 2131099706);
          } else {
            i = ViewDataBinding.getColorFromResource((View)localObject2, 2131100140);
          }
          if (bool2)
          {
            localObject2 = AppCompatResources.getDrawable(this.f.getContext(), 2131231350);
            l2 = l1;
          }
          else
          {
            localObject2 = AppCompatResources.getDrawable(this.f.getContext(), 2131231349);
            l2 = l1;
          }
        }
        else
        {
          localObject2 = null;
          i = 0;
        }
        boolean bool4 = (l2 & 0xC4) < 0L;
        if (bool4)
        {
          if (localObject1 != null) {
            localObject4 = ((MultiLiveVideoViewModel)localObject1).N3;
          } else {
            localObject4 = null;
          }
          updateRegistration(2, (Observable)localObject4);
          if (localObject4 != null) {
            bool2 = ((ObservableBoolean)localObject4).get();
          } else {
            bool2 = false;
          }
          l1 = l2;
          if (bool4)
          {
            if (bool2)
            {
              l1 = l2 | 0x200;
              l2 = 32768L;
            }
            else
            {
              l1 = l2 | 0x100;
              l2 = 16384L;
            }
            l1 |= l2;
          }
          localObject4 = this.d;
          if (bool2) {
            j = ViewDataBinding.getColorFromResource((View)localObject4, 2131099706);
          } else {
            j = ViewDataBinding.getColorFromResource((View)localObject4, 2131100140);
          }
          int k;
          if (bool2)
          {
            localObject4 = this.d.getContext();
            k = 2131231346;
          }
          else
          {
            localObject4 = this.d.getContext();
            k = 2131231345;
          }
          localObject4 = AppCompatResources.getDrawable((Context)localObject4, k);
          l2 = l1;
        }
        else
        {
          j = 0;
          localObject4 = null;
        }
        boolean bool5 = (l2 & 0xC8) < 0L;
        if (bool5)
        {
          if (localObject1 != null) {
            localObject1 = ((MultiLiveVideoViewModel)localObject1).O3;
          } else {
            localObject1 = null;
          }
          updateRegistration(3, (Observable)localObject1);
          if (localObject1 != null) {
            bool2 = ((ObservableBoolean)localObject1).get();
          } else {
            bool2 = false;
          }
          l1 = l2;
          if (bool5)
          {
            if (bool2)
            {
              l2 |= 0x800;
              l1 = 524288L;
            }
            else
            {
              l2 |= 0x400;
              l1 = 262144L;
            }
            l1 = l2 | l1;
          }
          localObject1 = this.q;
          if (bool2) {
            m = ViewDataBinding.getColorFromResource((View)localObject1, 2131099706);
          } else {
            m = ViewDataBinding.getColorFromResource((View)localObject1, 2131100140);
          }
          int n;
          if (bool2)
          {
            localObject1 = this.q.getContext();
            n = 2131231352;
          }
          else
          {
            localObject1 = this.q.getContext();
            n = 2131231351;
          }
          localObject1 = AppCompatResources.getDrawable((Context)localObject1, n);
          l2 = l1;
        }
        else
        {
          localObject1 = null;
          m = 0;
        }
      }
      else
      {
        localObject1 = null;
        m = 0;
        localObject2 = null;
        bool3 = false;
        j = 0;
        i = 0;
        localObject4 = null;
        l2 = l1;
      }
      if ((l2 & 0xC1) != 0L) {
        b.a(this.c, bool3, null);
      }
      if ((0xC4 & l2) != 0L)
      {
        TextViewBindingAdapter.setDrawableStart(this.d, (Drawable)localObject4);
        this.d.setTextColor(j);
      }
      if ((0x80 & l2) != 0L)
      {
        this.d.setOnClickListener(this.p3);
        this.f.setOnClickListener(this.H3);
        this.q.setOnClickListener(this.p2);
      }
      if ((0xC2 & l2) != 0L)
      {
        TextViewBindingAdapter.setDrawableStart(this.f, (Drawable)localObject2);
        this.f.setTextColor(i);
      }
      if ((l2 & 0xC8) != 0L)
      {
        TextViewBindingAdapter.setDrawableStart(this.q, (Drawable)localObject1);
        this.q.setTextColor(m);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable g paramg)
  {
    this.y = paramg;
    try
    {
      this.I3 |= 0x10;
      notifyPropertyChanged(79);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public boolean hasPendingBindings()
  {
    try
    {
      return this.I3 != 0L;
    }
    finally {}
  }
  
  public void i(@Nullable VideoPlayViewModel paramVideoPlayViewModel)
  {
    this.x = paramVideoPlayViewModel;
  }
  
  public void invalidateAll()
  {
    try
    {
      this.I3 = 128L;
      requestRebind();
      return;
    }
    finally {}
  }
  
  public void l(@Nullable MultiLiveVideoViewModel paramMultiLiveVideoViewModel)
  {
    this.z = paramMultiLiveVideoViewModel;
    try
    {
      this.I3 |= 0x40;
      notifyPropertyChanged(105);
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
        if (paramInt1 != 2)
        {
          if (paramInt1 != 3) {
            return false;
          }
          return p((ObservableBoolean)paramObject, paramInt2);
        }
        return m((ObservableBoolean)paramObject, paramInt2);
      }
      return n((ObservableBoolean)paramObject, paramInt2);
    }
    return o((ObservableBoolean)paramObject, paramInt2);
  }
  
  public boolean setVariable(int paramInt, @Nullable Object paramObject)
  {
    if (79 == paramInt)
    {
      h((g)paramObject);
    }
    else if (100 == paramInt)
    {
      i((VideoPlayViewModel)paramObject);
    }
    else
    {
      if (105 != paramInt) {
        break label53;
      }
      l((MultiLiveVideoViewModel)paramObject);
    }
    boolean bool = true;
    return bool;
    label53:
    bool = false;
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\LayoutDayNightModeBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */