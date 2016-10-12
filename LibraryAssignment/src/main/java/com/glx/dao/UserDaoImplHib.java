package com.glx.dao;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.glx.model.Books;
import com.glx.model.BooksList;
import com.glx.model.User;

@Repository
@Primary
public class UserDaoImplHib implements UserDao{
	@Autowired
	private SessionFactory sessionFactory;
	    @Override
		public void save(User user) {
			 
	    	Session session = sessionFactory.openSession();
			 session.beginTransaction();
			 session.save(user);
			 session.getTransaction().commit();
			 session.close();
	 }

		@Override
		public boolean authenticate(String username, String password) {
	    	Session session = sessionFactory.openSession();
			 session.beginTransaction();
			 
			 //Using Query
			 Query query = session.createQuery("from User where username = :uname and password = :pword ");
			 query.setString("uname", username);
			query.setString("pword", password);
			List <User> list = query.list();
			if (!list.isEmpty())
			 return true;
			else return false;
		}

		@Override
		public User showInfo(String username) {
	    	Session session = sessionFactory.openSession();
			 session.beginTransaction();
			 
			 //Using Criteria
			 Criteria cr = session.createCriteria(User.class);
			 cr.add(Restrictions.eq("username", username));
			 List <User> list = cr.list();
			 User user=new User(); 
			 
			 for (User User: list){				
				user.setId(User.getId());
				user.setName(User.getName());
			    user.setDob(User.getDob());
			    user.setPassword(User.getPassword());
			    user.setUsername(User.getUsername());
			    }
				session.getTransaction().commit();
				session.close();
			   return user;
		}

		@Override
		public void update(User user) {
	    	Session session = sessionFactory.openSession();
			 session.beginTransaction();
			 
			 //Using Load
			 try{
			 User User = (User) session.load(User.class, user.getId());
			 
			 	User.setUsername(user.getUsername());
				User.setPassword(user.getPassword());
				User.setName(user.getName());
				User.setId(user.getId());
				User.setDob(user.getDob());
				session.getTransaction().commit();
				session.close();
			 }
			 catch(Exception e){
				 return;
			 }
		}

		@Override
		public boolean delete(int id) {
	    	Session session = sessionFactory.openSession();
			 session.beginTransaction();
			 //Using Get
			 User User = (User) session.get(User.class, id);
			 if(User!=null){
			 session.delete(User);
			 session.getTransaction().commit();
				session.close();
				return true;
				}
			 return false;
			
		}

		@Override
		public User showInfobyID(int id) {
	    	Session session = sessionFactory.openSession();
			 session.beginTransaction();
			 try{
			 User User = (User) session.load(User.class, id);
			 User user=new User(); 
			
				
				user.setId(User.getId());
				user.setName(User.getName());
			    user.setDob(User.getDob());
			    user.setPassword(User.getPassword());
			    user.setUsername(User.getUsername());
				session.getTransaction().commit();
				session.close();
			   return user;
			   }
			 catch (Exception e){
				 return null;
			 }
		}
		@Override
		public List<BooksList> getBooks(int userid) {
			Session session=sessionFactory.openSession();
			Query query=session.createSQLQuery("select * from USER_BOOKSLIST where userId="+userid);
		List<Object[]> ids=query.list();
			List<BooksList> bookslist=new ArrayList<BooksList>();
			for(Object[] p:ids)
			{
				int uid=Integer.parseInt(p[0].toString());
				System.out.println(uid);
				bookslist.add((BooksList) session.get(BooksList.class, uid));
				
			}
			return bookslist;
		}
}
		