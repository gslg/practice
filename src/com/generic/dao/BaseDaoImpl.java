package com.generic.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.jdbc.Work;
import org.springframework.beans.factory.annotation.Autowired;

import com.util.page.PageBean;

public class BaseDaoImpl<T, ID extends Serializable> implements BaseDao<T, ID>{
	@Autowired
	private SessionFactory sessionFactory;
	
	protected Class<T> entityClass;
	
	public BaseDaoImpl() {
	}
	/**
	 * 得到实体类型
	 * @return
	 */
	protected Class getEntityClass(){
		if (entityClass == null) {
			ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
			
            entityClass = (Class<T>) type.getActualTypeArguments()[0];
        }
		return entityClass;
	}
	
	/**
     * @return the sessionFactory
     */
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
 
    /**
     * @param sessionFactory the sessionFactory to set
     */
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
     
    /**
     * 
     * @return session
     */
    public Session getSession() {
        //需要开启事物，才能得到CurrentSession
        return sessionFactory.getCurrentSession();
    }
    
	@Override
	public void save(T t) {
		this.getSession().save(t);
	}

	@Override
	public void saveOrUpdate(T t) {
		this.getSession().saveOrUpdate(t);
	}

	@Override
	public T load(ID id) {
		return (T) this.getSession().load(getEntityClass(), id);
	}

	@Override
	public T get(ID id) {
		return (T) this.getSession().get(getEntityClass(), id);
	}

	@Override
	public boolean contains(T t) {
		return this.getSession().contains(t);
	}

	@Override
	public void delete(T t) {
		this.getSession().delete(t);
	}

	@Override
	public boolean deleteById(ID Id) {
		 T t = get(Id);
         if(t == null){
             return false;
         }
         delete(t);
        return true;
	}

	/**
	 * 批量删除
	 * @param entities
	 */
	@Override
	public void deleteAll(Collection<T> entities) {
		for(T entity : entities)
			delete(entity);
	}

	/**
	 * 执行HQL语句
	 * @param hqlString
	 * @param values 不定参数数组
	 */
	@Override
	public void queryHql(String hqlString, Object[] values) {
		Query query = this.getSession().createQuery(hqlString);
		if(values!=null && values.length>0){
			for(int i =0;i<values.length;i++)
				query.setParameter(i, values[i]);
		}
		
		query.executeUpdate();
	}

	/**
	 * 执行SQL语句
	 * @param sqlString
	 * @param values 不定参数数组
	 */
	@Override
	public void querySql(String sqlString, Object[] values) {
		Query query = this.getSession().createSQLQuery(sqlString);
		if(values!=null && values.length>0){
			for(int i =0;i<values.length;i++)
				query.setParameter(i, values[i]);
		}
		
		query.executeUpdate();
	}

	/**
	 * 根据HQL语句查询并返回唯一实体
	 * @param hqlString
	 * @param values 不定参数数组
	 */
	@Override
	public T getByHQL(String hqlString, Object[] values) {
		Query query = this.getSession().createQuery(hqlString);
		if(values!=null && values.length>0){
			for(int i =0;i<values.length;i++)
				query.setParameter(i, values[i]);
		}
		return (T) query.uniqueResult();
	}

	/**
	 * 根据SQL语句查询并返回唯一实体
	 * @param sqlString
	 * @param values 不定参数数组
	 */
	@Override
	public T getBySQL(String sqlString, Object[] values) {
		Query query = this.getSession().createSQLQuery(sqlString);
		if(values!=null && values.length>0){
			for(int i =0;i<values.length;i++)
				query.setParameter(i, values[i]);
		}
		
		return (T) query.uniqueResult();
	}

	/**
     * <根据HQL语句，得到对应的list>
     * @param hqlString HQL语句
     * @param values 不定参数的Object数组
     * @return 查询多个实体的List集合
     */
	@Override
	public List<T> getListByHQL(String hqlString, Object[] values) {
		Query query = this.getSession().createQuery(hqlString);
		if(values!=null && values.length>0){
			for(int i =0;i<values.length;i++)
				query.setParameter(i, values[i]);
		}
		
		return query.list();
	}
	/**
     * <根据SQL语句，得到对应的list>
     * @param sqlString HQL语句
     * @param values 不定参数的Object数组
     * @return 查询多个实体的List集合
     */
	@Override
	public List<T> getListBySQL(String sqlString, Object[] values) {
		Query query = this.getSession().createSQLQuery(sqlString);
		if(values!=null && values.length>0){
			for(int i =0;i<values.length;i++)
				query.setParameter(i, values[i]);
		}
		return query.list();
	}

	@Override
	public List findListBySql(final String sql, final RowMapper map, final Object[] values) {
		final List list = new ArrayList();
		//执行JDBC批量保存
		Work jdbcWork = new Work() {
			
			@Override
			public void execute(Connection connection) throws SQLException {
				PreparedStatement ps = null;
				ResultSet rs = null;
				
				try {
					ps = connection.prepareStatement(sql);
					if(values!=null && values.length>0){
						for(int i = 0;i<values.length;i++){
							setParameter(ps, i, values[i]);
						}
					}
					
					rs = ps.executeQuery();
					int index = 0;
					while(rs.next()){
						Object obj = map.mapRow(rs, index++);
						list.add(obj);
					}
				} finally{
					if(rs!=null){
						rs.close();
					}
					if(ps!=null){
						ps.close();
					}
				}
			}
		};
		this.getSession().doWork(jdbcWork);
		return list;
	}

	@Override
	public void refresh(T t) {
		this.getSession().refresh(t);
	}

	@Override
	public void update(T t) {
		this.getSession().update(t);
	}
	/**
     * <根据HQL得到记录数>
     * @param hql HQL语句
     * @param values 不定参数的Object数组
     * @return 记录总数
     */
	@Override
	public Long countByHql(String hql, Object[] values) {
		 Query query = this.getSession().createQuery(hql);
	        if(values != null){
	            for(int i = 0; i < values.length; i++) {
	                query.setParameter(i, values[i]);
	            }
	        }
	        return (long)query.list().size();
	}
	/**
	 * <HQL分页查询>
	 * @param hql HQL语句
	 * @param countHql 查询记录条数的HQL语句
	 * @param pageNo 当前页数
	 * @param pageSize 每页显示的条数
	 * @param values 不定参数的数组
	 * @return 分页对象  里面包含了页码的信息以及查询的数据List集合
	 */
	@Override
	public PageBean<T> findPageByFetchedHql(String hql, String countHql, int pageNo, 
			int pageSize, Object[] values) {
		PageBean<T> pageBean = new PageBean<T>();
		
		Query query = this.getSession().createQuery(hql);
		if(values!=null && values.length>0){
			for(int i=0;i<values.length;i++){
				query.setParameter(i, values[i]);
			}
		}
		
		int currentPage = pageNo>1 ? pageNo : 1;
		
		pageBean.setCurrentPage(currentPage);
		pageBean.setPageSize(pageSize);
		
		if(countHql == null){
			ScrollableResults results = query.scroll();
			results.last();
			pageBean.setTotalCount(results.getRowNumber()+1);//设置总记录数
		}else{
			Long count = countByHql(countHql,values);
			pageBean.setTotalCount(count.intValue());
		}
		pageBean.resetPageNo();
		
		List<T> itemList = query.setFirstResult((currentPage - 1) * pageSize)
								.setMaxResults(pageSize).list();
        if (itemList == null)
        {
            itemList = new ArrayList<T>();
        }
        pageBean.setResultList(itemList);
		return pageBean;
	}

	/**
     * 
     * 设置每行批处理参数
     * 
     * @param ps
     * @param pos ?占位符索引，从0开始
     * @param data
     * @throws SQLException
     * @see [类、类#方法、类#成员]
     */
    private void setParameter(PreparedStatement ps, int pos, Object data)
        throws SQLException
    {
        if (data == null)
        {
            ps.setNull(pos + 1, Types.VARCHAR);
            return;
        }
        Class dataCls = data.getClass();
        //String
        if (String.class.equals(dataCls))
        {
            ps.setString(pos + 1, (String)data);
        }
        //boolean
        else if (boolean.class.equals(dataCls))
        {
            ps.setBoolean(pos + 1, ((Boolean)data));
        }
        //int
        else if (int.class.equals(dataCls))
        {
            ps.setInt(pos + 1, (Integer)data);
        }
        //double
        else if (double.class.equals(dataCls))
        {
            ps.setDouble(pos + 1, (Double)data);
        }
        //Date
        else if (Date.class.equals(dataCls))
        {
            Date val = (Date)data;
            ps.setTimestamp(pos + 1, new Timestamp(val.getTime()));
        }
        //BigDecimal
        else if (BigDecimal.class.equals(dataCls))
        {
            ps.setBigDecimal(pos + 1, (BigDecimal)data);
        }
        else
        {
            // 未知类型
            ps.setObject(pos + 1, data);
        }
         
    }
     

}
