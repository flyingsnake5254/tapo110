package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Typeface;
import com.github.mikephil.charting.components.ComponentBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.Legend.LegendDirection;
import com.github.mikephil.charting.components.Legend.LegendForm;
import com.github.mikephil.charting.components.Legend.LegendHorizontalAlignment;
import com.github.mikephil.charting.components.Legend.LegendOrientation;
import com.github.mikephil.charting.components.LegendEntry;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.interfaces.datasets.ICandleDataSet;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.interfaces.datasets.IPieDataSet;
import com.github.mikephil.charting.utils.FSize;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LegendRenderer
  extends Renderer
{
  protected List<LegendEntry> computedEntries = new ArrayList(16);
  protected Paint.FontMetrics legendFontMetrics = new Paint.FontMetrics();
  protected Legend mLegend;
  protected Paint mLegendFormPaint;
  protected Paint mLegendLabelPaint;
  private Path mLineFormPath = new Path();
  
  public LegendRenderer(ViewPortHandler paramViewPortHandler, Legend paramLegend)
  {
    super(paramViewPortHandler);
    this.mLegend = paramLegend;
    paramViewPortHandler = new Paint(1);
    this.mLegendLabelPaint = paramViewPortHandler;
    paramViewPortHandler.setTextSize(Utils.convertDpToPixel(9.0F));
    this.mLegendLabelPaint.setTextAlign(Paint.Align.LEFT);
    paramViewPortHandler = new Paint(1);
    this.mLegendFormPaint = paramViewPortHandler;
    paramViewPortHandler.setStyle(Paint.Style.FILL);
  }
  
  public void computeLegend(ChartData<?> paramChartData)
  {
    Object localObject = paramChartData;
    if (!this.mLegend.isLegendCustom())
    {
      this.computedEntries.clear();
      for (int i = 0; i < paramChartData.getDataSetCount(); i++)
      {
        IDataSet localIDataSet = ((ChartData)localObject).getDataSetByIndex(i);
        List localList = localIDataSet.getColors();
        int j = localIDataSet.getEntryCount();
        int k;
        if ((localIDataSet instanceof IBarDataSet))
        {
          IBarDataSet localIBarDataSet = (IBarDataSet)localIDataSet;
          if (localIBarDataSet.isStacked())
          {
            String[] arrayOfString = localIBarDataSet.getStackLabels();
            for (k = 0; (k < localList.size()) && (k < localIBarDataSet.getStackSize()); k++) {
              this.computedEntries.add(new LegendEntry(arrayOfString[(k % arrayOfString.length)], localIDataSet.getForm(), localIDataSet.getFormSize(), localIDataSet.getFormLineWidth(), localIDataSet.getFormLineDashEffect(), ((Integer)localList.get(k)).intValue()));
            }
            if (localIBarDataSet.getLabel() != null) {
              this.computedEntries.add(new LegendEntry(localIDataSet.getLabel(), Legend.LegendForm.NONE, NaN.0F, NaN.0F, null, 1122867));
            }
            continue;
          }
        }
        if ((localIDataSet instanceof IPieDataSet))
        {
          localObject = (IPieDataSet)localIDataSet;
          for (k = 0; (k < localList.size()) && (k < j); k++) {
            this.computedEntries.add(new LegendEntry(((PieEntry)((IDataSet)localObject).getEntryForIndex(k)).getLabel(), localIDataSet.getForm(), localIDataSet.getFormSize(), localIDataSet.getFormLineWidth(), localIDataSet.getFormLineDashEffect(), ((Integer)localList.get(k)).intValue()));
          }
          if (((IDataSet)localObject).getLabel() != null) {
            this.computedEntries.add(new LegendEntry(localIDataSet.getLabel(), Legend.LegendForm.NONE, NaN.0F, NaN.0F, null, 1122867));
          }
        }
        else
        {
          if ((localIDataSet instanceof ICandleDataSet))
          {
            localObject = (ICandleDataSet)localIDataSet;
            if (((ICandleDataSet)localObject).getDecreasingColor() != 1122867)
            {
              j = ((ICandleDataSet)localObject).getDecreasingColor();
              k = ((ICandleDataSet)localObject).getIncreasingColor();
              this.computedEntries.add(new LegendEntry(null, localIDataSet.getForm(), localIDataSet.getFormSize(), localIDataSet.getFormLineWidth(), localIDataSet.getFormLineDashEffect(), j));
              this.computedEntries.add(new LegendEntry(localIDataSet.getLabel(), localIDataSet.getForm(), localIDataSet.getFormSize(), localIDataSet.getFormLineWidth(), localIDataSet.getFormLineDashEffect(), k));
              break label675;
            }
          }
          for (k = 0; (k < localList.size()) && (k < j); k++)
          {
            if ((k < localList.size() - 1) && (k < j - 1)) {
              localObject = null;
            } else {
              localObject = paramChartData.getDataSetByIndex(i).getLabel();
            }
            this.computedEntries.add(new LegendEntry((String)localObject, localIDataSet.getForm(), localIDataSet.getFormSize(), localIDataSet.getFormLineWidth(), localIDataSet.getFormLineDashEffect(), ((Integer)localList.get(k)).intValue()));
          }
        }
        label675:
        localObject = paramChartData;
      }
      if (this.mLegend.getExtraEntries() != null) {
        Collections.addAll(this.computedEntries, this.mLegend.getExtraEntries());
      }
      this.mLegend.setEntries(this.computedEntries);
    }
    paramChartData = this.mLegend.getTypeface();
    if (paramChartData != null) {
      this.mLegendLabelPaint.setTypeface(paramChartData);
    }
    this.mLegendLabelPaint.setTextSize(this.mLegend.getTextSize());
    this.mLegendLabelPaint.setColor(this.mLegend.getTextColor());
    this.mLegend.calculateDimensions(this.mLegendLabelPaint, this.mViewPortHandler);
  }
  
  protected void drawForm(Canvas paramCanvas, float paramFloat1, float paramFloat2, LegendEntry paramLegendEntry, Legend paramLegend)
  {
    int i = paramLegendEntry.formColor;
    if ((i != 1122868) && (i != 1122867) && (i != 0))
    {
      i = paramCanvas.save();
      Legend.LegendForm localLegendForm = paramLegendEntry.form;
      Object localObject = localLegendForm;
      if (localLegendForm == Legend.LegendForm.DEFAULT) {
        localObject = paramLegend.getForm();
      }
      this.mLegendFormPaint.setColor(paramLegendEntry.formColor);
      if (Float.isNaN(paramLegendEntry.formSize)) {
        f1 = paramLegend.getFormSize();
      } else {
        f1 = paramLegendEntry.formSize;
      }
      float f2 = Utils.convertDpToPixel(f1);
      float f1 = f2 / 2.0F;
      int j = 1.$SwitchMap$com$github$mikephil$charting$components$Legend$LegendForm[localObject.ordinal()];
      if ((j != 3) && (j != 4))
      {
        if (j != 5)
        {
          if (j == 6)
          {
            if (Float.isNaN(paramLegendEntry.formLineWidth)) {
              f1 = paramLegend.getFormLineWidth();
            } else {
              f1 = paramLegendEntry.formLineWidth;
            }
            f1 = Utils.convertDpToPixel(f1);
            localObject = paramLegendEntry.formLineDashEffect;
            paramLegendEntry = (LegendEntry)localObject;
            if (localObject == null) {
              paramLegendEntry = paramLegend.getFormLineDashEffect();
            }
            this.mLegendFormPaint.setStyle(Paint.Style.STROKE);
            this.mLegendFormPaint.setStrokeWidth(f1);
            this.mLegendFormPaint.setPathEffect(paramLegendEntry);
            this.mLineFormPath.reset();
            this.mLineFormPath.moveTo(paramFloat1, paramFloat2);
            this.mLineFormPath.lineTo(paramFloat1 + f2, paramFloat2);
            paramCanvas.drawPath(this.mLineFormPath, this.mLegendFormPaint);
          }
        }
        else
        {
          this.mLegendFormPaint.setStyle(Paint.Style.FILL);
          paramCanvas.drawRect(paramFloat1, paramFloat2 - f1, paramFloat1 + f2, paramFloat2 + f1, this.mLegendFormPaint);
        }
      }
      else
      {
        this.mLegendFormPaint.setStyle(Paint.Style.FILL);
        paramCanvas.drawCircle(paramFloat1 + f1, paramFloat2, f1, this.mLegendFormPaint);
      }
      paramCanvas.restoreToCount(i);
    }
  }
  
  protected void drawLabel(Canvas paramCanvas, float paramFloat1, float paramFloat2, String paramString)
  {
    paramCanvas.drawText(paramString, paramFloat1, paramFloat2, this.mLegendLabelPaint);
  }
  
  public Paint getFormPaint()
  {
    return this.mLegendFormPaint;
  }
  
  public Paint getLabelPaint()
  {
    return this.mLegendLabelPaint;
  }
  
  public void renderLegend(Canvas paramCanvas)
  {
    if (!this.mLegend.isEnabled()) {
      return;
    }
    Object localObject1 = this.mLegend.getTypeface();
    if (localObject1 != null) {
      this.mLegendLabelPaint.setTypeface((Typeface)localObject1);
    }
    this.mLegendLabelPaint.setTextSize(this.mLegend.getTextSize());
    this.mLegendLabelPaint.setColor(this.mLegend.getTextColor());
    float f1 = Utils.getLineHeight(this.mLegendLabelPaint, this.legendFontMetrics);
    float f2 = Utils.getLineSpacing(this.mLegendLabelPaint, this.legendFontMetrics) + Utils.convertDpToPixel(this.mLegend.getYEntrySpace());
    float f3 = f1 - Utils.calcTextHeight(this.mLegendLabelPaint, "ABC") / 2.0F;
    LegendEntry[] arrayOfLegendEntry = this.mLegend.getEntries();
    float f4 = Utils.convertDpToPixel(this.mLegend.getFormToTextSpace());
    float f5 = Utils.convertDpToPixel(this.mLegend.getXEntrySpace());
    localObject1 = this.mLegend.getOrientation();
    Legend.LegendHorizontalAlignment localLegendHorizontalAlignment = this.mLegend.getHorizontalAlignment();
    Object localObject2 = this.mLegend.getVerticalAlignment();
    Object localObject3 = this.mLegend.getDirection();
    float f6 = Utils.convertDpToPixel(this.mLegend.getFormSize());
    float f7 = Utils.convertDpToPixel(this.mLegend.getStackSpace());
    float f8 = this.mLegend.getYOffset();
    float f9 = this.mLegend.getXOffset();
    int i = 1.$SwitchMap$com$github$mikephil$charting$components$Legend$LegendHorizontalAlignment[localLegendHorizontalAlignment.ordinal()];
    Object localObject4;
    float f10;
    Object localObject5;
    float f11;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          f9 = 0.0F;
        }
        else
        {
          localObject4 = Legend.LegendOrientation.VERTICAL;
          if (localObject1 == localObject4) {
            f10 = this.mViewPortHandler.getChartWidth() / 2.0F;
          } else {
            f10 = this.mViewPortHandler.contentLeft() + this.mViewPortHandler.contentWidth() / 2.0F;
          }
          localObject5 = Legend.LegendDirection.LEFT_TO_RIGHT;
          if (localObject3 == localObject5) {
            f11 = f9;
          } else {
            f11 = -f9;
          }
          f10 += f11;
          if (localObject1 == localObject4)
          {
            double d1 = f10;
            double d2;
            if (localObject3 == localObject5) {
              d2 = -this.mLegend.mNeededWidth / 2.0D + f9;
            } else {
              d2 = this.mLegend.mNeededWidth / 2.0D - f9;
            }
            f9 = (float)(d1 + d2);
          }
          else
          {
            f9 = f10;
          }
        }
      }
      else
      {
        if (localObject1 == Legend.LegendOrientation.VERTICAL) {
          f10 = this.mViewPortHandler.getChartWidth();
        } else {
          f10 = this.mViewPortHandler.contentRight();
        }
        f10 -= f9;
        f9 = f10;
        if (localObject3 == Legend.LegendDirection.LEFT_TO_RIGHT) {
          f9 = f10 - this.mLegend.mNeededWidth;
        }
      }
    }
    else
    {
      if (localObject1 != Legend.LegendOrientation.VERTICAL) {
        f9 += this.mViewPortHandler.contentLeft();
      }
      if (localObject3 == Legend.LegendDirection.RIGHT_TO_LEFT) {
        f9 += this.mLegend.mNeededWidth;
      }
    }
    i = 1.$SwitchMap$com$github$mikephil$charting$components$Legend$LegendOrientation[localObject1.ordinal()];
    int j;
    float f12;
    int k;
    if (i != 1)
    {
      if (i == 2)
      {
        i = 1.$SwitchMap$com$github$mikephil$charting$components$Legend$LegendVerticalAlignment[localObject2.ordinal()];
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3)
            {
              f10 = 0.0F;
            }
            else
            {
              f10 = this.mViewPortHandler.getChartHeight() / 2.0F;
              localObject1 = this.mLegend;
              f10 = f10 - ((Legend)localObject1).mNeededHeight / 2.0F + ((ComponentBase)localObject1).getYOffset();
            }
          }
          else
          {
            if (localLegendHorizontalAlignment == Legend.LegendHorizontalAlignment.CENTER) {
              f10 = this.mViewPortHandler.getChartHeight();
            } else {
              f10 = this.mViewPortHandler.contentBottom();
            }
            f10 -= this.mLegend.mNeededHeight + f8;
          }
        }
        else
        {
          if (localLegendHorizontalAlignment == Legend.LegendHorizontalAlignment.CENTER) {
            f10 = 0.0F;
          } else {
            f10 = this.mViewPortHandler.contentTop();
          }
          f10 += f8;
        }
        j = 0;
        i = 0;
        f12 = 0.0F;
        f5 = f7;
        f8 = f3;
        localObject1 = localObject3;
        while (i < arrayOfLegendEntry.length)
        {
          localObject5 = arrayOfLegendEntry[i];
          if (((LegendEntry)localObject5).form != Legend.LegendForm.NONE) {
            k = 1;
          } else {
            k = 0;
          }
          if (Float.isNaN(((LegendEntry)localObject5).formSize)) {
            f3 = f6;
          } else {
            f3 = Utils.convertDpToPixel(((LegendEntry)localObject5).formSize);
          }
          if (k != 0)
          {
            localObject3 = Legend.LegendDirection.LEFT_TO_RIGHT;
            if (localObject1 == localObject3) {
              f7 = f9 + f12;
            } else {
              f7 = f9 - (f3 - f12);
            }
            drawForm(paramCanvas, f7, f10 + f8, (LegendEntry)localObject5, this.mLegend);
            f11 = f7;
            if (localObject1 == localObject3) {
              f11 = f7 + f3;
            }
          }
          else
          {
            f11 = f9;
          }
          f7 = f9;
          localObject3 = ((LegendEntry)localObject5).label;
          if (localObject3 != null)
          {
            if ((k != 0) && (j == 0))
            {
              if (localObject1 == Legend.LegendDirection.LEFT_TO_RIGHT) {
                f9 = f4;
              } else {
                f9 = -f4;
              }
              f9 = f11 + f9;
            }
            else
            {
              f9 = f11;
              if (j != 0) {
                f9 = f7;
              }
            }
            f11 = f9;
            if (localObject1 == Legend.LegendDirection.RIGHT_TO_LEFT) {
              f11 = f9 - Utils.calcTextWidth(this.mLegendLabelPaint, (String)localObject3);
            }
            if (j == 0)
            {
              drawLabel(paramCanvas, f11, f10 + f1, ((LegendEntry)localObject5).label);
            }
            else
            {
              f10 += f1 + f2;
              drawLabel(paramCanvas, f11, f10 + f1, ((LegendEntry)localObject5).label);
            }
            f10 += f1 + f2;
            f11 = 0.0F;
          }
          else
          {
            f11 = f12 + (f3 + f5);
            j = 1;
          }
          i++;
          f9 = f7;
          f12 = f11;
        }
      }
    }
    else
    {
      f11 = f7;
      localObject1 = this.mLegend.getCalculatedLineSizes();
      localObject4 = this.mLegend.getCalculatedLabelSizes();
      localObject5 = this.mLegend.getCalculatedLabelBreakPoints();
      i = 1.$SwitchMap$com$github$mikephil$charting$components$Legend$LegendVerticalAlignment[localObject2.ordinal()];
      f10 = f8;
      if (i != 1) {
        if (i != 2)
        {
          if (i != 3) {
            f10 = 0.0F;
          } else {
            f10 = f8 + (this.mViewPortHandler.getChartHeight() - this.mLegend.mNeededHeight) / 2.0F;
          }
        }
        else {
          f10 = this.mViewPortHandler.getChartHeight() - f8 - this.mLegend.mNeededHeight;
        }
      }
      k = arrayOfLegendEntry.length;
      f8 = f9;
      i = 0;
      j = 0;
      f7 = f5;
      f5 = f11;
      f11 = f8;
      while (i < k)
      {
        LegendEntry localLegendEntry = arrayOfLegendEntry[i];
        int m;
        if (localLegendEntry.form != Legend.LegendForm.NONE) {
          m = 1;
        } else {
          m = 0;
        }
        if (Float.isNaN(localLegendEntry.formSize)) {
          f12 = f6;
        } else {
          f12 = Utils.convertDpToPixel(localLegendEntry.formSize);
        }
        if ((i < ((List)localObject5).size()) && (((Boolean)((List)localObject5).get(i)).booleanValue()))
        {
          f11 = f10 + (f1 + f2);
          f10 = f9;
        }
        else
        {
          f8 = f11;
          f11 = f10;
          f10 = f8;
        }
        if ((f10 == f9) && (localLegendHorizontalAlignment == Legend.LegendHorizontalAlignment.CENTER) && (j < ((List)localObject1).size()))
        {
          if (localObject3 == Legend.LegendDirection.RIGHT_TO_LEFT) {
            f8 = ((FSize)((List)localObject1).get(j)).width;
          } else {
            f8 = -((FSize)((List)localObject1).get(j)).width;
          }
          f10 += f8 / 2.0F;
          j++;
        }
        int n;
        if (localLegendEntry.label == null) {
          n = 1;
        } else {
          n = 0;
        }
        if (m != 0)
        {
          f8 = f10;
          if (localObject3 == Legend.LegendDirection.RIGHT_TO_LEFT) {
            f8 = f10 - f12;
          }
          drawForm(paramCanvas, f8, f11 + f3, localLegendEntry, this.mLegend);
          if (localObject3 == Legend.LegendDirection.LEFT_TO_RIGHT) {
            f10 = f8 + f12;
          } else {
            f10 = f8;
          }
        }
        if (n == 0)
        {
          f8 = f10;
          if (m != 0)
          {
            if (localObject3 == Legend.LegendDirection.RIGHT_TO_LEFT) {
              f8 = -f4;
            } else {
              f8 = f4;
            }
            f8 = f10 + f8;
          }
          localObject2 = Legend.LegendDirection.RIGHT_TO_LEFT;
          f10 = f8;
          if (localObject3 == localObject2) {
            f10 = f8 - ((FSize)((List)localObject4).get(i)).width;
          }
          drawLabel(paramCanvas, f10, f11 + f1, localLegendEntry.label);
          f8 = f10;
          if (localObject3 == Legend.LegendDirection.LEFT_TO_RIGHT) {
            f8 = f10 + ((FSize)((List)localObject4).get(i)).width;
          }
          if (localObject3 == localObject2) {
            f10 = -f7;
          } else {
            f10 = f7;
          }
          f10 = f8 + f10;
        }
        else
        {
          if (localObject3 == Legend.LegendDirection.RIGHT_TO_LEFT) {
            f8 = -f5;
          } else {
            f8 = f5;
          }
          f10 += f8;
        }
        f8 = f7;
        i++;
        f7 = f11;
        f11 = f10;
        f10 = f7;
        f7 = f8;
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\renderer\LegendRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */