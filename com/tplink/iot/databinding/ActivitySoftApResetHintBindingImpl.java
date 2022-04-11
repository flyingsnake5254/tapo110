package com.tplink.iot.databinding;

import android.content.res.Resources;
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
import androidx.databinding.adapters.TextViewBindingAdapter;

public class ActivitySoftApResetHintBindingImpl
  extends ActivitySoftApResetHintBinding
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
    localSparseIntArray.put(2131364607, 3);
    localSparseIntArray.put(2131362822, 4);
  }
  
  public ActivitySoftApResetHintBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 5, y, z));
  }
  
  private ActivitySoftApResetHintBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 0, (ImageView)paramArrayOfObject[4], (ImageView)paramArrayOfObject[1], (TextView)paramArrayOfObject[2], (TextView)paramArrayOfObject[3]);
    this.d.setTag(null);
    paramDataBindingComponent = (LinearLayout)paramArrayOfObject[0];
    this.p0 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    this.f.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  protected void executeBindings()
  {
    try
    {
      long l = this.p1;
      this.p1 = 0L;
      Object localObject1 = this.x;
      if ((0x3 & l) != 0L) {
        this.d.setOnClickListener((View.OnClickListener)localObject1);
      }
      if ((l & 0x2) != 0L)
      {
        localObject1 = this.f;
        TextViewBindingAdapter.setText((TextView)localObject1, ((TextView)localObject1).getResources().getString(2131953319, new Object[] { Integer.valueOf(5) }));
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
      this.p1 |= 1L;
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
      return this.p1 != 0L;
    }
    finally {}
  }
  
  public void invalidateAll()
  {
    try
    {
      this.p1 = 2L;
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
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivitySoftApResetHintBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */