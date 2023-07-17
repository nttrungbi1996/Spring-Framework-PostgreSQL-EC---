package com.example.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.model.Account;

@Aspect
@Component
public class CheckLoginAdminAspect {

	@Autowired
	Account account;

	// ログ出力処理
	// 全Controllerクラスの全メソッド処理的を指定
	@Before("execution(* com.example.demo.controller.admin.*AdminController.*(..))")
	public void writeLog(JoinPoint jp) {
		//
		if (account == null || account.getName() == null
				|| account.getName().length() == 0) {
			System.out.println("ゲスト：");
		} else {
			System.out.println(account.getName() + "：");
		}
		System.out.println(jp.getSignature());
	}

	@Around("execution(* com.example.demo.controller.admin.ItemAdminController.*(..)) ||"
			+ "execution(* com.example.demo.controller.admin.CategoryAdminCotroller.*(..)) ||"
			+ "execution(* com.example.demo.controller.admin.EnquiriesAdminController.*(..)) ||"
			+ "execution(* com.example.demo.controller.admin.CustomerAdminController.*(..))")
	public Object checkLogin(ProceedingJoinPoint jp) throws Throwable {

		if (account == null || account.getName() == null
				|| account.getName().length() == 0) {
			System.out.println("ログインしていません！");

			return "redirect:/admin/login?error=notLoggedIn";
		}

		return jp.proceed();
	}
}
