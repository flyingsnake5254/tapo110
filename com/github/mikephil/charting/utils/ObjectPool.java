package com.github.mikephil.charting.utils;

import java.util.List;

public class ObjectPool<T extends Poolable>
{
  private static int ids;
  private int desiredCapacity;
  private T modelObject;
  private Object[] objects;
  private int objectsPointer;
  private int poolId;
  private float replenishPercentage;
  
  private ObjectPool(int paramInt, T paramT)
  {
    if (paramInt > 0)
    {
      this.desiredCapacity = paramInt;
      this.objects = new Object[paramInt];
      this.objectsPointer = 0;
      this.modelObject = paramT;
      this.replenishPercentage = 1.0F;
      refillPool();
      return;
    }
    throw new IllegalArgumentException("Object Pool must be instantiated with a capacity greater than 0!");
  }
  
  public static ObjectPool create(int paramInt, Poolable paramPoolable)
  {
    try
    {
      ObjectPool localObjectPool = new com/github/mikephil/charting/utils/ObjectPool;
      localObjectPool.<init>(paramInt, paramPoolable);
      paramInt = ids;
      localObjectPool.poolId = paramInt;
      ids = paramInt + 1;
      return localObjectPool;
    }
    finally
    {
      paramPoolable = finally;
      throw paramPoolable;
    }
  }
  
  private void refillPool()
  {
    refillPool(this.replenishPercentage);
  }
  
  private void refillPool(float paramFloat)
  {
    int i = this.desiredCapacity;
    int j = (int)(i * paramFloat);
    if (j < 1) {
      j = 1;
    } else if (j > i) {
      j = i;
    }
    for (i = 0; i < j; i++) {
      this.objects[i] = this.modelObject.instantiate();
    }
    this.objectsPointer = (j - 1);
  }
  
  private void resizePool()
  {
    int i = this.desiredCapacity;
    int j = i * 2;
    this.desiredCapacity = j;
    Object[] arrayOfObject = new Object[j];
    for (j = 0; j < i; j++) {
      arrayOfObject[j] = this.objects[j];
    }
    this.objects = arrayOfObject;
  }
  
  public T get()
  {
    try
    {
      if ((this.objectsPointer == -1) && (this.replenishPercentage > 0.0F)) {
        refillPool();
      }
      Object localObject1 = this.objects;
      int i = this.objectsPointer;
      localObject1 = (Poolable)localObject1[i];
      ((Poolable)localObject1).currentOwnerId = Poolable.NO_OWNER;
      this.objectsPointer = (i - 1);
      return (T)localObject1;
    }
    finally {}
  }
  
  public int getPoolCapacity()
  {
    return this.objects.length;
  }
  
  public int getPoolCount()
  {
    return this.objectsPointer + 1;
  }
  
  public int getPoolId()
  {
    return this.poolId;
  }
  
  public float getReplenishPercentage()
  {
    return this.replenishPercentage;
  }
  
  public void recycle(T paramT)
  {
    try
    {
      int i = paramT.currentOwnerId;
      if (i != Poolable.NO_OWNER)
      {
        if (i == this.poolId)
        {
          paramT = new java/lang/IllegalArgumentException;
          paramT.<init>("The object passed is already stored in this pool!");
          throw paramT;
        }
        IllegalArgumentException localIllegalArgumentException = new java/lang/IllegalArgumentException;
        StringBuilder localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>();
        localStringBuilder.append("The object to recycle already belongs to poolId ");
        localStringBuilder.append(paramT.currentOwnerId);
        localStringBuilder.append(".  Object cannot belong to two different pool instances simultaneously!");
        localIllegalArgumentException.<init>(localStringBuilder.toString());
        throw localIllegalArgumentException;
      }
      i = this.objectsPointer + 1;
      this.objectsPointer = i;
      if (i >= this.objects.length) {
        resizePool();
      }
      paramT.currentOwnerId = this.poolId;
      this.objects[this.objectsPointer] = paramT;
      return;
    }
    finally {}
  }
  
  public void recycle(List<T> paramList)
  {
    try
    {
      while (paramList.size() + this.objectsPointer + 1 > this.desiredCapacity) {
        resizePool();
      }
      int i = paramList.size();
      for (int j = 0; j < i; j++)
      {
        Poolable localPoolable = (Poolable)paramList.get(j);
        int k = localPoolable.currentOwnerId;
        if (k != Poolable.NO_OWNER)
        {
          if (k == this.poolId)
          {
            paramList = new java/lang/IllegalArgumentException;
            paramList.<init>("The object passed is already stored in this pool!");
            throw paramList;
          }
          paramList = new java/lang/IllegalArgumentException;
          StringBuilder localStringBuilder = new java/lang/StringBuilder;
          localStringBuilder.<init>();
          localStringBuilder.append("The object to recycle already belongs to poolId ");
          localStringBuilder.append(localPoolable.currentOwnerId);
          localStringBuilder.append(".  Object cannot belong to two different pool instances simultaneously!");
          paramList.<init>(localStringBuilder.toString());
          throw paramList;
        }
        localPoolable.currentOwnerId = this.poolId;
        this.objects[(this.objectsPointer + 1 + j)] = localPoolable;
      }
      this.objectsPointer += i;
      return;
    }
    finally {}
  }
  
  public void setReplenishPercentage(float paramFloat)
  {
    float f;
    if (paramFloat > 1.0F)
    {
      f = 1.0F;
    }
    else
    {
      f = paramFloat;
      if (paramFloat < 0.0F) {
        f = 0.0F;
      }
    }
    this.replenishPercentage = f;
  }
  
  public static abstract class Poolable
  {
    public static int NO_OWNER = -1;
    int currentOwnerId = NO_OWNER;
    
    protected abstract Poolable instantiate();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\utils\ObjectPool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */