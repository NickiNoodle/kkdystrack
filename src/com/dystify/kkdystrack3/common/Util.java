package com.dystify.kkdystrack3.common;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

/**
 * Contains some miscellaneous static utility methods that don't really fit
 * anywhere else
 * 
 * @author Duemmer
 *
 */
public class Util
{
  
  /**
   * Resolves the absolute root directory of the resources directory.
   * <p/>
   * <b>NOTE:</b> This operates off of the assumption that the app was run using
   * either the launch script or in the editor (i.e. the working directory of the
   * call is the jar file / project root directory). This will produce incorrect
   * results if the working directory is not the jar's home directory.
   * 
   * @return a {@link File} that points to the resources directory
   */
  public static File getResourceRootDir() {
    /**
     * Old method, doesn't seem to work with Boot (probably thanks to the funky
     * classloading), didn't have the working directory restriction
     */
    // File f;
    // URL u;
    // try {
    // // get the location of the jar
    // String jarPath =
    // Util.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
    // System.out.println("Jar Path: \"" + jarPath + "\"");
    // f = new File(jarPath).getParentFile();
    // u = f.toURI().toURL();
    // } catch (MalformedURLException | URISyntaxException e) {
    // throw new FileNotFoundException("failed to find resource root!");
    // }
    //
    // if (u == null || !f.exists())
    // throw new FileNotFoundException("failed to find resource root!");
    //
    // return f;
    
    String cwd = Paths.get("").toAbsolutePath().toString();
    return new File(cwd + File.separatorChar + "resource");
  }
}
