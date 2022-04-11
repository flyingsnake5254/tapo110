package com.tplink.iot.databinding;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.Observable;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import androidx.databinding.adapters.ImageViewBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.tplink.iot.adapter.databinding.d;
import com.tplink.iot.generated.callback.a;
import com.tplink.iot.generated.callback.a.a;
import com.tplink.iot.view.ipcamera.base.b;
import com.tplink.iot.viewmodel.ipcamera.play.SelectDeviceViewModel.a;

public class ItemCameraSelectDeviceFullScreenBindingImpl
  extends ItemCameraSelectDeviceFullScreenBinding
  implements a.a
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts p1;
  @Nullable
  private static final SparseIntArray p2;
  @Nullable
  private final View.OnClickListener H3;
  private long I3 = -1L;
  @NonNull
  private final ConstraintLayout p3;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    p2 = localSparseIntArray;
    localSparseIntArray.put(2131362020, 5);
  }
  
  public ItemCameraSelectDeviceFullScreenBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 6, p1, p2));
  }
  
  private ItemCameraSelectDeviceFullScreenBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 1, (View)paramArrayOfObject[5], (ImageView)paramArrayOfObject[4], (TextView)paramArrayOfObject[2], (ImageView)paramArrayOfObject[1], (TextView)paramArrayOfObject[3]);
    this.d.setTag(null);
    this.f.setTag(null);
    this.q.setTag(null);
    paramDataBindingComponent = (ConstraintLayout)paramArrayOfObject[0];
    this.p3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    this.x.setTag(null);
    setRootTag(paramView);
    this.H3 = new a(this, 1);
    invalidateAll();
  }
  
  private boolean h(ObservableBoolean paramObservableBoolean, int paramInt)
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
  
  public final void d(int paramInt, View paramView)
  {
    d locald = this.z;
    Integer localInteger = this.p0;
    if (locald != null) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    if (paramInt != 0) {
      locald.a(paramView, ViewDataBinding.safeUnbox(localInteger));
    }
  }
  
  protected void executeBindings()
  {
    try
    {
      long l1 = this.I3;
      this.I3 = 0L;
      Object localObject1 = this.y;
      Integer localInteger = this.p0;
      float f1 = 0.0F;
      float f2 = 0.0F;
      String str1;
      boolean bool2;
      boolean bool3;
      String str2;
      if ((l1 & 0x13) != 0L)
      {
        boolean bool1 = (l1 & 0x12) < 0L;
        boolean bool4;
        if (bool1)
        {
          if (localObject1 != null)
          {
            str1 = ((SelectDeviceViewModel.a)localObject1).d;
            bool2 = ((SelectDeviceViewModel.a)localObject1).c;
            bool3 = ((SelectDeviceViewModel.a)localObject1).b;
            str2 = ((SelectDeviceViewModel.a)localObject1).e;
          }
          else
          {
            str1 = null;
            bool2 = false;
            bool3 = false;
            str2 = null;
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
          bool4 = bool2 ^ true;
          if (bool2) {
            f2 = 0.4F;
          } else {
            f2 = 1.0F;
          }
          l1 = l2;
          bool2 = bool4;
        }
        else
        {
          str1 = null;
          bool3 = false;
          str2 = null;
          bool2 = false;
        }
        if (localObject1 != null) {
          localObject1 = ((SelectDeviceViewModel.a)localObject1).g;
        } else {
          localObject1 = null;
        }
        updateRegistration(0, (Observable)localObject1);
        if (localObject1 != null) {
          bool4 = ((ObservableBoolean)localObject1).get();
        } else {
          bool4 = false;
        }
        l2 = l1;
        if ((l1 & 0x13) != 0L)
        {
          if (bool4) {
            l2 = 256L;
          } else {
            l2 = 128L;
          }
          l2 = l1 | l2;
        }
        if (bool4)
        {
          localObject1 = this.d.getContext();
          i = 2131231492;
        }
        else
        {
          localObject1 = this.d.getContext();
          i = 2131231348;
        }
        localObject1 = AppCompatResources.getDrawable((Context)localObject1, i);
        l1 = l2;
      }
      else
      {
        localObject1 = null;
        str2 = null;
        bool2 = false;
        bool3 = false;
        str1 = null;
        f2 = f1;
      }
      boolean bool5 = (l1 & 0x14) < 0L;
      long l2 = l1;
      if (bool5)
      {
        if (ViewDataBinding.safeUnbox(localInteger) == 0) {
          i = 1;
        } else {
          i = 0;
        }
        l2 = l1;
        if (bool5)
        {
          if (i != 0) {
            l2 = 64L;
          } else {
            l2 = 32L;
          }
          l2 = l1 | l2;
        }
        if (i == 0)
        {
          i = 2;
          break label393;
        }
      }
      int i = 0;
      label393:
      if ((0x12 & l2) != 0L)
      {
        if (ViewDataBinding.getBuildSdkInt() >= 11) {
          this.d.setAlpha(f2);
        }
        TextViewBindingAdapter.setText(this.f, str2);
        b.E(this.q, str1, false);
        this.p3.setEnabled(bool2);
        b.Q(this.x, bool3);
      }
      if ((0x13 & l2) != 0L) {
        ImageViewBindingAdapter.setImageDrawable(this.d, (Drawable)localObject1);
      }
      if ((l2 & 0x14) != 0L) {
        b.z(this.q, Integer.valueOf(i));
      }
      if ((l2 & 0x10) != 0L) {
        this.p3.setOnClickListener(this.H3);
      }
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
  
  public void i(@Nullable d paramd)
  {
    this.z = paramd;
    try
    {
      this.I3 |= 0x8;
      notifyPropertyChanged(9);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void invalidateAll()
  {
    try
    {
      this.I3 = 16L;
      requestRebind();
      return;
    }
    finally {}
  }
  
  public void l(@Nullable SelectDeviceViewModel.a parama)
  {
    this.y = parama;
    try
    {
      this.I3 |= 0x2;
      notifyPropertyChanged(31);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void m(@Nullable Integer paramInteger)
  {
    this.p0 = paramInteger;
    try
    {
      this.I3 |= 0x4;
      notifyPropertyChanged(76);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  protected boolean onFieldChange(int paramInt1, Object paramObject, int paramInt2)
  {
    if (paramInt1 != 0) {
      return false;
    }
    return h((ObservableBoolean)paramObject, paramInt2);
  }
  
  public boolean setVariable(int paramInt, @Nullable Object paramObject)
  {
    if (31 == paramInt)
    {
      l((SelectDeviceViewModel.a)paramObject);
    }
    else if (76 == paramInt)
    {
      m((Integer)paramObject);
    }
    else
    {
      if (9 != paramInt) {
        break label53;
      }
      i((d)paramObject);
    }
    boolean bool = true;
    return bool;
    label53:
    bool = false;
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ItemCameraSelectDeviceFullScreenBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */