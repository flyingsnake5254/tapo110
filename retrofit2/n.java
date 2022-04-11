package retrofit2;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles.Lookup;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

class n
{
  private static final n a = ;
  
  private static n e()
  {
    for (;;)
    {
      try
      {
        Class.forName("android.os.Build");
        if (Build.VERSION.SDK_INT != 0)
        {
          localObject = new a();
          return (n)localObject;
        }
      }
      catch (ClassNotFoundException localClassNotFoundException2)
      {
        Object localObject;
        continue;
      }
      try
      {
        Class.forName("java.util.Optional");
        localObject = new b();
        return (n)localObject;
      }
      catch (ClassNotFoundException localClassNotFoundException1)
      {
        return new n();
      }
    }
  }
  
  static n f()
  {
    return a;
  }
  
  List<? extends c.a> a(@Nullable Executor paramExecutor)
  {
    return Collections.singletonList(new g(paramExecutor));
  }
  
  @Nullable
  Executor b()
  {
    return null;
  }
  
  List<? extends f.a> c()
  {
    return Collections.emptyList();
  }
  
  int d()
  {
    return 0;
  }
  
  @Nullable
  Object g(Method paramMethod, Class<?> paramClass, Object paramObject, @Nullable Object... paramVarArgs)
    throws Throwable
  {
    throw new UnsupportedOperationException();
  }
  
  boolean h(Method paramMethod)
  {
    return false;
  }
  
  static class a
    extends n
  {
    List<? extends c.a> a(@Nullable Executor paramExecutor)
    {
      if (paramExecutor != null)
      {
        paramExecutor = new g(paramExecutor);
        if (Build.VERSION.SDK_INT >= 24) {
          paramExecutor = Arrays.asList(new c.a[] { e.a, paramExecutor });
        } else {
          paramExecutor = Collections.singletonList(paramExecutor);
        }
        return paramExecutor;
      }
      throw new AssertionError();
    }
    
    public Executor b()
    {
      return new a();
    }
    
    List<? extends f.a> c()
    {
      List localList;
      if (Build.VERSION.SDK_INT >= 24) {
        localList = Collections.singletonList(l.a);
      } else {
        localList = Collections.emptyList();
      }
      return localList;
    }
    
    int d()
    {
      int i;
      if (Build.VERSION.SDK_INT >= 24) {
        i = 1;
      } else {
        i = 0;
      }
      return i;
    }
    
    @IgnoreJRERequirement
    boolean h(Method paramMethod)
    {
      if (Build.VERSION.SDK_INT < 24) {
        return false;
      }
      return paramMethod.isDefault();
    }
    
    static class a
      implements Executor
    {
      private final Handler c = new Handler(Looper.getMainLooper());
      
      public void execute(Runnable paramRunnable)
      {
        this.c.post(paramRunnable);
      }
    }
  }
  
  @IgnoreJRERequirement
  static class b
    extends n
  {
    List<? extends c.a> a(@Nullable Executor paramExecutor)
    {
      ArrayList localArrayList = new ArrayList(2);
      localArrayList.add(e.a);
      localArrayList.add(new g(paramExecutor));
      return Collections.unmodifiableList(localArrayList);
    }
    
    List<? extends f.a> c()
    {
      return Collections.singletonList(l.a);
    }
    
    int d()
    {
      return 1;
    }
    
    Object g(Method paramMethod, Class<?> paramClass, Object paramObject, @Nullable Object... paramVarArgs)
      throws Throwable
    {
      Constructor localConstructor = MethodHandles.Lookup.class.getDeclaredConstructor(new Class[] { Class.class, Integer.TYPE });
      localConstructor.setAccessible(true);
      return ((MethodHandles.Lookup)localConstructor.newInstance(new Object[] { paramClass, Integer.valueOf(-1) })).unreflectSpecial(paramMethod, paramClass).bindTo(paramObject).invokeWithArguments(paramVarArgs);
    }
    
    boolean h(Method paramMethod)
    {
      return paramMethod.isDefault();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\retrofit2\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */