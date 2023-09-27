package swap.ReturnWebookDataGithub.Controllers;

import swap.ReturnWebookDataGithub.Models.GitHubRequest;
import swap.ReturnWebookDataGithub.Models.IssueReturnGit;
import swap.ReturnWebookDataGithub.Services.Interface.IssueServiceInterface;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("issue")
public class IssueController {

    private IssueServiceInterface issueServiceInterface;
    public IssueController(IssueServiceInterface issueServiceInterface){
        this.issueServiceInterface = issueServiceInterface;
    }
    @GetMapping("/")
    public List<IssueReturnGit> buscaIssue(@RequestParam String user,
                                           @RequestParam String repository){
        GitHubRequest gitHubRequest =  new GitHubRequest();
        gitHubRequest.user = user;
        gitHubRequest.repository = repository;

        List<IssueReturnGit> issues = issueServiceInterface.getIssues(gitHubRequest);

        return issues;
    }
}
