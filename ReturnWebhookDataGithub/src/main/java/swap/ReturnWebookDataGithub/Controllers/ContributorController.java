package swap.ReturnWebookDataGithub.Controllers;

import swap.ReturnWebookDataGithub.Models.ContributorReturnGit;
import swap.ReturnWebookDataGithub.Models.GitHubRequest;
import swap.ReturnWebookDataGithub.Services.Interface.ContribudorServiceInterface;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("contributor")
public class ContributorController {

    private ContribudorServiceInterface contribudorServiceInterface;
    public ContributorController(ContribudorServiceInterface contribudorServiceInterface){
        this.contribudorServiceInterface = contribudorServiceInterface;
    }
    @GetMapping("/")
    public List<ContributorReturnGit> buscaContributor(@RequestParam String user,
                                                       @RequestParam String repository){
        GitHubRequest gitHubRequest =  new GitHubRequest();
        gitHubRequest.user = user;
        gitHubRequest.repository = repository;

        List<ContributorReturnGit> Contributor = contribudorServiceInterface.getContributors(gitHubRequest);

        return Contributor;
    }
}
