package com.tplink.tdp.bean;

import b.d.c0.m.e.a;
import com.tplink.tdp.tlv.adapter.c;

public class TDPTLVDevice$ByteToBoolAdapter2
  extends c<Boolean>
{
  public Boolean b(a parama)
  {
    parama = parama.e();
    boolean bool = true;
    if ((parama == null) || (parama.byteValue() != 1)) {
      bool = false;
    }
    return Boolean.valueOf(bool);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\tdp\bean\TDPTLVDevice$ByteToBoolAdapter2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */