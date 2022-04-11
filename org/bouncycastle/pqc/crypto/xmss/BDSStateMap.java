package org.bouncycastle.pqc.crypto.xmss;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.bouncycastle.util.d;

public class BDSStateMap
  implements Serializable
{
  private final Map<Integer, BDS> bdsState = new TreeMap();
  
  BDSStateMap() {}
  
  BDSStateMap(BDSStateMap paramBDSStateMap, m paramm, long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    Iterator localIterator = paramBDSStateMap.bdsState.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      this.bdsState.put(localInteger, paramBDSStateMap.bdsState.get(localInteger));
    }
    updateState(paramm, paramLong, paramArrayOfByte1, paramArrayOfByte2);
  }
  
  BDSStateMap(m paramm, long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    for (long l = 0L; l < paramLong; l += 1L) {
      updateState(paramm, l, paramArrayOfByte1, paramArrayOfByte2);
    }
  }
  
  private void updateState(m paramm, long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    Object localObject = paramm.g();
    int i = ((r)localObject).d();
    long l1 = u.j(paramLong, i);
    int j = u.i(paramLong, i);
    g localg = (g)((g.b)new g.b().h(l1)).p(j).l();
    int k = 1;
    int m = (1 << i) - 1;
    long l2 = l1;
    int n = k;
    if (j < m)
    {
      if ((get(0) == null) || (j == 0)) {
        put(0, new BDS((r)localObject, paramArrayOfByte1, paramArrayOfByte2, localg));
      }
      update(0, paramArrayOfByte1, paramArrayOfByte2, localg);
      n = k;
      l2 = l1;
    }
    while (n < paramm.d())
    {
      k = u.i(l2, i);
      l2 = u.j(l2, i);
      localObject = (g)((g.b)((g.b)new g.b().g(n)).h(l2)).p(k).l();
      if ((k < m) && (u.m(paramLong, i, n)))
      {
        if (get(n) == null) {
          put(n, new BDS(paramm.g(), paramArrayOfByte1, paramArrayOfByte2, (g)localObject));
        }
        update(n, paramArrayOfByte1, paramArrayOfByte2, (g)localObject);
      }
      n++;
    }
  }
  
  public BDS get(int paramInt)
  {
    return (BDS)this.bdsState.get(d.b(paramInt));
  }
  
  public boolean isEmpty()
  {
    return this.bdsState.isEmpty();
  }
  
  public void put(int paramInt, BDS paramBDS)
  {
    this.bdsState.put(d.b(paramInt), paramBDS);
  }
  
  void setXMSS(r paramr)
  {
    Iterator localIterator = this.bdsState.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Integer)localIterator.next();
      localObject = (BDS)this.bdsState.get(localObject);
      ((BDS)localObject).setXMSS(paramr);
      ((BDS)localObject).validate();
    }
  }
  
  public BDS update(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, g paramg)
  {
    return (BDS)this.bdsState.put(d.b(paramInt), ((BDS)this.bdsState.get(d.b(paramInt))).getNextState(paramArrayOfByte1, paramArrayOfByte2, paramg));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\pqc\crypto\xmss\BDSStateMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */