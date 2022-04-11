package androidx.navigation;

import android.content.Intent;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NavDeepLinkRequest
{
  private final String mAction;
  private final String mMimeType;
  private final Uri mUri;
  
  NavDeepLinkRequest(@NonNull Intent paramIntent)
  {
    this(paramIntent.getData(), paramIntent.getAction(), paramIntent.getType());
  }
  
  NavDeepLinkRequest(@Nullable Uri paramUri, @Nullable String paramString1, @Nullable String paramString2)
  {
    this.mUri = paramUri;
    this.mAction = paramString1;
    this.mMimeType = paramString2;
  }
  
  @Nullable
  public String getAction()
  {
    return this.mAction;
  }
  
  @Nullable
  public String getMimeType()
  {
    return this.mMimeType;
  }
  
  @Nullable
  public Uri getUri()
  {
    return this.mUri;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("NavDeepLinkRequest");
    localStringBuilder.append("{");
    if (this.mUri != null)
    {
      localStringBuilder.append(" uri=");
      localStringBuilder.append(this.mUri.toString());
    }
    if (this.mAction != null)
    {
      localStringBuilder.append(" action=");
      localStringBuilder.append(this.mAction);
    }
    if (this.mMimeType != null)
    {
      localStringBuilder.append(" mimetype=");
      localStringBuilder.append(this.mMimeType);
    }
    localStringBuilder.append(" }");
    return localStringBuilder.toString();
  }
  
  public static final class Builder
  {
    private String mAction;
    private String mMimeType;
    private Uri mUri;
    
    @NonNull
    public static Builder fromAction(@NonNull String paramString)
    {
      if (!paramString.isEmpty())
      {
        Builder localBuilder = new Builder();
        localBuilder.setAction(paramString);
        return localBuilder;
      }
      throw new IllegalArgumentException("The NavDeepLinkRequest cannot have an empty action.");
    }
    
    @NonNull
    public static Builder fromMimeType(@NonNull String paramString)
    {
      Builder localBuilder = new Builder();
      localBuilder.setMimeType(paramString);
      return localBuilder;
    }
    
    @NonNull
    public static Builder fromUri(@NonNull Uri paramUri)
    {
      Builder localBuilder = new Builder();
      localBuilder.setUri(paramUri);
      return localBuilder;
    }
    
    @NonNull
    public NavDeepLinkRequest build()
    {
      return new NavDeepLinkRequest(this.mUri, this.mAction, this.mMimeType);
    }
    
    @NonNull
    public Builder setAction(@NonNull String paramString)
    {
      if (!paramString.isEmpty())
      {
        this.mAction = paramString;
        return this;
      }
      throw new IllegalArgumentException("The NavDeepLinkRequest cannot have an empty action.");
    }
    
    @NonNull
    public Builder setMimeType(@NonNull String paramString)
    {
      if (Pattern.compile("^[-\\w*.]+/[-\\w+*.]+$").matcher(paramString).matches())
      {
        this.mMimeType = paramString;
        return this;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("The given mimeType ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" does not match to required \"type/subtype\" format");
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    
    @NonNull
    public Builder setUri(@NonNull Uri paramUri)
    {
      this.mUri = paramUri;
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\navigation\NavDeepLinkRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */