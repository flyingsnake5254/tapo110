package io.netty.handler.codec.http.websocketx;

import io.netty.util.internal.ObjectUtil;

public final class WebSocketDecoderConfig
{
  static final WebSocketDecoderConfig DEFAULT = new WebSocketDecoderConfig(65536, true, false, false, true, true);
  private final boolean allowExtensions;
  private final boolean allowMaskMismatch;
  private final boolean closeOnProtocolViolation;
  private final boolean expectMaskedFrames;
  private final int maxFramePayloadLength;
  private final boolean withUTF8Validator;
  
  private WebSocketDecoderConfig(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    this.maxFramePayloadLength = paramInt;
    this.expectMaskedFrames = paramBoolean1;
    this.allowMaskMismatch = paramBoolean2;
    this.allowExtensions = paramBoolean3;
    this.closeOnProtocolViolation = paramBoolean4;
    this.withUTF8Validator = paramBoolean5;
  }
  
  public static Builder newBuilder()
  {
    return new Builder(DEFAULT, null);
  }
  
  public boolean allowExtensions()
  {
    return this.allowExtensions;
  }
  
  public boolean allowMaskMismatch()
  {
    return this.allowMaskMismatch;
  }
  
  public boolean closeOnProtocolViolation()
  {
    return this.closeOnProtocolViolation;
  }
  
  public boolean expectMaskedFrames()
  {
    return this.expectMaskedFrames;
  }
  
  public int maxFramePayloadLength()
  {
    return this.maxFramePayloadLength;
  }
  
  public Builder toBuilder()
  {
    return new Builder(this, null);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WebSocketDecoderConfig [maxFramePayloadLength=");
    localStringBuilder.append(this.maxFramePayloadLength);
    localStringBuilder.append(", expectMaskedFrames=");
    localStringBuilder.append(this.expectMaskedFrames);
    localStringBuilder.append(", allowMaskMismatch=");
    localStringBuilder.append(this.allowMaskMismatch);
    localStringBuilder.append(", allowExtensions=");
    localStringBuilder.append(this.allowExtensions);
    localStringBuilder.append(", closeOnProtocolViolation=");
    localStringBuilder.append(this.closeOnProtocolViolation);
    localStringBuilder.append(", withUTF8Validator=");
    localStringBuilder.append(this.withUTF8Validator);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public boolean withUTF8Validator()
  {
    return this.withUTF8Validator;
  }
  
  public static final class Builder
  {
    private boolean allowExtensions;
    private boolean allowMaskMismatch;
    private boolean closeOnProtocolViolation;
    private boolean expectMaskedFrames;
    private int maxFramePayloadLength;
    private boolean withUTF8Validator;
    
    private Builder(WebSocketDecoderConfig paramWebSocketDecoderConfig)
    {
      ObjectUtil.checkNotNull(paramWebSocketDecoderConfig, "decoderConfig");
      this.maxFramePayloadLength = paramWebSocketDecoderConfig.maxFramePayloadLength();
      this.expectMaskedFrames = paramWebSocketDecoderConfig.expectMaskedFrames();
      this.allowMaskMismatch = paramWebSocketDecoderConfig.allowMaskMismatch();
      this.allowExtensions = paramWebSocketDecoderConfig.allowExtensions();
      this.closeOnProtocolViolation = paramWebSocketDecoderConfig.closeOnProtocolViolation();
      this.withUTF8Validator = paramWebSocketDecoderConfig.withUTF8Validator();
    }
    
    public Builder allowExtensions(boolean paramBoolean)
    {
      this.allowExtensions = paramBoolean;
      return this;
    }
    
    public Builder allowMaskMismatch(boolean paramBoolean)
    {
      this.allowMaskMismatch = paramBoolean;
      return this;
    }
    
    public WebSocketDecoderConfig build()
    {
      return new WebSocketDecoderConfig(this.maxFramePayloadLength, this.expectMaskedFrames, this.allowMaskMismatch, this.allowExtensions, this.closeOnProtocolViolation, this.withUTF8Validator, null);
    }
    
    public Builder closeOnProtocolViolation(boolean paramBoolean)
    {
      this.closeOnProtocolViolation = paramBoolean;
      return this;
    }
    
    public Builder expectMaskedFrames(boolean paramBoolean)
    {
      this.expectMaskedFrames = paramBoolean;
      return this;
    }
    
    public Builder maxFramePayloadLength(int paramInt)
    {
      this.maxFramePayloadLength = paramInt;
      return this;
    }
    
    public Builder withUTF8Validator(boolean paramBoolean)
    {
      this.withUTF8Validator = paramBoolean;
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\websocketx\WebSocketDecoderConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */