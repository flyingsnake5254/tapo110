package io.netty.handler.codec.compression;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.util.ReferenceCounted;
import java.util.List;

public class Bzip2Decoder
  extends ByteToMessageDecoder
{
  private int blockCRC;
  private Bzip2BlockDecompressor blockDecompressor;
  private int blockSize;
  private State currentState = State.INIT;
  private Bzip2HuffmanStageDecoder huffmanStageDecoder;
  private final Bzip2BitReader reader = new Bzip2BitReader();
  private int streamCRC;
  
  protected void decode(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf, List<Object> paramList)
    throws Exception
  {
    if (!paramByteBuf.isReadable()) {
      return;
    }
    Bzip2BitReader localBzip2BitReader = this.reader;
    localBzip2BitReader.setByteBuf(paramByteBuf);
    for (;;)
    {
      int i = 1.$SwitchMap$io$netty$handler$codec$compression$Bzip2Decoder$State[this.currentState.ordinal()];
      int j = 0;
      int k;
      boolean bool1;
      Object localObject1;
      int m;
      Object localObject2;
      int n;
      int i1;
      int i2;
      switch (i)
      {
      default: 
        throw new IllegalStateException();
      case 10: 
        paramByteBuf.skipBytes(paramByteBuf.readableBytes());
        return;
      case 1: 
        if (paramByteBuf.readableBytes() < 4) {
          return;
        }
        if (paramByteBuf.readUnsignedMedium() != 4348520) {
          break label1251;
        }
        i = paramByteBuf.readByte() - 48;
        if ((i < 1) || (i > 9)) {
          break label1240;
        }
        this.blockSize = (i * 100000);
        this.streamCRC = 0;
        this.currentState = State.INIT_BLOCK;
      case 2: 
        if (!localBzip2BitReader.hasReadableBytes(10)) {
          return;
        }
        k = localBzip2BitReader.readBits(24);
        i = localBzip2BitReader.readBits(24);
        if ((k == 1536581) && (i == 3690640))
        {
          if (localBzip2BitReader.readInt() == this.streamCRC) {
            this.currentState = State.EOF;
          } else {
            throw new DecompressionException("stream CRC error");
          }
        }
        else
        {
          if ((k != 3227993) || (i != 2511705)) {
            break label1229;
          }
          this.blockCRC = localBzip2BitReader.readInt();
          this.currentState = State.INIT_BLOCK_PARAMS;
        }
        break;
      case 3: 
        if (!localBzip2BitReader.hasReadableBits(25)) {
          return;
        }
        bool1 = localBzip2BitReader.readBoolean();
        i = localBzip2BitReader.readBits(24);
        this.blockDecompressor = new Bzip2BlockDecompressor(this.blockSize, this.blockCRC, bool1, i, localBzip2BitReader);
        this.currentState = State.RECEIVE_HUFFMAN_USED_MAP;
      case 4: 
        if (!localBzip2BitReader.hasReadableBits(16)) {
          return;
        }
        this.blockDecompressor.huffmanInUse16 = localBzip2BitReader.readBits(16);
        this.currentState = State.RECEIVE_HUFFMAN_USED_BITMAPS;
      case 5: 
        localObject1 = this.blockDecompressor;
        m = ((Bzip2BlockDecompressor)localObject1).huffmanInUse16;
        i = Integer.bitCount(m);
        localObject2 = ((Bzip2BlockDecompressor)localObject1).huffmanSymbolMap;
        if (!localBzip2BitReader.hasReadableBits(i * 16 + 3)) {
          return;
        }
        if (i > 0)
        {
          k = 0;
          for (i = 0;; i = i1)
          {
            n = i;
            if (k >= 16) {
              break;
            }
            i1 = i;
            if ((32768 >>> k & m) != 0)
            {
              i2 = k << 4;
              n = 0;
              for (;;)
              {
                i1 = i;
                if (n >= 16) {
                  break;
                }
                i1 = i;
                if (localBzip2BitReader.readBoolean())
                {
                  localObject2[i] = ((byte)(byte)i2);
                  i1 = i + 1;
                }
                n++;
                i2++;
                i = i1;
              }
            }
            k++;
          }
        }
        n = 0;
        ((Bzip2BlockDecompressor)localObject1).huffmanEndOfBlockSymbol = (n + 1);
        i = localBzip2BitReader.readBits(3);
        if ((i < 2) || (i > 6)) {
          break label1218;
        }
        k = n + 2;
        if (k > 258) {
          break label1207;
        }
        this.huffmanStageDecoder = new Bzip2HuffmanStageDecoder(localBzip2BitReader, i, k);
        this.currentState = State.RECEIVE_SELECTORS_NUMBER;
      case 6: 
        if (!localBzip2BitReader.hasReadableBits(15)) {
          return;
        }
        i = localBzip2BitReader.readBits(15);
        if ((i >= 1) && (i <= 18002))
        {
          this.huffmanStageDecoder.selectors = new byte[i];
          this.currentState = State.RECEIVE_SELECTORS;
        }
        break;
      case 7: 
        localObject2 = this.huffmanStageDecoder;
        localObject1 = ((Bzip2HuffmanStageDecoder)localObject2).selectors;
        n = localObject1.length;
        Bzip2MoveToFrontTable localBzip2MoveToFrontTable = ((Bzip2HuffmanStageDecoder)localObject2).tableMTF;
        for (i = ((Bzip2HuffmanStageDecoder)localObject2).currentSelector; i < n; i++)
        {
          if (!localBzip2BitReader.hasReadableBits(6))
          {
            ((Bzip2HuffmanStageDecoder)localObject2).currentSelector = i;
            return;
          }
          for (k = 0; localBzip2BitReader.readBoolean(); k++) {}
          localObject1[i] = localBzip2MoveToFrontTable.indexToFront(k);
        }
        this.currentState = State.RECEIVE_HUFFMAN_LENGTH;
      case 8: 
        localObject1 = this.huffmanStageDecoder;
        i1 = ((Bzip2HuffmanStageDecoder)localObject1).totalTables;
        localObject2 = ((Bzip2HuffmanStageDecoder)localObject1).tableCodeLengths;
        m = ((Bzip2HuffmanStageDecoder)localObject1).alphabetSize;
        i = ((Bzip2HuffmanStageDecoder)localObject1).currentLength;
        bool1 = ((Bzip2HuffmanStageDecoder)localObject1).modifyLength;
        i2 = ((Bzip2HuffmanStageDecoder)localObject1).currentGroup;
        for (;;)
        {
          k = j;
          if (i2 >= i1) {
            break;
          }
          if (!localBzip2BitReader.hasReadableBits(5))
          {
            k = 1;
            break;
          }
          n = i;
          if (i < 0) {
            n = localBzip2BitReader.readBits(5);
          }
          k = ((Bzip2HuffmanStageDecoder)localObject1).currentAlpha;
          if (k < m)
          {
            i = n;
            boolean bool2 = bool1;
            if (!localBzip2BitReader.isReadable())
            {
              i = n;
              i1 = 1;
              n = k;
              break label999;
            }
            for (;;)
            {
              if ((!bool2) && (!localBzip2BitReader.readBoolean()))
              {
                localObject2[i2][k] = ((byte)(byte)i);
                k++;
                n = i;
                bool1 = bool2;
                break;
              }
              if (!localBzip2BitReader.isReadable())
              {
                bool1 = true;
                break label864;
              }
              if (localBzip2BitReader.readBoolean()) {
                n = -1;
              } else {
                n = 1;
              }
              i += n;
              if (!localBzip2BitReader.isReadable())
              {
                bool1 = false;
                break label864;
              }
              bool2 = false;
            }
          }
          ((Bzip2HuffmanStageDecoder)localObject1).currentAlpha = 0;
          i2++;
          i = -1;
          bool1 = false;
        }
        n = 0;
        i1 = k;
        if (i1 != 0)
        {
          ((Bzip2HuffmanStageDecoder)localObject1).currentGroup = i2;
          ((Bzip2HuffmanStageDecoder)localObject1).currentLength = i;
          ((Bzip2HuffmanStageDecoder)localObject1).currentAlpha = n;
          ((Bzip2HuffmanStageDecoder)localObject1).modifyLength = bool1;
          return;
        }
        ((Bzip2HuffmanStageDecoder)localObject1).createHuffmanDecodingTables();
        this.currentState = State.DECODE_HUFFMAN_DATA;
      case 9: 
        label864:
        label999:
        localObject2 = this.blockDecompressor;
        i = paramByteBuf.readerIndex();
        if (!((Bzip2BlockDecompressor)localObject2).decodeHuffmanData(this.huffmanStageDecoder)) {
          return;
        }
        if ((paramByteBuf.readerIndex() == i) && (paramByteBuf.isReadable())) {
          localBzip2BitReader.refill();
        }
        i = ((Bzip2BlockDecompressor)localObject2).blockLength();
        localObject1 = paramChannelHandlerContext.alloc().buffer(i);
        try
        {
          for (;;)
          {
            i = ((Bzip2BlockDecompressor)localObject2).read();
            if (i < 0) {
              break;
            }
            ((ByteBuf)localObject1).writeByte(i);
          }
          i = ((Bzip2BlockDecompressor)localObject2).checkCRC();
          k = this.streamCRC;
          this.streamCRC = (i ^ (k >>> 31 | k << 1));
          paramList.add(localObject1);
          this.currentState = State.INIT_BLOCK;
        }
        finally
        {
          ((ReferenceCounted)localObject1).release();
        }
      }
    }
    throw new DecompressionException("incorrect selectors number");
    label1207:
    throw new DecompressionException("incorrect alphabet size");
    label1218:
    throw new DecompressionException("incorrect huffman groups number");
    label1229:
    throw new DecompressionException("bad block header");
    label1240:
    throw new DecompressionException("block size is invalid");
    label1251:
    throw new DecompressionException("Unexpected stream identifier contents. Mismatched bzip2 protocol version?");
  }
  
  public boolean isClosed()
  {
    boolean bool;
    if (this.currentState == State.EOF) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private static enum State
  {
    static
    {
      State localState1 = new State("INIT", 0);
      INIT = localState1;
      State localState2 = new State("INIT_BLOCK", 1);
      INIT_BLOCK = localState2;
      State localState3 = new State("INIT_BLOCK_PARAMS", 2);
      INIT_BLOCK_PARAMS = localState3;
      State localState4 = new State("RECEIVE_HUFFMAN_USED_MAP", 3);
      RECEIVE_HUFFMAN_USED_MAP = localState4;
      State localState5 = new State("RECEIVE_HUFFMAN_USED_BITMAPS", 4);
      RECEIVE_HUFFMAN_USED_BITMAPS = localState5;
      State localState6 = new State("RECEIVE_SELECTORS_NUMBER", 5);
      RECEIVE_SELECTORS_NUMBER = localState6;
      State localState7 = new State("RECEIVE_SELECTORS", 6);
      RECEIVE_SELECTORS = localState7;
      State localState8 = new State("RECEIVE_HUFFMAN_LENGTH", 7);
      RECEIVE_HUFFMAN_LENGTH = localState8;
      State localState9 = new State("DECODE_HUFFMAN_DATA", 8);
      DECODE_HUFFMAN_DATA = localState9;
      State localState10 = new State("EOF", 9);
      EOF = localState10;
      $VALUES = new State[] { localState1, localState2, localState3, localState4, localState5, localState6, localState7, localState8, localState9, localState10 };
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\compression\Bzip2Decoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */