package b.d.b.d.b;

import androidx.annotation.NonNull;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class b
{
  private static final String a;
  private final a b;
  private final c c;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b.class.getSimpleName());
    localStringBuilder.append(".DefaultKey");
    a = localStringBuilder.toString();
  }
  
  public b(@NonNull a parama, @NonNull c paramc)
  {
    this.b = parama;
    this.c = paramc;
  }
  
  @NonNull
  public <T extends a> T a(@NonNull Class<T> paramClass)
  {
    String str = paramClass.getCanonicalName();
    if (str != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(a);
      localStringBuilder.append(":");
      localStringBuilder.append(str);
      return b(localStringBuilder.toString(), paramClass);
    }
    throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
  }
  
  @NonNull
  public <T extends a> T b(@NonNull String paramString, @NonNull Class<T> paramClass)
  {
    a locala = this.c.b(paramString);
    if (paramClass.isInstance(locala)) {
      return locala;
    }
    paramClass = this.b.create(paramClass);
    this.c.c(paramString, paramClass);
    return paramClass;
  }
  
  public static abstract interface a
  {
    @NonNull
    public abstract <T extends a> T create(@NonNull Class<T> paramClass);
  }
  
  public static class b
    implements b.a
  {
    @NonNull
    public <T extends a> T create(@NonNull Class<T> paramClass)
    {
      try
      {
        a locala = (a)paramClass.newInstance();
        return locala;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("Cannot create an instance of ");
        localStringBuilder2.append(paramClass);
        throw new RuntimeException(localStringBuilder2.toString(), localIllegalAccessException);
      }
      catch (InstantiationException localInstantiationException)
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("Cannot create an instance of ");
        localStringBuilder1.append(paramClass);
        throw new RuntimeException(localStringBuilder1.toString(), localInstantiationException);
      }
    }
  }
  
  public static class c
    extends b.b
  {
    protected final b.d.b.d.a.b a;
    
    public c(b.d.b.d.a.b paramb)
    {
      this.a = paramb;
    }
    
    @NonNull
    public <T extends a> T create(@NonNull Class<T> paramClass)
    {
      if (a.class.isAssignableFrom(paramClass)) {
        try
        {
          localObject = (a)paramClass.getConstructor(new Class[] { b.d.b.d.a.b.class }).newInstance(new Object[] { this.a });
          return (T)localObject;
        }
        catch (InvocationTargetException localInvocationTargetException)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Cannot create an instance of ");
          ((StringBuilder)localObject).append(paramClass);
          throw new RuntimeException(((StringBuilder)localObject).toString(), localInvocationTargetException);
        }
        catch (InstantiationException localInstantiationException)
        {
          Object localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Cannot create an instance of ");
          ((StringBuilder)localObject).append(paramClass);
          throw new RuntimeException(((StringBuilder)localObject).toString(), localInstantiationException);
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("Cannot create an instance of ");
          localStringBuilder.append(paramClass);
          throw new RuntimeException(localStringBuilder.toString(), localIllegalAccessException);
        }
        catch (NoSuchMethodException localNoSuchMethodException)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Cannot create an instance of ");
          localStringBuilder.append(paramClass);
          throw new RuntimeException(localStringBuilder.toString(), localNoSuchMethodException);
        }
      }
      return super.create(paramClass);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\b\d\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */