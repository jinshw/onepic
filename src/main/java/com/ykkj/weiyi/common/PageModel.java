package com.ykkj.weiyi.common;

import java.io.Serializable;
import java.util.List;

/**
 * 分页模型
 *
 * @模块：
 *
 * @作者： 张晓东
 * @创建日期： 2015年11月2日
 *
 * @修改记录（修改时间、作者、原因）：
 */
@SuppressWarnings("serial")
public class PageModel implements Serializable{
    private int total;//总记录数 
    private int pages;//总页数
    private int pageSize;//每页显示条数
    private List<?> list;//当前页列表数
    private int pageIndex;//当前页面
    private long objectId;
    private String objectName;
    private long customId;

    //创建对象用
  	public PageModel() {
  		super();
  	}

  	/**
  	 * 传递参数用于获取总页数
  	 *
  	 * @作者: 张晓东
  	 * @创建日期： 2015年11月2日
  	 *
  	 * @参数：  total 总记录数
  	 * @参数：  pageSize 每页显示条数
  	 *
  	 * @修改记录（修改时间、作者、原因）：
  	 */
  	public PageModel(int total, int pageSize) {
  		super();
  		this.total = total;
  		this.pageSize = pageSize;
  	}
    
	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<?> getList() {
		return list;
	}

	public void setList(List<?> list) {
		this.list = list;
	}
	
	public int getPages() {
		if(total==0){
			pages=0;
			return pages;
		}
		
		if(pages==0){
			if(total%pageSize==0){
				pages=total/pageSize;
			}else{
				pages=(total/pageSize)+1;
			}
		}
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public long getObjectId() {
		return objectId;
	}

	public void setObjectId(long objectId) {
		this.objectId = objectId;
	}

	public String getObjectName() {
		return objectName;
	}

	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}

	public long getCustomId() {
		return customId;
	}

	public void setCustomId(long customId) {
		this.customId = customId;
	}
	
	/**
	 * 获取分页导航串
	 * @return
	 */
	public String getPageNavStr(){
		StringBuffer navStr=new StringBuffer("");
		int pages=this.getPages();//获取总页数
		navStr.append("<a href=\"#\" class=\"prev\" onclick=\"page("+(pageIndex-1)+")\"></a>");
		if(pages<=5){
			for(int i=1;i<=pages;i++){//小于等于总页数
				if(pageIndex==i){
					navStr.append("<span class=\"current\">"+i+"</span>");
				}else{
					navStr.append("<a href=\"#\" onclick=\"page("+i+")\"><b>"+i+"</b></a>");
				}
			}
		}else if(pages>5){
				if(pageIndex<=5){
					for(int m=1;m<=pageIndex;m++){
						if(m==pageIndex){
							navStr.append("<span class=\"current\">"+m+"</span>");
						}else{
							navStr.append("<a href=\"#\" onclick=\"page("+m+")\" ><b>"+m+"</b></a>");
						}
					}
				}else{
					navStr.append("<a href=\"#\" onclick=\"page(1)\" ><b>1</b></a>");
					navStr.append("<span class=\"zhongduan\">...</span>");
					for(int m=(pageIndex-3);m<=pageIndex;m++){
						if(m==pageIndex){
							navStr.append("<span class=\"current\">"+m+"</span>");
						}else{
							navStr.append("<a href=\"#\" onclick=\"page("+m+")\" ><b>"+m+"</b></a>");
						}
					}
				}
				
				if((pageIndex+3)>=pages){
					for(int m=(pageIndex+1);m<=pages;m++){
						navStr.append("<a href=\"#\" onclick=\"page("+m+")\"><b>"+m+"</b></a>");
					}
				}else{
					navStr.append("<a href=\"#\" onclick=\"page("+(pageIndex+1)+")\" ><b>"+(pageIndex+1)+"</b></a>");
					navStr.append("<a href=\"#\" onclick=\"page("+(pageIndex+2)+")\" ><b>"+(pageIndex+2)+"</b></a>");
					navStr.append("<span class=\"zhongduan\">...</span>");
					navStr.append("<a href=\"#\" onclick=\"page("+pages+")\"><b>"+pages+"</b></a>");
				}
		}
		if(pageIndex>=pages){
			pageIndex=(pages-1);
		}
		navStr.append("<a href=\"#\" class=\"next\" onclick=\"page("+(pageIndex+1)+")\" ></a>");
		return navStr.toString();
	}
	
	/**
	 * 获取分页页面码导航代码
	 * @return
	 */
	public String getPageDpubNavStr(){
		StringBuffer navStr=new StringBuffer("");
		int pages=this.getPages();//获取总页数
		navStr.append("<div class=\"page_orange clearfix mb30 mr20 mt20\">");
		navStr.append("<a href=\"${filterUrl(cururi,'page_index','1','update')}\" class=\"${prev_style!}\" onclick=\"page("+(pageIndex-1)+")\"></a>");
		if(pages<=5){
			for(int i=1;i<=pages;i++){//小于等于总页数
				if(pageIndex==i){
					navStr.append("<span class=\"${cur_page!}\">"+i+"</span>");
				}else{
					navStr.append("<a href=\"${filterUrl(cururi,'page_index','"+i+"','update')}\" onclick=\"page("+i+")\"><b>"+i+"</b></a>");
				}
			}
		}else if(pages>5){
				if(pageIndex<=5){
					for(int m=1;m<=pageIndex;m++){
						if(m==pageIndex){
							navStr.append("<span class=\"${cur_page!}\">"+m+"</span>");
						}else{
							navStr.append("<a href=\"${filterUrl(cururi,'page_index','"+m+"','update')}\" onclick=\"page("+m+")\" ><b>"+m+"</b></a>");
						}
					}
				}else{
					navStr.append("<a href=\"${filterUrl(cururi,'page_index','1','update')}\" onclick=\"page(1)\" ><b>1</b></a>");
					navStr.append("<span class=\"zhongduan\">...</span>");
					for(int m=(pageIndex-3);m<=pageIndex;m++){
						if(m==pageIndex){
							navStr.append("<span class=\"${cur_page!}\">"+m+"</span>");
						}else{
							navStr.append("<a href=\"${filterUrl(cururi,'page_index','"+m+"','update')}\" onclick=\"page("+m+")\" ><b>"+m+"</b></a>");
						}
					}
				}
				
				if((pageIndex+3)>=pages){
					for(int m=(pageIndex+1);m<=pages;m++){
						navStr.append("<a href=\"${filterUrl(cururi,'page_index','"+m+"','update')}\" onclick=\"page("+m+")\"><b>"+m+"</b></a>");
					}
				}else{
					navStr.append("<a href=\"${filterUrl(cururi,'page_index','"+(pageIndex+1)+"','update')}\" onclick=\"page("+(pageIndex+1)+")\" ><b>"+(pageIndex+1)+"</b></a>");
					navStr.append("<a href=\"${filterUrl(cururi,'page_index','"+(pageIndex+2)+"','update')}\" onclick=\"page("+(pageIndex+2)+")\" ><b>"+(pageIndex+2)+"</b></a>");
					navStr.append("<span class=\"zhongduan\">...</span>");
					navStr.append("<a href=\"${filterUrl(cururi,'page_index','"+pages+"','update')}\" onclick=\"page("+pages+")\"><b>"+pages+"</b></a>");
				}
		}
		if(pageIndex>=pages){
			pageIndex=(pages-1);
		}
		navStr.append("<a href=\"${filterUrl(cururi,'page_index','"+(pageIndex+1)+"','update')}\" class=\"${next_style!}\" onclick=\"page("+(pageIndex+1)+")\" ></a>");
		navStr.append("</div>");
		return navStr.toString();
	}
}
