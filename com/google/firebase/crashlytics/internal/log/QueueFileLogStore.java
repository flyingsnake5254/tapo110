package com.google.firebase.crashlytics.internal.log;

import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Locale;

class QueueFileLogStore
  implements FileLogStore
{
  private static final Charset UTF_8 = Charset.forName("UTF-8");
  private QueueFile logFile;
  private final int maxLogSize;
  private final File workingFile;
  
  QueueFileLogStore(File paramFile, int paramInt)
  {
    this.workingFile = paramFile;
    this.maxLogSize = paramInt;
  }
  
  private void doWriteToLog(long paramLong, String paramString)
  {
    if (this.logFile == null) {
      return;
    }
    String str = paramString;
    if (paramString == null) {
      str = "null";
    }
    try
    {
      int i = this.maxLogSize / 4;
      paramString = str;
      if (str.length() > i)
      {
        paramString = new java/lang/StringBuilder;
        paramString.<init>();
        paramString.append("...");
        paramString.append(str.substring(str.length() - i));
        paramString = paramString.toString();
      }
      paramString = paramString.replaceAll("\r", " ").replaceAll("\n", " ");
      paramString = String.format(Locale.US, "%d %s%n", new Object[] { Long.valueOf(paramLong), paramString }).getBytes(UTF_8);
      this.logFile.add(paramString);
      while ((!this.logFile.isEmpty()) && (this.logFile.usedBytes() > this.maxLogSize)) {
        this.logFile.remove();
      }
      return;
    }
    catch (IOException paramString)
    {
      Logger.getLogger().e("There was a problem writing to the Crashlytics log.", paramString);
    }
  }
  
  private LogBytes getLogBytes()
  {
    if (!this.workingFile.exists()) {
      return null;
    }
    openLogFile();
    Object localObject = this.logFile;
    if (localObject == null) {
      return null;
    }
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = 0;
    localObject = new byte[((QueueFile)localObject).usedBytes()];
    try
    {
      QueueFile localQueueFile = this.logFile;
      QueueFile.ElementReader local1 = new com/google/firebase/crashlytics/internal/log/QueueFileLogStore$1;
      local1.<init>(this, (byte[])localObject, arrayOfInt);
      localQueueFile.forEach(local1);
    }
    catch (IOException localIOException)
    {
      Logger.getLogger().e("A problem occurred while reading the Crashlytics log file.", localIOException);
    }
    return new LogBytes((byte[])localObject, arrayOfInt[0]);
  }
  
  private void openLogFile()
  {
    if (this.logFile == null) {
      try
      {
        localObject = new com/google/firebase/crashlytics/internal/log/QueueFile;
        ((QueueFile)localObject).<init>(this.workingFile);
        this.logFile = ((QueueFile)localObject);
      }
      catch (IOException localIOException)
      {
        Logger localLogger = Logger.getLogger();
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Could not open log file: ");
        ((StringBuilder)localObject).append(this.workingFile);
        localLogger.e(((StringBuilder)localObject).toString(), localIOException);
      }
    }
  }
  
  public void closeLogFile()
  {
    CommonUtils.closeOrLog(this.logFile, "There was a problem closing the Crashlytics log file.");
    this.logFile = null;
  }
  
  public void deleteLogFile()
  {
    closeLogFile();
    this.workingFile.delete();
  }
  
  public byte[] getLogAsBytes()
  {
    LogBytes localLogBytes = getLogBytes();
    if (localLogBytes == null) {
      return null;
    }
    int i = localLogBytes.offset;
    byte[] arrayOfByte = new byte[i];
    System.arraycopy(localLogBytes.bytes, 0, arrayOfByte, 0, i);
    return arrayOfByte;
  }
  
  public String getLogAsString()
  {
    Object localObject = getLogAsBytes();
    if (localObject != null) {
      localObject = new String((byte[])localObject, UTF_8);
    } else {
      localObject = null;
    }
    return (String)localObject;
  }
  
  public void writeToLog(long paramLong, String paramString)
  {
    openLogFile();
    doWriteToLog(paramLong, paramString);
  }
  
  private static class LogBytes
  {
    public final byte[] bytes;
    public final int offset;
    
    LogBytes(byte[] paramArrayOfByte, int paramInt)
    {
      this.bytes = paramArrayOfByte;
      this.offset = paramInt;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\crashlytics\internal\log\QueueFileLogStore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */