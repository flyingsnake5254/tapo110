package io.netty.handler.codec.compression;

import io.netty.buffer.ByteBuf;

public final class Snappy
{
  private static final int COPY_1_BYTE_OFFSET = 1;
  private static final int COPY_2_BYTE_OFFSET = 2;
  private static final int COPY_4_BYTE_OFFSET = 3;
  private static final int LITERAL = 0;
  private static final int MAX_HT_SIZE = 16384;
  private static final int MIN_COMPRESSIBLE_BYTES = 15;
  private static final int NOT_ENOUGH_INPUT = -1;
  private static final int PREAMBLE_NOT_FULL = -1;
  private State state = State.READY;
  private byte tag;
  private int written;
  
  private static int bitsToEncode(int paramInt)
  {
    paramInt = Integer.highestOneBit(paramInt);
    for (int i = 0;; i++)
    {
      paramInt >>= 1;
      if (paramInt == 0) {
        break;
      }
    }
    return i;
  }
  
  static int calculateChecksum(ByteBuf paramByteBuf)
  {
    return calculateChecksum(paramByteBuf, paramByteBuf.readerIndex(), paramByteBuf.readableBytes());
  }
  
  static int calculateChecksum(ByteBuf paramByteBuf, int paramInt1, int paramInt2)
  {
    Crc32c localCrc32c = new Crc32c();
    try
    {
      localCrc32c.update(paramByteBuf, paramInt1, paramInt2);
      paramInt1 = maskChecksum(localCrc32c.getValue());
      return paramInt1;
    }
    finally
    {
      localCrc32c.reset();
    }
  }
  
  private static int decodeCopyWith1ByteOffset(byte paramByte, ByteBuf paramByteBuf1, ByteBuf paramByteBuf2, int paramInt)
  {
    if (!paramByteBuf1.isReadable()) {
      return -1;
    }
    int i = paramByteBuf2.writerIndex();
    int j = ((paramByte & 0x1C) >> 2) + 4;
    int k = (paramByte & 0xE0) << 8 >> 5 | paramByteBuf1.readUnsignedByte();
    validateOffset(k, paramInt);
    paramByteBuf2.markReaderIndex();
    if (k < j)
    {
      for (paramByte = j / k; paramByte > 0; paramByte--)
      {
        paramByteBuf2.readerIndex(i - k);
        paramByteBuf2.readBytes(paramByteBuf2, k);
      }
      paramByte = j % k;
      if (paramByte != 0)
      {
        paramByteBuf2.readerIndex(i - k);
        paramByteBuf2.readBytes(paramByteBuf2, paramByte);
      }
    }
    else
    {
      paramByteBuf2.readerIndex(i - k);
      paramByteBuf2.readBytes(paramByteBuf2, j);
    }
    paramByteBuf2.resetReaderIndex();
    return j;
  }
  
  private static int decodeCopyWith2ByteOffset(byte paramByte, ByteBuf paramByteBuf1, ByteBuf paramByteBuf2, int paramInt)
  {
    if (paramByteBuf1.readableBytes() < 2) {
      return -1;
    }
    int i = paramByteBuf2.writerIndex();
    int j = (paramByte >> 2 & 0x3F) + 1;
    int k = paramByteBuf1.readUnsignedShortLE();
    validateOffset(k, paramInt);
    paramByteBuf2.markReaderIndex();
    if (k < j)
    {
      for (paramByte = j / k; paramByte > 0; paramByte--)
      {
        paramByteBuf2.readerIndex(i - k);
        paramByteBuf2.readBytes(paramByteBuf2, k);
      }
      paramByte = j % k;
      if (paramByte != 0)
      {
        paramByteBuf2.readerIndex(i - k);
        paramByteBuf2.readBytes(paramByteBuf2, paramByte);
      }
    }
    else
    {
      paramByteBuf2.readerIndex(i - k);
      paramByteBuf2.readBytes(paramByteBuf2, j);
    }
    paramByteBuf2.resetReaderIndex();
    return j;
  }
  
  private static int decodeCopyWith4ByteOffset(byte paramByte, ByteBuf paramByteBuf1, ByteBuf paramByteBuf2, int paramInt)
  {
    if (paramByteBuf1.readableBytes() < 4) {
      return -1;
    }
    int i = paramByteBuf2.writerIndex();
    int j = (paramByte >> 2 & 0x3F) + 1;
    int k = paramByteBuf1.readIntLE();
    validateOffset(k, paramInt);
    paramByteBuf2.markReaderIndex();
    if (k < j)
    {
      for (paramByte = j / k; paramByte > 0; paramByte--)
      {
        paramByteBuf2.readerIndex(i - k);
        paramByteBuf2.readBytes(paramByteBuf2, k);
      }
      paramByte = j % k;
      if (paramByte != 0)
      {
        paramByteBuf2.readerIndex(i - k);
        paramByteBuf2.readBytes(paramByteBuf2, paramByte);
      }
    }
    else
    {
      paramByteBuf2.readerIndex(i - k);
      paramByteBuf2.readBytes(paramByteBuf2, j);
    }
    paramByteBuf2.resetReaderIndex();
    return j;
  }
  
  static int decodeLiteral(byte paramByte, ByteBuf paramByteBuf1, ByteBuf paramByteBuf2)
  {
    paramByteBuf1.markReaderIndex();
    paramByte = paramByte >> 2 & 0x3F;
    switch (paramByte)
    {
    default: 
      break;
    case 63: 
      if (paramByteBuf1.readableBytes() < 4) {
        return -1;
      }
      paramByte = paramByteBuf1.readIntLE();
      break;
    case 62: 
      if (paramByteBuf1.readableBytes() < 3) {
        return -1;
      }
      paramByte = paramByteBuf1.readUnsignedMediumLE();
      break;
    case 61: 
      if (paramByteBuf1.readableBytes() < 2) {
        return -1;
      }
      paramByte = paramByteBuf1.readUnsignedShortLE();
      break;
    case 60: 
      if (!paramByteBuf1.isReadable()) {
        return -1;
      }
      paramByte = paramByteBuf1.readUnsignedByte();
    }
    paramByte++;
    if (paramByteBuf1.readableBytes() < paramByte)
    {
      paramByteBuf1.resetReaderIndex();
      return -1;
    }
    paramByteBuf2.writeBytes(paramByteBuf1, paramByte);
    return paramByte;
  }
  
  private static void encodeCopy(ByteBuf paramByteBuf, int paramInt1, int paramInt2)
  {
    while (paramInt2 >= 68)
    {
      encodeCopyWithOffset(paramByteBuf, paramInt1, 64);
      paramInt2 -= 64;
    }
    int i = paramInt2;
    if (paramInt2 > 64)
    {
      encodeCopyWithOffset(paramByteBuf, paramInt1, 60);
      i = paramInt2 - 60;
    }
    encodeCopyWithOffset(paramByteBuf, paramInt1, i);
  }
  
  private static void encodeCopyWithOffset(ByteBuf paramByteBuf, int paramInt1, int paramInt2)
  {
    if ((paramInt2 < 12) && (paramInt1 < 2048))
    {
      paramByteBuf.writeByte(paramInt2 - 4 << 2 | 0x1 | paramInt1 >> 8 << 5);
      paramByteBuf.writeByte(paramInt1 & 0xFF);
    }
    else
    {
      paramByteBuf.writeByte(paramInt2 - 1 << 2 | 0x2);
      paramByteBuf.writeByte(paramInt1 & 0xFF);
      paramByteBuf.writeByte(paramInt1 >> 8 & 0xFF);
    }
  }
  
  static void encodeLiteral(ByteBuf paramByteBuf1, ByteBuf paramByteBuf2, int paramInt)
  {
    if (paramInt < 61)
    {
      paramByteBuf2.writeByte(paramInt - 1 << 2);
    }
    else
    {
      int i = paramInt - 1;
      int j = bitsToEncode(i) / 8 + 1;
      paramByteBuf2.writeByte(j + 59 << 2);
      for (int k = 0; k < j; k++) {
        paramByteBuf2.writeByte(i >> k * 8 & 0xFF);
      }
    }
    paramByteBuf2.writeBytes(paramByteBuf1, paramInt);
  }
  
  private static int findMatchingLength(ByteBuf paramByteBuf, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 0;
    int j = paramInt2;
    int k;
    for (paramInt2 = i;; paramInt2 += 4)
    {
      i = paramInt2;
      k = j;
      if (j > paramInt3 - 4) {
        break;
      }
      i = paramInt2;
      k = j;
      if (paramByteBuf.getInt(j) != paramByteBuf.getInt(paramInt1 + paramInt2)) {
        break;
      }
      j += 4;
    }
    while ((k < paramInt3) && (paramByteBuf.getByte(paramInt1 + i) == paramByteBuf.getByte(k)))
    {
      k++;
      i++;
    }
    return i;
  }
  
  private static short[] getHashTable(int paramInt)
  {
    int i = 256;
    while ((i < 16384) && (i < paramInt)) {
      i <<= 1;
    }
    return new short[i];
  }
  
  private static int hash(ByteBuf paramByteBuf, int paramInt1, int paramInt2)
  {
    return paramByteBuf.getInt(paramInt1) * 506832829 >>> paramInt2;
  }
  
  static int maskChecksum(long paramLong)
  {
    return (int)((paramLong << 17 | paramLong >> 15) - 1568478504L);
  }
  
  private static int readPreamble(ByteBuf paramByteBuf)
  {
    int i = 0;
    int j = 0;
    while (paramByteBuf.isReadable())
    {
      int k = paramByteBuf.readUnsignedByte();
      int m = j + 1;
      i |= (k & 0x7F) << j * 7;
      if ((k & 0x80) == 0) {
        return i;
      }
      if (m < 4) {
        j = m;
      } else {
        throw new DecompressionException("Preamble is greater than 4 bytes");
      }
    }
    return 0;
  }
  
  static void validateChecksum(int paramInt, ByteBuf paramByteBuf)
  {
    validateChecksum(paramInt, paramByteBuf, paramByteBuf.readerIndex(), paramByteBuf.readableBytes());
  }
  
  static void validateChecksum(int paramInt1, ByteBuf paramByteBuf, int paramInt2, int paramInt3)
  {
    paramInt2 = calculateChecksum(paramByteBuf, paramInt2, paramInt3);
    if (paramInt2 == paramInt1) {
      return;
    }
    paramByteBuf = new StringBuilder();
    paramByteBuf.append("mismatching checksum: ");
    paramByteBuf.append(Integer.toHexString(paramInt2));
    paramByteBuf.append(" (expected: ");
    paramByteBuf.append(Integer.toHexString(paramInt1));
    paramByteBuf.append(')');
    throw new DecompressionException(paramByteBuf.toString());
  }
  
  private static void validateOffset(int paramInt1, int paramInt2)
  {
    if (paramInt1 != 0)
    {
      if (paramInt1 >= 0)
      {
        if (paramInt1 <= paramInt2) {
          return;
        }
        throw new DecompressionException("Offset exceeds size of chunk");
      }
      throw new DecompressionException("Offset is greater than maximum value supported by this implementation");
    }
    throw new DecompressionException("Offset is less than minimum permissible value");
  }
  
  public void decode(ByteBuf paramByteBuf1, ByteBuf paramByteBuf2)
  {
    while (paramByteBuf1.isReadable())
    {
      int i = 1.$SwitchMap$io$netty$handler$codec$compression$Snappy$State[this.state.ordinal()];
      if (i != 1)
      {
        if (i != 2)
        {
          if (i == 3) {
            break label269;
          }
          if (i != 4)
          {
            if (i != 5) {
              continue;
            }
            byte b = this.tag;
            i = b & 0x3;
            if (i != 1)
            {
              if (i != 2)
              {
                if (i != 3) {
                  continue;
                }
                i = decodeCopyWith4ByteOffset(b, paramByteBuf1, paramByteBuf2, this.written);
                if (i != -1)
                {
                  this.state = State.READING_TAG;
                  this.written += i;
                  continue;
                }
                return;
              }
              i = decodeCopyWith2ByteOffset(b, paramByteBuf1, paramByteBuf2, this.written);
              if (i != -1)
              {
                this.state = State.READING_TAG;
                this.written += i;
                continue;
              }
              return;
            }
            i = decodeCopyWith1ByteOffset(b, paramByteBuf1, paramByteBuf2, this.written);
            if (i != -1)
            {
              this.state = State.READING_TAG;
              this.written += i;
              continue;
            }
            return;
          }
          i = decodeLiteral(this.tag, paramByteBuf1, paramByteBuf2);
          if (i != -1)
          {
            this.state = State.READING_TAG;
            this.written += i;
            continue;
          }
        }
      }
      else {
        this.state = State.READING_PREAMBLE;
      }
      i = readPreamble(paramByteBuf1);
      if (i == -1) {
        return;
      }
      if (i == 0)
      {
        this.state = State.READY;
        return;
      }
      paramByteBuf2.ensureWritable(i);
      this.state = State.READING_TAG;
      label269:
      if (!paramByteBuf1.isReadable()) {
        return;
      }
      i = paramByteBuf1.readByte();
      this.tag = ((byte)i);
      i &= 0x3;
      if (i != 0)
      {
        if ((i == 1) || (i == 2) || (i == 3)) {
          this.state = State.READING_COPY;
        }
      }
      else {
        this.state = State.READING_LITERAL;
      }
    }
  }
  
  public void encode(ByteBuf paramByteBuf1, ByteBuf paramByteBuf2, int paramInt)
  {
    int j;
    for (int i = 0;; i++)
    {
      j = paramInt >>> i * 7;
      if ((j & 0xFFFFFF80) == 0) {
        break;
      }
      paramByteBuf2.writeByte(j & 0x7F | 0x80);
    }
    paramByteBuf2.writeByte(j);
    int k = paramByteBuf1.readerIndex();
    short[] arrayOfShort = getHashTable(paramInt);
    int m = Integer.numberOfLeadingZeros(arrayOfShort.length) + 1;
    i = k;
    if (paramInt - k >= 15)
    {
      j = k + 1;
      int n = hash(paramByteBuf1, j, m);
      i = k;
      int i1 = 32;
      for (;;)
      {
        int i2 = (i1 >> 5) + j;
        int i3 = paramInt - 4;
        if (i2 > i3) {
          break label374;
        }
        label127:
        int i4 = hash(paramByteBuf1, i2, m);
        int i5 = arrayOfShort[n] + k;
        arrayOfShort[n] = ((short)(short)(j - k));
        if (paramByteBuf1.getInt(j) == paramByteBuf1.getInt(i5))
        {
          encodeLiteral(paramByteBuf1, paramByteBuf2, j - i);
          n = i5;
          for (;;)
          {
            i1 = findMatchingLength(paramByteBuf1, n + 4, j + 4, paramInt) + 4;
            i = j + i1;
            encodeCopy(paramByteBuf2, j - n, i1);
            paramByteBuf1.readerIndex(paramByteBuf1.readerIndex() + i1);
            j = i - 1;
            if (i >= i3) {
              break label127;
            }
            n = hash(paramByteBuf1, j, m);
            i1 = i - k;
            arrayOfShort[n] = ((short)(short)(i1 - 1));
            i2 = j + 1;
            i4 = hash(paramByteBuf1, i2, m);
            n = k + arrayOfShort[i4];
            arrayOfShort[i4] = ((short)(short)i1);
            if (paramByteBuf1.getInt(i2) != paramByteBuf1.getInt(n))
            {
              n = hash(paramByteBuf1, j + 2, m);
              j = i + 1;
              break;
            }
            j = i;
          }
        }
        j = i2;
        i1++;
        n = i4;
      }
    }
    label374:
    if (i < paramInt) {
      encodeLiteral(paramByteBuf1, paramByteBuf2, paramInt - i);
    }
  }
  
  public void reset()
  {
    this.state = State.READY;
    this.tag = ((byte)0);
    this.written = 0;
  }
  
  private static enum State
  {
    static
    {
      State localState1 = new State("READY", 0);
      READY = localState1;
      State localState2 = new State("READING_PREAMBLE", 1);
      READING_PREAMBLE = localState2;
      State localState3 = new State("READING_TAG", 2);
      READING_TAG = localState3;
      State localState4 = new State("READING_LITERAL", 3);
      READING_LITERAL = localState4;
      State localState5 = new State("READING_COPY", 4);
      READING_COPY = localState5;
      $VALUES = new State[] { localState1, localState2, localState3, localState4, localState5 };
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\compression\Snappy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */