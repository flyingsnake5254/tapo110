package com.tplink.iot.musicphonerhythm.bean;

import com.google.gson.q.c;
import java.util.ArrayList;

public class TUBPColorDbBean
{
  @c("color_state")
  private ArrayList<Integer> colorState;
  @c("delta_db")
  private int deltaDb;
  
  public TUBPColorDbBean() {}
  
  public TUBPColorDbBean(ArrayList<Integer> paramArrayList, int paramInt)
  {
    this.colorState = paramArrayList;
    this.deltaDb = paramInt;
  }
  
  public void setColorState(ArrayList<Integer> paramArrayList)
  {
    this.colorState = paramArrayList;
  }
  
  public void setDeltaDb(int paramInt)
  {
    this.deltaDb = paramInt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\musicphonerhythm\bean\TUBPColorDbBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */