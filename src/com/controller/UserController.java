package com.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.entity.Goods;
import com.entity.Histories;
import com.entity.Items;
import com.entity.Orders;
import com.entity.Registers;
import com.entity.Users;
import com.service.GoodService;
import com.service.HistoryService;
import com.service.ItemService;
import com.service.OrderService;
import com.service.RegisterService;
import com.service.UserService;

/**
 * 用户
 */
@Controller
@RequestMapping("/index")
public class UserController{
	
	@Autowired
	private UserService userService;
	@Autowired
	private ItemService itemService;
	@Autowired
	private GoodService goodService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private RegisterService registerService;	
	@Autowired
	private HistoryService historyService;

	
	/**
	 * 注冊
	 * @return
	 */
	@RequestMapping("/register")
	public String register( Users user, HttpServletRequest request){
		int flag = userService.insertUser(user);
		if(flag==1) {
			request.setAttribute("msg", "注册成功");
			return "/index/login.jsp";
		}else {
			request.setAttribute("msg", "用户名重复！注册失败");
			return "/index/register.jsp";
		}
	}
	
	/**
	 * 登录
	 * @return
	 */
	@RequestMapping("/login")
	public String login( Users user, HttpSession session, HttpServletRequest request) {
		if(userService.checkUser(user.getUsername(), user.getPassword())) {
			Users newuser = new Users();
			newuser = userService.selectByUsername(user.getUsername());
			session.setAttribute("user", newuser);
			String ip = request.getHeader("x-forwarded-for"); 
	        if (ip != null && ip.length() != 0 && !"unknown".equalsIgnoreCase(ip)) {  
	            // 多次反向代理后会有多个ip值，第一个ip才是真实ip
	            if( ip.indexOf(",")!=-1 ){
	                ip = ip.split(",")[0];
	            }
	        }  
	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	            ip = request.getHeader("Proxy-Client-IP");  
	        }  
	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	            ip = request.getHeader("WL-Proxy-Client-IP");  
	        }  
	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	            ip = request.getHeader("HTTP_CLIENT_IP");  
	        }  
	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	            ip = request.getHeader("HTTP_X_FORWARDED_FOR");  
	        }  
	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	            ip = request.getHeader("X-Real-IP");  
	        }  
	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	            ip = request.getRemoteAddr();  
	        } 
	        Registers register = new Registers();
	        register.setUserId(newuser.getId());
	        register.setUserName(newuser.getUsername());
	        register.setPersonType("用户");
	        register.setIpAddress(ip);
	        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
	        //System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
			register.setSystime(df.format(new Date()));
			register.setOperateType("登录");
			registerService.insertRegister(register);
			return "redirect:index0";
		}
		request.setAttribute("msg", "账号或密码错误!");
		return "/index/login.jsp";
	}
	
	/**
	 * 首页，登录成功
	 * 
	 * @return
	 */
	@RequestMapping("/index0")
	public String index(HttpServletRequest request) {
		request.setAttribute("msg", "登录成功!");
		return "/index/index.jsp";
	}

	/**
	 * 退出
	 * @return
	 */
	@RequestMapping("/logout")
	public String logout(HttpSession session, HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for"); 
        if (ip != null && ip.length() != 0 && !"unknown".equalsIgnoreCase(ip)) {  
            // 多次反向代理后会有多个ip值，第一个ip才是真实ip
            if( ip.indexOf(",")!=-1 ){
                ip = ip.split(",")[0];
            }
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("Proxy-Client-IP");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("WL-Proxy-Client-IP");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("HTTP_CLIENT_IP");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("X-Real-IP");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getRemoteAddr();  
        } 
        Registers register = new Registers();
        Users newuser = new Users();
        newuser = (Users) session.getAttribute("user"); 
        register.setUserId(newuser.getId());
        register.setUserName(newuser.getUsername());
        register.setPersonType("用户");
        register.setIpAddress(ip);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        //System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
		register.setSystime(df.format(new Date()));
		register.setOperateType("退出");
		session.removeAttribute("user");
		session.removeAttribute("count");
		registerService.insertRegister(register);
		return "/index/login.jsp";
	}
	
	/**
	 * 修改用户信息
	 * @return
	 */
	@RequestMapping("/update")
	public String update(Users user,HttpServletRequest request, HttpSession session) {
		userService.updateUser(user);
		request.setAttribute("msg", "修改成功!");
		session.setAttribute("user", user);
		return "/index/index.jsp";
	}
	
	/**
	 * 获取所有商品信息
	 * @return
	 */
	@RequestMapping("/getGood")
	public String getGood(HttpServletRequest request) {
		List<Goods> goodlist = goodService.getList();
		request.setAttribute("goodList", goodlist);
		return "/index/goods.jsp";
	}
	
	/**
	 * 依据类型获取所有商品信息
	 * @return
	 */
	@RequestMapping("/getGoodByTypeId")
	public String getGoodByTypeId(@RequestParam("typeid") int typeid,HttpServletRequest request) {
		List<Goods> goodlist = goodService.queryGoodByTypeId(typeid);
		request.setAttribute("goodList", goodlist);
		return "/index/goods.jsp";
	}
	
	
	/**
	 * 商品详细信息
	 * @return
	 */
	@RequestMapping("/detail")
	public  String detail(@RequestParam("goodid") int goodid, 
			HttpSession session,HttpServletRequest request){
		Goods goods = goodService.queryGoodById(goodid);
		request.setAttribute("good", goods);
		Users user = new Users();
		user = (Users) session.getAttribute("user");
		if (user!=null) {
			Histories history = new Histories();
			history.setUserId(user.getId());
			history.setUserName(user.getUsername());
			history.setGoodId(goods.getId());
			history.setGoodName(goods.getName());
			history.setGoodType(goods.getTypeId());
	        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
	        //System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
			history.setSystime(df.format(new Date()));
			historyService.insertHistory(history);
		}
		return "/index/detail.jsp";
	}
	
	/**
	 * 购物车
	 * @return
	 */
	@RequestMapping("/cart")
	public String cart(@RequestParam("userid") int userid, HttpSession session, HttpServletRequest request) {
		List<Items> items = itemService.getItemListByOneId(userid);
		int allPrice = 0;
		if(items==null) {
			request.setAttribute("msg", "空空如也");
		}else {
			int allamount = 0;
			for(Items item:items) {
				int goodid = item.getGoodId();
				Goods goods = goodService.queryGoodById(goodid);
				item.setGood(goods);
				
				int price = item.getPrice();
				int amount = item.getAmount();
				allPrice += price * amount;
				allamount += amount;
			}
			session.setAttribute("count", allamount);//购物车数量
			session.setAttribute("items", items);
			session.setAttribute("allprice", allPrice); //购物车总价
		}
		return "/index/cart.jsp";
	}
	
	/**
	 * 加入购物车
	 * @return
	 */
	@RequestMapping("/buy")
	public  String buy(@RequestParam("goodid") int goodid, 
			@RequestParam("userid") int userid, 
			HttpSession session,HttpServletRequest request){
		//将购物车记录加入到数据库
		Goods goods = goodService.queryGoodById(goodid);
		Users users = userService.queryUserById(userid);
		if (goods .getStock() <= 0) {
			return "empty";
		}
		Items item = new Items();
		item = itemService.getItemByTwoId(users.getId(), goods.getId());
		if(item==null) {
			Items newitem = new Items();
			newitem.setAmount(1);
			newitem.setOrderId(users.getId());
			newitem.setGoodId(goods.getId());
			newitem.setPrice(goods.getPrice());
			itemService.insertItem(newitem);
			//输出购物车内商品数量
			List<Items> items = itemService.getItemListByOneId(userid);
			int amount = 0;
			for(Items i:items) {
				amount += i.getAmount();
			}
			session.setAttribute("count", amount);
			return "getGood";
		}else {
			int n = item.getAmount();
			n = n+1;
			item.setAmount(n);
			itemService.updateItem(item);
			//输出购物车内商品数量
			List<Items> items = itemService.getItemListByOneId(userid);
			int amount = 0;
			for(Items i:items) {
				amount += i.getAmount();
			}
			session.setAttribute("count", amount);
			return "cart";
		}

	}

	
	/**
	 * 减少购物车
	 */
	@RequestMapping("/lessen")
	public  String lessen(@RequestParam("goodid") int goodid, 
			@RequestParam("userid") int userid,
			@RequestParam("id") int id){
		Items item = new Items();
		item = itemService.getItemByTwoId(userid, goodid);
		int n = item.getAmount();
		n = n-1;
		if(n==0) {
			itemService.deleteItem(id);
		}else {
			item.setAmount(n);
			itemService.updateItem(item);
		}
		return "cart";
	}
	
	/**
	 * 删除购物车
	 */
	@RequestMapping("/delete")
	public  String delete(@RequestParam("goodid") int goodid, 
			@RequestParam("userid") int userid,
			@RequestParam("id") int id){
		Items item = new Items();
		item = itemService.getItemByTwoId(userid, goodid);
			itemService.deleteItem(id);
		return "cart";
	}
	
	
	/**
	 * 提交订单
	 * @return
	 */
	@RequestMapping("/save")
	public String save(@RequestParam("userid") int userid, @RequestParam("pay") int pay,
			HttpSession session, HttpServletRequest request){
		List<Items> items = itemService.getItemListByOneId(userid);
		for(Items i:items) {
			Orders order = new Orders();
			Users user = userService.queryUserById(i.getOrderId());
			Goods good = goodService.queryGoodById(i.getGoodId());
			order.setAddress(user.getAddress());
			order.setAmount(i.getAmount());
			order.setGoodId(good.getId());
			order.setGoodName(good.getName());
			if(pay==1) {
				order.setPaytype("支付宝");
			}
			if(pay==2) {
				order.setPaytype("微信");
			}
			if(pay==3) {
				order.setPaytype("货到付款");
			}
			order.setPhone(user.getPhone());
			order.setPrice(good.getPrice());
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
	        //System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
			order.setSystime(df.format(new Date()));
			order.setUserId(user.getId());
			order.setUserName(user.getName());
			orderService.insert(order);
		}
		request.setAttribute("msg", "付款成功");
		return "/index/payok.jsp";
	}
	
	/**
	 * 发送邮箱
	 * @return
	 */
	@RequestMapping("/mail")
	public String mail(@RequestParam("mail") String mail,
			HttpServletRequest request){
        try {
            
            //设置发件人
            String from = "2456778752@qq.com";
            
            //设置收件人
            String to = mail;
            
            //设置邮件发送的服务器，这里为QQ邮件服务器
            String host = "smtp.qq.com";
            
            //获取系统属性
            Properties properties = System.getProperties();
            
            //SSL加密
//            MailSSLSocketFactory sf = new MailSSLSocketFactory();
//            sf.setTrustAllHosts(true);
//            properties.put("mail.smtp.ssl.enable", "true");
//            properties.put("mail.smtp.ssl.socketFactory", sf);
            
            //设置系统属性
            properties.setProperty("mail.smtp.host", host);
            properties.put("mail.smtp.auth", "true");
            
            //获取发送邮件会话、获取第三方登录授权码
            Session session = Session.getDefaultInstance(properties, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(from, "eudyebiwwpyvdjch");
                }
            });
            
            Message message = new MimeMessage(session);
            
            //防止邮件被当然垃圾邮件处理，披上Outlook的马甲
            message.addHeader("X-Mailer","Microsoft Outlook Express 6.00.2900.2869");
            
            message.setFrom(new InternetAddress(from));
            
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            
            //邮件标题
            message.setSubject("Are you ok购物商城");
            
            BodyPart bodyPart = new MimeBodyPart();
            
            bodyPart.setText("亲，您的货物已经发出，请注意查收哦。");
            
            Multipart multipart = new MimeMultipart();
            
            multipart.addBodyPart(bodyPart);
            
           
            
            message.setContent(multipart);
            
            Transport.send(message);
            System.out.println("mail transports successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
		return "/index/payok.jsp";
	}
	
	/**
	 * 查看订单
	 * @return
	 */
	@RequestMapping("/order")
	public String order(@RequestParam("userid") int userid,
			HttpSession session, HttpServletRequest request){
		List<Orders> orders = orderService.getListById(userid);
		request.setAttribute("orders", orders);
		return "/index/order.jsp";
	}
	
	/**
	 * 查看浏览记录
	 * @return
	 */
	@RequestMapping("/history")
	public String history(@RequestParam("userid") int userid,
			HttpSession session, HttpServletRequest request){
		List<Histories> history = historyService.getListById(userid);
		request.setAttribute("histories", history);
		return "/index/history.jsp";
	}
	
	/**
	 * 推荐系统
	 * @return
	 */
	@RequestMapping("/recommend")
	public String recommend(@RequestParam("userid") int userid,
			HttpSession session, HttpServletRequest request) {
		List<Histories> history = historyService.getListById(userid);
		int typeid;
		if(history==null) {
			typeid=1;
		}
		else {
			typeid = history.get(0).getGoodType();
			}
		List<Goods> goodlist = goodService.queryGoodByTypeId(typeid);
		request.setAttribute("goodList", goodlist);
		return "/index/goods.jsp";
	}

}