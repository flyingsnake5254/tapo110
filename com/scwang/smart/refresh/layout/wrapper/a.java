package com.scwang.smart.refresh.layout.wrapper;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.Space;
import androidx.annotation.NonNull;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingParent;
import androidx.viewpager.widget.ViewPager;
import com.scwang.smart.refresh.layout.a.e;
import com.scwang.smart.refresh.layout.a.f;
import com.scwang.smart.refresh.layout.c.i;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class a
  implements com.scwang.smart.refresh.layout.a.b, com.scwang.smart.refresh.layout.c.a, ValueAnimator.AnimatorUpdateListener
{
  protected View c;
  protected View d;
  protected View f;
  protected boolean p0 = true;
  protected com.scwang.smart.refresh.layout.simple.a p1 = new com.scwang.smart.refresh.layout.simple.a();
  protected View q;
  protected View x;
  protected int y = 0;
  protected boolean z = true;
  
  public a(@NonNull View paramView)
  {
    this.f = paramView;
    this.d = paramView;
    this.c = paramView;
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.z = paramBoolean1;
    this.p0 = paramBoolean2;
  }
  
  protected void b(View paramView, e parame)
  {
    boolean bool1 = this.c.isInEditMode();
    for (View localView = null;; localView = paramView)
    {
      if ((localView == null) || (((localView instanceof NestedScrollingParent)) && (!(localView instanceof NestedScrollingChild))))
      {
        boolean bool2;
        if (localView == null) {
          bool2 = true;
        } else {
          bool2 = false;
        }
        paramView = m(paramView, bool2);
        if (paramView != localView) {}
      }
      else
      {
        if (localView != null) {
          this.f = localView;
        }
        return;
      }
      if (!bool1) {
        com.scwang.smart.refresh.layout.d.a.a(paramView, parame, this);
      }
    }
  }
  
  public void c(MotionEvent paramMotionEvent)
  {
    paramMotionEvent = new PointF(paramMotionEvent.getX(), paramMotionEvent.getY());
    paramMotionEvent.offset(-this.c.getLeft(), -this.c.getTop());
    View localView1 = this.f;
    View localView2 = this.c;
    if (localView1 != localView2) {
      this.f = l(localView2, paramMotionEvent, localView1);
    }
    if (this.f == this.c) {
      this.p1.a = null;
    } else {
      this.p1.a = paramMotionEvent;
    }
  }
  
  public void d(i parami)
  {
    if ((parami instanceof com.scwang.smart.refresh.layout.simple.a)) {
      this.p1 = ((com.scwang.smart.refresh.layout.simple.a)parami);
    } else {
      this.p1.b = parami;
    }
  }
  
  public void e(e parame, View paramView1, View paramView2)
  {
    b(this.c, parame);
    if ((paramView1 != null) || (paramView2 != null))
    {
      this.q = paramView1;
      this.x = paramView2;
      FrameLayout localFrameLayout = new FrameLayout(this.c.getContext());
      int i = parame.d().getLayout().indexOfChild(this.c);
      parame.d().getLayout().removeView(this.c);
      localFrameLayout.addView(this.c, 0, new ViewGroup.LayoutParams(-1, -1));
      ViewGroup.LayoutParams localLayoutParams = this.c.getLayoutParams();
      parame.d().getLayout().addView(localFrameLayout, i, localLayoutParams);
      this.c = localFrameLayout;
      if (paramView1 != null)
      {
        paramView1.setTag(com.scwang.smart.refresh.layout.b.a.srl_tag, "fixed-top");
        localLayoutParams = paramView1.getLayoutParams();
        parame = (ViewGroup)paramView1.getParent();
        i = parame.indexOfChild(paramView1);
        parame.removeView(paramView1);
        localLayoutParams.height = com.scwang.smart.refresh.layout.d.b.h(paramView1);
        parame.addView(new Space(this.c.getContext()), i, localLayoutParams);
        localFrameLayout.addView(paramView1, 1, localLayoutParams);
      }
      if (paramView2 != null)
      {
        paramView2.setTag(com.scwang.smart.refresh.layout.b.a.srl_tag, "fixed-bottom");
        localLayoutParams = paramView2.getLayoutParams();
        paramView1 = (ViewGroup)paramView2.getParent();
        i = paramView1.indexOfChild(paramView2);
        paramView1.removeView(paramView2);
        parame = new FrameLayout.LayoutParams(localLayoutParams);
        localLayoutParams.height = com.scwang.smart.refresh.layout.d.b.h(paramView2);
        paramView1.addView(new Space(this.c.getContext()), i, localLayoutParams);
        parame.gravity = 80;
        localFrameLayout.addView(paramView2, 1, parame);
      }
    }
  }
  
  public void f(boolean paramBoolean)
  {
    this.p1.c = paramBoolean;
  }
  
  public ValueAnimator.AnimatorUpdateListener g(int paramInt)
  {
    View localView = this.f;
    if ((localView != null) && (paramInt != 0) && (((paramInt < 0) && (localView.canScrollVertically(1))) || ((paramInt > 0) && (this.f.canScrollVertically(-1)))))
    {
      this.y = paramInt;
      return this;
    }
    return null;
  }
  
  @NonNull
  public View getView()
  {
    return this.c;
  }
  
  @NonNull
  public View h()
  {
    return this.f;
  }
  
  public boolean i()
  {
    boolean bool;
    if ((this.z) && (this.p1.a(this.c))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void j(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 1;
    if (paramInt2 != -1)
    {
      localView = this.d.findViewById(paramInt2);
      if (localView != null)
      {
        if (paramInt1 > 0)
        {
          localView.setTranslationY(paramInt1);
          paramInt2 = 1;
          break label57;
        }
        if (localView.getTranslationY() > 0.0F) {
          localView.setTranslationY(0.0F);
        }
      }
    }
    paramInt2 = 0;
    label57:
    if (paramInt3 != -1)
    {
      localView = this.d.findViewById(paramInt3);
      if (localView != null) {
        if (paramInt1 < 0)
        {
          localView.setTranslationY(paramInt1);
          paramInt2 = i;
        }
        else if (localView.getTranslationY() < 0.0F)
        {
          localView.setTranslationY(0.0F);
        }
      }
    }
    if (paramInt2 == 0) {
      this.d.setTranslationY(paramInt1);
    } else {
      this.d.setTranslationY(0.0F);
    }
    View localView = this.q;
    if (localView != null) {
      localView.setTranslationY(Math.max(0, paramInt1));
    }
    localView = this.x;
    if (localView != null) {
      localView.setTranslationY(Math.min(0, paramInt1));
    }
  }
  
  public boolean k()
  {
    boolean bool;
    if ((this.p0) && (this.p1.b(this.c))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  protected View l(View paramView1, PointF paramPointF, View paramView2)
  {
    if (((paramView1 instanceof ViewGroup)) && (paramPointF != null))
    {
      paramView1 = (ViewGroup)paramView1;
      int i = paramView1.getChildCount();
      PointF localPointF = new PointF();
      while (i > 0)
      {
        View localView = paramView1.getChildAt(i - 1);
        if (com.scwang.smart.refresh.layout.d.b.g(paramView1, localView, paramPointF.x, paramPointF.y, localPointF))
        {
          if (!(localView instanceof ViewPager))
          {
            paramView1 = localView;
            if (com.scwang.smart.refresh.layout.d.b.e(localView)) {}
          }
          else
          {
            paramPointF.offset(localPointF.x, localPointF.y);
            paramView1 = l(localView, paramPointF, paramView2);
            paramPointF.offset(-localPointF.x, -localPointF.y);
          }
          return paramView1;
        }
        i--;
      }
    }
    return paramView2;
  }
  
  protected View m(View paramView, boolean paramBoolean)
  {
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(paramView);
    Object localObject1 = null;
    while ((localLinkedList.size() > 0) && (localObject1 == null))
    {
      Object localObject2 = (View)localLinkedList.poll();
      if (localObject2 != null) {
        if (((paramBoolean) || (localObject2 != paramView)) && (com.scwang.smart.refresh.layout.d.b.e((View)localObject2)))
        {
          localObject1 = localObject2;
        }
        else if ((localObject2 instanceof ViewGroup))
        {
          localObject2 = (ViewGroup)localObject2;
          for (int i = 0; i < ((ViewGroup)localObject2).getChildCount(); i++) {
            localLinkedList.add(((ViewGroup)localObject2).getChildAt(i));
          }
        }
      }
    }
    if (localObject1 != null) {
      paramView = (View)localObject1;
    }
    return paramView;
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    try
    {
      float f1 = (i - this.y) * this.f.getScaleY();
      paramValueAnimator = this.f;
      if ((paramValueAnimator instanceof AbsListView)) {
        com.scwang.smart.refresh.layout.d.b.j((AbsListView)paramValueAnimator, (int)f1);
      } else {
        paramValueAnimator.scrollBy(0, (int)f1);
      }
    }
    finally
    {
      paramValueAnimator.printStackTrace();
    }
    this.y = i;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\scwang\smart\refresh\layout\wrapper\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */