package androidx.navigation;

import android.os.Bundle;
import androidx.core.os.BundleKt;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.collections.b0;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.j;
import kotlin.p;

@NavDestinationDsl
public final class NavActionBuilder
{
  private final Map<String, Object> defaultArguments = new LinkedHashMap();
  private int destinationId;
  private NavOptions navOptions;
  
  public final NavAction build$navigation_common_ktx_release()
  {
    int i = this.destinationId;
    NavOptions localNavOptions = this.navOptions;
    Object localObject;
    if (this.defaultArguments.isEmpty())
    {
      localObject = null;
    }
    else
    {
      localObject = b0.n(this.defaultArguments).toArray(new Pair[0]);
      if (localObject == null) {
        break label77;
      }
      localObject = (Pair[])localObject;
      localObject = BundleKt.bundleOf((Pair[])Arrays.copyOf((Object[])localObject, localObject.length));
    }
    return new NavAction(i, localNavOptions, (Bundle)localObject);
    label77:
    throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
  }
  
  public final Map<String, Object> getDefaultArguments()
  {
    return this.defaultArguments;
  }
  
  public final int getDestinationId()
  {
    return this.destinationId;
  }
  
  public final void navOptions(l<? super NavOptionsBuilder, p> paraml)
  {
    j.f(paraml, "optionsBuilder");
    NavOptionsBuilder localNavOptionsBuilder = new NavOptionsBuilder();
    paraml.invoke(localNavOptionsBuilder);
    this.navOptions = localNavOptionsBuilder.build$navigation_common_ktx_release();
  }
  
  public final void setDestinationId(int paramInt)
  {
    this.destinationId = paramInt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\navigation\NavActionBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */