package com.tplink.iot.adapter.smart;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tplink.iot.devicecommon.adapter.SingleCheckMarkAdapter;
import com.tplink.iot.devicecommon.adapter.SingleCheckMarkViewHolder;
import com.tplink.iot.model.smart.a;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.j;

public final class DeviceTriggerSingleChoiceAdapter
  extends SingleCheckMarkAdapter<a>
{
  public DeviceTriggerSingleChoiceAdapter(Context paramContext, List<a> paramList)
  {
    super(paramContext, paramList, 0);
  }
  
  public void A(SingleCheckMarkViewHolder paramSingleCheckMarkViewHolder, a parama, int paramInt)
  {
    j.e(paramSingleCheckMarkViewHolder, "holder");
    j.e(parama, "data");
    paramSingleCheckMarkViewHolder.d().setText(parama.e());
    TextView localTextView = (TextView)paramSingleCheckMarkViewHolder.e(2131364655);
    if (localTextView != null)
    {
      localObject = parama.c();
      int i = 0;
      if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
        paramInt = 0;
      } else {
        paramInt = 1;
      }
      if ((paramInt ^ 0x1) != 0) {
        paramInt = i;
      } else {
        paramInt = 8;
      }
      localTextView.setVisibility(paramInt);
      localObject = parama.c();
      if (localObject == null) {
        localObject = "";
      }
      localTextView.setText((CharSequence)localObject);
    }
    Object localObject = paramSingleCheckMarkViewHolder.itemView;
    j.d(localObject, "holder.itemView");
    ((View)localObject).setEnabled(parama.b());
    paramSingleCheckMarkViewHolder = paramSingleCheckMarkViewHolder.itemView;
    j.d(paramSingleCheckMarkViewHolder, "holder.itemView");
    float f;
    if (parama.b()) {
      f = 1.0F;
    } else {
      f = 0.5F;
    }
    paramSingleCheckMarkViewHolder.setAlpha(f);
  }
  
  public final void B(String paramString, Object paramObject)
  {
    j.e(paramString, "id");
    Iterator localIterator = q().iterator();
    for (int i = 0; localIterator.hasNext(); i++)
    {
      a locala = (a)localIterator.next();
      int j;
      if ((j.a(locala.d(), paramString)) && (j.a(locala.a(), paramObject))) {
        j = 1;
      } else {
        j = 0;
      }
      if (j != 0) {
        break label89;
      }
    }
    i = -1;
    label89:
    if (i != -1) {
      z(i);
    }
  }
  
  public SingleCheckMarkViewHolder w(ViewGroup paramViewGroup, int paramInt)
  {
    j.e(paramViewGroup, "parent");
    paramViewGroup = r().inflate(2131559083, paramViewGroup, false);
    j.d(paramViewGroup, "mInflater.inflate(R.layo…_subtitle, parent, false)");
    return new SingleCheckMarkViewHolder(paramViewGroup);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\adapter\smart\DeviceTriggerSingleChoiceAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */