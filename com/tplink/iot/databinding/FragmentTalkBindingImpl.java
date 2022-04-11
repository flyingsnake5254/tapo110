package com.tplink.iot.databinding;

import android.content.res.Resources;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.Observable;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.tplink.iot.view.ipcamera.widget.liveViewSettingButton.RippleLayout;
import com.tplink.iot.viewmodel.ipcamera.play.TalkViewModel;

public class FragmentTalkBindingImpl
  extends FragmentTalkBinding
{
  @Nullable
  private static final SparseIntArray p0;
  @Nullable
  private static final ViewDataBinding.IncludedLayouts z;
  @NonNull
  private final ConstraintLayout p1;
  private a p2;
  private long p3 = -1L;
  
  public FragmentTalkBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 5, z, p0));
  }
  
  private FragmentTalkBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 2, (ImageView)paramArrayOfObject[4], (TextView)paramArrayOfObject[1], (RippleLayout)paramArrayOfObject[2], (ImageButton)paramArrayOfObject[3]);
    this.c.setTag(null);
    this.d.setTag(null);
    paramDataBindingComponent = (ConstraintLayout)paramArrayOfObject[0];
    this.p1 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    this.f.setTag(null);
    this.q.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  private boolean l(ObservableBoolean paramObservableBoolean, int paramInt)
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
  
  private boolean m(ObservableBoolean paramObservableBoolean, int paramInt)
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
      long l1 = this.p3;
      this.p3 = 0L;
      View.OnClickListener localOnClickListener = this.y;
      TalkViewModel localTalkViewModel = this.x;
      Object localObject1 = null;
      a locala;
      Object localObject2;
      if (((l1 & 0x14) != 0L) && (localOnClickListener != null))
      {
        locala = this.p2;
        localObject2 = locala;
        if (locala == null)
        {
          localObject2 = new a();
          this.p2 = ((a)localObject2);
        }
        locala = ((a)localObject2).a(localOnClickListener);
      }
      else
      {
        locala = null;
      }
      boolean bool1 = false;
      long l2;
      boolean bool3;
      if ((l1 & 0x1B) != 0L)
      {
        if (localTalkViewModel != null) {
          localObject2 = localTalkViewModel.j;
        } else {
          localObject2 = null;
        }
        updateRegistration(0, (Observable)localObject2);
        if (localObject2 != null) {
          bool2 = ((ObservableBoolean)localObject2).get();
        } else {
          bool2 = false;
        }
        l2 = l1;
        if ((l1 & 0x19) != 0L)
        {
          if (bool2) {
            l2 = 256L;
          } else {
            l2 = 128L;
          }
          l2 = l1 | l2;
        }
        l1 = l2;
        if ((l2 & 0x1B) != 0L) {
          if (bool2) {
            l1 = l2 | 0x400;
          } else {
            l1 = l2 | 0x200;
          }
        }
        l2 = l1;
        bool3 = bool2;
        if ((l1 & 0x19) != 0L)
        {
          if (bool2)
          {
            f = 1.0F;
            break label267;
          }
          f = 0.3F;
          break label267;
        }
      }
      else
      {
        bool3 = false;
        l2 = l1;
      }
      float f = 0.0F;
      boolean bool2 = bool3;
      l1 = l2;
      label267:
      boolean bool4 = (0x400 & l1) < 0L;
      if (bool4)
      {
        if (localTalkViewModel != null) {
          localObject2 = localTalkViewModel.l;
        } else {
          localObject2 = null;
        }
        updateRegistration(1, (Observable)localObject2);
        bool3 = bool1;
        if (localObject2 != null) {
          bool3 = ((ObservableBoolean)localObject2).get();
        }
        l2 = l1;
        if (bool4)
        {
          if (bool3) {
            l2 = 64L;
          } else {
            l2 = 32L;
          }
          l2 = l1 | l2;
        }
        int i;
        if (bool3)
        {
          localObject2 = this.d.getResources();
          i = 2131954452;
        }
        else
        {
          localObject2 = this.d.getResources();
          i = 2131954451;
        }
        localObject2 = ((Resources)localObject2).getString(i);
        l1 = l2;
      }
      else
      {
        localObject2 = null;
      }
      boolean bool5 = (0x1B & l1) < 0L;
      if (bool5)
      {
        if (!bool2) {
          localObject2 = this.d.getResources().getString(2131954450);
        }
        localObject1 = localObject2;
      }
      if ((0x14 & l1) != 0L)
      {
        this.c.setOnClickListener(locala);
        this.f.setOnClickListener(locala);
        this.q.setOnClickListener(locala);
      }
      if (bool5) {
        TextViewBindingAdapter.setText(this.d, (CharSequence)localObject1);
      }
      if ((l1 & 0x19) != 0L)
      {
        if (ViewDataBinding.getBuildSdkInt() >= 11) {
          this.q.setAlpha(f);
        }
        this.q.setEnabled(bool2);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable View.OnClickListener paramOnClickListener)
  {
    this.y = paramOnClickListener;
    try
    {
      this.p3 |= 0x4;
      notifyPropertyChanged(55);
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
    this.x = paramTalkViewModel;
    try
    {
      this.p3 |= 0x8;
      notifyPropertyChanged(97);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void invalidateAll()
  {
    try
    {
      this.p3 = 16L;
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
      return m((ObservableBoolean)paramObject, paramInt2);
    }
    return l((ObservableBoolean)paramObject, paramInt2);
  }
  
  public boolean setVariable(int paramInt, @Nullable Object paramObject)
  {
    if (55 == paramInt)
    {
      h((View.OnClickListener)paramObject);
    }
    else
    {
      if (97 != paramInt) {
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
  
  public static class a
    implements View.OnClickListener
  {
    private View.OnClickListener c;
    
    public a a(View.OnClickListener paramOnClickListener)
    {
      this.c = paramOnClickListener;
      if (paramOnClickListener == null) {
        paramOnClickListener = null;
      } else {
        paramOnClickListener = this;
      }
      return paramOnClickListener;
    }
    
    public void onClick(View paramView)
    {
      this.c.onClick(paramView);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentTalkBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */