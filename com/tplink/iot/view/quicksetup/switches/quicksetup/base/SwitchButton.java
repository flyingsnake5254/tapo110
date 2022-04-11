package com.tplink.iot.view.quicksetup.switches.quicksetup.base;

public enum SwitchButton
{
  public static final a Companion = new a(null);
  private final int pos;
  
  static
  {
    SwitchButton localSwitchButton1 = new SwitchButton("FIRST", 0, 1);
    FIRST = localSwitchButton1;
    SwitchButton localSwitchButton2 = new SwitchButton("SECOND", 1, 2);
    SECOND = localSwitchButton2;
    $VALUES = new SwitchButton[] { localSwitchButton1, localSwitchButton2 };
  }
  
  private SwitchButton(int paramInt)
  {
    this.pos = paramInt;
  }
  
  public static final SwitchButton fromInt(int paramInt)
  {
    return Companion.a(paramInt);
  }
  
  public final int getPos()
  {
    return this.pos;
  }
  
  public static final class a
  {
    public final SwitchButton a(int paramInt)
    {
      for (localSwitchButton : )
      {
        int k;
        if (localSwitchButton.getPos() == paramInt) {
          k = 1;
        } else {
          k = 0;
        }
        if (k != 0) {
          break label57;
        }
      }
      SwitchButton localSwitchButton = null;
      label57:
      return localSwitchButton;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\quicksetup\switches\quicksetup\base\SwitchButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */