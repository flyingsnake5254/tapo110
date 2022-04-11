package kotlin.collections;

import java.util.Iterator;
import kotlin.jvm.internal.r.a;

public abstract class k
  implements Iterator<Boolean>, a
{
  public final Boolean next()
  {
    return Boolean.valueOf(nextBoolean());
  }
  
  public abstract boolean nextBoolean();
  
  public void remove()
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\collections\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */