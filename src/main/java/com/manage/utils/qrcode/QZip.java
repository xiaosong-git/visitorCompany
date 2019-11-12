package com.manage.utils.qrcode;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import java.util.zip.CheckedOutputStream;
import java.util.zip.Deflater;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * GZIPѹ����ZIPѹ��������
 * 
 * @author Jerry
 * @date 2015-7-27
 */
public class QZip {

	/**
	 * ��׺����
	 */
	public final String EXT = ".zip";
	private final String BASE_DIR = "";

	// ����"/"������ΪĿ¼��ʶ�жϷ�
	private final String PATH = File.separator;
	private int BUFFER = 1024;

	public QZip() {
	}

	public QZip(int BUFFER) {
		this.BUFFER = BUFFER;
	}

	/**
	 * ѹ��Ŀ���ļ��л��ļ�
	 * 
	 * @param srcFile
	 *            һ���ļ���Ŀ¼<br>
	 *            ѹ���ļ�Ĭ�Ϸ���Դ�ļ���
	 * @return ����ʱ����-1
	 * 
	 */
	public long file2Zip(File srcFile) {
		String name = srcFile.getName();
		String path = srcFile.getPath();
		path = path.substring(0, path.lastIndexOf(File.separatorChar) + 1);
		String destPath = path + name + EXT;
		return file2Zip(srcFile, destPath);
	}

	/**
	 * ѹ��Ŀ���ļ��л��ļ�
	 * 
	 * @param srcPath
	 *            һ���ļ��л��ļ�·��<br>
	 *            ѹ���ļ�����Դ�ļ���
	 * @return ����ʱ����-1
	 * 
	 */
	public long file2Zip(String srcPath) {
		File srcFile = new File(srcPath);
		return file2Zip(srcFile);
	}

	/**
	 * ѹ��Ŀ���ļ��л��ļ�
	 * 
	 * @param srcPath
	 *            Դ�ļ���·�����ļ�·��
	 * @param destPath
	 *            Ŀ���ļ�(�����Ǹ��ļ�)
	 * @return ����ʱ����-1
	 * @throws Exception
	 * 
	 */
	public long file2Zip(String srcPath, String destPath) {
		File srcFile = new File(srcPath);
		return file2Zip(srcFile, destPath);
	}

	/**
	 * ѹ��Ŀ���ļ��л��ļ�
	 * 
	 * @param srcFile
	 *            ��Ҫѹ����·�����ļ�
	 * @param destPath
	 *            һ���ļ��ľ���·��+����.zip
	 * @return ����ʱ����-1
	 * 
	 */
	public long file2Zip(File srcFile, String destPath) {
		File file = new File(destPath);
		if (file.exists() && file.isDirectory()) {
			System.out.println("Ŀ���ļ����ļ������Ѿ�����!");
			return -1;
		}
		return file2Zip(srcFile, file);
	}

	/**
	 * ѹ��Ŀ���ļ��л��ļ�
	 * 
	 * @param srcFile
	 *            ��Ҫѹ����·�����ļ�
	 * @param destFile
	 *            Ŀ���ļ�(�������ļ�)
	 * @return ����ʱ����-1
	 * 
	 */
	public long file2Zip(File srcFile, File destFile) {
		// ������ļ���CRC32У��
		CheckedOutputStream cos = null;
		try {
			FileOutputStream fil = new FileOutputStream(destFile);
			cos = new CheckedOutputStream(
					new BufferedOutputStream(fil, BUFFER), new CRC32());
			ZipOutputStream zos = new ZipOutputStream(cos);
			zos.setMethod(ZipOutputStream.DEFLATED);
			zos.setLevel(Deflater.BEST_COMPRESSION);
			mainZip(srcFile, zos, BASE_DIR);
			zos.finish();
			zos.flush();
			zos.close();
			cos.flush();
			cos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return cos.getChecksum().getValue();
	}

	/**
	 * ��ѹ������
	 * 
	 * @param srcFile
	 *            Դ·��
	 * @param zos
	 *            ZipOutputStream
	 * @param basePath
	 *            ѹ���������·��
	 * @throws Exception
	 */
	private void mainZip(File srcFile, ZipOutputStream zos, String basePath) {
		try {
			if (srcFile.isDirectory()) {
				zipDir(srcFile, zos, basePath);
			} else {
				zipFile(srcFile, zos, basePath);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ѹ��Ŀ¼
	 * 
	 * @param dir
	 * @param zos
	 * @param basePath
	 * @throws Exception
	 */
	private void zipDir(File dir, ZipOutputStream zos, String basePath)
			throws Exception {
		File[] files = dir.listFiles();
		// ������Ŀ¼
		if (files.length < 1) {
			ZipEntry entry = new ZipEntry(basePath + dir.getName() + PATH);
			zos.putNextEntry(entry);
			zos.closeEntry();
		}
		for (File file : files) {
			// �ݹ�ѹ��
			mainZip(file, zos, basePath + dir.getName() + PATH);
		}
	}

	/**
	 * �ļ�ѹ��
	 * 
	 * <pre>
	 * ����ж༶Ŀ¼����ô�������Ҫ��������Ŀ¼���ļ��� 
	 * �����WinRAR��ѹ����������������ʾΪ����
	 * </pre>
	 * 
	 * @param file
	 *            ��ѹ���ļ�
	 * @param zos
	 *            ZipOutputStream
	 * @param dir
	 *            ѹ���ļ��еĵ�ǰ·��
	 * @throws Exception
	 */
	private void zipFile(File file, ZipOutputStream zos, String dir)
			throws Exception {
		ZipEntry entry = new ZipEntry(dir + file.getName());
		zos.putNextEntry(entry);
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(
				file));
		int count = 0;
		byte data[] = new byte[BUFFER];
		while ((count = bis.read(data, 0, BUFFER)) != -1) {
			zos.write(data, 0, count);
		}
		bis.close();
		zos.closeEntry();
	}

	/**
	 * �ļ���ѹ��
	 * 
	 * @param srcPath
	 *            �ļ�ȫ·��
	 * @return ����ʱ����-1
	 * 
	 */
	public long zip2File(String filepath) {
		File srcFile = new File(filepath);
		return zip2File(srcFile);
	}

	/**
	 * ��ѹ��
	 * 
	 * @param srcFile
	 *            ��ѹ���ĵ�
	 * @return ����ʱ����-1
	 * @throws Exception
	 * 
	 */
	public long zip2File(File srcFile) {
		String path = srcFile.getPath();
		path = path.substring(0, path.lastIndexOf(File.separatorChar) + 1);
		return zip2File(srcFile, path);
	}

	/**
	 * ��ѹ��
	 * 
	 * @param srcFile
	 *            ��ѹ���ļ�
	 * @param destFile
	 *            ��ѹ�����·��
	 * @return ����ʱ����-1
	 * 
	 */
	public long zip2File(File srcFile, File destFile) {
		CheckedInputStream cis = null;
		try {
			FileInputStream inpu = new FileInputStream(srcFile);
			cis = new CheckedInputStream(new BufferedInputStream(inpu, BUFFER),
					new CRC32());
			ZipInputStream zis = new ZipInputStream(cis);
			mainUnzip(destFile, zis);
			zis.close();
			cis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return -1;
		} catch (IOException e) {
			e.printStackTrace();
			return -1;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
		return cis.getChecksum().getValue();
	}

	/**
	 * ��ѹ��
	 * 
	 * @param srcFile
	 *            ��ѹ���ĵ�
	 * @param destPath
	 *            ��ѹ�����·��
	 * @return
	 * 
	 */
	public long zip2File(File srcFile, String destPath) {
		return zip2File(srcFile, new File(destPath));
	}

	/**
	 * �ļ� ��ѹ��
	 * 
	 * @param srcPath
	 *            Դ�ļ�
	 * @param destPath
	 *            Ŀ���ļ�·��
	 * @return
	 * @throws Exception
	 * 
	 */
	public long zip2File(String srcPath, String destPath) {
		File srcFile = new File(srcPath);
		return zip2File(srcFile, destPath);
	}

	/**
	 * �ļ� ��ѹ��
	 * 
	 * @param destFile
	 *            Ŀ���ļ�
	 * @param zis
	 *            ZipInputStream
	 * @throws Exception
	 */
	private void mainUnzip(File destFile, ZipInputStream zis) throws Exception {
		ZipEntry entry = null;
		while ((entry = zis.getNextEntry()) != null) {
			// �ļ�
			String dir = destFile.getPath() + File.separator + entry.getName();
			dir = compatibility(dir);
			File dirFile = new File(dir);
			// �ļ����
			fileProber(dirFile);
			if (entry.isDirectory()) {
				dirFile.mkdirs();
			} else {
				unzipFile(dirFile, zis);
			}
			zis.closeEntry();
		}
	}

	/**
	 * �����windows��ѹ��,Ȼ����Linux�Ͻ�ѹ�����������
	 * 
	 * @param dir
	 * @return
	 * 
	 */
	private String compatibility(String dir) {
		int a = dir.indexOf("/");
		int b = dir.indexOf("\\");
		if (a < 0 || b < 0) {
			return dir;
		}
		if (a < b) {
			dir = dir.replace("\\", "/");
		} else {
			dir = dir.replace("/", "\\");
		}
		return dir;
	}

	/**
	 * �ļ�̽��
	 * 
	 * 
	 * ����Ŀ¼������ʱ������Ŀ¼��
	 * 
	 * 
	 * @param dirFile
	 */
	private void fileProber(File dirFile) {
		File parentFile = dirFile.getParentFile();
		if (!parentFile.exists()) {
			// �ݹ�Ѱ���ϼ�Ŀ¼
			fileProber(parentFile);
			parentFile.mkdir();
		}
	}

	/**
	 * �ļ���ѹ��
	 * 
	 * @param destFile
	 *            Ŀ���ļ�
	 * @param zis
	 *            ZipInputStream
	 * @throws Exception
	 */
	private void unzipFile(File destFile, ZipInputStream zis) throws Exception {
		BufferedOutputStream bos = new BufferedOutputStream(
				new FileOutputStream(destFile));
		int count;
		byte data[] = new byte[BUFFER];
		while ((count = zis.read(data, 0, BUFFER)) != -1) {
			bos.write(data, 0, count);
		}
		bos.close();
	}

	/**
	 * Ϊ�����ļ����Ǵ����ļ���
	 * 
	 * @param mkdirName
	 * @return
	 * 
	 */
	public boolean mkdir(String mkdirName) {
		try {
			File dirFile = new File(mkdirName);
			boolean bFile = dirFile.exists();
			if (bFile) {
				if (dirFile.isDirectory()) {
					return true;
				}
				return false;
			} else {
				bFile = dirFile.mkdir();
				return bFile;
			}
		} catch (Exception err) {
			err.printStackTrace();
			return false;
		}

	}

	/**
	 * ��ȡѹ������������
	 * 
	 * @param stream
	 * @return
	 * @throws IOException
	 * 
	 */
	public GZIPInputStream getGzipInputStream(InputStream stream)
			throws IOException {
		return new GZIPInputStream(stream);
	}

	/**
	 * ��ȡѹ�����������
	 * 
	 * @param stream
	 * @return
	 * @throws IOException
	 * 
	 */
	public GZIPOutputStream getGzipOutputStream(OutputStream stream)
			throws IOException {
		return new GZIPOutputStream(stream);
	}

	/**
	 * ѹ���ֽ�����<br>
	 * ֻ�����ֽڳ��ȴ���50ʱ����Ч��,С��50 ��������<br>
	 * ����Ҫ����100�ֽڲ���Ч��
	 * 
	 * @param data
	 *            ��Ҫѹ��������
	 * @return
	 * @throws Exception
	 *             servlet��ʹ��:<br>
	 *             response.setHeader("Content-Encoding",gzip;); //
	 *             ����Content-Encoding�����ǹؼ��㣡<br>
	 *             response.setCharacterEncoding(ENCODING); // �����ַ���<br>
	 *             response.setContentLength(output.length);// �趨����������ݳ���
	 */
	public byte[] getGZIPBytes(byte[] data) throws Exception {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		// ѹ��
		GZIPOutputStream gos = new GZIPOutputStream(baos);
		gos.write(data, 0, data.length);
		gos.finish();
		byte[] output = baos.toByteArray();
		baos.flush();
		baos.close();
		return output;
	}

	/**
	 * ��ѹ���ַ�����<br>
	 * ֻ�����ֽڳ��ȴ���50ʱ����Ч��,С��50 ��������<br>
	 * ����Ҫ����100�ֽڲ���Ч��
	 * Android�ӷ������˻�õ����������ڷ�����������response.setHeader("Content-Encoding", "gzip");<br>
	 * ʱ�Զ���ѹ,����Ҫ�ֶ���ѹ
	 * 
	 * @param inbyte
	 * @return
	 * @throws IOException
	 * 
	 */
	public byte[] getUnGZIPBytes(byte[] inbyte) throws IOException {
		ByteArrayInputStream stream = new ByteArrayInputStream(inbyte);
		ByteArrayOutputStream stream2 = new ByteArrayOutputStream();
		GZIPInputStream gis = new GZIPInputStream(stream);
		int count = 0;
		byte data[] = new byte[BUFFER];
		while ((count = gis.read(data, 0, BUFFER)) != -1) {
			stream2.write(data, 0, count);
		}
		gis.close();
		return stream2.toByteArray();
	}

	// ���Դ���
	public static void main(String[] args) throws Exception {
		QZip unZip = new QZip();
		String inputStr = "���Ǻ�,����ȿ�ˮ������ɽ�����������Ǻ�æ��,����ȿ�ˮ������ɽ��������zlex.org";
		System.out.println(inputStr);
		System.out.println("ԭʼ����:" + inputStr.getBytes().length);
		byte[] res = unZip.getGZIPBytes(inputStr.getBytes());
		System.out.println("ѹ���󳤶�:" + res.length);
		System.out.println("ѹ������ַ���:" + new String(res));
		byte[] ori = unZip.getUnGZIPBytes(res);
		System.out.println("��ѹ���󳤶�:" + ori.length);
		System.out.println("��ѹ������ַ���:" + new String(ori));
		System.out.println(unZip.file2Zip("F:/DDPush��Ϣ����/",
				"F:/DDPush��Ϣ����2.zip"));
		System.out.println(unZip.zip2File("F:/DDPush��Ϣ����2.zip",
				"F:/DDPush��Ϣ����2/"));
		System.out.println(unZip.file2Zip("F:/dd.doc", "F:/dd.zip"));
		System.out.println(unZip.zip2File("F:/dd.zip", "F:/dd"));
	}

}
