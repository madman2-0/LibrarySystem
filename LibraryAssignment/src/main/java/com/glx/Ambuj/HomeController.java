package com.glx.Ambuj;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.glx.model.Books;
import com.glx.model.BooksList;


import com.glx.model.User;
import com.glx.service.BookService;

import com.glx.service.UserService;


@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	private UserService userService;
	@Autowired
	private BookService bookService;
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	@RequestMapping(value = "/registrationpage", method = RequestMethod.GET)
	public ModelAndView registrationPage( @ModelAttribute("user") User user){
		
		return new ModelAndView("signup");
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public ModelAndView register(@Valid @ModelAttribute("user") User user, BindingResult result){
		if (result.hasErrors()){
			return new ModelAndView("signup");
		}
		userService.save(user);
		return new ModelAndView("Successful","command",user);

	}
	
	@RequestMapping(value = "/signinpage", method = RequestMethod.GET)
	public ModelAndView signinPage(){
		
		
		return new ModelAndView("signin","command",new User());
	}
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam("username") String username,@RequestParam("password") String password ){
		ModelAndView mav=new ModelAndView();
		if(userService.authenticate(username,password)){
			User user=userService.showInfo(username);
			
			mav.setViewName("display");
			mav.addObject("user", user);
			return mav;
		}
		mav.setViewName("signin");
		mav.addObject("idErrorMsg", "*User Name or Password is incorrect");
		return mav;
			
	}
	
	
	
	
	@RequestMapping(value = "/UserupdatePage", method = RequestMethod.POST)
	public ModelAndView UserupdatePage(@ModelAttribute("user") User user){

		User user1=userService.showInfobyID(user.getId());
		

		if(user1!=null){
			user.setUsername(user1.getUsername());
			user.setPassword(user1.getPassword());
			user.setName(user1.getName());
			user.setDob(user1.getDob());
		return new ModelAndView("updatePage","command",user);
		}
		else{
			ModelAndView mav=new ModelAndView();
			mav.setViewName("id");
			mav.addObject("updateErrorMsg", "Id does not exist");
			return mav;
		}
	}
	
	@RequestMapping(value = "/updateuser", method = RequestMethod.POST)
	public ModelAndView updateuser(@ModelAttribute("user") User user){
		
		userService.update(user);
		
			return new ModelAndView("successfuluserupdate","command",new User());
	}
	@RequestMapping(value = "/deleteuser", method = RequestMethod.POST)
	public ModelAndView deleteuser(@RequestParam("id") int id){
		
		
	if (userService.delete(id)){
			return new ModelAndView("deletepage","command",new User());}
	else{
		ModelAndView mav=new ModelAndView();
		mav.setViewName("userid");
		mav.addObject("deleteErrorMsg", "Id does not exist");
		return mav;
		}
	}
	@RequestMapping(value = "/modifyaccount", method = RequestMethod.GET)
	public ModelAndView modifyaccount(@RequestParam ("ma") int id) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("modify");
		mav.addObject("ma",id);
		return mav;
	}
	
	@RequestMapping(value = "/useridpage", method = RequestMethod.GET)
	public String useridpage(Model model) {
		
		return "userid";
	}
	
	@RequestMapping(value = "/showinfousers")
	public ModelAndView showinfousers(@RequestParam("id")int userid){
			ModelAndView mav = new ModelAndView();
			
			List<BooksList>list=userService.getBooks(userid);

			mav.setViewName("showbookspage");
			mav.addObject("list",list);
			mav.addObject("userid", userid);
			return mav;
	}
	
	
	
	
	
	
	/*------------------------------------------------------------------*/
	
	
	
	/*BOOKS*/
	/*Update Books*/
	@RequestMapping(value = "/updateBook", method = RequestMethod.POST)
	public ModelAndView updatePage(@ModelAttribute("book") BooksList book){

		BooksList book1=bookService.BooksshowInfo(book.getBookid());
		

		if(book1!=null){
			book.setBookname(book1.getBookname());
			book.setBookid(book1.getBookid());
			book.setBookauthor(book1.getBookauthor());
		return new ModelAndView("updateBookPage","command",book);
		}
		else{
			ModelAndView mav=new ModelAndView();
			mav.setViewName("id");
			mav.addObject("updateErrorMsg", "Id does not exist");
			return mav;
		}
	}
	
	@RequestMapping(value = "/updatedBook", method = RequestMethod.POST)
	public ModelAndView update(@ModelAttribute("book") BooksList book){
		
		bookService.update(book);
		
			return new ModelAndView("SuccessfulUpdate","command", new BooksList());
	}
	
	@RequestMapping(value = "/bookidpage", method = RequestMethod.GET)
	public String bookid(Model model) {
		
		return "id";
	}

	@RequestMapping(value = "/adminloginpage", method = RequestMethod.GET)
	public String adminloginpage(Model model) {
		
		return "adminsignin";
	}
	@RequestMapping(value = "/loginadmin", method = RequestMethod.POST)
	public ModelAndView loginadmin(@RequestParam("adminusername") String adminusername,@RequestParam("adminpassword") String adminpassword ){
		ModelAndView mav=new ModelAndView();
		if(adminusername.equals("admin")&&adminpassword.equals("123")){
			
			mav.setViewName("adminpage");
			return mav;
		}
		mav.setViewName("adminsignin");
		mav.addObject("idErrorMsg", "*User Name or Password is incorrect");
		return mav;
		
	}
	
	@RequestMapping(value = "/insertbook", method = RequestMethod.GET)
	public ModelAndView insertpage( @ModelAttribute("book") User user){
		
		return new ModelAndView("bookslist");
	}
	
	@RequestMapping(value = "/insertbookdb", method = RequestMethod.POST)
	public ModelAndView insertbookdb( @ModelAttribute("book") BooksList book){

		bookService.insert(book);
		return new ModelAndView("SuccessfulBook","command",book);

	}
	@RequestMapping(value = "/backtoadminloginpage", method = RequestMethod.GET)
	public String backtoadminloginpage(Model model) {
		
		return "adminpage";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ModelAndView delete(@RequestParam("bookid") int bookid){
		
		
			
	if (bookService.delete(bookid)){
			return new ModelAndView("deletepage","command",new BooksList());}
	else{
		ModelAndView mav=new ModelAndView();
		mav.setViewName("id");
		mav.addObject("deleteErrorMsg", "Id does not exist");
		return mav;
		}
	}
	
	@RequestMapping(value = "/showinfobook", method = RequestMethod.POST)
	public ModelAndView showinfobook(@RequestParam("bookid") int bookid ){
			ModelAndView mav = new ModelAndView();
			List<User>list=bookService.getUsers(bookid);
		if(!list.isEmpty()){
			mav.setViewName("showinfopage");
			mav.addObject("list",list);
			mav.addObject("bookid", bookid);
			return mav;
		}
		else
			mav.setViewName("id");
			mav.addObject("showInfoErrorMsg","No id found");
			return mav;
	}
	
	
	
	
	
	
	
	
	
/*-----------------------------------------------------------------------------*/
	@RequestMapping(value = "/addbooks")
	public ModelAndView insertbookdb(){

		List<Object[]>list=bookService.createlist();
		
		List<Map<Integer,String>>list1=new ArrayList<Map<Integer,String>>();
		for(int i=0;i<list.size();i++)
		{
			Map<Integer,String>map=new HashMap<Integer, String>();
			map.put(((Integer)(list.get(i)[0])), ((String)(list.get(i)[1])));
			list1.add(map);
		}
		ModelAndView mav = new ModelAndView();
		mav.setViewName("bookstore");
		mav.addObject("map",list1);
		mav.addObject("book1", new Books()); 
		return mav;

	}
	@RequestMapping(value = "/submitbooks", method = RequestMethod.POST)
	public ModelAndView submitbooks(@ModelAttribute("book1") Books book){
	System.out.println(book.getBook());
	/*System.out.println(book1.getBookname());*/
	
	BooksList book1  = new BooksList();

	book1.setBookname("Oliver's Twist");
	book1.setBookauthor("Writer");
	
	BooksList book2  = new BooksList();

	book2.setBookname("Twilight");
	book2.setBookauthor("E. L. James");
	
	User user1 = new User();

	user1.setName("Ajay");
	user1.setUsername("ajayshakya");
	user1.setPassword("Ajay@123");
	user1.setDob("13/02/1994");
	
	User user2 = new User();

	user2.setName("Anuj");
	user2.setUsername("anujshakya");
	user2.setPassword("Anuj@123");
	user2.setDob("13/02/1994");
	
	user1.getBooks().add(book1);
	user1.getBooks().add(book2);
	book1.getUsers().add(user1);
	book2.getUsers().add(user1);
	
	user2.getBooks().add(book1);
	user2.getBooks().add(book2);
	book1.getUsers().add(user2);
	book2.getUsers().add(user2);
	
	bookService.insert(book1);
	bookService.insert(book2);

			return new ModelAndView("SuccessfulUpdate","command", new BooksList());
	}
	
	/*-----------------------------------------------------------------------------*/
	
	
	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public String aboutus(Model model) {
		
		return "about";
	}
	@RequestMapping(value = "/career", method = RequestMethod.GET)
	public String careers(Model model) {
		
		return "career";
	}

        @RequestMapping(value="/logout",method = RequestMethod.GET)
        public String logout(HttpServletRequest request){
            HttpSession httpSession = request.getSession();
            httpSession.invalidate();
            return "home";

    }
	
}
