package controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import entity.Author;
import entity.Book;
import service.AuthorService;
import service.BookService;

@Controller
public class bookController {

	@Autowired
	private AuthorService authorService;

	@Autowired
	private BookService bookService;

	@GetMapping("/book/form/add")
	public ModelAndView getFormAdd() {

		ModelAndView mv = new ModelAndView("bookform");
		List<Author> authorList = this.authorService.getAuthorList();
		mv.addObject("authorList", authorList);
		return mv;
	}

	@PostMapping("/book/form/save")
	public String saveBook(@Valid Book book, BindingResult result, RedirectAttributes redirect) {

		if (result.hasErrors()) {
			redirect.addFlashAttribute("mensagem", "Verifique os campos obrigatórios");
			return "redirect:/book/form/add";
		}

		this.bookService.save(book);

		return "redirect:/";
	}

	@GetMapping("/edit/{id}")
	public ModelAndView getEdit(@PathVariable("id") Long id) {

		ModelAndView mv = new ModelAndView("bookform");
		List<Author> authorList = this.authorService.getAuthorList();
		mv.addObject("authorList", authorList);

		Book book = this.bookService.findById(id);

		mv.addObject("book", book);

		return mv;

	}

}
