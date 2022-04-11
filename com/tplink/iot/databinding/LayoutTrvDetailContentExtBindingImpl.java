package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import com.tplink.iot.devices.trv.viewmodel.TRVDetailViewModel;
import com.tplink.iot.widget.trv.TemperatureSlider;
import com.tplink.iot.widget.viewgroup.ToastTipBarView;

public class LayoutTrvDetailContentExtBindingImpl
  extends LayoutTrvDetailContentExtBinding
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts p2;
  @Nullable
  private static final SparseIntArray p3;
  @NonNull
  private final FrameLayout H3;
  private long I3 = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    p3 = localSparseIntArray;
    localSparseIntArray.put(2131364702, 2);
    localSparseIntArray.put(2131364703, 3);
    localSparseIntArray.put(2131364169, 4);
    localSparseIntArray.put(2131363134, 5);
    localSparseIntArray.put(2131364665, 6);
    localSparseIntArray.put(2131364259, 7);
  }
  
  public LayoutTrvDetailContentExtBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 8, p2, p3));
  }
  
  private LayoutTrvDetailContentExtBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 0, (ImageView)paramArrayOfObject[1], (ImageView)paramArrayOfObject[5], (TemperatureSlider)paramArrayOfObject[4], (ToastTipBarView)paramArrayOfObject[7], (TextView)paramArrayOfObject[6], (TextView)paramArrayOfObject[2], (TextView)paramArrayOfObject[3]);
    this.c.setTag(null);
    paramDataBindingComponent = (FrameLayout)paramArrayOfObject[0];
    this.H3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  protected void executeBindings()
  {
    try
    {
      long l = this.I3;
      this.I3 = 0L;
      View.OnClickListener localOnClickListener = this.p0;
      if ((l & 0x6) != 0L) {
        this.c.setOnClickListener(localOnClickListener);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable TRVDetailViewModel paramTRVDetailViewModel)
  {
    this.p1 = paramTRVDetailViewModel;
  }
  
  public boolean hasPendingBindings()
  {
    try
    {
      return this.I3 != 0L;
    }
    finally {}
  }
  
  public void i(@Nullable View.OnClickListener paramOnClickListener)
  {
    this.p0 = paramOnClickListener;
    try
    {
      this.I3 |= 0x2;
      notifyPropertyChanged(69);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void invalidateAll()
  {
    try
    {
      this.I3 = 4L;
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
    if (15 == paramInt)
    {
      h((TRVDetailViewModel)paramObject);
    }
    else
    {
      if (69 != paramInt) {
        break label36;
      }
      i((View.OnClickListener)paramObject);
    }
    boolean bool = true;
    return bool;
    label36:
    bool = false;
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\LayoutTrvDetailContentExtBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */