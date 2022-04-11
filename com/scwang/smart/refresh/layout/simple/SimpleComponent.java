package com.scwang.smart.refresh.layout.simple;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.scwang.smart.refresh.layout.SmartRefreshLayout.LayoutParams;
import com.scwang.smart.refresh.layout.a.a;
import com.scwang.smart.refresh.layout.a.c;
import com.scwang.smart.refresh.layout.a.d;
import com.scwang.smart.refresh.layout.a.e;
import com.scwang.smart.refresh.layout.a.f;
import com.scwang.smart.refresh.layout.c.h;
import com.scwang.smart.refresh.layout.constant.RefreshState;
import com.scwang.smart.refresh.layout.constant.b;

public abstract class SimpleComponent
  extends RelativeLayout
  implements a
{
  protected View c;
  protected b d;
  protected a f;
  
  protected SimpleComponent(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected SimpleComponent(@NonNull View paramView)
  {
    this(paramView, locala);
  }
  
  protected SimpleComponent(@NonNull View paramView, @Nullable a parama)
  {
    super(paramView.getContext(), null, 0);
    this.c = paramView;
    this.f = parama;
    if (((this instanceof c)) && ((parama instanceof d)) && (parama.getSpinnerStyle() == b.e))
    {
      parama.getView().setScaleY(-1.0F);
    }
    else if ((this instanceof d))
    {
      paramView = this.f;
      if (((paramView instanceof c)) && (paramView.getSpinnerStyle() == b.e)) {
        parama.getView().setScaleY(-1.0F);
      }
    }
  }
  
  @SuppressLint({"RestrictedApi"})
  public boolean b(boolean paramBoolean)
  {
    a locala = this.f;
    if (((locala instanceof c)) && (((c)locala).b(paramBoolean))) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    return paramBoolean;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = super.equals(paramObject);
    boolean bool2 = true;
    if (!bool1)
    {
      if ((paramObject instanceof a))
      {
        if (getView() != ((a)paramObject).getView()) {
          bool2 = false;
        }
        return bool2;
      }
      return false;
    }
    return true;
  }
  
  public int f(@NonNull f paramf, boolean paramBoolean)
  {
    a locala = this.f;
    if ((locala != null) && (locala != this)) {
      return locala.f(paramf, paramBoolean);
    }
    return 0;
  }
  
  public void g(@NonNull e parame, int paramInt1, int paramInt2)
  {
    Object localObject = this.f;
    if ((localObject != null) && (localObject != this))
    {
      ((a)localObject).g(parame, paramInt1, paramInt2);
    }
    else
    {
      localObject = this.c;
      if (localObject != null)
      {
        localObject = ((View)localObject).getLayoutParams();
        if ((localObject instanceof SmartRefreshLayout.LayoutParams)) {
          parame.e(this, ((SmartRefreshLayout.LayoutParams)localObject).a);
        }
      }
    }
  }
  
  @NonNull
  public b getSpinnerStyle()
  {
    Object localObject = this.d;
    if (localObject != null) {
      return (b)localObject;
    }
    localObject = this.f;
    if ((localObject != null) && (localObject != this)) {
      return ((a)localObject).getSpinnerStyle();
    }
    localObject = this.c;
    if (localObject != null)
    {
      localObject = ((View)localObject).getLayoutParams();
      b localb;
      if ((localObject instanceof SmartRefreshLayout.LayoutParams))
      {
        localb = ((SmartRefreshLayout.LayoutParams)localObject).b;
        this.d = localb;
        if (localb != null) {
          return localb;
        }
      }
      if (localObject != null)
      {
        int i = ((ViewGroup.LayoutParams)localObject).height;
        if ((i == 0) || (i == -1)) {
          for (localb : b.f) {
            if (localb.i)
            {
              this.d = localb;
              return localb;
            }
          }
        }
      }
    }
    localObject = b.a;
    this.d = ((b)localObject);
    return (b)localObject;
  }
  
  @NonNull
  public View getView()
  {
    View localView = this.c;
    Object localObject = localView;
    if (localView == null) {
      localObject = this;
    }
    return (View)localObject;
  }
  
  public void h(@NonNull f paramf, @NonNull RefreshState paramRefreshState1, @NonNull RefreshState paramRefreshState2)
  {
    Object localObject1 = this.f;
    if ((localObject1 != null) && (localObject1 != this))
    {
      Object localObject2;
      RefreshState localRefreshState;
      if (((this instanceof c)) && ((localObject1 instanceof d)))
      {
        localObject1 = paramRefreshState1;
        if (paramRefreshState1.isFooter) {
          localObject1 = paramRefreshState1.toHeader();
        }
        localObject2 = localObject1;
        localRefreshState = paramRefreshState2;
        if (paramRefreshState2.isFooter)
        {
          localRefreshState = paramRefreshState2.toHeader();
          localObject2 = localObject1;
        }
      }
      else
      {
        localObject2 = paramRefreshState1;
        localRefreshState = paramRefreshState2;
        if ((this instanceof d))
        {
          localObject2 = paramRefreshState1;
          localRefreshState = paramRefreshState2;
          if ((localObject1 instanceof c))
          {
            localObject1 = paramRefreshState1;
            if (paramRefreshState1.isHeader) {
              localObject1 = paramRefreshState1.toFooter();
            }
            localObject2 = localObject1;
            localRefreshState = paramRefreshState2;
            if (paramRefreshState2.isHeader)
            {
              localRefreshState = paramRefreshState2.toFooter();
              localObject2 = localObject1;
            }
          }
        }
      }
      paramRefreshState1 = this.f;
      if (paramRefreshState1 != null) {
        paramRefreshState1.h(paramf, (RefreshState)localObject2, localRefreshState);
      }
    }
  }
  
  public void i(@NonNull f paramf, int paramInt1, int paramInt2)
  {
    a locala = this.f;
    if ((locala != null) && (locala != this)) {
      locala.i(paramf, paramInt1, paramInt2);
    }
  }
  
  public void j(@NonNull f paramf, int paramInt1, int paramInt2)
  {
    a locala = this.f;
    if ((locala != null) && (locala != this)) {
      locala.j(paramf, paramInt1, paramInt2);
    }
  }
  
  public void k(float paramFloat, int paramInt1, int paramInt2)
  {
    a locala = this.f;
    if ((locala != null) && (locala != this)) {
      locala.k(paramFloat, paramInt1, paramInt2);
    }
  }
  
  public boolean n()
  {
    a locala = this.f;
    boolean bool;
    if ((locala != null) && (locala != this) && (locala.n())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void s(boolean paramBoolean, float paramFloat, int paramInt1, int paramInt2, int paramInt3)
  {
    a locala = this.f;
    if ((locala != null) && (locala != this)) {
      locala.s(paramBoolean, paramFloat, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void setPrimaryColors(@ColorInt int... paramVarArgs)
  {
    a locala = this.f;
    if ((locala != null) && (locala != this)) {
      locala.setPrimaryColors(paramVarArgs);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\scwang\smart\refresh\layout\simple\SimpleComponent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */