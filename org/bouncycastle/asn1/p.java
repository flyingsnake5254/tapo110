package org.bouncycastle.asn1;

import java.io.IOException;
import java.io.OutputStream;

public class p
{
  private OutputStream a;
  
  public p(OutputStream paramOutputStream)
  {
    this.a = paramOutputStream;
  }
  
  p a()
  {
    return new z0(this.a);
  }
  
  p b()
  {
    return new n1(this.a);
  }
  
  void c(int paramInt)
    throws IOException
  {
    this.a.write(paramInt);
  }
  
  void d(byte[] paramArrayOfByte)
    throws IOException
  {
    this.a.write(paramArrayOfByte);
  }
  
  void e(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    this.a.write(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  void f(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
    throws IOException
  {
    k(paramInt1, paramInt2);
    i(paramArrayOfByte.length);
    d(paramArrayOfByte);
  }
  
  void g(int paramInt, byte[] paramArrayOfByte)
    throws IOException
  {
    c(paramInt);
    i(paramArrayOfByte.length);
    d(paramArrayOfByte);
  }
  
  void h(q paramq)
    throws IOException
  {
    if (paramq != null)
    {
      paramq.g(new a(this.a));
      return;
    }
    throw new IOException("null object detected");
  }
  
  void i(int paramInt)
    throws IOException
  {
    if (paramInt > 127)
    {
      int i = paramInt;
      for (int j = 1;; j++)
      {
        i >>>= 8;
        if (i == 0) {
          break;
        }
      }
      c((byte)(j | 0x80));
      for (j = (j - 1) * 8; j >= 0; j -= 8) {
        c((byte)(paramInt >> j));
      }
    }
    c((byte)paramInt);
  }
  
  public void j(e parame)
    throws IOException
  {
    if (parame != null)
    {
      parame.c().g(this);
      return;
    }
    throw new IOException("null object detected");
  }
  
  void k(int paramInt1, int paramInt2)
    throws IOException
  {
    if (paramInt2 < 31)
    {
      c(paramInt1 | paramInt2);
    }
    else
    {
      c(paramInt1 | 0x1F);
      if (paramInt2 < 128)
      {
        c(paramInt2);
      }
      else
      {
        byte[] arrayOfByte = new byte[5];
        paramInt1 = 4;
        arrayOfByte[4] = ((byte)(byte)(paramInt2 & 0x7F));
        int i;
        int j;
        do
        {
          i = paramInt2 >> 7;
          j = paramInt1 - 1;
          arrayOfByte[j] = ((byte)(byte)(i & 0x7F | 0x80));
          paramInt1 = j;
          paramInt2 = i;
        } while (i > 127);
        e(arrayOfByte, j, 5 - j);
      }
    }
  }
  
  private class a
    extends p
  {
    private boolean b = true;
    
    public a(OutputStream paramOutputStream)
    {
      super();
    }
    
    public void c(int paramInt)
      throws IOException
    {
      if (this.b) {
        this.b = false;
      } else {
        super.c(paramInt);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */