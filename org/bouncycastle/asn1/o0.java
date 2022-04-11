package org.bouncycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class o0
  extends q
{
  private m c;
  private j d;
  private q f;
  private int q;
  private q x;
  
  public o0(f paramf)
  {
    int i = 0;
    Object localObject1 = r(paramf, 0);
    Object localObject2 = localObject1;
    if ((localObject1 instanceof m))
    {
      this.c = ((m)localObject1);
      localObject2 = r(paramf, 1);
      i = 1;
    }
    int j = i;
    localObject1 = localObject2;
    if ((localObject2 instanceof j))
    {
      this.d = ((j)localObject2);
      j = i + 1;
      localObject1 = r(paramf, j);
    }
    i = j;
    localObject2 = localObject1;
    if (!(localObject1 instanceof x))
    {
      this.f = ((q)localObject1);
      i = j + 1;
      localObject2 = r(paramf, i);
    }
    if (paramf.c() == i + 1)
    {
      if ((localObject2 instanceof x))
      {
        paramf = (x)localObject2;
        s(paramf.p());
        this.x = paramf.o();
        return;
      }
      throw new IllegalArgumentException("No tagged object found in vector. Structure doesn't seem to be of type External");
    }
    throw new IllegalArgumentException("input vector too large");
  }
  
  private q r(f paramf, int paramInt)
  {
    if (paramf.c() > paramInt) {
      return paramf.b(paramInt).c();
    }
    throw new IllegalArgumentException("too few objects in input vector");
  }
  
  private void s(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= 2))
    {
      this.q = paramInt;
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("invalid encoding value: ");
    localStringBuilder.append(paramInt);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  boolean f(q paramq)
  {
    if (!(paramq instanceof o0)) {
      return false;
    }
    if (this == paramq) {
      return true;
    }
    paramq = (o0)paramq;
    Object localObject1 = this.c;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = paramq.c;
      if ((localObject2 == null) || (!((q)localObject2).equals(localObject1))) {
        return false;
      }
    }
    localObject1 = this.d;
    if (localObject1 != null)
    {
      localObject2 = paramq.d;
      if ((localObject2 == null) || (!((q)localObject2).equals(localObject1))) {
        return false;
      }
    }
    localObject1 = this.f;
    if (localObject1 != null)
    {
      localObject2 = paramq.f;
      if ((localObject2 == null) || (!((q)localObject2).equals(localObject1))) {
        return false;
      }
    }
    return this.x.equals(paramq.x);
  }
  
  void g(p paramp)
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    Object localObject = this.c;
    if (localObject != null) {
      localByteArrayOutputStream.write(((l)localObject).e("DER"));
    }
    localObject = this.d;
    if (localObject != null) {
      localByteArrayOutputStream.write(((l)localObject).e("DER"));
    }
    localObject = this.f;
    if (localObject != null) {
      localByteArrayOutputStream.write(((l)localObject).e("DER"));
    }
    localByteArrayOutputStream.write(new g1(true, this.q, this.x).e("DER"));
    paramp.f(32, 8, localByteArrayOutputStream.toByteArray());
  }
  
  int h()
    throws IOException
  {
    return d().length;
  }
  
  public int hashCode()
  {
    Object localObject = this.c;
    if (localObject != null) {
      i = ((m)localObject).hashCode();
    } else {
      i = 0;
    }
    localObject = this.d;
    int j = i;
    if (localObject != null) {
      j = i ^ ((j)localObject).hashCode();
    }
    localObject = this.f;
    int i = j;
    if (localObject != null) {
      i = j ^ ((l)localObject).hashCode();
    }
    return i ^ this.x.hashCode();
  }
  
  boolean j()
  {
    return true;
  }
  
  public q m()
  {
    return this.f;
  }
  
  public m n()
  {
    return this.c;
  }
  
  public int o()
  {
    return this.q;
  }
  
  public q p()
  {
    return this.x;
  }
  
  public j q()
  {
    return this.d;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\o0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */