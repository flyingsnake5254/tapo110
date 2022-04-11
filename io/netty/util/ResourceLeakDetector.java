package io.netty.util;

import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class ResourceLeakDetector<T>
{
  private static final Level DEFAULT_LEVEL;
  private static final int DEFAULT_SAMPLING_INTERVAL = 128;
  private static final int DEFAULT_TARGET_RECORDS = 4;
  private static final String PROP_LEVEL = "io.netty.leakDetection.level";
  private static final String PROP_LEVEL_OLD = "io.netty.leakDetectionLevel";
  private static final String PROP_SAMPLING_INTERVAL = "io.netty.leakDetection.samplingInterval";
  private static final String PROP_TARGET_RECORDS = "io.netty.leakDetection.targetRecords";
  static final int SAMPLING_INTERVAL;
  private static final int TARGET_RECORDS;
  private static final AtomicReference<String[]> excludedMethods = new AtomicReference(EmptyArrays.EMPTY_STRINGS);
  private static Level level;
  private static final InternalLogger logger;
  private final Set<DefaultResourceLeak<?>> allLeaks = Collections.newSetFromMap(new ConcurrentHashMap());
  private final ReferenceQueue<Object> refQueue = new ReferenceQueue();
  private final Set<String> reportedLeaks = Collections.newSetFromMap(new ConcurrentHashMap());
  private final String resourceType;
  private final int samplingInterval;
  
  static
  {
    Level localLevel = Level.SIMPLE;
    DEFAULT_LEVEL = localLevel;
    InternalLogger localInternalLogger = InternalLoggerFactory.getInstance(ResourceLeakDetector.class);
    logger = localInternalLogger;
    String str = SystemPropertyUtil.get("io.netty.noResourceLeakDetection");
    boolean bool = false;
    if (str != null)
    {
      bool = SystemPropertyUtil.getBoolean("io.netty.noResourceLeakDetection", false);
      localInternalLogger.debug("-Dio.netty.noResourceLeakDetection: {}", Boolean.valueOf(bool));
      localInternalLogger.warn("-Dio.netty.noResourceLeakDetection is deprecated. Use '-D{}={}' instead.", "io.netty.leakDetection.level", localLevel.name().toLowerCase());
    }
    if (bool) {
      localLevel = Level.DISABLED;
    }
    localLevel = Level.parseLevel(SystemPropertyUtil.get("io.netty.leakDetection.level", SystemPropertyUtil.get("io.netty.leakDetectionLevel", localLevel.name())));
    int i = SystemPropertyUtil.getInt("io.netty.leakDetection.targetRecords", 4);
    TARGET_RECORDS = i;
    SAMPLING_INTERVAL = SystemPropertyUtil.getInt("io.netty.leakDetection.samplingInterval", 128);
    level = localLevel;
    if (localInternalLogger.isDebugEnabled())
    {
      localInternalLogger.debug("-D{}: {}", "io.netty.leakDetection.level", localLevel.name().toLowerCase());
      localInternalLogger.debug("-D{}: {}", "io.netty.leakDetection.targetRecords", Integer.valueOf(i));
    }
  }
  
  @Deprecated
  public ResourceLeakDetector(Class<?> paramClass)
  {
    this(StringUtil.simpleClassName(paramClass));
  }
  
  public ResourceLeakDetector(Class<?> paramClass, int paramInt)
  {
    this(StringUtil.simpleClassName(paramClass), paramInt, Long.MAX_VALUE);
  }
  
  @Deprecated
  public ResourceLeakDetector(Class<?> paramClass, int paramInt, long paramLong)
  {
    this(paramClass, paramInt);
  }
  
  @Deprecated
  public ResourceLeakDetector(String paramString)
  {
    this(paramString, 128, Long.MAX_VALUE);
  }
  
  @Deprecated
  public ResourceLeakDetector(String paramString, int paramInt, long paramLong)
  {
    this.resourceType = ((String)ObjectUtil.checkNotNull(paramString, "resourceType"));
    this.samplingInterval = paramInt;
  }
  
  public static void addExclusions(Class paramClass, String... paramVarArgs)
  {
    Object localObject1 = new HashSet(Arrays.asList(paramVarArgs));
    Object localObject2 = paramClass.getDeclaredMethods();
    int i = localObject2.length;
    for (int j = 0; (j < i) && ((!((Set)localObject1).remove(localObject2[j].getName())) || (!((Set)localObject1).isEmpty())); j++) {}
    if (((Set)localObject1).isEmpty())
    {
      do
      {
        localObject1 = (String[])excludedMethods.get();
        localObject2 = (String[])Arrays.copyOf((Object[])localObject1, localObject1.length + paramVarArgs.length * 2);
        for (j = 0; j < paramVarArgs.length; j++)
        {
          i = localObject1.length;
          int k = j * 2;
          localObject2[(i + k)] = paramClass.getName();
          localObject2[(localObject1.length + k + 1)] = paramVarArgs[j];
        }
      } while (!excludedMethods.compareAndSet(localObject1, localObject2));
      return;
    }
    paramVarArgs = new StringBuilder();
    paramVarArgs.append("Can't find '");
    paramVarArgs.append(localObject1);
    paramVarArgs.append("' in ");
    paramVarArgs.append(paramClass.getName());
    throw new IllegalArgumentException(paramVarArgs.toString());
  }
  
  private void clearRefQueue()
  {
    for (;;)
    {
      DefaultResourceLeak localDefaultResourceLeak = (DefaultResourceLeak)this.refQueue.poll();
      if (localDefaultResourceLeak == null) {
        return;
      }
      localDefaultResourceLeak.dispose();
    }
  }
  
  public static Level getLevel()
  {
    return level;
  }
  
  public static boolean isEnabled()
  {
    boolean bool;
    if (getLevel().ordinal() > Level.DISABLED.ordinal()) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private void reportLeak()
  {
    if (!needReport())
    {
      clearRefQueue();
      return;
    }
    for (;;)
    {
      Object localObject = (DefaultResourceLeak)this.refQueue.poll();
      if (localObject == null) {
        return;
      }
      if (((DefaultResourceLeak)localObject).dispose())
      {
        localObject = ((DefaultResourceLeak)localObject).toString();
        if (this.reportedLeaks.add(localObject)) {
          if (((String)localObject).isEmpty()) {
            reportUntracedLeak(this.resourceType);
          } else {
            reportTracedLeak(this.resourceType, (String)localObject);
          }
        }
      }
    }
  }
  
  @Deprecated
  public static void setEnabled(boolean paramBoolean)
  {
    Level localLevel;
    if (paramBoolean) {
      localLevel = Level.SIMPLE;
    } else {
      localLevel = Level.DISABLED;
    }
    setLevel(localLevel);
  }
  
  public static void setLevel(Level paramLevel)
  {
    level = (Level)ObjectUtil.checkNotNull(paramLevel, "level");
  }
  
  private DefaultResourceLeak track0(T paramT)
  {
    Level localLevel = level;
    if (localLevel == Level.DISABLED) {
      return null;
    }
    if (localLevel.ordinal() < Level.PARANOID.ordinal())
    {
      if (PlatformDependent.threadLocalRandom().nextInt(this.samplingInterval) == 0)
      {
        reportLeak();
        return new DefaultResourceLeak(paramT, this.refQueue, this.allLeaks);
      }
      return null;
    }
    reportLeak();
    return new DefaultResourceLeak(paramT, this.refQueue, this.allLeaks);
  }
  
  protected boolean needReport()
  {
    return logger.isErrorEnabled();
  }
  
  @Deprecated
  public final ResourceLeak open(T paramT)
  {
    return track0(paramT);
  }
  
  @Deprecated
  protected void reportInstancesLeak(String paramString) {}
  
  protected void reportTracedLeak(String paramString1, String paramString2)
  {
    logger.error("LEAK: {}.release() was not called before it's garbage-collected. See https://netty.io/wiki/reference-counted-objects.html for more information.{}", paramString1, paramString2);
  }
  
  protected void reportUntracedLeak(String paramString)
  {
    logger.error("LEAK: {}.release() was not called before it's garbage-collected. Enable advanced leak reporting to find out where the leak occurred. To enable advanced leak reporting, specify the JVM option '-D{}={}' or call {}.setLevel() See https://netty.io/wiki/reference-counted-objects.html for more information.", new Object[] { paramString, "io.netty.leakDetection.level", Level.ADVANCED.name().toLowerCase(), StringUtil.simpleClassName(this) });
  }
  
  public final ResourceLeakTracker<T> track(T paramT)
  {
    return track0(paramT);
  }
  
  private static final class DefaultResourceLeak<T>
    extends WeakReference<Object>
    implements ResourceLeakTracker<T>, ResourceLeak
  {
    private static final AtomicIntegerFieldUpdater<DefaultResourceLeak<?>> droppedRecordsUpdater = AtomicIntegerFieldUpdater.newUpdater(DefaultResourceLeak.class, "droppedRecords");
    private static final AtomicReferenceFieldUpdater<DefaultResourceLeak<?>, ResourceLeakDetector.Record> headUpdater = AtomicReferenceFieldUpdater.newUpdater(DefaultResourceLeak.class, ResourceLeakDetector.Record.class, "head");
    private final Set<DefaultResourceLeak<?>> allLeaks;
    private volatile int droppedRecords;
    private volatile ResourceLeakDetector.Record head;
    private final int trackedHash;
    
    DefaultResourceLeak(Object paramObject, ReferenceQueue<Object> paramReferenceQueue, Set<DefaultResourceLeak<?>> paramSet)
    {
      super(paramReferenceQueue);
      this.trackedHash = System.identityHashCode(paramObject);
      paramSet.add(this);
      headUpdater.set(this, new ResourceLeakDetector.Record(ResourceLeakDetector.Record.access$100()));
      this.allLeaks = paramSet;
    }
    
    /* Error */
    private static void reachabilityFence0(Object paramObject)
    {
      // Byte code:
      //   0: aload_0
      //   1: ifnull +15 -> 16
      //   4: aload_0
      //   5: monitorenter
      //   6: aload_0
      //   7: monitorexit
      //   8: goto +8 -> 16
      //   11: astore_1
      //   12: aload_0
      //   13: monitorexit
      //   14: aload_1
      //   15: athrow
      //   16: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	17	0	paramObject	Object
      //   11	4	1	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   6	8	11	finally
      //   12	14	11	finally
    }
    
    private void record0(Object paramObject)
    {
      if (ResourceLeakDetector.TARGET_RECORDS > 0)
      {
        AtomicReferenceFieldUpdater localAtomicReferenceFieldUpdater;
        ResourceLeakDetector.Record localRecord1;
        int j;
        ResourceLeakDetector.Record localRecord3;
        do
        {
          localAtomicReferenceFieldUpdater = headUpdater;
          localRecord1 = (ResourceLeakDetector.Record)localAtomicReferenceFieldUpdater.get(this);
          if (localRecord1 == null) {
            return;
          }
          int i = ResourceLeakDetector.Record.access$300(localRecord1);
          j = 1;
          int k = i + 1;
          int m = ResourceLeakDetector.TARGET_RECORDS;
          i = 0;
          ResourceLeakDetector.Record localRecord2;
          if (k >= m)
          {
            i = Math.min(k - ResourceLeakDetector.TARGET_RECORDS, 30);
            if (PlatformDependent.threadLocalRandom().nextInt(1 << i) == 0) {
              j = 0;
            }
            if (j != 0) {
              localRecord2 = ResourceLeakDetector.Record.access$400(localRecord1);
            } else {
              localRecord2 = localRecord1;
            }
          }
          else
          {
            localRecord2 = localRecord1;
            j = i;
          }
          localRecord3 = new io/netty/util/ResourceLeakDetector$Record;
          if (paramObject != null) {
            localRecord3.<init>(localRecord2, paramObject);
          } else {
            localRecord3.<init>(localRecord2);
          }
        } while (!localAtomicReferenceFieldUpdater.compareAndSet(this, localRecord1, localRecord3));
        if (j != 0) {
          droppedRecordsUpdater.incrementAndGet(this);
        }
      }
    }
    
    public boolean close()
    {
      if (this.allLeaks.remove(this))
      {
        clear();
        headUpdater.set(this, null);
        return true;
      }
      return false;
    }
    
    public boolean close(T paramT)
    {
      try
      {
        boolean bool = close();
        return bool;
      }
      finally
      {
        reachabilityFence0(paramT);
      }
    }
    
    boolean dispose()
    {
      clear();
      return this.allLeaks.remove(this);
    }
    
    public void record()
    {
      record0(null);
    }
    
    public void record(Object paramObject)
    {
      record0(paramObject);
    }
    
    public String toString()
    {
      ResourceLeakDetector.Record localRecord = (ResourceLeakDetector.Record)headUpdater.getAndSet(this, null);
      if (localRecord == null) {
        return "";
      }
      int i = droppedRecordsUpdater.get(this);
      int j = 0;
      int k = ResourceLeakDetector.Record.access$300(localRecord);
      int m = 1;
      k++;
      StringBuilder localStringBuilder = new StringBuilder(k * 2048);
      Object localObject = StringUtil.NEWLINE;
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("Recent access records: ");
      localStringBuilder.append((String)localObject);
      localObject = new HashSet(k);
      while (localRecord != ResourceLeakDetector.Record.access$100())
      {
        String str = localRecord.toString();
        if (((Set)localObject).add(str))
        {
          if (ResourceLeakDetector.Record.access$400(localRecord) == ResourceLeakDetector.Record.access$100())
          {
            localStringBuilder.append("Created at:");
            localStringBuilder.append(StringUtil.NEWLINE);
            localStringBuilder.append(str);
          }
          else
          {
            localStringBuilder.append('#');
            localStringBuilder.append(m);
            localStringBuilder.append(':');
            localStringBuilder.append(StringUtil.NEWLINE);
            localStringBuilder.append(str);
            m++;
          }
        }
        else {
          j++;
        }
        localRecord = ResourceLeakDetector.Record.access$400(localRecord);
      }
      if (j > 0)
      {
        localStringBuilder.append(": ");
        localStringBuilder.append(j);
        localStringBuilder.append(" leak records were discarded because they were duplicates");
        localStringBuilder.append(StringUtil.NEWLINE);
      }
      if (i > 0)
      {
        localStringBuilder.append(": ");
        localStringBuilder.append(i);
        localStringBuilder.append(" leak records were discarded because the leak record count is targeted to ");
        localStringBuilder.append(ResourceLeakDetector.TARGET_RECORDS);
        localStringBuilder.append(". Use system property ");
        localStringBuilder.append("io.netty.leakDetection.targetRecords");
        localStringBuilder.append(" to increase the limit.");
        localStringBuilder.append(StringUtil.NEWLINE);
      }
      localStringBuilder.setLength(localStringBuilder.length() - StringUtil.NEWLINE.length());
      return localStringBuilder.toString();
    }
  }
  
  public static enum Level
  {
    static
    {
      Level localLevel1 = new Level("DISABLED", 0);
      DISABLED = localLevel1;
      Level localLevel2 = new Level("SIMPLE", 1);
      SIMPLE = localLevel2;
      Level localLevel3 = new Level("ADVANCED", 2);
      ADVANCED = localLevel3;
      Level localLevel4 = new Level("PARANOID", 3);
      PARANOID = localLevel4;
      $VALUES = new Level[] { localLevel1, localLevel2, localLevel3, localLevel4 };
    }
    
    static Level parseLevel(String paramString)
    {
      String str = paramString.trim();
      Level[] arrayOfLevel = values();
      int i = arrayOfLevel.length;
      int j = 0;
      while (j < i)
      {
        paramString = arrayOfLevel[j];
        if ((!str.equalsIgnoreCase(paramString.name())) && (!str.equals(String.valueOf(paramString.ordinal())))) {
          j++;
        } else {
          return paramString;
        }
      }
      return ResourceLeakDetector.DEFAULT_LEVEL;
    }
  }
  
  private static final class Record
    extends Throwable
  {
    private static final Record BOTTOM = new Record();
    private static final long serialVersionUID = 6065153674892850720L;
    private final String hintString;
    private final Record next;
    private final int pos;
    
    private Record()
    {
      this.hintString = null;
      this.next = null;
      this.pos = -1;
    }
    
    Record(Record paramRecord)
    {
      this.hintString = null;
      this.next = paramRecord;
      paramRecord.pos += 1;
    }
    
    Record(Record paramRecord, Object paramObject)
    {
      if ((paramObject instanceof ResourceLeakHint)) {
        paramObject = ((ResourceLeakHint)paramObject).toHintString();
      } else {
        paramObject = paramObject.toString();
      }
      this.hintString = ((String)paramObject);
      this.next = paramRecord;
      paramRecord.pos += 1;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder(2048);
      if (this.hintString != null)
      {
        localStringBuilder.append("\tHint: ");
        localStringBuilder.append(this.hintString);
        localStringBuilder.append(StringUtil.NEWLINE);
      }
      StackTraceElement[] arrayOfStackTraceElement = getStackTrace();
      label150:
      for (int i = 3; i < arrayOfStackTraceElement.length; i++)
      {
        StackTraceElement localStackTraceElement = arrayOfStackTraceElement[i];
        String[] arrayOfString = (String[])ResourceLeakDetector.excludedMethods.get();
        for (int j = 0; j < arrayOfString.length; j += 2) {
          if ((arrayOfString[j].equals(localStackTraceElement.getClassName())) && (arrayOfString[(j + 1)].equals(localStackTraceElement.getMethodName()))) {
            break label150;
          }
        }
        localStringBuilder.append('\t');
        localStringBuilder.append(localStackTraceElement.toString());
        localStringBuilder.append(StringUtil.NEWLINE);
      }
      return localStringBuilder.toString();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\ResourceLeakDetector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */