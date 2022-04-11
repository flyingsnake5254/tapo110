package com.tplink.iot.databinding;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.Observable;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import androidx.databinding.adapters.ImageViewBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.databinding.adapters.ViewBindingAdapter;
import com.tplink.iot.generated.callback.a;
import com.tplink.iot.generated.callback.a.a;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.view.ipcamera.widget.calendar.WeekdayView;
import com.tplink.iot.view.ipcamera.widget.calendar.c;
import com.tplink.iot.view.ipcamera.widget.calendar.d;
import com.tplink.iot.view.ipcamera.widget.calendar.scrollCalendar.ScrollCalendar;
import com.tplink.iot.viewmodel.ipcamera.play.PlayBackControlViewModel;
import java.util.Calendar;
import java.util.List;

public class LayoutPlayBackFullscreenCalendarBindingImpl
  extends LayoutPlayBackFullscreenCalendarBinding
  implements a.a
{
  @Nullable
  private static final SparseIntArray H3;
  @Nullable
  private static final ViewDataBinding.IncludedLayouts p3;
  @NonNull
  private final LinearLayout I3;
  @Nullable
  private final View.OnClickListener J3;
  @Nullable
  private final View.OnClickListener K3;
  @Nullable
  private final View.OnClickListener L3;
  private long M3 = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    H3 = localSparseIntArray;
    localSparseIntArray.put(2131364858, 6);
  }
  
  public LayoutPlayBackFullscreenCalendarBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 7, p3, H3));
  }
  
  private LayoutPlayBackFullscreenCalendarBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 8, (TextView)paramArrayOfObject[1], (ImageView)paramArrayOfObject[2], (ImageView)paramArrayOfObject[3], (TextView)paramArrayOfObject[4], (ScrollCalendar)paramArrayOfObject[5], (WeekdayView)paramArrayOfObject[6]);
    this.c.setTag(null);
    this.d.setTag(null);
    this.f.setTag(null);
    this.q.setTag(null);
    paramDataBindingComponent = (LinearLayout)paramArrayOfObject[0];
    this.I3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    this.x.setTag(null);
    setRootTag(paramView);
    this.J3 = new a(this, 2);
    this.K3 = new a(this, 3);
    this.L3 = new a(this, 1);
    invalidateAll();
  }
  
  private boolean n(ObservableField<d> paramObservableField, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.M3 |= 0x80;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean o(ObservableField<Calendar> paramObservableField, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.M3 |= 0x10;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean p(ObservableField<List<d>> paramObservableField, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.M3 |= 0x40;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean q(ObservableField<d> paramObservableField, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.M3 |= 0x4;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean r(ObservableField<d> paramObservableField, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.M3 |= 0x20;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean s(ObservableField<String> paramObservableField, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.M3 |= 0x2;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean t(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.M3 |= 0x8;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean u(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.M3 |= 1L;
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
          localg = this.z;
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
        localg = this.z;
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
      localg = this.z;
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
      long l1 = this.M3;
      this.M3 = 0L;
      c localc = this.p2;
      com.tplink.iot.view.ipcamera.widget.calendar.b localb = this.p0;
      Object localObject1 = this.p1;
      Object localObject2;
      boolean bool3;
      Object localObject4;
      label246:
      Object localObject5;
      label303:
      Object localObject6;
      int j;
      label419:
      Object localObject7;
      label477:
      label535:
      Object localObject8;
      if ((0x18FF & l1) != 0L)
      {
        boolean bool1 = (l1 & 0x1801) < 0L;
        if (bool1)
        {
          if (localObject1 != null) {
            localObject2 = ((PlayBackControlViewModel)localObject1).T3;
          } else {
            localObject2 = null;
          }
          updateRegistration(0, (Observable)localObject2);
          if (localObject2 != null) {
            bool3 = ((ObservableBoolean)localObject2).get();
          } else {
            bool3 = false;
          }
          l2 = l1;
          if (bool1)
          {
            if (bool3)
            {
              l2 = l1 | 0x4000;
              l1 = 65536L;
            }
            else
            {
              l2 = l1 | 0x2000;
              l1 = 32768L;
            }
            l2 |= l1;
          }
          localObject2 = this.f.getContext();
          int i;
          if (bool3) {
            i = 2131231288;
          } else {
            i = 2131231289;
          }
          localObject2 = AppCompatResources.getDrawable((Context)localObject2, i);
          l1 = l2;
        }
        else
        {
          bool3 = false;
          localObject2 = null;
        }
        if ((l1 & 0x1802) != 0L)
        {
          if (localObject1 != null) {
            localObject4 = ((PlayBackControlViewModel)localObject1).Q3;
          } else {
            localObject4 = null;
          }
          updateRegistration(1, (Observable)localObject4);
          if (localObject4 != null)
          {
            localObject4 = (String)((ObservableField)localObject4).get();
            break label246;
          }
        }
        localObject4 = null;
        if ((l1 & 0x1804) != 0L)
        {
          if (localObject1 != null) {
            localObject5 = ((PlayBackControlViewModel)localObject1).g4;
          } else {
            localObject5 = null;
          }
          updateRegistration(2, (Observable)localObject5);
          if (localObject5 != null)
          {
            localObject5 = (d)((ObservableField)localObject5).get();
            break label303;
          }
        }
        localObject5 = null;
        boolean bool2 = (l1 & 0x1808) < 0L;
        long l3 = l1;
        if (bool2)
        {
          if (localObject1 != null) {
            localObject6 = ((PlayBackControlViewModel)localObject1).R3;
          } else {
            localObject6 = null;
          }
          updateRegistration(3, (Observable)localObject6);
          boolean bool4;
          if (localObject6 != null) {
            bool4 = ((ObservableBoolean)localObject6).get();
          } else {
            bool4 = false;
          }
          l2 = l1;
          if (bool2)
          {
            if (bool4) {
              l2 = 262144L;
            } else {
              l2 = 131072L;
            }
            l2 = l1 | l2;
          }
          l3 = l2;
          if (bool4)
          {
            j = 8;
            break label419;
          }
        }
        j = 0;
        long l2 = l3;
        if ((l2 & 0x1810) != 0L)
        {
          if (localObject1 != null) {
            localObject6 = ((PlayBackControlViewModel)localObject1).h4;
          } else {
            localObject6 = null;
          }
          updateRegistration(4, (Observable)localObject6);
          if (localObject6 != null)
          {
            localObject7 = (Calendar)((ObservableField)localObject6).get();
            break label477;
          }
        }
        localObject7 = null;
        if ((l2 & 0x1820) != 0L)
        {
          if (localObject1 != null) {
            localObject6 = ((PlayBackControlViewModel)localObject1).i4;
          } else {
            localObject6 = null;
          }
          updateRegistration(5, (Observable)localObject6);
          if (localObject6 != null)
          {
            localObject6 = (d)((ObservableField)localObject6).get();
            break label535;
          }
        }
        localObject6 = null;
        if ((l2 & 0x1840) != 0L)
        {
          if (localObject1 != null) {
            localObject8 = ((PlayBackControlViewModel)localObject1).f4;
          } else {
            localObject8 = null;
          }
          updateRegistration(6, (Observable)localObject8);
          if (localObject8 != null)
          {
            localObject8 = (List)((ObservableField)localObject8).get();
            break label594;
          }
        }
        localObject8 = null;
        label594:
        if ((l2 & 0x1880) != 0L)
        {
          if (localObject1 != null) {
            localObject1 = ((PlayBackControlViewModel)localObject1).e4;
          } else {
            localObject1 = null;
          }
          updateRegistration(7, (Observable)localObject1);
          if (localObject1 != null)
          {
            localObject1 = (d)((ObservableField)localObject1).get();
            break label653;
          }
        }
        localObject1 = null;
        label653:
        Object localObject9 = localObject4;
        l1 = l2;
        localObject4 = localObject7;
        localObject7 = localObject2;
        localObject2 = localObject9;
      }
      else
      {
        localObject8 = null;
        localObject1 = null;
        localObject4 = null;
        localObject7 = null;
        localObject5 = null;
        j = 0;
        bool3 = false;
        localObject2 = null;
        localObject6 = null;
      }
      if ((l1 & 0x1802) != 0L) {
        TextViewBindingAdapter.setText(this.c, (CharSequence)localObject2);
      }
      if ((l1 & 0x1000) != 0L)
      {
        this.d.setOnClickListener(this.L3);
        this.q.setOnClickListener(this.K3);
      }
      if ((l1 & 0x1801) != 0L)
      {
        ImageViewBindingAdapter.setImageDrawable(this.f, (Drawable)localObject7);
        ViewBindingAdapter.setOnClick(this.f, this.J3, bool3);
      }
      if ((l1 & 0x1808) != 0L) {
        this.q.setVisibility(j);
      }
      if ((0x1400 & l1) != 0L) {
        com.tplink.iot.view.ipcamera.base.b.f(this.x, localb);
      }
      if ((0x1100 & l1) != 0L) {
        com.tplink.iot.view.ipcamera.base.b.l(this.x, localc);
      }
      if ((0x1880 & l1) != 0L) {
        com.tplink.iot.view.ipcamera.base.b.g(this.x, (d)localObject1);
      }
      if ((0x1840 & l1) != 0L) {
        com.tplink.iot.view.ipcamera.base.b.i(this.x, (List)localObject8);
      }
      if ((l1 & 0x1804) != 0L) {
        com.tplink.iot.view.ipcamera.base.b.j(this.x, (d)localObject5);
      }
      if ((0x1820 & l1) != 0L) {
        com.tplink.iot.view.ipcamera.base.b.k(this.x, (d)localObject6);
      }
      if ((l1 & 0x1810) != 0L) {
        com.tplink.iot.view.ipcamera.base.b.h(this.x, (Calendar)localObject4);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable com.tplink.iot.view.ipcamera.widget.calendar.b paramb)
  {
    this.p0 = paramb;
    try
    {
      this.M3 |= 0x400;
      notifyPropertyChanged(63);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public boolean hasPendingBindings()
  {
    try
    {
      return this.M3 != 0L;
    }
    finally {}
  }
  
  public void i(@Nullable c paramc)
  {
    this.p2 = paramc;
    try
    {
      this.M3 |= 0x100;
      notifyPropertyChanged(64);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void invalidateAll()
  {
    try
    {
      this.M3 = 4096L;
      requestRebind();
      return;
    }
    finally {}
  }
  
  public void l(@Nullable g paramg)
  {
    this.z = paramg;
    try
    {
      this.M3 |= 0x200;
      notifyPropertyChanged(79);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void m(@Nullable PlayBackControlViewModel paramPlayBackControlViewModel)
  {
    this.p1 = paramPlayBackControlViewModel;
    try
    {
      this.M3 |= 0x800;
      notifyPropertyChanged(105);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  protected boolean onFieldChange(int paramInt1, Object paramObject, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return false;
    case 7: 
      return n((ObservableField)paramObject, paramInt2);
    case 6: 
      return p((ObservableField)paramObject, paramInt2);
    case 5: 
      return r((ObservableField)paramObject, paramInt2);
    case 4: 
      return o((ObservableField)paramObject, paramInt2);
    case 3: 
      return t((ObservableBoolean)paramObject, paramInt2);
    case 2: 
      return q((ObservableField)paramObject, paramInt2);
    case 1: 
      return s((ObservableField)paramObject, paramInt2);
    }
    return u((ObservableBoolean)paramObject, paramInt2);
  }
  
  public boolean setVariable(int paramInt, @Nullable Object paramObject)
  {
    if (64 == paramInt)
    {
      i((c)paramObject);
    }
    else if (79 == paramInt)
    {
      l((g)paramObject);
    }
    else if (63 == paramInt)
    {
      h((com.tplink.iot.view.ipcamera.widget.calendar.b)paramObject);
    }
    else
    {
      if (105 != paramInt) {
        break label70;
      }
      m((PlayBackControlViewModel)paramObject);
    }
    boolean bool = true;
    return bool;
    label70:
    bool = false;
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\LayoutPlayBackFullscreenCalendarBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */