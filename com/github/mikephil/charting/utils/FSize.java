package com.github.mikephil.charting.utils;

import java.util.List;

public final class FSize
  extends ObjectPool.Poolable
{
  private static ObjectPool<FSize> pool;
  public float height;
  public float width;
  
  static
  {
    ObjectPool localObjectPool = ObjectPool.create(256, new FSize(0.0F, 0.0F));
    pool = localObjectPool;
    localObjectPool.setReplenishPercentage(0.5F);
  }
  
  public FSize() {}
  
  public FSize(float paramFloat1, float paramFloat2)
  {
    this.width = paramFloat1;
    this.height = paramFloat2;
  }
  
  public static FSize getInstance(float paramFloat1, float paramFloat2)
  {
    FSize localFSize = (FSize)pool.get();
    localFSize.width = paramFloat1;
    localFSize.height = paramFloat2;
    return localFSize;
  }
  
  public static void recycleInstance(FSize paramFSize)
  {
    pool.recycle(paramFSize);
  }
  
  public static void recycleInstances(List<FSize> paramList)
  {
    pool.recycle(paramList);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = false;
    if (paramObject == null) {
      return false;
    }
    if (this == paramObject) {
      return true;
    }
    boolean bool2 = bool1;
    if ((paramObject instanceof FSize))
    {
      paramObject = (FSize)paramObject;
      bool2 = bool1;
      if (this.width == ((FSize)paramObject).width)
      {
        bool2 = bool1;
        if (this.height == ((FSize)paramObject).height) {
          bool2 = true;
        }
      }
    }
    return bool2;
  }
  
  public int hashCode()
  {
    return Float.floatToIntBits(this.width) ^ Float.floatToIntBits(this.height);
  }
  
  protected ObjectPool.Poolable instantiate()
  {
    return new FSize(0.0F, 0.0F);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.width);
    localStringBuilder.append("x");
    localStringBuilder.append(this.height);
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\utils\FSize.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */