package cn.jy.code;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
/**
 * Servlet implementation class CodeServlet
 */
public class CodeServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
    
	//验证码字体
	private Font[] codeFont={new Font("Times New Roman",Font.PLAIN,20),
			new Font("Times New Roman",Font.PLAIN,20),
			new Font("Times New Roman",Font.PLAIN,20),
			new Font("Times New Roman",Font.PLAIN,20)};
	
	//验证码数字颜色
	private Color[] color={Color.BLACK,Color.RED,Color.DARK_GRAY,Color.BLUE};
	
	//用于存储之后生成的验证码
	private String codeNumbers="";
	
	private final String IMAGE_CHAR="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	
	//定义验证码图片的大小
	private final Integer IMAGE_WIDTH=90;
	private final Integer IMAGE_HEIGHT=30;
	
	
	
    public CodeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
response.setContentType("image/gif");
		
		//不设置缓存，页面不使用缓存
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		
		//创建一个图像，验证码显示图片大小
		BufferedImage image=new BufferedImage(IMAGE_WIDTH,IMAGE_HEIGHT,BufferedImage.TYPE_INT_RGB);
		
		//获取图形绘制对象
		Graphics g=image.getGraphics();
		
		//绘制图形背景颜色
		g.setColor(getRandColor(200,250));
		
		//绘制背景图片
		g.fillRect(0, 0, IMAGE_WIDTH, IMAGE_HEIGHT);
		
		//循环产生4位数字
		for(int i=0;i<4;i++)
		{
			drawCode(g,i);	
		}
		
		//增加干扰线
		drawNoise(g,12);
		
		//将验证码内容保存进session中，用于验证用户输入是否正确时使用
  		HttpSession session=request.getSession(true);
  		session.removeAttribute(Constants.check_number_name);
// 		session.setAttribute(Constants.check_number_name, codeNumbers);
//		request.getSession().setAttribute("codeNumbers", codeNumbers);
		Constants.setCheck_number_name(codeNumbers);
		//重设字符串
		codeNumbers="";
		//利用inmagIO类的write方法对图像进行编码
		ServletOutputStream sos=response.getOutputStream();
		ImageIO.write(image, "GIF", sos);
		sos.close();
		
	}

	private void drawNoise(Graphics graphics, int lineNumber) {
		// TODO Auto-generated method stub
		//干扰线颜色
		graphics.setColor(getRandColor(160,200));
		
		for(int i=0;i<lineNumber;i++)
		{
			//线的起始X轴 （只有在80,20的范围内随机，由于从0开始，所以要加1）
			int pointX1=1+(int)(Math.random()*80);
			//线的起始Y轴 （只有在80,20的范围内随机，由于从0开始，所以要加1）
			int pointY1=1+(int)(Math.random()*20);
			//线的终止X轴 （只有在80,20的范围内随机，由于从0开始，所以要加1）
			int pointX2=1+(int)(Math.random()*80);
			//线的终止Y轴 （只有在80,20的范围内随机，由于从0开始，所以要加1）
			int pointY2=1+(int)(Math.random()*20);
			
			graphics.drawLine(pointX1, pointY1, pointX2, pointY2);
			
		}		
	}

	private void drawCode(Graphics graphics, int i) {
		// TODO Auto-generated method stub
		Random random=new Random();
		//产生随机切割序号
		// 0-61.9999
		Integer j=random.nextInt((IMAGE_CHAR.length()));
		
		//切割随机数
		String number=IMAGE_CHAR.substring(j, j+1);
		graphics.setFont(codeFont[i]);
		graphics.setColor(color[i]);
		
		//绘制验证码图片X\Y （每个字体X每次进步13的倍数，Y不变，大小 6* 6）
		graphics.drawString(number,6+i*13,16);
		
		codeNumbers+=number;
		
	}

	private Color getRandColor(int fc, int bc) {
		// TODO Auto-generated method stub
		//随机对象
		Random random=new Random();
		
		//随机初始数值不得大于255
		if(fc>255)
			fc=255;
		
		if(bc>255)
			bc=255;
		
		//产生随机红蓝绿色调
		int r=fc+random.nextInt(bc-fc);
		int g=fc+random.nextInt(bc-fc);
		int b=fc+random.nextInt(bc-fc);
		
		
		return new Color(r,g,b);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}
}
