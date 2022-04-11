package okio;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class Options
  extends AbstractList<ByteString>
  implements RandomAccess
{
  final ByteString[] byteStrings;
  final int[] trie;
  
  private Options(ByteString[] paramArrayOfByteString, int[] paramArrayOfInt)
  {
    this.byteStrings = paramArrayOfByteString;
    this.trie = paramArrayOfInt;
  }
  
  private static void buildTrieRecursive(long paramLong, Buffer paramBuffer, int paramInt1, List<ByteString> paramList, int paramInt2, int paramInt3, List<Integer> paramList1)
  {
    int i = paramInt2;
    if (i < paramInt3)
    {
      int j = i;
      while (j < paramInt3) {
        if (((ByteString)paramList.get(j)).size() >= paramInt1) {
          j++;
        } else {
          throw new AssertionError();
        }
      }
      ByteString localByteString1 = (ByteString)paramList.get(paramInt2);
      ByteString localByteString2 = (ByteString)paramList.get(paramInt3 - 1);
      j = -1;
      paramInt2 = i;
      Object localObject = localByteString1;
      if (paramInt1 == localByteString1.size())
      {
        j = ((Integer)paramList1.get(i)).intValue();
        paramInt2 = i + 1;
        localObject = (ByteString)paramList.get(paramInt2);
      }
      int k;
      int m;
      if (((ByteString)localObject).getByte(paramInt1) != localByteString2.getByte(paramInt1))
      {
        i = paramInt2 + 1;
        for (k = 1; i < paramInt3; k = m)
        {
          m = k;
          if (((ByteString)paramList.get(i - 1)).getByte(paramInt1) != ((ByteString)paramList.get(i)).getByte(paramInt1)) {
            m = k + 1;
          }
          i++;
        }
        paramLong = paramLong + intCount(paramBuffer) + 2L + k * 2;
        paramBuffer.writeInt(k);
        paramBuffer.writeInt(j);
        for (i = paramInt2; i < paramInt3; i++)
        {
          j = ((ByteString)paramList.get(i)).getByte(paramInt1);
          if ((i == paramInt2) || (j != ((ByteString)paramList.get(i - 1)).getByte(paramInt1))) {
            paramBuffer.writeInt(j & 0xFF);
          }
        }
        localObject = new Buffer();
        for (i = paramInt2; i < paramInt3; i = paramInt2)
        {
          m = ((ByteString)paramList.get(i)).getByte(paramInt1);
          j = i + 1;
          for (paramInt2 = j; paramInt2 < paramInt3; paramInt2++) {
            if (m != ((ByteString)paramList.get(paramInt2)).getByte(paramInt1)) {
              break label427;
            }
          }
          paramInt2 = paramInt3;
          label427:
          if ((j == paramInt2) && (paramInt1 + 1 == ((ByteString)paramList.get(i)).size()))
          {
            paramBuffer.writeInt(((Integer)paramList1.get(i)).intValue());
          }
          else
          {
            paramBuffer.writeInt((int)((intCount((Buffer)localObject) + paramLong) * -1L));
            buildTrieRecursive(paramLong, (Buffer)localObject, paramInt1 + 1, paramList, i, paramInt2, paramList1);
          }
        }
        paramBuffer.write((Buffer)localObject, ((Buffer)localObject).size());
      }
      else
      {
        i = 0;
        k = Math.min(((ByteString)localObject).size(), localByteString2.size());
        for (m = paramInt1; (m < k) && (((ByteString)localObject).getByte(m) == localByteString2.getByte(m)); m++) {
          i++;
        }
        paramLong = 1L + (paramLong + intCount(paramBuffer) + 2L + i);
        paramBuffer.writeInt(-i);
        paramBuffer.writeInt(j);
        for (j = paramInt1;; j++)
        {
          m = paramInt1 + i;
          if (j >= m) {
            break;
          }
          paramBuffer.writeInt(((ByteString)localObject).getByte(j) & 0xFF);
        }
        if (paramInt2 + 1 == paramInt3)
        {
          if (m == ((ByteString)paramList.get(paramInt2)).size()) {
            paramBuffer.writeInt(((Integer)paramList1.get(paramInt2)).intValue());
          } else {
            throw new AssertionError();
          }
        }
        else
        {
          localObject = new Buffer();
          paramBuffer.writeInt((int)((intCount((Buffer)localObject) + paramLong) * -1L));
          buildTrieRecursive(paramLong, (Buffer)localObject, m, paramList, paramInt2, paramInt3, paramList1);
          paramBuffer.write((Buffer)localObject, ((Buffer)localObject).size());
        }
      }
      return;
    }
    throw new AssertionError();
  }
  
  private static int intCount(Buffer paramBuffer)
  {
    return (int)(paramBuffer.size() / 4L);
  }
  
  public static Options of(ByteString... paramVarArgs)
  {
    int i = paramVarArgs.length;
    int j = 0;
    if (i == 0) {
      return new Options(new ByteString[0], new int[] { 0, -1 });
    }
    ArrayList localArrayList = new ArrayList(Arrays.asList(paramVarArgs));
    Collections.sort(localArrayList);
    Object localObject1 = new ArrayList();
    for (i = 0; i < localArrayList.size(); i++) {
      ((List)localObject1).add(Integer.valueOf(-1));
    }
    for (i = 0; i < localArrayList.size(); i++) {
      ((List)localObject1).set(Collections.binarySearch(localArrayList, paramVarArgs[i]), Integer.valueOf(i));
    }
    if (((ByteString)localArrayList.get(0)).size() != 0)
    {
      for (i = 0; i < localArrayList.size(); i = k)
      {
        ByteString localByteString = (ByteString)localArrayList.get(i);
        k = i + 1;
        int m = k;
        while (m < localArrayList.size())
        {
          localObject2 = (ByteString)localArrayList.get(m);
          if (((ByteString)localObject2).startsWith(localByteString)) {
            if (((ByteString)localObject2).size() != localByteString.size())
            {
              if (((Integer)((List)localObject1).get(m)).intValue() > ((Integer)((List)localObject1).get(i)).intValue())
              {
                localArrayList.remove(m);
                ((List)localObject1).remove(m);
              }
              else
              {
                m++;
              }
            }
            else
            {
              paramVarArgs = new StringBuilder();
              paramVarArgs.append("duplicate option: ");
              paramVarArgs.append(localObject2);
              throw new IllegalArgumentException(paramVarArgs.toString());
            }
          }
        }
      }
      Object localObject2 = new Buffer();
      buildTrieRecursive(0L, (Buffer)localObject2, 0, localArrayList, 0, localArrayList.size(), (List)localObject1);
      int k = intCount((Buffer)localObject2);
      localObject1 = new int[k];
      for (i = j; i < k; i++) {
        localObject1[i] = ((Buffer)localObject2).readInt();
      }
      if (((Buffer)localObject2).exhausted()) {
        return new Options((ByteString[])paramVarArgs.clone(), (int[])localObject1);
      }
      throw new AssertionError();
    }
    throw new IllegalArgumentException("the empty byte string is not a supported option");
  }
  
  public ByteString get(int paramInt)
  {
    return this.byteStrings[paramInt];
  }
  
  public final int size()
  {
    return this.byteStrings.length;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\okio\Options.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */