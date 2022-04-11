package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Objects;

final class AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame
  extends CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame
{
  private final String file;
  private final int importance;
  private final long offset;
  private final long pc;
  private final String symbol;
  
  private AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame(long paramLong1, String paramString1, @Nullable String paramString2, long paramLong2, int paramInt)
  {
    this.pc = paramLong1;
    this.symbol = paramString1;
    this.file = paramString2;
    this.offset = paramLong2;
    this.importance = paramInt;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame))
    {
      CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame localFrame = (CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame)paramObject;
      if ((this.pc == localFrame.getPc()) && (this.symbol.equals(localFrame.getSymbol())))
      {
        paramObject = this.file;
        if ((paramObject == null ? localFrame.getFile() == null : ((String)paramObject).equals(localFrame.getFile())) && (this.offset == localFrame.getOffset()) && (this.importance == localFrame.getImportance())) {}
      }
      else
      {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  @Nullable
  public String getFile()
  {
    return this.file;
  }
  
  public int getImportance()
  {
    return this.importance;
  }
  
  public long getOffset()
  {
    return this.offset;
  }
  
  public long getPc()
  {
    return this.pc;
  }
  
  @NonNull
  public String getSymbol()
  {
    return this.symbol;
  }
  
  public int hashCode()
  {
    long l = this.pc;
    int i = (int)(l ^ l >>> 32);
    int j = this.symbol.hashCode();
    String str = this.file;
    int k;
    if (str == null) {
      k = 0;
    } else {
      k = str.hashCode();
    }
    l = this.offset;
    int m = (int)(l >>> 32 ^ l);
    return this.importance ^ ((((i ^ 0xF4243) * 1000003 ^ j) * 1000003 ^ k) * 1000003 ^ m) * 1000003;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Frame{pc=");
    localStringBuilder.append(this.pc);
    localStringBuilder.append(", symbol=");
    localStringBuilder.append(this.symbol);
    localStringBuilder.append(", file=");
    localStringBuilder.append(this.file);
    localStringBuilder.append(", offset=");
    localStringBuilder.append(this.offset);
    localStringBuilder.append(", importance=");
    localStringBuilder.append(this.importance);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  static final class Builder
    extends CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder
  {
    private String file;
    private Integer importance;
    private Long offset;
    private Long pc;
    private String symbol;
    
    public CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame build()
    {
      Object localObject1 = this.pc;
      Object localObject2 = "";
      if (localObject1 == null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(" pc");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      localObject1 = localObject2;
      if (this.symbol == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(" symbol");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      localObject2 = localObject1;
      if (this.offset == null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" offset");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      localObject1 = localObject2;
      if (this.importance == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(" importance");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      if (((String)localObject1).isEmpty()) {
        return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame(this.pc.longValue(), this.symbol, this.file, this.offset.longValue(), this.importance.intValue(), null);
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Missing required properties:");
      ((StringBuilder)localObject2).append((String)localObject1);
      throw new IllegalStateException(((StringBuilder)localObject2).toString());
    }
    
    public CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder setFile(String paramString)
    {
      this.file = paramString;
      return this;
    }
    
    public CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder setImportance(int paramInt)
    {
      this.importance = Integer.valueOf(paramInt);
      return this;
    }
    
    public CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder setOffset(long paramLong)
    {
      this.offset = Long.valueOf(paramLong);
      return this;
    }
    
    public CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder setPc(long paramLong)
    {
      this.pc = Long.valueOf(paramLong);
      return this;
    }
    
    public CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder setSymbol(String paramString)
    {
      Objects.requireNonNull(paramString, "Null symbol");
      this.symbol = paramString;
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\crashlytics\internal\model\AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */