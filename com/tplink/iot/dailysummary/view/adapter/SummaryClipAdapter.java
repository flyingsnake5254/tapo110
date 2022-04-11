package com.tplink.iot.dailysummary.view.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tplink.iot.Utils.q0;
import com.tplink.iot.dailysummary.model.SummaryClipItem;
import com.tplink.iot.dailysummary.network.bean.common.SummaryClip;
import com.tplink.iot.dailysummary.network.bean.common.SummaryClipVideo;
import com.tplink.iot.dailysummary.network.bean.common.SummaryImage;
import com.tplink.iot.dailysummary.view.SummaryClipListActivity;
import com.tplink.iot.dailysummary.view.viewhodlder.SummaryClipTitleViewHolder;
import com.tplink.iot.dailysummary.view.viewhodlder.SummaryClipVideoViewHolder;
import com.tplink.iot.databinding.ItemSummaryClipTitleBinding;
import com.tplink.iot.databinding.ItemSummaryClipVideoBinding;
import com.tplink.iot.e.a.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.j;
import kotlin.text.m;

public final class SummaryClipAdapter
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  public static final a a = new a(null);
  private final Context b;
  private ArrayList<SummaryClipItem> c;
  private int d;
  
  public SummaryClipAdapter(Context paramContext, int paramInt)
  {
    this.b = paramContext;
    this.d = -1;
    p(paramInt);
  }
  
  private final void o(int paramInt)
  {
    int i = this.d;
    if (paramInt == i) {
      return;
    }
    if (i >= 0)
    {
      localObject = this.c;
      if (localObject == null) {
        j.t("mSummaryClipAdapterList");
      }
      ((SummaryClipItem)((ArrayList)localObject).get(this.d)).setChoosed(false);
      notifyItemChanged(this.d);
    }
    this.d = paramInt;
    Object localObject = this.c;
    if (localObject == null) {
      j.t("mSummaryClipAdapterList");
    }
    localObject = ((ArrayList)localObject).get(paramInt);
    j.d(localObject, "mSummaryClipAdapterList[newIndex]");
    localObject = (SummaryClipItem)localObject;
    ((SummaryClipItem)localObject).setChoosed(true);
    notifyItemChanged(paramInt);
    SummaryClipVideo localSummaryClipVideo = ((SummaryClipItem)localObject).getVideo();
    if ((localSummaryClipVideo != null) && (!TextUtils.isEmpty(localSummaryClipVideo.getUri())) && (!TextUtils.isEmpty(localSummaryClipVideo.getM3u8())))
    {
      localObject = this.b;
      Objects.requireNonNull(localObject, "null cannot be cast to non-null type com.tplink.iot.dailysummary.view.SummaryClipListActivity");
      ((SummaryClipListActivity)localObject).B1(localSummaryClipVideo);
    }
  }
  
  private final void p(int paramInt)
  {
    this.c = new ArrayList();
    List localList = c.k.h();
    if (localList == null) {
      return;
    }
    int i = -1;
    int j = localList.size() - 1;
    if (j >= 0) {
      for (int k = 0;; k++)
      {
        Object localObject1 = (SummaryClip)localList.get(k);
        if ((!TextUtils.isEmpty(((SummaryClip)localObject1).getUuid())) && (!TextUtils.isEmpty(((SummaryClip)localObject1).getEventLocalTime())) && (((SummaryClip)localObject1).getVideo() != null) && (((SummaryClip)localObject1).getVideo().size() != 0) && (((SummaryClip)localObject1).getImage() != null) && (((SummaryClip)localObject1).getImage().size() != 0))
        {
          Object localObject2 = ((SummaryClip)localObject1).getEventLocalTime();
          j.d(localObject2, "clip.eventLocalTime");
          int m = q((String)localObject2);
          int n = i;
          if (i != m)
          {
            localObject2 = this.c;
            if (localObject2 == null) {
              j.t("mSummaryClipAdapterList");
            }
            localObject3 = q0.a(m);
            j.d(localObject3, "TimeUtils.generateDisplayHour(hour)");
            ((ArrayList)localObject2).add(new SummaryClipItem(null, null, 0L, null, null, false, 1, (String)localObject3, 63, null));
            n = m;
          }
          SummaryImage localSummaryImage = (SummaryImage)((SummaryClip)localObject1).getImage().get(0);
          Object localObject3 = (SummaryClipVideo)((SummaryClip)localObject1).getVideo().get(0);
          if ((localSummaryImage != null) && (localObject3 != null))
          {
            String str = ((SummaryClip)localObject1).getUuid();
            j.d(str, "clip.uuid");
            localObject2 = ((SummaryClip)localObject1).getEventLocalTime();
            j.d(localObject2, "clip.eventLocalTime");
            localObject1 = ((SummaryClip)localObject1).getSplitPoint();
            j.d(localObject1, "clip.splitPoint");
            localObject1 = new SummaryClipItem(str, (String)localObject2, ((Long)localObject1).longValue(), (SummaryClipVideo)localObject3, localSummaryImage, false, 0, null, 224, null);
            localObject2 = this.c;
            if (localObject2 == null) {
              j.t("mSummaryClipAdapterList");
            }
            ((ArrayList)localObject2).add(localObject1);
            i = n;
            if (k == paramInt)
            {
              localObject2 = this.c;
              if (localObject2 == null) {
                j.t("mSummaryClipAdapterList");
              }
              o(((ArrayList)localObject2).indexOf(localObject1));
              i = n;
            }
          }
          else
          {
            i = n;
          }
        }
        if (k == j) {
          break;
        }
      }
    }
  }
  
  private final int q(String paramString)
  {
    paramString = m.f0(paramString, new String[] { " " }, false, 0, 6, null).toArray(new String[0]);
    Objects.requireNonNull(paramString, "null cannot be cast to non-null type kotlin.Array<T>");
    paramString = (String[])paramString;
    int i = paramString.length;
    int j = -1;
    int k = j;
    if (i == 2)
    {
      paramString = m.f0(paramString[1], new String[] { ":" }, false, 0, 6, null).toArray(new String[0]);
      Objects.requireNonNull(paramString, "null cannot be cast to non-null type kotlin.Array<T>");
      paramString = (String[])paramString;
      k = j;
      if (paramString.length == 3) {
        k = Integer.parseInt(paramString[0]);
      }
    }
    return k;
  }
  
  public int getItemCount()
  {
    ArrayList localArrayList = this.c;
    if (localArrayList == null) {
      j.t("mSummaryClipAdapterList");
    }
    return localArrayList.size();
  }
  
  public int getItemViewType(int paramInt)
  {
    ArrayList localArrayList = this.c;
    if (localArrayList == null) {
      j.t("mSummaryClipAdapterList");
    }
    return ((SummaryClipItem)localArrayList.get(paramInt)).getType();
  }
  
  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView)
  {
    j.e(paramRecyclerView, "recyclerView");
    paramRecyclerView = (GridLayoutManager)paramRecyclerView.getLayoutManager();
    if (paramRecyclerView != null) {
      paramRecyclerView.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup()
      {
        public int getSpanSize(int paramAnonymousInt)
        {
          if (((SummaryClipItem)SummaryClipAdapter.n(this.a).get(paramAnonymousInt)).getType() == 2) {
            return 1;
          }
          return 2;
        }
      });
    }
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    j.e(paramViewHolder, "holder");
    Object localObject = this.c;
    if (localObject == null) {
      j.t("mSummaryClipAdapterList");
    }
    if (((ArrayList)localObject).size() == 0) {
      return;
    }
    if ((paramViewHolder instanceof SummaryClipTitleViewHolder))
    {
      paramViewHolder = (SummaryClipTitleViewHolder)paramViewHolder;
      localObject = this.c;
      if (localObject == null) {
        j.t("mSummaryClipAdapterList");
      }
      paramViewHolder.c(((SummaryClipItem)((ArrayList)localObject).get(paramInt)).getDisplayHour());
    }
    else
    {
      paramViewHolder = (SummaryClipVideoViewHolder)paramViewHolder;
      localObject = this.c;
      if (localObject == null) {
        j.t("mSummaryClipAdapterList");
      }
      localObject = ((ArrayList)localObject).get(paramInt);
      j.d(localObject, "mSummaryClipAdapterList[position]");
      paramViewHolder.c((SummaryClipItem)localObject);
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    j.e(paramViewGroup, "parent");
    if (paramInt != 1)
    {
      paramViewGroup = (ItemSummaryClipVideoBinding)DataBindingUtil.inflate(LayoutInflater.from(this.b), 2131559089, paramViewGroup, false);
      j.d(paramViewGroup, "binding");
      paramViewGroup = new SummaryClipVideoViewHolder(paramViewGroup);
      paramViewGroup.itemView.setOnClickListener(new b(paramViewGroup, this));
    }
    else
    {
      paramViewGroup = (ItemSummaryClipTitleBinding)DataBindingUtil.inflate(LayoutInflater.from(this.b), 2131559088, paramViewGroup, false);
      j.d(paramViewGroup, "binding");
      paramViewGroup = new SummaryClipTitleViewHolder(paramViewGroup);
    }
    return paramViewGroup;
  }
  
  public final int r()
  {
    return this.d;
  }
  
  public static final class a {}
  
  static final class b
    implements View.OnClickListener
  {
    b(SummaryClipVideoViewHolder paramSummaryClipVideoViewHolder, SummaryClipAdapter paramSummaryClipAdapter) {}
    
    public final void onClick(View paramView)
    {
      SummaryClipAdapter.m(jdField_this, this.c.getBindingAdapterPosition());
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\dailysummary\view\adapter\SummaryClipAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */