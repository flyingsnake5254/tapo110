package com.google.android.gms.internal.vision;

import java.util.NoSuchElementException;

abstract class zzdg<E>
  extends zzdv<E>
{
  private int position;
  private final int size;
  
  protected zzdg(int paramInt1, int paramInt2)
  {
    zzcy.zze(paramInt2, paramInt1);
    this.size = paramInt1;
    this.position = paramInt2;
  }
  
  protected abstract E get(int paramInt);
  
  public final boolean hasNext()
  {
    return this.position < this.size;
  }
  
  public final boolean hasPrevious()
  {
    return this.position > 0;
  }
  
  public final E next()
  {
    if (hasNext())
    {
      int i = this.position;
      this.position = (i + 1);
      return (E)get(i);
    }
    throw new NoSuchElementException();
  }
  
  public final int nextIndex()
  {
    return this.position;
  }
  
  public final E previous()
  {
    if (hasPrevious())
    {
      int i = this.position - 1;
      this.position = i;
      return (E)get(i);
    }
    throw new NoSuchElementException();
  }
  
  public final int previousIndex()
  {
    return this.position - 1;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzdg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */