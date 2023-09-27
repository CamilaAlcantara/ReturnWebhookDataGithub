package swap.ReturnWebookDataGithub.Services.Interface;


import swap.ReturnWebookDataGithub.Models.ContributorReturnGit;
import swap.ReturnWebookDataGithub.Models.GitHubRequest;

import java.util.List;

public interface ContribudorServiceInterface {
    List<ContributorReturnGit> getContributors(GitHubRequest gitHubRequest);
}
