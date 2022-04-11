package com.google.android.material.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

class ViewOverlayApi14
  implements ViewOverlayImpl
{
  protected OverlayViewGroup overlayViewGroup = new OverlayViewGroup(paramContext, paramViewGroup, paramView, this);
  
  ViewOverlayApi14(Context paramContext, ViewGroup paramViewGroup, View paramView) {}
  
  static ViewOverlayApi14 createFrom(View paramView)
  {
    ViewGroup localViewGroup = ViewUtils.getContentView(paramView);
    if (localViewGroup != null)
    {
      int i = localViewGroup.getChildCount();
      for (int j = 0; j < i; j++)
      {
        View localView = localViewGroup.getChildAt(j);
        if ((localView instanceof OverlayViewGroup)) {
          return ((OverlayViewGroup)localView).viewOverlay;
        }
      }
      return new ViewGroupOverlayApi14(localViewGroup.getContext(), localViewGroup, paramView);
    }
    return null;
  }
  
  public void add(@NonNull Drawable paramDrawable)
  {
    this.overlayViewGroup.add(paramDrawable);
  }
  
  public void remove(@NonNull Drawable paramDrawable)
  {
    this.overlayViewGroup.remove(paramDrawable);
  }
  
  @SuppressLint({"ViewConstructor", "PrivateApi"})
  static class OverlayViewGroup
    extends ViewGroup
  {
    static Method invalidateChildInParentFastMethod;
    private boolean disposed;
    ArrayList<Drawable> drawables = null;
    ViewGroup hostView;
    View requestingView;
    ViewOverlayApi14 viewOverlay;
    
    static
    {
      try
      {
        Class localClass = Integer.TYPE;
        invalidateChildInParentFastMethod = ViewGroup.class.getDeclaredMethod("invalidateChildInParentFast", new Class[] { localClass, localClass, Rect.class });
        return;
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        for (;;) {}
      }
    }
    
    OverlayViewGroup(Context paramContext, ViewGroup paramViewGroup, View paramView, ViewOverlayApi14 paramViewOverlayApi14)
    {
      super();
      this.hostView = paramViewGroup;
      this.requestingView = paramView;
      setRight(paramViewGroup.getWidth());
      setBottom(paramViewGroup.getHeight());
      paramViewGroup.addView(this);
      this.viewOverlay = paramViewOverlayApi14;
    }
    
    private void assertNotDisposed()
    {
      if (!this.disposed) {
        return;
      }
      throw new IllegalStateException("This overlay was disposed already. Please use a new one via ViewGroupUtils.getOverlay()");
    }
    
    private void disposeIfEmpty()
    {
      if (getChildCount() == 0)
      {
        ArrayList localArrayList = this.drawables;
        if ((localArrayList == null) || (localArrayList.size() == 0))
        {
          this.disposed = true;
          this.hostView.removeView(this);
        }
      }
    }
    
    private void getOffset(int[] paramArrayOfInt)
    {
      int[] arrayOfInt1 = new int[2];
      int[] arrayOfInt2 = new int[2];
      this.hostView.getLocationOnScreen(arrayOfInt1);
      this.requestingView.getLocationOnScreen(arrayOfInt2);
      arrayOfInt2[0] -= arrayOfInt1[0];
      arrayOfInt2[1] -= arrayOfInt1[1];
    }
    
    public void add(Drawable paramDrawable)
    {
      assertNotDisposed();
      if (this.drawables == null) {
        this.drawables = new ArrayList();
      }
      if (!this.drawables.contains(paramDrawable))
      {
        this.drawables.add(paramDrawable);
        invalidate(paramDrawable.getBounds());
        paramDrawable.setCallback(this);
      }
    }
    
    public void add(View paramView)
    {
      assertNotDisposed();
      if ((paramView.getParent() instanceof ViewGroup))
      {
        ViewGroup localViewGroup = (ViewGroup)paramView.getParent();
        if ((localViewGroup != this.hostView) && (localViewGroup.getParent() != null) && (ViewCompat.isAttachedToWindow(localViewGroup)))
        {
          int[] arrayOfInt1 = new int[2];
          int[] arrayOfInt2 = new int[2];
          localViewGroup.getLocationOnScreen(arrayOfInt1);
          this.hostView.getLocationOnScreen(arrayOfInt2);
          ViewCompat.offsetLeftAndRight(paramView, arrayOfInt1[0] - arrayOfInt2[0]);
          ViewCompat.offsetTopAndBottom(paramView, arrayOfInt1[1] - arrayOfInt2[1]);
        }
        localViewGroup.removeView(paramView);
        if (paramView.getParent() != null) {
          localViewGroup.removeView(paramView);
        }
      }
      super.addView(paramView);
    }
    
    protected void dispatchDraw(Canvas paramCanvas)
    {
      Object localObject = new int[2];
      int[] arrayOfInt = new int[2];
      this.hostView.getLocationOnScreen((int[])localObject);
      this.requestingView.getLocationOnScreen(arrayOfInt);
      int i = 0;
      paramCanvas.translate(arrayOfInt[0] - localObject[0], arrayOfInt[1] - localObject[1]);
      paramCanvas.clipRect(new Rect(0, 0, this.requestingView.getWidth(), this.requestingView.getHeight()));
      super.dispatchDraw(paramCanvas);
      localObject = this.drawables;
      int j;
      if (localObject == null) {
        j = 0;
      } else {
        j = ((ArrayList)localObject).size();
      }
      while (i < j)
      {
        ((Drawable)this.drawables.get(i)).draw(paramCanvas);
        i++;
      }
    }
    
    public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
    {
      return false;
    }
    
    public ViewParent invalidateChildInParent(int[] paramArrayOfInt, Rect paramRect)
    {
      if (this.hostView != null)
      {
        paramRect.offset(paramArrayOfInt[0], paramArrayOfInt[1]);
        if (this.hostView != null)
        {
          paramArrayOfInt[0] = 0;
          paramArrayOfInt[1] = 0;
          int[] arrayOfInt = new int[2];
          getOffset(arrayOfInt);
          paramRect.offset(arrayOfInt[0], arrayOfInt[1]);
          return super.invalidateChildInParent(paramArrayOfInt, paramRect);
        }
        invalidate(paramRect);
      }
      return null;
    }
    
    @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    protected ViewParent invalidateChildInParentFast(int paramInt1, int paramInt2, Rect paramRect)
    {
      if ((this.hostView != null) && (invalidateChildInParentFastMethod != null)) {
        try
        {
          getOffset(new int[2]);
          invalidateChildInParentFastMethod.invoke(this.hostView, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramRect });
        }
        catch (InvocationTargetException paramRect)
        {
          paramRect.printStackTrace();
        }
        catch (IllegalAccessException paramRect)
        {
          paramRect.printStackTrace();
        }
      }
      return null;
    }
    
    public void invalidateDrawable(@NonNull Drawable paramDrawable)
    {
      invalidate(paramDrawable.getBounds());
    }
    
    protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
    
    public void remove(Drawable paramDrawable)
    {
      ArrayList localArrayList = this.drawables;
      if (localArrayList != null)
      {
        localArrayList.remove(paramDrawable);
        invalidate(paramDrawable.getBounds());
        paramDrawable.setCallback(null);
        disposeIfEmpty();
      }
    }
    
    public void remove(View paramView)
    {
      super.removeView(paramView);
      disposeIfEmpty();
    }
    
    protected boolean verifyDrawable(@NonNull Drawable paramDrawable)
    {
      if (!super.verifyDrawable(paramDrawable))
      {
        ArrayList localArrayList = this.drawables;
        if ((localArrayList == null) || (!localArrayList.contains(paramDrawable))) {
          return false;
        }
      }
      boolean bool = true;
      return bool;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\internal\ViewOverlayApi14.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */