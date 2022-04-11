package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.Observable;
import androidx.databinding.ObservableInt;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import androidx.databinding.adapters.AbsSpinnerBindingAdapter;
import androidx.databinding.adapters.AdapterViewBindingAdapter;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.tplink.iot.view.iotcommon.DebugFwUpdateViewModel;

public class ActivityDebugFwUpdateBindingImpl
  extends ActivityDebugFwUpdateBinding
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts e4;
  @Nullable
  private static final SparseIntArray f4;
  @NonNull
  private final LinearLayout g4;
  private InverseBindingListener h4 = new a();
  private long i4 = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    f4 = localSparseIntArray;
    localSparseIntArray.put(2131364383, 2);
    localSparseIntArray.put(2131363276, 3);
    localSparseIntArray.put(2131364384, 4);
    localSparseIntArray.put(2131364463, 5);
    localSparseIntArray.put(2131364212, 6);
    localSparseIntArray.put(2131362553, 7);
    localSparseIntArray.put(2131364213, 8);
    localSparseIntArray.put(2131362554, 9);
    localSparseIntArray.put(2131364211, 10);
    localSparseIntArray.put(2131362552, 11);
    localSparseIntArray.put(2131363271, 12);
    localSparseIntArray.put(2131362043, 13);
    localSparseIntArray.put(2131362086, 14);
    localSparseIntArray.put(2131363712, 15);
    localSparseIntArray.put(2131364586, 16);
    localSparseIntArray.put(2131362056, 17);
    localSparseIntArray.put(2131364451, 18);
    localSparseIntArray.put(2131362139, 19);
    localSparseIntArray.put(2131364727, 20);
    localSparseIntArray.put(2131364216, 21);
    localSparseIntArray.put(2131362557, 22);
    localSparseIntArray.put(2131364215, 23);
    localSparseIntArray.put(2131362556, 24);
    localSparseIntArray.put(2131364217, 25);
    localSparseIntArray.put(2131362558, 26);
    localSparseIntArray.put(2131362041, 27);
    localSparseIntArray.put(2131364672, 28);
    localSparseIntArray.put(2131363348, 29);
    localSparseIntArray.put(2131364415, 30);
    localSparseIntArray.put(2131362064, 31);
    localSparseIntArray.put(2131364668, 32);
    localSparseIntArray.put(2131362153, 33);
  }
  
  public ActivityDebugFwUpdateBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 34, e4, f4));
  }
  
  private ActivityDebugFwUpdateBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 1, (Button)paramArrayOfObject[27], (Button)paramArrayOfObject[13], (Button)paramArrayOfObject[17], (Button)paramArrayOfObject[31], (Button)paramArrayOfObject[14], (Button)paramArrayOfObject[19], (Button)paramArrayOfObject[33], (TextInputEditText)paramArrayOfObject[11], (TextInputEditText)paramArrayOfObject[7], (TextInputEditText)paramArrayOfObject[9], (TextInputEditText)paramArrayOfObject[24], (TextInputEditText)paramArrayOfObject[22], (TextInputEditText)paramArrayOfObject[26], (LinearLayout)paramArrayOfObject[12], (LinearLayout)paramArrayOfObject[3], (LinearLayout)paramArrayOfObject[29], (ProgressBar)paramArrayOfObject[15], (Spinner)paramArrayOfObject[1], (TextInputLayout)paramArrayOfObject[10], (TextInputLayout)paramArrayOfObject[6], (TextInputLayout)paramArrayOfObject[8], (TextInputLayout)paramArrayOfObject[23], (TextInputLayout)paramArrayOfObject[21], (TextInputLayout)paramArrayOfObject[25], (TextView)paramArrayOfObject[2], (TextView)paramArrayOfObject[4], (TextView)paramArrayOfObject[30], (TextView)paramArrayOfObject[18], (TextView)paramArrayOfObject[5], (TextView)paramArrayOfObject[16], (TextView)paramArrayOfObject[32], (TextView)paramArrayOfObject[28], (TextView)paramArrayOfObject[20]);
    paramDataBindingComponent = (LinearLayout)paramArrayOfObject[0];
    this.g4 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    this.N3.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  private boolean i(ObservableInt paramObservableInt, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.i4 |= 1L;
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
      long l = this.i4;
      this.i4 = 0L;
      Object localObject1 = this.d4;
      int i = 0;
      boolean bool = (0x7 & l) < 0L;
      int j = i;
      if (bool)
      {
        if (localObject1 != null) {
          localObject1 = ((DebugFwUpdateViewModel)localObject1).i();
        } else {
          localObject1 = null;
        }
        updateRegistration(0, (Observable)localObject1);
        j = i;
        if (localObject1 != null) {
          j = ((ObservableInt)localObject1).get();
        }
      }
      if ((l & 0x4) != 0L)
      {
        AbsSpinnerBindingAdapter.setEntries(this.N3, DebugFwUpdateViewModel.a);
        AdapterViewBindingAdapter.setOnItemSelectedListener(this.N3, null, null, this.h4);
      }
      if (bool) {
        AdapterViewBindingAdapter.setSelectedItemPosition(this.N3, j);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable DebugFwUpdateViewModel paramDebugFwUpdateViewModel)
  {
    this.d4 = paramDebugFwUpdateViewModel;
    try
    {
      this.i4 |= 0x2;
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
      return this.i4 != 0L;
    }
    finally {}
  }
  
  public void invalidateAll()
  {
    try
    {
      this.i4 = 4L;
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
    return i((ObservableInt)paramObject, paramInt2);
  }
  
  public boolean setVariable(int paramInt, @Nullable Object paramObject)
  {
    boolean bool;
    if (103 == paramInt)
    {
      h((DebugFwUpdateViewModel)paramObject);
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
      int i = ActivityDebugFwUpdateBindingImpl.this.N3.getSelectedItemPosition();
      Object localObject = ActivityDebugFwUpdateBindingImpl.this.d4;
      int j = 1;
      int k;
      if (localObject != null) {
        k = 1;
      } else {
        k = 0;
      }
      if (k != 0)
      {
        localObject = ((DebugFwUpdateViewModel)localObject).i();
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityDebugFwUpdateBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */