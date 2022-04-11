package com.tplink.iot.databinding;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import androidx.databinding.adapters.ImageViewBindingAdapter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.view.ipcamera.base.b;
import com.tplink.iot.view.ipcamera.widget.CameraLoadingView;
import com.tplink.iot.viewmodel.ipcamera.setting.video.VideoQualityViewModel;

public class ActivityVideoQualityBindingImpl
  extends ActivityVideoQualityBinding
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts p0;
  @Nullable
  private static final SparseIntArray p1;
  private long H3 = -1L;
  @NonNull
  private final ScrollView p2;
  @NonNull
  private final ConstraintLayout p3;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    p1 = localSparseIntArray;
    localSparseIntArray.put(2131364777, 4);
    localSparseIntArray.put(2131364776, 5);
    localSparseIntArray.put(2131363926, 6);
  }
  
  public ActivityVideoQualityBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 7, p0, p1));
  }
  
  private ActivityVideoQualityBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 2, (CameraLoadingView)paramArrayOfObject[3], (RecyclerView)paramArrayOfObject[6], (ImageView)paramArrayOfObject[2], (ImageView)paramArrayOfObject[5], (TextView)paramArrayOfObject[4]);
    this.c.setTag(null);
    paramDataBindingComponent = (ScrollView)paramArrayOfObject[0];
    this.p2 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (ConstraintLayout)paramArrayOfObject[1];
    this.p3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    this.f.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  private boolean l(MutableLiveData<Drawable> paramMutableLiveData, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.H3 |= 1L;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean m(MutableLiveData<Boolean> paramMutableLiveData, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.H3 |= 0x2;
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
      long l = this.H3;
      this.H3 = 0L;
      Object localObject1 = this.y;
      boolean bool1 = false;
      boolean bool2 = false;
      Object localObject2 = null;
      Boolean localBoolean = null;
      if ((0x1B & l) != 0L)
      {
        if ((l & 0x19) != 0L)
        {
          if (localObject1 != null) {
            localObject2 = ((VideoQualityViewModel)localObject1).h();
          } else {
            localObject2 = null;
          }
          updateLiveDataRegistration(0, (LiveData)localObject2);
          if (localObject2 != null)
          {
            localObject2 = (Drawable)((LiveData)localObject2).getValue();
            break label96;
          }
        }
        localObject2 = null;
        label96:
        bool1 = bool2;
        if ((l & 0x1A) != 0L)
        {
          if (localObject1 != null) {
            localObject1 = ((VideoQualityViewModel)localObject1).n();
          } else {
            localObject1 = null;
          }
          updateLiveDataRegistration(1, (LiveData)localObject1);
          if (localObject1 != null) {
            localBoolean = (Boolean)((LiveData)localObject1).getValue();
          }
          bool1 = ViewDataBinding.safeUnbox(localBoolean);
        }
      }
      if ((l & 0x1A) != 0L) {
        b.K(this.c, Boolean.valueOf(bool1));
      }
      if ((l & 0x19) != 0L) {
        ImageViewBindingAdapter.setImageDrawable(this.f, (Drawable)localObject2);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable View.OnClickListener paramOnClickListener)
  {
    this.z = paramOnClickListener;
  }
  
  public boolean hasPendingBindings()
  {
    try
    {
      return this.H3 != 0L;
    }
    finally {}
  }
  
  public void i(@Nullable VideoQualityViewModel paramVideoQualityViewModel)
  {
    this.y = paramVideoQualityViewModel;
    try
    {
      this.H3 |= 0x8;
      notifyPropertyChanged(103);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void invalidateAll()
  {
    try
    {
      this.H3 = 16L;
      requestRebind();
      return;
    }
    finally {}
  }
  
  protected boolean onFieldChange(int paramInt1, Object paramObject, int paramInt2)
  {
    if (paramInt1 != 0)
    {
      if (paramInt1 != 1) {
        return false;
      }
      return m((MutableLiveData)paramObject, paramInt2);
    }
    return l((MutableLiveData)paramObject, paramInt2);
  }
  
  public boolean setVariable(int paramInt, @Nullable Object paramObject)
  {
    if (9 == paramInt)
    {
      h((View.OnClickListener)paramObject);
    }
    else
    {
      if (103 != paramInt) {
        break label36;
      }
      i((VideoQualityViewModel)paramObject);
    }
    boolean bool = true;
    return bool;
    label36:
    bool = false;
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityVideoQualityBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */