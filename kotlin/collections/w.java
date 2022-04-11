package kotlin.collections;

import java.util.ListIterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.r.a;

public final class w
  implements ListIterator, a
{
  public static final w c = new w();
  
  public Void a()
  {
    throw new NoSuchElementException();
  }
  
  public Void b()
  {
    throw new NoSuchElementException();
  }
  
  public boolean hasNext()
  {
    return false;
  }
  
  public boolean hasPrevious()
  {
    return false;
  }
  
  public int nextIndex()
  {
    return 0;
  }
  
  public int previousIndex()
  {
    return -1;
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\collections\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */