package okhttp3.internal.http2;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import okio.BufferedSink;
import okio.ByteString;

class Huffman
{
  private static final int[] CODES = { 8184, 8388568, 268435426, 268435427, 268435428, 268435429, 268435430, 268435431, 268435432, 16777194, 1073741820, 268435433, 268435434, 1073741821, 268435435, 268435436, 268435437, 268435438, 268435439, 268435440, 268435441, 268435442, 1073741822, 268435443, 268435444, 268435445, 268435446, 268435447, 268435448, 268435449, 268435450, 268435451, 20, 1016, 1017, 4090, 8185, 21, 248, 2042, 1018, 1019, 249, 2043, 250, 22, 23, 24, 0, 1, 2, 25, 26, 27, 28, 29, 30, 31, 92, 251, 32764, 32, 4091, 1020, 8186, 33, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 252, 115, 253, 8187, 524272, 8188, 16380, 34, 32765, 3, 35, 4, 36, 5, 37, 38, 39, 6, 116, 117, 40, 41, 42, 7, 43, 118, 44, 8, 9, 45, 119, 120, 121, 122, 123, 32766, 2044, 16381, 8189, 268435452, 1048550, 4194258, 1048551, 1048552, 4194259, 4194260, 4194261, 8388569, 4194262, 8388570, 8388571, 8388572, 8388573, 8388574, 16777195, 8388575, 16777196, 16777197, 4194263, 8388576, 16777198, 8388577, 8388578, 8388579, 8388580, 2097116, 4194264, 8388581, 4194265, 8388582, 8388583, 16777199, 4194266, 2097117, 1048553, 4194267, 4194268, 8388584, 8388585, 2097118, 8388586, 4194269, 4194270, 16777200, 2097119, 4194271, 8388587, 8388588, 2097120, 2097121, 4194272, 2097122, 8388589, 4194273, 8388590, 8388591, 1048554, 4194274, 4194275, 4194276, 8388592, 4194277, 4194278, 8388593, 67108832, 67108833, 1048555, 524273, 4194279, 8388594, 4194280, 33554412, 67108834, 67108835, 67108836, 134217694, 134217695, 67108837, 16777201, 33554413, 524274, 2097123, 67108838, 134217696, 134217697, 67108839, 134217698, 16777202, 2097124, 2097125, 67108840, 67108841, 268435453, 134217699, 134217700, 134217701, 1048556, 16777203, 1048557, 2097126, 4194281, 2097127, 2097128, 8388595, 4194282, 4194283, 33554414, 33554415, 16777204, 16777205, 67108842, 8388596, 67108843, 134217702, 67108844, 67108845, 134217703, 134217704, 134217705, 134217706, 134217707, 268435454, 134217708, 134217709, 134217710, 134217711, 134217712, 67108846 };
  private static final byte[] CODE_LENGTHS = { 13, 23, 28, 28, 28, 28, 28, 28, 28, 24, 30, 28, 28, 30, 28, 28, 28, 28, 28, 28, 28, 28, 30, 28, 28, 28, 28, 28, 28, 28, 28, 28, 6, 10, 10, 12, 13, 6, 8, 11, 10, 10, 8, 11, 8, 6, 6, 6, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 7, 8, 15, 6, 12, 10, 13, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 7, 8, 13, 19, 13, 14, 6, 15, 5, 6, 5, 6, 5, 6, 6, 6, 5, 7, 7, 6, 6, 6, 5, 6, 7, 6, 5, 5, 6, 7, 7, 7, 7, 7, 15, 11, 14, 13, 28, 20, 22, 20, 20, 22, 22, 22, 23, 22, 23, 23, 23, 23, 23, 24, 23, 24, 24, 22, 23, 24, 23, 23, 23, 23, 21, 22, 23, 22, 23, 23, 24, 22, 21, 20, 22, 22, 23, 23, 21, 23, 22, 22, 24, 21, 22, 23, 23, 21, 21, 22, 21, 23, 22, 23, 23, 20, 22, 22, 22, 23, 22, 22, 23, 26, 26, 20, 19, 22, 23, 22, 25, 26, 26, 26, 27, 27, 26, 24, 25, 19, 21, 26, 27, 27, 26, 27, 24, 21, 21, 26, 26, 28, 27, 27, 27, 20, 24, 20, 21, 22, 21, 21, 23, 22, 22, 25, 25, 24, 24, 26, 23, 26, 27, 26, 26, 27, 27, 27, 27, 27, 28, 27, 27, 27, 27, 27, 26 };
  private static final Huffman INSTANCE = new Huffman();
  private final Node root = new Node();
  
  private Huffman()
  {
    buildTree();
  }
  
  private void addCode(int paramInt1, int paramInt2, byte paramByte)
  {
    Node localNode1 = new Node(paramInt1, paramByte);
    Node localNode2 = this.root;
    while (paramByte > 8)
    {
      paramByte = (byte)(paramByte - 8);
      paramInt1 = paramInt2 >>> paramByte & 0xFF;
      Node[] arrayOfNode = localNode2.children;
      if (arrayOfNode != null)
      {
        if (arrayOfNode[paramInt1] == null) {
          arrayOfNode[paramInt1] = new Node();
        }
        localNode2 = localNode2.children[paramInt1];
      }
      else
      {
        throw new IllegalStateException("invalid dictionary: prefix not unique");
      }
    }
    paramByte = 8 - paramByte;
    paramInt2 = paramInt2 << paramByte & 0xFF;
    for (paramInt1 = paramInt2; paramInt1 < paramInt2 + (1 << paramByte); paramInt1++) {
      localNode2.children[paramInt1] = localNode1;
    }
  }
  
  private void buildTree()
  {
    for (int i = 0;; i++)
    {
      byte[] arrayOfByte = CODE_LENGTHS;
      if (i >= arrayOfByte.length) {
        break;
      }
      addCode(i, CODES[i], arrayOfByte[i]);
    }
  }
  
  public static Huffman get()
  {
    return INSTANCE;
  }
  
  byte[] decode(byte[] paramArrayOfByte)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    Node localNode1 = this.root;
    int i = 0;
    int j = 0;
    int k = 0;
    Node localNode2;
    int m;
    for (;;)
    {
      localNode2 = localNode1;
      m = k;
      if (i >= paramArrayOfByte.length) {
        break;
      }
      j = j << 8 | paramArrayOfByte[i] & 0xFF;
      k += 8;
      while (k >= 8)
      {
        localNode1 = localNode1.children[(j >>> k - 8 & 0xFF)];
        if (localNode1.children == null)
        {
          localByteArrayOutputStream.write(localNode1.symbol);
          k -= localNode1.terminalBits;
          localNode1 = this.root;
        }
        else
        {
          k -= 8;
        }
      }
      i++;
    }
    while (m > 0)
    {
      paramArrayOfByte = localNode2.children[(j << 8 - m & 0xFF)];
      if ((paramArrayOfByte.children != null) || (paramArrayOfByte.terminalBits > m)) {
        break;
      }
      localByteArrayOutputStream.write(paramArrayOfByte.symbol);
      m -= paramArrayOfByte.terminalBits;
      localNode2 = this.root;
    }
    return localByteArrayOutputStream.toByteArray();
  }
  
  void encode(ByteString paramByteString, BufferedSink paramBufferedSink)
    throws IOException
  {
    int i = 0;
    long l = 0L;
    int j = 0;
    while (i < paramByteString.size())
    {
      int k = paramByteString.getByte(i) & 0xFF;
      int m = CODES[k];
      k = CODE_LENGTHS[k];
      l = l << k | m;
      j += k;
      while (j >= 8)
      {
        j -= 8;
        paramBufferedSink.writeByte((int)(l >> j));
      }
      i++;
    }
    if (j > 0) {
      paramBufferedSink.writeByte((int)(255 >>> j | l << 8 - j));
    }
  }
  
  int encodedLength(ByteString paramByteString)
  {
    long l = 0L;
    for (int i = 0; i < paramByteString.size(); i++)
    {
      int j = paramByteString.getByte(i);
      l += CODE_LENGTHS[(j & 0xFF)];
    }
    return (int)(l + 7L >> 3);
  }
  
  private static final class Node
  {
    final Node[] children;
    final int symbol;
    final int terminalBits;
    
    Node()
    {
      this.children = new Node['??'];
      this.symbol = 0;
      this.terminalBits = 0;
    }
    
    Node(int paramInt1, int paramInt2)
    {
      this.children = null;
      this.symbol = paramInt1;
      paramInt2 &= 0x7;
      paramInt1 = paramInt2;
      if (paramInt2 == 0) {
        paramInt1 = 8;
      }
      this.terminalBits = paramInt1;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\okhttp3\internal\http2\Huffman.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */