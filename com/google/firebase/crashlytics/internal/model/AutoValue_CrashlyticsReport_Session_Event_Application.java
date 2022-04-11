package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Objects;

final class AutoValue_CrashlyticsReport_Session_Event_Application
  extends CrashlyticsReport.Session.Event.Application
{
  private final Boolean background;
  private final ImmutableList<CrashlyticsReport.CustomAttribute> customAttributes;
  private final CrashlyticsReport.Session.Event.Application.Execution execution;
  private final int uiOrientation;
  
  private AutoValue_CrashlyticsReport_Session_Event_Application(CrashlyticsReport.Session.Event.Application.Execution paramExecution, @Nullable ImmutableList<CrashlyticsReport.CustomAttribute> paramImmutableList, @Nullable Boolean paramBoolean, int paramInt)
  {
    this.execution = paramExecution;
    this.customAttributes = paramImmutableList;
    this.background = paramBoolean;
    this.uiOrientation = paramInt;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof CrashlyticsReport.Session.Event.Application))
    {
      paramObject = (CrashlyticsReport.Session.Event.Application)paramObject;
      if (this.execution.equals(((CrashlyticsReport.Session.Event.Application)paramObject).getExecution()))
      {
        Object localObject = this.customAttributes;
        if (localObject == null ? ((CrashlyticsReport.Session.Event.Application)paramObject).getCustomAttributes() == null : ((ImmutableList)localObject).equals(((CrashlyticsReport.Session.Event.Application)paramObject).getCustomAttributes()))
        {
          localObject = this.background;
          if ((localObject == null ? ((CrashlyticsReport.Session.Event.Application)paramObject).getBackground() == null : ((Boolean)localObject).equals(((CrashlyticsReport.Session.Event.Application)paramObject).getBackground())) && (this.uiOrientation == ((CrashlyticsReport.Session.Event.Application)paramObject).getUiOrientation())) {
            break label111;
          }
        }
      }
      bool = false;
      label111:
      return bool;
    }
    return false;
  }
  
  @Nullable
  public Boolean getBackground()
  {
    return this.background;
  }
  
  @Nullable
  public ImmutableList<CrashlyticsReport.CustomAttribute> getCustomAttributes()
  {
    return this.customAttributes;
  }
  
  @NonNull
  public CrashlyticsReport.Session.Event.Application.Execution getExecution()
  {
    return this.execution;
  }
  
  public int getUiOrientation()
  {
    return this.uiOrientation;
  }
  
  public int hashCode()
  {
    int i = this.execution.hashCode();
    Object localObject = this.customAttributes;
    int j = 0;
    int k;
    if (localObject == null) {
      k = 0;
    } else {
      k = ((ImmutableList)localObject).hashCode();
    }
    localObject = this.background;
    if (localObject != null) {
      j = ((Boolean)localObject).hashCode();
    }
    return (((i ^ 0xF4243) * 1000003 ^ k) * 1000003 ^ j) * 1000003 ^ this.uiOrientation;
  }
  
  public CrashlyticsReport.Session.Event.Application.Builder toBuilder()
  {
    return new Builder(this, null);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Application{execution=");
    localStringBuilder.append(this.execution);
    localStringBuilder.append(", customAttributes=");
    localStringBuilder.append(this.customAttributes);
    localStringBuilder.append(", background=");
    localStringBuilder.append(this.background);
    localStringBuilder.append(", uiOrientation=");
    localStringBuilder.append(this.uiOrientation);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  static final class Builder
    extends CrashlyticsReport.Session.Event.Application.Builder
  {
    private Boolean background;
    private ImmutableList<CrashlyticsReport.CustomAttribute> customAttributes;
    private CrashlyticsReport.Session.Event.Application.Execution execution;
    private Integer uiOrientation;
    
    Builder() {}
    
    private Builder(CrashlyticsReport.Session.Event.Application paramApplication)
    {
      this.execution = paramApplication.getExecution();
      this.customAttributes = paramApplication.getCustomAttributes();
      this.background = paramApplication.getBackground();
      this.uiOrientation = Integer.valueOf(paramApplication.getUiOrientation());
    }
    
    public CrashlyticsReport.Session.Event.Application build()
    {
      Object localObject1 = this.execution;
      Object localObject2 = "";
      if (localObject1 == null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(" execution");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      localObject1 = localObject2;
      if (this.uiOrientation == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(" uiOrientation");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      if (((String)localObject1).isEmpty()) {
        return new AutoValue_CrashlyticsReport_Session_Event_Application(this.execution, this.customAttributes, this.background, this.uiOrientation.intValue(), null);
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Missing required properties:");
      ((StringBuilder)localObject2).append((String)localObject1);
      throw new IllegalStateException(((StringBuilder)localObject2).toString());
    }
    
    public CrashlyticsReport.Session.Event.Application.Builder setBackground(@Nullable Boolean paramBoolean)
    {
      this.background = paramBoolean;
      return this;
    }
    
    public CrashlyticsReport.Session.Event.Application.Builder setCustomAttributes(ImmutableList<CrashlyticsReport.CustomAttribute> paramImmutableList)
    {
      this.customAttributes = paramImmutableList;
      return this;
    }
    
    public CrashlyticsReport.Session.Event.Application.Builder setExecution(CrashlyticsReport.Session.Event.Application.Execution paramExecution)
    {
      Objects.requireNonNull(paramExecution, "Null execution");
      this.execution = paramExecution;
      return this;
    }
    
    public CrashlyticsReport.Session.Event.Application.Builder setUiOrientation(int paramInt)
    {
      this.uiOrientation = Integer.valueOf(paramInt);
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\crashlytics\internal\model\AutoValue_CrashlyticsReport_Session_Event_Application.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */