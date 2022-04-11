package b.d.c0.m;

import com.tplink.tdp.tlv.adapter.CollectionAdapterFactory;
import com.tplink.tdp.tlv.adapter.TLVAdapters;
import com.tplink.tdp.tlv.adapter.TLVStructureAdapterFactory;
import com.tplink.tdp.tlv.adapter.c;
import com.tplink.tdp.tlv.adapter.d;
import com.tplink.tdp.tlv.adapter.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class a
{
  private final Map<e<?>, c<?>> a = new ConcurrentHashMap();
  private List<d> b = new ArrayList();
  private short[] c;
  
  public a()
  {
    com.tplink.tdp.tlv.adapter.a locala = new com.tplink.tdp.tlv.adapter.a();
    this.b.add(TLVAdapters.b);
    this.b.add(TLVAdapters.d);
    this.b.add(TLVAdapters.n);
    this.b.add(TLVAdapters.p);
    this.b.add(TLVAdapters.j);
    this.b.add(TLVAdapters.l);
    this.b.add(TLVAdapters.f);
    this.b.add(TLVAdapters.h);
    this.b.add(TLVAdapters.r);
    this.b.add(TLVAdapters.t);
    this.b.add(new CollectionAdapterFactory(locala));
    this.b.add(new TLVStructureAdapterFactory(locala));
  }
  
  public <T> T a(byte[] paramArrayOfByte, Class<T> paramClass)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
    {
      paramArrayOfByte = new b.d.c0.m.e.a(paramArrayOfByte);
      paramClass = b(new e(paramClass));
      if (paramClass != null) {
        return (T)paramClass.a(paramArrayOfByte);
      }
    }
    return null;
  }
  
  public <T> c<T> b(e<T> parame)
  {
    c localc = (c)this.a.get(parame);
    if (localc != null) {
      return localc;
    }
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      localc = ((d)localIterator.next()).a(this, parame);
      if (localc != null)
      {
        this.a.put(parame, localc);
        return localc;
      }
    }
    return null;
  }
  
  public short[] c()
  {
    return this.c;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\c0\m\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */