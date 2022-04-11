package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;

public class ViewFoundedDeviceItemBindingImpl
  extends ViewFoundedDeviceItemBinding
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts y;
  @Nullable
  private static final SparseIntArray z;
  @NonNull
  private final RelativeLayout p0;
  private a p1;
  private long p2 = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    z = localSparseIntArray;
    localSparseIntArray.put(2131362416, 1);
    localSparseIntArray.put(2131363525, 2);
    localSparseIntArray.put(2131363393, 3);
    localSparseIntArray.put(2131362225, 4);
  }
  
  public ViewFoundedDeviceItemBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 5, y, z));
  }
  
  private ViewFoundedDeviceItemBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 0, (CheckBox)paramArrayOfObject[4], (ImageView)paramArrayOfObject[1], (TextView)paramArrayOfObject[3], (TextView)paramArrayOfObject[2]);
    paramDataBindingComponent = (RelativeLayout)paramArrayOfObject[0];
    this.p0 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  protected void executeBindings()
  {
    try
    {
      long l = this.p2;
      this.p2 = 0L;
      a locala1 = null;
      View.OnClickListener localOnClickListener = this.x;
      boolean bool = (l & 0x3) < 0L;
      a locala2 = locala1;
      if (bool)
      {
        locala2 = locala1;
        if (localOnClickListener != null)
        {
          locala1 = this.p1;
          locala2 = locala1;
          if (locala1 == null)
          {
            locala2 = new a();
            this.p1 = locala2;
          }
          locala2 = locala2.a(localOnClickListener);
        }
      }
      if (bool) {
        this.p0.setOnClickListener(locala2);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable View.OnClickListener paramOnClickListener)
  {
    this.x = paramOnClickListener;
    try
    {
      this.p2 |= 1L;
      notifyPropertyChanged(55);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public boolean hasPendingBindings()
  {
    try
    {
      return this.p2 != 0L;
    }
    finally {}
  }
  
  public void invalidateAll()
  {
    try
    {
      this.p2 = 2L;
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
    if (55 == paramInt)
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
  
  public static class a
    implements View.OnClickListener
  {
    private View.OnClickListener c;
    
    public a a(View.OnClickListener paramOnClickListener)
    {
      this.c = paramOnClickListener;
      if (paramOnClickListener == null) {
        paramOnClickListener = null;
      } else {
        paramOnClickListener = this;
      }
      return paramOnClickListener;
    }
    
    public void onClick(View paramView)
    {
      this.c.onClick(paramView);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ViewFoundedDeviceItemBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */