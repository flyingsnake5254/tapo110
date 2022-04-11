package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import com.tplink.iot.widget.viewgroup.ToastTipBarView;

public class ActivityTrvSetTemperatureRangeBindingImpl
  extends ActivityTrvSetTemperatureRangeBinding
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
    localSparseIntArray.put(2131364259, 5);
    localSparseIntArray.put(2131363350, 6);
    localSparseIntArray.put(2131361969, 7);
  }
  
  public ActivityTrvSetTemperatureRangeBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 8, p1, p2));
  }
  
  private ActivityTrvSetTemperatureRangeBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 0, (ImageView)paramArrayOfObject[7], (LinearLayout)paramArrayOfObject[6], (ToastTipBarView)paramArrayOfObject[5], (TextView)paramArrayOfObject[4], (TextView)paramArrayOfObject[2], (TextView)paramArrayOfObject[3], (TextView)paramArrayOfObject[1]);
    paramDataBindingComponent = (LinearLayout)paramArrayOfObject[0];
    this.p3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    this.q.setTag(null);
    this.x.setTag(null);
    this.y.setTag(null);
    this.z.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  protected void executeBindings()
  {
    try
    {
      long l = this.H3;
      this.H3 = 0L;
      View.OnClickListener localOnClickListener = this.p0;
      if ((l & 0x3) != 0L)
      {
        this.q.setOnClickListener(localOnClickListener);
        this.x.setOnClickListener(localOnClickListener);
        this.y.setOnClickListener(localOnClickListener);
        this.z.setOnClickListener(localOnClickListener);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable View.OnClickListener paramOnClickListener)
  {
    this.p0 = paramOnClickListener;
    try
    {
      this.H3 |= 1L;
      notifyPropertyChanged(69);
      super.requestRebind();
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
      this.H3 = 2L;
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
    if (69 == paramInt)
    {
      h((View.OnClickListener)paramObject);
      bool = true;
    }
    else
    {
      bool = false;
    }
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityTrvSetTemperatureRangeBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */