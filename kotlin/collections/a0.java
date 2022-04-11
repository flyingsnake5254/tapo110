package kotlin.collections;

import java.util.Iterator;
import kotlin.jvm.internal.r.a;

public abstract class a0
  implements Iterator<Long>, a
{
  public final Long next()
  {
    return Long.valueOf(nextLong());
  }
  
  public abstract long nextLong();
  
  public void remove()
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\collections\a0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */