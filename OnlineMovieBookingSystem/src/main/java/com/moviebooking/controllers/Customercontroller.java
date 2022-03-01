package com.moviebooking.controllers;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.http.HttpRequest;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.springframework.format.datetime.joda.LocalDateParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.moviebooking.bean.Admin;
import com.moviebooking.bean.Customer;
import com.moviebooking.bean.Movie;
import com.moviebooking.bean.Seat;
import com.moviebooking.bean.Shows;
import com.moviebooking.bean.Theatre;
import com.moviebooking.bean.Ticket;
import com.moviebooking.service.AdminService;
import com.moviebooking.service.AdminServiceImpl;
import com.moviebooking.service.BookingService;
import com.moviebooking.service.BookingServiceImpl;
import com.moviebooking.service.Customerservieimpl;
import com.moviebooking.service.MovieService;
import com.moviebooking.service.MovieServiceImpl;
import com.moviebooking.service.SeatServiceImpl;
import com.moviebooking.service.Seatservice;
import com.moviebooking.service.ShowService;
import com.moviebooking.service.ShowServiceImpl;
import com.moviebooking.service.Theatreservice;
import com.moviebooking.service.TheatreserviceImpl;
import com.moviebooking.service.TicketService;
import com.moviebooking.service.TicketServiceImpl;
import com.mysql.cj.jdbc.Blob;

@Controller
@RequestMapping("/")
@SessionAttributes({ "Logininfo" })
public class Customercontroller {

	String filePath = "WEB-INF" + File.separator + "PosterImages" + File.separator;
	String location;
	String date;

	Customerservieimpl impl = new Customerservieimpl();
	Theatreservice timpl = new TheatreserviceImpl();
	AdminService aimpl = new AdminServiceImpl();
	MovieService mimpl = new MovieServiceImpl();
	ShowService simpl = new ShowServiceImpl();
	Seatservice seimpl = new SeatServiceImpl();
	TicketService tiimpl  =  new TicketServiceImpl();
	BookingService bimpl  = new BookingServiceImpl();

	@RequestMapping(value = "/Login", method = RequestMethod.GET)
	public String ShowLogin() {
		return "Loginpage";
	}

	@RequestMapping(value = "/selectlocation", method = RequestMethod.GET)
	public String SelectLocation(Model model) {
		List<Theatre> ltheatre = timpl.allTheatreLoaction();
		Set<String> dtheatre = new TreeSet<String>();
		for (Theatre t : ltheatre) {
			dtheatre.add(t.getLocation());
		}
		
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
		   LocalDateTime now = LocalDateTime.now();  
		  String format1 = dtf.format(now);
		  System.out.println(format1);
		  List<String> dates  = new ArrayList<String>();
		  dates.add(format1);
		  
		  
		  for(int i=1;i<=6;i++) {
		  SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		   Date date = null;
		try {
			date = format.parse(format1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   Calendar calendar = Calendar.getInstance();
		  calendar.setTime(date);
		  calendar.add(Calendar.DAY_OF_YEAR, i); 
		  //System.out.println(format.format(calendar.getTime())); 
		  dates.add(format.format(calendar.getTime()));

		  }
		
		
		  model.addAttribute("dates", dates);
		model.addAttribute("dtheatre", dtheatre);
		return "LocationSelect";
	}

	@RequestMapping(value = "/loginfailure", method = RequestMethod.GET)
	public String LoginFailure() {
		return "LoginFailure";
	}

	@RequestMapping(value = "/SignIn", method = RequestMethod.GET)
	public String Customersignin() {
		return "CustomerSigninPage";
	}

	@RequestMapping(value = "/SignInFailed", method = RequestMethod.GET)
	public String SignInFailed() {
		return "SignInFailed";
	}

	@RequestMapping(value = "/Signincheck", method = RequestMethod.POST)
	public String Signincheck(@RequestParam("userSigninName") String name,
			@RequestParam("userSigninEmail") String email, @RequestParam("userSigninPhoneno") String phoneno,
			@RequestParam("userpassword") String pwd, @RequestParam("confirmuserpassword") String confirmpwd,
			ModelMap m) {

		if (pwd.equals(confirmpwd))

		{
			Customer cus = new Customer(name, email, phoneno, confirmpwd);
			int r = impl.register(cus);
			if (r == 1) {
				return "SigninSucess";
			} else {
				return "SigninAlreadyExist";
			}
		} else {
			return "redirect:/SignInFailed";
		}

	}

	@RequestMapping("addMovie")
	public String AddMovie() {
		return "AddMovie";
	}
	@RequestMapping("removeMovie")
	public String removeMovie()
	{
		return "RemoveMoviePage";
	}
	@RequestMapping("removeMovieFromDB")
	public String RemoveMovieFromDB(@RequestParam("DeletingMovieId") int DeletingMovieId,@RequestParam("DeletingMovieName") String DeletingMovieName , HttpSession s,Model m)
	{
		
		try {
		String path = s.getServletContext().getRealPath("/") + filePath+ DeletingMovieName;
		File f = new File(path);
		f.delete();
		
		mimpl.deleteMovie(DeletingMovieId);
		return "AdminLoginView";
		}
		catch(Exception e)
		{
			System.out.println(e);
			return "AdminLoginView";
		}
	}

	
	@RequestMapping(value = "/addMovietoDB", method = RequestMethod.POST)
	public String addMovietoDB(@RequestParam("movieName") String movieName,
			@RequestParam("actorsName") String actorsName, @RequestParam("directorName") String directorName,
			@RequestParam("PosterName") CommonsMultipartFile PosterName, Model m, HttpSession s) {

		byte[] bytes = PosterName.getBytes();
		String path = s.getServletContext().getRealPath("/") + filePath + PosterName.getOriginalFilename();
		String postername = PosterName.getOriginalFilename();
		System.out.println(path);
		mimpl = new MovieServiceImpl();

		try {
			FileOutputStream fos = new FileOutputStream(path);
			fos.write(bytes);
			fos.close();
//			File oldname = new File(path);
//			File newname = new File(s.getServletContext().getRealPath("/") + filePath + movieName);
//			oldname.renameTo(newname);

			mimpl.addMovietoDB(movieName, actorsName, directorName,postername,bytes);

		} catch (Exception e) {
			System.out.println(e);
		}
		return "AdminLoginView";
	}

	@RequestMapping(value = "/showMovies")
	public ModelAndView showMovies(HttpSession s, ModelAndView model) {
		List<Movie> movielist = mimpl.allMovieList();
		String path = s.getServletContext().getRealPath("/") + filePath;
		model.addObject("movielist", movielist);
		model.addObject("path", path);
		model.setViewName("ShowAllMovies");
		return model;
	}

	@RequestMapping("adminLoginView")
	public String adminLoginView(Model m) {
		int size = mimpl.allMovieList().size();
		 List<Movie> latestmovies=null;
		System.out.println("size is "+size);
		 if(size<10)
		 {
			 int numofmoviestoberetrived = (int) Math.floor(size/2)+1;
			 latestmovies = mimpl.latestmovies(numofmoviestoberetrived);
		 }
		 else {
			 latestmovies = mimpl.latestmovies(5);
		 }
		 m.addAttribute("latestmovies",latestmovies);
		return "AdminLoginView";
	}
	
	@RequestMapping("addTheatre")
	public String addTheatre()
	{
		return "AddTheatre";
	}
	@RequestMapping("addTheatretoDB")
	public String addTheatretoDB(@RequestParam("theatreName") String theatreName,@RequestParam("theatreLocation") String theatreLocation,@RequestParam("noofSeats") int noofSeats,@RequestParam("noofrows") int noofrows)
	{
		timpl.addTheatre(theatreName, theatreLocation, noofSeats,noofrows);
		Theatre theatre = timpl.getTheatre(theatreName);
		System.out.println(theatre+"    "+"printing in the COntroller line no 232");
		seimpl.addseattoDB(theatre);
		return "AdminLoginView";
	}
	
	@RequestMapping("showTheatre")
	public String showTheatre(Model m)
	{
		List<Theatre> allTheatreLoaction = timpl.allTheatreLoaction();
		m.addAttribute("allTheatreLoaction", allTheatreLoaction);
		return "ShowAllTheatres";
	}
	
	
	
	
	@RequestMapping("removeTheatre")
	public String removeTheatre()
	{
		
		return "RemoveTheatrePage";
	}
	
	@RequestMapping("removeTheatreFromDB")
	public String removeTheatreFromDB(@RequestParam("TheatreId") int TheatreId,@RequestParam("TheatreName") String TheatreName) {
		timpl.removeTheatre(TheatreId, TheatreName);
		seimpl.removeSeatsofTheatre(TheatreId);
		return "AdminLoginView";
	}
	

	// @SuppressWarnings("unused")
	@RequestMapping(value = "/logincheck", method = RequestMethod.POST)
	public ModelAndView Logincheck(@RequestParam("userEmail") String umail,
			@RequestParam("userpassword") String upassword, ModelAndView model) {
		Customer cus = impl.UserCheck(umail, upassword);
		Admin adm = aimpl.AdminCheck(umail, upassword);

		// String s = "";

		if (cus == null && adm == null) {
			model.addObject("LoginFailMessage", "Incorrect UserName or Password");
			model.setViewName("LoginFailure");
		} else if (adm != null) {
			model.addObject("Logininfo", adm);
			System.out.println(adm.toString());
			// model.addObject("Admin",adm);
			//model.addObject("Logininfo", adm);
			
			int size = mimpl.allMovieList().size();
			 List<Movie> latestmovies=null;
			System.out.println("size is "+size);
			 if(size<10)
			 {
				 int numofmoviestoberetrived = (int) Math.floor(size/2)+1;
				 latestmovies = mimpl.latestmovies(numofmoviestoberetrived);
			 }
			 else {
				 latestmovies = mimpl.latestmovies(5);
			 }
			 
			model.addObject("latestmovies",latestmovies);
			model.setViewName("AdminLoginView");
		} 
		else 
		{
			
			
			System.out.println(cus.toString());
			model.addObject("Logininfo", cus);

			List<Theatre> ltheatre = timpl.allTheatreLoaction();
			Set<String> dtheatre = new TreeSet<String>();
			for (Theatre t : ltheatre) {
				dtheatre.add(t.getLocation());
			}
			
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
			   LocalDateTime now = LocalDateTime.now();  
			  String format1 = dtf.format(now);
			  System.out.println(format1);
			  List<String> dates  = new ArrayList<String>();
			  dates.add(format1);
			  
			  
			  for(int i=1;i<=6;i++) {
			  SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			   Date date = null;
			try {
				date = format.parse(format1);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			   Calendar calendar = Calendar.getInstance();
			  calendar.setTime(date);
			  calendar.add(Calendar.DAY_OF_YEAR, i); 
			  //System.out.println(format.format(calendar.getTime())); 
			  dates.add(format.format(calendar.getTime()));

			  }
			  
			 
			  
			 
			
			model.addObject("dates", dates);
			
			
			
			model.addObject("dtheatre", dtheatre);
			model.setViewName("LocationSelect");
		}
		return model;
	}
	
	
	
	
	
	
	
	//mappings related to the customers
	@RequestMapping(value = "home",method = RequestMethod.POST)
	public String locationselected(@RequestParam("locationselected") String locationselected,@RequestParam("dateselected") String dateselected,Model m)
	{
		location = locationselected;
		date = dateselected;
		System.out.println(locationselected);
		System.out.println("Date selected is : "+date);
		List<Movie> movielistByLocation = mimpl.movielistByLocation(locationselected);
		
		
		
		
		
		
		
		
		
		
		m.addAttribute("locationselected", locationselected);
		m.addAttribute("movielistByLocation", movielistByLocation);
		return "CustomerHomePage";
	}
	
	
	@RequestMapping(value="/getUserImage/{id}")
	public void getUserImage(HttpServletResponse response , @PathVariable("id") int tweetID) throws IOException, SQLException{

	 response.setContentType("image/jpeg");
	 
	 Blob blob =  (Blob) mimpl.getMoviebyId(tweetID).getPoster();
	 int blobLength = (int) blob.length();  
	 byte[] buffer = blob.getBytes(1, blobLength);
	 
	 // byte[] buffer1 = mip.getTweetByID(tweetID).getUserImage();
	  InputStream in1 = new ByteArrayInputStream(buffer);
	  IOUtils.copy(in1, response.getOutputStream());        
	}
	
	
	@RequestMapping("navigationBarCustomer")
	public String navigationBarCustomer(Model m)
	
	{
		System.out.println(location);
		List<Movie> movielistByLocation = mimpl.movielistByLocation(location);
		m.addAttribute("movielistByLocation", movielistByLocation);
		return "CustomerHomePage";
	}
	
	@RequestMapping("customerProfile")
	public String customerProfile()
	{
		return "CustomerProfilePage";
	}

	
	@RequestMapping("changePassword")
	public String changePassword()
	{
		return "ChangePassword";
	}
	
	@RequestMapping(value="changePasswordInDB",method =RequestMethod.POST)
	public String changePassword(@RequestParam("newPassword") String newPassword,@RequestParam("reenterNewPassword") String reenterNewPassword,@RequestParam("cusId") int cusId,Model m)
	{
		
		
		if(!newPassword.equals(reenterNewPassword))
		{
			m.addAttribute("errormsg","<div class=\"alert alert-danger\" role=\"alert\">Passwords Doesnot Match</div>");
			return "ChangePassword";
			
			
		}
		else {
			System.out.println(cusId+" +++++==+++ "+newPassword);
			impl.changePassword(cusId, reenterNewPassword);
			List<Movie> movielistByLocation = mimpl.movielistByLocation(location);
			m.addAttribute("movielistByLocation", movielistByLocation);
			return "CustomerHomePage";
			
		}
		
		
	}
	
	
	@RequestMapping("editProfile")
	public String editProfile()
	{
		return "EditProfile";
	}
	
	@RequestMapping(value="editProfileToDB",method =RequestMethod.POST)
	public String editProfileToDB(@RequestParam("customerId") int customerId,@RequestParam("newName") String newName,@RequestParam("newPhoneNumber") String newPhoneNumber,Model m)
	{
		impl.editprofile(customerId, newName, newPhoneNumber);
		List<Movie> movielistByLocation = mimpl.movielistByLocation(location);
		m.addAttribute("movielistByLocation", movielistByLocation);
		Customer customer = impl.getCustomer(customerId);
		m.addAttribute("Logininfo",customer);
		return "CustomerHomePage";
	}
	
	
	
	@RequestMapping(value="/theatreSelection/{movieId}",method=RequestMethod.GET)
	public String theatreSelectionbyMovieId(@PathVariable int movieId,Model m)
	{
		System.out.println(movieId);
		List<Theatre> theatresByMovieSelected = timpl.getTheatresByMovieSelected( movieId,location);
		
		for(Theatre t:theatresByMovieSelected)
		{
			System.out.println(t.toString());
		}
		
		List<Shows> allShowsbyTheatre = simpl.allShowsbyTheatre(theatresByMovieSelected,movieId);
		for(Shows s:allShowsbyTheatre)
		{
			System.out.println(s.toString());
		}
		
		

		m.addAttribute("movieId",movieId );
		m.addAttribute("theatresByMovieSelected", theatresByMovieSelected);
		m.addAttribute("allShowsbyTheatre", allShowsbyTheatre);
		
		

		return "showSelectionByCustomer";
	}
	
	
	@RequestMapping(value="{movieId}/seatselection/{sId}",method=RequestMethod.GET)
	public String seatselection(@PathVariable("movieId") int movieId,@PathVariable("sId") int sId,Model m)
	{
		System.out.println(movieId+"     line 451 in controller "+sId);
		
		
		Movie movieIdbyShowId = seimpl.getMovieIdbyShowId(sId);
		System.out.println(movieIdbyShowId +"   line no 455");
		
		
		Theatre theatrebyShowId = seimpl.getTheatrebyShowId(sId);
		System.out.println(theatrebyShowId +"line no 459");
		
		
		List<Seat> seatsByTheatre = seimpl.seatsByTheatre(theatrebyShowId);
		for(Seat s:seatsByTheatre)
		{
			System.out.println(s.toString() +" line no 465");
		}
		
		System.out.println(date +" line no 468 controller");
		
		
		int noofSeatsPerrow = theatrebyShowId.getNoofseats()/theatrebyShowId.getNoofrows();
		
		
		List<Seat> bookedseats = bimpl.bookedseats(date, sId);
		List<Integer> bookedseatids = new ArrayList<Integer>();
		
		for(Seat s:bookedseats)
			bookedseatids.add(s.getId());
		
	
		
		m.addAttribute("bookedseatids", bookedseatids);
		m.addAttribute("movieId",movieId);
		m.addAttribute("sId",sId);
		m.addAttribute("movieIdbyShowId",movieIdbyShowId);
		m.addAttribute("theatrebyShowId",theatrebyShowId);
		m.addAttribute("seatsByTheatre",seatsByTheatre);
		m.addAttribute("noofSeatsPerrow", noofSeatsPerrow);
		
		return "SeatSelectionPage";
	}
	
	@RequestMapping(value="bookseats",method=RequestMethod.POST)
	public String bookseats(@RequestParam("seatsselected") int[] seatsselected,@RequestParam("movieId") int movieId
			,@RequestParam("sId") int sId,Model m)
	{
	
	
		System.out.println("line 485 ");
		for(int s:seatsselected)
		{
			System.out.println(s);
		}
		
		Movie movie= seimpl.getMovieIdbyShowId(sId);//+++++++++++++++++++++++++++++
		Theatre theatre = seimpl.getTheatrebyShowId(sId);//+++++++++++++++++++++++++++++
		Shows show = simpl.showTimeById(sId);//+++++++++++++++++++++++++++++
		List<String> seatName = new ArrayList<String>(); //names of all seats //+++++++++++++++++++++++++++++
		String seatnumbers = "";// Not in use
		
		for(int i:seatsselected)
		{
			seatnumbers = seatnumbers+i+",";
			Seat seatBySeatId = seimpl.getSeatBySeatId(i);
			System.out.println(seatBySeatId);
			seatName.add(seatBySeatId.getSeatrow()+"-"+seatBySeatId.getSeatno());
		}
		for(String s:seatName)
			System.out.println(s);
		
		int totalPrice = seatName.size() * 100;//+++++++++++++++++++++
		
		
		m.addAttribute("movie",movie);
		m.addAttribute("theatre", theatre);
		m.addAttribute("date", date);
		m.addAttribute("show", show);
		m.addAttribute("seatName", seatName);
		m.addAttribute("seatnumbers", seatnumbers);//not in use
		m.addAttribute("totalPrice",totalPrice);
		
		
		return "TicketDisplayPage";
	}
	
	
	
	
	@RequestMapping(value="confirmTicket",method=RequestMethod.POST)
	public String confirmTicket(@RequestParam("movie") int movie,@RequestParam("theatre") int theatre,
			@RequestParam("show") int show,@RequestParam("customerid") int customerid,
			@RequestParam("seatnumbers") String seatnumbers,@RequestParam("totalPrice") int totalPrice,
			@RequestParam("date") String date,Model m)
	{
		
		
		
		
		
		
		
		
		
		//System.out.println("m: "+movie +"  t:"+theatre+"  s: "+show+" cus: "+customerid+" seatnumbers " +seatnumbers);
		int addTicket = tiimpl.addTicket(date,seatnumbers, movie, theatre, show, totalPrice);
		if(addTicket!=0)
			m.addAttribute("ticketbookmsg", "<div class=\"alert alert-success\" role=\"alert\">Ticket Booked Sucessfully</div>");
		else
			m.addAttribute("ticketbookmsg", "<div class=\"alert alert-danger\" role=\"alert\">Unable to Book Tickets</div>");
		
		Ticket lastRow = tiimpl.lastRow();
		int addBooking = bimpl.addBooking(customerid, date, lastRow.getId());
		
		
		return "CustomerHomePage";
	}
	
	
	
	
	
	
	
	
	//Mappings related to shows
	
	@RequestMapping("addShow")
	public String addShow(Model m)
	{ 
		List<Movie> allMovieList = mimpl.allMovieList();
		List<Theatre> allTheatreLoaction = timpl.allTheatreLoaction();
		m.addAttribute("allTheatreLoaction", allTheatreLoaction);
		m.addAttribute("allMovieList", allMovieList);
		return "Addshow";
	}
	
	
	
	
	@RequestMapping("addShowtoDB")
	public String addShowtoDB(@RequestParam("movieStartTime") String movieStartTime,@RequestParam("MovieId") int MovieId,@RequestParam("TheatreId") int TheatreId)
	{
		simpl.addShow(movieStartTime, MovieId, TheatreId);
		return "AdminLoginView";
	}
	
	
	
	
	
	
	@RequestMapping("showAllShows")
	public String showAllShows(Model m)
	{
		List<Shows> allShows = simpl.allShows();
		List<Movie> allmovies = mimpl.allMovieList();
		List<Theatre> alltheatres = timpl.allTheatreLoaction();
		Map<Integer,Movie> movieMap = new HashMap<Integer, Movie>();
		for(Movie movie:allmovies)
		{
			movieMap.put(movie.getId(), movie);
		}
		Map<Integer,Theatre> theatreMap = new HashMap<Integer, Theatre>();
		for(Theatre t:alltheatres)
		{
			theatreMap.put(t.getId(), t);
		}
		m.addAttribute("theatreMap",theatreMap);
		m.addAttribute("movieMap",movieMap);
		m.addAttribute("allShows", allShows);
		return "ShowAllShows";
	}
	
	
	
	
	@RequestMapping("removeShow")
	public String removeShow(Model m)
	{
		List<Shows> allShows = simpl.allShows();
		
		for(Shows s:allShows)
			System.out.println(s);
		List<Theatre> allTheatreLoaction = timpl.allTheatreLoaction();
		Map<Integer,Theatre> theatreMap = new HashMap<Integer, Theatre>();
		
		for(Shows s:allShows)
		{
			int id =s.getTheatreid();
			if(theatreMap.containsKey(id))
			{
				continue;
			}
			else {
				for(Theatre t:allTheatreLoaction)
				{
					if(id==t.getId())
					{
						theatreMap.put(id, t);
						break;
					}
				}
			}
		}
		
		
		m.addAttribute("theatreMap", theatreMap);
		m.addAttribute("allShows", allShows);
		System.out.println("returning to remove show");
		return "RemoveShow";
	}
	
	
	
	@RequestMapping("removeShowFromDB")
	public String removeShowFromDB(@RequestParam("showId") int showId)
	{
		simpl.removeShow(showId);
		return "AdminLoginView";
	}
	
	
	
	@RequestMapping("updateShow")
	public String updateShow(Model m) {
		List<Shows> allShows = simpl.allShows();
		List<Movie> allMovieList = mimpl.allMovieList();
		List<Theatre> allTheatreLoaction = timpl.allTheatreLoaction();
		Map<Integer,Theatre> theatreMap = new HashMap<Integer, Theatre>();
		
		for(Shows s:allShows)
		{
			int id =s.getTheatreid();
			if(theatreMap.containsKey(id))
			{
				continue;
			}
			else {
				for(Theatre t:allTheatreLoaction)
				{
					if(id==t.getId())
					{
						theatreMap.put(id, t);
						break;
					}
				}
			}
		}
		
		
		m.addAttribute("allShows", allShows);
		m.addAttribute("allMovieList", allMovieList);
		m.addAttribute("theatreMap", theatreMap);
		return "UpdateShow";
	}
	
	
	
	@RequestMapping("updateShowtoDB")
	public String updateShowtoDB(@RequestParam("showId") int showId,@RequestParam("MovieId") int MovieId)
	{
		simpl.updateShow(showId, MovieId);
		
		return "AdminLoginView";
	}
	
	
	@RequestMapping("endsession")
	public String nextHandlingMethod2(SessionStatus status){
	  status.setComplete();
	  //System.out.println();
	  return "Loginpage";
	}
	
	
	@RequestMapping(value="/mybookings/{id}",method=RequestMethod.GET)
	public String mybookings(@PathVariable("id") int id,Model model)
	{
		List<Ticket> ticketsByCustomerId = tiimpl.getTicketsByCustomerId(id);
		for(Ticket t:ticketsByCustomerId)
			System.out.println(t.toString());
		
		
		
		
		List<Movie> uniquemovies = new ArrayList<Movie>();
		for(Ticket t:ticketsByCustomerId)
		{
			Movie m =mimpl.getMoviebyId(t.getMovieid());
			if(uniquemovies.size()==0)
			{
				uniquemovies.add(m);
			}
			else
			{
				int r =1;
				for(Movie mo:uniquemovies)
				{
					if(mo.getId()==m.getId())
					{
						r=0;
					}
				}
				if(r==1)
				{
					uniquemovies.add(m);
				}
			}
		}
		
		for(Movie m:uniquemovies)
			System.out.println(m.toString());
		
		Map<Integer,Movie> movieMap = new HashMap<Integer, Movie>();
		for(Movie m:uniquemovies)
			movieMap.put(m.getId(), m);
		
		
		
		
		
		List<Shows> shows = new ArrayList<Shows>();
		for(Ticket t:ticketsByCustomerId)
		{
			Shows showTimeById = simpl.showTimeById(t.getShowid());
			shows.add(showTimeById);
		}
		Map<Integer,Shows> uniqueshows  = new HashMap<Integer, Shows>();
		
		for(Ticket t:ticketsByCustomerId)
		{
			Shows showTimeById = simpl.showTimeById(t.getShowid());
			uniqueshows.put(showTimeById.getId(), showTimeById);
		}
		
		for(Map.Entry<Integer, Shows> m:uniqueshows.entrySet())
		{
			System.out.println(m.getKey()+"  -----  "+m.getValue());
		}
		
		
		
		
		List<Theatre> theatre  =  new ArrayList<Theatre>();
		for(Ticket t:ticketsByCustomerId)
		{
			Theatre theatreById = timpl.getTheatreById(t.getTheatreid());
			theatre.add(theatreById);
		}
		
		Map<Integer,Theatre> TheatreMap = new HashMap<Integer, Theatre>();
		for(Theatre t:theatre)
		{
			TheatreMap.put(t.getId(), t);
		}
		
		for(Map.Entry<Integer, Theatre> m:TheatreMap.entrySet())
		{
			System.out.println(m.getKey()+"  -----  "+m.getValue());
		}
		
		
		List<Seat> seats = new ArrayList<Seat>();
		Map<Integer, String> seatMap =  new HashMap<Integer, String>();
		for(Ticket t:ticketsByCustomerId)
		{
			String[] s = t.getSeatno().split(",");
			String a = "";
			for(String ss:s)
			{
				Seat seatBySeatId = seimpl.getSeatBySeatId(Integer.parseInt(ss));
				a = a+(seatBySeatId.getSeatrow()+seatBySeatId.getSeatno())+" ,";
			}
			String b = a.substring(0, a.length()-1);
			
			seatMap.put(t.getId(), b);
		}
		for(Map.Entry<Integer, String> m:seatMap.entrySet())
		{
			System.out.println(m.getKey()+ "    ^^^^^^^    "+m.getValue());
		}
		
		
		
		model.addAttribute("ticketsByCustomerId",ticketsByCustomerId);
		model.addAttribute("seatMap",seatMap);
		model.addAttribute("movieMap",movieMap);
		model.addAttribute("uniqueshows",uniqueshows);
		model.addAttribute("TheatreMap",TheatreMap);
		
		return "MyBookingsPage";
	}
	

  @RequestMapping(value="makePayment",method=RequestMethod.POST)
  public String makePayment(@RequestParam("movie") int movie,@RequestParam("theatre") int theatre,
			@RequestParam("show") int show,@RequestParam("customerid") int customerid,
			@RequestParam("seatnumbers") String seatnumbers,@RequestParam("totalPrice") int totalPrice,
			@RequestParam("date") String date,Model m)
  {
	  
		m.addAttribute("movie",movie);
		m.addAttribute("theatre", theatre);
		m.addAttribute("date", date);
		m.addAttribute("show", show);
		m.addAttribute("seatnumbers", seatnumbers);//not in use
		m.addAttribute("totalPrice",totalPrice);
		m.addAttribute("customerid",customerid);
	  return "MakePaymentPage";
  }
	

}//controller end
