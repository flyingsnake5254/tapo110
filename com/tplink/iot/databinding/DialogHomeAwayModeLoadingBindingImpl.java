package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import androidx.databinding.adapters.TextViewBindingAdapter;

public class DialogHomeAwayModeLoadingBindingImpl
  extends DialogHomeAwayModeLoadingBinding
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts x;
  @Nullable
  private static final SparseIntArray y;
  private long p0 = -1L;
  @NonNull
  private final LinearLayout z;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    y = localSparseIntArray;
    localSparseIntArray.put(2131363465, 2);
    localSparseIntArray.put(2131362406, 3);
  }
  
  public DialogHomeAwayModeLoadingBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 4, x, y));
  }
  
  private DialogHomeAwayModeLoadingBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 1, (ImageView)paramArrayOfObject[3], (TextView)paramArrayOfObject[1], (LinearLayout)paramArrayOfObject[2]);
    this.d.setTag(null);
    paramDataBindingComponent = (LinearLayout)paramArrayOfObject[0];
    this.z = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  private boolean h(ObservableField<String> paramObservableField, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.p0 |= 1L;
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
      long l = this.p0;
      this.p0 = 0L;
      ObservableField localObservableField = this.q;
      Object localObject1 = null;
      boolean bool = (l & 0x3) < 0L;
      Object localObject2 = localObject1;
      if (bool)
      {
        localObject2 = localObject1;
        if (localObservableField != null) {
          localObject2 = (String)localObservableField.get();
        }
      }
      if (bool) {
        TextViewBindingAdapter.setText(this.d, (CharSequence)localObject2);
      }
      return;
    }
    finally {}
  }
  
  public boolean hasPendingBindings()
  {
    try
    {
      return this.p0 != 0L;
    }
    finally {}
  }
  
  public void i(@Nullable ObservableField<String> paramObservableField)
  {
    updateRegistration(0, paramObservableField);
    this.q = paramObservableField;
    try
    {
      this.p0 |= 1L;
      notifyPropertyChanged(98);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void invalidateAll()
  {
    try
    {
      this.p0 = 2L;
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
    return h((ObservableField)paramObject, paramInt2);
  }
  
  public boolean setVariable(int paramInt, @Nullable Object paramObject)
  {
    boolean bool;
    if (98 == paramInt)
    {
      i((ObservableField)paramObject);
      bool = true;
    }
    else
    {
      bool = false;
    }
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\DialogHomeAwayModeLoadingBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */