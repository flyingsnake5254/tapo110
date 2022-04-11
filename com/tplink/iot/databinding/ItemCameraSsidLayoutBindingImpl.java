package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import androidx.databinding.adapters.TextViewBindingAdapter;

public class ItemCameraSsidLayoutBindingImpl
  extends ItemCameraSsidLayoutBinding
{
  @Nullable
  private static final SparseIntArray p0;
  @Nullable
  private static final ViewDataBinding.IncludedLayouts z;
  private a p1;
  private long p2 = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    p0 = localSparseIntArray;
    localSparseIntArray.put(2131362850, 2);
    localSparseIntArray.put(2131362848, 3);
  }
  
  public ItemCameraSsidLayoutBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 4, z, p0));
  }
  
  private ItemCameraSsidLayoutBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 0, (ImageView)paramArrayOfObject[3], (ImageView)paramArrayOfObject[2], (TextView)paramArrayOfObject[1], (RelativeLayout)paramArrayOfObject[0]);
    this.f.setTag(null);
    this.q.setTag(null);
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
      View.OnClickListener localOnClickListener = this.y;
      String str = this.x;
      boolean bool = (0x5 & l) < 0L;
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
      if ((l & 0x6) != 0L) {
        TextViewBindingAdapter.setText(this.f, str);
      }
      if (bool) {
        this.q.setOnClickListener(locala2);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable View.OnClickListener paramOnClickListener)
  {
    this.y = paramOnClickListener;
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
  
  public void i(@Nullable String paramString)
  {
    this.x = paramString;
    try
    {
      this.p2 |= 0x2;
      notifyPropertyChanged(92);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void invalidateAll()
  {
    try
    {
      this.p2 = 4L;
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
    if (55 == paramInt)
    {
      h((View.OnClickListener)paramObject);
    }
    else
    {
      if (92 != paramInt) {
        break label36;
      }
      i((String)paramObject);
    }
    boolean bool = true;
    return bool;
    label36:
    bool = false;
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ItemCameraSsidLayoutBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */