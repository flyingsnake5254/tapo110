package com.google.common.collect;

import com.google.common.base.j;
import com.google.common.base.n;
import com.google.common.primitives.d;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class TreeMultiset<E>
  extends o<E>
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private final transient f<E> header;
  private final transient w0<E> range;
  private final transient g<f<E>> rootReference;
  
  TreeMultiset(g<f<E>> paramg, w0<E> paramw0, f<E> paramf)
  {
    super(paramw0.b());
    this.rootReference = paramg;
    this.range = paramw0;
    this.header = paramf;
  }
  
  TreeMultiset(Comparator<? super E> paramComparator)
  {
    super(paramComparator);
    this.range = w0.a(paramComparator);
    paramComparator = new f(null, 1);
    this.header = paramComparator;
    successor(paramComparator, paramComparator);
    this.rootReference = new g(null);
  }
  
  private long aggregateAboveRange(e parame, @NullableDecl f<E> paramf)
  {
    if (paramf == null) {
      return 0L;
    }
    int i = comparator().compare(this.range.j(), f.g(paramf));
    if (i > 0) {
      return aggregateAboveRange(parame, f.j(paramf));
    }
    long l1;
    if (i == 0)
    {
      i = d.a[this.range.i().ordinal()];
      if (i != 1)
      {
        if (i == 2) {
          return parame.b(f.j(paramf));
        }
        throw new AssertionError();
      }
      l1 = parame.a(paramf);
    }
    for (long l2 = parame.b(f.j(paramf));; l2 = aggregateAboveRange(parame, f.h(paramf)))
    {
      return l1 + l2;
      l1 = parame.b(f.j(paramf)) + parame.a(paramf);
    }
  }
  
  private long aggregateBelowRange(e parame, @NullableDecl f<E> paramf)
  {
    if (paramf == null) {
      return 0L;
    }
    int i = comparator().compare(this.range.h(), f.g(paramf));
    if (i < 0) {
      return aggregateBelowRange(parame, f.h(paramf));
    }
    long l1;
    if (i == 0)
    {
      i = d.a[this.range.g().ordinal()];
      if (i != 1)
      {
        if (i == 2) {
          return parame.b(f.h(paramf));
        }
        throw new AssertionError();
      }
      l1 = parame.a(paramf);
    }
    for (long l2 = parame.b(f.h(paramf));; l2 = aggregateBelowRange(parame, f.j(paramf)))
    {
      return l1 + l2;
      l1 = parame.b(f.h(paramf)) + parame.a(paramf);
    }
  }
  
  private long aggregateForEntries(e parame)
  {
    f localf = (f)this.rootReference.c();
    long l1 = parame.b(localf);
    long l2 = l1;
    if (this.range.k()) {
      l2 = l1 - aggregateBelowRange(parame, localf);
    }
    l1 = l2;
    if (this.range.l()) {
      l1 = l2 - aggregateAboveRange(parame, localf);
    }
    return l1;
  }
  
  public static <E extends Comparable> TreeMultiset<E> create()
  {
    return new TreeMultiset(a2.g());
  }
  
  public static <E extends Comparable> TreeMultiset<E> create(Iterable<? extends E> paramIterable)
  {
    TreeMultiset localTreeMultiset = create();
    j1.a(localTreeMultiset, paramIterable);
    return localTreeMultiset;
  }
  
  public static <E> TreeMultiset<E> create(@NullableDecl Comparator<? super E> paramComparator)
  {
    if (paramComparator == null) {
      paramComparator = new TreeMultiset(a2.g());
    } else {
      paramComparator = new TreeMultiset(paramComparator);
    }
    return paramComparator;
  }
  
  static int distinctElements(@NullableDecl f<?> paramf)
  {
    int i;
    if (paramf == null) {
      i = 0;
    } else {
      i = f.f(paramf);
    }
    return i;
  }
  
  @NullableDecl
  private f<E> firstNode()
  {
    Object localObject1 = (f)this.rootReference.c();
    Object localObject2 = null;
    if (localObject1 == null) {
      return null;
    }
    if (this.range.k())
    {
      Object localObject3 = this.range.h();
      localObject4 = f.a((f)this.rootReference.c(), comparator(), localObject3);
      if (localObject4 == null) {
        return null;
      }
      localObject1 = localObject4;
      if (this.range.g() == BoundType.OPEN)
      {
        localObject1 = localObject4;
        if (comparator().compare(localObject3, ((f)localObject4).y()) == 0) {
          localObject1 = f.l((f)localObject4);
        }
      }
    }
    else
    {
      localObject1 = f.l(this.header);
    }
    Object localObject4 = localObject2;
    if (localObject1 != this.header) {
      if (!this.range.d(((f)localObject1).y())) {
        localObject4 = localObject2;
      } else {
        localObject4 = localObject1;
      }
    }
    return (f<E>)localObject4;
  }
  
  @NullableDecl
  private f<E> lastNode()
  {
    Object localObject1 = (f)this.rootReference.c();
    Object localObject2 = null;
    if (localObject1 == null) {
      return null;
    }
    if (this.range.l())
    {
      Object localObject3 = this.range.j();
      localObject4 = f.b((f)this.rootReference.c(), comparator(), localObject3);
      if (localObject4 == null) {
        return null;
      }
      localObject1 = localObject4;
      if (this.range.i() == BoundType.OPEN)
      {
        localObject1 = localObject4;
        if (comparator().compare(localObject3, ((f)localObject4).y()) == 0) {
          localObject1 = f.n((f)localObject4);
        }
      }
    }
    else
    {
      localObject1 = f.n(this.header);
    }
    Object localObject4 = localObject2;
    if (localObject1 != this.header) {
      if (!this.range.d(((f)localObject1).y())) {
        localObject4 = localObject2;
      } else {
        localObject4 = localObject1;
      }
    }
    return (f<E>)localObject4;
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    paramObjectInputStream.defaultReadObject();
    Object localObject = (Comparator)paramObjectInputStream.readObject();
    r2.a(o.class, "comparator").b(this, localObject);
    r2.a(TreeMultiset.class, "range").b(this, w0.a((Comparator)localObject));
    r2.a(TreeMultiset.class, "rootReference").b(this, new g(null));
    localObject = new f(null, 1);
    r2.a(TreeMultiset.class, "header").b(this, localObject);
    successor((f)localObject, (f)localObject);
    r2.f(this, paramObjectInputStream);
  }
  
  private static <T> void successor(f<T> paramf1, f<T> paramf2)
  {
    f.m(paramf1, paramf2);
    f.o(paramf2, paramf1);
  }
  
  private static <T> void successor(f<T> paramf1, f<T> paramf2, f<T> paramf3)
  {
    successor(paramf1, paramf2);
    successor(paramf2, paramf3);
  }
  
  private u1.a<E> wrapEntry(final f<E> paramf)
  {
    return new a(paramf);
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.defaultWriteObject();
    paramObjectOutputStream.writeObject(elementSet().comparator());
    r2.k(this, paramObjectOutputStream);
  }
  
  @CanIgnoreReturnValue
  public int add(@NullableDecl E paramE, int paramInt)
  {
    v.b(paramInt, "occurrences");
    if (paramInt == 0) {
      return count(paramE);
    }
    n.d(this.range.d(paramE));
    f localf = (f)this.rootReference.c();
    if (localf == null)
    {
      comparator().compare(paramE, paramE);
      localObject = new f(paramE, paramInt);
      paramE = this.header;
      successor(paramE, (f)localObject, paramE);
      this.rootReference.a(localf, localObject);
      return 0;
    }
    Object localObject = new int[1];
    paramE = localf.p(comparator(), paramE, paramInt, (int[])localObject);
    this.rootReference.a(localf, paramE);
    return localObject[0];
  }
  
  public void clear()
  {
    if ((!this.range.k()) && (!this.range.l()))
    {
      f localf;
      for (Object localObject = f.l(this.header);; localObject = localf)
      {
        localf = this.header;
        if (localObject == localf) {
          break;
        }
        localf = f.l((f)localObject);
        f.d((f)localObject, 0);
        f.i((f)localObject, null);
        f.k((f)localObject, null);
        f.o((f)localObject, null);
        f.m((f)localObject, null);
      }
      successor(localf, localf);
      this.rootReference.b();
    }
    else
    {
      k1.d(entryIterator());
    }
  }
  
  public int count(@NullableDecl Object paramObject)
  {
    try
    {
      f localf = (f)this.rootReference.c();
      if ((this.range.d(paramObject)) && (localf != null))
      {
        int i = localf.u(comparator(), paramObject);
        return i;
      }
    }
    catch (ClassCastException|NullPointerException paramObject)
    {
      for (;;) {}
    }
    return 0;
  }
  
  Iterator<u1.a<E>> descendingEntryIterator()
  {
    return new c();
  }
  
  int distinctElements()
  {
    return d.i(aggregateForEntries(e.d));
  }
  
  Iterator<E> elementIterator()
  {
    return v1.e(entryIterator());
  }
  
  Iterator<u1.a<E>> entryIterator()
  {
    return new b();
  }
  
  public a3<E> headMultiset(@NullableDecl E paramE, BoundType paramBoundType)
  {
    return new TreeMultiset(this.rootReference, this.range.m(w0.p(comparator(), paramE, paramBoundType)), this.header);
  }
  
  public Iterator<E> iterator()
  {
    return v1.i(this);
  }
  
  @CanIgnoreReturnValue
  public int remove(@NullableDecl Object paramObject, int paramInt)
  {
    v.b(paramInt, "occurrences");
    if (paramInt == 0) {
      return count(paramObject);
    }
    f localf = (f)this.rootReference.c();
    int[] arrayOfInt = new int[1];
    try
    {
      if ((this.range.d(paramObject)) && (localf != null))
      {
        paramObject = localf.E(comparator(), paramObject, paramInt, arrayOfInt);
        this.rootReference.a(localf, paramObject);
        return arrayOfInt[0];
      }
    }
    catch (ClassCastException|NullPointerException paramObject)
    {
      for (;;) {}
    }
    return 0;
  }
  
  @CanIgnoreReturnValue
  public int setCount(@NullableDecl E paramE, int paramInt)
  {
    v.b(paramInt, "count");
    boolean bool1 = this.range.d(paramE);
    boolean bool2 = true;
    if (!bool1)
    {
      if (paramInt != 0) {
        bool2 = false;
      }
      n.d(bool2);
      return 0;
    }
    f localf = (f)this.rootReference.c();
    if (localf == null)
    {
      if (paramInt > 0) {
        add(paramE, paramInt);
      }
      return 0;
    }
    int[] arrayOfInt = new int[1];
    paramE = localf.K(comparator(), paramE, paramInt, arrayOfInt);
    this.rootReference.a(localf, paramE);
    return arrayOfInt[0];
  }
  
  @CanIgnoreReturnValue
  public boolean setCount(@NullableDecl E paramE, int paramInt1, int paramInt2)
  {
    v.b(paramInt2, "newCount");
    v.b(paramInt1, "oldCount");
    n.d(this.range.d(paramE));
    f localf = (f)this.rootReference.c();
    boolean bool = false;
    if (localf == null)
    {
      if (paramInt1 == 0)
      {
        if (paramInt2 > 0) {
          add(paramE, paramInt2);
        }
        return true;
      }
      return false;
    }
    int[] arrayOfInt = new int[1];
    paramE = localf.J(comparator(), paramE, paramInt1, paramInt2, arrayOfInt);
    this.rootReference.a(localf, paramE);
    if (arrayOfInt[0] == paramInt1) {
      bool = true;
    }
    return bool;
  }
  
  public int size()
  {
    return d.i(aggregateForEntries(e.c));
  }
  
  public a3<E> tailMultiset(@NullableDecl E paramE, BoundType paramBoundType)
  {
    return new TreeMultiset(this.rootReference, this.range.m(w0.f(comparator(), paramE, paramBoundType)), this.header);
  }
  
  class a
    extends v1.b<E>
  {
    a(TreeMultiset.f paramf) {}
    
    public E a()
    {
      return (E)paramf.y();
    }
    
    public int getCount()
    {
      int i = paramf.x();
      int j = i;
      if (i == 0) {
        j = TreeMultiset.this.count(a());
      }
      return j;
    }
  }
  
  class b
    implements Iterator<u1.a<E>>
  {
    TreeMultiset.f<E> c = TreeMultiset.this.firstNode();
    @NullableDecl
    u1.a<E> d;
    
    b() {}
    
    public u1.a<E> a()
    {
      if (hasNext())
      {
        u1.a locala = TreeMultiset.this.wrapEntry(this.c);
        this.d = locala;
        if (TreeMultiset.f.l(this.c) == TreeMultiset.this.header) {
          this.c = null;
        } else {
          this.c = TreeMultiset.f.l(this.c);
        }
        return locala;
      }
      throw new NoSuchElementException();
    }
    
    public boolean hasNext()
    {
      if (this.c == null) {
        return false;
      }
      if (TreeMultiset.this.range.n(this.c.y()))
      {
        this.c = null;
        return false;
      }
      return true;
    }
    
    public void remove()
    {
      boolean bool;
      if (this.d != null) {
        bool = true;
      } else {
        bool = false;
      }
      v.e(bool);
      TreeMultiset.this.setCount(this.d.a(), 0);
      this.d = null;
    }
  }
  
  class c
    implements Iterator<u1.a<E>>
  {
    TreeMultiset.f<E> c = TreeMultiset.this.lastNode();
    u1.a<E> d = null;
    
    c() {}
    
    public u1.a<E> a()
    {
      if (hasNext())
      {
        u1.a locala = TreeMultiset.this.wrapEntry(this.c);
        this.d = locala;
        if (TreeMultiset.f.n(this.c) == TreeMultiset.this.header) {
          this.c = null;
        } else {
          this.c = TreeMultiset.f.n(this.c);
        }
        return locala;
      }
      throw new NoSuchElementException();
    }
    
    public boolean hasNext()
    {
      if (this.c == null) {
        return false;
      }
      if (TreeMultiset.this.range.o(this.c.y()))
      {
        this.c = null;
        return false;
      }
      return true;
    }
    
    public void remove()
    {
      boolean bool;
      if (this.d != null) {
        bool = true;
      } else {
        bool = false;
      }
      v.e(bool);
      TreeMultiset.this.setCount(this.d.a(), 0);
      this.d = null;
    }
  }
  
  private static abstract enum e
  {
    static
    {
      a locala = new a("SIZE", 0);
      c = locala;
      b localb = new b("DISTINCT", 1);
      d = localb;
      f = new e[] { locala, localb };
    }
    
    abstract int a(TreeMultiset.f<?> paramf);
    
    abstract long b(@NullableDecl TreeMultiset.f<?> paramf);
    
    static enum a
    {
      a()
      {
        super(paramInt, null);
      }
      
      int a(TreeMultiset.f<?> paramf)
      {
        return TreeMultiset.f.c(paramf);
      }
      
      long b(@NullableDecl TreeMultiset.f<?> paramf)
      {
        long l;
        if (paramf == null) {
          l = 0L;
        } else {
          l = TreeMultiset.f.e(paramf);
        }
        return l;
      }
    }
    
    static enum b
    {
      b()
      {
        super(paramInt, null);
      }
      
      int a(TreeMultiset.f<?> paramf)
      {
        return 1;
      }
      
      long b(@NullableDecl TreeMultiset.f<?> paramf)
      {
        long l;
        if (paramf == null) {
          l = 0L;
        } else {
          l = TreeMultiset.f.f(paramf);
        }
        return l;
      }
    }
  }
  
  private static final class f<E>
  {
    @NullableDecl
    private final E a;
    private int b;
    private int c;
    private long d;
    private int e;
    @NullableDecl
    private f<E> f;
    @NullableDecl
    private f<E> g;
    @NullableDecl
    private f<E> h;
    @NullableDecl
    private f<E> i;
    
    f(@NullableDecl E paramE, int paramInt)
    {
      boolean bool;
      if (paramInt > 0) {
        bool = true;
      } else {
        bool = false;
      }
      n.d(bool);
      this.a = paramE;
      this.b = paramInt;
      this.d = paramInt;
      this.c = 1;
      this.e = 1;
      this.f = null;
      this.g = null;
    }
    
    private f<E> A()
    {
      int j = s();
      if (j != -2)
      {
        if (j != 2)
        {
          C();
          return this;
        }
        if (this.f.s() < 0) {
          this.f = this.f.H();
        }
        return I();
      }
      if (this.g.s() > 0) {
        this.g = this.g.I();
      }
      return H();
    }
    
    private void B()
    {
      D();
      C();
    }
    
    private void C()
    {
      this.e = (Math.max(z(this.f), z(this.g)) + 1);
    }
    
    private void D()
    {
      this.c = (TreeMultiset.distinctElements(this.f) + 1 + TreeMultiset.distinctElements(this.g));
      this.d = (this.b + L(this.f) + L(this.g));
    }
    
    private f<E> F(f<E> paramf)
    {
      f localf = this.g;
      if (localf == null) {
        return this.f;
      }
      this.g = localf.F(paramf);
      this.c -= 1;
      this.d -= paramf.b;
      return A();
    }
    
    private f<E> G(f<E> paramf)
    {
      f localf = this.f;
      if (localf == null) {
        return this.g;
      }
      this.f = localf.G(paramf);
      this.c -= 1;
      this.d -= paramf.b;
      return A();
    }
    
    private f<E> H()
    {
      boolean bool;
      if (this.g != null) {
        bool = true;
      } else {
        bool = false;
      }
      n.u(bool);
      f localf = this.g;
      this.g = localf.f;
      localf.f = this;
      localf.d = this.d;
      localf.c = this.c;
      B();
      localf.C();
      return localf;
    }
    
    private f<E> I()
    {
      boolean bool;
      if (this.f != null) {
        bool = true;
      } else {
        bool = false;
      }
      n.u(bool);
      f localf = this.f;
      this.f = localf.g;
      localf.g = this;
      localf.d = this.d;
      localf.c = this.c;
      B();
      localf.C();
      return localf;
    }
    
    private static long L(@NullableDecl f<?> paramf)
    {
      long l;
      if (paramf == null) {
        l = 0L;
      } else {
        l = paramf.d;
      }
      return l;
    }
    
    private f<E> q(E paramE, int paramInt)
    {
      paramE = new f(paramE, paramInt);
      this.f = paramE;
      TreeMultiset.successor(this.h, paramE, this);
      this.e = Math.max(2, this.e);
      this.c += 1;
      this.d += paramInt;
      return this;
    }
    
    private f<E> r(E paramE, int paramInt)
    {
      paramE = new f(paramE, paramInt);
      this.g = paramE;
      TreeMultiset.successor(this, paramE, this.i);
      this.e = Math.max(2, this.e);
      this.c += 1;
      this.d += paramInt;
      return this;
    }
    
    private int s()
    {
      return z(this.f) - z(this.g);
    }
    
    @NullableDecl
    private f<E> t(Comparator<? super E> paramComparator, E paramE)
    {
      int j = paramComparator.compare(paramE, this.a);
      if (j < 0)
      {
        localf = this.f;
        if (localf == null) {
          paramComparator = this;
        } else {
          paramComparator = (f)j.a(localf.t(paramComparator, paramE), this);
        }
        return paramComparator;
      }
      if (j == 0) {
        return this;
      }
      f localf = this.g;
      if (localf == null) {
        paramComparator = null;
      } else {
        paramComparator = localf.t(paramComparator, paramE);
      }
      return paramComparator;
    }
    
    private f<E> v()
    {
      int j = this.b;
      this.b = 0;
      TreeMultiset.successor(this.h, this.i);
      f localf1 = this.f;
      if (localf1 == null) {
        return this.g;
      }
      f localf2 = this.g;
      if (localf2 == null) {
        return localf1;
      }
      if (localf1.e >= localf2.e)
      {
        localf2 = this.h;
        localf2.f = localf1.F(localf2);
        localf2.g = this.g;
        this.c -= 1;
        this.d -= j;
        return localf2.A();
      }
      localf1 = this.i;
      localf1.g = localf2.G(localf1);
      localf1.f = this.f;
      this.c -= 1;
      this.d -= j;
      return localf1.A();
    }
    
    @NullableDecl
    private f<E> w(Comparator<? super E> paramComparator, E paramE)
    {
      int j = paramComparator.compare(paramE, this.a);
      if (j > 0)
      {
        localf = this.g;
        if (localf == null) {
          paramComparator = this;
        } else {
          paramComparator = (f)j.a(localf.w(paramComparator, paramE), this);
        }
        return paramComparator;
      }
      if (j == 0) {
        return this;
      }
      f localf = this.f;
      if (localf == null) {
        paramComparator = null;
      } else {
        paramComparator = localf.w(paramComparator, paramE);
      }
      return paramComparator;
    }
    
    private static int z(@NullableDecl f<?> paramf)
    {
      int j;
      if (paramf == null) {
        j = 0;
      } else {
        j = paramf.e;
      }
      return j;
    }
    
    f<E> E(Comparator<? super E> paramComparator, @NullableDecl E paramE, int paramInt, int[] paramArrayOfInt)
    {
      int j = paramComparator.compare(paramE, this.a);
      f localf;
      if (j < 0)
      {
        localf = this.f;
        if (localf == null)
        {
          paramArrayOfInt[0] = 0;
          return this;
        }
        this.f = localf.E(paramComparator, paramE, paramInt, paramArrayOfInt);
        if (paramArrayOfInt[0] > 0) {
          if (paramInt >= paramArrayOfInt[0])
          {
            this.c -= 1;
            this.d -= paramArrayOfInt[0];
          }
          else
          {
            this.d -= paramInt;
          }
        }
        if (paramArrayOfInt[0] == 0) {
          paramComparator = this;
        } else {
          paramComparator = A();
        }
        return paramComparator;
      }
      if (j > 0)
      {
        localf = this.g;
        if (localf == null)
        {
          paramArrayOfInt[0] = 0;
          return this;
        }
        this.g = localf.E(paramComparator, paramE, paramInt, paramArrayOfInt);
        if (paramArrayOfInt[0] > 0) {
          if (paramInt >= paramArrayOfInt[0])
          {
            this.c -= 1;
            this.d -= paramArrayOfInt[0];
          }
          else
          {
            this.d -= paramInt;
          }
        }
        return A();
      }
      j = this.b;
      paramArrayOfInt[0] = j;
      if (paramInt >= j) {
        return v();
      }
      this.b = (j - paramInt);
      this.d -= paramInt;
      return this;
    }
    
    f<E> J(Comparator<? super E> paramComparator, @NullableDecl E paramE, int paramInt1, int paramInt2, int[] paramArrayOfInt)
    {
      int j = paramComparator.compare(paramE, this.a);
      f localf;
      if (j < 0)
      {
        localf = this.f;
        if (localf == null)
        {
          paramArrayOfInt[0] = 0;
          if ((paramInt1 == 0) && (paramInt2 > 0)) {
            return q(paramE, paramInt2);
          }
          return this;
        }
        this.f = localf.J(paramComparator, paramE, paramInt1, paramInt2, paramArrayOfInt);
        if (paramArrayOfInt[0] == paramInt1)
        {
          if ((paramInt2 == 0) && (paramArrayOfInt[0] != 0)) {
            this.c -= 1;
          } else if ((paramInt2 > 0) && (paramArrayOfInt[0] == 0)) {
            this.c += 1;
          }
          this.d += paramInt2 - paramArrayOfInt[0];
        }
        return A();
      }
      if (j > 0)
      {
        localf = this.g;
        if (localf == null)
        {
          paramArrayOfInt[0] = 0;
          if ((paramInt1 == 0) && (paramInt2 > 0)) {
            return r(paramE, paramInt2);
          }
          return this;
        }
        this.g = localf.J(paramComparator, paramE, paramInt1, paramInt2, paramArrayOfInt);
        if (paramArrayOfInt[0] == paramInt1)
        {
          if ((paramInt2 == 0) && (paramArrayOfInt[0] != 0)) {
            this.c -= 1;
          } else if ((paramInt2 > 0) && (paramArrayOfInt[0] == 0)) {
            this.c += 1;
          }
          this.d += paramInt2 - paramArrayOfInt[0];
        }
        return A();
      }
      j = this.b;
      paramArrayOfInt[0] = j;
      if (paramInt1 == j)
      {
        if (paramInt2 == 0) {
          return v();
        }
        this.d += paramInt2 - j;
        this.b = paramInt2;
      }
      return this;
    }
    
    f<E> K(Comparator<? super E> paramComparator, @NullableDecl E paramE, int paramInt, int[] paramArrayOfInt)
    {
      int j = paramComparator.compare(paramE, this.a);
      f localf;
      if (j < 0)
      {
        localf = this.f;
        if (localf == null)
        {
          paramArrayOfInt[0] = 0;
          if (paramInt > 0) {
            paramComparator = q(paramE, paramInt);
          } else {
            paramComparator = this;
          }
          return paramComparator;
        }
        this.f = localf.K(paramComparator, paramE, paramInt, paramArrayOfInt);
        if ((paramInt == 0) && (paramArrayOfInt[0] != 0)) {
          this.c -= 1;
        } else if ((paramInt > 0) && (paramArrayOfInt[0] == 0)) {
          this.c += 1;
        }
        this.d += paramInt - paramArrayOfInt[0];
        return A();
      }
      if (j > 0)
      {
        localf = this.g;
        if (localf == null)
        {
          paramArrayOfInt[0] = 0;
          if (paramInt > 0) {
            paramComparator = r(paramE, paramInt);
          } else {
            paramComparator = this;
          }
          return paramComparator;
        }
        this.g = localf.K(paramComparator, paramE, paramInt, paramArrayOfInt);
        if ((paramInt == 0) && (paramArrayOfInt[0] != 0)) {
          this.c -= 1;
        } else if ((paramInt > 0) && (paramArrayOfInt[0] == 0)) {
          this.c += 1;
        }
        this.d += paramInt - paramArrayOfInt[0];
        return A();
      }
      j = this.b;
      paramArrayOfInt[0] = j;
      if (paramInt == 0) {
        return v();
      }
      this.d += paramInt - j;
      this.b = paramInt;
      return this;
    }
    
    f<E> p(Comparator<? super E> paramComparator, @NullableDecl E paramE, int paramInt, int[] paramArrayOfInt)
    {
      int j = paramComparator.compare(paramE, this.a);
      boolean bool = true;
      f localf;
      if (j < 0)
      {
        localf = this.f;
        if (localf == null)
        {
          paramArrayOfInt[0] = 0;
          return q(paramE, paramInt);
        }
        j = localf.e;
        paramComparator = localf.p(paramComparator, paramE, paramInt, paramArrayOfInt);
        this.f = paramComparator;
        if (paramArrayOfInt[0] == 0) {
          this.c += 1;
        }
        this.d += paramInt;
        if (paramComparator.e == j) {
          paramComparator = this;
        } else {
          paramComparator = A();
        }
        return paramComparator;
      }
      if (j > 0)
      {
        localf = this.g;
        if (localf == null)
        {
          paramArrayOfInt[0] = 0;
          return r(paramE, paramInt);
        }
        j = localf.e;
        paramComparator = localf.p(paramComparator, paramE, paramInt, paramArrayOfInt);
        this.g = paramComparator;
        if (paramArrayOfInt[0] == 0) {
          this.c += 1;
        }
        this.d += paramInt;
        if (paramComparator.e == j) {
          paramComparator = this;
        } else {
          paramComparator = A();
        }
        return paramComparator;
      }
      j = this.b;
      paramArrayOfInt[0] = j;
      long l1 = j;
      long l2 = paramInt;
      if (l1 + l2 > 2147483647L) {
        bool = false;
      }
      n.d(bool);
      this.b += paramInt;
      this.d += l2;
      return this;
    }
    
    public String toString()
    {
      return v1.g(y(), x()).toString();
    }
    
    public int u(Comparator<? super E> paramComparator, E paramE)
    {
      int j = paramComparator.compare(paramE, this.a);
      int k = 0;
      int m = 0;
      f localf;
      if (j < 0)
      {
        localf = this.f;
        if (localf != null) {
          m = localf.u(paramComparator, paramE);
        }
        return m;
      }
      if (j > 0)
      {
        localf = this.g;
        if (localf == null) {
          m = k;
        } else {
          m = localf.u(paramComparator, paramE);
        }
        return m;
      }
      return this.b;
    }
    
    int x()
    {
      return this.b;
    }
    
    E y()
    {
      return (E)this.a;
    }
  }
  
  private static final class g<T>
  {
    @NullableDecl
    private T a;
    
    public void a(@NullableDecl T paramT1, T paramT2)
    {
      if (this.a == paramT1)
      {
        this.a = paramT2;
        return;
      }
      throw new ConcurrentModificationException();
    }
    
    void b()
    {
      this.a = null;
    }
    
    @NullableDecl
    public T c()
    {
      return (T)this.a;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\TreeMultiset.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */