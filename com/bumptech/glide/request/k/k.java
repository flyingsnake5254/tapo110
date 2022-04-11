package com.bumptech.glide.request.k;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.WindowManager;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.g;
import com.bumptech.glide.request.d;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Deprecated
public abstract class k<T extends View, Z>
  extends a<Z>
{
  private static boolean d;
  private static int f = g.glide_custom_view_target_tag;
  private boolean p0;
  protected final T q;
  private final a x;
  @Nullable
  private View.OnAttachStateChangeListener y;
  private boolean z;
  
  public k(@NonNull T paramT)
  {
    this.q = ((View)com.bumptech.glide.util.i.d(paramT));
    this.x = new a(paramT);
  }
  
  @Nullable
  private Object g()
  {
    return this.q.getTag(f);
  }
  
  private void i()
  {
    View.OnAttachStateChangeListener localOnAttachStateChangeListener = this.y;
    if ((localOnAttachStateChangeListener != null) && (!this.p0))
    {
      this.q.addOnAttachStateChangeListener(localOnAttachStateChangeListener);
      this.p0 = true;
    }
  }
  
  private void k()
  {
    View.OnAttachStateChangeListener localOnAttachStateChangeListener = this.y;
    if ((localOnAttachStateChangeListener != null) && (this.p0))
    {
      this.q.removeOnAttachStateChangeListener(localOnAttachStateChangeListener);
      this.p0 = false;
    }
  }
  
  private void l(@Nullable Object paramObject)
  {
    d = true;
    this.q.setTag(f, paramObject);
  }
  
  @CallSuper
  public void a(@NonNull i parami)
  {
    this.x.k(parami);
  }
  
  @CallSuper
  public void b(@Nullable Drawable paramDrawable)
  {
    super.b(paramDrawable);
    i();
  }
  
  @Nullable
  public d c()
  {
    Object localObject = g();
    if (localObject != null)
    {
      if ((localObject instanceof d)) {
        localObject = (d)localObject;
      } else {
        throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
      }
    }
    else {
      localObject = null;
    }
    return (d)localObject;
  }
  
  @CallSuper
  public void d(@Nullable Drawable paramDrawable)
  {
    super.d(paramDrawable);
    this.x.b();
    if (!this.z) {
      k();
    }
  }
  
  public void f(@Nullable d paramd)
  {
    l(paramd);
  }
  
  @CallSuper
  public void j(@NonNull i parami)
  {
    this.x.d(parami);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Target for: ");
    localStringBuilder.append(this.q);
    return localStringBuilder.toString();
  }
  
  @VisibleForTesting
  static final class a
  {
    @Nullable
    @VisibleForTesting
    static Integer a;
    private final View b;
    private final List<i> c = new ArrayList();
    boolean d;
    @Nullable
    private a e;
    
    a(@NonNull View paramView)
    {
      this.b = paramView;
    }
    
    private static int c(@NonNull Context paramContext)
    {
      if (a == null)
      {
        Display localDisplay = ((WindowManager)com.bumptech.glide.util.i.d((WindowManager)paramContext.getSystemService("window"))).getDefaultDisplay();
        paramContext = new Point();
        localDisplay.getSize(paramContext);
        a = Integer.valueOf(Math.max(paramContext.x, paramContext.y));
      }
      return a.intValue();
    }
    
    private int e(int paramInt1, int paramInt2, int paramInt3)
    {
      int i = paramInt2 - paramInt3;
      if (i > 0) {
        return i;
      }
      if ((this.d) && (this.b.isLayoutRequested())) {
        return 0;
      }
      paramInt1 -= paramInt3;
      if (paramInt1 > 0) {
        return paramInt1;
      }
      if ((!this.b.isLayoutRequested()) && (paramInt2 == -2))
      {
        if (Log.isLoggable("ViewTarget", 4)) {
          Log.i("ViewTarget", "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
        }
        return c(this.b.getContext());
      }
      return 0;
    }
    
    private int f()
    {
      int i = this.b.getPaddingTop();
      int j = this.b.getPaddingBottom();
      ViewGroup.LayoutParams localLayoutParams = this.b.getLayoutParams();
      int k;
      if (localLayoutParams != null) {
        k = localLayoutParams.height;
      } else {
        k = 0;
      }
      return e(this.b.getHeight(), k, i + j);
    }
    
    private int g()
    {
      int i = this.b.getPaddingLeft();
      int j = this.b.getPaddingRight();
      ViewGroup.LayoutParams localLayoutParams = this.b.getLayoutParams();
      int k;
      if (localLayoutParams != null) {
        k = localLayoutParams.width;
      } else {
        k = 0;
      }
      return e(this.b.getWidth(), k, i + j);
    }
    
    private boolean h(int paramInt)
    {
      boolean bool;
      if ((paramInt <= 0) && (paramInt != Integer.MIN_VALUE)) {
        bool = false;
      } else {
        bool = true;
      }
      return bool;
    }
    
    private boolean i(int paramInt1, int paramInt2)
    {
      boolean bool;
      if ((h(paramInt1)) && (h(paramInt2))) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    private void j(int paramInt1, int paramInt2)
    {
      Iterator localIterator = new ArrayList(this.c).iterator();
      while (localIterator.hasNext()) {
        ((i)localIterator.next()).d(paramInt1, paramInt2);
      }
    }
    
    void a()
    {
      if (this.c.isEmpty()) {
        return;
      }
      int i = g();
      int j = f();
      if (!i(i, j)) {
        return;
      }
      j(i, j);
      b();
    }
    
    void b()
    {
      ViewTreeObserver localViewTreeObserver = this.b.getViewTreeObserver();
      if (localViewTreeObserver.isAlive()) {
        localViewTreeObserver.removeOnPreDrawListener(this.e);
      }
      this.e = null;
      this.c.clear();
    }
    
    void d(@NonNull i parami)
    {
      int i = g();
      int j = f();
      if (i(i, j))
      {
        parami.d(i, j);
        return;
      }
      if (!this.c.contains(parami)) {
        this.c.add(parami);
      }
      if (this.e == null)
      {
        ViewTreeObserver localViewTreeObserver = this.b.getViewTreeObserver();
        parami = new a(this);
        this.e = parami;
        localViewTreeObserver.addOnPreDrawListener(parami);
      }
    }
    
    void k(@NonNull i parami)
    {
      this.c.remove(parami);
    }
    
    private static final class a
      implements ViewTreeObserver.OnPreDrawListener
    {
      private final WeakReference<k.a> c;
      
      a(@NonNull k.a parama)
      {
        this.c = new WeakReference(parama);
      }
      
      public boolean onPreDraw()
      {
        if (Log.isLoggable("ViewTarget", 2))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("OnGlobalLayoutListener called attachStateListener=");
          ((StringBuilder)localObject).append(this);
          Log.v("ViewTarget", ((StringBuilder)localObject).toString());
        }
        Object localObject = (k.a)this.c.get();
        if (localObject != null) {
          ((k.a)localObject).a();
        }
        return true;
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\request\k\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */