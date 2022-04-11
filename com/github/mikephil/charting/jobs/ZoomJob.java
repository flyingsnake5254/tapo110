package com.github.mikephil.charting.jobs;

import android.graphics.Matrix;
import android.view.View;
import com.github.mikephil.charting.charts.BarLineChartBase;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.YAxis.AxisDependency;
import com.github.mikephil.charting.utils.ObjectPool;
import com.github.mikephil.charting.utils.ObjectPool.Poolable;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.ViewPortHandler;

public class ZoomJob
  extends ViewPortJob
{
  private static ObjectPool<ZoomJob> pool;
  protected YAxis.AxisDependency axisDependency;
  protected Matrix mRunMatrixBuffer = new Matrix();
  protected float scaleX;
  protected float scaleY;
  
  static
  {
    ObjectPool localObjectPool = ObjectPool.create(1, new ZoomJob(null, 0.0F, 0.0F, 0.0F, 0.0F, null, null, null));
    pool = localObjectPool;
    localObjectPool.setReplenishPercentage(0.5F);
  }
  
  public ZoomJob(ViewPortHandler paramViewPortHandler, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, Transformer paramTransformer, YAxis.AxisDependency paramAxisDependency, View paramView)
  {
    super(paramViewPortHandler, paramFloat3, paramFloat4, paramTransformer, paramView);
    this.scaleX = paramFloat1;
    this.scaleY = paramFloat2;
    this.axisDependency = paramAxisDependency;
  }
  
  public static ZoomJob getInstance(ViewPortHandler paramViewPortHandler, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, Transformer paramTransformer, YAxis.AxisDependency paramAxisDependency, View paramView)
  {
    ZoomJob localZoomJob = (ZoomJob)pool.get();
    localZoomJob.xValue = paramFloat3;
    localZoomJob.yValue = paramFloat4;
    localZoomJob.scaleX = paramFloat1;
    localZoomJob.scaleY = paramFloat2;
    localZoomJob.mViewPortHandler = paramViewPortHandler;
    localZoomJob.mTrans = paramTransformer;
    localZoomJob.axisDependency = paramAxisDependency;
    localZoomJob.view = paramView;
    return localZoomJob;
  }
  
  public static void recycleInstance(ZoomJob paramZoomJob)
  {
    pool.recycle(paramZoomJob);
  }
  
  protected ObjectPool.Poolable instantiate()
  {
    return new ZoomJob(null, 0.0F, 0.0F, 0.0F, 0.0F, null, null, null);
  }
  
  public void run()
  {
    Matrix localMatrix = this.mRunMatrixBuffer;
    this.mViewPortHandler.zoom(this.scaleX, this.scaleY, localMatrix);
    this.mViewPortHandler.refresh(localMatrix, this.view, false);
    float f1 = ((BarLineChartBase)this.view).getAxis(this.axisDependency).mAxisRange / this.mViewPortHandler.getScaleY();
    float f2 = ((BarLineChartBase)this.view).getXAxis().mAxisRange / this.mViewPortHandler.getScaleX();
    float[] arrayOfFloat = this.pts;
    arrayOfFloat[0] = (this.xValue - f2 / 2.0F);
    arrayOfFloat[1] = (this.yValue + f1 / 2.0F);
    this.mTrans.pointValuesToPixel(arrayOfFloat);
    this.mViewPortHandler.translate(this.pts, localMatrix);
    this.mViewPortHandler.refresh(localMatrix, this.view, false);
    ((BarLineChartBase)this.view).calculateOffsets();
    this.view.postInvalidate();
    recycleInstance(this);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\jobs\ZoomJob.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */