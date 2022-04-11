package com.google.firebase.components;

import androidx.annotation.GuardedBy;
import com.google.firebase.events.Event;
import com.google.firebase.events.EventHandler;
import com.google.firebase.events.Publisher;
import com.google.firebase.events.Subscriber;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

class EventBus
  implements Subscriber, Publisher
{
  private final Executor defaultExecutor;
  @GuardedBy("this")
  private final Map<Class<?>, ConcurrentHashMap<EventHandler<Object>, Executor>> handlerMap = new HashMap();
  @GuardedBy("this")
  private Queue<Event<?>> pendingEvents = new ArrayDeque();
  
  EventBus(Executor paramExecutor)
  {
    this.defaultExecutor = paramExecutor;
  }
  
  private Set<Map.Entry<EventHandler<Object>, Executor>> getHandlers(Event<?> paramEvent)
  {
    try
    {
      paramEvent = (Map)this.handlerMap.get(paramEvent.getType());
      if (paramEvent == null) {
        paramEvent = Collections.emptySet();
      } else {
        paramEvent = paramEvent.entrySet();
      }
      return paramEvent;
    }
    finally {}
  }
  
  void enablePublishingAndFlushPending()
  {
    try
    {
      Object localObject1 = this.pendingEvents;
      if (localObject1 != null) {
        this.pendingEvents = null;
      } else {
        localObject1 = null;
      }
      if (localObject1 != null)
      {
        localObject1 = ((Queue)localObject1).iterator();
        while (((Iterator)localObject1).hasNext()) {
          publish((Event)((Iterator)localObject1).next());
        }
      }
      return;
    }
    finally {}
  }
  
  public void publish(Event<?> paramEvent)
  {
    Preconditions.checkNotNull(paramEvent);
    try
    {
      Object localObject = this.pendingEvents;
      if (localObject != null)
      {
        ((Queue)localObject).add(paramEvent);
        return;
      }
      localObject = getHandlers(paramEvent).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        ((Executor)localEntry.getValue()).execute(new j(localEntry, paramEvent));
      }
      return;
    }
    finally {}
  }
  
  public <T> void subscribe(Class<T> paramClass, EventHandler<? super T> paramEventHandler)
  {
    subscribe(paramClass, this.defaultExecutor, paramEventHandler);
  }
  
  public <T> void subscribe(Class<T> paramClass, Executor paramExecutor, EventHandler<? super T> paramEventHandler)
  {
    try
    {
      Preconditions.checkNotNull(paramClass);
      Preconditions.checkNotNull(paramEventHandler);
      Preconditions.checkNotNull(paramExecutor);
      if (!this.handlerMap.containsKey(paramClass))
      {
        Map localMap = this.handlerMap;
        ConcurrentHashMap localConcurrentHashMap = new java/util/concurrent/ConcurrentHashMap;
        localConcurrentHashMap.<init>();
        localMap.put(paramClass, localConcurrentHashMap);
      }
      ((ConcurrentHashMap)this.handlerMap.get(paramClass)).put(paramEventHandler, paramExecutor);
      return;
    }
    finally {}
  }
  
  public <T> void unsubscribe(Class<T> paramClass, EventHandler<? super T> paramEventHandler)
  {
    try
    {
      Preconditions.checkNotNull(paramClass);
      Preconditions.checkNotNull(paramEventHandler);
      boolean bool = this.handlerMap.containsKey(paramClass);
      if (!bool) {
        return;
      }
      ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)this.handlerMap.get(paramClass);
      localConcurrentHashMap.remove(paramEventHandler);
      if (localConcurrentHashMap.isEmpty()) {
        this.handlerMap.remove(paramClass);
      }
      return;
    }
    finally {}
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\components\EventBus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */