package com.tplink.iot.view.ipcamera.setting;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.tplink.iot.Utils.s0;
import com.tplink.libtpnetwork.cameranetwork.model.RecordPlanBean;
import com.tplink.libtpnetwork.cameranetwork.util.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

public class RecordCustomSettingView
  extends View
  implements View.OnTouchListener
{
  private static final String c = RecordCustomSettingView.class.getSimpleName();
  private String[] H3;
  private String[] I3;
  private int J3;
  private float K3;
  private Paint L3;
  private Paint M3;
  private Paint N3;
  private Paint O3;
  private Paint P3;
  private Paint Q3;
  private SparseIntArray R3;
  private SparseIntArray S3;
  private GestureDetector T3;
  private Map<Integer, d> U3;
  private ArrayList<c> V3;
  private ArrayList<Integer> W3;
  private Map<Integer, TreeSet<RecordPlanBean>> X3;
  private Rect Y3;
  private int Z3;
  private int a4;
  private int b4;
  private RecordPlanBean c4;
  private int d;
  private int d4;
  private int e4;
  private int f;
  private int p0;
  private int p1;
  private int p2;
  private int p3;
  private int q;
  private int x;
  private int y;
  private int z;
  
  public RecordCustomSettingView(Context paramContext)
  {
    super(paramContext);
    I(paramContext);
  }
  
  public RecordCustomSettingView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    I(paramContext);
  }
  
  public RecordCustomSettingView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    I(paramContext);
  }
  
  private void A(Canvas paramCanvas)
  {
    if (this.Y3 != null)
    {
      this.Q3.setColor(this.S3.get(this.c4.getRecordType()));
      paramCanvas.drawRect(this.Y3, this.Q3);
    }
  }
  
  private void B(Canvas paramCanvas, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    paramCanvas.drawLine(paramFloat1, paramFloat2, paramFloat1 + paramFloat3, paramFloat2, this.M3);
  }
  
  private void C(Canvas paramCanvas)
  {
    this.V3.clear();
    Iterator localIterator1 = this.X3.entrySet().iterator();
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((TreeSet)((Map.Entry)localIterator1.next()).getValue()).iterator();
      while (localIterator2.hasNext())
      {
        RecordPlanBean localRecordPlanBean = (RecordPlanBean)localIterator2.next();
        this.P3.setColor(this.R3.get(localRecordPlanBean.getRecordType()));
        Rect localRect = x(H(localRecordPlanBean.getStartTime()), H(localRecordPlanBean.getEndTime()), localRecordPlanBean.getDayIndex());
        this.V3.add(new c(localRect, localRecordPlanBean));
        paramCanvas.drawRect(localRect, this.P3);
      }
    }
  }
  
  private void D(Canvas paramCanvas, String paramString, int paramInt, float paramFloat1, float paramFloat2)
  {
    this.L3.setTextSize(paramInt);
    paramCanvas.drawText(paramString, paramFloat1, paramFloat2, this.L3);
  }
  
  private void E(Canvas paramCanvas, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    paramCanvas.drawLine(paramFloat1, paramFloat2, paramFloat1, paramFloat2 + paramFloat3, this.M3);
  }
  
  private int G(float paramFloat1, float paramFloat2)
  {
    if ((paramFloat1 - getCommonLeftDistance() >= 0.0F) && (paramFloat1 - getCommonLeftDistance() <= this.x * 7) && (paramFloat2 - getCommonTopDistance() >= 0.0F) && (paramFloat2 - getCommonTopDistance() <= this.q * 24)) {
      return (int)((paramFloat1 - getCommonLeftDistance()) / this.x) * 24 + ((int)((paramFloat2 - getCommonTopDistance()) / this.q) + 1);
    }
    return -1;
  }
  
  private int H(int paramInt)
  {
    return (int)(paramInt * 1.0D / 60.0D * this.q) + getCommonTopDistance();
  }
  
  private void I(Context paramContext)
  {
    this.d = e.a(12, paramContext);
    this.f = e.a(14, paramContext);
    this.y = e.a(9, paramContext);
    this.z = e.a(8, paramContext);
    this.J3 = e.a(28, paramContext);
    this.p0 = e.a(56, paramContext);
    this.p1 = e.a(88, paramContext);
    this.p2 = e.a(28, paramContext);
    this.p3 = paramContext.getResources().getDimensionPixelSize(2131165288);
    this.H3 = paramContext.getResources().getStringArray(2130903047);
    this.I3 = paramContext.getResources().getStringArray(2130903061);
    Paint localPaint = new Paint();
    this.L3 = localPaint;
    localPaint.setTextSize(this.d);
    this.L3.setAntiAlias(true);
    this.K3 = (this.L3.getFontMetrics().bottom - this.L3.getFontMetrics().top);
    localPaint = new Paint();
    this.M3 = localPaint;
    localPaint.setColor(ContextCompat.getColor(paramContext, 2131100157));
    this.M3.setStrokeWidth(this.p3);
    localPaint = new Paint();
    this.Q3 = localPaint;
    localPaint.setStrokeWidth(e.a(3, getContext()));
    this.Q3.setStyle(Paint.Style.STROKE);
    localPaint = new Paint();
    this.N3 = localPaint;
    localPaint.setColor(ContextCompat.getColor(paramContext, 2131100140));
    this.P3 = new Paint();
    this.O3 = new Paint();
    K();
  }
  
  private void J()
  {
    this.U3.clear();
    int i = 1;
    for (int j = 0; j < 7; j++) {
      for (int k = 0; k < 24; k++)
      {
        Map localMap = this.U3;
        int m = k * 60;
        localMap.put(Integer.valueOf(i), new d(0, m, m + 60, j, 0));
        i++;
      }
    }
  }
  
  private void K()
  {
    this.T3 = new GestureDetector(getContext(), new b(null));
    this.R3 = new SparseIntArray();
    this.S3 = new SparseIntArray();
    this.W3 = new ArrayList();
    this.V3 = new ArrayList();
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    this.X3 = localLinkedHashMap;
    localLinkedHashMap.put(Integer.valueOf(1), new TreeSet());
    this.X3.put(Integer.valueOf(2), new TreeSet());
    this.X3.put(Integer.valueOf(3), new TreeSet());
    this.X3.put(Integer.valueOf(4), new TreeSet());
    this.X3.put(Integer.valueOf(5), new TreeSet());
    this.X3.put(Integer.valueOf(6), new TreeSet());
    this.X3.put(Integer.valueOf(0), new TreeSet());
    this.U3 = new HashMap();
    this.d4 = -1;
    this.Z3 = -1;
    this.b4 = -1;
    this.a4 = 1;
    this.Y3 = null;
    this.R3.put(1, ContextCompat.getColor(getContext(), 2131100108));
    this.R3.put(2, ContextCompat.getColor(getContext(), 2131099745));
    this.S3.put(1, ContextCompat.getColor(getContext(), 2131100148));
    this.S3.put(2, ContextCompat.getColor(getContext(), 2131100145));
  }
  
  private int L(int paramInt)
  {
    View.MeasureSpec.getMode(paramInt);
    return getSuggestedHeight();
  }
  
  private int M(int paramInt)
  {
    View.MeasureSpec.getMode(paramInt);
    View.MeasureSpec.getSize(paramInt);
    return View.MeasureSpec.getSize(Integer.MIN_VALUE);
  }
  
  private int getCommonLeftDistance()
  {
    return this.y * 2 + this.J3;
  }
  
  private int getCommonTopDistance()
  {
    return this.z + this.p2;
  }
  
  private int getSuggestedHeight()
  {
    return View.MeasureSpec.getSize(Integer.MIN_VALUE);
  }
  
  private void t(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, TreeSet<RecordPlanBean> paramTreeSet)
  {
    TreeSet localTreeSet = new TreeSet();
    Object localObject;
    RecordPlanBean localRecordPlanBean;
    if (paramInt5 == 0)
    {
      localObject = paramTreeSet.iterator();
      for (;;)
      {
        if (!((Iterator)localObject).hasNext()) {
          break label846;
        }
        localRecordPlanBean = (RecordPlanBean)((Iterator)localObject).next();
        if (localRecordPlanBean.getEndTime() > paramInt1)
        {
          if (localRecordPlanBean.getStartTime() >= paramInt2) {
            break label846;
          }
          if ((localRecordPlanBean.getStartTime() >= paramInt1) && (localRecordPlanBean.getEndTime() <= paramInt2))
          {
            ((Iterator)localObject).remove();
          }
          else if ((localRecordPlanBean.getStartTime() >= paramInt1) && (localRecordPlanBean.contains(paramInt2)))
          {
            localRecordPlanBean.setStartTime(paramInt2);
          }
          else
          {
            if ((!localRecordPlanBean.contains(paramInt1)) || (localRecordPlanBean.getEndTime() > paramInt2)) {
              break;
            }
            localRecordPlanBean.setEndTime(paramInt1);
          }
        }
      }
      ((Iterator)localObject).remove();
      localTreeSet.add(new RecordPlanBean(localRecordPlanBean.getRecordType(), localRecordPlanBean.getDayIndex(), localRecordPlanBean.getStartTime(), paramInt1));
      localTreeSet.add(new RecordPlanBean(localRecordPlanBean.getRecordType(), localRecordPlanBean.getDayIndex(), paramInt2, localRecordPlanBean.getEndTime()));
    }
    else
    {
      paramInt5 = 1;
      localRecordPlanBean = new RecordPlanBean(paramInt3, paramInt4, paramInt1, paramInt2);
      Iterator localIterator = paramTreeSet.iterator();
      while (localIterator.hasNext())
      {
        localObject = (RecordPlanBean)localIterator.next();
        if (((RecordPlanBean)localObject).equals(localRecordPlanBean)) {
          paramTreeSet.remove(localObject);
        }
      }
      localIterator = paramTreeSet.iterator();
      for (;;)
      {
        paramInt4 = paramInt5;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (RecordPlanBean)localIterator.next();
        if (((RecordPlanBean)localObject).getRecordType() == paramInt3)
        {
          if ((localRecordPlanBean.contains(((RecordPlanBean)localObject).getStartTime())) && (localRecordPlanBean.contains(((RecordPlanBean)localObject).getEndTime())))
          {
            localIterator.remove();
          }
          else if ((((RecordPlanBean)localObject).containsWithEqual(paramInt1)) && (((RecordPlanBean)localObject).getEndTime() < paramInt2))
          {
            localRecordPlanBean.setStartTime(((RecordPlanBean)localObject).getStartTime());
            localIterator.remove();
          }
          else if ((((RecordPlanBean)localObject).getStartTime() > paramInt1) && (((RecordPlanBean)localObject).containsWithEqual(paramInt2)))
          {
            localRecordPlanBean.setEndTime(((RecordPlanBean)localObject).getEndTime());
            localIterator.remove();
          }
          else
          {
            if ((((RecordPlanBean)localObject).containsWithEqual(paramInt1)) && (((RecordPlanBean)localObject).containsWithEqual(paramInt2)))
            {
              paramInt4 = paramInt5;
              if (((RecordPlanBean)localObject).equals(localRecordPlanBean)) {
                break;
              }
              paramInt4 = 0;
              break;
            }
            if (!((RecordPlanBean)localObject).contains(paramInt1)) {
              ((RecordPlanBean)localObject).contains(paramInt2);
            }
          }
        }
        else if ((localRecordPlanBean.containsWithEqual(((RecordPlanBean)localObject).getStartTime())) && (localRecordPlanBean.containsWithEqual(((RecordPlanBean)localObject).getEndTime())))
        {
          localIterator.remove();
        }
        else if ((((RecordPlanBean)localObject).contains(paramInt1)) && (!((RecordPlanBean)localObject).contains(paramInt2)))
        {
          localIterator.remove();
          localTreeSet.add(new RecordPlanBean(((RecordPlanBean)localObject).getRecordType(), ((RecordPlanBean)localObject).getDayIndex(), ((RecordPlanBean)localObject).getStartTime(), paramInt1));
        }
        else if ((!((RecordPlanBean)localObject).contains(paramInt1)) && (((RecordPlanBean)localObject).contains(paramInt2)))
        {
          localIterator.remove();
          localTreeSet.add(new RecordPlanBean(((RecordPlanBean)localObject).getRecordType(), ((RecordPlanBean)localObject).getDayIndex(), paramInt2, ((RecordPlanBean)localObject).getEndTime()));
        }
        else if ((((RecordPlanBean)localObject).containsWithEqual(paramInt1)) && (((RecordPlanBean)localObject).containsWithEqual(paramInt2)))
        {
          if ((((RecordPlanBean)localObject).getStartTime() == paramInt1) && (((RecordPlanBean)localObject).getEndTime() == paramInt2))
          {
            localIterator.remove();
          }
          else if ((((RecordPlanBean)localObject).getStartTime() == paramInt1) && (((RecordPlanBean)localObject).getEndTime() != paramInt2))
          {
            ((RecordPlanBean)localObject).setStartTime(paramInt2);
          }
          else if ((((RecordPlanBean)localObject).getStartTime() != paramInt1) && (((RecordPlanBean)localObject).getEndTime() == paramInt2))
          {
            ((RecordPlanBean)localObject).setEndTime(paramInt1);
          }
          else
          {
            localIterator.remove();
            localTreeSet.add(new RecordPlanBean(((RecordPlanBean)localObject).getRecordType(), ((RecordPlanBean)localObject).getDayIndex(), ((RecordPlanBean)localObject).getStartTime(), paramInt1));
            localTreeSet.add(new RecordPlanBean(((RecordPlanBean)localObject).getRecordType(), ((RecordPlanBean)localObject).getDayIndex(), paramInt2, ((RecordPlanBean)localObject).getEndTime()));
            paramInt4 = paramInt5;
            break;
          }
        }
        else if (!((RecordPlanBean)localObject).contains(paramInt1))
        {
          ((RecordPlanBean)localObject).contains(paramInt2);
        }
      }
      if (paramInt4 != 0) {
        paramTreeSet.add(localRecordPlanBean);
      }
    }
    label846:
    if (localTreeSet.size() != 0) {
      paramTreeSet.addAll(localTreeSet);
    }
    u();
  }
  
  private void u()
  {
    J();
    Iterator localIterator1 = this.X3.entrySet().iterator();
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((TreeSet)((Map.Entry)localIterator1.next()).getValue()).iterator();
      while (localIterator2.hasNext())
      {
        RecordPlanBean localRecordPlanBean = (RecordPlanBean)localIterator2.next();
        d locald;
        int i;
        if ((localRecordPlanBean.getStartTime() % 60 != 0) && (localRecordPlanBean.getEndTime() % 60 != 0) && (localRecordPlanBean.getStartTime() / 60 == localRecordPlanBean.getEndTime() / 60))
        {
          d.b((d)this.U3.get(Integer.valueOf(localRecordPlanBean.getDayIndex() * 24 + localRecordPlanBean.getStartTime() / 60 + 1)), d.a((d)this.U3.get(Integer.valueOf(localRecordPlanBean.getDayIndex() * 24 + localRecordPlanBean.getStartTime() / 60 + 1))) | 0x8);
          locald = (d)this.U3.get(Integer.valueOf(localRecordPlanBean.getDayIndex() * 24 + localRecordPlanBean.getStartTime() / 60 + 1));
          i = d.c((d)this.U3.get(Integer.valueOf(localRecordPlanBean.getDayIndex() * 24 + localRecordPlanBean.getStartTime() / 60 + 1)));
          d.d(locald, localRecordPlanBean.getRecordType() | i);
        }
        else if ((localRecordPlanBean.getStartTime() % 60 == 0) && (localRecordPlanBean.getEndTime() % 60 == 0))
        {
          for (i = localRecordPlanBean.getStartTime() / 60; i < localRecordPlanBean.getEndTime() / 60; i++)
          {
            d.b((d)this.U3.get(Integer.valueOf(localRecordPlanBean.getDayIndex() * 24 + i + 1)), d.a((d)this.U3.get(Integer.valueOf(localRecordPlanBean.getDayIndex() * 24 + i + 1))) | 0x1);
            d.d((d)this.U3.get(Integer.valueOf(localRecordPlanBean.getDayIndex() * 24 + i + 1)), d.c((d)this.U3.get(Integer.valueOf(localRecordPlanBean.getDayIndex() * 24 + i + 1))) | localRecordPlanBean.getRecordType());
          }
        }
        else if ((localRecordPlanBean.getStartTime() % 60 == 0) && (localRecordPlanBean.getEndTime() % 60 != 0) && (localRecordPlanBean.getStartTime() / 60 == localRecordPlanBean.getEndTime() / 60))
        {
          d.b((d)this.U3.get(Integer.valueOf(localRecordPlanBean.getDayIndex() * 24 + localRecordPlanBean.getStartTime() / 60 + 1)), d.a((d)this.U3.get(Integer.valueOf(localRecordPlanBean.getDayIndex() * 24 + localRecordPlanBean.getStartTime() / 60 + 1))) | 0x2);
          locald = (d)this.U3.get(Integer.valueOf(localRecordPlanBean.getDayIndex() * 24 + localRecordPlanBean.getStartTime() / 60 + 1));
          i = d.c((d)this.U3.get(Integer.valueOf(localRecordPlanBean.getDayIndex() * 24 + localRecordPlanBean.getStartTime() / 60 + 1)));
          d.d(locald, localRecordPlanBean.getRecordType() | i);
        }
        else if ((localRecordPlanBean.getStartTime() % 60 == 0) && (localRecordPlanBean.getEndTime() % 60 != 0) && (localRecordPlanBean.getStartTime() / 60 != localRecordPlanBean.getEndTime() / 60))
        {
          for (i = localRecordPlanBean.getStartTime() / 60; i < localRecordPlanBean.getEndTime() / 60; i++)
          {
            d.b((d)this.U3.get(Integer.valueOf(localRecordPlanBean.getDayIndex() * 24 + i + 1)), d.a((d)this.U3.get(Integer.valueOf(localRecordPlanBean.getDayIndex() * 24 + i + 1))) | 0x1);
            d.d((d)this.U3.get(Integer.valueOf(localRecordPlanBean.getDayIndex() * 24 + i + 1)), d.c((d)this.U3.get(Integer.valueOf(localRecordPlanBean.getDayIndex() * 24 + i + 1))) | localRecordPlanBean.getRecordType());
          }
          d.b((d)this.U3.get(Integer.valueOf(localRecordPlanBean.getDayIndex() * 24 + localRecordPlanBean.getEndTime() / 60 + 1)), d.a((d)this.U3.get(Integer.valueOf(localRecordPlanBean.getDayIndex() * 24 + localRecordPlanBean.getEndTime() / 60 + 1))) | 0x2);
          locald = (d)this.U3.get(Integer.valueOf(localRecordPlanBean.getDayIndex() * 24 + localRecordPlanBean.getEndTime() / 60 + 1));
          i = d.c((d)this.U3.get(Integer.valueOf(localRecordPlanBean.getDayIndex() * 24 + localRecordPlanBean.getEndTime() / 60 + 1)));
          d.d(locald, localRecordPlanBean.getRecordType() | i);
        }
        else if ((localRecordPlanBean.getStartTime() % 60 != 0) && (localRecordPlanBean.getEndTime() % 60 == 0))
        {
          d.b((d)this.U3.get(Integer.valueOf(localRecordPlanBean.getDayIndex() * 24 + localRecordPlanBean.getStartTime() / 60 + 1)), d.a((d)this.U3.get(Integer.valueOf(localRecordPlanBean.getDayIndex() * 24 + localRecordPlanBean.getStartTime() / 60 + 1))) | 0x4);
          d.d((d)this.U3.get(Integer.valueOf(localRecordPlanBean.getDayIndex() * 24 + localRecordPlanBean.getStartTime() / 60 + 1)), d.c((d)this.U3.get(Integer.valueOf(localRecordPlanBean.getDayIndex() * 24 + localRecordPlanBean.getStartTime() / 60 + 1))) | localRecordPlanBean.getRecordType());
          i = localRecordPlanBean.getStartTime() / 60;
          for (;;)
          {
            i++;
            if (i >= localRecordPlanBean.getEndTime() / 60) {
              break;
            }
            d.b((d)this.U3.get(Integer.valueOf(localRecordPlanBean.getDayIndex() * 24 + i + 1)), d.a((d)this.U3.get(Integer.valueOf(localRecordPlanBean.getDayIndex() * 24 + i + 1))) | 0x1);
            d.d((d)this.U3.get(Integer.valueOf(localRecordPlanBean.getDayIndex() * 24 + i + 1)), d.c((d)this.U3.get(Integer.valueOf(localRecordPlanBean.getDayIndex() * 24 + i + 1))) | localRecordPlanBean.getRecordType());
          }
        }
        else
        {
          d.b((d)this.U3.get(Integer.valueOf(localRecordPlanBean.getDayIndex() * 24 + localRecordPlanBean.getStartTime() / 60 + 1)), d.a((d)this.U3.get(Integer.valueOf(localRecordPlanBean.getDayIndex() * 24 + localRecordPlanBean.getStartTime() / 60 + 1))) | 0x4);
          d.d((d)this.U3.get(Integer.valueOf(localRecordPlanBean.getDayIndex() * 24 + localRecordPlanBean.getStartTime() / 60 + 1)), d.c((d)this.U3.get(Integer.valueOf(localRecordPlanBean.getDayIndex() * 24 + localRecordPlanBean.getStartTime() / 60 + 1))) | localRecordPlanBean.getRecordType());
          i = localRecordPlanBean.getStartTime() / 60;
          for (;;)
          {
            i++;
            if (i >= localRecordPlanBean.getEndTime() / 60) {
              break;
            }
            d.b((d)this.U3.get(Integer.valueOf(localRecordPlanBean.getDayIndex() * 24 + i + 1)), d.a((d)this.U3.get(Integer.valueOf(localRecordPlanBean.getDayIndex() * 24 + i + 1))) | 0x1);
            d.d((d)this.U3.get(Integer.valueOf(localRecordPlanBean.getDayIndex() * 24 + i + 1)), d.c((d)this.U3.get(Integer.valueOf(localRecordPlanBean.getDayIndex() * 24 + i + 1))) | localRecordPlanBean.getRecordType());
          }
          d.b((d)this.U3.get(Integer.valueOf(localRecordPlanBean.getDayIndex() * 24 + localRecordPlanBean.getEndTime() / 60 + 1)), d.a((d)this.U3.get(Integer.valueOf(localRecordPlanBean.getDayIndex() * 24 + localRecordPlanBean.getEndTime() / 60 + 1))) | 0x2);
          locald = (d)this.U3.get(Integer.valueOf(localRecordPlanBean.getDayIndex() * 24 + localRecordPlanBean.getEndTime() / 60 + 1));
          i = d.c((d)this.U3.get(Integer.valueOf(localRecordPlanBean.getDayIndex() * 24 + localRecordPlanBean.getEndTime() / 60 + 1)));
          d.d(locald, localRecordPlanBean.getRecordType() | i);
        }
      }
    }
  }
  
  private void v(boolean paramBoolean, int paramInt, d paramd)
  {
    if (paramd == null) {
      return;
    }
    if (d.a(paramd) == 0) {
      d.b(paramd, 1);
    } else if (d.c(paramd) != this.a4) {
      d.b(paramd, 1);
    } else {
      d.b(paramd, 0);
    }
    if (!paramBoolean) {
      w(paramInt, paramd);
    }
  }
  
  private void w(int paramInt, d paramd)
  {
    paramInt = d.a(paramd);
    if (paramInt != 0)
    {
      if (paramInt == 1) {
        t(d.e(paramd), d.f(paramd), this.a4, d.g(paramd), 1, (TreeSet)this.X3.get(Integer.valueOf(d.g(paramd))));
      }
    }
    else {
      t(d.e(paramd), d.f(paramd), this.a4, d.g(paramd), 0, (TreeSet)this.X3.get(Integer.valueOf(d.g(paramd))));
    }
  }
  
  private Rect x(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = getCommonLeftDistance();
    int j = this.x;
    int k = getCommonLeftDistance();
    int m = this.x;
    return new Rect(i + j * paramInt3, paramInt1, k + paramInt3 * m + m, paramInt2);
  }
  
  private void y(Canvas paramCanvas)
  {
    int i = getCommonLeftDistance();
    int j = getCommonTopDistance();
    int k = getWidth();
    int m = k - (this.y * 3 + this.J3);
    z(paramCanvas);
    this.L3.setColor(ContextCompat.getColor(getContext(), 2131100161));
    int n = 0;
    Object localObject;
    float f1;
    for (int i1 = 0;; i1++)
    {
      localObject = this.I3;
      if (i1 >= localObject.length) {
        break;
      }
      localObject = localObject[i1];
      int i2 = this.x;
      f1 = i1 * i2;
      D(paramCanvas, (String)localObject, this.f, i + f1 + i2 / 2 - e.a(6, getContext()), this.p2 / 2 + this.K3 / 4.0F);
    }
    B(paramCanvas, 0.0F, this.p2, k);
    this.L3.setColor(ContextCompat.getColor(getContext(), 2131100160));
    for (i1 = 0;; i1++)
    {
      localObject = this.H3;
      k = n;
      if (i1 >= localObject.length) {
        break;
      }
      localObject = localObject[i1];
      f1 = this.q * i1 + j;
      D(paramCanvas, (String)localObject, this.d, this.y, f1 + this.K3 / 4.0F);
      float f2 = i;
      B(paramCanvas, f2, f1, m);
      if (i1 != this.H3.length - 1)
      {
        localObject = getContext();
        if (i1 % 2 == 0) {
          k = 2131100158;
        } else {
          k = 2131100159;
        }
        k = ContextCompat.getColor((Context)localObject, k);
        this.O3.setColor(k);
        k = this.p3;
        paramCanvas.drawRect(f2, k + f1, m + i, f1 + this.q - k, this.O3);
      }
    }
    while (k <= this.I3.length)
    {
      f1 = this.x * k;
      E(paramCanvas, getCommonLeftDistance() + f1, getCommonTopDistance(), this.q * 24);
      k++;
    }
  }
  
  private void z(Canvas paramCanvas)
  {
    paramCanvas.drawRect(0.0F, 0.0F, getWidth(), this.p2, this.N3);
  }
  
  public void F(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      setOnTouchListener(this);
      setFocusable(true);
      setClickable(true);
      setLongClickable(true);
    }
    else
    {
      setOnTouchListener(null);
      setFocusable(false);
      setClickable(false);
      setLongClickable(false);
    }
  }
  
  public ArrayList<RecordPlanBean> getAllRecordPlanBeans()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.X3.values().iterator();
    while (localIterator.hasNext()) {
      localArrayList.addAll((TreeSet)localIterator.next());
    }
    return localArrayList;
  }
  
  public int getCurrentRecordType()
  {
    return this.a4;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    C(paramCanvas);
    A(paramCanvas);
    y(paramCanvas);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    ViewGroup localViewGroup = (ViewGroup)getParent();
    if (localViewGroup != null)
    {
      this.x = ((localViewGroup.getWidth() - this.y * 3 - this.J3) / 7);
      this.q = ((localViewGroup.getHeight() - this.z * 2 - this.p0 - this.p1 - this.p2) / 24);
    }
    J();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(M(paramInt1), L(paramInt2));
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    return this.T3.onTouchEvent(paramMotionEvent);
  }
  
  public void setAllWeekRecordPlanByType(int paramInt)
  {
    int i = 2;
    if ((paramInt == 1) || (paramInt != 2)) {
      i = 1;
    }
    ArrayList localArrayList = new ArrayList();
    for (paramInt = 0; paramInt < 7; paramInt++) {
      localArrayList.add(new RecordPlanBean(i, paramInt, 0, 1440));
    }
    setRecordPlanCustomBeans(localArrayList);
  }
  
  public void setCurrentRecordType(int paramInt)
  {
    if ((paramInt != 1) && (paramInt != 2)) {
      this.a4 = 1;
    } else {
      this.a4 = paramInt;
    }
  }
  
  public void setMaxPeriodsNumOneDay(int paramInt)
  {
    this.d4 = paramInt;
  }
  
  public void setRecordPlanCustomBeans(ArrayList<RecordPlanBean> paramArrayList)
  {
    ((TreeSet)this.X3.get(Integer.valueOf(0))).clear();
    ((TreeSet)this.X3.get(Integer.valueOf(1))).clear();
    ((TreeSet)this.X3.get(Integer.valueOf(2))).clear();
    ((TreeSet)this.X3.get(Integer.valueOf(3))).clear();
    ((TreeSet)this.X3.get(Integer.valueOf(4))).clear();
    ((TreeSet)this.X3.get(Integer.valueOf(5))).clear();
    ((TreeSet)this.X3.get(Integer.valueOf(6))).clear();
    if (paramArrayList != null)
    {
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext())
      {
        paramArrayList = (RecordPlanBean)localIterator.next();
        ((TreeSet)this.X3.get(Integer.valueOf(paramArrayList.getDayIndex()))).add(paramArrayList);
      }
    }
    u();
    invalidate();
  }
  
  private class b
    implements GestureDetector.OnGestureListener
  {
    private int c;
    private int d;
    private boolean f;
    private boolean q;
    private boolean x;
    private boolean y;
    
    private b() {}
    
    private void a()
    {
      RecordCustomSettingView localRecordCustomSettingView;
      if (this.f)
      {
        localRecordCustomSettingView = RecordCustomSettingView.this;
        RecordCustomSettingView.l(localRecordCustomSettingView, f(RecordCustomSettingView.p(localRecordCustomSettingView), this.c));
        this.f = false;
      }
      else
      {
        this.d = f(RecordCustomSettingView.p(RecordCustomSettingView.this), this.c);
        if (((RecordCustomSettingView.k(RecordCustomSettingView.this) & this.d) == 4) || ((RecordCustomSettingView.k(RecordCustomSettingView.this) & this.d) == 8))
        {
          this.x = true;
          RecordCustomSettingView.l(RecordCustomSettingView.this, this.d);
        }
      }
      if (this.x)
      {
        localRecordCustomSettingView = RecordCustomSettingView.this;
        RecordCustomSettingView.s(localRecordCustomSettingView, false, RecordCustomSettingView.p(localRecordCustomSettingView), (RecordCustomSettingView.d)RecordCustomSettingView.r(RecordCustomSettingView.this).get(Integer.valueOf(RecordCustomSettingView.p(RecordCustomSettingView.this))));
        this.x = false;
      }
    }
    
    private void b(int paramInt1, int paramInt2)
    {
      RecordCustomSettingView.b(RecordCustomSettingView.this).clear();
      int i = paramInt1 - paramInt2;
      int j;
      if (i > 0) {
        j = paramInt2;
      } else {
        j = paramInt1;
      }
      if (i > 0) {
        i = paramInt1;
      } else {
        i = paramInt2;
      }
      if (j / 24 == i / 24)
      {
        k = j;
        if (paramInt1 > paramInt2) {
          for (paramInt1 = i - 1; paramInt1 >= j; paramInt1--) {
            RecordCustomSettingView.b(RecordCustomSettingView.this).add(Integer.valueOf(paramInt1));
          }
        }
        for (;;)
        {
          k++;
          if (k > i) {
            break;
          }
          RecordCustomSettingView.b(RecordCustomSettingView.this).add(Integer.valueOf(k));
        }
      }
      if ((i - j) % 24 == 0)
      {
        k = j;
        if (paramInt1 > paramInt2) {
          for (;;)
          {
            i -= 24;
            if (i < j) {
              break;
            }
            RecordCustomSettingView.b(RecordCustomSettingView.this).add(Integer.valueOf(i));
          }
        }
        for (;;)
        {
          k += 24;
          if (k > i) {
            break;
          }
          RecordCustomSettingView.b(RecordCustomSettingView.this).add(Integer.valueOf(k));
        }
      }
      int k = j;
      if (paramInt1 > paramInt2) {
        for (;;)
        {
          i -= 24;
          if (i < j) {
            break;
          }
          if (i != j) {
            RecordCustomSettingView.b(RecordCustomSettingView.this).add(Integer.valueOf(i - 1));
          } else {
            RecordCustomSettingView.b(RecordCustomSettingView.this).add(Integer.valueOf(i));
          }
        }
      }
      for (;;)
      {
        k += 24;
        if (k > i) {
          break;
        }
        if (k != i) {
          RecordCustomSettingView.b(RecordCustomSettingView.this).add(Integer.valueOf(k + 1));
        } else {
          RecordCustomSettingView.b(RecordCustomSettingView.this).add(Integer.valueOf(k));
        }
      }
    }
    
    private String c(int paramInt)
    {
      return RecordCustomSettingView.this.getContext().getString(2131953648, new Object[] { Integer.valueOf(paramInt) });
    }
    
    private boolean d(int paramInt1, int paramInt2)
    {
      paramInt1 -= paramInt2;
      return (Math.abs(paramInt1) != 1) && (Math.abs(paramInt1) != 24) && (Math.abs(paramInt1) != 23) && (Math.abs(paramInt1) != 25);
    }
    
    private int f(int paramInt1, int paramInt2)
    {
      if (paramInt1 / 24 == paramInt2 / 24)
      {
        if (paramInt2 - paramInt1 > 0) {
          return 6;
        }
        return 5;
      }
      if (paramInt1 % 24 == paramInt2 % 24)
      {
        if (paramInt2 - paramInt1 > 0) {
          return 10;
        }
        return 9;
      }
      return -1;
    }
    
    public boolean onDown(MotionEvent paramMotionEvent)
    {
      this.x = false;
      this.f = true;
      this.q = false;
      this.y = false;
      int i = RecordCustomSettingView.o(RecordCustomSettingView.this, paramMotionEvent.getX(), paramMotionEvent.getY());
      this.c = i;
      if (i > -1)
      {
        RecordCustomSettingView.q(RecordCustomSettingView.this, i);
        this.q = true;
        paramMotionEvent = RecordCustomSettingView.this;
        RecordCustomSettingView.s(paramMotionEvent, true, RecordCustomSettingView.p(paramMotionEvent), (RecordCustomSettingView.d)RecordCustomSettingView.r(RecordCustomSettingView.this).get(Integer.valueOf(RecordCustomSettingView.p(RecordCustomSettingView.this))));
      }
      else
      {
        RecordCustomSettingView.q(RecordCustomSettingView.this, -1);
      }
      return false;
    }
    
    public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      return true;
    }
    
    public void onLongPress(MotionEvent paramMotionEvent)
    {
      Object localObject;
      if (this.q)
      {
        localObject = RecordCustomSettingView.this;
        RecordCustomSettingView.s((RecordCustomSettingView)localObject, true, RecordCustomSettingView.p((RecordCustomSettingView)localObject), (RecordCustomSettingView.d)RecordCustomSettingView.r(RecordCustomSettingView.this).get(Integer.valueOf(RecordCustomSettingView.p(RecordCustomSettingView.this))));
        this.q = false;
      }
      for (int i = 0; i < RecordCustomSettingView.c(RecordCustomSettingView.this).size(); i++) {
        if (RecordCustomSettingView.c.a((RecordCustomSettingView.c)RecordCustomSettingView.c(RecordCustomSettingView.this).get(i)).contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))
        {
          localObject = RecordCustomSettingView.this;
          RecordCustomSettingView.e((RecordCustomSettingView)localObject, RecordCustomSettingView.c.b((RecordCustomSettingView.c)RecordCustomSettingView.c((RecordCustomSettingView)localObject).get(i)));
          localObject = RecordCustomSettingView.this;
          RecordCustomSettingView.f((RecordCustomSettingView)localObject, RecordCustomSettingView.c.a((RecordCustomSettingView.c)RecordCustomSettingView.c((RecordCustomSettingView)localObject).get(i)));
          RecordCustomSettingView.this.invalidate();
          localObject = new d5.h(RecordCustomSettingView.this.getContext()).j(d5.d, 0, true, true).j(d5.q, 0, true, true).n(true);
          int j;
          if (RecordCustomSettingView.d(RecordCustomSettingView.this).getRecordType() == 1) {
            j = 1;
          } else {
            j = 2;
          }
          localObject = ((d5.h)localObject).l(j, new b()).m(new a()).k();
          ((d5)localObject).v(1, c(RecordCustomSettingView.d(RecordCustomSettingView.this).getStartTime() / 60), c(RecordCustomSettingView.d(RecordCustomSettingView.this).getStartTime() % 60));
          ((d5)localObject).v(2, c(RecordCustomSettingView.d(RecordCustomSettingView.this).getEndTime() / 60), c(RecordCustomSettingView.d(RecordCustomSettingView.this).getEndTime() % 60));
          ((d5)localObject).u();
          ((Dialog)localObject).setOnDismissListener(s3.c);
        }
      }
    }
    
    public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      if ((this.q) && (RecordCustomSettingView.p(RecordCustomSettingView.this) > -1))
      {
        paramMotionEvent1 = (RecordCustomSettingView.d)RecordCustomSettingView.r(RecordCustomSettingView.this).get(Integer.valueOf(RecordCustomSettingView.p(RecordCustomSettingView.this)));
        if (paramMotionEvent1 == null) {
          return true;
        }
        RecordCustomSettingView localRecordCustomSettingView = RecordCustomSettingView.this;
        RecordCustomSettingView.a(localRecordCustomSettingView, RecordCustomSettingView.p(localRecordCustomSettingView), paramMotionEvent1);
        this.q = false;
        this.y = true;
      }
      int i = RecordCustomSettingView.o(RecordCustomSettingView.this, paramMotionEvent2.getX(), paramMotionEvent2.getY());
      this.c = i;
      if ((i > -1) && (i != RecordCustomSettingView.p(RecordCustomSettingView.this)))
      {
        if ((RecordCustomSettingView.p(RecordCustomSettingView.this) > -1) && (d(RecordCustomSettingView.p(RecordCustomSettingView.this), this.c)))
        {
          b(RecordCustomSettingView.p(RecordCustomSettingView.this), this.c);
          for (i = 0; i < RecordCustomSettingView.b(RecordCustomSettingView.this).size(); i++)
          {
            paramMotionEvent1 = RecordCustomSettingView.this;
            RecordCustomSettingView.s(paramMotionEvent1, false, ((Integer)RecordCustomSettingView.b(paramMotionEvent1).get(i)).intValue(), (RecordCustomSettingView.d)RecordCustomSettingView.r(RecordCustomSettingView.this).get(RecordCustomSettingView.b(RecordCustomSettingView.this).get(i)));
          }
          a();
        }
        else
        {
          a();
          paramMotionEvent1 = RecordCustomSettingView.this;
          RecordCustomSettingView.s(paramMotionEvent1, false, this.c, (RecordCustomSettingView.d)RecordCustomSettingView.r(paramMotionEvent1).get(Integer.valueOf(this.c)));
        }
        RecordCustomSettingView.q(RecordCustomSettingView.this, this.c);
        RecordCustomSettingView.this.invalidate();
        this.y = false;
      }
      if (this.y) {
        RecordCustomSettingView.this.invalidate();
      }
      return true;
    }
    
    public void onShowPress(MotionEvent paramMotionEvent) {}
    
    public boolean onSingleTapUp(MotionEvent paramMotionEvent)
    {
      if ((RecordCustomSettingView.o(RecordCustomSettingView.this, paramMotionEvent.getX(), paramMotionEvent.getY()) > -1) && (RecordCustomSettingView.p(RecordCustomSettingView.this) > -1))
      {
        RecordCustomSettingView.d locald = (RecordCustomSettingView.d)RecordCustomSettingView.r(RecordCustomSettingView.this).get(Integer.valueOf(RecordCustomSettingView.p(RecordCustomSettingView.this)));
        if (locald != null)
        {
          paramMotionEvent = RecordCustomSettingView.this;
          RecordCustomSettingView.a(paramMotionEvent, RecordCustomSettingView.p(paramMotionEvent), locald);
          RecordCustomSettingView.this.invalidate();
        }
      }
      return true;
    }
    
    class a
      implements d5.i
    {
      a() {}
      
      public void a(String... paramVarArgs)
      {
        int i = Integer.valueOf(paramVarArgs[0]).intValue() * 60 + Integer.valueOf(paramVarArgs[1]).intValue();
        int j = Integer.valueOf(paramVarArgs[2]).intValue() * 60 + Integer.valueOf(paramVarArgs[3]).intValue();
        if (i >= j)
        {
          s0.n((Activity)RecordCustomSettingView.this.getContext(), 2131951620);
          return;
        }
        if ((i > RecordCustomSettingView.d(RecordCustomSettingView.this).getStartTime()) && (j < RecordCustomSettingView.d(RecordCustomSettingView.this).getEndTime()))
        {
          RecordCustomSettingView.d(RecordCustomSettingView.this).setStartTime(i);
          RecordCustomSettingView.d(RecordCustomSettingView.this).setEndTime(j);
        }
        else
        {
          paramVarArgs = RecordCustomSettingView.this;
          RecordCustomSettingView.h(paramVarArgs, RecordCustomSettingView.d(paramVarArgs).getRecordType());
          ((TreeSet)RecordCustomSettingView.i(RecordCustomSettingView.this).get(Integer.valueOf(RecordCustomSettingView.d(RecordCustomSettingView.this).getDayIndex()))).remove(RecordCustomSettingView.d(RecordCustomSettingView.this));
          paramVarArgs = RecordCustomSettingView.this;
          RecordCustomSettingView.j(paramVarArgs, i, j, RecordCustomSettingView.g(paramVarArgs), RecordCustomSettingView.d(RecordCustomSettingView.this).getDayIndex(), 1, (TreeSet)RecordCustomSettingView.i(RecordCustomSettingView.this).get(Integer.valueOf(RecordCustomSettingView.d(RecordCustomSettingView.this).getDayIndex())));
          RecordCustomSettingView.h(RecordCustomSettingView.this, -1);
        }
        RecordCustomSettingView.this.invalidate();
        RecordCustomSettingView.f(RecordCustomSettingView.this, null);
      }
      
      public void b()
      {
        RecordCustomSettingView.f(RecordCustomSettingView.this, null);
        RecordCustomSettingView.this.invalidate();
      }
    }
    
    class b
      implements d5.j
    {
      b() {}
      
      public void a(int paramInt)
      {
        RecordCustomSettingView.d(RecordCustomSettingView.this).setRecordType(paramInt);
      }
    }
  }
  
  private class c
  {
    private Rect a;
    private RecordPlanBean b;
    
    public c(Rect paramRect, RecordPlanBean paramRecordPlanBean)
    {
      this.a = paramRect;
      this.b = paramRecordPlanBean;
    }
  }
  
  private class d
  {
    private int a;
    private Rect b;
    private int c;
    private int d;
    private int e;
    private int f;
    
    public d(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      this.a = paramInt1;
      this.c = paramInt4;
      this.d = paramInt2;
      this.e = paramInt3;
      this.b = RecordCustomSettingView.n(RecordCustomSettingView.this, RecordCustomSettingView.m(RecordCustomSettingView.this, paramInt2), RecordCustomSettingView.m(RecordCustomSettingView.this, paramInt3), paramInt4);
      this.f = paramInt5;
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool = true;
      if (this == paramObject) {
        return true;
      }
      if ((paramObject != null) && (d.class == paramObject.getClass()))
      {
        Object localObject = (d)paramObject;
        if (this.a != ((d)localObject).a) {
          return false;
        }
        if (this.c != ((d)localObject).c) {
          return false;
        }
        if (this.d != ((d)localObject).d) {
          return false;
        }
        if (this.e != ((d)localObject).e) {
          return false;
        }
        if (this.f != ((d)localObject).f) {
          return false;
        }
        paramObject = this.b;
        localObject = ((d)localObject).b;
        if (paramObject != null) {
          bool = ((Rect)paramObject).equals(localObject);
        } else if (localObject != null) {
          bool = false;
        }
        return bool;
      }
      return false;
    }
    
    public int hashCode()
    {
      int i = this.a;
      Rect localRect = this.b;
      int j;
      if (localRect != null) {
        j = localRect.hashCode();
      } else {
        j = 0;
      }
      return ((((i * 31 + j) * 31 + this.c) * 31 + this.d) * 31 + this.e) * 31 + this.f;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\setting\RecordCustomSettingView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */