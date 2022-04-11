package com.google.common.base;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Arrays;
import java.util.Objects;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class j
{
  public static <T> T a(@NullableDecl T paramT1, @NullableDecl T paramT2)
  {
    if (paramT1 != null) {
      return paramT1;
    }
    Objects.requireNonNull(paramT2, "Both parameters are null");
    return paramT2;
  }
  
  public static b b(Object paramObject)
  {
    return new b(paramObject.getClass().getSimpleName(), null);
  }
  
  public static final class b
  {
    private final String a;
    private final a b;
    private a c;
    private boolean d;
    
    private b(String paramString)
    {
      a locala = new a(null);
      this.b = locala;
      this.c = locala;
      this.d = false;
      this.a = ((String)n.o(paramString));
    }
    
    private a e()
    {
      a locala = new a(null);
      this.c.c = locala;
      this.c = locala;
      return locala;
    }
    
    private b f(@NullableDecl Object paramObject)
    {
      e().b = paramObject;
      return this;
    }
    
    private b g(String paramString, @NullableDecl Object paramObject)
    {
      a locala = e();
      locala.b = paramObject;
      locala.a = ((String)n.o(paramString));
      return this;
    }
    
    @CanIgnoreReturnValue
    public b a(String paramString, double paramDouble)
    {
      return g(paramString, String.valueOf(paramDouble));
    }
    
    @CanIgnoreReturnValue
    public b b(String paramString, int paramInt)
    {
      return g(paramString, String.valueOf(paramInt));
    }
    
    @CanIgnoreReturnValue
    public b c(String paramString, long paramLong)
    {
      return g(paramString, String.valueOf(paramLong));
    }
    
    @CanIgnoreReturnValue
    public b d(String paramString, @NullableDecl Object paramObject)
    {
      return g(paramString, paramObject);
    }
    
    @CanIgnoreReturnValue
    public b h(@NullableDecl Object paramObject)
    {
      return f(paramObject);
    }
    
    public String toString()
    {
      boolean bool = this.d;
      StringBuilder localStringBuilder = new StringBuilder(32);
      localStringBuilder.append(this.a);
      localStringBuilder.append('{');
      a locala = this.b.c;
      Object localObject3;
      for (Object localObject1 = ""; locala != null; localObject1 = localObject3)
      {
        Object localObject2 = locala.b;
        if (bool)
        {
          localObject3 = localObject1;
          if (localObject2 == null) {}
        }
        else
        {
          localStringBuilder.append((String)localObject1);
          localObject1 = locala.a;
          if (localObject1 != null)
          {
            localStringBuilder.append((String)localObject1);
            localStringBuilder.append('=');
          }
          if ((localObject2 != null) && (localObject2.getClass().isArray()))
          {
            localObject1 = Arrays.deepToString(new Object[] { localObject2 });
            localStringBuilder.append((CharSequence)localObject1, 1, ((String)localObject1).length() - 1);
          }
          else
          {
            localStringBuilder.append(localObject2);
          }
          localObject3 = ", ";
        }
        locala = locala.c;
      }
      localStringBuilder.append('}');
      return localStringBuilder.toString();
    }
    
    private static final class a
    {
      @NullableDecl
      String a;
      @NullableDecl
      Object b;
      @NullableDecl
      a c;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\base\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */