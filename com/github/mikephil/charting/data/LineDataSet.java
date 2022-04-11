package com.github.mikephil.charting.data;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.util.Log;
import com.github.mikephil.charting.formatter.DefaultFillFormatter;
import com.github.mikephil.charting.formatter.IFillFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.List;

public class LineDataSet
  extends LineRadarDataSet<Entry>
  implements ILineDataSet
{
  private List<Integer> mCircleColors = null;
  private int mCircleHoleColor = -1;
  private float mCircleHoleRadius = 4.0F;
  private float mCircleRadius = 8.0F;
  private float mCubicIntensity = 0.2F;
  private DashPathEffect mDashPathEffect = null;
  private boolean mDrawCircleHole = true;
  private boolean mDrawCircles = true;
  private IFillFormatter mFillFormatter = new DefaultFillFormatter();
  private Mode mMode = Mode.LINEAR;
  
  public LineDataSet(List<Entry> paramList, String paramString)
  {
    super(paramList, paramString);
    if (this.mCircleColors == null) {
      this.mCircleColors = new ArrayList();
    }
    this.mCircleColors.clear();
    this.mCircleColors.add(Integer.valueOf(Color.rgb(140, 234, 255)));
  }
  
  public DataSet<Entry> copy()
  {
    Object localObject = new ArrayList();
    for (int i = 0; i < this.mValues.size(); i++) {
      ((List)localObject).add(((Entry)this.mValues.get(i)).copy());
    }
    localObject = new LineDataSet((List)localObject, getLabel());
    copy((LineDataSet)localObject);
    return (DataSet<Entry>)localObject;
  }
  
  protected void copy(LineDataSet paramLineDataSet)
  {
    super.copy(paramLineDataSet);
    paramLineDataSet.mCircleColors = this.mCircleColors;
    paramLineDataSet.mCircleHoleColor = this.mCircleHoleColor;
    paramLineDataSet.mCircleHoleRadius = this.mCircleHoleRadius;
    paramLineDataSet.mCircleRadius = this.mCircleRadius;
    paramLineDataSet.mCubicIntensity = this.mCubicIntensity;
    paramLineDataSet.mDashPathEffect = this.mDashPathEffect;
    paramLineDataSet.mDrawCircleHole = this.mDrawCircleHole;
    paramLineDataSet.mDrawCircles = this.mDrawCircleHole;
    paramLineDataSet.mFillFormatter = this.mFillFormatter;
    paramLineDataSet.mMode = this.mMode;
  }
  
  public void disableDashedLine()
  {
    this.mDashPathEffect = null;
  }
  
  public void enableDashedLine(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.mDashPathEffect = new DashPathEffect(new float[] { paramFloat1, paramFloat2 }, paramFloat3);
  }
  
  public int getCircleColor(int paramInt)
  {
    return ((Integer)this.mCircleColors.get(paramInt)).intValue();
  }
  
  public int getCircleColorCount()
  {
    return this.mCircleColors.size();
  }
  
  public List<Integer> getCircleColors()
  {
    return this.mCircleColors;
  }
  
  public int getCircleHoleColor()
  {
    return this.mCircleHoleColor;
  }
  
  public float getCircleHoleRadius()
  {
    return this.mCircleHoleRadius;
  }
  
  public float getCircleRadius()
  {
    return this.mCircleRadius;
  }
  
  @Deprecated
  public float getCircleSize()
  {
    return getCircleRadius();
  }
  
  public float getCubicIntensity()
  {
    return this.mCubicIntensity;
  }
  
  public DashPathEffect getDashPathEffect()
  {
    return this.mDashPathEffect;
  }
  
  public IFillFormatter getFillFormatter()
  {
    return this.mFillFormatter;
  }
  
  public Mode getMode()
  {
    return this.mMode;
  }
  
  public boolean isDashedLineEnabled()
  {
    boolean bool;
    if (this.mDashPathEffect == null) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public boolean isDrawCircleHoleEnabled()
  {
    return this.mDrawCircleHole;
  }
  
  public boolean isDrawCirclesEnabled()
  {
    return this.mDrawCircles;
  }
  
  @Deprecated
  public boolean isDrawCubicEnabled()
  {
    boolean bool;
    if (this.mMode == Mode.CUBIC_BEZIER) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  @Deprecated
  public boolean isDrawSteppedEnabled()
  {
    boolean bool;
    if (this.mMode == Mode.STEPPED) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void resetCircleColors()
  {
    if (this.mCircleColors == null) {
      this.mCircleColors = new ArrayList();
    }
    this.mCircleColors.clear();
  }
  
  public void setCircleColor(int paramInt)
  {
    resetCircleColors();
    this.mCircleColors.add(Integer.valueOf(paramInt));
  }
  
  public void setCircleColors(List<Integer> paramList)
  {
    this.mCircleColors = paramList;
  }
  
  public void setCircleColors(int... paramVarArgs)
  {
    this.mCircleColors = ColorTemplate.createColors(paramVarArgs);
  }
  
  public void setCircleColors(int[] paramArrayOfInt, Context paramContext)
  {
    List localList = this.mCircleColors;
    Object localObject = localList;
    if (localList == null) {
      localObject = new ArrayList();
    }
    ((List)localObject).clear();
    int i = paramArrayOfInt.length;
    for (int j = 0; j < i; j++)
    {
      int k = paramArrayOfInt[j];
      ((List)localObject).add(Integer.valueOf(paramContext.getResources().getColor(k)));
    }
    this.mCircleColors = ((List)localObject);
  }
  
  public void setCircleHoleColor(int paramInt)
  {
    this.mCircleHoleColor = paramInt;
  }
  
  public void setCircleHoleRadius(float paramFloat)
  {
    if (paramFloat >= 0.5F) {
      this.mCircleHoleRadius = Utils.convertDpToPixel(paramFloat);
    } else {
      Log.e("LineDataSet", "Circle radius cannot be < 0.5");
    }
  }
  
  public void setCircleRadius(float paramFloat)
  {
    if (paramFloat >= 1.0F) {
      this.mCircleRadius = Utils.convertDpToPixel(paramFloat);
    } else {
      Log.e("LineDataSet", "Circle radius cannot be < 1");
    }
  }
  
  @Deprecated
  public void setCircleSize(float paramFloat)
  {
    setCircleRadius(paramFloat);
  }
  
  public void setCubicIntensity(float paramFloat)
  {
    float f = paramFloat;
    if (paramFloat > 1.0F) {
      f = 1.0F;
    }
    paramFloat = f;
    if (f < 0.05F) {
      paramFloat = 0.05F;
    }
    this.mCubicIntensity = paramFloat;
  }
  
  public void setDrawCircleHole(boolean paramBoolean)
  {
    this.mDrawCircleHole = paramBoolean;
  }
  
  public void setDrawCircles(boolean paramBoolean)
  {
    this.mDrawCircles = paramBoolean;
  }
  
  public void setFillFormatter(IFillFormatter paramIFillFormatter)
  {
    if (paramIFillFormatter == null) {
      this.mFillFormatter = new DefaultFillFormatter();
    } else {
      this.mFillFormatter = paramIFillFormatter;
    }
  }
  
  public void setMode(Mode paramMode)
  {
    this.mMode = paramMode;
  }
  
  public static enum Mode
  {
    static
    {
      Mode localMode1 = new Mode("LINEAR", 0);
      LINEAR = localMode1;
      Mode localMode2 = new Mode("STEPPED", 1);
      STEPPED = localMode2;
      Mode localMode3 = new Mode("CUBIC_BEZIER", 2);
      CUBIC_BEZIER = localMode3;
      Mode localMode4 = new Mode("HORIZONTAL_BEZIER", 3);
      HORIZONTAL_BEZIER = localMode4;
      $VALUES = new Mode[] { localMode1, localMode2, localMode3, localMode4 };
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\data\LineDataSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */