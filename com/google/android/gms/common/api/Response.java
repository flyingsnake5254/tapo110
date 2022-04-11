package com.google.android.gms.common.api;

import androidx.annotation.NonNull;

public class Response<T extends Result>
{
  private T zzap;
  
  public Response() {}
  
  protected Response(@NonNull T paramT)
  {
    this.zzap = paramT;
  }
  
  @NonNull
  protected T getResult()
  {
    return this.zzap;
  }
  
  public void setResult(@NonNull T paramT)
  {
    this.zzap = paramT;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\api\Response.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */