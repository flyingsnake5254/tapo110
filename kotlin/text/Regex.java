package kotlin.text;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.b.a;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import kotlin.sequences.f;
import kotlin.sequences.g;
import kotlin.v.d;
import kotlin.v.e;

public final class Regex
  implements Serializable
{
  public static final a Companion = new a(null);
  private Set<? extends RegexOption> _options;
  private final Pattern nativePattern;
  
  public Regex(String paramString)
  {
    this(paramString);
  }
  
  public Regex(String paramString, Set<? extends RegexOption> paramSet)
  {
    this(paramString);
  }
  
  public Regex(String paramString, RegexOption paramRegexOption)
  {
    this(paramString);
  }
  
  public Regex(Pattern paramPattern)
  {
    this.nativePattern = paramPattern;
  }
  
  private final Object writeReplace()
  {
    String str = this.nativePattern.pattern();
    j.d(str, "nativePattern.pattern()");
    return new b(str, this.nativePattern.flags());
  }
  
  public final boolean containsMatchIn(CharSequence paramCharSequence)
  {
    j.e(paramCharSequence, "input");
    return this.nativePattern.matcher(paramCharSequence).find();
  }
  
  public final i find(CharSequence paramCharSequence, int paramInt)
  {
    j.e(paramCharSequence, "input");
    Matcher localMatcher = this.nativePattern.matcher(paramCharSequence);
    j.d(localMatcher, "nativePattern.matcher(input)");
    return k.a(localMatcher, paramInt, paramCharSequence);
  }
  
  public final f<i> findAll(final CharSequence paramCharSequence, final int paramInt)
  {
    j.e(paramCharSequence, "input");
    if ((paramInt >= 0) && (paramInt <= paramCharSequence.length())) {
      return g.c(new c(this, paramCharSequence, paramInt), d.c);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Start index out of bounds: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", input length: ");
    localStringBuilder.append(paramCharSequence.length());
    throw new IndexOutOfBoundsException(localStringBuilder.toString());
  }
  
  public final Set<RegexOption> getOptions()
  {
    Object localObject = this._options;
    if (localObject == null)
    {
      int i = this.nativePattern.flags();
      localObject = EnumSet.allOf(RegexOption.class);
      kotlin.collections.l.s((Iterable)localObject, new Regex.fromInt..inlined.apply.lambda.1(i));
      localObject = Collections.unmodifiableSet((Set)localObject);
      j.d(localObject, "Collections.unmodifiable…mask == it.value }\n    })");
      this._options = ((Set)localObject);
    }
    return (Set<RegexOption>)localObject;
  }
  
  public final String getPattern()
  {
    String str = this.nativePattern.pattern();
    j.d(str, "nativePattern.pattern()");
    return str;
  }
  
  public final i matchEntire(CharSequence paramCharSequence)
  {
    j.e(paramCharSequence, "input");
    Matcher localMatcher = this.nativePattern.matcher(paramCharSequence);
    j.d(localMatcher, "nativePattern.matcher(input)");
    return k.b(localMatcher, paramCharSequence);
  }
  
  public final boolean matches(CharSequence paramCharSequence)
  {
    j.e(paramCharSequence, "input");
    return this.nativePattern.matcher(paramCharSequence).matches();
  }
  
  public final String replace(CharSequence paramCharSequence, String paramString)
  {
    j.e(paramCharSequence, "input");
    j.e(paramString, "replacement");
    paramCharSequence = this.nativePattern.matcher(paramCharSequence).replaceAll(paramString);
    j.d(paramCharSequence, "nativePattern.matcher(in…).replaceAll(replacement)");
    return paramCharSequence;
  }
  
  public final String replace(CharSequence paramCharSequence, kotlin.jvm.b.l<? super i, ? extends CharSequence> paraml)
  {
    j.e(paramCharSequence, "input");
    j.e(paraml, "transform");
    int i = 0;
    Object localObject = find$default(this, paramCharSequence, 0, 2, null);
    if (localObject != null)
    {
      int j = paramCharSequence.length();
      StringBuilder localStringBuilder = new StringBuilder(j);
      int k;
      i locali;
      do
      {
        j.c(localObject);
        localStringBuilder.append(paramCharSequence, i, ((i)localObject).a().h().intValue());
        localStringBuilder.append((CharSequence)paraml.invoke(localObject));
        k = ((i)localObject).a().g().intValue() + 1;
        locali = ((i)localObject).next();
        if (k >= j) {
          break;
        }
        i = k;
        localObject = locali;
      } while (locali != null);
      if (k < j) {
        localStringBuilder.append(paramCharSequence, k, j);
      }
      paramCharSequence = localStringBuilder.toString();
      j.d(paramCharSequence, "sb.toString()");
      return paramCharSequence;
    }
    return paramCharSequence.toString();
  }
  
  public final String replaceFirst(CharSequence paramCharSequence, String paramString)
  {
    j.e(paramCharSequence, "input");
    j.e(paramString, "replacement");
    paramCharSequence = this.nativePattern.matcher(paramCharSequence).replaceFirst(paramString);
    j.d(paramCharSequence, "nativePattern.matcher(in…replaceFirst(replacement)");
    return paramCharSequence;
  }
  
  public final List<String> split(CharSequence paramCharSequence, int paramInt)
  {
    j.e(paramCharSequence, "input");
    int i = 0;
    int j;
    if (paramInt >= 0) {
      j = 1;
    } else {
      j = 0;
    }
    if (j != 0)
    {
      Matcher localMatcher = this.nativePattern.matcher(paramCharSequence);
      if ((localMatcher.find()) && (paramInt != 1))
      {
        j = 10;
        if (paramInt > 0) {
          j = e.d(paramInt, 10);
        }
        ArrayList localArrayList = new ArrayList(j);
        int k = paramInt - 1;
        paramInt = i;
        do
        {
          localArrayList.add(paramCharSequence.subSequence(paramInt, localMatcher.start()).toString());
          j = localMatcher.end();
          if ((k >= 0) && (localArrayList.size() == k)) {
            break;
          }
          paramInt = j;
        } while (localMatcher.find());
        localArrayList.add(paramCharSequence.subSequence(j, paramCharSequence.length()).toString());
        return localArrayList;
      }
      return kotlin.collections.l.b(paramCharSequence.toString());
    }
    paramCharSequence = new StringBuilder();
    paramCharSequence.append("Limit must be non-negative, but was ");
    paramCharSequence.append(paramInt);
    paramCharSequence.append('.');
    throw new IllegalArgumentException(paramCharSequence.toString().toString());
  }
  
  public final Pattern toPattern()
  {
    return this.nativePattern;
  }
  
  public String toString()
  {
    String str = this.nativePattern.toString();
    j.d(str, "nativePattern.toString()");
    return str;
  }
  
  public static final class a
  {
    private final int b(int paramInt)
    {
      int i = paramInt;
      if ((paramInt & 0x2) != 0) {
        i = paramInt | 0x40;
      }
      return i;
    }
  }
  
  private static final class b
    implements Serializable
  {
    public static final a c = new a(null);
    private final String d;
    private final int f;
    
    public b(String paramString, int paramInt)
    {
      this.d = paramString;
      this.f = paramInt;
    }
    
    public static final class a {}
  }
  
  static final class c
    extends Lambda
    implements a<i>
  {
    c(Regex paramRegex, CharSequence paramCharSequence, int paramInt)
    {
      super();
    }
    
    public final i a()
    {
      return this.c.find(paramCharSequence, paramInt);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\text\Regex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */