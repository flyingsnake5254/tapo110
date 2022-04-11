package com.tplink.iot.view.ipcamera.widget.topsnackbar;

import android.graphics.Color;

public enum Prompt
{
  private int backgroundColor;
  private int resIcon;
  
  static
  {
    Prompt localPrompt1 = new Prompt("ERROR", 0, 2131690438, Color.parseColor("#ff0000"));
    ERROR = localPrompt1;
    Prompt localPrompt2 = new Prompt("WARNING", 1, 2131690441, Color.parseColor("#f0633d"));
    WARNING = localPrompt2;
    Prompt localPrompt3 = new Prompt("SUCCESS", 2, 2131690440, Color.parseColor("#31c27c"));
    SUCCESS = localPrompt3;
    $VALUES = new Prompt[] { localPrompt1, localPrompt2, localPrompt3 };
  }
  
  private Prompt(int paramInt1, int paramInt2)
  {
    this.resIcon = paramInt1;
    this.backgroundColor = paramInt2;
  }
  
  public int getBackgroundColor()
  {
    return this.backgroundColor;
  }
  
  public int getResIcon()
  {
    return this.resIcon;
  }
  
  public void setBackgroundColor(int paramInt)
  {
    this.backgroundColor = paramInt;
  }
  
  public void setResIcon(int paramInt)
  {
    this.resIcon = paramInt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\widget\topsnackbar\Prompt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */