package io.reactivex.internal.util;

import e.b.b;
import io.reactivex.g0.l;
import io.reactivex.v;

public class a<T>
{
  final int a;
  final Object[] b;
  Object[] c;
  int d;
  
  public a(int paramInt)
  {
    this.a = paramInt;
    Object[] arrayOfObject = new Object[paramInt + 1];
    this.b = arrayOfObject;
    this.c = arrayOfObject;
  }
  
  public <U> boolean a(v<? super U> paramv)
  {
    Object[] arrayOfObject = this.b;
    int i = this.a;
    for (;;)
    {
      int j = 0;
      if (arrayOfObject == null) {
        break;
      }
      while (j < i)
      {
        Object localObject = arrayOfObject[j];
        if (localObject == null) {
          break;
        }
        if (NotificationLite.acceptFull(localObject, paramv)) {
          return true;
        }
        j++;
      }
      arrayOfObject = (Object[])arrayOfObject[i];
    }
    return false;
  }
  
  public <U> boolean b(b<? super U> paramb)
  {
    Object[] arrayOfObject = this.b;
    int i = this.a;
    for (;;)
    {
      int j = 0;
      if (arrayOfObject == null) {
        break;
      }
      while (j < i)
      {
        Object localObject = arrayOfObject[j];
        if (localObject == null) {
          break;
        }
        if (NotificationLite.acceptFull(localObject, paramb)) {
          return true;
        }
        j++;
      }
      arrayOfObject = (Object[])arrayOfObject[i];
    }
    return false;
  }
  
  public void c(T paramT)
  {
    int i = this.a;
    int j = this.d;
    int k = j;
    if (j == i)
    {
      Object[] arrayOfObject = new Object[i + 1];
      this.c[i] = arrayOfObject;
      this.c = arrayOfObject;
      k = 0;
    }
    this.c[k] = paramT;
    this.d = (k + 1);
  }
  
  public void d(a<? super T> parama)
  {
    Object[] arrayOfObject = this.b;
    int i = this.a;
    while (arrayOfObject != null)
    {
      for (int j = 0; j < i; j++)
      {
        Object localObject = arrayOfObject[j];
        if (localObject == null) {
          break;
        }
        if (parama.test(localObject)) {
          return;
        }
      }
      arrayOfObject = (Object[])arrayOfObject[i];
    }
  }
  
  public void e(T paramT)
  {
    this.b[0] = paramT;
  }
  
  public static abstract interface a<T>
    extends l<T>
  {
    public abstract boolean test(T paramT);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\util\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */