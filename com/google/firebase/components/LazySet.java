package com.google.firebase.components;

import com.google.firebase.inject.Provider;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

class LazySet<T>
  implements Provider<Set<T>>
{
  private volatile Set<T> actualSet = null;
  private volatile Set<Provider<T>> providers = Collections.newSetFromMap(new ConcurrentHashMap());
  
  LazySet(Collection<Provider<T>> paramCollection)
  {
    this.providers.addAll(paramCollection);
  }
  
  static LazySet<?> fromCollection(Collection<Provider<?>> paramCollection)
  {
    return new LazySet((Set)paramCollection);
  }
  
  private void updateSet()
  {
    try
    {
      Iterator localIterator = this.providers.iterator();
      while (localIterator.hasNext())
      {
        Provider localProvider = (Provider)localIterator.next();
        this.actualSet.add(localProvider.get());
      }
      this.providers = null;
      return;
    }
    finally {}
  }
  
  void add(Provider<T> paramProvider)
  {
    try
    {
      if (this.actualSet == null) {
        this.providers.add(paramProvider);
      } else {
        this.actualSet.add(paramProvider.get());
      }
      return;
    }
    finally {}
  }
  
  public Set<T> get()
  {
    if (this.actualSet == null) {
      try
      {
        if (this.actualSet == null)
        {
          ConcurrentHashMap localConcurrentHashMap = new java/util/concurrent/ConcurrentHashMap;
          localConcurrentHashMap.<init>();
          this.actualSet = Collections.newSetFromMap(localConcurrentHashMap);
          updateSet();
        }
      }
      finally {}
    }
    return Collections.unmodifiableSet(this.actualSet);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\components\LazySet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */