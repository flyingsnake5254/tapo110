package com.github.mikephil.charting.listener;

import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;

public abstract interface OnDrawListener
{
  public abstract void onDrawFinished(DataSet<?> paramDataSet);
  
  public abstract void onEntryAdded(Entry paramEntry);
  
  public abstract void onEntryMoved(Entry paramEntry);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\listener\OnDrawListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */