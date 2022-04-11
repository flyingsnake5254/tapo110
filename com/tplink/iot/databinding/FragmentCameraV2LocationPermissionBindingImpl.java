package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import com.tplink.iot.view.ipcamera.base.g;

public class FragmentCameraV2LocationPermissionBindingImpl
  extends FragmentCameraV2LocationPermissionBinding
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts x;
  @Nullable
  private static final SparseIntArray y;
  private long p0 = -1L;
  @NonNull
  private final LinearLayout z;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    y = localSparseIntArray;
    localSparseIntArray.put(2131363277, 3);
  }
  
  public FragmentCameraV2LocationPermissionBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 4, x, y));
  }
  
  private FragmentCameraV2LocationPermissionBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 0, (Button)paramArrayOfObject[2], (ImageView)paramArrayOfObject[1], (LinearLayout)paramArrayOfObject[3]);
    this.c.setTag(null);
    this.d.setTag(null);
    paramDataBindingComponent = (LinearLayout)paramArrayOfObject[0];
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
      g localg = this.q;
      if ((l & 0x3) != 0L)
      {
        this.c.setOnClickListener(localg);
        this.d.setOnClickListener(localg);
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
      this.p0 |= 1L;
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
      return this.p0 != 0L;
    }
    finally {}
  }
  
  public void invalidateAll()
  {
    try
    {
      this.p0 = 2L;
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
    boolean bool;
    if (79 == paramInt)
    {
      h((g)paramObject);
      bool = true;
    }
    else
    {
      bool = false;
    }
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentCameraV2LocationPermissionBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */