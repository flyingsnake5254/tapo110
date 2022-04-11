package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.ObservableInt;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import androidx.databinding.adapters.SeekBarBindingAdapter;
import com.tplink.iot.view.ipcamera.widget.touchlayout.TouchListenerConstraintLayout;
import com.tplink.iot.viewmodel.ipcamera.play.TalkViewModel;

public class DialogVolumeControlBindingImpl
  extends DialogVolumeControlBinding
{
  @Nullable
  private static final SparseIntArray p0;
  @Nullable
  private static final ViewDataBinding.IncludedLayouts z;
  private InverseBindingListener p1 = new a();
  private InverseBindingListener p2 = new b();
  private long p3 = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    p0 = localSparseIntArray;
    localSparseIntArray.put(2131364190, 3);
    localSparseIntArray.put(2131364188, 4);
  }
  
  public DialogVolumeControlBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 5, z, p0));
  }
  
  private DialogVolumeControlBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 2, (TouchListenerConstraintLayout)paramArrayOfObject[0], (SeekBar)paramArrayOfObject[2], (SeekBar)paramArrayOfObject[1], (TextView)paramArrayOfObject[4], (TextView)paramArrayOfObject[3]);
    this.c.setTag(null);
    this.d.setTag(null);
    this.f.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  private boolean i(ObservableInt paramObservableInt, int paramInt)
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
  
  private boolean l(ObservableInt paramObservableInt, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.p3 |= 0x2;
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
      long l = this.p3;
      this.p3 = 0L;
      TalkViewModel localTalkViewModel = this.y;
      int i = 0;
      if ((0xF & l) != 0L)
      {
        ObservableInt localObservableInt;
        if ((l & 0xD) != 0L)
        {
          if (localTalkViewModel != null) {
            localObservableInt = localTalkViewModel.e;
          } else {
            localObservableInt = null;
          }
          updateRegistration(0, localObservableInt);
          if (localObservableInt != null)
          {
            i = localObservableInt.get();
            break label84;
          }
        }
        i = 0;
        label84:
        if ((l & 0xE) != 0L)
        {
          if (localTalkViewModel != null) {
            localObservableInt = localTalkViewModel.f;
          } else {
            localObservableInt = null;
          }
          updateRegistration(1, localObservableInt);
          if (localObservableInt != null)
          {
            j = localObservableInt.get();
            break label136;
          }
        }
      }
      int j = 0;
      label136:
      if ((l & 0xD) != 0L) {
        SeekBarBindingAdapter.setProgress(this.d, i);
      }
      if ((0x8 & l) != 0L)
      {
        SeekBarBindingAdapter.setOnSeekBarChangeListener(this.d, null, null, null, this.p1);
        SeekBarBindingAdapter.setOnSeekBarChangeListener(this.f, null, null, null, this.p2);
      }
      if ((l & 0xE) != 0L) {
        SeekBarBindingAdapter.setProgress(this.f, j);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable TalkViewModel paramTalkViewModel)
  {
    this.y = paramTalkViewModel;
    try
    {
      this.p3 |= 0x4;
      notifyPropertyChanged(103);
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
  
  public void invalidateAll()
  {
    try
    {
      this.p3 = 8L;
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
      return l((ObservableInt)paramObject, paramInt2);
    }
    return i((ObservableInt)paramObject, paramInt2);
  }
  
  public boolean setVariable(int paramInt, @Nullable Object paramObject)
  {
    boolean bool;
    if (103 == paramInt)
    {
      h((TalkViewModel)paramObject);
      bool = true;
    }
    else
    {
      bool = false;
    }
    return bool;
  }
  
  class a
    implements InverseBindingListener
  {
    a() {}
    
    public void onChange()
    {
      int i = DialogVolumeControlBindingImpl.this.d.getProgress();
      Object localObject = DialogVolumeControlBindingImpl.this.y;
      int j = 1;
      int k;
      if (localObject != null) {
        k = 1;
      } else {
        k = 0;
      }
      if (k != 0)
      {
        localObject = ((TalkViewModel)localObject).e;
        if (localObject != null) {
          k = j;
        } else {
          k = 0;
        }
        if (k != 0) {
          ((ObservableInt)localObject).set(i);
        }
      }
    }
  }
  
  class b
    implements InverseBindingListener
  {
    b() {}
    
    public void onChange()
    {
      int i = DialogVolumeControlBindingImpl.this.f.getProgress();
      Object localObject = DialogVolumeControlBindingImpl.this.y;
      int j = 1;
      int k;
      if (localObject != null) {
        k = 1;
      } else {
        k = 0;
      }
      if (k != 0)
      {
        localObject = ((TalkViewModel)localObject).f;
        if (localObject != null) {
          k = j;
        } else {
          k = 0;
        }
        if (k != 0) {
          ((ObservableInt)localObject).set(i);
        }
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\DialogVolumeControlBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */