package com.google.android.gms.common.data;

import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.NoSuchElementException;

@KeepForSdk
public class SingleRefDataBufferIterator<T>
  extends DataBufferIterator<T>
{
  private T zamg;
  
  public SingleRefDataBufferIterator(DataBuffer<T> paramDataBuffer)
  {
    super(paramDataBuffer);
  }
  
  public T next()
  {
    if (hasNext())
    {
      i = this.zall + 1;
      this.zall = i;
      if (i == 0)
      {
        localObject = this.zalk.get(0);
        this.zamg = localObject;
        if (!(localObject instanceof DataBufferRef))
        {
          localObject = String.valueOf(this.zamg.getClass());
          StringBuilder localStringBuilder = new StringBuilder(((String)localObject).length() + 44);
          localStringBuilder.append("DataBuffer reference of type ");
          localStringBuilder.append((String)localObject);
          localStringBuilder.append(" is not movable");
          throw new IllegalStateException(localStringBuilder.toString());
        }
      }
      else
      {
        ((DataBufferRef)this.zamg).zag(i);
      }
      return (T)this.zamg;
    }
    int i = this.zall;
    Object localObject = new StringBuilder(46);
    ((StringBuilder)localObject).append("Cannot advance the iterator beyond ");
    ((StringBuilder)localObject).append(i);
    throw new NoSuchElementException(((StringBuilder)localObject).toString());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\data\SingleRefDataBufferIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */