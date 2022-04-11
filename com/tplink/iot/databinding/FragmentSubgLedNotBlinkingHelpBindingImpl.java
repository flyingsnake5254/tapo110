package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import com.tplink.iot.devicecommon.widget.VariousImageViewLayout;
import com.tplink.iot.widget.PointTextView;

public class FragmentSubgLedNotBlinkingHelpBindingImpl
  extends FragmentSubgLedNotBlinkingHelpBinding
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
    localSparseIntArray.put(2131362831, 1);
    localSparseIntArray.put(2131363277, 2);
    localSparseIntArray.put(2131363291, 3);
    localSparseIntArray.put(2131364675, 4);
    localSparseIntArray.put(2131364676, 5);
    localSparseIntArray.put(2131364677, 6);
    localSparseIntArray.put(2131364606, 7);
    localSparseIntArray.put(2131363108, 8);
  }
  
  public FragmentSubgLedNotBlinkingHelpBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 9, p1, p2));
  }
  
  private FragmentSubgLedNotBlinkingHelpBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 0, (ImageView)paramArrayOfObject[1], (VariousImageViewLayout)paramArrayOfObject[8], (LinearLayout)paramArrayOfObject[2], (LinearLayout)paramArrayOfObject[3], (TextView)paramArrayOfObject[7], (PointTextView)paramArrayOfObject[4], (PointTextView)paramArrayOfObject[5], (PointTextView)paramArrayOfObject[6]);
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentSubgLedNotBlinkingHelpBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */