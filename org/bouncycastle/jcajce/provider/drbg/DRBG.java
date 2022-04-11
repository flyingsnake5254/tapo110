package org.bouncycastle.jcajce.provider.drbg;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.SecureRandomSpi;
import java.security.Security;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.bouncycastle.crypto.prng.SP800SecureRandom;
import org.bouncycastle.crypto.prng.d;
import org.bouncycastle.crypto.prng.e;
import org.bouncycastle.crypto.prng.h;
import org.bouncycastle.crypto.t.b;
import org.bouncycastle.util.f;

public class DRBG
{
  private static final String[][] a = { { "sun.security.provider.Sun", "sun.security.provider.SecureRandom" }, { "org.apache.harmony.security.provider.crypto.CryptoProvider", "org.apache.harmony.security.provider.crypto.SHA1PRNG_SecureRandomImpl" }, { "com.android.org.conscrypt.OpenSSLProvider", "com.android.org.conscrypt.OpenSSLRandom" }, { "org.conscrypt.OpenSSLProvider", "org.conscrypt.OpenSSLRandom" } };
  private static final Object[] b = i();
  
  private static SecureRandom e(boolean paramBoolean)
  {
    if (System.getProperty("org.bouncycastle.drbg.entropysource") != null)
    {
      localObject = g();
      d locald = ((e)localObject).get(128);
      arrayOfByte = locald.a();
      if (paramBoolean) {
        arrayOfByte = j(arrayOfByte);
      } else {
        arrayOfByte = k(arrayOfByte);
      }
      return new h((e)localObject).c(arrayOfByte).b(new org.bouncycastle.crypto.p.i(), org.bouncycastle.util.a.l(locald.a(), locald.a()), paramBoolean);
    }
    Object localObject = new f();
    byte[] arrayOfByte = ((SecureRandom)localObject).generateSeed(16);
    if (paramBoolean) {
      arrayOfByte = j(arrayOfByte);
    } else {
      arrayOfByte = k(arrayOfByte);
    }
    return new h((SecureRandom)localObject, true).c(arrayOfByte).b(new org.bouncycastle.crypto.p.i(), ((SecureRandom)localObject).generateSeed(32), paramBoolean);
  }
  
  private static SecureRandom f()
  {
    if (b != null) {
      return new d();
    }
    try
    {
      Object localObject = Security.getProperty("securerandom.source");
      URL localURL = new java/net/URL;
      localURL.<init>((String)localObject);
      localObject = new g(localURL);
      return (SecureRandom)localObject;
    }
    catch (Exception localException) {}
    return new SecureRandom();
  }
  
  private static e g()
  {
    return (e)AccessController.doPrivileged(new c(System.getProperty("org.bouncycastle.drbg.entropysource")));
  }
  
  private static SecureRandom h()
  {
    if (((Boolean)AccessController.doPrivileged(new a())).booleanValue()) {
      return (SecureRandom)AccessController.doPrivileged(new b());
    }
    return f();
  }
  
  private static final Object[] i()
  {
    int i = 0;
    for (;;)
    {
      Object localObject1 = a;
      if (i >= localObject1.length) {
        break;
      }
      Object localObject3 = localObject1[i];
      try
      {
        localObject1 = Class.forName(localObject3[0]).newInstance();
        localObject3 = Class.forName(localObject3[1]).newInstance();
        return new Object[] { localObject1, localObject3 };
      }
      finally
      {
        i++;
      }
    }
    return null;
  }
  
  private static byte[] j(byte[] paramArrayOfByte)
  {
    return org.bouncycastle.util.a.n(org.bouncycastle.util.i.e("Default"), paramArrayOfByte, f.n(Thread.currentThread().getId()), f.n(System.currentTimeMillis()));
  }
  
  private static byte[] k(byte[] paramArrayOfByte)
  {
    return org.bouncycastle.util.a.n(org.bouncycastle.util.i.e("Nonce"), paramArrayOfByte, f.q(Thread.currentThread().getId()), f.q(System.currentTimeMillis()));
  }
  
  public static class Default
    extends SecureRandomSpi
  {
    private static final SecureRandom random = DRBG.c(true);
    
    protected byte[] engineGenerateSeed(int paramInt)
    {
      return random.generateSeed(paramInt);
    }
    
    protected void engineNextBytes(byte[] paramArrayOfByte)
    {
      random.nextBytes(paramArrayOfByte);
    }
    
    protected void engineSetSeed(byte[] paramArrayOfByte)
    {
      random.setSeed(paramArrayOfByte);
    }
  }
  
  public static class NonceAndIV
    extends SecureRandomSpi
  {
    private static final SecureRandom random = DRBG.c(false);
    
    protected byte[] engineGenerateSeed(int paramInt)
    {
      return random.generateSeed(paramInt);
    }
    
    protected void engineNextBytes(byte[] paramArrayOfByte)
    {
      random.nextBytes(paramArrayOfByte);
    }
    
    protected void engineSetSeed(byte[] paramArrayOfByte)
    {
      random.setSeed(paramArrayOfByte);
    }
  }
  
  static final class a
    implements PrivilegedAction<Boolean>
  {
    public Boolean a()
    {
      boolean bool = false;
      try
      {
        if (SecureRandom.class.getMethod("getInstanceStrong", new Class[0]) != null) {
          bool = true;
        }
        return Boolean.valueOf(bool);
      }
      catch (Exception localException) {}
      return Boolean.FALSE;
    }
  }
  
  static final class b
    implements PrivilegedAction<SecureRandom>
  {
    public SecureRandom a()
    {
      try
      {
        SecureRandom localSecureRandom = (SecureRandom)SecureRandom.class.getMethod("getInstanceStrong", new Class[0]).invoke(null, new Object[0]);
        return localSecureRandom;
      }
      catch (Exception localException) {}
      return DRBG.b();
    }
  }
  
  static final class c
    implements PrivilegedAction<e>
  {
    c(String paramString) {}
    
    public e a()
    {
      try
      {
        localObject = (e)org.bouncycastle.jcajce.provider.symmetric.util.a.a(DRBG.class, this.a).newInstance();
        return (e)localObject;
      }
      catch (Exception localException)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("entropy source ");
        ((StringBuilder)localObject).append(this.a);
        ((StringBuilder)localObject).append(" not created: ");
        ((StringBuilder)localObject).append(localException.getMessage());
        throw new IllegalStateException(((StringBuilder)localObject).toString(), localException);
      }
    }
  }
  
  private static class d
    extends SecureRandom
  {
    d()
    {
      super((Provider)DRBG.a()[0]);
    }
  }
  
  private static class e
    extends Provider
  {
    protected e()
    {
      super(1.0D, "Bouncy Castle Hybrid Entropy Provider");
    }
  }
  
  private static class f
    extends SecureRandom
  {
    private final AtomicBoolean c = new AtomicBoolean(false);
    private final AtomicInteger d = new AtomicInteger(0);
    private final SecureRandom f;
    private final SP800SecureRandom q;
    
    f()
    {
      super(new DRBG.e());
      SecureRandom localSecureRandom = DRBG.d();
      this.f = localSecureRandom;
      this.q = new h(new a()).c(org.bouncycastle.util.i.e("Bouncy Castle Hybrid Entropy Source")).a(new b(new org.bouncycastle.crypto.p.i()), localSecureRandom.generateSeed(32), false);
    }
    
    public byte[] generateSeed(int paramInt)
    {
      byte[] arrayOfByte = new byte[paramInt];
      if ((this.d.getAndIncrement() > 20) && (this.c.getAndSet(false)))
      {
        this.d.set(0);
        this.q.reseed(null);
      }
      this.q.nextBytes(arrayOfByte);
      return arrayOfByte;
    }
    
    public void setSeed(long paramLong)
    {
      SP800SecureRandom localSP800SecureRandom = this.q;
      if (localSP800SecureRandom != null) {
        localSP800SecureRandom.setSeed(paramLong);
      }
    }
    
    public void setSeed(byte[] paramArrayOfByte)
    {
      SP800SecureRandom localSP800SecureRandom = this.q;
      if (localSP800SecureRandom != null) {
        localSP800SecureRandom.setSeed(paramArrayOfByte);
      }
    }
    
    class a
      implements e
    {
      a() {}
      
      public d get(int paramInt)
      {
        return new DRBG.f.b(DRBG.f.this, paramInt);
      }
    }
    
    private class b
      implements d
    {
      private final int a;
      private final AtomicReference b = new AtomicReference();
      private final AtomicBoolean c = new AtomicBoolean(false);
      
      b(int paramInt)
      {
        this.a = ((paramInt + 7) / 8);
      }
      
      public byte[] a()
      {
        byte[] arrayOfByte = (byte[])this.b.getAndSet(null);
        if ((arrayOfByte != null) && (arrayOfByte.length == this.a)) {
          this.c.set(false);
        } else {
          arrayOfByte = DRBG.f.a(DRBG.f.this).generateSeed(this.a);
        }
        if (!this.c.getAndSet(true)) {
          new Thread(new a(this.a)).start();
        }
        return arrayOfByte;
      }
      
      public int b()
      {
        return this.a * 8;
      }
      
      private class a
        implements Runnable
      {
        private final int c;
        
        a(int paramInt)
        {
          this.c = paramInt;
        }
        
        public void run()
        {
          DRBG.f.b.c(DRBG.f.b.this).set(DRBG.f.a(DRBG.f.this).generateSeed(this.c));
          DRBG.f.b(DRBG.f.this).set(true);
        }
      }
    }
  }
  
  private static class g
    extends SecureRandom
  {
    private final InputStream c;
    
    g(final URL paramURL)
    {
      super(new DRBG.e());
      this.c = ((InputStream)AccessController.doPrivileged(new a(paramURL)));
    }
    
    private int b(final byte[] paramArrayOfByte, final int paramInt1, final int paramInt2)
    {
      return ((Integer)AccessController.doPrivileged(new b(paramArrayOfByte, paramInt1, paramInt2))).intValue();
    }
    
    public byte[] generateSeed(int paramInt)
    {
      try
      {
        Object localObject1 = new byte[paramInt];
        int i = 0;
        while (i != paramInt)
        {
          int j = b((byte[])localObject1, i, paramInt - i);
          if (j <= -1) {
            break;
          }
          i += j;
        }
        if (i == paramInt) {
          return (byte[])localObject1;
        }
        localObject1 = new java/lang/InternalError;
        ((InternalError)localObject1).<init>("unable to fully read random source");
        throw ((Throwable)localObject1);
      }
      finally {}
    }
    
    public void setSeed(long paramLong) {}
    
    public void setSeed(byte[] paramArrayOfByte) {}
    
    class a
      implements PrivilegedAction<InputStream>
    {
      a(URL paramURL) {}
      
      public InputStream a()
      {
        try
        {
          InputStream localInputStream = paramURL.openStream();
          return localInputStream;
        }
        catch (IOException localIOException)
        {
          throw new InternalError("unable to open random source");
        }
      }
    }
    
    class b
      implements PrivilegedAction<Integer>
    {
      b(byte[] paramArrayOfByte, int paramInt1, int paramInt2) {}
      
      public Integer a()
      {
        try
        {
          int i = DRBG.g.a(DRBG.g.this).read(paramArrayOfByte, paramInt1, paramInt2);
          return Integer.valueOf(i);
        }
        catch (IOException localIOException)
        {
          throw new InternalError("unable to read random source");
        }
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\jcajce\provider\drbg\DRBG.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */