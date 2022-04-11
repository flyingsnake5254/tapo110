package androidx.navigation;

import androidx.annotation.IdRes;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.j;
import kotlin.p;

@NavDestinationDsl
public class NavDestinationBuilder<D extends NavDestination>
{
  private Map<Integer, NavAction> actions;
  private Map<String, NavArgument> arguments;
  private List<NavDeepLink> deepLinks;
  private final int id;
  private CharSequence label;
  private final Navigator<? extends D> navigator;
  
  public NavDestinationBuilder(Navigator<? extends D> paramNavigator, @IdRes int paramInt)
  {
    this.navigator = paramNavigator;
    this.id = paramInt;
    this.arguments = new LinkedHashMap();
    this.deepLinks = new ArrayList();
    this.actions = new LinkedHashMap();
  }
  
  public final void action(int paramInt, l<? super NavActionBuilder, p> paraml)
  {
    j.f(paraml, "actionBuilder");
    Map localMap = this.actions;
    NavActionBuilder localNavActionBuilder = new NavActionBuilder();
    paraml.invoke(localNavActionBuilder);
    localMap.put(Integer.valueOf(paramInt), localNavActionBuilder.build$navigation_common_ktx_release());
  }
  
  public final void argument(String paramString, l<? super NavArgumentBuilder, p> paraml)
  {
    j.f(paramString, "name");
    j.f(paraml, "argumentBuilder");
    Map localMap = this.arguments;
    NavArgumentBuilder localNavArgumentBuilder = new NavArgumentBuilder();
    paraml.invoke(localNavArgumentBuilder);
    localMap.put(paramString, localNavArgumentBuilder.build());
  }
  
  public D build()
  {
    NavDestination localNavDestination = this.navigator.createDestination();
    localNavDestination.setId(this.id);
    localNavDestination.setLabel(this.label);
    Iterator localIterator = this.arguments.entrySet().iterator();
    while (localIterator.hasNext())
    {
      localObject = (Map.Entry)localIterator.next();
      localNavDestination.addArgument((String)((Map.Entry)localObject).getKey(), (NavArgument)((Map.Entry)localObject).getValue());
    }
    Object localObject = this.deepLinks.iterator();
    while (((Iterator)localObject).hasNext()) {
      localNavDestination.addDeepLink((NavDeepLink)((Iterator)localObject).next());
    }
    localIterator = this.actions.entrySet().iterator();
    while (localIterator.hasNext())
    {
      localObject = (Map.Entry)localIterator.next();
      localNavDestination.putAction(((Number)((Map.Entry)localObject).getKey()).intValue(), (NavAction)((Map.Entry)localObject).getValue());
    }
    return localNavDestination;
  }
  
  public final void deepLink(String paramString)
  {
    j.f(paramString, "uriPattern");
    this.deepLinks.add(new NavDeepLink(paramString));
  }
  
  public final void deepLink(l<? super NavDeepLinkDslBuilder, p> paraml)
  {
    j.f(paraml, "navDeepLink");
    List localList = this.deepLinks;
    NavDeepLinkDslBuilder localNavDeepLinkDslBuilder = new NavDeepLinkDslBuilder();
    paraml.invoke(localNavDeepLinkDslBuilder);
    localList.add(localNavDeepLinkDslBuilder.build$navigation_common_ktx_release());
  }
  
  public final int getId()
  {
    return this.id;
  }
  
  public final CharSequence getLabel()
  {
    return this.label;
  }
  
  protected final Navigator<? extends D> getNavigator()
  {
    return this.navigator;
  }
  
  public final void setLabel(CharSequence paramCharSequence)
  {
    this.label = paramCharSequence;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\navigation\NavDestinationBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */