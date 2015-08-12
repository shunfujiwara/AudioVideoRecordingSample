package com.serenegiant.glutils;

/**
 * ポスタライズフィルター.
 *
 * Created by u1aryz on 2015/08/11.
 */
public class GLPosterizeFilter extends GLFilter {

  public static final String POSTERIZE_FRAGMENT_SHADER = "" +
      "#extension GL_OES_EGL_image_external : require\n" +
      "varying highp vec2 vTextureCoord;\n" +
      "\n" +
      "uniform samplerExternalOES inputImageTexture;\n" +
      "float colorLevels = 10.0;\n" +
      "\n" +
      "void main()\n" +
      "{\n" +
      "   highp vec4 textureColor = texture2D(inputImageTexture, vTextureCoord);\n" +
      "   \n" +
      "   gl_FragColor = floor((textureColor * colorLevels) + vec4(0.5)) / colorLevels;\n" +
      "}";

  public GLPosterizeFilter() {
    super(NO_FILTER_VERTEX_SHADER, POSTERIZE_FRAGMENT_SHADER);
  }
}
