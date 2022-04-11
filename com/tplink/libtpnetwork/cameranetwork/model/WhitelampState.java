package com.tplink.libtpnetwork.cameranetwork.model;

import com.google.gson.q.c;
import kotlin.jvm.internal.j;

public final class WhitelampState
{
  @c("force_wtl_state")
  private final String forceWtlState;
  
  public WhitelampState(String paramString)
  {
    this.forceWtlState = paramString;
  }
  
  public WhitelampState(boolean paramBoolean)
  {
    this(str);
  }
  
  public final String component1()
  {
    return this.forceWtlState;
  }
  
  public final WhitelampState copy(String paramString)
  {
    return new WhitelampState(paramString);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof WhitelampState))
      {
        paramObject = (WhitelampState)paramObject;
        if (j.a(this.forceWtlState, ((WhitelampState)paramObject).forceWtlState)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final String getForceWtlState()
  {
    return this.forceWtlState;
  }
  
  public int hashCode()
  {
    String str = this.forceWtlState;
    int i;
    if (str != null) {
      i = str.hashCode();
    } else {
      i = 0;
    }
    return i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WhitelampState(forceWtlState=");
    localStringBuilder.append(this.forceWtlState);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\WhitelampState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */