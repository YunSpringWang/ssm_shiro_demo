package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.ExpiredCredentialsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class UserController {
	private static Logger logger = Logger.getLogger(UserController.class);

	@RequestMapping(value = "/toLogin.do")
	public String toLogin(Model model) {

		return "login";
	}

	@RequestMapping(value = "/loginTest.do")
	public String login(HttpServletRequest request, Model model, String accountName, String password, boolean rememberMe) {
		System.out.println("rememberMe:" + rememberMe);
		logger.info("页面传输过来的值：username=" + accountName + "|password=" + password + "|rememberMe=" + rememberMe);
		Subject currentUser = SecurityUtils.getSubject();
		if (!currentUser.isAuthenticated()) {
			UsernamePasswordToken token = new UsernamePasswordToken(accountName, password.toCharArray());
			token.setRememberMe(rememberMe);
			try {
				currentUser.login(token);
	            return "redirect:/toIndex.do";
			}  catch (IncorrectCredentialsException e) {  
	            System.out.println("登录密码错误. Password for account " + token.getPrincipal() + " was incorrect.");  
//	            logger.error("对用户[{}]进行登录验证,验证未通过,用户不存在",token.getPrincipal());
	            token.clear();
	            return "redirect:/login.do";
	        } catch (ExcessiveAttemptsException e) {  
	            System.out.println("登录失败次数过多"); 
	            token.clear();
	            return "redirect:/login.do";
	        } catch (LockedAccountException e) {  
	            System.out.println("帐号已被锁定. The account for username " + token.getPrincipal() + " was locked.");  
	        } catch (DisabledAccountException e) {  
	            System.out.println("帐号已被禁用. The account for username " + token.getPrincipal() + " was disabled.");  
	        } catch (ExpiredCredentialsException e) {  
	            System.out.println("帐号已过期. the account for username " + token.getPrincipal() + "  was expired.");  
	        } catch (UnknownAccountException e) {  
	            System.out.println("帐号不存在. There is no user with username of " + token.getPrincipal());  
	        }  catch (UnauthorizedException e) {  
	            System.out.println("您没有得到相应的授权！" + e.getMessage());  
	        }   
		}
        return "redirect:/login.do";
	}

	/**
	 * 退出
	 * 
	 * @return
	 */
	@RequestMapping(value = "/logout.do")
	@ResponseBody
	public String logout() {

		Subject currentUser = SecurityUtils.getSubject();
		String result = "logout";
		currentUser.logout();
		logger.info("======用户======退出了系统");
		return result;
	}
}
