package io.netty.resolver;

import io.netty.util.NetUtil;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;

public final class HostsFileParser
{
  private static final Pattern WHITESPACES = Pattern.compile("[ \t]+");
  private static final String WINDOWS_DEFAULT_SYSTEM_ROOT = "C:\\Windows";
  private static final String WINDOWS_HOSTS_FILE_RELATIVE_PATH = "\\system32\\drivers\\etc\\hosts";
  private static final String X_PLATFORMS_HOSTS_FILE_PATH = "/etc/hosts";
  private static final InternalLogger logger = InternalLoggerFactory.getInstance(HostsFileParser.class);
  
  private static File locateHostsFile()
  {
    Object localObject;
    if (PlatformDependent.isWindows())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(System.getenv("SystemRoot"));
      ((StringBuilder)localObject).append("\\system32\\drivers\\etc\\hosts");
      File localFile = new File(((StringBuilder)localObject).toString());
      localObject = localFile;
      if (!localFile.exists()) {
        localObject = new File("C:\\Windows\\system32\\drivers\\etc\\hosts");
      }
    }
    else
    {
      localObject = new File("/etc/hosts");
    }
    return (File)localObject;
  }
  
  public static HostsFileEntries parse()
    throws IOException
  {
    return parse(locateHostsFile());
  }
  
  public static HostsFileEntries parse(File paramFile)
    throws IOException
  {
    return parse(paramFile, new Charset[] { Charset.defaultCharset() });
  }
  
  public static HostsFileEntries parse(File paramFile, Charset... paramVarArgs)
    throws IOException
  {
    ObjectUtil.checkNotNull(paramFile, "file");
    ObjectUtil.checkNotNull(paramVarArgs, "charsets");
    if ((paramFile.exists()) && (paramFile.isFile()))
    {
      int i = paramVarArgs.length;
      for (int j = 0; j < i; j++)
      {
        Object localObject = paramVarArgs[j];
        localObject = parse(new BufferedReader(new InputStreamReader(new FileInputStream(paramFile), (Charset)localObject)));
        if (localObject != HostsFileEntries.EMPTY) {
          return (HostsFileEntries)localObject;
        }
      }
    }
    return HostsFileEntries.EMPTY;
  }
  
  public static HostsFileEntries parse(Reader paramReader)
    throws IOException
  {
    ObjectUtil.checkNotNull(paramReader, "reader");
    BufferedReader localBufferedReader = new BufferedReader(paramReader);
    try
    {
      HashMap localHashMap1 = new java/util/HashMap;
      localHashMap1.<init>();
      HashMap localHashMap2 = new java/util/HashMap;
      localHashMap2.<init>();
      for (;;)
      {
        Object localObject1 = localBufferedReader.readLine();
        if (localObject1 == null) {
          break;
        }
        int i = ((String)localObject1).indexOf('#');
        paramReader = (Reader)localObject1;
        if (i != -1) {
          paramReader = ((String)localObject1).substring(0, i);
        }
        localObject1 = paramReader.trim();
        if (!((String)localObject1).isEmpty())
        {
          paramReader = new java/util/ArrayList;
          paramReader.<init>();
          Object localObject2;
          for (localObject2 : WHITESPACES.split((CharSequence)localObject1)) {
            if (!((String)localObject2).isEmpty()) {
              paramReader.add(localObject2);
            }
          }
          if (paramReader.size() >= 2)
          {
            localObject2 = NetUtil.createByteArrayFromIpAddressString((String)paramReader.get(0));
            if (localObject2 != null) {
              for (i = 1; i < paramReader.size(); i++)
              {
                Object localObject3 = (String)paramReader.get(i);
                localObject1 = ((String)localObject3).toLowerCase(Locale.ENGLISH);
                localObject3 = InetAddress.getByAddress((String)localObject3, (byte[])localObject2);
                if ((localObject3 instanceof Inet4Address))
                {
                  localObject3 = (Inet4Address)localHashMap1.put(localObject1, (Inet4Address)localObject3);
                  if (localObject3 != null) {
                    localHashMap1.put(localObject1, localObject3);
                  }
                }
                else
                {
                  localObject3 = (Inet6Address)localHashMap2.put(localObject1, (Inet6Address)localObject3);
                  if (localObject3 != null) {
                    localHashMap2.put(localObject1, localObject3);
                  }
                }
              }
            }
          }
        }
      }
      if ((localHashMap1.isEmpty()) && (localHashMap2.isEmpty())) {
        paramReader = HostsFileEntries.EMPTY;
      } else {
        paramReader = new HostsFileEntries(localHashMap1, localHashMap2);
      }
      return paramReader;
    }
    finally
    {
      try
      {
        localBufferedReader.close();
      }
      catch (IOException localIOException2)
      {
        logger.warn("Failed to close a reader", localIOException2);
      }
    }
  }
  
  public static HostsFileEntries parseSilently()
  {
    return parseSilently(new Charset[] { Charset.defaultCharset() });
  }
  
  public static HostsFileEntries parseSilently(Charset... paramVarArgs)
  {
    File localFile = locateHostsFile();
    try
    {
      paramVarArgs = parse(localFile, paramVarArgs);
      return paramVarArgs;
    }
    catch (IOException paramVarArgs)
    {
      if (logger.isWarnEnabled())
      {
        InternalLogger localInternalLogger = logger;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Failed to load and parse hosts file at ");
        localStringBuilder.append(localFile.getPath());
        localInternalLogger.warn(localStringBuilder.toString(), paramVarArgs);
      }
    }
    return HostsFileEntries.EMPTY;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\resolver\HostsFileParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */