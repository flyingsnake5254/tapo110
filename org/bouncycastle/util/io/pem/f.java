package org.bouncycastle.util.io.pem;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;
import java.util.List;
import org.bouncycastle.util.i;

public class f
  extends BufferedWriter
{
  private final int c;
  private char[] d = new char[64];
  
  public f(Writer paramWriter)
  {
    super(paramWriter);
    paramWriter = i.d();
    int i;
    if (paramWriter != null) {
      i = paramWriter.length();
    } else {
      i = 2;
    }
    this.c = i;
  }
  
  private void a(byte[] paramArrayOfByte)
    throws IOException
  {
    paramArrayOfByte = org.bouncycastle.util.encoders.a.b(paramArrayOfByte);
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      char[] arrayOfChar;
      for (int j = 0;; j++)
      {
        arrayOfChar = this.d;
        if (j == arrayOfChar.length) {
          break;
        }
        int k = i + j;
        if (k >= paramArrayOfByte.length) {
          break;
        }
        arrayOfChar[j] = ((char)(char)paramArrayOfByte[k]);
      }
      write(arrayOfChar, 0, j);
      newLine();
      i += this.d.length;
    }
  }
  
  private void e(String paramString)
    throws IOException
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("-----END ");
    localStringBuilder.append(paramString);
    localStringBuilder.append("-----");
    write(localStringBuilder.toString());
    newLine();
  }
  
  private void g(String paramString)
    throws IOException
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("-----BEGIN ");
    localStringBuilder.append(paramString);
    localStringBuilder.append("-----");
    write(localStringBuilder.toString());
    newLine();
  }
  
  public void c(c paramc)
    throws IOException
  {
    paramc = paramc.a();
    g(paramc.d());
    if (!paramc.c().isEmpty())
    {
      Iterator localIterator = paramc.c().iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        write(locala.b());
        write(": ");
        write(locala.c());
        newLine();
      }
      newLine();
    }
    a(paramc.b());
    e(paramc.d());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\util\io\pem\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */