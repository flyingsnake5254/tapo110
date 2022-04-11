package io.reactivex.internal.util;

public final class h<T>
{
  final float a;
  int b;
  int c;
  int d;
  T[] e;
  
  public h()
  {
    this(16, 0.75F);
  }
  
  public h(int paramInt, float paramFloat)
  {
    this.a = paramFloat;
    paramInt = i.a(paramInt);
    this.b = (paramInt - 1);
    this.d = ((int)(paramFloat * paramInt));
    this.e = new Object[paramInt];
  }
  
  static int c(int paramInt)
  {
    paramInt *= -1640531527;
    return paramInt ^ paramInt >>> 16;
  }
  
  public boolean a(T paramT)
  {
    Object[] arrayOfObject = this.e;
    int i = this.b;
    int j = c(paramT.hashCode()) & i;
    Object localObject = arrayOfObject[j];
    int k = j;
    if (localObject != null)
    {
      if (localObject.equals(paramT)) {
        return false;
      }
      do
      {
        k = j + 1 & i;
        localObject = arrayOfObject[k];
        if (localObject == null) {
          break;
        }
        j = k;
      } while (!localObject.equals(paramT));
      return false;
    }
    arrayOfObject[k] = paramT;
    k = this.c + 1;
    this.c = k;
    if (k >= this.d) {
      d();
    }
    return true;
  }
  
  public Object[] b()
  {
    return this.e;
  }
  
  void d()
  {
    Object[] arrayOfObject1 = this.e;
    int i = arrayOfObject1.length;
    int j = i << 1;
    int k = j - 1;
    Object[] arrayOfObject2 = new Object[j];
    for (int m = this.c; m != 0; m--)
    {
      do
      {
        i--;
      } while (arrayOfObject1[i] == null);
      int n = c(arrayOfObject1[i].hashCode()) & k;
      int i1 = n;
      if (arrayOfObject2[n] != null)
      {
        i1 = n;
        do
        {
          n = i1 + 1 & k;
          i1 = n;
        } while (arrayOfObject2[n] != null);
        i1 = n;
      }
      arrayOfObject2[i1] = arrayOfObject1[i];
    }
    this.b = k;
    this.d = ((int)(j * this.a));
    this.e = arrayOfObject2;
  }
  
  public boolean e(T paramT)
  {
    Object[] arrayOfObject = this.e;
    int i = this.b;
    int j = c(paramT.hashCode()) & i;
    Object localObject = arrayOfObject[j];
    if (localObject == null) {
      return false;
    }
    int k = j;
    if (localObject.equals(paramT)) {
      return f(j, arrayOfObject, i);
    }
    do
    {
      j = k + 1 & i;
      localObject = arrayOfObject[j];
      if (localObject == null) {
        return false;
      }
      k = j;
    } while (!localObject.equals(paramT));
    return f(j, arrayOfObject, i);
  }
  
  boolean f(int paramInt1, T[] paramArrayOfT, int paramInt2)
  {
    this.c -= 1;
    for (int i = paramInt1 + 1;; i++)
    {
      i &= paramInt2;
      T ? = paramArrayOfT[i];
      if (? == null)
      {
        paramArrayOfT[paramInt1] = null;
        return true;
      }
      int j = c(?.hashCode()) & paramInt2;
      if (paramInt1 <= i ? (paramInt1 >= j) || (j > i) : (paramInt1 >= j) && (j > i))
      {
        paramArrayOfT[paramInt1] = ?;
        paramInt1 = i;
        break;
      }
    }
  }
  
  public int g()
  {
    return this.c;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\util\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */