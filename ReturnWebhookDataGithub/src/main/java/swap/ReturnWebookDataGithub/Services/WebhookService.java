package swap.ReturnWebookDataGithub.Services;


import swap.ReturnWebookDataGithub.Services.Interface.ContribudorServiceInterface;
import swap.ReturnWebookDataGithub.Services.Interface.IssueServiceInterface;
import swap.ReturnWebookDataGithub.Services.Interface.UserServiceInterface;
import org.springframework.stereotype.Service;
import swap.ReturnWebookDataGithub.Models.*;
import swap.ReturnWebookDataGithub.Services.Interface.WebhookServiceInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
public class WebhookService implements WebhookServiceInterface {


    private IssueServiceInterface issueServiceInterface;
    private UserServiceInterface userServiceInterface;
   private ContribudorServiceInterface contribudorServiceInterface;

    public WebhookService(IssueServiceInterface issueServiceInterface,
                          UserServiceInterface userServiceInterface,
                          ContribudorServiceInterface contribudorServiceInterface){
        this.issueServiceInterface = issueServiceInterface;
        this.userServiceInterface = userServiceInterface;
        this.contribudorServiceInterface = contribudorServiceInterface;

    }

    @Override
    public CompletableFuture<DataReturnWebhook> webhookDataAsync(GitHubRequest gitHubRequest) {

        return CompletableFuture.supplyAsync(() -> {
            String username = userServiceInterface.getUser(gitHubRequest.user).name;
            String repository = gitHubRequest.repository;
            List<IssueReturnGit> listIssueReturn = issueServiceInterface.getIssues(gitHubRequest);
            List<ContributorReturnGit> listContributorReturn = contribudorServiceInterface.getContributors(gitHubRequest);


            List<Issue> issueList = new ArrayList<>();

            for(IssueReturnGit issue : listIssueReturn){
               Issue issues = new Issue();
               issues.title = issue.title;
               issues.user = issue.user.login;
               issues.labels = new ArrayList<>();

               for(LabelReturnGit labelReturnGit: issue.labels){
                   issues.labels.add(labelReturnGit.name);

               }
               issueList.add(issues);
            }



            List<Contributor> contributorList = new ArrayList<>();

            for(ContributorReturnGit contributorReturnGit: listContributorReturn){
                Contributor contributors = new Contributor();
                contributors.name = getNameContributor(contributorReturnGit.login);
                contributors.author = contributorReturnGit.login;
                contributors.commitsCount = contributorReturnGit.contributions;

                contributorList.add(contributors);
            }

            return new DataReturnWebhook(username,repository,issueList, contributorList);
        });
    }

    private String getNameContributor(String login){
        String nameContributor = new String();
        UserReturnGit userReturnGit = userServiceInterface.getUser(login);
        nameContributor = userReturnGit.name;

        return nameContributor;
    }
    @Override
    public DataReturnWebhook JsonWebhook(GitHubRequest gitHubRequest) {
        CompletableFuture<DataReturnWebhook> dataGitHub = webhookDataAsync(gitHubRequest);
        DataReturnWebhook dataReturnWebhook = null;
        try {
            dataReturnWebhook =  dataGitHub.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }


        return dataReturnWebhook;
    }
}
