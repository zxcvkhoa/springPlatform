package com.khoa.lookify.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.khoa.lookify.models.Lookify;
import com.khoa.lookify.services.LookifyService;

@Controller
public class LookifyController {
	private final LookifyService lookifyService;
	
	public LookifyController(LookifyService lookifyService) {
		this.lookifyService = lookifyService;
	}
	
	@RequestMapping("/")
	public String root(Model model) {
		List<Lookify> lookify = lookifyService.allLookifys();
		model.addAttribute("lookify", lookify);
		return "/lookifys/index.jsp";
	}
	
	@RequestMapping("/songs")
	public String index(Model model) {
		List<Lookify> lookify = lookifyService.allLookifys();
		model.addAttribute("lookifys", lookify);
		return "/lookifys/index.jsp";
	}
	
	@RequestMapping("/dashboard")
	public String dashboard(Model model) {
		List<Lookify> lookify = lookifyService.allLookifys();
		model.addAttribute("lookify", lookify);
		return "/lookifys/dashboard.jsp";
	}
		
	@RequestMapping("/songs/new")
	public String newLookify(@ModelAttribute("lookify") Lookify lookify) {
		return "/lookifys/new.jsp";
  }
	
	@RequestMapping(value="/songs", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("lookifys") Lookify lookify, BindingResult result) {
        if (result.hasErrors()) {
            return "/lookifys/new.jsp";
        } else {
            lookifyService.createLookify(lookify);
            return "redirect:/dashboard";
        }
    }
	
	@RequestMapping("/songs/{id}")
	public String show(@PathVariable("id") long id, Model model) {
		Lookify lookify = lookifyService.findLookify(id);
		model.addAttribute("lookify", lookify);
		return "/lookifys/show.jsp";
	}
	
	 @RequestMapping("/songs/edit/{id}")
	    public String edit(@PathVariable("id") Long id, Model model) {
		 Lookify lookify = lookifyService.findLookify(id);
	        model.addAttribute("lookify", lookify);
	        return "/lookifys/edit.jsp";
	}
	 
	 @RequestMapping(value="/songs/{id}", method=RequestMethod.PUT)
	    public String update(@Valid @ModelAttribute("lookifys") Lookify lookify, BindingResult result) {
	        if (result.hasErrors()) {
	            return "/lookifys/edit.jsp";
	        } else {
	            lookifyService.updateLookify(lookify);
	            return "redirect:/songs";
	        }
	    }
	 
	 @RequestMapping(value="/songs/delete/{id}", method=RequestMethod.GET)
	    public String destroy(@PathVariable("id") Long id) {
	        lookifyService.deleteLookify(id);
	        return "redirect:/dashboard";
	    }
	
	 @PostMapping("/songs/search")
		public String searchSongs(@RequestParam(value="artistSearch") String artistSearch) {
			if(artistSearch.equals("")) {
				return "redirect:/dashboard";
			}
			return "redirect:/songs/search/" + artistSearch;
		}
	 
	 @RequestMapping("/songs/search/{artistSearch}")
		public String searchResults(@PathVariable("artistSearch") String artistSearch, Model model) {
			List<Lookify> songs = lookifyService.allLookifys();
			List<Lookify> found = new ArrayList<Lookify>();
			for (int i=0; i<songs.size(); i++) {
				if (songs.get(i).getArtist().contains(artistSearch)){
					found.add(songs.get(i));
				}
			}

			model.addAttribute("found", found);
			return "/lookifys/searchresult.jsp";
		}
	 
	 @RequestMapping("/search/top")
	 	public String topTen(Model model) {
		 model.addAttribute("sortedSongs", lookifyService.sortSongs());
		 return "/lookifys/topten.jsp";
	 }
	
}