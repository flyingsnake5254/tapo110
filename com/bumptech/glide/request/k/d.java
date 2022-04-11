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
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.g;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class d<T extends View, Z>
  implements j<Z>
{
  @IdRes
  private static final int c = g.glide_custom_view_target_tag;
  private final a d;
  protected final T f;
  @Nullable
  private View.OnAttachStateChangeListener q;
  private boolean x;
  private boolean y;
  
  public d(@NonNull T paramT)
  {
    this.f = ((View)com.bumptech.glide.util.i.d(paramT));
    this.d = new a(paramT);
  }
  
  @Nullable
  private Object g()
  {
    return this.f.getTag(c);
  }
  
  private void i()
  {
    View.OnAttachStateChangeListener localOnAttachStateChangeListener = this.q;
    if ((localOnAttachStateChangeListener != null) && (!this.y))
    {
      this.f.addOnAttachStateChangeListener(localOnAttachStateChangeListener);
      this.y = true;
    }
  }
  
  private void k()
  {
    View.OnAttachStateChangeListener localOnAttachStateChangeListener = this.q;
    if ((localOnAttachStateChangeListener != null) && (this.y))
    {
      this.f.removeOnAttachStateChangeListener(localOnAttachStateChangeListener);
      this.y = false;
    }
  }
  
  private void n(@Nullable Object paramObject)
  {
    this.f.setTag(c, paramObject);
  }
  
  public final void a(@NonNull i parami)
  {
    this.d.k(parami);
  }
  
  public final void b(@Nullable Drawable paramDrawable)
  {
    i();
    m(paramDrawable);
  }
  
  @Nullable
  public final com.bumptech.glide.request.d c()
  {
    Object localObject = g();
    if (localObject != null)
    {
      if ((localObject instanceof com.bumptech.glide.request.d)) {
        return (com.bumptech.glide.request.d)localObject;
      }
      throw new IllegalArgumentException("You must not pass non-R.id ids to setTag(id)");
    }
    return null;
  }
  
  public final void d(@Nullable Drawable paramDrawable)
  {
    this.d.b();
    l(paramDrawable);
    if (!this.x) {
      k();
    }
  }
  
  public final void f(@Nullable com.bumptech.glide.request.d paramd)
  {
    n(paramd);
  }
  
  public final void j(@NonNull i parami)
  {
    this.d.d(parami);
  }
  
  protected abstract void l(@Nullable Drawable paramDrawable);
  
  protected void m(@Nullable Drawable paramDrawable) {}
  
  public void onDestroy() {}
  
  public void onStart() {}
  
  public void onStop() {}
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Target for: ");
    localStringBuilder.append(this.f);
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
        if (Log.isLoggable("CustomViewTarget", 4)) {
          Log.i("CustomViewTarget", "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use .override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
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
        parami = this.b.getViewTreeObserver();
        a locala = new a(this);
        this.e = locala;
        parami.addOnPreDrawListener(locala);
      }
    }
    
    void k(@NonNull i parami)
    {
      this.c.remove(parami);
    }
    
    private static final class a
      implements ViewTreeObserver.OnPreDrawListener
    {
      private final WeakReference<d.a> c;
      
      a(@NonNull d.a parama)
      {
        this.c = new WeakReference(parama);
      }
      
      public boolean onPreDraw()
      {
        if (Log.isLoggable("CustomViewTarget", 2))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("OnGlobalLayoutListener called attachStateListener=");
          ((StringBuilder)localObject).append(this);
          Log.v("CustomViewTarget", ((StringBuilder)localObject).toString());
        }
        Object localObject = (d.a)this.c.get();
        if (localObject != null) {
          ((d.a)localObject).a();
        }
        return true;
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\request\k\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */