package com.github.mikephil.charting.data;

import com.github.mikephil.charting.interfaces.datasets.IBubbleDataSet;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.List;

public class BubbleDataSet
  extends BarLineScatterCandleBubbleDataSet<BubbleEntry>
  implements IBubbleDataSet
{
  private float mHighlightCircleWidth = 2.5F;
  protected float mMaxSize;
  protected boolean mNormalizeSize = true;
  
  public BubbleDataSet(List<BubbleEntry> paramList, String paramString)
  {
    super(paramList, paramString);
  }
  
  protected void calcMinMax(BubbleEntry paramBubbleEntry)
  {
    super.calcMinMax(paramBubbleEntry);
    float f = paramBubbleEntry.getSize();
    if (f > this.mMaxSize) {
      this.mMaxSize = f;
    }
  }
  
  public DataSet<BubbleEntry> copy()
  {
    Object localObject = new ArrayList();
    for (int i = 0; i < this.mValues.size(); i++) {
      ((List)localObject).add(((BubbleEntry)this.mValues.get(i)).copy());
    }
    localObject = new BubbleDataSet((List)localObject, getLabel());
    copy((BubbleDataSet)localObject);
    return (DataSet<BubbleEntry>)localObject;
  }
  
  protected void copy(BubbleDataSet paramBubbleDataSet)
  {
    paramBubbleDataSet.mHighlightCircleWidth = this.mHighlightCircleWidth;
    paramBubbleDataSet.mNormalizeSize = this.mNormalizeSize;
  }
  
  public float getHighlightCircleWidth()
  {
    return this.mHighlightCircleWidth;
  }
  
  public float getMaxSize()
  {
    return this.mMaxSize;
  }
  
  public boolean isNormalizeSizeEnabled()
  {
    return this.mNormalizeSize;
  }
  
  public void setHighlightCircleWidth(float paramFloat)
  {
    this.mHighlightCircleWidth = Utils.convertDpToPixel(paramFloat);
  }
  
  public void setNormalizeSizeEnabled(boolean paramBoolean)
  {
    this.mNormalizeSize = paramBoolean;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\data\BubbleDataSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */