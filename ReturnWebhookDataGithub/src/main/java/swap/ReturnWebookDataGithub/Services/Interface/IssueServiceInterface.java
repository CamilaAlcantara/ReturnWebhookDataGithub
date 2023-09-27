package swap.ReturnWebookDataGithub.Services.Interface;

import swap.ReturnWebookDataGithub.Models.GitHubRequest;
import swap.ReturnWebookDataGithub.Models.IssueReturnGit;

import java.util.List;

public interface IssueServiceInterface {
    List<IssueReturnGit> getIssues(GitHubRequest gitHubRequest);
}
