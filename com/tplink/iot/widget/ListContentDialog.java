package com.tplink.iot.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AlertDialog.Builder;
import androidx.appcompat.app.AppCompatDialog;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import b.d.w.c.a;
import java.util.List;

public class ListContentDialog
  extends AlertDialog
{
  private int H3;
  private e I3;
  private d J3;
  private TextView c;
  private TextView d;
  private TextView f;
  private CharSequence p0;
  private int p1;
  private CharSequence p2;
  private int p3;
  private TextView q;
  private List<String> x = null;
  private CharSequence y;
  private CharSequence z;
  
  protected ListContentDialog(@NonNull Context paramContext)
  {
    super(paramContext, 2132017570);
    l(paramContext);
  }
  
  public static int k(Context paramContext, float paramFloat)
  {
    return Math.round(TypedValue.applyDimension(1, paramFloat, paramContext.getResources().getDisplayMetrics()));
  }
  
  private void l(Context paramContext)
  {
    this.p1 = -1;
    this.p3 = -1;
    this.H3 = k(paramContext, 184.0F);
  }
  
  private void m(ListContentDialog paramListContentDialog)
  {
    int i;
    if (!TextUtils.isEmpty(this.y))
    {
      paramListContentDialog.c.setVisibility(0);
      paramListContentDialog.c.setText(this.y);
      i = this.p1;
      if (i > 0) {
        paramListContentDialog.c.setTextColor(i);
      }
    }
    else
    {
      paramListContentDialog.c.setVisibility(8);
    }
    if (!TextUtils.isEmpty(this.p2))
    {
      paramListContentDialog.d.setVisibility(0);
      paramListContentDialog.d.setText(this.p2);
      i = this.p3;
      if (i > 0) {
        paramListContentDialog.d.setTextColor(i);
      }
    }
    else
    {
      paramListContentDialog.d.setVisibility(8);
    }
    paramListContentDialog.q.setText(this.z);
    paramListContentDialog.f.setText(this.p0);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131559116);
    this.c = ((TextView)findViewById(2131364252));
    this.d = ((TextView)findViewById(2131362323));
    this.q = ((TextView)findViewById(2131362186));
    this.f = ((TextView)findViewById(2131363581));
    paramBundle = (RecyclerView)findViewById(2131363246);
    paramBundle.setLayoutManager(new LinearLayoutManager(getContext()));
    paramBundle.setItemAnimator(new DefaultItemAnimator());
    Object localObject = new c(null);
    paramBundle.setAdapter((RecyclerView.Adapter)localObject);
    int i = 0;
    setCancelable(false);
    setCanceledOnTouchOutside(false);
    this.f.setOnClickListener(new a());
    this.q.setOnClickListener(new b());
    int j = 0;
    while (i < ((c)localObject).getItemCount())
    {
      j += k(getContext(), 40.0F);
      i++;
    }
    if (j > this.H3)
    {
      localObject = paramBundle.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).height = this.H3;
      paramBundle.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
  }
  
  public void show()
  {
    super.show();
    m(this);
  }
  
  public static class Builder
    extends AlertDialog.Builder
  {
    private ListContentDialog a = null;
    
    public Builder(@NonNull Context paramContext)
    {
      super();
      this.a = new ListContentDialog(paramContext);
    }
    
    public ListContentDialog a()
    {
      return this.a;
    }
    
    public Builder b(CharSequence paramCharSequence)
    {
      return c(paramCharSequence, 0);
    }
    
    public Builder c(CharSequence paramCharSequence, int paramInt)
    {
      ListContentDialog.g(this.a, paramCharSequence);
      if (paramInt > 0) {
        ListContentDialog.h(this.a, paramInt);
      }
      return this;
    }
    
    public Builder d(List<?> paramList)
    {
      try
      {
        ListContentDialog.j(this.a, paramList);
      }
      catch (ClassCastException paramList)
      {
        paramList.printStackTrace();
        a.c(getClass().getSimpleName(), "data list must be a string vector");
      }
      return this;
    }
    
    public Builder e(@Nullable CharSequence paramCharSequence)
    {
      ListContentDialog.e(this.a, paramCharSequence);
      return this;
    }
    
    public Builder f(ListContentDialog.e parame)
    {
      ListContentDialog.b(this.a, parame);
      return this;
    }
    
    public Builder g(@Nullable CharSequence paramCharSequence)
    {
      ListContentDialog.f(this.a, paramCharSequence);
      return this;
    }
    
    public Builder h(@Nullable CharSequence paramCharSequence)
    {
      ListContentDialog.d(this.a, paramCharSequence);
      return this;
    }
  }
  
  class a
    implements View.OnClickListener
  {
    a() {}
    
    public void onClick(View paramView)
    {
      ListContentDialog.this.dismiss();
      if (ListContentDialog.a(ListContentDialog.this) != null) {
        ListContentDialog.a(ListContentDialog.this).dismiss();
      }
    }
  }
  
  class b
    implements View.OnClickListener
  {
    b() {}
    
    public void onClick(View paramView)
    {
      ListContentDialog.this.dismiss();
      if (ListContentDialog.c(ListContentDialog.this) != null) {
        ListContentDialog.c(ListContentDialog.this).dismiss();
      }
    }
  }
  
  private class c
    extends RecyclerView.Adapter
  {
    private c() {}
    
    public int getItemCount()
    {
      int i;
      if (ListContentDialog.i(ListContentDialog.this) == null) {
        i = 0;
      } else {
        i = ListContentDialog.i(ListContentDialog.this).size();
      }
      return i;
    }
    
    public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
    {
      a locala = (a)paramViewHolder;
      if ((paramInt >= 0) && (paramInt < ListContentDialog.i(ListContentDialog.this).size()))
      {
        paramViewHolder = (String)ListContentDialog.i(ListContentDialog.this).get(paramInt);
        locala.a.setContent(paramViewHolder);
      }
    }
    
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
    {
      return new a(LayoutInflater.from(ListContentDialog.this.getContext()).inflate(2131559178, paramViewGroup, false));
    }
    
    class a
      extends RecyclerView.ViewHolder
    {
      public DialogPointTextView a;
      
      public a(View paramView)
      {
        super();
        this.a = ((DialogPointTextView)paramView.findViewById(2131362978));
      }
    }
  }
  
  public static abstract interface d
  {
    public abstract void dismiss();
  }
  
  public static abstract interface e
  {
    public abstract void dismiss();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\ListContentDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */