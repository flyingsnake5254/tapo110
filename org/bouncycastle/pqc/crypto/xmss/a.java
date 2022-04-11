package org.bouncycastle.pqc.crypto.xmss;

import java.io.Serializable;
import java.util.Objects;
import java.util.Stack;

class a
  implements Serializable
{
  private XMSSNode c;
  private final int d;
  private int f;
  private int q;
  private boolean x;
  private boolean y;
  
  a(int paramInt)
  {
    this.d = paramInt;
    this.x = false;
    this.y = false;
  }
  
  int a()
  {
    if ((this.x) && (!this.y)) {
      return this.f;
    }
    return Integer.MAX_VALUE;
  }
  
  int b()
  {
    return this.q;
  }
  
  public XMSSNode d()
  {
    return this.c.clone();
  }
  
  void f(int paramInt)
  {
    this.c = null;
    this.f = this.d;
    this.q = paramInt;
    this.x = true;
    this.y = false;
  }
  
  boolean g()
  {
    return this.y;
  }
  
  boolean h()
  {
    return this.x;
  }
  
  void i(XMSSNode paramXMSSNode)
  {
    this.c = paramXMSSNode;
    int i = paramXMSSNode.getHeight();
    this.f = i;
    if (i == this.d) {
      this.y = true;
    }
  }
  
  void j(Stack<XMSSNode> paramStack, h paramh, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, g paramg)
  {
    Objects.requireNonNull(paramg, "otsHashAddress == null");
    if ((!this.y) && (this.x))
    {
      g localg = (g)((g.b)((g.b)((g.b)new g.b().g(paramg.b())).h(paramg.c())).p(this.q).n(paramg.e()).o(paramg.f()).f(paramg.a())).l();
      f localf = (f)((f.b)((f.b)new f.b().g(localg.b())).h(localg.c())).n(this.q).l();
      paramg = (d)((d.b)((d.b)new d.b().g(localg.b())).h(localg.c())).n(this.q).k();
      paramh.h(paramh.g(paramArrayOfByte2, localg), paramArrayOfByte1);
      paramArrayOfByte1 = p.a(paramh, paramh.e(localg), localf);
      for (paramArrayOfByte2 = paramg; (!paramStack.isEmpty()) && (((XMSSNode)paramStack.peek()).getHeight() == paramArrayOfByte1.getHeight()) && (((XMSSNode)paramStack.peek()).getHeight() != this.d); paramArrayOfByte2 = (d)((d.b)((d.b)((d.b)new d.b().g(paramArrayOfByte2.b())).h(paramArrayOfByte2.c())).m(paramArrayOfByte2.e() + 1).n(paramArrayOfByte2.f()).f(paramArrayOfByte2.a())).k())
      {
        paramArrayOfByte2 = (d)((d.b)((d.b)((d.b)new d.b().g(paramArrayOfByte2.b())).h(paramArrayOfByte2.c())).m(paramArrayOfByte2.e()).n((paramArrayOfByte2.f() - 1) / 2).f(paramArrayOfByte2.a())).k();
        paramArrayOfByte1 = p.b(paramh, (XMSSNode)paramStack.pop(), paramArrayOfByte1, paramArrayOfByte2);
        paramArrayOfByte1 = new XMSSNode(paramArrayOfByte1.getHeight() + 1, paramArrayOfByte1.getValue());
      }
      paramg = this.c;
      if (paramg == null)
      {
        this.c = paramArrayOfByte1;
      }
      else if (paramg.getHeight() == paramArrayOfByte1.getHeight())
      {
        paramStack = (d)((d.b)((d.b)((d.b)new d.b().g(paramArrayOfByte2.b())).h(paramArrayOfByte2.c())).m(paramArrayOfByte2.e()).n((paramArrayOfByte2.f() - 1) / 2).f(paramArrayOfByte2.a())).k();
        paramh = p.b(paramh, this.c, paramArrayOfByte1, paramStack);
        paramArrayOfByte1 = new XMSSNode(this.c.getHeight() + 1, paramh.getValue());
        this.c = paramArrayOfByte1;
        paramStack = (d)((d.b)((d.b)((d.b)new d.b().g(paramStack.b())).h(paramStack.c())).m(paramStack.e() + 1).n(paramStack.f()).f(paramStack.a())).k();
      }
      else
      {
        paramStack.push(paramArrayOfByte1);
      }
      if (this.c.getHeight() == this.d)
      {
        this.y = true;
      }
      else
      {
        this.f = paramArrayOfByte1.getHeight();
        this.q += 1;
      }
      return;
    }
    throw new IllegalStateException("finished or not initialized");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\pqc\crypto\xmss\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */