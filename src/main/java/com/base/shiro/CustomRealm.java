package com.base.shiro;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.common.entity.SysManager;
import com.service.SysManagerService;

public class CustomRealm extends AuthorizingRealm {
	private static final Logger logger = Logger.getLogger(CustomRealm.class);
	@Autowired
	private SysManagerService sysManagerService;

	/**
	 * 认证-- Shiro登录认证(原理：用户提交 用户名和密码 --- shiro 封装令牌 ---- realm 通过用户名将密码查询返回 ----
	 * shiro 自动去比较查询出密码和用户输入密码是否一致---- 进行登陆控制 )
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// token中包含用户输入的用户名和密码
		// 第一步从token中取出用户名
		String userName = (String) token.getPrincipal();
		logger.info("[用户:" + userName + "|系统权限认证]");

		// 第二步：根据用户输入的userCode从数据库查询
		SysManager user = sysManagerService.selectManagerByAccount(userName);
		// 如果查询不到返回null
		// 判断用户是否存在
		if (user == null) {
			// 用户不存在
			throw new UnknownAccountException("没有找到该账号");
		} else {
			// 用户名存在
			// 参数1：用户对象，将来要放入session,数据库查询出来的用户
			// 参数2：凭证（密码）：密码校验：校验的动作交给shiro
			// 参数3:当前使用的Realm在Spring容器中的名字(bean的名字，自动在spring容器中寻找)
			SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user, user.getPassword(),
					super.getName());
			logger.info("[用户:" + userName + "|系统权限认证完成]");
			return authenticationInfo;// 密码校验失败，会自动抛出IncorrectCredentialsException
		}
		// 获取数据库中的密码
		/**
		 * 认证的用户,正确的密码
		 */
		// MD5 加密+加盐+多次加密
	}

	/**
	 * 授权,只有成功通过doGetAuthenticationInfo方法的认证后才会执行。
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// 从 principals获取主身份信息
		logger.info(principals.getPrimaryPrincipal());
		// 根据身份信息从数据库获取到权限数据
		Set<String> roles = new HashSet<String>();
		roles.add("admin");
		
		// 单独定一个集合对象
		Set<String> permissions = new HashSet<String>();
		permissions.add("permissions1");
		permissions.add("permissions2");

		// 查到权限数据，返回授权信息(要包括 上边的permissions)
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		// 将上边查询到授权信息填充到simpleAuthorizationInfo对象中
		simpleAuthorizationInfo.setRoles(roles);
		simpleAuthorizationInfo.setStringPermissions(permissions);
		return simpleAuthorizationInfo;
	}

	// 清除缓存
	public void clearCached() {
		PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();
		super.clearCache(principals);
	}

	@Override
	public String getName() {
		return getClass().getName();
	}
}