package com.google.gson;

import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import com.google.gson.stream.a;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public final class l
{
  /* Error */
  public static i b(a parama)
    throws JsonIOException, JsonSyntaxException
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 27	com/google/gson/stream/a:t	()Z
    //   4: istore_1
    //   5: aload_0
    //   6: iconst_1
    //   7: invokevirtual 31	com/google/gson/stream/a:L	(Z)V
    //   10: aload_0
    //   11: invokestatic 36	com/google/gson/internal/i:a	(Lcom/google/gson/stream/a;)Lcom/google/gson/i;
    //   14: astore_2
    //   15: aload_0
    //   16: iload_1
    //   17: invokevirtual 31	com/google/gson/stream/a:L	(Z)V
    //   20: aload_2
    //   21: areturn
    //   22: astore_2
    //   23: goto +103 -> 126
    //   26: astore_3
    //   27: new 38	com/google/gson/JsonParseException
    //   30: astore_2
    //   31: new 40	java/lang/StringBuilder
    //   34: astore 4
    //   36: aload 4
    //   38: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   41: aload 4
    //   43: ldc 43
    //   45: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: aload 4
    //   51: aload_0
    //   52: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: aload 4
    //   58: ldc 52
    //   60: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: pop
    //   64: aload_2
    //   65: aload 4
    //   67: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: aload_3
    //   71: invokespecial 59	com/google/gson/JsonParseException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   74: aload_2
    //   75: athrow
    //   76: astore_2
    //   77: new 38	com/google/gson/JsonParseException
    //   80: astore_3
    //   81: new 40	java/lang/StringBuilder
    //   84: astore 4
    //   86: aload 4
    //   88: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   91: aload 4
    //   93: ldc 43
    //   95: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: pop
    //   99: aload 4
    //   101: aload_0
    //   102: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   105: pop
    //   106: aload 4
    //   108: ldc 52
    //   110: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: pop
    //   114: aload_3
    //   115: aload 4
    //   117: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: aload_2
    //   121: invokespecial 59	com/google/gson/JsonParseException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   124: aload_3
    //   125: athrow
    //   126: aload_0
    //   127: iload_1
    //   128: invokevirtual 31	com/google/gson/stream/a:L	(Z)V
    //   131: aload_2
    //   132: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	133	0	parama	a
    //   4	124	1	bool	boolean
    //   14	7	2	locali	i
    //   22	1	2	localObject	Object
    //   30	45	2	localJsonParseException1	JsonParseException
    //   76	56	2	localStackOverflowError	StackOverflowError
    //   26	45	3	localOutOfMemoryError	OutOfMemoryError
    //   80	45	3	localJsonParseException2	JsonParseException
    //   34	82	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   10	15	22	finally
    //   27	76	22	finally
    //   77	126	22	finally
    //   10	15	26	java/lang/OutOfMemoryError
    //   10	15	76	java/lang/StackOverflowError
  }
  
  public static i c(Reader paramReader)
    throws JsonIOException, JsonSyntaxException
  {
    try
    {
      a locala = new com/google/gson/stream/a;
      locala.<init>(paramReader);
      paramReader = b(locala);
      if ((!paramReader.g()) && (locala.G() != JsonToken.END_DOCUMENT))
      {
        paramReader = new com/google/gson/JsonSyntaxException;
        paramReader.<init>("Did not consume the entire document.");
        throw paramReader;
      }
      return paramReader;
    }
    catch (NumberFormatException paramReader)
    {
      throw new JsonSyntaxException(paramReader);
    }
    catch (IOException paramReader)
    {
      throw new JsonIOException(paramReader);
    }
    catch (MalformedJsonException paramReader)
    {
      throw new JsonSyntaxException(paramReader);
    }
  }
  
  public static i d(String paramString)
    throws JsonSyntaxException
  {
    return c(new StringReader(paramString));
  }
  
  @Deprecated
  public i a(String paramString)
    throws JsonSyntaxException
  {
    return d(paramString);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\gson\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */