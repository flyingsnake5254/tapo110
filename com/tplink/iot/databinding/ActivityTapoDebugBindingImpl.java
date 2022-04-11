package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.Group;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;

public class ActivityTapoDebugBindingImpl
  extends ActivityTapoDebugBinding
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts Q3;
  @Nullable
  private static final SparseIntArray R3;
  @NonNull
  private final LinearLayout S3;
  private long T3 = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    R3 = localSparseIntArray;
    localSparseIntArray.put(2131364478, 7);
    localSparseIntArray.put(2131363356, 8);
    localSparseIntArray.put(2131364697, 9);
    localSparseIntArray.put(2131363295, 10);
    localSparseIntArray.put(2131364491, 11);
    localSparseIntArray.put(2131363344, 12);
    localSparseIntArray.put(2131364664, 13);
    localSparseIntArray.put(2131364477, 14);
    localSparseIntArray.put(2131363307, 15);
    localSparseIntArray.put(2131364519, 16);
    localSparseIntArray.put(2131362729, 17);
    localSparseIntArray.put(2131364476, 18);
  }
  
  public ActivityTapoDebugBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 19, Q3, R3));
  }
  
  private ActivityTapoDebugBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 0, (Button)paramArrayOfObject[4], (Button)paramArrayOfObject[5], (Button)paramArrayOfObject[6], (Button)paramArrayOfObject[3], (Button)paramArrayOfObject[1], (Button)paramArrayOfObject[2], (Group)paramArrayOfObject[17], (LinearLayout)paramArrayOfObject[10], (LinearLayout)paramArrayOfObject[15], (LinearLayout)paramArrayOfObject[12], (LinearLayout)paramArrayOfObject[8], (TextView)paramArrayOfObject[18], (TextView)paramArrayOfObject[14], (TextView)paramArrayOfObject[7], (TextView)paramArrayOfObject[11], (TextView)paramArrayOfObject[16], (TextView)paramArrayOfObject[13], (TextView)paramArrayOfObject[9]);
    this.c.setTag(null);
    this.d.setTag(null);
    this.f.setTag(null);
    this.q.setTag(null);
    this.x.setTag(null);
    this.y.setTag(null);
    paramDataBindingComponent = (LinearLayout)paramArrayOfObject[0];
    this.S3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  protected void executeBindings()
  {
    try
    {
      long l = this.T3;
      this.T3 = 0L;
      View.OnLongClickListener localOnLongClickListener = this.P3;
      View.OnClickListener localOnClickListener = this.O3;
      if ((l & 0x6) != 0L)
      {
        this.c.setOnClickListener(localOnClickListener);
        this.d.setOnClickListener(localOnClickListener);
        this.f.setOnClickListener(localOnClickListener);
        this.x.setOnClickListener(localOnClickListener);
        this.y.setOnClickListener(localOnClickListener);
      }
      if ((0x5 & l) != 0L) {
        this.q.setOnLongClickListener(localOnLongClickListener);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable View.OnClickListener paramOnClickListener)
  {
    this.O3 = paramOnClickListener;
    try
    {
      this.T3 |= 0x2;
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
      return this.T3 != 0L;
    }
    finally {}
  }
  
  public void i(@Nullable View.OnLongClickListener paramOnLongClickListener)
  {
    this.P3 = paramOnLongClickListener;
    try
    {
      this.T3 |= 1L;
      notifyPropertyChanged(71);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void invalidateAll()
  {
    try
    {
      this.T3 = 4L;
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
    if (71 == paramInt)
    {
      i((View.OnLongClickListener)paramObject);
    }
    else
    {
      if (69 != paramInt) {
        break label36;
      }
      h((View.OnClickListener)paramObject);
    }
    boolean bool = true;
    return bool;
    label36:
    bool = false;
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityTapoDebugBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */