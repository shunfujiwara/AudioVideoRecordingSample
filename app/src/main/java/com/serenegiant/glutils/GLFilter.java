package com.serenegiant.glutils;

/**
 * フィルターの基底クラス.
 *
 * Created by u1aryz on 2015/08/12.
 */
public class GLFilter {

  public static final String NO_FILTER_VERTEX_SHADER = "" +
      "uniform mat4 uMVPMatrix;\n" +
      "uniform mat4 uTexMatrix;\n" +
      "attribute highp vec4 aPosition;\n" +
      "attribute highp vec4 aTextureCoord;\n" +
      "varying highp vec2 vTextureCoord;\n" +
      "\n" +
      "void main() {\n" +
      "	 gl_Position = uMVPMatrix * aPosition;\n" +
      "	 vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n" +
      "}\n";

  public static final String NO_FILTER_FRAGMENT_SHADER = "" +
      "#extension GL_OES_EGL_image_external : require\n" +
      "precision mediump float;\n" +
      "uniform samplerExternalOES sTexture;\n" +
      "varying highp vec2 vTextureCoord;\n" +
      "\n" +
      "void main() {\n" +
      "  gl_FragColor = texture2D(sTexture, vTextureCoord);\n" +
      "}";

  private final GLDrawer2D mDrawerForRenderer;
  private final GLDrawer2D mDrawerForEncoder;

  public GLFilter() {
    this(NO_FILTER_VERTEX_SHADER, NO_FILTER_FRAGMENT_SHADER);
  }

  public GLFilter(String vertexShader, String fragmentShader) {
    mDrawerForRenderer = new GLDrawer2D(vertexShader, fragmentShader);
    mDrawerForEncoder = new GLDrawer2D(vertexShader, fragmentShader);
  }

  public GLDrawer2D getDrawerForRenderer() {
    return mDrawerForRenderer;
  }

  public GLDrawer2D getDrawerForEncoder() {
    return mDrawerForEncoder;
  }
}
