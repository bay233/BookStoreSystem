package com.Bean;

import java.io.Serializable;
import java.util.List;

public class PageBean<T> implements Serializable{

	private List<T> list;	//内容
	
	private int pageno;	//当前页
	private int pagesize = 0;   //每页大小
	private int prepage;	//上一页
	private int nextpage; //下一页
	
	private long total; //数据总数
	private int totalpages=1;   //总页数
	
	public int getTotalpages() {
		if (total%pagesize==0){
			totalpages = (int) total/pagesize;
		}else {
			totalpages = (int) total/pagesize+1;
		}
		return totalpages;
	}
	
	public int getPrepage() {
		if (pageno > 1){
			prepage = pageno-1;
		}else {
			prepage = 1;
		}
		return prepage;
	}
	
	public int getNextpage() {
		int tp = getTotalpages();
		if ( pageno == tp){
			nextpage = tp;
		}else{
			nextpage = pageno + 1;
		}
		return nextpage;
	}
	
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public int getPageno() {
		return pageno;
	}
	public void setPageno(int pageno) {
		this.pageno = pageno;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	
	public void setPrepage(int prepage) {
		this.prepage = prepage;
	}
	
	public void setNextpage(int nextpage) {
		this.nextpage = nextpage;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "PageBean [list=" + list.toString() + ", pageno=" + pageno + ", pagesize="
				+ pagesize + ", prepage=" + getPrepage() + ", nextpage=" + getNextpage()
				+ ", total=" + total + ", totalpages=" + getTotalpages() + "]";
	}
	
	
	
	
}
