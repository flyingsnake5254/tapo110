package io.netty.util;

import io.netty.util.internal.ObjectUtil;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class DefaultAttributeMap
  implements AttributeMap
{
  private static final int BUCKET_SIZE = 4;
  private static final int MASK = 3;
  private static final AtomicReferenceFieldUpdater<DefaultAttributeMap, AtomicReferenceArray> updater = AtomicReferenceFieldUpdater.newUpdater(DefaultAttributeMap.class, AtomicReferenceArray.class, "attributes");
  private volatile AtomicReferenceArray<DefaultAttribute<?>> attributes;
  
  private static int index(AttributeKey<?> paramAttributeKey)
  {
    return paramAttributeKey.id() & 0x3;
  }
  
  /* Error */
  public <T> Attribute<T> attr(AttributeKey<T> paramAttributeKey)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 51
    //   3: invokestatic 57	io/netty/util/internal/ObjectUtil:checkNotNull	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   6: pop
    //   7: aload_0
    //   8: getfield 59	io/netty/util/DefaultAttributeMap:attributes	Ljava/util/concurrent/atomic/AtomicReferenceArray;
    //   11: astore_2
    //   12: aload_2
    //   13: astore_3
    //   14: aload_2
    //   15: ifnonnull +31 -> 46
    //   18: new 24	java/util/concurrent/atomic/AtomicReferenceArray
    //   21: dup
    //   22: iconst_4
    //   23: invokespecial 62	java/util/concurrent/atomic/AtomicReferenceArray:<init>	(I)V
    //   26: astore_2
    //   27: aload_2
    //   28: astore_3
    //   29: getstatic 33	io/netty/util/DefaultAttributeMap:updater	Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;
    //   32: aload_0
    //   33: aconst_null
    //   34: aload_2
    //   35: invokevirtual 66	java/util/concurrent/atomic/AtomicReferenceFieldUpdater:compareAndSet	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z
    //   38: ifne +8 -> 46
    //   41: aload_0
    //   42: getfield 59	io/netty/util/DefaultAttributeMap:attributes	Ljava/util/concurrent/atomic/AtomicReferenceArray;
    //   45: astore_3
    //   46: aload_1
    //   47: invokestatic 68	io/netty/util/DefaultAttributeMap:index	(Lio/netty/util/AttributeKey;)I
    //   50: istore 4
    //   52: aload_3
    //   53: iload 4
    //   55: invokevirtual 72	java/util/concurrent/atomic/AtomicReferenceArray:get	(I)Ljava/lang/Object;
    //   58: checkcast 8	io/netty/util/DefaultAttributeMap$DefaultAttribute
    //   61: astore 5
    //   63: aload 5
    //   65: astore_2
    //   66: aload 5
    //   68: ifnonnull +61 -> 129
    //   71: new 8	io/netty/util/DefaultAttributeMap$DefaultAttribute
    //   74: dup
    //   75: invokespecial 73	io/netty/util/DefaultAttributeMap$DefaultAttribute:<init>	()V
    //   78: astore 5
    //   80: new 8	io/netty/util/DefaultAttributeMap$DefaultAttribute
    //   83: dup
    //   84: aload 5
    //   86: aload_1
    //   87: invokespecial 76	io/netty/util/DefaultAttributeMap$DefaultAttribute:<init>	(Lio/netty/util/DefaultAttributeMap$DefaultAttribute;Lio/netty/util/AttributeKey;)V
    //   90: astore_2
    //   91: aload 5
    //   93: aload_2
    //   94: invokestatic 80	io/netty/util/DefaultAttributeMap$DefaultAttribute:access$002	(Lio/netty/util/DefaultAttributeMap$DefaultAttribute;Lio/netty/util/DefaultAttributeMap$DefaultAttribute;)Lio/netty/util/DefaultAttributeMap$DefaultAttribute;
    //   97: pop
    //   98: aload_2
    //   99: aload 5
    //   101: invokestatic 83	io/netty/util/DefaultAttributeMap$DefaultAttribute:access$102	(Lio/netty/util/DefaultAttributeMap$DefaultAttribute;Lio/netty/util/DefaultAttributeMap$DefaultAttribute;)Lio/netty/util/DefaultAttributeMap$DefaultAttribute;
    //   104: pop
    //   105: aload_3
    //   106: iload 4
    //   108: aconst_null
    //   109: aload 5
    //   111: invokevirtual 86	java/util/concurrent/atomic/AtomicReferenceArray:compareAndSet	(ILjava/lang/Object;Ljava/lang/Object;)Z
    //   114: ifeq +5 -> 119
    //   117: aload_2
    //   118: areturn
    //   119: aload_3
    //   120: iload 4
    //   122: invokevirtual 72	java/util/concurrent/atomic/AtomicReferenceArray:get	(I)Ljava/lang/Object;
    //   125: checkcast 8	io/netty/util/DefaultAttributeMap$DefaultAttribute
    //   128: astore_2
    //   129: aload_2
    //   130: monitorenter
    //   131: aload_2
    //   132: astore_3
    //   133: aload_3
    //   134: invokestatic 90	io/netty/util/DefaultAttributeMap$DefaultAttribute:access$000	(Lio/netty/util/DefaultAttributeMap$DefaultAttribute;)Lio/netty/util/DefaultAttributeMap$DefaultAttribute;
    //   137: astore 5
    //   139: aload 5
    //   141: ifnonnull +34 -> 175
    //   144: new 8	io/netty/util/DefaultAttributeMap$DefaultAttribute
    //   147: astore 5
    //   149: aload 5
    //   151: aload_2
    //   152: aload_1
    //   153: invokespecial 76	io/netty/util/DefaultAttributeMap$DefaultAttribute:<init>	(Lio/netty/util/DefaultAttributeMap$DefaultAttribute;Lio/netty/util/AttributeKey;)V
    //   156: aload_3
    //   157: aload 5
    //   159: invokestatic 80	io/netty/util/DefaultAttributeMap$DefaultAttribute:access$002	(Lio/netty/util/DefaultAttributeMap$DefaultAttribute;Lio/netty/util/DefaultAttributeMap$DefaultAttribute;)Lio/netty/util/DefaultAttributeMap$DefaultAttribute;
    //   162: pop
    //   163: aload 5
    //   165: aload_3
    //   166: invokestatic 83	io/netty/util/DefaultAttributeMap$DefaultAttribute:access$102	(Lio/netty/util/DefaultAttributeMap$DefaultAttribute;Lio/netty/util/DefaultAttributeMap$DefaultAttribute;)Lio/netty/util/DefaultAttributeMap$DefaultAttribute;
    //   169: pop
    //   170: aload_2
    //   171: monitorexit
    //   172: aload 5
    //   174: areturn
    //   175: aload 5
    //   177: invokestatic 94	io/netty/util/DefaultAttributeMap$DefaultAttribute:access$200	(Lio/netty/util/DefaultAttributeMap$DefaultAttribute;)Lio/netty/util/AttributeKey;
    //   180: aload_1
    //   181: if_acmpne +16 -> 197
    //   184: aload 5
    //   186: invokestatic 98	io/netty/util/DefaultAttributeMap$DefaultAttribute:access$300	(Lio/netty/util/DefaultAttributeMap$DefaultAttribute;)Z
    //   189: ifne +8 -> 197
    //   192: aload_2
    //   193: monitorexit
    //   194: aload 5
    //   196: areturn
    //   197: aload 5
    //   199: astore_3
    //   200: goto -67 -> 133
    //   203: astore_1
    //   204: aload_2
    //   205: monitorexit
    //   206: aload_1
    //   207: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	208	0	this	DefaultAttributeMap
    //   0	208	1	paramAttributeKey	AttributeKey<T>
    //   11	194	2	localObject1	Object
    //   13	187	3	localObject2	Object
    //   50	71	4	i	int
    //   61	137	5	localDefaultAttribute	DefaultAttribute
    // Exception table:
    //   from	to	target	type
    //   133	139	203	finally
    //   144	172	203	finally
    //   175	194	203	finally
    //   204	206	203	finally
  }
  
  public <T> boolean hasAttr(AttributeKey<T> paramAttributeKey)
  {
    ObjectUtil.checkNotNull(paramAttributeKey, "key");
    Object localObject = this.attributes;
    if (localObject == null) {
      return false;
    }
    DefaultAttribute localDefaultAttribute = (DefaultAttribute)((AtomicReferenceArray)localObject).get(index(paramAttributeKey));
    if (localDefaultAttribute == null) {
      return false;
    }
    try
    {
      for (localObject = localDefaultAttribute.next; localObject != null; localObject = ((DefaultAttribute)localObject).next) {
        if ((((DefaultAttribute)localObject).key == paramAttributeKey) && (!((DefaultAttribute)localObject).removed)) {
          return true;
        }
      }
      return false;
    }
    finally {}
  }
  
  private static final class DefaultAttribute<T>
    extends AtomicReference<T>
    implements Attribute<T>
  {
    private static final long serialVersionUID = -2661411462200283011L;
    private final DefaultAttribute<?> head;
    private final AttributeKey<T> key;
    private DefaultAttribute<?> next;
    private DefaultAttribute<?> prev;
    private volatile boolean removed;
    
    DefaultAttribute()
    {
      this.head = this;
      this.key = null;
    }
    
    DefaultAttribute(DefaultAttribute<?> paramDefaultAttribute, AttributeKey<T> paramAttributeKey)
    {
      this.head = paramDefaultAttribute;
      this.key = paramAttributeKey;
    }
    
    private void remove0()
    {
      synchronized (this.head)
      {
        DefaultAttribute localDefaultAttribute2 = this.prev;
        if (localDefaultAttribute2 == null) {
          return;
        }
        localDefaultAttribute2.next = this.next;
        DefaultAttribute localDefaultAttribute3 = this.next;
        if (localDefaultAttribute3 != null) {
          localDefaultAttribute3.prev = localDefaultAttribute2;
        }
        this.prev = null;
        this.next = null;
        return;
      }
    }
    
    public T getAndRemove()
    {
      this.removed = true;
      Object localObject = getAndSet(null);
      remove0();
      return (T)localObject;
    }
    
    public AttributeKey<T> key()
    {
      return this.key;
    }
    
    public void remove()
    {
      this.removed = true;
      set(null);
      remove0();
    }
    
    public T setIfAbsent(T paramT)
    {
      Object localObject;
      do
      {
        localObject = null;
        if (compareAndSet(null, paramT)) {
          break;
        }
        localObject = get();
      } while (localObject == null);
      return (T)localObject;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\DefaultAttributeMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */