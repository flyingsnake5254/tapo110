package com.tplink.iot.view.ipcamera.widget.timeaxis;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.HorizontalScrollView;
import androidx.viewpager.widget.ViewPager;

public class TimeAxisHorizontalScrollView
  extends HorizontalScrollView
{
  private b c = null;
  private a d;
  private int f = 0;
  private boolean p0 = false;
  private boolean p1 = false;
  private boolean p2 = true;
  private int q = 0;
  private float x = 1.0F;
  private float y = -1.0F;
  private float z = -1.0F;
  
  public TimeAxisHorizontalScrollView(Context paramContext)
  {
    super(paramContext);
  }
  
  public TimeAxisHorizontalScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public TimeAxisHorizontalScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private float a(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getPointerCount() < 2) {
      return 0.0F;
    }
    float f1 = paramMotionEvent.getX(0) - paramMotionEvent.getX(1);
    float f2 = paramMotionEvent.getY(0) - paramMotionEvent.getY(1);
    return (float)Math.sqrt(f1 * f1 + f2 * f2);
  }
  
  public boolean canScrollHorizontally(int paramInt)
  {
    boolean bool;
    if ((super.canScrollHorizontally(paramInt)) && (this.f != 2)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.p2) {
      for (ViewParent localViewParent = getParent(); localViewParent != null; localViewParent = localViewParent.getParent()) {
        if ((localViewParent instanceof ViewPager)) {
          localViewParent.requestDisallowInterceptTouchEvent(true);
        }
      }
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    b localb = this.c;
    if ((localb != null) && (this.f != 2)) {
      localb.d(this, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.c != null)
    {
      int i = paramMotionEvent.getAction() & 0xFF;
      int j = 0;
      Object localObject;
      if (i != 0)
      {
        if (i != 1)
        {
          float f1;
          if (i != 2)
          {
            if (i == 5)
            {
              f1 = a(paramMotionEvent);
              this.x = f1;
              if ((f1 > 10.0F) && (this.f != 2))
              {
                this.f = 2;
                this.c.e();
              }
            }
          }
          else if (this.f == 2)
          {
            float f2 = a(paramMotionEvent);
            if (f2 > 10.0F)
            {
              j = this.q;
              if (j < 2)
              {
                this.q = (j + 1);
              }
              else
              {
                this.q = 0;
                f1 = (float)Math.pow(f2 / this.x, 1.0D);
                this.c.f(f1);
                this.x = f2;
              }
            }
            else
            {
              return true;
            }
          }
          else
          {
            if (this.p0)
            {
              if ((getScrollX() == 0) && (this.y == -1.0F)) {
                this.y = paramMotionEvent.getX();
              }
              if (this.y >= 0.0F)
              {
                localObject = this.d;
                if (localObject != null)
                {
                  this.f = 3;
                  ((a)localObject).d(paramMotionEvent.getX() - this.y);
                }
              }
            }
            if (this.p1)
            {
              ViewGroup localViewGroup = (ViewGroup)getChildAt(0);
              localObject = null;
              while (j < localViewGroup.getChildCount())
              {
                if ((localViewGroup.getChildAt(j) instanceof TimeAxisScaleView)) {
                  localObject = localViewGroup.getChildAt(j);
                }
                j++;
              }
              if ((localObject != null) && (getScrollX() + getWidth() == ((View)localObject).getRight()) && (this.z == -1.0F)) {
                this.z = paramMotionEvent.getX();
              }
              if (this.z >= 0.0F)
              {
                localObject = this.d;
                if (localObject != null)
                {
                  this.f = 3;
                  ((a)localObject).b(paramMotionEvent.getX() - this.z);
                }
              }
            }
          }
        }
        else
        {
          j = this.f;
          if (j == 3)
          {
            if (this.p0)
            {
              if (this.y >= 0.0F)
              {
                localObject = this.d;
                if (localObject != null) {
                  ((a)localObject).a(paramMotionEvent.getX() - this.y);
                }
              }
              this.y = -1.0F;
            }
            if (this.p1)
            {
              if (this.z >= 0.0F)
              {
                localObject = this.d;
                if (localObject != null) {
                  ((a)localObject).c(paramMotionEvent.getX() - this.z);
                }
              }
              this.z = -1.0F;
            }
          }
          else if (j != 0)
          {
            this.c.b();
          }
          this.f = 0;
        }
      }
      else
      {
        localObject = this.d;
        if (localObject != null)
        {
          ((a)localObject).d(0.0F);
          this.d.b(0.0F);
        }
        this.q = 0;
        this.f = 0;
        this.y = -1.0F;
        this.z = -1.0F;
      }
    }
    if (this.f == 2) {
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  protected boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
  {
    paramBoolean = super.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
    b localb = this.c;
    if ((localb != null) && (paramBoolean)) {
      if (paramInt1 > 0) {
        localb.g();
      } else {
        localb.c();
      }
    }
    return paramBoolean;
  }
  
  public void setCanLoadLeftMore(boolean paramBoolean)
  {
    this.p0 = paramBoolean;
  }
  
  public void setCanLoadRightMore(boolean paramBoolean)
  {
    this.p1 = paramBoolean;
  }
  
  public void setInterceptTouch(boolean paramBoolean)
  {
    this.p2 = paramBoolean;
  }
  
  public void setOnLoadingMoreListener(a parama)
  {
    this.d = parama;
  }
  
  public void setScrollViewListener(b paramb)
  {
    this.c = paramb;
  }
  
  public static abstract interface a
  {
    public abstract void a(float paramFloat);
    
    public abstract void b(float paramFloat);
    
    public abstract void c(float paramFloat);
    
    public abstract void d(float paramFloat);
  }
  
  protected static abstract interface b
  {
    public abstract void b();
    
    public abstract void c();
    
    public abstract void d(TimeAxisHorizontalScrollView paramTimeAxisHorizontalScrollView, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
    
    public abstract void e();
    
    public abstract void f(float paramFloat);
    
    public abstract void g();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\widget\timeaxis\TimeAxisHorizontalScrollView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */