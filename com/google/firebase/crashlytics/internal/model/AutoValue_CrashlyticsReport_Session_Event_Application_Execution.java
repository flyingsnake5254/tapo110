package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import java.util.Objects;

final class AutoValue_CrashlyticsReport_Session_Event_Application_Execution
  extends CrashlyticsReport.Session.Event.Application.Execution
{
  private final ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.BinaryImage> binaries;
  private final CrashlyticsReport.Session.Event.Application.Execution.Exception exception;
  private final CrashlyticsReport.Session.Event.Application.Execution.Signal signal;
  private final ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread> threads;
  
  private AutoValue_CrashlyticsReport_Session_Event_Application_Execution(ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread> paramImmutableList, CrashlyticsReport.Session.Event.Application.Execution.Exception paramException, CrashlyticsReport.Session.Event.Application.Execution.Signal paramSignal, ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.BinaryImage> paramImmutableList1)
  {
    this.threads = paramImmutableList;
    this.exception = paramException;
    this.signal = paramSignal;
    this.binaries = paramImmutableList1;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof CrashlyticsReport.Session.Event.Application.Execution))
    {
      paramObject = (CrashlyticsReport.Session.Event.Application.Execution)paramObject;
      if ((!this.threads.equals(((CrashlyticsReport.Session.Event.Application.Execution)paramObject).getThreads())) || (!this.exception.equals(((CrashlyticsReport.Session.Event.Application.Execution)paramObject).getException())) || (!this.signal.equals(((CrashlyticsReport.Session.Event.Application.Execution)paramObject).getSignal())) || (!this.binaries.equals(((CrashlyticsReport.Session.Event.Application.Execution)paramObject).getBinaries()))) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  @NonNull
  public ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.BinaryImage> getBinaries()
  {
    return this.binaries;
  }
  
  @NonNull
  public CrashlyticsReport.Session.Event.Application.Execution.Exception getException()
  {
    return this.exception;
  }
  
  @NonNull
  public CrashlyticsReport.Session.Event.Application.Execution.Signal getSignal()
  {
    return this.signal;
  }
  
  @NonNull
  public ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread> getThreads()
  {
    return this.threads;
  }
  
  public int hashCode()
  {
    return (((this.threads.hashCode() ^ 0xF4243) * 1000003 ^ this.exception.hashCode()) * 1000003 ^ this.signal.hashCode()) * 1000003 ^ this.binaries.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Execution{threads=");
    localStringBuilder.append(this.threads);
    localStringBuilder.append(", exception=");
    localStringBuilder.append(this.exception);
    localStringBuilder.append(", signal=");
    localStringBuilder.append(this.signal);
    localStringBuilder.append(", binaries=");
    localStringBuilder.append(this.binaries);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  static final class Builder
    extends CrashlyticsReport.Session.Event.Application.Execution.Builder
  {
    private ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.BinaryImage> binaries;
    private CrashlyticsReport.Session.Event.Application.Execution.Exception exception;
    private CrashlyticsReport.Session.Event.Application.Execution.Signal signal;
    private ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread> threads;
    
    public CrashlyticsReport.Session.Event.Application.Execution build()
    {
      Object localObject1 = this.threads;
      Object localObject2 = "";
      if (localObject1 == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("");
        ((StringBuilder)localObject1).append(" threads");
        localObject2 = ((StringBuilder)localObject1).toString();
      }
      localObject1 = localObject2;
      if (this.exception == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(" exception");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      localObject2 = localObject1;
      if (this.signal == null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" signal");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      localObject1 = localObject2;
      if (this.binaries == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(" binaries");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      if (((String)localObject1).isEmpty()) {
        return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution(this.threads, this.exception, this.signal, this.binaries, null);
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Missing required properties:");
      ((StringBuilder)localObject2).append((String)localObject1);
      throw new IllegalStateException(((StringBuilder)localObject2).toString());
    }
    
    public CrashlyticsReport.Session.Event.Application.Execution.Builder setBinaries(ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.BinaryImage> paramImmutableList)
    {
      Objects.requireNonNull(paramImmutableList, "Null binaries");
      this.binaries = paramImmutableList;
      return this;
    }
    
    public CrashlyticsReport.Session.Event.Application.Execution.Builder setException(CrashlyticsReport.Session.Event.Application.Execution.Exception paramException)
    {
      Objects.requireNonNull(paramException, "Null exception");
      this.exception = paramException;
      return this;
    }
    
    public CrashlyticsReport.Session.Event.Application.Execution.Builder setSignal(CrashlyticsReport.Session.Event.Application.Execution.Signal paramSignal)
    {
      Objects.requireNonNull(paramSignal, "Null signal");
      this.signal = paramSignal;
      return this;
    }
    
    public CrashlyticsReport.Session.Event.Application.Execution.Builder setThreads(ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread> paramImmutableList)
    {
      Objects.requireNonNull(paramImmutableList, "Null threads");
      this.threads = paramImmutableList;
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\crashlytics\internal\model\AutoValue_CrashlyticsReport_Session_Event_Application_Execution.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */