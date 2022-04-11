package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import androidx.databinding.adapters.SeekBarBindingAdapter;
import androidx.databinding.adapters.SeekBarBindingAdapter.OnStopTrackingTouch;
import androidx.lifecycle.LiveData;
import com.tplink.iot.view.ipcamera.widget.touchlayout.TouchListenerCardView;

public class ViewCloudTerraceControlSensitivityPanelBindingImpl
  extends ViewCloudTerraceControlSensitivityPanelBinding
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts p0;
  @Nullable
  private static final SparseIntArray p1;
  private OnStopTrackingTouchImpl p2;
  private long p3 = -1L;
  
  public ViewCloudTerraceControlSensitivityPanelBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 5, p0, p1));
  }
  
  private ViewCloudTerraceControlSensitivityPanelBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 1, (TouchListenerCardView)paramArrayOfObject[0], (SeekBar)paramArrayOfObject[4], (TextView)paramArrayOfObject[3], (TextView)paramArrayOfObject[1], (TextView)paramArrayOfObject[2]);
    this.c.setTag(null);
    this.d.setTag(null);
    this.f.setTag(null);
    this.q.setTag(null);
    this.x.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  private boolean l(LiveData<Integer> paramLiveData, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.p3 |= 1L;
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
      long l1 = this.p3;
      this.p3 = 0L;
      Object localObject1 = this.y;
      SeekBarBindingAdapter.OnStopTrackingTouch localOnStopTrackingTouch = this.z;
      int i = 0;
      int j = 0;
      int k = (l1 & 0x5) < 0L;
      int m;
      int n;
      long l2;
      if (k != 0)
      {
        if (localObject1 != null) {
          localObject1 = (Integer)((LiveData)localObject1).getValue();
        } else {
          localObject1 = null;
        }
        m = ViewDataBinding.safeUnbox((Integer)localObject1);
        if (m == 50) {
          i = 1;
        } else {
          i = 0;
        }
        if (m == 0) {
          n = 1;
        } else {
          n = 0;
        }
        if (m == 100) {
          j = 1;
        }
        l2 = l1;
        if (k != 0)
        {
          if (i != 0) {
            l2 = 64L;
          } else {
            l2 = 32L;
          }
          l2 = l1 | l2;
        }
        l1 = l2;
        if ((l2 & 0x5) != 0L)
        {
          if (n != 0) {
            l1 = 16L;
          } else {
            l1 = 8L;
          }
          l1 = l2 | l1;
        }
        l2 = l1;
        if ((l1 & 0x5) != 0L)
        {
          if (j != 0) {
            l2 = 256L;
          } else {
            l2 = 128L;
          }
          l2 = l1 | l2;
        }
        if (i != 0) {
          i = ViewDataBinding.getColorFromResource(this.x, 2131099808);
        } else {
          i = ViewDataBinding.getColorFromResource(this.x, 2131099806);
        }
        if (n != 0) {
          n = ViewDataBinding.getColorFromResource(this.q, 2131099808);
        } else {
          n = ViewDataBinding.getColorFromResource(this.q, 2131099806);
        }
        if (j != 0) {
          j = ViewDataBinding.getColorFromResource(this.f, 2131099808);
        } else {
          j = ViewDataBinding.getColorFromResource(this.f, 2131099806);
        }
        k = n;
        n = i;
        i = k;
      }
      else
      {
        m = 0;
        n = 0;
        j = 0;
        l2 = l1;
      }
      k = (0x6 & l2) < 0L;
      if ((k != 0) && (localOnStopTrackingTouch != null))
      {
        OnStopTrackingTouchImpl localOnStopTrackingTouchImpl = this.p2;
        localObject1 = localOnStopTrackingTouchImpl;
        if (localOnStopTrackingTouchImpl == null)
        {
          localObject1 = new OnStopTrackingTouchImpl();
          this.p2 = ((OnStopTrackingTouchImpl)localObject1);
        }
        localObject1 = ((OnStopTrackingTouchImpl)localObject1).a(localOnStopTrackingTouch);
      }
      else
      {
        localObject1 = null;
      }
      if ((l2 & 0x5) != 0L)
      {
        SeekBarBindingAdapter.setProgress(this.d, m);
        this.f.setTextColor(j);
        this.q.setTextColor(i);
        this.x.setTextColor(n);
      }
      if (k != 0) {
        SeekBarBindingAdapter.setOnSeekBarChangeListener(this.d, null, (SeekBarBindingAdapter.OnStopTrackingTouch)localObject1, null, null);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable LiveData<Integer> paramLiveData)
  {
    updateLiveDataRegistration(0, paramLiveData);
    this.y = paramLiveData;
    try
    {
      this.p3 |= 1L;
      notifyPropertyChanged(88);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public boolean hasPendingBindings()
  {
    try
    {
      return this.p3 != 0L;
    }
    finally {}
  }
  
  public void i(@Nullable SeekBarBindingAdapter.OnStopTrackingTouch paramOnStopTrackingTouch)
  {
    this.z = paramOnStopTrackingTouch;
    try
    {
      this.p3 |= 0x2;
      notifyPropertyChanged(93);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void invalidateAll()
  {
    try
    {
      this.p3 = 4L;
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
    if (88 == paramInt)
    {
      h((LiveData)paramObject);
    }
    else
    {
      if (93 != paramInt) {
        break label36;
      }
      i((SeekBarBindingAdapter.OnStopTrackingTouch)paramObject);
    }
    boolean bool = true;
    return bool;
    label36:
    bool = false;
    return bool;
  }
  
  public static class OnStopTrackingTouchImpl
    implements SeekBarBindingAdapter.OnStopTrackingTouch
  {
    private SeekBarBindingAdapter.OnStopTrackingTouch c;
    
    public OnStopTrackingTouchImpl a(SeekBarBindingAdapter.OnStopTrackingTouch paramOnStopTrackingTouch)
    {
      this.c = paramOnStopTrackingTouch;
      if (paramOnStopTrackingTouch == null) {
        paramOnStopTrackingTouch = null;
      } else {
        paramOnStopTrackingTouch = this;
      }
      return paramOnStopTrackingTouch;
    }
    
    public void onStopTrackingTouch(SeekBar paramSeekBar)
    {
      this.c.onStopTrackingTouch(paramSeekBar);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ViewCloudTerraceControlSensitivityPanelBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */