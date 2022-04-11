package com.google.android.gms.common.data;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;
import java.util.NoSuchElementException;

@KeepForSdk
public class DataBufferIterator<T>
  implements Iterator<T>
{
  protected final DataBuffer<T> zalk;
  protected int zall;
  
  public DataBufferIterator(DataBuffer<T> paramDataBuffer)
  {
    this.zalk = ((DataBuffer)Preconditions.checkNotNull(paramDataBuffer));
    this.zall = -1;
  }
  
  public boolean hasNext()
  {
    return this.zall < this.zalk.getCount() - 1;
  }
  
  public T next()
  {
    if (hasNext())
    {
      localObject = this.zalk;
      i = this.zall + 1;
      this.zall = i;
      return (T)((DataBuffer)localObject).get(i);
    }
    int i = this.zall;
    Object localObject = new StringBuilder(46);
    ((StringBuilder)localObject).append("Cannot advance the iterator beyond ");
    ((StringBuilder)localObject).append(i);
    throw new NoSuchElementException(((StringBuilder)localObject).toString());
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\data\DataBufferIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */