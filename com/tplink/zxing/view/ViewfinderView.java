package com.tplink.zxing.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import b.d.e0.a;
import b.d.e0.b;
import b.d.e0.g;

public final class ViewfinderView
  extends View
{
  private final Paint c = new Paint();
  private Bitmap d;
  private final int f;
  private int p0;
  private int p1;
  private int q;
  private int x;
  private Bitmap y;
  private int z;
  
  public ViewfinderView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ViewfinderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public ViewfinderView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    Resources localResources = getResources();
    this.f = localResources.getColor(b.viewfinder_mask);
    this.y = BitmapFactory.decodeResource(localResources, b.d.e0.c.scan_light);
    d(paramContext, paramAttributeSet);
  }
  
  private void a(Canvas paramCanvas, Rect paramRect)
  {
    this.c.setColor(this.z);
    this.c.setStyle(Paint.Style.STROKE);
    paramCanvas.drawRect(paramRect.left, paramRect.top, paramRect.right, paramRect.bottom, this.c);
    this.c.setColor(this.z);
    this.c.setStyle(Paint.Style.FILL);
    int i = this.p1;
    int j = this.p0;
    int k = paramRect.left;
    float f1 = k;
    int m = paramRect.top;
    paramCanvas.drawRect(f1, m, k + i, m + j, this.c);
    m = paramRect.left;
    f1 = m;
    k = paramRect.top;
    paramCanvas.drawRect(f1, k, m + j, k + i, this.c);
    k = paramRect.right;
    f1 = k - i;
    m = paramRect.top;
    paramCanvas.drawRect(f1, m, k, m + j, this.c);
    k = paramRect.right;
    f1 = k - j;
    m = paramRect.top;
    paramCanvas.drawRect(f1, m, k, m + i, this.c);
    m = paramRect.left;
    f1 = m;
    k = paramRect.bottom;
    paramCanvas.drawRect(f1, k - j, m + i, k, this.c);
    k = paramRect.left;
    f1 = k;
    m = paramRect.bottom;
    paramCanvas.drawRect(f1, m - i, k + j, m, this.c);
    m = paramRect.right;
    f1 = m - i;
    k = paramRect.bottom;
    paramCanvas.drawRect(f1, k - j, m, k, this.c);
    m = paramRect.right;
    f1 = m - j;
    j = paramRect.bottom;
    paramCanvas.drawRect(f1, j - i, m, j, this.c);
  }
  
  private void b(Canvas paramCanvas, Rect paramRect)
  {
    if (this.q == 0) {
      this.q = paramRect.top;
    }
    int i = this.q;
    if (i >= paramRect.bottom - 30) {
      this.q = paramRect.top;
    } else {
      this.q = (i + this.x);
    }
    int j = paramRect.left;
    i = this.q;
    paramRect = new Rect(j, i, paramRect.right, i + 30);
    paramCanvas.drawBitmap(this.y, null, paramRect, this.c);
  }
  
  private void d(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, g.ViewfinderView);
    float f1 = paramContext.getDimension(g.ViewfinderView_inner_margintop, -1.0F);
    if (f1 != -1.0F) {
      b.d.e0.h.c.c = (int)f1;
    }
    b.d.e0.h.c.a = (int)paramContext.getDimension(g.ViewfinderView_inner_width, a.a / 2);
    b.d.e0.h.c.b = (int)paramContext.getDimension(g.ViewfinderView_inner_height, a.a / 2);
    this.z = paramContext.getColor(g.ViewfinderView_inner_corner_color, Color.parseColor("#45DDDD"));
    this.p0 = ((int)paramContext.getDimension(g.ViewfinderView_inner_corner_length, 65.0F));
    this.p1 = ((int)paramContext.getDimension(g.ViewfinderView_inner_corner_width, 15.0F));
    this.y = BitmapFactory.decodeResource(getResources(), paramContext.getResourceId(g.ViewfinderView_inner_scan_bitmap, b.d.e0.c.scan_light));
    this.x = paramContext.getInt(g.ViewfinderView_inner_scan_speed, 5);
    paramContext.recycle();
  }
  
  public void c()
  {
    this.d = null;
    invalidate();
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    Rect localRect = b.d.e0.h.c.c().f();
    if (localRect == null) {
      return;
    }
    int i = getWidth();
    int j = getHeight();
    this.c.setColor(this.f);
    float f1 = i;
    paramCanvas.drawRect(0.0F, 0.0F, f1, localRect.top, this.c);
    paramCanvas.drawRect(0.0F, localRect.top, localRect.left, localRect.bottom + 1, this.c);
    paramCanvas.drawRect(localRect.right + 1, localRect.top, f1, localRect.bottom + 1, this.c);
    paramCanvas.drawRect(0.0F, localRect.bottom + 1, f1, j, this.c);
    if (this.d != null)
    {
      this.c.setAlpha(255);
      paramCanvas.drawBitmap(this.d, localRect.left, localRect.top, this.c);
    }
    else
    {
      a(paramCanvas, localRect);
      b(paramCanvas, localRect);
      postInvalidateDelayed(10L, localRect.left, localRect.top, localRect.right, localRect.bottom);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\zxing\view\ViewfinderView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */