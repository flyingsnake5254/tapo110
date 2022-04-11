package com.tplink.tdp.bean;

import b.d.c0.m.e.a;
import b.d.w.e.b;
import com.tplink.tdp.tlv.adapter.IPAdapter;

public class TDPTLVDevice$CompatSubnetMaskAdapter
  extends IPAdapter
{
  public String b(a parama)
  {
    String str = super.b(parama);
    Object localObject = str;
    if (str != null)
    {
      localObject = str;
      if (!b.d(str))
      {
        localObject = str.split("\\.");
        if (localObject.length == 4)
        {
          parama = new StringBuilder();
          parama.append(localObject[3]);
          parama.append(".");
          parama.append(localObject[2]);
          parama.append(".");
          parama.append(localObject[1]);
          parama.append(".");
          parama.append(localObject[0]);
          parama = parama.toString();
        }
        else
        {
          parama = "";
        }
        localObject = str;
        if (b.d(parama)) {
          localObject = parama;
        }
      }
    }
    return (String)localObject;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\tdp\bean\TDPTLVDevice$CompatSubnetMaskAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */