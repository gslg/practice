package com.util.page;

import java.io.Serializable;  
import java.util.List;  
  
/** 
 * 进行分页查询的结果封装类 
 * @author liuguo 
 * 
 * @param <T> 
 */  
public class PageBean<T> implements Serializable{   
    private static final long serialVersionUID = 1L;  
  
    /** 
     * 当前页码 
     */  
    private int currentPage=1;  
    /** 
     * 页面条目数，即每页面显示的记录数 
     */  
    private int pageSize=20;
    
    /** 
     * 总页数 
     */  
    private long pageCount=0;  
     /**
      * 总记录数
      */
    private long totalCount=0;
    /** 
     * 查询结果列表 
     */  
    private List<T> resultList;  
    /**
     * 是否分页
     */
    private boolean isPagging = true;
   /**
    * <获取当前每页显示条数>
    * @return
    */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * <设置每页显示条数>
	 * @param pageSize
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	
	/**
	 * <获取总页数>
	 * @return
	 */
	public long getPageCount() {
//		 if(count==0)return 0;  
//	     if(pageSize==0)return 0; 
//	        //long pageTotal1= totalCount%pageCount == 0 ? totalCount/pageCount : totalCount/pageCount+1;
//	     //long pageTotal=(pageCount-1)/pageSize+1;
//	        
//	    return (pageCount-1)/pageSize+1; 
		return pageCount;
	}
	/**
	 * <设置总页数>
	 * @param pageCount
	 */
	public void setPageCount(long pageCount) {
		this.pageCount = pageCount;
	}
	/**
	 * <获取总记录数>
	 */
	public long getTotalCount() {
		return totalCount;
	}

	/**
	 * <设置总记录数>
	 * @param count
	 */
	public void setTotalCount(long count) {
		this.totalCount = count;
	}

	/**
	 * <获取封装查询结果对象列表>
	 * @return
	 */
	public List<T> getResultList() {
		return resultList;
	}

	/**
	 * <设置对象列表>
	 * @param resultList
	 */
	public void setResultList(List<T> resultList) {
		this.resultList = resultList;
	}

	/**
	 * 是否分页
	 * @return
	 */
	public boolean isPagging() {
		return isPagging;
	}

	/**
	 * <是否分页>
	 * @param isPagging true 分页 and false 不分页
	 */
	public void setPagging(boolean isPagging) {
		this.isPagging = isPagging;
	}

    /**
     * <获取当前页数>
     * @return
     */
	public int getCurrentPage() {
		return currentPage;
	}

	/**
	 * <设置当前页数>
	 * @param currentPage
	 */
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public void resetPageNo() {
        this.pageCount = (totalCount-1)/pageSize+1;
    }
    
}