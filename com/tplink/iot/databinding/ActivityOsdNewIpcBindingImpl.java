package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.Observable;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.tplink.iot.view.ipcamera.base.b;
import com.tplink.iot.view.ipcamera.widget.CameraLoadingView;
import com.tplink.iot.viewmodel.ipcamera.setting.OsdViewModel;
import com.tplink.iot.widget.ErrorBar;

public class ActivityOsdNewIpcBindingImpl
  extends ActivityOsdNewIpcBinding
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts I3;
  @Nullable
  private static final SparseIntArray J3;
  @NonNull
  private final RelativeLayout K3;
  @NonNull
  private final LinearLayout L3;
  @NonNull
  private final LinearLayout M3;
  @NonNull
  private final LinearLayout N3;
  private InverseBindingListener O3 = new a();
  private InverseBindingListener P3 = new b();
  private InverseBindingListener Q3 = new c();
  private InverseBindingListener R3 = new d();
  private long S3 = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    J3 = localSparseIntArray;
    localSparseIntArray.put(2131364275, 10);
    localSparseIntArray.put(2131364252, 11);
    localSparseIntArray.put(2131364667, 12);
    localSparseIntArray.put(2131363381, 13);
  }
  
  public ActivityOsdNewIpcBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 14, I3, J3));
  }
  
  private ActivityOsdNewIpcBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 6, (ConstraintLayout)paramArrayOfObject[5], (CameraLoadingView)paramArrayOfObject[9], (ErrorBar)paramArrayOfObject[13], (TextView)paramArrayOfObject[6], (CheckBox)paramArrayOfObject[1], (CheckBox)paramArrayOfObject[8], (CheckBox)paramArrayOfObject[4], (TextView)paramArrayOfObject[11], (Toolbar)paramArrayOfObject[10], (TextView)paramArrayOfObject[12]);
    this.c.setTag(null);
    this.d.setTag(null);
    paramDataBindingComponent = (RelativeLayout)paramArrayOfObject[0];
    this.K3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (LinearLayout)paramArrayOfObject[2];
    this.L3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (LinearLayout)paramArrayOfObject[3];
    this.M3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (LinearLayout)paramArrayOfObject[7];
    this.N3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    this.q.setTag(null);
    this.x.setTag(null);
    this.y.setTag(null);
    this.z.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  private boolean l(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.S3 |= 0x20;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean m(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.S3 |= 0x4;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean n(ObservableField<String> paramObservableField, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.S3 |= 1L;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean o(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.S3 |= 0x2;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean p(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.S3 |= 0x8;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean q(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.S3 |= 0x10;
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
      long l1 = this.S3;
      this.S3 = 0L;
      View.OnClickListener localOnClickListener = this.H3;
      OsdViewModel localOsdViewModel = this.p3;
      Object localObject1;
      String str;
      label92:
      boolean bool2;
      int i;
      boolean bool3;
      label217:
      label272:
      boolean bool5;
      boolean bool6;
      label409:
      int j;
      boolean bool9;
      boolean bool10;
      if ((0x1BF & l1) != 0L)
      {
        if ((l1 & 0x181) != 0L)
        {
          if (localOsdViewModel != null) {
            localObject1 = localOsdViewModel.d;
          } else {
            localObject1 = null;
          }
          updateRegistration(0, (Observable)localObject1);
          if (localObject1 != null)
          {
            str = (String)((ObservableField)localObject1).get();
            break label92;
          }
        }
        str = null;
        boolean bool1 = (l1 & 0x182) < 0L;
        if (bool1)
        {
          if (localOsdViewModel != null) {
            localObject1 = localOsdViewModel.c;
          } else {
            localObject1 = null;
          }
          updateRegistration(1, (Observable)localObject1);
          if (localObject1 != null) {
            bool2 = ((ObservableBoolean)localObject1).get();
          } else {
            bool2 = false;
          }
          l2 = l1;
          if (bool1)
          {
            if (bool2) {
              l2 = 1024L;
            } else {
              l2 = 512L;
            }
            l2 = l1 | l2;
          }
          if (bool2)
          {
            l1 = l2;
          }
          else
          {
            i = 8;
            bool3 = bool2;
            break label217;
          }
        }
        else
        {
          bool2 = false;
        }
        i = 0;
        bool3 = bool2;
        long l2 = l1;
        if ((l2 & 0x184) != 0L)
        {
          if (localOsdViewModel != null) {
            localObject1 = localOsdViewModel.f;
          } else {
            localObject1 = null;
          }
          updateRegistration(2, (Observable)localObject1);
          if (localObject1 != null)
          {
            bool4 = ((ObservableBoolean)localObject1).get();
            break label272;
          }
        }
        bool4 = false;
        if ((l2 & 0x188) != 0L)
        {
          if (localOsdViewModel != null) {
            localObject1 = localOsdViewModel.a;
          } else {
            localObject1 = null;
          }
          updateRegistration(3, (Observable)localObject1);
          if (localObject1 != null) {
            bool2 = ((ObservableBoolean)localObject1).get();
          } else {
            bool2 = false;
          }
          bool5 = ViewDataBinding.safeUnbox(Boolean.valueOf(bool2));
        }
        else
        {
          bool5 = false;
        }
        Object localObject3;
        if ((l2 & 0x190) != 0L)
        {
          if (localOsdViewModel != null) {
            localObject1 = localOsdViewModel.e;
          } else {
            localObject1 = null;
          }
          updateRegistration(4, (Observable)localObject1);
          localObject3 = localObject1;
          if (localObject1 != null)
          {
            bool6 = ((ObservableBoolean)localObject1).get();
            break label409;
          }
        }
        else
        {
          localObject3 = null;
        }
        bool6 = false;
        localObject1 = localObject3;
        boolean bool7 = (l2 & 0x1B0) < 0L;
        if (bool7)
        {
          if (localOsdViewModel != null) {
            localObject3 = localOsdViewModel.b;
          } else {
            localObject3 = null;
          }
          updateRegistration(5, (Observable)localObject3);
          if (localObject3 != null) {
            bool2 = ((ObservableBoolean)localObject3).get();
          } else {
            bool2 = false;
          }
          l1 = l2;
          if (bool7) {
            if (bool2) {
              l1 = l2 | 0x1000;
            } else {
              l1 = l2 | 0x800;
            }
          }
          l2 = l1;
          if ((l1 & 0x1A0) != 0L)
          {
            if (bool2) {
              l2 = 16384L;
            } else {
              l2 = 8192L;
            }
            l2 = l1 | l2;
          }
          if ((l2 & 0x1A0) != 0L)
          {
            if (bool2) {
              bool7 = false;
            } else {
              j = 8;
            }
            int k = i;
            l1 = l2;
            bool9 = bool3;
            bool10 = bool4;
            i = j;
            j = k;
            break label644;
          }
          l1 = l2;
        }
        else
        {
          bool2 = false;
          l1 = l2;
        }
        j = i;
        i = 0;
        bool9 = bool3;
        bool10 = bool4;
      }
      else
      {
        str = null;
        bool9 = false;
        bool2 = false;
        bool10 = false;
        i = 0;
        j = 0;
        bool5 = false;
        localObject1 = null;
        bool6 = false;
      }
      label644:
      boolean bool4 = bool6;
      if ((l1 & 0x800) != 0L)
      {
        if (localOsdViewModel != null) {
          localObject1 = localOsdViewModel.e;
        }
        updateRegistration(4, (Observable)localObject1);
        bool4 = bool6;
        if (localObject1 != null) {
          bool4 = ((ObservableBoolean)localObject1).get();
        }
      }
      boolean bool8 = (l1 & 0x1B0) < 0L;
      if (bool8)
      {
        if (bool2) {
          bool3 = true;
        } else {
          bool3 = bool4;
        }
      }
      else {
        bool3 = false;
      }
      if ((l1 & 0x140) != 0L) {
        this.c.setOnClickListener(localOnClickListener);
      }
      if ((l1 & 0x182) != 0L)
      {
        this.c.setVisibility(j);
        CompoundButtonBindingAdapter.setChecked(this.z, bool9);
      }
      if ((0x188 & l1) != 0L) {
        b.K(this.d, Boolean.valueOf(bool5));
      }
      if ((l1 & 0x1A0) != 0L)
      {
        this.L3.setVisibility(i);
        CompoundButtonBindingAdapter.setChecked(this.x, bool2);
      }
      if (bool8) {
        b.Q(this.M3, bool3);
      }
      if ((0x190 & l1) != 0L) {
        b.Q(this.N3, bool4);
      }
      if ((l1 & 0x181) != 0L) {
        TextViewBindingAdapter.setText(this.q, str);
      }
      if ((0x100 & l1) != 0L)
      {
        TextViewBindingAdapter.setTextWatcher(this.q, null, null, null, this.O3);
        CompoundButtonBindingAdapter.setListeners(this.x, null, this.P3);
        CompoundButtonBindingAdapter.setListeners(this.y, null, this.Q3);
        CompoundButtonBindingAdapter.setListeners(this.z, null, this.R3);
      }
      if ((l1 & 0x184) != 0L) {
        CompoundButtonBindingAdapter.setChecked(this.y, bool10);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable View.OnClickListener paramOnClickListener)
  {
    this.H3 = paramOnClickListener;
    try
    {
      this.S3 |= 0x40;
      notifyPropertyChanged(2);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public boolean hasPendingBindings()
  {
    try
    {
      return this.S3 != 0L;
    }
    finally {}
  }
  
  public void i(@Nullable OsdViewModel paramOsdViewModel)
  {
    this.p3 = paramOsdViewModel;
    try
    {
      this.S3 |= 0x80;
      notifyPropertyChanged(105);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void invalidateAll()
  {
    try
    {
      this.S3 = 256L;
      requestRebind();
      return;
    }
    finally {}
  }
  
  protected boolean onFieldChange(int paramInt1, Object paramObject, int paramInt2)
  {
    if (paramInt1 != 0)
    {
      if (paramInt1 != 1)
      {
        if (paramInt1 != 2)
        {
          if (paramInt1 != 3)
          {
            if (paramInt1 != 4)
            {
              if (paramInt1 != 5) {
                return false;
              }
              return l((ObservableBoolean)paramObject, paramInt2);
            }
            return q((ObservableBoolean)paramObject, paramInt2);
          }
          return p((ObservableBoolean)paramObject, paramInt2);
        }
        return m((ObservableBoolean)paramObject, paramInt2);
      }
      return o((ObservableBoolean)paramObject, paramInt2);
    }
    return n((ObservableField)paramObject, paramInt2);
  }
  
  public boolean setVariable(int paramInt, @Nullable Object paramObject)
  {
    if (2 == paramInt)
    {
      h((View.OnClickListener)paramObject);
    }
    else
    {
      if (105 != paramInt) {
        break label35;
      }
      i((OsdViewModel)paramObject);
    }
    boolean bool = true;
    return bool;
    label35:
    bool = false;
    return bool;
  }
  
  class a
    implements InverseBindingListener
  {
    a() {}
    
    public void onChange()
    {
      String str = TextViewBindingAdapter.getTextString(ActivityOsdNewIpcBindingImpl.this.q);
      Object localObject = ActivityOsdNewIpcBindingImpl.this.p3;
      int i = 1;
      int j;
      if (localObject != null) {
        j = 1;
      } else {
        j = 0;
      }
      if (j != 0)
      {
        localObject = ((OsdViewModel)localObject).d;
        if (localObject != null) {
          j = i;
        } else {
          j = 0;
        }
        if (j != 0) {
          ((ObservableField)localObject).set(str);
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
      boolean bool = ActivityOsdNewIpcBindingImpl.this.x.isChecked();
      Object localObject = ActivityOsdNewIpcBindingImpl.this.p3;
      int i = 1;
      int j;
      if (localObject != null) {
        j = 1;
      } else {
        j = 0;
      }
      if (j != 0)
      {
        localObject = ((OsdViewModel)localObject).b;
        if (localObject != null) {
          j = i;
        } else {
          j = 0;
        }
        if (j != 0) {
          ((ObservableBoolean)localObject).set(bool);
        }
      }
    }
  }
  
  class c
    implements InverseBindingListener
  {
    c() {}
    
    public void onChange()
    {
      boolean bool = ActivityOsdNewIpcBindingImpl.this.y.isChecked();
      Object localObject = ActivityOsdNewIpcBindingImpl.this.p3;
      int i = 1;
      int j;
      if (localObject != null) {
        j = 1;
      } else {
        j = 0;
      }
      if (j != 0)
      {
        localObject = ((OsdViewModel)localObject).f;
        if (localObject != null) {
          j = i;
        } else {
          j = 0;
        }
        if (j != 0) {
          ((ObservableBoolean)localObject).set(bool);
        }
      }
    }
  }
  
  class d
    implements InverseBindingListener
  {
    d() {}
    
    public void onChange()
    {
      boolean bool = ActivityOsdNewIpcBindingImpl.this.z.isChecked();
      Object localObject = ActivityOsdNewIpcBindingImpl.this.p3;
      int i = 1;
      int j;
      if (localObject != null) {
        j = 1;
      } else {
        j = 0;
      }
      if (j != 0)
      {
        localObject = ((OsdViewModel)localObject).c;
        if (localObject != null) {
          j = i;
        } else {
          j = 0;
        }
        if (j != 0) {
          ((ObservableBoolean)localObject).set(bool);
        }
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityOsdNewIpcBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */