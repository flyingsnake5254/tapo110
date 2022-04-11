package com.tplink.iot.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import androidx.databinding.adapters.ViewBindingAdapter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tplink.iot.adapter.databinding.e;
import com.tplink.iot.generated.callback.a;
import com.tplink.iot.generated.callback.a.a;
import com.tplink.iot.generated.callback.b.a;
import com.tplink.iot.widget.cameralive.VideoSurfaceViewLayout;
import com.tplink.iot.widget.cameralive.y;

public class ItemMultiLiveBindingImpl
  extends ItemMultiLiveBinding
  implements a.a, b.a
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts L3;
  @Nullable
  private static final SparseIntArray M3;
  @NonNull
  private final View N3;
  @NonNull
  private final View O3;
  @Nullable
  private final View.OnClickListener P3;
  @Nullable
  private final View.OnClickListener Q3;
  @Nullable
  private final View.OnClickListener R3;
  @Nullable
  private final View.OnLongClickListener S3;
  @Nullable
  private final View.OnClickListener T3;
  @Nullable
  private final View.OnLongClickListener U3;
  @Nullable
  private final View.OnClickListener V3;
  private long W3 = -1L;
  
  public ItemMultiLiveBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 6, L3, M3));
  }
  
  private ItemMultiLiveBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 6, (RelativeLayout)paramArrayOfObject[2], (RelativeLayout)paramArrayOfObject[3], (FrameLayout)paramArrayOfObject[0], (VideoSurfaceViewLayout)paramArrayOfObject[5]);
    this.c.setTag(null);
    this.d.setTag(null);
    paramDataBindingComponent = (View)paramArrayOfObject[1];
    this.N3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (View)paramArrayOfObject[4];
    this.O3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    this.f.setTag(null);
    this.q.setTag(null);
    setRootTag(paramView);
    this.P3 = new a(this, 2);
    this.Q3 = new a(this, 6);
    this.R3 = new a(this, 3);
    this.S3 = new com.tplink.iot.generated.callback.b(this, 7);
    this.T3 = new a(this, 4);
    this.U3 = new com.tplink.iot.generated.callback.b(this, 5);
    this.V3 = new a(this, 1);
    invalidateAll();
  }
  
  private boolean h(MutableLiveData<Integer> paramMutableLiveData, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.W3 |= 1L;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean i(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.W3 |= 0x10;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean l(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.W3 |= 0x8;
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
        this.W3 |= 0x2;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean n(MutableLiveData<Boolean> paramMutableLiveData, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.W3 |= 0x20;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean o(MutableLiveData<String> paramMutableLiveData, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.W3 |= 0x4;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  public final boolean b(int paramInt, View paramView)
  {
    int i = 1;
    int j = 1;
    boolean bool1 = false;
    boolean bool2 = false;
    if (paramInt != 5)
    {
      if (paramInt != 7) {
        return false;
      }
      localObject1 = this.I3;
      localObject2 = this.y;
      if (localObject1 != null) {
        paramInt = j;
      } else {
        paramInt = 0;
      }
      if (paramInt != 0) {
        bool2 = ((e)localObject1).a(paramView, ViewDataBinding.safeUnbox((Integer)localObject2));
      }
      return bool2;
    }
    Object localObject2 = this.I3;
    Object localObject1 = this.y;
    if (localObject2 != null) {
      paramInt = i;
    } else {
      paramInt = 0;
    }
    bool2 = bool1;
    if (paramInt != 0) {
      bool2 = ((e)localObject2).a(paramView, ViewDataBinding.safeUnbox((Integer)localObject1));
    }
    return bool2;
  }
  
  public final void d(int paramInt, View paramView)
  {
    int i = 0;
    int j = 0;
    int k = 0;
    int m = 0;
    int n = 0;
    Object localObject1;
    Object localObject2;
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            if (paramInt == 6)
            {
              localObject1 = this.H3;
              localObject2 = this.y;
              paramInt = n;
              if (localObject1 != null) {
                paramInt = 1;
              }
              if (paramInt != 0) {
                ((com.tplink.iot.adapter.databinding.d)localObject1).a(paramView, ViewDataBinding.safeUnbox((Integer)localObject2));
              }
            }
          }
          else
          {
            localObject1 = this.H3;
            localObject2 = this.y;
            paramInt = i;
            if (localObject1 != null) {
              paramInt = 1;
            }
            if (paramInt != 0) {
              ((com.tplink.iot.adapter.databinding.d)localObject1).a(paramView, ViewDataBinding.safeUnbox((Integer)localObject2));
            }
          }
        }
        else
        {
          localObject1 = this.H3;
          localObject2 = this.y;
          paramInt = j;
          if (localObject1 != null) {
            paramInt = 1;
          }
          if (paramInt != 0) {
            ((com.tplink.iot.adapter.databinding.d)localObject1).a(paramView, ViewDataBinding.safeUnbox((Integer)localObject2));
          }
        }
      }
      else
      {
        localObject2 = this.H3;
        localObject1 = this.y;
        paramInt = k;
        if (localObject2 != null) {
          paramInt = 1;
        }
        if (paramInt != 0) {
          ((com.tplink.iot.adapter.databinding.d)localObject2).a(paramView, ViewDataBinding.safeUnbox((Integer)localObject1));
        }
      }
    }
    else
    {
      localObject2 = this.H3;
      localObject1 = this.y;
      paramInt = m;
      if (localObject2 != null) {
        paramInt = 1;
      }
      if (paramInt != 0) {
        ((com.tplink.iot.adapter.databinding.d)localObject2).a(paramView, ViewDataBinding.safeUnbox((Integer)localObject1));
      }
    }
  }
  
  protected void executeBindings()
  {
    try
    {
      long l1 = this.W3;
      this.W3 = 0L;
      Object localObject1 = this.z;
      ObservableBoolean localObservableBoolean1 = this.p0;
      MutableLiveData localMutableLiveData1 = this.K3;
      ObservableBoolean localObservableBoolean2 = this.p2;
      Integer localInteger = this.y;
      String str = this.x;
      Object localObject3 = this.p3;
      io.reactivex.m0.d locald = this.J3;
      MutableLiveData localMutableLiveData2 = this.p1;
      float f = 0.0F;
      int i = (l1 & 0x901) < 0L;
      int j;
      boolean bool1;
      long l2;
      boolean bool3;
      boolean bool4;
      if (i != 0)
      {
        if (localObject1 != null) {
          localObject1 = (Integer)((LiveData)localObject1).getValue();
        } else {
          localObject1 = null;
        }
        j = ViewDataBinding.safeUnbox(localInteger);
        int k = ViewDataBinding.safeUnbox((Integer)localObject1);
        bool1 = true;
        if (k == j) {
          bool2 = true;
        } else {
          bool2 = false;
        }
        if (k == j) {
          bool1 = false;
        }
        l2 = l1;
        if (i != 0)
        {
          if (bool2) {
            l2 = 524288L;
          } else {
            l2 = 262144L;
          }
          l2 = l1 | l2;
        }
        if (bool2) {
          f = 1.0F;
        }
        bool3 = bool1;
        bool4 = bool2;
      }
      else
      {
        bool3 = false;
        j = 0;
        f = 0.0F;
        bool4 = false;
        l2 = l1;
      }
      int m = (l2 & 0x802) < 0L;
      int n;
      if (m != 0)
      {
        if (localObservableBoolean1 != null) {
          bool2 = localObservableBoolean1.get();
        } else {
          bool2 = false;
        }
        i = ViewDataBinding.safeUnbox(Boolean.valueOf(bool2));
        l1 = l2;
        if (m != 0) {
          if (i != 0) {
            l1 = l2 | 0x8000;
          } else {
            l1 = l2 | 0x4000;
          }
        }
        n = i;
        l2 = l1;
      }
      else
      {
        n = 0;
        bool2 = false;
        i = 0;
      }
      if (((l2 & 0x804) != 0L) && (localMutableLiveData1 != null)) {
        localObject1 = (String)localMutableLiveData1.getValue();
      } else {
        localObject1 = null;
      }
      boolean bool5;
      if ((l2 & 0x808) != 0L)
      {
        if (localObservableBoolean2 != null) {
          bool1 = localObservableBoolean2.get();
        } else {
          bool1 = false;
        }
        bool5 = ViewDataBinding.safeUnbox(Boolean.valueOf(bool1));
      }
      else
      {
        bool5 = false;
      }
      m = (l2 & 0xA02) < 0L;
      if (m != 0)
      {
        bool6 = TextUtils.isEmpty(str);
        l1 = l2;
        if (m != 0) {
          if (bool6) {
            l1 = l2 | 0x2000 | 0x20000;
          } else {
            l1 = l2 | 0x1000 | 0x10000;
          }
        }
        l2 = l1;
        bool1 = bool6;
        if ((l1 & 0xA00) != 0L)
        {
          bool7 = bool6 ^ true;
          l2 = l1;
          break label478;
        }
      }
      else
      {
        bool1 = false;
      }
      boolean bool7 = false;
      boolean bool6 = bool1;
      label478:
      if ((l2 & 0x810) != 0L)
      {
        if (localObject3 != null) {
          bool1 = ((ObservableBoolean)localObject3).get();
        } else {
          bool1 = false;
        }
        bool1 = ViewDataBinding.safeUnbox(Boolean.valueOf(bool1));
      }
      else
      {
        bool1 = false;
      }
      boolean bool8;
      if ((l2 & 0x820) != 0L)
      {
        if (localMutableLiveData2 != null) {
          localObject3 = (Boolean)localMutableLiveData2.getValue();
        } else {
          localObject3 = null;
        }
        bool8 = ViewDataBinding.safeUnbox((Boolean)localObject3);
      }
      else
      {
        bool8 = false;
      }
      long l3 = l2;
      if ((l2 & 0x22000) != 0L)
      {
        if (localObservableBoolean1 != null) {
          bool2 = localObservableBoolean1.get();
        }
        m = ViewDataBinding.safeUnbox(Boolean.valueOf(bool2));
        l1 = l2;
        if ((l2 & 0x802) != 0L) {
          if (m != 0) {
            l1 = l2 | 0x8000;
          } else {
            l1 = l2 | 0x4000;
          }
        }
        l3 = l1;
        i = m;
        if ((l1 & 0x20000) != 0L)
        {
          bool2 = m ^ 0x1;
          i = m;
          break label677;
        }
      }
      boolean bool2 = false;
      l1 = l3;
      label677:
      boolean bool9 = (l1 & 0xA02) < 0L;
      if (bool9)
      {
        if (bool6) {
          m = i;
        } else {
          m = 0;
        }
        if (!bool6) {
          bool2 = false;
        }
      }
      else
      {
        bool2 = false;
        m = 0;
      }
      if ((l1 & 0x800) != 0L)
      {
        this.c.setOnClickListener(this.P3);
        this.d.setOnClickListener(this.R3);
        this.N3.setOnClickListener(this.V3);
        this.q.setOnLongClickListener(this.S3);
      }
      if (bool9)
      {
        com.tplink.iot.view.ipcamera.base.b.Q(this.c, bool2);
        com.tplink.iot.view.ipcamera.base.b.Q(this.d, m);
      }
      if ((0x901 & l1) != 0L)
      {
        if (ViewDataBinding.getBuildSdkInt() >= 11) {
          this.O3.setAlpha(f);
        }
        ViewBindingAdapter.setOnClick(this.O3, this.T3, bool3);
        y.d(this.q, bool4);
        ViewBindingAdapter.setOnClick(this.q, this.Q3, bool3);
      }
      if ((l1 & 0x802) != 0L)
      {
        com.tplink.iot.view.ipcamera.base.b.Q(this.O3, i);
        com.tplink.iot.view.ipcamera.base.b.v(this.q, Integer.valueOf(n));
        com.tplink.iot.view.ipcamera.base.b.b(this.q, null, Boolean.valueOf(i));
      }
      if ((l1 & 0xA00) != 0L)
      {
        ViewBindingAdapter.setOnLongClick(this.O3, this.U3, bool7);
        y.a(this.q, str);
        com.tplink.iot.view.ipcamera.base.b.Q(this.q, bool7);
      }
      if ((l1 & 0x810) != 0L) {
        y.b(this.q, bool1);
      }
      if ((l1 & 0x808) != 0L) {
        y.c(this.q, bool5);
      }
      if ((0x900 & l1) != 0L) {
        this.q.setItemPosition(j);
      }
      if ((l1 & 0x820) != 0L) {
        y.e(this.q, bool8);
      }
      if ((0xC00 & l1) != 0L) {
        y.f(this.q, locald);
      }
      if ((l1 & 0x804) != 0L) {
        y.g(this.q, (String)localObject1);
      }
      return;
    }
    finally {}
  }
  
  public boolean hasPendingBindings()
  {
    try
    {
      return this.W3 != 0L;
    }
    finally {}
  }
  
  public void invalidateAll()
  {
    try
    {
      this.W3 = 2048L;
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
            if (paramInt1 != 4)
            {
              if (paramInt1 != 5) {
                return false;
              }
              return n((MutableLiveData)paramObject, paramInt2);
            }
            return i((ObservableBoolean)paramObject, paramInt2);
          }
          return l((ObservableBoolean)paramObject, paramInt2);
        }
        return o((MutableLiveData)paramObject, paramInt2);
      }
      return m((ObservableBoolean)paramObject, paramInt2);
    }
    return h((MutableLiveData)paramObject, paramInt2);
  }
  
  public void p(@Nullable com.tplink.iot.adapter.databinding.d paramd)
  {
    this.H3 = paramd;
    try
    {
      this.W3 |= 0x40;
      notifyPropertyChanged(9);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void q(@Nullable MutableLiveData<Integer> paramMutableLiveData)
  {
    updateLiveDataRegistration(0, paramMutableLiveData);
    this.z = paramMutableLiveData;
    try
    {
      this.W3 |= 1L;
      notifyPropertyChanged(13);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void r(@Nullable String paramString)
  {
    this.x = paramString;
    try
    {
      this.W3 |= 0x200;
      notifyPropertyChanged(16);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void s(@Nullable ObservableBoolean paramObservableBoolean)
  {
    updateRegistration(4, paramObservableBoolean);
    this.p3 = paramObservableBoolean;
    try
    {
      this.W3 |= 0x10;
      notifyPropertyChanged(25);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public boolean setVariable(int paramInt, @Nullable Object paramObject)
  {
    if (13 == paramInt)
    {
      q((MutableLiveData)paramObject);
    }
    else if (46 == paramInt)
    {
      u((ObservableBoolean)paramObject);
    }
    else if (9 == paramInt)
    {
      p((com.tplink.iot.adapter.databinding.d)paramObject);
    }
    else if (101 == paramInt)
    {
      z((MutableLiveData)paramObject);
    }
    else if (39 == paramInt)
    {
      t((ObservableBoolean)paramObject);
    }
    else if (59 == paramInt)
    {
      v((e)paramObject);
    }
    else if (76 == paramInt)
    {
      w((Integer)paramObject);
    }
    else if (16 == paramInt)
    {
      r((String)paramObject);
    }
    else if (25 == paramInt)
    {
      s((ObservableBoolean)paramObject);
    }
    else if (86 == paramInt)
    {
      y((io.reactivex.m0.d)paramObject);
    }
    else
    {
      if (83 != paramInt) {
        break label189;
      }
      x((MutableLiveData)paramObject);
    }
    boolean bool = true;
    return bool;
    label189:
    bool = false;
    return bool;
  }
  
  public void t(@Nullable ObservableBoolean paramObservableBoolean)
  {
    updateRegistration(3, paramObservableBoolean);
    this.p2 = paramObservableBoolean;
    try
    {
      this.W3 |= 0x8;
      notifyPropertyChanged(39);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void u(@Nullable ObservableBoolean paramObservableBoolean)
  {
    updateRegistration(1, paramObservableBoolean);
    this.p0 = paramObservableBoolean;
    try
    {
      this.W3 |= 0x2;
      notifyPropertyChanged(46);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void v(@Nullable e parame)
  {
    this.I3 = parame;
    try
    {
      this.W3 |= 0x80;
      notifyPropertyChanged(59);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void w(@Nullable Integer paramInteger)
  {
    this.y = paramInteger;
    try
    {
      this.W3 |= 0x100;
      notifyPropertyChanged(76);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void x(@Nullable MutableLiveData<Boolean> paramMutableLiveData)
  {
    updateLiveDataRegistration(5, paramMutableLiveData);
    this.p1 = paramMutableLiveData;
    try
    {
      this.W3 |= 0x20;
      notifyPropertyChanged(83);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void y(@Nullable io.reactivex.m0.d<Integer> paramd)
  {
    this.J3 = paramd;
    try
    {
      this.W3 |= 0x400;
      notifyPropertyChanged(86);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void z(@Nullable MutableLiveData<String> paramMutableLiveData)
  {
    updateLiveDataRegistration(2, paramMutableLiveData);
    this.K3 = paramMutableLiveData;
    try
    {
      this.W3 |= 0x4;
      notifyPropertyChanged(101);
      super.requestRebind();
      return;
    }
    finally {}
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ItemMultiLiveBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */