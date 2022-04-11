package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.tplink.iot.viewmodel.login.a;

public class ItemRegionListTitleBindingImpl
  extends ItemRegionListTitleBinding
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts d;
  @Nullable
  private static final SparseIntArray f;
  @NonNull
  private final LinearLayout q;
  @NonNull
  private final TextView x;
  private long y = -1L;
  
  public ItemRegionListTitleBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 2, d, f));
  }
  
  private ItemRegionListTitleBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 1);
    paramDataBindingComponent = (LinearLayout)paramArrayOfObject[0];
    this.q = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (TextView)paramArrayOfObject[1];
    this.x = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  private boolean i(ObservableField<String> paramObservableField, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.y |= 1L;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  protected void executeBindings()
  {
    try
    {
      long l = this.y;
      this.y = 0L;
      Object localObject1 = this.c;
      Object localObject2 = null;
      boolean bool = (l & 0x7) < 0L;
      Object localObject3 = localObject2;
      if (bool)
      {
        if (localObject1 != null) {
          localObject1 = ((a)localObject1).a;
        } else {
          localObject1 = null;
        }
        updateRegistration(0, (Observable)localObject1);
        localObject3 = localObject2;
        if (localObject1 != null) {
          localObject3 = (String)((ObservableField)localObject1).get();
        }
      }
      if (bool) {
        TextViewBindingAdapter.setText(this.x, (CharSequence)localObject3);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable a parama)
  {
    this.c = parama;
    try
    {
      this.y |= 0x2;
      notifyPropertyChanged(105);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public boolean hasPendingBindings()
  {
    try
    {
      return this.y != 0L;
    }
    finally {}
  }
  
  public void invalidateAll()
  {
    try
    {
      this.y = 4L;
      requestRebind();
      return;
    }
    finally {}
  }
  
  protected boolean onFieldChange(int paramInt1, Object paramObject, int paramInt2)
  {
    if (paramInt1 != 0) {
      return false;
    }
    return i((ObservableField)paramObject, paramInt2);
  }
  
  public boolean setVariable(int paramInt, @Nullable Object paramObject)
  {
    boolean bool;
    if (105 == paramInt)
    {
      h((a)paramObject);
      bool = true;
    }
    else
    {
      bool = false;
    }
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ItemRegionListTitleBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */