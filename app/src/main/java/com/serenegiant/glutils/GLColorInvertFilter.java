package com.serenegiant.glutils;

/**
 * Invertフィルター.
 *
 * Created by u1aryz on 2015/08/11.
 */
public class GLColorInvertFilter extends GLDrawer2D {

  public static final String COLOR_INVERT_FRAGMENT_SHADER = "" +
      "#extension GL_OES_EGL_image_external : require\n" +
      "varying highp vec2 vTextureCoord;\n" +
      "\n" +
      "uniform samplerExternalOES inputImageTexture;\n" +
      "\n" +
      "void main()\n" +
      "{\n" +
      "    lowp vec4 textureColor = texture2D(inputImageTexture, vTextureCoord);\n" +
      "    \n" +
      "    gl_FragColor = vec4((1.0 - textureColor.rgb), textureColor.w);\n" +
      "}";

  public GLColorInvertFilter() {
    super(VSS, COLOR_INVERT_FRAGMENT_SHADER);
  }
}
