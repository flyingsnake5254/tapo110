package kotlin.collections;

import java.util.Iterator;
import kotlin.jvm.internal.r.a;

public abstract class z
  implements Iterator<Integer>, a
{
  public final Integer next()
  {
    return Integer.valueOf(nextInt());
  }
  
  public abstract int nextInt();
  
  public void remove()
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\collections\z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */