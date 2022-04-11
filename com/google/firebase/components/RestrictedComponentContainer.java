package com.google.firebase.components;

import com.google.firebase.events.Event;
import com.google.firebase.events.Publisher;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

final class RestrictedComponentContainer
  extends AbstractComponentContainer
{
  private final Set<Class<?>> allowedDeferredInterfaces;
  private final Set<Class<?>> allowedDirectInterfaces;
  private final Set<Class<?>> allowedProviderInterfaces;
  private final Set<Class<?>> allowedPublishedEvents;
  private final Set<Class<?>> allowedSetDirectInterfaces;
  private final Set<Class<?>> allowedSetProviderInterfaces;
  private final ComponentContainer delegateContainer;
  
  RestrictedComponentContainer(Component<?> paramComponent, ComponentContainer paramComponentContainer)
  {
    HashSet localHashSet1 = new HashSet();
    HashSet localHashSet2 = new HashSet();
    HashSet localHashSet3 = new HashSet();
    HashSet localHashSet4 = new HashSet();
    HashSet localHashSet5 = new HashSet();
    Iterator localIterator = paramComponent.getDependencies().iterator();
    while (localIterator.hasNext())
    {
      Dependency localDependency = (Dependency)localIterator.next();
      if (localDependency.isDirectInjection())
      {
        if (localDependency.isSet()) {
          localHashSet4.add(localDependency.getInterface());
        } else {
          localHashSet1.add(localDependency.getInterface());
        }
      }
      else if (localDependency.isDeferred()) {
        localHashSet3.add(localDependency.getInterface());
      } else if (localDependency.isSet()) {
        localHashSet5.add(localDependency.getInterface());
      } else {
        localHashSet2.add(localDependency.getInterface());
      }
    }
    if (!paramComponent.getPublishedEvents().isEmpty()) {
      localHashSet1.add(Publisher.class);
    }
    this.allowedDirectInterfaces = Collections.unmodifiableSet(localHashSet1);
    this.allowedProviderInterfaces = Collections.unmodifiableSet(localHashSet2);
    this.allowedDeferredInterfaces = Collections.unmodifiableSet(localHashSet3);
    this.allowedSetDirectInterfaces = Collections.unmodifiableSet(localHashSet4);
    this.allowedSetProviderInterfaces = Collections.unmodifiableSet(localHashSet5);
    this.allowedPublishedEvents = paramComponent.getPublishedEvents();
    this.delegateContainer = paramComponentContainer;
  }
  
  public <T> T get(Class<T> paramClass)
  {
    if (this.allowedDirectInterfaces.contains(paramClass))
    {
      Object localObject = this.delegateContainer.get(paramClass);
      if (!paramClass.equals(Publisher.class)) {
        return (T)localObject;
      }
      return new RestrictedPublisher(this.allowedPublishedEvents, (Publisher)localObject);
    }
    throw new DependencyException(String.format("Attempting to request an undeclared dependency %s.", new Object[] { paramClass }));
  }
  
  public <T> Deferred<T> getDeferred(Class<T> paramClass)
  {
    if (this.allowedDeferredInterfaces.contains(paramClass)) {
      return this.delegateContainer.getDeferred(paramClass);
    }
    throw new DependencyException(String.format("Attempting to request an undeclared dependency Deferred<%s>.", new Object[] { paramClass }));
  }
  
  public <T> Provider<T> getProvider(Class<T> paramClass)
  {
    if (this.allowedProviderInterfaces.contains(paramClass)) {
      return this.delegateContainer.getProvider(paramClass);
    }
    throw new DependencyException(String.format("Attempting to request an undeclared dependency Provider<%s>.", new Object[] { paramClass }));
  }
  
  public <T> Set<T> setOf(Class<T> paramClass)
  {
    if (this.allowedSetDirectInterfaces.contains(paramClass)) {
      return this.delegateContainer.setOf(paramClass);
    }
    throw new DependencyException(String.format("Attempting to request an undeclared dependency Set<%s>.", new Object[] { paramClass }));
  }
  
  public <T> Provider<Set<T>> setOfProvider(Class<T> paramClass)
  {
    if (this.allowedSetProviderInterfaces.contains(paramClass)) {
      return this.delegateContainer.setOfProvider(paramClass);
    }
    throw new DependencyException(String.format("Attempting to request an undeclared dependency Provider<Set<%s>>.", new Object[] { paramClass }));
  }
  
  private static class RestrictedPublisher
    implements Publisher
  {
    private final Set<Class<?>> allowedPublishedEvents;
    private final Publisher delegate;
    
    public RestrictedPublisher(Set<Class<?>> paramSet, Publisher paramPublisher)
    {
      this.allowedPublishedEvents = paramSet;
      this.delegate = paramPublisher;
    }
    
    public void publish(Event<?> paramEvent)
    {
      if (this.allowedPublishedEvents.contains(paramEvent.getType()))
      {
        this.delegate.publish(paramEvent);
        return;
      }
      throw new DependencyException(String.format("Attempting to publish an undeclared event %s.", new Object[] { paramEvent }));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\components\RestrictedComponentContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */