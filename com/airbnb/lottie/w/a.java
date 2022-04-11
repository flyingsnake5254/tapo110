package com.airbnb.lottie.w;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import com.airbnb.lottie.d;

public class a<T>
{
  @Nullable
  private final d a;
  @Nullable
  public final T b;
  @Nullable
  public T c;
  @Nullable
  public final Interpolator d;
  public final float e;
  @Nullable
  public Float f;
  private float g = -3987645.8F;
  private float h = -3987645.8F;
  private int i = 784923401;
  private int j = 784923401;
  private float k = Float.MIN_VALUE;
  private float l = Float.MIN_VALUE;
  public PointF m = null;
  public PointF n = null;
  
  public a(d paramd, @Nullable T paramT1, @Nullable T paramT2, @Nullable Interpolator paramInterpolator, float paramFloat, @Nullable Float paramFloat1)
  {
    this.a = paramd;
    this.b = paramT1;
    this.c = paramT2;
    this.d = paramInterpolator;
    this.e = paramFloat;
    this.f = paramFloat1;
  }
  
  public a(T paramT)
  {
    this.a = null;
    this.b = paramT;
    this.c = paramT;
    this.d = null;
    this.e = Float.MIN_VALUE;
    this.f = Float.valueOf(Float.MAX_VALUE);
  }
  
  public boolean a(@FloatRange(from=0.0D, to=1.0D) float paramFloat)
  {
    boolean bool;
    if ((paramFloat >= e()) && (paramFloat < b())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public float b()
  {
    if (this.a == null) {
      return 1.0F;
    }
    if (this.l == Float.MIN_VALUE) {
      if (this.f == null) {
        this.l = 1.0F;
      } else {
        this.l = (e() + (this.f.floatValue() - this.e) / this.a.e());
      }
    }
    return this.l;
  }
  
  public float c()
  {
    if (this.h == -3987645.8F) {
      this.h = ((Float)this.c).floatValue();
    }
    return this.h;
  }
  
  public int d()
  {
    if (this.j == 784923401) {
      this.j = ((Integer)this.c).intValue();
    }
    return this.j;
  }
  
  public float e()
  {
    d locald = this.a;
    if (locald == null) {
      return 0.0F;
    }
    if (this.k == Float.MIN_VALUE) {
      this.k = ((this.e - locald.o()) / this.a.e());
    }
    return this.k;
  }
  
  public float f()
  {
    if (this.g == -3987645.8F) {
      this.g = ((Float)this.b).floatValue();
    }
    return this.g;
  }
  
  public int g()
  {
    if (this.i == 784923401) {
      this.i = ((Integer)this.b).intValue();
    }
    return this.i;
  }
  
  public boolean h()
  {
    boolean bool;
    if (this.d == null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Keyframe{startValue=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", endValue=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", startFrame=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", endFrame=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", interpolator=");
    localStringBuilder.append(this.d);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\w\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */