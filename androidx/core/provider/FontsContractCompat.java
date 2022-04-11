package androidx.core.provider;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Typeface;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import android.os.CancellationSignal;
import android.os.Handler;
import android.provider.BaseColumns;
import androidx.annotation.GuardedBy;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.collection.LruCache;
import androidx.collection.SimpleArrayMap;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.content.res.ResourcesCompat.FontCallback;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.graphics.TypefaceCompatUtil;
import androidx.core.util.Preconditions;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

public class FontsContractCompat
{
  private static final int BACKGROUND_THREAD_KEEP_ALIVE_DURATION_MS = 10000;
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public static final String PARCEL_FONT_RESULTS = "font_results";
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  static final int RESULT_CODE_PROVIDER_NOT_FOUND = -1;
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  static final int RESULT_CODE_WRONG_CERTIFICATES = -2;
  private static final SelfDestructiveThread sBackgroundThread;
  private static final Comparator<byte[]> sByteArrayComparator = new Comparator()
  {
    public int compare(byte[] paramAnonymousArrayOfByte1, byte[] paramAnonymousArrayOfByte2)
    {
      int i;
      if (paramAnonymousArrayOfByte1.length != paramAnonymousArrayOfByte2.length)
      {
        i = paramAnonymousArrayOfByte1.length;
        j = paramAnonymousArrayOfByte2.length;
        return i - j;
      }
      for (int j = 0;; j++)
      {
        if (j >= paramAnonymousArrayOfByte1.length) {
          break label60;
        }
        if (paramAnonymousArrayOfByte1[j] != paramAnonymousArrayOfByte2[j])
        {
          i = paramAnonymousArrayOfByte1[j];
          j = paramAnonymousArrayOfByte2[j];
          break;
        }
      }
      label60:
      return 0;
    }
  };
  static final Object sLock;
  @GuardedBy("sLock")
  static final SimpleArrayMap<String, ArrayList<SelfDestructiveThread.ReplyCallback<TypefaceResult>>> sPendingReplies;
  static final LruCache<String, Typeface> sTypefaceCache = new LruCache(16);
  
  static
  {
    sBackgroundThread = new SelfDestructiveThread("fonts", 10, 10000);
    sLock = new Object();
    sPendingReplies = new SimpleArrayMap();
  }
  
  @Nullable
  public static Typeface buildTypeface(@NonNull Context paramContext, @Nullable CancellationSignal paramCancellationSignal, @NonNull FontInfo[] paramArrayOfFontInfo)
  {
    return TypefaceCompat.createFromFontInfo(paramContext, paramCancellationSignal, paramArrayOfFontInfo, 0);
  }
  
  private static List<byte[]> convertToByteArrayList(Signature[] paramArrayOfSignature)
  {
    ArrayList localArrayList = new ArrayList();
    for (int i = 0; i < paramArrayOfSignature.length; i++) {
      localArrayList.add(paramArrayOfSignature[i].toByteArray());
    }
    return localArrayList;
  }
  
  private static boolean equalsByteArrayList(List<byte[]> paramList1, List<byte[]> paramList2)
  {
    if (paramList1.size() != paramList2.size()) {
      return false;
    }
    for (int i = 0; i < paramList1.size(); i++) {
      if (!Arrays.equals((byte[])paramList1.get(i), (byte[])paramList2.get(i))) {
        return false;
      }
    }
    return true;
  }
  
  @NonNull
  public static FontFamilyResult fetchFonts(@NonNull Context paramContext, @Nullable CancellationSignal paramCancellationSignal, @NonNull FontRequest paramFontRequest)
    throws PackageManager.NameNotFoundException
  {
    ProviderInfo localProviderInfo = getProvider(paramContext.getPackageManager(), paramFontRequest, paramContext.getResources());
    if (localProviderInfo == null) {
      return new FontFamilyResult(1, null);
    }
    return new FontFamilyResult(0, getFontFromProvider(paramContext, paramFontRequest, localProviderInfo.authority, paramCancellationSignal));
  }
  
  private static List<List<byte[]>> getCertificates(FontRequest paramFontRequest, Resources paramResources)
  {
    if (paramFontRequest.getCertificates() != null) {
      return paramFontRequest.getCertificates();
    }
    return FontResourcesParserCompat.readCerts(paramResources, paramFontRequest.getCertificatesArrayResId());
  }
  
  @NonNull
  @VisibleForTesting
  static FontInfo[] getFontFromProvider(Context paramContext, FontRequest paramFontRequest, String paramString, CancellationSignal paramCancellationSignal)
  {
    Object localObject1 = new ArrayList();
    Uri localUri1 = new Uri.Builder().scheme("content").authority(paramString).build();
    Uri localUri2 = new Uri.Builder().scheme("content").authority(paramString).appendPath("file").build();
    Object localObject2 = null;
    paramString = (String)localObject2;
    try
    {
      if (Build.VERSION.SDK_INT > 16)
      {
        paramString = (String)localObject2;
        paramContext = paramContext.getContentResolver();
        paramString = (String)localObject2;
        paramFontRequest = paramFontRequest.getQuery();
        paramString = (String)localObject2;
        paramContext = paramContext.query(localUri1, new String[] { "_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code" }, "query = ?", new String[] { paramFontRequest }, null, paramCancellationSignal);
      }
      else
      {
        paramString = (String)localObject2;
        paramContext = paramContext.getContentResolver();
        paramString = (String)localObject2;
        paramFontRequest = paramFontRequest.getQuery();
        paramString = (String)localObject2;
        paramContext = paramContext.query(localUri1, new String[] { "_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code" }, "query = ?", new String[] { paramFontRequest }, null);
      }
      paramFontRequest = (FontRequest)localObject1;
      if (paramContext != null)
      {
        paramFontRequest = (FontRequest)localObject1;
        paramString = paramContext;
        if (paramContext.getCount() > 0)
        {
          paramString = paramContext;
          int i = paramContext.getColumnIndex("result_code");
          paramString = paramContext;
          paramCancellationSignal = new java/util/ArrayList;
          paramString = paramContext;
          paramCancellationSignal.<init>();
          paramString = paramContext;
          int j = paramContext.getColumnIndex("_id");
          paramString = paramContext;
          int k = paramContext.getColumnIndex("file_id");
          paramString = paramContext;
          int m = paramContext.getColumnIndex("font_ttc_index");
          paramString = paramContext;
          int n = paramContext.getColumnIndex("font_weight");
          paramString = paramContext;
          int i1 = paramContext.getColumnIndex("font_italic");
          for (;;)
          {
            paramString = paramContext;
            if (!paramContext.moveToNext()) {
              break;
            }
            int i2;
            if (i != -1)
            {
              paramString = paramContext;
              i2 = paramContext.getInt(i);
            }
            else
            {
              i2 = 0;
            }
            int i3;
            if (m != -1)
            {
              paramString = paramContext;
              i3 = paramContext.getInt(m);
            }
            else
            {
              i3 = 0;
            }
            if (k == -1)
            {
              paramString = paramContext;
              paramFontRequest = ContentUris.withAppendedId(localUri1, paramContext.getLong(j));
            }
            else
            {
              paramString = paramContext;
              paramFontRequest = ContentUris.withAppendedId(localUri2, paramContext.getLong(k));
            }
            int i4;
            if (n != -1)
            {
              paramString = paramContext;
              i4 = paramContext.getInt(n);
            }
            else
            {
              i4 = 400;
            }
            if (i1 != -1)
            {
              paramString = paramContext;
              if (paramContext.getInt(i1) == 1)
              {
                bool = true;
                break label498;
              }
            }
            boolean bool = false;
            label498:
            paramString = paramContext;
            localObject1 = new androidx/core/provider/FontsContractCompat$FontInfo;
            paramString = paramContext;
            ((FontInfo)localObject1).<init>(paramFontRequest, i3, i4, bool, i2);
            paramString = paramContext;
            paramCancellationSignal.add(localObject1);
          }
          paramFontRequest = paramCancellationSignal;
        }
      }
      return (FontInfo[])paramFontRequest.toArray(new FontInfo[0]);
    }
    finally
    {
      if (paramString != null) {
        paramString.close();
      }
    }
  }
  
  @NonNull
  static TypefaceResult getFontInternal(Context paramContext, FontRequest paramFontRequest, int paramInt)
  {
    try
    {
      paramFontRequest = fetchFonts(paramContext, null, paramFontRequest);
      int i = paramFontRequest.getStatusCode();
      int j = -3;
      if (i == 0)
      {
        paramContext = TypefaceCompat.createFromFontInfo(paramContext, null, paramFontRequest.getFonts(), paramInt);
        if (paramContext != null) {
          j = 0;
        }
        return new TypefaceResult(paramContext, j);
      }
      if (paramFontRequest.getStatusCode() == 1) {
        j = -2;
      }
      return new TypefaceResult(null, j);
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return new TypefaceResult(null, -1);
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public static Typeface getFontSync(Context paramContext, final FontRequest paramFontRequest, @Nullable ResourcesCompat.FontCallback arg2, @Nullable final Handler paramHandler, boolean paramBoolean, int paramInt1, final int paramInt2)
  {
    final Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramFontRequest.getIdentifier());
    ((StringBuilder)localObject1).append("-");
    ((StringBuilder)localObject1).append(paramInt2);
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = (Typeface)sTypefaceCache.get(localObject1);
    if (localObject2 != null)
    {
      if (??? != null) {
        ???.onFontRetrieved((Typeface)localObject2);
      }
      return (Typeface)localObject2;
    }
    if ((paramBoolean) && (paramInt1 == -1))
    {
      paramContext = getFontInternal(paramContext, paramFontRequest, paramInt2);
      if (??? != null)
      {
        paramInt1 = paramContext.mResult;
        if (paramInt1 == 0) {
          ???.callbackSuccessAsync(paramContext.mTypeface, paramHandler);
        } else {
          ???.callbackFailAsync(paramInt1, paramHandler);
        }
      }
      return paramContext.mTypeface;
    }
    paramFontRequest = new Callable()
    {
      public FontsContractCompat.TypefaceResult call()
        throws Exception
      {
        FontsContractCompat.TypefaceResult localTypefaceResult = FontsContractCompat.getFontInternal(FontsContractCompat.this, paramFontRequest, paramInt2);
        Typeface localTypeface = localTypefaceResult.mTypeface;
        if (localTypeface != null) {
          FontsContractCompat.sTypefaceCache.put(localObject1, localTypeface);
        }
        return localTypefaceResult;
      }
    };
    paramContext = null;
    if (paramBoolean) {}
    try
    {
      paramFontRequest = ((TypefaceResult)sBackgroundThread.postAndWait(paramFontRequest, paramInt1)).mTypeface;
      paramContext = paramFontRequest;
    }
    catch (InterruptedException paramFontRequest)
    {
      for (;;) {}
    }
    return paramContext;
    if (??? == null) {
      paramContext = null;
    } else {
      paramContext = new SelfDestructiveThread.ReplyCallback()
      {
        public void onReply(FontsContractCompat.TypefaceResult paramAnonymousTypefaceResult)
        {
          if (paramAnonymousTypefaceResult == null)
          {
            FontsContractCompat.this.callbackFailAsync(1, paramHandler);
          }
          else
          {
            int i = paramAnonymousTypefaceResult.mResult;
            if (i == 0) {
              FontsContractCompat.this.callbackSuccessAsync(paramAnonymousTypefaceResult.mTypeface, paramHandler);
            } else {
              FontsContractCompat.this.callbackFailAsync(i, paramHandler);
            }
          }
        }
      };
    }
    synchronized (sLock)
    {
      paramHandler = sPendingReplies;
      localObject2 = (ArrayList)paramHandler.get(localObject1);
      if (localObject2 != null)
      {
        if (paramContext != null) {
          ((ArrayList)localObject2).add(paramContext);
        }
        return null;
      }
      if (paramContext != null)
      {
        localObject2 = new java/util/ArrayList;
        ((ArrayList)localObject2).<init>();
        ((ArrayList)localObject2).add(paramContext);
        paramHandler.put(localObject1, localObject2);
      }
      sBackgroundThread.postAndReply(paramFontRequest, new SelfDestructiveThread.ReplyCallback()
      {
        public void onReply(FontsContractCompat.TypefaceResult paramAnonymousTypefaceResult)
        {
          synchronized (FontsContractCompat.sLock)
          {
            SimpleArrayMap localSimpleArrayMap = FontsContractCompat.sPendingReplies;
            ArrayList localArrayList = (ArrayList)localSimpleArrayMap.get(FontsContractCompat.this);
            if (localArrayList == null) {
              return;
            }
            localSimpleArrayMap.remove(FontsContractCompat.this);
            for (int i = 0; i < localArrayList.size(); i++) {
              ((SelfDestructiveThread.ReplyCallback)localArrayList.get(i)).onReply(paramAnonymousTypefaceResult);
            }
            return;
          }
        }
      });
      return null;
    }
  }
  
  @Nullable
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  @VisibleForTesting
  public static ProviderInfo getProvider(@NonNull PackageManager paramPackageManager, @NonNull FontRequest paramFontRequest, @Nullable Resources paramResources)
    throws PackageManager.NameNotFoundException
  {
    String str = paramFontRequest.getProviderAuthority();
    int i = 0;
    ProviderInfo localProviderInfo = paramPackageManager.resolveContentProvider(str, 0);
    if (localProviderInfo != null)
    {
      if (localProviderInfo.packageName.equals(paramFontRequest.getProviderPackage()))
      {
        paramPackageManager = convertToByteArrayList(paramPackageManager.getPackageInfo(localProviderInfo.packageName, 64).signatures);
        Collections.sort(paramPackageManager, sByteArrayComparator);
        paramFontRequest = getCertificates(paramFontRequest, paramResources);
        while (i < paramFontRequest.size())
        {
          paramResources = new ArrayList((Collection)paramFontRequest.get(i));
          Collections.sort(paramResources, sByteArrayComparator);
          if (equalsByteArrayList(paramPackageManager, paramResources)) {
            return localProviderInfo;
          }
          i++;
        }
        return null;
      }
      paramPackageManager = new StringBuilder();
      paramPackageManager.append("Found content provider ");
      paramPackageManager.append(str);
      paramPackageManager.append(", but package was not ");
      paramPackageManager.append(paramFontRequest.getProviderPackage());
      throw new PackageManager.NameNotFoundException(paramPackageManager.toString());
    }
    paramPackageManager = new StringBuilder();
    paramPackageManager.append("No package found for authority: ");
    paramPackageManager.append(str);
    throw new PackageManager.NameNotFoundException(paramPackageManager.toString());
  }
  
  @RequiresApi(19)
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public static Map<Uri, ByteBuffer> prepareFontData(Context paramContext, FontInfo[] paramArrayOfFontInfo, CancellationSignal paramCancellationSignal)
  {
    HashMap localHashMap = new HashMap();
    int i = paramArrayOfFontInfo.length;
    for (int j = 0; j < i; j++)
    {
      Object localObject = paramArrayOfFontInfo[j];
      if (((FontInfo)localObject).getResultCode() == 0)
      {
        localObject = ((FontInfo)localObject).getUri();
        if (!localHashMap.containsKey(localObject)) {
          localHashMap.put(localObject, TypefaceCompatUtil.mmap(paramContext, paramCancellationSignal, (Uri)localObject));
        }
      }
    }
    return Collections.unmodifiableMap(localHashMap);
  }
  
  public static void requestFont(@NonNull Context paramContext, @NonNull FontRequest paramFontRequest, @NonNull FontRequestCallback paramFontRequestCallback, @NonNull Handler paramHandler)
  {
    requestFontInternal(paramContext.getApplicationContext(), paramFontRequest, paramFontRequestCallback, paramHandler);
  }
  
  private static void requestFontInternal(@NonNull Context paramContext, @NonNull final FontRequest paramFontRequest, @NonNull final FontRequestCallback paramFontRequestCallback, @NonNull Handler paramHandler)
  {
    paramHandler.post(new Runnable()
    {
      public void run()
      {
        try
        {
          final Object localObject = FontsContractCompat.fetchFonts(FontsContractCompat.this, null, paramFontRequest);
          final int i;
          if (((FontsContractCompat.FontFamilyResult)localObject).getStatusCode() != 0)
          {
            i = ((FontsContractCompat.FontFamilyResult)localObject).getStatusCode();
            if (i != 1)
            {
              if (i != 2)
              {
                this.val$callerThreadHandler.post(new Runnable()
                {
                  public void run()
                  {
                    FontsContractCompat.4.this.val$callback.onTypefaceRequestFailed(-3);
                  }
                });
                return;
              }
              this.val$callerThreadHandler.post(new Runnable()
              {
                public void run()
                {
                  FontsContractCompat.4.this.val$callback.onTypefaceRequestFailed(-3);
                }
              });
              return;
            }
            this.val$callerThreadHandler.post(new Runnable()
            {
              public void run()
              {
                FontsContractCompat.4.this.val$callback.onTypefaceRequestFailed(-2);
              }
            });
            return;
          }
          FontsContractCompat.FontInfo[] arrayOfFontInfo = ((FontsContractCompat.FontFamilyResult)localObject).getFonts();
          if ((arrayOfFontInfo != null) && (arrayOfFontInfo.length != 0))
          {
            int j = arrayOfFontInfo.length;
            for (i = 0; i < j; i++)
            {
              localObject = arrayOfFontInfo[i];
              if (((FontsContractCompat.FontInfo)localObject).getResultCode() != 0)
              {
                i = ((FontsContractCompat.FontInfo)localObject).getResultCode();
                if (i < 0) {
                  this.val$callerThreadHandler.post(new Runnable()
                  {
                    public void run()
                    {
                      FontsContractCompat.4.this.val$callback.onTypefaceRequestFailed(-3);
                    }
                  });
                } else {
                  this.val$callerThreadHandler.post(new Runnable()
                  {
                    public void run()
                    {
                      FontsContractCompat.4.this.val$callback.onTypefaceRequestFailed(i);
                    }
                  });
                }
                return;
              }
            }
            localObject = FontsContractCompat.buildTypeface(FontsContractCompat.this, null, arrayOfFontInfo);
            if (localObject == null)
            {
              this.val$callerThreadHandler.post(new Runnable()
              {
                public void run()
                {
                  FontsContractCompat.4.this.val$callback.onTypefaceRequestFailed(-3);
                }
              });
              return;
            }
            this.val$callerThreadHandler.post(new Runnable()
            {
              public void run()
              {
                FontsContractCompat.4.this.val$callback.onTypefaceRetrieved(localObject);
              }
            });
            return;
          }
          this.val$callerThreadHandler.post(new Runnable()
          {
            public void run()
            {
              FontsContractCompat.4.this.val$callback.onTypefaceRequestFailed(1);
            }
          });
          return;
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException)
        {
          this.val$callerThreadHandler.post(new Runnable()
          {
            public void run()
            {
              FontsContractCompat.4.this.val$callback.onTypefaceRequestFailed(-1);
            }
          });
        }
      }
    });
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public static void resetCache()
  {
    sTypefaceCache.evictAll();
  }
  
  public static final class Columns
    implements BaseColumns
  {
    public static final String FILE_ID = "file_id";
    public static final String ITALIC = "font_italic";
    public static final String RESULT_CODE = "result_code";
    public static final int RESULT_CODE_FONT_NOT_FOUND = 1;
    public static final int RESULT_CODE_FONT_UNAVAILABLE = 2;
    public static final int RESULT_CODE_MALFORMED_QUERY = 3;
    public static final int RESULT_CODE_OK = 0;
    public static final String TTC_INDEX = "font_ttc_index";
    public static final String VARIATION_SETTINGS = "font_variation_settings";
    public static final String WEIGHT = "font_weight";
  }
  
  public static class FontFamilyResult
  {
    public static final int STATUS_OK = 0;
    public static final int STATUS_UNEXPECTED_DATA_PROVIDED = 2;
    public static final int STATUS_WRONG_CERTIFICATES = 1;
    private final FontsContractCompat.FontInfo[] mFonts;
    private final int mStatusCode;
    
    @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public FontFamilyResult(int paramInt, @Nullable FontsContractCompat.FontInfo[] paramArrayOfFontInfo)
    {
      this.mStatusCode = paramInt;
      this.mFonts = paramArrayOfFontInfo;
    }
    
    public FontsContractCompat.FontInfo[] getFonts()
    {
      return this.mFonts;
    }
    
    public int getStatusCode()
    {
      return this.mStatusCode;
    }
  }
  
  public static class FontInfo
  {
    private final boolean mItalic;
    private final int mResultCode;
    private final int mTtcIndex;
    private final Uri mUri;
    private final int mWeight;
    
    @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public FontInfo(@NonNull Uri paramUri, @IntRange(from=0L) int paramInt1, @IntRange(from=1L, to=1000L) int paramInt2, boolean paramBoolean, int paramInt3)
    {
      this.mUri = ((Uri)Preconditions.checkNotNull(paramUri));
      this.mTtcIndex = paramInt1;
      this.mWeight = paramInt2;
      this.mItalic = paramBoolean;
      this.mResultCode = paramInt3;
    }
    
    public int getResultCode()
    {
      return this.mResultCode;
    }
    
    @IntRange(from=0L)
    public int getTtcIndex()
    {
      return this.mTtcIndex;
    }
    
    @NonNull
    public Uri getUri()
    {
      return this.mUri;
    }
    
    @IntRange(from=1L, to=1000L)
    public int getWeight()
    {
      return this.mWeight;
    }
    
    public boolean isItalic()
    {
      return this.mItalic;
    }
  }
  
  public static class FontRequestCallback
  {
    public static final int FAIL_REASON_FONT_LOAD_ERROR = -3;
    public static final int FAIL_REASON_FONT_NOT_FOUND = 1;
    public static final int FAIL_REASON_FONT_UNAVAILABLE = 2;
    public static final int FAIL_REASON_MALFORMED_QUERY = 3;
    public static final int FAIL_REASON_PROVIDER_NOT_FOUND = -1;
    public static final int FAIL_REASON_SECURITY_VIOLATION = -4;
    public static final int FAIL_REASON_WRONG_CERTIFICATES = -2;
    @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final int RESULT_OK = 0;
    
    public void onTypefaceRequestFailed(int paramInt) {}
    
    public void onTypefaceRetrieved(Typeface paramTypeface) {}
    
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static @interface FontRequestFailReason {}
  }
  
  private static final class TypefaceResult
  {
    final int mResult;
    final Typeface mTypeface;
    
    TypefaceResult(@Nullable Typeface paramTypeface, int paramInt)
    {
      this.mTypeface = paramTypeface;
      this.mResult = paramInt;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\provider\FontsContractCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */