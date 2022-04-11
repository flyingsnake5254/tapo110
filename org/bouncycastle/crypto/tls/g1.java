package org.bouncycastle.crypto.tls;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.SecureRandom;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.bouncycastle.util.a;
import org.bouncycastle.util.d;

public abstract class g1
{
  protected static final Integer a = d.b(65281);
  protected static final Integer b = d.b(35);
  protected boolean A = false;
  protected boolean B = false;
  protected boolean C = false;
  protected boolean D = true;
  private g c = new g(0);
  private g d = new g(2);
  private g e = new g(0);
  y f;
  protected SecureRandom g;
  private w0 h = null;
  private b1 i = null;
  private volatile boolean j = false;
  private volatile boolean k = false;
  private volatile boolean l = false;
  private volatile boolean m = true;
  private volatile int n = 0;
  private byte[] o = null;
  protected i1 p = null;
  protected c0 q = null;
  protected a0 r = null;
  protected h s = null;
  protected int[] t = null;
  protected short[] u = null;
  protected Hashtable v = null;
  protected Hashtable w = null;
  protected short x = (short)0;
  protected boolean y = false;
  protected boolean z = false;
  
  public g1(InputStream paramInputStream, OutputStream paramOutputStream, SecureRandom paramSecureRandom)
  {
    this.f = new y(this, paramInputStream, paramOutputStream);
    this.g = paramSecureRandom;
  }
  
  private void C()
    throws IOException
  {
    while (this.d.b() >= 2)
    {
      byte[] arrayOfByte = this.d.i(2, 0);
      u((short)arrayOfByte[0], (short)arrayOfByte[1]);
    }
  }
  
  private void D() {}
  
  private void E(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    int i1 = 0;
    while (i1 < paramInt2) {
      if (m1.k0(paramArrayOfByte, paramInt1 + i1) == 1)
      {
        if ((!this.z) && (this.d.b() <= 0) && (this.e.b() <= 0))
        {
          this.f.p();
          this.z = true;
          w();
          i1++;
        }
        else
        {
          throw new TlsFatalAlert((short)10);
        }
      }
      else {
        throw new TlsFatalAlert((short)50);
      }
    }
  }
  
  private void G(g paramg)
    throws IOException
  {
    while (paramg.b() >= 4)
    {
      Object localObject = new byte[4];
      boolean bool = false;
      paramg.e((byte[])localObject, 0, 4, 0);
      short s1 = m1.k0((byte[])localObject, 0);
      int i1 = m1.h0((byte[])localObject, 1);
      int i2 = i1 + 4;
      if (paramg.b() < i2) {
        break;
      }
      if ((this.x == 16) || (s1 == 20)) {
        bool = true;
      }
      e(bool);
      if (s1 != 0)
      {
        if (s1 == 20)
        {
          localObject = n();
          if ((this.o == null) && (((p0)localObject).e().e() != null)) {
            this.o = k(((p0)localObject).isServer() ^ true);
          }
        }
        paramg.c(this.f.i(), i2);
      }
      paramg.g(4);
      A(s1, paramg.f(i1));
    }
  }
  
  protected static Hashtable M(ByteArrayInputStream paramByteArrayInputStream)
    throws IOException
  {
    if (paramByteArrayInputStream.available() < 1) {
      return null;
    }
    Object localObject = m1.a0(paramByteArrayInputStream);
    c(paramByteArrayInputStream);
    localObject = new ByteArrayInputStream((byte[])localObject);
    paramByteArrayInputStream = new Hashtable();
    while (((ByteArrayInputStream)localObject).available() > 0) {
      if (paramByteArrayInputStream.put(d.b(m1.d0((InputStream)localObject)), m1.a0((InputStream)localObject)) != null) {
        throw new TlsFatalAlert((short)47);
      }
    }
    return paramByteArrayInputStream;
  }
  
  protected static Vector N(ByteArrayInputStream paramByteArrayInputStream)
    throws IOException
  {
    Object localObject = m1.b0(paramByteArrayInputStream);
    c(paramByteArrayInputStream);
    localObject = new ByteArrayInputStream((byte[])localObject);
    paramByteArrayInputStream = new Vector();
    while (((ByteArrayInputStream)localObject).available() > 0) {
      paramByteArrayInputStream.addElement(new e0(m1.d0((InputStream)localObject), m1.a0((InputStream)localObject)));
    }
    return paramByteArrayInputStream;
  }
  
  protected static void W(OutputStream paramOutputStream, Hashtable paramHashtable)
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    Y(localByteArrayOutputStream, paramHashtable, true);
    Y(localByteArrayOutputStream, paramHashtable, false);
    m1.t0(localByteArrayOutputStream.toByteArray(), paramOutputStream);
  }
  
  protected static void Y(OutputStream paramOutputStream, Hashtable paramHashtable, boolean paramBoolean)
    throws IOException
  {
    Enumeration localEnumeration = paramHashtable.keys();
    while (localEnumeration.hasMoreElements())
    {
      Object localObject = (Integer)localEnumeration.nextElement();
      int i1 = ((Integer)localObject).intValue();
      localObject = (byte[])paramHashtable.get(localObject);
      boolean bool;
      if (localObject.length == 0) {
        bool = true;
      } else {
        bool = false;
      }
      if (paramBoolean == bool)
      {
        m1.i(i1);
        m1.w0(i1, paramOutputStream);
        m1.t0((byte[])localObject, paramOutputStream);
      }
    }
  }
  
  protected static void Z(OutputStream paramOutputStream, Vector paramVector)
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    for (int i1 = 0; i1 < paramVector.size(); i1++)
    {
      e0 locale0 = (e0)paramVector.elementAt(i1);
      int i2 = locale0.b();
      m1.i(i2);
      m1.w0(i2, localByteArrayOutputStream);
      m1.t0(locale0.a(), localByteArrayOutputStream);
    }
    m1.u0(localByteArrayOutputStream.toByteArray(), paramOutputStream);
  }
  
  protected static void c(ByteArrayInputStream paramByteArrayInputStream)
    throws IOException
  {
    if (paramByteArrayInputStream.available() <= 0) {
      return;
    }
    throw new TlsFatalAlert((short)50);
  }
  
  protected static byte[] i(boolean paramBoolean, org.bouncycastle.crypto.prng.g paramg)
  {
    byte[] arrayOfByte = new byte[32];
    paramg.b(arrayOfByte);
    if (paramBoolean) {
      m1.s0(arrayOfByte, 0);
    }
    return arrayOfByte;
  }
  
  protected static byte[] j(byte[] paramArrayOfByte)
    throws IOException
  {
    return m1.q(paramArrayOfByte);
  }
  
  protected static void l(p0 paramp0, x0 paramx0)
    throws IOException
  {
    paramx0 = paramx0.i();
    try
    {
      paramp0.e().f = m1.f(paramp0, paramx0);
      return;
    }
    finally
    {
      if (paramx0 != null) {
        a.u(paramx0, (byte)0);
      }
    }
  }
  
  protected static byte[] p(p0 paramp0, v0 paramv0, byte[] paramArrayOfByte)
  {
    paramv0 = paramv0.f();
    if ((paramArrayOfByte != null) && (m1.K(paramp0))) {
      paramv0.update(paramArrayOfByte, 0, paramArrayOfByte.length);
    }
    paramp0 = new byte[paramv0.e()];
    paramv0.doFinal(paramp0, 0);
    return paramp0;
  }
  
  protected static int s(p0 paramp0, int paramInt)
    throws IOException
  {
    boolean bool = m1.P(paramp0);
    switch (paramInt)
    {
    default: 
      switch (paramInt)
      {
      default: 
        switch (paramInt)
        {
        default: 
          switch (paramInt)
          {
          default: 
            switch (paramInt)
            {
            default: 
              switch (paramInt)
              {
              default: 
                switch (paramInt)
                {
                default: 
                  switch (paramInt)
                  {
                  default: 
                    switch (paramInt)
                    {
                    default: 
                      switch (paramInt)
                      {
                      default: 
                        if (bool) {
                          return 1;
                        }
                        return 0;
                      }
                      break;
                    }
                    break;
                  }
                  break;
                }
                break;
              }
              break;
            }
          case 175: 
          case 177: 
          case 179: 
          case 181: 
          case 183: 
          case 49208: 
          case 49211: 
          case 49301: 
          case 49303: 
          case 49305: 
            if (bool) {
              return 2;
            }
            return 0;
          }
        case 157: 
        case 159: 
        case 161: 
        case 163: 
        case 165: 
        case 167: 
        case 169: 
        case 171: 
        case 173: 
          if (bool) {
            return 2;
          }
          throw new TlsFatalAlert((short)47);
        }
        break;
      }
      break;
    }
    if (bool) {
      return 1;
    }
    throw new TlsFatalAlert((short)47);
  }
  
  protected abstract void A(short paramShort, ByteArrayInputStream paramByteArrayInputStream)
    throws IOException;
  
  protected void B()
  {
    Object localObject = this.q;
    if (localObject != null)
    {
      ((c0)localObject).a();
      this.q = null;
    }
    localObject = this.p;
    if (localObject != null)
    {
      ((i1)localObject).invalidate();
      this.p = null;
    }
  }
  
  protected void F(ByteArrayInputStream paramByteArrayInputStream)
    throws IOException
  {
    byte[] arrayOfByte = this.o;
    if (arrayOfByte != null)
    {
      arrayOfByte = m1.Z(arrayOfByte.length, paramByteArrayInputStream);
      c(paramByteArrayInputStream);
      if (a.o(this.o, arrayOfByte)) {
        return;
      }
      throw new TlsFatalAlert((short)51);
    }
    throw new TlsFatalAlert((short)80);
  }
  
  protected short H(Hashtable paramHashtable1, Hashtable paramHashtable2, short paramShort)
    throws IOException
  {
    short s1 = u0.b(paramHashtable2);
    if ((s1 >= 0) && ((!t.a(s1)) || ((!this.y) && (s1 != u0.b(paramHashtable1))))) {
      throw new TlsFatalAlert(paramShort);
    }
    return s1;
  }
  
  protected void I(short paramShort, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    switch (paramShort)
    {
    default: 
      throw new TlsFatalAlert((short)80);
    case 23: 
      if (this.l)
      {
        this.c.a(paramArrayOfByte, paramInt1, paramInt2);
        D();
      }
      else
      {
        throw new TlsFatalAlert((short)10);
      }
      break;
    case 22: 
      if (this.e.b() > 0)
      {
        this.e.a(paramArrayOfByte, paramInt1, paramInt2);
        G(this.e);
      }
      else
      {
        g localg = new g(paramArrayOfByte, paramInt1, paramInt2);
        G(localg);
        paramShort = localg.b();
        if (paramShort > 0) {
          this.e.a(paramArrayOfByte, paramInt1 + paramInt2 - paramShort, paramShort);
        }
      }
      break;
    case 21: 
      this.d.a(paramArrayOfByte, paramInt1, paramInt2);
      C();
      break;
    case 20: 
      E(paramArrayOfByte, paramInt1, paramInt2);
    }
  }
  
  protected void J(short paramShort, String paramString, Throwable paramThrowable)
    throws IOException
  {
    t().n((short)2, paramShort, paramString, paramThrowable);
    int i1 = (byte)paramShort;
    try
    {
      this.f.v((short)21, new byte[] { 2, i1 }, 0, 2);
      return;
    }
    catch (Exception paramString)
    {
      for (;;) {}
    }
  }
  
  protected void K(short paramShort, String paramString)
    throws IOException
  {
    t().n((short)1, paramShort, paramString, null);
    Q((short)21, new byte[] { 1, (byte)paramShort }, 0, 2);
  }
  
  protected int L(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (paramInt2 < 1) {
      return 0;
    }
    while (this.c.b() == 0)
    {
      if (this.j)
      {
        if (!this.k)
        {
          if (this.l) {
            return -1;
          }
          throw new IllegalStateException("Cannot read application data until initial handshake completed.");
        }
        throw new IOException("Cannot read application data on failed TLS connection");
      }
      P();
    }
    paramInt2 = Math.min(paramInt2, this.c.b());
    this.c.h(paramArrayOfByte, paramInt1, paramInt2, 0);
    return paramInt2;
  }
  
  protected void O()
    throws IOException
  {
    if (!m1.K(n()))
    {
      K((short)100, "Renegotiation not supported");
      return;
    }
    throw new TlsFatalAlert((short)40);
  }
  
  protected void P()
    throws IOException
  {
    try
    {
      if (this.f.o()) {
        return;
      }
      if (!this.l)
      {
        TlsFatalAlert localTlsFatalAlert1 = new org/bouncycastle/crypto/tls/TlsFatalAlert;
        localTlsFatalAlert1.<init>((short)40);
        throw localTlsFatalAlert1;
      }
      z();
      throw new TlsNoCloseNotifyException();
    }
    catch (RuntimeException localRuntimeException)
    {
      y((short)80, "Failed to read record", localRuntimeException);
      throw new TlsFatalAlert((short)80, localRuntimeException);
    }
    catch (IOException localIOException)
    {
      y((short)80, "Failed to read record", localIOException);
      throw localIOException;
    }
    catch (TlsFatalAlert localTlsFatalAlert2)
    {
      y(localTlsFatalAlert2.getAlertDescription(), "Failed to read record", localTlsFatalAlert2);
      throw localTlsFatalAlert2;
    }
    catch (TlsFatalAlertReceived localTlsFatalAlertReceived)
    {
      throw localTlsFatalAlertReceived;
    }
  }
  
  protected void Q(short paramShort, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    try
    {
      this.f.v(paramShort, paramArrayOfByte, paramInt1, paramInt2);
      return;
    }
    catch (RuntimeException paramArrayOfByte)
    {
      y((short)80, "Failed to write record", paramArrayOfByte);
      throw new TlsFatalAlert((short)80, paramArrayOfByte);
    }
    catch (IOException paramArrayOfByte)
    {
      y((short)80, "Failed to write record", paramArrayOfByte);
      throw paramArrayOfByte;
    }
    catch (TlsFatalAlert paramArrayOfByte)
    {
      y(paramArrayOfByte.getAlertDescription(), "Failed to write record", paramArrayOfByte);
      throw paramArrayOfByte;
    }
  }
  
  protected void R(h paramh)
    throws IOException
  {
    Object localObject = paramh;
    if (paramh == null) {
      localObject = h.a;
    }
    if ((((h)localObject).c()) && (!n().isServer()))
    {
      paramh = n().b();
      if (paramh.i())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramh.toString());
        ((StringBuilder)localObject).append(" client didn't provide credentials");
        K((short)41, ((StringBuilder)localObject).toString());
        return;
      }
    }
    paramh = new a((short)11);
    ((h)localObject).a(paramh);
    paramh.a();
  }
  
  protected void S()
    throws IOException
  {
    Q((short)20, new byte[] { 1 }, 0, 1);
    this.f.r();
  }
  
  protected void T()
    throws IOException
  {
    byte[] arrayOfByte = k(n().isServer());
    a locala = new a((short)20, arrayOfByte.length);
    locala.write(arrayOfByte);
    locala.a();
  }
  
  protected void U(Vector paramVector)
    throws IOException
  {
    a locala = new a((short)23);
    Z(locala, paramVector);
    locala.a();
  }
  
  protected void V(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (!this.j)
    {
      while (paramInt2 > 0)
      {
        int i1 = paramInt1;
        int i2 = paramInt2;
        if (this.m)
        {
          i2 = this.n;
          if (i2 != 1)
          {
            if (i2 != 2)
            {
              Q((short)23, paramArrayOfByte, paramInt1, 1);
              i1 = paramInt1 + 1;
              i2 = paramInt2 - 1;
            }
            else
            {
              this.m = false;
            }
          }
          else
          {
            Q((short)23, m1.a, 0, 0);
            i2 = paramInt2;
            i1 = paramInt1;
          }
        }
        paramInt1 = i1;
        paramInt2 = i2;
        if (i2 > 0)
        {
          paramInt2 = Math.min(i2, this.f.j());
          Q((short)23, paramArrayOfByte, i1, paramInt2);
          paramInt1 = i1 + paramInt2;
          paramInt2 = i2 - paramInt2;
        }
      }
      return;
    }
    throw new IOException("Cannot write application data on closed/failed TLS connection");
  }
  
  protected void X(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (paramInt2 >= 4)
    {
      if (m1.k0(paramArrayOfByte, paramInt1) != 0) {
        this.f.i().write(paramArrayOfByte, paramInt1, paramInt2);
      }
      int i1 = 0;
      int i2;
      do
      {
        i2 = Math.min(paramInt2 - i1, this.f.j());
        Q((short)22, paramArrayOfByte, paramInt1 + i1, i2);
        i2 = i1 + i2;
        i1 = i2;
      } while (i2 < paramInt2);
      return;
    }
    throw new TlsFatalAlert((short)80);
  }
  
  protected int a()
  {
    return this.c.b();
  }
  
  protected void b()
    throws IOException
  {
    short s1 = this.r.l;
    if (s1 >= 0) {
      if (t.a(s1))
      {
        int i1 = this.r.l;
        this.f.t(1 << i1 + 8);
      }
      else
      {
        throw new TlsFatalAlert((short)80);
      }
    }
  }
  
  protected void d()
    throws IOException
  {
    if (this.D) {
      while (this.x != 16) {
        if (!this.j) {
          P();
        } else {
          throw new TlsFatalAlert((short)80);
        }
      }
    }
  }
  
  protected void e(boolean paramBoolean)
    throws IOException
  {
    if (paramBoolean == this.z) {
      return;
    }
    throw new TlsFatalAlert((short)10);
  }
  
  protected void f()
  {
    byte[] arrayOfByte = this.o;
    if (arrayOfByte != null)
    {
      a.u(arrayOfByte, (byte)0);
      this.o = null;
    }
    this.r.a();
    this.s = null;
    this.t = null;
    this.u = null;
    this.v = null;
    this.w = null;
    this.y = false;
    this.z = false;
    this.A = false;
    this.B = false;
    this.C = false;
  }
  
  public void g()
    throws IOException
  {
    x(true);
  }
  
  protected void h()
    throws IOException
  {
    try
    {
      this.x = ((short)16);
      this.d.j();
      this.e.j();
      this.f.e();
      boolean bool;
      if (!m1.N(n())) {
        bool = true;
      } else {
        bool = false;
      }
      this.m = bool;
      Object localObject1;
      if (!this.l)
      {
        this.l = true;
        if (this.D)
        {
          localObject1 = new org/bouncycastle/crypto/tls/w0;
          ((w0)localObject1).<init>(this);
          this.h = ((w0)localObject1);
          localObject1 = new org/bouncycastle/crypto/tls/b1;
          ((b1)localObject1).<init>(this);
          this.i = ((b1)localObject1);
        }
      }
      if (this.p != null)
      {
        if (this.q == null)
        {
          localObject1 = new org/bouncycastle/crypto/tls/c0$b;
          ((c0.b)localObject1).<init>();
          this.q = ((c0.b)localObject1).b(this.r.b()).c(this.r.d()).d(this.r.e()).f(this.s).e(this.r.f()).g(this.r.h()).h(this.w).a();
          localObject1 = new org/bouncycastle/crypto/tls/j1;
          ((j1)localObject1).<init>(this.p.a(), this.q);
          this.p = ((i1)localObject1);
        }
        o().h(this.p);
      }
      t().t();
      return;
    }
    finally
    {
      f();
    }
  }
  
  protected byte[] k(boolean paramBoolean)
  {
    p0 localp0 = n();
    String str;
    if (paramBoolean) {
      str = "server finished";
    } else {
      str = "client finished";
    }
    byte[] arrayOfByte;
    if (paramBoolean) {
      arrayOfByte = m1.g;
    } else {
      arrayOfByte = m1.f;
    }
    return m1.h(localp0, str, p(localp0, this.f.h(), arrayOfByte));
  }
  
  protected void m()
    throws IOException
  {
    this.f.f();
  }
  
  protected abstract p0 n();
  
  abstract c o();
  
  public InputStream q()
  {
    if (this.D) {
      return this.h;
    }
    throw new IllegalStateException("Cannot use InputStream in non-blocking mode! Use offerInput() instead.");
  }
  
  public OutputStream r()
  {
    if (this.D) {
      return this.i;
    }
    throw new IllegalStateException("Cannot use OutputStream in non-blocking mode! Use offerOutput() instead.");
  }
  
  protected abstract f1 t();
  
  protected void u(short paramShort1, short paramShort2)
    throws IOException
  {
    t().p(paramShort1, paramShort2);
    if (paramShort1 == 1)
    {
      v(paramShort2);
      return;
    }
    z();
    throw new TlsFatalAlertReceived(paramShort2);
  }
  
  protected void v(short paramShort)
    throws IOException
  {
    if (paramShort == 0) {
      if (this.l) {
        x(false);
      } else {
        throw new TlsFatalAlert((short)40);
      }
    }
  }
  
  protected void w()
    throws IOException
  {}
  
  protected void x(boolean paramBoolean)
    throws IOException
  {
    if (!this.j)
    {
      this.j = true;
      if ((paramBoolean) && (!this.l)) {
        K((short)90, "User canceled handshake");
      }
      K((short)0, "Connection closed");
      this.f.q();
      if (!this.l) {
        f();
      }
    }
  }
  
  protected void y(short paramShort, String paramString, Throwable paramThrowable)
    throws IOException
  {
    if (!this.j)
    {
      J(paramShort, paramString, paramThrowable);
      z();
    }
  }
  
  protected void z()
  {
    this.j = true;
    this.k = true;
    B();
    this.f.q();
    if (!this.l) {
      f();
    }
  }
  
  class a
    extends ByteArrayOutputStream
  {
    a(short paramShort)
      throws IOException
    {
      this(paramShort, 60);
    }
    
    a(short paramShort, int paramInt)
      throws IOException
    {
      super();
      m1.H0(paramShort, this);
      this.count += 3;
    }
    
    void a()
      throws IOException
    {
      int i = this.count - 4;
      m1.j(i);
      m1.D0(i, this.buf, 1);
      g1.this.X(this.buf, 0, this.count);
      this.buf = null;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\tls\g1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */