package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.encoders.config.EncoderConfig;
import java.io.IOException;

public final class AutoCrashlyticsReportEncoder
  implements Configurator
{
  public static final int CODEGEN_VERSION = 2;
  public static final Configurator CONFIG = new AutoCrashlyticsReportEncoder();
  
  public void configure(EncoderConfig<?> paramEncoderConfig)
  {
    Object localObject = CrashlyticsReportEncoder.INSTANCE;
    paramEncoderConfig.registerEncoder(CrashlyticsReport.class, (ObjectEncoder)localObject);
    paramEncoderConfig.registerEncoder(AutoValue_CrashlyticsReport.class, (ObjectEncoder)localObject);
    localObject = CrashlyticsReportSessionEncoder.INSTANCE;
    paramEncoderConfig.registerEncoder(CrashlyticsReport.Session.class, (ObjectEncoder)localObject);
    paramEncoderConfig.registerEncoder(AutoValue_CrashlyticsReport_Session.class, (ObjectEncoder)localObject);
    localObject = CrashlyticsReportSessionApplicationEncoder.INSTANCE;
    paramEncoderConfig.registerEncoder(CrashlyticsReport.Session.Application.class, (ObjectEncoder)localObject);
    paramEncoderConfig.registerEncoder(AutoValue_CrashlyticsReport_Session_Application.class, (ObjectEncoder)localObject);
    localObject = CrashlyticsReportSessionApplicationOrganizationEncoder.INSTANCE;
    paramEncoderConfig.registerEncoder(CrashlyticsReport.Session.Application.Organization.class, (ObjectEncoder)localObject);
    paramEncoderConfig.registerEncoder(AutoValue_CrashlyticsReport_Session_Application_Organization.class, (ObjectEncoder)localObject);
    localObject = CrashlyticsReportSessionUserEncoder.INSTANCE;
    paramEncoderConfig.registerEncoder(CrashlyticsReport.Session.User.class, (ObjectEncoder)localObject);
    paramEncoderConfig.registerEncoder(AutoValue_CrashlyticsReport_Session_User.class, (ObjectEncoder)localObject);
    localObject = CrashlyticsReportSessionOperatingSystemEncoder.INSTANCE;
    paramEncoderConfig.registerEncoder(CrashlyticsReport.Session.OperatingSystem.class, (ObjectEncoder)localObject);
    paramEncoderConfig.registerEncoder(AutoValue_CrashlyticsReport_Session_OperatingSystem.class, (ObjectEncoder)localObject);
    localObject = CrashlyticsReportSessionDeviceEncoder.INSTANCE;
    paramEncoderConfig.registerEncoder(CrashlyticsReport.Session.Device.class, (ObjectEncoder)localObject);
    paramEncoderConfig.registerEncoder(AutoValue_CrashlyticsReport_Session_Device.class, (ObjectEncoder)localObject);
    localObject = CrashlyticsReportSessionEventEncoder.INSTANCE;
    paramEncoderConfig.registerEncoder(CrashlyticsReport.Session.Event.class, (ObjectEncoder)localObject);
    paramEncoderConfig.registerEncoder(AutoValue_CrashlyticsReport_Session_Event.class, (ObjectEncoder)localObject);
    localObject = CrashlyticsReportSessionEventApplicationEncoder.INSTANCE;
    paramEncoderConfig.registerEncoder(CrashlyticsReport.Session.Event.Application.class, (ObjectEncoder)localObject);
    paramEncoderConfig.registerEncoder(AutoValue_CrashlyticsReport_Session_Event_Application.class, (ObjectEncoder)localObject);
    localObject = CrashlyticsReportSessionEventApplicationExecutionEncoder.INSTANCE;
    paramEncoderConfig.registerEncoder(CrashlyticsReport.Session.Event.Application.Execution.class, (ObjectEncoder)localObject);
    paramEncoderConfig.registerEncoder(AutoValue_CrashlyticsReport_Session_Event_Application_Execution.class, (ObjectEncoder)localObject);
    localObject = CrashlyticsReportSessionEventApplicationExecutionThreadEncoder.INSTANCE;
    paramEncoderConfig.registerEncoder(CrashlyticsReport.Session.Event.Application.Execution.Thread.class, (ObjectEncoder)localObject);
    paramEncoderConfig.registerEncoder(AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread.class, (ObjectEncoder)localObject);
    localObject = CrashlyticsReportSessionEventApplicationExecutionThreadFrameEncoder.INSTANCE;
    paramEncoderConfig.registerEncoder(CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.class, (ObjectEncoder)localObject);
    paramEncoderConfig.registerEncoder(AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame.class, (ObjectEncoder)localObject);
    localObject = CrashlyticsReportSessionEventApplicationExecutionExceptionEncoder.INSTANCE;
    paramEncoderConfig.registerEncoder(CrashlyticsReport.Session.Event.Application.Execution.Exception.class, (ObjectEncoder)localObject);
    paramEncoderConfig.registerEncoder(AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception.class, (ObjectEncoder)localObject);
    localObject = CrashlyticsReportSessionEventApplicationExecutionSignalEncoder.INSTANCE;
    paramEncoderConfig.registerEncoder(CrashlyticsReport.Session.Event.Application.Execution.Signal.class, (ObjectEncoder)localObject);
    paramEncoderConfig.registerEncoder(AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal.class, (ObjectEncoder)localObject);
    localObject = CrashlyticsReportSessionEventApplicationExecutionBinaryImageEncoder.INSTANCE;
    paramEncoderConfig.registerEncoder(CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.class, (ObjectEncoder)localObject);
    paramEncoderConfig.registerEncoder(AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage.class, (ObjectEncoder)localObject);
    localObject = CrashlyticsReportCustomAttributeEncoder.INSTANCE;
    paramEncoderConfig.registerEncoder(CrashlyticsReport.CustomAttribute.class, (ObjectEncoder)localObject);
    paramEncoderConfig.registerEncoder(AutoValue_CrashlyticsReport_CustomAttribute.class, (ObjectEncoder)localObject);
    localObject = CrashlyticsReportSessionEventDeviceEncoder.INSTANCE;
    paramEncoderConfig.registerEncoder(CrashlyticsReport.Session.Event.Device.class, (ObjectEncoder)localObject);
    paramEncoderConfig.registerEncoder(AutoValue_CrashlyticsReport_Session_Event_Device.class, (ObjectEncoder)localObject);
    localObject = CrashlyticsReportSessionEventLogEncoder.INSTANCE;
    paramEncoderConfig.registerEncoder(CrashlyticsReport.Session.Event.Log.class, (ObjectEncoder)localObject);
    paramEncoderConfig.registerEncoder(AutoValue_CrashlyticsReport_Session_Event_Log.class, (ObjectEncoder)localObject);
    localObject = CrashlyticsReportFilesPayloadEncoder.INSTANCE;
    paramEncoderConfig.registerEncoder(CrashlyticsReport.FilesPayload.class, (ObjectEncoder)localObject);
    paramEncoderConfig.registerEncoder(AutoValue_CrashlyticsReport_FilesPayload.class, (ObjectEncoder)localObject);
    localObject = CrashlyticsReportFilesPayloadFileEncoder.INSTANCE;
    paramEncoderConfig.registerEncoder(CrashlyticsReport.FilesPayload.File.class, (ObjectEncoder)localObject);
    paramEncoderConfig.registerEncoder(AutoValue_CrashlyticsReport_FilesPayload_File.class, (ObjectEncoder)localObject);
  }
  
  private static final class CrashlyticsReportCustomAttributeEncoder
    implements ObjectEncoder<CrashlyticsReport.CustomAttribute>
  {
    static final CrashlyticsReportCustomAttributeEncoder INSTANCE = new CrashlyticsReportCustomAttributeEncoder();
    private static final FieldDescriptor KEY_DESCRIPTOR = FieldDescriptor.of("key");
    private static final FieldDescriptor VALUE_DESCRIPTOR = FieldDescriptor.of("value");
    
    public void encode(CrashlyticsReport.CustomAttribute paramCustomAttribute, ObjectEncoderContext paramObjectEncoderContext)
      throws IOException
    {
      paramObjectEncoderContext.add(KEY_DESCRIPTOR, paramCustomAttribute.getKey());
      paramObjectEncoderContext.add(VALUE_DESCRIPTOR, paramCustomAttribute.getValue());
    }
  }
  
  private static final class CrashlyticsReportEncoder
    implements ObjectEncoder<CrashlyticsReport>
  {
    private static final FieldDescriptor BUILDVERSION_DESCRIPTOR;
    private static final FieldDescriptor DISPLAYVERSION_DESCRIPTOR;
    private static final FieldDescriptor GMPAPPID_DESCRIPTOR;
    private static final FieldDescriptor INSTALLATIONUUID_DESCRIPTOR;
    static final CrashlyticsReportEncoder INSTANCE = new CrashlyticsReportEncoder();
    private static final FieldDescriptor NDKPAYLOAD_DESCRIPTOR = FieldDescriptor.of("ndkPayload");
    private static final FieldDescriptor PLATFORM_DESCRIPTOR;
    private static final FieldDescriptor SDKVERSION_DESCRIPTOR = FieldDescriptor.of("sdkVersion");
    private static final FieldDescriptor SESSION_DESCRIPTOR;
    
    static
    {
      GMPAPPID_DESCRIPTOR = FieldDescriptor.of("gmpAppId");
      PLATFORM_DESCRIPTOR = FieldDescriptor.of("platform");
      INSTALLATIONUUID_DESCRIPTOR = FieldDescriptor.of("installationUuid");
      BUILDVERSION_DESCRIPTOR = FieldDescriptor.of("buildVersion");
      DISPLAYVERSION_DESCRIPTOR = FieldDescriptor.of("displayVersion");
      SESSION_DESCRIPTOR = FieldDescriptor.of("session");
    }
    
    public void encode(CrashlyticsReport paramCrashlyticsReport, ObjectEncoderContext paramObjectEncoderContext)
      throws IOException
    {
      paramObjectEncoderContext.add(SDKVERSION_DESCRIPTOR, paramCrashlyticsReport.getSdkVersion());
      paramObjectEncoderContext.add(GMPAPPID_DESCRIPTOR, paramCrashlyticsReport.getGmpAppId());
      paramObjectEncoderContext.add(PLATFORM_DESCRIPTOR, paramCrashlyticsReport.getPlatform());
      paramObjectEncoderContext.add(INSTALLATIONUUID_DESCRIPTOR, paramCrashlyticsReport.getInstallationUuid());
      paramObjectEncoderContext.add(BUILDVERSION_DESCRIPTOR, paramCrashlyticsReport.getBuildVersion());
      paramObjectEncoderContext.add(DISPLAYVERSION_DESCRIPTOR, paramCrashlyticsReport.getDisplayVersion());
      paramObjectEncoderContext.add(SESSION_DESCRIPTOR, paramCrashlyticsReport.getSession());
      paramObjectEncoderContext.add(NDKPAYLOAD_DESCRIPTOR, paramCrashlyticsReport.getNdkPayload());
    }
  }
  
  private static final class CrashlyticsReportFilesPayloadEncoder
    implements ObjectEncoder<CrashlyticsReport.FilesPayload>
  {
    private static final FieldDescriptor FILES_DESCRIPTOR = FieldDescriptor.of("files");
    static final CrashlyticsReportFilesPayloadEncoder INSTANCE = new CrashlyticsReportFilesPayloadEncoder();
    private static final FieldDescriptor ORGID_DESCRIPTOR = FieldDescriptor.of("orgId");
    
    public void encode(CrashlyticsReport.FilesPayload paramFilesPayload, ObjectEncoderContext paramObjectEncoderContext)
      throws IOException
    {
      paramObjectEncoderContext.add(FILES_DESCRIPTOR, paramFilesPayload.getFiles());
      paramObjectEncoderContext.add(ORGID_DESCRIPTOR, paramFilesPayload.getOrgId());
    }
  }
  
  private static final class CrashlyticsReportFilesPayloadFileEncoder
    implements ObjectEncoder<CrashlyticsReport.FilesPayload.File>
  {
    private static final FieldDescriptor CONTENTS_DESCRIPTOR = FieldDescriptor.of("contents");
    private static final FieldDescriptor FILENAME_DESCRIPTOR;
    static final CrashlyticsReportFilesPayloadFileEncoder INSTANCE = new CrashlyticsReportFilesPayloadFileEncoder();
    
    static
    {
      FILENAME_DESCRIPTOR = FieldDescriptor.of("filename");
    }
    
    public void encode(CrashlyticsReport.FilesPayload.File paramFile, ObjectEncoderContext paramObjectEncoderContext)
      throws IOException
    {
      paramObjectEncoderContext.add(FILENAME_DESCRIPTOR, paramFile.getFilename());
      paramObjectEncoderContext.add(CONTENTS_DESCRIPTOR, paramFile.getContents());
    }
  }
  
  private static final class CrashlyticsReportSessionApplicationEncoder
    implements ObjectEncoder<CrashlyticsReport.Session.Application>
  {
    private static final FieldDescriptor DEVELOPMENTPLATFORMVERSION_DESCRIPTOR = FieldDescriptor.of("developmentPlatformVersion");
    private static final FieldDescriptor DEVELOPMENTPLATFORM_DESCRIPTOR;
    private static final FieldDescriptor DISPLAYVERSION_DESCRIPTOR;
    private static final FieldDescriptor IDENTIFIER_DESCRIPTOR;
    private static final FieldDescriptor INSTALLATIONUUID_DESCRIPTOR;
    static final CrashlyticsReportSessionApplicationEncoder INSTANCE = new CrashlyticsReportSessionApplicationEncoder();
    private static final FieldDescriptor ORGANIZATION_DESCRIPTOR;
    private static final FieldDescriptor VERSION_DESCRIPTOR;
    
    static
    {
      IDENTIFIER_DESCRIPTOR = FieldDescriptor.of("identifier");
      VERSION_DESCRIPTOR = FieldDescriptor.of("version");
      DISPLAYVERSION_DESCRIPTOR = FieldDescriptor.of("displayVersion");
      ORGANIZATION_DESCRIPTOR = FieldDescriptor.of("organization");
      INSTALLATIONUUID_DESCRIPTOR = FieldDescriptor.of("installationUuid");
      DEVELOPMENTPLATFORM_DESCRIPTOR = FieldDescriptor.of("developmentPlatform");
    }
    
    public void encode(CrashlyticsReport.Session.Application paramApplication, ObjectEncoderContext paramObjectEncoderContext)
      throws IOException
    {
      paramObjectEncoderContext.add(IDENTIFIER_DESCRIPTOR, paramApplication.getIdentifier());
      paramObjectEncoderContext.add(VERSION_DESCRIPTOR, paramApplication.getVersion());
      paramObjectEncoderContext.add(DISPLAYVERSION_DESCRIPTOR, paramApplication.getDisplayVersion());
      paramObjectEncoderContext.add(ORGANIZATION_DESCRIPTOR, paramApplication.getOrganization());
      paramObjectEncoderContext.add(INSTALLATIONUUID_DESCRIPTOR, paramApplication.getInstallationUuid());
      paramObjectEncoderContext.add(DEVELOPMENTPLATFORM_DESCRIPTOR, paramApplication.getDevelopmentPlatform());
      paramObjectEncoderContext.add(DEVELOPMENTPLATFORMVERSION_DESCRIPTOR, paramApplication.getDevelopmentPlatformVersion());
    }
  }
  
  private static final class CrashlyticsReportSessionApplicationOrganizationEncoder
    implements ObjectEncoder<CrashlyticsReport.Session.Application.Organization>
  {
    private static final FieldDescriptor CLSID_DESCRIPTOR = FieldDescriptor.of("clsId");
    static final CrashlyticsReportSessionApplicationOrganizationEncoder INSTANCE = new CrashlyticsReportSessionApplicationOrganizationEncoder();
    
    public void encode(CrashlyticsReport.Session.Application.Organization paramOrganization, ObjectEncoderContext paramObjectEncoderContext)
      throws IOException
    {
      paramObjectEncoderContext.add(CLSID_DESCRIPTOR, paramOrganization.getClsId());
    }
  }
  
  private static final class CrashlyticsReportSessionDeviceEncoder
    implements ObjectEncoder<CrashlyticsReport.Session.Device>
  {
    private static final FieldDescriptor ARCH_DESCRIPTOR;
    private static final FieldDescriptor CORES_DESCRIPTOR;
    private static final FieldDescriptor DISKSPACE_DESCRIPTOR;
    static final CrashlyticsReportSessionDeviceEncoder INSTANCE = new CrashlyticsReportSessionDeviceEncoder();
    private static final FieldDescriptor MANUFACTURER_DESCRIPTOR = FieldDescriptor.of("manufacturer");
    private static final FieldDescriptor MODELCLASS_DESCRIPTOR = FieldDescriptor.of("modelClass");
    private static final FieldDescriptor MODEL_DESCRIPTOR;
    private static final FieldDescriptor RAM_DESCRIPTOR;
    private static final FieldDescriptor SIMULATOR_DESCRIPTOR;
    private static final FieldDescriptor STATE_DESCRIPTOR;
    
    static
    {
      ARCH_DESCRIPTOR = FieldDescriptor.of("arch");
      MODEL_DESCRIPTOR = FieldDescriptor.of("model");
      CORES_DESCRIPTOR = FieldDescriptor.of("cores");
      RAM_DESCRIPTOR = FieldDescriptor.of("ram");
      DISKSPACE_DESCRIPTOR = FieldDescriptor.of("diskSpace");
      SIMULATOR_DESCRIPTOR = FieldDescriptor.of("simulator");
      STATE_DESCRIPTOR = FieldDescriptor.of("state");
    }
    
    public void encode(CrashlyticsReport.Session.Device paramDevice, ObjectEncoderContext paramObjectEncoderContext)
      throws IOException
    {
      paramObjectEncoderContext.add(ARCH_DESCRIPTOR, paramDevice.getArch());
      paramObjectEncoderContext.add(MODEL_DESCRIPTOR, paramDevice.getModel());
      paramObjectEncoderContext.add(CORES_DESCRIPTOR, paramDevice.getCores());
      paramObjectEncoderContext.add(RAM_DESCRIPTOR, paramDevice.getRam());
      paramObjectEncoderContext.add(DISKSPACE_DESCRIPTOR, paramDevice.getDiskSpace());
      paramObjectEncoderContext.add(SIMULATOR_DESCRIPTOR, paramDevice.isSimulator());
      paramObjectEncoderContext.add(STATE_DESCRIPTOR, paramDevice.getState());
      paramObjectEncoderContext.add(MANUFACTURER_DESCRIPTOR, paramDevice.getManufacturer());
      paramObjectEncoderContext.add(MODELCLASS_DESCRIPTOR, paramDevice.getModelClass());
    }
  }
  
  private static final class CrashlyticsReportSessionEncoder
    implements ObjectEncoder<CrashlyticsReport.Session>
  {
    private static final FieldDescriptor APP_DESCRIPTOR;
    private static final FieldDescriptor CRASHED_DESCRIPTOR;
    private static final FieldDescriptor DEVICE_DESCRIPTOR = FieldDescriptor.of("device");
    private static final FieldDescriptor ENDEDAT_DESCRIPTOR;
    private static final FieldDescriptor EVENTS_DESCRIPTOR = FieldDescriptor.of("events");
    private static final FieldDescriptor GENERATORTYPE_DESCRIPTOR = FieldDescriptor.of("generatorType");
    private static final FieldDescriptor GENERATOR_DESCRIPTOR;
    private static final FieldDescriptor IDENTIFIER_DESCRIPTOR;
    static final CrashlyticsReportSessionEncoder INSTANCE = new CrashlyticsReportSessionEncoder();
    private static final FieldDescriptor OS_DESCRIPTOR;
    private static final FieldDescriptor STARTEDAT_DESCRIPTOR;
    private static final FieldDescriptor USER_DESCRIPTOR;
    
    static
    {
      GENERATOR_DESCRIPTOR = FieldDescriptor.of("generator");
      IDENTIFIER_DESCRIPTOR = FieldDescriptor.of("identifier");
      STARTEDAT_DESCRIPTOR = FieldDescriptor.of("startedAt");
      ENDEDAT_DESCRIPTOR = FieldDescriptor.of("endedAt");
      CRASHED_DESCRIPTOR = FieldDescriptor.of("crashed");
      APP_DESCRIPTOR = FieldDescriptor.of("app");
      USER_DESCRIPTOR = FieldDescriptor.of("user");
      OS_DESCRIPTOR = FieldDescriptor.of("os");
    }
    
    public void encode(CrashlyticsReport.Session paramSession, ObjectEncoderContext paramObjectEncoderContext)
      throws IOException
    {
      paramObjectEncoderContext.add(GENERATOR_DESCRIPTOR, paramSession.getGenerator());
      paramObjectEncoderContext.add(IDENTIFIER_DESCRIPTOR, paramSession.getIdentifierUtf8Bytes());
      paramObjectEncoderContext.add(STARTEDAT_DESCRIPTOR, paramSession.getStartedAt());
      paramObjectEncoderContext.add(ENDEDAT_DESCRIPTOR, paramSession.getEndedAt());
      paramObjectEncoderContext.add(CRASHED_DESCRIPTOR, paramSession.isCrashed());
      paramObjectEncoderContext.add(APP_DESCRIPTOR, paramSession.getApp());
      paramObjectEncoderContext.add(USER_DESCRIPTOR, paramSession.getUser());
      paramObjectEncoderContext.add(OS_DESCRIPTOR, paramSession.getOs());
      paramObjectEncoderContext.add(DEVICE_DESCRIPTOR, paramSession.getDevice());
      paramObjectEncoderContext.add(EVENTS_DESCRIPTOR, paramSession.getEvents());
      paramObjectEncoderContext.add(GENERATORTYPE_DESCRIPTOR, paramSession.getGeneratorType());
    }
  }
  
  private static final class CrashlyticsReportSessionEventApplicationEncoder
    implements ObjectEncoder<CrashlyticsReport.Session.Event.Application>
  {
    private static final FieldDescriptor BACKGROUND_DESCRIPTOR = FieldDescriptor.of("background");
    private static final FieldDescriptor CUSTOMATTRIBUTES_DESCRIPTOR;
    private static final FieldDescriptor EXECUTION_DESCRIPTOR;
    static final CrashlyticsReportSessionEventApplicationEncoder INSTANCE = new CrashlyticsReportSessionEventApplicationEncoder();
    private static final FieldDescriptor UIORIENTATION_DESCRIPTOR = FieldDescriptor.of("uiOrientation");
    
    static
    {
      EXECUTION_DESCRIPTOR = FieldDescriptor.of("execution");
      CUSTOMATTRIBUTES_DESCRIPTOR = FieldDescriptor.of("customAttributes");
    }
    
    public void encode(CrashlyticsReport.Session.Event.Application paramApplication, ObjectEncoderContext paramObjectEncoderContext)
      throws IOException
    {
      paramObjectEncoderContext.add(EXECUTION_DESCRIPTOR, paramApplication.getExecution());
      paramObjectEncoderContext.add(CUSTOMATTRIBUTES_DESCRIPTOR, paramApplication.getCustomAttributes());
      paramObjectEncoderContext.add(BACKGROUND_DESCRIPTOR, paramApplication.getBackground());
      paramObjectEncoderContext.add(UIORIENTATION_DESCRIPTOR, paramApplication.getUiOrientation());
    }
  }
  
  private static final class CrashlyticsReportSessionEventApplicationExecutionBinaryImageEncoder
    implements ObjectEncoder<CrashlyticsReport.Session.Event.Application.Execution.BinaryImage>
  {
    private static final FieldDescriptor BASEADDRESS_DESCRIPTOR;
    static final CrashlyticsReportSessionEventApplicationExecutionBinaryImageEncoder INSTANCE = new CrashlyticsReportSessionEventApplicationExecutionBinaryImageEncoder();
    private static final FieldDescriptor NAME_DESCRIPTOR = FieldDescriptor.of("name");
    private static final FieldDescriptor SIZE_DESCRIPTOR;
    private static final FieldDescriptor UUID_DESCRIPTOR = FieldDescriptor.of("uuid");
    
    static
    {
      BASEADDRESS_DESCRIPTOR = FieldDescriptor.of("baseAddress");
      SIZE_DESCRIPTOR = FieldDescriptor.of("size");
    }
    
    public void encode(CrashlyticsReport.Session.Event.Application.Execution.BinaryImage paramBinaryImage, ObjectEncoderContext paramObjectEncoderContext)
      throws IOException
    {
      paramObjectEncoderContext.add(BASEADDRESS_DESCRIPTOR, paramBinaryImage.getBaseAddress());
      paramObjectEncoderContext.add(SIZE_DESCRIPTOR, paramBinaryImage.getSize());
      paramObjectEncoderContext.add(NAME_DESCRIPTOR, paramBinaryImage.getName());
      paramObjectEncoderContext.add(UUID_DESCRIPTOR, paramBinaryImage.getUuidUtf8Bytes());
    }
  }
  
  private static final class CrashlyticsReportSessionEventApplicationExecutionEncoder
    implements ObjectEncoder<CrashlyticsReport.Session.Event.Application.Execution>
  {
    private static final FieldDescriptor BINARIES_DESCRIPTOR = FieldDescriptor.of("binaries");
    private static final FieldDescriptor EXCEPTION_DESCRIPTOR;
    static final CrashlyticsReportSessionEventApplicationExecutionEncoder INSTANCE = new CrashlyticsReportSessionEventApplicationExecutionEncoder();
    private static final FieldDescriptor SIGNAL_DESCRIPTOR;
    private static final FieldDescriptor THREADS_DESCRIPTOR = FieldDescriptor.of("threads");
    
    static
    {
      EXCEPTION_DESCRIPTOR = FieldDescriptor.of("exception");
      SIGNAL_DESCRIPTOR = FieldDescriptor.of("signal");
    }
    
    public void encode(CrashlyticsReport.Session.Event.Application.Execution paramExecution, ObjectEncoderContext paramObjectEncoderContext)
      throws IOException
    {
      paramObjectEncoderContext.add(THREADS_DESCRIPTOR, paramExecution.getThreads());
      paramObjectEncoderContext.add(EXCEPTION_DESCRIPTOR, paramExecution.getException());
      paramObjectEncoderContext.add(SIGNAL_DESCRIPTOR, paramExecution.getSignal());
      paramObjectEncoderContext.add(BINARIES_DESCRIPTOR, paramExecution.getBinaries());
    }
  }
  
  private static final class CrashlyticsReportSessionEventApplicationExecutionExceptionEncoder
    implements ObjectEncoder<CrashlyticsReport.Session.Event.Application.Execution.Exception>
  {
    private static final FieldDescriptor CAUSEDBY_DESCRIPTOR = FieldDescriptor.of("causedBy");
    private static final FieldDescriptor FRAMES_DESCRIPTOR;
    static final CrashlyticsReportSessionEventApplicationExecutionExceptionEncoder INSTANCE = new CrashlyticsReportSessionEventApplicationExecutionExceptionEncoder();
    private static final FieldDescriptor OVERFLOWCOUNT_DESCRIPTOR = FieldDescriptor.of("overflowCount");
    private static final FieldDescriptor REASON_DESCRIPTOR;
    private static final FieldDescriptor TYPE_DESCRIPTOR = FieldDescriptor.of("type");
    
    static
    {
      REASON_DESCRIPTOR = FieldDescriptor.of("reason");
      FRAMES_DESCRIPTOR = FieldDescriptor.of("frames");
    }
    
    public void encode(CrashlyticsReport.Session.Event.Application.Execution.Exception paramException, ObjectEncoderContext paramObjectEncoderContext)
      throws IOException
    {
      paramObjectEncoderContext.add(TYPE_DESCRIPTOR, paramException.getType());
      paramObjectEncoderContext.add(REASON_DESCRIPTOR, paramException.getReason());
      paramObjectEncoderContext.add(FRAMES_DESCRIPTOR, paramException.getFrames());
      paramObjectEncoderContext.add(CAUSEDBY_DESCRIPTOR, paramException.getCausedBy());
      paramObjectEncoderContext.add(OVERFLOWCOUNT_DESCRIPTOR, paramException.getOverflowCount());
    }
  }
  
  private static final class CrashlyticsReportSessionEventApplicationExecutionSignalEncoder
    implements ObjectEncoder<CrashlyticsReport.Session.Event.Application.Execution.Signal>
  {
    private static final FieldDescriptor ADDRESS_DESCRIPTOR = FieldDescriptor.of("address");
    private static final FieldDescriptor CODE_DESCRIPTOR;
    static final CrashlyticsReportSessionEventApplicationExecutionSignalEncoder INSTANCE = new CrashlyticsReportSessionEventApplicationExecutionSignalEncoder();
    private static final FieldDescriptor NAME_DESCRIPTOR = FieldDescriptor.of("name");
    
    static
    {
      CODE_DESCRIPTOR = FieldDescriptor.of("code");
    }
    
    public void encode(CrashlyticsReport.Session.Event.Application.Execution.Signal paramSignal, ObjectEncoderContext paramObjectEncoderContext)
      throws IOException
    {
      paramObjectEncoderContext.add(NAME_DESCRIPTOR, paramSignal.getName());
      paramObjectEncoderContext.add(CODE_DESCRIPTOR, paramSignal.getCode());
      paramObjectEncoderContext.add(ADDRESS_DESCRIPTOR, paramSignal.getAddress());
    }
  }
  
  private static final class CrashlyticsReportSessionEventApplicationExecutionThreadEncoder
    implements ObjectEncoder<CrashlyticsReport.Session.Event.Application.Execution.Thread>
  {
    private static final FieldDescriptor FRAMES_DESCRIPTOR = FieldDescriptor.of("frames");
    private static final FieldDescriptor IMPORTANCE_DESCRIPTOR;
    static final CrashlyticsReportSessionEventApplicationExecutionThreadEncoder INSTANCE = new CrashlyticsReportSessionEventApplicationExecutionThreadEncoder();
    private static final FieldDescriptor NAME_DESCRIPTOR = FieldDescriptor.of("name");
    
    static
    {
      IMPORTANCE_DESCRIPTOR = FieldDescriptor.of("importance");
    }
    
    public void encode(CrashlyticsReport.Session.Event.Application.Execution.Thread paramThread, ObjectEncoderContext paramObjectEncoderContext)
      throws IOException
    {
      paramObjectEncoderContext.add(NAME_DESCRIPTOR, paramThread.getName());
      paramObjectEncoderContext.add(IMPORTANCE_DESCRIPTOR, paramThread.getImportance());
      paramObjectEncoderContext.add(FRAMES_DESCRIPTOR, paramThread.getFrames());
    }
  }
  
  private static final class CrashlyticsReportSessionEventApplicationExecutionThreadFrameEncoder
    implements ObjectEncoder<CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame>
  {
    private static final FieldDescriptor FILE_DESCRIPTOR;
    private static final FieldDescriptor IMPORTANCE_DESCRIPTOR = FieldDescriptor.of("importance");
    static final CrashlyticsReportSessionEventApplicationExecutionThreadFrameEncoder INSTANCE = new CrashlyticsReportSessionEventApplicationExecutionThreadFrameEncoder();
    private static final FieldDescriptor OFFSET_DESCRIPTOR;
    private static final FieldDescriptor PC_DESCRIPTOR = FieldDescriptor.of("pc");
    private static final FieldDescriptor SYMBOL_DESCRIPTOR = FieldDescriptor.of("symbol");
    
    static
    {
      FILE_DESCRIPTOR = FieldDescriptor.of("file");
      OFFSET_DESCRIPTOR = FieldDescriptor.of("offset");
    }
    
    public void encode(CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame paramFrame, ObjectEncoderContext paramObjectEncoderContext)
      throws IOException
    {
      paramObjectEncoderContext.add(PC_DESCRIPTOR, paramFrame.getPc());
      paramObjectEncoderContext.add(SYMBOL_DESCRIPTOR, paramFrame.getSymbol());
      paramObjectEncoderContext.add(FILE_DESCRIPTOR, paramFrame.getFile());
      paramObjectEncoderContext.add(OFFSET_DESCRIPTOR, paramFrame.getOffset());
      paramObjectEncoderContext.add(IMPORTANCE_DESCRIPTOR, paramFrame.getImportance());
    }
  }
  
  private static final class CrashlyticsReportSessionEventDeviceEncoder
    implements ObjectEncoder<CrashlyticsReport.Session.Event.Device>
  {
    private static final FieldDescriptor BATTERYLEVEL_DESCRIPTOR;
    private static final FieldDescriptor BATTERYVELOCITY_DESCRIPTOR;
    private static final FieldDescriptor DISKUSED_DESCRIPTOR = FieldDescriptor.of("diskUsed");
    static final CrashlyticsReportSessionEventDeviceEncoder INSTANCE = new CrashlyticsReportSessionEventDeviceEncoder();
    private static final FieldDescriptor ORIENTATION_DESCRIPTOR;
    private static final FieldDescriptor PROXIMITYON_DESCRIPTOR;
    private static final FieldDescriptor RAMUSED_DESCRIPTOR;
    
    static
    {
      BATTERYLEVEL_DESCRIPTOR = FieldDescriptor.of("batteryLevel");
      BATTERYVELOCITY_DESCRIPTOR = FieldDescriptor.of("batteryVelocity");
      PROXIMITYON_DESCRIPTOR = FieldDescriptor.of("proximityOn");
      ORIENTATION_DESCRIPTOR = FieldDescriptor.of("orientation");
      RAMUSED_DESCRIPTOR = FieldDescriptor.of("ramUsed");
    }
    
    public void encode(CrashlyticsReport.Session.Event.Device paramDevice, ObjectEncoderContext paramObjectEncoderContext)
      throws IOException
    {
      paramObjectEncoderContext.add(BATTERYLEVEL_DESCRIPTOR, paramDevice.getBatteryLevel());
      paramObjectEncoderContext.add(BATTERYVELOCITY_DESCRIPTOR, paramDevice.getBatteryVelocity());
      paramObjectEncoderContext.add(PROXIMITYON_DESCRIPTOR, paramDevice.isProximityOn());
      paramObjectEncoderContext.add(ORIENTATION_DESCRIPTOR, paramDevice.getOrientation());
      paramObjectEncoderContext.add(RAMUSED_DESCRIPTOR, paramDevice.getRamUsed());
      paramObjectEncoderContext.add(DISKUSED_DESCRIPTOR, paramDevice.getDiskUsed());
    }
  }
  
  private static final class CrashlyticsReportSessionEventEncoder
    implements ObjectEncoder<CrashlyticsReport.Session.Event>
  {
    private static final FieldDescriptor APP_DESCRIPTOR = FieldDescriptor.of("app");
    private static final FieldDescriptor DEVICE_DESCRIPTOR = FieldDescriptor.of("device");
    static final CrashlyticsReportSessionEventEncoder INSTANCE = new CrashlyticsReportSessionEventEncoder();
    private static final FieldDescriptor LOG_DESCRIPTOR = FieldDescriptor.of("log");
    private static final FieldDescriptor TIMESTAMP_DESCRIPTOR = FieldDescriptor.of("timestamp");
    private static final FieldDescriptor TYPE_DESCRIPTOR = FieldDescriptor.of("type");
    
    public void encode(CrashlyticsReport.Session.Event paramEvent, ObjectEncoderContext paramObjectEncoderContext)
      throws IOException
    {
      paramObjectEncoderContext.add(TIMESTAMP_DESCRIPTOR, paramEvent.getTimestamp());
      paramObjectEncoderContext.add(TYPE_DESCRIPTOR, paramEvent.getType());
      paramObjectEncoderContext.add(APP_DESCRIPTOR, paramEvent.getApp());
      paramObjectEncoderContext.add(DEVICE_DESCRIPTOR, paramEvent.getDevice());
      paramObjectEncoderContext.add(LOG_DESCRIPTOR, paramEvent.getLog());
    }
  }
  
  private static final class CrashlyticsReportSessionEventLogEncoder
    implements ObjectEncoder<CrashlyticsReport.Session.Event.Log>
  {
    private static final FieldDescriptor CONTENT_DESCRIPTOR = FieldDescriptor.of("content");
    static final CrashlyticsReportSessionEventLogEncoder INSTANCE = new CrashlyticsReportSessionEventLogEncoder();
    
    public void encode(CrashlyticsReport.Session.Event.Log paramLog, ObjectEncoderContext paramObjectEncoderContext)
      throws IOException
    {
      paramObjectEncoderContext.add(CONTENT_DESCRIPTOR, paramLog.getContent());
    }
  }
  
  private static final class CrashlyticsReportSessionOperatingSystemEncoder
    implements ObjectEncoder<CrashlyticsReport.Session.OperatingSystem>
  {
    private static final FieldDescriptor BUILDVERSION_DESCRIPTOR = FieldDescriptor.of("buildVersion");
    static final CrashlyticsReportSessionOperatingSystemEncoder INSTANCE = new CrashlyticsReportSessionOperatingSystemEncoder();
    private static final FieldDescriptor JAILBROKEN_DESCRIPTOR = FieldDescriptor.of("jailbroken");
    private static final FieldDescriptor PLATFORM_DESCRIPTOR = FieldDescriptor.of("platform");
    private static final FieldDescriptor VERSION_DESCRIPTOR = FieldDescriptor.of("version");
    
    public void encode(CrashlyticsReport.Session.OperatingSystem paramOperatingSystem, ObjectEncoderContext paramObjectEncoderContext)
      throws IOException
    {
      paramObjectEncoderContext.add(PLATFORM_DESCRIPTOR, paramOperatingSystem.getPlatform());
      paramObjectEncoderContext.add(VERSION_DESCRIPTOR, paramOperatingSystem.getVersion());
      paramObjectEncoderContext.add(BUILDVERSION_DESCRIPTOR, paramOperatingSystem.getBuildVersion());
      paramObjectEncoderContext.add(JAILBROKEN_DESCRIPTOR, paramOperatingSystem.isJailbroken());
    }
  }
  
  private static final class CrashlyticsReportSessionUserEncoder
    implements ObjectEncoder<CrashlyticsReport.Session.User>
  {
    private static final FieldDescriptor IDENTIFIER_DESCRIPTOR = FieldDescriptor.of("identifier");
    static final CrashlyticsReportSessionUserEncoder INSTANCE = new CrashlyticsReportSessionUserEncoder();
    
    public void encode(CrashlyticsReport.Session.User paramUser, ObjectEncoderContext paramObjectEncoderContext)
      throws IOException
    {
      paramObjectEncoderContext.add(IDENTIFIER_DESCRIPTOR, paramUser.getIdentifier());
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\crashlytics\internal\model\AutoCrashlyticsReportEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */