package io.netty.util.internal.logging;

import java.util.HashSet;
import java.util.Set;

final class MessageFormatter
{
  private static final String DELIM_STR = "{}";
  private static final char ESCAPE_CHAR = '\\';
  
  static FormattingTuple arrayFormat(String paramString, Object[] paramArrayOfObject)
  {
    Object localObject1 = null;
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length != 0))
    {
      int i = paramArrayOfObject.length - 1;
      Object localObject2 = paramArrayOfObject[i];
      if ((localObject2 instanceof Throwable)) {
        localObject2 = (Throwable)localObject2;
      } else {
        localObject2 = null;
      }
      if (paramString == null) {
        return new FormattingTuple(null, (Throwable)localObject2);
      }
      int j = paramString.indexOf("{}");
      if (j == -1) {
        return new FormattingTuple(paramString, (Throwable)localObject2);
      }
      StringBuilder localStringBuilder = new StringBuilder(paramString.length() + 50);
      int k = 0;
      int m = 0;
      int n;
      int i1;
      int i2;
      do
      {
        if ((j != 0) && (paramString.charAt(j - 1) == '\\')) {
          n = 0;
        } else {
          n = 1;
        }
        if (n != 0)
        {
          localStringBuilder.append(paramString, k, j);
        }
        else
        {
          localStringBuilder.append(paramString, k, j - 1);
          if ((j >= 2) && (paramString.charAt(j - 2) == '\\')) {
            n = 1;
          } else {
            n = 0;
          }
        }
        i1 = j + 2;
        if (n != 0)
        {
          deeplyAppendParameter(localStringBuilder, paramArrayOfObject[m], null);
          m++;
          n = m;
          if (m > i)
          {
            n = m;
            break;
          }
        }
        else
        {
          localStringBuilder.append("{}");
          n = m;
        }
        i2 = paramString.indexOf("{}", i1);
        j = i2;
        k = i1;
        m = n;
      } while (i2 != -1);
      localStringBuilder.append(paramString, i1, paramString.length());
      paramArrayOfObject = localStringBuilder.toString();
      paramString = (String)localObject1;
      if (n <= i) {
        paramString = (String)localObject2;
      }
      return new FormattingTuple(paramArrayOfObject, paramString);
    }
    return new FormattingTuple(paramString, null);
  }
  
  private static void booleanArrayAppend(StringBuilder paramStringBuilder, boolean[] paramArrayOfBoolean)
  {
    if (paramArrayOfBoolean.length == 0) {
      return;
    }
    paramStringBuilder.append(paramArrayOfBoolean[0]);
    for (int i = 1; i < paramArrayOfBoolean.length; i++)
    {
      paramStringBuilder.append(", ");
      paramStringBuilder.append(paramArrayOfBoolean[i]);
    }
  }
  
  private static void byteArrayAppend(StringBuilder paramStringBuilder, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length == 0) {
      return;
    }
    paramStringBuilder.append(paramArrayOfByte[0]);
    for (int i = 1; i < paramArrayOfByte.length; i++)
    {
      paramStringBuilder.append(", ");
      paramStringBuilder.append(paramArrayOfByte[i]);
    }
  }
  
  private static void charArrayAppend(StringBuilder paramStringBuilder, char[] paramArrayOfChar)
  {
    if (paramArrayOfChar.length == 0) {
      return;
    }
    paramStringBuilder.append(paramArrayOfChar[0]);
    for (int i = 1; i < paramArrayOfChar.length; i++)
    {
      paramStringBuilder.append(", ");
      paramStringBuilder.append(paramArrayOfChar[i]);
    }
  }
  
  private static void deeplyAppendParameter(StringBuilder paramStringBuilder, Object paramObject, Set<Object[]> paramSet)
  {
    if (paramObject == null)
    {
      paramStringBuilder.append("null");
      return;
    }
    Class localClass = paramObject.getClass();
    if (!localClass.isArray())
    {
      if (Number.class.isAssignableFrom(localClass))
      {
        if (localClass == Long.class) {
          paramStringBuilder.append(((Long)paramObject).longValue());
        } else if ((localClass != Integer.class) && (localClass != Short.class) && (localClass != Byte.class))
        {
          if (localClass == Double.class) {
            paramStringBuilder.append(((Double)paramObject).doubleValue());
          } else if (localClass == Float.class) {
            paramStringBuilder.append(((Float)paramObject).floatValue());
          } else {
            safeObjectAppend(paramStringBuilder, paramObject);
          }
        }
        else {
          paramStringBuilder.append(((Number)paramObject).intValue());
        }
      }
      else {
        safeObjectAppend(paramStringBuilder, paramObject);
      }
    }
    else
    {
      paramStringBuilder.append('[');
      if (localClass == boolean[].class) {
        booleanArrayAppend(paramStringBuilder, (boolean[])paramObject);
      } else if (localClass == byte[].class) {
        byteArrayAppend(paramStringBuilder, (byte[])paramObject);
      } else if (localClass == char[].class) {
        charArrayAppend(paramStringBuilder, (char[])paramObject);
      } else if (localClass == short[].class) {
        shortArrayAppend(paramStringBuilder, (short[])paramObject);
      } else if (localClass == int[].class) {
        intArrayAppend(paramStringBuilder, (int[])paramObject);
      } else if (localClass == long[].class) {
        longArrayAppend(paramStringBuilder, (long[])paramObject);
      } else if (localClass == float[].class) {
        floatArrayAppend(paramStringBuilder, (float[])paramObject);
      } else if (localClass == double[].class) {
        doubleArrayAppend(paramStringBuilder, (double[])paramObject);
      } else {
        objectArrayAppend(paramStringBuilder, (Object[])paramObject, paramSet);
      }
      paramStringBuilder.append(']');
    }
  }
  
  private static void doubleArrayAppend(StringBuilder paramStringBuilder, double[] paramArrayOfDouble)
  {
    if (paramArrayOfDouble.length == 0) {
      return;
    }
    paramStringBuilder.append(paramArrayOfDouble[0]);
    for (int i = 1; i < paramArrayOfDouble.length; i++)
    {
      paramStringBuilder.append(", ");
      paramStringBuilder.append(paramArrayOfDouble[i]);
    }
  }
  
  private static void floatArrayAppend(StringBuilder paramStringBuilder, float[] paramArrayOfFloat)
  {
    if (paramArrayOfFloat.length == 0) {
      return;
    }
    paramStringBuilder.append(paramArrayOfFloat[0]);
    for (int i = 1; i < paramArrayOfFloat.length; i++)
    {
      paramStringBuilder.append(", ");
      paramStringBuilder.append(paramArrayOfFloat[i]);
    }
  }
  
  static FormattingTuple format(String paramString, Object paramObject)
  {
    return arrayFormat(paramString, new Object[] { paramObject });
  }
  
  static FormattingTuple format(String paramString, Object paramObject1, Object paramObject2)
  {
    return arrayFormat(paramString, new Object[] { paramObject1, paramObject2 });
  }
  
  private static void intArrayAppend(StringBuilder paramStringBuilder, int[] paramArrayOfInt)
  {
    if (paramArrayOfInt.length == 0) {
      return;
    }
    paramStringBuilder.append(paramArrayOfInt[0]);
    for (int i = 1; i < paramArrayOfInt.length; i++)
    {
      paramStringBuilder.append(", ");
      paramStringBuilder.append(paramArrayOfInt[i]);
    }
  }
  
  private static void longArrayAppend(StringBuilder paramStringBuilder, long[] paramArrayOfLong)
  {
    if (paramArrayOfLong.length == 0) {
      return;
    }
    paramStringBuilder.append(paramArrayOfLong[0]);
    for (int i = 1; i < paramArrayOfLong.length; i++)
    {
      paramStringBuilder.append(", ");
      paramStringBuilder.append(paramArrayOfLong[i]);
    }
  }
  
  private static void objectArrayAppend(StringBuilder paramStringBuilder, Object[] paramArrayOfObject, Set<Object[]> paramSet)
  {
    if (paramArrayOfObject.length == 0) {
      return;
    }
    Object localObject = paramSet;
    if (paramSet == null) {
      localObject = new HashSet(paramArrayOfObject.length);
    }
    if (((Set)localObject).add(paramArrayOfObject))
    {
      deeplyAppendParameter(paramStringBuilder, paramArrayOfObject[0], (Set)localObject);
      for (int i = 1; i < paramArrayOfObject.length; i++)
      {
        paramStringBuilder.append(", ");
        deeplyAppendParameter(paramStringBuilder, paramArrayOfObject[i], (Set)localObject);
      }
      ((Set)localObject).remove(paramArrayOfObject);
    }
    else
    {
      paramStringBuilder.append("...");
    }
  }
  
  /* Error */
  private static void safeObjectAppend(StringBuilder paramStringBuilder, Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual 208	java/lang/Object:toString	()Ljava/lang/String;
    //   5: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8: pop
    //   9: goto +66 -> 75
    //   12: astore_2
    //   13: getstatic 214	java/lang/System:err	Ljava/io/PrintStream;
    //   16: astore_3
    //   17: new 33	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 215	java/lang/StringBuilder:<init>	()V
    //   24: astore 4
    //   26: aload 4
    //   28: ldc -39
    //   30: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: pop
    //   34: aload 4
    //   36: aload_1
    //   37: invokevirtual 85	java/lang/Object:getClass	()Ljava/lang/Class;
    //   40: invokevirtual 220	java/lang/Class:getName	()Ljava/lang/String;
    //   43: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: aload 4
    //   49: bipush 93
    //   51: invokevirtual 79	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   54: pop
    //   55: aload_3
    //   56: aload 4
    //   58: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: invokevirtual 226	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   64: aload_2
    //   65: invokevirtual 229	java/lang/Throwable:printStackTrace	()V
    //   68: aload_0
    //   69: ldc -25
    //   71: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: pop
    //   75: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	paramStringBuilder	StringBuilder
    //   0	76	1	paramObject	Object
    //   12	53	2	localObject	Object
    //   16	40	3	localPrintStream	java.io.PrintStream
    //   24	33	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   0	9	12	finally
  }
  
  private static void shortArrayAppend(StringBuilder paramStringBuilder, short[] paramArrayOfShort)
  {
    if (paramArrayOfShort.length == 0) {
      return;
    }
    paramStringBuilder.append(paramArrayOfShort[0]);
    for (int i = 1; i < paramArrayOfShort.length; i++)
    {
      paramStringBuilder.append(", ");
      paramStringBuilder.append(paramArrayOfShort[i]);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\internal\logging\MessageFormatter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */