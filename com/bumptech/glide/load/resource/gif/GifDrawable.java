package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.view.Gravity;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat.AnimationCallback;
import com.bumptech.glide.c;
import com.bumptech.glide.l.a;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class GifDrawable
  extends Drawable
  implements f.b, Animatable, Animatable2Compat
{
  private final a c;
  private boolean d;
  private boolean f;
  private boolean p0;
  private Paint p1;
  private Rect p2;
  private List<Animatable2Compat.AnimationCallback> p3;
  private boolean q;
  private boolean x = true;
  private int y;
  private int z = -1;
  
  public GifDrawable(Context paramContext, a parama, com.bumptech.glide.load.i<Bitmap> parami, int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    this(new a(new f(c.c(paramContext), parama, paramInt1, paramInt2, parami, paramBitmap)));
  }
  
  GifDrawable(a parama)
  {
    this.c = ((a)com.bumptech.glide.util.i.d(parama));
  }
  
  private Drawable.Callback b()
  {
    for (Drawable.Callback localCallback = getCallback(); (localCallback instanceof Drawable); localCallback = ((Drawable)localCallback).getCallback()) {}
    return localCallback;
  }
  
  private Rect d()
  {
    if (this.p2 == null) {
      this.p2 = new Rect();
    }
    return this.p2;
  }
  
  private Paint h()
  {
    if (this.p1 == null) {
      this.p1 = new Paint(2);
    }
    return this.p1;
  }
  
  private void j()
  {
    List localList = this.p3;
    if (localList != null)
    {
      int i = 0;
      int j = localList.size();
      while (i < j)
      {
        ((Animatable2Compat.AnimationCallback)this.p3.get(i)).onAnimationEnd(this);
        i++;
      }
    }
  }
  
  private void l()
  {
    this.y = 0;
  }
  
  private void n()
  {
    com.bumptech.glide.util.i.a(this.q ^ true, "You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.");
    if (this.c.a.f() == 1)
    {
      invalidateSelf();
    }
    else if (!this.d)
    {
      this.d = true;
      this.c.a.r(this);
      invalidateSelf();
    }
  }
  
  private void o()
  {
    this.d = false;
    this.c.a.s(this);
  }
  
  public void a()
  {
    if (b() == null)
    {
      stop();
      invalidateSelf();
      return;
    }
    invalidateSelf();
    if (g() == f() - 1) {
      this.y += 1;
    }
    int i = this.z;
    if ((i != -1) && (this.y >= i))
    {
      j();
      stop();
    }
  }
  
  public ByteBuffer c()
  {
    return this.c.a.b();
  }
  
  public void clearAnimationCallbacks()
  {
    List localList = this.p3;
    if (localList != null) {
      localList.clear();
    }
  }
  
  public void draw(@NonNull Canvas paramCanvas)
  {
    if (this.q) {
      return;
    }
    if (this.p0)
    {
      Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), d());
      this.p0 = false;
    }
    paramCanvas.drawBitmap(this.c.a.c(), null, d(), h());
  }
  
  public Bitmap e()
  {
    return this.c.a.e();
  }
  
  public int f()
  {
    return this.c.a.f();
  }
  
  public int g()
  {
    return this.c.a.d();
  }
  
  public Drawable.ConstantState getConstantState()
  {
    return this.c;
  }
  
  public int getIntrinsicHeight()
  {
    return this.c.a.h();
  }
  
  public int getIntrinsicWidth()
  {
    return this.c.a.k();
  }
  
  public int getOpacity()
  {
    return -2;
  }
  
  public int i()
  {
    return this.c.a.j();
  }
  
  public boolean isRunning()
  {
    return this.d;
  }
  
  public void k()
  {
    this.q = true;
    this.c.a.a();
  }
  
  public void m(com.bumptech.glide.load.i<Bitmap> parami, Bitmap paramBitmap)
  {
    this.c.a.o(parami, paramBitmap);
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    this.p0 = true;
  }
  
  public void registerAnimationCallback(@NonNull Animatable2Compat.AnimationCallback paramAnimationCallback)
  {
    if (paramAnimationCallback == null) {
      return;
    }
    if (this.p3 == null) {
      this.p3 = new ArrayList();
    }
    this.p3.add(paramAnimationCallback);
  }
  
  public void setAlpha(int paramInt)
  {
    h().setAlpha(paramInt);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    h().setColorFilter(paramColorFilter);
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    com.bumptech.glide.util.i.a(this.q ^ true, "Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.");
    this.x = paramBoolean1;
    if (!paramBoolean1) {
      o();
    } else if (this.f) {
      n();
    }
    return super.setVisible(paramBoolean1, paramBoolean2);
  }
  
  public void start()
  {
    this.f = true;
    l();
    if (this.x) {
      n();
    }
  }
  
  public void stop()
  {
    this.f = false;
    o();
  }
  
  public boolean unregisterAnimationCallback(@NonNull Animatable2Compat.AnimationCallback paramAnimationCallback)
  {
    List localList = this.p3;
    if ((localList != null) && (paramAnimationCallback != null)) {
      return localList.remove(paramAnimationCallback);
    }
    return false;
  }
  
  static final class a
    extends Drawable.ConstantState
  {
    @VisibleForTesting
    final f a;
    
    a(f paramf)
    {
      this.a = paramf;
    }
    
    public int getChangingConfigurations()
    {
      return 0;
    }
    
    @NonNull
    public Drawable newDrawable()
    {
      return new GifDrawable(this);
    }
    
    @NonNull
    public Drawable newDrawable(Resources paramResources)
    {
      return newDrawable();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\resource\gif\GifDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */