package kotlin.text;

import java.util.Iterator;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import kotlin.v.d;
import kotlin.v.e;

public final class k
{
  private static final i f(Matcher paramMatcher, int paramInt, CharSequence paramCharSequence)
  {
    if (!paramMatcher.find(paramInt)) {
      paramMatcher = null;
    } else {
      paramMatcher = new j(paramMatcher, paramCharSequence);
    }
    return paramMatcher;
  }
  
  private static final i g(Matcher paramMatcher, CharSequence paramCharSequence)
  {
    if (!paramMatcher.matches()) {
      paramMatcher = null;
    } else {
      paramMatcher = new j(paramMatcher, paramCharSequence);
    }
    return paramMatcher;
  }
  
  private static final d h(MatchResult paramMatchResult)
  {
    return e.i(paramMatchResult.start(), paramMatchResult.end());
  }
  
  private static final d i(MatchResult paramMatchResult, int paramInt)
  {
    return e.i(paramMatchResult.start(paramInt), paramMatchResult.end(paramInt));
  }
  
  private static final int j(Iterable<? extends f> paramIterable)
  {
    paramIterable = paramIterable.iterator();
    int i = 0;
    while (paramIterable.hasNext()) {
      i |= ((f)paramIterable.next()).getValue();
    }
    return i;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\text\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */