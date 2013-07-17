package com.project.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import com.project.rest.model.Document;
import com.project.rest.service.DocumentService;
   
@Controller    
public class DocumentController {  
   
	@Autowired
	private DocumentService documentService;
	
    @RequestMapping(value = "/document", method = RequestMethod.GET)  
	public String getDocumentList(ModelMap model) {  
        model.addAttribute("documentList", documentService.listDocument());  
        return "output";  
    }  
    
    @RequestMapping(value = "/document/save", method = RequestMethod.POST)  
	public View createDocument(@ModelAttribute Document document, ModelMap model) {
    	if(StringUtils.hasText(document.getId())) {
    		documentService.updateDocument(document);
    	} else {
    		documentService.addDocument(document);
    	}
    	return new RedirectView("/HelloSpringWithMongoDB/document");  
    }
        
    @RequestMapping(value = "/document/delete", method = RequestMethod.GET)  
	public View deleteDocument(@ModelAttribute Document document, ModelMap model) {  
        documentService.deleteDocument(document);  
        return new RedirectView("/HelloSpringWithMongoDB/document");  
    }    
}
