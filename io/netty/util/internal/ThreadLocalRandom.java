package io.netty.util.internal;

import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public final class ThreadLocalRandom
  extends Random
{
  private static final long addend = 11L;
  private static volatile long initialSeedUniquifier = 0L;
  private static final InternalLogger logger = InternalLoggerFactory.getInstance(ThreadLocalRandom.class);
  private static final long mask = 281474976710655L;
  private static final long multiplier = 25214903917L;
  private static volatile long seedGeneratorEndTime = 0L;
  private static final long seedGeneratorStartTime;
  private static final Thread seedGeneratorThread;
  private static final BlockingQueue<Long> seedQueue;
  private static final AtomicLong seedUniquifier = new AtomicLong();
  private static final long serialVersionUID = -5851777807851030925L;
  boolean initialized = true;
  private long pad0;
  private long pad1;
  private long pad2;
  private long pad3;
  private long pad4;
  private long pad5;
  private long pad6;
  private long pad7;
  private long rnd;
  
  static
  {
    initialSeedUniquifier = SystemPropertyUtil.getLong("io.netty.initialSeedUniquifier", 0L);
    if (initialSeedUniquifier == 0L)
    {
      if (SystemPropertyUtil.getBoolean("java.util.secureRandomSeed", false))
      {
        seedQueue = new LinkedBlockingQueue();
        seedGeneratorStartTime = System.nanoTime();
        Thread local1 = new Thread("initialSeedUniquifierGenerator")
        {
          public void run()
          {
            byte[] arrayOfByte = new SecureRandom().generateSeed(8);
            ThreadLocalRandom.access$002(System.nanoTime());
            long l1 = arrayOfByte[0];
            long l2 = arrayOfByte[1];
            long l3 = arrayOfByte[2];
            long l4 = arrayOfByte[3];
            long l5 = arrayOfByte[4];
            long l6 = arrayOfByte[5];
            long l7 = arrayOfByte[6];
            long l8 = arrayOfByte[7];
            ThreadLocalRandom.seedQueue.add(Long.valueOf((l1 & 0xFF) << 56 | (l2 & 0xFF) << 48 | (l3 & 0xFF) << 40 | (l4 & 0xFF) << 32 | (l5 & 0xFF) << 24 | (l6 & 0xFF) << 16 | (l7 & 0xFF) << 8 | l8 & 0xFF));
          }
        };
        seedGeneratorThread = local1;
        local1.setDaemon(true);
        local1.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler()
        {
          public void uncaughtException(Thread paramAnonymousThread, Throwable paramAnonymousThrowable)
          {
            ThreadLocalRandom.logger.debug("An exception has been raised by {}", paramAnonymousThread.getName(), paramAnonymousThrowable);
          }
        });
        local1.start();
      }
      else
      {
        initialSeedUniquifier = mix64(System.currentTimeMillis()) ^ mix64(System.nanoTime());
        seedGeneratorThread = null;
        seedQueue = null;
        seedGeneratorStartTime = 0L;
      }
    }
    else
    {
      seedGeneratorThread = null;
      seedQueue = null;
      seedGeneratorStartTime = 0L;
    }
  }
  
  ThreadLocalRandom()
  {
    super(newSeed());
  }
  
  public static ThreadLocalRandom current()
  {
    return InternalThreadLocalMap.get().random();
  }
  
  public static long getInitialSeedUniquifier()
  {
    long l1 = initialSeedUniquifier;
    if (l1 != 0L) {
      return l1;
    }
    try
    {
      l1 = initialSeedUniquifier;
      if (l1 != 0L) {
        return l1;
      }
      long l2 = seedGeneratorStartTime;
      long l3 = TimeUnit.SECONDS.toNanos(3L);
      int i = 0;
      for (;;)
      {
        long l4 = System.nanoTime();
        l4 = l2 + l3 - l4;
        boolean bool = l4 < 0L;
        if (!bool) {}
        try
        {
          Long localLong = (Long)seedQueue.poll();
          break label107;
          localLong = (Long)seedQueue.poll(l4, TimeUnit.NANOSECONDS);
          label107:
          if (localLong != null)
          {
            l3 = localLong.longValue();
            l1 = l3;
          }
          else
          {
            if (bool) {
              continue;
            }
            seedGeneratorThread.interrupt();
            logger.warn("Failed to generate a seed from SecureRandom within {} seconds. Not enough entropy?", Long.valueOf(3L));
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          i = 1;
          logger.warn("Failed to generate a seed from SecureRandom due to an InterruptedException.");
        }
      }
      l1 = l1 ^ 0x3255ECDC33BAE119 ^ Long.reverse(System.nanoTime());
      initialSeedUniquifier = l1;
      if (i != 0)
      {
        Thread.currentThread().interrupt();
        seedGeneratorThread.interrupt();
      }
      if (seedGeneratorEndTime == 0L) {
        seedGeneratorEndTime = System.nanoTime();
      }
      return l1;
    }
    finally {}
  }
  
  private static long mix64(long paramLong)
  {
    paramLong = (paramLong ^ paramLong >>> 33) * -49064778989728563L;
    paramLong = (paramLong ^ paramLong >>> 33) * -4265267296055464877L;
    return paramLong ^ paramLong >>> 33;
  }
  
  private static long newSeed()
  {
    Object localObject;
    long l1;
    boolean bool;
    long l2;
    long l3;
    do
    {
      localObject = seedUniquifier;
      l1 = ((AtomicLong)localObject).get();
      bool = l1 < 0L;
      if (bool) {
        l2 = l1;
      } else {
        l2 = getInitialSeedUniquifier();
      }
      l3 = 181783497276652981L * l2;
    } while (!((AtomicLong)localObject).compareAndSet(l1, l3));
    if (!bool)
    {
      localObject = logger;
      if (((InternalLogger)localObject).isDebugEnabled()) {
        if (seedGeneratorEndTime != 0L) {
          ((InternalLogger)localObject).debug(String.format("-Dio.netty.initialSeedUniquifier: 0x%016x (took %d ms)", new Object[] { Long.valueOf(l2), Long.valueOf(TimeUnit.NANOSECONDS.toMillis(seedGeneratorEndTime - seedGeneratorStartTime)) }));
        } else {
          ((InternalLogger)localObject).debug(String.format("-Dio.netty.initialSeedUniquifier: 0x%016x", new Object[] { Long.valueOf(l2) }));
        }
      }
    }
    return System.nanoTime() ^ l3;
  }
  
  public static void setInitialSeedUniquifier(long paramLong)
  {
    initialSeedUniquifier = paramLong;
  }
  
  protected int next(int paramInt)
  {
    long l = this.rnd * 25214903917L + 11L & 0xFFFFFFFFFFFF;
    this.rnd = l;
    return (int)(l >>> 48 - paramInt);
  }
  
  public double nextDouble(double paramDouble)
  {
    if (paramDouble > 0.0D) {
      return nextDouble() * paramDouble;
    }
    throw new IllegalArgumentException("n must be positive");
  }
  
  public double nextDouble(double paramDouble1, double paramDouble2)
  {
    if (paramDouble1 < paramDouble2) {
      return nextDouble() * (paramDouble2 - paramDouble1) + paramDouble1;
    }
    throw new IllegalArgumentException();
  }
  
  public int nextInt(int paramInt1, int paramInt2)
  {
    if (paramInt1 < paramInt2) {
      return nextInt(paramInt2 - paramInt1) + paramInt1;
    }
    throw new IllegalArgumentException();
  }
  
  public long nextLong(long paramLong)
  {
    long l1 = 0L;
    if (paramLong > 0L)
    {
      for (long l2 = paramLong; l2 >= 2147483647L; l2 = paramLong)
      {
        int i = next(2);
        paramLong = l2 >>> 1;
        if ((i & 0x2) != 0) {
          paramLong = l2 - paramLong;
        }
        long l3 = l1;
        if ((i & 0x1) == 0) {
          l3 = l1 + (l2 - paramLong);
        }
        l1 = l3;
      }
      return l1 + nextInt((int)l2);
    }
    throw new IllegalArgumentException("n must be positive");
  }
  
  public long nextLong(long paramLong1, long paramLong2)
  {
    if (paramLong1 < paramLong2) {
      return nextLong(paramLong2 - paramLong1) + paramLong1;
    }
    throw new IllegalArgumentException();
  }
  
  public void setSeed(long paramLong)
  {
    if (!this.initialized)
    {
      this.rnd = ((paramLong ^ 0x5DEECE66D) & 0xFFFFFFFFFFFF);
      return;
    }
    throw new UnsupportedOperationException();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\internal\ThreadLocalRandom.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */