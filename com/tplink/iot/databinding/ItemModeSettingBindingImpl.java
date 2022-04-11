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

public class ItemModeSettingBindingImpl
  extends ItemModeSettingBinding
  implements a.a
{
  @Nullable
  private static final SparseIntArray H3;
  @Nullable
  private static final ViewDataBinding.IncludedLayouts p3;
  @NonNull
  private final ConstraintLayout I3;
  @NonNull
  private final ImageView J3;
  @Nullable
  private final View.OnClickListener K3;
  @Nullable
  private final View.OnClickListener L3;
  private long M3 = -1L;
  
  public ItemModeSettingBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 7, p3, H3));
  }
  
  private ItemModeSettingBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 0, (ImageView)paramArrayOfObject[5], (ImageView)paramArrayOfObject[6], (ImageView)paramArrayOfObject[1], (TextView)paramArrayOfObject[3], (TextView)paramArrayOfObject[4]);
    this.c.setTag(null);
    this.d.setTag(null);
    this.f.setTag(null);
    paramDataBindingComponent = (ConstraintLayout)paramArrayOfObject[0];
    this.I3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (ImageView)paramArrayOfObject[2];
    this.J3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    this.q.setTag(null);
    this.x.setTag(null);
    setRootTag(paramView);
    this.K3 = new a(this, 2);
    this.L3 = new a(this, 1);
    invalidateAll();
  }
  
  public final void d(int paramInt, View paramView)
  {
    int i = 0;
    int j = 0;
    Object localObject1;
    Object localObject2;
    if (paramInt != 1)
    {
      if (paramInt == 2)
      {
        localObject1 = this.p1;
        localObject2 = this.p0;
        paramInt = j;
        if (localObject1 != null) {
          paramInt = 1;
        }
        if (paramInt != 0) {
          ((d)localObject1).a(paramView, ViewDataBinding.safeUnbox((Integer)localObject2));
        }
      }
    }
    else
    {
      localObject2 = this.p1;
      localObject1 = this.p0;
      paramInt = i;
      if (localObject2 != null) {
        paramInt = 1;
      }
      if (paramInt != 0) {
        ((d)localObject2).a(paramView, ViewDataBinding.safeUnbox((Integer)localObject1));
      }
    }
  }
  
  protected void executeBindings()
  {
    try
    {
      long l1 = this.M3;
      this.M3 = 0L;
      Object localObject1 = this.p2;
      CameraPreviewInfo localCameraPreviewInfo = this.y;
      String str1 = this.z;
      int i = 0;
      boolean bool1 = (l1 & 0x23) < 0L;
      boolean bool3;
      if (bool1)
      {
        bool2 = ViewDataBinding.safeUnbox((Boolean)localObject1);
        l2 = l1;
        if (bool1) {
          if (bool2) {
            l2 = l1 | 0x80;
          } else {
            l2 = l1 | 0x40;
          }
        }
        l1 = l2;
        if ((l2 & 0x21) != 0L)
        {
          if (bool2) {
            l1 = 8192L;
          } else {
            l1 = 4096L;
          }
          l1 = l2 | l1;
        }
        bool3 = bool2;
        l2 = l1;
        if ((l1 & 0x21) != 0L) {
          if (bool2)
          {
            bool3 = bool2;
            l2 = l1;
          }
          else
          {
            j = 4;
            l2 = l1;
            break label173;
          }
        }
      }
      else
      {
        bool3 = false;
        l2 = l1;
      }
      int j = 0;
      boolean bool2 = bool3;
      label173:
      String str2 = null;
      boolean bool4 = (l2 & 0x22) < 0L;
      boolean bool5;
      float f;
      if (bool4)
      {
        if (localCameraPreviewInfo != null)
        {
          bool5 = localCameraPreviewInfo.m();
          str2 = localCameraPreviewInfo.e();
          localObject1 = localCameraPreviewInfo.l();
        }
        else
        {
          localObject1 = null;
          bool5 = false;
        }
        l1 = l2;
        if (bool4) {
          if (bool5) {
            l1 = l2 | 0x800;
          } else {
            l1 = l2 | 0x400;
          }
        }
        if (bool5) {
          f = 1.0F;
        } else {
          f = 0.5F;
        }
        bool3 = bool5 ^ true;
      }
      else
      {
        str2 = null;
        localObject1 = str2;
        bool5 = false;
        f = 0.0F;
        bool3 = false;
        l1 = l2;
      }
      long l2 = l1;
      if ((0x40 & l1) != 0L)
      {
        if (localCameraPreviewInfo != null) {
          bool5 = localCameraPreviewInfo.m();
        }
        l2 = l1;
        if ((l1 & 0x22) != 0L) {
          if (bool5) {
            l2 = l1 | 0x800;
          } else {
            l2 = l1 | 0x400;
          }
        }
        bool3 = bool5 ^ true;
      }
      bool4 = (l2 & 0x23) < 0L;
      if (bool4)
      {
        if (bool2) {
          bool5 = true;
        } else {
          bool5 = bool3;
        }
        l1 = l2;
        if (bool4)
        {
          if (bool5) {
            l1 = 512L;
          } else {
            l1 = 256L;
          }
          l1 = l2 | l1;
        }
        if (bool5) {
          i = 4;
        }
        l2 = l1;
      }
      else
      {
        i = 0;
      }
      if ((0x23 & l2) != 0L) {
        this.c.setVisibility(i);
      }
      if ((0x20 & l2) != 0L)
      {
        this.d.setOnClickListener(this.K3);
        this.I3.setOnClickListener(this.L3);
      }
      if ((l2 & 0x21) != 0L) {
        this.d.setVisibility(j);
      }
      if ((l2 & 0x22) != 0L)
      {
        if (ViewDataBinding.getBuildSdkInt() >= 11)
        {
          this.f.setAlpha(f);
          this.q.setAlpha(f);
          this.x.setAlpha(f);
        }
        b.E(this.f, str2, true);
        b.Q(this.J3, bool3);
        TextViewBindingAdapter.setText(this.q, (CharSequence)localObject1);
      }
      if ((l2 & 0x28) != 0L) {
        TextViewBindingAdapter.setText(this.x, str1);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable d paramd)
  {
    this.p1 = paramd;
    try
    {
      this.M3 |= 0x10;
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
      return this.M3 != 0L;
    }
    finally {}
  }
  
  public void i(@Nullable CameraPreviewInfo paramCameraPreviewInfo)
  {
    this.y = paramCameraPreviewInfo;
    try
    {
      this.M3 |= 0x2;
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
      this.M3 = 32L;
      requestRebind();
      return;
    }
    finally {}
  }
  
  public void l(@Nullable Boolean paramBoolean)
  {
    this.p2 = paramBoolean;
    try
    {
      this.M3 |= 1L;
      notifyPropertyChanged(37);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void m(@Nullable String paramString)
  {
    this.z = paramString;
    try
    {
      this.M3 |= 0x8;
      notifyPropertyChanged(58);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void n(@Nullable Integer paramInteger)
  {
    this.p0 = paramInteger;
    try
    {
      this.M3 |= 0x4;
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
    if (37 == paramInt)
    {
      l((Boolean)paramObject);
    }
    else if (31 == paramInt)
    {
      i((CameraPreviewInfo)paramObject);
    }
    else if (76 == paramInt)
    {
      n((Integer)paramObject);
    }
    else if (58 == paramInt)
    {
      m((String)paramObject);
    }
    else
    {
      if (9 != paramInt) {
        break label87;
      }
      h((d)paramObject);
    }
    boolean bool = true;
    return bool;
    label87:
    bool = false;
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ItemModeSettingBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */