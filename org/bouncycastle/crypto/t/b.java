package org.bouncycastle.crypto.t;

import java.util.Hashtable;
import org.bouncycastle.crypto.g;
import org.bouncycastle.crypto.h;
import org.bouncycastle.crypto.j;
import org.bouncycastle.crypto.w.a0;
import org.bouncycastle.util.d;

public class b
  implements j
{
  private static Hashtable a;
  private g b;
  private int c;
  private int d;
  private org.bouncycastle.util.e e;
  private org.bouncycastle.util.e f;
  private byte[] g;
  private byte[] h;
  
  static
  {
    Hashtable localHashtable = new Hashtable();
    a = localHashtable;
    localHashtable.put("GOST3411", d.b(32));
    a.put("MD2", d.b(16));
    a.put("MD4", d.b(64));
    a.put("MD5", d.b(64));
    a.put("RIPEMD128", d.b(64));
    a.put("RIPEMD160", d.b(64));
    a.put("SHA-1", d.b(64));
    a.put("SHA-224", d.b(64));
    a.put("SHA-256", d.b(64));
    a.put("SHA-384", d.b(128));
    a.put("SHA-512", d.b(128));
    a.put("Tiger", d.b(64));
    a.put("Whirlpool", d.b(64));
  }
  
  public b(g paramg)
  {
    this(paramg, e(paramg));
  }
  
  private b(g paramg, int paramInt)
  {
    this.b = paramg;
    int i = paramg.e();
    this.c = i;
    this.d = paramInt;
    this.g = new byte[paramInt];
    this.h = new byte[paramInt + i];
  }
  
  private static int e(g paramg)
  {
    if ((paramg instanceof h)) {
      return ((h)paramg).k();
    }
    Object localObject = (Integer)a.get(paramg.b());
    if (localObject != null) {
      return ((Integer)localObject).intValue();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("unknown digest passed: ");
    ((StringBuilder)localObject).append(paramg.b());
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  private static void f(byte[] paramArrayOfByte, int paramInt, byte paramByte)
  {
    for (int i = 0; i < paramInt; i++) {
      paramArrayOfByte[i] = ((byte)(byte)(paramArrayOfByte[i] ^ paramByte));
    }
  }
  
  public int a()
  {
    return this.c;
  }
  
  public String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.b.b());
    localStringBuilder.append("/HMAC");
    return localStringBuilder.toString();
  }
  
  public void c(byte paramByte)
  {
    this.b.c(paramByte);
  }
  
  public void d(org.bouncycastle.crypto.e parame)
  {
    this.b.reset();
    parame = ((a0)parame).a();
    int i = parame.length;
    if (i > this.d)
    {
      this.b.update(parame, 0, i);
      this.b.doFinal(this.g, 0);
      i = this.c;
    }
    else
    {
      System.arraycopy(parame, 0, this.g, 0, i);
    }
    for (;;)
    {
      parame = this.g;
      if (i >= parame.length) {
        break;
      }
      parame[i] = ((byte)0);
      i++;
    }
    System.arraycopy(parame, 0, this.h, 0, this.d);
    f(this.g, this.d, (byte)54);
    f(this.h, this.d, (byte)92);
    parame = this.b;
    if ((parame instanceof org.bouncycastle.util.e))
    {
      parame = ((org.bouncycastle.util.e)parame).copy();
      this.f = parame;
      ((g)parame).update(this.h, 0, this.d);
    }
    parame = this.b;
    byte[] arrayOfByte = this.g;
    parame.update(arrayOfByte, 0, arrayOfByte.length);
    parame = this.b;
    if ((parame instanceof org.bouncycastle.util.e)) {
      this.e = ((org.bouncycastle.util.e)parame).copy();
    }
  }
  
  public int doFinal(byte[] paramArrayOfByte, int paramInt)
  {
    this.b.doFinal(this.h, this.d);
    Object localObject = this.f;
    if (localObject != null)
    {
      ((org.bouncycastle.util.e)this.b).m((org.bouncycastle.util.e)localObject);
      localObject = this.b;
      ((g)localObject).update(this.h, this.d, ((g)localObject).e());
    }
    else
    {
      localObject = this.b;
      byte[] arrayOfByte = this.h;
      ((g)localObject).update(arrayOfByte, 0, arrayOfByte.length);
    }
    int i = this.b.doFinal(paramArrayOfByte, paramInt);
    for (paramInt = this.d;; paramInt++)
    {
      paramArrayOfByte = this.h;
      if (paramInt >= paramArrayOfByte.length) {
        break;
      }
      paramArrayOfByte[paramInt] = ((byte)0);
    }
    paramArrayOfByte = this.e;
    if (paramArrayOfByte != null)
    {
      ((org.bouncycastle.util.e)this.b).m(paramArrayOfByte);
    }
    else
    {
      paramArrayOfByte = this.b;
      localObject = this.g;
      paramArrayOfByte.update((byte[])localObject, 0, localObject.length);
    }
    return i;
  }
  
  public void reset()
  {
    this.b.reset();
    g localg = this.b;
    byte[] arrayOfByte = this.g;
    localg.update(arrayOfByte, 0, arrayOfByte.length);
  }
  
  public void update(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.b.update(paramArrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\t\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */