package com.google.firebase.components;

import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import java.util.Set;

public abstract interface ComponentContainer
{
  public abstract <T> T get(Class<T> paramClass);
  
  public abstract <T> Deferred<T> getDeferred(Class<T> paramClass);
  
  public abstract <T> Provider<T> getProvider(Class<T> paramClass);
  
  public abstract <T> Set<T> setOf(Class<T> paramClass);
  
  public abstract <T> Provider<Set<T>> setOfProvider(Class<T> paramClass);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\components\ComponentContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */