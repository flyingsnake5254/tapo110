package org.eclipse.paho.client.mqttv3.persist;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Enumeration;
import java.util.Vector;
import org.eclipse.paho.client.mqttv3.MqttClientPersistence;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;
import org.eclipse.paho.client.mqttv3.internal.FileLock;

public class MqttDefaultFilePersistence
  implements MqttClientPersistence
{
  private static FilenameFilter FILENAME_FILTER;
  private static final String LOCK_FILENAME = ".lck";
  private static final String MESSAGE_BACKUP_FILE_EXTENSION = ".bup";
  private static final String MESSAGE_FILE_EXTENSION = ".msg";
  private File clientDir = null;
  private File dataDir;
  private FileLock fileLock = null;
  
  public MqttDefaultFilePersistence()
  {
    this(System.getProperty("user.dir"));
  }
  
  public MqttDefaultFilePersistence(String paramString)
  {
    this.dataDir = new File(paramString);
  }
  
  private void checkIsOpen()
    throws MqttPersistenceException
  {
    if (this.clientDir != null) {
      return;
    }
    throw new MqttPersistenceException();
  }
  
  private static FilenameFilter getFilenameFilter()
  {
    if (FILENAME_FILTER == null) {
      FILENAME_FILTER = new PersistanceFileNameFilter(".msg");
    }
    return FILENAME_FILTER;
  }
  
  private File[] getFiles()
    throws MqttPersistenceException
  {
    checkIsOpen();
    File[] arrayOfFile = this.clientDir.listFiles(getFilenameFilter());
    if (arrayOfFile != null) {
      return arrayOfFile;
    }
    throw new MqttPersistenceException();
  }
  
  private boolean isSafeChar(char paramChar)
  {
    return (Character.isJavaIdentifierPart(paramChar)) || (paramChar == '-');
  }
  
  private void restoreBackups(File paramFile)
    throws MqttPersistenceException
  {
    File[] arrayOfFile = paramFile.listFiles(new PersistanceFileFilter(".bup"));
    if (arrayOfFile != null)
    {
      int i = arrayOfFile.length;
      for (int j = 0;; j++)
      {
        if (j >= i) {
          return;
        }
        File localFile1 = arrayOfFile[j];
        File localFile2 = new File(paramFile, localFile1.getName().substring(0, localFile1.getName().length() - 4));
        if (!localFile1.renameTo(localFile2))
        {
          localFile2.delete();
          localFile1.renameTo(localFile2);
        }
      }
    }
    throw new MqttPersistenceException();
  }
  
  public void clear()
    throws MqttPersistenceException
  {
    checkIsOpen();
    File[] arrayOfFile = getFiles();
    int i = arrayOfFile.length;
    for (int j = 0;; j++)
    {
      if (j >= i)
      {
        this.clientDir.delete();
        return;
      }
      arrayOfFile[j].delete();
    }
  }
  
  public void close()
    throws MqttPersistenceException
  {
    try
    {
      FileLock localFileLock = this.fileLock;
      if (localFileLock != null) {
        localFileLock.release();
      }
      if (getFiles().length == 0) {
        this.clientDir.delete();
      }
      this.clientDir = null;
      return;
    }
    finally {}
  }
  
  public boolean containsKey(String paramString)
    throws MqttPersistenceException
  {
    checkIsOpen();
    File localFile = this.clientDir;
    paramString = new StringBuilder(String.valueOf(paramString));
    paramString.append(".msg");
    return new File(localFile, paramString.toString()).exists();
  }
  
  /* Error */
  public org.eclipse.paho.client.mqttv3.MqttPersistable get(String paramString)
    throws MqttPersistenceException
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 64	org/eclipse/paho/client/mqttv3/persist/MqttDefaultFilePersistence:checkIsOpen	()V
    //   4: new 45	java/io/File
    //   7: astore_2
    //   8: aload_0
    //   9: getfield 41	org/eclipse/paho/client/mqttv3/persist/MqttDefaultFilePersistence:clientDir	Ljava/io/File;
    //   12: astore_3
    //   13: new 123	java/lang/StringBuilder
    //   16: astore 4
    //   18: aload 4
    //   20: aload_1
    //   21: invokestatic 127	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   24: invokespecial 128	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   27: aload 4
    //   29: ldc 18
    //   31: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: aload_2
    //   36: aload_3
    //   37: aload 4
    //   39: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokespecial 102	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   45: new 144	java/io/FileInputStream
    //   48: astore_3
    //   49: aload_3
    //   50: aload_2
    //   51: invokespecial 146	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   54: aload_3
    //   55: invokevirtual 149	java/io/FileInputStream:available	()I
    //   58: istore 5
    //   60: iload 5
    //   62: newarray <illegal type>
    //   64: astore_2
    //   65: iconst_0
    //   66: istore 6
    //   68: iload 6
    //   70: iload 5
    //   72: if_icmplt +23 -> 95
    //   75: aload_3
    //   76: invokevirtual 151	java/io/FileInputStream:close	()V
    //   79: new 153	org/eclipse/paho/client/mqttv3/internal/MqttPersistentData
    //   82: dup
    //   83: aload_1
    //   84: aload_2
    //   85: iconst_0
    //   86: iload 5
    //   88: aconst_null
    //   89: iconst_0
    //   90: iconst_0
    //   91: invokespecial 156	org/eclipse/paho/client/mqttv3/internal/MqttPersistentData:<init>	(Ljava/lang/String;[BII[BII)V
    //   94: areturn
    //   95: aload_3
    //   96: aload_2
    //   97: iload 6
    //   99: iload 5
    //   101: iload 6
    //   103: isub
    //   104: invokevirtual 160	java/io/FileInputStream:read	([BII)I
    //   107: istore 7
    //   109: iload 6
    //   111: iload 7
    //   113: iadd
    //   114: istore 6
    //   116: goto -48 -> 68
    //   119: astore_1
    //   120: new 51	org/eclipse/paho/client/mqttv3/MqttPersistenceException
    //   123: dup
    //   124: aload_1
    //   125: invokespecial 163	org/eclipse/paho/client/mqttv3/MqttPersistenceException:<init>	(Ljava/lang/Throwable;)V
    //   128: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	129	0	this	MqttDefaultFilePersistence
    //   0	129	1	paramString	String
    //   7	90	2	localObject1	Object
    //   12	84	3	localObject2	Object
    //   16	22	4	localStringBuilder	StringBuilder
    //   58	46	5	i	int
    //   66	49	6	j	int
    //   107	7	7	k	int
    // Exception table:
    //   from	to	target	type
    //   4	65	119	java/io/IOException
    //   75	95	119	java/io/IOException
    //   95	109	119	java/io/IOException
  }
  
  public Enumeration<String> keys()
    throws MqttPersistenceException
  {
    checkIsOpen();
    File[] arrayOfFile = getFiles();
    Vector localVector = new Vector(arrayOfFile.length);
    int i = arrayOfFile.length;
    for (int j = 0;; j++)
    {
      if (j >= i) {
        return localVector.elements();
      }
      String str = arrayOfFile[j].getName();
      localVector.addElement(str.substring(0, str.length() - 4));
    }
  }
  
  public void open(String paramString1, String paramString2)
    throws MqttPersistenceException
  {
    if ((this.dataDir.exists()) && (!this.dataDir.isDirectory())) {
      throw new MqttPersistenceException();
    }
    if ((!this.dataDir.exists()) && (!this.dataDir.mkdirs())) {
      throw new MqttPersistenceException();
    }
    if (this.dataDir.canWrite())
    {
      StringBuffer localStringBuffer = new StringBuffer();
      int i = 0;
      for (int j = 0;; j++)
      {
        if (j >= paramString1.length())
        {
          localStringBuffer.append("-");
          for (j = i;; j++)
          {
            if (j >= paramString2.length()) {}
            for (;;)
            {
              try
              {
                if (this.clientDir == null)
                {
                  paramString2 = localStringBuffer.toString();
                  paramString1 = new java/io/File;
                  paramString1.<init>(this.dataDir, paramString2);
                  this.clientDir = paramString1;
                  if (!paramString1.exists()) {
                    this.clientDir.mkdir();
                  }
                }
              }
              finally {}
              try
              {
                paramString1 = this.fileLock;
                if (paramString1 != null) {
                  paramString1.release();
                }
                paramString1 = new org/eclipse/paho/client/mqttv3/internal/FileLock;
                paramString1.<init>(this.clientDir, ".lck");
                this.fileLock = paramString1;
              }
              catch (Exception paramString1)
              {
                char c;
              }
            }
            restoreBackups(this.clientDir);
            return;
            c = paramString2.charAt(j);
            if (isSafeChar(c)) {
              localStringBuffer.append(c);
            }
          }
        }
        c = paramString1.charAt(j);
        if (isSafeChar(c)) {
          localStringBuffer.append(c);
        }
      }
    }
    throw new MqttPersistenceException();
  }
  
  /* Error */
  public void put(String paramString, org.eclipse.paho.client.mqttv3.MqttPersistable paramMqttPersistable)
    throws MqttPersistenceException
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 64	org/eclipse/paho/client/mqttv3/persist/MqttDefaultFilePersistence:checkIsOpen	()V
    //   4: aload_0
    //   5: getfield 41	org/eclipse/paho/client/mqttv3/persist/MqttDefaultFilePersistence:clientDir	Ljava/io/File;
    //   8: astore_3
    //   9: new 123	java/lang/StringBuilder
    //   12: dup
    //   13: aload_1
    //   14: invokestatic 127	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   17: invokespecial 128	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   20: astore 4
    //   22: aload 4
    //   24: ldc 18
    //   26: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: new 45	java/io/File
    //   33: dup
    //   34: aload_3
    //   35: aload 4
    //   37: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: invokespecial 102	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   43: astore_3
    //   44: aload_0
    //   45: getfield 41	org/eclipse/paho/client/mqttv3/persist/MqttDefaultFilePersistence:clientDir	Ljava/io/File;
    //   48: astore 4
    //   50: new 123	java/lang/StringBuilder
    //   53: dup
    //   54: aload_1
    //   55: invokestatic 127	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   58: invokespecial 128	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   61: astore_1
    //   62: aload_1
    //   63: ldc 18
    //   65: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: aload_1
    //   70: ldc 15
    //   72: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: pop
    //   76: new 45	java/io/File
    //   79: dup
    //   80: aload 4
    //   82: aload_1
    //   83: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   86: invokespecial 102	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   89: astore_1
    //   90: aload_3
    //   91: invokevirtual 138	java/io/File:exists	()Z
    //   94: ifeq +22 -> 116
    //   97: aload_3
    //   98: aload_1
    //   99: invokevirtual 106	java/io/File:renameTo	(Ljava/io/File;)Z
    //   102: ifne +14 -> 116
    //   105: aload_1
    //   106: invokevirtual 110	java/io/File:delete	()Z
    //   109: pop
    //   110: aload_3
    //   111: aload_1
    //   112: invokevirtual 106	java/io/File:renameTo	(Ljava/io/File;)Z
    //   115: pop
    //   116: new 220	java/io/FileOutputStream
    //   119: astore 4
    //   121: aload 4
    //   123: aload_3
    //   124: invokespecial 221	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   127: aload 4
    //   129: aload_2
    //   130: invokeinterface 227 1 0
    //   135: aload_2
    //   136: invokeinterface 230 1 0
    //   141: aload_2
    //   142: invokeinterface 233 1 0
    //   147: invokevirtual 237	java/io/FileOutputStream:write	([BII)V
    //   150: aload_2
    //   151: invokeinterface 240 1 0
    //   156: ifnull +26 -> 182
    //   159: aload 4
    //   161: aload_2
    //   162: invokeinterface 240 1 0
    //   167: aload_2
    //   168: invokeinterface 243 1 0
    //   173: aload_2
    //   174: invokeinterface 246 1 0
    //   179: invokevirtual 237	java/io/FileOutputStream:write	([BII)V
    //   182: aload 4
    //   184: invokevirtual 250	java/io/FileOutputStream:getFD	()Ljava/io/FileDescriptor;
    //   187: invokevirtual 255	java/io/FileDescriptor:sync	()V
    //   190: aload 4
    //   192: invokevirtual 256	java/io/FileOutputStream:close	()V
    //   195: aload_1
    //   196: invokevirtual 138	java/io/File:exists	()Z
    //   199: ifeq +8 -> 207
    //   202: aload_1
    //   203: invokevirtual 110	java/io/File:delete	()Z
    //   206: pop
    //   207: aload_1
    //   208: invokevirtual 138	java/io/File:exists	()Z
    //   211: ifeq +22 -> 233
    //   214: aload_1
    //   215: aload_3
    //   216: invokevirtual 106	java/io/File:renameTo	(Ljava/io/File;)Z
    //   219: ifne +14 -> 233
    //   222: aload_3
    //   223: invokevirtual 110	java/io/File:delete	()Z
    //   226: pop
    //   227: aload_1
    //   228: aload_3
    //   229: invokevirtual 106	java/io/File:renameTo	(Ljava/io/File;)Z
    //   232: pop
    //   233: return
    //   234: astore_2
    //   235: goto +18 -> 253
    //   238: astore_2
    //   239: new 51	org/eclipse/paho/client/mqttv3/MqttPersistenceException
    //   242: astore 4
    //   244: aload 4
    //   246: aload_2
    //   247: invokespecial 163	org/eclipse/paho/client/mqttv3/MqttPersistenceException:<init>	(Ljava/lang/Throwable;)V
    //   250: aload 4
    //   252: athrow
    //   253: aload_1
    //   254: invokevirtual 138	java/io/File:exists	()Z
    //   257: ifeq +22 -> 279
    //   260: aload_1
    //   261: aload_3
    //   262: invokevirtual 106	java/io/File:renameTo	(Ljava/io/File;)Z
    //   265: ifne +14 -> 279
    //   268: aload_3
    //   269: invokevirtual 110	java/io/File:delete	()Z
    //   272: pop
    //   273: aload_1
    //   274: aload_3
    //   275: invokevirtual 106	java/io/File:renameTo	(Ljava/io/File;)Z
    //   278: pop
    //   279: aload_2
    //   280: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	281	0	this	MqttDefaultFilePersistence
    //   0	281	1	paramString	String
    //   0	281	2	paramMqttPersistable	org.eclipse.paho.client.mqttv3.MqttPersistable
    //   8	267	3	localFile	File
    //   20	231	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   116	182	234	finally
    //   182	207	234	finally
    //   239	253	234	finally
    //   116	182	238	java/io/IOException
    //   182	207	238	java/io/IOException
  }
  
  public void remove(String paramString)
    throws MqttPersistenceException
  {
    checkIsOpen();
    File localFile = this.clientDir;
    paramString = new StringBuilder(String.valueOf(paramString));
    paramString.append(".msg");
    paramString = new File(localFile, paramString.toString());
    if (paramString.exists()) {
      paramString.delete();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\eclipse\paho\client\mqttv3\persist\MqttDefaultFilePersistence.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */