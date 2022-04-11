package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import com.tplink.iot.view.ipcamera.widget.calendar.WeekdayView;
import com.tplink.iot.view.ipcamera.widget.calendar.c;
import com.tplink.iot.view.ipcamera.widget.calendar.d;
import com.tplink.iot.view.ipcamera.widget.calendar.scrollCalendar.ScrollCalendar;
import com.tplink.iot.viewmodel.ipcamera.play.PlayBackControlViewModel;
import java.util.Calendar;
import java.util.List;

public class PlayBackDateSelectorBindingImpl
  extends PlayBackDateSelectorBinding
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts y;
  @Nullable
  private static final SparseIntArray z;
  @NonNull
  private final ScrollView p0;
  private long p1 = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    z = localSparseIntArray;
    localSparseIntArray.put(2131364858, 2);
  }
  
  public PlayBackDateSelectorBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 3, y, z));
  }
  
  private PlayBackDateSelectorBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 5, (ScrollCalendar)paramArrayOfObject[1], (WeekdayView)paramArrayOfObject[2]);
    paramDataBindingComponent = (ScrollView)paramArrayOfObject[0];
    this.p0 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    this.c.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  private boolean m(ObservableField<d> paramObservableField, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.p1 |= 0x2;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean n(ObservableField<Calendar> paramObservableField, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.p1 |= 0x4;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean o(ObservableField<List<d>> paramObservableField, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.p1 |= 0x8;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean p(ObservableField<d> paramObservableField, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.p1 |= 0x10;
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
        this.p1 |= 1L;
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
      long l = this.p1;
      this.p1 = 0L;
      c localc = this.x;
      Object localObject1 = this.q;
      com.tplink.iot.view.ipcamera.widget.calendar.b localb = this.f;
      Object localObject2 = null;
      Object localObject3;
      label101:
      Object localObject5;
      label158:
      Object localObject6;
      label215:
      Object localObject7;
      label272:
      Object localObject8;
      if ((0x15F & l) != 0L)
      {
        if ((l & 0x141) != 0L)
        {
          if (localObject1 != null) {
            localObject3 = ((PlayBackControlViewModel)localObject1).i4;
          } else {
            localObject3 = null;
          }
          updateRegistration(0, (Observable)localObject3);
          if (localObject3 != null)
          {
            localObject3 = (d)((ObservableField)localObject3).get();
            break label101;
          }
        }
        localObject3 = null;
        if ((l & 0x142) != 0L)
        {
          if (localObject1 != null) {
            localObject5 = ((PlayBackControlViewModel)localObject1).e4;
          } else {
            localObject5 = null;
          }
          updateRegistration(1, (Observable)localObject5);
          if (localObject5 != null)
          {
            localObject5 = (d)((ObservableField)localObject5).get();
            break label158;
          }
        }
        localObject5 = null;
        if ((l & 0x144) != 0L)
        {
          if (localObject1 != null) {
            localObject6 = ((PlayBackControlViewModel)localObject1).h4;
          } else {
            localObject6 = null;
          }
          updateRegistration(2, (Observable)localObject6);
          if (localObject6 != null)
          {
            localObject6 = (Calendar)((ObservableField)localObject6).get();
            break label215;
          }
        }
        localObject6 = null;
        if ((l & 0x148) != 0L)
        {
          if (localObject1 != null) {
            localObject7 = ((PlayBackControlViewModel)localObject1).f4;
          } else {
            localObject7 = null;
          }
          updateRegistration(3, (Observable)localObject7);
          if (localObject7 != null)
          {
            localObject7 = (List)((ObservableField)localObject7).get();
            break label272;
          }
        }
        localObject7 = null;
        localObject8 = localObject2;
        if ((l & 0x150) != 0L)
        {
          if (localObject1 != null) {
            localObject1 = ((PlayBackControlViewModel)localObject1).g4;
          } else {
            localObject1 = null;
          }
          updateRegistration(4, (Observable)localObject1);
          localObject8 = localObject2;
          if (localObject1 != null) {
            localObject8 = (d)((ObservableField)localObject1).get();
          }
        }
      }
      else
      {
        localObject8 = null;
        localObject3 = localObject8;
        localObject5 = localObject3;
        localObject6 = localObject5;
        localObject7 = localObject6;
      }
      if ((0x180 & l) != 0L) {
        com.tplink.iot.view.ipcamera.base.b.f(this.c, localb);
      }
      if ((0x120 & l) != 0L) {
        com.tplink.iot.view.ipcamera.base.b.l(this.c, localc);
      }
      if ((l & 0x142) != 0L) {
        com.tplink.iot.view.ipcamera.base.b.g(this.c, (d)localObject5);
      }
      if ((l & 0x148) != 0L) {
        com.tplink.iot.view.ipcamera.base.b.i(this.c, (List)localObject7);
      }
      if ((0x150 & l) != 0L) {
        com.tplink.iot.view.ipcamera.base.b.j(this.c, (d)localObject8);
      }
      if ((l & 0x141) != 0L) {
        com.tplink.iot.view.ipcamera.base.b.k(this.c, (d)localObject3);
      }
      if ((l & 0x144) != 0L) {
        com.tplink.iot.view.ipcamera.base.b.h(this.c, (Calendar)localObject6);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable com.tplink.iot.view.ipcamera.widget.calendar.b paramb)
  {
    this.f = paramb;
    try
    {
      this.p1 |= 0x80;
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
      return this.p1 != 0L;
    }
    finally {}
  }
  
  public void i(@Nullable c paramc)
  {
    this.x = paramc;
    try
    {
      this.p1 |= 0x20;
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
      this.p1 = 256L;
      requestRebind();
      return;
    }
    finally {}
  }
  
  public void l(@Nullable PlayBackControlViewModel paramPlayBackControlViewModel)
  {
    this.q = paramPlayBackControlViewModel;
    try
    {
      this.p1 |= 0x40;
      notifyPropertyChanged(75);
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
          if (paramInt1 != 3)
          {
            if (paramInt1 != 4) {
              return false;
            }
            return p((ObservableField)paramObject, paramInt2);
          }
          return o((ObservableField)paramObject, paramInt2);
        }
        return n((ObservableField)paramObject, paramInt2);
      }
      return m((ObservableField)paramObject, paramInt2);
    }
    return q((ObservableField)paramObject, paramInt2);
  }
  
  public boolean setVariable(int paramInt, @Nullable Object paramObject)
  {
    if (64 == paramInt)
    {
      i((c)paramObject);
    }
    else if (75 == paramInt)
    {
      l((PlayBackControlViewModel)paramObject);
    }
    else
    {
      if (63 != paramInt) {
        break label53;
      }
      h((com.tplink.iot.view.ipcamera.widget.calendar.b)paramObject);
    }
    boolean bool = true;
    return bool;
    label53:
    bool = false;
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\PlayBackDateSelectorBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */