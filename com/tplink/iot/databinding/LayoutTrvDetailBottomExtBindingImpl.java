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
import com.tplink.iot.devices.trv.viewmodel.TRVDetailViewModel;
import com.tplink.iot.widget.businessview.ThingNextEventView;

public class LayoutTrvDetailBottomExtBindingImpl
  extends LayoutTrvDetailBottomExtBinding
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts H3;
  @Nullable
  private static final SparseIntArray I3;
  @NonNull
  private final LinearLayout J3;
  private long K3 = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    I3 = localSparseIntArray;
    localSparseIntArray.put(2131363330, 7);
    localSparseIntArray.put(2131363331, 8);
    localSparseIntArray.put(2131364208, 9);
  }
  
  public LayoutTrvDetailBottomExtBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 10, H3, I3));
  }
  
  private LayoutTrvDetailBottomExtBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 0, (ImageView)paramArrayOfObject[3], (ImageView)paramArrayOfObject[1], (ImageView)paramArrayOfObject[2], (LinearLayout)paramArrayOfObject[7], (LinearLayout)paramArrayOfObject[8], (ThingNextEventView)paramArrayOfObject[9], (TextView)paramArrayOfObject[6], (TextView)paramArrayOfObject[4], (TextView)paramArrayOfObject[5]);
    this.c.setTag(null);
    this.d.setTag(null);
    this.f.setTag(null);
    paramDataBindingComponent = (LinearLayout)paramArrayOfObject[0];
    this.J3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    this.z.setTag(null);
    this.p0.setTag(null);
    this.p1.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  protected void executeBindings()
  {
    try
    {
      long l = this.K3;
      this.K3 = 0L;
      View.OnClickListener localOnClickListener = this.p2;
      if ((l & 0x6) != 0L)
      {
        this.c.setOnClickListener(localOnClickListener);
        this.d.setOnClickListener(localOnClickListener);
        this.f.setOnClickListener(localOnClickListener);
        this.z.setOnClickListener(localOnClickListener);
        this.p0.setOnClickListener(localOnClickListener);
        this.p1.setOnClickListener(localOnClickListener);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable TRVDetailViewModel paramTRVDetailViewModel)
  {
    this.p3 = paramTRVDetailViewModel;
  }
  
  public boolean hasPendingBindings()
  {
    try
    {
      return this.K3 != 0L;
    }
    finally {}
  }
  
  public void i(@Nullable View.OnClickListener paramOnClickListener)
  {
    this.p2 = paramOnClickListener;
    try
    {
      this.K3 |= 0x2;
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
      this.K3 = 4L;
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\LayoutTrvDetailBottomExtBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */