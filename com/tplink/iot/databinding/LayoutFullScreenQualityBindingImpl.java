package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.Observable;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import com.tplink.iot.generated.callback.a;
import com.tplink.iot.generated.callback.a.a;
import com.tplink.iot.view.ipcamera.base.b;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.ipcamera.play.MultiLiveVideoViewModel;
import com.tplink.iot.viewmodel.ipcamera.play.VideoPlayViewModel;

public class LayoutFullScreenQualityBindingImpl
  extends LayoutFullScreenQualityBinding
  implements a.a
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts y;
  @Nullable
  private static final SparseIntArray z;
  @NonNull
  private final LinearLayout p0;
  @Nullable
  private final View.OnClickListener p1;
  @Nullable
  private final View.OnClickListener p2;
  private long p3 = -1L;
  
  public LayoutFullScreenQualityBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 3, y, z));
  }
  
  private LayoutFullScreenQualityBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 3, (TextView)paramArrayOfObject[1], (TextView)paramArrayOfObject[2]);
    paramDataBindingComponent = (LinearLayout)paramArrayOfObject[0];
    this.p0 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    this.c.setTag(null);
    this.d.setTag(null);
    setRootTag(paramView);
    this.p1 = new a(this, 1);
    this.p2 = new a(this, 2);
    invalidateAll();
  }
  
  private boolean m(ObservableBoolean paramObservableBoolean, int paramInt)
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
  
  private boolean n(ObservableBoolean paramObservableBoolean, int paramInt)
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
  
  private boolean o(ObservableBoolean paramObservableBoolean, int paramInt)
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
  
  public final void d(int paramInt, View paramView)
  {
    int i = 0;
    int j = 0;
    g localg;
    if (paramInt != 1)
    {
      if (paramInt == 2)
      {
        localg = this.q;
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
      localg = this.q;
      paramInt = i;
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
      long l1 = this.p3;
      this.p3 = 0L;
      MultiLiveVideoViewModel localMultiLiveVideoViewModel = this.x;
      long l2;
      int k;
      int m;
      if ((0x67 & l1) != 0L)
      {
        boolean bool1 = (l1 & 0x61) < 0L;
        Object localObject1;
        if (bool1)
        {
          if (localMultiLiveVideoViewModel != null) {
            localObject1 = localMultiLiveVideoViewModel.Y3;
          } else {
            localObject1 = null;
          }
          updateRegistration(0, (Observable)localObject1);
          if (localObject1 != null) {
            bool2 = ((ObservableBoolean)localObject1).get();
          } else {
            bool2 = false;
          }
          l2 = l1;
          if (bool1)
          {
            if (bool2) {
              l2 = 1024L;
            } else {
              l2 = 512L;
            }
            l2 = l1 | l2;
          }
          if (bool2)
          {
            i = ViewDataBinding.getColorFromResource(this.d, 2131099706);
            l1 = l2;
          }
          else
          {
            i = ViewDataBinding.getColorFromResource(this.d, 2131100140);
            l1 = l2;
          }
        }
        else
        {
          i = 0;
        }
        boolean bool3 = (l1 & 0x62) < 0L;
        if (bool3)
        {
          if (localMultiLiveVideoViewModel != null) {
            localObject1 = localMultiLiveVideoViewModel.X3;
          } else {
            localObject1 = null;
          }
          updateRegistration(1, (Observable)localObject1);
          if (localObject1 != null) {
            bool2 = ((ObservableBoolean)localObject1).get();
          } else {
            bool2 = false;
          }
          l2 = l1;
          if (bool3)
          {
            if (bool2) {
              l2 = 256L;
            } else {
              l2 = 128L;
            }
            l2 = l1 | l2;
          }
          localObject1 = this.c;
          if (bool2)
          {
            j = ViewDataBinding.getColorFromResource((View)localObject1, 2131099706);
            l1 = l2;
          }
          else
          {
            j = ViewDataBinding.getColorFromResource((View)localObject1, 2131100140);
            l1 = l2;
          }
        }
        else
        {
          j = 0;
        }
        l2 = l1;
        k = i;
        m = j;
        if ((l1 & 0x64) != 0L)
        {
          if (localMultiLiveVideoViewModel != null) {
            localObject1 = localMultiLiveVideoViewModel.a4;
          } else {
            localObject1 = null;
          }
          updateRegistration(2, (Observable)localObject1);
          l2 = l1;
          k = i;
          m = j;
          if (localObject1 != null)
          {
            bool2 = ((ObservableBoolean)localObject1).get();
            break label385;
          }
        }
      }
      else
      {
        k = 0;
        m = 0;
        l2 = l1;
      }
      boolean bool2 = false;
      int j = m;
      int i = k;
      l1 = l2;
      label385:
      if ((l1 & 0x64) != 0L) {
        b.a(this.p0, bool2, null);
      }
      if ((0x62 & l1) != 0L) {
        this.c.setTextColor(j);
      }
      if ((0x40 & l1) != 0L)
      {
        this.c.setOnClickListener(this.p1);
        this.d.setOnClickListener(this.p2);
      }
      if ((l1 & 0x61) != 0L) {
        this.d.setTextColor(i);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable g paramg)
  {
    this.q = paramg;
    try
    {
      this.p3 |= 0x10;
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
      return this.p3 != 0L;
    }
    finally {}
  }
  
  public void i(@Nullable VideoPlayViewModel paramVideoPlayViewModel)
  {
    this.f = paramVideoPlayViewModel;
  }
  
  public void invalidateAll()
  {
    try
    {
      this.p3 = 64L;
      requestRebind();
      return;
    }
    finally {}
  }
  
  public void l(@Nullable MultiLiveVideoViewModel paramMultiLiveVideoViewModel)
  {
    this.x = paramMultiLiveVideoViewModel;
    try
    {
      this.p3 |= 0x20;
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
        if (paramInt1 != 2) {
          return false;
        }
        return o((ObservableBoolean)paramObject, paramInt2);
      }
      return m((ObservableBoolean)paramObject, paramInt2);
    }
    return n((ObservableBoolean)paramObject, paramInt2);
  }
  
  public boolean setVariable(int paramInt, @Nullable Object paramObject)
  {
    if (100 == paramInt)
    {
      i((VideoPlayViewModel)paramObject);
    }
    else if (79 == paramInt)
    {
      h((g)paramObject);
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\LayoutFullScreenQualityBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */