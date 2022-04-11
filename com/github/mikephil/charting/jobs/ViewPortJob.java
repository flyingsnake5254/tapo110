package com.github.mikephil.charting.jobs;

import android.view.View;
import com.github.mikephil.charting.utils.ObjectPool.Poolable;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.ViewPortHandler;

public abstract class ViewPortJob
  extends ObjectPool.Poolable
  implements Runnable
{
  protected Transformer mTrans;
  protected ViewPortHandler mViewPortHandler;
  protected float[] pts = new float[2];
  protected View view;
  protected float xValue = 0.0F;
  protected float yValue = 0.0F;
  
  public ViewPortJob(ViewPortHandler paramViewPortHandler, float paramFloat1, float paramFloat2, Transformer paramTransformer, View paramView)
  {
    this.mViewPortHandler = paramViewPortHandler;
    this.xValue = paramFloat1;
    this.yValue = paramFloat2;
    this.mTrans = paramTransformer;
    this.view = paramView;
  }
  
  public float getXValue()
  {
    return this.xValue;
  }
  
  public float getYValue()
  {
    return this.yValue;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\jobs\ViewPortJob.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */