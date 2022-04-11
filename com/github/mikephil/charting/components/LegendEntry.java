package com.github.mikephil.charting.components;

import android.graphics.DashPathEffect;

public class LegendEntry
{
  public Legend.LegendForm form = Legend.LegendForm.DEFAULT;
  public int formColor = 1122867;
  public DashPathEffect formLineDashEffect = null;
  public float formLineWidth = NaN.0F;
  public float formSize = NaN.0F;
  public String label;
  
  public LegendEntry() {}
  
  public LegendEntry(String paramString, Legend.LegendForm paramLegendForm, float paramFloat1, float paramFloat2, DashPathEffect paramDashPathEffect, int paramInt)
  {
    this.label = paramString;
    this.form = paramLegendForm;
    this.formSize = paramFloat1;
    this.formLineWidth = paramFloat2;
    this.formLineDashEffect = paramDashPathEffect;
    this.formColor = paramInt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\components\LegendEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */