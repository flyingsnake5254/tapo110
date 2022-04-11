package com.google.firebase.crashlytics.internal.model.serialization;

import android.util.Base64;
import android.util.JsonReader;
import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.model.AutoCrashlyticsReportEncoder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.CustomAttribute;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.CustomAttribute.Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload.Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload.File;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload.File.Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application.Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device.Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.BinaryImage;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Signal;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Signal.Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device.Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Log;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Log.Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem.Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.User;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.User.Builder;
import com.google.firebase.crashlytics.internal.model.ImmutableList;
import com.google.firebase.encoders.DataEncoder;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CrashlyticsReportJsonTransform
{
  private static final DataEncoder CRASHLYTICS_REPORT_JSON_ENCODER = new JsonDataEncoderBuilder().configureWith(AutoCrashlyticsReportEncoder.CONFIG).ignoreNullValues(true).build();
  
  @NonNull
  private static CrashlyticsReport.Session.Application parseApp(@NonNull JsonReader paramJsonReader)
    throws IOException
  {
    CrashlyticsReport.Session.Application.Builder localBuilder = CrashlyticsReport.Session.Application.builder();
    paramJsonReader.beginObject();
    while (paramJsonReader.hasNext())
    {
      String str = paramJsonReader.nextName();
      str.hashCode();
      int i = -1;
      switch (str.hashCode())
      {
      default: 
        break;
      case 1975623094: 
        if (str.equals("displayVersion")) {
          i = 5;
        }
        break;
      case 719853845: 
        if (str.equals("installationUuid")) {
          i = 4;
        }
        break;
      case 351608024: 
        if (str.equals("version")) {
          i = 3;
        }
        break;
      case 213652010: 
        if (str.equals("developmentPlatformVersion")) {
          i = 2;
        }
        break;
      case -519438642: 
        if (str.equals("developmentPlatform")) {
          i = 1;
        }
        break;
      case -1618432855: 
        if (str.equals("identifier")) {
          i = 0;
        }
        break;
      }
      switch (i)
      {
      default: 
        paramJsonReader.skipValue();
        break;
      case 5: 
        localBuilder.setDisplayVersion(paramJsonReader.nextString());
        break;
      case 4: 
        localBuilder.setInstallationUuid(paramJsonReader.nextString());
        break;
      case 3: 
        localBuilder.setVersion(paramJsonReader.nextString());
        break;
      case 2: 
        localBuilder.setDevelopmentPlatformVersion(paramJsonReader.nextString());
        break;
      case 1: 
        localBuilder.setDevelopmentPlatform(paramJsonReader.nextString());
        break;
      case 0: 
        localBuilder.setIdentifier(paramJsonReader.nextString());
      }
    }
    paramJsonReader.endObject();
    return localBuilder.build();
  }
  
  @NonNull
  private static <T> ImmutableList<T> parseArray(@NonNull JsonReader paramJsonReader, @NonNull ObjectParser<T> paramObjectParser)
    throws IOException
  {
    ArrayList localArrayList = new ArrayList();
    paramJsonReader.beginArray();
    while (paramJsonReader.hasNext()) {
      localArrayList.add(paramObjectParser.parse(paramJsonReader));
    }
    paramJsonReader.endArray();
    return ImmutableList.from(localArrayList);
  }
  
  @NonNull
  private static CrashlyticsReport.CustomAttribute parseCustomAttribute(@NonNull JsonReader paramJsonReader)
    throws IOException
  {
    CrashlyticsReport.CustomAttribute.Builder localBuilder = CrashlyticsReport.CustomAttribute.builder();
    paramJsonReader.beginObject();
    while (paramJsonReader.hasNext())
    {
      String str = paramJsonReader.nextName();
      str.hashCode();
      if (!str.equals("key"))
      {
        if (!str.equals("value")) {
          paramJsonReader.skipValue();
        } else {
          localBuilder.setValue(paramJsonReader.nextString());
        }
      }
      else {
        localBuilder.setKey(paramJsonReader.nextString());
      }
    }
    paramJsonReader.endObject();
    return localBuilder.build();
  }
  
  @NonNull
  private static CrashlyticsReport.Session.Device parseDevice(@NonNull JsonReader paramJsonReader)
    throws IOException
  {
    CrashlyticsReport.Session.Device.Builder localBuilder = CrashlyticsReport.Session.Device.builder();
    paramJsonReader.beginObject();
    while (paramJsonReader.hasNext())
    {
      String str = paramJsonReader.nextName();
      str.hashCode();
      int i = -1;
      switch (str.hashCode())
      {
      default: 
        break;
      case 2078953423: 
        if (str.equals("modelClass")) {
          i = 8;
        }
        break;
      case 109757585: 
        if (str.equals("state")) {
          i = 7;
        }
        break;
      case 104069929: 
        if (str.equals("model")) {
          i = 6;
        }
        break;
      case 94848180: 
        if (str.equals("cores")) {
          i = 5;
        }
        break;
      case 81784169: 
        if (str.equals("diskSpace")) {
          i = 4;
        }
        break;
      case 3002454: 
        if (str.equals("arch")) {
          i = 3;
        }
        break;
      case 112670: 
        if (str.equals("ram")) {
          i = 2;
        }
        break;
      case -1969347631: 
        if (str.equals("manufacturer")) {
          i = 1;
        }
        break;
      case -1981332476: 
        if (str.equals("simulator")) {
          i = 0;
        }
        break;
      }
      switch (i)
      {
      default: 
        paramJsonReader.skipValue();
        break;
      case 8: 
        localBuilder.setModelClass(paramJsonReader.nextString());
        break;
      case 7: 
        localBuilder.setState(paramJsonReader.nextInt());
        break;
      case 6: 
        localBuilder.setModel(paramJsonReader.nextString());
        break;
      case 5: 
        localBuilder.setCores(paramJsonReader.nextInt());
        break;
      case 4: 
        localBuilder.setDiskSpace(paramJsonReader.nextLong());
        break;
      case 3: 
        localBuilder.setArch(paramJsonReader.nextInt());
        break;
      case 2: 
        localBuilder.setRam(paramJsonReader.nextLong());
        break;
      case 1: 
        localBuilder.setManufacturer(paramJsonReader.nextString());
        break;
      case 0: 
        localBuilder.setSimulator(paramJsonReader.nextBoolean());
      }
    }
    paramJsonReader.endObject();
    return localBuilder.build();
  }
  
  @NonNull
  private static CrashlyticsReport.Session.Event parseEvent(@NonNull JsonReader paramJsonReader)
    throws IOException
  {
    CrashlyticsReport.Session.Event.Builder localBuilder = CrashlyticsReport.Session.Event.builder();
    paramJsonReader.beginObject();
    while (paramJsonReader.hasNext())
    {
      String str = paramJsonReader.nextName();
      str.hashCode();
      int i = -1;
      switch (str.hashCode())
      {
      default: 
        break;
      case 55126294: 
        if (str.equals("timestamp")) {
          i = 4;
        }
        break;
      case 3575610: 
        if (str.equals("type")) {
          i = 3;
        }
        break;
      case 107332: 
        if (str.equals("log")) {
          i = 2;
        }
        break;
      case 96801: 
        if (str.equals("app")) {
          i = 1;
        }
        break;
      case -1335157162: 
        if (str.equals("device")) {
          i = 0;
        }
        break;
      }
      switch (i)
      {
      default: 
        paramJsonReader.skipValue();
        break;
      case 4: 
        localBuilder.setTimestamp(paramJsonReader.nextLong());
        break;
      case 3: 
        localBuilder.setType(paramJsonReader.nextString());
        break;
      case 2: 
        localBuilder.setLog(parseEventLog(paramJsonReader));
        break;
      case 1: 
        localBuilder.setApp(parseEventApp(paramJsonReader));
        break;
      case 0: 
        localBuilder.setDevice(parseEventDevice(paramJsonReader));
      }
    }
    paramJsonReader.endObject();
    return localBuilder.build();
  }
  
  @NonNull
  private static CrashlyticsReport.Session.Event.Application parseEventApp(@NonNull JsonReader paramJsonReader)
    throws IOException
  {
    CrashlyticsReport.Session.Event.Application.Builder localBuilder = CrashlyticsReport.Session.Event.Application.builder();
    paramJsonReader.beginObject();
    while (paramJsonReader.hasNext())
    {
      String str = paramJsonReader.nextName();
      str.hashCode();
      int i = -1;
      switch (str.hashCode())
      {
      default: 
        break;
      case 928737948: 
        if (str.equals("uiOrientation")) {
          i = 3;
        }
        break;
      case 555169704: 
        if (str.equals("customAttributes")) {
          i = 2;
        }
        break;
      case -1090974952: 
        if (str.equals("execution")) {
          i = 1;
        }
        break;
      case -1332194002: 
        if (str.equals("background")) {
          i = 0;
        }
        break;
      }
      switch (i)
      {
      default: 
        paramJsonReader.skipValue();
        break;
      case 3: 
        localBuilder.setUiOrientation(paramJsonReader.nextInt());
        break;
      case 2: 
        localBuilder.setCustomAttributes(parseArray(paramJsonReader, f.a));
        break;
      case 1: 
        localBuilder.setExecution(parseEventExecution(paramJsonReader));
        break;
      case 0: 
        localBuilder.setBackground(Boolean.valueOf(paramJsonReader.nextBoolean()));
      }
    }
    paramJsonReader.endObject();
    return localBuilder.build();
  }
  
  @NonNull
  private static CrashlyticsReport.Session.Event.Application.Execution.BinaryImage parseEventBinaryImage(@NonNull JsonReader paramJsonReader)
    throws IOException
  {
    CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.Builder localBuilder = CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.builder();
    paramJsonReader.beginObject();
    while (paramJsonReader.hasNext())
    {
      String str = paramJsonReader.nextName();
      str.hashCode();
      int i = -1;
      switch (str.hashCode())
      {
      default: 
        break;
      case 1153765347: 
        if (str.equals("baseAddress")) {
          i = 3;
        }
        break;
      case 3601339: 
        if (str.equals("uuid")) {
          i = 2;
        }
        break;
      case 3530753: 
        if (str.equals("size")) {
          i = 1;
        }
        break;
      case 3373707: 
        if (str.equals("name")) {
          i = 0;
        }
        break;
      }
      switch (i)
      {
      default: 
        paramJsonReader.skipValue();
        break;
      case 3: 
        localBuilder.setBaseAddress(paramJsonReader.nextLong());
        break;
      case 2: 
        localBuilder.setUuidFromUtf8Bytes(Base64.decode(paramJsonReader.nextString(), 2));
        break;
      case 1: 
        localBuilder.setSize(paramJsonReader.nextLong());
        break;
      case 0: 
        localBuilder.setName(paramJsonReader.nextString());
      }
    }
    paramJsonReader.endObject();
    return localBuilder.build();
  }
  
  @NonNull
  private static CrashlyticsReport.Session.Event.Device parseEventDevice(@NonNull JsonReader paramJsonReader)
    throws IOException
  {
    CrashlyticsReport.Session.Event.Device.Builder localBuilder = CrashlyticsReport.Session.Event.Device.builder();
    paramJsonReader.beginObject();
    while (paramJsonReader.hasNext())
    {
      String str = paramJsonReader.nextName();
      str.hashCode();
      int i = -1;
      switch (str.hashCode())
      {
      default: 
        break;
      case 1516795582: 
        if (str.equals("proximityOn")) {
          i = 5;
        }
        break;
      case 976541947: 
        if (str.equals("ramUsed")) {
          i = 4;
        }
        break;
      case 279795450: 
        if (str.equals("diskUsed")) {
          i = 3;
        }
        break;
      case -1439500848: 
        if (str.equals("orientation")) {
          i = 2;
        }
        break;
      case -1455558134: 
        if (str.equals("batteryVelocity")) {
          i = 1;
        }
        break;
      case -1708606089: 
        if (str.equals("batteryLevel")) {
          i = 0;
        }
        break;
      }
      switch (i)
      {
      default: 
        paramJsonReader.skipValue();
        break;
      case 5: 
        localBuilder.setProximityOn(paramJsonReader.nextBoolean());
        break;
      case 4: 
        localBuilder.setRamUsed(paramJsonReader.nextLong());
        break;
      case 3: 
        localBuilder.setDiskUsed(paramJsonReader.nextLong());
        break;
      case 2: 
        localBuilder.setOrientation(paramJsonReader.nextInt());
        break;
      case 1: 
        localBuilder.setBatteryVelocity(paramJsonReader.nextInt());
        break;
      case 0: 
        localBuilder.setBatteryLevel(Double.valueOf(paramJsonReader.nextDouble()));
      }
    }
    paramJsonReader.endObject();
    return localBuilder.build();
  }
  
  @NonNull
  private static CrashlyticsReport.Session.Event.Application.Execution parseEventExecution(@NonNull JsonReader paramJsonReader)
    throws IOException
  {
    CrashlyticsReport.Session.Event.Application.Execution.Builder localBuilder = CrashlyticsReport.Session.Event.Application.Execution.builder();
    paramJsonReader.beginObject();
    while (paramJsonReader.hasNext())
    {
      String str = paramJsonReader.nextName();
      str.hashCode();
      int i = -1;
      switch (str.hashCode())
      {
      default: 
        break;
      case 1481625679: 
        if (str.equals("exception")) {
          i = 3;
        }
        break;
      case 937615455: 
        if (str.equals("binaries")) {
          i = 2;
        }
        break;
      case -902467928: 
        if (str.equals("signal")) {
          i = 1;
        }
        break;
      case -1337936983: 
        if (str.equals("threads")) {
          i = 0;
        }
        break;
      }
      switch (i)
      {
      default: 
        paramJsonReader.skipValue();
        break;
      case 3: 
        localBuilder.setException(parseEventExecutionException(paramJsonReader));
        break;
      case 2: 
        localBuilder.setBinaries(parseArray(paramJsonReader, e.a));
        break;
      case 1: 
        localBuilder.setSignal(parseEventSignal(paramJsonReader));
        break;
      case 0: 
        localBuilder.setThreads(parseArray(paramJsonReader, c.a));
      }
    }
    paramJsonReader.endObject();
    return localBuilder.build();
  }
  
  @NonNull
  private static CrashlyticsReport.Session.Event.Application.Execution.Exception parseEventExecutionException(@NonNull JsonReader paramJsonReader)
    throws IOException
  {
    CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder localBuilder = CrashlyticsReport.Session.Event.Application.Execution.Exception.builder();
    paramJsonReader.beginObject();
    while (paramJsonReader.hasNext())
    {
      String str = paramJsonReader.nextName();
      str.hashCode();
      int i = -1;
      switch (str.hashCode())
      {
      default: 
        break;
      case 581754413: 
        if (str.equals("overflowCount")) {
          i = 4;
        }
        break;
      case 91997906: 
        if (str.equals("causedBy")) {
          i = 3;
        }
        break;
      case 3575610: 
        if (str.equals("type")) {
          i = 2;
        }
        break;
      case -934964668: 
        if (str.equals("reason")) {
          i = 1;
        }
        break;
      case -1266514778: 
        if (str.equals("frames")) {
          i = 0;
        }
        break;
      }
      switch (i)
      {
      default: 
        paramJsonReader.skipValue();
        break;
      case 4: 
        localBuilder.setOverflowCount(paramJsonReader.nextInt());
        break;
      case 3: 
        localBuilder.setCausedBy(parseEventExecutionException(paramJsonReader));
        break;
      case 2: 
        localBuilder.setType(paramJsonReader.nextString());
        break;
      case 1: 
        localBuilder.setReason(paramJsonReader.nextString());
        break;
      case 0: 
        localBuilder.setFrames(parseArray(paramJsonReader, b.a));
      }
    }
    paramJsonReader.endObject();
    return localBuilder.build();
  }
  
  @NonNull
  private static CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame parseEventFrame(@NonNull JsonReader paramJsonReader)
    throws IOException
  {
    CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder localBuilder = CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.builder();
    paramJsonReader.beginObject();
    while (paramJsonReader.hasNext())
    {
      String str = paramJsonReader.nextName();
      str.hashCode();
      int i = -1;
      switch (str.hashCode())
      {
      default: 
        break;
      case 2125650548: 
        if (str.equals("importance")) {
          i = 4;
        }
        break;
      case 3143036: 
        if (str.equals("file")) {
          i = 3;
        }
        break;
      case 3571: 
        if (str.equals("pc")) {
          i = 2;
        }
        break;
      case -887523944: 
        if (str.equals("symbol")) {
          i = 1;
        }
        break;
      case -1019779949: 
        if (str.equals("offset")) {
          i = 0;
        }
        break;
      }
      switch (i)
      {
      default: 
        paramJsonReader.skipValue();
        break;
      case 4: 
        localBuilder.setImportance(paramJsonReader.nextInt());
        break;
      case 3: 
        localBuilder.setFile(paramJsonReader.nextString());
        break;
      case 2: 
        localBuilder.setPc(paramJsonReader.nextLong());
        break;
      case 1: 
        localBuilder.setSymbol(paramJsonReader.nextString());
        break;
      case 0: 
        localBuilder.setOffset(paramJsonReader.nextLong());
      }
    }
    paramJsonReader.endObject();
    return localBuilder.build();
  }
  
  @NonNull
  private static CrashlyticsReport.Session.Event.Log parseEventLog(@NonNull JsonReader paramJsonReader)
    throws IOException
  {
    CrashlyticsReport.Session.Event.Log.Builder localBuilder = CrashlyticsReport.Session.Event.Log.builder();
    paramJsonReader.beginObject();
    while (paramJsonReader.hasNext())
    {
      String str = paramJsonReader.nextName();
      str.hashCode();
      if (!str.equals("content")) {
        paramJsonReader.skipValue();
      } else {
        localBuilder.setContent(paramJsonReader.nextString());
      }
    }
    paramJsonReader.endObject();
    return localBuilder.build();
  }
  
  @NonNull
  private static CrashlyticsReport.Session.Event.Application.Execution.Signal parseEventSignal(@NonNull JsonReader paramJsonReader)
    throws IOException
  {
    CrashlyticsReport.Session.Event.Application.Execution.Signal.Builder localBuilder = CrashlyticsReport.Session.Event.Application.Execution.Signal.builder();
    paramJsonReader.beginObject();
    while (paramJsonReader.hasNext())
    {
      String str = paramJsonReader.nextName();
      str.hashCode();
      int i = -1;
      switch (str.hashCode())
      {
      default: 
        break;
      case 3373707: 
        if (str.equals("name")) {
          i = 2;
        }
        break;
      case 3059181: 
        if (str.equals("code")) {
          i = 1;
        }
        break;
      case -1147692044: 
        if (str.equals("address")) {
          i = 0;
        }
        break;
      }
      switch (i)
      {
      default: 
        paramJsonReader.skipValue();
        break;
      case 2: 
        localBuilder.setName(paramJsonReader.nextString());
        break;
      case 1: 
        localBuilder.setCode(paramJsonReader.nextString());
        break;
      case 0: 
        localBuilder.setAddress(paramJsonReader.nextLong());
      }
    }
    paramJsonReader.endObject();
    return localBuilder.build();
  }
  
  @NonNull
  private static CrashlyticsReport.Session.Event.Application.Execution.Thread parseEventThread(@NonNull JsonReader paramJsonReader)
    throws IOException
  {
    CrashlyticsReport.Session.Event.Application.Execution.Thread.Builder localBuilder = CrashlyticsReport.Session.Event.Application.Execution.Thread.builder();
    paramJsonReader.beginObject();
    while (paramJsonReader.hasNext())
    {
      String str = paramJsonReader.nextName();
      str.hashCode();
      int i = -1;
      switch (str.hashCode())
      {
      default: 
        break;
      case 2125650548: 
        if (str.equals("importance")) {
          i = 2;
        }
        break;
      case 3373707: 
        if (str.equals("name")) {
          i = 1;
        }
        break;
      case -1266514778: 
        if (str.equals("frames")) {
          i = 0;
        }
        break;
      }
      switch (i)
      {
      default: 
        paramJsonReader.skipValue();
        break;
      case 2: 
        localBuilder.setImportance(paramJsonReader.nextInt());
        break;
      case 1: 
        localBuilder.setName(paramJsonReader.nextString());
        break;
      case 0: 
        localBuilder.setFrames(parseArray(paramJsonReader, b.a));
      }
    }
    paramJsonReader.endObject();
    return localBuilder.build();
  }
  
  @NonNull
  private static CrashlyticsReport.FilesPayload.File parseFile(@NonNull JsonReader paramJsonReader)
    throws IOException
  {
    CrashlyticsReport.FilesPayload.File.Builder localBuilder = CrashlyticsReport.FilesPayload.File.builder();
    paramJsonReader.beginObject();
    while (paramJsonReader.hasNext())
    {
      String str = paramJsonReader.nextName();
      str.hashCode();
      if (!str.equals("filename"))
      {
        if (!str.equals("contents")) {
          paramJsonReader.skipValue();
        } else {
          localBuilder.setContents(Base64.decode(paramJsonReader.nextString(), 2));
        }
      }
      else {
        localBuilder.setFilename(paramJsonReader.nextString());
      }
    }
    paramJsonReader.endObject();
    return localBuilder.build();
  }
  
  @NonNull
  private static CrashlyticsReport.FilesPayload parseNdkPayload(@NonNull JsonReader paramJsonReader)
    throws IOException
  {
    CrashlyticsReport.FilesPayload.Builder localBuilder = CrashlyticsReport.FilesPayload.builder();
    paramJsonReader.beginObject();
    while (paramJsonReader.hasNext())
    {
      String str = paramJsonReader.nextName();
      str.hashCode();
      if (!str.equals("files"))
      {
        if (!str.equals("orgId")) {
          paramJsonReader.skipValue();
        } else {
          localBuilder.setOrgId(paramJsonReader.nextString());
        }
      }
      else {
        localBuilder.setFiles(parseArray(paramJsonReader, d.a));
      }
    }
    paramJsonReader.endObject();
    return localBuilder.build();
  }
  
  @NonNull
  private static CrashlyticsReport.Session.OperatingSystem parseOs(@NonNull JsonReader paramJsonReader)
    throws IOException
  {
    CrashlyticsReport.Session.OperatingSystem.Builder localBuilder = CrashlyticsReport.Session.OperatingSystem.builder();
    paramJsonReader.beginObject();
    while (paramJsonReader.hasNext())
    {
      String str = paramJsonReader.nextName();
      str.hashCode();
      int i = -1;
      switch (str.hashCode())
      {
      default: 
        break;
      case 1874684019: 
        if (str.equals("platform")) {
          i = 3;
        }
        break;
      case 351608024: 
        if (str.equals("version")) {
          i = 2;
        }
        break;
      case -293026577: 
        if (str.equals("jailbroken")) {
          i = 1;
        }
        break;
      case -911706486: 
        if (str.equals("buildVersion")) {
          i = 0;
        }
        break;
      }
      switch (i)
      {
      default: 
        paramJsonReader.skipValue();
        break;
      case 3: 
        localBuilder.setPlatform(paramJsonReader.nextInt());
        break;
      case 2: 
        localBuilder.setVersion(paramJsonReader.nextString());
        break;
      case 1: 
        localBuilder.setJailbroken(paramJsonReader.nextBoolean());
        break;
      case 0: 
        localBuilder.setBuildVersion(paramJsonReader.nextString());
      }
    }
    paramJsonReader.endObject();
    return localBuilder.build();
  }
  
  @NonNull
  private static CrashlyticsReport parseReport(@NonNull JsonReader paramJsonReader)
    throws IOException
  {
    CrashlyticsReport.Builder localBuilder = CrashlyticsReport.builder();
    paramJsonReader.beginObject();
    while (paramJsonReader.hasNext())
    {
      String str = paramJsonReader.nextName();
      str.hashCode();
      int i = -1;
      switch (str.hashCode())
      {
      default: 
        break;
      case 1984987798: 
        if (str.equals("session")) {
          i = 7;
        }
        break;
      case 1975623094: 
        if (str.equals("displayVersion")) {
          i = 6;
        }
        break;
      case 1874684019: 
        if (str.equals("platform")) {
          i = 5;
        }
        break;
      case 719853845: 
        if (str.equals("installationUuid")) {
          i = 4;
        }
        break;
      case 344431858: 
        if (str.equals("gmpAppId")) {
          i = 3;
        }
        break;
      case -911706486: 
        if (str.equals("buildVersion")) {
          i = 2;
        }
        break;
      case -1962630338: 
        if (str.equals("sdkVersion")) {
          i = 1;
        }
        break;
      case -2118372775: 
        if (str.equals("ndkPayload")) {
          i = 0;
        }
        break;
      }
      switch (i)
      {
      default: 
        paramJsonReader.skipValue();
        break;
      case 7: 
        localBuilder.setSession(parseSession(paramJsonReader));
        break;
      case 6: 
        localBuilder.setDisplayVersion(paramJsonReader.nextString());
        break;
      case 5: 
        localBuilder.setPlatform(paramJsonReader.nextInt());
        break;
      case 4: 
        localBuilder.setInstallationUuid(paramJsonReader.nextString());
        break;
      case 3: 
        localBuilder.setGmpAppId(paramJsonReader.nextString());
        break;
      case 2: 
        localBuilder.setBuildVersion(paramJsonReader.nextString());
        break;
      case 1: 
        localBuilder.setSdkVersion(paramJsonReader.nextString());
        break;
      case 0: 
        localBuilder.setNdkPayload(parseNdkPayload(paramJsonReader));
      }
    }
    paramJsonReader.endObject();
    return localBuilder.build();
  }
  
  @NonNull
  private static CrashlyticsReport.Session parseSession(@NonNull JsonReader paramJsonReader)
    throws IOException
  {
    CrashlyticsReport.Session.Builder localBuilder = CrashlyticsReport.Session.builder();
    paramJsonReader.beginObject();
    while (paramJsonReader.hasNext())
    {
      String str = paramJsonReader.nextName();
      str.hashCode();
      int i = -1;
      switch (str.hashCode())
      {
      default: 
        break;
      case 2047016109: 
        if (str.equals("generatorType")) {
          i = 10;
        }
        break;
      case 1025385094: 
        if (str.equals("crashed")) {
          i = 9;
        }
        break;
      case 286956243: 
        if (str.equals("generator")) {
          i = 8;
        }
        break;
      case 3599307: 
        if (str.equals("user")) {
          i = 7;
        }
        break;
      case 96801: 
        if (str.equals("app")) {
          i = 6;
        }
        break;
      case 3556: 
        if (str.equals("os")) {
          i = 5;
        }
        break;
      case -1291329255: 
        if (str.equals("events")) {
          i = 4;
        }
        break;
      case -1335157162: 
        if (str.equals("device")) {
          i = 3;
        }
        break;
      case -1606742899: 
        if (str.equals("endedAt")) {
          i = 2;
        }
        break;
      case -1618432855: 
        if (str.equals("identifier")) {
          i = 1;
        }
        break;
      case -2128794476: 
        if (str.equals("startedAt")) {
          i = 0;
        }
        break;
      }
      switch (i)
      {
      default: 
        paramJsonReader.skipValue();
        break;
      case 10: 
        localBuilder.setGeneratorType(paramJsonReader.nextInt());
        break;
      case 9: 
        localBuilder.setCrashed(paramJsonReader.nextBoolean());
        break;
      case 8: 
        localBuilder.setGenerator(paramJsonReader.nextString());
        break;
      case 7: 
        localBuilder.setUser(parseUser(paramJsonReader));
        break;
      case 6: 
        localBuilder.setApp(parseApp(paramJsonReader));
        break;
      case 5: 
        localBuilder.setOs(parseOs(paramJsonReader));
        break;
      case 4: 
        localBuilder.setEvents(parseArray(paramJsonReader, a.a));
        break;
      case 3: 
        localBuilder.setDevice(parseDevice(paramJsonReader));
        break;
      case 2: 
        localBuilder.setEndedAt(Long.valueOf(paramJsonReader.nextLong()));
        break;
      case 1: 
        localBuilder.setIdentifierFromUtf8Bytes(Base64.decode(paramJsonReader.nextString(), 2));
        break;
      case 0: 
        localBuilder.setStartedAt(paramJsonReader.nextLong());
      }
    }
    paramJsonReader.endObject();
    return localBuilder.build();
  }
  
  @NonNull
  private static CrashlyticsReport.Session.User parseUser(@NonNull JsonReader paramJsonReader)
    throws IOException
  {
    CrashlyticsReport.Session.User.Builder localBuilder = CrashlyticsReport.Session.User.builder();
    paramJsonReader.beginObject();
    while (paramJsonReader.hasNext())
    {
      String str = paramJsonReader.nextName();
      str.hashCode();
      if (!str.equals("identifier")) {
        paramJsonReader.skipValue();
      } else {
        localBuilder.setIdentifier(paramJsonReader.nextString());
      }
    }
    paramJsonReader.endObject();
    return localBuilder.build();
  }
  
  /* Error */
  @NonNull
  public CrashlyticsReport.Session.Event eventFromJson(@NonNull String paramString)
    throws IOException
  {
    // Byte code:
    //   0: new 81	android/util/JsonReader
    //   3: astore_2
    //   4: new 894	java/io/StringReader
    //   7: astore_3
    //   8: aload_3
    //   9: aload_1
    //   10: invokespecial 897	java/io/StringReader:<init>	(Ljava/lang/String;)V
    //   13: aload_2
    //   14: aload_3
    //   15: invokespecial 900	android/util/JsonReader:<init>	(Ljava/io/Reader;)V
    //   18: aload_2
    //   19: invokestatic 43	com/google/firebase/crashlytics/internal/model/serialization/CrashlyticsReportJsonTransform:parseEvent	(Landroid/util/JsonReader;)Lcom/google/firebase/crashlytics/internal/model/CrashlyticsReport$Session$Event;
    //   22: astore_1
    //   23: aload_2
    //   24: invokevirtual 903	android/util/JsonReader:close	()V
    //   27: aload_1
    //   28: areturn
    //   29: astore_1
    //   30: aload_2
    //   31: invokevirtual 903	android/util/JsonReader:close	()V
    //   34: goto +9 -> 43
    //   37: astore_2
    //   38: aload_1
    //   39: aload_2
    //   40: invokevirtual 909	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   43: aload_1
    //   44: athrow
    //   45: astore_1
    //   46: new 72	java/io/IOException
    //   49: dup
    //   50: aload_1
    //   51: invokespecial 911	java/io/IOException:<init>	(Ljava/lang/Throwable;)V
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	this	CrashlyticsReportJsonTransform
    //   0	55	1	paramString	String
    //   3	28	2	localJsonReader	JsonReader
    //   37	3	2	localThrowable	Throwable
    //   7	8	3	localStringReader	java.io.StringReader
    // Exception table:
    //   from	to	target	type
    //   18	23	29	finally
    //   30	34	37	finally
    //   0	18	45	java/lang/IllegalStateException
    //   23	27	45	java/lang/IllegalStateException
    //   38	43	45	java/lang/IllegalStateException
    //   43	45	45	java/lang/IllegalStateException
  }
  
  @NonNull
  public String eventToJson(@NonNull CrashlyticsReport.Session.Event paramEvent)
  {
    return CRASHLYTICS_REPORT_JSON_ENCODER.encode(paramEvent);
  }
  
  /* Error */
  @NonNull
  public CrashlyticsReport reportFromJson(@NonNull String paramString)
    throws IOException
  {
    // Byte code:
    //   0: new 81	android/util/JsonReader
    //   3: astore_2
    //   4: new 894	java/io/StringReader
    //   7: astore_3
    //   8: aload_3
    //   9: aload_1
    //   10: invokespecial 897	java/io/StringReader:<init>	(Ljava/lang/String;)V
    //   13: aload_2
    //   14: aload_3
    //   15: invokespecial 900	android/util/JsonReader:<init>	(Ljava/io/Reader;)V
    //   18: aload_2
    //   19: invokestatic 923	com/google/firebase/crashlytics/internal/model/serialization/CrashlyticsReportJsonTransform:parseReport	(Landroid/util/JsonReader;)Lcom/google/firebase/crashlytics/internal/model/CrashlyticsReport;
    //   22: astore_1
    //   23: aload_2
    //   24: invokevirtual 903	android/util/JsonReader:close	()V
    //   27: aload_1
    //   28: areturn
    //   29: astore_1
    //   30: aload_2
    //   31: invokevirtual 903	android/util/JsonReader:close	()V
    //   34: goto +9 -> 43
    //   37: astore_2
    //   38: aload_1
    //   39: aload_2
    //   40: invokevirtual 909	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   43: aload_1
    //   44: athrow
    //   45: astore_1
    //   46: new 72	java/io/IOException
    //   49: dup
    //   50: aload_1
    //   51: invokespecial 911	java/io/IOException:<init>	(Ljava/lang/Throwable;)V
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	this	CrashlyticsReportJsonTransform
    //   0	55	1	paramString	String
    //   3	28	2	localJsonReader	JsonReader
    //   37	3	2	localThrowable	Throwable
    //   7	8	3	localStringReader	java.io.StringReader
    // Exception table:
    //   from	to	target	type
    //   18	23	29	finally
    //   30	34	37	finally
    //   0	18	45	java/lang/IllegalStateException
    //   23	27	45	java/lang/IllegalStateException
    //   38	43	45	java/lang/IllegalStateException
    //   43	45	45	java/lang/IllegalStateException
  }
  
  @NonNull
  public String reportToJson(@NonNull CrashlyticsReport paramCrashlyticsReport)
  {
    return CRASHLYTICS_REPORT_JSON_ENCODER.encode(paramCrashlyticsReport);
  }
  
  private static abstract interface ObjectParser<T>
  {
    public abstract T parse(@NonNull JsonReader paramJsonReader)
      throws IOException;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\crashlytics\internal\model\serialization\CrashlyticsReportJsonTransform.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */