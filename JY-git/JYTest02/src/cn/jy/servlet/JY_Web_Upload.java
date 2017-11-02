package cn.jy.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.jy.code.Constants;
import cn.jy.entity.Workerinfo;
import cn.jy.tool.DBTool;

public class JY_Web_Upload extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private int    		operId	   =	0;	//	操作类型;
	private DBTool 		dbTool;
	private HttpSession session;
	private File   file;//	文件的内容;
	private String sResult="fail";
	private String savePath,saveTemp,num,path,spath,
				   tmp,bid,gid;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter pWriter = 	resp.getWriter();	
		//	数据传输的类型;
		resp.setContentType("text/html;charset=utf-8");
		//	写数据信息操作;
		operId				=	Integer.parseInt(req.getParameter("operid")) ;
		dbTool				=	new DBTool();
		session				=	req.getSession();

		switch(operId){
		//上传图片
			case 1:
				 tmp			=	new String(req.getParameter("bid").getBytes("iso-8859-1"),"utf-8");
				 if(tmp.indexOf("-")<0){
						bid=tmp;
						gid=new String(req.getParameter("gid").getBytes("iso-8859-1"),"utf-8");
				}
				 else{
					 bid		=	tmp.substring(0, tmp.indexOf("-"));
					 gid		=	tmp.substring(tmp.indexOf("-")+1,tmp.length() );
				 }
				 
//				 num	=	(String)req.getParameter("num"); 
				 spath 	= 	(String)req.getParameter("spath");
				 savePath= this.getServletContext().getRealPath("/")+ "photo"+File.separator+bid+File.separator+spath;
//				 savePath="D:/java_dev/MyWorkSpace/JYTest02/WebContent/"+(String)req.getParameter("spath")+"/images/";
				 File file = new File(savePath);
				//判断上传文件的保存目录是否存在
				 if (!file.exists() && !file.isDirectory()) {
				 	System.out.println(savePath+"目录不存在，需要创建");
				 	 //创建目录
				 	file.mkdirs();
				 }
				//消息提示
				 try{
				 //使用Apache文件上传组件处理文件上传步骤：
					//1、创建一个DiskFileItemFactory工厂
					DiskFileItemFactory factory = new DiskFileItemFactory();
					//2、创建一个文件上传解析器
					ServletFileUpload upload = new ServletFileUpload(factory);
					//解决上传文件名的中文乱码
					upload.setHeaderEncoding("UTF-8"); 
					//3、判断提交上来的数据是否是上传表单的数据
					if(!ServletFileUpload.isMultipartContent(req )){
						//按照传统方式获取数据
						return;
					}
					//4、使用ServletFileUpload解析器解析上传数据，解析结果返回的是一个List<FileItem>集合，每一个FileItem对应一个Form表单的输入项
					List<FileItem> list = upload.parseRequest(req );
				 	for(FileItem item : list){
				 			String path = item.getString("UTF-8");
				 			FileInputStream in = new FileInputStream(path);
//				 			String name = item.getName();		// 获取上传文件名,包括路径
				 			String name=bid+spath+gid+"file"+java.lang.System.currentTimeMillis();
				 			//创建一个文件输出流
//				 			FileOutputStream out = new FileOutputStream(savePath + "\\" + bid+ "_"+num+".jpg");
				 			FileOutputStream out = new FileOutputStream(savePath+File.separator+name+".jpg");
				 			//创建一个缓冲区
				 			byte buffer[] = new byte[1024];
				 			//判断输入流中的数据是否已经读完的标识
				 			int len = 0;
				 			//循环将输入流读入到缓冲区当中，(len=in.read(buffer))>0就表示in里面还有数据
				 			while((len=in.read(buffer))>0){
				 				//使用FileOutputStream输出流将缓冲区的数据写入到指定的目录(savePath + "\\" + filename)当中
				 				out.write(buffer, 0, len);
				 			}
				 			//关闭输入流
				 			in.close();
				 			//关闭输出流
				 			out.close();
				 			//删除处理文件上传时生成的临时文件
				 			JSONObject obj = new JSONObject();
				 			obj.put("img", name);
				 			sResult=obj.toString();
				 		}
				 }catch (Exception e) {
					 e.printStackTrace();
				 }
				
				break;
		//删除图片
			case 2:
				path="D:/java_dev/MyWorkSpace/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/wtpwebapps/JYTest02/";
				file = new File(path);
				bid=(String)req.getParameter("bid");
				
				break;
			default:
				break;
		}
		pWriter.print(sResult)	;
		pWriter.flush();
		pWriter.close();
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");	
		doGet(req, resp);
	}
}
