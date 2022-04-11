package com.github.mikephil.charting.renderer;

import com.github.mikephil.charting.utils.ViewPortHandler;

public abstract class Renderer
{
  protected ViewPortHandler mViewPortHandler;
  
  public Renderer(ViewPortHandler paramViewPortHandler)
  {
    this.mViewPortHandler = paramViewPortHandler;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\renderer\Renderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */