package com.google.common.collect;

import com.google.common.base.Equivalence;
import com.google.common.base.c;
import com.google.common.base.j;
import com.google.common.base.j.b;
import com.google.common.base.n;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;

public final class o1
{
  boolean a;
  int b = -1;
  int c = -1;
  @MonotonicNonNullDecl
  p1.n d;
  @MonotonicNonNullDecl
  p1.n e;
  @MonotonicNonNullDecl
  Equivalence<Object> f;
  
  int a()
  {
    int i = this.c;
    int j = i;
    if (i == -1) {
      j = 4;
    }
    return j;
  }
  
  int b()
  {
    int i = this.b;
    int j = i;
    if (i == -1) {
      j = 16;
    }
    return j;
  }
  
  Equivalence<Object> c()
  {
    return (Equivalence)j.a(this.f, d().a());
  }
  
  p1.n d()
  {
    return (p1.n)j.a(this.d, p1.n.c);
  }
  
  p1.n e()
  {
    return (p1.n)j.a(this.e, p1.n.c);
  }
  
  public <K, V> ConcurrentMap<K, V> f()
  {
    if (!this.a) {
      return new ConcurrentHashMap(b(), 0.75F, a());
    }
    return p1.b(this);
  }
  
  o1 g(p1.n paramn)
  {
    p1.n localn = this.d;
    boolean bool;
    if (localn == null) {
      bool = true;
    } else {
      bool = false;
    }
    n.x(bool, "Key strength was already set to %s", localn);
    this.d = ((p1.n)n.o(paramn));
    if (paramn != p1.n.c) {
      this.a = true;
    }
    return this;
  }
  
  @CanIgnoreReturnValue
  public o1 h()
  {
    return g(p1.n.d);
  }
  
  public String toString()
  {
    j.b localb = j.b(this);
    int i = this.b;
    if (i != -1) {
      localb.b("initialCapacity", i);
    }
    i = this.c;
    if (i != -1) {
      localb.b("concurrencyLevel", i);
    }
    p1.n localn = this.d;
    if (localn != null) {
      localb.d("keyStrength", c.e(localn.toString()));
    }
    localn = this.e;
    if (localn != null) {
      localb.d("valueStrength", c.e(localn.toString()));
    }
    if (this.f != null) {
      localb.h("keyEquivalence");
    }
    return localb.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\o1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */