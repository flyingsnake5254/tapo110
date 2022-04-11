package com.google.android.exoplayer2.offline;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import com.google.android.exoplayer2.scheduler.Requirements;
import com.google.android.exoplayer2.util.b0;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.u;
import java.util.HashMap;
import java.util.List;

public abstract class DownloadService
  extends Service
{
  private static final HashMap<Class<? extends DownloadService>, b> c = new HashMap();
  @Nullable
  private final c d;
  @Nullable
  private final String f;
  private boolean p0;
  private boolean p1;
  private boolean p2;
  private boolean p3;
  @StringRes
  private final int q;
  @StringRes
  private final int x;
  private d y;
  private int z;
  
  private static Intent e(Context paramContext, Class<? extends DownloadService> paramClass, String paramString)
  {
    return new Intent(paramContext, paramClass).setAction(paramString);
  }
  
  private boolean g()
  {
    return this.p2;
  }
  
  private static boolean h(int paramInt)
  {
    boolean bool;
    if ((paramInt != 2) && (paramInt != 5) && (paramInt != 7)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  private void i(List<b> paramList)
  {
    if (this.d != null)
    {
      int i = 0;
      while (i < paramList.size()) {
        if (!h(((b)paramList.get(i)).a)) {
          i++;
        } else {
          throw null;
        }
      }
    }
  }
  
  private void j()
  {
    if (this.d == null)
    {
      if ((o0.a < 28) && (this.p1))
      {
        stopSelf();
        this.p2 = true;
      }
      else
      {
        this.p2 |= stopSelfResult(this.z);
      }
      return;
    }
    throw null;
  }
  
  protected abstract d d();
  
  @Nullable
  protected abstract com.google.android.exoplayer2.scheduler.d f();
  
  @Nullable
  public final IBinder onBind(Intent paramIntent)
  {
    throw new UnsupportedOperationException();
  }
  
  public void onCreate()
  {
    Object localObject = this.f;
    if (localObject != null) {
      b0.a(this, (String)localObject, this.q, this.x, 2);
    }
    Class localClass = getClass();
    HashMap localHashMap = c;
    localObject = (b)localHashMap.get(localClass);
    if (localObject == null)
    {
      boolean bool;
      if (this.d != null) {
        bool = true;
      } else {
        bool = false;
      }
      if (bool) {
        localObject = f();
      } else {
        localObject = null;
      }
      d locald = d();
      this.y = locald;
      locald.n();
      localObject = new b(getApplicationContext(), this.y, bool, (com.google.android.exoplayer2.scheduler.d)localObject, localClass, null);
      localHashMap.put(localClass, localObject);
    }
    else
    {
      this.y = b.c((b)localObject);
    }
    ((b)localObject).d(this);
  }
  
  public void onDestroy()
  {
    this.p3 = true;
    ((b)g.e((b)c.get(getClass()))).e(this);
    if (this.d == null) {
      return;
    }
    throw null;
  }
  
  public int onStartCommand(@Nullable Intent paramIntent, int paramInt1, int paramInt2)
  {
    this.z = paramInt2;
    this.p1 = false;
    Object localObject1;
    Object localObject2;
    if (paramIntent != null)
    {
      localObject1 = paramIntent.getAction();
      localObject2 = paramIntent.getStringExtra("content_id");
      int i = this.p0;
      if ((!paramIntent.getBooleanExtra("foreground", false)) && (!"com.google.android.exoplayer.downloadService.action.RESTART".equals(localObject1))) {
        paramInt1 = 0;
      } else {
        paramInt1 = 1;
      }
      this.p0 = (i | paramInt1);
    }
    else
    {
      localObject1 = null;
      localObject2 = localObject1;
    }
    Object localObject3 = localObject1;
    if (localObject1 == null) {
      localObject3 = "com.google.android.exoplayer.downloadService.action.INIT";
    }
    d locald = (d)g.e(this.y);
    paramInt1 = -1;
    switch (((String)localObject3).hashCode())
    {
    default: 
      break;
    case 1547520644: 
      if (((String)localObject3).equals("com.google.android.exoplayer.downloadService.action.REMOVE_DOWNLOAD")) {
        paramInt1 = 8;
      }
      break;
    case 1015676687: 
      if (((String)localObject3).equals("com.google.android.exoplayer.downloadService.action.INIT")) {
        paramInt1 = 7;
      }
      break;
    case 671523141: 
      if (((String)localObject3).equals("com.google.android.exoplayer.downloadService.action.SET_STOP_REASON")) {
        paramInt1 = 6;
      }
      break;
    case 191112771: 
      if (((String)localObject3).equals("com.google.android.exoplayer.downloadService.action.PAUSE_DOWNLOADS")) {
        paramInt1 = 5;
      }
      break;
    case -119057172: 
      if (((String)localObject3).equals("com.google.android.exoplayer.downloadService.action.SET_REQUIREMENTS")) {
        paramInt1 = 4;
      }
      break;
    case -650547439: 
      if (((String)localObject3).equals("com.google.android.exoplayer.downloadService.action.REMOVE_ALL_DOWNLOADS")) {
        paramInt1 = 3;
      }
      break;
    case -871181424: 
      if (((String)localObject3).equals("com.google.android.exoplayer.downloadService.action.RESTART")) {
        paramInt1 = 2;
      }
      break;
    case -932047176: 
      if (((String)localObject3).equals("com.google.android.exoplayer.downloadService.action.RESUME_DOWNLOADS")) {
        paramInt1 = 1;
      }
      break;
    case -1931239035: 
      if (((String)localObject3).equals("com.google.android.exoplayer.downloadService.action.ADD_DOWNLOAD")) {
        paramInt1 = 0;
      }
      break;
    }
    switch (paramInt1)
    {
    default: 
      if (((String)localObject3).length() != 0) {
        paramIntent = "Ignored unrecognized action: ".concat((String)localObject3);
      } else {
        paramIntent = new String("Ignored unrecognized action: ");
      }
      u.c("DownloadService", paramIntent);
      break;
    case 8: 
      if (localObject2 == null) {
        u.c("DownloadService", "Ignored REMOVE_DOWNLOAD: Missing content_id extra");
      } else {
        locald.m((String)localObject2);
      }
      break;
    case 6: 
      if (!((Intent)g.e(paramIntent)).hasExtra("stop_reason")) {
        u.c("DownloadService", "Ignored SET_STOP_REASON: Missing stop_reason extra");
      } else {
        locald.q((String)localObject2, paramIntent.getIntExtra("stop_reason", 0));
      }
      break;
    case 5: 
      locald.k();
      break;
    case 4: 
      localObject1 = (Requirements)((Intent)g.e(paramIntent)).getParcelableExtra("requirements");
      if (localObject1 == null)
      {
        u.c("DownloadService", "Ignored SET_REQUIREMENTS: Missing requirements extra");
      }
      else
      {
        localObject2 = f();
        paramIntent = (Intent)localObject1;
        if (localObject2 != null)
        {
          localObject2 = ((com.google.android.exoplayer2.scheduler.d)localObject2).b((Requirements)localObject1);
          paramIntent = (Intent)localObject1;
          if (!((Requirements)localObject2).equals(localObject1))
          {
            paramInt2 = ((Requirements)localObject1).c();
            paramInt1 = ((Requirements)localObject2).c();
            paramIntent = new StringBuilder(65);
            paramIntent.append("Ignoring requirements not supported by the Scheduler: ");
            paramIntent.append(paramInt2 ^ paramInt1);
            u.h("DownloadService", paramIntent.toString());
            paramIntent = (Intent)localObject2;
          }
        }
        locald.p(paramIntent);
      }
      break;
    case 3: 
      locald.l();
      break;
    case 1: 
      locald.n();
      break;
    case 0: 
      localObject1 = (DownloadRequest)((Intent)g.e(paramIntent)).getParcelableExtra("download_request");
      if (localObject1 == null) {
        u.c("DownloadService", "Ignored ADD_DOWNLOAD: Missing download_request extra");
      } else {
        locald.a((DownloadRequest)localObject1, paramIntent.getIntExtra("stop_reason", 0));
      }
      break;
    }
    if ((o0.a >= 26) && (this.p0) && (this.d != null)) {
      throw null;
    }
    this.p2 = false;
    if (locald.f()) {
      j();
    }
    return 1;
  }
  
  public void onTaskRemoved(Intent paramIntent)
  {
    this.p1 = true;
  }
  
  private static final class b
    implements d.a
  {
    private final Context a;
    private final d b;
    private final boolean c;
    @Nullable
    private final com.google.android.exoplayer2.scheduler.d d;
    private final Class<? extends DownloadService> e;
    @Nullable
    private DownloadService f;
    
    private b(Context paramContext, d paramd, boolean paramBoolean, @Nullable com.google.android.exoplayer2.scheduler.d paramd1, Class<? extends DownloadService> paramClass)
    {
      this.a = paramContext;
      this.b = paramd;
      this.c = paramBoolean;
      this.d = paramd1;
      this.e = paramClass;
      paramd.b(this);
      j();
    }
    
    private void h()
    {
      Intent localIntent;
      if (this.c)
      {
        localIntent = DownloadService.c(this.a, this.e, "com.google.android.exoplayer.downloadService.action.RESTART");
        o0.H0(this.a, localIntent);
      }
      else
      {
        try
        {
          localIntent = DownloadService.c(this.a, this.e, "com.google.android.exoplayer.downloadService.action.INIT");
          this.a.startService(localIntent);
        }
        catch (IllegalStateException localIllegalStateException)
        {
          u.h("DownloadService", "Failed to restart DownloadService (process is idle).");
        }
      }
    }
    
    private boolean i()
    {
      DownloadService localDownloadService = this.f;
      boolean bool;
      if ((localDownloadService != null) && (!DownloadService.b(localDownloadService))) {
        bool = false;
      } else {
        bool = true;
      }
      return bool;
    }
    
    private void j()
    {
      if (this.d == null) {
        return;
      }
      if (this.b.h())
      {
        String str = this.a.getPackageName();
        Requirements localRequirements = this.b.e();
        if (!this.d.a(localRequirements, str, "com.google.android.exoplayer.downloadService.action.RESTART")) {
          u.c("DownloadService", "Scheduling downloads failed.");
        }
      }
      else
      {
        this.d.cancel();
      }
    }
    
    public void a(d paramd, boolean paramBoolean)
    {
      if ((!paramBoolean) && (!paramd.d()) && (i()))
      {
        paramd = paramd.c();
        for (int i = 0; i < paramd.size(); i++) {
          if (((b)paramd.get(i)).a == 0)
          {
            h();
            break;
          }
        }
      }
      j();
    }
    
    public void d(DownloadService paramDownloadService)
    {
      boolean bool;
      if (this.f == null) {
        bool = true;
      } else {
        bool = false;
      }
      g.g(bool);
      this.f = paramDownloadService;
      if (this.b.g()) {
        o0.x().postAtFrontOfQueue(new a(this, paramDownloadService));
      }
    }
    
    public void e(DownloadService paramDownloadService)
    {
      boolean bool;
      if (this.f == paramDownloadService) {
        bool = true;
      } else {
        bool = false;
      }
      g.g(bool);
      this.f = null;
      if ((this.d != null) && (!this.b.h())) {
        this.d.cancel();
      }
    }
  }
  
  private final class c {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\offline\DownloadService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */