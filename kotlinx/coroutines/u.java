package kotlinx.coroutines;

import kotlin.jvm.b.l;
import kotlin.p;

final class u
{
  public final Object a;
  public final l<Throwable, p> b;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CompletedWithCancellation[");
    localStringBuilder.append(this.a);
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */