package com.tplink.iot.viewmodel.account;

import android.app.Application;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.net.Uri;
import android.provider.MediaStore.Images.Media;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import b.d.c.a.e;
import com.tplink.cloud.bean.webservice.result.AccountAvatarResult;
import com.tplink.cloud.context.TCAccountBean;
import com.tplink.iot.Utils.p;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.TCAccountRepository;
import com.tplink.libtpnetwork.Utils.o;
import io.reactivex.e0.c;
import io.reactivex.g0.j;
import io.reactivex.q;
import io.reactivex.t;
import java.io.File;
import java.io.IOException;

public class AccountInfoViewModel
  extends AndroidViewModel
{
  private o a = o.h0();
  private TCAccountRepository b = (TCAccountRepository)b.d.b.f.b.a(b.d.s.a.a.f(), TCAccountRepository.class);
  private TPIoTClientManager c = (TPIoTClientManager)b.d.b.f.b.a(b.d.s.a.a.f(), TPIoTClientManager.class);
  private String d = null;
  private MediatorLiveData<TCAccountBean> e = new MediatorLiveData();
  private MutableLiveData<Boolean> f = new MutableLiveData();
  private MutableLiveData<h> g = new MutableLiveData();
  private MutableLiveData<Boolean> h = new MutableLiveData();
  
  public AccountInfoViewModel(@NonNull Application paramApplication)
  {
    super(paramApplication);
    this.e.addSource(this.b.r(), new a());
  }
  
  private Bitmap m(Uri paramUri, Matrix paramMatrix)
    throws IOException
  {
    Bitmap localBitmap = MediaStore.Images.Media.getBitmap(getApplication().getContentResolver(), paramUri);
    int i = localBitmap.getWidth();
    int j = localBitmap.getHeight();
    int k;
    if (i > j) {
      k = j;
    } else {
      k = i;
    }
    if (paramMatrix != null) {
      paramUri = Bitmap.createBitmap(localBitmap, (i - k) / 2, (j - k) / 2, k, k, paramMatrix, true);
    } else {
      paramUri = Bitmap.createBitmap(localBitmap, (i - k) / 2, (j - k) / 2, k, k);
    }
    localBitmap.isRecycled();
    return paramUri;
  }
  
  /* Error */
  private byte[] n(Bitmap paramBitmap)
  {
    // Byte code:
    //   0: new 158	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: aload_0
    //   10: invokevirtual 124	androidx/lifecycle/AndroidViewModel:getApplication	()Landroid/app/Application;
    //   13: invokevirtual 163	android/app/Application:getCacheDir	()Ljava/io/File;
    //   16: invokevirtual 169	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   19: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: pop
    //   23: aload_2
    //   24: ldc -81
    //   26: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: aload_2
    //   31: ldc -79
    //   33: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: pop
    //   37: new 165	java/io/File
    //   40: dup
    //   41: aload_2
    //   42: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokespecial 183	java/io/File:<init>	(Ljava/lang/String;)V
    //   48: astore_3
    //   49: ldc -71
    //   51: aload_3
    //   52: invokevirtual 169	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   55: invokestatic 190	b/d/w/c/a:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   58: new 192	android/graphics/Matrix
    //   61: dup
    //   62: invokespecial 193	android/graphics/Matrix:<init>	()V
    //   65: astore 4
    //   67: new 195	java/io/ByteArrayOutputStream
    //   70: dup
    //   71: invokespecial 196	java/io/ByteArrayOutputStream:<init>	()V
    //   74: astore 5
    //   76: aload_1
    //   77: getstatic 202	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   80: bipush 100
    //   82: aload 5
    //   84: invokevirtual 206	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   87: pop
    //   88: aload 5
    //   90: invokevirtual 209	java/io/ByteArrayOutputStream:size	()I
    //   93: istore 6
    //   95: aload 4
    //   97: ldc -46
    //   99: ldc -46
    //   101: invokevirtual 214	android/graphics/Matrix:setScale	(FF)V
    //   104: aconst_null
    //   105: astore 7
    //   107: aconst_null
    //   108: astore 8
    //   110: aload_1
    //   111: astore 9
    //   113: ldc -46
    //   115: fstore 10
    //   117: iload 6
    //   119: ldc -41
    //   121: if_icmple +107 -> 228
    //   124: aload 5
    //   126: invokevirtual 218	java/io/ByteArrayOutputStream:reset	()V
    //   129: aload_1
    //   130: iconst_0
    //   131: iconst_0
    //   132: aload_1
    //   133: invokevirtual 142	android/graphics/Bitmap:getWidth	()I
    //   136: aload_1
    //   137: invokevirtual 145	android/graphics/Bitmap:getHeight	()I
    //   140: aload 4
    //   142: iconst_1
    //   143: invokestatic 149	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   146: astore_2
    //   147: aload_2
    //   148: getstatic 202	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   151: bipush 100
    //   153: aload 5
    //   155: invokevirtual 206	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   158: pop
    //   159: aload 5
    //   161: invokevirtual 209	java/io/ByteArrayOutputStream:size	()I
    //   164: istore 11
    //   166: iload 11
    //   168: istore 6
    //   170: aload_2
    //   171: astore 9
    //   173: iload 11
    //   175: ldc -41
    //   177: if_icmple -60 -> 117
    //   180: fload 10
    //   182: ldc -37
    //   184: fmul
    //   185: fstore 12
    //   187: aload 4
    //   189: fload 12
    //   191: fload 12
    //   193: invokevirtual 214	android/graphics/Matrix:setScale	(FF)V
    //   196: iload 11
    //   198: istore 6
    //   200: aload_2
    //   201: astore 9
    //   203: fload 12
    //   205: fstore 10
    //   207: aload_2
    //   208: invokevirtual 156	android/graphics/Bitmap:isRecycled	()Z
    //   211: ifne -94 -> 117
    //   214: aconst_null
    //   215: astore 9
    //   217: iload 11
    //   219: istore 6
    //   221: fload 12
    //   223: fstore 10
    //   225: goto -108 -> 117
    //   228: new 221	java/io/FileOutputStream
    //   231: astore_2
    //   232: aload_2
    //   233: aload_3
    //   234: invokespecial 224	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   237: new 226	java/io/BufferedOutputStream
    //   240: astore_1
    //   241: aload_1
    //   242: aload_2
    //   243: invokespecial 229	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   246: aload_1
    //   247: astore_3
    //   248: aload_2
    //   249: astore 7
    //   251: aload 9
    //   253: getstatic 202	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   256: bipush 100
    //   258: aload_1
    //   259: invokevirtual 206	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   262: pop
    //   263: aload_1
    //   264: astore_3
    //   265: aload_2
    //   266: astore 7
    //   268: aload_1
    //   269: invokevirtual 232	java/io/BufferedOutputStream:flush	()V
    //   272: aload_1
    //   273: astore_3
    //   274: aload_2
    //   275: astore 7
    //   277: aload_2
    //   278: invokevirtual 233	java/io/FileOutputStream:flush	()V
    //   281: aload_1
    //   282: invokevirtual 236	java/io/BufferedOutputStream:close	()V
    //   285: goto +11 -> 296
    //   288: astore_1
    //   289: aload_1
    //   290: invokevirtual 237	java/io/IOException:toString	()Ljava/lang/String;
    //   293: invokestatic 239	b/d/w/c/a:d	(Ljava/lang/String;)V
    //   296: aload_2
    //   297: invokevirtual 240	java/io/FileOutputStream:close	()V
    //   300: goto +82 -> 382
    //   303: astore 9
    //   305: goto +26 -> 331
    //   308: astore_1
    //   309: goto +112 -> 421
    //   312: astore 9
    //   314: aconst_null
    //   315: astore_1
    //   316: goto +15 -> 331
    //   319: astore_1
    //   320: aconst_null
    //   321: astore_2
    //   322: goto +99 -> 421
    //   325: astore 9
    //   327: aconst_null
    //   328: astore_2
    //   329: aload_2
    //   330: astore_1
    //   331: aload_1
    //   332: astore_3
    //   333: aload_2
    //   334: astore 7
    //   336: aload 9
    //   338: invokevirtual 237	java/io/IOException:toString	()Ljava/lang/String;
    //   341: invokestatic 239	b/d/w/c/a:d	(Ljava/lang/String;)V
    //   344: aload_1
    //   345: ifnull +18 -> 363
    //   348: aload_1
    //   349: invokevirtual 236	java/io/BufferedOutputStream:close	()V
    //   352: goto +11 -> 363
    //   355: astore_1
    //   356: aload_1
    //   357: invokevirtual 237	java/io/IOException:toString	()Ljava/lang/String;
    //   360: invokestatic 239	b/d/w/c/a:d	(Ljava/lang/String;)V
    //   363: aload_2
    //   364: ifnull +18 -> 382
    //   367: aload_2
    //   368: invokevirtual 240	java/io/FileOutputStream:close	()V
    //   371: goto +11 -> 382
    //   374: astore_1
    //   375: aload_1
    //   376: invokevirtual 237	java/io/IOException:toString	()Ljava/lang/String;
    //   379: invokestatic 239	b/d/w/c/a:d	(Ljava/lang/String;)V
    //   382: aload 5
    //   384: invokevirtual 241	java/io/ByteArrayOutputStream:flush	()V
    //   387: aload 5
    //   389: invokevirtual 242	java/io/ByteArrayOutputStream:close	()V
    //   392: aload 5
    //   394: invokevirtual 246	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   397: astore_1
    //   398: goto +14 -> 412
    //   401: astore_1
    //   402: aload_1
    //   403: invokevirtual 237	java/io/IOException:toString	()Ljava/lang/String;
    //   406: invokestatic 239	b/d/w/c/a:d	(Ljava/lang/String;)V
    //   409: aload 8
    //   411: astore_1
    //   412: aload_1
    //   413: areturn
    //   414: astore_1
    //   415: aload 7
    //   417: astore_2
    //   418: aload_3
    //   419: astore 7
    //   421: aload 7
    //   423: ifnull +21 -> 444
    //   426: aload 7
    //   428: invokevirtual 236	java/io/BufferedOutputStream:close	()V
    //   431: goto +13 -> 444
    //   434: astore 7
    //   436: aload 7
    //   438: invokevirtual 237	java/io/IOException:toString	()Ljava/lang/String;
    //   441: invokestatic 239	b/d/w/c/a:d	(Ljava/lang/String;)V
    //   444: aload_2
    //   445: ifnull +18 -> 463
    //   448: aload_2
    //   449: invokevirtual 240	java/io/FileOutputStream:close	()V
    //   452: goto +11 -> 463
    //   455: astore_2
    //   456: aload_2
    //   457: invokevirtual 237	java/io/IOException:toString	()Ljava/lang/String;
    //   460: invokestatic 239	b/d/w/c/a:d	(Ljava/lang/String;)V
    //   463: aload_1
    //   464: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	465	0	this	AccountInfoViewModel
    //   0	465	1	paramBitmap	Bitmap
    //   7	442	2	localObject1	Object
    //   455	2	2	localIOException1	IOException
    //   48	371	3	localObject2	Object
    //   65	123	4	localMatrix	Matrix
    //   74	319	5	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   93	127	6	i	int
    //   105	322	7	localObject3	Object
    //   434	3	7	localIOException2	IOException
    //   108	302	8	localObject4	Object
    //   111	141	9	localObject5	Object
    //   303	1	9	localIOException3	IOException
    //   312	1	9	localIOException4	IOException
    //   325	12	9	localIOException5	IOException
    //   115	109	10	f1	float
    //   164	54	11	j	int
    //   185	37	12	f2	float
    // Exception table:
    //   from	to	target	type
    //   281	285	288	java/io/IOException
    //   251	263	303	java/io/IOException
    //   268	272	303	java/io/IOException
    //   277	281	303	java/io/IOException
    //   237	246	308	finally
    //   237	246	312	java/io/IOException
    //   228	237	319	finally
    //   228	237	325	java/io/IOException
    //   348	352	355	java/io/IOException
    //   296	300	374	java/io/IOException
    //   367	371	374	java/io/IOException
    //   382	398	401	java/io/IOException
    //   251	263	414	finally
    //   268	272	414	finally
    //   277	281	414	finally
    //   336	344	414	finally
    //   426	431	434	java/io/IOException
    //   448	452	455	java/io/IOException
  }
  
  private void o(MutableLiveData<Boolean> paramMutableLiveData)
  {
    if (this.b.y()) {
      paramMutableLiveData.setValue(Boolean.TRUE);
    } else {
      paramMutableLiveData.setValue(null);
    }
  }
  
  private int v(String paramString)
  {
    int i = 0;
    try
    {
      ExifInterface localExifInterface = new androidx/exifinterface/media/ExifInterface;
      localExifInterface.<init>(paramString);
      int j = localExifInterface.getAttributeInt("Orientation", 1);
      if (j != 3)
      {
        if (j != 6)
        {
          if (j == 8) {
            i = 270;
          }
        }
        else {
          i = 90;
        }
      }
      else {
        i = 180;
      }
    }
    catch (IOException paramString)
    {
      b.d.w.c.a.d(paramString.toString());
    }
    return i;
  }
  
  public void A(File paramFile)
  {
    if (paramFile == null)
    {
      this.g.setValue(new h(1));
      return;
    }
    int i = v(paramFile.getAbsolutePath());
    Matrix localMatrix = new Matrix();
    localMatrix.postRotate(i);
    z(Uri.fromFile(paramFile), localMatrix);
  }
  
  public LiveData<TCAccountBean> p()
  {
    return this.e;
  }
  
  public LiveData<h> r()
  {
    return this.g;
  }
  
  public LiveData<Boolean> s()
  {
    return this.f;
  }
  
  public String t()
  {
    String str = this.a.f(this.d, "");
    if (!str.isEmpty())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(getApplication().getCacheDir().getAbsolutePath());
      localStringBuilder.append("/image_cache/");
      localStringBuilder.append(str);
      if (new File(localStringBuilder.toString()).exists()) {
        return str;
      }
    }
    return "";
  }
  
  public LiveData<Boolean> u()
  {
    return this.h;
  }
  
  public void w()
  {
    this.c.d3().C(io.reactivex.l0.a.c()).l(new g()).h(new f()).y();
  }
  
  public void x()
  {
    o(this.f);
  }
  
  public void y(String paramString)
  {
    Object localObject = this.a.f(this.d, "");
    paramString = paramString.substring(paramString.lastIndexOf("/") + 1);
    if (!((String)localObject).equals(paramString))
    {
      if (!((String)localObject).isEmpty())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(getApplication().getCacheDir().getAbsolutePath());
        localStringBuilder.append("/image_cache/");
        localStringBuilder.append((String)localObject);
        localObject = new File(localStringBuilder.toString());
        if (((File)localObject).exists()) {
          ((File)localObject).delete();
        }
      }
      this.a.k(this.d, paramString);
    }
  }
  
  public void z(Uri paramUri, final Matrix paramMatrix)
  {
    if (!this.b.y())
    {
      this.g.setValue(null);
      return;
    }
    q.f0(paramUri).g0(new e(paramMatrix)).N(new d()).L0(io.reactivex.l0.a.c()).H0(new b(), new c());
  }
  
  class a
    implements Observer<TCAccountBean>
  {
    a() {}
    
    public void a(@Nullable TCAccountBean paramTCAccountBean)
    {
      if (paramTCAccountBean != null) {
        AccountInfoViewModel.f(AccountInfoViewModel.this, paramTCAccountBean.getCloudUserName());
      }
      AccountInfoViewModel.g(AccountInfoViewModel.this).setValue(paramTCAccountBean);
    }
  }
  
  class b
    implements io.reactivex.g0.g<AccountAvatarResult>
  {
    b() {}
    
    public void a(AccountAvatarResult paramAccountAvatarResult)
      throws Exception
    {
      AccountInfoViewModel.h(AccountInfoViewModel.this).postValue(new AccountInfoViewModel.h(AccountInfoViewModel.this, 0));
    }
  }
  
  class c
    implements io.reactivex.g0.g<Throwable>
  {
    c() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      AccountInfoViewModel.h(AccountInfoViewModel.this).postValue(new AccountInfoViewModel.h(AccountInfoViewModel.this, 1));
    }
  }
  
  class d
    implements j<byte[], t<AccountAvatarResult>>
  {
    d() {}
    
    public t<AccountAvatarResult> a(byte[] paramArrayOfByte)
      throws Exception
    {
      return AccountInfoViewModel.i(AccountInfoViewModel.this).b0("image/png", paramArrayOfByte);
    }
  }
  
  class e
    implements j<Uri, byte[]>
  {
    e(Matrix paramMatrix) {}
    
    public byte[] a(Uri paramUri)
      throws Exception
    {
      paramUri = AccountInfoViewModel.j(AccountInfoViewModel.this, paramUri, paramMatrix);
      AccountInfoViewModel.h(AccountInfoViewModel.this).postValue(new AccountInfoViewModel.h(AccountInfoViewModel.this, -1, paramUri));
      return AccountInfoViewModel.k(AccountInfoViewModel.this, paramUri);
    }
  }
  
  class f
    implements io.reactivex.g0.a
  {
    f() {}
    
    public void run()
      throws Exception
    {
      e.l().d("");
      e.l().a("");
      b.d.n.f.b.l().clear();
      p.c();
      AccountInfoViewModel.l(AccountInfoViewModel.this).postValue(Boolean.TRUE);
    }
  }
  
  class g
    implements io.reactivex.g0.g<c>
  {
    g() {}
    
    public void a(c paramc)
      throws Exception
    {
      AccountInfoViewModel.l(AccountInfoViewModel.this).setValue(null);
    }
  }
  
  public class h
  {
    private int a;
    private Bitmap b;
    
    public h(int paramInt)
    {
      this.a = paramInt;
    }
    
    public h(int paramInt, Bitmap paramBitmap)
    {
      this.a = paramInt;
      this.b = paramBitmap;
    }
    
    public int a()
    {
      return this.a;
    }
    
    public Bitmap b()
    {
      return this.b;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\account\AccountInfoViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */