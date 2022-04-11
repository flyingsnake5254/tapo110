package com.tplink.iot.dailysummary.view.adapter;

import androidx.databinding.BindingAdapter;
import com.tplink.iot.dailysummary.widget.SummaryTimeAxisLayout;
import com.tplink.iot.dailysummary.widget.SummaryTimeAxisLayout.b;
import java.util.ArrayList;
import java.util.LinkedList;
import kotlin.jvm.internal.j;

public final class c
{
  public static final c a = new c();
  
  @BindingAdapter({"summary_clip_split_point_list"})
  public static final void a(SummaryTimeAxisLayout paramSummaryTimeAxisLayout, ArrayList<Long> paramArrayList)
  {
    j.e(paramSummaryTimeAxisLayout, "timeAxisLayout");
    if (paramArrayList != null) {
      paramSummaryTimeAxisLayout.setClipSplitPointList(paramArrayList);
    }
  }
  
  @BindingAdapter({"summary_clip_hightlight"})
  public static final void b(SummaryTimeAxisLayout paramSummaryTimeAxisLayout, boolean paramBoolean)
  {
    j.e(paramSummaryTimeAxisLayout, "timeAxisLayout");
    paramSummaryTimeAxisLayout.e(paramBoolean);
  }
  
  @BindingAdapter({"summary_thumbnail_list"})
  public static final void c(SummaryTimeAxisLayout paramSummaryTimeAxisLayout, LinkedList<com.tplink.iot.dailysummary.model.c> paramLinkedList)
  {
    j.e(paramSummaryTimeAxisLayout, "timeAxisLayout");
    if (paramLinkedList != null) {
      paramSummaryTimeAxisLayout.setThumbnailList(paramLinkedList);
    }
  }
  
  @BindingAdapter({"player_currentTime"})
  public static final void d(SummaryTimeAxisLayout paramSummaryTimeAxisLayout, long paramLong)
  {
    j.e(paramSummaryTimeAxisLayout, "timeAxisLayout");
    paramSummaryTimeAxisLayout.setPlayerCurrentTime(paramLong);
  }
  
  @BindingAdapter({"summary_duration"})
  public static final void e(SummaryTimeAxisLayout paramSummaryTimeAxisLayout, Long paramLong)
  {
    j.e(paramSummaryTimeAxisLayout, "timeAxisLayout");
    if (paramLong != null) {
      paramSummaryTimeAxisLayout.setSummaryDuration(paramLong.longValue());
    }
  }
  
  @BindingAdapter({"time_changed_listener"})
  public static final void f(SummaryTimeAxisLayout paramSummaryTimeAxisLayout, SummaryTimeAxisLayout.b paramb)
  {
    j.e(paramSummaryTimeAxisLayout, "timeAxisLayout");
    paramSummaryTimeAxisLayout.setOnTimeChangedListener(paramb);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\dailysummary\view\adapter\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */