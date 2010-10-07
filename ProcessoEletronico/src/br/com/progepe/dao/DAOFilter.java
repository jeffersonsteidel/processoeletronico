package br.com.progepe.dao;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.hibernate.Filter;
import org.hibernate.HibernateException;

public class DAOFilter implements Filter {
	public void init(FilterConfig config) throws ServletException {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HibernateUtility.beginTransaction();
		try {
			chain.doFilter(request, response);
			HibernateUtility.commitTransaction();
		} catch (HibernateException exception) {
			exception.printStackTrace();
			HibernateUtility.rollbackTransaction();
		} finally {
			HibernateUtility.closeSession();
		}
	}

	public void destroy() {
	}

	public String getName() {
		return null;
	}

	public Filter setParameter(String arg0, Object arg1) {
		return null;
	}

	@SuppressWarnings("rawtypes")
	public Filter setParameterList(String arg0, Collection arg1) {
		return null;
	}

	public Filter setParameterList(String arg0, Object[] arg1) {
		return null;
	}

	public void validate() throws HibernateException {
		// TODO Auto-generated method stub

	}
}
