package com.tplink.libtpcontrols;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import androidx.annotation.NonNull;

public class TPV2GifView
  extends View
{
  private volatile boolean H3 = false;
  private volatile boolean I3 = false;
  private boolean J3 = false;
  private boolean K3 = true;
  private boolean L3 = false;
  private int M3 = 0;
  private int N3 = 0;
  private a O3 = null;
  private int c;
  private Movie d;
  private long f;
  private float p0;
  private int p1;
  private int p2;
  private boolean p3 = true;
  private int q;
  private long x;
  private float y;
  private float z;
  
  public TPV2GifView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TPV2GifView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TPV2GifView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    c(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(Canvas paramCanvas)
  {
    this.d.setTime(this.q);
    paramCanvas.save();
    float f1 = this.p0;
    paramCanvas.scale(f1, f1);
    Movie localMovie = this.d;
    float f2 = this.y;
    f1 = this.p0;
    localMovie.draw(paramCanvas, f2 / f1, this.z / f1);
    paramCanvas.restore();
  }
  
  private void b()
  {
    this.H3 = false;
    this.I3 = false;
    this.f = 0L;
    this.q = 0;
    this.x = 0L;
    this.N3 = 0;
    this.p3 = true;
  }
  
  @SuppressLint({"NewApi"})
  private void c(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 11) {
      setLayerType(1, null);
    }
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, x0.TPGifView, paramInt, 0);
    this.c = paramContext.getResourceId(x0.TPGifView_gif, -1);
    this.H3 = paramContext.getBoolean(x0.TPGifView_paused, false);
    paramContext.recycle();
    if (this.c != -1) {
      this.d = Movie.decodeStream(getResources().openRawResource(this.c));
    }
  }
  
  private void d()
  {
    long l1 = SystemClock.uptimeMillis();
    if (this.f == 0L) {
      this.f = l1;
    }
    int i = this.d.duration();
    int j = i;
    if (i == 0) {
      j = 1000;
    }
    i = this.M3;
    if (i > 0)
    {
      long l2 = this.f;
      int k = this.N3;
      if (l1 - l2 > (k + 1) * j)
      {
        k++;
        this.N3 = k;
        if (k >= i)
        {
          this.H3 = true;
          this.I3 = true;
          this.q = (j - 1);
        }
        else
        {
          this.q = ((int)((l1 - l2) % j));
        }
      }
      else
      {
        this.q = ((int)((l1 - l2) % j));
      }
    }
    else
    {
      this.q = ((int)((l1 - this.f) % j));
    }
  }
  
  private void e()
  {
    long l1 = SystemClock.uptimeMillis();
    if (this.f == 0L) {
      this.f = l1;
    }
    int i = this.d.duration();
    int j = i;
    if (i == 0) {
      j = 1000;
    }
    if (this.x == 0L) {
      this.x = this.q;
    }
    long l2 = this.f;
    long l3 = j;
    long l4 = this.x;
    j = (int)((l1 - l2) % l3 + l4) % j;
    this.q = j;
    if (j < l4)
    {
      this.x = 0L;
      this.H3 = true;
      this.I3 = true;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.d != null) {
      if (!this.J3)
      {
        if (!this.H3)
        {
          if (this.K3) {
            d();
          } else if (this.L3) {
            e();
          }
          a(paramCanvas);
          invalidate();
        }
        else
        {
          if (this.I3)
          {
            a locala = this.O3;
            if (locala != null) {
              locala.complete();
            }
          }
          a(paramCanvas);
        }
      }
      else {
        a(paramCanvas);
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.y = ((getWidth() - this.p1) / 2.0F);
    this.z = ((getHeight() - this.p2) / 2.0F);
    if (getVisibility() == 0) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    this.p3 = paramBoolean;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    Movie localMovie = this.d;
    if (localMovie != null)
    {
      paramInt2 = localMovie.width();
      int i = this.d.height();
      paramInt1 = View.MeasureSpec.getSize(paramInt1);
      float f1 = 1.0F / (paramInt2 / paramInt1);
      this.p0 = f1;
      this.p1 = paramInt1;
      paramInt2 = (int)(i * f1);
      this.p2 = paramInt2;
      setMeasuredDimension(paramInt1, paramInt2);
    }
    else
    {
      setMeasuredDimension(getSuggestedMinimumWidth(), getSuggestedMinimumHeight());
    }
  }
  
  @SuppressLint({"NewApi"})
  public void onScreenStateChanged(int paramInt)
  {
    super.onScreenStateChanged(paramInt);
    boolean bool = true;
    if (paramInt != 1) {
      bool = false;
    }
    this.p3 = bool;
    invalidate();
  }
  
  @SuppressLint({"NewApi"})
  protected void onVisibilityChanged(@NonNull View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    boolean bool;
    if (paramInt == 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.p3 = bool;
    invalidate();
  }
  
  protected void onWindowVisibilityChanged(int paramInt)
  {
    super.onWindowVisibilityChanged(paramInt);
    boolean bool;
    if (paramInt == 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.p3 = bool;
    invalidate();
  }
  
  public void setFrameMoveProgress(int paramInt)
  {
    this.J3 = true;
    setProgress(paramInt);
  }
  
  public void setFrameMovieResource(int paramInt)
  {
    this.c = paramInt;
    this.J3 = true;
    this.K3 = false;
    this.L3 = false;
    this.d = Movie.decodeStream(getResources().openRawResource(this.c));
    b();
    requestLayout();
  }
  
  public void setMovie(Movie paramMovie)
  {
    this.d = paramMovie;
    b();
    requestLayout();
  }
  
  public void setMovieProgress(int paramInt)
  {
    this.J3 = false;
    this.K3 = false;
    this.L3 = true;
    this.H3 = false;
    setProgress(paramInt);
  }
  
  public void setMovieResource(int paramInt)
  {
    this.c = paramInt;
    this.d = Movie.decodeStream(getResources().openRawResource(this.c));
    b();
    requestLayout();
  }
  
  public void setMovieTime(int paramInt)
  {
    this.J3 = false;
    this.K3 = false;
    this.L3 = true;
    this.q = paramInt;
    invalidate();
  }
  
  public void setOnCompletedListener(a parama)
  {
    this.O3 = parama;
  }
  
  public void setPaused(boolean paramBoolean)
  {
    this.H3 = paramBoolean;
    if (!paramBoolean) {
      this.f = (SystemClock.uptimeMillis() - this.q);
    }
    invalidate();
  }
  
  public void setProgress(int paramInt)
  {
    int i;
    if (paramInt < 0)
    {
      i = 0;
    }
    else
    {
      i = paramInt;
      if (paramInt > 100) {
        i = 100;
      }
    }
    int j = this.d.duration();
    paramInt = j;
    if (j == 0) {
      paramInt = 1000;
    }
    this.q = (i * paramInt / 100);
    invalidate();
  }
  
  public void setTimes(int paramInt)
  {
    this.M3 = paramInt;
  }
  
  public static abstract interface a
  {
    public abstract void complete();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\TPV2GifView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */