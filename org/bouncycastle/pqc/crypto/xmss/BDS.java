package org.bouncycastle.pqc.crypto.xmss;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Stack;
import java.util.TreeMap;

public final class BDS
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private List<XMSSNode> authenticationPath;
  private int index;
  private int k;
  private Map<Integer, XMSSNode> keep;
  private Map<Integer, LinkedList<XMSSNode>> retain;
  private XMSSNode root;
  private Stack<XMSSNode> stack;
  private final List<a> treeHashInstances;
  private final int treeHeight;
  private boolean used;
  private transient h wotsPlus;
  
  private BDS(BDS paramBDS, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, g paramg)
  {
    this.wotsPlus = paramBDS.wotsPlus;
    this.treeHeight = paramBDS.treeHeight;
    this.k = paramBDS.k;
    this.root = paramBDS.root;
    this.authenticationPath = new ArrayList(paramBDS.authenticationPath);
    this.retain = paramBDS.retain;
    this.stack = ((Stack)paramBDS.stack.clone());
    this.treeHashInstances = paramBDS.treeHashInstances;
    this.keep = new TreeMap(paramBDS.keep);
    this.index = paramBDS.index;
    nextAuthenticationPath(paramArrayOfByte1, paramArrayOfByte2, paramg);
    paramBDS.used = true;
  }
  
  private BDS(h paramh, int paramInt1, int paramInt2)
  {
    this.wotsPlus = paramh;
    this.treeHeight = paramInt1;
    this.k = paramInt2;
    if ((paramInt2 <= paramInt1) && (paramInt2 >= 2))
    {
      paramInt2 = paramInt1 - paramInt2;
      if (paramInt2 % 2 == 0)
      {
        this.authenticationPath = new ArrayList();
        this.retain = new TreeMap();
        this.stack = new Stack();
        this.treeHashInstances = new ArrayList();
        for (paramInt1 = 0; paramInt1 < paramInt2; paramInt1++) {
          this.treeHashInstances.add(new a(paramInt1));
        }
        this.keep = new TreeMap();
        this.index = 0;
        this.used = false;
        return;
      }
    }
    throw new IllegalArgumentException("illegal value for BDS parameter k");
  }
  
  BDS(r paramr, int paramInt)
  {
    this(paramr.f(), paramr.d(), paramr.e());
    this.index = paramInt;
    this.used = true;
  }
  
  BDS(r paramr, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, g paramg)
  {
    this(paramr.f(), paramr.d(), paramr.e());
    initialize(paramArrayOfByte1, paramArrayOfByte2, paramg);
  }
  
  BDS(r paramr, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, g paramg, int paramInt)
  {
    this(paramr.f(), paramr.d(), paramr.e());
    initialize(paramArrayOfByte1, paramArrayOfByte2, paramg);
    while (this.index < paramInt)
    {
      nextAuthenticationPath(paramArrayOfByte1, paramArrayOfByte2, paramg);
      this.used = false;
    }
  }
  
  private a getBDSTreeHashInstanceForUpdate()
  {
    Iterator localIterator = this.treeHashInstances.iterator();
    Object localObject = null;
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if ((!locala.g()) && (locala.h()))
      {
        if ((localObject == null) || (locala.a() < ((a)localObject).a())) {}
        for (;;)
        {
          localObject = locala;
          break;
          if ((locala.a() != ((a)localObject).a()) || (locala.b() >= ((a)localObject).b())) {
            break;
          }
        }
      }
    }
    return (a)localObject;
  }
  
  private void initialize(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, g paramg)
  {
    Objects.requireNonNull(paramg, "otsHashAddress == null");
    Object localObject1 = (f)((f.b)((f.b)new f.b().g(paramg.b())).h(paramg.c())).l();
    Object localObject2 = (d)((d.b)((d.b)new d.b().g(paramg.b())).h(paramg.c())).k();
    int i = 0;
    g localg = paramg;
    paramg = (g)localObject2;
    while (i < 1 << this.treeHeight)
    {
      localg = (g)((g.b)((g.b)((g.b)new g.b().g(localg.b())).h(localg.c())).p(i).n(localg.e()).o(localg.f()).f(localg.a())).l();
      localObject2 = this.wotsPlus;
      ((h)localObject2).h(((h)localObject2).g(paramArrayOfByte2, localg), paramArrayOfByte1);
      Object localObject3 = this.wotsPlus.e(localg);
      localObject2 = (f)((f.b)((f.b)((f.b)new f.b().g(((l)localObject1).b())).h(((l)localObject1).c())).n(i).o(((f)localObject1).f()).p(((f)localObject1).g()).f(((l)localObject1).a())).l();
      localObject1 = p.a(this.wotsPlus, (k)localObject3, (f)localObject2);
      for (paramg = (d)((d.b)((d.b)((d.b)new d.b().g(paramg.b())).h(paramg.c())).n(i).f(paramg.a())).k(); (!this.stack.isEmpty()) && (((XMSSNode)this.stack.peek()).getHeight() == ((XMSSNode)localObject1).getHeight()); paramg = (d)((d.b)((d.b)((d.b)new d.b().g(paramg.b())).h(paramg.c())).m(paramg.e() + 1).n(paramg.f()).f(paramg.a())).k())
      {
        int j = (int)Math.floor(i / (1 << ((XMSSNode)localObject1).getHeight()));
        if (j == 1) {
          this.authenticationPath.add(((XMSSNode)localObject1).clone());
        }
        if ((j == 3) && (((XMSSNode)localObject1).getHeight() < this.treeHeight - this.k)) {
          ((a)this.treeHashInstances.get(((XMSSNode)localObject1).getHeight())).i(((XMSSNode)localObject1).clone());
        }
        if ((j >= 3) && ((j & 0x1) == 1) && (((XMSSNode)localObject1).getHeight() >= this.treeHeight - this.k) && (((XMSSNode)localObject1).getHeight() <= this.treeHeight - 2)) {
          if (this.retain.get(Integer.valueOf(((XMSSNode)localObject1).getHeight())) == null)
          {
            localObject3 = new LinkedList();
            ((LinkedList)localObject3).add(((XMSSNode)localObject1).clone());
            this.retain.put(Integer.valueOf(((XMSSNode)localObject1).getHeight()), localObject3);
          }
          else
          {
            ((LinkedList)this.retain.get(Integer.valueOf(((XMSSNode)localObject1).getHeight()))).add(((XMSSNode)localObject1).clone());
          }
        }
        paramg = (d)((d.b)((d.b)((d.b)new d.b().g(paramg.b())).h(paramg.c())).m(paramg.e()).n((paramg.f() - 1) / 2).f(paramg.a())).k();
        localObject1 = p.b(this.wotsPlus, (XMSSNode)this.stack.pop(), (XMSSNode)localObject1, paramg);
        localObject1 = new XMSSNode(((XMSSNode)localObject1).getHeight() + 1, ((XMSSNode)localObject1).getValue());
      }
      this.stack.push(localObject1);
      i++;
      localObject1 = localObject2;
    }
    this.root = ((XMSSNode)this.stack.pop());
  }
  
  private void nextAuthenticationPath(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, g paramg)
  {
    Objects.requireNonNull(paramg, "otsHashAddress == null");
    if (!this.used)
    {
      if (this.index <= (1 << this.treeHeight) - 2)
      {
        Object localObject1 = (f)((f.b)((f.b)new f.b().g(paramg.b())).h(paramg.c())).l();
        Object localObject2 = (d)((d.b)((d.b)new d.b().g(paramg.b())).h(paramg.c())).k();
        int i = u.b(this.index, this.treeHeight);
        if (((this.index >> i + 1 & 0x1) == 0) && (i < this.treeHeight - 1)) {
          this.keep.put(Integer.valueOf(i), ((XMSSNode)this.authenticationPath.get(i)).clone());
        }
        int j = 0;
        if (i == 0)
        {
          localObject2 = (g)((g.b)((g.b)((g.b)new g.b().g(paramg.b())).h(paramg.c())).p(this.index).n(paramg.e()).o(paramg.f()).f(paramg.a())).l();
          paramg = this.wotsPlus;
          paramg.h(paramg.g(paramArrayOfByte2, (g)localObject2), paramArrayOfByte1);
          paramg = this.wotsPlus.e((g)localObject2);
          localObject1 = (f)((f.b)((f.b)((f.b)new f.b().g(((l)localObject1).b())).h(((l)localObject1).c())).n(this.index).o(((f)localObject1).f()).p(((f)localObject1).g()).f(((l)localObject1).a())).l();
          paramg = p.a(this.wotsPlus, paramg, (f)localObject1);
          this.authenticationPath.set(0, paramg);
          i = j;
        }
        else
        {
          localObject1 = (d.b)((d.b)new d.b().g(((l)localObject2).b())).h(((l)localObject2).c());
          int m = i - 1;
          localObject2 = (d)((d.b)((d.b)localObject1).m(m).n(this.index >> i).f(((l)localObject2).a())).k();
          localObject2 = p.b(this.wotsPlus, (XMSSNode)this.authenticationPath.get(m), (XMSSNode)this.keep.get(Integer.valueOf(m)), (l)localObject2);
          localObject2 = new XMSSNode(((XMSSNode)localObject2).getHeight() + 1, ((XMSSNode)localObject2).getValue());
          this.authenticationPath.set(i, localObject2);
          this.keep.remove(Integer.valueOf(m));
          for (m = 0; m < i; m++)
          {
            if (m < this.treeHeight - this.k)
            {
              localObject2 = this.authenticationPath;
              localObject1 = ((a)this.treeHashInstances.get(m)).d();
            }
            else
            {
              localObject2 = this.authenticationPath;
              localObject1 = ((LinkedList)this.retain.get(Integer.valueOf(m))).removeFirst();
            }
            ((List)localObject2).set(m, localObject1);
          }
          int n = Math.min(i, this.treeHeight - this.k);
          for (m = 0;; m++)
          {
            i = j;
            localObject2 = paramg;
            if (m >= n) {
              break;
            }
            i = this.index + 1 + (1 << m) * 3;
            if (i < 1 << this.treeHeight) {
              ((a)this.treeHashInstances.get(m)).f(i);
            }
          }
        }
        while (i < this.treeHeight - this.k >> 1)
        {
          paramg = getBDSTreeHashInstanceForUpdate();
          if (paramg != null) {
            paramg.j(this.stack, this.wotsPlus, paramArrayOfByte1, paramArrayOfByte2, (g)localObject2);
          }
          i++;
        }
        this.index += 1;
        return;
      }
      throw new IllegalStateException("index out of bounds");
    }
    throw new IllegalStateException("index already used");
  }
  
  protected List<XMSSNode> getAuthenticationPath()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.authenticationPath.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((XMSSNode)localIterator.next()).clone());
    }
    return localArrayList;
  }
  
  protected int getIndex()
  {
    return this.index;
  }
  
  public BDS getNextState(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, g paramg)
  {
    return new BDS(this, paramArrayOfByte1, paramArrayOfByte2, paramg);
  }
  
  protected XMSSNode getRoot()
  {
    return this.root.clone();
  }
  
  protected int getTreeHeight()
  {
    return this.treeHeight;
  }
  
  boolean isUsed()
  {
    return this.used;
  }
  
  protected void setXMSS(r paramr)
  {
    if (this.treeHeight == paramr.d())
    {
      this.wotsPlus = paramr.f();
      return;
    }
    throw new IllegalStateException("wrong height");
  }
  
  protected void validate()
  {
    if (this.authenticationPath != null)
    {
      if (this.retain != null)
      {
        if (this.stack != null)
        {
          if (this.treeHashInstances != null)
          {
            if (this.keep != null)
            {
              if (u.l(this.treeHeight, this.index)) {
                return;
              }
              throw new IllegalStateException("index in BDS state out of bounds");
            }
            throw new IllegalStateException("keep == null");
          }
          throw new IllegalStateException("treeHashInstances == null");
        }
        throw new IllegalStateException("stack == null");
      }
      throw new IllegalStateException("retain == null");
    }
    throw new IllegalStateException("authenticationPath == null");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\pqc\crypto\xmss\BDS.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */