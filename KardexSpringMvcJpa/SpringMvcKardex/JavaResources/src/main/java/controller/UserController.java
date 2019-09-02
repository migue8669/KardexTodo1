package controller;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import service.UserService;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value ="/list",method = RequestMethod.GET)
    public ModelAndView list(){
        ModelAndView model=new ModelAndView("user/list");
        model.addObject("listUser",userService.listUser());
        return model;
    }
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public ModelAndView add(){ModelAndView model=new ModelAndView("user/form");
    model.addObject("userForm",new User());
    return model;
    }

    @RequestMapping(value = "/update/{id}",method = RequestMethod.PUT)
    public ModelAndView update(String id){
        ModelAndView model = new ModelAndView("user/form");
        model.addObject("userForm",userService.findUserById(id));
        return model;
    }

    @RequestMapping(value = "/update/{id}",method = RequestMethod.POST)
    public String save(User user){
        if(user.getId()!=null && user.getId().trim().equals("")){
            userService.update(user);
        }else {userService.add(user);}
        return "redirect:user/list";

    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    public String delete(String id){
        User user = userService.findUserById(id);
        userService.delete(user);
        return "redirect:user/list";
    }
}
