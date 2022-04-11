package com.tplink.iot.view.ipcamera.widget.multiOperationEditText.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.animation.Interpolator;
import androidx.annotation.ColorInt;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.text.TextDirectionHeuristicCompat;
import androidx.core.text.TextDirectionHeuristicsCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;

public final class b
{
  private static final boolean a;
  private static final Paint b;
  private boolean A;
  private Bitmap B;
  private Paint C;
  private float D;
  private float E;
  private float F;
  private float G;
  private int[] H;
  private boolean I;
  private final TextPaint J;
  private Interpolator K;
  private Interpolator L;
  private float M;
  private float N;
  private float O;
  private int P;
  private float Q;
  private float R;
  private float S;
  private int T;
  private final View c;
  private boolean d;
  private float e;
  private final Rect f;
  private final Rect g;
  private final RectF h;
  private int i = 16;
  private int j = 16;
  private float k = 15.0F;
  private float l = 15.0F;
  private ColorStateList m;
  private ColorStateList n;
  private float o;
  private float p;
  private float q;
  private float r;
  private float s;
  private float t;
  private Typeface u;
  private Typeface v;
  private Typeface w;
  private CharSequence x;
  private CharSequence y;
  private boolean z;
  
  static
  {
    boolean bool;
    if (Build.VERSION.SDK_INT < 18) {
      bool = true;
    } else {
      bool = false;
    }
    a = bool;
    b = null;
    if (0 != 0) {
      throw new NullPointerException();
    }
  }
  
  public b(View paramView)
  {
    this.c = paramView;
    this.J = new TextPaint(129);
    this.g = new Rect();
    this.f = new Rect();
    this.h = new RectF();
  }
  
  private void I(float paramFloat)
  {
    f(paramFloat);
    boolean bool;
    if ((a) && (this.F != 1.0F)) {
      bool = true;
    } else {
      bool = false;
    }
    this.A = bool;
    if (bool) {
      i();
    }
    ViewCompat.postInvalidateOnAnimation(this.c);
  }
  
  private static int a(int paramInt1, int paramInt2, float paramFloat)
  {
    float f1 = 1.0F - paramFloat;
    float f2 = Color.alpha(paramInt1);
    float f3 = Color.alpha(paramInt2);
    float f4 = Color.red(paramInt1);
    float f5 = Color.red(paramInt2);
    float f6 = Color.green(paramInt1);
    float f7 = Color.green(paramInt2);
    float f8 = Color.blue(paramInt1);
    float f9 = Color.blue(paramInt2);
    return Color.argb((int)(f2 * f1 + f3 * paramFloat), (int)(f4 * f1 + f5 * paramFloat), (int)(f6 * f1 + f7 * paramFloat), (int)(f8 * f1 + f9 * paramFloat));
  }
  
  private void b()
  {
    float f1 = this.G;
    f(this.l);
    CharSequence localCharSequence = this.y;
    float f2 = 0.0F;
    if (localCharSequence != null) {
      f3 = this.J.measureText(localCharSequence, 0, localCharSequence.length());
    } else {
      f3 = 0.0F;
    }
    int i1 = GravityCompat.getAbsoluteGravity(this.j, this.z);
    int i2 = i1 & 0x70;
    float f4;
    if (i2 != 48)
    {
      if (i2 != 80)
      {
        f4 = (this.J.descent() - this.J.ascent()) / 2.0F;
        float f5 = this.J.descent();
        this.p = (this.g.centerY() + (f4 - f5));
      }
      else
      {
        this.p = this.g.bottom;
      }
    }
    else {
      this.p = (this.g.top - this.J.ascent());
    }
    i2 = i1 & 0x800007;
    if (i2 != 1)
    {
      if (i2 != 5) {
        this.r = this.g.left;
      } else {
        this.r = (this.g.right - f3);
      }
    }
    else {
      this.r = (this.g.centerX() - f3 / 2.0F);
    }
    f(this.k);
    localCharSequence = this.y;
    float f3 = f2;
    if (localCharSequence != null) {
      f3 = this.J.measureText(localCharSequence, 0, localCharSequence.length());
    }
    i1 = GravityCompat.getAbsoluteGravity(this.i, this.z);
    i2 = i1 & 0x70;
    if (i2 != 48)
    {
      if (i2 != 80)
      {
        f4 = (this.J.descent() - this.J.ascent()) / 2.0F;
        f2 = this.J.descent();
        this.o = (this.f.centerY() + (f4 - f2));
      }
      else
      {
        this.o = this.f.bottom;
      }
    }
    else {
      this.o = (this.f.top - this.J.ascent());
    }
    i2 = i1 & 0x800007;
    if (i2 != 1)
    {
      if (i2 != 5) {
        this.q = this.f.left;
      } else {
        this.q = (this.f.right - f3);
      }
    }
    else {
      this.q = (this.f.centerX() - f3 / 2.0F);
    }
    g();
    I(f1);
  }
  
  private void c()
  {
    e(this.e);
  }
  
  private boolean d(CharSequence paramCharSequence)
  {
    int i1 = ViewCompat.getLayoutDirection(this.c);
    int i2 = 1;
    if (i1 != 1) {
      i2 = 0;
    }
    TextDirectionHeuristicCompat localTextDirectionHeuristicCompat;
    if (i2 != 0) {
      localTextDirectionHeuristicCompat = TextDirectionHeuristicsCompat.FIRSTSTRONG_RTL;
    } else {
      localTextDirectionHeuristicCompat = TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR;
    }
    return localTextDirectionHeuristicCompat.isRtl(paramCharSequence, 0, paramCharSequence.length());
  }
  
  private void e(float paramFloat)
  {
    q(paramFloat);
    this.s = t(this.q, this.r, paramFloat, this.K);
    this.t = t(this.o, this.p, paramFloat, this.K);
    I(t(this.k, this.l, paramFloat, this.L));
    if (this.n != this.m) {
      this.J.setColor(a(n(), m(), paramFloat));
    } else {
      this.J.setColor(m());
    }
    this.J.setShadowLayer(t(this.Q, this.M, paramFloat, null), t(this.R, this.N, paramFloat, null), t(this.S, this.O, paramFloat, null), a(this.T, this.P, paramFloat));
    ViewCompat.postInvalidateOnAnimation(this.c);
  }
  
  private void f(float paramFloat)
  {
    if (this.x == null) {
      return;
    }
    float f1 = this.g.width();
    float f2 = this.f.width();
    boolean bool1 = r(paramFloat, this.l);
    boolean bool2 = true;
    float f3;
    Object localObject;
    Typeface localTypeface;
    int i1;
    if (bool1)
    {
      f3 = this.l;
      this.F = 1.0F;
      localObject = this.w;
      localTypeface = this.u;
      if (localObject != localTypeface)
      {
        this.w = localTypeface;
        i1 = 1;
        paramFloat = f1;
      }
      else
      {
        i1 = 0;
        paramFloat = f1;
      }
    }
    else
    {
      f3 = this.k;
      localTypeface = this.w;
      localObject = this.v;
      if (localTypeface != localObject)
      {
        this.w = ((Typeface)localObject);
        i1 = 1;
      }
      else
      {
        i1 = 0;
      }
      if (r(paramFloat, f3)) {
        this.F = 1.0F;
      } else {
        this.F = (paramFloat / this.k);
      }
      paramFloat = this.l / this.k;
      if (f2 * paramFloat > f1) {
        paramFloat = Math.min(f1 / paramFloat, f2);
      } else {
        paramFloat = f2;
      }
    }
    int i2 = i1;
    if (paramFloat > 0.0F)
    {
      if ((this.G == f3) && (!this.I) && (i1 == 0)) {
        i1 = 0;
      } else {
        i1 = 1;
      }
      this.G = f3;
      this.I = false;
      i2 = i1;
    }
    if ((this.y == null) || (i2 != 0))
    {
      this.J.setTextSize(this.G);
      this.J.setTypeface(this.w);
      localObject = this.J;
      if (this.F == 1.0F) {
        bool2 = false;
      }
      ((TextPaint)localObject).setLinearText(bool2);
      localObject = TextUtils.ellipsize(this.x, this.J, paramFloat, TextUtils.TruncateAt.END);
      if (!TextUtils.equals((CharSequence)localObject, this.y))
      {
        this.y = ((CharSequence)localObject);
        this.z = d((CharSequence)localObject);
      }
    }
  }
  
  private void g()
  {
    Bitmap localBitmap = this.B;
    if (localBitmap != null)
    {
      localBitmap.recycle();
      this.B = null;
    }
  }
  
  private void i()
  {
    if ((this.B == null) && (!this.f.isEmpty()) && (!TextUtils.isEmpty(this.y)))
    {
      e(0.0F);
      this.D = this.J.ascent();
      this.E = this.J.descent();
      Object localObject1 = this.J;
      Object localObject2 = this.y;
      int i1 = Math.round(((TextPaint)localObject1).measureText((CharSequence)localObject2, 0, ((CharSequence)localObject2).length()));
      int i2 = Math.round(this.E - this.D);
      if ((i1 > 0) && (i2 > 0))
      {
        this.B = Bitmap.createBitmap(i1, i2, Bitmap.Config.ARGB_8888);
        localObject2 = new Canvas(this.B);
        localObject1 = this.y;
        ((Canvas)localObject2).drawText((CharSequence)localObject1, 0, ((CharSequence)localObject1).length(), 0.0F, i2 - this.J.descent(), this.J);
        if (this.C == null) {
          this.C = new Paint(3);
        }
      }
    }
  }
  
  @ColorInt
  private int m()
  {
    int[] arrayOfInt = this.H;
    if (arrayOfInt != null) {
      return this.n.getColorForState(arrayOfInt, 0);
    }
    return this.n.getDefaultColor();
  }
  
  @ColorInt
  private int n()
  {
    int[] arrayOfInt = this.H;
    if (arrayOfInt != null) {
      return this.m.getColorForState(arrayOfInt, 0);
    }
    return this.m.getDefaultColor();
  }
  
  private void q(float paramFloat)
  {
    this.h.left = t(this.f.left, this.g.left, paramFloat, this.K);
    this.h.top = t(this.o, this.p, paramFloat, this.K);
    this.h.right = t(this.f.right, this.g.right, paramFloat, this.K);
    this.h.bottom = t(this.f.bottom, this.g.bottom, paramFloat, this.K);
  }
  
  private static boolean r(float paramFloat1, float paramFloat2)
  {
    boolean bool;
    if (Math.abs(paramFloat1 - paramFloat2) < 0.001F) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private static float t(float paramFloat1, float paramFloat2, float paramFloat3, Interpolator paramInterpolator)
  {
    float f1 = paramFloat3;
    if (paramInterpolator != null) {
      f1 = paramInterpolator.getInterpolation(paramFloat3);
    }
    return a.a(paramFloat1, paramFloat2, f1);
  }
  
  private Typeface v(int paramInt)
  {
    TypedArray localTypedArray = this.c.getContext().obtainStyledAttributes(paramInt, new int[] { 16843692 });
    try
    {
      Object localObject1 = localTypedArray.getString(0);
      if (localObject1 != null)
      {
        localObject1 = Typeface.create((String)localObject1, 0);
        return (Typeface)localObject1;
      }
      return null;
    }
    finally
    {
      localTypedArray.recycle();
    }
  }
  
  private static boolean x(Rect paramRect, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool;
    if ((paramRect.left == paramInt1) && (paramRect.top == paramInt2) && (paramRect.right == paramInt3) && (paramRect.bottom == paramInt4)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void A(ColorStateList paramColorStateList)
  {
    if (this.n != paramColorStateList)
    {
      this.n = paramColorStateList;
      w();
    }
  }
  
  public void B(int paramInt)
  {
    if (this.j != paramInt)
    {
      this.j = paramInt;
      w();
    }
  }
  
  public void C(float paramFloat)
  {
    if (this.l != paramFloat)
    {
      this.l = paramFloat;
      w();
    }
  }
  
  public void D(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!x(this.f, paramInt1, paramInt2, paramInt3, paramInt4))
    {
      this.f.set(paramInt1, paramInt2, paramInt3, paramInt4);
      this.I = true;
      u();
    }
  }
  
  public void E(ColorStateList paramColorStateList)
  {
    if (this.m != paramColorStateList)
    {
      this.m = paramColorStateList;
      w();
    }
  }
  
  public void F(int paramInt)
  {
    if (this.i != paramInt)
    {
      this.i = paramInt;
      w();
    }
  }
  
  public void G(float paramFloat)
  {
    if (this.k != paramFloat)
    {
      this.k = paramFloat;
      w();
    }
  }
  
  public void H(float paramFloat)
  {
    paramFloat = d.a(paramFloat, 0.0F, 1.0F);
    if (paramFloat != this.e)
    {
      this.e = paramFloat;
      c();
    }
  }
  
  public void J(Interpolator paramInterpolator)
  {
    this.K = paramInterpolator;
    w();
  }
  
  public final boolean K(int[] paramArrayOfInt)
  {
    this.H = paramArrayOfInt;
    if (s())
    {
      w();
      return true;
    }
    return false;
  }
  
  public void L(CharSequence paramCharSequence)
  {
    if ((paramCharSequence == null) || (!paramCharSequence.equals(this.x)))
    {
      this.x = paramCharSequence;
      this.y = null;
      g();
      w();
    }
  }
  
  public void M(Interpolator paramInterpolator)
  {
    this.L = paramInterpolator;
    w();
  }
  
  public void N(Typeface paramTypeface)
  {
    this.v = paramTypeface;
    this.u = paramTypeface;
    w();
  }
  
  public void h(Canvas paramCanvas)
  {
    int i1 = paramCanvas.save();
    if ((this.y != null) && (this.d))
    {
      float f1 = this.s;
      float f2 = this.t;
      int i2;
      if ((this.A) && (this.B != null)) {
        i2 = 1;
      } else {
        i2 = 0;
      }
      if (i2 != 0)
      {
        f3 = this.D * this.F;
      }
      else
      {
        f3 = this.J.ascent() * this.F;
        this.J.descent();
      }
      float f4 = f2;
      if (i2 != 0) {
        f4 = f2 + f3;
      }
      float f3 = this.F;
      if (f3 != 1.0F) {
        paramCanvas.scale(f3, f3, f1, f4);
      }
      if (i2 != 0)
      {
        paramCanvas.drawBitmap(this.B, f1, f4, this.C);
      }
      else
      {
        CharSequence localCharSequence = this.y;
        paramCanvas.drawText(localCharSequence, 0, localCharSequence.length(), f1, f4, this.J);
      }
    }
    paramCanvas.restoreToCount(i1);
  }
  
  public ColorStateList j()
  {
    return this.n;
  }
  
  public float k()
  {
    return this.l;
  }
  
  public Typeface l()
  {
    Typeface localTypeface = this.u;
    if (localTypeface == null) {
      localTypeface = Typeface.DEFAULT;
    }
    return localTypeface;
  }
  
  public float o()
  {
    return this.e;
  }
  
  public CharSequence p()
  {
    return this.x;
  }
  
  final boolean s()
  {
    ColorStateList localColorStateList = this.n;
    if ((localColorStateList == null) || (!localColorStateList.isStateful()))
    {
      localColorStateList = this.m;
      if ((localColorStateList == null) || (!localColorStateList.isStateful())) {}
    }
    else
    {
      return true;
    }
    boolean bool = false;
    return bool;
  }
  
  void u()
  {
    boolean bool;
    if ((this.g.width() > 0) && (this.g.height() > 0) && (this.f.width() > 0) && (this.f.height() > 0)) {
      bool = true;
    } else {
      bool = false;
    }
    this.d = bool;
  }
  
  public void w()
  {
    if ((this.c.getHeight() > 0) && (this.c.getWidth() > 0))
    {
      b();
      c();
    }
  }
  
  public void y(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!x(this.g, paramInt1, paramInt2, paramInt3, paramInt4))
    {
      this.g.set(paramInt1, paramInt2, paramInt3, paramInt4);
      this.I = true;
      u();
    }
  }
  
  @SuppressLint({"RestrictedApi"})
  public void z(int paramInt)
  {
    TintTypedArray localTintTypedArray = TintTypedArray.obtainStyledAttributes(this.c.getContext(), paramInt, com.tplink.iot.b.TextAppearance);
    if (localTintTypedArray.hasValue(3)) {
      this.n = localTintTypedArray.getColorStateList(3);
    }
    if (localTintTypedArray.hasValue(0)) {
      this.l = localTintTypedArray.getDimensionPixelSize(0, (int)this.l);
    }
    this.P = localTintTypedArray.getInt(7, 0);
    this.N = localTintTypedArray.getFloat(8, 0.0F);
    this.O = localTintTypedArray.getFloat(9, 0.0F);
    this.M = localTintTypedArray.getFloat(10, 0.0F);
    localTintTypedArray.recycle();
    if (Build.VERSION.SDK_INT >= 16) {
      this.u = v(paramInt);
    }
    w();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\widget\multiOperationEditText\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */