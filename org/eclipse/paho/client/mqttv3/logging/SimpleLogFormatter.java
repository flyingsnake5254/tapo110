package org.eclipse.paho.client.mqttv3.logging;

import java.util.logging.Formatter;

public class SimpleLogFormatter
  extends Formatter
{
  private static final String LS = System.getProperty("line.separator");
  
  public static String left(String paramString, int paramInt, char paramChar)
  {
    if (paramString.length() >= paramInt) {
      return paramString;
    }
    StringBuffer localStringBuffer = new StringBuffer(paramInt);
    localStringBuffer.append(paramString);
    paramInt -= paramString.length();
    for (;;)
    {
      paramInt--;
      if (paramInt < 0) {
        return localStringBuffer.toString();
      }
      localStringBuffer.append(paramChar);
    }
  }
  
  /* Error */
  public String format(java.util.logging.LogRecord paramLogRecord)
  {
    // Byte code:
    //   0: new 32	java/lang/StringBuffer
    //   3: dup
    //   4: invokespecial 51	java/lang/StringBuffer:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: aload_1
    //   10: invokevirtual 57	java/util/logging/LogRecord:getLevel	()Ljava/util/logging/Level;
    //   13: invokevirtual 62	java/util/logging/Level:getName	()Ljava/lang/String;
    //   16: invokevirtual 39	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   19: pop
    //   20: aload_2
    //   21: ldc 64
    //   23: invokevirtual 39	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   26: pop
    //   27: new 66	java/lang/StringBuilder
    //   30: dup
    //   31: ldc 68
    //   33: iconst_1
    //   34: anewarray 70	java/lang/Object
    //   37: dup
    //   38: iconst_0
    //   39: new 72	java/util/Date
    //   42: dup
    //   43: aload_1
    //   44: invokevirtual 76	java/util/logging/LogRecord:getMillis	()J
    //   47: invokespecial 79	java/util/Date:<init>	(J)V
    //   50: aastore
    //   51: invokestatic 84	java/text/MessageFormat:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   54: invokestatic 88	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   57: invokespecial 91	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   60: astore_3
    //   61: aload_3
    //   62: ldc 64
    //   64: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: pop
    //   68: aload_2
    //   69: aload_3
    //   70: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: invokevirtual 39	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   76: pop
    //   77: aload_1
    //   78: invokevirtual 98	java/util/logging/LogRecord:getSourceClassName	()Ljava/lang/String;
    //   81: astore 4
    //   83: aload 4
    //   85: ifnull +71 -> 156
    //   88: aload 4
    //   90: invokevirtual 30	java/lang/String:length	()I
    //   93: istore 5
    //   95: iload 5
    //   97: bipush 20
    //   99: if_icmple +19 -> 118
    //   102: aload_1
    //   103: invokevirtual 98	java/util/logging/LogRecord:getSourceClassName	()Ljava/lang/String;
    //   106: iload 5
    //   108: bipush 19
    //   110: isub
    //   111: invokevirtual 102	java/lang/String:substring	(I)Ljava/lang/String;
    //   114: astore_3
    //   115: goto +44 -> 159
    //   118: new 32	java/lang/StringBuffer
    //   121: dup
    //   122: invokespecial 51	java/lang/StringBuffer:<init>	()V
    //   125: astore_3
    //   126: aload_3
    //   127: aload 4
    //   129: invokevirtual 39	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   132: pop
    //   133: aload_3
    //   134: iconst_1
    //   135: newarray <illegal type>
    //   137: dup
    //   138: iconst_0
    //   139: bipush 32
    //   141: castore
    //   142: iconst_0
    //   143: iconst_1
    //   144: invokevirtual 105	java/lang/StringBuffer:append	([CII)Ljava/lang/StringBuffer;
    //   147: pop
    //   148: aload_3
    //   149: invokevirtual 43	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   152: astore_3
    //   153: goto +6 -> 159
    //   156: ldc 107
    //   158: astore_3
    //   159: aload_2
    //   160: aload_3
    //   161: invokevirtual 39	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   164: pop
    //   165: aload_2
    //   166: ldc 64
    //   168: invokevirtual 39	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   171: pop
    //   172: aload_2
    //   173: ldc 109
    //   175: invokevirtual 39	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   178: pop
    //   179: aload_2
    //   180: aload_1
    //   181: invokevirtual 112	java/util/logging/LogRecord:getSourceMethodName	()Ljava/lang/String;
    //   184: bipush 23
    //   186: bipush 32
    //   188: invokestatic 114	org/eclipse/paho/client/mqttv3/logging/SimpleLogFormatter:left	(Ljava/lang/String;IC)Ljava/lang/String;
    //   191: invokevirtual 39	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   194: pop
    //   195: aload_2
    //   196: ldc 64
    //   198: invokevirtual 39	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   201: pop
    //   202: aload_2
    //   203: aload_1
    //   204: invokevirtual 117	java/util/logging/LogRecord:getThreadID	()I
    //   207: invokevirtual 120	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
    //   210: pop
    //   211: aload_2
    //   212: ldc 64
    //   214: invokevirtual 39	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   217: pop
    //   218: aload_2
    //   219: aload_0
    //   220: aload_1
    //   221: invokevirtual 123	java/util/logging/Formatter:formatMessage	(Ljava/util/logging/LogRecord;)Ljava/lang/String;
    //   224: invokevirtual 39	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   227: pop
    //   228: aload_2
    //   229: getstatic 18	org/eclipse/paho/client/mqttv3/logging/SimpleLogFormatter:LS	Ljava/lang/String;
    //   232: invokevirtual 39	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   235: pop
    //   236: aload_1
    //   237: invokevirtual 127	java/util/logging/LogRecord:getThrown	()Ljava/lang/Throwable;
    //   240: ifnull +79 -> 319
    //   243: aload_2
    //   244: ldc -127
    //   246: invokevirtual 39	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   249: pop
    //   250: aload_1
    //   251: invokevirtual 127	java/util/logging/LogRecord:getThrown	()Ljava/lang/Throwable;
    //   254: astore 6
    //   256: aconst_null
    //   257: astore_3
    //   258: new 131	java/io/StringWriter
    //   261: astore_1
    //   262: aload_1
    //   263: invokespecial 132	java/io/StringWriter:<init>	()V
    //   266: new 134	java/io/PrintWriter
    //   269: astore 4
    //   271: aload 4
    //   273: aload_1
    //   274: invokespecial 137	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
    //   277: aload 6
    //   279: aload 4
    //   281: invokevirtual 143	java/lang/Throwable:printStackTrace	(Ljava/io/PrintWriter;)V
    //   284: aload_2
    //   285: aload_1
    //   286: invokevirtual 144	java/io/StringWriter:toString	()Ljava/lang/String;
    //   289: invokevirtual 39	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   292: pop
    //   293: aload 4
    //   295: invokevirtual 147	java/io/PrintWriter:close	()V
    //   298: goto +21 -> 319
    //   301: astore_1
    //   302: aload 4
    //   304: astore_3
    //   305: goto +4 -> 309
    //   308: astore_1
    //   309: aload_3
    //   310: ifnull +7 -> 317
    //   313: aload_3
    //   314: invokevirtual 147	java/io/PrintWriter:close	()V
    //   317: aload_1
    //   318: athrow
    //   319: aload_2
    //   320: invokevirtual 43	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   323: areturn
    //   324: astore_1
    //   325: goto -6 -> 319
    //   328: astore_3
    //   329: goto -12 -> 317
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	332	0	this	SimpleLogFormatter
    //   0	332	1	paramLogRecord	java.util.logging.LogRecord
    //   7	313	2	localStringBuffer	StringBuffer
    //   60	254	3	localObject1	Object
    //   328	1	3	localException	Exception
    //   81	222	4	localObject2	Object
    //   93	18	5	i	int
    //   254	24	6	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   277	293	301	finally
    //   258	277	308	finally
    //   293	298	324	java/lang/Exception
    //   313	317	328	java/lang/Exception
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\eclipse\paho\client\mqttv3\logging\SimpleLogFormatter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */