package io.netty.util.internal;

import java.util.Iterator;
import java.util.List;

public final class ThrowableUtil
{
  @SuppressJava6Requirement(reason="Throwable addSuppressed is only available for >= 7. Has check for < 7.")
  public static void addSuppressed(Throwable paramThrowable1, Throwable paramThrowable2)
  {
    if (!haveSuppressed()) {
      return;
    }
    paramThrowable1.addSuppressed(paramThrowable2);
  }
  
  public static void addSuppressed(Throwable paramThrowable, List<Throwable> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      addSuppressed(paramThrowable, (Throwable)paramList.next());
    }
  }
  
  public static void addSuppressedAndClear(Throwable paramThrowable, List<Throwable> paramList)
  {
    addSuppressed(paramThrowable, paramList);
    paramList.clear();
  }
  
  public static boolean haveSuppressed()
  {
    boolean bool;
    if (PlatformDependent.javaVersion() >= 7) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  /* Error */
  public static String stackTraceToString(Throwable paramThrowable)
  {
    // Byte code:
    //   0: new 62	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 63	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore_1
    //   8: new 65	java/io/PrintStream
    //   11: dup
    //   12: aload_1
    //   13: invokespecial 68	java/io/PrintStream:<init>	(Ljava/io/OutputStream;)V
    //   16: astore_2
    //   17: aload_0
    //   18: aload_2
    //   19: invokevirtual 72	java/lang/Throwable:printStackTrace	(Ljava/io/PrintStream;)V
    //   22: aload_2
    //   23: invokevirtual 75	java/io/PrintStream:flush	()V
    //   26: new 77	java/lang/String
    //   29: dup
    //   30: aload_1
    //   31: invokevirtual 81	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   34: invokespecial 84	java/lang/String:<init>	([B)V
    //   37: astore_0
    //   38: aload_1
    //   39: invokevirtual 87	java/io/ByteArrayOutputStream:close	()V
    //   42: aload_0
    //   43: areturn
    //   44: astore_0
    //   45: aload_1
    //   46: invokevirtual 87	java/io/ByteArrayOutputStream:close	()V
    //   49: aload_0
    //   50: athrow
    //   51: astore_1
    //   52: goto -10 -> 42
    //   55: astore_1
    //   56: goto -7 -> 49
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	paramThrowable	Throwable
    //   7	39	1	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   51	1	1	localIOException1	java.io.IOException
    //   55	1	1	localIOException2	java.io.IOException
    //   16	7	2	localPrintStream	java.io.PrintStream
    // Exception table:
    //   from	to	target	type
    //   26	38	44	finally
    //   38	42	51	java/io/IOException
    //   45	49	55	java/io/IOException
  }
  
  public static <T extends Throwable> T unknownStackTrace(T paramT, Class<?> paramClass, String paramString)
  {
    paramT.setStackTrace(new StackTraceElement[] { new StackTraceElement(paramClass.getName(), paramString, null, -1) });
    return paramT;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\internal\ThrowableUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */