package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import com.tplink.iot.devices.lightstrip.widget.CircleEffectImageView;
import com.tplink.iot.devices.lightstrip.widget.ColorEffectPlateView;
import com.tplink.iot.devices.lightstrip.widget.ColorPaintingRingView;
import com.tplink.iot.devices.lightstrip.widget.SelectableColorPointView;
import com.tplink.iot.widget.WaveView;

public class LayoutLightStripGuidePageBindingImpl
  extends LayoutLightStripGuidePageBinding
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts p2;
  @Nullable
  private static final SparseIntArray p3;
  @NonNull
  private final RelativeLayout H3;
  private long I3 = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    p3 = localSparseIntArray;
    localSparseIntArray.put(2131363909, 1);
    localSparseIntArray.put(2131363914, 2);
    localSparseIntArray.put(2131364826, 3);
    localSparseIntArray.put(2131364014, 4);
    localSparseIntArray.put(2131362285, 5);
    localSparseIntArray.put(2131362283, 6);
    localSparseIntArray.put(2131362243, 7);
    localSparseIntArray.put(2131364473, 8);
    localSparseIntArray.put(2131362106, 9);
  }
  
  public LayoutLightStripGuidePageBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 10, p2, p3));
  }
  
  private LayoutLightStripGuidePageBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 0, (TextView)paramArrayOfObject[9], (CircleEffectImageView)paramArrayOfObject[7], (ColorEffectPlateView)paramArrayOfObject[6], (ColorPaintingRingView)paramArrayOfObject[5], (RelativeLayout)paramArrayOfObject[1], (RelativeLayout)paramArrayOfObject[2], (SelectableColorPointView)paramArrayOfObject[4], (TextView)paramArrayOfObject[8], (WaveView)paramArrayOfObject[3]);
    paramDataBindingComponent = (RelativeLayout)paramArrayOfObject[0];
    this.H3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  protected void executeBindings()
  {
    try
    {
      this.I3 = 0L;
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
  
  public void invalidateAll()
  {
    try
    {
      this.I3 = 1L;
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\LayoutLightStripGuidePageBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */