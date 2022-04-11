package com.google.gson.internal;

import com.google.gson.JsonIOException;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.j;
import com.google.gson.stream.MalformedJsonException;
import com.google.gson.stream.a;
import com.google.gson.stream.b;
import java.io.EOFException;
import java.io.IOException;
import java.io.Writer;

public final class i
{
  public static com.google.gson.i a(a parama)
    throws JsonParseException
  {
    try
    {
      parama.G();
      int i = 0;
      try
      {
        parama = (com.google.gson.i)TypeAdapters.X.read(parama);
        return parama;
      }
      catch (EOFException parama) {}
      if (i == 0) {
        break label65;
      }
    }
    catch (NumberFormatException parama)
    {
      throw new JsonSyntaxException(parama);
    }
    catch (IOException parama)
    {
      throw new JsonIOException(parama);
    }
    catch (MalformedJsonException parama)
    {
      throw new JsonSyntaxException(parama);
    }
    catch (EOFException parama)
    {
      i = 1;
    }
    return j.a;
    label65:
    throw new JsonSyntaxException(parama);
  }
  
  public static void b(com.google.gson.i parami, b paramb)
    throws IOException
  {
    TypeAdapters.X.write(paramb, parami);
  }
  
  public static Writer c(Appendable paramAppendable)
  {
    if ((paramAppendable instanceof Writer)) {
      paramAppendable = (Writer)paramAppendable;
    } else {
      paramAppendable = new a(paramAppendable);
    }
    return paramAppendable;
  }
  
  private static final class a
    extends Writer
  {
    private final Appendable c;
    private final a d = new a();
    
    a(Appendable paramAppendable)
    {
      this.c = paramAppendable;
    }
    
    public void close() {}
    
    public void flush() {}
    
    public void write(int paramInt)
      throws IOException
    {
      this.c.append((char)paramInt);
    }
    
    public void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
      throws IOException
    {
      a locala = this.d;
      locala.c = paramArrayOfChar;
      this.c.append(locala, paramInt1, paramInt2 + paramInt1);
    }
    
    static class a
      implements CharSequence
    {
      char[] c;
      
      public char charAt(int paramInt)
      {
        return this.c[paramInt];
      }
      
      public int length()
      {
        return this.c.length;
      }
      
      public CharSequence subSequence(int paramInt1, int paramInt2)
      {
        return new String(this.c, paramInt1, paramInt2 - paramInt1);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\gson\internal\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */