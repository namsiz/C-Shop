package com.cshop.controller;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cshop.mapper.TbItemMapper;
import com.cshop.pojo.TbItem;
import com.cshop.pojo.TbItemExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


public class TestPageHelper {
	@Test
	public void testPageHelpe() {
		ApplicationContext applicationContect = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
		TbItemMapper mapper = applicationContect.getBean(TbItemMapper.class);
		TbItemExample example = new TbItemExample();
		PageHelper.startPage(2, 10);
		
		List<TbItem> list =  mapper.selectByExample(example);
		for(TbItem tbItem:list) {
			System.out.println(tbItem.getTitle());
		}
		PageInfo<TbItem> pageinfo = new PageInfo<>(list);
		long total = pageinfo.getTotal();
		System.out.println("共有："+total);
	}
}
