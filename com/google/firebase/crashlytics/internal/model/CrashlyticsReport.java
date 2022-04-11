package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.auto.value.AutoValue;
import com.google.auto.value.AutoValue.Builder;
import com.google.firebase.encoders.annotations.Encodable;
import com.google.firebase.encoders.annotations.Encodable.Field;
import com.google.firebase.encoders.annotations.Encodable.Ignore;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.charset.Charset;

@Encodable
@AutoValue
public abstract class CrashlyticsReport
{
  public static final String DEVELOPMENT_PLATFORM_UNITY = "Unity";
  private static final Charset UTF_8 = Charset.forName("UTF-8");
  
  @NonNull
  public static Builder builder()
  {
    return new AutoValue_CrashlyticsReport.Builder();
  }
  
  @NonNull
  public abstract String getBuildVersion();
  
  @NonNull
  public abstract String getDisplayVersion();
  
  @NonNull
  public abstract String getGmpAppId();
  
  @NonNull
  public abstract String getInstallationUuid();
  
  @Nullable
  public abstract FilesPayload getNdkPayload();
  
  public abstract int getPlatform();
  
  @NonNull
  public abstract String getSdkVersion();
  
  @Nullable
  public abstract Session getSession();
  
  @Encodable.Ignore
  public Type getType()
  {
    if (getSession() != null) {
      return Type.JAVA;
    }
    if (getNdkPayload() != null) {
      return Type.NATIVE;
    }
    return Type.INCOMPLETE;
  }
  
  @NonNull
  protected abstract Builder toBuilder();
  
  @NonNull
  public CrashlyticsReport withEvents(@NonNull ImmutableList<CrashlyticsReport.Session.Event> paramImmutableList)
  {
    if (getSession() != null) {
      return toBuilder().setSession(getSession().withEvents(paramImmutableList)).build();
    }
    throw new IllegalStateException("Reports without sessions cannot have events added to them.");
  }
  
  @NonNull
  public CrashlyticsReport withNdkPayload(@NonNull FilesPayload paramFilesPayload)
  {
    return toBuilder().setSession(null).setNdkPayload(paramFilesPayload).build();
  }
  
  @NonNull
  public CrashlyticsReport withOrganizationId(@NonNull String paramString)
  {
    Builder localBuilder = toBuilder();
    Object localObject = getNdkPayload();
    if (localObject != null) {
      localBuilder.setNdkPayload(((FilesPayload)localObject).toBuilder().setOrgId(paramString).build());
    }
    localObject = getSession();
    if (localObject != null) {
      localBuilder.setSession(((Session)localObject).withOrganizationId(paramString));
    }
    return localBuilder.build();
  }
  
  @NonNull
  public CrashlyticsReport withSessionEndFields(long paramLong, boolean paramBoolean, @Nullable String paramString)
  {
    Builder localBuilder = toBuilder();
    if (getSession() != null) {
      localBuilder.setSession(getSession().withSessionEndFields(paramLong, paramBoolean, paramString));
    }
    return localBuilder.build();
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface Architecture
  {
    public static final int ARM64 = 9;
    public static final int ARMV6 = 5;
    public static final int ARMV7 = 6;
    public static final int UNKNOWN = 7;
    public static final int X86_32 = 0;
    public static final int X86_64 = 1;
  }
  
  @AutoValue.Builder
  public static abstract class Builder
  {
    @NonNull
    public abstract CrashlyticsReport build();
    
    @NonNull
    public abstract Builder setBuildVersion(@NonNull String paramString);
    
    @NonNull
    public abstract Builder setDisplayVersion(@NonNull String paramString);
    
    @NonNull
    public abstract Builder setGmpAppId(@NonNull String paramString);
    
    @NonNull
    public abstract Builder setInstallationUuid(@NonNull String paramString);
    
    @NonNull
    public abstract Builder setNdkPayload(CrashlyticsReport.FilesPayload paramFilesPayload);
    
    @NonNull
    public abstract Builder setPlatform(int paramInt);
    
    @NonNull
    public abstract Builder setSdkVersion(@NonNull String paramString);
    
    @NonNull
    public abstract Builder setSession(@NonNull CrashlyticsReport.Session paramSession);
  }
  
  @AutoValue
  public static abstract class CustomAttribute
  {
    @NonNull
    public static Builder builder()
    {
      return new AutoValue_CrashlyticsReport_CustomAttribute.Builder();
    }
    
    @NonNull
    public abstract String getKey();
    
    @NonNull
    public abstract String getValue();
    
    @AutoValue.Builder
    public static abstract class Builder
    {
      @NonNull
      public abstract CrashlyticsReport.CustomAttribute build();
      
      @NonNull
      public abstract Builder setKey(@NonNull String paramString);
      
      @NonNull
      public abstract Builder setValue(@NonNull String paramString);
    }
  }
  
  @AutoValue
  public static abstract class FilesPayload
  {
    @NonNull
    public static Builder builder()
    {
      return new AutoValue_CrashlyticsReport_FilesPayload.Builder();
    }
    
    @NonNull
    public abstract ImmutableList<File> getFiles();
    
    @Nullable
    public abstract String getOrgId();
    
    abstract Builder toBuilder();
    
    @AutoValue.Builder
    public static abstract class Builder
    {
      public abstract CrashlyticsReport.FilesPayload build();
      
      public abstract Builder setFiles(ImmutableList<CrashlyticsReport.FilesPayload.File> paramImmutableList);
      
      public abstract Builder setOrgId(String paramString);
    }
    
    @AutoValue
    public static abstract class File
    {
      @NonNull
      public static Builder builder()
      {
        return new AutoValue_CrashlyticsReport_FilesPayload_File.Builder();
      }
      
      @NonNull
      public abstract byte[] getContents();
      
      @NonNull
      public abstract String getFilename();
      
      @AutoValue.Builder
      public static abstract class Builder
      {
        public abstract CrashlyticsReport.FilesPayload.File build();
        
        public abstract Builder setContents(byte[] paramArrayOfByte);
        
        public abstract Builder setFilename(String paramString);
      }
    }
  }
  
  @AutoValue
  public static abstract class Session
  {
    @NonNull
    public static Builder builder()
    {
      return new AutoValue_CrashlyticsReport_Session.Builder().setCrashed(false);
    }
    
    @NonNull
    public abstract Application getApp();
    
    @Nullable
    public abstract Device getDevice();
    
    @Nullable
    public abstract Long getEndedAt();
    
    @Nullable
    public abstract ImmutableList<Event> getEvents();
    
    @NonNull
    public abstract String getGenerator();
    
    public abstract int getGeneratorType();
    
    @Encodable.Ignore
    @NonNull
    public abstract String getIdentifier();
    
    @Encodable.Field(name="identifier")
    @NonNull
    public byte[] getIdentifierUtf8Bytes()
    {
      return getIdentifier().getBytes(CrashlyticsReport.UTF_8);
    }
    
    @Nullable
    public abstract OperatingSystem getOs();
    
    public abstract long getStartedAt();
    
    @Nullable
    public abstract User getUser();
    
    public abstract boolean isCrashed();
    
    @NonNull
    public abstract Builder toBuilder();
    
    @NonNull
    Session withEvents(@NonNull ImmutableList<Event> paramImmutableList)
    {
      return toBuilder().setEvents(paramImmutableList).build();
    }
    
    @NonNull
    Session withOrganizationId(@NonNull String paramString)
    {
      paramString = getApp().withOrganizationId(paramString);
      return toBuilder().setApp(paramString).build();
    }
    
    @NonNull
    Session withSessionEndFields(long paramLong, boolean paramBoolean, @Nullable String paramString)
    {
      Builder localBuilder = toBuilder();
      localBuilder.setEndedAt(Long.valueOf(paramLong));
      localBuilder.setCrashed(paramBoolean);
      if (paramString != null) {
        localBuilder.setUser(User.builder().setIdentifier(paramString).build()).build();
      }
      return localBuilder.build();
    }
    
    @AutoValue
    public static abstract class Application
    {
      @NonNull
      public static Builder builder()
      {
        return new AutoValue_CrashlyticsReport_Session_Application.Builder();
      }
      
      @Nullable
      public abstract String getDevelopmentPlatform();
      
      @Nullable
      public abstract String getDevelopmentPlatformVersion();
      
      @Nullable
      public abstract String getDisplayVersion();
      
      @NonNull
      public abstract String getIdentifier();
      
      @Nullable
      public abstract String getInstallationUuid();
      
      @Nullable
      public abstract Organization getOrganization();
      
      @NonNull
      public abstract String getVersion();
      
      @NonNull
      protected abstract Builder toBuilder();
      
      @NonNull
      Application withOrganizationId(@NonNull String paramString)
      {
        Object localObject = getOrganization();
        if (localObject != null) {
          localObject = ((Organization)localObject).toBuilder();
        } else {
          localObject = Organization.builder();
        }
        return toBuilder().setOrganization(((CrashlyticsReport.Session.Application.Organization.Builder)localObject).setClsId(paramString).build()).build();
      }
      
      @AutoValue.Builder
      public static abstract class Builder
      {
        @NonNull
        public abstract CrashlyticsReport.Session.Application build();
        
        @NonNull
        public abstract Builder setDevelopmentPlatform(@Nullable String paramString);
        
        @NonNull
        public abstract Builder setDevelopmentPlatformVersion(@Nullable String paramString);
        
        @NonNull
        public abstract Builder setDisplayVersion(@NonNull String paramString);
        
        @NonNull
        public abstract Builder setIdentifier(@NonNull String paramString);
        
        @NonNull
        public abstract Builder setInstallationUuid(@NonNull String paramString);
        
        @NonNull
        public abstract Builder setOrganization(@NonNull CrashlyticsReport.Session.Application.Organization paramOrganization);
        
        @NonNull
        public abstract Builder setVersion(@NonNull String paramString);
      }
      
      @AutoValue
      public static abstract class Organization
      {
        @NonNull
        public static Builder builder()
        {
          return new AutoValue_CrashlyticsReport_Session_Application_Organization.Builder();
        }
        
        @NonNull
        public abstract String getClsId();
        
        @NonNull
        protected abstract Builder toBuilder();
        
        @AutoValue.Builder
        public static abstract class Builder
        {
          @NonNull
          public abstract CrashlyticsReport.Session.Application.Organization build();
          
          @NonNull
          public abstract Builder setClsId(@NonNull String paramString);
        }
      }
    }
    
    @AutoValue.Builder
    public static abstract class Builder
    {
      @NonNull
      public abstract CrashlyticsReport.Session build();
      
      @NonNull
      public abstract Builder setApp(@NonNull CrashlyticsReport.Session.Application paramApplication);
      
      @NonNull
      public abstract Builder setCrashed(boolean paramBoolean);
      
      @NonNull
      public abstract Builder setDevice(@NonNull CrashlyticsReport.Session.Device paramDevice);
      
      @NonNull
      public abstract Builder setEndedAt(@NonNull Long paramLong);
      
      @NonNull
      public abstract Builder setEvents(@NonNull ImmutableList<CrashlyticsReport.Session.Event> paramImmutableList);
      
      @NonNull
      public abstract Builder setGenerator(@NonNull String paramString);
      
      @NonNull
      public abstract Builder setGeneratorType(int paramInt);
      
      @NonNull
      public abstract Builder setIdentifier(@NonNull String paramString);
      
      @NonNull
      public Builder setIdentifierFromUtf8Bytes(@NonNull byte[] paramArrayOfByte)
      {
        return setIdentifier(new String(paramArrayOfByte, CrashlyticsReport.UTF_8));
      }
      
      @NonNull
      public abstract Builder setOs(@NonNull CrashlyticsReport.Session.OperatingSystem paramOperatingSystem);
      
      @NonNull
      public abstract Builder setStartedAt(long paramLong);
      
      @NonNull
      public abstract Builder setUser(@NonNull CrashlyticsReport.Session.User paramUser);
    }
    
    @AutoValue
    public static abstract class Device
    {
      @NonNull
      public static Builder builder()
      {
        return new AutoValue_CrashlyticsReport_Session_Device.Builder();
      }
      
      @NonNull
      public abstract int getArch();
      
      public abstract int getCores();
      
      public abstract long getDiskSpace();
      
      @NonNull
      public abstract String getManufacturer();
      
      @NonNull
      public abstract String getModel();
      
      @NonNull
      public abstract String getModelClass();
      
      public abstract long getRam();
      
      public abstract int getState();
      
      public abstract boolean isSimulator();
      
      @AutoValue.Builder
      public static abstract class Builder
      {
        @NonNull
        public abstract CrashlyticsReport.Session.Device build();
        
        @NonNull
        public abstract Builder setArch(int paramInt);
        
        @NonNull
        public abstract Builder setCores(int paramInt);
        
        @NonNull
        public abstract Builder setDiskSpace(long paramLong);
        
        @NonNull
        public abstract Builder setManufacturer(@NonNull String paramString);
        
        @NonNull
        public abstract Builder setModel(@NonNull String paramString);
        
        @NonNull
        public abstract Builder setModelClass(@NonNull String paramString);
        
        @NonNull
        public abstract Builder setRam(long paramLong);
        
        @NonNull
        public abstract Builder setSimulator(boolean paramBoolean);
        
        @NonNull
        public abstract Builder setState(int paramInt);
      }
    }
    
    @AutoValue
    public static abstract class Event
    {
      @NonNull
      public static Builder builder()
      {
        return new AutoValue_CrashlyticsReport_Session_Event.Builder();
      }
      
      @NonNull
      public abstract Application getApp();
      
      @NonNull
      public abstract Device getDevice();
      
      @Nullable
      public abstract Log getLog();
      
      public abstract long getTimestamp();
      
      @NonNull
      public abstract String getType();
      
      @NonNull
      public abstract Builder toBuilder();
      
      @AutoValue
      public static abstract class Application
      {
        @NonNull
        public static Builder builder()
        {
          return new AutoValue_CrashlyticsReport_Session_Event_Application.Builder();
        }
        
        @Nullable
        public abstract Boolean getBackground();
        
        @Nullable
        public abstract ImmutableList<CrashlyticsReport.CustomAttribute> getCustomAttributes();
        
        @NonNull
        public abstract Execution getExecution();
        
        public abstract int getUiOrientation();
        
        @NonNull
        public abstract Builder toBuilder();
        
        @AutoValue.Builder
        public static abstract class Builder
        {
          @NonNull
          public abstract CrashlyticsReport.Session.Event.Application build();
          
          @NonNull
          public abstract Builder setBackground(@Nullable Boolean paramBoolean);
          
          @NonNull
          public abstract Builder setCustomAttributes(@NonNull ImmutableList<CrashlyticsReport.CustomAttribute> paramImmutableList);
          
          @NonNull
          public abstract Builder setExecution(@NonNull CrashlyticsReport.Session.Event.Application.Execution paramExecution);
          
          @NonNull
          public abstract Builder setUiOrientation(int paramInt);
        }
        
        @AutoValue
        public static abstract class Execution
        {
          @NonNull
          public static Builder builder()
          {
            return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution.Builder();
          }
          
          @NonNull
          public abstract ImmutableList<BinaryImage> getBinaries();
          
          @NonNull
          public abstract Exception getException();
          
          @NonNull
          public abstract Signal getSignal();
          
          @NonNull
          public abstract ImmutableList<Thread> getThreads();
          
          @AutoValue
          public static abstract class BinaryImage
          {
            @NonNull
            public static Builder builder()
            {
              return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage.Builder();
            }
            
            @NonNull
            public abstract long getBaseAddress();
            
            @NonNull
            public abstract String getName();
            
            public abstract long getSize();
            
            @Encodable.Ignore
            @Nullable
            public abstract String getUuid();
            
            @Encodable.Field(name="uuid")
            @Nullable
            public byte[] getUuidUtf8Bytes()
            {
              Object localObject = getUuid();
              if (localObject != null) {
                localObject = ((String)localObject).getBytes(CrashlyticsReport.UTF_8);
              } else {
                localObject = null;
              }
              return (byte[])localObject;
            }
            
            @AutoValue.Builder
            public static abstract class Builder
            {
              @NonNull
              public abstract CrashlyticsReport.Session.Event.Application.Execution.BinaryImage build();
              
              @NonNull
              public abstract Builder setBaseAddress(long paramLong);
              
              @NonNull
              public abstract Builder setName(@NonNull String paramString);
              
              @NonNull
              public abstract Builder setSize(long paramLong);
              
              @NonNull
              public abstract Builder setUuid(@Nullable String paramString);
              
              @NonNull
              public Builder setUuidFromUtf8Bytes(@NonNull byte[] paramArrayOfByte)
              {
                return setUuid(new String(paramArrayOfByte, CrashlyticsReport.UTF_8));
              }
            }
          }
          
          @AutoValue.Builder
          public static abstract class Builder
          {
            @NonNull
            public abstract CrashlyticsReport.Session.Event.Application.Execution build();
            
            @NonNull
            public abstract Builder setBinaries(@NonNull ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.BinaryImage> paramImmutableList);
            
            @NonNull
            public abstract Builder setException(@NonNull CrashlyticsReport.Session.Event.Application.Execution.Exception paramException);
            
            @NonNull
            public abstract Builder setSignal(@NonNull CrashlyticsReport.Session.Event.Application.Execution.Signal paramSignal);
            
            @NonNull
            public abstract Builder setThreads(@NonNull ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread> paramImmutableList);
          }
          
          @AutoValue
          public static abstract class Exception
          {
            @NonNull
            public static Builder builder()
            {
              return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception.Builder();
            }
            
            @Nullable
            public abstract Exception getCausedBy();
            
            @NonNull
            public abstract ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame> getFrames();
            
            public abstract int getOverflowCount();
            
            @Nullable
            public abstract String getReason();
            
            @NonNull
            public abstract String getType();
            
            @AutoValue.Builder
            public static abstract class Builder
            {
              @NonNull
              public abstract CrashlyticsReport.Session.Event.Application.Execution.Exception build();
              
              @NonNull
              public abstract Builder setCausedBy(@NonNull CrashlyticsReport.Session.Event.Application.Execution.Exception paramException);
              
              @NonNull
              public abstract Builder setFrames(@NonNull ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame> paramImmutableList);
              
              @NonNull
              public abstract Builder setOverflowCount(int paramInt);
              
              @NonNull
              public abstract Builder setReason(@NonNull String paramString);
              
              @NonNull
              public abstract Builder setType(@NonNull String paramString);
            }
          }
          
          @AutoValue
          public static abstract class Signal
          {
            @NonNull
            public static Builder builder()
            {
              return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal.Builder();
            }
            
            @NonNull
            public abstract long getAddress();
            
            @NonNull
            public abstract String getCode();
            
            @NonNull
            public abstract String getName();
            
            @AutoValue.Builder
            public static abstract class Builder
            {
              @NonNull
              public abstract CrashlyticsReport.Session.Event.Application.Execution.Signal build();
              
              @NonNull
              public abstract Builder setAddress(long paramLong);
              
              @NonNull
              public abstract Builder setCode(@NonNull String paramString);
              
              @NonNull
              public abstract Builder setName(@NonNull String paramString);
            }
          }
          
          @AutoValue
          public static abstract class Thread
          {
            @NonNull
            public static Builder builder()
            {
              return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread.Builder();
            }
            
            @NonNull
            public abstract ImmutableList<Frame> getFrames();
            
            public abstract int getImportance();
            
            @NonNull
            public abstract String getName();
            
            @AutoValue.Builder
            public static abstract class Builder
            {
              @NonNull
              public abstract CrashlyticsReport.Session.Event.Application.Execution.Thread build();
              
              @NonNull
              public abstract Builder setFrames(@NonNull ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame> paramImmutableList);
              
              @NonNull
              public abstract Builder setImportance(int paramInt);
              
              @NonNull
              public abstract Builder setName(@NonNull String paramString);
            }
            
            @AutoValue
            public static abstract class Frame
            {
              @NonNull
              public static Builder builder()
              {
                return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame.Builder();
              }
              
              @Nullable
              public abstract String getFile();
              
              public abstract int getImportance();
              
              public abstract long getOffset();
              
              public abstract long getPc();
              
              @NonNull
              public abstract String getSymbol();
              
              @AutoValue.Builder
              public static abstract class Builder
              {
                @NonNull
                public abstract CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame build();
                
                @NonNull
                public abstract Builder setFile(@NonNull String paramString);
                
                @NonNull
                public abstract Builder setImportance(int paramInt);
                
                @NonNull
                public abstract Builder setOffset(long paramLong);
                
                @NonNull
                public abstract Builder setPc(long paramLong);
                
                @NonNull
                public abstract Builder setSymbol(@NonNull String paramString);
              }
            }
          }
        }
      }
      
      @AutoValue.Builder
      public static abstract class Builder
      {
        @NonNull
        public abstract CrashlyticsReport.Session.Event build();
        
        @NonNull
        public abstract Builder setApp(@NonNull CrashlyticsReport.Session.Event.Application paramApplication);
        
        @NonNull
        public abstract Builder setDevice(@NonNull CrashlyticsReport.Session.Event.Device paramDevice);
        
        @NonNull
        public abstract Builder setLog(@NonNull CrashlyticsReport.Session.Event.Log paramLog);
        
        @NonNull
        public abstract Builder setTimestamp(long paramLong);
        
        @NonNull
        public abstract Builder setType(@NonNull String paramString);
      }
      
      @AutoValue
      public static abstract class Device
      {
        @NonNull
        public static Builder builder()
        {
          return new AutoValue_CrashlyticsReport_Session_Event_Device.Builder();
        }
        
        @Nullable
        public abstract Double getBatteryLevel();
        
        public abstract int getBatteryVelocity();
        
        public abstract long getDiskUsed();
        
        public abstract int getOrientation();
        
        public abstract long getRamUsed();
        
        public abstract boolean isProximityOn();
        
        @AutoValue.Builder
        public static abstract class Builder
        {
          @NonNull
          public abstract CrashlyticsReport.Session.Event.Device build();
          
          @NonNull
          public abstract Builder setBatteryLevel(Double paramDouble);
          
          @NonNull
          public abstract Builder setBatteryVelocity(int paramInt);
          
          @NonNull
          public abstract Builder setDiskUsed(long paramLong);
          
          @NonNull
          public abstract Builder setOrientation(int paramInt);
          
          @NonNull
          public abstract Builder setProximityOn(boolean paramBoolean);
          
          @NonNull
          public abstract Builder setRamUsed(long paramLong);
        }
      }
      
      @AutoValue
      public static abstract class Log
      {
        @NonNull
        public static Builder builder()
        {
          return new AutoValue_CrashlyticsReport_Session_Event_Log.Builder();
        }
        
        @NonNull
        public abstract String getContent();
        
        @AutoValue.Builder
        public static abstract class Builder
        {
          @NonNull
          public abstract CrashlyticsReport.Session.Event.Log build();
          
          @NonNull
          public abstract Builder setContent(@NonNull String paramString);
        }
      }
    }
    
    @AutoValue
    public static abstract class OperatingSystem
    {
      @NonNull
      public static Builder builder()
      {
        return new AutoValue_CrashlyticsReport_Session_OperatingSystem.Builder();
      }
      
      @NonNull
      public abstract String getBuildVersion();
      
      public abstract int getPlatform();
      
      @NonNull
      public abstract String getVersion();
      
      public abstract boolean isJailbroken();
      
      @AutoValue.Builder
      public static abstract class Builder
      {
        @NonNull
        public abstract CrashlyticsReport.Session.OperatingSystem build();
        
        @NonNull
        public abstract Builder setBuildVersion(@NonNull String paramString);
        
        @NonNull
        public abstract Builder setJailbroken(boolean paramBoolean);
        
        @NonNull
        public abstract Builder setPlatform(int paramInt);
        
        @NonNull
        public abstract Builder setVersion(@NonNull String paramString);
      }
    }
    
    @AutoValue
    public static abstract class User
    {
      @NonNull
      public static Builder builder()
      {
        return new AutoValue_CrashlyticsReport_Session_User.Builder();
      }
      
      @NonNull
      public abstract String getIdentifier();
      
      @AutoValue.Builder
      public static abstract class Builder
      {
        @NonNull
        public abstract CrashlyticsReport.Session.User build();
        
        @NonNull
        public abstract Builder setIdentifier(@NonNull String paramString);
      }
    }
  }
  
  public static enum Type
  {
    static
    {
      Type localType1 = new Type("INCOMPLETE", 0);
      INCOMPLETE = localType1;
      Type localType2 = new Type("JAVA", 1);
      JAVA = localType2;
      Type localType3 = new Type("NATIVE", 2);
      NATIVE = localType3;
      $VALUES = new Type[] { localType1, localType2, localType3 };
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\crashlytics\internal\model\CrashlyticsReport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */