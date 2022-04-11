package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableInt;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import com.tplink.iot.view.ipcamera.widget.progressbar.MultiColorSeekBar;
import com.tplink.iot.view.ipcamera.widget.progressbar.a;
import com.tplink.iot.view.ipcamera.widget.touchlayout.TouchListenerConstraintLayout;
import com.tplink.iot.viewmodel.ipcamera.play.TalkViewModel;

public class DialogMicrophoneControlBindingImpl
  extends DialogMicrophoneControlBinding
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
    localSparseIntArray.put(2131364252, 3);
  }
  
  public DialogMicrophoneControlBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 4, z, p0));
  }
  
  private DialogMicrophoneControlBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 2, (TouchListenerConstraintLayout)paramArrayOfObject[0], (TextView)paramArrayOfObject[1], (MultiColorSeekBar)paramArrayOfObject[2], (TextView)paramArrayOfObject[3]);
    this.c.setTag(null);
    this.d.setTag(null);
    this.f.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  private boolean l(ObservableBoolean paramObservableBoolean, int paramInt)
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
  
  private boolean m(ObservableInt paramObservableInt, int paramInt)
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
      ObservableInt localObservableInt = null;
      ObservableBoolean localObservableBoolean = this.x;
      TalkViewModel localTalkViewModel = this.y;
      int i = 0;
      boolean bool1 = (l1 & 0xA) < 0L;
      boolean bool2;
      long l2;
      if (bool1)
      {
        if (localObservableBoolean != null) {
          bool2 = localObservableBoolean.get();
        } else {
          bool2 = false;
        }
        l2 = l1;
        if (bool1)
        {
          if (bool2) {
            l2 = 32L;
          } else {
            l2 = 16L;
          }
          l2 = l1 | l2;
        }
        if (!bool2)
        {
          j = 4;
          break label118;
        }
      }
      else
      {
        bool2 = false;
        l2 = l1;
      }
      int j = 0;
      label118:
      boolean bool3 = (0xD & l2) < 0L;
      int k = i;
      if (bool3)
      {
        if (localTalkViewModel != null) {
          localObservableInt = localTalkViewModel.e;
        }
        updateRegistration(0, localObservableInt);
        k = i;
        if (localObservableInt != null) {
          k = localObservableInt.get();
        }
      }
      if ((l2 & 0xA) != 0L)
      {
        this.d.setVisibility(j);
        a.c(this.f, bool2);
      }
      if (bool3) {
        a.d(this.f, k);
      }
      if ((l2 & 0x8) != 0L) {
        a.e(this.f, this.p2, this.p1);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable ObservableBoolean paramObservableBoolean)
  {
    updateRegistration(1, paramObservableBoolean);
    this.x = paramObservableBoolean;
    try
    {
      this.p3 |= 0x2;
      notifyPropertyChanged(84);
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
  
  public void i(@Nullable TalkViewModel paramTalkViewModel)
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
      return l((ObservableBoolean)paramObject, paramInt2);
    }
    return m((ObservableInt)paramObject, paramInt2);
  }
  
  public boolean setVariable(int paramInt, @Nullable Object paramObject)
  {
    if (84 == paramInt)
    {
      h((ObservableBoolean)paramObject);
    }
    else
    {
      if (103 != paramInt) {
        break label36;
      }
      i((TalkViewModel)paramObject);
    }
    boolean bool = true;
    return bool;
    label36:
    bool = false;
    return bool;
  }
  
  class a
    implements InverseBindingListener
  {
    a() {}
    
    public void onChange()
    {
      boolean bool = a.a(DialogMicrophoneControlBindingImpl.this.f);
      ObservableBoolean localObservableBoolean = DialogMicrophoneControlBindingImpl.this.x;
      int i;
      if (localObservableBoolean != null) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        localObservableBoolean.set(bool);
      }
    }
  }
  
  class b
    implements InverseBindingListener
  {
    b() {}
    
    public void onChange()
    {
      int i = a.b(DialogMicrophoneControlBindingImpl.this.f);
      Object localObject = DialogMicrophoneControlBindingImpl.this.y;
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
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\DialogMicrophoneControlBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */