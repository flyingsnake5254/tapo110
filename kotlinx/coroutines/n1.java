package kotlinx.coroutines;

import kotlin.TypeCastException;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.internal.g;
import kotlinx.coroutines.internal.i;

public final class n1
  extends g
  implements y0
{
  public final String L(String paramString)
  {
    j.f(paramString, "state");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("List{");
    localStringBuilder.append(paramString);
    localStringBuilder.append("}[");
    paramString = A();
    if (paramString != null)
    {
      paramString = (i)paramString;
      int j;
      for (int i = 1; (j.a(paramString, this) ^ true); i = j)
      {
        j = i;
        if ((paramString instanceof i1))
        {
          i1 locali1 = (i1)paramString;
          if (i != 0) {
            i = 0;
          } else {
            localStringBuilder.append(", ");
          }
          localStringBuilder.append(locali1);
          j = i;
        }
        paramString = paramString.B();
      }
      localStringBuilder.append("]");
      paramString = localStringBuilder.toString();
      j.b(paramString, "StringBuilder().apply(builderAction).toString()");
      return paramString;
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
  }
  
  public n1 d()
  {
    return this;
  }
  
  public boolean isActive()
  {
    return true;
  }
  
  public String toString()
  {
    String str;
    if (g0.c()) {
      str = L("Active");
    } else {
      str = super.toString();
    }
    return str;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\n1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */