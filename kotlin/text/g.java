package kotlin.text;

import kotlin.jvm.internal.j;
import kotlin.v.d;

public final class g
{
  private final String a;
  private final d b;
  
  public g(String paramString, d paramd)
  {
    this.a = paramString;
    this.b = paramd;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof g))
      {
        paramObject = (g)paramObject;
        if ((j.a(this.a, ((g)paramObject).a)) && (j.a(this.b, ((g)paramObject).b))) {}
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
    Object localObject = this.a;
    int i = 0;
    int j;
    if (localObject != null) {
      j = localObject.hashCode();
    } else {
      j = 0;
    }
    localObject = this.b;
    if (localObject != null) {
      i = localObject.hashCode();
    }
    return j * 31 + i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MatchGroup(value=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", range=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\text\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */