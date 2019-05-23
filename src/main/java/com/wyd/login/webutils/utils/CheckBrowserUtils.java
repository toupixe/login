package com.wyd.login.webutils.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;


@Component
public class CheckBrowserUtils {
		public static List<String> browserList = new ArrayList<String>(45);// list大小
		//browserList里面的值表示的是移动端（非PC端）
		static {
			browserList.add("nokia");
			browserList.add("samsung");
			browserList.add("midp-2");
			browserList.add("cldc1.1");
			browserList.add("symbianos");
			browserList.add("maui");
			browserList.add("untrusted/1.0");
			browserList.add("windows ce");
			browserList.add("iphone");
			browserList.add("ipad");
			browserList.add("android");
			browserList.add("blackberry");
			browserList.add("ucweb");
			browserList.add("brew");
			browserList.add("j2me");
			browserList.add("yulong");
			browserList.add("coolpad");
			browserList.add("tianyu");
			browserList.add("ty-");
			browserList.add("k-touch");
			browserList.add("haier");
			browserList.add("dopod");
			browserList.add("lenovo");
			browserList.add("mobile");
			browserList.add("huaqin");
			browserList.add("aigo-");
			browserList.add("ctc/1.0");
			browserList.add("ctc/2.0");
			browserList.add("cmcc");
			browserList.add("daxian");
			browserList.add("mot-");
			browserList.add("sonyericsson");
			browserList.add("gionee");
			browserList.add("htc");
			browserList.add("zte");
			browserList.add("huawei");
			browserList.add("webos");
			browserList.add("gobrowser");
			browserList.add("iemobile");
			browserList.add("wap2.0");
			browserList.add("ucbrowser");
			browserList.add("ipod");
		}
	 
	}
