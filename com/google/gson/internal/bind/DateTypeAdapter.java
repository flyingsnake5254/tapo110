package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.d;
import com.google.gson.internal.g;
import com.google.gson.p;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.b;
import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public final class DateTypeAdapter
  extends TypeAdapter<Date>
{
  public static final p a = new p()
  {
    public <T> TypeAdapter<T> a(Gson paramAnonymousGson, com.google.gson.r.a<T> paramAnonymousa)
    {
      if (paramAnonymousa.getRawType() == Date.class) {
        paramAnonymousGson = new DateTypeAdapter();
      } else {
        paramAnonymousGson = null;
      }
      return paramAnonymousGson;
    }
  };
  private final List<DateFormat> b;
  
  public DateTypeAdapter()
  {
    ArrayList localArrayList = new ArrayList();
    this.b = localArrayList;
    Locale localLocale = Locale.US;
    localArrayList.add(DateFormat.getDateTimeInstance(2, 2, localLocale));
    if (!Locale.getDefault().equals(localLocale)) {
      localArrayList.add(DateFormat.getDateTimeInstance(2, 2));
    }
    if (d.e()) {
      localArrayList.add(g.c(2, 2));
    }
  }
  
  /* Error */
  private Date a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 26	com/google/gson/internal/bind/DateTypeAdapter:b	Ljava/util/List;
    //   6: invokeinterface 72 1 0
    //   11: astore_2
    //   12: aload_2
    //   13: invokeinterface 77 1 0
    //   18: ifeq +23 -> 41
    //   21: aload_2
    //   22: invokeinterface 81 1 0
    //   27: checkcast 34	java/text/DateFormat
    //   30: astore_3
    //   31: aload_3
    //   32: aload_1
    //   33: invokevirtual 84	java/text/DateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   36: astore_3
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_3
    //   40: areturn
    //   41: new 86	java/text/ParsePosition
    //   44: astore_2
    //   45: aload_2
    //   46: iconst_0
    //   47: invokespecial 89	java/text/ParsePosition:<init>	(I)V
    //   50: aload_1
    //   51: aload_2
    //   52: invokestatic 94	com/google/gson/internal/bind/c/a:c	(Ljava/lang/String;Ljava/text/ParsePosition;)Ljava/util/Date;
    //   55: astore_2
    //   56: aload_0
    //   57: monitorexit
    //   58: aload_2
    //   59: areturn
    //   60: astore_2
    //   61: new 96	com/google/gson/JsonSyntaxException
    //   64: astore_3
    //   65: aload_3
    //   66: aload_1
    //   67: aload_2
    //   68: invokespecial 99	com/google/gson/JsonSyntaxException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   71: aload_3
    //   72: athrow
    //   73: astore_1
    //   74: aload_0
    //   75: monitorexit
    //   76: aload_1
    //   77: athrow
    //   78: astore_3
    //   79: goto -67 -> 12
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	this	DateTypeAdapter
    //   0	82	1	paramString	String
    //   11	48	2	localObject1	Object
    //   60	8	2	localParseException1	java.text.ParseException
    //   30	42	3	localObject2	Object
    //   78	1	3	localParseException2	java.text.ParseException
    // Exception table:
    //   from	to	target	type
    //   41	56	60	java/text/ParseException
    //   2	12	73	finally
    //   12	31	73	finally
    //   31	37	73	finally
    //   41	56	73	finally
    //   61	73	73	finally
    //   31	37	78	java/text/ParseException
  }
  
  public Date b(com.google.gson.stream.a parama)
    throws IOException
  {
    if (parama.G() == JsonToken.NULL)
    {
      parama.C();
      return null;
    }
    return a(parama.E());
  }
  
  public void c(b paramb, Date paramDate)
    throws IOException
  {
    if (paramDate == null) {}
    try
    {
      paramb.w();
      return;
    }
    finally {}
    paramb.J(((DateFormat)this.b.get(0)).format(paramDate));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\gson\internal\bind\DateTypeAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */