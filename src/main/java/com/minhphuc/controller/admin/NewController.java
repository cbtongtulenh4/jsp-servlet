package com.minhphuc.controller.admin;

import com.minhphuc.model.NewModel;
import com.minhphuc.paging.PageRequest;
import com.minhphuc.paging.Pageble;
import com.minhphuc.service.iNewService;
import com.minhphuc.sort.Sorter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "NewControllerOfAdmin")
public class NewController {

    @Autowired
    private iNewService newService;

    @RequestMapping(value = "admin-new-list", method = RequestMethod.GET)
    public ModelAndView controllerList(@ModelAttribute("model")NewModel model){
        ModelAndView mav = new ModelAndView("admin/new/list");
        Pageble pageble = new PageRequest(model.getPage(), model.getMaxPageItem(),new Sorter("title", "DESC"));
        model.setListResult(newService.findAll(pageble));
        mav.addObject("model", model);
        return mav;
    }

    @RequestMapping(value = "admin-new-edit", method = RequestMethod.GET)
    public ModelAndView controllerEdit(){
        return new ModelAndView("admin/new/edit");
    }
}
