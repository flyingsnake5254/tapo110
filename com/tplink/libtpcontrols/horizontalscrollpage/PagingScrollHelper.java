package com.tplink.libtpcontrols.horizontalscrollpage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.OnFlingListener;
import androidx.recyclerview.widget.RecyclerView.OnScrollListener;

public class PagingScrollHelper
{
  private RecyclerView a = null;
  private PageIndicatorView b = null;
  private PageScrollListener c = new PageScrollListener();
  private PageFlingListener d = new PageFlingListener();
  private b e = new b();
  private c f;
  private int g = 0;
  private int h = 0;
  private int i = 0;
  private int j = 0;
  private int k = 2;
  private int l = 3;
  private int m = 0;
  private int n = 0;
  private ValueAnimator o = null;
  private boolean p = false;
  private boolean q = false;
  private a r = a.c;
  
  public PagingScrollHelper(int paramInt1, int paramInt2)
  {
    this.k = paramInt1;
    this.l = paramInt2;
  }
  
  private int u()
  {
    int i1;
    if (this.r == a.d) {
      i1 = this.g / this.a.getHeight();
    } else {
      i1 = this.h / this.a.getWidth();
    }
    return Math.abs(i1);
  }
  
  private int v()
  {
    int i1;
    if (this.r == a.d) {
      i1 = this.i / this.a.getHeight();
    } else {
      i1 = this.j / this.a.getWidth();
    }
    return i1;
  }
  
  public void A()
  {
    Object localObject = this.a.getLayoutManager();
    if (localObject != null)
    {
      if (((RecyclerView.LayoutManager)localObject).canScrollVertically()) {
        this.r = a.d;
      } else if (((RecyclerView.LayoutManager)localObject).canScrollHorizontally()) {
        this.r = a.c;
      } else {
        this.r = a.f;
      }
      localObject = this.o;
      if (localObject != null) {
        ((ValueAnimator)localObject).cancel();
      }
      this.j = 0;
      this.i = 0;
      this.h = 0;
      this.g = 0;
      this.n = 0;
    }
  }
  
  public void w(PageIndicatorView paramPageIndicatorView)
  {
    this.b = paramPageIndicatorView;
  }
  
  public void x(boolean paramBoolean)
  {
    this.p = paramBoolean;
  }
  
  public void y(c paramc)
  {
    this.f = paramc;
  }
  
  public void z(RecyclerView paramRecyclerView)
  {
    if (paramRecyclerView != null)
    {
      this.a = paramRecyclerView;
      boolean bool;
      if ((paramRecyclerView.getAdapter() != null) && (this.a.getAdapter().getItemCount() != 0)) {
        bool = false;
      } else {
        bool = true;
      }
      this.q = bool;
      if (!bool)
      {
        paramRecyclerView.setOnFlingListener(this.d);
        paramRecyclerView.addOnScrollListener(this.c);
        paramRecyclerView.setOnTouchListener(this.e);
      }
      A();
      return;
    }
    throw new IllegalArgumentException("recycleView must be not null");
  }
  
  public class PageFlingListener
    extends RecyclerView.OnFlingListener
  {
    public PageFlingListener() {}
    
    public boolean onFling(int paramInt1, int paramInt2)
    {
      if (PagingScrollHelper.a(PagingScrollHelper.this) == PagingScrollHelper.a.f) {
        return false;
      }
      int i = PagingScrollHelper.b(PagingScrollHelper.this);
      int j;
      if (PagingScrollHelper.a(PagingScrollHelper.this) == PagingScrollHelper.a.d)
      {
        j = PagingScrollHelper.j(PagingScrollHelper.this);
        if (paramInt2 < 0)
        {
          paramInt1 = i - 1;
        }
        else
        {
          paramInt1 = i;
          if (paramInt2 > 0) {
            paramInt1 = i + 1;
          }
        }
        paramInt1 *= PagingScrollHelper.l(PagingScrollHelper.this).getHeight();
        paramInt2 = j;
      }
      else
      {
        j = PagingScrollHelper.m(PagingScrollHelper.this);
        if (paramInt1 < 0)
        {
          paramInt2 = i - 1;
        }
        else
        {
          paramInt2 = i;
          if (paramInt1 > 0) {
            paramInt2 = i + 1;
          }
        }
        paramInt1 = paramInt2 * PagingScrollHelper.l(PagingScrollHelper.this).getWidth();
        paramInt2 = j;
      }
      if (PagingScrollHelper.o(PagingScrollHelper.this))
      {
        i = paramInt1;
        if (paramInt1 <= 0) {
          break label158;
        }
      }
      else
      {
        i = paramInt1;
        if (paramInt1 >= 0) {
          break label158;
        }
      }
      i = 0;
      label158:
      if (PagingScrollHelper.p(PagingScrollHelper.this) == null)
      {
        PagingScrollHelper.q(PagingScrollHelper.this, ValueAnimator.ofInt(new int[] { paramInt2, i }));
        PagingScrollHelper.p(PagingScrollHelper.this).setDuration(300L);
        PagingScrollHelper.p(PagingScrollHelper.this).addUpdateListener(new a(this));
        PagingScrollHelper.p(PagingScrollHelper.this).addListener(new a());
      }
      else
      {
        PagingScrollHelper.p(PagingScrollHelper.this).cancel();
        PagingScrollHelper.p(PagingScrollHelper.this).setIntValues(new int[] { paramInt2, i });
      }
      PagingScrollHelper.p(PagingScrollHelper.this).start();
      return true;
    }
    
    class a
      extends AnimatorListenerAdapter
    {
      a() {}
      
      public void onAnimationEnd(Animator paramAnimator)
      {
        if (PagingScrollHelper.r(PagingScrollHelper.this) != null) {
          PagingScrollHelper.r(PagingScrollHelper.this).a(PagingScrollHelper.s(PagingScrollHelper.this));
        }
        if ((PagingScrollHelper.t(PagingScrollHelper.this) != null) && (!PagingScrollHelper.c(PagingScrollHelper.this))) {
          PagingScrollHelper.t(PagingScrollHelper.this).setSelectedPage(PagingScrollHelper.s(PagingScrollHelper.this));
        }
        paramAnimator = PagingScrollHelper.this;
        PagingScrollHelper.d(paramAnimator, PagingScrollHelper.s(paramAnimator));
        PagingScrollHelper.l(PagingScrollHelper.this).stopScroll();
        paramAnimator = PagingScrollHelper.this;
        PagingScrollHelper.f(paramAnimator, PagingScrollHelper.j(paramAnimator));
        paramAnimator = PagingScrollHelper.this;
        PagingScrollHelper.h(paramAnimator, PagingScrollHelper.m(paramAnimator));
      }
    }
  }
  
  public class PageScrollListener
    extends RecyclerView.OnScrollListener
  {
    public PageScrollListener() {}
    
    public void onScrollStateChanged(@NonNull RecyclerView paramRecyclerView, int paramInt)
    {
      if ((paramInt == 0) && (PagingScrollHelper.a(PagingScrollHelper.this) != PagingScrollHelper.a.f))
      {
        PagingScrollHelper.a locala1 = PagingScrollHelper.a(PagingScrollHelper.this);
        PagingScrollHelper.a locala2 = PagingScrollHelper.a.d;
        int i = 64536;
        int j = 1;
        int k = 1;
        int m = 0;
        paramInt = 0;
        if (locala1 == locala2)
        {
          if (Math.abs(PagingScrollHelper.j(PagingScrollHelper.this) - PagingScrollHelper.e(PagingScrollHelper.this)) <= paramRecyclerView.getHeight() / 2) {
            k = 0;
          }
          if (k != 0)
          {
            if (PagingScrollHelper.j(PagingScrollHelper.this) - PagingScrollHelper.e(PagingScrollHelper.this) < 0)
            {
              paramInt = i;
              i = m;
              break label208;
            }
            paramInt = 1000;
            i = m;
            break label208;
          }
        }
        else
        {
          if (Math.abs(PagingScrollHelper.m(PagingScrollHelper.this) - PagingScrollHelper.g(PagingScrollHelper.this)) > paramRecyclerView.getWidth() / 2) {
            k = j;
          } else {
            k = 0;
          }
          if (k != 0) {
            if (PagingScrollHelper.m(PagingScrollHelper.this) - PagingScrollHelper.g(PagingScrollHelper.this) < 0) {
              paramInt = i;
            } else {
              paramInt = 1000;
            }
          }
        }
        k = 0;
        i = paramInt;
        paramInt = k;
        label208:
        PagingScrollHelper.i(PagingScrollHelper.this).onFling(i, paramInt);
      }
    }
    
    public void onScrolled(@NonNull RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      paramRecyclerView = PagingScrollHelper.this;
      PagingScrollHelper.k(paramRecyclerView, PagingScrollHelper.j(paramRecyclerView) + paramInt2);
      paramRecyclerView = PagingScrollHelper.this;
      PagingScrollHelper.n(paramRecyclerView, PagingScrollHelper.m(paramRecyclerView) + paramInt1);
    }
  }
  
  static enum a
  {
    static
    {
      a locala1 = new a("HORIZONTAL", 0);
      c = locala1;
      a locala2 = new a("VERTICAL", 1);
      d = locala2;
      a locala3 = new a("NULL", 2);
      f = locala3;
      q = new a[] { locala1, locala2, locala3 };
    }
  }
  
  public class b
    implements View.OnTouchListener
  {
    public b() {}
    
    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      if (paramMotionEvent.getAction() == 0)
      {
        paramView = PagingScrollHelper.this;
        PagingScrollHelper.f(paramView, PagingScrollHelper.j(paramView));
        paramView = PagingScrollHelper.this;
        PagingScrollHelper.h(paramView, PagingScrollHelper.m(paramView));
      }
      return false;
    }
  }
  
  public static abstract interface c
  {
    public abstract void a(int paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\horizontalscrollpage\PagingScrollHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */