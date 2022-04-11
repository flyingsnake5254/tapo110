package com.tplink.iot.devices.trv.view.chart;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.ComponentBase;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.renderer.AxisRenderer;
import com.github.mikephil.charting.renderer.Renderer;
import com.github.mikephil.charting.renderer.YAxisRenderer;
import com.github.mikephil.charting.utils.FSize;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.j;

public final class b
  extends YAxisRenderer
{
  public b(ViewPortHandler paramViewPortHandler, YAxis paramYAxis, Transformer paramTransformer)
  {
    super(paramViewPortHandler, paramYAxis, paramTransformer);
  }
  
  public void renderAxisLabels(Canvas paramCanvas)
  {
    j.e(paramCanvas, "c");
  }
  
  public void renderLimitLines(Canvas paramCanvas)
  {
    j.e(paramCanvas, "c");
    Object localObject1 = this.mYAxis;
    j.d(localObject1, "mYAxis");
    List localList = ((AxisBase)localObject1).getLimitLines();
    int i = 0;
    if ((localList != null) && (!localList.isEmpty())) {
      j = 0;
    } else {
      j = 1;
    }
    if (j != 0) {
      return;
    }
    float[] arrayOfFloat = this.mRenderLimitLinesBuffer;
    arrayOfFloat[0] = 0.0F;
    arrayOfFloat[1] = 0.0F;
    localObject1 = this.mRenderLimitLines;
    ((Path)localObject1).reset();
    int k = localList.size();
    for (int j = i; j < k; j++)
    {
      Object localObject2 = (LimitLine)localList.get(j);
      j.d(localObject2, "l");
      if (((ComponentBase)localObject2).isEnabled())
      {
        i = paramCanvas.save();
        Object localObject3 = this.mLimitLineClippingRect;
        Object localObject4 = this.mViewPortHandler;
        j.d(localObject4, "mViewPortHandler");
        ((RectF)localObject3).set(((ViewPortHandler)localObject4).getContentRect());
        this.mLimitLineClippingRect.inset(0.0F, -((LimitLine)localObject2).getLineWidth());
        paramCanvas.clipRect(this.mLimitLineClippingRect);
        localObject4 = this.mLimitLinePaint;
        j.d(localObject4, "mLimitLinePaint");
        ((Paint)localObject4).setStyle(Paint.Style.STROKE);
        localObject4 = this.mLimitLinePaint;
        j.d(localObject4, "mLimitLinePaint");
        ((Paint)localObject4).setColor(((LimitLine)localObject2).getLineColor());
        localObject4 = this.mLimitLinePaint;
        j.d(localObject4, "mLimitLinePaint");
        ((Paint)localObject4).setStrokeWidth(((LimitLine)localObject2).getLineWidth());
        localObject4 = this.mLimitLinePaint;
        j.d(localObject4, "mLimitLinePaint");
        ((Paint)localObject4).setPathEffect(((LimitLine)localObject2).getDashPathEffect());
        arrayOfFloat[1] = ((LimitLine)localObject2).getLimit();
        this.mTrans.pointValuesToPixel(arrayOfFloat);
        ((Path)localObject1).moveTo(this.mViewPortHandler.contentLeft(), arrayOfFloat[1]);
        ((Path)localObject1).lineTo(this.mViewPortHandler.contentRight(), arrayOfFloat[1]);
        paramCanvas.drawPath((Path)localObject1, this.mLimitLinePaint);
        paramCanvas.restoreToCount(i);
        ((Path)localObject1).reset();
        localObject4 = ((LimitLine)localObject2).getLabel();
        if ((localObject4 != null) && ((j.a(localObject4, "") ^ true)))
        {
          localObject3 = this.mLimitLinePaint;
          j.d(localObject3, "mLimitLinePaint");
          ((Paint)localObject3).setStyle(((LimitLine)localObject2).getTextStyle());
          localObject3 = this.mLimitLinePaint;
          j.d(localObject3, "mLimitLinePaint");
          ((Paint)localObject3).setPathEffect(null);
          localObject3 = this.mLimitLinePaint;
          j.d(localObject3, "mLimitLinePaint");
          ((Paint)localObject3).setColor(((ComponentBase)localObject2).getTextColor());
          localObject3 = this.mLimitLinePaint;
          j.d(localObject3, "mLimitLinePaint");
          ((Paint)localObject3).setTypeface(((ComponentBase)localObject2).getTypeface());
          localObject3 = this.mLimitLinePaint;
          j.d(localObject3, "mLimitLinePaint");
          ((Paint)localObject3).setStrokeWidth(0.5F);
          localObject3 = this.mLimitLinePaint;
          j.d(localObject3, "mLimitLinePaint");
          ((Paint)localObject3).setTextSize(((ComponentBase)localObject2).getTextSize());
          localObject3 = Utils.calcTextSize(this.mLimitLinePaint, (String)localObject4);
          float f1 = this.mViewPortHandler.contentLeft();
          float f2 = ((ComponentBase)localObject2).getXOffset();
          float f3 = ((FSize)localObject3).width;
          float f4 = arrayOfFloat[1];
          float f5 = ((FSize)localObject3).height / 2.0F;
          localObject2 = this.mLimitLinePaint;
          j.d(localObject2, "mLimitLinePaint");
          ((Paint)localObject2).setTextAlign(Paint.Align.LEFT);
          paramCanvas.drawText((String)localObject4, f1 - f2 - f3, f4 + f5, this.mLimitLinePaint);
        }
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\trv\view\chart\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */