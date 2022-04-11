package io.netty.buffer;

import io.netty.util.ByteProcessor;
import io.netty.util.IllegalReferenceCountException;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.ReferenceCounted;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.RecyclableArrayList;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class CompositeByteBuf
  extends AbstractReferenceCountedByteBuf
  implements Iterable<ByteBuf>
{
  static final ByteWrapper<byte[]> BYTE_ARRAY_WRAPPER = new ByteWrapper()
  {
    public boolean isEmpty(byte[] paramAnonymousArrayOfByte)
    {
      boolean bool;
      if (paramAnonymousArrayOfByte.length == 0) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public ByteBuf wrap(byte[] paramAnonymousArrayOfByte)
    {
      return Unpooled.wrappedBuffer(paramAnonymousArrayOfByte);
    }
  };
  static final ByteWrapper<ByteBuffer> BYTE_BUFFER_WRAPPER = new ByteWrapper()
  {
    public boolean isEmpty(ByteBuffer paramAnonymousByteBuffer)
    {
      return paramAnonymousByteBuffer.hasRemaining() ^ true;
    }
    
    public ByteBuf wrap(ByteBuffer paramAnonymousByteBuffer)
    {
      return Unpooled.wrappedBuffer(paramAnonymousByteBuffer);
    }
  };
  private static final Iterator<ByteBuf> EMPTY_ITERATOR;
  private static final ByteBuffer EMPTY_NIO_BUFFER = Unpooled.EMPTY_BUFFER.nioBuffer();
  private final ByteBufAllocator alloc;
  private int componentCount;
  private Component[] components;
  private final boolean direct;
  private boolean freed;
  private Component lastAccessed;
  private final int maxNumComponents;
  
  static
  {
    EMPTY_ITERATOR = Collections.emptyList().iterator();
  }
  
  CompositeByteBuf(ByteBufAllocator paramByteBufAllocator)
  {
    super(Integer.MAX_VALUE);
    this.alloc = paramByteBufAllocator;
    this.direct = false;
    this.maxNumComponents = 0;
    this.components = null;
  }
  
  public CompositeByteBuf(ByteBufAllocator paramByteBufAllocator, boolean paramBoolean, int paramInt)
  {
    this(paramByteBufAllocator, paramBoolean, paramInt, 0);
  }
  
  private CompositeByteBuf(ByteBufAllocator paramByteBufAllocator, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    super(Integer.MAX_VALUE);
    this.alloc = ((ByteBufAllocator)ObjectUtil.checkNotNull(paramByteBufAllocator, "alloc"));
    if (paramInt1 >= 1)
    {
      this.direct = paramBoolean;
      this.maxNumComponents = paramInt1;
      this.components = newCompArray(paramInt2, paramInt1);
      return;
    }
    paramByteBufAllocator = new StringBuilder();
    paramByteBufAllocator.append("maxNumComponents: ");
    paramByteBufAllocator.append(paramInt1);
    paramByteBufAllocator.append(" (expected: >= 1)");
    throw new IllegalArgumentException(paramByteBufAllocator.toString());
  }
  
  <T> CompositeByteBuf(ByteBufAllocator paramByteBufAllocator, boolean paramBoolean, int paramInt1, ByteWrapper<T> paramByteWrapper, T[] paramArrayOfT, int paramInt2)
  {
    this(paramByteBufAllocator, paramBoolean, paramInt1, paramArrayOfT.length - paramInt2);
    addComponents0(false, 0, paramByteWrapper, paramArrayOfT, paramInt2);
    consolidateIfNeeded();
    setIndex(0, capacity());
  }
  
  public CompositeByteBuf(ByteBufAllocator paramByteBufAllocator, boolean paramBoolean, int paramInt, Iterable<ByteBuf> paramIterable)
  {
    this(paramByteBufAllocator, paramBoolean, paramInt, i);
    addComponents(false, 0, paramIterable);
    setIndex(0, capacity());
  }
  
  public CompositeByteBuf(ByteBufAllocator paramByteBufAllocator, boolean paramBoolean, int paramInt, ByteBuf... paramVarArgs)
  {
    this(paramByteBufAllocator, paramBoolean, paramInt, paramVarArgs, 0);
  }
  
  CompositeByteBuf(ByteBufAllocator paramByteBufAllocator, boolean paramBoolean, int paramInt1, ByteBuf[] paramArrayOfByteBuf, int paramInt2)
  {
    this(paramByteBufAllocator, paramBoolean, paramInt1, paramArrayOfByteBuf.length - paramInt2);
    addComponents0(false, 0, paramArrayOfByteBuf, paramInt2);
    consolidateIfNeeded();
    setIndex0(0, capacity());
  }
  
  private void addComp(int paramInt, Component paramComponent)
  {
    shiftComps(paramInt, 1);
    this.components[paramInt] = paramComponent;
  }
  
  private int addComponent0(boolean paramBoolean, int paramInt, ByteBuf paramByteBuf)
  {
    int i = 0;
    try
    {
      checkComponentIndex(paramInt);
      Component localComponent = newComponent(ensureAccessible(paramByteBuf), 0);
      int j = localComponent.length();
      checkForOverflow(capacity(), j);
      addComp(paramInt, localComponent);
      if (j > 0) {
        try
        {
          if (paramInt < this.componentCount - 1) {
            updateComponentOffsets(paramInt);
          }
        }
        finally
        {
          paramInt = 1;
          break label114;
        }
      }
      if (paramInt > 0) {
        ((Component)localObject1).reposition(this.components[(paramInt - 1)].endOffset);
      }
      if (paramBoolean) {
        this.writerIndex += j;
      }
      return paramInt;
    }
    finally
    {
      paramInt = i;
      label114:
      if (paramInt == 0) {
        paramByteBuf.release();
      }
    }
  }
  
  private CompositeByteBuf addComponents(boolean paramBoolean, int paramInt, Iterable<ByteBuf> paramIterable)
  {
    if ((paramIterable instanceof ByteBuf)) {
      return addComponent(paramBoolean, paramInt, (ByteBuf)paramIterable);
    }
    ObjectUtil.checkNotNull(paramIterable, "buffers");
    paramIterable = paramIterable.iterator();
    try
    {
      checkComponentIndex(paramInt);
      while (paramIterable.hasNext())
      {
        ByteBuf localByteBuf = (ByteBuf)paramIterable.next();
        if (localByteBuf == null) {
          break;
        }
        paramInt = Math.min(addComponent0(paramBoolean, paramInt, localByteBuf) + 1, this.componentCount);
      }
      while (paramIterable.hasNext()) {
        ReferenceCountUtil.safeRelease(paramIterable.next());
      }
      consolidateIfNeeded();
      return this;
    }
    finally
    {
      while (paramIterable.hasNext()) {
        ReferenceCountUtil.safeRelease(paramIterable.next());
      }
    }
  }
  
  private <T> int addComponents0(boolean paramBoolean, int paramInt1, ByteWrapper<T> paramByteWrapper, T[] paramArrayOfT, int paramInt2)
  {
    checkComponentIndex(paramInt1);
    int i = paramArrayOfT.length;
    for (int j = paramInt1; paramInt2 < i; j = paramInt1)
    {
      T ? = paramArrayOfT[paramInt2];
      if (? == null) {
        break;
      }
      paramInt1 = j;
      if (!paramByteWrapper.isEmpty(?))
      {
        int k = addComponent0(paramBoolean, j, paramByteWrapper.wrap(?)) + 1;
        j = this.componentCount;
        paramInt1 = k;
        if (k > j) {
          paramInt1 = j;
        }
      }
      paramInt2++;
    }
    return j;
  }
  
  private CompositeByteBuf addComponents0(boolean paramBoolean, int paramInt1, ByteBuf[] paramArrayOfByteBuf, int paramInt2)
  {
    int i = paramArrayOfByteBuf.length;
    int j = i - paramInt2;
    int k = capacity();
    int m = 0;
    int n = 0;
    int i1 = 0;
    while (n < paramArrayOfByteBuf.length)
    {
      i1 += paramArrayOfByteBuf[n].readableBytes();
      checkForOverflow(k, i1);
      n++;
    }
    int i2 = Integer.MAX_VALUE;
    k = i2;
    n = paramInt2;
    try
    {
      checkComponentIndex(paramInt1);
      k = i2;
      n = paramInt2;
      shiftComps(paramInt1, j);
      i1 = m;
      if (paramInt1 > 0)
      {
        k = i2;
        n = paramInt2;
        i1 = this.components[(paramInt1 - 1)].endOffset;
      }
      n = paramInt1;
      m = i1;
      for (i1 = n; paramInt2 < i; i1++)
      {
        Object localObject1 = paramArrayOfByteBuf[paramInt2];
        if (localObject1 == null) {
          break;
        }
        k = i1;
        n = paramInt2;
        localObject1 = newComponent(ensureAccessible((ByteBuf)localObject1), m);
        k = i1;
        n = paramInt2;
        this.components[i1] = localObject1;
        k = i1;
        n = paramInt2;
        m = ((Component)localObject1).endOffset;
        paramInt2++;
      }
      return this;
    }
    finally
    {
      if (k < this.componentCount)
      {
        paramInt2 = j + paramInt1;
        if (k < paramInt2)
        {
          removeCompRange(k, paramInt2);
          while (n < i)
          {
            ReferenceCountUtil.safeRelease(paramArrayOfByteBuf[n]);
            n++;
          }
        }
        updateComponentOffsets(k);
      }
      if ((paramBoolean) && (k > paramInt1) && (k <= this.componentCount))
      {
        paramInt2 = this.writerIndex;
        paramArrayOfByteBuf = this.components;
        this.writerIndex = (paramInt2 + (paramArrayOfByteBuf[(k - 1)].endOffset - paramArrayOfByteBuf[paramInt1].offset));
      }
    }
  }
  
  private ByteBuf allocBuffer(int paramInt)
  {
    ByteBuf localByteBuf;
    if (this.direct) {
      localByteBuf = alloc().directBuffer(paramInt);
    } else {
      localByteBuf = alloc().heapBuffer(paramInt);
    }
    return localByteBuf;
  }
  
  private void checkComponentIndex(int paramInt)
  {
    ensureAccessible();
    if ((paramInt >= 0) && (paramInt <= this.componentCount)) {
      return;
    }
    throw new IndexOutOfBoundsException(String.format("cIndex: %d (expected: >= 0 && <= numComponents(%d))", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.componentCount) }));
  }
  
  private void checkComponentIndex(int paramInt1, int paramInt2)
  {
    ensureAccessible();
    if ((paramInt1 >= 0) && (paramInt1 + paramInt2 <= this.componentCount)) {
      return;
    }
    throw new IndexOutOfBoundsException(String.format("cIndex: %d, numComponents: %d (expected: cIndex >= 0 && cIndex + numComponents <= totalNumComponents(%d))", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.componentCount) }));
  }
  
  private static void checkForOverflow(int paramInt1, int paramInt2)
  {
    if (paramInt1 + paramInt2 >= 0) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Can't increase by ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(" as capacity(");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(") would overflow ");
    localStringBuilder.append(Integer.MAX_VALUE);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  private void clearComps()
  {
    removeCompRange(0, this.componentCount);
  }
  
  private void consolidate0(int paramInt1, int paramInt2)
  {
    if (paramInt2 <= 1) {
      return;
    }
    int i = paramInt1 + paramInt2;
    if (paramInt1 != 0) {
      j = this.components[paramInt1].offset;
    } else {
      j = 0;
    }
    ByteBuf localByteBuf = allocBuffer(this.components[(i - 1)].endOffset - j);
    for (int j = paramInt1; j < i; j++) {
      this.components[j].transferTo(localByteBuf);
    }
    this.lastAccessed = null;
    removeCompRange(paramInt1 + 1, i);
    this.components[paramInt1] = newComponent(localByteBuf, 0);
    if ((paramInt1 != 0) || (paramInt2 != this.componentCount)) {
      updateComponentOffsets(paramInt1);
    }
  }
  
  private void consolidateIfNeeded()
  {
    int i = this.componentCount;
    if (i > this.maxNumComponents) {
      consolidate0(0, i);
    }
  }
  
  private void copyTo(int paramInt1, int paramInt2, int paramInt3, ByteBuf paramByteBuf)
  {
    int i = 0;
    int j = paramInt1;
    paramInt1 = i;
    while (paramInt2 > 0)
    {
      Component localComponent = this.components[paramInt3];
      i = Math.min(paramInt2, localComponent.endOffset - j);
      localComponent.buf.getBytes(localComponent.idx(j), paramByteBuf, paramInt1, i);
      j += i;
      paramInt1 += i;
      paramInt2 -= i;
      paramInt3++;
    }
    paramByteBuf.writerIndex(paramByteBuf.capacity());
  }
  
  private static ByteBuf ensureAccessible(ByteBuf paramByteBuf)
  {
    if ((AbstractByteBuf.checkAccessible) && (!paramByteBuf.isAccessible())) {
      throw new IllegalReferenceCountException(0);
    }
    return paramByteBuf;
  }
  
  private Component findComponent(int paramInt)
  {
    Component localComponent = this.lastAccessed;
    if ((localComponent != null) && (paramInt >= localComponent.offset) && (paramInt < localComponent.endOffset))
    {
      ensureAccessible();
      return localComponent;
    }
    checkIndex(paramInt);
    return findIt(paramInt);
  }
  
  private Component findComponent0(int paramInt)
  {
    Component localComponent = this.lastAccessed;
    if ((localComponent != null) && (paramInt >= localComponent.offset) && (paramInt < localComponent.endOffset)) {
      return localComponent;
    }
    return findIt(paramInt);
  }
  
  private Component findIt(int paramInt)
  {
    int i = this.componentCount;
    int j = 0;
    while (j <= i)
    {
      int k = j + i >>> 1;
      Component localComponent = this.components[k];
      if (paramInt >= localComponent.endOffset)
      {
        j = k + 1;
      }
      else if (paramInt < localComponent.offset)
      {
        i = k - 1;
      }
      else
      {
        this.lastAccessed = localComponent;
        return localComponent;
      }
    }
    throw new Error("should not reach here");
  }
  
  private static Component[] newCompArray(int paramInt1, int paramInt2)
  {
    return new Component[Math.max(paramInt1, Math.min(16, paramInt2))];
  }
  
  private Component newComponent(ByteBuf paramByteBuf, int paramInt)
  {
    int i = paramByteBuf.readerIndex();
    int j = paramByteBuf.readableBytes();
    for (Object localObject1 = paramByteBuf;; localObject1 = ((ByteBuf)localObject1).unwrap()) {
      if ((!(localObject1 instanceof WrappedByteBuf)) && (!(localObject1 instanceof SwappedByteBuf)))
      {
        int k;
        if ((localObject1 instanceof AbstractUnpooledSlicedByteBuf))
        {
          k = ((AbstractUnpooledSlicedByteBuf)localObject1).idx(0) + i;
          localObject1 = ((ByteBuf)localObject1).unwrap();
        }
        Object localObject2;
        for (;;)
        {
          break;
          if ((localObject1 instanceof PooledSlicedByteBuf))
          {
            k = ((PooledSlicedByteBuf)localObject1).adjustment + i;
            localObject1 = ((ByteBuf)localObject1).unwrap();
          }
          else
          {
            if (!(localObject1 instanceof DuplicatedByteBuf))
            {
              localObject2 = localObject1;
              if (!(localObject1 instanceof PooledDuplicatedByteBuf)) {}
            }
            else
            {
              localObject2 = ((ByteBuf)localObject1).unwrap();
            }
            k = i;
            localObject1 = localObject2;
          }
        }
        if (paramByteBuf.capacity() == j) {
          localObject2 = paramByteBuf;
        } else {
          localObject2 = null;
        }
        ByteOrder localByteOrder = ByteOrder.BIG_ENDIAN;
        return new Component(paramByteBuf.order(localByteOrder), i, ((ByteBuf)localObject1).order(localByteOrder), k, paramInt, j, (ByteBuf)localObject2);
      }
    }
  }
  
  private void removeComp(int paramInt)
  {
    removeCompRange(paramInt, paramInt + 1);
  }
  
  private void removeCompRange(int paramInt1, int paramInt2)
  {
    if (paramInt1 >= paramInt2) {
      return;
    }
    int i = this.componentCount;
    if (paramInt2 < i)
    {
      Component[] arrayOfComponent = this.components;
      System.arraycopy(arrayOfComponent, paramInt2, arrayOfComponent, paramInt1, i - paramInt2);
    }
    paramInt2 = i - paramInt2 + paramInt1;
    for (paramInt1 = paramInt2; paramInt1 < i; paramInt1++) {
      this.components[paramInt1] = null;
    }
    this.componentCount = paramInt2;
  }
  
  private void shiftComps(int paramInt1, int paramInt2)
  {
    int i = this.componentCount;
    int j = i + paramInt2;
    Component[] arrayOfComponent = this.components;
    if (j > arrayOfComponent.length)
    {
      int k = Math.max((i >> 1) + i, j);
      if (paramInt1 == i)
      {
        arrayOfComponent = (Component[])Arrays.copyOf(this.components, k, Component[].class);
      }
      else
      {
        arrayOfComponent = new Component[k];
        if (paramInt1 > 0) {
          System.arraycopy(this.components, 0, arrayOfComponent, 0, paramInt1);
        }
        if (paramInt1 < i) {
          System.arraycopy(this.components, paramInt1, arrayOfComponent, paramInt2 + paramInt1, i - paramInt1);
        }
      }
      this.components = arrayOfComponent;
    }
    else if (paramInt1 < i)
    {
      System.arraycopy(arrayOfComponent, paramInt1, arrayOfComponent, paramInt2 + paramInt1, i - paramInt1);
    }
    this.componentCount = j;
  }
  
  private int toComponentIndex0(int paramInt)
  {
    int i = this.componentCount;
    int j = 0;
    int k = 0;
    if (paramInt == 0) {
      for (m = 0; m < i; m++) {
        if (this.components[m].endOffset > 0) {
          return m;
        }
      }
    }
    int m = i;
    if (i <= 2)
    {
      m = k;
      if (i != 1) {
        if (paramInt < this.components[0].endOffset) {
          m = k;
        } else {
          m = 1;
        }
      }
      return m;
    }
    while (j <= m)
    {
      k = j + m >>> 1;
      Component localComponent = this.components[k];
      if (paramInt >= localComponent.endOffset) {
        j = k + 1;
      } else if (paramInt < localComponent.offset) {
        m = k - 1;
      } else {
        return k;
      }
    }
    throw new Error("should not reach here");
  }
  
  private void updateComponentOffsets(int paramInt)
  {
    int i = this.componentCount;
    if (i <= paramInt) {
      return;
    }
    int j;
    if (paramInt > 0) {
      j = this.components[(paramInt - 1)].endOffset;
    } else {
      j = 0;
    }
    while (paramInt < i)
    {
      Component localComponent = this.components[paramInt];
      localComponent.reposition(j);
      j = localComponent.endOffset;
      paramInt++;
    }
  }
  
  protected byte _getByte(int paramInt)
  {
    Component localComponent = findComponent0(paramInt);
    return localComponent.buf.getByte(localComponent.idx(paramInt));
  }
  
  protected int _getInt(int paramInt)
  {
    Component localComponent = findComponent0(paramInt);
    if (paramInt + 4 <= localComponent.endOffset) {
      return localComponent.buf.getInt(localComponent.idx(paramInt));
    }
    if (order() == ByteOrder.BIG_ENDIAN)
    {
      i = _getShort(paramInt);
      return _getShort(paramInt + 2) & 0xFFFF | (i & 0xFFFF) << 16;
    }
    int i = _getShort(paramInt);
    return (_getShort(paramInt + 2) & 0xFFFF) << 16 | i & 0xFFFF;
  }
  
  protected int _getIntLE(int paramInt)
  {
    Component localComponent = findComponent0(paramInt);
    if (paramInt + 4 <= localComponent.endOffset) {
      return localComponent.buf.getIntLE(localComponent.idx(paramInt));
    }
    if (order() == ByteOrder.BIG_ENDIAN)
    {
      i = _getShortLE(paramInt);
      return (_getShortLE(paramInt + 2) & 0xFFFF) << 16 | i & 0xFFFF;
    }
    int i = _getShortLE(paramInt);
    return _getShortLE(paramInt + 2) & 0xFFFF | (i & 0xFFFF) << 16;
  }
  
  protected long _getLong(int paramInt)
  {
    Component localComponent = findComponent0(paramInt);
    if (paramInt + 8 <= localComponent.endOffset) {
      return localComponent.buf.getLong(localComponent.idx(paramInt));
    }
    if (order() == ByteOrder.BIG_ENDIAN) {
      return (_getInt(paramInt) & 0xFFFFFFFF) << 32 | _getInt(paramInt + 4) & 0xFFFFFFFF;
    }
    return _getInt(paramInt) & 0xFFFFFFFF | (0xFFFFFFFF & _getInt(paramInt + 4)) << 32;
  }
  
  protected long _getLongLE(int paramInt)
  {
    Component localComponent = findComponent0(paramInt);
    if (paramInt + 8 <= localComponent.endOffset) {
      return localComponent.buf.getLongLE(localComponent.idx(paramInt));
    }
    if (order() == ByteOrder.BIG_ENDIAN) {
      return _getIntLE(paramInt) & 0xFFFFFFFF | (0xFFFFFFFF & _getIntLE(paramInt + 4)) << 32;
    }
    return (_getIntLE(paramInt) & 0xFFFFFFFF) << 32 | _getIntLE(paramInt + 4) & 0xFFFFFFFF;
  }
  
  protected short _getShort(int paramInt)
  {
    Component localComponent = findComponent0(paramInt);
    if (paramInt + 2 <= localComponent.endOffset) {
      return localComponent.buf.getShort(localComponent.idx(paramInt));
    }
    if (order() == ByteOrder.BIG_ENDIAN)
    {
      i = _getByte(paramInt);
      return (short)(_getByte(paramInt + 1) & 0xFF | (i & 0xFF) << 8);
    }
    int i = _getByte(paramInt);
    return (short)((_getByte(paramInt + 1) & 0xFF) << 8 | i & 0xFF);
  }
  
  protected short _getShortLE(int paramInt)
  {
    Component localComponent = findComponent0(paramInt);
    if (paramInt + 2 <= localComponent.endOffset) {
      return localComponent.buf.getShortLE(localComponent.idx(paramInt));
    }
    if (order() == ByteOrder.BIG_ENDIAN)
    {
      i = _getByte(paramInt);
      return (short)((_getByte(paramInt + 1) & 0xFF) << 8 | i & 0xFF);
    }
    int i = _getByte(paramInt);
    return (short)(_getByte(paramInt + 1) & 0xFF | (i & 0xFF) << 8);
  }
  
  protected int _getUnsignedMedium(int paramInt)
  {
    Component localComponent = findComponent0(paramInt);
    if (paramInt + 3 <= localComponent.endOffset) {
      return localComponent.buf.getUnsignedMedium(localComponent.idx(paramInt));
    }
    if (order() == ByteOrder.BIG_ENDIAN)
    {
      i = _getShort(paramInt);
      return _getByte(paramInt + 2) & 0xFF | (i & 0xFFFF) << 8;
    }
    int i = _getShort(paramInt);
    return (_getByte(paramInt + 2) & 0xFF) << 16 | i & 0xFFFF;
  }
  
  protected int _getUnsignedMediumLE(int paramInt)
  {
    Component localComponent = findComponent0(paramInt);
    if (paramInt + 3 <= localComponent.endOffset) {
      return localComponent.buf.getUnsignedMediumLE(localComponent.idx(paramInt));
    }
    if (order() == ByteOrder.BIG_ENDIAN)
    {
      i = _getShortLE(paramInt);
      return (_getByte(paramInt + 2) & 0xFF) << 16 | i & 0xFFFF;
    }
    int i = _getShortLE(paramInt);
    return _getByte(paramInt + 2) & 0xFF | (i & 0xFFFF) << 8;
  }
  
  protected void _setByte(int paramInt1, int paramInt2)
  {
    Component localComponent = findComponent0(paramInt1);
    localComponent.buf.setByte(localComponent.idx(paramInt1), paramInt2);
  }
  
  protected void _setInt(int paramInt1, int paramInt2)
  {
    Component localComponent = findComponent0(paramInt1);
    if (paramInt1 + 4 <= localComponent.endOffset)
    {
      localComponent.buf.setInt(localComponent.idx(paramInt1), paramInt2);
    }
    else if (order() == ByteOrder.BIG_ENDIAN)
    {
      _setShort(paramInt1, (short)(paramInt2 >>> 16));
      _setShort(paramInt1 + 2, (short)paramInt2);
    }
    else
    {
      _setShort(paramInt1, (short)paramInt2);
      _setShort(paramInt1 + 2, (short)(paramInt2 >>> 16));
    }
  }
  
  protected void _setIntLE(int paramInt1, int paramInt2)
  {
    Component localComponent = findComponent0(paramInt1);
    if (paramInt1 + 4 <= localComponent.endOffset)
    {
      localComponent.buf.setIntLE(localComponent.idx(paramInt1), paramInt2);
    }
    else if (order() == ByteOrder.BIG_ENDIAN)
    {
      _setShortLE(paramInt1, (short)paramInt2);
      _setShortLE(paramInt1 + 2, (short)(paramInt2 >>> 16));
    }
    else
    {
      _setShortLE(paramInt1, (short)(paramInt2 >>> 16));
      _setShortLE(paramInt1 + 2, (short)paramInt2);
    }
  }
  
  protected void _setLong(int paramInt, long paramLong)
  {
    Component localComponent = findComponent0(paramInt);
    if (paramInt + 8 <= localComponent.endOffset)
    {
      localComponent.buf.setLong(localComponent.idx(paramInt), paramLong);
    }
    else if (order() == ByteOrder.BIG_ENDIAN)
    {
      _setInt(paramInt, (int)(paramLong >>> 32));
      _setInt(paramInt + 4, (int)paramLong);
    }
    else
    {
      _setInt(paramInt, (int)paramLong);
      _setInt(paramInt + 4, (int)(paramLong >>> 32));
    }
  }
  
  protected void _setLongLE(int paramInt, long paramLong)
  {
    Component localComponent = findComponent0(paramInt);
    if (paramInt + 8 <= localComponent.endOffset)
    {
      localComponent.buf.setLongLE(localComponent.idx(paramInt), paramLong);
    }
    else if (order() == ByteOrder.BIG_ENDIAN)
    {
      _setIntLE(paramInt, (int)paramLong);
      _setIntLE(paramInt + 4, (int)(paramLong >>> 32));
    }
    else
    {
      _setIntLE(paramInt, (int)(paramLong >>> 32));
      _setIntLE(paramInt + 4, (int)paramLong);
    }
  }
  
  protected void _setMedium(int paramInt1, int paramInt2)
  {
    Component localComponent = findComponent0(paramInt1);
    if (paramInt1 + 3 <= localComponent.endOffset)
    {
      localComponent.buf.setMedium(localComponent.idx(paramInt1), paramInt2);
    }
    else if (order() == ByteOrder.BIG_ENDIAN)
    {
      _setShort(paramInt1, (short)(paramInt2 >> 8));
      _setByte(paramInt1 + 2, (byte)paramInt2);
    }
    else
    {
      _setShort(paramInt1, (short)paramInt2);
      _setByte(paramInt1 + 2, (byte)(paramInt2 >>> 16));
    }
  }
  
  protected void _setMediumLE(int paramInt1, int paramInt2)
  {
    Component localComponent = findComponent0(paramInt1);
    if (paramInt1 + 3 <= localComponent.endOffset)
    {
      localComponent.buf.setMediumLE(localComponent.idx(paramInt1), paramInt2);
    }
    else if (order() == ByteOrder.BIG_ENDIAN)
    {
      _setShortLE(paramInt1, (short)paramInt2);
      _setByte(paramInt1 + 2, (byte)(paramInt2 >>> 16));
    }
    else
    {
      _setShortLE(paramInt1, (short)(paramInt2 >> 8));
      _setByte(paramInt1 + 2, (byte)paramInt2);
    }
  }
  
  protected void _setShort(int paramInt1, int paramInt2)
  {
    Component localComponent = findComponent0(paramInt1);
    if (paramInt1 + 2 <= localComponent.endOffset)
    {
      localComponent.buf.setShort(localComponent.idx(paramInt1), paramInt2);
    }
    else if (order() == ByteOrder.BIG_ENDIAN)
    {
      _setByte(paramInt1, (byte)(paramInt2 >>> 8));
      _setByte(paramInt1 + 1, (byte)paramInt2);
    }
    else
    {
      _setByte(paramInt1, (byte)paramInt2);
      _setByte(paramInt1 + 1, (byte)(paramInt2 >>> 8));
    }
  }
  
  protected void _setShortLE(int paramInt1, int paramInt2)
  {
    Component localComponent = findComponent0(paramInt1);
    if (paramInt1 + 2 <= localComponent.endOffset)
    {
      localComponent.buf.setShortLE(localComponent.idx(paramInt1), paramInt2);
    }
    else if (order() == ByteOrder.BIG_ENDIAN)
    {
      _setByte(paramInt1, (byte)paramInt2);
      _setByte(paramInt1 + 1, (byte)(paramInt2 >>> 8));
    }
    else
    {
      _setByte(paramInt1, (byte)(paramInt2 >>> 8));
      _setByte(paramInt1 + 1, (byte)paramInt2);
    }
  }
  
  public CompositeByteBuf addComponent(int paramInt, ByteBuf paramByteBuf)
  {
    return addComponent(false, paramInt, paramByteBuf);
  }
  
  public CompositeByteBuf addComponent(ByteBuf paramByteBuf)
  {
    return addComponent(false, paramByteBuf);
  }
  
  public CompositeByteBuf addComponent(boolean paramBoolean, int paramInt, ByteBuf paramByteBuf)
  {
    ObjectUtil.checkNotNull(paramByteBuf, "buffer");
    addComponent0(paramBoolean, paramInt, paramByteBuf);
    consolidateIfNeeded();
    return this;
  }
  
  public CompositeByteBuf addComponent(boolean paramBoolean, ByteBuf paramByteBuf)
  {
    return addComponent(paramBoolean, this.componentCount, paramByteBuf);
  }
  
  public CompositeByteBuf addComponents(int paramInt, Iterable<ByteBuf> paramIterable)
  {
    return addComponents(false, paramInt, paramIterable);
  }
  
  public CompositeByteBuf addComponents(int paramInt, ByteBuf... paramVarArgs)
  {
    ObjectUtil.checkNotNull(paramVarArgs, "buffers");
    addComponents0(false, paramInt, paramVarArgs, 0);
    consolidateIfNeeded();
    return this;
  }
  
  public CompositeByteBuf addComponents(Iterable<ByteBuf> paramIterable)
  {
    return addComponents(false, paramIterable);
  }
  
  public CompositeByteBuf addComponents(boolean paramBoolean, Iterable<ByteBuf> paramIterable)
  {
    return addComponents(paramBoolean, this.componentCount, paramIterable);
  }
  
  public CompositeByteBuf addComponents(boolean paramBoolean, ByteBuf... paramVarArgs)
  {
    ObjectUtil.checkNotNull(paramVarArgs, "buffers");
    addComponents0(paramBoolean, this.componentCount, paramVarArgs, 0);
    consolidateIfNeeded();
    return this;
  }
  
  public CompositeByteBuf addComponents(ByteBuf... paramVarArgs)
  {
    return addComponents(false, paramVarArgs);
  }
  
  /* Error */
  public CompositeByteBuf addFlattenedComponents(boolean paramBoolean, ByteBuf paramByteBuf)
  {
    // Byte code:
    //   0: aload_2
    //   1: ldc_w 533
    //   4: invokestatic 107	io/netty/util/internal/ObjectUtil:checkNotNull	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   7: pop
    //   8: aload_2
    //   9: invokevirtual 372	io/netty/buffer/ByteBuf:readerIndex	()I
    //   12: istore_3
    //   13: aload_2
    //   14: invokevirtual 549	io/netty/buffer/ByteBuf:writerIndex	()I
    //   17: istore 4
    //   19: iload_3
    //   20: iload 4
    //   22: if_icmpne +12 -> 34
    //   25: aload_2
    //   26: invokeinterface 226 1 0
    //   31: pop
    //   32: aload_0
    //   33: areturn
    //   34: aload_2
    //   35: instanceof 2
    //   38: ifne +20 -> 58
    //   41: aload_0
    //   42: iload_1
    //   43: aload_0
    //   44: getfield 208	io/netty/buffer/CompositeByteBuf:componentCount	I
    //   47: aload_2
    //   48: invokespecial 244	io/netty/buffer/CompositeByteBuf:addComponent0	(ZILio/netty/buffer/ByteBuf;)I
    //   51: pop
    //   52: aload_0
    //   53: invokespecial 144	io/netty/buffer/CompositeByteBuf:consolidateIfNeeded	()V
    //   56: aload_0
    //   57: areturn
    //   58: aload_2
    //   59: instanceof 551
    //   62: ifeq +15 -> 77
    //   65: aload_2
    //   66: invokevirtual 383	io/netty/buffer/ByteBuf:unwrap	()Lio/netty/buffer/ByteBuf;
    //   69: checkcast 2	io/netty/buffer/CompositeByteBuf
    //   72: astore 5
    //   74: goto +9 -> 83
    //   77: aload_2
    //   78: checkcast 2	io/netty/buffer/CompositeByteBuf
    //   81: astore 5
    //   83: iload 4
    //   85: iload_3
    //   86: isub
    //   87: istore 6
    //   89: aload 5
    //   91: iload_3
    //   92: iload 6
    //   94: invokevirtual 553	io/netty/buffer/AbstractByteBuf:checkIndex	(II)V
    //   97: aload 5
    //   99: getfield 96	io/netty/buffer/CompositeByteBuf:components	[Lio/netty/buffer/CompositeByteBuf$Component;
    //   102: astore 7
    //   104: aload_0
    //   105: getfield 208	io/netty/buffer/CompositeByteBuf:componentCount	I
    //   108: istore 8
    //   110: aload_0
    //   111: getfield 220	io/netty/buffer/AbstractByteBuf:writerIndex	I
    //   114: istore 9
    //   116: aload 5
    //   118: iload_3
    //   119: invokespecial 555	io/netty/buffer/CompositeByteBuf:toComponentIndex0	(I)I
    //   122: istore 10
    //   124: aload_0
    //   125: invokevirtual 148	io/netty/buffer/CompositeByteBuf:capacity	()I
    //   128: istore 11
    //   130: aload 7
    //   132: astore 5
    //   134: aload 5
    //   136: iload 10
    //   138: aaload
    //   139: astore 12
    //   141: iload_3
    //   142: aload 12
    //   144: getfield 275	io/netty/buffer/CompositeByteBuf$Component:offset	I
    //   147: invokestatic 369	java/lang/Math:max	(II)I
    //   150: istore 13
    //   152: iload 4
    //   154: aload 12
    //   156: getfield 214	io/netty/buffer/CompositeByteBuf$Component:endOffset	I
    //   159: invokestatic 250	java/lang/Math:min	(II)I
    //   162: istore 14
    //   164: iload 14
    //   166: iload 13
    //   168: isub
    //   169: istore 15
    //   171: iload 15
    //   173: ifle +62 -> 235
    //   176: aload_0
    //   177: getfield 208	io/netty/buffer/CompositeByteBuf:componentCount	I
    //   180: istore 16
    //   182: new 16	io/netty/buffer/CompositeByteBuf$Component
    //   185: astore 7
    //   187: aload 7
    //   189: aload 12
    //   191: getfield 558	io/netty/buffer/CompositeByteBuf$Component:srcBuf	Lio/netty/buffer/ByteBuf;
    //   194: invokevirtual 561	io/netty/buffer/ByteBuf:retain	()Lio/netty/buffer/ByteBuf;
    //   197: aload 12
    //   199: iload 13
    //   201: invokevirtual 564	io/netty/buffer/CompositeByteBuf$Component:srcIdx	(I)I
    //   204: aload 12
    //   206: getfield 332	io/netty/buffer/CompositeByteBuf$Component:buf	Lio/netty/buffer/ByteBuf;
    //   209: aload 12
    //   211: iload 13
    //   213: invokevirtual 336	io/netty/buffer/CompositeByteBuf$Component:idx	(I)I
    //   216: iload 11
    //   218: iload 15
    //   220: aconst_null
    //   221: invokespecial 405	io/netty/buffer/CompositeByteBuf$Component:<init>	(Lio/netty/buffer/ByteBuf;ILio/netty/buffer/ByteBuf;IIILio/netty/buffer/ByteBuf;)V
    //   224: aload_0
    //   225: iload 16
    //   227: aload 7
    //   229: invokespecial 206	io/netty/buffer/CompositeByteBuf:addComp	(ILio/netty/buffer/CompositeByteBuf$Component;)V
    //   232: goto +3 -> 235
    //   235: iload 4
    //   237: iload 14
    //   239: if_icmpne +29 -> 268
    //   242: iload_1
    //   243: ifeq +12 -> 255
    //   246: aload_0
    //   247: iload 6
    //   249: iload 9
    //   251: iadd
    //   252: putfield 220	io/netty/buffer/AbstractByteBuf:writerIndex	I
    //   255: aload_0
    //   256: invokespecial 144	io/netty/buffer/CompositeByteBuf:consolidateIfNeeded	()V
    //   259: aload_2
    //   260: invokeinterface 226 1 0
    //   265: pop
    //   266: aload_0
    //   267: areturn
    //   268: iload 11
    //   270: iload 15
    //   272: iadd
    //   273: istore 11
    //   275: iinc 10 1
    //   278: goto -144 -> 134
    //   281: astore_2
    //   282: iload_1
    //   283: ifeq +9 -> 292
    //   286: aload_0
    //   287: iload 9
    //   289: putfield 220	io/netty/buffer/AbstractByteBuf:writerIndex	I
    //   292: aload_0
    //   293: getfield 208	io/netty/buffer/CompositeByteBuf:componentCount	I
    //   296: iconst_1
    //   297: isub
    //   298: istore 10
    //   300: iload 10
    //   302: iload 8
    //   304: if_icmplt +25 -> 329
    //   307: aload_0
    //   308: getfield 96	io/netty/buffer/CompositeByteBuf:components	[Lio/netty/buffer/CompositeByteBuf$Component;
    //   311: iload 10
    //   313: aaload
    //   314: invokevirtual 567	io/netty/buffer/CompositeByteBuf$Component:free	()V
    //   317: aload_0
    //   318: iload 10
    //   320: invokespecial 569	io/netty/buffer/CompositeByteBuf:removeComp	(I)V
    //   323: iinc 10 -1
    //   326: goto -26 -> 300
    //   329: aload_2
    //   330: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	331	0	this	CompositeByteBuf
    //   0	331	1	paramBoolean	boolean
    //   0	331	2	paramByteBuf	ByteBuf
    //   12	130	3	i	int
    //   17	223	4	j	int
    //   72	63	5	localObject1	Object
    //   87	165	6	k	int
    //   102	126	7	localObject2	Object
    //   108	197	8	m	int
    //   114	174	9	n	int
    //   122	202	10	i1	int
    //   128	146	11	i2	int
    //   139	71	12	localObject3	Object
    //   150	62	13	i3	int
    //   162	78	14	i4	int
    //   169	104	15	i5	int
    //   180	46	16	i6	int
    // Exception table:
    //   from	to	target	type
    //   116	130	281	finally
    //   141	164	281	finally
    //   176	232	281	finally
    //   246	255	281	finally
    //   255	266	281	finally
  }
  
  public ByteBufAllocator alloc()
  {
    return this.alloc;
  }
  
  public byte[] array()
  {
    int i = this.componentCount;
    if (i != 0)
    {
      if (i == 1) {
        return this.components[0].buf.array();
      }
      throw new UnsupportedOperationException();
    }
    return EmptyArrays.EMPTY_BYTES;
  }
  
  public int arrayOffset()
  {
    int i = this.componentCount;
    if (i != 0)
    {
      if (i == 1)
      {
        Component localComponent = this.components[0];
        return localComponent.idx(localComponent.buf.arrayOffset());
      }
      throw new UnsupportedOperationException();
    }
    return 0;
  }
  
  public int capacity()
  {
    int i = this.componentCount;
    if (i > 0) {
      i = this.components[(i - 1)].endOffset;
    } else {
      i = 0;
    }
    return i;
  }
  
  public CompositeByteBuf capacity(int paramInt)
  {
    checkNewCapacity(paramInt);
    int i = this.componentCount;
    int j = capacity();
    if (paramInt > j)
    {
      paramInt -= j;
      addComponent0(false, i, allocBuffer(paramInt).setIndex(0, paramInt));
      if (this.componentCount >= this.maxNumComponents) {
        consolidateIfNeeded();
      }
    }
    else if (paramInt < j)
    {
      this.lastAccessed = null;
      int k = i - 1;
      j -= paramInt;
      while (k >= 0)
      {
        Component localComponent = this.components[k];
        int m = localComponent.length();
        if (j < m)
        {
          localComponent.endOffset -= j;
          ByteBuf localByteBuf = localComponent.slice;
          if (localByteBuf == null) {
            break;
          }
          Component.access$102(localComponent, localByteBuf.slice(0, localComponent.length()));
          break;
        }
        localComponent.free();
        j -= m;
        k--;
      }
      removeCompRange(k + 1, i);
      if (readerIndex() > paramInt) {
        setIndex0(paramInt, paramInt);
      } else if (this.writerIndex > paramInt) {
        this.writerIndex = paramInt;
      }
    }
    return this;
  }
  
  public CompositeByteBuf clear()
  {
    super.clear();
    return this;
  }
  
  public ByteBuf component(int paramInt)
  {
    checkComponentIndex(paramInt);
    return this.components[paramInt].duplicate();
  }
  
  public ByteBuf componentAtOffset(int paramInt)
  {
    return findComponent(paramInt).duplicate();
  }
  
  public CompositeByteBuf consolidate()
  {
    ensureAccessible();
    consolidate0(0, this.componentCount);
    return this;
  }
  
  public CompositeByteBuf consolidate(int paramInt1, int paramInt2)
  {
    checkComponentIndex(paramInt1, paramInt2);
    consolidate0(paramInt1, paramInt2);
    return this;
  }
  
  public ByteBuf copy(int paramInt1, int paramInt2)
  {
    checkIndex(paramInt1, paramInt2);
    ByteBuf localByteBuf = allocBuffer(paramInt2);
    if (paramInt2 != 0) {
      copyTo(paramInt1, paramInt2, toComponentIndex0(paramInt1), localByteBuf);
    }
    return localByteBuf;
  }
  
  protected void deallocate()
  {
    if (this.freed) {
      return;
    }
    this.freed = true;
    int i = 0;
    int j = this.componentCount;
    while (i < j)
    {
      this.components[i].free();
      i++;
    }
  }
  
  public List<ByteBuf> decompose(int paramInt1, int paramInt2)
  {
    checkIndex(paramInt1, paramInt2);
    if (paramInt2 == 0) {
      return Collections.emptyList();
    }
    int i = toComponentIndex0(paramInt1);
    Object localObject1 = this.components[i];
    Object localObject2 = ((Component)localObject1).buf.slice(((Component)localObject1).idx(paramInt1), Math.min(((Component)localObject1).endOffset - paramInt1, paramInt2));
    paramInt1 = paramInt2 - ((ByteBuf)localObject2).readableBytes();
    if (paramInt1 == 0) {
      return Collections.singletonList(localObject2);
    }
    localObject1 = new ArrayList(this.componentCount - i);
    ((List)localObject1).add(localObject2);
    paramInt2 = i;
    do
    {
      localObject2 = this.components;
      paramInt2++;
      localObject2 = localObject2[paramInt2];
      localObject2 = ((Component)localObject2).buf.slice(((Component)localObject2).idx(((Component)localObject2).offset), Math.min(((Component)localObject2).length(), paramInt1));
      i = paramInt1 - ((ByteBuf)localObject2).readableBytes();
      ((List)localObject1).add(localObject2);
      paramInt1 = i;
    } while (i > 0);
    return (List<ByteBuf>)localObject1;
  }
  
  public CompositeByteBuf discardReadBytes()
  {
    ensureAccessible();
    int i = readerIndex();
    if (i == 0) {
      return this;
    }
    int j = writerIndex();
    if ((i == j) && (j == capacity()))
    {
      j = this.componentCount;
      for (k = 0; k < j; k++) {
        this.components[k].free();
      }
      this.lastAccessed = null;
      clearComps();
      setIndex(0, 0);
      adjustMarkers(i);
      return this;
    }
    int m = this.componentCount;
    Component localComponent = null;
    for (int k = 0; k < m; k++)
    {
      localComponent = this.components[k];
      if (localComponent.endOffset > i) {
        break;
      }
      localComponent.free();
    }
    m = localComponent.offset;
    localComponent.offset = 0;
    localComponent.endOffset -= i;
    localComponent.srcAdjustment += i;
    localComponent.adjustment += i;
    ByteBuf localByteBuf = localComponent.slice;
    if (localByteBuf != null) {
      Component.access$102(localComponent, localByteBuf.slice(i - m, localComponent.length()));
    }
    localComponent = this.lastAccessed;
    if ((localComponent != null) && (localComponent.endOffset <= i)) {
      this.lastAccessed = null;
    }
    removeCompRange(0, k);
    updateComponentOffsets(0);
    setIndex(0, j - i);
    adjustMarkers(i);
    return this;
  }
  
  public CompositeByteBuf discardReadComponents()
  {
    ensureAccessible();
    int i = readerIndex();
    if (i == 0) {
      return this;
    }
    int j = writerIndex();
    if ((i == j) && (j == capacity()))
    {
      j = this.componentCount;
      for (k = 0; k < j; k++) {
        this.components[k].free();
      }
      this.lastAccessed = null;
      clearComps();
      setIndex(0, 0);
      adjustMarkers(i);
      return this;
    }
    int m = this.componentCount;
    Component localComponent1 = null;
    for (int k = 0; k < m; k++)
    {
      localComponent1 = this.components[k];
      if (localComponent1.endOffset > i) {
        break;
      }
      localComponent1.free();
    }
    if (k == 0) {
      return this;
    }
    Component localComponent2 = this.lastAccessed;
    if ((localComponent2 != null) && (localComponent2.endOffset <= i)) {
      this.lastAccessed = null;
    }
    removeCompRange(0, k);
    k = localComponent1.offset;
    updateComponentOffsets(0);
    setIndex(i - k, j - k);
    adjustMarkers(k);
    return this;
  }
  
  public CompositeByteBuf discardSomeReadBytes()
  {
    return discardReadComponents();
  }
  
  public CompositeByteBuf ensureWritable(int paramInt)
  {
    super.ensureWritable(paramInt);
    return this;
  }
  
  protected int forEachByteAsc0(int paramInt1, int paramInt2, ByteProcessor paramByteProcessor)
    throws Exception
  {
    if (paramInt2 <= paramInt1) {
      return -1;
    }
    int i = toComponentIndex0(paramInt1);
    paramInt2 -= paramInt1;
    int j = paramInt1;
    for (paramInt1 = i; paramInt2 > 0; paramInt1++)
    {
      Component localComponent = this.components[paramInt1];
      if (localComponent.offset != localComponent.endOffset)
      {
        ByteBuf localByteBuf = localComponent.buf;
        i = localComponent.idx(j);
        int k = Math.min(paramInt2, localComponent.endOffset - j);
        if ((localByteBuf instanceof AbstractByteBuf)) {
          i = ((AbstractByteBuf)localByteBuf).forEachByteAsc0(i, i + k, paramByteProcessor);
        } else {
          i = localByteBuf.forEachByte(i, k, paramByteProcessor);
        }
        if (i != -1) {
          return i - localComponent.adjustment;
        }
        j += k;
        paramInt2 -= k;
      }
    }
    return -1;
  }
  
  protected int forEachByteDesc0(int paramInt1, int paramInt2, ByteProcessor paramByteProcessor)
    throws Exception
  {
    if (paramInt2 > paramInt1) {
      return -1;
    }
    int i = toComponentIndex0(paramInt1);
    int j = paramInt1 + 1 - paramInt2;
    for (paramInt1 = i; j > 0; paramInt1--)
    {
      Component localComponent = this.components[paramInt1];
      if (localComponent.offset != localComponent.endOffset)
      {
        ByteBuf localByteBuf = localComponent.buf;
        i = localComponent.idx(j + paramInt2);
        int k = Math.min(j, i);
        int m = i - k;
        if ((localByteBuf instanceof AbstractByteBuf)) {
          i = ((AbstractByteBuf)localByteBuf).forEachByteDesc0(i - 1, m, paramByteProcessor);
        } else {
          i = localByteBuf.forEachByteDesc(m, k, paramByteProcessor);
        }
        if (i != -1) {
          return i - localComponent.adjustment;
        }
        j -= k;
      }
    }
    return -1;
  }
  
  public byte getByte(int paramInt)
  {
    Component localComponent = findComponent(paramInt);
    return localComponent.buf.getByte(localComponent.idx(paramInt));
  }
  
  public int getBytes(int paramInt1, FileChannel paramFileChannel, long paramLong, int paramInt2)
    throws IOException
  {
    if (nioBufferCount() == 1) {
      return paramFileChannel.write(internalNioBuffer(paramInt1, paramInt2), paramLong);
    }
    long l = 0L;
    ByteBuffer[] arrayOfByteBuffer = nioBuffers(paramInt1, paramInt2);
    paramInt2 = arrayOfByteBuffer.length;
    for (paramInt1 = 0; paramInt1 < paramInt2; paramInt1++) {
      l += paramFileChannel.write(arrayOfByteBuffer[paramInt1], paramLong + l);
    }
    if (l > 2147483647L) {
      return Integer.MAX_VALUE;
    }
    return (int)l;
  }
  
  public int getBytes(int paramInt1, GatheringByteChannel paramGatheringByteChannel, int paramInt2)
    throws IOException
  {
    if (nioBufferCount() == 1) {
      return paramGatheringByteChannel.write(internalNioBuffer(paramInt1, paramInt2));
    }
    long l = paramGatheringByteChannel.write(nioBuffers(paramInt1, paramInt2));
    if (l > 2147483647L) {
      return Integer.MAX_VALUE;
    }
    return (int)l;
  }
  
  public CompositeByteBuf getBytes(int paramInt, ByteBuf paramByteBuf)
  {
    return getBytes(paramInt, paramByteBuf, paramByteBuf.writableBytes());
  }
  
  public CompositeByteBuf getBytes(int paramInt1, ByteBuf paramByteBuf, int paramInt2)
  {
    getBytes(paramInt1, paramByteBuf, paramByteBuf.writerIndex(), paramInt2);
    paramByteBuf.writerIndex(paramByteBuf.writerIndex() + paramInt2);
    return this;
  }
  
  public CompositeByteBuf getBytes(int paramInt1, ByteBuf paramByteBuf, int paramInt2, int paramInt3)
  {
    checkDstIndex(paramInt1, paramInt3, paramInt2, paramByteBuf.capacity());
    if (paramInt3 == 0) {
      return this;
    }
    int i = toComponentIndex0(paramInt1);
    int j = paramInt1;
    for (paramInt1 = i; paramInt3 > 0; paramInt1++)
    {
      Component localComponent = this.components[paramInt1];
      i = Math.min(paramInt3, localComponent.endOffset - j);
      localComponent.buf.getBytes(localComponent.idx(j), paramByteBuf, paramInt2, i);
      j += i;
      paramInt2 += i;
      paramInt3 -= i;
    }
    return this;
  }
  
  public CompositeByteBuf getBytes(int paramInt1, OutputStream paramOutputStream, int paramInt2)
    throws IOException
  {
    checkIndex(paramInt1, paramInt2);
    if (paramInt2 == 0) {
      return this;
    }
    for (int i = toComponentIndex0(paramInt1); paramInt2 > 0; i++)
    {
      Component localComponent = this.components[i];
      int j = Math.min(paramInt2, localComponent.endOffset - paramInt1);
      localComponent.buf.getBytes(localComponent.idx(paramInt1), paramOutputStream, j);
      paramInt1 += j;
      paramInt2 -= j;
    }
    return this;
  }
  
  /* Error */
  public CompositeByteBuf getBytes(int paramInt, ByteBuffer paramByteBuffer)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 751	java/nio/ByteBuffer:limit	()I
    //   4: istore_3
    //   5: aload_2
    //   6: invokevirtual 754	java/nio/ByteBuffer:remaining	()I
    //   9: istore 4
    //   11: aload_0
    //   12: iload_1
    //   13: iload 4
    //   15: invokevirtual 553	io/netty/buffer/AbstractByteBuf:checkIndex	(II)V
    //   18: iload 4
    //   20: ifne +5 -> 25
    //   23: aload_0
    //   24: areturn
    //   25: aload_0
    //   26: iload_1
    //   27: invokespecial 555	io/netty/buffer/CompositeByteBuf:toComponentIndex0	(I)I
    //   30: istore 5
    //   32: iload_1
    //   33: istore 6
    //   35: iload 5
    //   37: istore_1
    //   38: iload 4
    //   40: ifle +86 -> 126
    //   43: aload_0
    //   44: getfield 96	io/netty/buffer/CompositeByteBuf:components	[Lio/netty/buffer/CompositeByteBuf$Component;
    //   47: iload_1
    //   48: aaload
    //   49: astore 7
    //   51: iload 4
    //   53: aload 7
    //   55: getfield 214	io/netty/buffer/CompositeByteBuf$Component:endOffset	I
    //   58: iload 6
    //   60: isub
    //   61: invokestatic 250	java/lang/Math:min	(II)I
    //   64: istore 5
    //   66: aload_2
    //   67: aload_2
    //   68: invokevirtual 757	java/nio/ByteBuffer:position	()I
    //   71: iload 5
    //   73: iadd
    //   74: invokevirtual 760	java/nio/ByteBuffer:limit	(I)Ljava/nio/Buffer;
    //   77: pop
    //   78: aload 7
    //   80: getfield 332	io/netty/buffer/CompositeByteBuf$Component:buf	Lio/netty/buffer/ByteBuf;
    //   83: aload 7
    //   85: iload 6
    //   87: invokevirtual 336	io/netty/buffer/CompositeByteBuf$Component:idx	(I)I
    //   90: aload_2
    //   91: invokevirtual 762	io/netty/buffer/ByteBuf:getBytes	(ILjava/nio/ByteBuffer;)Lio/netty/buffer/ByteBuf;
    //   94: pop
    //   95: iload 6
    //   97: iload 5
    //   99: iadd
    //   100: istore 6
    //   102: iload 4
    //   104: iload 5
    //   106: isub
    //   107: istore 4
    //   109: iinc 1 1
    //   112: goto -74 -> 38
    //   115: astore 7
    //   117: aload_2
    //   118: iload_3
    //   119: invokevirtual 760	java/nio/ByteBuffer:limit	(I)Ljava/nio/Buffer;
    //   122: pop
    //   123: aload 7
    //   125: athrow
    //   126: aload_2
    //   127: iload_3
    //   128: invokevirtual 760	java/nio/ByteBuffer:limit	(I)Ljava/nio/Buffer;
    //   131: pop
    //   132: aload_0
    //   133: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	this	CompositeByteBuf
    //   0	134	1	paramInt	int
    //   0	134	2	paramByteBuffer	ByteBuffer
    //   4	124	3	i	int
    //   9	99	4	j	int
    //   30	77	5	k	int
    //   33	68	6	m	int
    //   49	35	7	localComponent	Component
    //   115	9	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   43	95	115	finally
  }
  
  public CompositeByteBuf getBytes(int paramInt, byte[] paramArrayOfByte)
  {
    return getBytes(paramInt, paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public CompositeByteBuf getBytes(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    checkDstIndex(paramInt1, paramInt3, paramInt2, paramArrayOfByte.length);
    if (paramInt3 == 0) {
      return this;
    }
    for (int i = toComponentIndex0(paramInt1); paramInt3 > 0; i++)
    {
      Component localComponent = this.components[i];
      int j = Math.min(paramInt3, localComponent.endOffset - paramInt1);
      localComponent.buf.getBytes(localComponent.idx(paramInt1), paramArrayOfByte, paramInt2, j);
      paramInt1 += j;
      paramInt2 += j;
      paramInt3 -= j;
    }
    return this;
  }
  
  public boolean hasArray()
  {
    int i = this.componentCount;
    if (i != 0)
    {
      if (i != 1) {
        return false;
      }
      return this.components[0].buf.hasArray();
    }
    return true;
  }
  
  public boolean hasMemoryAddress()
  {
    int i = this.componentCount;
    if (i != 0)
    {
      if (i != 1) {
        return false;
      }
      return this.components[0].buf.hasMemoryAddress();
    }
    return Unpooled.EMPTY_BUFFER.hasMemoryAddress();
  }
  
  public ByteBuf internalComponent(int paramInt)
  {
    checkComponentIndex(paramInt);
    return this.components[paramInt].slice();
  }
  
  public ByteBuf internalComponentAtOffset(int paramInt)
  {
    return findComponent(paramInt).slice();
  }
  
  public ByteBuffer internalNioBuffer(int paramInt1, int paramInt2)
  {
    int i = this.componentCount;
    if (i != 0)
    {
      if (i == 1) {
        return this.components[0].internalNioBuffer(paramInt1, paramInt2);
      }
      throw new UnsupportedOperationException();
    }
    return EMPTY_NIO_BUFFER;
  }
  
  boolean isAccessible()
  {
    return this.freed ^ true;
  }
  
  public boolean isDirect()
  {
    int i = this.componentCount;
    if (i == 0) {
      return false;
    }
    for (int j = 0; j < i; j++) {
      if (!this.components[j].buf.isDirect()) {
        return false;
      }
    }
    return true;
  }
  
  public Iterator<ByteBuf> iterator()
  {
    ensureAccessible();
    Object localObject;
    if (this.componentCount == 0) {
      localObject = EMPTY_ITERATOR;
    } else {
      localObject = new CompositeByteBufIterator(null);
    }
    return (Iterator<ByteBuf>)localObject;
  }
  
  public CompositeByteBuf markReaderIndex()
  {
    super.markReaderIndex();
    return this;
  }
  
  public CompositeByteBuf markWriterIndex()
  {
    super.markWriterIndex();
    return this;
  }
  
  public int maxNumComponents()
  {
    return this.maxNumComponents;
  }
  
  public long memoryAddress()
  {
    int i = this.componentCount;
    if (i != 0)
    {
      if (i == 1)
      {
        Component localComponent = this.components[0];
        return localComponent.buf.memoryAddress() + localComponent.adjustment;
      }
      throw new UnsupportedOperationException();
    }
    return Unpooled.EMPTY_BUFFER.memoryAddress();
  }
  
  public ByteBuffer nioBuffer(int paramInt1, int paramInt2)
  {
    checkIndex(paramInt1, paramInt2);
    int i = this.componentCount;
    if (i != 0)
    {
      int j = 0;
      if (i == 1)
      {
        localObject1 = this.components[0];
        localObject2 = ((Component)localObject1).buf;
        if (((ByteBuf)localObject2).nioBufferCount() == 1) {
          return ((ByteBuf)localObject2).nioBuffer(((Component)localObject1).idx(paramInt1), paramInt2);
        }
      }
      Object localObject1 = nioBuffers(paramInt1, paramInt2);
      if (localObject1.length == 1) {
        return localObject1[0];
      }
      Object localObject2 = ByteBuffer.allocate(paramInt2).order(order());
      paramInt2 = localObject1.length;
      for (paramInt1 = j; paramInt1 < paramInt2; paramInt1++) {
        ((ByteBuffer)localObject2).put(localObject1[paramInt1]);
      }
      ((ByteBuffer)localObject2).flip();
      return (ByteBuffer)localObject2;
    }
    return EMPTY_NIO_BUFFER;
  }
  
  public int nioBufferCount()
  {
    int i = this.componentCount;
    if (i != 0)
    {
      int j = 0;
      if (i != 1)
      {
        int k = 0;
        while (j < i)
        {
          k += this.components[j].buf.nioBufferCount();
          j++;
        }
        return k;
      }
      return this.components[0].buf.nioBufferCount();
    }
    return 1;
  }
  
  public ByteBuffer[] nioBuffers()
  {
    return nioBuffers(readerIndex(), readableBytes());
  }
  
  public ByteBuffer[] nioBuffers(int paramInt1, int paramInt2)
  {
    checkIndex(paramInt1, paramInt2);
    if (paramInt2 == 0) {
      return new ByteBuffer[] { EMPTY_NIO_BUFFER };
    }
    RecyclableArrayList localRecyclableArrayList = RecyclableArrayList.newInstance(this.componentCount);
    try
    {
      int i = toComponentIndex0(paramInt1);
      while (paramInt2 > 0)
      {
        Component localComponent = this.components[i];
        localObject1 = localComponent.buf;
        int j = Math.min(paramInt2, localComponent.endOffset - paramInt1);
        int k = ((ByteBuf)localObject1).nioBufferCount();
        if (k != 0)
        {
          if (k != 1) {
            Collections.addAll(localRecyclableArrayList, ((ByteBuf)localObject1).nioBuffers(localComponent.idx(paramInt1), j));
          } else {
            localRecyclableArrayList.add(((ByteBuf)localObject1).nioBuffer(localComponent.idx(paramInt1), j));
          }
          paramInt1 += j;
          paramInt2 -= j;
          i++;
        }
        else
        {
          localObject1 = new java/lang/UnsupportedOperationException;
          ((UnsupportedOperationException)localObject1).<init>();
          throw ((Throwable)localObject1);
        }
      }
      Object localObject1 = (ByteBuffer[])localRecyclableArrayList.toArray(new ByteBuffer[0]);
      return (ByteBuffer[])localObject1;
    }
    finally
    {
      localRecyclableArrayList.recycle();
    }
  }
  
  public int numComponents()
  {
    return this.componentCount;
  }
  
  public ByteOrder order()
  {
    return ByteOrder.BIG_ENDIAN;
  }
  
  public CompositeByteBuf readBytes(ByteBuf paramByteBuf)
  {
    super.readBytes(paramByteBuf, paramByteBuf.writableBytes());
    return this;
  }
  
  public CompositeByteBuf readBytes(ByteBuf paramByteBuf, int paramInt)
  {
    super.readBytes(paramByteBuf, paramInt);
    return this;
  }
  
  public CompositeByteBuf readBytes(ByteBuf paramByteBuf, int paramInt1, int paramInt2)
  {
    super.readBytes(paramByteBuf, paramInt1, paramInt2);
    return this;
  }
  
  public CompositeByteBuf readBytes(OutputStream paramOutputStream, int paramInt)
    throws IOException
  {
    super.readBytes(paramOutputStream, paramInt);
    return this;
  }
  
  public CompositeByteBuf readBytes(ByteBuffer paramByteBuffer)
  {
    super.readBytes(paramByteBuffer);
    return this;
  }
  
  public CompositeByteBuf readBytes(byte[] paramArrayOfByte)
  {
    super.readBytes(paramArrayOfByte, 0, paramArrayOfByte.length);
    return this;
  }
  
  public CompositeByteBuf readBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    super.readBytes(paramArrayOfByte, paramInt1, paramInt2);
    return this;
  }
  
  public CompositeByteBuf readerIndex(int paramInt)
  {
    super.readerIndex(paramInt);
    return this;
  }
  
  public CompositeByteBuf removeComponent(int paramInt)
  {
    checkComponentIndex(paramInt);
    Component localComponent = this.components[paramInt];
    if (this.lastAccessed == localComponent) {
      this.lastAccessed = null;
    }
    localComponent.free();
    removeComp(paramInt);
    if (localComponent.length() > 0) {
      updateComponentOffsets(paramInt);
    }
    return this;
  }
  
  public CompositeByteBuf removeComponents(int paramInt1, int paramInt2)
  {
    checkComponentIndex(paramInt1, paramInt2);
    if (paramInt2 == 0) {
      return this;
    }
    int i = paramInt2 + paramInt1;
    int j = 0;
    for (paramInt2 = paramInt1; paramInt2 < i; paramInt2++)
    {
      Component localComponent = this.components[paramInt2];
      if (localComponent.length() > 0) {
        j = 1;
      }
      if (this.lastAccessed == localComponent) {
        this.lastAccessed = null;
      }
      localComponent.free();
    }
    removeCompRange(paramInt1, i);
    if (j != 0) {
      updateComponentOffsets(paramInt1);
    }
    return this;
  }
  
  public CompositeByteBuf resetReaderIndex()
  {
    super.resetReaderIndex();
    return this;
  }
  
  public CompositeByteBuf resetWriterIndex()
  {
    super.resetWriterIndex();
    return this;
  }
  
  public CompositeByteBuf retain()
  {
    super.retain();
    return this;
  }
  
  public CompositeByteBuf retain(int paramInt)
  {
    super.retain(paramInt);
    return this;
  }
  
  public CompositeByteBuf setBoolean(int paramInt, boolean paramBoolean)
  {
    return setByte(paramInt, paramBoolean);
  }
  
  public CompositeByteBuf setByte(int paramInt1, int paramInt2)
  {
    Component localComponent = findComponent(paramInt1);
    localComponent.buf.setByte(localComponent.idx(paramInt1), paramInt2);
    return this;
  }
  
  public int setBytes(int paramInt1, InputStream paramInputStream, int paramInt2)
    throws IOException
  {
    checkIndex(paramInt1, paramInt2);
    if (paramInt2 == 0) {
      return paramInputStream.read(EmptyArrays.EMPTY_BYTES);
    }
    int i = toComponentIndex0(paramInt1);
    int j = 0;
    int k = paramInt2;
    int m = paramInt1;
    paramInt2 = j;
    do
    {
      Component localComponent = this.components[i];
      int n = Math.min(k, localComponent.endOffset - m);
      if (n == 0)
      {
        j = k;
        k = m;
        paramInt1 = paramInt2;
      }
      for (;;)
      {
        paramInt2 = i + 1;
        break;
        int i1 = localComponent.buf.setBytes(localComponent.idx(m), paramInputStream, n);
        if (i1 < 0)
        {
          paramInt1 = paramInt2;
          if (paramInt2 != 0) {
            return paramInt1;
          }
          return -1;
        }
        m += i1;
        int i2 = k - i1;
        int i3 = paramInt2 + i1;
        paramInt2 = i;
        paramInt1 = i3;
        k = m;
        j = i2;
        if (i1 != n) {
          break;
        }
        paramInt1 = i3;
        k = m;
        j = i2;
      }
      i = paramInt2;
      paramInt2 = paramInt1;
      m = k;
      k = j;
    } while (j > 0);
    return paramInt1;
  }
  
  public int setBytes(int paramInt1, FileChannel paramFileChannel, long paramLong, int paramInt2)
    throws IOException
  {
    checkIndex(paramInt1, paramInt2);
    if (paramInt2 == 0) {
      return paramFileChannel.read(EMPTY_NIO_BUFFER, paramLong);
    }
    int i = toComponentIndex0(paramInt1);
    int j = 0;
    int k = paramInt2;
    int m = paramInt1;
    paramInt1 = j;
    do
    {
      Component localComponent = this.components[i];
      int n = Math.min(k, localComponent.endOffset - m);
      if (n == 0)
      {
        j = k;
        k = m;
      }
      int i1;
      for (;;)
      {
        i1 = i + 1;
        paramInt2 = paramInt1;
        break;
        int i2 = localComponent.buf.setBytes(localComponent.idx(m), paramFileChannel, paramLong + paramInt1, n);
        if (i2 == 0)
        {
          paramInt2 = paramInt1;
          break label211;
        }
        if (i2 < 0)
        {
          paramInt2 = paramInt1;
          if (paramInt1 != 0) {
            break label211;
          }
          return -1;
        }
        int i3 = m + i2;
        m = k - i2;
        paramInt1 += i2;
        i1 = i;
        paramInt2 = paramInt1;
        k = i3;
        j = m;
        if (i2 != n) {
          break;
        }
        k = i3;
        j = m;
      }
      i = i1;
      paramInt1 = paramInt2;
      m = k;
      k = j;
    } while (j > 0);
    label211:
    return paramInt2;
  }
  
  public int setBytes(int paramInt1, ScatteringByteChannel paramScatteringByteChannel, int paramInt2)
    throws IOException
  {
    checkIndex(paramInt1, paramInt2);
    if (paramInt2 == 0) {
      return paramScatteringByteChannel.read(EMPTY_NIO_BUFFER);
    }
    int i = toComponentIndex0(paramInt1);
    int j = 0;
    int k = paramInt2;
    int m = paramInt1;
    paramInt1 = j;
    do
    {
      Component localComponent = this.components[i];
      int n = Math.min(k, localComponent.endOffset - m);
      if (n == 0)
      {
        j = k;
        k = m;
      }
      for (;;)
      {
        m = i + 1;
        paramInt2 = paramInt1;
        break;
        int i1 = localComponent.buf.setBytes(localComponent.idx(m), paramScatteringByteChannel, n);
        if (i1 == 0) {
          return paramInt1;
        }
        if (i1 < 0)
        {
          paramInt2 = paramInt1;
          if (paramInt1 != 0) {
            return paramInt2;
          }
          return -1;
        }
        int i2 = m + i1;
        int i3 = k - i1;
        paramInt1 += i1;
        m = i;
        paramInt2 = paramInt1;
        k = i2;
        j = i3;
        if (i1 != n) {
          break;
        }
        k = i2;
        j = i3;
      }
      i = m;
      paramInt1 = paramInt2;
      m = k;
      k = j;
    } while (j > 0);
    return paramInt2;
  }
  
  public CompositeByteBuf setBytes(int paramInt, ByteBuf paramByteBuf)
  {
    super.setBytes(paramInt, paramByteBuf, paramByteBuf.readableBytes());
    return this;
  }
  
  public CompositeByteBuf setBytes(int paramInt1, ByteBuf paramByteBuf, int paramInt2)
  {
    super.setBytes(paramInt1, paramByteBuf, paramInt2);
    return this;
  }
  
  public CompositeByteBuf setBytes(int paramInt1, ByteBuf paramByteBuf, int paramInt2, int paramInt3)
  {
    checkSrcIndex(paramInt1, paramInt3, paramInt2, paramByteBuf.capacity());
    if (paramInt3 == 0) {
      return this;
    }
    int i = toComponentIndex0(paramInt1);
    int j = paramInt1;
    for (paramInt1 = i; paramInt3 > 0; paramInt1++)
    {
      Component localComponent = this.components[paramInt1];
      i = Math.min(paramInt3, localComponent.endOffset - j);
      localComponent.buf.setBytes(localComponent.idx(j), paramByteBuf, paramInt2, i);
      j += i;
      paramInt2 += i;
      paramInt3 -= i;
    }
    return this;
  }
  
  /* Error */
  public CompositeByteBuf setBytes(int paramInt, ByteBuffer paramByteBuffer)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 751	java/nio/ByteBuffer:limit	()I
    //   4: istore_3
    //   5: aload_2
    //   6: invokevirtual 754	java/nio/ByteBuffer:remaining	()I
    //   9: istore 4
    //   11: aload_0
    //   12: iload_1
    //   13: iload 4
    //   15: invokevirtual 553	io/netty/buffer/AbstractByteBuf:checkIndex	(II)V
    //   18: iload 4
    //   20: ifne +5 -> 25
    //   23: aload_0
    //   24: areturn
    //   25: aload_0
    //   26: iload_1
    //   27: invokespecial 555	io/netty/buffer/CompositeByteBuf:toComponentIndex0	(I)I
    //   30: istore 5
    //   32: iload_1
    //   33: istore 6
    //   35: iload 5
    //   37: istore_1
    //   38: iload 4
    //   40: ifle +86 -> 126
    //   43: aload_0
    //   44: getfield 96	io/netty/buffer/CompositeByteBuf:components	[Lio/netty/buffer/CompositeByteBuf$Component;
    //   47: iload_1
    //   48: aaload
    //   49: astore 7
    //   51: iload 4
    //   53: aload 7
    //   55: getfield 214	io/netty/buffer/CompositeByteBuf$Component:endOffset	I
    //   58: iload 6
    //   60: isub
    //   61: invokestatic 250	java/lang/Math:min	(II)I
    //   64: istore 5
    //   66: aload_2
    //   67: aload_2
    //   68: invokevirtual 757	java/nio/ByteBuffer:position	()I
    //   71: iload 5
    //   73: iadd
    //   74: invokevirtual 760	java/nio/ByteBuffer:limit	(I)Ljava/nio/Buffer;
    //   77: pop
    //   78: aload 7
    //   80: getfield 332	io/netty/buffer/CompositeByteBuf$Component:buf	Lio/netty/buffer/ByteBuf;
    //   83: aload 7
    //   85: iload 6
    //   87: invokevirtual 336	io/netty/buffer/CompositeByteBuf$Component:idx	(I)I
    //   90: aload_2
    //   91: invokevirtual 949	io/netty/buffer/ByteBuf:setBytes	(ILjava/nio/ByteBuffer;)Lio/netty/buffer/ByteBuf;
    //   94: pop
    //   95: iload 6
    //   97: iload 5
    //   99: iadd
    //   100: istore 6
    //   102: iload 4
    //   104: iload 5
    //   106: isub
    //   107: istore 4
    //   109: iinc 1 1
    //   112: goto -74 -> 38
    //   115: astore 7
    //   117: aload_2
    //   118: iload_3
    //   119: invokevirtual 760	java/nio/ByteBuffer:limit	(I)Ljava/nio/Buffer;
    //   122: pop
    //   123: aload 7
    //   125: athrow
    //   126: aload_2
    //   127: iload_3
    //   128: invokevirtual 760	java/nio/ByteBuffer:limit	(I)Ljava/nio/Buffer;
    //   131: pop
    //   132: aload_0
    //   133: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	this	CompositeByteBuf
    //   0	134	1	paramInt	int
    //   0	134	2	paramByteBuffer	ByteBuffer
    //   4	124	3	i	int
    //   9	99	4	j	int
    //   30	77	5	k	int
    //   33	68	6	m	int
    //   49	35	7	localComponent	Component
    //   115	9	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   43	95	115	finally
  }
  
  public CompositeByteBuf setBytes(int paramInt, byte[] paramArrayOfByte)
  {
    return setBytes(paramInt, paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public CompositeByteBuf setBytes(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    checkSrcIndex(paramInt1, paramInt3, paramInt2, paramArrayOfByte.length);
    if (paramInt3 == 0) {
      return this;
    }
    for (int i = toComponentIndex0(paramInt1); paramInt3 > 0; i++)
    {
      Component localComponent = this.components[i];
      int j = Math.min(paramInt3, localComponent.endOffset - paramInt1);
      localComponent.buf.setBytes(localComponent.idx(paramInt1), paramArrayOfByte, paramInt2, j);
      paramInt1 += j;
      paramInt2 += j;
      paramInt3 -= j;
    }
    return this;
  }
  
  public CompositeByteBuf setChar(int paramInt1, int paramInt2)
  {
    return setShort(paramInt1, paramInt2);
  }
  
  public CompositeByteBuf setDouble(int paramInt, double paramDouble)
  {
    return setLong(paramInt, Double.doubleToRawLongBits(paramDouble));
  }
  
  public CompositeByteBuf setFloat(int paramInt, float paramFloat)
  {
    return setInt(paramInt, Float.floatToRawIntBits(paramFloat));
  }
  
  public CompositeByteBuf setIndex(int paramInt1, int paramInt2)
  {
    super.setIndex(paramInt1, paramInt2);
    return this;
  }
  
  public CompositeByteBuf setInt(int paramInt1, int paramInt2)
  {
    checkIndex(paramInt1, 4);
    _setInt(paramInt1, paramInt2);
    return this;
  }
  
  public CompositeByteBuf setLong(int paramInt, long paramLong)
  {
    checkIndex(paramInt, 8);
    _setLong(paramInt, paramLong);
    return this;
  }
  
  public CompositeByteBuf setMedium(int paramInt1, int paramInt2)
  {
    checkIndex(paramInt1, 3);
    _setMedium(paramInt1, paramInt2);
    return this;
  }
  
  public CompositeByteBuf setShort(int paramInt1, int paramInt2)
  {
    checkIndex(paramInt1, 2);
    _setShort(paramInt1, paramInt2);
    return this;
  }
  
  public CompositeByteBuf setZero(int paramInt1, int paramInt2)
  {
    super.setZero(paramInt1, paramInt2);
    return this;
  }
  
  public CompositeByteBuf skipBytes(int paramInt)
  {
    super.skipBytes(paramInt);
    return this;
  }
  
  public int toByteIndex(int paramInt)
  {
    checkComponentIndex(paramInt);
    return this.components[paramInt].offset;
  }
  
  public int toComponentIndex(int paramInt)
  {
    checkIndex(paramInt);
    return toComponentIndex0(paramInt);
  }
  
  public String toString()
  {
    Object localObject = super.toString();
    String str = ((String)localObject).substring(0, ((String)localObject).length() - 1);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append(", components=");
    ((StringBuilder)localObject).append(this.componentCount);
    ((StringBuilder)localObject).append(')');
    return ((StringBuilder)localObject).toString();
  }
  
  public CompositeByteBuf touch()
  {
    return this;
  }
  
  public CompositeByteBuf touch(Object paramObject)
  {
    return this;
  }
  
  public ByteBuf unwrap()
  {
    return null;
  }
  
  public CompositeByteBuf writeBoolean(boolean paramBoolean)
  {
    writeByte(paramBoolean);
    return this;
  }
  
  public CompositeByteBuf writeByte(int paramInt)
  {
    ensureWritable0(1);
    int i = this.writerIndex;
    this.writerIndex = (i + 1);
    _setByte(i, paramInt);
    return this;
  }
  
  public CompositeByteBuf writeBytes(ByteBuf paramByteBuf)
  {
    super.writeBytes(paramByteBuf, paramByteBuf.readableBytes());
    return this;
  }
  
  public CompositeByteBuf writeBytes(ByteBuf paramByteBuf, int paramInt)
  {
    super.writeBytes(paramByteBuf, paramInt);
    return this;
  }
  
  public CompositeByteBuf writeBytes(ByteBuf paramByteBuf, int paramInt1, int paramInt2)
  {
    super.writeBytes(paramByteBuf, paramInt1, paramInt2);
    return this;
  }
  
  public CompositeByteBuf writeBytes(ByteBuffer paramByteBuffer)
  {
    super.writeBytes(paramByteBuffer);
    return this;
  }
  
  public CompositeByteBuf writeBytes(byte[] paramArrayOfByte)
  {
    super.writeBytes(paramArrayOfByte, 0, paramArrayOfByte.length);
    return this;
  }
  
  public CompositeByteBuf writeBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    super.writeBytes(paramArrayOfByte, paramInt1, paramInt2);
    return this;
  }
  
  public CompositeByteBuf writeChar(int paramInt)
  {
    super.writeShort(paramInt);
    return this;
  }
  
  public CompositeByteBuf writeDouble(double paramDouble)
  {
    super.writeLong(Double.doubleToRawLongBits(paramDouble));
    return this;
  }
  
  public CompositeByteBuf writeFloat(float paramFloat)
  {
    super.writeInt(Float.floatToRawIntBits(paramFloat));
    return this;
  }
  
  public CompositeByteBuf writeInt(int paramInt)
  {
    super.writeInt(paramInt);
    return this;
  }
  
  public CompositeByteBuf writeLong(long paramLong)
  {
    super.writeLong(paramLong);
    return this;
  }
  
  public CompositeByteBuf writeMedium(int paramInt)
  {
    super.writeMedium(paramInt);
    return this;
  }
  
  public CompositeByteBuf writeShort(int paramInt)
  {
    super.writeShort(paramInt);
    return this;
  }
  
  public CompositeByteBuf writeZero(int paramInt)
  {
    super.writeZero(paramInt);
    return this;
  }
  
  public CompositeByteBuf writerIndex(int paramInt)
  {
    super.writerIndex(paramInt);
    return this;
  }
  
  static abstract interface ByteWrapper<T>
  {
    public abstract boolean isEmpty(T paramT);
    
    public abstract ByteBuf wrap(T paramT);
  }
  
  private static final class Component
  {
    int adjustment;
    final ByteBuf buf;
    int endOffset;
    int offset;
    private ByteBuf slice;
    int srcAdjustment;
    final ByteBuf srcBuf;
    
    Component(ByteBuf paramByteBuf1, int paramInt1, ByteBuf paramByteBuf2, int paramInt2, int paramInt3, int paramInt4, ByteBuf paramByteBuf3)
    {
      this.srcBuf = paramByteBuf1;
      this.srcAdjustment = (paramInt1 - paramInt3);
      this.buf = paramByteBuf2;
      this.adjustment = (paramInt2 - paramInt3);
      this.offset = paramInt3;
      this.endOffset = (paramInt3 + paramInt4);
      this.slice = paramByteBuf3;
    }
    
    ByteBuf duplicate()
    {
      return this.srcBuf.duplicate();
    }
    
    void free()
    {
      this.slice = null;
      this.srcBuf.release();
    }
    
    int idx(int paramInt)
    {
      return paramInt + this.adjustment;
    }
    
    ByteBuffer internalNioBuffer(int paramInt1, int paramInt2)
    {
      return this.srcBuf.internalNioBuffer(srcIdx(paramInt1), paramInt2);
    }
    
    int length()
    {
      return this.endOffset - this.offset;
    }
    
    void reposition(int paramInt)
    {
      int i = paramInt - this.offset;
      this.endOffset += i;
      this.srcAdjustment -= i;
      this.adjustment -= i;
      this.offset = paramInt;
    }
    
    ByteBuf slice()
    {
      ByteBuf localByteBuf1 = this.slice;
      ByteBuf localByteBuf2 = localByteBuf1;
      if (localByteBuf1 == null)
      {
        localByteBuf2 = this.srcBuf.slice(srcIdx(this.offset), length());
        this.slice = localByteBuf2;
      }
      return localByteBuf2;
    }
    
    int srcIdx(int paramInt)
    {
      return paramInt + this.srcAdjustment;
    }
    
    void transferTo(ByteBuf paramByteBuf)
    {
      paramByteBuf.writeBytes(this.buf, idx(this.offset), length());
      free();
    }
  }
  
  private final class CompositeByteBufIterator
    implements Iterator<ByteBuf>
  {
    private int index;
    private final int size = CompositeByteBuf.this.numComponents();
    
    private CompositeByteBufIterator() {}
    
    public boolean hasNext()
    {
      boolean bool;
      if (this.size > this.index) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public ByteBuf next()
    {
      if (this.size == CompositeByteBuf.this.numComponents())
      {
        if (hasNext()) {
          try
          {
            Object localObject = CompositeByteBuf.this.components;
            int i = this.index;
            this.index = (i + 1);
            localObject = localObject[i].slice();
            return (ByteBuf)localObject;
          }
          catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
          {
            throw new ConcurrentModificationException();
          }
        }
        throw new NoSuchElementException();
      }
      throw new ConcurrentModificationException();
    }
    
    public void remove()
    {
      throw new UnsupportedOperationException("Read-Only");
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\buffer\CompositeByteBuf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */