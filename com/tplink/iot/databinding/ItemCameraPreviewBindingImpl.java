package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import com.tplink.iot.view.ipcamera.base.b;
import com.tplink.iot.view.ipcamera.preview.CameraPreviewInfo;
import com.tplink.iot.widget.RoundImageView;
import com.tplink.iot.widget.camerapreview.PreviewDisplayView;
import com.tplink.iot.widget.camerapreview.g;

public class ItemCameraPreviewBindingImpl
  extends ItemCameraPreviewBinding
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts q;
  @Nullable
  private static final SparseIntArray x;
  private long p0 = -1L;
  @NonNull
  private final ConstraintLayout y;
  @NonNull
  private final PreviewDisplayView z;
  
  public ItemCameraPreviewBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 3, q, x));
  }
  
  private ItemCameraPreviewBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 0, (RoundImageView)paramArrayOfObject[1]);
    this.c.setTag(null);
    paramDataBindingComponent = (ConstraintLayout)paramArrayOfObject[0];
    this.y = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (PreviewDisplayView)paramArrayOfObject[2];
    this.z = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  protected void executeBindings()
  {
    try
    {
      long l = this.p0;
      this.p0 = 0L;
      Object localObject1 = null;
      String str = this.d;
      CameraPreviewInfo localCameraPreviewInfo = this.f;
      boolean bool = (l & 0x6) < 0L;
      Object localObject2 = localObject1;
      if (bool)
      {
        localObject2 = localObject1;
        if (localCameraPreviewInfo != null) {
          localObject2 = localCameraPreviewInfo.e();
        }
      }
      if (bool)
      {
        b.E(this.c, (String)localObject2, false);
        g.b(this.z, localCameraPreviewInfo);
      }
      if ((0x5 & l) != 0L) {
        g.a(this.z, str);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable String paramString)
  {
    this.d = paramString;
    try
    {
      this.p0 |= 1L;
      notifyPropertyChanged(3);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public boolean hasPendingBindings()
  {
    try
    {
      return this.p0 != 0L;
    }
    finally {}
  }
  
  public void i(@Nullable CameraPreviewInfo paramCameraPreviewInfo)
  {
    this.f = paramCameraPreviewInfo;
    try
    {
      this.p0 |= 0x2;
      notifyPropertyChanged(6);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void invalidateAll()
  {
    try
    {
      this.p0 = 4L;
      requestRebind();
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
    if (3 == paramInt)
    {
      h((String)paramObject);
    }
    else
    {
      if (6 != paramInt) {
        break label35;
      }
      i((CameraPreviewInfo)paramObject);
    }
    boolean bool = true;
    return bool;
    label35:
    bool = false;
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ItemCameraPreviewBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */