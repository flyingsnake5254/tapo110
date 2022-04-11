package com.tplink.iot.e.a;

import com.bumptech.glide.load.j.g;
import com.tplink.iot.dailysummary.model.SummaryClipItem;
import com.tplink.iot.dailysummary.network.bean.common.SummaryClip;

public final class b
  extends g
{
  private String i;
  
  public b(SummaryClipItem paramSummaryClipItem)
  {
    super((String)localObject);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramSummaryClipItem.getUuid());
    ((StringBuilder)localObject).append(paramSummaryClipItem.getSplitPoint());
    this.i = ((StringBuilder)localObject).toString();
  }
  
  public b(SummaryClip paramSummaryClip) {}
  
  public String c()
  {
    return this.i;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\e\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */