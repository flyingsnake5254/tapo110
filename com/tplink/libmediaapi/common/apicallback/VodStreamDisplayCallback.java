package com.tplink.libmediaapi.common.apicallback;

public abstract interface VodStreamDisplayCallback
{
  public abstract void showDisplayProgress(long paramLong);
  
  public abstract void vodPlayRate(boolean paramBoolean, float paramFloat);
  
  public abstract void vodSeekTime(boolean paramBoolean);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libmediaapi\common\apicallback\VodStreamDisplayCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */