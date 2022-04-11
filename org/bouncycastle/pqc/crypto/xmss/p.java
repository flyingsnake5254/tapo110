package org.bouncycastle.pqc.crypto.xmss;

import java.util.Objects;

class p
{
  static XMSSNode a(h paramh, k paramk, f paramf)
  {
    Objects.requireNonNull(paramk, "publicKey == null");
    Objects.requireNonNull(paramf, "address == null");
    int i = paramh.d().c();
    paramk = paramk.a();
    XMSSNode[] arrayOfXMSSNode = new XMSSNode[paramk.length];
    for (int j = 0; j < paramk.length; j++) {
      arrayOfXMSSNode[j] = new XMSSNode(0, paramk[j]);
    }
    paramk = ((f.b)((f.b)new f.b().g(paramf.b())).h(paramf.c())).n(paramf.e()).o(0).p(paramf.g()).f(paramf.a());
    j = i;
    for (;;)
    {
      paramk = (f)((f.b)paramk).l();
      if (j <= 1) {
        break;
      }
      double d;
      for (i = 0;; i++)
      {
        d = j / 2;
        if (i >= (int)Math.floor(d)) {
          break;
        }
        paramk = (f)((f.b)((f.b)((f.b)new f.b().g(paramk.b())).h(paramk.c())).n(paramk.e()).o(paramk.f()).p(i).f(paramk.a())).l();
        int k = i * 2;
        arrayOfXMSSNode[i] = b(paramh, arrayOfXMSSNode[k], arrayOfXMSSNode[(k + 1)], paramk);
      }
      if (j % 2 == 1) {
        arrayOfXMSSNode[((int)Math.floor(d))] = arrayOfXMSSNode[(j - 1)];
      }
      j = (int)Math.ceil(j / 2.0D);
      paramk = ((f.b)((f.b)new f.b().g(paramk.b())).h(paramk.c())).n(paramk.e()).o(paramk.f() + 1).p(paramk.g()).f(paramk.a());
    }
    return arrayOfXMSSNode[0];
  }
  
  static XMSSNode b(h paramh, XMSSNode paramXMSSNode1, XMSSNode paramXMSSNode2, l paraml)
  {
    Objects.requireNonNull(paramXMSSNode1, "left == null");
    Objects.requireNonNull(paramXMSSNode2, "right == null");
    if (paramXMSSNode1.getHeight() == paramXMSSNode2.getHeight())
    {
      Objects.requireNonNull(paraml, "address == null");
      byte[] arrayOfByte1 = paramh.f();
      boolean bool = paraml instanceof f;
      int i = 0;
      if (bool)
      {
        paraml = (f)paraml;
        localObject = (f)((f.b)((f.b)((f.b)new f.b().g(paraml.b())).h(paraml.c())).n(paraml.e()).o(paraml.f()).p(paraml.g()).f(0)).l();
      }
      else
      {
        localObject = paraml;
        if ((paraml instanceof d))
        {
          paraml = (d)paraml;
          localObject = (d)((d.b)((d.b)((d.b)new d.b().g(paraml.b())).h(paraml.c())).m(paraml.e()).n(paraml.f()).f(0)).k();
        }
      }
      byte[] arrayOfByte2 = paramh.c().c(arrayOfByte1, ((l)localObject).d());
      if ((localObject instanceof f))
      {
        paraml = (f)localObject;
        paraml = (f)((f.b)((f.b)((f.b)new f.b().g(paraml.b())).h(paraml.c())).n(paraml.e()).o(paraml.f()).p(paraml.g()).f(1)).l();
      }
      else
      {
        paraml = (l)localObject;
        if ((localObject instanceof d))
        {
          paraml = (d)localObject;
          paraml = (d)((d.b)((d.b)((d.b)new d.b().g(paraml.b())).h(paraml.c())).m(paraml.e()).n(paraml.f()).f(1)).k();
        }
      }
      byte[] arrayOfByte3 = paramh.c().c(arrayOfByte1, paraml.d());
      if ((paraml instanceof f))
      {
        paraml = (f)paraml;
        localObject = (f)((f.b)((f.b)((f.b)new f.b().g(paraml.b())).h(paraml.c())).n(paraml.e()).o(paraml.f()).p(paraml.g()).f(2)).l();
      }
      else
      {
        localObject = paraml;
        if ((paraml instanceof d))
        {
          paraml = (d)paraml;
          localObject = (d)((d.b)((d.b)((d.b)new d.b().g(paraml.b())).h(paraml.c())).m(paraml.e()).n(paraml.f()).f(2)).k();
        }
      }
      Object localObject = paramh.c().c(arrayOfByte1, ((l)localObject).d());
      int j = paramh.d().b();
      paraml = new byte[j * 2];
      int m;
      for (int k = 0;; k++)
      {
        m = i;
        if (k >= j) {
          break;
        }
        paraml[k] = ((byte)(byte)(paramXMSSNode1.getValue()[k] ^ arrayOfByte3[k]));
      }
      while (m < j)
      {
        paraml[(m + j)] = ((byte)(byte)(paramXMSSNode2.getValue()[m] ^ localObject[m]));
        m++;
      }
      paramh = paramh.c().b(arrayOfByte2, paraml);
      return new XMSSNode(paramXMSSNode1.getHeight(), paramh);
    }
    throw new IllegalStateException("height of both nodes must be equal");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\pqc\crypto\xmss\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */