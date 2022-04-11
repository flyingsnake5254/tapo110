package com.tplink.iot.databinding;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import androidx.databinding.adapters.ImageViewBindingAdapter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tplink.libtpcontrols.tprefreshablebutton.TPRefreshableButton;

public class ActivityCameraCloudConnectBindingImpl
  extends ActivityCameraCloudConnectBinding
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts y;
  @Nullable
  private static final SparseIntArray z;
  @NonNull
  private final LinearLayout p0;
  @NonNull
  private final ImageView p1;
  private long p2 = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    z = localSparseIntArray;
    localSparseIntArray.put(2131362826, 2);
    localSparseIntArray.put(2131363277, 3);
    localSparseIntArray.put(2131364453, 4);
    localSparseIntArray.put(2131362042, 5);
  }
  
  public ActivityCameraCloudConnectBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 6, y, z));
  }
  
  private ActivityCameraCloudConnectBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 1, (TPRefreshableButton)paramArrayOfObject[5], (ImageView)paramArrayOfObject[2], (LinearLayout)paramArrayOfObject[3], (TextView)paramArrayOfObject[4]);
    paramDataBindingComponent = (LinearLayout)paramArrayOfObject[0];
    this.p0 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (ImageView)paramArrayOfObject[1];
    this.p1 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  private boolean i(MutableLiveData<Boolean> paramMutableLiveData, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.p2 |= 1L;
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
      long l1 = this.p2;
      this.p2 = 0L;
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
          localObject1 = this.p1.getContext();
          i = 2131230938;
        }
        else
        {
          localObject1 = this.p1.getContext();
          i = 2131230937;
        }
        localObject1 = AppCompatResources.getDrawable((Context)localObject1, i);
      }
      if ((l2 & 0x3) != 0L) {
        ImageViewBindingAdapter.setImageDrawable(this.p1, (Drawable)localObject1);
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
      this.p2 |= 1L;
      notifyPropertyChanged(12);
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
    if (paramInt1 != 0) {
      return false;
    }
    return i((MutableLiveData)paramObject, paramInt2);
  }
  
  public boolean setVariable(int paramInt, @Nullable Object paramObject)
  {
    boolean bool;
    if (12 == paramInt)
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityCameraCloudConnectBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */