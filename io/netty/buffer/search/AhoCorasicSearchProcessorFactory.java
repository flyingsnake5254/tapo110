package io.netty.buffer.search;

import io.netty.util.internal.PlatformDependent;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class AhoCorasicSearchProcessorFactory
  extends AbstractMultiSearchProcessorFactory
{
  static final int ALPHABET_SIZE = 256;
  static final int BITS_PER_SYMBOL = 8;
  private final int[] jumpTable;
  private final int[] matchForNeedleId;
  
  AhoCorasicSearchProcessorFactory(byte[]... paramVarArgs)
  {
    int i = paramVarArgs.length;
    int j = 0;
    int k = 0;
    while (k < i) {
      if (paramVarArgs[k].length != 0) {
        k++;
      } else {
        throw new IllegalArgumentException("Needle must be non empty");
      }
    }
    paramVarArgs = buildTrie(paramVarArgs);
    this.jumpTable = paramVarArgs.jumpTable;
    this.matchForNeedleId = paramVarArgs.matchForNeedleId;
    linkSuffixes();
    for (k = j;; k++)
    {
      paramVarArgs = this.jumpTable;
      if (k >= paramVarArgs.length) {
        break;
      }
      if (this.matchForNeedleId[(paramVarArgs[k] >> 8)] >= 0) {
        paramVarArgs[k] = (-paramVarArgs[k]);
      }
    }
  }
  
  private static Context buildTrie(byte[][] paramArrayOfByte)
  {
    ArrayList localArrayList1 = new ArrayList(256);
    int i = 0;
    for (int j = 0; j < 256; j++) {
      localArrayList1.add(Integer.valueOf(-1));
    }
    ArrayList localArrayList2 = new ArrayList();
    localArrayList2.add(Integer.valueOf(-1));
    for (j = 0; j < paramArrayOfByte.length; j++)
    {
      byte[] arrayOfByte = paramArrayOfByte[j];
      int k = arrayOfByte.length;
      int m = 0;
      int n = 0;
      while (m < k)
      {
        int i1 = n + (arrayOfByte[m] & 0xFF);
        if (((Integer)localArrayList1.get(i1)).intValue() == -1)
        {
          localArrayList1.set(i1, Integer.valueOf(localArrayList1.size()));
          for (n = 0; n < 256; n++) {
            localArrayList1.add(Integer.valueOf(-1));
          }
          localArrayList2.add(Integer.valueOf(-1));
        }
        n = ((Integer)localArrayList1.get(i1)).intValue();
        m++;
      }
      localArrayList2.set(n >> 8, Integer.valueOf(j));
    }
    paramArrayOfByte = new Context(null);
    paramArrayOfByte.jumpTable = new int[localArrayList1.size()];
    for (j = 0; j < localArrayList1.size(); j++) {
      paramArrayOfByte.jumpTable[j] = ((Integer)localArrayList1.get(j)).intValue();
    }
    paramArrayOfByte.matchForNeedleId = new int[localArrayList2.size()];
    for (j = i; j < localArrayList2.size(); j++) {
      paramArrayOfByte.matchForNeedleId[j] = ((Integer)localArrayList2.get(j)).intValue();
    }
    return paramArrayOfByte;
  }
  
  private void linkSuffixes()
  {
    ArrayDeque localArrayDeque = new ArrayDeque();
    localArrayDeque.add(Integer.valueOf(0));
    int[] arrayOfInt1 = new int[this.matchForNeedleId.length];
    Arrays.fill(arrayOfInt1, -1);
    while (!localArrayDeque.isEmpty())
    {
      int i = ((Integer)localArrayDeque.remove()).intValue();
      int j = i >> 8;
      int k;
      if (arrayOfInt1[j] == -1) {
        k = 0;
      } else {
        k = arrayOfInt1[j];
      }
      int[] arrayOfInt2 = this.matchForNeedleId;
      if (arrayOfInt2[j] == -1) {
        arrayOfInt2[j] = arrayOfInt2[(k >> 8)];
      }
      for (j = 0; j < 256; j++)
      {
        int m = i | j;
        arrayOfInt2 = this.jumpTable;
        int n = arrayOfInt2[m];
        int i1 = arrayOfInt2[(k | j)];
        if (n != -1)
        {
          if ((i <= 0) || (i1 == -1)) {
            i1 = 0;
          }
          arrayOfInt1[(n >> 8)] = i1;
          localArrayDeque.add(Integer.valueOf(n));
        }
        else
        {
          if (i1 == -1) {
            i1 = 0;
          }
          arrayOfInt2[m] = i1;
        }
      }
    }
  }
  
  public Processor newSearchProcessor()
  {
    return new Processor(this.jumpTable, this.matchForNeedleId);
  }
  
  private static class Context
  {
    int[] jumpTable;
    int[] matchForNeedleId;
  }
  
  public static class Processor
    implements MultiSearchProcessor
  {
    private long currentPosition;
    private final int[] jumpTable;
    private final int[] matchForNeedleId;
    
    Processor(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
    {
      this.jumpTable = paramArrayOfInt1;
      this.matchForNeedleId = paramArrayOfInt2;
    }
    
    public int getFoundNeedleId()
    {
      return this.matchForNeedleId[((int)this.currentPosition >> 8)];
    }
    
    public boolean process(byte paramByte)
    {
      long l = PlatformDependent.getInt(this.jumpTable, this.currentPosition | paramByte & 0xFF);
      this.currentPosition = l;
      if (l < 0L)
      {
        this.currentPosition = (-l);
        return false;
      }
      return true;
    }
    
    public void reset()
    {
      this.currentPosition = 0L;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\buffer\search\AhoCorasicSearchProcessorFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */