package com.google.firebase.components;

import com.google.firebase.inject.Provider;
import java.util.Set;

abstract class AbstractComponentContainer
  implements ComponentContainer
{
  public <T> T get(Class<T> paramClass)
  {
    paramClass = getProvider(paramClass);
    if (paramClass == null) {
      return null;
    }
    return (T)paramClass.get();
  }
  
  public <T> Set<T> setOf(Class<T> paramClass)
  {
    return (Set)setOfProvider(paramClass).get();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\components\AbstractComponentContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */