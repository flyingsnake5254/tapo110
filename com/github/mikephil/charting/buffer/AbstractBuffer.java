package com.github.mikephil.charting.buffer;

public abstract class AbstractBuffer<T>
{
  public final float[] buffer;
  protected int index = 0;
  protected int mFrom = 0;
  protected int mTo = 0;
  protected float phaseX = 1.0F;
  protected float phaseY = 1.0F;
  
  public AbstractBuffer(int paramInt)
  {
    this.buffer = new float[paramInt];
  }
  
  public abstract void feed(T paramT);
  
  public void limitFrom(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    this.mFrom = i;
  }
  
  public void limitTo(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    this.mTo = i;
  }
  
  public void reset()
  {
    this.index = 0;
  }
  
  public void setPhases(float paramFloat1, float paramFloat2)
  {
    this.phaseX = paramFloat1;
    this.phaseY = paramFloat2;
  }
  
  public int size()
  {
    return this.buffer.length;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\buffer\AbstractBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */