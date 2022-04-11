package com.tplink.iot.adapter.cloudvideo;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.bumptech.glide.c;
import com.bumptech.glide.h;
import com.bumptech.glide.i;
import com.bumptech.glide.load.engine.j;
import com.bumptech.glide.request.a;
import com.bumptech.glide.request.g;
import com.tplink.iot.Utils.q0;
import com.tplink.iot.Utils.x0.w;
import com.tplink.iot.cloud.bean.cloudvideo.common.CloudVideo;
import com.tplink.iot.cloud.bean.cloudvideo.common.CloudVideoThumbnail;
import com.tplink.iot.model.cloudvideo.CloudVideoItem;
import com.tplink.iot.view.cloudvideo.o;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class CloudVideoListAdapter
  extends RecyclerView.Adapter
{
  private final int a = 0;
  private final int b = 1;
  private final int c = 2;
  private final int d = -1;
  private final int e = -1;
  private final Set<CloudVideoItem> f;
  protected int g;
  protected b h;
  protected c i;
  private Context j;
  private d k;
  private List<CloudVideoItem> l = new ArrayList();
  private List<CloudVideoItem> m = new ArrayList();
  private List<Integer> n = new ArrayList();
  private List<CloudVideoItem> o = new ArrayList();
  private String p;
  private boolean q = false;
  private boolean r = false;
  private g s;
  private boolean t = false;
  private String u = "";
  
  public CloudVideoListAdapter(Context paramContext, boolean paramBoolean)
  {
    this.j = paramContext;
    this.f = Collections.synchronizedSet(new HashSet());
    this.g = 0;
    this.r = paramBoolean;
    this.s = ((g)((g)((g)new g().V(2131689581)).j(2131689581)).f(j.d));
  }
  
  private Map<Integer, List<CloudVideoItem>> A(List<CloudVideoItem> paramList)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        CloudVideoItem localCloudVideoItem = (CloudVideoItem)paramList.next();
        if (localCloudVideoItem.getType() == 0)
        {
          if (!this.r)
          {
            localLinkedHashMap.put(Integer.valueOf(-1), Collections.singletonList(localCloudVideoItem));
            this.q = true;
          }
        }
        else
        {
          int i1 = v(localCloudVideoItem);
          Object localObject = (List)localLinkedHashMap.get(Integer.valueOf(i1));
          if ((localObject != null) && (!((List)localObject).isEmpty()))
          {
            ((List)localObject).add(localCloudVideoItem);
          }
          else
          {
            localObject = new ArrayList();
            ((List)localObject).add(localCloudVideoItem);
            localLinkedHashMap.put(Integer.valueOf(i1), localObject);
          }
        }
      }
    }
    return localLinkedHashMap;
  }
  
  private void D()
  {
    O();
    notifyDataSetChanged();
  }
  
  private boolean F(int paramInt)
  {
    return this.f.remove(this.m.get(paramInt));
  }
  
  private void O()
  {
    Object localObject1 = this.l;
    if (localObject1 == null) {
      return;
    }
    Map localMap = A((List)localObject1);
    this.m.clear();
    this.n.clear();
    this.o.clear();
    localObject1 = localMap.entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
      if (((Integer)((Map.Entry)localObject2).getKey()).intValue() == -1)
      {
        if (localMap.size() <= 1) {
          break;
        }
        this.m.add(((List)((Map.Entry)localObject2).getValue()).get(0));
        this.n.add(Integer.valueOf(-1));
      }
      else
      {
        this.m.add(null);
        this.n.add(((Map.Entry)localObject2).getKey());
        localObject2 = ((List)((Map.Entry)localObject2).getValue()).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          CloudVideoItem localCloudVideoItem = (CloudVideoItem)((Iterator)localObject2).next();
          this.m.add(localCloudVideoItem);
          this.n.add(Integer.valueOf(-1));
          this.o.add(localCloudVideoItem);
        }
      }
    }
  }
  
  private boolean s(int paramInt)
  {
    return this.f.add(this.m.get(paramInt));
  }
  
  private int v(CloudVideoItem paramCloudVideoItem)
  {
    if (paramCloudVideoItem == null) {
      return -1;
    }
    paramCloudVideoItem = paramCloudVideoItem.getCloudVideo().getEventLocalTime().split(" ");
    if (paramCloudVideoItem.length == 2)
    {
      paramCloudVideoItem = paramCloudVideoItem[1].split(":");
      if (paramCloudVideoItem.length == 3) {
        return Integer.parseInt(paramCloudVideoItem[0]);
      }
    }
    return -1;
  }
  
  public boolean B()
  {
    boolean bool;
    if (y() == this.o.size()) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean C(int paramInt)
  {
    if ((paramInt >= 0) && (getItemViewType(paramInt) == 2)) {
      return this.f.contains(this.m.get(paramInt));
    }
    return false;
  }
  
  public void E()
  {
    this.m.remove(0);
    this.n.remove(0);
    this.q = false;
    notifyItemRemoved(0);
  }
  
  public void G()
  {
    this.t = true;
    for (int i1 = 0; i1 < this.m.size(); i1++) {
      if ((getItemViewType(i1) == 2) && (!C(i1)))
      {
        s(i1);
        notifyItemChanged(i1);
      }
    }
    c localc = this.i;
    if (localc != null) {
      localc.b0(y());
    }
  }
  
  public void H(List<CloudVideoItem> paramList)
  {
    if (paramList == null) {
      return;
    }
    if (this.l == null) {
      this.l = new ArrayList();
    }
    this.l.clear();
    this.l.addAll(paramList);
    this.q = false;
    if (this.t)
    {
      Set localSet = this.f;
      if (localSet != null) {
        localSet.addAll(paramList);
      }
    }
    D();
  }
  
  public void I(String paramString)
  {
    this.u = paramString;
  }
  
  public void J(d paramd)
  {
    this.k = paramd;
  }
  
  public void K(int paramInt)
  {
    if (this.g != paramInt)
    {
      this.g = paramInt;
      Object localObject = this.h;
      if (localObject != null) {
        ((b)localObject).B(paramInt);
      }
      if (this.g == 0)
      {
        this.f.clear();
        this.t = false;
      }
      localObject = this.i;
      if (localObject != null) {
        ((c)localObject).b0(y());
      }
      this.p = "";
      notifyDataSetChanged();
    }
  }
  
  public void L(b paramb)
  {
    this.h = paramb;
  }
  
  public void M(c paramc)
  {
    this.i = paramc;
  }
  
  public void N(String paramString)
  {
    if (paramString == null) {
      return;
    }
    this.p = paramString;
    if (!this.m.isEmpty()) {
      notifyDataSetChanged();
    }
  }
  
  public void P(int paramInt)
  {
    if ((paramInt >= 0) && (getItemViewType(paramInt) == 2))
    {
      if (C(paramInt)) {
        F(paramInt);
      } else {
        s(paramInt);
      }
      this.t = B();
      notifyItemChanged(paramInt);
      c localc = this.i;
      if (localc != null) {
        localc.b0(y());
      }
    }
  }
  
  public int getItemCount()
  {
    List localList = this.n;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((this.q) && (paramInt == 0)) {
      return 0;
    }
    if (((Integer)this.n.get(paramInt)).intValue() == -1) {
      return 2;
    }
    return 1;
  }
  
  public void onAttachedToRecyclerView(@NonNull RecyclerView paramRecyclerView)
  {
    paramRecyclerView = (GridLayoutManager)paramRecyclerView.getLayoutManager();
    if (paramRecyclerView == null) {
      return;
    }
    paramRecyclerView.setSpanSizeLookup(new a());
  }
  
  public void onBindViewHolder(@NonNull RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((paramViewHolder instanceof HeaderViewHolder))
    {
      ((HeaderViewHolder)paramViewHolder).mCloudServiceExpireTv.setText(this.j.getResources().getString(2131953791));
    }
    else if ((paramViewHolder instanceof TitleViewHolder))
    {
      ((TitleViewHolder)paramViewHolder).mTitleTv.setText(q0.a(((Integer)this.n.get(paramInt)).intValue()));
    }
    else if ((paramViewHolder instanceof VideoViewHolder))
    {
      VideoViewHolder localVideoViewHolder = (VideoViewHolder)paramViewHolder;
      paramViewHolder = (CloudVideoItem)this.m.get(paramInt);
      Context localContext = this.j;
      if (localContext != null) {
        c.u(localContext).s(((CloudVideoThumbnail)paramViewHolder.getCloudVideo().getVideoThumbnails().get(0)).getUri()).m0(this.s).x0(localVideoViewHolder.mVideoIv);
      }
      localVideoViewHolder.mRecordTimeTv.setText(paramViewHolder.getDisplayTime());
      localVideoViewHolder.mSelectIv.setVisibility(8);
      if (w() == 1)
      {
        if (C(paramInt))
        {
          localVideoViewHolder.mSelectIv.setImageResource(2131690251);
          localVideoViewHolder.mVideoIv.setColorFilter(o.a, PorterDuff.Mode.SRC_OVER);
        }
        else
        {
          localVideoViewHolder.mSelectIv.setImageResource(2131690252);
          localVideoViewHolder.mVideoIv.clearColorFilter();
        }
        localVideoViewHolder.mSelectIv.setVisibility(0);
      }
      else
      {
        localVideoViewHolder.mSelectIv.setVisibility(8);
        if ((!TextUtils.isEmpty(this.p)) && (this.p.equals(paramViewHolder.getCloudVideo().getUuid())))
        {
          localVideoViewHolder.mPlayVideoIv.setVisibility(0);
          localVideoViewHolder.mVideoIv.setColorFilter(o.a, PorterDuff.Mode.SRC_OVER);
        }
        else
        {
          localVideoViewHolder.mPlayVideoIv.setVisibility(8);
          localVideoViewHolder.mVideoIv.clearColorFilter();
        }
      }
      if (!paramViewHolder.isHasVideo()) {
        localVideoViewHolder.mNoVideoIv.setVisibility(0);
      } else {
        localVideoViewHolder.mNoVideoIv.setVisibility(8);
      }
    }
  }
  
  @NonNull
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt != 0)
    {
      LayoutInflater localLayoutInflater;
      if (paramInt != 1)
      {
        localLayoutInflater = LayoutInflater.from(this.j);
        if (this.r) {
          paramInt = 2131559013;
        } else {
          paramInt = 2131559012;
        }
        paramViewGroup = new VideoViewHolder(localLayoutInflater.inflate(paramInt, paramViewGroup, false));
      }
      else
      {
        localLayoutInflater = LayoutInflater.from(this.j);
        if (this.r) {
          paramInt = 2131559011;
        } else {
          paramInt = 2131559010;
        }
        paramViewGroup = new TitleViewHolder(localLayoutInflater.inflate(paramInt, paramViewGroup, false));
      }
    }
    else
    {
      paramViewGroup = new HeaderViewHolder(LayoutInflater.from(this.j).inflate(2131558736, paramViewGroup, false));
    }
    return paramViewGroup;
  }
  
  public void t()
  {
    this.t = false;
    this.f.clear();
    c localc = this.i;
    if (localc != null) {
      localc.b0(y());
    }
    notifyDataSetChanged();
  }
  
  public List<CloudVideoItem> u()
  {
    return this.l;
  }
  
  public int w()
  {
    return this.g;
  }
  
  public List<CloudVideoItem> x()
  {
    return new ArrayList(this.f);
  }
  
  public int y()
  {
    return this.f.size();
  }
  
  public int z()
  {
    List localList = this.m;
    if ((localList != null) && (!localList.isEmpty())) {
      return this.m.size();
    }
    return 0;
  }
  
  class HeaderViewHolder
    extends RecyclerView.ViewHolder
    implements View.OnClickListener
  {
    @BindView
    ImageView mCloudServiceExpireCloseIv;
    @BindView
    TextView mCloudServiceExpireTv;
    
    public HeaderViewHolder(View paramView)
    {
      super();
      ButterKnife.b(this, paramView);
      paramView.setOnClickListener(this);
    }
    
    @OnClick
    void close()
    {
      CloudVideoListAdapter localCloudVideoListAdapter = CloudVideoListAdapter.this;
      if (localCloudVideoListAdapter.g == 1) {
        return;
      }
      if (CloudVideoListAdapter.m(localCloudVideoListAdapter))
      {
        CloudVideoListAdapter.this.E();
        w.w(CloudVideoListAdapter.o(CloudVideoListAdapter.this), "cloudvideo");
        if (CloudVideoListAdapter.p(CloudVideoListAdapter.this) != null) {
          CloudVideoListAdapter.p(CloudVideoListAdapter.this).f0();
        }
      }
    }
    
    public void onClick(View paramView)
    {
      int i = getAdapterPosition();
      if ((CloudVideoListAdapter.this.getItemViewType(i) == 0) && (CloudVideoListAdapter.p(CloudVideoListAdapter.this) != null)) {
        CloudVideoListAdapter.p(CloudVideoListAdapter.this).p((CloudVideoItem)CloudVideoListAdapter.q(CloudVideoListAdapter.this).get(i));
      }
    }
  }
  
  class TitleViewHolder
    extends RecyclerView.ViewHolder
  {
    @BindView
    TextView mTitleTv;
    
    public TitleViewHolder(View paramView)
    {
      super();
      ButterKnife.b(this, paramView);
    }
  }
  
  class VideoViewHolder
    extends RecyclerView.ViewHolder
    implements View.OnLongClickListener, View.OnClickListener
  {
    @BindView
    ImageView mNoVideoIv;
    @BindView
    ImageView mPlayVideoIv;
    @BindView
    TextView mRecordTimeTv;
    @BindView
    ImageView mSelectIv;
    @BindView
    ImageView mVideoIv;
    
    public VideoViewHolder(View paramView)
    {
      super();
      ButterKnife.b(this, paramView);
      paramView.setOnClickListener(this);
      paramView.setOnLongClickListener(this);
    }
    
    public void onClick(View paramView)
    {
      int i = getAdapterPosition();
      if ((i >= 0) && (i < CloudVideoListAdapter.this.getItemCount()) && (CloudVideoListAdapter.this.getItemViewType(i) == 2))
      {
        paramView = CloudVideoListAdapter.this;
        if (paramView.g == 1) {
          paramView.P(i);
        } else if (CloudVideoListAdapter.p(paramView) != null) {
          CloudVideoListAdapter.p(CloudVideoListAdapter.this).p((CloudVideoItem)CloudVideoListAdapter.q(CloudVideoListAdapter.this).get(i));
        }
      }
    }
    
    public boolean onLongClick(View paramView)
    {
      if (CloudVideoListAdapter.r(CloudVideoListAdapter.this)) {
        return true;
      }
      int i = getAdapterPosition();
      paramView = CloudVideoListAdapter.this;
      if (paramView.g != 1) {
        paramView.K(1);
      }
      CloudVideoListAdapter.this.P(i);
      return true;
    }
  }
  
  class a
    extends GridLayoutManager.SpanSizeLookup
  {
    a() {}
    
    public int getSpanSize(int paramInt)
    {
      if ((CloudVideoListAdapter.m(CloudVideoListAdapter.this)) && (paramInt == 0)) {
        return 2;
      }
      if (((Integer)CloudVideoListAdapter.n(CloudVideoListAdapter.this).get(paramInt)).intValue() == -1) {
        return 1;
      }
      return 2;
    }
  }
  
  public static abstract interface b
  {
    public abstract void B(int paramInt);
  }
  
  public static abstract interface c
  {
    public abstract void b0(int paramInt);
  }
  
  public static abstract interface d
  {
    public abstract void f0();
    
    public abstract void p(CloudVideoItem paramCloudVideoItem);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\adapter\cloudvideo\CloudVideoListAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */