package com.github.mikephil.charting.listener;

import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;

public abstract interface OnChartValueSelectedListener
{
  public abstract void onNothingSelected();
  
  public abstract void onValueSelected(Entry paramEntry, Highlight paramHighlight);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\listener\OnChartValueSelectedListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */