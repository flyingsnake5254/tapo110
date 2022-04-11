package com.github.mikephil.charting.exception;

public class DrawingDataSetNotCreatedException
  extends RuntimeException
{
  private static final long serialVersionUID = 1L;
  
  public DrawingDataSetNotCreatedException()
  {
    super("Have to create a new drawing set first. Call ChartData's createNewDrawingDataSet() method");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\exception\DrawingDataSetNotCreatedException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */