package com.tplink.iot.databinding;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.Observable;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import androidx.databinding.adapters.ImageViewBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.databinding.adapters.ViewBindingAdapter;
import com.tplink.iot.viewmodel.ipcamera.play.TalkViewModel;

public class FragmentVoiceCallBindingImpl
  extends FragmentVoiceCallBinding
{
  @Nullable
  private static final SparseIntArray H3;
  @Nullable
  private static final ViewDataBinding.IncludedLayouts p3;
  @NonNull
  private final ConstraintLayout I3;
  private a J3;
  private long K3 = -1L;
  
  public FragmentVoiceCallBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 9, p3, H3));
  }
  
  private FragmentVoiceCallBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 4, (ImageView)paramArrayOfObject[2], (ImageView)paramArrayOfObject[3], (TextView)paramArrayOfObject[8], (TextView)paramArrayOfObject[6], (ImageView)paramArrayOfObject[5], (TextView)paramArrayOfObject[7], (ImageView)paramArrayOfObject[4], (TextView)paramArrayOfObject[1]);
    this.c.setTag(null);
    this.d.setTag(null);
    this.f.setTag(null);
    this.q.setTag(null);
    paramDataBindingComponent = (ConstraintLayout)paramArrayOfObject[0];
    this.I3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    this.x.setTag(null);
    this.y.setTag(null);
    this.z.setTag(null);
    this.p0.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  private boolean l(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.K3 |= 0x4;
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
        this.K3 |= 0x2;
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
        this.K3 |= 0x8;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean o(ObservableField<String> paramObservableField, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.K3 |= 1L;
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
      long l1 = this.K3;
      this.K3 = 0L;
      Object localObject1 = this.p2;
      TalkViewModel localTalkViewModel = this.p1;
      Object localObject2;
      a locala;
      if (((l1 & 0x74) != 0L) && (localObject1 != null))
      {
        localObject2 = this.J3;
        localObject3 = localObject2;
        if (localObject2 == null)
        {
          localObject3 = new a();
          this.J3 = ((a)localObject3);
        }
        locala = ((a)localObject3).a((View.OnClickListener)localObject1);
      }
      else
      {
        locala = null;
      }
      boolean bool4;
      float f;
      label502:
      Object localObject5;
      Drawable localDrawable;
      Object localObject7;
      if ((0x7F & l1) != 0L)
      {
        boolean bool1 = (l1 & 0x62) < 0L;
        long l2;
        int i;
        if (bool1)
        {
          if (localTalkViewModel != null) {
            localObject3 = localTalkViewModel.i;
          } else {
            localObject3 = null;
          }
          updateRegistration(1, (Observable)localObject3);
          if (localObject3 != null) {
            bool4 = ((ObservableBoolean)localObject3).get();
          } else {
            bool4 = false;
          }
          l2 = l1;
          if (bool1)
          {
            if (bool4)
            {
              l1 |= 0x4000;
              l2 = 262144L;
            }
            else
            {
              l1 |= 0x2000;
              l2 = 131072L;
            }
            l2 = l1 | l2;
          }
          localObject3 = this.z.getContext();
          if (bool4) {
            i = 2131231565;
          } else {
            i = 2131231566;
          }
          localObject2 = AppCompatResources.getDrawable((Context)localObject3, i);
          if (bool4)
          {
            localObject3 = this.f.getResources();
            i = 2131954448;
          }
          else
          {
            localObject3 = this.f.getResources();
            i = 2131954449;
          }
          localObject3 = ((Resources)localObject3).getString(i);
          l1 = l2;
        }
        else
        {
          localObject3 = null;
          localObject2 = null;
        }
        boolean bool5;
        if ((l1 & 0x75) != 0L)
        {
          if (localTalkViewModel != null) {
            localObject1 = localTalkViewModel.j;
          } else {
            localObject1 = null;
          }
          updateRegistration(2, (Observable)localObject1);
          if (localObject1 != null) {
            bool4 = ((ObservableBoolean)localObject1).get();
          } else {
            bool4 = false;
          }
          l2 = l1;
          if ((l1 & 0x64) != 0L)
          {
            if (bool4)
            {
              l2 = l1 | 0x400;
              l1 = 65536L;
            }
            else
            {
              l2 = l1 | 0x200;
              l1 = 32768L;
            }
            l2 |= l1;
          }
          l1 = l2;
          if ((l2 & 0x65) != 0L) {
            if (bool4) {
              l1 = l2 | 0x100000;
            } else {
              l1 = l2 | 0x80000;
            }
          }
          l2 = l1;
          bool5 = bool4;
          if ((l1 & 0x64) != 0L)
          {
            if (bool4) {
              f = 1.0F;
            } else {
              f = 0.3F;
            }
            localObject1 = this.q.getResources();
            if (bool4) {
              i = 2131954443;
            } else {
              i = 2131951757;
            }
            localObject1 = ((Resources)localObject1).getString(i);
            break label502;
          }
        }
        else
        {
          bool5 = false;
          l2 = l1;
        }
        localObject1 = null;
        f = 0.0F;
        bool4 = bool5;
        l1 = l2;
        boolean bool2 = (l1 & 0x68) < 0L;
        if (bool2)
        {
          if (localTalkViewModel != null) {
            localObject5 = localTalkViewModel.h;
          } else {
            localObject5 = null;
          }
          updateRegistration(3, (Observable)localObject5);
          if (localObject5 != null) {
            bool5 = ((ObservableBoolean)localObject5).get();
          } else {
            bool5 = false;
          }
          l2 = l1;
          if (bool2)
          {
            if (bool5)
            {
              l1 |= 0x100;
              l2 = 4096L;
            }
            else
            {
              l1 |= 0x80;
              l2 = 2048L;
            }
            l2 = l1 | l2;
          }
          localObject5 = this.x.getContext();
          int j;
          if (bool5) {
            j = 2131231343;
          } else {
            j = 2131231344;
          }
          localDrawable = AppCompatResources.getDrawable((Context)localObject5, j);
          if (bool5)
          {
            localObject5 = this.y.getResources();
            j = 2131954445;
          }
          else
          {
            localObject5 = this.y.getResources();
            j = 2131954446;
          }
          localObject5 = ((Resources)localObject5).getString(j);
          l1 = l2;
        }
        else
        {
          localObject5 = null;
          localDrawable = null;
        }
        Object localObject6 = localObject1;
        localObject1 = localObject3;
        localObject7 = localObject2;
        localObject2 = localObject6;
      }
      else
      {
        f = 0.0F;
        bool4 = false;
        localDrawable = null;
        localObject1 = null;
        localObject7 = null;
        localObject2 = null;
        localObject5 = null;
      }
      if ((l1 & 0x100000) != 0L)
      {
        if (localTalkViewModel != null) {
          localObject3 = localTalkViewModel.g;
        } else {
          localObject3 = null;
        }
        updateRegistration(0, (Observable)localObject3);
        if (localObject3 != null)
        {
          localObject3 = (String)((ObservableField)localObject3).get();
          break label787;
        }
      }
      Object localObject3 = null;
      label787:
      boolean bool3 = (0x65 & l1) < 0L;
      if (bool3)
      {
        if (!bool4) {
          localObject3 = this.p0.getResources().getString(2131954450);
        }
      }
      else {
        localObject3 = null;
      }
      if ((0x50 & l1) != 0L)
      {
        this.c.setOnClickListener(locala);
        this.d.setOnClickListener(locala);
        this.z.setOnClickListener(locala);
      }
      if ((l1 & 0x62) != 0L)
      {
        TextViewBindingAdapter.setText(this.f, (CharSequence)localObject1);
        ImageViewBindingAdapter.setImageDrawable(this.z, (Drawable)localObject7);
      }
      if ((l1 & 0x64) != 0L)
      {
        TextViewBindingAdapter.setText(this.q, (CharSequence)localObject2);
        if (ViewDataBinding.getBuildSdkInt() >= 11) {
          this.x.setAlpha(f);
        }
      }
      if ((0x68 & l1) != 0L)
      {
        ImageViewBindingAdapter.setImageDrawable(this.x, localDrawable);
        TextViewBindingAdapter.setText(this.y, (CharSequence)localObject5);
      }
      if ((l1 & 0x74) != 0L) {
        ViewBindingAdapter.setOnClick(this.x, locala, bool4);
      }
      if (bool3) {
        TextViewBindingAdapter.setText(this.p0, (CharSequence)localObject3);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable View.OnClickListener paramOnClickListener)
  {
    this.p2 = paramOnClickListener;
    try
    {
      this.K3 |= 0x10;
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
      return this.K3 != 0L;
    }
    finally {}
  }
  
  public void i(@Nullable TalkViewModel paramTalkViewModel)
  {
    this.p1 = paramTalkViewModel;
    try
    {
      this.K3 |= 0x20;
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
      this.K3 = 64L;
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
          if (paramInt1 != 3) {
            return false;
          }
          return n((ObservableBoolean)paramObject, paramInt2);
        }
        return l((ObservableBoolean)paramObject, paramInt2);
      }
      return m((ObservableBoolean)paramObject, paramInt2);
    }
    return o((ObservableField)paramObject, paramInt2);
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentVoiceCallBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */