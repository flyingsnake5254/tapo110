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
import androidx.databinding.adapters.Converters;
import androidx.databinding.adapters.ImageViewBindingAdapter;
import androidx.databinding.adapters.ViewBindingAdapter;
import com.tplink.iot.generated.callback.a;
import com.tplink.iot.generated.callback.a.a;
import com.tplink.iot.view.ipcamera.base.b;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.ipcamera.play.MultiLiveVideoViewModel;
import com.tplink.iot.viewmodel.ipcamera.play.TalkViewModel;
import com.tplink.iot.viewmodel.ipcamera.play.VideoPlayViewModel;
import com.tplink.iot.widget.FullScreenControlShowView;

public class LayoutFullScreenControlBindingImpl
  extends LayoutFullScreenControlBinding
  implements a.a
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts p2;
  @Nullable
  private static final SparseIntArray p3;
  @NonNull
  private final FullScreenControlShowView H3;
  @Nullable
  private final View.OnClickListener I3;
  @Nullable
  private final View.OnClickListener J3;
  @Nullable
  private final View.OnClickListener K3;
  @Nullable
  private final View.OnClickListener L3;
  @Nullable
  private final View.OnClickListener M3;
  private long N3 = -1L;
  
  public LayoutFullScreenControlBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 6, p2, p3));
  }
  
  private LayoutFullScreenControlBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 7, (ImageView)paramArrayOfObject[3], (ImageView)paramArrayOfObject[1], (ImageView)paramArrayOfObject[4], (ImageView)paramArrayOfObject[2], (ImageView)paramArrayOfObject[5]);
    this.c.setTag(null);
    this.d.setTag(null);
    this.f.setTag(null);
    this.q.setTag(null);
    this.x.setTag(null);
    paramDataBindingComponent = (FullScreenControlShowView)paramArrayOfObject[0];
    this.H3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    setRootTag(paramView);
    this.I3 = new a(this, 3);
    this.J3 = new a(this, 4);
    this.K3 = new a(this, 5);
    this.L3 = new a(this, 1);
    this.M3 = new a(this, 2);
    invalidateAll();
  }
  
  private boolean n(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.N3 |= 0x8;
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
        this.N3 |= 0x2;
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
        this.N3 |= 0x40;
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
        this.N3 |= 0x4;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean r(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.N3 |= 1L;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean s(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.N3 |= 0x10;
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
        this.N3 |= 0x20;
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
    int n = 0;
    g localg;
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            if (paramInt == 5)
            {
              localg = this.y;
              paramInt = n;
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
    else
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
  
  protected void executeBindings()
  {
    try
    {
      long l1 = this.N3;
      this.N3 = 0L;
      Object localObject1 = this.p0;
      Object localObject2 = this.z;
      Object localObject3 = this.p1;
      Object localObject4;
      label93:
      boolean bool2;
      boolean bool4;
      if ((0xCF5 & l1) != 0L)
      {
        if ((l1 & 0x881) != 0L)
        {
          if (localObject1 != null) {
            localObject4 = ((VideoPlayViewModel)localObject1).I;
          } else {
            localObject4 = null;
          }
          updateRegistration(0, (Observable)localObject4);
          if (localObject4 != null)
          {
            bool1 = ((ObservableBoolean)localObject4).get();
            break label93;
          }
        }
        bool1 = false;
        bool2 = (l1 & 0xCF4) < 0L;
        bool4 = bool1;
        if (bool2)
        {
          if (localObject1 != null) {
            localObject4 = ((VideoPlayViewModel)localObject1).r;
          } else {
            localObject4 = null;
          }
          updateRegistration(6, (Observable)localObject4);
          if (localObject4 != null) {
            bool4 = ((ObservableBoolean)localObject4).get();
          } else {
            bool4 = false;
          }
          l2 = l1;
          bool5 = bool1;
          bool6 = bool4;
          if (!bool2) {
            break label224;
          }
          if (bool4)
          {
            l2 = l1 | 0x80000;
            bool5 = bool1;
            bool6 = bool4;
            break label224;
          }
          l2 = l1 | 0x40000;
          bool5 = bool1;
          bool6 = bool4;
          break label224;
        }
      }
      else
      {
        bool4 = false;
      }
      boolean bool6 = false;
      boolean bool5 = bool4;
      long l2 = l1;
      label224:
      int k;
      int j;
      if ((l2 & 0xA0A) != 0L)
      {
        bool2 = (l2 & 0xA02) < 0L;
        if (bool2)
        {
          if (localObject2 != null) {
            localObject4 = ((MultiLiveVideoViewModel)localObject2).I3;
          } else {
            localObject4 = null;
          }
          updateRegistration(1, (Observable)localObject4);
          if (localObject4 != null) {
            bool1 = ((ObservableBoolean)localObject4).get();
          } else {
            bool1 = false;
          }
          l1 = l2;
          if (bool2)
          {
            if (bool1)
            {
              l1 = l2 | 0x8000000;
              l2 = 536870912L;
            }
            else
            {
              l1 = l2 | 0x4000000;
              l2 = 268435456L;
            }
            l1 |= l2;
          }
          localObject4 = this.c;
          if (bool1) {
            k = ViewDataBinding.getColorFromResource((View)localObject4, 2131099789);
          } else {
            k = ViewDataBinding.getColorFromResource((View)localObject4, 2131099790);
          }
          int i;
          if (bool1)
          {
            localObject4 = this.c.getContext();
            i = 2131231614;
          }
          else
          {
            localObject4 = this.c.getContext();
            i = 2131231613;
          }
          localObject6 = AppCompatResources.getDrawable((Context)localObject4, i);
          l2 = l1;
        }
        else
        {
          k = 0;
          localObject6 = null;
        }
        boolean bool3 = (l2 & 0xA08) < 0L;
        if (bool3)
        {
          if (localObject2 != null) {
            localObject4 = ((MultiLiveVideoViewModel)localObject2).e4;
          } else {
            localObject4 = null;
          }
          updateRegistration(3, (Observable)localObject4);
          if (localObject4 != null) {
            bool1 = ((ObservableBoolean)localObject4).get();
          } else {
            bool1 = false;
          }
          l1 = l2;
          if (bool3)
          {
            if (bool1)
            {
              l2 |= 0x2000;
              l1 = 137438953472L;
            }
            else
            {
              l2 |= 0x1000;
              l1 = 68719476736L;
            }
            l1 = l2 | l1;
          }
          localObject4 = this.q.getContext();
          if (bool1) {
            j = 2131231632;
          } else {
            j = 2131231631;
          }
          localObject4 = AppCompatResources.getDrawable((Context)localObject4, j);
          if (bool1)
          {
            j = ViewDataBinding.getColorFromResource(this.q, 2131099789);
            l2 = l1;
            localObject2 = localObject6;
          }
          else
          {
            j = ViewDataBinding.getColorFromResource(this.q, 2131099790);
            l2 = l1;
            localObject2 = localObject6;
          }
        }
        else
        {
          j = 0;
          localObject4 = null;
          localObject2 = localObject6;
        }
      }
      else
      {
        j = 0;
        localObject4 = null;
        k = 0;
        localObject2 = null;
      }
      if ((l2 & 0xC30) != 0L)
      {
        if (localObject3 != null) {
          localObject6 = ((TalkViewModel)localObject3).k;
        } else {
          localObject6 = null;
        }
        updateRegistration(4, (Observable)localObject6);
        if (localObject6 != null) {
          bool1 = ((ObservableBoolean)localObject6).get();
        } else {
          bool1 = false;
        }
        l1 = l2;
        if ((l2 & 0x100C30) != 0L) {
          if (bool1) {
            l1 = l2 | 0x8000;
          } else {
            l1 = l2 | 0x4000;
          }
        }
        l2 = l1;
        if ((l1 & 0x10C30) != 0L) {
          if (bool1) {
            l2 = l1 | 0x80000000;
          } else {
            l2 = l1 | 0x40000000;
          }
        }
      }
      else
      {
        localObject6 = null;
        bool1 = false;
      }
      if ((l2 & 0x40000) != 0L)
      {
        if (localObject1 != null) {
          localObject1 = ((VideoPlayViewModel)localObject1).D;
        } else {
          localObject1 = null;
        }
        updateRegistration(2, (Observable)localObject1);
        if (localObject1 != null) {
          bool4 = ((ObservableBoolean)localObject1).get();
        } else {
          bool4 = false;
        }
        bool4 ^= true;
      }
      else
      {
        bool4 = false;
      }
      boolean bool7 = (l2 & 0xCF4) < 0L;
      if (bool7)
      {
        if (bool6) {
          bool4 = true;
        }
        bool6 = bool4;
        l1 = l2;
        if (bool7)
        {
          if (bool4)
          {
            l1 = l2 | 0x20000;
            l2 = 2097152L;
          }
          else
          {
            l1 = l2 | 0x10000;
            l2 = 1048576L;
          }
          l1 |= l2;
          bool6 = bool4;
        }
      }
      else
      {
        bool6 = false;
        l1 = l2;
      }
      l2 = l1;
      boolean bool8 = bool1;
      if ((l1 & 0x110000) != 0L)
      {
        if (localObject3 != null) {
          localObject6 = ((TalkViewModel)localObject3).k;
        }
        updateRegistration(4, (Observable)localObject6);
        if (localObject6 != null) {
          bool1 = ((ObservableBoolean)localObject6).get();
        }
        long l3 = l1;
        if ((l1 & 0x100C30) != 0L) {
          if (bool1) {
            l3 = l1 | 0x8000;
          } else {
            l3 = l1 | 0x4000;
          }
        }
        l2 = l3;
        bool8 = bool1;
        if ((l3 & 0x10C30) != 0L) {
          if (bool1)
          {
            l2 = l3 | 0x80000000;
            bool8 = bool1;
          }
          else
          {
            l2 = l3 | 0x40000000;
            bool8 = bool1;
          }
        }
      }
      if ((0x80008000 & l2) != 0L)
      {
        if (localObject3 != null) {
          localObject6 = ((TalkViewModel)localObject3).m;
        } else {
          localObject6 = null;
        }
        updateRegistration(5, (Observable)localObject6);
        if (localObject6 != null) {
          bool1 = ((ObservableBoolean)localObject6).get();
        } else {
          bool1 = false;
        }
        bool4 = bool1;
        if ((l2 & 0x8000) != 0L)
        {
          boolean bool9 = bool1 ^ true;
          bool4 = bool1;
          bool1 = bool9;
          break label1144;
        }
      }
      else
      {
        bool4 = false;
      }
      boolean bool1 = false;
      label1144:
      if ((l2 & 0x100C30) != 0L)
      {
        if (!bool8) {
          bool1 = false;
        }
        l1 = l2;
        if ((l2 & 0xC30) != 0L)
        {
          if (bool1)
          {
            l2 |= 0x800000;
            l1 = 34359738368L;
          }
          else
          {
            l2 |= 0x400000;
            l1 = 17179869184L;
          }
          l1 = l2 | l1;
        }
        if ((l1 & 0xC30) != 0L)
        {
          localObject6 = this.f;
          if (bool1) {
            m = 2131099789;
          } else {
            m = 2131099790;
          }
          m = ViewDataBinding.getColorFromResource((View)localObject6, m);
          if (bool1)
          {
            localObject6 = AppCompatResources.getDrawable(this.f.getContext(), 2131231620);
            break label1317;
          }
          localObject6 = AppCompatResources.getDrawable(this.f.getContext(), 2131231619);
          break label1317;
        }
        l2 = l1;
      }
      else
      {
        bool1 = false;
      }
      Object localObject6 = null;
      int m = 0;
      l1 = l2;
      label1317:
      if ((l1 & 0x10C30) != 0L)
      {
        if (!bool8) {
          bool4 = false;
        }
        l2 = l1;
        if ((l1 & 0xC30) != 0L)
        {
          if (bool4)
          {
            l2 = l1 | 0x2000000;
            l1 = 8589934592L;
          }
          else
          {
            l2 = l1 | 0x1000000;
            l1 = 4294967296L;
          }
          l2 |= l1;
        }
        if ((l2 & 0xC30) != 0L)
        {
          if (bool4) {
            localObject1 = AppCompatResources.getDrawable(this.x.getContext(), 2131230828);
          } else {
            localObject1 = AppCompatResources.getDrawable(this.x.getContext(), 2131230827);
          }
          localObject3 = this.x.getContext();
          int n;
          if (bool4) {
            n = 2131231622;
          } else {
            n = 2131231621;
          }
          localObject3 = AppCompatResources.getDrawable((Context)localObject3, n);
        }
        else
        {
          localObject1 = null;
          localObject3 = null;
        }
      }
      else
      {
        localObject1 = null;
        localObject3 = null;
        bool4 = false;
        l2 = l1;
      }
      boolean bool10 = (l2 & 0xCF4) < 0L;
      if (bool10)
      {
        if (bool6) {
          bool4 = true;
        }
        if (bool6) {
          bool1 = true;
        }
        bool8 = bool1;
        bool1 = bool4;
      }
      else
      {
        bool8 = false;
        bool1 = false;
      }
      if ((l2 & 0x800) != 0L)
      {
        this.c.setOnClickListener(this.I3);
        this.d.setOnClickListener(this.L3);
        this.f.setOnClickListener(this.J3);
        this.q.setOnClickListener(this.M3);
        this.x.setOnClickListener(this.K3);
      }
      if ((l2 & 0xA02) != 0L)
      {
        ViewBindingAdapter.setBackground(this.c, Converters.convertColorToDrawable(k));
        ImageViewBindingAdapter.setImageDrawable(this.c, (Drawable)localObject2);
      }
      if ((0x881 & l2) != 0L) {
        b.Q(this.c, bool5);
      }
      if ((0x8C4 & l2) != 0L)
      {
        b.c(this.c, Boolean.valueOf(bool6), null);
        b.c(this.d, Boolean.valueOf(bool6), null);
        b.c(this.q, Boolean.valueOf(bool6), null);
      }
      if ((l2 & 0xC30) != 0L)
      {
        ViewBindingAdapter.setBackground(this.f, Converters.convertColorToDrawable(m));
        ImageViewBindingAdapter.setImageDrawable(this.f, (Drawable)localObject6);
        ViewBindingAdapter.setBackground(this.x, (Drawable)localObject1);
        ImageViewBindingAdapter.setImageDrawable(this.x, (Drawable)localObject3);
      }
      if (bool10)
      {
        b.c(this.f, Boolean.valueOf(bool1), null);
        b.c(this.x, Boolean.valueOf(bool8), null);
      }
      if ((l2 & 0xA08) != 0L)
      {
        ViewBindingAdapter.setBackground(this.q, Converters.convertColorToDrawable(j));
        ImageViewBindingAdapter.setImageDrawable(this.q, (Drawable)localObject4);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable MultiLiveVideoViewModel paramMultiLiveVideoViewModel)
  {
    this.z = paramMultiLiveVideoViewModel;
    try
    {
      this.N3 |= 0x200;
      notifyPropertyChanged(66);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public boolean hasPendingBindings()
  {
    try
    {
      return this.N3 != 0L;
    }
    finally {}
  }
  
  public void i(@Nullable VideoPlayViewModel paramVideoPlayViewModel)
  {
    this.p0 = paramVideoPlayViewModel;
    try
    {
      this.N3 |= 0x80;
      notifyPropertyChanged(74);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void invalidateAll()
  {
    try
    {
      this.N3 = 2048L;
      requestRebind();
      return;
    }
    finally {}
  }
  
  public void l(@Nullable g paramg)
  {
    this.y = paramg;
    try
    {
      this.N3 |= 0x100;
      notifyPropertyChanged(79);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void m(@Nullable TalkViewModel paramTalkViewModel)
  {
    this.p1 = paramTalkViewModel;
    try
    {
      this.N3 |= 0x400;
      notifyPropertyChanged(96);
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
    case 6: 
      return p((ObservableBoolean)paramObject, paramInt2);
    case 5: 
      return t((ObservableBoolean)paramObject, paramInt2);
    case 4: 
      return s((ObservableBoolean)paramObject, paramInt2);
    case 3: 
      return n((ObservableBoolean)paramObject, paramInt2);
    case 2: 
      return q((ObservableBoolean)paramObject, paramInt2);
    case 1: 
      return o((ObservableBoolean)paramObject, paramInt2);
    }
    return r((ObservableBoolean)paramObject, paramInt2);
  }
  
  public boolean setVariable(int paramInt, @Nullable Object paramObject)
  {
    if (74 == paramInt)
    {
      i((VideoPlayViewModel)paramObject);
    }
    else if (79 == paramInt)
    {
      l((g)paramObject);
    }
    else if (66 == paramInt)
    {
      h((MultiLiveVideoViewModel)paramObject);
    }
    else
    {
      if (96 != paramInt) {
        break label70;
      }
      m((TalkViewModel)paramObject);
    }
    boolean bool = true;
    return bool;
    label70:
    bool = false;
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\LayoutFullScreenControlBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */