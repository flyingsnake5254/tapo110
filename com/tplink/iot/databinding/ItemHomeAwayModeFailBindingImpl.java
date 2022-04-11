package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.tplink.iot.generated.callback.a;
import com.tplink.iot.generated.callback.a.a;
import com.tplink.iot.view.ipcamera.base.b;
import com.tplink.iot.view.ipcamera.preview.CameraPreviewInfo;

public class ItemHomeAwayModeFailBindingImpl
  extends ItemHomeAwayModeFailBinding
  implements a.a
{
  @Nullable
  private static final SparseIntArray H3;
  @Nullable
  private static final ViewDataBinding.IncludedLayouts p3;
  @NonNull
  private final ConstraintLayout I3;
  @Nullable
  private final View.OnClickListener J3;
  private long K3 = -1L;
  
  public ItemHomeAwayModeFailBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 8, p3, H3));
  }
  
  private ItemHomeAwayModeFailBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 0, (ImageView)paramArrayOfObject[3], (ImageView)paramArrayOfObject[2], (ImageView)paramArrayOfObject[1], (ImageView)paramArrayOfObject[6], (ImageView)paramArrayOfObject[7], (TextView)paramArrayOfObject[4], (TextView)paramArrayOfObject[5]);
    this.c.setTag(null);
    this.d.setTag(null);
    this.f.setTag(null);
    this.q.setTag(null);
    paramDataBindingComponent = (ConstraintLayout)paramArrayOfObject[0];
    this.I3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    this.x.setTag(null);
    this.y.setTag(null);
    this.z.setTag(null);
    setRootTag(paramView);
    this.J3 = new a(this, 1);
    invalidateAll();
  }
  
  public final void d(int paramInt, View paramView)
  {
    com.tplink.iot.adapter.databinding.d locald = this.p1;
    Integer localInteger = this.p2;
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
      long l1 = this.K3;
      this.K3 = 0L;
      Object localObject1 = this.p0;
      boolean bool1 = (l1 & 0x9) < 0L;
      boolean bool2;
      long l2;
      boolean bool3;
      Object localObject3;
      Object localObject4;
      Object localObject5;
      boolean bool4;
      boolean bool5;
      if (bool1)
      {
        if (localObject1 != null)
        {
          bool2 = ((com.tplink.iot.view.ipcamera.preview.d)localObject1).b();
          localObject1 = ((com.tplink.iot.view.ipcamera.preview.d)localObject1).a();
        }
        else
        {
          localObject1 = null;
          bool2 = false;
        }
        l2 = l1;
        if (bool1)
        {
          if (bool2)
          {
            l1 |= 0x200;
            l2 = 2048L;
          }
          else
          {
            l1 |= 0x100;
            l2 = 1024L;
          }
          l2 = l1 | l2;
        }
        bool1 = bool2 ^ true;
        l1 = l2;
        if ((l2 & 0x9) != 0L)
        {
          if (bool1) {
            l1 = 128L;
          } else {
            l1 = 64L;
          }
          l1 = l2 | l1;
        }
        if (localObject1 != null)
        {
          bool3 = ((CameraPreviewInfo)localObject1).m();
          localObject3 = ((CameraPreviewInfo)localObject1).i();
          localObject4 = ((CameraPreviewInfo)localObject1).l();
          localObject5 = ((CameraPreviewInfo)localObject1).e();
          localObject1 = localObject4;
        }
        else
        {
          localObject5 = null;
          localObject3 = localObject5;
          localObject1 = localObject3;
          bool3 = false;
        }
        bool4 = bool3 ^ true;
        localObject4 = localObject5;
        l2 = l1;
        bool5 = bool2;
        bool2 = bool3;
        localObject5 = localObject3;
        localObject3 = localObject1;
        bool3 = bool4;
      }
      else
      {
        localObject4 = null;
        localObject1 = localObject4;
        localObject3 = localObject1;
        bool5 = false;
        bool1 = false;
        bool2 = false;
        bool3 = false;
        localObject5 = localObject1;
        l2 = l1;
      }
      boolean bool6 = (l2 & 0x9) < 0L;
      int i;
      if (bool6)
      {
        boolean bool7;
        if (bool1) {
          bool7 = bool2;
        } else {
          bool7 = false;
        }
        if (bool5) {
          bool4 = true;
        } else {
          bool4 = bool3;
        }
        if (!bool5) {
          bool2 = false;
        }
        l1 = l2;
        if (bool6)
        {
          if (bool7) {
            l1 = 32L;
          } else {
            l1 = 16L;
          }
          l1 = l2 | l1;
        }
        if (bool7)
        {
          bool1 = false;
          l2 = l1;
        }
        else
        {
          i = 4;
          l2 = l1;
        }
      }
      else
      {
        i = 0;
        bool2 = false;
        bool4 = false;
      }
      if ((0x9 & l2) != 0L)
      {
        b.Q(this.c, bool2);
        b.Q(this.d, bool3);
        b.E(this.f, (String)localObject4, false);
        this.q.setVisibility(i);
        b.Q(this.x, bool4);
        TextViewBindingAdapter.setText(this.y, (CharSequence)localObject3);
        TextViewBindingAdapter.setText(this.z, (CharSequence)localObject5);
      }
      if ((l2 & 0x8) != 0L) {
        this.x.setOnClickListener(this.J3);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable com.tplink.iot.adapter.databinding.d paramd)
  {
    this.p1 = paramd;
    try
    {
      this.K3 |= 0x4;
      notifyPropertyChanged(9);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public boolean hasPendingBindings()
  {
    try
    {
      return this.K3 != 0L;
    }
    finally {}
  }
  
  public void i(@Nullable com.tplink.iot.view.ipcamera.preview.d paramd)
  {
    this.p0 = paramd;
    try
    {
      this.K3 |= 1L;
      notifyPropertyChanged(31);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void invalidateAll()
  {
    try
    {
      this.K3 = 8L;
      requestRebind();
      return;
    }
    finally {}
  }
  
  public void l(@Nullable Integer paramInteger)
  {
    this.p2 = paramInteger;
    try
    {
      this.K3 |= 0x2;
      notifyPropertyChanged(76);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  protected boolean onFieldChange(int paramInt1, Object paramObject, int paramInt2)
  {
    return false;
  }
  
  public boolean setVariable(int paramInt, @Nullable Object paramObject)
  {
    if (31 == paramInt)
    {
      i((com.tplink.iot.view.ipcamera.preview.d)paramObject);
    }
    else if (76 == paramInt)
    {
      l((Integer)paramObject);
    }
    else
    {
      if (9 != paramInt) {
        break label53;
      }
      h((com.tplink.iot.adapter.databinding.d)paramObject);
    }
    boolean bool = true;
    return bool;
    label53:
    bool = false;
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ItemHomeAwayModeFailBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */