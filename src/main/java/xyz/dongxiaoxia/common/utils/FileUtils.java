package xyz.dongxiaoxia.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * Created in 2016/4/25 by Tong zhenke <br>
 */
public class FileUtils {

    private static final Logger logger = LoggerFactory
            .getLogger(FileUtils.class);
    /**
     * 上传文件
     *
     * @param in
     * @param destFile
     * @param BUFFER_SIZE
     */
    public static void appendFile(InputStream in, File destFile, int BUFFER_SIZE) {
        OutputStream out = null;
        try {
            // plupload 配置了chunk的时候新上传的文件append到文件末尾
            if (destFile.exists()) {
                out = new BufferedOutputStream(new FileOutputStream(destFile,
                        true), BUFFER_SIZE);
            } else {
                out = new BufferedOutputStream(new FileOutputStream(destFile),
                        BUFFER_SIZE);
            }
            in = new BufferedInputStream(in, BUFFER_SIZE);

            int len = 0;
            byte[] buffer = new byte[BUFFER_SIZE];
            while ((len = in.read(buffer)) > 0) {
                out.write(buffer, 0, len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != in) {
                    in.close();
                }
                if (null != out) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 转换文件大小
     *
     * @param size
     * @return string
     */
    public static String convertFileSize(long size) {
        long kb = 1024;
        long mb = kb * 1024;
        long gb = mb * 1024;

        if (size >= gb) {
            return String.format("%.1f GB", (float) size / gb);
        } else if (size >= mb) {
            float f = (float) size / mb;
            return String.format(f > 100 ? "%.0f MB" : "%.1f MB", f);
        } else if (size >= kb) {
            float f = (float) size / kb;
            return String.format(f > 100 ? "%.0f KB" : "%.1f KB", f);
        } else
            return String.format("%d B", size);
    }

    /**
     *
     * @Title: upZipFiles
     * @Description: 解压文件
     * @param zipPath
     * @param descDir
     * @throws IOException
     *             设定文件
     */
    public static void upZipFiles(String zipPath, String realPath,
                                  String descDir) throws IOException {
        unZipFiles(new File(zipPath), realPath, descDir);
    }

    /**
     *
     * @Title: unZipFiles
     * @Description: 解压文件
     * @param zipFile
     * @param descDir
     * @throws IOException
     *             设定文件
     */
    public static void unZipFiles(File zipFile, String realPath, String descDir)
            throws IOException {
        ZipFile zip = new ZipFile(zipFile);

        //创建解压目录
        File folder = new File(descDir);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        for (Enumeration<?> entries = zip.entries(); entries.hasMoreElements();) {
            ZipEntry entry = (ZipEntry) entries.nextElement();
            String zipEntryName = entry.getName();
            InputStream in = zip.getInputStream(entry);
            System.out.println(descDir + zipEntryName);
            String outPath = (descDir + zipEntryName).replaceAll("\\\\", "/");
            // 输出文件路径信息
            logger.info(outPath);
            File file = new File(outPath);
            // 判断是否为文件夹，是则创建文件夹即可
            // 判断文件全路径是否为文件夹,如果是上面已经上传,不需要解压
            if (zipEntryName.indexOf(".")<1) {
                logger.info("文件夹是否存在"+file.exists());
                if (!file.exists()) {
                    file.mkdirs();
                }
                continue;
            }


            OutputStream out = new FileOutputStream(outPath);
            byte[] buf1 = new byte[1024];
            int len;
            while ((len = in.read(buf1)) > 0) {
                out.write(buf1, 0, len);
            }
            in.close();
            out.close();
        }
        System.out.println("******************解压完毕********************");
    }

    /**
     *
     * @Title: deleteFile
     * @Description: 删除文件
     * @param sPath
     * @return boolean 返回类型
     */
    public static boolean deleteFile(String sPath) {
        boolean flag = false;
        File file = new File(sPath);
        // 路径为文件且不为空则进行删除
        if (file.isFile() && file.exists()) {
            file.delete();
            flag = true;
        }
        return flag;
    }

    public static boolean deleteDir(String dirPath) {
        return deleteDir(new File(dirPath));
    }

    /**
     *
     * @Title: deleteDir
     * @Description: 递归删除目录下的所有文件及子目录下所有文件
     * @param dir
     * @return boolean 返回类型
     */
    public static boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        // 目录此时为空，可以删除
        return dir.delete();
    }

    /**
     *
     * @Title: getExtensionName
     * @Description: 获取文件后缀名
     * @param filename
     * @return String 返回类型
     */
    public static String getExtensionName(String filename) {
        if ((filename != null) && (filename.length() > 0)) {
            int dot = filename.lastIndexOf('.');
            if ((dot > -1) && (dot < (filename.length() - 1))) {
                return filename.substring(dot + 1);
            }
        }
        return filename;
    }

}
