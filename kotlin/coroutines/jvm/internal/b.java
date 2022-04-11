package kotlin.coroutines.jvm.internal;

import kotlin.coroutines.c;
import kotlin.coroutines.f;

public final class b
  implements c<Object>
{
  public static final b c = new b();
  
  public f getContext()
  {
    throw new IllegalStateException("This continuation is already complete".toString());
  }
  
  public void resumeWith(Object paramObject)
  {
    throw new IllegalStateException("This continuation is already complete".toString());
  }
  
  public String toString()
  {
    return "This continuation is already complete";
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\coroutines\jvm\internal\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */