package com.tplink.cloud.bean.push;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.a;
import com.google.gson.stream.b;
import com.tplink.cloud.bean.push.params.SubscribeItemParams;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SubscribeMessageAdapter
  extends TypeAdapter<List<SubscribeItemParams>>
{
  private static final String SUBSCRIBE_MESSAGE_SEPARATOR = ":";
  
  public List<SubscribeItemParams> read(a parama)
    throws IOException
  {
    HashMap localHashMap = new HashMap();
    parama.a();
    while (parama.s())
    {
      Object localObject = parama.E();
      if (((String)localObject).contains(":"))
      {
        String[] arrayOfString = ((String)localObject).split(":");
        SubscribeItemParams localSubscribeItemParams = (SubscribeItemParams)localHashMap.get(arrayOfString[0]);
        localObject = localSubscribeItemParams;
        if (localSubscribeItemParams == null)
        {
          localObject = new SubscribeItemParams();
          ((SubscribeItemParams)localObject).setDeviceId(arrayOfString[0]);
          localHashMap.put(arrayOfString[0], localObject);
        }
        ((SubscribeItemParams)localObject).addMessageType(arrayOfString[1]);
      }
    }
    parama.E();
    parama.j();
    return new ArrayList(localHashMap.values());
  }
  
  public void write(b paramb, List<SubscribeItemParams> paramList)
    throws IOException
  {
    paramb.e();
    Iterator localIterator1 = paramList.iterator();
    while (localIterator1.hasNext())
    {
      SubscribeItemParams localSubscribeItemParams = (SubscribeItemParams)localIterator1.next();
      Iterator localIterator2 = localSubscribeItemParams.getMessageTypeList().iterator();
      while (localIterator2.hasNext())
      {
        paramList = (String)localIterator2.next();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(localSubscribeItemParams.getDeviceId());
        localStringBuilder.append(":");
        localStringBuilder.append(paramList);
        paramb.J(localStringBuilder.toString());
      }
    }
    paramb.j();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\cloud\bean\push\SubscribeMessageAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */