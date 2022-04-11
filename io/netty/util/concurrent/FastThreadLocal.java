package io.netty.util.concurrent;

import io.netty.util.internal.InternalThreadLocalMap;
import io.netty.util.internal.PlatformDependent;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;

public class FastThreadLocal<V>
{
  private static final int variablesToRemoveIndex = ;
  private final int index = InternalThreadLocalMap.nextVariableIndex();
  
  private static void addToVariablesToRemove(InternalThreadLocalMap paramInternalThreadLocalMap, FastThreadLocal<?> paramFastThreadLocal)
  {
    int i = variablesToRemoveIndex;
    Object localObject = paramInternalThreadLocalMap.indexedVariable(i);
    if ((localObject != InternalThreadLocalMap.UNSET) && (localObject != null))
    {
      paramInternalThreadLocalMap = (Set)localObject;
    }
    else
    {
      localObject = Collections.newSetFromMap(new IdentityHashMap());
      paramInternalThreadLocalMap.setIndexedVariable(i, localObject);
      paramInternalThreadLocalMap = (InternalThreadLocalMap)localObject;
    }
    paramInternalThreadLocalMap.add(paramFastThreadLocal);
  }
  
  public static void destroy() {}
  
  private V initialize(InternalThreadLocalMap paramInternalThreadLocalMap)
  {
    Object localObject2;
    try
    {
      Object localObject1 = initialValue();
    }
    catch (Exception localException)
    {
      PlatformDependent.throwException(localException);
      localObject2 = null;
    }
    paramInternalThreadLocalMap.setIndexedVariable(this.index, localObject2);
    addToVariablesToRemove(paramInternalThreadLocalMap, this);
    return (V)localObject2;
  }
  
  public static void removeAll()
  {
    InternalThreadLocalMap localInternalThreadLocalMap = InternalThreadLocalMap.getIfSet();
    if (localInternalThreadLocalMap == null) {
      return;
    }
    try
    {
      Object localObject2 = localInternalThreadLocalMap.indexedVariable(variablesToRemoveIndex);
      if ((localObject2 != null) && (localObject2 != InternalThreadLocalMap.UNSET))
      {
        localObject2 = (Set)localObject2;
        int i = 0;
        localObject2 = (FastThreadLocal[])((Set)localObject2).toArray(new FastThreadLocal[0]);
        int j = localObject2.length;
        while (i < j)
        {
          localObject2[i].remove(localInternalThreadLocalMap);
          i++;
        }
      }
      return;
    }
    finally
    {
      InternalThreadLocalMap.remove();
    }
  }
  
  private static void removeFromVariablesToRemove(InternalThreadLocalMap paramInternalThreadLocalMap, FastThreadLocal<?> paramFastThreadLocal)
  {
    paramInternalThreadLocalMap = paramInternalThreadLocalMap.indexedVariable(variablesToRemoveIndex);
    if ((paramInternalThreadLocalMap != InternalThreadLocalMap.UNSET) && (paramInternalThreadLocalMap != null)) {
      ((Set)paramInternalThreadLocalMap).remove(paramFastThreadLocal);
    }
  }
  
  private void setKnownNotUnset(InternalThreadLocalMap paramInternalThreadLocalMap, V paramV)
  {
    if (paramInternalThreadLocalMap.setIndexedVariable(this.index, paramV)) {
      addToVariablesToRemove(paramInternalThreadLocalMap, this);
    }
  }
  
  public static int size()
  {
    InternalThreadLocalMap localInternalThreadLocalMap = InternalThreadLocalMap.getIfSet();
    if (localInternalThreadLocalMap == null) {
      return 0;
    }
    return localInternalThreadLocalMap.size();
  }
  
  public final V get()
  {
    InternalThreadLocalMap localInternalThreadLocalMap = InternalThreadLocalMap.get();
    Object localObject = localInternalThreadLocalMap.indexedVariable(this.index);
    if (localObject != InternalThreadLocalMap.UNSET) {
      return (V)localObject;
    }
    return (V)initialize(localInternalThreadLocalMap);
  }
  
  public final V get(InternalThreadLocalMap paramInternalThreadLocalMap)
  {
    Object localObject = paramInternalThreadLocalMap.indexedVariable(this.index);
    if (localObject != InternalThreadLocalMap.UNSET) {
      return (V)localObject;
    }
    return (V)initialize(paramInternalThreadLocalMap);
  }
  
  public final V getIfExists()
  {
    Object localObject = InternalThreadLocalMap.getIfSet();
    if (localObject != null)
    {
      localObject = ((InternalThreadLocalMap)localObject).indexedVariable(this.index);
      if (localObject != InternalThreadLocalMap.UNSET) {
        return (V)localObject;
      }
    }
    return null;
  }
  
  protected V initialValue()
    throws Exception
  {
    return null;
  }
  
  public final boolean isSet()
  {
    return isSet(InternalThreadLocalMap.getIfSet());
  }
  
  public final boolean isSet(InternalThreadLocalMap paramInternalThreadLocalMap)
  {
    boolean bool;
    if ((paramInternalThreadLocalMap != null) && (paramInternalThreadLocalMap.isIndexedVariableSet(this.index))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  protected void onRemoval(V paramV)
    throws Exception
  {}
  
  public final void remove()
  {
    remove(InternalThreadLocalMap.getIfSet());
  }
  
  public final void remove(InternalThreadLocalMap paramInternalThreadLocalMap)
  {
    if (paramInternalThreadLocalMap == null) {
      return;
    }
    Object localObject = paramInternalThreadLocalMap.removeIndexedVariable(this.index);
    removeFromVariablesToRemove(paramInternalThreadLocalMap, this);
    if (localObject != InternalThreadLocalMap.UNSET) {
      try
      {
        onRemoval(localObject);
      }
      catch (Exception paramInternalThreadLocalMap)
      {
        PlatformDependent.throwException(paramInternalThreadLocalMap);
      }
    }
  }
  
  public final void set(InternalThreadLocalMap paramInternalThreadLocalMap, V paramV)
  {
    if (paramV != InternalThreadLocalMap.UNSET) {
      setKnownNotUnset(paramInternalThreadLocalMap, paramV);
    } else {
      remove(paramInternalThreadLocalMap);
    }
  }
  
  public final void set(V paramV)
  {
    if (paramV != InternalThreadLocalMap.UNSET) {
      setKnownNotUnset(InternalThreadLocalMap.get(), paramV);
    } else {
      remove();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\concurrent\FastThreadLocal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */