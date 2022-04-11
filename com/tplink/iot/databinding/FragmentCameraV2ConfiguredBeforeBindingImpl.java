package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import com.tplink.iot.widget.autofixtextview.AutofitTextView;

public class FragmentCameraV2ConfiguredBeforeBindingImpl
  extends FragmentCameraV2ConfiguredBeforeBinding
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts p1;
  @Nullable
  private static final SparseIntArray p2;
  private long H3 = -1L;
  @NonNull
  private final LinearLayout p3;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    p2 = localSparseIntArray;
    localSparseIntArray.put(2131364275, 1);
    localSparseIntArray.put(2131363277, 2);
    localSparseIntArray.put(2131364688, 3);
    localSparseIntArray.put(2131364675, 4);
    localSparseIntArray.put(2131364676, 5);
    localSparseIntArray.put(2131364677, 6);
    localSparseIntArray.put(2131364382, 7);
    localSparseIntArray.put(2131364354, 8);
  }
  
  public FragmentCameraV2ConfiguredBeforeBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 9, p1, p2));
  }
  
  private FragmentCameraV2ConfiguredBeforeBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 0, (RelativeLayout)paramArrayOfObject[2], (Toolbar)paramArrayOfObject[1], (TextView)paramArrayOfObject[8], (AutofitTextView)paramArrayOfObject[7], (TextView)paramArrayOfObject[4], (TextView)paramArrayOfObject[5], (TextView)paramArrayOfObject[6], (TextView)paramArrayOfObject[3]);
    paramDataBindingComponent = (LinearLayout)paramArrayOfObject[0];
    this.p3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  protected void executeBindings()
  {
    try
    {
      this.H3 = 0L;
      return;
    }
    finally {}
  }
  
  public boolean hasPendingBindings()
  {
    try
    {
      return this.H3 != 0L;
    }
    finally {}
  }
  
  public void invalidateAll()
  {
    try
    {
      this.H3 = 1L;
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentCameraV2ConfiguredBeforeBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */