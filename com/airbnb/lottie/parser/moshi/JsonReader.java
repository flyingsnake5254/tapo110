package com.airbnb.lottie.parser.moshi;

import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Options;

public abstract class JsonReader
  implements Closeable
{
  private static final String[] c = new String[''];
  int d;
  int[] f = new int[32];
  String[] q = new String[32];
  int[] x = new int[32];
  boolean y;
  boolean z;
  
  static
  {
    for (int i = 0; i <= 31; i++) {
      c[i] = String.format("\\u%04x", new Object[] { Integer.valueOf(i) });
    }
    String[] arrayOfString = c;
    arrayOfString[34] = "\\\"";
    arrayOfString[92] = "\\\\";
    arrayOfString[9] = "\\t";
    arrayOfString[8] = "\\b";
    arrayOfString[10] = "\\n";
    arrayOfString[13] = "\\r";
    arrayOfString[12] = "\\f";
  }
  
  private static void B(BufferedSink paramBufferedSink, String paramString)
    throws IOException
  {
    String[] arrayOfString = c;
    paramBufferedSink.writeByte(34);
    int i = paramString.length();
    int j = 0;
    int n;
    for (int k = 0; j < i; k = n)
    {
      int m = paramString.charAt(j);
      String str2;
      if (m < 128)
      {
        String str1 = arrayOfString[m];
        str2 = str1;
        if (str1 == null)
        {
          n = k;
          break label133;
        }
      }
      else if (m == 8232)
      {
        str2 = "\\u2028";
      }
      else
      {
        n = k;
        if (m != 8233) {
          break label133;
        }
        str2 = "\\u2029";
      }
      if (k < j) {
        paramBufferedSink.writeUtf8(paramString, k, j);
      }
      paramBufferedSink.writeUtf8(str2);
      n = j + 1;
      label133:
      j++;
    }
    if (k < i) {
      paramBufferedSink.writeUtf8(paramString, k, i);
    }
    paramBufferedSink.writeByte(34);
  }
  
  public static JsonReader v(BufferedSource paramBufferedSource)
  {
    return new d(paramBufferedSource);
  }
  
  public abstract void A()
    throws IOException;
  
  final b C(String paramString)
    throws b
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(" at path ");
    localStringBuilder.append(getPath());
    throw new b(localStringBuilder.toString());
  }
  
  public abstract void c()
    throws IOException;
  
  public abstract void e()
    throws IOException;
  
  public abstract void g()
    throws IOException;
  
  public final String getPath()
  {
    return c.a(this.d, this.f, this.q, this.x);
  }
  
  public abstract void i()
    throws IOException;
  
  public abstract boolean j()
    throws IOException;
  
  public abstract boolean k()
    throws IOException;
  
  public abstract double l()
    throws IOException;
  
  public abstract int s()
    throws IOException;
  
  public abstract String t()
    throws IOException;
  
  public abstract String u()
    throws IOException;
  
  public abstract Token w()
    throws IOException;
  
  final void x(int paramInt)
  {
    int i = this.d;
    Object localObject = this.f;
    if (i == localObject.length) {
      if (i != 256)
      {
        this.f = Arrays.copyOf((int[])localObject, localObject.length * 2);
        localObject = this.q;
        this.q = ((String[])Arrays.copyOf((Object[])localObject, localObject.length * 2));
        localObject = this.x;
        this.x = Arrays.copyOf((int[])localObject, localObject.length * 2);
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Nesting too deep at ");
        ((StringBuilder)localObject).append(getPath());
        throw new a(((StringBuilder)localObject).toString());
      }
    }
    localObject = this.f;
    i = this.d;
    this.d = (i + 1);
    localObject[i] = paramInt;
  }
  
  public abstract int y(a parama)
    throws IOException;
  
  public abstract void z()
    throws IOException;
  
  public static enum Token
  {
    static
    {
      Token localToken1 = new Token("BEGIN_ARRAY", 0);
      BEGIN_ARRAY = localToken1;
      Token localToken2 = new Token("END_ARRAY", 1);
      END_ARRAY = localToken2;
      Token localToken3 = new Token("BEGIN_OBJECT", 2);
      BEGIN_OBJECT = localToken3;
      Token localToken4 = new Token("END_OBJECT", 3);
      END_OBJECT = localToken4;
      Token localToken5 = new Token("NAME", 4);
      NAME = localToken5;
      Token localToken6 = new Token("STRING", 5);
      STRING = localToken6;
      Token localToken7 = new Token("NUMBER", 6);
      NUMBER = localToken7;
      Token localToken8 = new Token("BOOLEAN", 7);
      BOOLEAN = localToken8;
      Token localToken9 = new Token("NULL", 8);
      NULL = localToken9;
      Token localToken10 = new Token("END_DOCUMENT", 9);
      END_DOCUMENT = localToken10;
      $VALUES = new Token[] { localToken1, localToken2, localToken3, localToken4, localToken5, localToken6, localToken7, localToken8, localToken9, localToken10 };
    }
  }
  
  public static final class a
  {
    final String[] a;
    final Options b;
    
    private a(String[] paramArrayOfString, Options paramOptions)
    {
      this.a = paramArrayOfString;
      this.b = paramOptions;
    }
    
    public static a a(String... paramVarArgs)
    {
      try
      {
        ByteString[] arrayOfByteString = new ByteString[paramVarArgs.length];
        Buffer localBuffer = new okio/Buffer;
        localBuffer.<init>();
        for (int i = 0; i < paramVarArgs.length; i++)
        {
          JsonReader.a(localBuffer, paramVarArgs[i]);
          localBuffer.readByte();
          arrayOfByteString[i] = localBuffer.readByteString();
        }
        paramVarArgs = new a((String[])paramVarArgs.clone(), Options.of(arrayOfByteString));
        return paramVarArgs;
      }
      catch (IOException paramVarArgs)
      {
        throw new AssertionError(paramVarArgs);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\parser\moshi\JsonReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */