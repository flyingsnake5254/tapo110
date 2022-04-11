package androidx.core.hardware.fingerprint;

import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.fingerprint.FingerprintManager;
import android.hardware.fingerprint.FingerprintManager.AuthenticationCallback;
import android.hardware.fingerprint.FingerprintManager.AuthenticationResult;
import android.hardware.fingerprint.FingerprintManager.CryptoObject;
import android.os.Build.VERSION;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

@Deprecated
public class FingerprintManagerCompat
{
  private final Context mContext;
  
  private FingerprintManagerCompat(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  @NonNull
  public static FingerprintManagerCompat from(@NonNull Context paramContext)
  {
    return new FingerprintManagerCompat(paramContext);
  }
  
  @Nullable
  @RequiresApi(23)
  private static FingerprintManager getFingerprintManagerOrNull(@NonNull Context paramContext)
  {
    int i = Build.VERSION.SDK_INT;
    if (i == 23) {
      return (FingerprintManager)paramContext.getSystemService(FingerprintManager.class);
    }
    if ((i > 23) && (paramContext.getPackageManager().hasSystemFeature("android.hardware.fingerprint"))) {
      return (FingerprintManager)paramContext.getSystemService(FingerprintManager.class);
    }
    return null;
  }
  
  @RequiresApi(23)
  static CryptoObject unwrapCryptoObject(FingerprintManager.CryptoObject paramCryptoObject)
  {
    CryptoObject localCryptoObject = null;
    if (paramCryptoObject == null) {
      return null;
    }
    if (paramCryptoObject.getCipher() != null) {
      return new CryptoObject(paramCryptoObject.getCipher());
    }
    if (paramCryptoObject.getSignature() != null) {
      return new CryptoObject(paramCryptoObject.getSignature());
    }
    if (paramCryptoObject.getMac() != null) {
      localCryptoObject = new CryptoObject(paramCryptoObject.getMac());
    }
    return localCryptoObject;
  }
  
  @RequiresApi(23)
  private static FingerprintManager.AuthenticationCallback wrapCallback(AuthenticationCallback paramAuthenticationCallback)
  {
    new FingerprintManager.AuthenticationCallback()
    {
      public void onAuthenticationError(int paramAnonymousInt, CharSequence paramAnonymousCharSequence)
      {
        FingerprintManagerCompat.this.onAuthenticationError(paramAnonymousInt, paramAnonymousCharSequence);
      }
      
      public void onAuthenticationFailed()
      {
        FingerprintManagerCompat.this.onAuthenticationFailed();
      }
      
      public void onAuthenticationHelp(int paramAnonymousInt, CharSequence paramAnonymousCharSequence)
      {
        FingerprintManagerCompat.this.onAuthenticationHelp(paramAnonymousInt, paramAnonymousCharSequence);
      }
      
      public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult paramAnonymousAuthenticationResult)
      {
        FingerprintManagerCompat.this.onAuthenticationSucceeded(new FingerprintManagerCompat.AuthenticationResult(FingerprintManagerCompat.unwrapCryptoObject(paramAnonymousAuthenticationResult.getCryptoObject())));
      }
    };
  }
  
  @RequiresApi(23)
  private static FingerprintManager.CryptoObject wrapCryptoObject(CryptoObject paramCryptoObject)
  {
    FingerprintManager.CryptoObject localCryptoObject = null;
    if (paramCryptoObject == null) {
      return null;
    }
    if (paramCryptoObject.getCipher() != null) {
      return new FingerprintManager.CryptoObject(paramCryptoObject.getCipher());
    }
    if (paramCryptoObject.getSignature() != null) {
      return new FingerprintManager.CryptoObject(paramCryptoObject.getSignature());
    }
    if (paramCryptoObject.getMac() != null) {
      localCryptoObject = new FingerprintManager.CryptoObject(paramCryptoObject.getMac());
    }
    return localCryptoObject;
  }
  
  @RequiresPermission("android.permission.USE_FINGERPRINT")
  public void authenticate(@Nullable CryptoObject paramCryptoObject, int paramInt, @Nullable androidx.core.os.CancellationSignal paramCancellationSignal, @NonNull AuthenticationCallback paramAuthenticationCallback, @Nullable Handler paramHandler)
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      FingerprintManager localFingerprintManager = getFingerprintManagerOrNull(this.mContext);
      if (localFingerprintManager != null)
      {
        if (paramCancellationSignal != null) {
          paramCancellationSignal = (android.os.CancellationSignal)paramCancellationSignal.getCancellationSignalObject();
        } else {
          paramCancellationSignal = null;
        }
        localFingerprintManager.authenticate(wrapCryptoObject(paramCryptoObject), paramCancellationSignal, paramInt, wrapCallback(paramAuthenticationCallback), paramHandler);
      }
    }
  }
  
  @RequiresPermission("android.permission.USE_FINGERPRINT")
  public boolean hasEnrolledFingerprints()
  {
    int i = Build.VERSION.SDK_INT;
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (i >= 23)
    {
      FingerprintManager localFingerprintManager = getFingerprintManagerOrNull(this.mContext);
      bool2 = bool1;
      if (localFingerprintManager != null)
      {
        bool2 = bool1;
        if (localFingerprintManager.hasEnrolledFingerprints()) {
          bool2 = true;
        }
      }
    }
    return bool2;
  }
  
  @RequiresPermission("android.permission.USE_FINGERPRINT")
  public boolean isHardwareDetected()
  {
    int i = Build.VERSION.SDK_INT;
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (i >= 23)
    {
      FingerprintManager localFingerprintManager = getFingerprintManagerOrNull(this.mContext);
      bool2 = bool1;
      if (localFingerprintManager != null)
      {
        bool2 = bool1;
        if (localFingerprintManager.isHardwareDetected()) {
          bool2 = true;
        }
      }
    }
    return bool2;
  }
  
  public static abstract class AuthenticationCallback
  {
    public void onAuthenticationError(int paramInt, CharSequence paramCharSequence) {}
    
    public void onAuthenticationFailed() {}
    
    public void onAuthenticationHelp(int paramInt, CharSequence paramCharSequence) {}
    
    public void onAuthenticationSucceeded(FingerprintManagerCompat.AuthenticationResult paramAuthenticationResult) {}
  }
  
  public static final class AuthenticationResult
  {
    private final FingerprintManagerCompat.CryptoObject mCryptoObject;
    
    public AuthenticationResult(FingerprintManagerCompat.CryptoObject paramCryptoObject)
    {
      this.mCryptoObject = paramCryptoObject;
    }
    
    public FingerprintManagerCompat.CryptoObject getCryptoObject()
    {
      return this.mCryptoObject;
    }
  }
  
  public static class CryptoObject
  {
    private final Cipher mCipher;
    private final Mac mMac;
    private final Signature mSignature;
    
    public CryptoObject(@NonNull Signature paramSignature)
    {
      this.mSignature = paramSignature;
      this.mCipher = null;
      this.mMac = null;
    }
    
    public CryptoObject(@NonNull Cipher paramCipher)
    {
      this.mCipher = paramCipher;
      this.mSignature = null;
      this.mMac = null;
    }
    
    public CryptoObject(@NonNull Mac paramMac)
    {
      this.mMac = paramMac;
      this.mCipher = null;
      this.mSignature = null;
    }
    
    @Nullable
    public Cipher getCipher()
    {
      return this.mCipher;
    }
    
    @Nullable
    public Mac getMac()
    {
      return this.mMac;
    }
    
    @Nullable
    public Signature getSignature()
    {
      return this.mSignature;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\hardware\fingerprint\FingerprintManagerCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */