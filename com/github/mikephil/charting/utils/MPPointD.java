package com.github.mikephil.charting.utils;

import java.util.List;

public class MPPointD
  extends ObjectPool.Poolable
{
  private static ObjectPool<MPPointD> pool;
  public double x;
  public double y;
  
  static
  {
    ObjectPool localObjectPool = ObjectPool.create(64, new MPPointD(0.0D, 0.0D));
    pool = localObjectPool;
    localObjectPool.setReplenishPercentage(0.5F);
  }
  
  private MPPointD(double paramDouble1, double paramDouble2)
  {
    this.x = paramDouble1;
    this.y = paramDouble2;
  }
  
  public static MPPointD getInstance(double paramDouble1, double paramDouble2)
  {
    MPPointD localMPPointD = (MPPointD)pool.get();
    localMPPointD.x = paramDouble1;
    localMPPointD.y = paramDouble2;
    return localMPPointD;
  }
  
  public static void recycleInstance(MPPointD paramMPPointD)
  {
    pool.recycle(paramMPPointD);
  }
  
  public static void recycleInstances(List<MPPointD> paramList)
  {
    pool.recycle(paramList);
  }
  
  protected ObjectPool.Poolable instantiate()
  {
    return new MPPointD(0.0D, 0.0D);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MPPointD, x: ");
    localStringBuilder.append(this.x);
    localStringBuilder.append(", y: ");
    localStringBuilder.append(this.y);
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\utils\MPPointD.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */