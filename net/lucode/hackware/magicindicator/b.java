package net.lucode.hackware.magicindicator;

import android.util.SparseArray;
import android.util.SparseBooleanArray;

public class b
{
  private SparseBooleanArray a = new SparseBooleanArray();
  private SparseArray<Float> b = new SparseArray();
  private int c;
  private int d;
  private int e;
  private float f;
  private int g;
  private boolean h;
  private a i;
  
  private void a(int paramInt)
  {
    a locala = this.i;
    if (locala != null) {
      locala.a(paramInt, this.c);
    }
    this.a.put(paramInt, true);
  }
  
  private void b(int paramInt, float paramFloat, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.h) || (paramInt == this.d) || (this.g == 1) || (paramBoolean2))
    {
      a locala = this.i;
      if (locala != null) {
        locala.b(paramInt, this.c, paramFloat, paramBoolean1);
      }
      this.b.put(paramInt, Float.valueOf(1.0F - paramFloat));
    }
  }
  
  private void c(int paramInt, float paramFloat, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((!this.h) && (paramInt != this.e) && (this.g != 1))
    {
      int j = this.d;
      if (((paramInt == j - 1) || (paramInt == j + 1)) && ((((Float)this.b.get(paramInt, Float.valueOf(0.0F))).floatValue() == 1.0F) && (!paramBoolean2))) {}
    }
    else
    {
      a locala = this.i;
      if (locala != null) {
        locala.d(paramInt, this.c, paramFloat, paramBoolean1);
      }
      this.b.put(paramInt, Float.valueOf(paramFloat));
    }
  }
  
  private void d(int paramInt)
  {
    a locala = this.i;
    if (locala != null) {
      locala.c(paramInt, this.c);
    }
    this.a.put(paramInt, false);
  }
  
  public int e()
  {
    return this.d;
  }
  
  public int f()
  {
    return this.g;
  }
  
  public int g()
  {
    return this.c;
  }
  
  public void h(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void i(int paramInt1, float paramFloat, int paramInt2)
  {
    float f1 = paramInt1 + paramFloat;
    float f2 = this.f;
    boolean bool;
    if (f2 <= f1) {
      bool = true;
    } else {
      bool = false;
    }
    if (this.g != 0)
    {
      if (f1 == f2) {
        return;
      }
      int j = paramInt1 + 1;
      if ((paramFloat == 0.0F) && (bool))
      {
        j = paramInt1 - 1;
        paramInt2 = 0;
      }
      else
      {
        paramInt2 = 1;
      }
      for (int k = 0; k < this.c; k++) {
        if ((k != paramInt1) && (k != j) && (((Float)this.b.get(k, Float.valueOf(0.0F))).floatValue() != 1.0F)) {
          c(k, 1.0F, bool, true);
        }
      }
      if (paramInt2 != 0)
      {
        if (bool)
        {
          c(paramInt1, paramFloat, true, false);
          b(j, paramFloat, true, false);
        }
        else
        {
          paramFloat = 1.0F - paramFloat;
          c(j, paramFloat, false, false);
          b(paramInt1, paramFloat, false, false);
        }
      }
      else
      {
        paramFloat = 1.0F - paramFloat;
        c(j, paramFloat, true, false);
        b(paramInt1, paramFloat, true, false);
      }
    }
    else
    {
      for (paramInt1 = 0; paramInt1 < this.c; paramInt1++) {
        if (paramInt1 != this.d)
        {
          if (!this.a.get(paramInt1)) {
            a(paramInt1);
          }
          if (((Float)this.b.get(paramInt1, Float.valueOf(0.0F))).floatValue() != 1.0F) {
            c(paramInt1, 1.0F, false, true);
          }
        }
      }
      b(this.d, 1.0F, false, true);
      d(this.d);
    }
    this.f = f1;
  }
  
  public void j(int paramInt)
  {
    this.e = this.d;
    this.d = paramInt;
    d(paramInt);
    for (paramInt = 0; paramInt < this.c; paramInt++) {
      if ((paramInt != this.d) && (!this.a.get(paramInt))) {
        a(paramInt);
      }
    }
  }
  
  public void k(a parama)
  {
    this.i = parama;
  }
  
  public void l(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public void m(int paramInt)
  {
    this.c = paramInt;
    this.a.clear();
    this.b.clear();
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2);
    
    public abstract void b(int paramInt1, int paramInt2, float paramFloat, boolean paramBoolean);
    
    public abstract void c(int paramInt1, int paramInt2);
    
    public abstract void d(int paramInt1, int paramInt2, float paramFloat, boolean paramBoolean);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\net\lucode\hackware\magicindicator\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */