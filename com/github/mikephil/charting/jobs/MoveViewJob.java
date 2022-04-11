package com.github.mikephil.charting.jobs;

import android.view.View;
import com.github.mikephil.charting.utils.ObjectPool;
import com.github.mikephil.charting.utils.ObjectPool.Poolable;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.ViewPortHandler;

public class MoveViewJob
  extends ViewPortJob
{
  private static ObjectPool<MoveViewJob> pool;
  
  static
  {
    ObjectPool localObjectPool = ObjectPool.create(2, new MoveViewJob(null, 0.0F, 0.0F, null, null));
    pool = localObjectPool;
    localObjectPool.setReplenishPercentage(0.5F);
  }
  
  public MoveViewJob(ViewPortHandler paramViewPortHandler, float paramFloat1, float paramFloat2, Transformer paramTransformer, View paramView)
  {
    super(paramViewPortHandler, paramFloat1, paramFloat2, paramTransformer, paramView);
  }
  
  public static MoveViewJob getInstance(ViewPortHandler paramViewPortHandler, float paramFloat1, float paramFloat2, Transformer paramTransformer, View paramView)
  {
    MoveViewJob localMoveViewJob = (MoveViewJob)pool.get();
    localMoveViewJob.mViewPortHandler = paramViewPortHandler;
    localMoveViewJob.xValue = paramFloat1;
    localMoveViewJob.yValue = paramFloat2;
    localMoveViewJob.mTrans = paramTransformer;
    localMoveViewJob.view = paramView;
    return localMoveViewJob;
  }
  
  public static void recycleInstance(MoveViewJob paramMoveViewJob)
  {
    pool.recycle(paramMoveViewJob);
  }
  
  protected ObjectPool.Poolable instantiate()
  {
    return new MoveViewJob(this.mViewPortHandler, this.xValue, this.yValue, this.mTrans, this.view);
  }
  
  public void run()
  {
    float[] arrayOfFloat = this.pts;
    arrayOfFloat[0] = this.xValue;
    arrayOfFloat[1] = this.yValue;
    this.mTrans.pointValuesToPixel(arrayOfFloat);
    this.mViewPortHandler.centerViewPort(this.pts, this.view);
    recycleInstance(this);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\jobs\MoveViewJob.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */