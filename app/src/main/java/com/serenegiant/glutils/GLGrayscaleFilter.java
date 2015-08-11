package com.serenegiant.glutils;

/**
 * グレースケールフィルター.
 *
 * Created by u1aryz on 2015/08/11.
 */
public class GLGrayscaleFilter extends GLDrawer2D {

  public static final String GRAYSCALE_FRAGMENT_SHADER = "" +
      "#extension GL_OES_EGL_image_external : require\n" +
      "precision highp float;\n" +
      "\n" +
      "varying vec2 vTextureCoord;\n" +
      "\n" +
      "uniform samplerExternalOES inputImageTexture;\n" +
      "\n" +
      "const highp vec3 W = vec3(0.2125, 0.7154, 0.0721);\n" +
      "\n" +
      "void main()\n" +
      "{\n" +
      "  lowp vec4 textureColor = texture2D(inputImageTexture, vTextureCoord);\n" +
      "  float luminance = dot(textureColor.rgb, W);\n" +
      "\n" +
      "  gl_FragColor = vec4(vec3(luminance), textureColor.a);\n" +
      "}";

  public GLGrayscaleFilter() {
    super(VSS, GRAYSCALE_FRAGMENT_SHADER);
  }
}
