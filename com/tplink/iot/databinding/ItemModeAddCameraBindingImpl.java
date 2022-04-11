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
import com.tplink.iot.adapter.databinding.d;
import com.tplink.iot.generated.callback.a;
import com.tplink.iot.generated.callback.a.a;
import com.tplink.iot.view.ipcamera.base.b;
import com.tplink.iot.view.ipcamera.preview.CameraPreviewInfo;

public class ItemModeAddCameraBindingImpl
  extends ItemModeAddCameraBinding
  implements a.a
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts I3;
  @Nullable
  private static final SparseIntArray J3;
  @NonNull
  private final ConstraintLayout K3;
  @NonNull
  private final ImageView L3;
  @Nullable
  private final View.OnClickListener M3;
  private long N3 = -1L;
  
  public ItemModeAddCameraBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 8, I3, J3));
  }
  
  private ItemModeAddCameraBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 0, (View)paramArrayOfObject[1], (ImageView)paramArrayOfObject[2], (ImageView)paramArrayOfObject[6], (ImageView)paramArrayOfObject[7], (TextView)paramArrayOfObject[4], (TextView)paramArrayOfObject[5]);
    this.c.setTag(null);
    this.d.setTag(null);
    this.f.setTag(null);
    this.q.setTag(null);
    paramDataBindingComponent = (ConstraintLayout)paramArrayOfObject[0];
    this.K3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (ImageView)paramArrayOfObject[3];
    this.L3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    this.x.setTag(null);
    this.y.setTag(null);
    setRootTag(paramView);
    this.M3 = new a(this, 1);
    invalidateAll();
  }
  
  public final void d(int paramInt, View paramView)
  {
    d locald = this.p2;
    Integer localInteger = this.p1;
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
      long l1 = this.N3;
      this.N3 = 0L;
      Object localObject1 = this.p3;
      Integer localInteger1 = this.H3;
      CameraPreviewInfo localCameraPreviewInfo = this.z;
      Integer localInteger2 = this.p1;
      String str = this.p0;
      boolean bool1 = (l1 & 0x45) < 0L;
      boolean bool3;
      boolean bool4;
      if (bool1)
      {
        bool2 = ViewDataBinding.safeUnbox((Boolean)localObject1);
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
        bool3 = bool2 ^ true;
        bool4 = bool2;
        l1 = l2;
        bool1 = bool3;
        if ((l2 & 0x45) != 0L)
        {
          if (bool3) {
            l1 = 256L;
          } else {
            l1 = 128L;
          }
          l1 = l2 | l1;
          bool4 = bool2;
          bool1 = bool3;
        }
      }
      else
      {
        bool4 = false;
        bool1 = false;
      }
      boolean bool5 = (l1 & 0x4A) < 0L;
      if (bool5)
      {
        if (localInteger1 != null) {
          bool2 = localInteger1.equals(Integer.valueOf(0));
        } else {
          bool2 = false;
        }
        bool6 = bool2 ^ true;
        l2 = l1;
        bool3 = bool6;
        if (bool5) {
          if (bool6)
          {
            l2 = l1 | 0x10000;
            bool3 = bool6;
          }
          else
          {
            l2 = l1 | 0x8000;
            bool3 = bool6;
          }
        }
      }
      else
      {
        bool3 = false;
        l2 = l1;
      }
      Object localObject3 = null;
      boolean bool6 = (l2 & 0x44) < 0L;
      float f;
      boolean bool7;
      boolean bool8;
      if (bool6)
      {
        if (localCameraPreviewInfo != null)
        {
          bool2 = localCameraPreviewInfo.m();
          localObject1 = localCameraPreviewInfo.e();
          localObject3 = localCameraPreviewInfo.l();
        }
        else
        {
          localObject1 = null;
          bool2 = false;
        }
        l1 = l2;
        if (bool6) {
          if (bool2) {
            l1 = l2 | 0x4000;
          } else {
            l1 = l2 | 0x2000;
          }
        }
        if (bool2) {
          f = 1.0F;
        } else {
          f = 0.5F;
        }
        bool7 = bool2 ^ true;
        bool8 = bool2;
      }
      else
      {
        localObject1 = null;
        localObject3 = localObject1;
        f = 0.0F;
        bool8 = false;
        bool7 = false;
        l1 = l2;
      }
      long l2 = l1;
      boolean bool2 = bool8;
      if ((l1 & 0x500) != 0L)
      {
        if (localCameraPreviewInfo != null) {
          bool8 = localCameraPreviewInfo.m();
        }
        l2 = l1;
        bool2 = bool8;
        if ((l1 & 0x44) != 0L) {
          if (bool8)
          {
            l2 = l1 | 0x4000;
            bool2 = bool8;
          }
          else
          {
            l2 = l1 | 0x2000;
            bool2 = bool8;
          }
        }
      }
      if (((l2 & 0x10000) != 0L) && (localInteger1 != null)) {
        bool8 = localInteger1.equals(localInteger2);
      } else {
        bool8 = false;
      }
      bool6 = (l2 & 0x45) < 0L;
      boolean bool9;
      int i;
      if (bool6)
      {
        if (bool1) {
          bool9 = bool2;
        } else {
          bool9 = false;
        }
        if (!bool4) {
          bool2 = false;
        }
        l1 = l2;
        if (bool6)
        {
          if (bool2) {
            l1 = 4096L;
          } else {
            l1 = 2048L;
          }
          l1 = l2 | l1;
        }
        if (bool2)
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
        bool9 = false;
      }
      bool6 = (l2 & 0x4A) < 0L;
      if (bool6)
      {
        if (bool3) {
          bool2 = bool8;
        } else {
          bool2 = false;
        }
      }
      else {
        bool2 = false;
      }
      if (bool6) {
        b.Q(this.c, bool2);
      }
      if ((l2 & 0x44) != 0L)
      {
        if (ViewDataBinding.getBuildSdkInt() >= 11)
        {
          this.d.setAlpha(f);
          this.x.setAlpha(f);
          this.y.setAlpha(f);
        }
        b.E(this.d, (String)localObject1, true);
        b.Q(this.L3, bool7);
        TextViewBindingAdapter.setText(this.x, (CharSequence)localObject3);
      }
      if ((l2 & 0x45) != 0L)
      {
        this.f.setVisibility(i);
        b.Q(this.q, bool9);
      }
      if ((0x40 & l2) != 0L) {
        this.K3.setOnClickListener(this.M3);
      }
      if ((l2 & 0x50) != 0L) {
        TextViewBindingAdapter.setText(this.y, str);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable d paramd)
  {
    this.p2 = paramd;
    try
    {
      this.N3 |= 0x20;
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
      return this.N3 != 0L;
    }
    finally {}
  }
  
  public void i(@Nullable Integer paramInteger)
  {
    this.H3 = paramInteger;
    try
    {
      this.N3 |= 0x2;
      notifyPropertyChanged(24);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void invalidateAll()
  {
    try
    {
      this.N3 = 64L;
      requestRebind();
      return;
    }
    finally {}
  }
  
  public void l(@Nullable CameraPreviewInfo paramCameraPreviewInfo)
  {
    this.z = paramCameraPreviewInfo;
    try
    {
      this.N3 |= 0x4;
      notifyPropertyChanged(31);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void m(@Nullable Boolean paramBoolean)
  {
    this.p3 = paramBoolean;
    try
    {
      this.N3 |= 1L;
      notifyPropertyChanged(51);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void n(@Nullable String paramString)
  {
    this.p0 = paramString;
    try
    {
      this.N3 |= 0x10;
      notifyPropertyChanged(58);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void o(@Nullable Integer paramInteger)
  {
    this.p1 = paramInteger;
    try
    {
      this.N3 |= 0x8;
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
    if (51 == paramInt)
    {
      m((Boolean)paramObject);
    }
    else if (24 == paramInt)
    {
      i((Integer)paramObject);
    }
    else if (31 == paramInt)
    {
      l((CameraPreviewInfo)paramObject);
    }
    else if (76 == paramInt)
    {
      o((Integer)paramObject);
    }
    else if (58 == paramInt)
    {
      n((String)paramObject);
    }
    else
    {
      if (9 != paramInt) {
        break label104;
      }
      h((d)paramObject);
    }
    boolean bool = true;
    return bool;
    label104:
    bool = false;
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ItemModeAddCameraBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */