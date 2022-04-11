package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.Utils.extension.a;
import com.tplink.iot.devices.lightstrip.viewmodel.effects.CustomizedEffectsMakeViewModel;
import com.tplink.iot.devices.lightstrip.widget.DiscreteSeekBarTextView;
import com.tplink.iot.devices.lightstrip.widget.multicolorpalette.MultiColorPaletteView;
import com.tplink.iot.widget.BrightnessSeekBar;
import com.tplink.iot.widget.ItemSettingLayout;

public class ActivityCustomizedEffectsMakeBindingImpl
  extends ActivityCustomizedEffectsMakeBinding
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts I3;
  @Nullable
  private static final SparseIntArray J3;
  @NonNull
  private final LinearLayout K3;
  private long L3 = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    J3 = localSparseIntArray;
    localSparseIntArray.put(2131363945, 5);
    localSparseIntArray.put(2131363506, 6);
    localSparseIntArray.put(2131362498, 7);
    localSparseIntArray.put(2131364000, 8);
    localSparseIntArray.put(2131363999, 9);
    localSparseIntArray.put(2131362027, 10);
  }
  
  public ActivityCustomizedEffectsMakeBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 11, I3, J3));
  }
  
  private ActivityCustomizedEffectsMakeBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 1, (BrightnessSeekBar)paramArrayOfObject[10], (Button)paramArrayOfObject[4], (Button)paramArrayOfObject[3], (DiscreteSeekBarTextView)paramArrayOfObject[7], (ItemSettingLayout)paramArrayOfObject[1], (MultiColorPaletteView)paramArrayOfObject[6], (RecyclerView)paramArrayOfObject[5], (SeekBar)paramArrayOfObject[9], (SeekBar)paramArrayOfObject[8], (TextView)paramArrayOfObject[2]);
    this.d.setTag(null);
    this.f.setTag(null);
    this.x.setTag(null);
    paramDataBindingComponent = (LinearLayout)paramArrayOfObject[0];
    this.K3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    this.p2.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  private boolean l(LiveData<String> paramLiveData, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.L3 |= 1L;
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
      long l = this.L3;
      this.L3 = 0L;
      View.OnClickListener localOnClickListener = this.p3;
      Object localObject1 = this.H3;
      Object localObject2 = null;
      boolean bool = (l & 0xD) < 0L;
      Object localObject3 = localObject2;
      if (bool)
      {
        if (localObject1 != null) {
          localObject1 = ((CustomizedEffectsMakeViewModel)localObject1).n();
        } else {
          localObject1 = null;
        }
        updateLiveDataRegistration(0, (LiveData)localObject1);
        localObject3 = localObject2;
        if (localObject1 != null) {
          localObject3 = (String)((LiveData)localObject1).getValue();
        }
      }
      if ((0xA & l) != 0L)
      {
        this.d.setOnClickListener(localOnClickListener);
        this.f.setOnClickListener(localOnClickListener);
        this.x.setOnClickListener(localOnClickListener);
        this.p2.setOnClickListener(localOnClickListener);
      }
      if (bool) {
        a.f(this.x, (String)localObject3);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable View.OnClickListener paramOnClickListener)
  {
    this.p3 = paramOnClickListener;
    try
    {
      this.L3 |= 0x2;
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
      return this.L3 != 0L;
    }
    finally {}
  }
  
  public void i(@Nullable CustomizedEffectsMakeViewModel paramCustomizedEffectsMakeViewModel)
  {
    this.H3 = paramCustomizedEffectsMakeViewModel;
    try
    {
      this.L3 |= 0x4;
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
      this.L3 = 8L;
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
    return l((LiveData)paramObject, paramInt2);
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
      i((CustomizedEffectsMakeViewModel)paramObject);
    }
    boolean bool = true;
    return bool;
    label36:
    bool = false;
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityCustomizedEffectsMakeBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */