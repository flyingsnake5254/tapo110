package com.google.firebase.heartbeatinfo;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Task;
import java.util.List;

public abstract interface HeartBeatInfo
{
  @NonNull
  public abstract Task<List<HeartBeatResult>> getAndClearStoredHeartBeatInfo();
  
  @NonNull
  public abstract HeartBeat getHeartBeatCode(@NonNull String paramString);
  
  @NonNull
  public abstract Task<Void> storeHeartBeatInfo(@NonNull String paramString);
  
  public static enum HeartBeat
  {
    private final int code;
    
    static
    {
      HeartBeat localHeartBeat1 = new HeartBeat("NONE", 0, 0);
      NONE = localHeartBeat1;
      HeartBeat localHeartBeat2 = new HeartBeat("SDK", 1, 1);
      SDK = localHeartBeat2;
      HeartBeat localHeartBeat3 = new HeartBeat("GLOBAL", 2, 2);
      GLOBAL = localHeartBeat3;
      HeartBeat localHeartBeat4 = new HeartBeat("COMBINED", 3, 3);
      COMBINED = localHeartBeat4;
      $VALUES = new HeartBeat[] { localHeartBeat1, localHeartBeat2, localHeartBeat3, localHeartBeat4 };
    }
    
    private HeartBeat(int paramInt)
    {
      this.code = paramInt;
    }
    
    public int getCode()
    {
      return this.code;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\heartbeatinfo\HeartBeatInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */