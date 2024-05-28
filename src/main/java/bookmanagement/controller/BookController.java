package bookmanagement.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import bookmanagement.model.BookBean;
import bookmanagement.persistant.DAO.BookDAO;
import bookmanagement.persistant.DTO.*;


@Controller
public class BookController {
	@Autowired
	BookDAO bookDAO;
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String displayView(ModelMap model) {
		
			    //get data from persistant
			    ArrayList<BookResponseDTO> dtoList=new ArrayList<BookResponseDTO>();  
			     dtoList=bookDAO.getAllBooks();
			    //mapping convert dto to bean
			     
			    ArrayList<BookBean> list=new ArrayList<BookBean>();
			    for(BookResponseDTO dto: dtoList) {
			    	BookBean bean=new BookBean();
			    	bean.setId(dto.getId());
			    	bean.setName(dto.getName());
			    	bean.setAuthor(dto.getAuthor());
			    	bean.setPrice(dto.getPrice());
			      
			      list.add(bean);
			    }
			    
			    
			    //send data to jsp
			  model.addAttribute("list",list);

		return "displaybook";
	}
	
	@RequestMapping(value="/addbook",method=RequestMethod.GET)
	public ModelAndView addBook() {
		return new ModelAndView("addbook","bean",new BookBean());
	}
	
	@RequestMapping(value="/addbook",method=RequestMethod.POST)
	public String addBook(@ModelAttribute("bean") @Validated BookBean bean,BindingResult bindingResult,ModelMap model){
		if(bindingResult.hasErrors()) {
		return "addbook";
		}
		
		BookRequestDTO bookDTO=new BookRequestDTO();
		
		bookDTO.setName(bean.getName());
		bookDTO.setAuthor(bean.getAuthor());
		bookDTO.setPrice(bean.getPrice());
		
		int rs=bookDAO.insertBook(bookDTO);
		
		if(rs==0) {
			model.addAttribute("error","Insert fail(SQL Error)");
			return "addbook";
		}
		return "redirect:/";
	}
	
	@RequestMapping(value="/updatebook/{id}",method=RequestMethod.GET)
	public ModelAndView updateBook(@PathVariable int id) {
		BookResponseDTO bookDTO=bookDAO.getBookByID(id);
		BookBean bean=new BookBean();
		bean.setId(bookDTO.getId());
		bean.setName(bookDTO.getName());
		bean.setAuthor(bookDTO.getAuthor());
		bean.setPrice(bookDTO.getPrice());
		
		return new ModelAndView("updatebook","bean",bean);
	}
	
	@RequestMapping(value="/updatebook",method=RequestMethod.POST)
	public String updateBook(@ModelAttribute("bean") @Validated BookBean bean,BindingResult bindingResult,ModelMap model){
		if(bindingResult.hasErrors()) {
		return "updatebook";
		}
		System.out.println("Update"+bean.getId()+bean.getName()+bean.getAuthor()+bean.getPrice());
		
		BookRequestDTO bookDTO=new BookRequestDTO();
		
		bookDTO.setId(bean.getId());
		bookDTO.setName(bean.getName());
		bookDTO.setAuthor(bean.getAuthor());
		bookDTO.setPrice(bean.getPrice());
		
		int rs=bookDAO.updateBook(bookDTO);
		
		if(rs==0) {
			model.addAttribute("error","Update fail(SQL Error)");
			return "updatebook";
		}
		return "redirect:/";
	}
	

	@RequestMapping(value="/deletebook/{id}",method=RequestMethod.GET)
	public String deleteBook(@PathVariable int id,ModelMap model) {
		int rs=bookDAO.deleteBook(id);
		if(rs==0) {
			model.addAttribute("error","Delete Fail");
			return "displaybook";
		}
		return "redirect:/";
	}
	
	
}
