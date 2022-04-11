package com.google.gson;

import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

public abstract class TypeAdapter<T>
{
  public final T fromJson(Reader paramReader)
    throws IOException
  {
    return (T)read(new com.google.gson.stream.a(paramReader));
  }
  
  public final T fromJson(String paramString)
    throws IOException
  {
    return (T)fromJson(new StringReader(paramString));
  }
  
  public final T fromJsonTree(i parami)
  {
    try
    {
      com.google.gson.internal.bind.a locala = new com/google/gson/internal/bind/a;
      locala.<init>(parami);
      parami = read(locala);
      return parami;
    }
    catch (IOException parami)
    {
      throw new JsonIOException(parami);
    }
  }
  
  public final TypeAdapter<T> nullSafe()
  {
    new TypeAdapter()
    {
      public T read(com.google.gson.stream.a paramAnonymousa)
        throws IOException
      {
        if (paramAnonymousa.G() == JsonToken.NULL)
        {
          paramAnonymousa.C();
          return null;
        }
        return (T)TypeAdapter.this.read(paramAnonymousa);
      }
      
      public void write(com.google.gson.stream.b paramAnonymousb, T paramAnonymousT)
        throws IOException
      {
        if (paramAnonymousT == null) {
          paramAnonymousb.w();
        } else {
          TypeAdapter.this.write(paramAnonymousb, paramAnonymousT);
        }
      }
    };
  }
  
  public abstract T read(com.google.gson.stream.a parama)
    throws IOException;
  
  public final String toJson(T paramT)
  {
    StringWriter localStringWriter = new StringWriter();
    try
    {
      toJson(localStringWriter, paramT);
      return localStringWriter.toString();
    }
    catch (IOException paramT)
    {
      throw new AssertionError(paramT);
    }
  }
  
  public final void toJson(Writer paramWriter, T paramT)
    throws IOException
  {
    write(new com.google.gson.stream.b(paramWriter), paramT);
  }
  
  public final i toJsonTree(T paramT)
  {
    try
    {
      com.google.gson.internal.bind.b localb = new com/google/gson/internal/bind/b;
      localb.<init>();
      write(localb, paramT);
      paramT = localb.M();
      return paramT;
    }
    catch (IOException paramT)
    {
      throw new JsonIOException(paramT);
    }
  }
  
  public abstract void write(com.google.gson.stream.b paramb, T paramT)
    throws IOException;
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\gson\TypeAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */