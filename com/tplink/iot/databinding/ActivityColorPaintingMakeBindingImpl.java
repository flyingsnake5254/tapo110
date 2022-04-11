package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.Observable;
import androidx.databinding.ObservableInt;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import androidx.lifecycle.LiveData;
import com.tplink.iot.Utils.extension.a;
import com.tplink.iot.devices.lightstrip.viewmodel.effects.ColorPaintingMakeViewModel;
import com.tplink.iot.devices.lightstrip.widget.ColorPaintingSegmentView;
import com.tplink.iot.widget.BrightnessSeekBar;
import com.tplink.iot.widget.ItemSettingLayout;

public class ActivityColorPaintingMakeBindingImpl
  extends ActivityColorPaintingMakeBinding
{
  @Nullable
  private static final SparseIntArray H3;
  @Nullable
  private static final ViewDataBinding.IncludedLayouts p3;
  @NonNull
  private final LinearLayout I3;
  private long J3 = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    H3 = localSparseIntArray;
    localSparseIntArray.put(2131362286, 7);
    localSparseIntArray.put(2131362027, 8);
  }
  
  public ActivityColorPaintingMakeBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 9, p3, H3));
  }
  
  private ActivityColorPaintingMakeBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 2, (BrightnessSeekBar)paramArrayOfObject[8], (Button)paramArrayOfObject[6], (Button)paramArrayOfObject[5], (ColorPaintingSegmentView)paramArrayOfObject[7], (CardView)paramArrayOfObject[2], (ItemSettingLayout)paramArrayOfObject[1], (ImageView)paramArrayOfObject[3], (TextView)paramArrayOfObject[4]);
    this.d.setTag(null);
    this.f.setTag(null);
    this.x.setTag(null);
    this.y.setTag(null);
    this.z.setTag(null);
    paramDataBindingComponent = (LinearLayout)paramArrayOfObject[0];
    this.I3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    this.p0.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  private boolean l(LiveData<String> paramLiveData, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.J3 |= 0x2;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean m(ObservableInt paramObservableInt, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.J3 |= 1L;
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
      long l = this.J3;
      this.J3 = 0L;
      View.OnClickListener localOnClickListener = this.p1;
      Object localObject1 = this.p2;
      int i = 0;
      int j = 0;
      Object localObject2 = null;
      Object localObject3 = localObject2;
      if ((0x1B & l) != 0L)
      {
        int k = j;
        if ((l & 0x19) != 0L)
        {
          if (localObject1 != null) {
            localObject3 = ((ColorPaintingMakeViewModel)localObject1).s();
          } else {
            localObject3 = null;
          }
          updateRegistration(0, (Observable)localObject3);
          k = j;
          if (localObject3 != null) {
            k = ((ObservableInt)localObject3).get();
          }
        }
        i = k;
        localObject3 = localObject2;
        if ((l & 0x1A) != 0L)
        {
          if (localObject1 != null) {
            localObject1 = ((ColorPaintingMakeViewModel)localObject1).n();
          } else {
            localObject1 = null;
          }
          updateLiveDataRegistration(1, (LiveData)localObject1);
          i = k;
          localObject3 = localObject2;
          if (localObject1 != null)
          {
            localObject3 = (String)((LiveData)localObject1).getValue();
            i = k;
          }
        }
      }
      if ((0x14 & l) != 0L)
      {
        this.d.setOnClickListener(localOnClickListener);
        this.f.setOnClickListener(localOnClickListener);
        this.x.setOnClickListener(localOnClickListener);
        this.y.setOnClickListener(localOnClickListener);
      }
      if ((l & 0x1A) != 0L) {
        a.f(this.y, (String)localObject3);
      }
      if ((l & 0x19) != 0L)
      {
        a.e(this.z, i);
        this.p0.setTextColor(i);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable View.OnClickListener paramOnClickListener)
  {
    this.p1 = paramOnClickListener;
    try
    {
      this.J3 |= 0x4;
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
      return this.J3 != 0L;
    }
    finally {}
  }
  
  public void i(@Nullable ColorPaintingMakeViewModel paramColorPaintingMakeViewModel)
  {
    this.p2 = paramColorPaintingMakeViewModel;
    try
    {
      this.J3 |= 0x8;
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
      this.J3 = 16L;
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
      return l((LiveData)paramObject, paramInt2);
    }
    return m((ObservableInt)paramObject, paramInt2);
  }
  
  public boolean setVariable(int paramInt, @Nullable Object paramObject)
  {
    if (69 == paramInt)
    {
      h((View.OnClickListener)paramObject);
    }
    else
    {
      if (103 != paramInt) {
        break label36;
      }
      i((ColorPaintingMakeViewModel)paramObject);
    }
    boolean bool = true;
    return bool;
    label36:
    bool = false;
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityColorPaintingMakeBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */