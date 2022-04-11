package com.google.gson;

import com.google.gson.internal.d;
import com.google.gson.internal.g;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.b;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

final class DefaultDateTypeAdapter
  extends TypeAdapter<java.util.Date>
{
  private final Class<? extends java.util.Date> a;
  private final List<DateFormat> b;
  
  public DefaultDateTypeAdapter(Class<? extends java.util.Date> paramClass, int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList();
    this.b = localArrayList;
    this.a = c(paramClass);
    paramClass = Locale.US;
    localArrayList.add(DateFormat.getDateTimeInstance(paramInt1, paramInt2, paramClass));
    if (!Locale.getDefault().equals(paramClass)) {
      localArrayList.add(DateFormat.getDateTimeInstance(paramInt1, paramInt2));
    }
    if (d.e()) {
      localArrayList.add(g.c(paramInt1, paramInt2));
    }
  }
  
  DefaultDateTypeAdapter(Class<? extends java.util.Date> paramClass, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    this.b = localArrayList;
    this.a = c(paramClass);
    paramClass = Locale.US;
    localArrayList.add(new SimpleDateFormat(paramString, paramClass));
    if (!Locale.getDefault().equals(paramClass)) {
      localArrayList.add(new SimpleDateFormat(paramString));
    }
  }
  
  private java.util.Date a(String paramString)
  {
    for (;;)
    {
      Object localObject1;
      Object localObject2;
      synchronized (this.b)
      {
        localObject1 = this.b.iterator();
        if (((Iterator)localObject1).hasNext()) {
          localObject2 = (DateFormat)((Iterator)localObject1).next();
        }
      }
      for (;;)
      {
        try
        {
          localObject2 = ((DateFormat)localObject2).parse(paramString);
          return (java.util.Date)localObject2;
        }
        catch (ParseException localParseException2) {}
        try
        {
          localObject1 = new java/text/ParsePosition;
          ((ParsePosition)localObject1).<init>(0);
          localObject1 = com.google.gson.internal.bind.c.a.c(paramString, (ParsePosition)localObject1);
          return (java.util.Date)localObject1;
        }
        catch (ParseException localParseException1)
        {
          localObject1 = new com/google/gson/JsonSyntaxException;
          ((JsonSyntaxException)localObject1).<init>(paramString, localParseException1);
          throw ((Throwable)localObject1);
        }
      }
      paramString = finally;
      throw paramString;
    }
  }
  
  private static Class<? extends java.util.Date> c(Class<? extends java.util.Date> paramClass)
  {
    if ((paramClass != java.util.Date.class) && (paramClass != java.sql.Date.class) && (paramClass != Timestamp.class))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Date type must be one of ");
      localStringBuilder.append(java.util.Date.class);
      localStringBuilder.append(", ");
      localStringBuilder.append(Timestamp.class);
      localStringBuilder.append(", or ");
      localStringBuilder.append(java.sql.Date.class);
      localStringBuilder.append(" but was ");
      localStringBuilder.append(paramClass);
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return paramClass;
  }
  
  public java.util.Date b(com.google.gson.stream.a parama)
    throws IOException
  {
    if (parama.G() == JsonToken.NULL)
    {
      parama.C();
      return null;
    }
    parama = a(parama.E());
    Class localClass = this.a;
    if (localClass == java.util.Date.class) {
      return parama;
    }
    if (localClass == Timestamp.class) {
      return new Timestamp(parama.getTime());
    }
    if (localClass == java.sql.Date.class) {
      return new java.sql.Date(parama.getTime());
    }
    throw new AssertionError();
  }
  
  public void d(b paramb, java.util.Date paramDate)
    throws IOException
  {
    if (paramDate == null)
    {
      paramb.w();
      return;
    }
    synchronized (this.b)
    {
      paramb.J(((DateFormat)this.b.get(0)).format(paramDate));
      return;
    }
  }
  
  public String toString()
  {
    DateFormat localDateFormat = (DateFormat)this.b.get(0);
    if ((localDateFormat instanceof SimpleDateFormat))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("DefaultDateTypeAdapter(");
      localStringBuilder.append(((SimpleDateFormat)localDateFormat).toPattern());
      localStringBuilder.append(')');
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DefaultDateTypeAdapter(");
    localStringBuilder.append(localDateFormat.getClass().getSimpleName());
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\gson\DefaultDateTypeAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */