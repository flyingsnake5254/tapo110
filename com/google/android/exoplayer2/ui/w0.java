package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.text.Layout.Alignment;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.text.c;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.u;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

final class w0
{
  private int A;
  private int B;
  private int C;
  private int D;
  private StaticLayout E;
  private StaticLayout F;
  private int G;
  private int H;
  private int I;
  private Rect J;
  private final float a;
  private final float b;
  private final float c;
  private final float d;
  private final float e;
  private final TextPaint f;
  private final Paint g;
  private final Paint h;
  @Nullable
  private CharSequence i;
  @Nullable
  private Layout.Alignment j;
  @Nullable
  private Bitmap k;
  private float l;
  private int m;
  private int n;
  private float o;
  private int p;
  private float q;
  private float r;
  private int s;
  private int t;
  private int u;
  private int v;
  private int w;
  private float x;
  private float y;
  private float z;
  
  public w0(Context paramContext)
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(null, new int[] { 16843287, 16843288 }, 0, 0);
    this.e = localTypedArray.getDimensionPixelSize(0, 0);
    this.d = localTypedArray.getFloat(1, 1.0F);
    localTypedArray.recycle();
    float f1 = Math.round(paramContext.getResources().getDisplayMetrics().densityDpi * 2.0F / 160.0F);
    this.a = f1;
    this.b = f1;
    this.c = f1;
    paramContext = new TextPaint();
    this.f = paramContext;
    paramContext.setAntiAlias(true);
    paramContext.setSubpixelText(true);
    paramContext = new Paint();
    this.g = paramContext;
    paramContext.setAntiAlias(true);
    paramContext.setStyle(Paint.Style.FILL);
    paramContext = new Paint();
    this.h = paramContext;
    paramContext.setAntiAlias(true);
    paramContext.setFilterBitmap(true);
  }
  
  private static boolean a(@Nullable CharSequence paramCharSequence1, @Nullable CharSequence paramCharSequence2)
  {
    boolean bool;
    if ((paramCharSequence1 != paramCharSequence2) && ((paramCharSequence1 == null) || (!paramCharSequence1.equals(paramCharSequence2)))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  @RequiresNonNull({"cueBitmap", "bitmapRect"})
  private void c(Canvas paramCanvas)
  {
    paramCanvas.drawBitmap(this.k, null, this.J, this.h);
  }
  
  private void d(Canvas paramCanvas, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      e(paramCanvas);
    }
    else
    {
      g.e(this.J);
      g.e(this.k);
      c(paramCanvas);
    }
  }
  
  private void e(Canvas paramCanvas)
  {
    StaticLayout localStaticLayout1 = this.E;
    StaticLayout localStaticLayout2 = this.F;
    if ((localStaticLayout1 != null) && (localStaticLayout2 != null))
    {
      int i1 = paramCanvas.save();
      paramCanvas.translate(this.G, this.H);
      if (Color.alpha(this.u) > 0)
      {
        this.g.setColor(this.u);
        paramCanvas.drawRect(-this.I, 0.0F, localStaticLayout1.getWidth() + this.I, localStaticLayout1.getHeight(), this.g);
      }
      int i2 = this.w;
      int i3 = 1;
      if (i2 == 1)
      {
        this.f.setStrokeJoin(Paint.Join.ROUND);
        this.f.setStrokeWidth(this.a);
        this.f.setColor(this.v);
        this.f.setStyle(Paint.Style.FILL_AND_STROKE);
        localStaticLayout2.draw(paramCanvas);
      }
      else
      {
        TextPaint localTextPaint;
        float f1;
        float f2;
        if (i2 == 2)
        {
          localTextPaint = this.f;
          f1 = this.b;
          f2 = this.c;
          localTextPaint.setShadowLayer(f1, f2, f2, this.v);
        }
        else if ((i2 == 3) || (i2 == 4))
        {
          if (i2 != 3) {
            i3 = 0;
          }
          int i4 = -1;
          if (i3 != 0) {
            i2 = -1;
          } else {
            i2 = this.v;
          }
          if (i3 != 0) {
            i4 = this.v;
          }
          float f3 = this.b / 2.0F;
          this.f.setColor(this.s);
          this.f.setStyle(Paint.Style.FILL);
          localTextPaint = this.f;
          f1 = this.b;
          f2 = -f3;
          localTextPaint.setShadowLayer(f1, f2, f2, i2);
          localStaticLayout2.draw(paramCanvas);
          this.f.setShadowLayer(this.b, f3, f3, i4);
        }
      }
      this.f.setColor(this.s);
      this.f.setStyle(Paint.Style.FILL);
      localStaticLayout1.draw(paramCanvas);
      this.f.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
      paramCanvas.restoreToCount(i1);
    }
  }
  
  @RequiresNonNull({"cueBitmap"})
  private void f()
  {
    Bitmap localBitmap = this.k;
    int i1 = this.C;
    int i2 = this.A;
    int i3 = this.D;
    int i4 = this.B;
    float f1 = i2;
    float f2 = i1 - i2;
    float f3 = f1 + this.o * f2;
    float f4 = i4;
    f1 = i3 - i4;
    f4 += this.l * f1;
    i1 = Math.round(f2 * this.q);
    f2 = this.r;
    if (f2 != -3.4028235E38F) {
      i3 = Math.round(f1 * f2);
    } else {
      i3 = Math.round(i1 * (localBitmap.getHeight() / localBitmap.getWidth()));
    }
    i2 = this.p;
    if (i2 == 2) {}
    for (f1 = i1;; f1 = i1 / 2)
    {
      f1 = f3 - f1;
      break;
      f1 = f3;
      if (i2 != 1) {
        break;
      }
    }
    i2 = Math.round(f1);
    i4 = this.n;
    if (i4 == 2) {}
    for (f1 = i3;; f1 = i3 / 2)
    {
      f1 = f4 - f1;
      break;
      f1 = f4;
      if (i4 != 1) {
        break;
      }
    }
    i4 = Math.round(f1);
    this.J = new Rect(i2, i4, i1 + i2, i3 + i4);
  }
  
  @RequiresNonNull({"cueText"})
  private void g()
  {
    Object localObject1 = this.i;
    if ((localObject1 instanceof SpannableStringBuilder)) {
      localObject1 = (SpannableStringBuilder)localObject1;
    } else {
      localObject1 = new SpannableStringBuilder(this.i);
    }
    int i1 = this.C - this.A;
    int i2 = this.D - this.B;
    this.f.setTextSize(this.x);
    int i3 = (int)(this.x * 0.125F + 0.5F);
    int i4 = i3 * 2;
    int i5 = i1 - i4;
    float f1 = this.q;
    int i6 = i5;
    if (f1 != -3.4028235E38F) {
      i6 = (int)(i5 * f1);
    }
    i5 = i6;
    if (i5 <= 0)
    {
      u.h("SubtitlePainter", "Skipped drawing subtitle cue (insufficient space)");
      return;
    }
    if (this.y > 0.0F) {
      ((SpannableStringBuilder)localObject1).setSpan(new AbsoluteSizeSpan((int)this.y), 0, ((SpannableStringBuilder)localObject1).length(), 16711680);
    }
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder((CharSequence)localObject1);
    if (this.w == 1)
    {
      localObject2 = (ForegroundColorSpan[])localSpannableStringBuilder.getSpans(0, localSpannableStringBuilder.length(), ForegroundColorSpan.class);
      i7 = localObject2.length;
      for (i6 = 0; i6 < i7; i6++) {
        localSpannableStringBuilder.removeSpan(localObject2[i6]);
      }
    }
    if (Color.alpha(this.t) > 0)
    {
      i6 = this.w;
      if ((i6 != 0) && (i6 != 2)) {
        localSpannableStringBuilder.setSpan(new BackgroundColorSpan(this.t), 0, localSpannableStringBuilder.length(), 16711680);
      } else {
        ((SpannableStringBuilder)localObject1).setSpan(new BackgroundColorSpan(this.t), 0, ((SpannableStringBuilder)localObject1).length(), 16711680);
      }
    }
    Object localObject3 = this.j;
    Object localObject2 = localObject3;
    if (localObject3 == null) {
      localObject2 = Layout.Alignment.ALIGN_CENTER;
    }
    localObject3 = new StaticLayout((CharSequence)localObject1, this.f, i5, (Layout.Alignment)localObject2, this.d, this.e, true);
    this.E = ((StaticLayout)localObject3);
    int i8 = ((StaticLayout)localObject3).getHeight();
    int i9 = this.E.getLineCount();
    i6 = 0;
    for (int i7 = 0; i7 < i9; i7++) {
      i6 = Math.max((int)Math.ceil(this.E.getLineWidth(i7)), i6);
    }
    if ((this.q != -3.4028235E38F) && (i6 < i5)) {
      i6 = i5;
    }
    i5 = i6 + i4;
    f1 = this.o;
    if (f1 != -3.4028235E38F)
    {
      i6 = Math.round(i1 * f1);
      i7 = this.A;
      i6 += i7;
      i1 = this.p;
      if (i1 != 1)
      {
        if (i1 == 2) {
          i6 -= i5;
        }
      }
      else {
        i6 = (i6 * 2 - i5) / 2;
      }
      i7 = Math.max(i6, i7);
      i6 = Math.min(i5 + i7, this.C);
    }
    else
    {
      i7 = (i1 - i5) / 2 + this.A;
      i6 = i7 + i5;
    }
    i1 = i6 - i7;
    if (i1 <= 0)
    {
      u.h("SubtitlePainter", "Skipped drawing subtitle cue (invalid horizontal positioning)");
      return;
    }
    f1 = this.l;
    if (f1 != -3.4028235E38F)
    {
      if (this.m == 0)
      {
        i5 = Math.round(i2 * f1) + this.B;
        i2 = this.n;
        if (i2 != 2)
        {
          i6 = i5;
          if (i2 != 1) {
            break label752;
          }
          i6 = (i5 * 2 - i8) / 2;
          break label752;
        }
      }
      else
      {
        i6 = this.E.getLineBottom(0) - this.E.getLineTop(0);
        f1 = this.l;
        if (f1 >= 0.0F)
        {
          i6 = Math.round(f1 * i6) + this.B;
          break label752;
        }
        i5 = Math.round((f1 + 1.0F) * i6) + this.D;
      }
      i6 = i5 - i8;
      label752:
      i5 = this.D;
      if (i6 + i8 > i5)
      {
        i5 -= i8;
      }
      else
      {
        i8 = this.B;
        i5 = i6;
        if (i6 < i8)
        {
          i6 = i8;
          break label824;
        }
      }
    }
    else
    {
      i5 = this.D - i8 - (int)(i2 * this.z);
    }
    i6 = i5;
    label824:
    this.E = new StaticLayout((CharSequence)localObject1, this.f, i1, (Layout.Alignment)localObject2, this.d, this.e, true);
    this.F = new StaticLayout(localSpannableStringBuilder, this.f, i1, (Layout.Alignment)localObject2, this.d, this.e, true);
    this.G = i7;
    this.H = i6;
    this.I = i3;
  }
  
  public void b(c paramc, f0 paramf0, float paramFloat1, float paramFloat2, float paramFloat3, Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool;
    if (paramc.f == null) {
      bool = true;
    } else {
      bool = false;
    }
    int i1 = -16777216;
    if (bool)
    {
      if (TextUtils.isEmpty(paramc.c)) {
        return;
      }
      if (paramc.n) {
        i1 = paramc.o;
      } else {
        i1 = paramf0.d;
      }
    }
    if ((a(this.i, paramc.c)) && (o0.b(this.j, paramc.d)) && (this.k == paramc.f) && (this.l == paramc.g) && (this.m == paramc.h) && (o0.b(Integer.valueOf(this.n), Integer.valueOf(paramc.i))) && (this.o == paramc.j) && (o0.b(Integer.valueOf(this.p), Integer.valueOf(paramc.k))) && (this.q == paramc.l) && (this.r == paramc.m) && (this.s == paramf0.b) && (this.t == paramf0.c) && (this.u == i1) && (this.w == paramf0.e) && (this.v == paramf0.f) && (o0.b(this.f.getTypeface(), paramf0.g)) && (this.x == paramFloat1) && (this.y == paramFloat2) && (this.z == paramFloat3) && (this.A == paramInt1) && (this.B == paramInt2) && (this.C == paramInt3) && (this.D == paramInt4))
    {
      d(paramCanvas, bool);
      return;
    }
    this.i = paramc.c;
    this.j = paramc.d;
    this.k = paramc.f;
    this.l = paramc.g;
    this.m = paramc.h;
    this.n = paramc.i;
    this.o = paramc.j;
    this.p = paramc.k;
    this.q = paramc.l;
    this.r = paramc.m;
    this.s = paramf0.b;
    this.t = paramf0.c;
    this.u = i1;
    this.w = paramf0.e;
    this.v = paramf0.f;
    this.f.setTypeface(paramf0.g);
    this.x = paramFloat1;
    this.y = paramFloat2;
    this.z = paramFloat3;
    this.A = paramInt1;
    this.B = paramInt2;
    this.C = paramInt3;
    this.D = paramInt4;
    if (bool)
    {
      g.e(this.i);
      g();
    }
    else
    {
      g.e(this.k);
      f();
    }
    d(paramCanvas, bool);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\ui\w0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */