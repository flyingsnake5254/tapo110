package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.generated.callback.a;
import com.tplink.iot.generated.callback.a.a;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.ipcamera.memories.MemoriesFilterViewModel;

public class ActivityMemoriesFilterBindingImpl
  extends ActivityMemoriesFilterBinding
  implements a.a
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts R3;
  @Nullable
  private static final SparseIntArray S3;
  @NonNull
  private final RelativeLayout T3;
  @NonNull
  private final LinearLayout U3;
  @Nullable
  private final View.OnClickListener V3;
  @Nullable
  private final View.OnClickListener W3;
  @Nullable
  private final View.OnClickListener X3;
  @Nullable
  private final View.OnClickListener Y3;
  @Nullable
  private final View.OnClickListener Z3;
  @Nullable
  private final View.OnClickListener a4;
  private InverseBindingListener b4 = new a();
  private InverseBindingListener c4 = new b();
  private InverseBindingListener d4 = new c();
  private InverseBindingListener e4 = new d();
  private InverseBindingListener f4 = new e();
  private long g4 = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    S3 = localSparseIntArray;
    localSparseIntArray.put(2131364275, 13);
    localSparseIntArray.put(2131362640, 14);
    localSparseIntArray.put(2131362641, 15);
    localSparseIntArray.put(2131362810, 16);
    localSparseIntArray.put(2131364760, 17);
    localSparseIntArray.put(2131364372, 18);
    localSparseIntArray.put(2131362620, 19);
    localSparseIntArray.put(2131364740, 20);
  }
  
  public ActivityMemoriesFilterBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 21, R3, S3));
  }
  
  private ActivityMemoriesFilterBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 6, (Button)paramArrayOfObject[12], (CheckBox)paramArrayOfObject[7], (RelativeLayout)paramArrayOfObject[6], (TextView)paramArrayOfObject[19], (RadioButton)paramArrayOfObject[9], (RelativeLayout)paramArrayOfObject[8], (TextView)paramArrayOfObject[14], (RecyclerView)paramArrayOfObject[15], (TextView)paramArrayOfObject[16], (CheckBox)paramArrayOfObject[3], (RelativeLayout)paramArrayOfObject[2], (View)paramArrayOfObject[13], (TextView)paramArrayOfObject[18], (TextView)paramArrayOfObject[20], (RadioButton)paramArrayOfObject[11], (RelativeLayout)paramArrayOfObject[10], (TextView)paramArrayOfObject[17], (CheckBox)paramArrayOfObject[5], (RelativeLayout)paramArrayOfObject[4]);
    this.c.setTag(null);
    this.d.setTag(null);
    this.f.setTag(null);
    this.x.setTag(null);
    this.y.setTag(null);
    this.p2.setTag(null);
    this.p3.setTag(null);
    paramDataBindingComponent = (RelativeLayout)paramArrayOfObject[0];
    this.T3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (LinearLayout)paramArrayOfObject[1];
    this.U3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    this.K3.setTag(null);
    this.L3.setTag(null);
    this.N3.setTag(null);
    this.O3.setTag(null);
    setRootTag(paramView);
    this.V3 = new a(this, 3);
    this.W3 = new a(this, 4);
    this.X3 = new a(this, 5);
    this.Y3 = new a(this, 1);
    this.Z3 = new a(this, 2);
    this.a4 = new a(this, 6);
    invalidateAll();
  }
  
  private boolean l(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.g4 |= 0x4;
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
        this.g4 |= 0x8;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean n(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.g4 |= 0x2;
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
        this.g4 |= 1L;
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
        this.g4 |= 0x10;
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
        this.g4 |= 0x20;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  public final void d(int paramInt, View paramView)
  {
    int i = 1;
    int j = 1;
    int k = 1;
    int m = 1;
    int n = 1;
    int i1 = 1;
    g localg;
    switch (paramInt)
    {
    default: 
      break;
    case 6: 
      localg = this.P3;
      if (localg != null) {
        paramInt = i1;
      } else {
        paramInt = 0;
      }
      if (paramInt != 0) {
        localg.onClick(paramView);
      }
      break;
    case 5: 
      localg = this.P3;
      if (localg != null) {
        paramInt = i;
      } else {
        paramInt = 0;
      }
      if (paramInt != 0) {
        localg.onClick(paramView);
      }
      break;
    case 4: 
      localg = this.P3;
      if (localg != null) {
        paramInt = j;
      } else {
        paramInt = 0;
      }
      if (paramInt != 0) {
        localg.onClick(paramView);
      }
      break;
    case 3: 
      localg = this.P3;
      if (localg != null) {
        paramInt = k;
      } else {
        paramInt = 0;
      }
      if (paramInt != 0) {
        localg.onClick(paramView);
      }
      break;
    case 2: 
      localg = this.P3;
      if (localg != null) {
        paramInt = m;
      } else {
        paramInt = 0;
      }
      if (paramInt != 0) {
        localg.onClick(paramView);
      }
      break;
    case 1: 
      localg = this.P3;
      if (localg != null) {
        paramInt = n;
      } else {
        paramInt = 0;
      }
      if (paramInt != 0) {
        localg.onClick(paramView);
      }
      break;
    }
  }
  
  protected void executeBindings()
  {
    try
    {
      long l1 = this.g4;
      this.g4 = 0L;
      MemoriesFilterViewModel localMemoriesFilterViewModel = this.Q3;
      boolean bool1;
      label81:
      long l2;
      boolean bool3;
      int i;
      label190:
      boolean bool4;
      label243:
      label296:
      boolean bool5;
      label349:
      boolean bool6;
      if ((0x1BF & l1) != 0L)
      {
        ObservableBoolean localObservableBoolean;
        if ((l1 & 0x181) != 0L)
        {
          if (localMemoriesFilterViewModel != null) {
            localObservableBoolean = localMemoriesFilterViewModel.c;
          } else {
            localObservableBoolean = null;
          }
          updateRegistration(0, localObservableBoolean);
          if (localObservableBoolean != null)
          {
            bool1 = localObservableBoolean.get();
            break label81;
          }
        }
        bool1 = false;
        boolean bool2 = (l1 & 0x182) < 0L;
        l2 = l1;
        if (bool2)
        {
          if (localMemoriesFilterViewModel != null) {
            localObservableBoolean = localMemoriesFilterViewModel.h;
          } else {
            localObservableBoolean = null;
          }
          updateRegistration(1, localObservableBoolean);
          if (localObservableBoolean != null) {
            bool3 = localObservableBoolean.get();
          } else {
            bool3 = false;
          }
          l2 = l1;
          if (bool2)
          {
            if (bool3) {
              l2 = 1024L;
            } else {
              l2 = 512L;
            }
            l2 = l1 | l2;
          }
          if (!bool3)
          {
            i = 8;
            break label190;
          }
        }
        i = 0;
        if ((l2 & 0x184) != 0L)
        {
          if (localMemoriesFilterViewModel != null) {
            localObservableBoolean = localMemoriesFilterViewModel.e;
          } else {
            localObservableBoolean = null;
          }
          updateRegistration(2, localObservableBoolean);
          if (localObservableBoolean != null)
          {
            bool4 = localObservableBoolean.get();
            break label243;
          }
        }
        bool4 = false;
        if ((l2 & 0x188) != 0L)
        {
          if (localMemoriesFilterViewModel != null) {
            localObservableBoolean = localMemoriesFilterViewModel.f;
          } else {
            localObservableBoolean = null;
          }
          updateRegistration(3, localObservableBoolean);
          if (localObservableBoolean != null)
          {
            bool3 = localObservableBoolean.get();
            break label296;
          }
        }
        bool3 = false;
        if ((l2 & 0x190) != 0L)
        {
          if (localMemoriesFilterViewModel != null) {
            localObservableBoolean = localMemoriesFilterViewModel.g;
          } else {
            localObservableBoolean = null;
          }
          updateRegistration(4, localObservableBoolean);
          if (localObservableBoolean != null)
          {
            bool5 = localObservableBoolean.get();
            break label349;
          }
        }
        bool5 = false;
        if ((l2 & 0x1A0) != 0L)
        {
          if (localMemoriesFilterViewModel != null) {
            localObservableBoolean = localMemoriesFilterViewModel.d;
          } else {
            localObservableBoolean = null;
          }
          updateRegistration(5, localObservableBoolean);
          if (localObservableBoolean != null)
          {
            bool6 = localObservableBoolean.get();
            break label426;
          }
        }
        bool6 = false;
      }
      else
      {
        bool6 = false;
        bool1 = false;
        i = 0;
        bool4 = false;
        bool5 = false;
        bool3 = false;
        l2 = l1;
      }
      label426:
      if ((l2 & 0x100) != 0L)
      {
        this.c.setOnClickListener(this.a4);
        CompoundButtonBindingAdapter.setListeners(this.d, null, this.b4);
        this.f.setOnClickListener(this.V3);
        CompoundButtonBindingAdapter.setListeners(this.x, null, this.c4);
        this.y.setOnClickListener(this.W3);
        CompoundButtonBindingAdapter.setListeners(this.p2, null, this.d4);
        this.p3.setOnClickListener(this.Y3);
        CompoundButtonBindingAdapter.setListeners(this.K3, null, this.e4);
        this.L3.setOnClickListener(this.X3);
        CompoundButtonBindingAdapter.setListeners(this.N3, null, this.f4);
        this.O3.setOnClickListener(this.Z3);
      }
      if ((l2 & 0x184) != 0L) {
        CompoundButtonBindingAdapter.setChecked(this.d, bool4);
      }
      if ((l2 & 0x188) != 0L) {
        CompoundButtonBindingAdapter.setChecked(this.x, bool3);
      }
      if ((l2 & 0x181) != 0L) {
        CompoundButtonBindingAdapter.setChecked(this.p2, bool1);
      }
      if ((0x182 & l2) != 0L) {
        this.U3.setVisibility(i);
      }
      if ((0x190 & l2) != 0L) {
        CompoundButtonBindingAdapter.setChecked(this.K3, bool5);
      }
      if ((l2 & 0x1A0) != 0L) {
        CompoundButtonBindingAdapter.setChecked(this.N3, bool6);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable MemoriesFilterViewModel paramMemoriesFilterViewModel)
  {
    this.Q3 = paramMemoriesFilterViewModel;
    try
    {
      this.g4 |= 0x80;
      notifyPropertyChanged(61);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public boolean hasPendingBindings()
  {
    try
    {
      return this.g4 != 0L;
    }
    finally {}
  }
  
  public void i(@Nullable g paramg)
  {
    this.P3 = paramg;
    try
    {
      this.g4 |= 0x40;
      notifyPropertyChanged(79);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void invalidateAll()
  {
    try
    {
      this.g4 = 256L;
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
              return q((ObservableBoolean)paramObject, paramInt2);
            }
            return p((ObservableBoolean)paramObject, paramInt2);
          }
          return m((ObservableBoolean)paramObject, paramInt2);
        }
        return l((ObservableBoolean)paramObject, paramInt2);
      }
      return n((ObservableBoolean)paramObject, paramInt2);
    }
    return o((ObservableBoolean)paramObject, paramInt2);
  }
  
  public boolean setVariable(int paramInt, @Nullable Object paramObject)
  {
    if (79 == paramInt)
    {
      i((g)paramObject);
    }
    else
    {
      if (61 != paramInt) {
        break label36;
      }
      h((MemoriesFilterViewModel)paramObject);
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
      boolean bool = ActivityMemoriesFilterBindingImpl.this.d.isChecked();
      Object localObject = ActivityMemoriesFilterBindingImpl.this.Q3;
      int i = 1;
      int j;
      if (localObject != null) {
        j = 1;
      } else {
        j = 0;
      }
      if (j != 0)
      {
        localObject = ((MemoriesFilterViewModel)localObject).e;
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
  
  class b
    implements InverseBindingListener
  {
    b() {}
    
    public void onChange()
    {
      boolean bool = ActivityMemoriesFilterBindingImpl.this.x.isChecked();
      Object localObject = ActivityMemoriesFilterBindingImpl.this.Q3;
      int i = 1;
      int j;
      if (localObject != null) {
        j = 1;
      } else {
        j = 0;
      }
      if (j != 0)
      {
        localObject = ((MemoriesFilterViewModel)localObject).f;
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
      boolean bool = ActivityMemoriesFilterBindingImpl.this.p2.isChecked();
      Object localObject = ActivityMemoriesFilterBindingImpl.this.Q3;
      int i = 1;
      int j;
      if (localObject != null) {
        j = 1;
      } else {
        j = 0;
      }
      if (j != 0)
      {
        localObject = ((MemoriesFilterViewModel)localObject).c;
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
      boolean bool = ActivityMemoriesFilterBindingImpl.this.K3.isChecked();
      Object localObject = ActivityMemoriesFilterBindingImpl.this.Q3;
      int i = 1;
      int j;
      if (localObject != null) {
        j = 1;
      } else {
        j = 0;
      }
      if (j != 0)
      {
        localObject = ((MemoriesFilterViewModel)localObject).g;
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
  
  class e
    implements InverseBindingListener
  {
    e() {}
    
    public void onChange()
    {
      boolean bool = ActivityMemoriesFilterBindingImpl.this.N3.isChecked();
      Object localObject = ActivityMemoriesFilterBindingImpl.this.Q3;
      int i = 1;
      int j;
      if (localObject != null) {
        j = 1;
      } else {
        j = 0;
      }
      if (j != 0)
      {
        localObject = ((MemoriesFilterViewModel)localObject).d;
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityMemoriesFilterBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */