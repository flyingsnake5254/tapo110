package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import com.tplink.iot.widget.BrightnessSeekBar;
import com.tplink.iot.widget.colorbulb.ColorPlateWrapView;

public class FragmentColorPickerDialogBindingImpl
  extends FragmentColorPickerDialogBinding
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts y;
  @Nullable
  private static final SparseIntArray z;
  @NonNull
  private final LinearLayout p0;
  private long p1 = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    z = localSparseIntArray;
    localSparseIntArray.put(2131363013, 1);
    localSparseIntArray.put(2131363111, 2);
    localSparseIntArray.put(2131362289, 3);
    localSparseIntArray.put(2131363267, 4);
    localSparseIntArray.put(2131362027, 5);
  }
  
  public FragmentColorPickerDialogBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 6, y, z));
  }
  
  private FragmentColorPickerDialogBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 0, (BrightnessSeekBar)paramArrayOfObject[5], (ColorPlateWrapView)paramArrayOfObject[3], (ImageView)paramArrayOfObject[1], (ImageView)paramArrayOfObject[2], (LinearLayout)paramArrayOfObject[4]);
    paramDataBindingComponent = (LinearLayout)paramArrayOfObject[0];
    this.p0 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  protected void executeBindings()
  {
    try
    {
      this.p1 = 0L;
      return;
    }
    finally {}
  }
  
  public boolean hasPendingBindings()
  {
    try
    {
      return this.p1 != 0L;
    }
    finally {}
  }
  
  public void invalidateAll()
  {
    try
    {
      this.p1 = 1L;
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
    return true;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentColorPickerDialogBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */