package com.tplink.tdp.bean;

import b.d.c0.m.e.a;
import com.tplink.tdp.tlv.adapter.c;

public class TDPTLVDevice$ByteToBoolAdapter
  extends c<Boolean>
{
  public Boolean b(a parama)
  {
    parama = parama.e();
    boolean bool;
    if ((parama != null) && (parama.byteValue() != 0)) {
      bool = true;
    } else {
      bool = false;
    }
    return Boolean.valueOf(bool);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\tdp\bean\TDPTLVDevice$ByteToBoolAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */