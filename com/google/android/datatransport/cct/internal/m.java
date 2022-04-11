package com.google.android.datatransport.cct.internal;

import android.util.JsonReader;
import android.util.JsonToken;
import androidx.annotation.NonNull;
import com.google.auto.value.AutoValue;
import java.io.IOException;
import java.io.Reader;

@AutoValue
public abstract class m
{
  static m a(long paramLong)
  {
    return new h(paramLong);
  }
  
  @NonNull
  public static m b(@NonNull Reader paramReader)
    throws IOException
  {
    paramReader = new JsonReader(paramReader);
    try
    {
      paramReader.beginObject();
      while (paramReader.hasNext())
      {
        if (paramReader.nextName().equals("nextRequestWaitMillis"))
        {
          if (paramReader.peek() == JsonToken.STRING)
          {
            localObject1 = a(Long.parseLong(paramReader.nextString()));
            return (m)localObject1;
          }
          localObject1 = a(paramReader.nextLong());
          return (m)localObject1;
        }
        paramReader.skipValue();
      }
      Object localObject1 = new java/io/IOException;
      ((IOException)localObject1).<init>("Response is missing nextRequestWaitMillis field.");
      throw ((Throwable)localObject1);
    }
    finally
    {
      paramReader.close();
    }
  }
  
  public abstract long c();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\datatransport\cct\internal\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */