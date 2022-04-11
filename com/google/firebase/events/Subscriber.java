package com.google.firebase.events;

import java.util.concurrent.Executor;

public abstract interface Subscriber
{
  public abstract <T> void subscribe(Class<T> paramClass, EventHandler<? super T> paramEventHandler);
  
  public abstract <T> void subscribe(Class<T> paramClass, Executor paramExecutor, EventHandler<? super T> paramEventHandler);
  
  public abstract <T> void unsubscribe(Class<T> paramClass, EventHandler<? super T> paramEventHandler);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\events\Subscriber.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */