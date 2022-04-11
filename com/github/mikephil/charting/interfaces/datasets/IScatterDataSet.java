package com.github.mikephil.charting.interfaces.datasets;

import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.renderer.scatter.IShapeRenderer;

public abstract interface IScatterDataSet
  extends ILineScatterCandleRadarDataSet<Entry>
{
  public abstract int getScatterShapeHoleColor();
  
  public abstract float getScatterShapeHoleRadius();
  
  public abstract float getScatterShapeSize();
  
  public abstract IShapeRenderer getShapeRenderer();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\interfaces\datasets\IScatterDataSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */