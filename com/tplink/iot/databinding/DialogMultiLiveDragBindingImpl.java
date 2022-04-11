package com.tplink.iot.databinding;

import android.content.res.Resources;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class DialogMultiLiveDragBindingImpl
  extends DialogMultiLiveDragBinding
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts y;
  @Nullable
  private static final SparseIntArray z;
  @NonNull
  private final TextView p0;
  private long p1 = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    z = localSparseIntArray;
    localSparseIntArray.put(2131363685, 2);
    localSparseIntArray.put(2131362810, 3);
    localSparseIntArray.put(2131363508, 4);
  }
  
  public DialogMultiLiveDragBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 5, y, z));
  }
  
  private DialogMultiLiveDragBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 1, (ConstraintLayout)paramArrayOfObject[0], (ImageView)paramArrayOfObject[3], (ImageView)paramArrayOfObject[4], (View)paramArrayOfObject[2]);
    this.c.setTag(null);
    paramDataBindingComponent = (TextView)paramArrayOfObject[1];
    this.p0 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  private boolean i(MutableLiveData<Boolean> paramMutableLiveData, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.p1 |= 1L;
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
      long l1 = this.p1;
      this.p1 = 0L;
      MutableLiveData localMutableLiveData = this.x;
      Object localObject1 = null;
      Object localObject3 = null;
      boolean bool1 = (l1 & 0x3) < 0L;
      long l2 = l1;
      if (bool1)
      {
        localObject1 = localObject3;
        if (localMutableLiveData != null) {
          localObject1 = (Boolean)localMutableLiveData.getValue();
        }
        boolean bool2 = ViewDataBinding.safeUnbox((Boolean)localObject1);
        l2 = l1;
        if (bool1)
        {
          if (bool2) {
            l2 = 8L;
          } else {
            l2 = 4L;
          }
          l2 = l1 | l2;
        }
        int i;
        if (bool2)
        {
          localObject1 = this.p0.getResources();
          i = 2131953167;
        }
        else
        {
          localObject1 = this.p0.getResources();
          i = 2131953168;
        }
        localObject1 = ((Resources)localObject1).getString(i);
      }
      if ((l2 & 0x3) != 0L) {
        TextViewBindingAdapter.setText(this.p0, (CharSequence)localObject1);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable MutableLiveData<Boolean> paramMutableLiveData)
  {
    updateLiveDataRegistration(0, paramMutableLiveData);
    this.x = paramMutableLiveData;
    try
    {
      this.p1 |= 1L;
      notifyPropertyChanged(43);
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
    if (paramInt1 != 0) {
      return false;
    }
    return i((MutableLiveData)paramObject, paramInt2);
  }
  
  public boolean setVariable(int paramInt, @Nullable Object paramObject)
  {
    boolean bool;
    if (43 == paramInt)
    {
      h((MutableLiveData)paramObject);
      bool = true;
    }
    else
    {
      bool = false;
    }
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\DialogMultiLiveDragBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */