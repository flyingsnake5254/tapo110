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

public class ItemCameraSelectDeviceBindingImpl
  extends ItemCameraSelectDeviceBinding
  implements a.a
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts p0;
  @Nullable
  private static final SparseIntArray p1;
  @Nullable
  private final View.OnClickListener H3;
  private long I3 = -1L;
  @NonNull
  private final ConstraintLayout p2;
  @NonNull
  private final View p3;
  
  public ItemCameraSelectDeviceBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 6, p0, p1));
  }
  
  private ItemCameraSelectDeviceBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 1, (ImageView)paramArrayOfObject[5], (TextView)paramArrayOfObject[3], (ImageView)paramArrayOfObject[2], (TextView)paramArrayOfObject[4]);
    this.c.setTag(null);
    this.d.setTag(null);
    this.f.setTag(null);
    paramDataBindingComponent = (ConstraintLayout)paramArrayOfObject[0];
    this.p2 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (View)paramArrayOfObject[1];
    this.p3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    this.q.setTag(null);
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
    d locald = this.y;
    Integer localInteger = this.z;
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
      Object localObject1 = this.x;
      Integer localInteger = this.z;
      float f1 = 0.0F;
      float f2 = 0.0F;
      Object localObject2;
      boolean bool3;
      boolean bool4;
      boolean bool5;
      Drawable localDrawable;
      if ((l1 & 0x13) != 0L)
      {
        boolean bool1 = (l1 & 0x12) < 0L;
        String str;
        if (bool1)
        {
          if (localObject1 != null)
          {
            localObject2 = ((SelectDeviceViewModel.a)localObject1).d;
            bool3 = ((SelectDeviceViewModel.a)localObject1).c;
            bool4 = ((SelectDeviceViewModel.a)localObject1).b;
            str = ((SelectDeviceViewModel.a)localObject1).e;
          }
          else
          {
            localObject2 = null;
            bool3 = false;
            bool4 = false;
            str = null;
          }
          l2 = l1;
          if (bool1)
          {
            if (bool3) {
              l2 = 256L;
            } else {
              l2 = 128L;
            }
            l2 = l1 | l2;
          }
          bool5 = bool3 ^ true;
          if (bool3) {
            f2 = 0.4F;
          } else {
            f2 = 1.0F;
          }
          l1 = l2;
          bool3 = bool5;
        }
        else
        {
          localObject2 = null;
          bool4 = false;
          str = null;
          bool3 = false;
        }
        if (localObject1 != null) {
          localObject1 = ((SelectDeviceViewModel.a)localObject1).g;
        } else {
          localObject1 = null;
        }
        updateRegistration(0, (Observable)localObject1);
        if (localObject1 != null) {
          bool5 = ((ObservableBoolean)localObject1).get();
        } else {
          bool5 = false;
        }
        long l2 = l1;
        if ((l1 & 0x13) != 0L)
        {
          if (bool5) {
            l2 = 64L;
          } else {
            l2 = 32L;
          }
          l2 = l1 | l2;
        }
        int i;
        if (bool5)
        {
          localObject1 = this.c.getContext();
          i = 2131231492;
        }
        else
        {
          localObject1 = this.c.getContext();
          i = 2131231348;
        }
        localDrawable = AppCompatResources.getDrawable((Context)localObject1, i);
        localObject1 = localObject2;
        l1 = l2;
        localObject2 = str;
      }
      else
      {
        localDrawable = null;
        localObject2 = null;
        bool3 = false;
        bool4 = false;
        localObject1 = null;
        f2 = f1;
      }
      boolean bool2 = (l1 & 0x14) < 0L;
      if ((bool2) && (ViewDataBinding.safeUnbox(localInteger) != 0)) {
        bool5 = true;
      } else {
        bool5 = false;
      }
      if ((0x12 & l1) != 0L)
      {
        if (ViewDataBinding.getBuildSdkInt() >= 11) {
          this.c.setAlpha(f2);
        }
        TextViewBindingAdapter.setText(this.d, (CharSequence)localObject2);
        b.E(this.f, (String)localObject1, false);
        this.p2.setEnabled(bool3);
        b.Q(this.q, bool4);
      }
      if ((0x13 & l1) != 0L) {
        ImageViewBindingAdapter.setImageDrawable(this.c, localDrawable);
      }
      if ((l1 & 0x10) != 0L) {
        this.p2.setOnClickListener(this.H3);
      }
      if (bool2) {
        b.Q(this.p3, bool5);
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
    this.y = paramd;
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
    this.x = parama;
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
    this.z = paramInteger;
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ItemCameraSelectDeviceBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */