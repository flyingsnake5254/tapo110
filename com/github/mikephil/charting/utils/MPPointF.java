package com.github.mikephil.charting.utils;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.List;

public class MPPointF
  extends ObjectPool.Poolable
{
  public static final Parcelable.Creator<MPPointF> CREATOR = new Parcelable.Creator()
  {
    public MPPointF createFromParcel(Parcel paramAnonymousParcel)
    {
      MPPointF localMPPointF = new MPPointF(0.0F, 0.0F);
      localMPPointF.my_readFromParcel(paramAnonymousParcel);
      return localMPPointF;
    }
    
    public MPPointF[] newArray(int paramAnonymousInt)
    {
      return new MPPointF[paramAnonymousInt];
    }
  };
  private static ObjectPool<MPPointF> pool;
  public float x;
  public float y;
  
  static
  {
    ObjectPool localObjectPool = ObjectPool.create(32, new MPPointF(0.0F, 0.0F));
    pool = localObjectPool;
    localObjectPool.setReplenishPercentage(0.5F);
  }
  
  public MPPointF() {}
  
  public MPPointF(float paramFloat1, float paramFloat2)
  {
    this.x = paramFloat1;
    this.y = paramFloat2;
  }
  
  public static MPPointF getInstance()
  {
    return (MPPointF)pool.get();
  }
  
  public static MPPointF getInstance(float paramFloat1, float paramFloat2)
  {
    MPPointF localMPPointF = (MPPointF)pool.get();
    localMPPointF.x = paramFloat1;
    localMPPointF.y = paramFloat2;
    return localMPPointF;
  }
  
  public static MPPointF getInstance(MPPointF paramMPPointF)
  {
    MPPointF localMPPointF = (MPPointF)pool.get();
    localMPPointF.x = paramMPPointF.x;
    localMPPointF.y = paramMPPointF.y;
    return localMPPointF;
  }
  
  public static void recycleInstance(MPPointF paramMPPointF)
  {
    pool.recycle(paramMPPointF);
  }
  
  public static void recycleInstances(List<MPPointF> paramList)
  {
    pool.recycle(paramList);
  }
  
  public float getX()
  {
    return this.x;
  }
  
  public float getY()
  {
    return this.y;
  }
  
  protected ObjectPool.Poolable instantiate()
  {
    return new MPPointF(0.0F, 0.0F);
  }
  
  public void my_readFromParcel(Parcel paramParcel)
  {
    this.x = paramParcel.readFloat();
    this.y = paramParcel.readFloat();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\utils\MPPointF.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */