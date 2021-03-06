package com.github.mikephil.charting.data;

import com.github.mikephil.charting.charts.ScatterChart.ScatterShape;
import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet;
import com.github.mikephil.charting.renderer.scatter.ChevronDownShapeRenderer;
import com.github.mikephil.charting.renderer.scatter.ChevronUpShapeRenderer;
import com.github.mikephil.charting.renderer.scatter.CircleShapeRenderer;
import com.github.mikephil.charting.renderer.scatter.CrossShapeRenderer;
import com.github.mikephil.charting.renderer.scatter.IShapeRenderer;
import com.github.mikephil.charting.renderer.scatter.SquareShapeRenderer;
import com.github.mikephil.charting.renderer.scatter.TriangleShapeRenderer;
import com.github.mikephil.charting.renderer.scatter.XShapeRenderer;
import java.util.ArrayList;
import java.util.List;

public class ScatterDataSet
  extends LineScatterCandleRadarDataSet<Entry>
  implements IScatterDataSet
{
  private int mScatterShapeHoleColor = 1122867;
  private float mScatterShapeHoleRadius = 0.0F;
  protected IShapeRenderer mShapeRenderer = new SquareShapeRenderer();
  private float mShapeSize = 15.0F;
  
  public ScatterDataSet(List<Entry> paramList, String paramString)
  {
    super(paramList, paramString);
  }
  
  public static IShapeRenderer getRendererForShape(ScatterChart.ScatterShape paramScatterShape)
  {
    switch (1.$SwitchMap$com$github$mikephil$charting$charts$ScatterChart$ScatterShape[paramScatterShape.ordinal()])
    {
    default: 
      return null;
    case 7: 
      return new ChevronDownShapeRenderer();
    case 6: 
      return new ChevronUpShapeRenderer();
    case 5: 
      return new XShapeRenderer();
    case 4: 
      return new CrossShapeRenderer();
    case 3: 
      return new TriangleShapeRenderer();
    case 2: 
      return new CircleShapeRenderer();
    }
    return new SquareShapeRenderer();
  }
  
  public DataSet<Entry> copy()
  {
    Object localObject = new ArrayList();
    for (int i = 0; i < this.mValues.size(); i++) {
      ((List)localObject).add(((Entry)this.mValues.get(i)).copy());
    }
    localObject = new ScatterDataSet((List)localObject, getLabel());
    copy((ScatterDataSet)localObject);
    return (DataSet<Entry>)localObject;
  }
  
  protected void copy(ScatterDataSet paramScatterDataSet)
  {
    super.copy(paramScatterDataSet);
    paramScatterDataSet.mShapeSize = this.mShapeSize;
    paramScatterDataSet.mShapeRenderer = this.mShapeRenderer;
    paramScatterDataSet.mScatterShapeHoleRadius = this.mScatterShapeHoleRadius;
    paramScatterDataSet.mScatterShapeHoleColor = this.mScatterShapeHoleColor;
  }
  
  public int getScatterShapeHoleColor()
  {
    return this.mScatterShapeHoleColor;
  }
  
  public float getScatterShapeHoleRadius()
  {
    return this.mScatterShapeHoleRadius;
  }
  
  public float getScatterShapeSize()
  {
    return this.mShapeSize;
  }
  
  public IShapeRenderer getShapeRenderer()
  {
    return this.mShapeRenderer;
  }
  
  public void setScatterShape(ScatterChart.ScatterShape paramScatterShape)
  {
    this.mShapeRenderer = getRendererForShape(paramScatterShape);
  }
  
  public void setScatterShapeHoleColor(int paramInt)
  {
    this.mScatterShapeHoleColor = paramInt;
  }
  
  public void setScatterShapeHoleRadius(float paramFloat)
  {
    this.mScatterShapeHoleRadius = paramFloat;
  }
  
  public void setScatterShapeSize(float paramFloat)
  {
    this.mShapeSize = paramFloat;
  }
  
  public void setShapeRenderer(IShapeRenderer paramIShapeRenderer)
  {
    this.mShapeRenderer = paramIShapeRenderer;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\data\ScatterDataSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */