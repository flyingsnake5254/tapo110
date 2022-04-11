package com.google.firebase.components;

import android.util.Log;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import com.google.firebase.dynamicloading.ComponentLoader;
import com.google.firebase.events.Publisher;
import com.google.firebase.events.Subscriber;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

public class ComponentRuntime
  extends AbstractComponentContainer
  implements ComponentLoader
{
  private static final Provider<Set<Object>> EMPTY_PROVIDER = k.a;
  private final Map<Component<?>, Provider<?>> components = new HashMap();
  private final AtomicReference<Boolean> eagerComponentsInitializedWith = new AtomicReference();
  private final EventBus eventBus;
  private final Map<Class<?>, Provider<?>> lazyInstanceMap = new HashMap();
  private final Map<Class<?>, LazySet<?>> lazySetMap = new HashMap();
  private final List<Provider<ComponentRegistrar>> unprocessedRegistrarProviders;
  
  private ComponentRuntime(Executor paramExecutor, Iterable<Provider<ComponentRegistrar>> paramIterable, Collection<Component<?>> paramCollection)
  {
    Object localObject = new EventBus(paramExecutor);
    this.eventBus = ((EventBus)localObject);
    paramExecutor = new ArrayList();
    paramExecutor.add(Component.of(localObject, EventBus.class, new Class[] { Subscriber.class, Publisher.class }));
    paramExecutor.add(Component.of(this, ComponentLoader.class, new Class[0]));
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      localObject = (Component)paramCollection.next();
      if (localObject != null) {
        paramExecutor.add(localObject);
      }
    }
    this.unprocessedRegistrarProviders = iterableToList(paramIterable);
    discoverComponents(paramExecutor);
  }
  
  @Deprecated
  public ComponentRuntime(Executor paramExecutor, Iterable<ComponentRegistrar> paramIterable, Component<?>... paramVarArgs)
  {
    this(paramExecutor, toProviders(paramIterable), Arrays.asList(paramVarArgs));
  }
  
  public static Builder builder(Executor paramExecutor)
  {
    return new Builder(paramExecutor);
  }
  
  private void discoverComponents(List<Component<?>> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      Object localObject1 = this.unprocessedRegistrarProviders.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (Provider)((Iterator)localObject1).next();
        try
        {
          localObject2 = (ComponentRegistrar)((Provider)localObject2).get();
          if (localObject2 != null)
          {
            paramList.addAll(((ComponentRegistrar)localObject2).getComponents());
            ((Iterator)localObject1).remove();
          }
        }
        catch (InvalidRegistrarException localInvalidRegistrarException)
        {
          ((Iterator)localObject1).remove();
          Log.w("ComponentDiscovery", "Invalid component registrar.", localInvalidRegistrarException);
        }
      }
      if (this.components.isEmpty())
      {
        CycleDetector.detect(paramList);
      }
      else
      {
        localObject1 = new java/util/ArrayList;
        ((ArrayList)localObject1).<init>(this.components.keySet());
        ((ArrayList)localObject1).addAll(paramList);
        CycleDetector.detect((List)localObject1);
      }
      localObject1 = paramList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Component localComponent = (Component)((Iterator)localObject1).next();
        Lazy localLazy = new com/google/firebase/components/Lazy;
        e locale = new com/google/firebase/components/e;
        locale.<init>(this, localComponent);
        localLazy.<init>(locale);
        this.components.put(localComponent, localLazy);
      }
      localArrayList.addAll(processInstanceComponents(paramList));
      localArrayList.addAll(processSetComponents());
      processDependencies();
      paramList = localArrayList.iterator();
      while (paramList.hasNext()) {
        ((Runnable)paramList.next()).run();
      }
      maybeInitializeEagerComponents();
      return;
    }
    finally {}
  }
  
  private void doInitializeEagerComponents(Map<Component<?>, Provider<?>> paramMap, boolean paramBoolean)
  {
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      paramMap = (Component)((Map.Entry)localObject).getKey();
      localObject = (Provider)((Map.Entry)localObject).getValue();
      if ((paramMap.isAlwaysEager()) || ((paramMap.isEagerInDefaultApp()) && (paramBoolean))) {
        ((Provider)localObject).get();
      }
    }
    this.eventBus.enablePublishingAndFlushPending();
  }
  
  private static <T> List<T> iterableToList(Iterable<T> paramIterable)
  {
    ArrayList localArrayList = new ArrayList();
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      localArrayList.add(paramIterable.next());
    }
    return localArrayList;
  }
  
  private void maybeInitializeEagerComponents()
  {
    Boolean localBoolean = (Boolean)this.eagerComponentsInitializedWith.get();
    if (localBoolean != null) {
      doInitializeEagerComponents(this.components, localBoolean.booleanValue());
    }
  }
  
  private void processDependencies()
  {
    Iterator localIterator1 = this.components.keySet().iterator();
    while (localIterator1.hasNext())
    {
      Component localComponent = (Component)localIterator1.next();
      Iterator localIterator2 = localComponent.getDependencies().iterator();
      Dependency localDependency;
      while (localIterator2.hasNext())
      {
        localDependency = (Dependency)localIterator2.next();
        if ((localDependency.isSet()) && (!this.lazySetMap.containsKey(localDependency.getInterface())))
        {
          this.lazySetMap.put(localDependency.getInterface(), LazySet.fromCollection(Collections.emptySet()));
        }
        else if (!this.lazyInstanceMap.containsKey(localDependency.getInterface()))
        {
          if (localDependency.isRequired()) {
            break label167;
          }
          if (!localDependency.isSet()) {
            this.lazyInstanceMap.put(localDependency.getInterface(), OptionalProvider.empty());
          }
        }
      }
      continue;
      label167:
      throw new MissingDependencyException(String.format("Unsatisfied dependency for component %s: %s", new Object[] { localComponent, localDependency.getInterface() }));
    }
  }
  
  private List<Runnable> processInstanceComponents(List<Component<?>> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (Component)paramList.next();
      if (((Component)localObject).isValue())
      {
        Provider localProvider = (Provider)this.components.get(localObject);
        localObject = ((Component)localObject).getProvidedInterfaces().iterator();
        while (((Iterator)localObject).hasNext())
        {
          Class localClass = (Class)((Iterator)localObject).next();
          if (!this.lazyInstanceMap.containsKey(localClass)) {
            this.lazyInstanceMap.put(localClass, localProvider);
          } else {
            localArrayList.add(new i((OptionalProvider)this.lazyInstanceMap.get(localClass), localProvider));
          }
        }
      }
    }
    return localArrayList;
  }
  
  private List<Runnable> processSetComponents()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = new HashMap();
    Iterator localIterator1 = this.components.entrySet().iterator();
    Object localObject2;
    while (localIterator1.hasNext())
    {
      localObject2 = (Map.Entry)localIterator1.next();
      Object localObject3 = (Component)((Map.Entry)localObject2).getKey();
      if (!((Component)localObject3).isValue())
      {
        localObject2 = (Provider)((Map.Entry)localObject2).getValue();
        Iterator localIterator2 = ((Component)localObject3).getProvidedInterfaces().iterator();
        while (localIterator2.hasNext())
        {
          localObject3 = (Class)localIterator2.next();
          if (!((Map)localObject1).containsKey(localObject3)) {
            ((Map)localObject1).put(localObject3, new HashSet());
          }
          ((Set)((Map)localObject1).get(localObject3)).add(localObject2);
        }
      }
    }
    localIterator1 = ((Map)localObject1).entrySet().iterator();
    while (localIterator1.hasNext())
    {
      localObject2 = (Map.Entry)localIterator1.next();
      if (!this.lazySetMap.containsKey(((Map.Entry)localObject2).getKey()))
      {
        this.lazySetMap.put((Class)((Map.Entry)localObject2).getKey(), LazySet.fromCollection((Collection)((Map.Entry)localObject2).getValue()));
      }
      else
      {
        localObject1 = (LazySet)this.lazySetMap.get(((Map.Entry)localObject2).getKey());
        localObject2 = ((Set)((Map.Entry)localObject2).getValue()).iterator();
        while (((Iterator)localObject2).hasNext()) {
          localArrayList.add(new h((LazySet)localObject1, (Provider)((Iterator)localObject2).next()));
        }
      }
    }
    return localArrayList;
  }
  
  private static Iterable<Provider<ComponentRegistrar>> toProviders(Iterable<ComponentRegistrar> paramIterable)
  {
    ArrayList localArrayList = new ArrayList();
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      localArrayList.add(new f((ComponentRegistrar)paramIterable.next()));
    }
    return localArrayList;
  }
  
  public void discoverComponents()
  {
    try
    {
      if (this.unprocessedRegistrarProviders.isEmpty()) {
        return;
      }
      discoverComponents(new ArrayList());
      return;
    }
    finally {}
  }
  
  public <T> Deferred<T> getDeferred(Class<T> paramClass)
  {
    paramClass = getProvider(paramClass);
    if (paramClass == null) {
      return OptionalProvider.empty();
    }
    if ((paramClass instanceof OptionalProvider)) {
      return (OptionalProvider)paramClass;
    }
    return OptionalProvider.of(paramClass);
  }
  
  public <T> Provider<T> getProvider(Class<T> paramClass)
  {
    try
    {
      Preconditions.checkNotNull(paramClass, "Null interface requested.");
      paramClass = (Provider)this.lazyInstanceMap.get(paramClass);
      return paramClass;
    }
    finally
    {
      paramClass = finally;
      throw paramClass;
    }
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.TESTS})
  @VisibleForTesting
  public void initializeAllComponentsForTests()
  {
    Iterator localIterator = this.components.values().iterator();
    while (localIterator.hasNext()) {
      ((Provider)localIterator.next()).get();
    }
  }
  
  public void initializeEagerComponents(boolean paramBoolean)
  {
    if (!this.eagerComponentsInitializedWith.compareAndSet(null, Boolean.valueOf(paramBoolean))) {
      return;
    }
    try
    {
      HashMap localHashMap = new java/util/HashMap;
      localHashMap.<init>(this.components);
      doInitializeEagerComponents(localHashMap, paramBoolean);
      return;
    }
    finally {}
  }
  
  public <T> Provider<Set<T>> setOfProvider(Class<T> paramClass)
  {
    try
    {
      paramClass = (LazySet)this.lazySetMap.get(paramClass);
      if (paramClass != null) {
        return paramClass;
      }
      paramClass = EMPTY_PROVIDER;
      return paramClass;
    }
    finally {}
  }
  
  public static final class Builder
  {
    private final List<Component<?>> additionalComponents = new ArrayList();
    private final Executor defaultExecutor;
    private final List<Provider<ComponentRegistrar>> lazyRegistrars = new ArrayList();
    
    Builder(Executor paramExecutor)
    {
      this.defaultExecutor = paramExecutor;
    }
    
    public Builder addComponent(Component<?> paramComponent)
    {
      this.additionalComponents.add(paramComponent);
      return this;
    }
    
    public Builder addComponentRegistrar(ComponentRegistrar paramComponentRegistrar)
    {
      this.lazyRegistrars.add(new g(paramComponentRegistrar));
      return this;
    }
    
    public Builder addLazyComponentRegistrars(Collection<Provider<ComponentRegistrar>> paramCollection)
    {
      this.lazyRegistrars.addAll(paramCollection);
      return this;
    }
    
    public ComponentRuntime build()
    {
      return new ComponentRuntime(this.defaultExecutor, this.lazyRegistrars, this.additionalComponents, null);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\components\ComponentRuntime.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */