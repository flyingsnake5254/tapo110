package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.p;
import com.google.gson.r.a;
import com.google.gson.stream.b;
import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public final class TimeTypeAdapter
  extends TypeAdapter<Time>
{
  public static final p a = new p()
  {
    public <T> TypeAdapter<T> a(Gson paramAnonymousGson, a<T> paramAnonymousa)
    {
      if (paramAnonymousa.getRawType() == Time.class) {
        paramAnonymousGson = new TimeTypeAdapter();
      } else {
        paramAnonymousGson = null;
      }
      return paramAnonymousGson;
    }
  };
  private final DateFormat b = new SimpleDateFormat("hh:mm:ss a");
  
  /* Error */
  public Time a(com.google.gson.stream.a parama)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokevirtual 40	com/google/gson/stream/a:G	()Lcom/google/gson/stream/JsonToken;
    //   6: getstatic 46	com/google/gson/stream/JsonToken:NULL	Lcom/google/gson/stream/JsonToken;
    //   9: if_acmpne +11 -> 20
    //   12: aload_1
    //   13: invokevirtual 49	com/google/gson/stream/a:C	()V
    //   16: aload_0
    //   17: monitorexit
    //   18: aconst_null
    //   19: areturn
    //   20: new 51	java/sql/Time
    //   23: dup
    //   24: aload_0
    //   25: getfield 29	com/google/gson/internal/bind/TimeTypeAdapter:b	Ljava/text/DateFormat;
    //   28: aload_1
    //   29: invokevirtual 55	com/google/gson/stream/a:E	()Ljava/lang/String;
    //   32: invokevirtual 61	java/text/DateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   35: invokevirtual 67	java/util/Date:getTime	()J
    //   38: invokespecial 70	java/sql/Time:<init>	(J)V
    //   41: astore_1
    //   42: aload_0
    //   43: monitorexit
    //   44: aload_1
    //   45: areturn
    //   46: astore_1
    //   47: new 72	com/google/gson/JsonSyntaxException
    //   50: astore_2
    //   51: aload_2
    //   52: aload_1
    //   53: invokespecial 75	com/google/gson/JsonSyntaxException:<init>	(Ljava/lang/Throwable;)V
    //   56: aload_2
    //   57: athrow
    //   58: astore_1
    //   59: aload_0
    //   60: monitorexit
    //   61: aload_1
    //   62: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	63	0	this	TimeTypeAdapter
    //   0	63	1	parama	com.google.gson.stream.a
    //   50	7	2	localJsonSyntaxException	com.google.gson.JsonSyntaxException
    // Exception table:
    //   from	to	target	type
    //   20	42	46	java/text/ParseException
    //   2	16	58	finally
    //   20	42	58	finally
    //   47	58	58	finally
  }
  
  public void b(b paramb, Time paramTime)
    throws IOException
  {
    if (paramTime == null) {
      paramTime = null;
    }
    try
    {
      paramTime = this.b.format(paramTime);
      paramb.J(paramTime);
      return;
    }
    finally {}
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\gson\internal\bind\TimeTypeAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */