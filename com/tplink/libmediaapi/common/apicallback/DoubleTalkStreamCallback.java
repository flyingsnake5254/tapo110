package com.tplink.libmediaapi.common.apicallback;

public abstract interface DoubleTalkStreamCallback
{
  public abstract void onDoubleTalkClose(String paramString);
  
  public abstract void onDoubleTalkCreateFailure(String paramString, int paramInt);
  
  public abstract void onDoubleTalkCreateSuccess(String paramString);
  
  public abstract void onDoubleTalkSendDataFailure(String paramString, int paramInt, Exception paramException);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libmediaapi\common\apicallback\DoubleTalkStreamCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */