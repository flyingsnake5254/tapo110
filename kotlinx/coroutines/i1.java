package kotlinx.coroutines;

import kotlin.TypeCastException;

public abstract class i1<J extends d1>
  extends v
  implements o0, y0
{
  public final J q;
  
  public i1(J paramJ)
  {
    this.q = paramJ;
  }
  
  public n1 d()
  {
    return null;
  }
  
  public void dispose()
  {
    d1 locald1 = this.q;
    if (locald1 != null)
    {
      ((j1)locald1).d0(this);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.JobSupport");
  }
  
  public boolean isActive()
  {
    return true;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\i1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */