package com.google.android.gms.common.data;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

@KeepForSdk
@ShowFirstParty
@SafeParcelable.Class(creator="BitmapTeleporterCreator")
public class BitmapTeleporter
  extends AbstractSafeParcelable
  implements ReflectedParcelable
{
  @KeepForSdk
  public static final Parcelable.Creator<BitmapTeleporter> CREATOR = new zaa();
  @SafeParcelable.Field(id=3)
  private final int mType;
  @SafeParcelable.VersionField(id=1)
  private final int zalf;
  @SafeParcelable.Field(id=2)
  private ParcelFileDescriptor zalg;
  private Bitmap zalh;
  private boolean zali;
  private File zalj;
  
  @SafeParcelable.Constructor
  BitmapTeleporter(@SafeParcelable.Param(id=1) int paramInt1, @SafeParcelable.Param(id=2) ParcelFileDescriptor paramParcelFileDescriptor, @SafeParcelable.Param(id=3) int paramInt2)
  {
    this.zalf = paramInt1;
    this.zalg = paramParcelFileDescriptor;
    this.mType = paramInt2;
    this.zalh = null;
    this.zali = false;
  }
  
  @KeepForSdk
  public BitmapTeleporter(Bitmap paramBitmap)
  {
    this.zalf = 1;
    this.zalg = null;
    this.mType = 0;
    this.zalh = paramBitmap;
    this.zali = true;
  }
  
  private static void zaa(Closeable paramCloseable)
  {
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable)
    {
      Log.w("BitmapTeleporter", "Could not close stream", paramCloseable);
    }
  }
  
  private final FileOutputStream zabz()
  {
    File localFile = this.zalj;
    if (localFile != null) {
      try
      {
        localFile = File.createTempFile("teleporter", ".tmp", localFile);
        try
        {
          FileOutputStream localFileOutputStream = new java/io/FileOutputStream;
          localFileOutputStream.<init>(localFile);
          this.zalg = ParcelFileDescriptor.open(localFile, 268435456);
          localFile.delete();
          return localFileOutputStream;
        }
        catch (FileNotFoundException localFileNotFoundException)
        {
          throw new IllegalStateException("Temporary file is somehow already deleted");
        }
        throw new IllegalStateException("setTempDir() must be called before writing this object to a parcel");
      }
      catch (IOException localIOException)
      {
        throw new IllegalStateException("Could not create temporary file", localIOException);
      }
    }
  }
  
  /* Error */
  @KeepForSdk
  public Bitmap get()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 55	com/google/android/gms/common/data/BitmapTeleporter:zali	Z
    //   4: ifne +122 -> 126
    //   7: new 127	java/io/DataInputStream
    //   10: dup
    //   11: new 129	android/os/ParcelFileDescriptor$AutoCloseInputStream
    //   14: dup
    //   15: aload_0
    //   16: getfield 49	com/google/android/gms/common/data/BitmapTeleporter:zalg	Landroid/os/ParcelFileDescriptor;
    //   19: invokespecial 132	android/os/ParcelFileDescriptor$AutoCloseInputStream:<init>	(Landroid/os/ParcelFileDescriptor;)V
    //   22: invokespecial 135	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   25: astore_1
    //   26: aload_1
    //   27: invokevirtual 139	java/io/DataInputStream:readInt	()I
    //   30: newarray <illegal type>
    //   32: astore_2
    //   33: aload_1
    //   34: invokevirtual 139	java/io/DataInputStream:readInt	()I
    //   37: istore_3
    //   38: aload_1
    //   39: invokevirtual 139	java/io/DataInputStream:readInt	()I
    //   42: istore 4
    //   44: aload_1
    //   45: invokevirtual 143	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   48: invokestatic 149	android/graphics/Bitmap$Config:valueOf	(Ljava/lang/String;)Landroid/graphics/Bitmap$Config;
    //   51: astore 5
    //   53: aload_1
    //   54: aload_2
    //   55: invokevirtual 153	java/io/DataInputStream:read	([B)I
    //   58: pop
    //   59: aload_1
    //   60: invokestatic 155	com/google/android/gms/common/data/BitmapTeleporter:zaa	(Ljava/io/Closeable;)V
    //   63: aload_2
    //   64: invokestatic 161	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   67: astore_1
    //   68: iload_3
    //   69: iload 4
    //   71: aload 5
    //   73: invokestatic 167	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   76: astore 5
    //   78: aload 5
    //   80: aload_1
    //   81: invokevirtual 171	android/graphics/Bitmap:copyPixelsFromBuffer	(Ljava/nio/Buffer;)V
    //   84: aload_0
    //   85: aload 5
    //   87: putfield 53	com/google/android/gms/common/data/BitmapTeleporter:zalh	Landroid/graphics/Bitmap;
    //   90: aload_0
    //   91: iconst_1
    //   92: putfield 55	com/google/android/gms/common/data/BitmapTeleporter:zali	Z
    //   95: goto +31 -> 126
    //   98: astore 5
    //   100: goto +19 -> 119
    //   103: astore 5
    //   105: new 111	java/lang/IllegalStateException
    //   108: astore_2
    //   109: aload_2
    //   110: ldc -83
    //   112: aload 5
    //   114: invokespecial 121	java/lang/IllegalStateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   117: aload_2
    //   118: athrow
    //   119: aload_1
    //   120: invokestatic 155	com/google/android/gms/common/data/BitmapTeleporter:zaa	(Ljava/io/Closeable;)V
    //   123: aload 5
    //   125: athrow
    //   126: aload_0
    //   127: getfield 53	com/google/android/gms/common/data/BitmapTeleporter:zalh	Landroid/graphics/Bitmap;
    //   130: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	131	0	this	BitmapTeleporter
    //   25	95	1	localObject1	Object
    //   32	86	2	localObject2	Object
    //   37	32	3	i	int
    //   42	28	4	j	int
    //   51	35	5	localObject3	Object
    //   98	1	5	localObject4	Object
    //   103	21	5	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   26	59	98	finally
    //   105	119	98	finally
    //   26	59	103	java/io/IOException
  }
  
  @KeepForSdk
  public void release()
  {
    if (!this.zali) {
      try
      {
        this.zalg.close();
        return;
      }
      catch (IOException localIOException)
      {
        Log.w("BitmapTeleporter", "Could not close PFD", localIOException);
      }
    }
  }
  
  @KeepForSdk
  public void setTempDir(File paramFile)
  {
    Objects.requireNonNull(paramFile, "Cannot set null temp directory");
    this.zalj = paramFile;
  }
  
  /* Error */
  public void writeToParcel(android.os.Parcel paramParcel, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 49	com/google/android/gms/common/data/BitmapTeleporter:zalg	Landroid/os/ParcelFileDescriptor;
    //   4: ifnonnull +133 -> 137
    //   7: aload_0
    //   8: getfield 53	com/google/android/gms/common/data/BitmapTeleporter:zalh	Landroid/graphics/Bitmap;
    //   11: astore_3
    //   12: aload_3
    //   13: invokevirtual 191	android/graphics/Bitmap:getRowBytes	()I
    //   16: aload_3
    //   17: invokevirtual 194	android/graphics/Bitmap:getHeight	()I
    //   20: imul
    //   21: invokestatic 198	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   24: astore 4
    //   26: aload_3
    //   27: aload 4
    //   29: invokevirtual 201	android/graphics/Bitmap:copyPixelsToBuffer	(Ljava/nio/Buffer;)V
    //   32: aload 4
    //   34: invokevirtual 205	java/nio/ByteBuffer:array	()[B
    //   37: astore 5
    //   39: new 207	java/io/DataOutputStream
    //   42: dup
    //   43: new 209	java/io/BufferedOutputStream
    //   46: dup
    //   47: aload_0
    //   48: invokespecial 211	com/google/android/gms/common/data/BitmapTeleporter:zabz	()Ljava/io/FileOutputStream;
    //   51: invokespecial 214	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   54: invokespecial 215	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   57: astore 4
    //   59: aload 4
    //   61: aload 5
    //   63: arraylength
    //   64: invokevirtual 219	java/io/DataOutputStream:writeInt	(I)V
    //   67: aload 4
    //   69: aload_3
    //   70: invokevirtual 222	android/graphics/Bitmap:getWidth	()I
    //   73: invokevirtual 219	java/io/DataOutputStream:writeInt	(I)V
    //   76: aload 4
    //   78: aload_3
    //   79: invokevirtual 194	android/graphics/Bitmap:getHeight	()I
    //   82: invokevirtual 219	java/io/DataOutputStream:writeInt	(I)V
    //   85: aload 4
    //   87: aload_3
    //   88: invokevirtual 226	android/graphics/Bitmap:getConfig	()Landroid/graphics/Bitmap$Config;
    //   91: invokevirtual 229	android/graphics/Bitmap$Config:toString	()Ljava/lang/String;
    //   94: invokevirtual 232	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   97: aload 4
    //   99: aload 5
    //   101: invokevirtual 236	java/io/DataOutputStream:write	([B)V
    //   104: aload 4
    //   106: invokestatic 155	com/google/android/gms/common/data/BitmapTeleporter:zaa	(Ljava/io/Closeable;)V
    //   109: goto +28 -> 137
    //   112: astore_1
    //   113: goto +17 -> 130
    //   116: astore_3
    //   117: new 111	java/lang/IllegalStateException
    //   120: astore_1
    //   121: aload_1
    //   122: ldc -18
    //   124: aload_3
    //   125: invokespecial 121	java/lang/IllegalStateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   128: aload_1
    //   129: athrow
    //   130: aload 4
    //   132: invokestatic 155	com/google/android/gms/common/data/BitmapTeleporter:zaa	(Ljava/io/Closeable;)V
    //   135: aload_1
    //   136: athrow
    //   137: aload_1
    //   138: invokestatic 244	com/google/android/gms/common/internal/safeparcel/SafeParcelWriter:beginObjectHeader	(Landroid/os/Parcel;)I
    //   141: istore 6
    //   143: aload_1
    //   144: iconst_1
    //   145: aload_0
    //   146: getfield 47	com/google/android/gms/common/data/BitmapTeleporter:zalf	I
    //   149: invokestatic 247	com/google/android/gms/common/internal/safeparcel/SafeParcelWriter:writeInt	(Landroid/os/Parcel;II)V
    //   152: aload_1
    //   153: iconst_2
    //   154: aload_0
    //   155: getfield 49	com/google/android/gms/common/data/BitmapTeleporter:zalg	Landroid/os/ParcelFileDescriptor;
    //   158: iload_2
    //   159: iconst_1
    //   160: ior
    //   161: iconst_0
    //   162: invokestatic 251	com/google/android/gms/common/internal/safeparcel/SafeParcelWriter:writeParcelable	(Landroid/os/Parcel;ILandroid/os/Parcelable;IZ)V
    //   165: aload_1
    //   166: iconst_3
    //   167: aload_0
    //   168: getfield 51	com/google/android/gms/common/data/BitmapTeleporter:mType	I
    //   171: invokestatic 247	com/google/android/gms/common/internal/safeparcel/SafeParcelWriter:writeInt	(Landroid/os/Parcel;II)V
    //   174: aload_1
    //   175: iload 6
    //   177: invokestatic 254	com/google/android/gms/common/internal/safeparcel/SafeParcelWriter:finishObjectHeader	(Landroid/os/Parcel;I)V
    //   180: aload_0
    //   181: aconst_null
    //   182: putfield 49	com/google/android/gms/common/data/BitmapTeleporter:zalg	Landroid/os/ParcelFileDescriptor;
    //   185: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	186	0	this	BitmapTeleporter
    //   0	186	1	paramParcel	android.os.Parcel
    //   0	186	2	paramInt	int
    //   11	77	3	localBitmap	Bitmap
    //   116	9	3	localIOException	IOException
    //   24	107	4	localObject	Object
    //   37	63	5	arrayOfByte	byte[]
    //   141	35	6	i	int
    // Exception table:
    //   from	to	target	type
    //   59	104	112	finally
    //   117	130	112	finally
    //   59	104	116	java/io/IOException
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\data\BitmapTeleporter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */