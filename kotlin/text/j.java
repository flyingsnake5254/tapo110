package kotlin.text;

import java.util.Iterator;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.collections.a;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.f;
import kotlin.v.d;

final class j
  implements i
{
  private final h a;
  private final Matcher b;
  private final CharSequence c;
  
  public j(Matcher paramMatcher, CharSequence paramCharSequence)
  {
    this.b = paramMatcher;
    this.c = paramCharSequence;
    this.a = new a(this);
  }
  
  private final MatchResult c()
  {
    return this.b;
  }
  
  public d a()
  {
    return k.c(c());
  }
  
  public i next()
  {
    int i = c().end();
    if (c().end() == c().start()) {
      j = 1;
    } else {
      j = 0;
    }
    int j = i + j;
    Object localObject;
    if (j <= this.c.length())
    {
      localObject = this.b.pattern().matcher(this.c);
      kotlin.jvm.internal.j.d(localObject, "matcher.pattern().matcher(input)");
      localObject = k.a((Matcher)localObject, j, this.c);
    }
    else
    {
      localObject = null;
    }
    return (i)localObject;
  }
  
  public static final class a
    extends a<g>
  {
    a(j paramj) {}
    
    public int a()
    {
      return j.b(this.c).groupCount() + 1;
    }
    
    public g c(int paramInt)
    {
      Object localObject = k.d(j.b(this.c), paramInt);
      if (((d)localObject).h().intValue() >= 0)
      {
        String str = j.b(this.c).group(paramInt);
        kotlin.jvm.internal.j.d(str, "matchResult.group(index)");
        localObject = new g(str, (d)localObject);
      }
      else
      {
        localObject = null;
      }
      return (g)localObject;
    }
    
    public boolean isEmpty()
    {
      return false;
    }
    
    public Iterator<g> iterator()
    {
      return kotlin.sequences.g.g(kotlin.collections.l.t(kotlin.collections.l.e(this)), new a(this)).iterator();
    }
    
    static final class a
      extends Lambda
      implements kotlin.jvm.b.l<Integer, g>
    {
      a(j.a parama)
      {
        super();
      }
      
      public final g a(int paramInt)
      {
        return this.c.c(paramInt);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\text\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */