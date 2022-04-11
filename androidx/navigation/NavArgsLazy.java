package androidx.navigation;

import android.os.Bundle;
import androidx.collection.SimpleArrayMap;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;
import kotlin.TypeCastException;
import kotlin.f;
import kotlin.jvm.internal.j;
import kotlin.reflect.c;

public final class NavArgsLazy<Args extends NavArgs>
  implements f<Args>
{
  private final kotlin.jvm.b.a<Bundle> argumentProducer;
  private Args cached;
  private final c<Args> navArgsClass;
  
  public NavArgsLazy(c<Args> paramc, kotlin.jvm.b.a<Bundle> parama)
  {
    this.navArgsClass = paramc;
    this.argumentProducer = parama;
  }
  
  public Args getValue()
  {
    Object localObject1 = this.cached;
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject1 = (Bundle)this.argumentProducer.invoke();
      localObject2 = (Method)NavArgsLazyKt.getMethodMap().get(this.navArgsClass);
      if (localObject2 == null)
      {
        Class localClass = kotlin.jvm.a.a(this.navArgsClass);
        localObject2 = NavArgsLazyKt.getMethodSignature();
        localObject2 = localClass.getMethod("fromBundle", (Class[])Arrays.copyOf((Object[])localObject2, localObject2.length));
        NavArgsLazyKt.getMethodMap().put(this.navArgsClass, localObject2);
        j.b(localObject2, "navArgsClass.java.getMet…hod\n                    }");
      }
      localObject2 = ((Method)localObject2).invoke(null, new Object[] { localObject1 });
      if (localObject2 != null)
      {
        localObject2 = (NavArgs)localObject2;
        this.cached = ((NavArgs)localObject2);
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type Args");
      }
    }
    return (Args)localObject2;
  }
  
  public boolean isInitialized()
  {
    boolean bool;
    if (this.cached != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\navigation\NavArgsLazy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */