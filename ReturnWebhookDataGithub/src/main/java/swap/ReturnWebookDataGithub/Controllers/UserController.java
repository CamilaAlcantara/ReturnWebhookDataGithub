package swap.ReturnWebookDataGithub.Controllers;


import swap.ReturnWebookDataGithub.Models.UserReturnGit;
import swap.ReturnWebookDataGithub.Services.Interface.UserServiceInterface;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("user")
public class UserController {

    private UserServiceInterface userServiceInterface;
    public UserController(UserServiceInterface userServiceInterface){
        this.userServiceInterface = userServiceInterface;
    }

    @GetMapping("/")
    public UserReturnGit buscaUser(@RequestParam String user){
        return userServiceInterface.getUser(user);

    }
}
