package com.tplink.iot.databinding;

import android.util.Pair;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.Observable;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableFloat;
import androidx.databinding.ObservableInt;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.tplink.iot.view.ipcamera.base.b;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.view.ipcamera.widget.timeaxis.TimeAxisLayout;
import com.tplink.iot.view.ipcamera.widget.timeaxis.TimeAxisLayout.b;
import com.tplink.iot.viewmodel.ipcamera.play.PlayBackControlViewModel;
import java.util.ArrayList;
import java.util.List;

public class PlayBackTimeRulerBindingImpl
  extends PlayBackTimeRulerBinding
{
  @Nullable
  private static final SparseIntArray p0;
  @Nullable
  private static final ViewDataBinding.IncludedLayouts z;
  @NonNull
  private final RelativeLayout p1;
  @NonNull
  private final TextView p2;
  private long p3 = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    p0 = localSparseIntArray;
    localSparseIntArray.put(2131363653, 4);
  }
  
  public PlayBackTimeRulerBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 5, z, p0));
  }
  
  private PlayBackTimeRulerBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 9, (ImageView)paramArrayOfObject[4], (TextView)paramArrayOfObject[2], (TimeAxisLayout)paramArrayOfObject[1]);
    paramDataBindingComponent = (RelativeLayout)paramArrayOfObject[0];
    this.p1 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (TextView)paramArrayOfObject[3];
    this.p2 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    this.d.setTag(null);
    this.f.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  private boolean m(ObservableField<String> paramObservableField, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.p3 |= 0x100;
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
        this.p3 |= 0x8;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean o(ObservableInt paramObservableInt, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.p3 |= 1L;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean p(ObservableField<List<ArrayList<int[]>>> paramObservableField, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.p3 |= 0x2;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean q(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.p3 |= 0x4;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean r(ObservableInt paramObservableInt, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.p3 |= 0x20;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean s(ObservableInt paramObservableInt, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.p3 |= 0x10;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean t(ObservableField<Pair<ArrayList<int[]>, ArrayList<int[]>>> paramObservableField, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.p3 |= 0x80;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean u(ObservableFloat paramObservableFloat, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.p3 |= 0x40;
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
      long l1 = this.p3;
      this.p3 = 0L;
      TimeAxisLayout.b localb = this.y;
      PlayBackControlViewModel localPlayBackControlViewModel = this.q;
      Object localObject1;
      int i;
      label89:
      label146:
      Object localObject3;
      boolean bool1;
      long l2;
      Object localObject4;
      int j;
      int k;
      label359:
      float f;
      label415:
      label474:
      int n;
      ObservableBoolean localObservableBoolean;
      if ((0x19FF & l1) != 0L)
      {
        if ((l1 & 0x1801) != 0L)
        {
          if (localPlayBackControlViewModel != null) {
            localObject1 = localPlayBackControlViewModel.k4;
          } else {
            localObject1 = null;
          }
          updateRegistration(0, (Observable)localObject1);
          if (localObject1 != null)
          {
            i = ((ObservableInt)localObject1).get();
            break label89;
          }
        }
        i = 0;
        if ((l1 & 0x1802) != 0L)
        {
          if (localPlayBackControlViewModel != null) {
            localObject1 = localPlayBackControlViewModel.m4;
          } else {
            localObject1 = null;
          }
          updateRegistration(1, (Observable)localObject1);
          if (localObject1 != null)
          {
            localObject1 = (List)((ObservableField)localObject1).get();
            break label146;
          }
        }
        localObject1 = null;
        if ((l1 & 0x183C) != 0L)
        {
          if (localPlayBackControlViewModel != null) {
            localObject3 = localPlayBackControlViewModel.n4;
          } else {
            localObject3 = null;
          }
          updateRegistration(2, (Observable)localObject3);
          if (localObject3 != null) {
            bool1 = ((ObservableBoolean)localObject3).get();
          } else {
            bool1 = false;
          }
          l2 = l1;
          bool2 = bool1;
          if ((l1 & 0x180C) != 0L) {
            if (bool1)
            {
              l2 = l1 | 0x10000;
              bool2 = bool1;
            }
            else
            {
              l2 = l1 | 0x8000;
              bool2 = bool1;
            }
          }
        }
        else
        {
          bool2 = false;
          l2 = l1;
        }
        if ((l2 & 0x1834) != 0L)
        {
          if (localPlayBackControlViewModel != null)
          {
            localObject3 = localPlayBackControlViewModel.p4;
            localObject4 = localPlayBackControlViewModel.o4;
          }
          else
          {
            localObject3 = null;
            localObject4 = localObject3;
          }
          updateRegistration(4, (Observable)localObject3);
          updateRegistration(5, (Observable)localObject4);
          if (localObject3 != null) {
            j = ((ObservableInt)localObject3).get();
          } else {
            j = 0;
          }
          k = j;
          if (localObject4 != null)
          {
            m = ((ObservableInt)localObject4).get();
            break label359;
          }
        }
        else
        {
          k = 0;
        }
        int m = 0;
        j = k;
        if ((l2 & 0x1840) != 0L)
        {
          if (localPlayBackControlViewModel != null) {
            localObject3 = localPlayBackControlViewModel.j4;
          } else {
            localObject3 = null;
          }
          updateRegistration(6, (Observable)localObject3);
          if (localObject3 != null)
          {
            f = ((ObservableFloat)localObject3).get();
            break label415;
          }
        }
        f = 0.0F;
        if ((l2 & 0x1880) != 0L)
        {
          if (localPlayBackControlViewModel != null) {
            localObject3 = localPlayBackControlViewModel.l4;
          } else {
            localObject3 = null;
          }
          updateRegistration(7, (Observable)localObject3);
          if (localObject3 != null)
          {
            localObject3 = (Pair)((ObservableField)localObject3).get();
            break label474;
          }
        }
        localObject3 = null;
        boolean bool4 = (l2 & 0x1900) < 0L;
        if (bool4)
        {
          if (localPlayBackControlViewModel != null) {
            localObject4 = localPlayBackControlViewModel.O3;
          } else {
            localObject4 = null;
          }
          k = 8;
          updateRegistration(8, (Observable)localObject4);
          if (localObject4 != null) {
            localObject4 = (String)((ObservableField)localObject4).get();
          } else {
            localObject4 = null;
          }
          if (localObject4 != null) {
            n = 1;
          } else {
            n = 0;
          }
          l1 = l2;
          if (bool4)
          {
            if (n != 0) {
              l1 = 16384L;
            } else {
              l1 = 8192L;
            }
            l1 = l2 | l1;
          }
          if (n != 0) {
            k = 0;
          }
          l2 = l1;
        }
        else
        {
          localObject4 = null;
          k = 0;
        }
        bool1 = bool2;
        n = j;
        j = m;
      }
      else
      {
        l2 = l1;
        localObservableBoolean = null;
        localObject1 = localObservableBoolean;
        localObject3 = localObject1;
        f = 0.0F;
        i = 0;
        bool1 = false;
        n = 0;
        j = 0;
        k = 0;
        localObject4 = localObject1;
        localObject1 = localObservableBoolean;
      }
      if ((l2 & 0x10000) != 0L)
      {
        if (localPlayBackControlViewModel != null) {
          localObservableBoolean = localPlayBackControlViewModel.q4;
        } else {
          localObservableBoolean = null;
        }
        updateRegistration(3, localObservableBoolean);
        if (localObservableBoolean != null)
        {
          bool2 = localObservableBoolean.get();
          break label714;
        }
      }
      boolean bool2 = false;
      label714:
      boolean bool3 = (l2 & 0x180C) < 0L;
      if ((!bool3) || (!bool1)) {
        bool2 = false;
      }
      if (bool3) {
        b.Q(this.p2, bool2);
      }
      if ((l2 & 0x1900) != 0L)
      {
        TextViewBindingAdapter.setText(this.d, (CharSequence)localObject4);
        this.d.setVisibility(k);
      }
      if ((l2 & 0x1801) != 0L) {
        b.L(this.f, i);
      }
      if ((0x1880 & l2) != 0L) {
        b.O(this.f, (Pair)localObject3);
      }
      if ((l2 & 0x1802) != 0L) {
        b.M(this.f, (List)localObject1);
      }
      if ((0x1400 & l2) != 0L) {
        b.N(this.f, localb);
      }
      if ((0x1840 & l2) != 0L) {
        b.P(this.f, f);
      }
      if ((0x1834 & l2) != 0L) {
        b.t(this.f, Boolean.valueOf(bool1), Integer.valueOf(j), Integer.valueOf(n));
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable g paramg)
  {
    this.x = paramg;
  }
  
  public boolean hasPendingBindings()
  {
    try
    {
      return this.p3 != 0L;
    }
    finally {}
  }
  
  public void i(@Nullable TimeAxisLayout.b paramb)
  {
    this.y = paramb;
    try
    {
      this.p3 |= 0x400;
      notifyPropertyChanged(99);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void invalidateAll()
  {
    try
    {
      this.p3 = 4096L;
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
      this.p3 |= 0x800;
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
    case 8: 
      return m((ObservableField)paramObject, paramInt2);
    case 7: 
      return t((ObservableField)paramObject, paramInt2);
    case 6: 
      return u((ObservableFloat)paramObject, paramInt2);
    case 5: 
      return r((ObservableInt)paramObject, paramInt2);
    case 4: 
      return s((ObservableInt)paramObject, paramInt2);
    case 3: 
      return n((ObservableBoolean)paramObject, paramInt2);
    case 2: 
      return q((ObservableBoolean)paramObject, paramInt2);
    case 1: 
      return p((ObservableField)paramObject, paramInt2);
    }
    return o((ObservableInt)paramObject, paramInt2);
  }
  
  public boolean setVariable(int paramInt, @Nullable Object paramObject)
  {
    if (79 == paramInt)
    {
      h((g)paramObject);
    }
    else if (99 == paramInt)
    {
      i((TimeAxisLayout.b)paramObject);
    }
    else
    {
      if (105 != paramInt) {
        break label53;
      }
      l((PlayBackControlViewModel)paramObject);
    }
    boolean bool = true;
    return bool;
    label53:
    bool = false;
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\PlayBackTimeRulerBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */