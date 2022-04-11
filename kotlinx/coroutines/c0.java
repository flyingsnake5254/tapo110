package kotlinx.coroutines;

import kotlin.coroutines.a;
import kotlin.coroutines.f.c;
import kotlin.jvm.internal.j;

public final class c0
  extends a
{
  public static final a c = new a(null);
  private final String d;
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof c0))
      {
        paramObject = (c0)paramObject;
        if (j.a(this.d, ((c0)paramObject).d)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    String str = this.d;
    int i;
    if (str != null) {
      i = str.hashCode();
    } else {
      i = 0;
    }
    return i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CoroutineName(");
    localStringBuilder.append(this.d);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
  
  public final String u()
  {
    return this.d;
  }
  
  public static final class a
    implements f.c<c0>
  {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\c0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */