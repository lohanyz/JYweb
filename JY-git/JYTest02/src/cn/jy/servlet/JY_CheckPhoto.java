package cn.jy.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;

@SuppressWarnings("deprecation")
public class JY_CheckPhoto extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private File   file;//	文件的内容;
	private String sResult="fail";
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		super.doGet(req, resp);
	}
	
	@SuppressWarnings({ "rawtypes" })
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("port!!!!!!!!!!!");
		PrintWriter pWriter  = resp.getWriter();
		//	临时目录;
		String 		pathTemp = req.getSession().getServletContext().getRealPath("/")+ "temp"; 
		//	文件检测;
		file 				 = new File(pathTemp);
		if (!file.exists()) {
			file.mkdirs();
		}
		//  正式目录;
		String 		pathTrue =req.getSession().getServletContext().getRealPath("/")+ "photo"; 
		//	文件检测;
		file 				 = new File(pathTrue);
		if (!file.exists()) {
			file.mkdirs();
		}
		//	Disk上传的内容;
		DiskFileUpload fu 	 = new DiskFileUpload();

		fu.setSizeMax(1 * 1024 * 1024); // 设置允许用户上传文件大小,单位:字节
		fu.setSizeThreshold(4096); 		// 设置最多只允许在内存中存储的数据,单位:字节
		fu.setRepositoryPath(pathTemp); // 设置一旦文件大小超过getSizeThreshold()的值时数据存放在硬盘的目录

		// 开始读取上传信息
		List 	fileItems  	 = null;

		try {
			fileItems = fu.parseRequest(req);
		} catch (Exception e) {
			e.printStackTrace();
		}

		Iterator 	  iter  = fileItems.iterator(); 		// 依次处理每个上传的文件
		while (iter.hasNext()){

			FileItem  item  = (FileItem) iter.next(); // 忽略其他不是文件域的所有表单信息
			
			if (!item.isFormField()){

				String name = item.getName();		// 获取上传文件名,包括路径
				//	
				if(name.contains("getgoods")){
					String bid=name.substring(0, name.indexOf("getgoods"));
					pathTrue=pathTrue+File.separator+bid+File.separator+"getgoods";
				}
				if(name.contains("resign")){
					String bid=name.substring(0, name.indexOf("resign"));
					pathTrue=pathTrue+File.separator+bid+File.separator+"resign";
				}
				if(name.contains("boxmanage")){
					
					String bid=name.substring(0, name.indexOf("boxmanage"));
					pathTrue=pathTrue+File.separator+bid+File.separator+"boxmanage";
				}
				if(name.contains("port")){
					
					String bid=name.substring(0, name.indexOf("port"));
					pathTrue=pathTrue+File.separator+bid+File.separator+"port";
				}
				if(name.contains("harbor")){
					String bid=name.substring(0, name.indexOf("harbor"));
					pathTrue=pathTrue+File.separator+bid+File.separator+"harbor";
				}
				file=new File(pathTrue);
				if(!file.exists()){
					file.mkdirs();
				}
				
				long   size = item.getSize();
				if ((name == null || name.equals("")) && size == 0)
					continue;
				file 	    = new File(pathTrue, name+".jpg");
				try {
					item.write(file);
				} catch (Exception e) {
					e.printStackTrace();
				}
				sResult	=	"success";
			}
		}

		pWriter.print(sResult)	;
		pWriter.flush();
		pWriter.close();
	}
}
