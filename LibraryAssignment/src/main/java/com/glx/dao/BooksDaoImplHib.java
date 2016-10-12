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

import com.glx.model.BooksList;
import com.glx.model.User;

@Repository
@Primary
public class BooksDaoImplHib implements BooksDao{
	@Autowired
	private SessionFactory sessionFactory;
	    @Override
		public void insert(BooksList book) {
			 
	    	Session session = sessionFactory.openSession();
			 session.beginTransaction();
			 session.save(book);
			 session.getTransaction().commit();
			 session.close();
	 }

	
		
		@Override
		public void update(BooksList book) {
	    	Session session = sessionFactory.openSession();
			 session.beginTransaction();
			 
			 //Using Load
			 try{
			 BooksList BooksList = (BooksList) session.load(BooksList.class, book.getBookid());
			 
				BooksList.setBookname(book.getBookname());
				BooksList.setBookid(book.getBookid());
				BooksList.setBookauthor(book.getBookauthor());
				session.getTransaction().commit();
				session.close();
			 }
			 catch(Exception e){
				 return;
			 }
		}

		@Override
		public boolean delete(int bookid) {
	    	Session session = sessionFactory.openSession();
			 session.beginTransaction();
			 //Using Get
			 BooksList BooksList = (BooksList) session.get(BooksList.class, bookid);
			 session.getTransaction().commit();
			 session.flush();
		     session.clear();
		     
			 if(BooksList!=null){
			 session.delete(BooksList);
			 session.getTransaction().commit();
				session.close();
				return true;
				}
			 return false;
			
		}

		@Override
		public BooksList BooksshowInfo(int bookid) {
	    	Session session = sessionFactory.openSession();
			 session.beginTransaction();
			 try{
			
			 BooksList booksList = (BooksList) session.load(BooksList.class, bookid);
				 
			 
			     BooksList BooksList=new BooksList(); 
			
				
				BooksList.setBookid(booksList.getBookid());
				BooksList.setBookname(booksList.getBookname());
			    BooksList.setBookauthor(booksList.getBookauthor());

				session.getTransaction().commit();
				session.close();
			   return BooksList;
			   }
			 catch (Exception e){
				 return null;
			 }
		}



		@Override
		public List<Object[]> createlist() {
			Session session = sessionFactory.openSession();
			 session.beginTransaction();
			 try{
			List<Object[]> bookslist = (List<Object[]>)(session.createQuery("Select bookid, bookname from BooksList").list());
/*			for(Object[] list: bookslist){

		        Integer id = (Integer)list[0];

		        System.out.println(id);

		        String name = (String)list[1];
		        
		        System.out.println(name);
			}*/
			session.getTransaction().commit();
			session.close();
			return bookslist;
			}
			 catch (Exception e){e.printStackTrace();
			return null;
			 }
		}
		
		@Override
		public List<User> getUsers(int bookid) {
			Session session=sessionFactory.openSession();
			List<User> userslist=new ArrayList<User>();
			Query query=session.createQuery("from BooksList bl where bl.bookid = :id");
			query.setParameter("id", bookid);
			if ((query.list() != null) && !query.list().isEmpty())
			{
				Query query1=session.createSQLQuery("select * from USER_BOOKSLIST bl where bl.bookId = :id");
				query1.setParameter("id", bookid);
				
				if (!query1.list().isEmpty()){
				List<Object[]> ids=query1.list();
					
					for(Object[] p:ids)
					{
						int uid=Integer.parseInt(p[1].toString());
						System.out.println(uid);
						userslist.add((User) session.get(User.class, uid));
						
					}
				}

			}			
			return userslist;
			
		}
}
		