package com.google.android.exoplayer2.source;

import android.util.SparseArray;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.l;

final class t0<V>
{
  private int a;
  private final SparseArray<V> b = new SparseArray();
  private final l<V> c;
  
  public t0(l<V> paraml)
  {
    this.c = paraml;
    this.a = -1;
  }
  
  public void a(int paramInt, V paramV)
  {
    int i = this.a;
    boolean bool1 = false;
    boolean bool2;
    if (i == -1)
    {
      if (this.b.size() == 0) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      g.g(bool2);
      this.a = 0;
    }
    if (this.b.size() > 0)
    {
      Object localObject = this.b;
      i = ((SparseArray)localObject).keyAt(((SparseArray)localObject).size() - 1);
      bool2 = bool1;
      if (paramInt >= i) {
        bool2 = true;
      }
      g.a(bool2);
      if (i == paramInt)
      {
        localObject = this.c;
        SparseArray localSparseArray = this.b;
        ((l)localObject).accept(localSparseArray.valueAt(localSparseArray.size() - 1));
      }
    }
    this.b.append(paramInt, paramV);
  }
  
  public void b()
  {
    for (int i = 0; i < this.b.size(); i++) {
      this.c.accept(this.b.valueAt(i));
    }
    this.a = -1;
    this.b.clear();
  }
  
  public void c(int paramInt)
  {
    for (int i = this.b.size() - 1; (i >= 0) && (paramInt < this.b.keyAt(i)); i--)
    {
      this.c.accept(this.b.valueAt(i));
      this.b.removeAt(i);
    }
    if (this.b.size() > 0) {
      paramInt = Math.min(this.a, this.b.size() - 1);
    } else {
      paramInt = -1;
    }
    this.a = paramInt;
  }
  
  public void d(int paramInt)
  {
    int j;
    for (int i = 0; i < this.b.size() - 1; i = j)
    {
      SparseArray localSparseArray = this.b;
      j = i + 1;
      if (paramInt < localSparseArray.keyAt(j)) {
        break;
      }
      this.c.accept(this.b.valueAt(i));
      this.b.removeAt(i);
      i = this.a;
      if (i > 0) {
        this.a = (i - 1);
      }
    }
  }
  
  public V e(int paramInt)
  {
    if (this.a == -1) {}
    for (this.a = 0;; this.a -= 1)
    {
      int i = this.a;
      if ((i <= 0) || (paramInt >= this.b.keyAt(i))) {
        break;
      }
    }
    while ((this.a < this.b.size() - 1) && (paramInt >= this.b.keyAt(this.a + 1))) {
      this.a += 1;
    }
    return (V)this.b.valueAt(this.a);
  }
  
  public V f()
  {
    SparseArray localSparseArray = this.b;
    return (V)localSparseArray.valueAt(localSparseArray.size() - 1);
  }
  
  public boolean g()
  {
    boolean bool;
    if (this.b.size() == 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\source\t0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */