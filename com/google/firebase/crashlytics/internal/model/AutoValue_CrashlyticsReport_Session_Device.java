package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import java.util.Objects;

final class AutoValue_CrashlyticsReport_Session_Device
  extends CrashlyticsReport.Session.Device
{
  private final int arch;
  private final int cores;
  private final long diskSpace;
  private final String manufacturer;
  private final String model;
  private final String modelClass;
  private final long ram;
  private final boolean simulator;
  private final int state;
  
  private AutoValue_CrashlyticsReport_Session_Device(int paramInt1, String paramString1, int paramInt2, long paramLong1, long paramLong2, boolean paramBoolean, int paramInt3, String paramString2, String paramString3)
  {
    this.arch = paramInt1;
    this.model = paramString1;
    this.cores = paramInt2;
    this.ram = paramLong1;
    this.diskSpace = paramLong2;
    this.simulator = paramBoolean;
    this.state = paramInt3;
    this.manufacturer = paramString2;
    this.modelClass = paramString3;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof CrashlyticsReport.Session.Device))
    {
      paramObject = (CrashlyticsReport.Session.Device)paramObject;
      if ((this.arch != ((CrashlyticsReport.Session.Device)paramObject).getArch()) || (!this.model.equals(((CrashlyticsReport.Session.Device)paramObject).getModel())) || (this.cores != ((CrashlyticsReport.Session.Device)paramObject).getCores()) || (this.ram != ((CrashlyticsReport.Session.Device)paramObject).getRam()) || (this.diskSpace != ((CrashlyticsReport.Session.Device)paramObject).getDiskSpace()) || (this.simulator != ((CrashlyticsReport.Session.Device)paramObject).isSimulator()) || (this.state != ((CrashlyticsReport.Session.Device)paramObject).getState()) || (!this.manufacturer.equals(((CrashlyticsReport.Session.Device)paramObject).getManufacturer())) || (!this.modelClass.equals(((CrashlyticsReport.Session.Device)paramObject).getModelClass()))) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  @NonNull
  public int getArch()
  {
    return this.arch;
  }
  
  public int getCores()
  {
    return this.cores;
  }
  
  public long getDiskSpace()
  {
    return this.diskSpace;
  }
  
  @NonNull
  public String getManufacturer()
  {
    return this.manufacturer;
  }
  
  @NonNull
  public String getModel()
  {
    return this.model;
  }
  
  @NonNull
  public String getModelClass()
  {
    return this.modelClass;
  }
  
  public long getRam()
  {
    return this.ram;
  }
  
  public int getState()
  {
    return this.state;
  }
  
  public int hashCode()
  {
    int i = this.arch;
    int j = this.model.hashCode();
    int k = this.cores;
    long l = this.ram;
    int m = (int)(l ^ l >>> 32);
    l = this.diskSpace;
    int n = (int)(l ^ l >>> 32);
    int i1;
    if (this.simulator) {
      i1 = 1231;
    } else {
      i1 = 1237;
    }
    return ((((((((i ^ 0xF4243) * 1000003 ^ j) * 1000003 ^ k) * 1000003 ^ m) * 1000003 ^ n) * 1000003 ^ i1) * 1000003 ^ this.state) * 1000003 ^ this.manufacturer.hashCode()) * 1000003 ^ this.modelClass.hashCode();
  }
  
  public boolean isSimulator()
  {
    return this.simulator;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Device{arch=");
    localStringBuilder.append(this.arch);
    localStringBuilder.append(", model=");
    localStringBuilder.append(this.model);
    localStringBuilder.append(", cores=");
    localStringBuilder.append(this.cores);
    localStringBuilder.append(", ram=");
    localStringBuilder.append(this.ram);
    localStringBuilder.append(", diskSpace=");
    localStringBuilder.append(this.diskSpace);
    localStringBuilder.append(", simulator=");
    localStringBuilder.append(this.simulator);
    localStringBuilder.append(", state=");
    localStringBuilder.append(this.state);
    localStringBuilder.append(", manufacturer=");
    localStringBuilder.append(this.manufacturer);
    localStringBuilder.append(", modelClass=");
    localStringBuilder.append(this.modelClass);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  static final class Builder
    extends CrashlyticsReport.Session.Device.Builder
  {
    private Integer arch;
    private Integer cores;
    private Long diskSpace;
    private String manufacturer;
    private String model;
    private String modelClass;
    private Long ram;
    private Boolean simulator;
    private Integer state;
    
    public CrashlyticsReport.Session.Device build()
    {
      Object localObject1 = this.arch;
      Object localObject2 = "";
      if (localObject1 == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("");
        ((StringBuilder)localObject1).append(" arch");
        localObject2 = ((StringBuilder)localObject1).toString();
      }
      localObject1 = localObject2;
      if (this.model == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(" model");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      localObject2 = localObject1;
      if (this.cores == null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" cores");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      localObject1 = localObject2;
      if (this.ram == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(" ram");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      localObject2 = localObject1;
      if (this.diskSpace == null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" diskSpace");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      localObject1 = localObject2;
      if (this.simulator == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(" simulator");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      localObject2 = localObject1;
      if (this.state == null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" state");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      localObject1 = localObject2;
      if (this.manufacturer == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(" manufacturer");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      localObject2 = localObject1;
      if (this.modelClass == null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" modelClass");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      if (((String)localObject2).isEmpty()) {
        return new AutoValue_CrashlyticsReport_Session_Device(this.arch.intValue(), this.model, this.cores.intValue(), this.ram.longValue(), this.diskSpace.longValue(), this.simulator.booleanValue(), this.state.intValue(), this.manufacturer, this.modelClass, null);
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Missing required properties:");
      ((StringBuilder)localObject1).append((String)localObject2);
      throw new IllegalStateException(((StringBuilder)localObject1).toString());
    }
    
    public CrashlyticsReport.Session.Device.Builder setArch(int paramInt)
    {
      this.arch = Integer.valueOf(paramInt);
      return this;
    }
    
    public CrashlyticsReport.Session.Device.Builder setCores(int paramInt)
    {
      this.cores = Integer.valueOf(paramInt);
      return this;
    }
    
    public CrashlyticsReport.Session.Device.Builder setDiskSpace(long paramLong)
    {
      this.diskSpace = Long.valueOf(paramLong);
      return this;
    }
    
    public CrashlyticsReport.Session.Device.Builder setManufacturer(String paramString)
    {
      Objects.requireNonNull(paramString, "Null manufacturer");
      this.manufacturer = paramString;
      return this;
    }
    
    public CrashlyticsReport.Session.Device.Builder setModel(String paramString)
    {
      Objects.requireNonNull(paramString, "Null model");
      this.model = paramString;
      return this;
    }
    
    public CrashlyticsReport.Session.Device.Builder setModelClass(String paramString)
    {
      Objects.requireNonNull(paramString, "Null modelClass");
      this.modelClass = paramString;
      return this;
    }
    
    public CrashlyticsReport.Session.Device.Builder setRam(long paramLong)
    {
      this.ram = Long.valueOf(paramLong);
      return this;
    }
    
    public CrashlyticsReport.Session.Device.Builder setSimulator(boolean paramBoolean)
    {
      this.simulator = Boolean.valueOf(paramBoolean);
      return this;
    }
    
    public CrashlyticsReport.Session.Device.Builder setState(int paramInt)
    {
      this.state = Integer.valueOf(paramInt);
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\crashlytics\internal\model\AutoValue_CrashlyticsReport_Session_Device.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */