package com.khoa.lookify.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.khoa.lookify.models.Lookify;
import com.khoa.lookify.services.LookifyService;

@RestController
public class LookifyApi {
	private final LookifyService lookifyService;
	
    public LookifyApi(LookifyService lookifyService){
        this.lookifyService = lookifyService;
    }
    @RequestMapping("/api/songs")
    public List<Lookify> index() {
        return lookifyService.allLookifys();
    }
    
    @RequestMapping(value="/api/songs", method=RequestMethod.POST)
    public Lookify create(@RequestParam(value="title") String title, @RequestParam(value="artist") String artist, @RequestParam(value="rating") int rating) {
    Lookify lookify = new Lookify(title, artist, rating);
        return lookifyService.createLookify(lookify);
    }
    
    @RequestMapping("/api/songs/{id}")
    public Lookify show(@PathVariable("id") Long id) {
    	Lookify lookify = lookifyService.findLookify(id);
        return lookify;
    }
    
    @RequestMapping(value="/api/songs/{id}", method=RequestMethod.PUT)
    public Lookify update(@PathVariable("id") Long id, @RequestParam(value="title", required=false) String title, 	@RequestParam(value="artist", required=false) String artist, @RequestParam(value="rating", required=false) 	int rating) {
    	Lookify lookify = lookifyService.findLookify(id);
        lookify.setTitle(title);
        lookify.setArtist(artist);
        lookify.setRating(rating);
        return lookifyService.updateLookify(lookify);
    }
    
    @RequestMapping(value="/api/songs/{id}", method=RequestMethod.DELETE)
    public void destroy(@PathVariable("id") Long id) {
        lookifyService.deleteLookify(id);
    }
    
    
    
}
