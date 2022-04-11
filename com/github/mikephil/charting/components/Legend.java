package com.github.mikephil.charting.components;

import android.graphics.DashPathEffect;
import android.graphics.Paint;
import com.github.mikephil.charting.utils.FSize;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.ArrayList;
import java.util.List;

public class Legend
  extends ComponentBase
{
  private List<Boolean> mCalculatedLabelBreakPoints = new ArrayList(16);
  private List<FSize> mCalculatedLabelSizes = new ArrayList(16);
  private List<FSize> mCalculatedLineSizes = new ArrayList(16);
  private LegendDirection mDirection = LegendDirection.LEFT_TO_RIGHT;
  private boolean mDrawInside = false;
  private LegendEntry[] mEntries = new LegendEntry[0];
  private LegendEntry[] mExtraEntries;
  private DashPathEffect mFormLineDashEffect = null;
  private float mFormLineWidth = 3.0F;
  private float mFormSize = 8.0F;
  private float mFormToTextSpace = 5.0F;
  private LegendHorizontalAlignment mHorizontalAlignment = LegendHorizontalAlignment.LEFT;
  private boolean mIsLegendCustom = false;
  private float mMaxSizePercent = 0.95F;
  public float mNeededHeight = 0.0F;
  public float mNeededWidth = 0.0F;
  private LegendOrientation mOrientation = LegendOrientation.HORIZONTAL;
  private LegendForm mShape = LegendForm.SQUARE;
  private float mStackSpace = 3.0F;
  public float mTextHeightMax = 0.0F;
  public float mTextWidthMax = 0.0F;
  private LegendVerticalAlignment mVerticalAlignment = LegendVerticalAlignment.BOTTOM;
  private boolean mWordWrapEnabled = false;
  private float mXEntrySpace = 6.0F;
  private float mYEntrySpace = 0.0F;
  
  public Legend()
  {
    this.mTextSize = Utils.convertDpToPixel(10.0F);
    this.mXOffset = Utils.convertDpToPixel(5.0F);
    this.mYOffset = Utils.convertDpToPixel(3.0F);
  }
  
  public Legend(LegendEntry[] paramArrayOfLegendEntry)
  {
    this();
    if (paramArrayOfLegendEntry != null)
    {
      this.mEntries = paramArrayOfLegendEntry;
      return;
    }
    throw new IllegalArgumentException("entries array is NULL");
  }
  
  public void calculateDimensions(Paint paramPaint, ViewPortHandler paramViewPortHandler)
  {
    float f1 = Utils.convertDpToPixel(this.mFormSize);
    float f2 = Utils.convertDpToPixel(this.mStackSpace);
    float f3 = Utils.convertDpToPixel(this.mFormToTextSpace);
    float f4 = Utils.convertDpToPixel(this.mXEntrySpace);
    float f5 = Utils.convertDpToPixel(this.mYEntrySpace);
    boolean bool = this.mWordWrapEnabled;
    Object localObject = this.mEntries;
    int i = localObject.length;
    this.mTextWidthMax = getMaximumEntryWidth(paramPaint);
    this.mTextHeightMax = getMaximumEntryHeight(paramPaint);
    int j = 1.$SwitchMap$com$github$mikephil$charting$components$Legend$LegendOrientation[this.mOrientation.ordinal()];
    float f6;
    float f9;
    float f10;
    float f11;
    float f12;
    int i1;
    float f13;
    if (j != 1)
    {
      if (j == 2)
      {
        f6 = Utils.getLineHeight(paramPaint);
        f5 = Utils.getLineSpacing(paramPaint) + f5;
        float f7 = paramViewPortHandler.contentWidth();
        float f8 = this.mMaxSizePercent;
        this.mCalculatedLabelBreakPoints.clear();
        this.mCalculatedLabelSizes.clear();
        this.mCalculatedLineSizes.clear();
        j = 0;
        f9 = 0.0F;
        int k = -1;
        f10 = 0.0F;
        f11 = 0.0F;
        paramViewPortHandler = (ViewPortHandler)localObject;
        f12 = f1;
        while (j < i)
        {
          localObject = paramViewPortHandler[j];
          if (((LegendEntry)localObject).form != LegendForm.NONE) {
            i1 = 1;
          } else {
            i1 = 0;
          }
          if (Float.isNaN(((LegendEntry)localObject).formSize)) {
            f13 = f12;
          } else {
            f13 = Utils.convertDpToPixel(((LegendEntry)localObject).formSize);
          }
          localObject = ((LegendEntry)localObject).label;
          this.mCalculatedLabelBreakPoints.add(Boolean.FALSE);
          if (k == -1) {
            f10 = 0.0F;
          } else {
            f10 += f2;
          }
          if (localObject != null)
          {
            this.mCalculatedLabelSizes.add(Utils.calcTextSize(paramPaint, (String)localObject));
            if (i1 != 0) {
              f13 = f3 + f13;
            } else {
              f13 = 0.0F;
            }
            f13 = f10 + f13 + ((FSize)this.mCalculatedLabelSizes.get(j)).width;
            i1 = k;
          }
          else
          {
            this.mCalculatedLabelSizes.add(FSize.getInstance(0.0F, 0.0F));
            if (i1 == 0) {
              f13 = 0.0F;
            }
            f10 += f13;
            f13 = f10;
            i1 = k;
            if (k == -1)
            {
              i1 = j;
              f13 = f10;
            }
          }
          if ((localObject == null) && (j != i - 1))
          {
            f1 = f11;
          }
          else
          {
            m = f11 < 0.0F;
            if (m == 0) {
              f10 = 0.0F;
            } else {
              f10 = f4;
            }
            if ((bool) && (m != 0) && (f7 * f8 - f11 < f10 + f13))
            {
              this.mCalculatedLineSizes.add(FSize.getInstance(f11, f6));
              f10 = Math.max(f9, f11);
              List localList = this.mCalculatedLabelBreakPoints;
              if (i1 > -1) {
                m = i1;
              } else {
                m = j;
              }
              localList.set(m, Boolean.TRUE);
              f9 = f13;
            }
            else
            {
              f11 += f10 + f13;
              f10 = f9;
              f9 = f11;
            }
            f11 = f10;
            if (j == i - 1)
            {
              this.mCalculatedLineSizes.add(FSize.getInstance(f9, f6));
              f11 = Math.max(f10, f9);
            }
            f1 = f9;
            f9 = f11;
          }
          if (localObject != null) {
            i1 = -1;
          }
          j++;
          int m = i1;
          f10 = f13;
          f11 = f1;
        }
        this.mNeededWidth = f9;
        f13 = this.mCalculatedLineSizes.size();
        if (this.mCalculatedLineSizes.size() == 0) {
          j = 0;
        } else {
          j = this.mCalculatedLineSizes.size() - 1;
        }
        this.mNeededHeight = (f6 * f13 + f5 * j);
      }
    }
    else
    {
      f6 = Utils.getLineHeight(paramPaint);
      f13 = 0.0F;
      f12 = 0.0F;
      f4 = 0.0F;
      int n = 0;
      j = 0;
      while (n < i)
      {
        paramViewPortHandler = localObject[n];
        if (paramViewPortHandler.form != LegendForm.NONE) {
          i1 = 1;
        } else {
          i1 = 0;
        }
        if (Float.isNaN(paramViewPortHandler.formSize)) {
          f9 = f1;
        } else {
          f9 = Utils.convertDpToPixel(paramViewPortHandler.formSize);
        }
        paramViewPortHandler = paramViewPortHandler.label;
        if (j == 0) {
          f4 = 0.0F;
        }
        f11 = f4;
        if (i1 != 0)
        {
          f11 = f4;
          if (j != 0) {
            f11 = f4 + f2;
          }
          f11 += f9;
        }
        if (paramViewPortHandler != null)
        {
          if ((i1 != 0) && (j == 0))
          {
            f10 = f11 + f3;
            f4 = f13;
            f9 = f12;
            i1 = j;
          }
          else
          {
            f4 = f13;
            f9 = f12;
            f10 = f11;
            i1 = j;
            if (j != 0)
            {
              f4 = Math.max(f13, f11);
              f9 = f12 + (f6 + f5);
              f10 = 0.0F;
              i1 = 0;
            }
          }
          f10 += Utils.calcTextWidth(paramPaint, paramViewPortHandler);
          f13 = f4;
          f12 = f9;
          f11 = f10;
          j = i1;
          if (n < i - 1)
          {
            f12 = f9 + (f6 + f5);
            f13 = f4;
            f11 = f10;
            j = i1;
          }
        }
        else
        {
          f4 = f11 + f9;
          f11 = f4;
          if (n < i - 1) {
            f11 = f4 + f2;
          }
          j = 1;
        }
        f13 = Math.max(f13, f11);
        n++;
        f4 = f11;
      }
      this.mNeededWidth = f13;
      this.mNeededHeight = f12;
    }
    this.mNeededHeight += this.mYOffset;
    this.mNeededWidth += this.mXOffset;
  }
  
  public List<Boolean> getCalculatedLabelBreakPoints()
  {
    return this.mCalculatedLabelBreakPoints;
  }
  
  public List<FSize> getCalculatedLabelSizes()
  {
    return this.mCalculatedLabelSizes;
  }
  
  public List<FSize> getCalculatedLineSizes()
  {
    return this.mCalculatedLineSizes;
  }
  
  public LegendDirection getDirection()
  {
    return this.mDirection;
  }
  
  public LegendEntry[] getEntries()
  {
    return this.mEntries;
  }
  
  public LegendEntry[] getExtraEntries()
  {
    return this.mExtraEntries;
  }
  
  public LegendForm getForm()
  {
    return this.mShape;
  }
  
  public DashPathEffect getFormLineDashEffect()
  {
    return this.mFormLineDashEffect;
  }
  
  public float getFormLineWidth()
  {
    return this.mFormLineWidth;
  }
  
  public float getFormSize()
  {
    return this.mFormSize;
  }
  
  public float getFormToTextSpace()
  {
    return this.mFormToTextSpace;
  }
  
  public LegendHorizontalAlignment getHorizontalAlignment()
  {
    return this.mHorizontalAlignment;
  }
  
  public float getMaxSizePercent()
  {
    return this.mMaxSizePercent;
  }
  
  public float getMaximumEntryHeight(Paint paramPaint)
  {
    LegendEntry[] arrayOfLegendEntry = this.mEntries;
    int i = arrayOfLegendEntry.length;
    float f1 = 0.0F;
    int j = 0;
    while (j < i)
    {
      String str = arrayOfLegendEntry[j].label;
      float f2;
      if (str == null)
      {
        f2 = f1;
      }
      else
      {
        float f3 = Utils.calcTextHeight(paramPaint, str);
        f2 = f1;
        if (f3 > f1) {
          f2 = f3;
        }
      }
      j++;
      f1 = f2;
    }
    return f1;
  }
  
  public float getMaximumEntryWidth(Paint paramPaint)
  {
    float f1 = Utils.convertDpToPixel(this.mFormToTextSpace);
    LegendEntry[] arrayOfLegendEntry = this.mEntries;
    int i = arrayOfLegendEntry.length;
    float f2 = 0.0F;
    float f3 = 0.0F;
    int j = 0;
    while (j < i)
    {
      Object localObject = arrayOfLegendEntry[j];
      if (Float.isNaN(((LegendEntry)localObject).formSize)) {
        f4 = this.mFormSize;
      } else {
        f4 = ((LegendEntry)localObject).formSize;
      }
      float f5 = Utils.convertDpToPixel(f4);
      float f4 = f3;
      if (f5 > f3) {
        f4 = f5;
      }
      localObject = ((LegendEntry)localObject).label;
      if (localObject == null)
      {
        f3 = f2;
      }
      else
      {
        f5 = Utils.calcTextWidth(paramPaint, (String)localObject);
        f3 = f2;
        if (f5 > f2) {
          f3 = f5;
        }
      }
      j++;
      f2 = f3;
      f3 = f4;
    }
    return f2 + f3 + f1;
  }
  
  public LegendOrientation getOrientation()
  {
    return this.mOrientation;
  }
  
  public float getStackSpace()
  {
    return this.mStackSpace;
  }
  
  public LegendVerticalAlignment getVerticalAlignment()
  {
    return this.mVerticalAlignment;
  }
  
  public float getXEntrySpace()
  {
    return this.mXEntrySpace;
  }
  
  public float getYEntrySpace()
  {
    return this.mYEntrySpace;
  }
  
  public boolean isDrawInsideEnabled()
  {
    return this.mDrawInside;
  }
  
  public boolean isLegendCustom()
  {
    return this.mIsLegendCustom;
  }
  
  public boolean isWordWrapEnabled()
  {
    return this.mWordWrapEnabled;
  }
  
  public void resetCustom()
  {
    this.mIsLegendCustom = false;
  }
  
  public void setCustom(List<LegendEntry> paramList)
  {
    this.mEntries = ((LegendEntry[])paramList.toArray(new LegendEntry[paramList.size()]));
    this.mIsLegendCustom = true;
  }
  
  public void setCustom(LegendEntry[] paramArrayOfLegendEntry)
  {
    this.mEntries = paramArrayOfLegendEntry;
    this.mIsLegendCustom = true;
  }
  
  public void setDirection(LegendDirection paramLegendDirection)
  {
    this.mDirection = paramLegendDirection;
  }
  
  public void setDrawInside(boolean paramBoolean)
  {
    this.mDrawInside = paramBoolean;
  }
  
  public void setEntries(List<LegendEntry> paramList)
  {
    this.mEntries = ((LegendEntry[])paramList.toArray(new LegendEntry[paramList.size()]));
  }
  
  public void setExtra(List<LegendEntry> paramList)
  {
    this.mExtraEntries = ((LegendEntry[])paramList.toArray(new LegendEntry[paramList.size()]));
  }
  
  public void setExtra(int[] paramArrayOfInt, String[] paramArrayOfString)
  {
    ArrayList localArrayList = new ArrayList();
    for (int i = 0; i < Math.min(paramArrayOfInt.length, paramArrayOfString.length); i++)
    {
      LegendEntry localLegendEntry = new LegendEntry();
      int j = paramArrayOfInt[i];
      localLegendEntry.formColor = j;
      localLegendEntry.label = paramArrayOfString[i];
      if ((j != 1122868) && (j != 0))
      {
        if (j == 1122867) {
          localLegendEntry.form = LegendForm.EMPTY;
        }
      }
      else {
        localLegendEntry.form = LegendForm.NONE;
      }
      localArrayList.add(localLegendEntry);
    }
    this.mExtraEntries = ((LegendEntry[])localArrayList.toArray(new LegendEntry[localArrayList.size()]));
  }
  
  public void setExtra(LegendEntry[] paramArrayOfLegendEntry)
  {
    LegendEntry[] arrayOfLegendEntry = paramArrayOfLegendEntry;
    if (paramArrayOfLegendEntry == null) {
      arrayOfLegendEntry = new LegendEntry[0];
    }
    this.mExtraEntries = arrayOfLegendEntry;
  }
  
  public void setForm(LegendForm paramLegendForm)
  {
    this.mShape = paramLegendForm;
  }
  
  public void setFormLineDashEffect(DashPathEffect paramDashPathEffect)
  {
    this.mFormLineDashEffect = paramDashPathEffect;
  }
  
  public void setFormLineWidth(float paramFloat)
  {
    this.mFormLineWidth = paramFloat;
  }
  
  public void setFormSize(float paramFloat)
  {
    this.mFormSize = paramFloat;
  }
  
  public void setFormToTextSpace(float paramFloat)
  {
    this.mFormToTextSpace = paramFloat;
  }
  
  public void setHorizontalAlignment(LegendHorizontalAlignment paramLegendHorizontalAlignment)
  {
    this.mHorizontalAlignment = paramLegendHorizontalAlignment;
  }
  
  public void setMaxSizePercent(float paramFloat)
  {
    this.mMaxSizePercent = paramFloat;
  }
  
  public void setOrientation(LegendOrientation paramLegendOrientation)
  {
    this.mOrientation = paramLegendOrientation;
  }
  
  public void setStackSpace(float paramFloat)
  {
    this.mStackSpace = paramFloat;
  }
  
  public void setVerticalAlignment(LegendVerticalAlignment paramLegendVerticalAlignment)
  {
    this.mVerticalAlignment = paramLegendVerticalAlignment;
  }
  
  public void setWordWrapEnabled(boolean paramBoolean)
  {
    this.mWordWrapEnabled = paramBoolean;
  }
  
  public void setXEntrySpace(float paramFloat)
  {
    this.mXEntrySpace = paramFloat;
  }
  
  public void setYEntrySpace(float paramFloat)
  {
    this.mYEntrySpace = paramFloat;
  }
  
  public static enum LegendDirection
  {
    static
    {
      LegendDirection localLegendDirection1 = new LegendDirection("LEFT_TO_RIGHT", 0);
      LEFT_TO_RIGHT = localLegendDirection1;
      LegendDirection localLegendDirection2 = new LegendDirection("RIGHT_TO_LEFT", 1);
      RIGHT_TO_LEFT = localLegendDirection2;
      $VALUES = new LegendDirection[] { localLegendDirection1, localLegendDirection2 };
    }
  }
  
  public static enum LegendForm
  {
    static
    {
      LegendForm localLegendForm1 = new LegendForm("NONE", 0);
      NONE = localLegendForm1;
      LegendForm localLegendForm2 = new LegendForm("EMPTY", 1);
      EMPTY = localLegendForm2;
      LegendForm localLegendForm3 = new LegendForm("DEFAULT", 2);
      DEFAULT = localLegendForm3;
      LegendForm localLegendForm4 = new LegendForm("SQUARE", 3);
      SQUARE = localLegendForm4;
      LegendForm localLegendForm5 = new LegendForm("CIRCLE", 4);
      CIRCLE = localLegendForm5;
      LegendForm localLegendForm6 = new LegendForm("LINE", 5);
      LINE = localLegendForm6;
      $VALUES = new LegendForm[] { localLegendForm1, localLegendForm2, localLegendForm3, localLegendForm4, localLegendForm5, localLegendForm6 };
    }
  }
  
  public static enum LegendHorizontalAlignment
  {
    static
    {
      LegendHorizontalAlignment localLegendHorizontalAlignment1 = new LegendHorizontalAlignment("LEFT", 0);
      LEFT = localLegendHorizontalAlignment1;
      LegendHorizontalAlignment localLegendHorizontalAlignment2 = new LegendHorizontalAlignment("CENTER", 1);
      CENTER = localLegendHorizontalAlignment2;
      LegendHorizontalAlignment localLegendHorizontalAlignment3 = new LegendHorizontalAlignment("RIGHT", 2);
      RIGHT = localLegendHorizontalAlignment3;
      $VALUES = new LegendHorizontalAlignment[] { localLegendHorizontalAlignment1, localLegendHorizontalAlignment2, localLegendHorizontalAlignment3 };
    }
  }
  
  public static enum LegendOrientation
  {
    static
    {
      LegendOrientation localLegendOrientation1 = new LegendOrientation("HORIZONTAL", 0);
      HORIZONTAL = localLegendOrientation1;
      LegendOrientation localLegendOrientation2 = new LegendOrientation("VERTICAL", 1);
      VERTICAL = localLegendOrientation2;
      $VALUES = new LegendOrientation[] { localLegendOrientation1, localLegendOrientation2 };
    }
  }
  
  public static enum LegendVerticalAlignment
  {
    static
    {
      LegendVerticalAlignment localLegendVerticalAlignment1 = new LegendVerticalAlignment("TOP", 0);
      TOP = localLegendVerticalAlignment1;
      LegendVerticalAlignment localLegendVerticalAlignment2 = new LegendVerticalAlignment("CENTER", 1);
      CENTER = localLegendVerticalAlignment2;
      LegendVerticalAlignment localLegendVerticalAlignment3 = new LegendVerticalAlignment("BOTTOM", 2);
      BOTTOM = localLegendVerticalAlignment3;
      $VALUES = new LegendVerticalAlignment[] { localLegendVerticalAlignment1, localLegendVerticalAlignment2, localLegendVerticalAlignment3 };
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\components\Legend.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */